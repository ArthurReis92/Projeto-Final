package br.com.unit.sistemabiblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.unit.sistemabiblioteca.business.model.Leitor;

public class LeitorDao {
	List<Leitor> leitores;

	public LeitorDao() {
		leitores = new ArrayList<>();
	}

	public void inserir(Leitor leitor) {
		leitores.add(leitor);
	}

	public void remover(long cpf) {
		leitores.remove(consultar(cpf));
	}

	public Leitor consultar(long cpf) {

		for (Leitor leitor : leitores) {
			if (leitor.getCpf() == cpf) {
				return leitor;
			}
		}
		return null;

	}

	public boolean existe(long cpf) {
		if (leitores.contains(consultar(cpf))) {
			return true;
		}
		return false;
	}

	public void alterar(long cpf, Leitor leitor) {
		leitores.set(leitores.indexOf(consultar(cpf)), leitor);
	}

}
