package com.Alisa.Entity;

import com.opensymphony.xwork2.ActionSupport;


public class User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long account;
	private String userName;
	private String password;
//	我想说一句，Struts2 ，你的命名能不能遵守规范啊
	private String cla;
	private String type;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCla() {
		return cla;
	}
	public void setCla(String cla) {
		this.cla = cla;
	}
	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("setUserName"+userName);
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
