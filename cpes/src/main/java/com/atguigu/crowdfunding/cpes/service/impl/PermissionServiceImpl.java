package com.atguigu.crowdfunding.cpes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.dao.PermissionMapper;
import com.atguigu.crowdfunding.cpes.dao.RoleMapper;
import com.atguigu.crowdfunding.cpes.service.i.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{
      @Autowired
	  private PermissionMapper permissionMapper ;

	@Override
	public List<Permission> queryPermissions(int id) {
		List<Permission> permissions  = permissionMapper.getPermissions( id);
		return permissions;
	}

	@Override
	public List<Permission> queryAll() {
		List<Permission> permissions = permissionMapper.getAll();
		return permissions;
	}

	@Override
	public void addPermission(Permission permission) {
		permissionMapper.addPermission(permission);
		
	}

	@Override
	public Permission getPermissionById(Integer id) {
		Permission permission = 	permissionMapper.getPermissionById(id);
		return permission;
	}

	@Override
	public void updatePermission(Permission permission) {
		permissionMapper.updatePermission(permission);
		
	}

	@Override
	public void deletePermission(Integer id) {
		permissionMapper.deletePermission(id);
		//先让它删除 睡五秒 --查看数据库确认     抛出异常
	}

//	@Override
//	public List<Permission> getAsignedPermissions(Integer id) {
//		List<Permission> permissions = 	permissionMapper.getAsignedPermissions(id);
//		return permissions;
//	}

	@Override
	public List<Integer> getAsignedPermissionIdList(Integer id) {
		List<Integer> idList = permissionMapper.getAsignedPermissionIdList(id);
		return idList;
	}

}
