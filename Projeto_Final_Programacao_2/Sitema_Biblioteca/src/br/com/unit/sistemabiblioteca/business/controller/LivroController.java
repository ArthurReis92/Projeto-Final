package br.com.unit.sistemabiblioteca.business.controller;

import br.com.unit.sistemabiblioteca.dao.LivroDao;

public class LivroController {
	LivroDao livroDao;
	
	public LivroController() {
		livroDao = new LivroDao();
	}
	
	
}
