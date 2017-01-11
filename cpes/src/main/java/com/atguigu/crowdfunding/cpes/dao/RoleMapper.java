package com.atguigu.crowdfunding.cpes.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Role;

public interface RoleMapper {
	public List<Role> getAllPaged(Map<String, Object> paraMap);

	public Role getById(Integer id);


	public void insert(String name);

	public void update(Role role);

	public void delete( Datas datas);
    //删除旧的只需要roleid即可
	public void deleteRolePermissionRelation(@Param("roleid")Integer roleid);

	public void insertRolePermissionRelation(@Param("roleid")Integer roleid,@Param("datas")Datas datas);

	public Role getDeepRoleById(Integer id);

	public List<Role> getAll();

	public List<Integer> getAsginedRoles(Integer userid);

	public int selectTotalCounts();
}
