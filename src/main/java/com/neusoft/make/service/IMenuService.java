package com.neusoft.make.service;

import java.util.List;

import com.neusoft.make.po.Menu;
import com.neusoft.make.po.User;

/**
 * @Description: 菜单专属Service接口
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 * 
 */
public interface IMenuService {

	/**
	 * @Description: 根据角色Id查询角色对应的一级菜单
	 * @param: roleId 角色Id
	 * @return: 菜单对象集合
	 * @exception: 无
	 */
	public List<Menu> listMenu(int roleId);

	/**
	 * @Description: 按用户名和密码查询 相应的对象==登录
	 * @param: keywords  用户名
	 * @param: keywords2 密码
	 * @return: 用户对象
	 * @exception: 无
	 */
	public User login(String keywords, String keywords2);
}
