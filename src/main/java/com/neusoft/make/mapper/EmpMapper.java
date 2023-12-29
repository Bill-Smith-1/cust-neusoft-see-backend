/**
 * 
 */
package com.neusoft.make.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.make.po.Emp;

/**
 * @Description: 用户Mapper接口
 * @author: 裴佳辉
 * @date: 2023-12-28
 */
@Mapper
public interface EmpMapper {
	/**
	 * @Description: 单条件获取用户数量
	 * @param: keywords 查询条件关键字
	 * @return: 整数
	 * @exception: 无
	 */
	public int getEmpCount(@Param("keywords") String keywords);

	/**
	 * @Description: 单条件分页获取用户记录
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    起始页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: 用户对象集合
	 * @exception: 无
	 */
	public List<Emp> listEmp(@Param("keywords") String keywords, @Param("pageNum") int pageNum,
			@Param("maxPageNum") int maxPageNum);

	/**
	 * @Description: 用户注册
	 * @param: emp 包含员用户信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int addEmp(Map<String, Object> emp);

	/**
	 * @Description: 用户更新
	 * @param: emp 包含用户信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */

	public int updateEmpById(Map<String, Object> emp);

	/**
	 * @Description: 用户删除
	 * @param: id 包含用户编号字符串对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int deleteEmpByIds(String id);

}
