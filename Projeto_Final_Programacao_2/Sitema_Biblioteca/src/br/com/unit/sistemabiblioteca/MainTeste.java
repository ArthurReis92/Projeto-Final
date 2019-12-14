package br.com.unit.sistemabiblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.unit.sistemabiblioteca.business.controller.EmprestimoController;
import br.com.unit.sistemabiblioteca.business.controller.FuncionarioController;
import br.com.unit.sistemabiblioteca.business.controller.LeitorController;
import br.com.unit.sistemabiblioteca.business.controller.LivroController;
import br.com.unit.sistemabiblioteca.business.model.Emprestimo;
import br.com.unit.sistemabiblioteca.business.model.Endereco;
import br.com.unit.sistemabiblioteca.business.model.Funcionario;
import br.com.unit.sistemabiblioteca.business.model.Leitor;
import br.com.unit.sistemabiblioteca.business.model.Livro;
import br.com.unit.sistemabiblioteca.dao.LeitorDao;

public class MainTeste {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner ler = new Scanner(System.in);
		LeitorController leitorController = new LeitorController();
		FuncionarioController funcionarioController = new FuncionarioController();
		LivroController livroController = new LivroController();
		EmprestimoController emprestimoController = new EmprestimoController();

		Scanner c = new Scanner(new File("codigo.txt"));
		Scanner na = new Scanner(new File("nome.txt"));
		Scanner an = new Scanner(new File("ano.txt"));
		Scanner at = new Scanner(new File("autor.txt"));

		ArrayList<String> nome = new ArrayList<>();
		ArrayList<String> autor = new ArrayList<>();
		ArrayList<Integer> ano = new ArrayList<>();
		ArrayList<Long> codigo = new ArrayList<>();

		while (c.hasNextLine()) {
			codigo.add(c.nextLong());
		}
		while (na.hasNextLine()) {
			nome.add(na.nextLine());
		}
		while (at.hasNext()) {
			autor.add(at.nextLine());
		}
		while (an.hasNextLine()) {
			ano.add(an.nextInt());
		}

		int ano1;
		long codigo1;
		String autor1, nome1;
		List<Livro> listaDeLivros = new ArrayList<Livro>();

		for (int i = 0; i < 10; i++) {
			ano1 = ano.get(i);
			autor1 = autor.get(i);
			codigo1 = codigo.get(i);
			nome1 = nome.get(i);
			Livro livroDaLista = new Livro();
			livroDaLista.setAno(ano1);
			livroDaLista.setAutor(autor1);
			livroDaLista.setCodigo(codigo1);
			livroDaLista.setNome(nome1);
			listaDeLivros.add(livroDaLista);
		}
		livroController.inserirTodos(listaDeLivros);

		c = new Scanner(new File("LeitorCpf.txt"));
		na = new Scanner(new File("LeitorNome.txt"));
		at = new Scanner(new File("LeitorEndereco.txt"));

		ArrayList<String> nomeLeitor1 = new ArrayList<>();
		ArrayList<String> logradouro1 = new ArrayList<>();
		ArrayList<Long> cpfLeitor1 = new ArrayList<>();

		while (na.hasNextLine()) {
			nomeLeitor1.add(na.nextLine());
		}
		while (c.hasNextLine()) {
			cpfLeitor1.add(c.nextLong());
		}
		while (at.hasNext()) {
			logradouro1.add(at.nextLine());
		}

		long cpf1;
		String leitorNome, logradouro2;
		List<Leitor> listaLeitor = new ArrayList<>();

		for (int i = 0; i < 7; i++) {
			cpf1 = cpfLeitor1.get(i);
			leitorNome = nomeLeitor1.get(i);
			logradouro2 = logradouro1.get(i);
			Leitor leitorDaLista = new Leitor();
			Endereco enderecoLista = new Endereco();
			enderecoLista.setLogradouro(logradouro2);
			leitorDaLista.setCpf(cpf1);
			leitorDaLista.setNome(leitorNome);
			leitorDaLista.setEndereco(enderecoLista);
			listaLeitor.add(leitorDaLista);
		}
		leitorController.inserirTodos(listaLeitor);

		c = new Scanner(new File("cpfFuncionario.txt"));
		na = new Scanner(new File("nomeFuncionario.txt"));
		at = new Scanner(new File("enderecoFuncionario.txt"));

		ArrayList<String> nomeFuncionario1 = new ArrayList<>();
		ArrayList<String> logradouroFuncionario1 = new ArrayList<>();
		ArrayList<Long> cpfFuncionario1 = new ArrayList<>();

