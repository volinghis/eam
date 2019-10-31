package com.ehs.eam.eamPartLibrary.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ehs.common.base.config.DataConfig;

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
@Table(name = "EAM_PART_LIBRARY",uniqueConstraints = @UniqueConstraint(columnNames = DataConfig.TABLE_UNIQUE_KEY))
public class EamPartLibrary extends com.ehs.eam.eamPartLibrary.entity.entitysuper.EamPartLibrary {

	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;
	
}
