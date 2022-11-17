package com.torino.gestionecorsi.businesscomponent.facade;

import java.io.IOException;

import com.torino.gestionecorsi.architecture.dao.DAOException;
import com.torino.gestionecorsi.businesscomponent.CorsistaBC;
import com.torino.gestionecorsi.businesscomponent.CorsoBC;
import com.torino.gestionecorsi.businesscomponent.CorsoCorsistaBC;
import com.torino.gestionecorsi.businesscomponent.DocenteBC;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;
import com.torino.gestionecorsi.businesscomponent.model.CorsoCorsista;
import com.torino.gestionecorsi.businesscomponent.model.Docente;

public class AdminFacade {
	private static AdminFacade aF;
	private CorsoBC coBC;
	private CorsistaBC caBC;
	private DocenteBC dBC;
	private CorsoCorsistaBC ccBC;

	private AdminFacade() {
	}

	public static AdminFacade getInstance() {
		if (aF == null) {
			aF = new AdminFacade();
		}
		return aF;
	}

	// corsisti
	public Corsista[] getCorsisti() throws ClassNotFoundException, DAOException, IOException {
		caBC = new CorsistaBC();
		return caBC.getAll();
	}

	public Corsista findCorsistaByCod(long cod) throws ClassNotFoundException, DAOException, IOException {
		caBC = new CorsistaBC();
		return caBC.getByCod(cod);
	}

	public void create(Corsista corsista) throws ClassNotFoundException, DAOException, IOException {
		caBC = new CorsistaBC();
		caBC.create(corsista);
	}

	// corsi
	public void delete(Corso corso) throws ClassNotFoundException, DAOException, IOException {
		coBC = new CorsoBC();
		coBC.delete(corso);
	}

	public Corso[] getCorsi() throws ClassNotFoundException, DAOException, IOException {
		coBC = new CorsoBC();
		return coBC.getCorsi();
	}

	public Corso findCorsoByCod(long cod) throws ClassNotFoundException, DAOException, IOException {
		coBC = new CorsoBC();
		return coBC.findByCod(cod);
	}

	// docente
	public Docente[] getDocenti() throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		return dBC.getDocenti();
	}

	public Docente findDocenteByCod(long cod) throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		return dBC.findByCod(cod);
	}

	// corso_corsista
	public void create(CorsoCorsista corcorsista) throws ClassNotFoundException, DAOException, IOException {
		ccBC = new CorsoCorsistaBC();
		ccBC.create(corcorsista);
	}

	public Corso[] getCorsiByCorsista(Corsista corsista) throws ClassNotFoundException, DAOException, IOException {
		ccBC = new CorsoCorsistaBC();
		return ccBC.getCorsiByCorsista(corsista);
	}

	public Corsista[] getCorsistiByCorsi(Corso corso) throws ClassNotFoundException, DAOException, IOException {
		ccBC = new CorsoCorsistaBC();
		return ccBC.getCorsistiByCorso(corso);
	}

}
