package com.neusoft.make.po;

/**
 * @Description: 用户实体类
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 * 
 */
public class User {
	private String id;
	private String userName;
	private String password;
	private String realName;
	private String roleID;
	private String docTitleID;
	private String isScheduling;
	private String deptID;
	private String registLeID;
	private String delMark;

	public User() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getDocTitleID() {
		return docTitleID;
	}

	public void setDocTitleID(String docTitleID) {
		this.docTitleID = docTitleID;
	}

	public String getIsScheduling() {
		return isScheduling;
	}

	public void setIsScheduling(String isScheduling) {
		this.isScheduling = isScheduling;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public String getRegistLeID() {
		return registLeID;
	}

	public void setRegistLeID(String registLeID) {
		this.registLeID = registLeID;
	}

	public String getDelMark() {
		return delMark;
	}

	public void setDelMark(String delMark) {
		this.delMark = delMark;
	}
}