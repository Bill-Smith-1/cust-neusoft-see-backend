package com.neusoft.make.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.service.IDeptService;

/**
 * @Description: 部门管理专属Controller
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 */

@CrossOrigin("*") // 允许跨域访问
@RestController
@RequestMapping("/newDept")
public class DeptController {

	@Autowired
	IDeptService deptService;

	/**
	 * @Description: 查询部门的方法
	 * 
	 * @param: keywords   用于查询的关键字
	 * @param: pageNum    当前页码
	 * @param: maxPageNum 每页显示的记录数量
	 * @return: PageDto 数据传输对象
	 */
	@RequestMapping("listDept") // @RequestParam method = RequestMethod.POST
	public PageDto listDept(String keywords, String pageNum, String maxPageNum) {
		System.out.println("keywords=" + keywords + " pageNum=" + pageNum + " maxPageNum=" + maxPageNum);
		return deptService.listDept(keywords, Integer.parseInt(pageNum), Integer.parseInt(maxPageNum));
	}

	/**
	 * @Description: 添加部门的方法
	 * 
	 * @param: dept 包含部门信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败 method = RequestMethod.POST
	 */
	@RequestMapping(value = "addDept")
	public String addDept(@RequestParam Map<String, Object> dept) {
		int result = deptService.addDept(dept);
		if (result == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 更新部门信息的方法
	 * 
	 * @param: dept 包含更新部门信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	// @RequestMapping(value = "updateDept", method = RequestMethod.POST) // GET
	@RequestMapping("updateDept")
	public String updateDept(@RequestParam Map<String, Object> dept) {
		int i = deptService.updateDeptById(dept);
		if (i == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 根据部门号删除部门的方法 可以批量删除
	 * 
	 * @param: deptno 包含部门号的字符串
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	@RequestMapping("deleteDept")
	public String deleteDeptById(@RequestParam String deptno) {
		System.out.println("DeptController deptno=" + deptno);
		int result = deptService.deleteDeptByIds(deptno);
		if (result == 1) {
			return "1";
		}
		return "0";
	}
}