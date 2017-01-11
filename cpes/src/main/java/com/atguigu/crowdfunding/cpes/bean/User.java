package com.atguigu.crowdfunding.cpes.bean;

public class User {
    private Integer id;

    private String name;

    private String loginacct;

    private String userpswd;

    private String email;
    
    private int index;
    

    public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
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
        this.name = name == null ? null : name.trim();
    }

    public String getLoginacct() {
        return loginacct;
    }

    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct == null ? null : loginacct.trim();
    }

    public String getUserpswd() {
        return userpswd;
    }

    public void setUserpswd(String userpswd) {
        this.userpswd = userpswd == null ? null : userpswd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

	public User(Integer id, String name, String loginacct, String userpswd,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.loginacct = loginacct;
		this.userpswd = userpswd;
		this.email = email;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", loginacct=" + loginacct
				+ ", userpswd=" + userpswd + ", email=" + email + "]";
	}
    
    
    
    
}