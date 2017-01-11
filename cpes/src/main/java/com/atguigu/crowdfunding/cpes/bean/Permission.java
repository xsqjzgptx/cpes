package com.atguigu.crowdfunding.cpes.bean;

import java.util.ArrayList;
import java.util.List;

public class Permission {
    private Integer id,pid;

    private String name;

    private String url;

    private String icon;
    private Integer sepno;
    
    private boolean checked; //是否被分配
    
    private boolean open = true ; //跟表没关系 , 是zTree的要求
    private List<Permission> children = new ArrayList<Permission>();
    
    
    
    public Integer getSepno() {
		return sepno;
	}

	public void setSepno(Integer sepno) {
		this.sepno = sepno;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	
	public List<Permission> getChildren() {
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}

	public Integer getSeqno() {
		return sepno;
	}

	public void setSeqno(Integer sepno) {
		this.sepno = sepno;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

	public Permission(Integer id, Integer pid, String name, String url,
			String icon, Integer seqno, boolean open,
			List<Permission> permissions) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.sepno = seqno;
		this.open = open;
		this.children = permissions;
	}

	public Permission() {
		super();
	}

	public Permission(String name, boolean open, List<Permission> permissions) {
		super();
		this.name = name;
		this.open = open;
		this.children = permissions;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", icon=" + icon
				+ ", sepno=" + sepno + ", checked=" + checked + "]";
	}
    
    
    
    
    
}