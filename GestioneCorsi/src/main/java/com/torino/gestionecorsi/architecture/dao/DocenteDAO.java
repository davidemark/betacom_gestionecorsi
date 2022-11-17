package com.torino.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.torino.gestionecorsi.businesscomponent.model.Docente;

public class DocenteDAO implements GenericDAO<Docente>, DAOConstants {

	private CachedRowSet rowSet;

	public static DocenteDAO getFactory() throws DAOException {
		return new DocenteDAO();
	}

	private DocenteDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, Docente entity) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection conn, Docente entity) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Docente getByCod(Connection conn, long cod) throws DAOException {
		Docente docente = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_GET_BY_COD);
			ps.setLong(1, cod);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				docente = new Docente();

				docente.setCoddcocente(rs.getLong(1));
				docente.setNome(rs.getString(2));
				docente.setCognome(rs.getString(3));
				docente.setCvdocente(rs.getString(4));

			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docente;
	}

	@Override
	public Docente[] getAll(Connection conn) throws DAOException {
		Docente[] docenti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE);
			rs.last();
			docenti = new Docente[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Docente d = new Docente();
				d.setCoddcocente(rs.getLong(1));
				d.setNome(rs.getString(2));
				d.setCognome(rs.getString(3));
				d.setCvdocente(rs.getString(4));

				docenti[i] = d;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docenti;
	}

}
