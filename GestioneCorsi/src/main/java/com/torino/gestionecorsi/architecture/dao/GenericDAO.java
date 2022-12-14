package com.torino.gestionecorsi.architecture.dao;

import java.sql.Connection;

public interface GenericDAO<T> {
	void create(Connection conn, T entity) throws DAOException;

	void delete(Connection conn, T entity) throws DAOException;

	T getByCod(Connection conn, long id) throws DAOException;

	T[] getAll(Connection conn) throws DAOException;
}
