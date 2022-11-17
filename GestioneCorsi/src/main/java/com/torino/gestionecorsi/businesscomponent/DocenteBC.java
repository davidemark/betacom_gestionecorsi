package com.torino.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.architecture.dao.DocenteDAO;
import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.model.Docente;

public class DocenteBC {
	private Connection conn;

	public DocenteBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public Docente findByCod(long cod) throws DAOException {
		return DocenteDAO.getFactory().getByCod(conn, cod);
	}

	public Docente[] getDocenti() throws DAOException {
		return DocenteDAO.getFactory().getAll(conn);
	}

}
