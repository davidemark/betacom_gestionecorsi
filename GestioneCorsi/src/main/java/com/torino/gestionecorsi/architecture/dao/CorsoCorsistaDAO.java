package com.torino.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.torino.gestionecorsi.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO implements GenericDAO<CorsoCorsista>, DAOConstants{
	public static CorsoCorsistaDAO getFactory() throws DAOException {
		return new CorsoCorsistaDAO();
	}

	private CachedRowSet rowSet;
	
	private CorsoCorsistaDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	

	@Override
	public void create(Connection conn, CorsoCorsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSOCORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorso());
			rowSet.updateLong(2, entity.getCodCorsista());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
			
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public void delete(Connection conn, CorsoCorsista entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CorsoCorsista getByCod(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
