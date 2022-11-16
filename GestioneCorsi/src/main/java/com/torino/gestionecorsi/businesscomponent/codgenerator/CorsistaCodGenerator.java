package com.torino.gestionecorsi.businesscomponent.codgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.torino.gestionecorsi.architecture.dao.DAOConstants;
import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;

public class CorsistaCodGenerator implements DAOConstants {
	private static CorsistaCodGenerator codGen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private CorsistaCodGenerator() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public static CorsistaCodGenerator getInstance() throws ClassNotFoundException, DAOException, IOException {
		if (codGen == null) {
			codGen = new CorsistaCodGenerator();
		}
		return codGen;
	}

	public long getNextCod() throws DAOException, IOException, ClassNotFoundException {
		long cod = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSISTA_SEQ);
			rs.next();
			cod = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return cod;
	}
	
}
