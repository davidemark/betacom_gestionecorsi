package com.torino.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;



import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;
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
	
	public Corsista[] getAllByCorso(Connection conn, Corso corso) throws DAOException{
		Corsista[] corcor = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSOCORSISTA_BYCORSO,
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			//select codcorsista from corso_corsista where codcorso=?
			ps.setLong(1, corso.getCodcorso());
			ResultSet rs = ps.executeQuery();
			rs.last();
			corcor = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for(int i =0;rs.next();i++) {
				Corsista c = new Corsista();
				long cod = rs.getLong(1);
				c = CorsistaDAO.getFactory().getByCod(conn, cod);
				corcor[i]=c;
			}
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corcor;
	}
	public Corso[] getAllByCorsista(Connection conn, Corsista corsista) throws DAOException{
		Corso[] corcor = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSOCORSISTA_BYCORSISTA,
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			//select codcorso from corso_corsista where codcorsista=?
			ps.setLong(1, corsista.getCodcorsista());
			ResultSet rs = ps.executeQuery();
			rs.last();
			corcor = new Corso[rs.getRow()];
			rs.beforeFirst();
			for(int i =0;rs.next();i++) {
				Corso c = new Corso();
				long cod = rs.getLong(1);
				c = CorsoDAO.getFactory().getByCod(conn, cod);
				corcor[i]=c;
			}
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corcor;
	}
}
