/**
 * 
 */
package com.neusoft.make.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.service.IEmpService;

/**
 * @Description: 用户管理专属Controller
 * @author: 裴佳辉
 * @date: 2023-12-28
 */
@CrossOrigin("*") // 允许跨域访问
@RestController
@RequestMapping("/newEmp") // url=/newEmp
public class EmpController {
//上层调用中层  DI 依赖注入注解 Spring框架 @注解
	@Autowired
	IEmpService empService;

	/**
	 * @Description: 查询用户的方法
	 * 
	 * @param: keywords   用于查询的关键字
	 * @param: pageNum    当前页码
	 * @param: maxPageNum 每页显示的记录数量
	 * @return: PageDto 数据传输对象
	 */
	@RequestMapping("listEmp") // url=/ListEmp
	public PageDto listEmp(String keywords, String pageNum, String maxPageNum) {
		System.out.println("keywords=" + keywords + " pageNum=" + pageNum + " maxPageNum=" + maxPageNum);
		// 上层调中层
		return empService.listEmp(keywords, Integer.parseInt(pageNum), Integer.parseInt(maxPageNum));
	}

	/**
	 * @Description: 用户注册的方法
	 * 
	 * @param: emp 包含用户信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败 method = RequestMethod.POST
	 */
	@RequestMapping(value = "addEmp")
	public String addEmp(@RequestParam Map<String, Object> emp) {
		int result = empService.addEmp(emp);
		if (result == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 更新用户信息的方法
	 * 
	 * @param: emp 包含更新用户信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	// @RequestMapping(value = "updateEmp", method = RequestMethod.POST) // GET
	@RequestMapping("updateEmp")
	public String updateEmp(@RequestParam Map<String, Object> emp) {
		int i = empService.updateEmpById(emp);
		if (i == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 根据用户ID删除部门的方法 可以批量删除
	 * 
	 * @param: empNo 包含用户ID的字符串
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	@RequestMapping("deleteEmp")
	public String deleteEmpById(@RequestParam String id) {
		System.out.println("DeptController empNo=" + id);
		int result = empService.deleteEmpByIds(id);
		if (result == 1) {
			return "1";
		}
		return "0";
	}
}
