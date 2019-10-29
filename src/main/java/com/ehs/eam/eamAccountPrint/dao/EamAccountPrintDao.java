/**   
 * Copyright © 2019 西安东恒鑫源软件开发有限公司版权所有.
 * 
 * 功能描述：
 * @Package: com.ehs.eam.eamAccountPrint.dao 
 * @author: qjj   
 * @date: 2019年10月28日 上午9:55:54 
 */
package com.ehs.eam.eamAccountPrint.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ehs.common.base.config.DataConfig;
import com.ehs.common.base.entity.BaseEntity;
import com.ehs.eam.eamAccountPrint.entity.EamAccountPrint;

/**   
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: EamAccountPrintDao.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: qjj
* @date: 2019年10月28日 上午9:55:54 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月28日     qjj           v1.0.0               修改原因
*/
@Repository
public interface EamAccountPrintDao  extends JpaRepository<EamAccountPrint, String>,JpaSpecificationExecutor<EamAccountPrint>{
	
	@Query(" select ep from EamAccountPrint ep where ep."+BaseEntity.VERSION_ID+" = "+DataConfig.VERSION_EFFECTIVE+" and ep."+EamAccountPrint.DEVICE_NUM+" like %?1%  order by "+BaseEntity.CREATION_TIME+" desc")
	public Page<EamAccountPrint> findEamAccountPrint(String query,Pageable pageable);

}
