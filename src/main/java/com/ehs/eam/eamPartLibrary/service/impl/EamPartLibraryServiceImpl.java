package com.ehs.eam.eamPartLibrary.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ehs.common.base.service.BaseCommonService;
import com.ehs.common.oper.bean.PageInfoBean;
import com.ehs.eam.eamPartLibrary.dao.EamPartLibraryDao;
import com.ehs.eam.eamPartLibrary.entity.EamPartLibrary;
import com.ehs.eam.eamPartLibrary.entity.EamPartLibraryQueryBean;
import com.ehs.eam.eamPartLibrary.service.EamPartLibraryService;

/**   
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: EamPartLibraryServiceImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: zhaol
* @date: 2019年10月28日 上午10:09:18 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月28日     zhaol           v1.0.0               修改原因
*/
@Service
public class EamPartLibraryServiceImpl implements EamPartLibraryService {
	
	@Resource
	private EamPartLibraryDao eamPartLibraryDao;
	
	@Resource
	private BaseCommonService baseCommonService;

	@Override
	@Transactional
	public EamPartLibrary saveOrUpdateEamPart(EamPartLibrary eamPartLibrary) {
		// TODO Auto-generated method stub
		try {
			return baseCommonService.saveOrUpdate(eamPartLibrary);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageInfoBean findEamPartLibraryAll(EamPartLibraryQueryBean queryBean) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(queryBean.getPage()-1, queryBean.getSize());
		Page<EamPartLibrary> eamParts = eamPartLibraryDao.findEamPart(queryBean.getQuery(), pageRequest);
		if (eamParts!=null) {
			PageInfoBean pb=new PageInfoBean();
			pb.setDataList(eamParts.getContent());
			pb.setTotalCount(eamParts.getTotalElements());
			return pb;
		}
		return null;
	}
}
