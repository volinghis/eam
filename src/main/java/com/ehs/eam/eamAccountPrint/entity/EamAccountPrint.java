/**   
 * Copyright © 2019 西安东恒鑫源软件开发有限公司版权所有.
 * 
 * 功能描述：
 * @Package: eam.eamAccountPrint.entity 
 * @author: qjj   
 * @date: 2019年10月25日 上午11:27:15 
 */
package com.ehs.eam.eamAccountPrint.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ehs.common.base.config.DataConfig;

/**
 * 
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: EamAccountPrint.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: qjj
* @date: 2019年10月31日 下午2:13:42 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月31日     qjj           v1.0.0               修改原因
 */
@Entity
@Table(name = "EAM_ACCOUNT_PRINT",uniqueConstraints = @UniqueConstraint(columnNames = DataConfig.TABLE_UNIQUE_KEY))
public class EamAccountPrint extends com.ehs.eam.eamAccountPrint.entity.entitySuper.EamAccountPrint {

	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;

}
