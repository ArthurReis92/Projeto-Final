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
	
//	public Emprestimo consultar(long cpf, long codigo) {
//		return emprestimoDao.consultar(cpf, codigo);
//	}
	
	public List<Emprestimo> retornarTodos(){
		return emprestimoDao.retornarTodos();
	}

//	public void remover(long cpf, long codigo){
//		if() {
//			
//		}
//	}
	
}
