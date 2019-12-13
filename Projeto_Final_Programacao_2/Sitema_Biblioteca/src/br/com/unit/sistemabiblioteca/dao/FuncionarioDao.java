package br.com.unit.sistemabiblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.unit.sistemabiblioteca.business.model.Funcionario;

public class FuncionarioDao {
	List<Funcionario> funcionarios;

	public FuncionarioDao() {
		funcionarios = new ArrayList<>();
	}

	public void inserir(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	public void remover(long cpf) {
		funcionarios.remove(consultar(cpf));
	}

	public Funcionario consultar(long cpf) {

		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf() == cpf) {
				return funcionario;
			}
		}
		return null;

	}

	public boolean existe(Funcionario funcionario) {
		if (funcionarios.contains(funcionario)) {
			return true;
		}
		return false;
	}

	public void alterar(long cpf, Funcionario funcionario) {
		funcionarios.set(funcionarios.indexOf(consultar(cpf)), funcionario);
	}

}
