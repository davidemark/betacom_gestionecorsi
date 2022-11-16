package com.torino.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.torino.gestionecorsi.architecture.dao.CorsoDAO;
import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.model.Corso;

public class CorsoBC {
	private Connection conn;

	public CorsoBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void delete(Corso corso) throws DAOException {
		CorsoDAO.getFactory().delete(conn, corso);
	}

	public Corso findByCod(long cod) throws DAOException {
		return CorsoDAO.getFactory().getByCod(conn, cod);
	}

	public Corso[] getCorsi() throws DAOException {
		return CorsoDAO.getFactory().getAll(conn);
	}

}
