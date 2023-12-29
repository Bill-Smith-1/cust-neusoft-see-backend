package com.neusoft.make.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.make.mapper.MenuMapper;
import com.neusoft.make.po.Menu;
import com.neusoft.make.po.User;
import com.neusoft.make.service.IMenuService;

/**
 * @Description: 菜单Service接口实现类
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 */
@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	MenuMapper sysMenuMapper;

	/**
	 * @Description: 根据角色Id查询角色对应的一级菜单
	 * @param: roleId 角色Id
	 * @return: 菜单对象集合
	 * @exception: 无
	 */
	public List<Menu> listMenu(int roleId) {
		return sysMenuMapper.listMenu(roleId);
	}

	/**
	 * @Description: 按用户名和密码查询 相应的对象==登录
	 * @param: keywords  用户名
	 * @param: keywords2 密码
	 * @return: 用户对象
	 * @exception: 无
	 */
	@Override
	public User login(String keywords, String keywords2) {
		return sysMenuMapper.login(keywords, keywords2);
	}
}
