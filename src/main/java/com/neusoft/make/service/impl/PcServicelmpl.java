package com.neusoft.make.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.mapper.PcMapper;
import com.neusoft.make.po.Pc;
import com.neusoft.make.service.IPcService;

/**
 * @Description: 产品类别Service接口实现类
 * 
 * @author: 王思鉴
 * 
 * @date: 2023-12-27
 */
@Service
public class PcServicelmpl implements IPcService {
	@Autowired // DI 依赖注入注解 Spring框架 @注解
	PcMapper pcMapper;// 中层调用底层

	/**
	 * @Description: 分页查询产品类别
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */
	@Override
	public PageDto listPc(String keywords, int pageNum, int maxPageNum) {
		int totalRow = 0; // 初始化总行数
		int totalPageNum = 0; // 初始化总页数
		int preNum = 0; // 初始化上一页
		int nextNum = 0; // 初始化下一页
		int beginNum = 0; // 初始化开始记录数

		PageDto pageDto = new PageDto();
		// 获取总行数
		totalRow = pcMapper.getPcCount(keywords);
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
		List<Pc> list = pcMapper.listPc(keywords, beginNum, maxPageNum);
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
	 * @Description: 产品类别添加
	 * @param: Pc 包含产品类别信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	@Override
	public int addPc(Map<String, Object> pc) {
		return pcMapper.addPc(pc);
	}

	/**
	 * @Description: 产品类别更新
	 * @param: dept 包含产品类别信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	@Override
	public int updatePcById(Map<String, Object> pc) {
		return pcMapper.updatePcById(pc);
	}

	/**
	 * @Description: 产品类别删除
	 * @param: deptno 包含产品类别编号信的字符串对象
	 * @return: 整数 1==删除成功 0==删除失败
	 * @exception: 无
	 */
	@Override
	public int deletePcByIds(String pcno) {
		String[] split = pcno.split(","); // 3,6,10
		int n = 0;
		for (String str : split) {
			n = pcMapper.deletePcByIds(str);
		}
		return n;
	}
}