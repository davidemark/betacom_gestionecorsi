package com.torino.gestionecorsi.businesscomponent.model;

import java.util.Date;

public class Corso {
	private long codcorso;
	private String nome;
	private Date dataInizio;
	private Date dataFine;
	private Double costo;
	private String commento;
	private long coddocente;

	public long getCodcorso() {
		return codcorso;
	}

	public void setCodcorso(long codcorso) {
		this.codcorso = codcorso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	private String aula;

	

	public long getCoddocente() {
		return coddocente;
	}

	public void setCoddocente(long coddocente) {
		this.coddocente = coddocente;
	}

	@Override
	public String toString() {
		return "Corso [codcorso=" + codcorso + ", nome=" + nome + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + ", costo=" + costo + ", commento=" + commento + ", coddocente=" + coddocente + ", aula="
				+ aula + "]";
	}

}
