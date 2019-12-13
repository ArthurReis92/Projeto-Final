package br.com.unit.sistemabiblioteca.business.controller;

import br.com.unit.sistemabiblioteca.business.model.Endereco;
import br.com.unit.sistemabiblioteca.business.model.Funcionario;
import br.com.unit.sistemabiblioteca.dao.FuncionarioDao;

public class FuncionarioController {
	FuncionarioDao funcionarioDao;

	public FuncionarioController() {
		funcionarioDao = new FuncionarioDao();
	}

	public Funcionario consultar(long cpf) {

		return funcionarioDao.consultar(cpf);

	}

	public void inserir(String nome, long cpf, String logradouro) {
		Funcionario funcionario = new Funcionario();
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);

		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setEndereco(endereco);

		if (funcionarioDao.existe(cpf)) {
			System.out.println("Funcion�rio j� foi cadastrado");
			return;
		}

		funcionarioDao.inserir(funcionario);

	}

	public boolean existe(long cpf) throws Exception {
		if (funcionarioDao.existe(cpf)) {
			return true;
		} else {
			throw new Exception("Funcion�rio n�o cadastrado");
		}
	}

}
