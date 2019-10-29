package com.ehs.eam.eamPartLibrary.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ehs.common.base.config.DataConfig;
import com.ehs.common.base.entity.BaseEntity;
import com.ehs.eam.eamPartLibrary.entity.EamPartLibrary;

/**   
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: EamPartLibraryDao.java
* @Description: 查询、分页
*
* @version: v1.0.0
* @author: zhaol
* @date: 2019年10月28日 上午10:01:30 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月28日     zhaol           v1.0.0               修改原因
*/
@Repository
public interface EamPartLibraryDao extends JpaRepository<EamPartLibrary, String> {

	@Query(" select e from EamPartLibrary e where e."+BaseEntity.VERSION_ID+" = "+DataConfig.VERSION_EFFECTIVE+" and (e."+EamPartLibrary.DEVICE_CODE+" like %?1% or e."+EamPartLibrary.DEVICE_NAME+" like %?1% ) order by "+BaseEntity.CREATION_TIME+" desc")
	public Page<EamPartLibrary> findEamPart(String query, Pageable pageable);
	
}
