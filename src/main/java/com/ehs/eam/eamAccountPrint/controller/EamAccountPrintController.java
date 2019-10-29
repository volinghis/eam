/**   
 * Copyright © 2019 西安东恒鑫源软件开发有限公司版权所有.
 * 
 * 功能描述：
 * @Package: com.ehs.eam.controller 
 * @author: qjj   
 * @date: 2019年10月25日 下午4:43:35 
 */
package com.ehs.eam.eamAccountPrint.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehs.common.auth.entity.SysRole;
import com.ehs.common.base.service.BaseCommonService;
import com.ehs.common.base.utils.JsonUtils;
import com.ehs.common.oper.bean.PageInfoBean;
import com.ehs.common.oper.bean.ResultBean;
import com.ehs.eam.eamAccountPrint.bean.AccountPrintQueryBean;
import com.ehs.eam.eamAccountPrint.entity.EamAccountPrint;
import com.ehs.eam.eamAccountPrint.service.EamAccountPrintService;

/**
 * Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
 * 
 * @ClassName: EamAccountPrintController.java
 * @Description: 设备台账控制类
 *
 * @version: v1.0.0
 * @author: qjj
 * @date: 2019年10月25日 下午4:43:35
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019年10月25日
 *        qjj v1.0.0 修改原因
 */
@RestController
@RequestMapping("/eam/eamAccountPrint")
public class EamAccountPrintController {

	@Resource
	private EamAccountPrintService eamAccountPrintService;
	
	@Resource
	private BaseCommonService baseCommonService;
	
	
	/**
	 * 
	* @Function:getEamAccountPrintList 
	* @Description: 获取台账数据集合
	* @param querybean
	* @return
	* @throws：异常描述
	* @version: v1.0.0
	* @author: qjj
	* @date: 2019年10月28日 上午11:39:31 
	*
	* Modification History:
	* Date        Author        Version      Description
	*---------------------------------------------------------*
	* 2019年10月28日     qjj        v1.0.0            修改原因
	 */
	@RequestMapping(value = "/getEamAccountPrintList")
	public String getEamAccountPrintList(@RequestBody AccountPrintQueryBean querybean) {
		PageInfoBean pageBean = eamAccountPrintService.findEamAccountPrintList(querybean);
		return pageBean==null?"[]":JsonUtils.toJsonString(pageBean);
	}
	
	/**
	 * 
	* @Function:saveEamAccountPrint 
	* @Description: 设备台账保存
	* @param eamAccountPrint
	* @return
	* @throws：异常描述
	* @version: v1.0.0
	* @author: qjj
	* @date: 2019年10月28日 下午1:45:32 
	*
	* Modification History:
	* Date        Author        Version      Description
	*---------------------------------------------------------*
	* 2019年10月28日     qjj        v1.0.0            修改原因
	 */
	@RequestMapping(value = "/saveEamAccountPrint")
	public String saveEamAccountPrint(@RequestBody EamAccountPrint eamAccountPrint) {
		System.out.println("=========="+JsonUtils.toJsonString(eamAccountPrint));
		ResultBean resultBean=new ResultBean();
		EamAccountPrint ep=	baseCommonService.saveOrUpdate(eamAccountPrint);
		return JsonUtils.toJsonString(resultBean.ok("保存成功",ep.getKey()));
	}

	
	/**
	 * 
	* @Function:getEamAccountPrintInfo 
	* @Description: 获取当前设备台账信息
	* @param key
	* @return
	* @throws：异常描述
	* @version: v1.0.0
	* @author: qjj
	* @date: 2019年10月28日 下午4:38:09 
	*
	* Modification History:
	* Date        Author        Version      Description
	*---------------------------------------------------------*
	* 2019年10月28日     qjj        v1.0.0            修改原因
	 */
	@RequestMapping(value = "/getAccountPrintInfo")
	public String getEamAccountPrintInfo(String key) {
	     EamAccountPrint ep=baseCommonService.findByKey(EamAccountPrint.class, key);
		 return ep==null?"{}":JsonUtils.toJsonString(ep);
	}
	
	@RequestMapping(value = "/deleteAccountPrintInfo")
	public String deleteAccountPrintInfo(String key) {
		ResultBean resultBean=new ResultBean();
	    baseCommonService.deleteByKey(EamAccountPrint.class, key);
		return JsonUtils.toJsonString(resultBean.ok("删除成功"));
	}
	
}



