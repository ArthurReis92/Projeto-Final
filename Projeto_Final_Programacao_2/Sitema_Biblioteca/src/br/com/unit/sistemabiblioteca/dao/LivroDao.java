package br.com.unit.sistemabiblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.unit.sistemabiblioteca.business.model.Livro;

public class LivroDao {
	List<Livro> livros;

	public LivroDao() {
		livros = new ArrayList<>();
	}

	public void inserir(Livro livro) {
		livros.add(livro);
	}

	public void remover(long codigo) {
		livros.remove(consultar(codigo));
	}

	public Livro consultar(long codigo) {

		for (Livro livro : livros) {
			if (livro.getCodigo() == codigo) {
				return livro;
			}
		}
		return null;

	}

	public Livro consultar(String nome) {

		for (Livro livro : livros) {
			if (livro.getNome() == nome) {
				return livro;
			}
		}
		return null;

	}

	public Livro consultar(long codigo, String nome) {

		for (Livro livro : livros) {
			if (livro.getCodigo() == codigo) {
				return livro;
			}
		}
		return null;

	}

	public boolean existe(long codigo) {
		if (livros.contains(consultar(codigo))) {
			return true;
		}
		return false;
	}

	public void alterar(long codigo, Livro livro) {
		livros.set(livros.indexOf(consultar(codigo)), livro);
	}
}
