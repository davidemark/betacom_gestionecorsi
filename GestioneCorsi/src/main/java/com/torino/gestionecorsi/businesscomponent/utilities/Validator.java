package com.torino.gestionecorsi.businesscomponent.utilities;

import java.util.Date;

import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;

public class Validator {
	
	public static Validator getFactory() {
		return new Validator();
	}

	private Validator() {
		
	}
	
	public boolean validate(Corsista corsista) {
		boolean flag = true;
		if(flag) {
			String nome = corsista.getNome();
			flag = nome.length()<=30 &&nome.length() >0&& nome!=null;
			char[]caratt = nome.toCharArray();
			for(int i = 0; i<caratt.length && flag; i++)
				flag = Character.isDigit(caratt[i])?false:true;
		}
		if(flag) {
			String cognome = corsista.getCognome();
			flag = cognome.length()<=30 &&cognome.length() >0&& cognome!=null;
			char[]caratt = cognome.toCharArray();
			for(int i = 0; i<caratt.length && flag; i++)
				flag = Character.isDigit(caratt[i])?false:true;
		}
		return flag;
	}
	
	public boolean validate(Corso corso) {
		boolean flag = true;
		if(flag) {
			String nome = corso.getNome();
			flag = nome.length()<=30;
			char[]caratt = nome.toCharArray();
			for(int i = 0; i<caratt.length && flag; i++)
				flag = Character.isDigit(caratt[i])?false:true;
		}
		if(flag) {
			if(corso.getCommento()!=null)
				flag = corso.getCommento().length()<=200;
		}
		if(flag)
			flag = corso.getAula().length()<30;
		if(flag)
			flag = !(corso.getDataInizio().equals(corso.getDataFine()));
		if(flag) {
			Date oggi = new Date();
			flag = corso.getDataFine().getTime()>oggi.getTime();
		}
		return flag;
	}
	
	
}
