package br.com.unit.sistemabiblioteca.business.controller;

import br.com.unit.sistemabiblioteca.dao.EmprestimoDao;

public class EmprestimoController {
	EmprestimoDao emprestimoDao;
	
	public EmprestimoController() {
		emprestimoDao = new EmprestimoDao();
	}


	
}
