package com.neusoft.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.make.po.Menu;
import com.neusoft.make.po.User;

/**
 * @Description: 菜单Mapper接口
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 */
@Mapper
public interface MenuMapper {

	/**
	 * @Description: 根据角色查询角色对应的一级菜单
	 * @param: roleId 角色编号
	 * @return: 菜单对象集合
	 * @exception: 无
	 */
	List<Menu> listMenu(int roleId);

	/**
	 * @Description: 根据父级菜单Id，查询对应的子级菜单
	 * @param: parentId 父级菜单Id
	 * @return: 菜单对象集合
	 * @exception: 无
	 */
	List<Menu> sysChildMenuList(int parentId);

	/**
	 * @Description: 按用户名和密码查询 相应的对象==登录
	 * @param: parentId 父级权限编号
	 * @return: 用户对象
	 * @exception: 无 ---- @Param("keywords")
	 */
	public User login(String keywords, String keywords2);
}