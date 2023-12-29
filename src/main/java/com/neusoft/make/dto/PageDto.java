package com.neusoft.make.dto;

import java.util.List;

/**
 * @Description: 数据传输对象==这里专用于传输分页后的业务数据
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 */
public class PageDto {
	private int totalRow; // 总行数
	private int totalPageNum; // 总页数
	private int preNum; // 上一页
	private int nextNum; // 下一页
	private int pageNum; // 当前页
	private int maxPageNum; // 每页显示最大行数
	private int beginNum; // 开始记录数
	private List list; // 查询返回数据

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getPreNum() {
		return preNum;
	}

	public void setPreNum(int preNum) {
		this.preNum = preNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getMaxPageNum() {
		return maxPageNum;
	}

	public void setMaxPageNum(int maxPageNum) {
		this.maxPageNum = maxPageNum;
	}

	public int getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(int beginNum) {
		this.beginNum = beginNum;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}