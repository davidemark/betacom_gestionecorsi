package com.torino.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, entity.getCodcorso());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corso getByCod(Connection conn, long cod) throws DAOException {
		Corso corso = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_BY_ID);
			ps.setLong(1, cod);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corso = new Corso();
				corso.setCodcorso(rs.getLong(1));
				corso.setNome(rs.getString(2));
				corso.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
				corso.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
				corso.setCosto(rs.getDouble(5));
				corso.setCommento(rs.getString(6));
				corso.setAula(rs.getString(7));
				corso.setCoddocente(rs.getLong(8));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		Corso[] corsi = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSO);
			rs.last();

			corsi = new Corso[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corso co = new Corso();
				co.setCodcorso(rs.getLong(1));
				co.setNome(rs.getString(2));
				co.setDataInizio(new java.util.Date(rs.getDate(3).getTime())); // rs.getDate() è in formato sql
				co.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
				co.setCosto(rs.getDouble(5));
				co.setCommento(rs.getString(6));
				co.setAula(rs.getString(7));
				co.setCoddocente(rs.getLong(8));
				corsi[i] = co;
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}

}
