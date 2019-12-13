package br.com.unit.sistemabiblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.unit.sistemabiblioteca.business.model.Emprestimo;

public class EmprestimoDao {
	List<Emprestimo> emprestimos;
	
	public EmprestimoDao() {
		emprestimos = new ArrayList<>();
	}
	
	public void remover(Emprestimo emprestimo) {
		emprestimos.remove(emprestimo);
	}
	
	public void inserir(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
	}
	
	public Emprestimo consultar(long cpf) {
		for (Emprestimo emprestimo : emprestimos) {
			if(emprestimo.getLeitor().getCpf() == cpf) {
				return emprestimo;
			}
		}
		return null;
	}
	
	public List<Emprestimo> retornarTodos(){
		return emprestimos;
	}
	
	public void alterar(long cpf, Emprestimo emprestimo) {
		emprestimos.set(emprestimos.indexOf(consultar(cpf)), emprestimo);
	}
}