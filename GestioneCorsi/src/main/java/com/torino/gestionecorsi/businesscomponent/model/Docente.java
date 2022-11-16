package com.torino.gestionecorsi.businesscomponent.model;

public class Docente {
	private String nome;
	private String cognome;
	private String cvdocente;
	private long coddocente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCvdocente() {
		return cvdocente;
	}

	public void setCvdocente(String cvdocente) {
		this.cvdocente = cvdocente;
	}

	public long getCoddcocente() {
		return coddocente;
	}

	public void setCoddcocente(long coddcocente) {
		this.coddocente = coddcocente;
	}

}
