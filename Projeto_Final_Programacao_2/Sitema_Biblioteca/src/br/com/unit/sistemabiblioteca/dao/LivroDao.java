package br.com.unit.sistemabiblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.unit.sistemabiblioteca.business.model.Livro;

public class LivroDao {
	List<Livro> livros;
	
	public LivroDao() {
		livros = new ArrayList<>();
	}
}
