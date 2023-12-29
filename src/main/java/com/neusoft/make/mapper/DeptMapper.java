package com.neusoft.make.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.make.po.Dept;

/**
 * @Description: 部门Mapper接口
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 */
@Mapper
public interface DeptMapper {

	/**
	 * @Description: 单条件获取部门数量
	 * @param: keywords 查询条件关键字
	 * @return: 整数
	 * @exception: 无
	 */
	public int getDeptCount(@Param("keywords") String keywords);

	/**
	 * @Description: 单条件分页获取部门记录
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    起始页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: 部门对象集合
	 * @exception: 无
	 */
	public List<Dept> listDept(@Param("keywords") String keywords, @Param("pageNum") int pageNum,
			@Param("maxPageNum") int maxPageNum);

	/**
	 * @Description: 部门添加
	 * @param: dept 包含部门信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int addDept(Map<String, Object> dept);

	/**
	 * @Description: 部门更新
	 * @param: dept 包含部门信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int updateDeptById(Map<String, Object> dept);

	/**
	 * @Description: 部门删除
	 * @param: deptno 包含部门编号信的字符串对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int deleteDeptByIds(String deptno);
}