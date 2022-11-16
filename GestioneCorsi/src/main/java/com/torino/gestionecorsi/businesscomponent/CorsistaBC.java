package com.torino.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.torino.gestionecorsi.architecture.dao.CorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.DAOException;

import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;


public class CorsistaBC {
	private Connection conn;
	
	public CorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn=DBAccess.getConnection();
		
	}
	
	public void create(Corsista corsista) throws DAOException {
		CorsistaDAO.getFactory().create(conn,corsista);
	}
	
	public Corsista getByCod(long cod) throws DAOException {
		return CorsistaDAO.getFactory().getByCod(conn, cod);
	}
	
	
}
