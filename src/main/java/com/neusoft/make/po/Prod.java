package com.neusoft.make.po;

/**
 * @Description: 部门实体类
 * 
 * @author: 王思鉴
 * 
 * @date: 2023-12-28
 */
public class Prod {
	private Integer pno;
	private Integer pcode;
	private String pname;
	private Integer pcno;
	private String pSpec;
	private String pDesc;

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public Integer getPcode() {
		return pcode;
	}

	public void setPcode(Integer pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getpSpec() {
		return pSpec;
	}

	public void setpSpec(String pSpec) {
		this.pSpec = pSpec;
	}

	public Integer getPcno() {
		return pcno;
	}

	public void setPcno(Integer pcno) {
		this.pcno = pcno;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
}
