package br.com.unit.sistemabiblioteca.business.controller;

import java.util.List;

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

	public void inserir(String nome, long cpf, String logradouro) throws Exception {
		Funcionario funcionario = new Funcionario();
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);

		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setEndereco(endereco);

		if (funcionarioDao.existe(cpf)) {
			throw new Exception("O funcionário informado já tem cadastro!");
		} else {
			funcionarioDao.inserir(funcionario);
		}
	}

	public boolean existe(long cpf) throws Exception {
		if (funcionarioDao.existe(cpf)) {
			return true;
		} else {
			throw new Exception("Funcionário não cadastrado");
		}
	}

	public void alterar(String nome, long cpf, String logradouro, long cpfAlterar) throws Exception {
		Funcionario funcionario = new Funcionario();
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		funcionario.setCpf(cpf);
		funcionario.setNome(nome);
		funcionario.setEndereco(endereco);
		
		if (existe(cpfAlterar)) {
			funcionarioDao.alterar(cpfAlterar, funcionario);
		}

	}

	public void remover(long cpf) throws Exception {
		if (existe(cpf)) {
			funcionarioDao.remover(cpf);
		}
	}

	public List<Funcionario> retornarTodos() {
		return funcionarioDao.retornarTodos();
	}

}
