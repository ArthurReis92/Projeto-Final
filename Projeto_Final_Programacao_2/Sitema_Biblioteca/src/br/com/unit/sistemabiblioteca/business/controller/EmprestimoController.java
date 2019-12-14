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

	public void inserir(Funcionario funcionario, Leitor leitor, Livro livro) {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setFuncionario(funcionario);
		emprestimo.setLeitor(leitor);
		emprestimo.setLivro(livro);
		
		emprestimoDao.inserir(emprestimo);
		
	}
	
	public Emprestimo consultar(long cpf) {
		return emprestimoDao.consultar(cpf);
	}
	
	public List<Emprestimo> retornarEmprestimosLeitor(long cpf) {
		return emprestimoDao.retornarEmprestimosLeitor(cpf);
	}
	
	public List<Emprestimo> retornarTodos(){
		return emprestimoDao.retornarTodos();
	}

	public void removerEmprestimoLivro(long cpf, long codigo){
		emprestimoDao.removerEmprestimoLivro(cpf, codigo);
	}

	public void renovar(Leitor leitor, Livro livro, Funcionario funcionario) {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setLeitor(leitor);
		emprestimo.setFuncionario(funcionario);
		emprestimo.setLivro(livro);
		
		emprestimoDao.renovar(emprestimo);
		
	}
	
}
