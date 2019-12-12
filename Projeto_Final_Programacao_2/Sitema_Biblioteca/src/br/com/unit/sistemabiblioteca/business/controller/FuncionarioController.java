package br.com.unit.sistemabiblioteca.business.controller;

import br.com.unit.sistemabiblioteca.dao.FuncionarioDao;

public class FuncionarioController {
	FuncionarioDao funcionarioDao;
	
	public FuncionarioController() {
		funcionarioDao = new FuncionarioDao();
	}
	
	
}
