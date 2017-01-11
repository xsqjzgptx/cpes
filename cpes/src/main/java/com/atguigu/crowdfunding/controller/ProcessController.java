package com.atguigu.crowdfunding.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.bean.Role;

@RequestMapping("system/process")
@Controller
public class ProcessController {
	@Autowired
	private RepositoryService reService;

	@RequestMapping("/index")
	public String index() {
		return "process/index";
	}
    //需要注意的东西
	@ResponseBody
	@RequestMapping("/datas")
	public Object toIndex(Integer draw, Integer start,
			@RequestParam(value = "length") Integer pagesize) {
		ProcessDefinitionQuery query = reService.createProcessDefinitionQuery();
		//查询出所有的流程  以及总数
		List<ProcessDefinition> pDs = reService.createProcessDefinitionQuery().listPage(start, pagesize);
		long tocalCounts = query.count();
		//因为这里转化JSON会出现类似递归的异常  所以要把List<ProcessDefinition> 转换为 List<Map>
		List<Map<String, Object>> pDs2 = new ArrayList<Map<String,Object>>();
		int index = 0;
		for (ProcessDefinition pD : pDs) {
			Map<String, Object> pDMap = new HashMap<String, Object>();
			pDMap.put("id", pD.getId());
			pDMap.put("index", index++);
			pDMap.put("name", pD.getName());
			pDMap.put("key", pD.getKey());
			pDMap.put("version", pD.getVersion());
			pDMap.put("deploymentid", pD.getDeploymentId());//用于删除
			pDs2.add(pDMap);
		}

		Page<Map<String, Object>> page = new Page<Map<String, Object>>();
		page.setData(pDs2);
		page.setRecordsTotal((int)tocalCounts);
		page.setDraw(draw);
		page.setRecordsFiltered((int)tocalCounts);
		
		page.setDraw(draw); // 传过来 再传回去
		return page;
	}

	@ResponseBody
	@RequestMapping("/deletes")
	public Object delete(Datas datas) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//传过来遍历删除 缺点多次连接数据库 但是没办法 然而可以优化: 查询可以省去
//		for (String pid : datas.getPids()) {
//			String deploymentId = reService.createProcessDefinitionQuery().singleResult().getDeploymentId();
//			reService.deleteDeployment(deploymentId, true);;
//		}
		// 直接传过来did
		try {
			for (String did : datas.getPids()) {
				reService.deleteDeployment(did, true);
			}
			resultMap.put("success", true);
		} catch (Exception e) {
			System.out.println(e.getCause());
			resultMap.put("error", "删除流程定义信息失败");
		}
		// 需要重新发送请求到tree
		return resultMap;
	}
//@RequestParam("pdfile") MultipartFile multipartFile,
	
	@RequestMapping("/showimg")
	public String showing(String pdid,Model model){
		model.addAttribute("pdid", pdid);
		return "process/showimg";
	}
	
	@ResponseBody
	@RequestMapping("/uploadProcDef")
	public Object upload(
			HttpServletRequest request) {
		MultipartHttpServletRequest  multiReq = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multiReq.getFile("pdfile");
		// 因为要返回JSON数据 所以使用一个MAP保存success error信息
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//除了前台 , 后台要再次对文件大小和类型(不做了, dpmn的类型获取不到)进行判断
		long size = multipartFile.getSize();
		if (size>10*1024*1024) {
			resultMap.put("error", "流程图片大小不能超过10M,请重新上传!");
			return resultMap;
		}
		//如果文件大小和类型没有问题 则进行上传
		String originalFilename = multipartFile.getOriginalFilename();
		if (!originalFilename.endsWith(".bpmn")) {
			resultMap.put("error", "上传文件类型有误,请上传流程文件");
			return resultMap;
		}
		
		InputStream inputStream= null;
		
		try {
			inputStream = multipartFile.getInputStream();
			reService.createDeployment().addInputStream(originalFilename, inputStream).deploy();
			resultMap.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("error", "流程图片上传失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/loadProcDefImg")
	public void showimg(@RequestParam("pdid")String pid,HttpServletResponse resp){
		    resp.setCharacterEncoding("utf-8");
			ProcessDefinition pD = reService.createProcessDefinitionQuery().processDefinitionId(pid).singleResult();
			InputStream is = reService.getResourceAsStream(pD.getDeploymentId(),pD.getDiagramResourceName());
			
			int len =  0 ;
			byte [] b = new byte[1024];
			try {
				OutputStream os = resp.getOutputStream();
				while((len = is.read(b)) !=-1 ){
					os.write(b, 0, len);
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	
}
