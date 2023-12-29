package com.neusoft.make.service;

import java.util.Map;

import com.neusoft.make.dto.PageDto;

/**
 * @Description: 订单Service接口
 * 
 * @author: 吴则朋
 * 
 * @date: 2023-12-28
 * 
 */
public interface IOrderService {
	/**
	 * @Description: 分页查询订单
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */
	public PageDto listOrder(String keywords, int pageNum, int maxPageNum);

	/**
	 * @Description: 订单添加
	 * @param: ORDER 包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	int addOrder(Map<String, Object> ORDER);

	/**
	 * @Description: 订单更新
	 * @param: ORDER 包含订单信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	public int updateOrderById(Map<String, Object> ORDER);

	/**
	 * @Description: 订单删除
	 * @param: ID 包含订单编号信的字符串对象
	 * @return: 整数 1==删除成功 0==删除失败
	 * @exception: 无
	 */
	public int deleteOrderByIds(String id);

}
