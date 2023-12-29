package com.neusoft.make.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.make.po.Order;

/**
 * @Description: 订单Mapper接口
 * 
 * @author: 吴则朋
 * 
 * @date: 2023-12-28
 */
@Mapper
public interface OrderMapper {
	/**
	 * @Description: 单条件获取订单数量
	 * @param: keywords 查询条件关键字
	 * @return: 整数
	 * @exception: 无
	 */
	public int getOrderCount(@Param("keywords") String keywords);

	/**
	 * @Description: 单条件分页获取订单记录
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    起始页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: 订单对象集合
	 * @exception: 无
	 */
	public List<Order> listOrder(@Param("keywords") String keywords, @Param("pageNum") int pageNum,
			@Param("maxPageNum") int maxPageNum);

	/**
	 * @Description: 订单添加
	 * @param: order 包含订单信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int addOrder(Map<String, Object> order);

	/**
	 * @Description: 订单更新
	 * @param: order 包含订单信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int updateOrderById(Map<String, Object> order);

	/**
	 * @Description: 订单删除
	 * @param: ID 包含订单编号信的字符串对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int deleteOrderByIds(String id);
}
