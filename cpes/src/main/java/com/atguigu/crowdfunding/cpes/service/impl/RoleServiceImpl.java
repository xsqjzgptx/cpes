package com.atguigu.crowdfunding.cpes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.dao.RoleMapper;
import com.atguigu.crowdfunding.cpes.service.i.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
    private RoleMapper roleMapper;
	@Override
	public Page<Role> getAllRoles(Map<String, Object> paraMap) {
		Page<Role> page = new Page<>();
		//查询数量
		int totalCounts = roleMapper.selectTotalCounts();
		//查询分页数据
		List<Role> roles = roleMapper.getAllPaged(paraMap);
		
		//为page的各个属性(DataTable要求的属性)赋值
		int index = 1;
		for (Role role : roles) {
		   role.setIndex(index++);
		}
		
		page.setRecordsFiltered(totalCounts);
		page.setData(roles);
		page.setRecordsFiltered(totalCounts);
		return page;
	}
	@Override
	public Role getRoleById(Integer id) {
		Role role = roleMapper.getById(id);
		return role;
	}
	@Override
	public void updateRole(Role role) {
		roleMapper.update(role);
	}
	@Override
	public void insert(String name) {
		roleMapper.insert(name);
		
	}
	@Override
	public void update(Role role) {
		
		roleMapper.update(role);
	}
	@Override
	public void delete(Datas datas) {
		//先删除旧的   再加入新的
		roleMapper.delete(datas);
	}
	@Override
	public void design(Datas datas, Integer roleId) {
		//删除旧的关系 增加新的关系
		roleMapper.deleteRolePermissionRelation(roleId);
		roleMapper.insertRolePermissionRelation(roleId,datas);
	}
	@Override
	public Role getDeepRoleById(Integer id) {
		Role role = roleMapper.getDeepRoleById(id);
		return role;
	}
	@Override
	public List<Role> getAll() {
		List<Role> roles = 	roleMapper.getAll();
		return roles;
	}
}