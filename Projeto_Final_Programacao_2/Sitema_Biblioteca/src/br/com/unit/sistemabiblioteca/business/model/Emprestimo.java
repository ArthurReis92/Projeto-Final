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
		return "\nEmpréstimo: \n" + livro + "\n" + leitor + "\n" + funcionario + "\n"
				+ dataRetirada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leitor == null) ? 0 : leitor.hashCode());
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (leitor == null) {
			if (other.leitor != null)
				return false;
		} else if (!leitor.equals(other.leitor))
			return false;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		return true;
	}
	
}
