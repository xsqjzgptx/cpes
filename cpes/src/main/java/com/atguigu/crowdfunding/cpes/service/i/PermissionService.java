package com.atguigu.crowdfunding.cpes.service.i;

import java.util.List;

import com.atguigu.crowdfunding.cpes.bean.Permission;

public interface PermissionService {

	List<Permission> queryPermissions(int i);

	List<Permission> queryAll();

	void addPermission(Permission permission);

	Permission getPermissionById(Integer id);

	void updatePermission(Permission permission);

	void deletePermission(Integer id);

//	List<Permission> getAsignedPermissions(Integer id);

	List<Integer> getAsignedPermissionIdList(Integer id);

}
