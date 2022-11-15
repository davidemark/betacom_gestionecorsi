package com.torino.gestionecorsi.architecture.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.torino.gestionecorsi.businesscomponent.model.Corsista;




public class CorsistaDAO implements GenericDAO<Corsista>, DAOConstants {
	 public static CorsistaDAO getFactory() throws DAOException {
			return new CorsistaDAO();
		}

	private CachedRowSet rowSet;

	 private CorsistaDAO() throws DAOException {
	  try {
	   rowSet = RowSetProvider.newFactory().createCachedRowSet();
	  } catch (SQLException sql) {
	   throw new DAOException(sql);
	  }
	 }

	 @Override
	 public void create(Connection conn, Corsista entity) throws DAOException {
	  try {
	   rowSet.setCommand(SELECT_CORSISTA);
	   rowSet.execute(conn);
	   rowSet.moveToInsertRow();
	   rowSet.updateLong(1, entity.getCodcorsista());
	   rowSet.updateString(2, entity.getNome());
	   rowSet.updateString(3, entity.getCognome());
	   rowSet.updateInt(4, entity.isPrecedentiformativi()?1:0 );
	  
	   rowSet.insertRow();
	   rowSet.moveToCurrentRow();
	   rowSet.acceptChanges();
	  } catch (SQLException sql) {
	   throw new DAOException(sql);
	  }
	 }

	

	@Override
	public void delete(Connection conn, Corsista entity) throws DAOException {
		
		
	}

	@Override
	public Corsista getByCod(Connection conn, long cod) throws DAOException {
		Corsista corsista = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_GETBYCOD);
			ps.setLong(1, cod);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				corsista = new Corsista();
				
				corsista.setCodcorsista(rs.getLong(1));
				corsista.setNome(rs.getString(2));
				corsista.setCognome(rs.getString(3));
				corsista.setPrecedentiformativi(rs.getInt(4)==1);
				
			}
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	
	}

	@Override
	public Corsista[] getAll(Connection conn) throws DAOException {
	
		Corsista[]corsisti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);
			rs.last();
			corsisti = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for(int i =0;rs.next();i++) {
				Corsista a = new Corsista();
				a.setCodcorsista(rs.getLong(1));
				a.setNome(rs.getString(2));
				a.setCognome(rs.getString(3));
				a.setPrecedentiformativi(rs.getInt(4)==1);
				
				corsisti[i]=a;
			}
			rs.close();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}

		
	 }
 





