package com.atguigu.crowdfunding.cpes.service.i;

import java.util.List;
import java.util.Map;

import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.bean.User;

public interface UserService {

	User getUserByName(String loginacct);


	Page<User> getAllUsers(Map<String, Object> paraMetersMap);


	void insert(User user);


	User getUserById(Integer userid);


	void update(User user);


	void delete(Datas datas);


	List<Integer> getAsignedRolesByUid(Integer userid);


	List<Permission> queryPermissions(User loginUser);


	void asignRole(Datas datas, Integer userid);


	void unAssignRole(Datas datas, Integer userid);


	void asignAll(Integer userid);


	void unAssignAll(Integer userid);




}
