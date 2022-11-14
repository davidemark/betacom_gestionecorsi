package com.torino.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.torino.gestionecorsi.businesscomponent.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants {

	private CachedRowSet rowSet;
	
	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}

	private CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, Corso entity) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection conn, Corso entity) throws DAOException {
		

	}

	@Override
	public Corso getByCod(Connection conn, long id) throws DAOException {
		
		return null;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		
		return null;
	}

}
