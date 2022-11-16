package com.torino.gestionecorsi.businesscomponent.model;

public class Amministratore {
	private String codadmin;
	private String nome;
	private String cognome;

	public String getCodadmin() {
		return codadmin;
	}

	public void setCodadmin(String codadmin) {
		this.codadmin = codadmin;
	}

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

	@Override
	public String toString() {
		return "Amministratore [codadmin=" + codadmin + ", nome=" + nome + ", cognome=" + cognome + "]";
	}

}
