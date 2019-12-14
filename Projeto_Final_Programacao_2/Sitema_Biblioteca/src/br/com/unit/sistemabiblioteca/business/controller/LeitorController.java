package br.com.unit.sistemabiblioteca.business.controller;

import java.util.List;

import br.com.unit.sistemabiblioteca.business.model.Endereco;
import br.com.unit.sistemabiblioteca.business.model.Leitor;
import br.com.unit.sistemabiblioteca.dao.LeitorDao;

public class LeitorController {
	LeitorDao leitorDao;

	public LeitorController() {
		leitorDao = new LeitorDao();
	}

	public void inserir(String nome, long cpf, String logradouro) throws Exception {
		Leitor leitor = new Leitor();
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);

		leitor.setCpf(cpf);
		leitor.setNome(nome);
		leitor.setEndereco(endereco);

		if (leitorDao.existe(cpf)) {
			throw new Exception("Leitor já foi cadastrado!");
		} else {
			leitorDao.inserir(leitor);
		}

	}

	public Leitor consultar(long cpf) {

		return leitorDao.consultar(cpf);

	}

	public boolean existe(long cpf) throws Exception {
		if (leitorDao.existe(cpf)) {
			return true;
		} else {
			throw new Exception("Leitor sem cadastro!");
		}
	}

	public List<Leitor> retornarTodos() {
		return leitorDao.retornarTodos();
	}

	public void alterar(long cpf, String nome, String logradouro, long cpfAlterar) throws Exception {
		Leitor leitor = new Leitor();
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);

		leitor.setCpf(cpf);
		leitor.setNome(nome);

		if (existe(cpfAlterar)) {
			leitorDao.alterar(cpfAlterar, leitor);
		}

	}

	public void remover(long cpf) throws Exception {
		if (existe(cpf)) {
			leitorDao.remover(cpf);
		}
	}

}
