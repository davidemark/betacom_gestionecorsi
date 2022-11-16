package com.torino.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.torino.gestionecorsi.architecture.dao.CorsoCorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.DAOException;

import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.model.CorsoCorsista;


public class CorsoCorsistaBC {
private Connection conn;
	
	public CorsoCorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn=DBAccess.getConnection();
		
	}
	
	public void create(CorsoCorsista oa) throws DAOException {
		CorsoCorsistaDAO.getFactory().create(conn, oa);
	}
}
