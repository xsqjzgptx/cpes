package com.atguigu.crowdfunding.cpes.bean;

public class Role {

	private Integer id;
	private String name;
	
	private Integer index;
	private boolean isasigned; 
	//角色是否被授权 ---老师专门写了个类RolePermissionCount
	//所以这样的话 表中也可以添加此字段
	
	public boolean isIsasigned() {
		return isasigned;
	}
	public void setIsasigned(boolean isasigned) {
		this.isasigned = isasigned;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Role() {
		super();
	}
	
	 
}
