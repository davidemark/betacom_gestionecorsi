package com.torino.gestionecorsi.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.torino.gestionecorsi.architecture.dao.DAOConstants;
import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;

public class Login implements DAOConstants{
	private Connection conn;
	
	public Login() throws ClassNotFoundException, DAOException, IOException {
		conn=DBAccess.getConnection();
	}
	
	public String getCodAdmin(String nomeadmin, String cognome) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_CODADMIN);
			//Select codadmin from amministratore where nomeadmin = ? and cognome = ?
			ps.setString(1, nomeadmin);
			ps.setString(2, cognome);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			return null;
		}catch(SQLException s) {
			throw new DAOException(s);
		}
	}
}
