package com.atguigu.crowdfunding.cpes.bean;

import java.util.List;

public class Datas {
	private List<User> users;
	private List<Role> roles;
	private List<String> pids; //流程部署id
	

	public List<String> getPids() {
		return pids;
	}

	public void setPids(List<String> pids) {
		this.pids = pids;
	}

	// 通用性:能代表所有的bean的主键
	private List<Integer> ids;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

}
