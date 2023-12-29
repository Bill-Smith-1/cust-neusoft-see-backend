/**
 * 
 */
package com.neusoft.make.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.make.dto.PageDto;
import com.neusoft.make.mapper.DeviceTypeMapper;
import com.neusoft.make.po.DeviceType;
import com.neusoft.make.service.IDeviceTypeService;

/**
 * @Description: 设备类型Service接口实现类
 * @author: 马硕
 * @date: 2023-12-26
 */
@Service
public class DeviceTypeServiceImpl implements IDeviceTypeService {

	@Autowired // DI 依赖注入注解
	DeviceTypeMapper devicetypeMapper;

	/**
	 * @Description: 分页查询设备类型
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    当前页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: dto对象
	 * @exception: 无
	 */

	@Override
	public PageDto listDeviceType(String keywords, int pageNum, int maxPageNum) {
		// TODO Auto-generated method stub
		int totalRow = 0; // 初始化总行数
		int totalPageNum = 0; // 初始化总页数
		int preNum = 0; // 初始化上一页
		int nextNum = 0; // 初始化下一页
		int beginNum = 0; // 初始化开始记录数

		PageDto pageDto = new PageDto();
		// 获取总行数
		totalRow = devicetypeMapper.getDeviceTypeCount(keywords);// dao.getDeptCount();// 12
		// 如果查询行数为0，那么直接结束。
		if (totalRow == 0) {
			return pageDto;
		}
		// 计算总页数 21 % 5
		if (totalRow % maxPageNum == 0) {
			totalPageNum = totalRow / maxPageNum;
		} else {
			totalPageNum = totalRow / maxPageNum + 1; // 5
		}
		// 当前页数验证
		if (pageNum <= 0) {
			pageNum = 1;
		}
		if (pageNum > totalPageNum) {
			pageNum = totalPageNum;
		}
		// 设置上一页和下一页
		preNum = pageNum;
		nextNum = pageNum;
		if (pageNum > 1) {
			preNum--;
		}
		if (pageNum < totalPageNum) {
			nextNum++;
		}
		// 计算开始查询记录数
		beginNum = (pageNum - 1) * maxPageNum;
		// 开始查询业务数据
		List<DeviceType> list = devicetypeMapper.listDeviceType(keywords, beginNum, maxPageNum);
		// 封装返回数据
		pageDto.setTotalRow(totalRow);// totalRow
		pageDto.setTotalPageNum(totalPageNum);
		pageDto.setPreNum(preNum);
		pageDto.setNextNum(nextNum);
		pageDto.setPageNum(pageNum);
		pageDto.setMaxPageNum(maxPageNum);
		pageDto.setBeginNum(beginNum);
		pageDto.setList(list);
		return pageDto;
	}

	/**
	 * @Description: 设备类型添加
	 * @param: DeviceType 包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */

	@Override
	public int addDeviceType(Map<String, Object> devicetype) {
		// TODO Auto-generated method stub
		return devicetypeMapper.addDeviceType(devicetype);
	}

	/**
	 * @Description: 设备类型更新
	 * @param: DeviceType包含部门信息的Map对象
	 * @return: 整数 1==添加成功 0==添加失败
	 * @exception: 无
	 */

	@Override
	public int updateDeviceTypeById(Map<String, Object> devicetype) {
		// TODO Auto-generated method stub
		return devicetypeMapper.updateDeviceTypeById(devicetype);
	}

	/**
	 * @Description: 设备类型删除
	 * @param: ID 包含部门编号的字符串对象
	 * @return: 整数 1==删除成功 0==删除失败
	 * @exception: 无
	 */

	@Override
	public int deleteDeviceTypeByIds(String ID) {
		// TODO Auto-generated method stub
		String[] split = ID.split(","); // 3,6,10
		int n = 0;
		for (String str : split) {
			n = devicetypeMapper.deleteDeviceTypeByIds(str);
		}
		return n;
	}

}
