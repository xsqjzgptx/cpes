package com.atguigu.crowdfunding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowdfunding.cpes.bean.CertAcc;
import com.atguigu.crowdfunding.cpes.bean.CertImg;
import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.service.i.CertImgService;

@Controller
@RequestMapping("system/cert")
public class CertImgController {
	@Autowired
	private CertImgService certImgService;

	@RequestMapping("/type")
	// cis
	public String certType(Map<String, Object> map) {
		List<CertImg> certImgs = certImgService.getAllCertImgs();
		//查出
		List<CertAcc> assinedCert = certImgService.getAsignedCerts();

		map.put("cis", certImgs);
		map.put("acis", assinedCert);
		return "cert/type";

	}

	/**
	 * ciid:5 acctype:0 flg:1
	 * 这三个数据 可以封装为一个AcctCert类来接收  也可以先各自接收然后再封装到一个Map中传入dao
	 */
	@ResponseBody
	@RequestMapping("/operation")
	public Object oprtate(
			@RequestParam("ciid")Integer ciid, 
			@RequestParam("acctype")String acctype, 
			@RequestParam("flag")String flag) {
		Map<String,Object> pMap = new HashMap<String, Object>();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		pMap.put("ciid", ciid);
		pMap.put("acctype", acctype);
		if ("1".equals(flag)) {
			// 1代表该checkbox被选中了 是要增加
			try {
				certImgService.insertCertImg(pMap);
				resultMap.put("success", true);
				resultMap.put("msg", "资质添加成功");
			} catch (Exception e) {
				resultMap.put("error", "资质添加失败");
				e.printStackTrace();
			}
			
		}else if("0".equals(flag)){
			// 0代表该checkbox被没有取消选中了 是要删除
			try {
				certImgService.deleteCertImg(pMap);
				resultMap.put("success", true);
				resultMap.put("msg", "资质删除成功");
			} catch (Exception e) {
				resultMap.put("error", "资质删除失败");
				e.printStackTrace();
			}
		}
		return resultMap;
	}

	@RequestMapping("/index")
	public String index() {
		return "cert/index";
	}

	@ResponseBody
	@RequestMapping("/datas")
	public Object toIndex(Integer draw, Integer start,
			@RequestParam(value = "length") Integer pagesize) {
		Map<String, Object> paraMetersMap = new HashMap<String, Object>();
		// start就是索引 index
		paraMetersMap.put("start", start);
		paraMetersMap.put("pageSize", pagesize);
		Page<CertImg> certImgs = certImgService.getPagedCertImgs(paraMetersMap);
		certImgs.setDraw(draw); // 传过来 再传回去
		return certImgs;
	}

	@RequestMapping("/add")
	public String addCert() {
		return "cert/add";
	}

	@ResponseBody
	@RequestMapping("/insert")
	public Object insertCert(CertImg certImg) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			certImgService.insert(certImg);
			map.put("success", true);
		} catch (Exception e) {
			map.put("error", "新增资质信息失败");
		}
		return map;
	}

	@RequestMapping("/edit/{certId}")
	public String editCert(@PathVariable("certId") Integer certId,
			Map<String, Object> map) {
		CertImg certImg = certImgService.getCertImgById(certId);
		map.put("ci", certImg);
		return "cert/edit";
	}

	@ResponseBody
	@RequestMapping("/update")
	public Object updateCert(CertImg certImg) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			certImgService.update(certImg);
			map.put("success", true);
		} catch (Exception e) {
			map.put("error", "修改资质信息失败");
		}
		return map;
	}

	@ResponseBody
	@RequestMapping("/deletes")
	public Object deleteCert(Datas datas) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			certImgService.delete(datas);
			map.put("success", true);
		} catch (Exception e) {
			map.put("error", "删除资质信息失败");
		}
		return map;
	}

}
