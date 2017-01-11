package com.atguigu.crowdfunding.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.service.i.PermissionService;

@RequestMapping("/system/permission")
@Controller
public class PermissionController {
	@Autowired
	private PermissionService pService;

	@RequestMapping("/index")
	public String toPermission() {
		return "permission/index";
	}
    @ResponseBody
	@RequestMapping("/delete")
	public Object delete(Integer id){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			 pService.deletePermission(id);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "删除用户信息失败");
		}
		//需要重新发送请求到tree 
		return resultMap;
	}
	
	
	
	//有与这个
	@ResponseBody
	@RequestMapping("/update")
	public Object Update(Permission permission){
		System.out.println(permission);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			 pService.updatePermission(permission);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "更新用户信息失败");
		}
		//需要重新发送请求到tree 
		return resultMap;
	}
	
	
	@RequestMapping("/edit")
	public Object toUpdate(Integer id,Map<String, Object>map){
//		map.put("id", id); //这一步其实是不需要的  因为p中有id 页面中通过p取即可
		Permission permission =  pService.getPermissionById(id);
		map.put("p", permission);
		return "permission/edit";
	}
	
	//要传递 pid 
	@RequestMapping("/add")
	public String toAdd(Integer pid ,Map<String, Integer> map) {
		map.put("pid", pid);
		return "permission/add";
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public Object add(Permission permission){
		// 因为要返回JSON数据 所以使用一个MAP保存success error信息
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			pService.addPermission(permission);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "保存用户信息失败");
		}
		//需要重新发送请求到tree 
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/tree")
	public Object getTree() {
		// list : [ { } ]
		List<Permission> treeData = new ArrayList<Permission>();
		long startTimeMillis = System.currentTimeMillis();
		// 1 使用递归循环连接数据库 效率很低
		// Permission root= new Permission();
		// root.setId(0);
		// bindTreeData(root);
		// //注意了 这个pid是0的父节点是一个抽象的 不存在的 它是表中实际根据点CPES菜单的虚拟父节点
		// // 这个虚拟的根节点是用来查询表中的实际跟节点的
		// // 所以实际上下面的root.getChildren()中包括了表中实际根据点CPES菜单
		// treeData.addAll(root.getChildren());

		// 为了提高效率 要做到只查询一次数据库就得到所有数据 然后在程序中组合关系
		List<Permission> permissions = pService.queryAll();
		// // 2 把一次性取出来的数据在内存中进行组合父子关系 : 性能比1 好了很多
		// // 以是一个笛卡尔的过程 也就不必要的运算 幸好是在内存中 速度快点 没有递归 层次多的问题还是没有解决吗
		//
		// for (Permission permission : permissions) {
		// //每次取出
		// Permission childPermission = permission ;
		// int pId = childPermission.getPid();
		// if (pId==0) {
		// treeData.add(permission);
		// }else {
		// for (Permission permission2 : permissions) {
		// if (permission2.getId() == pId) { // 如果时表中跟节点 把它加到treeData中
		// Permission parentPermission = permission2 ;
		// parentPermission.getChildren().add(childPermission);
		// }
		// }
		// }
		// }
		// 3 把一次性查出的数据 放到Map中 再用Map取以组合父子关系 : 而不是..
		// 因为这里是线性查询 而不是索引查询 List(AyyayList)是索引查询快 而map是线性查询快
		// 有个很重要的现象 : 使用map遍历组合时只用了一个for循环 而List是两个 为什么为什么为什么

		Map<Integer, Permission> pMap = new HashMap<Integer, Permission>();
		for (Permission permission : permissions) {
			pMap.put(permission.getId(), permission);
			// 把数据从List转入map的同时 取到根节点时 顺便把它放入treeData中
			int pid = permission.getPid() ;
			if ( pid== 0) {
				treeData.add(permission);
			}
		}
		// 使用Map遍历取出以组合关系
		for (Permission permission : permissions) {
			Permission childPermission = permission;
			int pid = childPermission.getPid();
			// 因为父的id是子的pid , 反过来 子的pid是子的id, 那么传入子类的Pid就是传入了父的id
			// 也就可以获取到父Permission
			if (pid != 0) {
				Permission parentPermission = pMap.get(pid);
				parentPermission.getChildren().add(childPermission);
			}
		}
		long endTimeMillis = System.currentTimeMillis();
		System.out.println("所用时间:－－－" + (endTimeMillis - startTimeMillis));
		return treeData;
	}

	// 把父的节点传进去
	public void bindTreeData(Permission parentPermission) {
		List<Permission> ps = pService.queryPermissions(parentPermission
				.getId());
		for (Permission permission : ps) {
			bindTreeData(permission);
			parentPermission.getChildren().add(permission);
		}
	}

}
