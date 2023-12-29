/**
 * 
 */
package com.neusoft.make.service;

import java.util.Map;

import com.neusoft.make.dto.PageDto;

/**
 * @Description: 用户Service接口
 * @author: 裴佳辉
 * @date: 2023-12-28
 */
public interface IEmpService {
	/**
	 * @Description: 分页查询用户
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */
	public PageDto listEmp(String keywords, int pageNum, int maxPageNum);

	/**
	 * @Description: 用户注册
	 * @param: emp 包含用户信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	int addEmp(Map<String, Object> emp);

	/**
	 * @Description: 用户更新
	 * @param: emp 包含用户信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	public int updateEmpById(Map<String, Object> emp);

	/**
	 * @Description: 用户删除
	 * @param: empNo 包含用户编号的字符串对象
	 * @return: 整数 1==删除成功 0==删除失败
	 * @exception: 无
	 */
	public int deleteEmpByIds(String id);
}
