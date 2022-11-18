package com.torino.gestionecorsi.architecture.dao;

public interface DAOConstants {

	/* ---------- Admin */
	String SELECT_REPORT = "select * from report";
	String SELECT_CORSOCORSISTA = "select * from corso_corsista";
	String SELECT_CORSO = "select * from corso";
	String DELETE_CORSO = "delete from corso where codcorso = ?";
	String SELECT_CORSO_BY_ID = "select * from corso where codcorso = ?";
	String SELECT_CORSISTA = "select * from corsista";
	String SELECT_CORSISTA_GET_BY_COD = "select * from corsista where codcorsista = ?";
	String SELECT_CORSOCORSISTA_BYCORSO = "select codcorsista from corso_corsista where codcorso =?";
	String SELECT_CORSOCORSISTA_BYCORSISTA = "select codcorso from corso_corsista where codcorsista= ?";
	String SELECT_DOCENTE_GET_BY_COD = "select * from docente where coddocente = ?";
	String SELECT_DOCENTE = "select * from docente";
	String SELECT_CODADMIN = "Select codadmin from amministratore where nomeadmin = ? and cognome = ?";
	String SELECT_ULTIMA_DATA="select max(datainiziocorso) from corso";
	String SELECT_DURATA_MEDIA="select avg(datafinecorso-datainiziocorso) from corso";
	String SELECT_COMMENTI="select count(commenticorso) from corso";

	/* ---------- Sequence */
	String SELECT_CORSISTA_SEQ = "select corsista_seq.nextval from dual";
}
