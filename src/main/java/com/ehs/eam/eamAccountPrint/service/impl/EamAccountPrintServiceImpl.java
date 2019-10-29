/**   
 * Copyright © 2019 西安东恒鑫源软件开发有限公司版权所有.
 * 
 * 功能描述：
 * @Package: eam.eamAccountPrint.service.impl 
 * @author: qjj   
 * @date: 2019年10月25日 下午2:25:26 
 */
package com.ehs.eam.eamAccountPrint.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ehs.common.oper.bean.PageInfoBean;
import com.ehs.eam.eamAccountPrint.bean.AccountPrintQueryBean;
import com.ehs.eam.eamAccountPrint.dao.EamAccountPrintDao;
import com.ehs.eam.eamAccountPrint.entity.EamAccountPrint;
import com.ehs.eam.eamAccountPrint.service.EamAccountPrintService;

/**   
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: EamAccountPrintImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: qjj
* @date: 2019年10月25日 下午2:25:26 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月25日     qjj           v1.0.0               修改原因
*/
@Service
public class EamAccountPrintServiceImpl implements EamAccountPrintService {

	@Resource
	private EamAccountPrintDao accountPrintDao;
	
	
	/** 
	* @see com.ehs.eam.eamAccountPrint.service.EamAccountPrintService#findEamAccountPrintList(com.ehs.eam.eamAccountPrint.bean.EamAccountPrintQuery)  
	*/
	@Override
	public PageInfoBean findEamAccountPrintList(AccountPrintQueryBean querybean) {
		// TODO Auto-generated method stub
		PageRequest pageRequest =PageRequest.of(querybean.getPage()-1, querybean.getSize());
		Page<EamAccountPrint> accountPrintPage=	accountPrintDao.findEamAccountPrint(querybean.getQuery(), pageRequest);
//		Specification<EamAccountPrint> sp=null;
//		List<Predicate> ps=new ArrayList<Predicate>();
//		//多条件查询
//		sp=(Root<EamAccountPrint> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)->{
//        	if(StringUtils.isNotBlank(querybean.getQuery())){
//        		ps.add(criteriaBuilder.like(root.get(EamAccountPrint.DEVICE_NUM),"%"+querybean.getQuery()+"%" ));
//        	}
//        	return criteriaBuilder.and(ps.toArray(new Predicate[0]));
//        };
//       Page<EamAccountPrint> accountPrintPage= accountPrintDao.findAll(sp, pageRequest);
		if (accountPrintPage!=null) {
			PageInfoBean pg=new PageInfoBean();
			pg.setDataList(accountPrintPage.getContent());
			pg.setTotalCount(accountPrintPage.getTotalElements());
			return pg;
		}
		return null;
	}



}
