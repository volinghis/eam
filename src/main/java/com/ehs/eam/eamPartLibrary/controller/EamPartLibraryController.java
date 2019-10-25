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
import com.ehs.common.oper.bean.ResultBean;
import com.ehs.eam.eamPartLibrary.entity.EamPartLibrary;
import com.ehs.eam.eamPartLibrary.service.EamPartLibraryService;

@Controller
public class EamPartLibraryController {

	private static final Logger logger = LoggerFactory.getLogger(EamPartLibraryController.class);
	@Resource
	private BaseCommonService baseCommonService;
	
	private EamPartLibraryService eamPartLibraryService;
	
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
		EamPartLibrary eLibrary= eamPartLibraryService.saveOrUpdateUser(eamPartLibrary);
		logger.info("===========退出saveEamPartLibrary方法=============");
		return JsonUtils.toJsonString(resultBean.ok("保存成功！",eLibrary.getKey()));
	}
}
