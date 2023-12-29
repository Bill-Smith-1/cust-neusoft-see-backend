package com.neusoft.make.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.mapper.ProdMapper;
import com.neusoft.make.po.Prod;
import com.neusoft.make.service.IProdService;

/**
 * @Description: 产品Service接口实现类
 * 
 * @author: 王思鉴
 * 
 * @date: 2023-12-28
 * 
 */
@Service
public class ProdServiceImpl implements IProdService {
	@Autowired // DI 依赖注入注解 Spring框架 @注解
	ProdMapper prodMapper;// 中层调用底层

	/**
	 * @Description: 分页查询员工
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */
	@Override
	public PageDto listProd(String keywords, int pageNum, int maxPageNum) {
		int totalRow = 0; // 初始化总行数
		int totalPageNum = 0; // 初始化总页数
		int preNum = 0; // 初始化上一页
		int nextNum = 0; // 初始化下一页
		int beginNum = 0; // 初始化开始记录数

		PageDto pageDto = new PageDto();
		// 获取总行数
		totalRow = prodMapper.getProdCount(keywords);
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
		List<Prod> list = prodMapper.listProd(keywords, beginNum, maxPageNum);
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

	@Override
	public int addProd(Map<String, Object> prod) {
		return prodMapper.addProd(prod);
	}

	@Override
	public int updateProdById(Map<String, Object> prod) {
		return prodMapper.updateProdById(prod);
	}

	@Override
	public int deleteProdByIds(String pcode) {
		String[] split = pcode.split(","); // 3,6,10
		int n = 0;
		for (String str : split) {
			n = prodMapper.deleteProdByIds(str);
		}
		return n;
	}

}
