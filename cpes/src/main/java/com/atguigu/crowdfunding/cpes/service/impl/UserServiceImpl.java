package com.atguigu.crowdfunding.cpes.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.bean.User;
import com.atguigu.crowdfunding.cpes.dao.RoleMapper;
import com.atguigu.crowdfunding.cpes.dao.UserMapper;
import com.atguigu.crowdfunding.cpes.service.i.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper  roleMapper;
	@Override
	public User getUserByName(String loginacct) {
		User user = userMapper.getUserByName(loginacct);
		return user;
	}

	//这个其实是getAllUsers
	@Override
	public Page<User> getAllUsers(Map<String, Object> paraMetersMap) {
		Page<User> page = new Page<>();
		// 查询数量
		int totalCounts = userMapper.selectTotalUserCounts();
		// 查询分页数据
		List<User> users = userMapper.getAll(paraMetersMap);

		// 为page的各个属性(DataTable要求的属性)赋值
		int index = 1;
		for (User user : users) {
			user.setIndex(index++);
		}

		page.setRecordsFiltered(totalCounts);
		page.setData(users);
		page.setRecordsFiltered(totalCounts);
		return page;
	}

	@Override
	public void insert(User user) {
		//先判断用户是否存在 再插入
		User userByName = userMapper.getUserByName(user.getLoginacct());
		if (userByName == null) {
			userMapper.insert(user);
		}else {
			throw new RuntimeException();//处理器会捕捉并处理
		}
	}

	@Override
	public User getUserById(Integer userid) {
		User user = userMapper.selectByPrimaryKey(userid);
		return user;
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
		
	}

	@Override
	public void delete(Datas datas) {
		userMapper.delete(datas);
	}

	@Override
	public List<Integer> getAsignedRolesByUid(Integer userid) {
		List<Integer> aRoles = roleMapper.getAsginedRoles(userid);
		return aRoles;
	}

	@Override
	public List<Permission> queryPermissions(User loginUser) {
		List<Permission> permissions = 	userMapper.queryPermissions(loginUser);
		return permissions;
	}

	@Override
	public void asignRole(Datas datas, Integer userid) {
		
		//因为这时datas的ids集合里就有一个属性 所以直接传入一个即可
		Integer roleid = datas.getIds().get(0);
		userMapper.asignRole(roleid,userid);
		
	}

	@Override
	public void unAssignRole(Datas datas, Integer userid) {
		Integer roleid = datas.getIds().get(0);
		userMapper.unAssignRole(roleid,userid);
		
	}

	@Override
	public void asignAll(Integer userid) {
		//这里需要所有的roleid  可以从页面传过来 也可以从数据库查出来 这里选择后者
		List<Role> all = roleMapper.getAll();
		List<Integer> roidList = new ArrayList<Integer>();
		for (Role role : all) {
			roidList.add(role.getId());
		}
		userMapper.asignAll(userid,roidList);
	}

	@Override
	public void unAssignAll(Integer userid) {
		userMapper.unAssignAll(userid);
	}

}