		while (na.hasNextLine()) {
			nomeFuncionario1.add(na.nextLine());
		}
		while (c.hasNextLine()) {
			cpfFuncionario1.add(c.nextLong());
		}
		while (at.hasNext()) {
			logradouroFuncionario1.add(at.nextLine());
		}

		long cpf2;
		String funcionarioNome, logradouro3;
		List<Funcionario> listaFuncionario = new ArrayList<>();

		for (int i = 0; i < 7; i++) {
			cpf2 = cpfFuncionario1.get(i);
			funcionarioNome = nomeFuncionario1.get(i);
			logradouro3 = logradouroFuncionario1.get(i);
			Funcionario funcionarioLista = new Funcionario();
			Endereco enderecoLista = new Endereco();
			enderecoLista.setLogradouro(logradouro3);
			funcionarioLista.setCpf(cpf2);
			funcionarioLista.setNome(funcionarioNome);
			funcionarioLista.setEndereco(enderecoLista);
			listaFuncionario.add(funcionarioLista);
		}

		funcionarioController.inserirTodos(listaFuncionario);

		char resp;
		do {
			int n;
			while (true) {
				try {
					System.out.println("Digite um dos números abaixo para executar uma das operações: "
							+ "\n 1 - Portal de Leitores" + "\n 2 - Portal de Funcionarios" + "\n 3 - Portal de Livros"
							+ "\n 4 - Portal de Empréstimo");
					n = ler.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Dígito inválido!");
				}
			}
			switch (n) {
			case 1:

				do {
					int m;
					while (true) {
						try {
							System.out.println("Digite um dos números abaixo para executar uma das operações: "
									+ "\n 1 - Cadastrar novos leitores"
									+ "\n 2 - Imprimir todos os leitores cadastrados"
									+ "\n 3 - Modificar dados de um leitor cadastrado"
									+ "\n 4 - Remover leitor cadastrado"
									+ "\n 5 - Consultar dados de algum leitor cadastrado");
							m = ler.nextInt();
							break;
						} catch (Exception e) {
							ler.nextLine();
							System.out.println("Dígito inválido!");
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
												"Dados inválidos! Digite novamente o nome, cpf e logradouro do leitor: ");
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

									System.out.println("Digite matricula/cpf do leitor que você quer alterar: ");
									long cpfAlterar = ler.nextLong();
									leitorController.alterar(cpfLeitor, nomeLeitor, logradouroLeitor, cpfAlterar);
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente a matricula/cpf do leitor que você quer alterar: ");
									} else {
										System.out.println(
												"Dados inválidos! Digite novamente a matricula/cpf do leitor que você quer alterar: ");
									}
								}
							}
							System.out.println("Deseja modificar mais algum funcionario cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 4:

						do {
							System.out.println("Digite o cpf/matrícula do leitor que deseja remover");
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
												+ " Digite novamente o cpf/matrícula do leitor que deseja remover: ");
									} else {
										System.out.println(
												"Dados inválidos! Digite novamente o cpf/matrícula do leitor que deseja remover: ");
									}
								}
							}
							System.out.println("Deseja remover mais algum leitor cadastrado? (s/n)");
							resp = ler.next().charAt(0);
						} while (resp == 's');
						break;

					case 5:

						do {
							System.out.println("Digite o cpf/matrícula do leitor para realizar a consulta: ");
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
												+ " Digite novamente o cpf/matrícula do leitor que deseja remover: ");
									} else {
										System.out.println(
												"Dados inválidos! Digite novamente o cpf/matrícula do leitor que deseja remover: ");
									}
								}
							}

							System.out.println("Deseja consultar mais algum leitor cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					default:
						System.out.println("Opção inválida!");
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
							System.out.println("Digite um dos números abaixo para executar uma das operações: "
									+ "\n 1 - Cadastrar novos Funcionarios"
									+ "\n 2 - Imprimir todos os Funcionarios cadastrados"
									+ "\n 3 - Modificar dados de um funcionario cadastrado"
									+ "\n 4 - Remover funcionario cadastrado"
									+ "\n 5 - Consultar dados de algum funcionario cadastrado");
							m = ler.nextInt();
							break;
						} catch (Exception e) {
							ler.nextLine();
							System.out.println("Dígito inválido!");
						}
					}

					switch (m) {
					case 1:

						do {
							System.out.println("Digite o nome, cpf, logradouro do leitor: ");
							while (true) {
								try {
									ler.nextLine();
									String nomeFuncionario = ler.nextLine();
									long cpfFuncionario = ler.nextLong();
									ler.nextLine();
									String logradouroFuncionario = ler.nextLine();
									funcionarioController.inserir(nomeFuncionario, cpfFuncionario,
											logradouroFuncionario);
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o nome, cpf e logradouro do Funcionario: ");
									} else {
										System.out.println(
												"Dados inválidos! Digite novamente o nome, cpf e logradouro do Funcionario: ");
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

							while (true) {
								try {
									System.out.println(
											"Digite os novos dados do funcionario:  nome, cpf, logradouro (nesta ordem) ");
									ler.nextLine();
									String nomeFuncionario = ler.nextLine();
									long cpfFuncionario = ler.nextLong();
									ler.nextLine();
									String logradouroFuncionario = ler.nextLine();
									System.out.println("Digite cpf do leitor que você quer alterar: ");
									long cpfAlterar = ler.nextLong();
									funcionarioController.alterar(nomeFuncionario, cpfFuncionario,
											logradouroFuncionario, cpfAlterar);
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage());
									} else {
										System.out.println("Dados inválidos!");
									}
								}
							}
							System.out.println("Deseja modificar mais algum funcionario cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 4:

						do {
							System.out.println("Digite o cpf do funcionário que deseja remover");
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
												"Dados inválidos! Digite novamente o cpf do funcionario que deseja remover: ");
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
												"Dados inválidos! Digite novamente o cpf do funcionario que deseja remover: ");
									}
								}
							}

							System.out.println("Deseja consultar mais algum funcionário cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					default:
						System.out.println("Opção inválida!");
						break;
					}
					System.out.println("Deseja retornar ao Menu de Funcionários? (s/n)");
					resp = ler.next().charAt(0);
				} while (resp == 's');
				break;
			case 3:

				do {
					int m;
					while (true) {
						try {
							System.out.println("Digite um dos números abaixo para executar uma das operações: "
									+ "\n 1 - Cadastrar novos livros" + "\n 2 - Imprimir todos os livros cadastrados"
									+ "\n 3 - Modificar dados de um livro cadastrado"
									+ "\n 4 - Remover livro cadastrado"
									+ "\n 5 - Consultar dados de algum livro cadastrado");
							m = ler.nextInt();
							break;
						} catch (Exception e) {
							ler.nextLine();
							System.out.println("Dígito inválido!");
						}
					}

					ler.nextLine();
					switch (m) {
					case 1:

						do {
							System.out.println("Digite o nome, código e autor do livro: ");
							while (true) {
								try {

									String nomeLivro = ler.nextLine();

									long codigoLivro = ler.nextLong();
									ler.nextLine();
									String autorLivro = ler.nextLine();

									livroController.inserir(nomeLivro, codigoLivro, autorLivro);
									break;
								} catch (Exception e) {

									if (e.getMessage() != null) {
										System.out.println(
												e.getMessage() + " Digite novamente o nome, código e autor do livro: ");
									} else {
										System.out.println(
												"Dados inválidos! Digite novamente o nome, código e autor do livro: ");
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

							System.out.println("Digite os novos dados do livro:  nome, código, autor (nesta ordem) ");
							while (true) {
								try {
									String nomeLivro = ler.nextLine();
									long codigoLivro = ler.nextLong();
									ler.nextLine();
									String autorLivro = ler.nextLine();
									System.out.println("Digite o código do livro que você quer alterar: ");
									long codigoAlterar = ler.nextLong();
									livroController.alterar(nomeLivro, codigoLivro, autorLivro, codigoAlterar);
									ler.nextLine();
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente nome, código e autor (nesta ordem) ");
									} else {
										System.out.println(
												"Dados inválidos! Digite novamente nome, código e autor (nesta ordem): ");
									}
								}
							}
							System.out.println("Deseja modificar mais algum livro cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 4:

						do {
							System.out.println("Digite o código do livro que deseja remover");
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
												+ " Digite novamente o código do livro que deseja remover: ");
									} else {
										System.out.println(
												"Dados inválidos! Digite novamente o código do livro que deseja remover: ");
									}
								}
							}
							System.out.println("Deseja remover mais algum livro cadastrado? (s/n)");
							resp = ler.next().charAt(0);
						} while (resp == 's');
						break;

					case 5:

						do {
							System.out.println("Digite o código do livro para realizar a consulta: ");
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
												+ " Digite novamente o código do livro para realizar a consulta: ");
									} else {
										System.out.println(
												"Dados inválidos! Digite novamente o código do livro para realizar a consulta: ");
									}
								}
							}

							System.out.println("Deseja consultar mais algum livro cadastrado? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					default:
						System.out.println("Opção inválida!");
						break;
					}
					System.out.println("Deseja retornar ao Menu de Livros? (s/n)");
					resp = ler.next().charAt(0);
				} while (resp == 's');
				break;
			case 4:
				System.out.println("Digite o cpf do funcionario que está realizando a operação");
				long cpfFuncionarioEmprestimo;
				while (true) {
					try {
						cpfFuncionarioEmprestimo = ler.nextLong();
						funcionarioController.existe(cpfFuncionarioEmprestimo);
						break;
					} catch (Exception e) {
						ler.nextLine();
						System.out.println("Funcionario não cadastrado! Digite o cpf do funcionário novamente:");
					}
				}
				do {
					int m;
					while (true) {
						try {
							System.out.println("Digite um dos números abaixo para executar uma das operações: "
									+ "\n 1 - Realizar empréstimos de livros"
									+ "\n 2 - Imprimir todos os empréstimos cadastrados"
									+ "\n 3 - Renovar empréstimo realizado" + "\n 4 - Devolução de livro"
									+ "\n 5 - Consultar empréstimos de um leitor");
							m = ler.nextInt();
							break;
						} catch (Exception e) {
							ler.nextLine();
							System.out.println("Dígito inválido!");
						}
					}

					switch (m) {
					case 1:

						do {

							System.out.println("Digite a matrícula/cpf do leitor que está realizando o empréstimo");
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

							System.out.println("Digite o código do livro que o leitor quer emprestado");

							long codigoLivroEmprestado;
							while (true) {
								try {
									codigoLivroEmprestado = ler.nextLong();
									livroController.existe(codigoLivroEmprestado);
									break;
								} catch (Exception e) {
									ler.nextLine();
									System.out.println(e.getMessage() + " Digite o código do livro novamente");
								}
							}

							try {
								emprestimoController.inserir(funcionarioController.consultar(cpfFuncionarioEmprestimo),
										leitorController.consultar(cpfLeitorEmprestimo),
										livroController.consultar(codigoLivroEmprestado));
								System.out.println("Empréstimo realizado com sucesso!");
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
//							if (emprestimoController.consultarDisponibilidade(codigoLivroEmprestado)) {
//								emprestimoController.inserir(funcionarioController.consultar(cpfFuncionarioEmprestimo),
//										leitorController.consultar(cpfLeitorEmprestimo),
//										livroController.consultar(codigoLivroEmprestado));
//								System.out.println("Empréstimo realizado com sucesso!");
//							} else {
//								System.out.println("Livro indisponível");
//							}

							System.out.println("Deseja realizar mais algum empréstimo? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 2:
						System.out.println("--------- Lista de Todos os Empréstimos ---------");
						System.out.println("------------------------------------");
						for (Emprestimo emprestimo : emprestimoController.retornarTodos()) {
							System.out.println(emprestimo);
						}
						break;

					case 3:

						do {

							System.out.println("Digite o cpf do leitor e o código do livro a ser renovado: ");
							while (true) {
								try {
									long cpfLeitor = ler.nextLong();
									long codigoLivro = ler.nextLong();

									emprestimoController.renovar(leitorController.consultar(cpfLeitor),
											livroController.consultar(codigoLivro),
											funcionarioController.consultar(cpfFuncionarioEmprestimo));
									break;
								} catch (Exception e) {
									ler.nextLine();
									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o cpf do leitor e o código do livro a ser renovado: ");
									} else {
										System.out.println(
												"Dados inválidos! Digite novamente o cpf do leitor e o código do livro a ser renovado: ");
									}
								}
							}
							System.out.println("Deseja renovar mais algum empréstimo? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					case 4:

						do {
							System.out.println("Digite o nome do leitor e o código do livro a ser devolvido: ");
							ler.nextLine();
							while (true) {
								long cpfLeitor;
								long codigoLivro;
								try {

									cpfLeitor = ler.nextLong();
									codigoLivro = ler.nextLong();

									emprestimoController.removerEmprestimoLivro(cpfLeitor, codigoLivro);
									break;
								} catch (Exception e) {

									if (e.getMessage() != null) {
										System.out.println(e.getMessage()
												+ " Digite novamente o nome do leitor e o código do livro a ser devolvido: ");
										break;
									} else {
										System.out.println(
												"Dados inválidos! Digite novamente o nome do leitor e o código do livro a ser devolvido: ");
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
												"Dados inválidos! Digite novamente o cpf para realizar a consulta: ");
									}
								}
							}

							System.out.println("Deseja consultar mais empréstimos de algum leitor? (s/n)");
							resp = ler.next().charAt(0);

						} while (resp == 's');
						break;

					default:
						System.out.println("Opção inválida!");
						break;
					}
					System.out.println("Deseja retornar ao Menu de Empréstimos? (s/n)");
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
