package com.torino.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.torino.gestionecorsi.architecture.dao.CorsoCorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.DAOException;

import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;
import com.torino.gestionecorsi.businesscomponent.model.CorsoCorsista;


public class CorsoCorsistaBC {
private Connection conn;
	
	public CorsoCorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn=DBAccess.getConnection();
		
	}
	
	public void create(CorsoCorsista oa) throws DAOException {
		CorsoCorsistaDAO.getFactory().create(conn, oa);
	}
	
	public Corso[] getCorsiByCorsista(Corsista corsista) throws DAOException {
		return CorsoCorsistaDAO.getFactory().getAllByCorsista(conn, corsista);
	}
	
	public Corsista[] getCorsistiByCorso(Corso corso) throws DAOException {
		return CorsoCorsistaDAO.getFactory().getAllByCorso(conn, corso);
	}
}
