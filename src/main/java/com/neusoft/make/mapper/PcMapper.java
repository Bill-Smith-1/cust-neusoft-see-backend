package com.neusoft.make.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.make.po.Pc;

/**
 * @Description: 产品类别Mapper接口
 * 
 * @author: 王思鉴
 * 
 * @date: 2023-12-26
 */
@Mapper
public interface PcMapper {
	/**
	 * @Description: 单条件获取产品类别数量
	 * @param: keywords 查询条件关键字
	 * @return: 整数
	 * @exception: 无
	 */
	public int getPcCount(@Param("keywords") String keywords);

	/**
	 * @Description: 单条件分页获取产品类别数量记录
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    起始页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: 产品类别数量对象集合
	 * @exception: 无
	 */
	public List<Pc> listPc(@Param("keywords") String keywords, @Param("pageNum") int pageNum,
			@Param("maxPageNum") int maxPageNum);

	/**
	 * @Description: 产品类别数量添加
	 * @param: Pc 包含产品类别数量信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int addPc(Map<String, Object> pc);

	/**
	 * @Description: 产品类别数量更新
	 * @param: dept 包含产品类别数量信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int updatePcById(Map<String, Object> pc);

	/**
	 * @Description: 产品类别数量删除
	 * @param: deptno 包含产品类别数量编号信的字符串对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int deletePcByIds(String pcno);
}
