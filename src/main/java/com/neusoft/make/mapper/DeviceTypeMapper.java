/**
 * 
 */
package com.neusoft.make.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.make.po.DeviceType;

/**
 * @Description: 设备类型Mapper接口
 * @author: 马硕
 * @date: 2023-12-26
 */
@Mapper
public interface DeviceTypeMapper {
	/**
	 * @Description: 单条件获取设备类型数量
	 * @param: keywords 查询条件关键字
	 * @return: 整数
	 * @exception: 无
	 */
	public int getDeviceTypeCount(@Param("keywords") String keywords);

	/**
	 * @Description: 单条件分页获取设备类型记录
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    起始页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: 设备类型对象集合
	 * @exception: 无
	 */
	public List<DeviceType> listDeviceType(@Param("keywords") String keywords, @Param("pageNum") int pageNum,
			@Param("maxPageNum") int maxPageNum);

	/**
	 * @Description: 设备类型添加
	 * @param: DeviceType 包含设备类型信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int addDeviceType(Map<String, Object> devicetype);

	/**
	 * @Description: 设备类型更新
	 * @param: DeviceType 包含设备类型信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int updateDeviceTypeById(Map<String, Object> devicetype);

	/**
	 * @Description: 设备类型删除
	 * @param: ID 包含设备类型编号信的字符串对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int deleteDeviceTypeByIds(String ID);

}
