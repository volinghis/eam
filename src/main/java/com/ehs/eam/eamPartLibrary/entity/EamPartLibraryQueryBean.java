package com.ehs.eam.eamPartLibrary.entity;

import com.ehs.common.oper.bean.PageBody;

/**   
* Copyright: Copyright (c) 2019 西安东恒鑫源软件开发有限公司
* @ClassName: EamPartLibraryQueryBean.java
* @Description: 备件查询实体类
*
* @version: v1.0.0
* @author: zhaol
* @date: 2019年10月28日 上午9:48:31 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月28日     zhaol           v1.0.0               修改原因
*/
public class EamPartLibraryQueryBean extends PageBody {
	
	private  String query;
	
	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}
	
}
