package com.neusoft.make.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.make.po.Menu;
import com.neusoft.make.po.User;
import com.neusoft.make.service.IMenuService;

/**
 * @Description: 菜单管理专属Controller
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 */
@CrossOrigin("*") // 允许跨域访问
@RestController
@RequestMapping("/newMenu")
public class MenuController {

	@Autowired
	IMenuService menuService;

	/**
	 * @Description: 通过权限编号查询菜单
	 * 
	 * @param: roleId 权限编号
	 * @return: 菜单对象集合
	 */
	@RequestMapping("listMenu")
	public List<Menu> list(int roleId) {
		return menuService.listMenu(roleId);
	}

	/**
	 * @Description: 通过用户名和密码查找指定的用户对象==用户登录
	 * 
	 * @param: username 用户名, password 密码
	 * @return: 指定的用户对象
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET) // @RequestParam @RequestParam
	public User getUserBean(String username, String password, HttpSession session) {
		User user = menuService.login(username, password);
		if (user != null) {
			session.setAttribute("login_user", user);
			return user;
		} else {
			return null;
		}
	}
}