package com.torino.gestionecorsi.architecture.dao;

public interface DAOConstants {

	/* ---------- Admin */
	String SELECT_REPORT = "select * from report";
	
	/* ---------- Sequence */
	String SELECT_CORSOSEQ = "select corso_seq.nextval from dual";
}
