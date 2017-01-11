package com.atguigu.crowdfunding.cpes.service.i;

import java.util.List;
import java.util.Map;

import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Role;

public interface RoleService {
   public Page<Role> getAllRoles(Map<String, Object> map);
   public Role getRoleById(Integer id);
   public void updateRole(Role role);

	public void insert(String name);
	public void update(Role role);
	public void delete(Datas datas);
	public void design(Datas datas, Integer roleId);
	public Role getDeepRoleById(Integer id);
	public List<Role> getAll();
}
