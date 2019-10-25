package eam.eamPartLibrary.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ehs.common.base.entity.BaseEntity;

/**   
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: eamPartLibrary.java
* @Description: 备件实体类
*
* @version: v1.0.0
* @author: zhaol
* @date: 2019年10月24日 下午6:06:23 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月24日     zhaol           v1.0.0               修改原因
*/
@Entity
@Table(name = "EAM_PART_LIBRARY")
public class EamPartLibrary extends BaseEntity {

	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;
	
	public static final String DEVICENAME="deviceName";
	public static final String DEVICECODE="deviceCode";
	public static final String MODEL="model";
	public static final String TYPE="type";
	public static final String BRAND="brand";
	public static final String NORM="norm";
	public static final String WAREHOUSE="Warehouse";
	public static final String UNIT="unit";
	public static final String PRICE="price";
	public static final String AMOUNT="amount";
	public static final String WARNINGVALUE="warningValue";
	public static final String MANUFACTURER="manufacturer";
	public static final String SUPPLIER="supplier";
	public static final String MATERIAL_TYPE_NAME="materialTypeName"; 
	public static final String LABELCODE="labelCode";
	public static final String SORT="sort";
	
	/**
	 * 设备名称
	 */
	private String deviceName;
	
	/**
	 * 设备编码
	 */
	private String deviceCode;
	
	/**
	 * 设备型号
	 */
	private String model;
	
	/**
	 * 设备类型
	 */
	private String type;
	
	/**
	 * 品牌
	 */
	private String brand;
	
	/**
	 * 规格
	 */
	private String norm;
	
	/**
	 * 所在仓库
	 */
	private String Warehouse;
	
	/**
	 * 单位
	 */
	private char unit;
	
	/**
	 * 价格
	 */
	private BigDecimal price;
	
	/**
	 * 数量
	 */
	private Integer amount;
	
	/**
	 * 预警值
	 */
	private Integer warningValue;
	
	/**
	 * 生产厂商
	 */
	private String manufacturer;
	
	/**
	 * 供应商
	 */
	private String supplier;
	
	/**
	 * 物资类型
	 */
	private String materialTypeName;
	
	/**
	 * 标签码
	 */
	private String labelCode;
	
	/**
	 * 排序
	 */
	private Integer sort; 
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getNorm() {
		return norm;
	}

	public void setNorm(String norm) {
		this.norm = norm;
	}

	public String getWarehouse() {
		return Warehouse;
	}

	public void setWarehouse(String warehouse) {
		Warehouse = warehouse;
	}

	public char getUnit() {
		return unit;
	}

	public void setUnit(char unit) {
		this.unit = unit;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getWarningValue() {
		return warningValue;
	}

	public void setWarningValue(Integer warningValue) {
		this.warningValue = warningValue;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getMaterialTypeName() {
		return materialTypeName;
	}

	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	public String getLabelCode() {
		return labelCode;
	}

	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public List<String> getForeignClasses() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
