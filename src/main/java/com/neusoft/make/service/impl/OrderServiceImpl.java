package com.neusoft.make.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.mapper.OrderMapper;
import com.neusoft.make.po.Order;
import com.neusoft.make.service.IOrderService;

/**
 * @Description: 订单Service接口实现类
 * 
 * @author: 吴则朋
 * 
 * @date: 2023-12-28
 */
@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired // DI 依赖注入注解 Spring框架 @注解
	OrderMapper orderMapper;// 中层调用底层

	/**
	 * @Description: 分页查询订单
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */
	@Override
	public PageDto listOrder(String keywords, int pageNum, int maxPageNum) {
		int totalRow = 0; // 初始化总行数
		int totalPageNum = 0; // 初始化总页数
		int preNum = 0; // 初始化上一页
		int nextNum = 0; // 初始化下一页
		int beginNum = 0; // 初始化开始记录数

		PageDto pageDto = new PageDto();
		// 获取总行数
		totalRow = orderMapper.getOrderCount(keywords);
		// 如果查询行数为0，那么直接结束。
		if (totalRow == 0) {
			return pageDto;
		}
		// 计算总页数 21 % 5
		if (totalRow % maxPageNum == 0) {
			totalPageNum = totalRow / maxPageNum;
		} else {
			totalPageNum = totalRow / maxPageNum + 1; // 5
		}
		// 当前页数验证
		if (pageNum <= 0) {
			pageNum = 1;
		}
		if (pageNum > totalPageNum) {
			pageNum = totalPageNum;
		}
		// 设置上一页和下一页
		preNum = pageNum;
		nextNum = pageNum;
		if (pageNum > 1) {
			preNum--;
		}
		if (pageNum < totalPageNum) {
			nextNum++;
		}
		// 计算开始查询记录数
		beginNum = (pageNum - 1) * maxPageNum;
		// 开始查询业务数据
		List<Order> list = orderMapper.listOrder(keywords, beginNum, maxPageNum);
		// 封装返回数据
		pageDto.setTotalRow(totalRow);// totalRow
		pageDto.setTotalPageNum(totalPageNum);
		pageDto.setPreNum(preNum);
		pageDto.setNextNum(nextNum);
		pageDto.setPageNum(pageNum);
		pageDto.setMaxPageNum(maxPageNum);
		pageDto.setBeginNum(beginNum);
		pageDto.setList(list);
		return pageDto;
	}

	/**
	 * @Description: 订单添加
	 * @param: ORDER 包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	@Override
	public int addOrder(Map<String, Object> ORDER) {
		return orderMapper.addOrder(ORDER);
	}

	/**
	 * @Description: 订单更新
	 * @param: ORDER 包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	@Override
	public int updateOrderById(Map<String, Object> ORDER) {
		return orderMapper.updateOrderById(ORDER);
	}

	/**
	 * @Description: 订单删除
	 * @param: id 包含部门编号的字符串对象
	 * @return: 整数 1==删除成功 0==删除失败
	 * @exception: 无
	 */
	@Override
	public int deleteOrderByIds(String id) {
		String[] split = id.split(","); // 3,6,10
		int n = 0;
		for (String str : split) {
			n = orderMapper.deleteOrderByIds(str);
		}
		return n;
	}

}
