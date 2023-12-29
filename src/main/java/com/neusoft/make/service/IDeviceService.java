package com.neusoft.make.service;

import java.util.Map;

import com.neusoft.make.dto.PageDto;

/**
 * @Description: 设备Service接口
 * 
 * @author: 马硕
 * 
 * @date: 2023-12-26
 * 
 */
public interface IDeviceService {

	/**
	 * @Description: 分页查询设备
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */
	public PageDto listDevice(String keywords, int pageNum, int maxPageNum);

	/**
	 * @Description: 设备添加
	 * @param: Device 包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	int addDevice(Map<String, Object> device);

	/**
	 * @Description: 设备更新
	 * @param: DeviceType 包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */
	public int updateDeviceById(Map<String, Object> device);

	/**
	 * @Description: 设备类型删除
	 * @param: DeviceType 包含部门编号信的字符串对象
	 * @return: 整数 1==删除成功 0==删除失败
	 * @exception: 无
	 */
	public int deleteDeviceByIds(String ID);
}