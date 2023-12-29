/**
 * 
 */
package com.neusoft.make.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.make.po.Device;

/**
 * @Description: 设备Mapper接口
 * @author: 马硕
 * @date: 2023-12-26
 */
@Mapper
public interface DeviceMapper {
	/**
	 * @Description: 单条件获取设备数量
	 * @param: keywords 查询条件关键字
	 * @return: 整数
	 * @exception: 无
	 */
	public int getDeviceCount(@Param("keywords") String keywords);

	/**
	 * @Description: 单条件分页获取设备记录
	 * @param: keywords   查询条件关键字
	 * @param: pageNum    起始页数
	 * @param: maxPageNum 每页最多显示的记录数
	 * @return: 设备类型对象集合
	 * @exception: 无
	 */
	public List<Device> listDevice(@Param("keywords") String keywords, @Param("pageNum") int pageNum,
			@Param("maxPageNum") int maxPageNum);

	/**
	 * @Description: 设备添加
	 * @param: Device 包含设备信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int addDevice(Map<String, Object> device);

	/**
	 * @Description: 设备更新
	 * @param: Device 包含设备信息的Map对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int updateDeviceById(Map<String, Object> device);

	/**
	 * @Description: 设备删除
	 * @param: ID 包含设备编号信的字符串对象
	 * @return: 整数1 为成功
	 * @exception: 无
	 */
	public int deleteDeviceByIds(String ID);

}
