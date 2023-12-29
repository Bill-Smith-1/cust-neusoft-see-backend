/**
 * 
 */
package com.neusoft.make.po;

/**
 * @Description: 设备实体类
 * @author: 马硕
 * @date: 2023-12-26
 */
public class Device {
	private Integer ID;
	private String DeviceCode;
	private String DeviceName;
	private String DeviceSpec;
	private String ProductStatus;
	private String Factory;
	private String RentalStatus;
	private Integer DeviceType;

	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}

	/**
	 * @return the deviceCode
	 */
	public String getDeviceCode() {
		return DeviceCode;
	}

	/**
	 * @param deviceCode the deviceCode to set
	 */
	public void setDeviceCode(String deviceCode) {
		DeviceCode = deviceCode;
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return DeviceName;
	}

	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}

	/**
	 * @return the deviceSpec
	 */
	public String getDeviceSpec() {
		return DeviceSpec;
	}

	/**
	 * @param deviceSpec the deviceSpec to set
	 */
	public void setDeviceSpec(String deviceSpec) {
		DeviceSpec = deviceSpec;
	}

	/**
	 * @return the productStatus
	 */
	public String getProductStatus() {
		return ProductStatus;
	}

	/**
	 * @param productStatus the productStatus to set
	 */
	public void setProductStatus(String productStatus) {
		ProductStatus = productStatus;
	}

	/**
	 * @return the factory
	 */
	public String getFactory() {
		return Factory;
	}

	/**
	 * @param factory the factory to set
	 */
	public void setFactory(String factory) {
		Factory = factory;
	}

	/**
	 * @return the rentalStatus
	 */
	public String getRentalStatus() {
		return RentalStatus;
	}

	/**
	 * @param rentalStatus the rentalStatus to set
	 */
	public void setRentalStatus(String rentalStatus) {
		RentalStatus = rentalStatus;
	}

	/**
	 * @return the deviceType
	 */
	public Integer getDeviceType() {
		return DeviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(Integer deviceType) {
		DeviceType = deviceType;
	}

}