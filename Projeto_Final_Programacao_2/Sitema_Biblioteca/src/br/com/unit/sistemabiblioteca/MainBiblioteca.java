package br.com.unit.sistemabiblioteca;
import java.util.Scanner;

import br.com.unit.sistemabiblioteca.business.controller.FuncionarioController;
import br.com.unit.sistemabiblioteca.business.controller.LeitorController;
import br.com.unit.sistemabiblioteca.business.controller.LivroController;
public class MainBiblioteca {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		LeitorController leitorController = new LeitorController();
		FuncionarioController funcionarioController = new FuncionarioController();
		LivroController livroController = new LivroController();
		
		System.out.println("Digite: \n 1 - Cadastrar \n 2 - Consultar \n 3 - Alterar \n 4 - Excluir");
		int n = ler.nextInt();
		
		switch(n) {
		case 1: 
			System.out.println("Escolha uma opção de cadastro: \n 1 - Livros \n 2 - Funcionários \n 3 - Leitores");
			int m = ler.nextInt();
			
			switch (m) {
			case 1:
				
			}
			break;
		}
	}

}
