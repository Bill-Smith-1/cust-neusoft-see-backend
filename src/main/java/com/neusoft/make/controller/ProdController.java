package com.neusoft.make.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.service.IProdService;

/**
 * @Description: 产品管理专属Controller
 * 
 * @author: 王思鉴
 * 
 * @date: 2023-12-28
 */
@CrossOrigin("*") // 允许跨域访问
@RestController
@RequestMapping("/newProd") // url=/newProd
public class ProdController {
	// 上层调中层
	@Autowired
	IProdService prodService;

	/**
	 * @Description: 查询产品的方法
	 * 
	 * @param: keywords   用于查询的关键字
	 * @param: pageNum    当前页码
	 * @param: maxPageNum 每页显示的记录数量
	 * @return: PageDto 数据传输对象
	 */
	@RequestMapping("listProd") // @RequestParam method = RequestMethod.POST
	public PageDto listProd(String keywords, String pageNum, String maxPageNum) {
		System.out.println("keywords=" + keywords + " pageNum=" + pageNum + " maxPageNum=" + maxPageNum);
		return prodService.listProd(keywords, Integer.parseInt(pageNum), Integer.parseInt(maxPageNum));
	}

	/**
	 * @Description: 添加产品的方法
	 * 
	 * @param: prod 包含产品信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败 method = RequestMethod.POST
	 */
	@RequestMapping(value = "addProd")
	public String addProd(@RequestParam Map<String, Object> prod) {
		int result = prodService.addProd(prod);
		if (result == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 更新产品信息的方法
	 * 
	 * @param: prod 包含更新产品信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	@RequestMapping("updateProd")
	public String updateProd(@RequestParam Map<String, Object> prod) {
		int i = prodService.updateProdById(prod);
		if (i == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 根据产品号删除产品的方法 可以批量删除
	 * 
	 * @param: pcode 包含产品号的字符串
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	@RequestMapping("deleteProd")
	public String deleteProdById(@RequestParam String pcode) {
		System.out.println("ProdController pcode=" + pcode);
		int result = prodService.deleteProdByIds(pcode);
		if (result == 1) {
			return "1";
		}
		return "0";
	}
}
