package br.com.unit.sistemabiblioteca.business.controller;

import java.util.List;

import br.com.unit.sistemabiblioteca.business.model.Livro;
import br.com.unit.sistemabiblioteca.dao.LivroDao;

public class LivroController {
	LivroDao livroDao;

	public LivroController() {
		livroDao = new LivroDao();
	}

	public Livro consultar(long codigo) {
		if (livroDao.existe(codigo)) {
			return livroDao.consultar(codigo);
		}
		return null;
	}

	public void inserir(String nome, long codigo, String autor) throws Exception {
		Livro livro = new Livro();
		livro.setNome(nome);
		livro.setCodigo(codigo);
		livro.setAutor(autor);
		
		if(livroDao.existe(codigo)) {
			throw new Exception("Esse livro já existe na biblioteca");
		}else {
			livroDao.inserir(livro);
		}

	}

	public void remover(long codigo) {
		livroDao.remover(codigo);
	}

	public boolean existe(long codigo) throws Exception {
		if(livroDao.existe(codigo)) {
			return true;
		} else {
			throw new Exception("Livro não cadastrado!");
		}
	}

	public void alterar(String nome, long codigo, String autor, long codigoAlterar) throws Exception {
		Livro livro = new Livro();
		livro.setAutor(autor);
		livro.setCodigo(codigo);
		livro.setNome(nome);
		
		if(existe(codigoAlterar)) {
			livroDao.alterar(codigoAlterar,livro);
		}
	}

	public List<Livro> retornarTodos() {
		return livroDao.retornarTodos();
	}

	public void inserirTodos(List<Livro> listaDeLivros) {
		livroDao.inserirTodos(listaDeLivros);
		
	}



}
