/**   
 * Copyright © 2019 西安东恒鑫源软件开发有限公司版权所有.
 * 
 * 功能描述：
 * @Package: eam.eamAccountPrint.entity 
 * @author: qjj   
 * @date: 2019年10月25日 上午11:27:15 
 */
package com.ehs.eam.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.ehs.common.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**   
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: EamAccountPrint.java
* @Description:设备台账实体类
*
* @version: v1.0.0
* @author: qjj
* @date: 2019年10月25日 上午11:27:15 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月25日     qjj           v1.0.0               修改原因
*/
@Entity
@Table(name = "EAM_ACCOUNT_PRINT")
public class EamAccountPrint extends BaseEntity {
	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;
	
	public static final String DEVICE_NUM = "deviceNum" ;
	public static final String DEVICE_NAME = "deviceName" ;
	public static final String DEVICE_MODEL = "deviceModel" ;
	public static final String FACTORY_NAME = "factoryName" ;
	public static final String DEVICE_STATUS = "deviceStatus" ;
	public static final String INSTALL_LOCATION = "installLocation" ;
	public static final String PURCHASE_TIME = "purchaseTime" ;
	public static final String BUYING_PRICE = "buyingPrice" ;


	/**
	 * 设备编码
	 */
	private String deviceNum;
	
	/**
	 * 设备名称
	 */
	private String deviceName;
	
	/**
	 * 规格型号
	 */
	private String deviceModel;
	
	/**
	 * 生产厂家
	 */
	private String factoryName;
	
	/**
	 * 设备状态
	 */
	private String deviceStatus;
	
	/**
	 * 安装位置
	 */
	private String installLocation;
	
	/**
	 *采购时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp purchaseTime;
	
	/**
	 * 采购价格
	 */
	private BigDecimal buyingPrice;
	
	
	

	/**
	 * @return the deviceNum
	 */
	public String getDeviceNum() {
		return deviceNum;
	}

	/**
	 * @param deviceNum the deviceNum to set
	 */
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the deviceModel
	 */
	public String getDeviceModel() {
		return deviceModel;
	}

	/**
	 * @param deviceModel the deviceModel to set
	 */
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	/**
	 * @return the factoryName
	 */
	public String getFactoryName() {
		return factoryName;
	}

	/**
	 * @param factoryName the factoryName to set
	 */
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	/**
	 * @return the deviceStatus
	 */
	public String getDeviceStatus() {
		return deviceStatus;
	}

	/**
	 * @param deviceStatus the deviceStatus to set
	 */
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	/**
	 * @return the installLocation
	 */
	public String getInstallLocation() {
		return installLocation;
	}

	/**
	 * @param installLocation the installLocation to set
	 */
	public void setInstallLocation(String installLocation) {
		this.installLocation = installLocation;
	}

	/**
	 * @return the purchaseTime
	 */
	public Timestamp getPurchaseTime() {
		return purchaseTime;
	}

	/**
	 * @param purchaseTime the purchaseTime to set
	 */
	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	/**
	 * @return the buyingPrice
	 */
	public BigDecimal getBuyingPrice() {
		return buyingPrice;
	}

	/**
	 * @param buyingPrice the buyingPrice to set
	 */
	public void setBuyingPrice(BigDecimal buyingPrice) {
		this.buyingPrice = buyingPrice;
	}




	/** 
	* @see com.ehs.common.base.entity.BaseEntity#getForeignClasses()  
	*/
	@Override
	public List<String> getForeignClasses() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
