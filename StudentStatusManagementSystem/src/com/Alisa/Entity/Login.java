package com.Alisa.Entity;

public class Login {
	private String loginName;
	private String loginPassword;
	private String randNumber;
	private long account;
	
	
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getRandNumber() {
		return randNumber;
	}
	public void setRandNumber(String randNumber) {
		this.randNumber = randNumber;
	}
}
