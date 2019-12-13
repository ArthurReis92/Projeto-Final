package br.com.unit.sistemabiblioteca.business.model;

import java.util.Date;

public class Emprestimo {
	Livro livro;
	Leitor leitor;
	Funcionario funcionario;
	Date dataRetirada;
	
	public Emprestimo() {
		dataRetirada = new Date();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	@Override
	public String toString() {
		return "Emprestimo [livro=" + livro + ", leitor=" + leitor + ", funcionario=" + funcionario + ", dataRetirada="
				+ dataRetirada + "]";
	}
	
	
	
}
