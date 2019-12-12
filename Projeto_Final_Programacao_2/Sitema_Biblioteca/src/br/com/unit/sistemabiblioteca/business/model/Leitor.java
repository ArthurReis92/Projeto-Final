package br.com.unit.sistemabiblioteca.business.model;

public class Leitor {
	private String nome;
	private long cpf;
	private long matricula;
	private double divida;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public double getDivida() {
		return divida;
	}
	public void setDivida(double divida) {
		this.divida = divida;
	}
	
	
}
