package com.torino.gestionecorsi.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.torino.gestionecorsi.architecture.dao.CorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.CorsoCorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.CorsoDAO;
import com.torino.gestionecorsi.architecture.dao.DAOConstants;
import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;

public class Report implements DAOConstants{
	Connection conn;
	
	public Report() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public int getNumeroCorsisti() throws DAOException {
		Corsista[] c =CorsistaDAO.getFactory().getAll(conn);
		return c.length;
	}
	
	//corso popolare
		//SE NON ABBIAMO UN CAMPO NELLA TABELLA corso CON GLI STUDENTI, NON POSSO INTERROGARE FACILMENTE IL DB, 
		//HO COMUNQUE BISOGNO DI USARE UN ALGORITMO PER TROVARE QUANTI CORSISTI HA OGNI CORSO PER TROVARE QUELLO CON PIU' CORSI
		//query
		//view
			//create view as
			//select nomecorso 
	public Corso getCorsoPopolare() throws DAOException {
		Corso corso = null;
		int studenti =0;
		Corso[]corsi=CorsoDAO.getFactory().getAll(conn);
		/*for(Corso c1 : corsi)
				System.out.println(c1.toString());*/
		for(Corso c : corsi) {
			int studC = CorsoCorsistaDAO.getFactory().getAllByCorso(conn, c).length;
			if( studC >studenti) {
				studenti=studC;
				corso = c;
			}
		}
		return corso;
	}
	
	//data inizio ultimo corso(non so se intende solo la data o se vuole anche il corso)
		//query
		/*
		 * select max(datainiziocorso) from corso; 
		 * */
	public Date getInizioUltimoCorso() throws DAOException {
		java.util.Date data = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(/*SELECT_ULTIMA_DATA*/"select max(datainiziocorso) from corso");
			
			
			rs.beforeFirst();
			rs.next();
			data = new java.util.Date(rs.getDate(1).getTime());
			rs.next();
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return data;
	}
	
	//data media corsi in giorni lavorativi (capire se intende saltando i festivi o se va bene in giorni)
		//query
		/*
		 * select avg(datafinecorso-datainiziocorso) from corso
		 * */
	public int getDurataMediaCorsi() throws DAOException {
		int durata = 0;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(/*SELECT_DURATA_MEDIA*/"select avg(datafinecorso-datainiziocorso) from corso");
			
			
			rs.beforeFirst();
			rs.next();
			durata = (int)rs.getInt(1);
			rs.next();
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return durata;
	}
	
	//numero di commenti presenti 
		//domanda massimo
	
	//elenco di corsisti
	public Corsista[] getCorsisti() throws DAOException {
		return CorsistaDAO.getFactory().getAll(conn);
	}
	
	//docente con più tipologie di corso
		//chiedere a massimo
	
	//corsi con posti disponibili
	public List<Corso> getCorsiDisponibili () throws DAOException{
		List<Corso> corsiDisponibili = new LinkedList<Corso>();
		Corso[] corsi = CorsoDAO.getFactory().getAll(conn);
		for(Corso c:corsi) {
			Corsista[] cor=CorsoCorsistaDAO.getFactory().getAllByCorso(conn, c);
			if(cor.length <12) {
				corsiDisponibili.add(c);
			}
		}
		return corsiDisponibili;
	}
	
	public void closeConnection() throws DAOException {
		DBAccess.closeConnection();
	}
	
}
