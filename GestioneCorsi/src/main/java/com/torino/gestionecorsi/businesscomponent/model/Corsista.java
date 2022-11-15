package com.torino.gestionecorsi.businesscomponent.model;

public class Corsista {
	private String nome;
	private String cognome;
	private boolean precedentiformativi;
	private long codcorsista;
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
	public boolean isPrecedentiformativi() {
		return precedentiformativi;
	}
	public void setPrecedentiformativi(boolean precedentiformativi) {
		this.precedentiformativi = precedentiformativi;
	}
	public long getCodcorsista() {
		return codcorsista;
	}
	public void setCodcorsista(long codcorsista) {
		this.codcorsista = codcorsista;
	}
	
	
	
}