package com.neusoft.make.po;

/**
 * @Description: 部门实体类
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 */
public class Dept {
	private Integer deptno;
	private String dname;
	private Integer locid;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getLocid() {
		return locid;
	}

	public void setLocid(Integer locid) {
		this.locid = locid;
	}
}