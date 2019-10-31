/**   
 * Copyright © 2019 西安东恒鑫源软件开发有限公司版权所有.
 * 
 * 功能描述：
 * @Package: com.ehs.eam.eamAccountPrint.entity 
 * @author: qjj   
 * @date: 2019年10月31日 下午2:04:32 
 */
package com.ehs.eam.eamAccountPrint.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ehs.eam.eamAccountPrint.entity.entitySuper.EamAccountPrint;

/**   
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: EamAccountPrintHis.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: qjj
* @date: 2019年10月31日 下午2:04:32 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月31日     qjj           v1.0.0               修改原因
*/
@Entity
@Table(name = "EAM_ACCOUNT_PRINT_HIS")
public class EamAccountPrintHis extends EamAccountPrint {

	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;

}
