package com.ht.servlet;

/////用户名密码读取类

public class AccountBean {
	static AccountBean AB;
	private String username;
	 private int type=-1;
	 AccountBean(){}
	 public static AccountBean getInstance(){
			if(AB==null) AB=new AccountBean();
			return AB;
		}
	 private String password;
	 
	 public int getType() {
		  return type;
		 }
	 public void setType(int type) {
		  this.type = type;
	 }
	 public String getPassword() {
	  return password;
	 }
	 public void setPassword(String password) {
	  this.password = password;
	 }
	 public String getUsername() {
	  return username;
	 }
	 public void setUsername(String username) {
	  this.username = username;
	 }
}
