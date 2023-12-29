package com.neusoft.make.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.service.IPcService;

/**
 * @Description: 产品类别管理专属Controller
 * 
 * @author: 王思鉴
 * 
 * @date: 2023-12-27
 */
@CrossOrigin("*") // 允许跨域访问
@RestController
@RequestMapping("/newPc") // url=/newPc
public class PcController {
	// 上层调中层
	@Autowired
	IPcService pcService;

	/**
	 * @Description: 查询产品类别的方法
	 * 
	 * @param: keywords   用于查询的关键字
	 * @param: pageNum    当前页码
	 * @param: maxPageNum 每页显示的记录数量
	 * @return: PageDto 数据传输对象
	 */
	@RequestMapping("listPc") // @RequestParam method = RequestMethod.POST
	public PageDto listPc(String keywords, String pageNum, String maxPageNum) {
		System.out.println("keywords=" + keywords + " pageNum=" + pageNum + " maxPageNum=" + maxPageNum);
		return pcService.listPc(keywords, Integer.parseInt(pageNum), Integer.parseInt(maxPageNum));
	}

	/**
	 * @Description: 添加产品类别的方法
	 * 
	 * @param: pc 包含产品类别信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败 method = RequestMethod.POST
	 */
	@RequestMapping(value = "addPc")
	public String addPc(@RequestParam Map<String, Object> pc) {
		int result = pcService.addPc(pc);
		if (result == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 更新产品类别的方法
	 * 
	 * @param: dept 包含更新产品类别信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	// @RequestMapping(value = "updatePc", method = RequestMethod.POST) // GET
	@RequestMapping("updatePc")
	public String updatePc(@RequestParam Map<String, Object> pc) {
		int i = pcService.updatePcById(pc);
		if (i == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 根据产品类别号删除产品类别的方法 可以批量删除
	 * 
	 * @param: deptno 包含产品类别号的字符串
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	@RequestMapping("deletePc")
	public String deletePcById(@RequestParam String pcno) {
		System.out.println("PcController empNo=" + pcno);
		int result = pcService.deletePcByIds(pcno);
		if (result == 1) {
			return "1";
		}
		return "0";
	}
}
