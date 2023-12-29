/**
 * 
 */
package com.neusoft.make.po;

/**
 * @Description:用户实体类
 * @author: 裴佳辉
 * @date: 2023-12-26
 */
public class Emp {
	private Integer id;// ID
	private String uName;// 用户名
	private String pword;// 密码
	private String rName;// 真实姓名
	private Integer rID;// 注册类型
	private String cInfo;// 联系方式
	private String fName;// 工厂名称
	private String fProfile;// 工厂简介
	private String fStatus;// 工厂状态
	private Integer delMark;// 删除标记

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public Integer getrID() {
		return rID;
	}

	public void setrID(Integer rID) {
		this.rID = rID;
	}

	public String getcInfo() {
		return cInfo;
	}

	public void setcInfo(String cInfo) {
		this.cInfo = cInfo;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfProfile() {
		return fProfile;
	}

	public void setfProfile(String fProfile) {
		this.fProfile = fProfile;
	}

	public String getfStatus() {
		return fStatus;
	}

	public void setfStatus(String fStatus) {
		this.fStatus = fStatus;
	}

	public Integer getDelMark() {
		return delMark;
	}

	public void setDelMark(Integer delMark) {
		this.delMark = delMark;
	}

}
