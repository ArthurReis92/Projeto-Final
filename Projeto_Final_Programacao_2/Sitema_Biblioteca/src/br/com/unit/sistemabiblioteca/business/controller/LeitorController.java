package br.com.unit.sistemabiblioteca.business.controller;

import br.com.unit.sistemabiblioteca.dao.LeitorDao;

public class LeitorController {
	LeitorDao leitorDao;
	
	public LeitorController() {
		leitorDao = new LeitorDao();
	}
	
	
}
