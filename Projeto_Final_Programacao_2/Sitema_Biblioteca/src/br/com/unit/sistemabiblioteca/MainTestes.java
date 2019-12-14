package br.com.unit.sistemabiblioteca;

import java.util.Scanner;

import br.com.unit.sistemabiblioteca.business.controller.EmprestimoController;
import br.com.unit.sistemabiblioteca.business.controller.FuncionarioController;
import br.com.unit.sistemabiblioteca.business.controller.LeitorController;
import br.com.unit.sistemabiblioteca.business.controller.LivroController;
import br.com.unit.sistemabiblioteca.business.model.Emprestimo;

public class MainTestes {
	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		LeitorController leitorController = new LeitorController();
		FuncionarioController funcionarioController = new FuncionarioController();
		LivroController livroController = new LivroController();
		EmprestimoController emprestimoController = new EmprestimoController();

		
		
		
		// Cadastro de leitor

		System.out.println("Digite o nome, cpf, logradouro do leitor: ");
		while (true) {
			try {
				String nomeLeitor = ler.nextLine();
				long cpfLeitor = ler.nextLong();
				String logradouroLeitor = ler.nextLine();
				leitorController.inserir(nomeLeitor, cpfLeitor, logradouroLeitor);
				ler.nextLine();
				break;
			} catch (Exception e) {
				ler.nextLine();
				if (e.getMessage() != null) {
					System.out.println(e.getMessage() + " Digite novamente o nome, cpf e logradouro do leitor: ");
				} else {
					System.out.println("Dados inv�lidos! Digite novamente o nome, cpf e logradouro do leitor: ");
				}
			}
		}
		// Cadastro de Funcionario
		System.out.println("Digite o nome, cpf, logradouro do funcionario: ");
		while (true) {
			try {
				String nomeFuncionario = ler.nextLine();
				long cpfFuncionario = ler.nextLong();
				String logradouroFuncionario = ler.nextLine();
				funcionarioController.inserir(nomeFuncionario, cpfFuncionario, logradouroFuncionario);
				ler.nextLine();
				break;
			} catch (Exception e) {
				ler.nextLine();
				System.out.println(e.getMessage() + " Digite novamente o nome, cpf e logradouro do funcion�rio: ");
			}
		}
		// Cadastro de Livros
		System.out.println("Digite o nome, codigo, autor do livro: ");
		while (true) {
			try {
				String nomeLivro = ler.nextLine();
				long codigoLivro = ler.nextLong();
				ler.nextLine();
				String autorLivro = ler.nextLine();
				livroController.inserir(nomeLivro, codigoLivro, autorLivro);
				break;
			} catch (Exception e) {
				ler.nextLine();
				System.out.println(e.getMessage() + " Digite novamente o nome, cpf e logradouro do funcion�rio: ");
			}
		}
		// Emprestimo de livros

		System.out.println("Digite o cpf do funcionario que est� realizando a opera��o");
		long cpfFuncionarioEmprestimo;
		while (true) {
			try {
				cpfFuncionarioEmprestimo = ler.nextLong();
				funcionarioController.existe(cpfFuncionarioEmprestimo);
				break;
			} catch (Exception e) {
				ler.nextLine();
				System.out.println("Funcionario n�o cadastrado! Digite o cpf do funcion�rio novamente:");
			}
		}

		System.out.println("Digite a matr�cula/cpf do leitor que est� realizando o empr�stimo");
		long cpfLeitorEmprestimo;
		while (true) {
			try {
				cpfLeitorEmprestimo = ler.nextLong();
				leitorController.existe(cpfLeitorEmprestimo);
				break;
			} catch (Exception e) {
				ler.nextLine();
				System.out.println(e.getMessage() + " Digite o cpf do leitor novamenteo");
			}
		}

		System.out.println("Digite o c�digo do livro que o leitor quer emprestado");

		long codigoLivroEmprestado = ler.nextLong();

		if (emprestimoController.consultarDisponibilidade(codigoLivroEmprestado)) {
			emprestimoController.inserir(funcionarioController.consultar(cpfFuncionarioEmprestimo),
					leitorController.consultar(cpfLeitorEmprestimo), livroController.consultar(codigoLivroEmprestado));
			System.out.println("Empr�stimo realizado com sucesso!");
		} else {
			System.out.println("Livro indispon�vel");
		}
		System.out.println("---------Lista de empr�stimos------------");
		for (Emprestimo emprestimo : emprestimoController.retornarTodos()) {
			System.out.println(emprestimo);
		}
		;
		ler.close();
	}

}
