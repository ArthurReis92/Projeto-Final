package br.com.unit.sistemabiblioteca.business.controller;

import br.com.unit.sistemabiblioteca.business.model.Livro;
import br.com.unit.sistemabiblioteca.dao.LivroDao;

public class LivroController {
	LivroDao livroDao;
	
	public LivroController() {
		livroDao = new LivroDao();
	}
	
	public Livro consultar(long codigo) {
		if(livroDao.existe(codigo)) {
			return livroDao.consultar(codigo);
		}
		return null;
	}

	public void inserir(String nome, long codigo, String autor) {
		Livro livro = new Livro();
		livro.setNome(nome);
		livro.setCodigo(codigo);
		livro.setAutor(autor);
		
		
		
		livroDao.inserir(livro);
		
	}
	
	
}
