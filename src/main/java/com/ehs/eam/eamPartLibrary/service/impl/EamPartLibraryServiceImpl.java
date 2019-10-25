package com.ehs.eam.eamPartLibrary.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ehs.common.base.service.BaseCommonService;
import com.ehs.eam.eamPartLibrary.entity.EamPartLibrary;
import com.ehs.eam.eamPartLibrary.service.EamPartLibraryService;

@Service
public class EamPartLibraryServiceImpl implements EamPartLibraryService {
	
	@Resource
	private BaseCommonService baseCommonService;

	@Override
	@Transactional
	public EamPartLibrary saveOrUpdateUser(EamPartLibrary eamPartLibrary) {
		// TODO Auto-generated method stub
		try {
			return baseCommonService.saveOrUpdate(eamPartLibrary);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
