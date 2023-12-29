package com.neusoft.make.service;

import java.util.Map;

import com.neusoft.make.dto.PageDto;

/**
 * @Description: 部门Service接口
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 * 
 */
public interface IDeptService {

	/**
	 * @Description: 分页查询部门
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */
	public PageDto listDept(String keywords, int pageNum, int maxPageNum);

	/**
	 * @Description: 部门添加
	 * @param: dept 包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	int addDept(Map<String, Object> dept);

	/**
	 * @Description: 部门更新
	 * @param: dept 包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	public int updateDeptById(Map<String, Object> dept);

	/**
	 * @Description: 部门删除
	 * @param: deptno 包含部门编号信的字符串对象
	 * @return: 整数 1==删除成功 0==删除失败
	 * @exception: 无
	 */
	public int deleteDeptByIds(String deptno);
}
