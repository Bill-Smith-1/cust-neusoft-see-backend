package com.neusoft.make.service;

import java.util.Map;

import com.neusoft.make.dto.PageDto;

/**
 * @Description: 产品类别Service接口
 * 
 * @author: 王思鉴
 * 
 * @date: 2023-12-27
 * 
 */
public interface IPcService {
	/**
	 * @Description: 分页查询产品类别
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */
	public PageDto listPc(String keywords, int pageNum, int maxPageNum);

	/**
	 * @Description: 产品类别添加
	 * @param: dept 包含产品类别信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	int addPc(Map<String, Object> pc);

	/**
	 * @Description: 产品类别更新
	 * @param: emp 包含产品类别信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	public int updatePcById(Map<String, Object> pc);

	/**
	 * @Description: 产品类别删除
	 * @param: deptno 包含产品类别编号信的字符串对象
	 * @return: 整数 1==删除成功 0==删除失败
	 * @exception: 无
	 */
	public int deletePcByIds(String pcno);
}
