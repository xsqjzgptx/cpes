package com.atguigu.crowdfunding.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Model;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.service.i.PermissionService;
import com.atguigu.crowdfunding.cpes.service.i.RoleService;

@RequestMapping("/system/role")
@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService pService;

	@ResponseBody
	@RequestMapping("/assign")
	private Object design(Datas datas, Integer roleid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			roleService.design(datas, roleid);
			map.put("success", true);
		} catch (Exception e) {
			map.put("error", "角色权限分配失败");
		}
		return map;
	}

	// 深度加载rOle可以放在这里
	@ResponseBody
	@RequestMapping("/permissiontree")
	public Object getPermissionTree(@RequestParam("roleid") Integer id) {
		// 因为这里向页面返回的就是Permission的集合
		// 所以获取所有已分配的权限集合(这里其实只需要什么字段) 然后和 所有的权限集合进行---比对---把被分配的权限属性设置为true即可
//		List<Permission> asignedPermissions = pService.getAsignedPermissions(id);
		List<Integer> asignedPermissionIdList = pService.getAsignedPermissionIdList(id);
		List<Permission> treeData = new ArrayList<Permission>();
		long startTimeMillis = System.currentTimeMillis();
		List<Permission> permissions = pService.queryAll();

		Map<Integer, Permission> pMap = new HashMap<Integer, Permission>();
		for (Permission permission : permissions) {
			pMap.put(permission.getId(), permission);
			// 把数据从List转入map的同时 取到根节点时 顺便把它放入treeData中
			int pid = permission.getPid();
			if (pid == 0) {
				treeData.add(permission);
			}
		}
		// 放在这里做比对: Map好取
//		for (Permission permission : permissions) {
//			Permission currentPermission = permission;
//			for (Permission asignedPermission : asignedPermissions) {
//				if (currentPermission.getId().equals(asignedPermission.getId())) {
//					currentPermission.setChecked(true);
//				}
//			}
//		}
		for (Integer asignedPermissionId : asignedPermissionIdList) {
			Permission assignedPermission = pMap.get(asignedPermissionId);
			assignedPermission.setChecked(true);
		}

		for (Permission permission : permissions) {
			Permission childPermission = permission;
			int pid = childPermission.getPid();
			if (pid != 0) {
				Permission parentPermission = pMap.get(pid);
				parentPermission.getChildren().add(childPermission);
			}
		}
		long endTimeMillis = System.currentTimeMillis();
		System.out.println("所用时间:－－－" + (endTimeMillis - startTimeMillis));
		return treeData;
	}

	// 需要深度加载Role , 因为需要把当前role的所有权限回显
	@RequestMapping("/permission/{roleid}")
	public String permission(@PathVariable("roleid") Integer id,
			Map<String, Object> map) {
		// 根据Id深度加载Role
		Role role = roleService.getRoleById(id);
		map.put("role", role);
		return "role/permission";
	}

	@RequestMapping("/index")
	public String index() {
		return "role/index";
	}
	@ResponseBody
	@RequestMapping("/datas")
	public Object toIndex(Integer draw, Integer start,
			@RequestParam(value = "length") Integer pagesize) {
		Map<String, Object> paraMetersMap = new HashMap<String, Object>();
		// paraMetersMap.put("draw", draw) ;
		paraMetersMap.put("start", start);
		paraMetersMap.put("pageSize", pagesize);
		Page<Role> roles = roleService.getAllRoles(paraMetersMap);
		roles.setDraw(draw); // 传过来 再传回去
		return roles;
	}

	// 这个不是ajax请求 跳转到新的页面
	@RequestMapping("/add")
	public String add() {
		return "role/add";
	}

	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(String name) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			roleService.insert(name);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "新增角色信息失败");
		}
		return resultMap;
	}

	@RequestMapping("/edit/{id}")
	public String toUpdate(@PathVariable("id") Integer id,
			Map<String, Object> map) {
		Role role = roleService.getRoleById(id);
		map.put("role", role);
		return "role/edit";
	}

	@ResponseBody
	@RequestMapping("/update")
	public Object update(Role role) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			roleService.update(role);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "修改角色信息失败");
		}
		return resultMap;
	}

	// @RequestParam("id") List<Integer> id
	@ResponseBody
	@RequestMapping("/deletes")
	public Object delete(Datas datas) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			roleService.delete(datas);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "删除角色信息失败");
		}
		return resultMap;
	}

}
