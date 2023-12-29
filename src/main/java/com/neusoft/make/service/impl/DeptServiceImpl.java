package com.neusoft.make.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.mapper.DeptMapper;
import com.neusoft.make.po.Dept;
import com.neusoft.make.service.IDeptService;

/**
 * @Description: 部门Service接口实现类
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 */
@Service
public class DeptServiceImpl implements IDeptService {

	@Autowired // DI 依赖注入注解
	DeptMapper deptMapper;

	/**
	 * @Description: 分页查询部门
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */
	@Override
	public PageDto listDept(String keywords, int pageNum, int maxPageNum) {
		int totalRow = 0; // 初始化总行数
		int totalPageNum = 0; // 初始化总页数
		int preNum = 0; // 初始化上一页
		int nextNum = 0; // 初始化下一页
		int beginNum = 0; // 初始化开始记录数

		PageDto pageDto = new PageDto();
		// 获取总行数
		totalRow = deptMapper.getDeptCount(keywords);// dao.getDeptCount();// 12
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
		List<Dept> list = deptMapper.listDept(keywords, beginNum, maxPageNum);
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
	 * @Description: 部门添加
	 * @param: dept 包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	@Override
	public int addDept(Map<String, Object> dept) {
		return deptMapper.addDept(dept);
	}

	/**
	 * @Description: 部门更新
	 * @param: dept 包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	@Override
	public int updateDeptById(Map<String, Object> dept) {
		return deptMapper.updateDeptById(dept);
	}

	/**
	 * @Description: 部门删除
	 * @param: deptno 包含部门编号信的字符串对象
	 * @return: 整数 1==删除成功 0==删除失败
	 * @exception: 无
	 */
	@Override
	public int deleteDeptByIds(String deptno) {
		String[] split = deptno.split(","); // 3,6,10
		int n = 0;
		for (String str : split) {
			n = deptMapper.deleteDeptByIds(str);
		}
		return n;
	}
}