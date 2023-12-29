package com.neusoft.make.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.make.po.Prod;

/**
 * @Description: 产品信息Mapper接口
 * 
 * @author: 王思鉴
 * 
 * @date: 2023-12-28
 */
@Mapper
public interface ProdMapper {
	/**
	 * @Description: 单条件获取产品信息数量
	 * @param: keywords 查询条件关键字
	 * @return: 整数
	 * @exception: 无
	 */
	public int getProdCount(@Param("keywords") String keywords);

	/**
	 * @Description: 单条件分页获取产品信息记录
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    起始页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: 产品信息对象集合
	 * @exception: 无
	 */
	public List<Prod> listProd(@Param("keywords") String keywords, @Param("pageNum") int pageNum,
			@Param("maxPageNum") int maxPageNum);

	/**
	 * @Description: 产品信息添加
	 * @param: prod 包含产品信息信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int addProd(Map<String, Object> prod);

	/**
	 * @Description: 产品信息更新
	 * @param: prod 包含产品信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int updateProdById(Map<String, Object> prod);

	/**
	 * @Description: 产品信息删除
	 * @param: prodno 包含产品信息编号信的字符串对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int deleteProdByIds(String prodno);
}