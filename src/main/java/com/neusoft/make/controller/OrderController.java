package com.neusoft.make.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.service.IOrderService;

/**
 * @Description: 订单管理专属Controller
 * 
 * @author: 吴则朋
 * 
 * @date: 2023-12-28
 */
@CrossOrigin("*") // 允许跨域访问
@RestController
@RequestMapping("/newOrder") // url=/newOrder
public class OrderController {
	// 上层调中层 DI 依赖注入注解 Spring框架 @注解
	@Autowired
	IOrderService orderService;

	/**
	 * @Description: 查询订单的方法
	 * 
	 * @param: keywords   用于查询的关键字
	 * @param: pageNum    当前页码
	 * @param: maxPageNum 每页显示的记录数量
	 * @return: PageDto 数据传输对象
	 */
	@RequestMapping("listOrder") // url=/newOrder
	public PageDto listOrder(String keywords, String pageNum, String maxPageNum) {
		System.out.println("keywords=" + keywords + " pageNum=" + pageNum + " maxPageNum=" + maxPageNum);
		// 上层掉中层
		return orderService.listOrder(keywords, Integer.parseInt(pageNum), Integer.parseInt(maxPageNum));
	}

	/**
	 * @Description: 添加订单的方法
	 * 
	 * @param: ORDER 包含员工信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败 method = RequestMethod.POST
	 */
	@RequestMapping(value = "addOrder")
	public String addOrder(@RequestParam Map<String, Object> ORDER) {
		int result = orderService.addOrder(ORDER);
		if (result == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 更新订单信息的方法
	 * 
	 * @param: ORDER 包含更新部门信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	// @RequestMapping(value = "updateOrder", method = RequestMethod.POST) // GET
	@RequestMapping("updateOrder")
	public String updateOrder(@RequestParam Map<String, Object> ORDER) {
		int i = orderService.updateOrderById(ORDER);
		if (i == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 根据订单号删除订单的方法 可以批量删除
	 * 
	 * @param: id 包含订单号的字符串
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	@RequestMapping("deleteOrder")
	public String deleteOrderById(@RequestParam String id) {
		System.out.println("OrderController id=" + id);
		int result = orderService.deleteOrderByIds(id);
		if (result == 1) {
			return "1";
		}
		return "0";
	}
}
