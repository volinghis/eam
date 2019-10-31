package com.ehs.eam.eamPartLibrary.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ehs.eam.eamPartLibrary.entity.entitysuper.EamPartLibrary;

@Entity
@Table(name = "EAM_PART_LIBRARY_HIS")
public class EamPartLibraryHis extends EamPartLibrary {

	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;

}
