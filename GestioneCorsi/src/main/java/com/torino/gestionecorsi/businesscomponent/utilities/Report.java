package com.torino.gestionecorsi.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.torino.gestionecorsi.architecture.dao.CorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.CorsoCorsistaDAO;
import com.torino.gestionecorsi.architecture.dao.CorsoDAO;
import com.torino.gestionecorsi.architecture.dao.DAOConstants;
import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.architecture.dao.DocenteDAO;
import com.torino.gestionecorsi.architecture.dbaccess.DBAccess;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;
import com.torino.gestionecorsi.businesscomponent.model.Docente;

public class Report implements DAOConstants{
	public static Report getFactory() throws ClassNotFoundException, DAOException, IOException {
		return new Report();
	}

	Connection conn;
	Map<Long, Integer> mappaDocenti;
	
	private Report() throws ClassNotFoundException, DAOException, IOException {
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

			ResultSet rs = stmt.executeQuery(SELECT_ULTIMA_DATA);
			
			
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

			ResultSet rs = stmt.executeQuery(SELECT_DURATA_MEDIA);
			
			
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
		//select count(commenti) from corso;
	public int getCommenti() throws DAOException {
		int commenti = 0;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_COMMENTI);
			
			
			rs.beforeFirst();
			rs.next();
			commenti = (int)rs.getInt(1);
			rs.next();
			rs.close();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return commenti;
	}
	
	//elenco di corsisti
	public Corsista[] getCorsisti() throws DAOException {
		return CorsistaDAO.getFactory().getAll(conn);
	}
	
	//docente con più tipologie di corso
	public Docente getDocentePopolare() throws DAOException {
		Corso[]corsi = CorsoDAO.getFactory().getAll(conn);
		/*for(Corso c : corsi)
			System.out.println(c.toString());*/
		//System.out.println();
		mappaDocenti = new HashMap<Long, Integer>();
		for(Corso c:corsi) {
			//System.out.println(c.toString());
			aggiungi(mappaDocenti, c.getCoddocente());
			
		}
		int crsiTenuti = 0;
		Docente docentePop = null;
		Docente[] docenti = DocenteDAO.getFactory().getAll(conn);
		//Set<Long> s = mappaDocenti.keySet();
		//System.out.println("mappa");
		//for(Long l:s)
			//System.out.println(l);
		for(Docente d : docenti) {
			if(mappaDocenti.containsKey(d.getCoddcocente()) && mappaDocenti.get(d.getCoddcocente())>crsiTenuti ) {
				crsiTenuti = (int)( mappaDocenti.get(d.getCoddcocente()));
				//System.out.println();
				docentePop = d;
			}
		}
		return docentePop;
		
	}
	
	private void aggiungi(Map<Long, Integer> mappaDocenti2, long coddocente) throws DAOException {
		//Docente d = DocenteDAO.getFactory().getByCod(conn, coddocente);
		//System.out.println(d.toString());
		if(mappaDocenti2.containsKey(coddocente)) {
			int contatore = mappaDocenti2.get(coddocente);
			mappaDocenti2.put(coddocente, new Integer(contatore+1));
		}else {
			mappaDocenti2.put(coddocente, new Integer(1));
		}
	}
	/*input type ... name="<%=codcorso%>" value="<%=codcorso%>";
	setParameter("2",2);*/
	

	//corsi con posti disponibili
	public List<Corso> getCorsiDisponibili () throws DAOException{
		List<Corso> corsiDisponibili = new LinkedList<Corso>();
		Corso[] corsi = CorsoDAO.getFactory().getAll(conn);
		for(Corso c:corsi) {
			/*Corsista[] cor=CorsoCorsistaDAO.getFactory().getAllByCorso(conn, c);*/
			if(/*cor.length <12*/disponibile(c)) {
				corsiDisponibili.add(c);
			}
		}
		return corsiDisponibili;
	}
	
	public boolean disponibile(Corso c) throws DAOException {
		Corsista[] cor = CorsoCorsistaDAO.getFactory().getAllByCorso(conn, c);
		return cor.length<12;
	}

	public void closeConnection() throws DAOException {
		DBAccess.closeConnection();
	}
	
}
