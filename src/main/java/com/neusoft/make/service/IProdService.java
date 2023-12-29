package com.neusoft.make.service;

import java.util.Map;

import com.neusoft.make.dto.PageDto;

/**
 * @Description: 产品信息Service接口
 * 
 * @author: 王思鉴
 * 
 * @date: 2023-12-28
 */
public interface IProdService {
	/**
	 * @Description: 分页查询产品信息
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */
	public PageDto listProd(String keywords, int pageNum, int maxPageNum);

	/**
	 * @Description: 产品信息添加
	 * @param: dept 包含产品信息信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	int addProd(Map<String, Object> prod);

	/**
	 * @Description: 产品信息更新
	 * @param: prod 包含产品信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	public int updateProdById(Map<String, Object> prod);

	/**
	 * @Description: 员工删除
	 * @param: pcode 包含员工编号信的字符串对象
	 * @return: 整数 1==删除成功 0==删除失败
	 * @exception: 无
	 */
	public int deleteProdByIds(String pcode);
}
