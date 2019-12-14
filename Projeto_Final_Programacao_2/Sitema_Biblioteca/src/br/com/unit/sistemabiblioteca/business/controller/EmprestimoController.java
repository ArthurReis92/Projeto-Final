package br.com.unit.sistemabiblioteca.business.controller;

import java.util.List;

import br.com.unit.sistemabiblioteca.business.model.Emprestimo;
import br.com.unit.sistemabiblioteca.business.model.Funcionario;
import br.com.unit.sistemabiblioteca.business.model.Leitor;
import br.com.unit.sistemabiblioteca.business.model.Livro;
import br.com.unit.sistemabiblioteca.dao.EmprestimoDao;

public class EmprestimoController {
	EmprestimoDao emprestimoDao;

	public EmprestimoController() {
		emprestimoDao = new EmprestimoDao();
	}

	public boolean consultarDisponibilidade(long codigoLivroEmprestado) {
		return emprestimoDao.consultarDisponibilidade(codigoLivroEmprestado);
	}

	public void inserir(Funcionario funcionario, Leitor leitor, Livro livro) throws Exception {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setFuncionario(funcionario);
		emprestimo.setLeitor(leitor);
		emprestimo.setLivro(livro);

		if (consultarDisponibilidade(livro.getCodigo())) {
			emprestimoDao.inserir(emprestimo);
		}else {
			throw new Exception("Livro indisponível!");
		}

	}

	public Emprestimo consultar(long cpf) {
		return emprestimoDao.consultar(cpf);
	}

	public Emprestimo consultar(long cpf, long codigo) {
		return emprestimoDao.consultar(cpf, codigo);
	}

	public List<Emprestimo> retornarEmprestimosLeitor(long cpf) {
		return emprestimoDao.retornarEmprestimosLeitor(cpf);
	}

	public List<Emprestimo> retornarTodos() {
		return emprestimoDao.retornarTodos();
	}

	public void removerEmprestimoLivro(long cpf, long codigo) throws Exception {

		Emprestimo emprestimo = consultar(cpf, codigo);
		if (!existe(emprestimo)) {
			throw new Exception("Não há mais empréstimos desse livro para esse leitor!");
		}
		if (existe(emprestimo)) {
			emprestimoDao.removerEmprestimoLivro(cpf, codigo);
		} else {
			throw new Exception("Emprétimo não existe!");
		}
	}

	public void renovar(Leitor leitor, Livro livro, Funcionario funcionario) throws Exception {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setLeitor(leitor);
		emprestimo.setFuncionario(funcionario);
		emprestimo.setLivro(livro);
		if (existe(emprestimo)) {
			emprestimoDao.renovar(emprestimo);
		}
	}

	public boolean existe(Emprestimo emprestimo) throws Exception {
		if (emprestimoDao.existe(emprestimo)) {
			return true;
		} else {
			throw new Exception("Empréstimo não existe!");
		}
	}

}
