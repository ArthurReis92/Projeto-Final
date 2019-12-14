package br.com.unit.sistemabiblioteca;

import java.util.Scanner;

import br.com.unit.sistemabiblioteca.business.controller.EmprestimoController;
import br.com.unit.sistemabiblioteca.business.controller.FuncionarioController;
import br.com.unit.sistemabiblioteca.business.controller.LeitorController;
import br.com.unit.sistemabiblioteca.business.controller.LivroController;
import br.com.unit.sistemabiblioteca.business.model.Emprestimo;
import br.com.unit.sistemabiblioteca.business.model.Funcionario;
import br.com.unit.sistemabiblioteca.business.model.Leitor;
import br.com.unit.sistemabiblioteca.business.model.Livro;

public class MainTeste {
	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		LeitorController leitorController = new LeitorController();
		FuncionarioController funcionarioController = new FuncionarioController();
		LivroController livroController = new LivroController();
		EmprestimoController emprestimoController = new EmprestimoController();

		char resp;
		do {
			int n;
			while (true) {
				try {
					System.out.println("Digite um dos n�meros abaixo para executar uma das opera��es: "
							+ "\n 1 - Portal de Leitores" + "\n 2 - Portal de Funcionarios" + "\n 3 - Portal de Livros"
							+ "\n 4 - Portal de Empr�stimo");
					n = ler.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("D�gito inv�lido!");
				}
			}
			switch (n) {
			case 1:

				do {
					int m;
					while (true) {
						try {
							System.out.println("Digite um dos n�meros abaixo para executar uma das opera��es: "
									+ "\n 1 - Cadastrar novos leitores"
									+ "\n 2 - Imprimir todos os leitores cadastrados"
									+ "\n 3 - Modificar dados de um leitor cadastrado"
									+ "\n 4 - Remover leitor cadastrado"
									+ "\n 5 - Consultar dados de algum leitor cadastrado");
							m = ler.nextInt();
							break;
						} catch (Exception e) {
							ler.nextLine();
							System.out.println("D�gito inv�lido!");
						}
					}
					switch (m) {
					case 1:

						do {
							System.out.println("Digite o nome, cpf, logradouro do leitor: ");
							while (true) {
								try {
									ler.nextLine();
									String nomeLeitor = ler.nextLine();
									long cpfLeitor = ler.nextLong();
									ler.nextLine();
									String logradouroLeitor = ler.nextLine();
									leitorController.inserir(nomeLeitor, cpfLeitor, logradouroLeitor);
									break;
								} catch (Exception e) {
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o nome, cpf e logradouro do leitor: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o nome, cpf e logradouro do leitor: ");
									}
								}
							}

							System.out.println("Deseja cadastrar mais algum leitor? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 2:
						System.out.println("---------Leitores Cadastrados---------");
						System.out.println("------------------------------------");
						for (Leitor leitor : leitorController.retornarTodos()) {
							System.out.println(leitor);
						}
						break;

					case 3:
						ler.nextLine();
						do {
							System.out
									.println("Digite os novos dados do leitor:  nome, cpf, logradouro (nesta ordem) ");
							while (true) {
								try {

									String nomeLeitor = ler.nextLine();
									long cpfLeitor = ler.nextLong();
									ler.nextLine();
									String logradouroLeitor = ler.nextLine();

									System.out.println("Digite matricula/cpf do leitor que voc� quer alterar: ");
									long cpfAlterar = ler.nextLong();
									leitorController.alterar(cpfLeitor, nomeLeitor, logradouroLeitor, cpfAlterar);
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente a matricula/cpf do leitor que voc� quer alterar: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente a matricula/cpf do leitor que voc� quer alterar: ");
									}
								}
							}
							System.out.println("Deseja modificar mais algum funcionario cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 4:

						do {
							System.out.println("Digite o cpf/matr�cula do leitor que deseja remover");
							while (true) {
								try {

									long cpfLeitor = ler.nextLong();
									leitorController.remover(cpfLeitor);
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o cpf/matr�cula do leitor que deseja remover: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o cpf/matr�cula do leitor que deseja remover: ");
									}
								}
							}
							System.out.println("Deseja remover mais algum leitor cadastrado? (s/n)");
							resp = ler.next().charAt(0);
						} while (resp == 's');
						break;

					case 5:

						do {
							System.out.println("Digite o cpf/matr�cula do leitor para realizar a consulta: ");
							while (true) {
								try {
									long cpfLeitor = ler.nextLong();
									System.out.println(leitorController.consultar(cpfLeitor));
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o cpf/matr�cula do leitor que deseja remover: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o cpf/matr�cula do leitor que deseja remover: ");
									}
								}
							}

							System.out.println("Deseja consultar mais algum leitor cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					default:
						System.out.println("Op��o inv�lida!");
						break;
					}
					System.out.println("Deseja retornar ao Menu de Leitores? (s/n)");
					resp = ler.next().charAt(0);
				} while (resp == 's');
				break;

			case 2:
				
				do {
					int m;
					while (true) {
						try {
							System.out.println("Digite um dos n�meros abaixo para executar uma das opera��es: "
									+ "\n 1 - Cadastrar novos Funcionarios"
									+ "\n 2 - Imprimir todos os Funcionarios cadastrados"
									+ "\n 3 - Modificar dados de um funcionario cadastrado"
									+ "\n 4 - Remover funcionario cadastrado"
									+ "\n 5 - Consultar dados de algum funcionario cadastrado");
							m = ler.nextInt();
							break;
						} catch (Exception e) {
							ler.nextLine();
							System.out.println("D�gito inv�lido!");
						}
					}

					switch (m) {
					case 1:

						do {
							System.out.println("Digite o nome, cpf, logradouro do leitor: ");
							while (true) {
								try {
									String nomeFuncionario = ler.nextLine();
									ler.nextLine();
									long cpfFuncionario = ler.nextLong();
									String logradouroFuncionario = ler.nextLine();
									funcionarioController.inserir(nomeFuncionario, cpfFuncionario,
											logradouroFuncionario);
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o nome, cpf e logradouro do Funcionario: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o nome, cpf e logradouro do Funcionario: ");
									}
								}
							}

							System.out.println("Deseja cadastrar mais algum Funcionario? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 2:
						System.out.println("---------Funcionarios Cadastrados---------");
						System.out.println("------------------------------------");
						for (Funcionario funcionario : funcionarioController.retornarTodos()) {
							System.out.println(funcionario);
						}
						break;

					case 3:

						do {

							System.out.println(
									"Digite os novos dados do funcionario:  nome, cpf, logradouro (nesta ordem) ");
							while (true) {
								try {
									String nomeFuncionario = ler.nextLine();
									long cpfFuncionario = ler.nextLong();
									String logradouroFuncionario = ler.nextLine();
									System.out.println("Digite cpf do leitor que voc� quer alterar: ");
									long cpfAlterar = ler.nextLong();
									funcionarioController.alterar(nomeFuncionario, cpfFuncionario,
											logradouroFuncionario, cpfAlterar);
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o cpf do funcion�rio que voc� quer alterar: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o cpf do funcion�rio que voc� quer alterar: ");
									}
								}
							}
							System.out.println("Deseja modificar mais algum funcionario cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 4:

						do {
							System.out.println("Digite o cpf do funcion�rio que deseja remover");
							while (true) {
								try {

									long cpfFuncionario = ler.nextLong();
									funcionarioController.remover(cpfFuncionario);
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o cpf do funcionario que deseja remover: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o cpf do funcionario que deseja remover: ");
									}
								}
							}
							System.out.println("Deseja remover mais algum funcionario cadastrado? (s/n)");
							resp = ler.next().charAt(0);
						} while (resp == 's');
						break;

					case 5:

						do {
							System.out.println("Digite o cpf do funcionario para realizar a consulta: ");
							while (true) {
								try {
									long cpfFuncionario = ler.nextLong();
									System.out.println(funcionarioController.consultar(cpfFuncionario));
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o cpf do funcionario que deseja remover: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o cpf do funcionario que deseja remover: ");
									}
								}
							}

							System.out.println("Deseja consultar mais algum funcion�rio cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					default:
						System.out.println("Op��o inv�lida!");
						break;
					}
					System.out.println("Deseja retornar ao Menu de Funcion�rios? (s/n)");
					resp = ler.next().charAt(0);
				} while (resp == 's');
				break;
			case 3:

				do {
					int m;
					while (true) {
						try {
							System.out.println("Digite um dos n�meros abaixo para executar uma das opera��es: "
									+ "\n 1 - Cadastrar novos livros" + "\n 2 - Imprimir todos os livros cadastrados"
									+ "\n 3 - Modificar dados de um livro cadastrado" + "\n 4 - Remover livro cadastrado"
									+ "\n 5 - Consultar dados de algum livro cadastrado");
							m = ler.nextInt();
							break;
						} catch (Exception e) {
							ler.nextLine();
							System.out.println("D�gito inv�lido!");
						}
					}

					ler.nextLine();
					switch (m) {
					case 1:

						do {
							System.out.println("Digite o nome, c�digo e autor do livro: ");
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
									if (e.getMessage() != null) {
										System.out.println(
												e.getMessage() + " Digite novamente o nome, c�digo e autor do livro: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o nome, c�digo e autor do livro: ");
									}
								}
							}

							System.out.println("Deseja cadastrar mais algum livro? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 2:
						System.out.println("---------Livros Cadastrados---------");
						System.out.println("------------------------------------");
						for (Livro livro : livroController.retornarTodos()) {
							System.out.println(livro);
						}
						break;

					case 3:

						do {

							System.out.println("Digite os novos dados do livro:  nome, c�digo, autor (nesta ordem) ");
							while (true) {
								try {
									String nomeLivro = ler.nextLine();
									long codigoLivro = ler.nextLong();
									ler.nextLine();
									String autorLivro = ler.nextLine();
									System.out.println("Digite o c�digo do livro que voc� quer alterar: ");
									long codigoAlterar = ler.nextLong();
									livroController.alterar(nomeLivro, codigoLivro, autorLivro, codigoAlterar);
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente nome, c�digo e autor (nesta ordem) ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente nome, c�digo e autor (nesta ordem): ");
									}
								}
							}
							System.out.println("Deseja modificar mais algum livro cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 4:

						do {
							System.out.println("Digite o c�digo do livro que deseja remover");
							while (true) {
								try {

									long codigoLivro = ler.nextLong();
									livroController.remover(codigoLivro);
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o c�digo do livro que deseja remover: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o c�digo do livro que deseja remover: ");
									}
								}
							}
							System.out.println("Deseja remover mais algum livro cadastrado? (s/n)");
							resp = ler.next().charAt(0);
						} while (resp == 's');
						break;

					case 5:

						do {
							System.out.println("Digite o c�digo do livro para realizar a consulta: ");
							while (true) {
								try {
									long codigoLivro = ler.nextLong();
									System.out.println(livroController.consultar(codigoLivro));
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o c�digo do livro para realizar a consulta: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o c�digo do livro para realizar a consulta: ");
									}
								}
							}

							System.out.println("Deseja consultar mais algum livro cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					default:
						System.out.println("Op��o inv�lida!");
						break;
					}
					System.out.println("Deseja retornar ao Menu de Livros? (s/n)");
					resp = ler.next().charAt(0);
				} while (resp == 's');
				break;
			case 4:
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
				do {
					int m;
					while (true) {
						try {
							System.out.println("Digite um dos n�meros abaixo para executar uma das opera��es: "
									+ "\n 1 - Realizar empr�stimos de livros"
									+ "\n 2 - Imprimir todos os empr�stimos cadastrados" + "\n 3 - Renovar empr�stimo realizado"
									+ "\n 4 - Devolu��o de livro" + "\n 5 - Consultar empr�stimos de um leitor");
							m = ler.nextInt();
							break;
						} catch (Exception e) {
							ler.nextLine();
							System.out.println("D�gito inv�lido!");
						}
					}

					switch (m) {
					case 1:

						do {

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

							long codigoLivroEmprestado;
							while (true) {
								try {
									codigoLivroEmprestado = ler.nextLong();
									livroController.existe(codigoLivroEmprestado);
									break;
								} catch (Exception e) {
									ler.nextLine();
									System.out.println(e.getMessage() + " Digite o c�digo do livro novamente");
								}
							}

							if (emprestimoController.consultarDisponibilidade(codigoLivroEmprestado)) {
								emprestimoController.inserir(funcionarioController.consultar(cpfFuncionarioEmprestimo),
										leitorController.consultar(cpfLeitorEmprestimo),
										livroController.consultar(codigoLivroEmprestado));
								System.out.println("Empr�stimo realizado com sucesso!");
							} else {
								System.out.println("Livro indispon�vel");
							}

							System.out.println("Deseja realizar mais algum empr�stimo? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 2:
						System.out.println("--------- Lista de Todos os Empr�stimos ---------");
						System.out.println("------------------------------------");
						for (Emprestimo emprestimo : emprestimoController.retornarTodos()) {
							System.out.println(emprestimo);
						}
						break;

					case 3:

						do {

							System.out.println("Digite o cpf do leitor e o c�digo do livro a ser renovado: ");
							while (true) {
								try {
									long cpfLeitor = ler.nextLong();
									long codigoLivro = ler.nextLong();
									ler.nextLine();
									emprestimoController.renovar(leitorController.consultar(cpfLeitor),
											livroController.consultar(codigoLivro),
											funcionarioController.consultar(cpfFuncionarioEmprestimo));
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o cpf do leitor e o c�digo do livro a ser renovado: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o cpf do leitor e o c�digo do livro a ser renovado: ");
									}
								}
							}
							System.out.println("Deseja renovar mais algum empr�stimo? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 4:

						do {
							System.out.println("Digite o nome do leitor e o c�digo do livro a ser devolvido: ");
							while (true) {
								try {
									long cpfLeitor = ler.nextLong();
									long codigoLivro = ler.nextLong();
									ler.nextLine();
									emprestimoController.removerEmprestimoLivro(cpfLeitor, codigoLivro);
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o nome do leitor e o c�digo do livro a ser devolvido: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o nome do leitor e o c�digo do livro a ser devolvido: ");
									}
								}
							}
							System.out.println("Deseja devolver mais algum livro? (s/n)");
							resp = ler.next().charAt(0);
						} while (resp == 's');
						break;

					case 5:

						do {
							System.out.println("Digite o cpf para realizar a consulta: ");
							while (true) {
								try {
									long cpfLeitor = ler.nextLong();
									System.out.println(emprestimoController.retornarEmprestimosLeitor(cpfLeitor));
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(
												e.getMessage() + " Digite novamente o cpf para realizar a consulta: ");
									} else {
										System.out.println(
												"Dados inv�lidos! Digite novamente o cpf para realizar a consulta: ");
									}
								}
							}

							System.out.println("Deseja consultar mais empr�stimos de algum leitor? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					default:
						System.out.println("Op��o inv�lida!");
						break;
					}
					System.out.println("Deseja retornar ao Menu de Empr�stimos? (s/n)");
					resp = ler.next().charAt(0);
				} while (resp == 's');
				break;
			}
			System.out.println("Deseja retornar ao menu Principal? (s/n)");
			resp = ler.next().charAt(0);
		} while (resp == 's');
		ler.close();

	}

}
