/**
 * 
 */
package com.neusoft.make.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.service.IDeviceService;

/**
 * @Description: 设备专属Controller
 * @author: 马硕
 * @date: 2023-12-26
 */
@CrossOrigin("*") // 允许跨域访问
@RestController
@RequestMapping("/newDevice")
public class DeviceController {

	@Autowired
	IDeviceService deviceService;

	/**
	 * @Description: 查询设备的方法
	 * 
	 * @param: keywords   用于查询的关键字
	 * @param: pageNum    当前页码
	 * @param: maxPageNum 每页显示的记录数量
	 * @return: PageDto 数据传输对象
	 */
	@RequestMapping("listDevice") // @RequestParam method = RequestMethod.POST
	public PageDto listDevice(String keywords, String pageNum, String maxPageNum) {
		System.out.println("keywords=" + keywords + " pageNum=" + pageNum + " maxPageNum=" + maxPageNum);
		return deviceService.listDevice(keywords, Integer.parseInt(pageNum), Integer.parseInt(maxPageNum));
	}

	/**
	 * @Description: 添加设备的方法
	 * 
	 * @param: Device 包含部门信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败 method = RequestMethod.POST
	 */
	@RequestMapping(value = "addDevice")
	public String addDevice(@RequestParam Map<String, Object> device) {
		int result = deviceService.addDevice(device);
		if (result == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 更新设备信息的方法
	 * 
	 * @param: Device 包含更新部门信息的Map集合
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	// @RequestMapping(value = "updateDept", method = RequestMethod.POST) // GET
	@RequestMapping("updateDevice")
	public String updateDevice(@RequestParam Map<String, Object> device) {
		int i = deviceService.updateDeviceById(device);
		if (i == 1) {
			return "1";
		}
		return "0";
	}

	/**
	 * @Description: 根据设备号删除设备的方法 可以批量删除
	 * 
	 * @param: ID 包含部门号的字符串
	 * @return: 字符串 "1"==添加成功 "0"==添加失败
	 */
	@RequestMapping("deleteDevice")
	public String deleteDeviceById(@RequestParam String id) {
		System.out.println("DeviceController id=" + id);
		int result = deviceService.deleteDeviceByIds(id);
		if (result == 1) {
			return "1";
		}
		return "0";
	}
}
