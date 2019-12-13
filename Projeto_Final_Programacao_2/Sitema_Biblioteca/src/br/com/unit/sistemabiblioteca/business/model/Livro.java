package br.com.unit.sistemabiblioteca.business.model;

public class Livro {
	private String nome;
	private String autor;
	private long codigo;
	private int ano;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", autor=" + autor + ", codigo=" + codigo + "]";
	}

	
}
