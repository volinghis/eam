package com.ehs.eam.eamPartLibrary.service;

import com.ehs.common.oper.bean.PageInfoBean;
import com.ehs.eam.eamPartLibrary.entity.EamPartLibrary;
import com.ehs.eam.eamPartLibrary.entity.EamPartLibraryQueryBean;

public interface EamPartLibraryService {

	public EamPartLibrary saveOrUpdateEamPart(EamPartLibrary eamPartLibrary);
	
	public PageInfoBean findEamPartLibraryAll(EamPartLibraryQueryBean queryBean);

}
