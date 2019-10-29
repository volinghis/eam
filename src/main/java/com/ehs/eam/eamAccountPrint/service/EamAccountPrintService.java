/**   
 * Copyright © 2019 西安东恒鑫源软件开发有限公司版权所有.
 * 
 * 功能描述：
 * @Package: eam.eamAccountPrint.service 
 * @author: qjj   
 * @date: 2019年10月25日 下午2:24:42 
 */
package com.ehs.eam.eamAccountPrint.service;

import org.springframework.stereotype.Service;

import com.ehs.common.oper.bean.PageInfoBean;
import com.ehs.eam.eamAccountPrint.bean.AccountPrintQueryBean;

/**   
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: EamAccountPrintService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: qjj
* @date: 2019年10月25日 下午2:24:42 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月25日     qjj           v1.0.0               修改原因
*/
public interface EamAccountPrintService {

	/**   
	* @Function:findEamAccountPrintList 
	* @Description: 该函数的功能描述
	* @param accountPrintQuery
	* @return
	* @throws：异常描述
	* @version: v1.0.0
	* @author: qjj
	* @date: 2019年10月28日 上午9:38:02 
	*
	* Modification History:
	* Date        Author        Version      Description
	*---------------------------------------------------------*
	* 2019年10月28日     qjj        v1.0.0            修改原因
	*/
 public	PageInfoBean findEamAccountPrintList(AccountPrintQueryBean accountPrintQuery);


}
