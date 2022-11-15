package com.torino.gestionecorsi.architecture.dao;

public interface DAOConstants {

	/* ---------- Admin */
	String SELECT_REPORT = "select * from report";
	String SELECT_CORSOCORSISTA = "select * from corso_corsista";
	String SELECT_CORSO = "select * from corso";
	String DELETE_CORSO = "delete from corso where codcorso = ?";
	String SELECT_CORSO_BY_ID = "select * from corso where codcorso = ?";
	String SELECT_CORSISTA = "select * from corsista";
	String SELECT_CORSISTA_GETBYCOD = "select * from corsista where codcorsista = ?";
	/* ---------- Sequence */
	String SELECT_CORSOSEQ = "select corso_seq.nextval from dual";
}
