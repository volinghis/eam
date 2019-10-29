package com.ehs.eam.eamPartLibrary.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehs.common.base.service.BaseCommonService;
import com.ehs.common.base.utils.JsonUtils;
import com.ehs.common.oper.bean.PageInfoBean;
import com.ehs.common.oper.bean.ResultBean;
import com.ehs.eam.eamPartLibrary.entity.EamPartLibrary;
import com.ehs.eam.eamPartLibrary.entity.EamPartLibraryQueryBean;
import com.ehs.eam.eamPartLibrary.service.EamPartLibraryService;

/**   
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: EamPartLibraryController.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: zhaol
* @date: 2019年10月28日 上午10:00:54 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月28日     zhaol           v1.0.0               修改原因
*/
@Controller
public class EamPartLibraryController {

	private static final Logger logger = LoggerFactory.getLogger(EamPartLibraryController.class);
	@Resource
	private BaseCommonService baseCommonService;
	
	@Resource
	private EamPartLibraryService eamPartLibraryService;
	
	/**
	 * 
	* @Function: EamPartLibraryController.java
	* @Description: 添加
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: zhaol
	* @date: 2019年10月28日 下午2:24:59 
	*
	* Modification History:
	* Date         Author          Version    Description
	*---------------------------------------------------------*
	* 2019年10月28日     zhaol           v1.0.0               修改原因
	 */
	@RequestMapping(value = "/eam/eamPartLibrary/saveEamPartLibrary")
	@ResponseBody
	public String saveEamPartLibrary(@RequestBody EamPartLibrary eamPartLibrary, HttpServletRequest request,HttpServletResponse response) {
		logger.info("===========进入saveEamPartLibrary方法=============");
		ResultBean resultBean=new ResultBean();
		List<EamPartLibrary> eLibraries = (List<EamPartLibrary>)baseCommonService.findAll(EamPartLibrary.class);
		if(eLibraries !=null && eLibraries.size() > 0) {
			long c=eLibraries.stream().filter(s->StringUtils.equals(s.getDeviceCode(),eamPartLibrary.getDeviceCode()) && !StringUtils.equals(s.getKey(), eamPartLibrary.getKey())).count();
			if(c>0) {
				return JsonUtils.toJsonString(resultBean.error("保存数据失败:已存在相同编号"));
			}
		}
		if (eamPartLibrary != null) {
			System.out.println("warehouse================="+eamPartLibrary.getWarehouse());
			EamPartLibrary eLibrary= eamPartLibraryService.saveOrUpdateEamPart(eamPartLibrary);
			logger.info("===========退出saveEamPartLibrary方法=============");
			return JsonUtils.toJsonString(resultBean.ok("保存成功！",eLibrary.getKey()));
		}
		return JsonUtils.toJsonString(resultBean.error("保存数据失败"));
	}
	
	/**
	 * 
	* @Function: EamPartLibraryController.java
	* @Description: 查询
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: zhaol
	* @date: 2019年10月28日 下午2:24:34 
	*
	* Modification History:
	* Date         Author          Version     Description
	*---------------------------------------------------------*
	* 2019年10月28日     zhaol           v1.0.0               修改原因
	 */
	@RequestMapping(value = "/eam/eamPartLibrary/getEamPartLibraryList")
	@ResponseBody
	public String getEamPartLibraryList(@RequestBody EamPartLibraryQueryBean queryBean,HttpServletRequest request,HttpServletResponse response) {
		logger.info("===========进入getEamPartLibraryList方法=============");
		PageInfoBean pb = eamPartLibraryService.findEamPartLibraryAll(queryBean);
		System.out.println("pb==============="+JsonUtils.toJsonString(pb));
		return (pb==null?"[]":JsonUtils.toJsonString(pb));
	}
	/**
	 * 
	* @Function: EamPartLibraryController.java
	* @Description: 编辑
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: zhaol
	* @date: 2019年10月28日 下午2:24:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2019年10月28日     zhaol           v1.0.0              	修改原因
	 */
	@RequestMapping(value = "/eam/eamPartLibrary/getEamPartLibrary")
	@ResponseBody
	public String getEamPartLibrary(HttpServletRequest request,HttpServletResponse response) {
		logger.info("===========进入getEamPartLibrary方法=============");
		String key=request.getParameter("key");
		EamPartLibrary eamPartLibrary= baseCommonService.findByKey(EamPartLibrary.class, key);
		return eamPartLibrary==null?"{}":JsonUtils.toJsonString(eamPartLibrary);
	}
	
	/**
	 * 
	* @Function: EamPartLibraryController.java
	* @Description: 删除
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: zhaol
	* @date: 2019年10月28日 下午2:24:21 
	*
	* Modification History:
	* Date         Author          Version      Description
	*---------------------------------------------------------*
	* 2019年10月28日     zhaol           v1.0.0                    修改原因
	 */
	@RequestMapping(value = "/eam/eamPartLibrary/deleteEamPartLibrary")
	@ResponseBody
	public String deleteEamPartLibrary(HttpServletRequest request,HttpServletResponse response) {
		logger.info("===========进入deleteEamPartLibrary方法=============");
		ResultBean resultBean=new ResultBean();
		String key=request.getParameter("key");
		baseCommonService.deleteByKey(EamPartLibrary.class, key);
		return JsonUtils.toJsonString(resultBean.ok("删除备件成功！"));
	}
}
