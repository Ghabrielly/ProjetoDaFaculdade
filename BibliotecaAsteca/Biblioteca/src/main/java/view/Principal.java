package view;

import controller.EmprestimoController;
import controller.LivrosController;
import controller.PessoasController;
import model.emprestimo.Multa;
import model.livro.Livro;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.pessoa.Pessoa;
import repository.RepositorioLivroLista;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal();
        LivrosController controllerLivro = new LivrosController();
        PessoasController controllerPessoa = new PessoasController();
        EmprestimoController controllerEmprestimo = new EmprestimoController();
        Multa emprestimo = new Multa();

        int opcao;

        do {
            System.out.println("\n--Biblioteca Asteca--\n");
            menu.menuPrincipal();

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {
                    int opCadastro;
                    do {
                        menu.menuCadastro();
                        opCadastro = scanner.nextInt();
                        scanner.nextLine();

                        switch (opCadastro) {
                            case 1:
                                controllerLivro.criarLivro();
                                break;
                            case 2:
                                controllerPessoa.criarCliente();
                                break;
                            case 3:
                                controllerPessoa.criarFuncionario();
                                break;
                            case 4:
                                controllerEmprestimo.criarEmprestimo();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (opCadastro != 0);
                    break;
                }
                case 2: {
                    int opExibicao;
                    do {
                        menu.menuExibir();
                        opExibicao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opExibicao) {
                            case 1:
                                controllerLivro.listarTodosLivros();
                                break;
                            case 2:
                                controllerPessoa.listarClientes();
                                break;
                            case 3:
                                controllerPessoa.listarFuncionarios();
                                break;
                            case 4:
                                controllerEmprestimo.listarTodosEmprestimos();
                                break;
                            case 5:
                                System.out.println(emprestimo.verificarDevolucaoAtrasada());
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (opExibicao != 0);
                    break;
                }
                case 3: {
                    int opDelecao;
                    do {
                        menu.menuDeletar();
                        opDelecao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opDelecao) {
                            case 1:
                                controllerLivro.removerLivro();
                                break;
                            case 2:
                                controllerPessoa.removerClientePorId();
                                break;
                            case 3:
                                controllerPessoa.removerFuncionarioPorId();
                                break;
                            case 4:
                                controllerEmprestimo.removerEmprestimo();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (opDelecao != 0);
                    break;
                }
                case 4: {
                    int opAtualiza;
                    do {
                        menu.menuAtualizar();
                        opAtualiza = scanner.nextInt();
                        scanner.nextLine();

                        switch (opAtualiza) {
                            case 1:
                                controllerLivro.atualizarLivro();
                                break;
                            case 2:
                                controllerPessoa.atualizarCliente();
                                break;
                            case 3:
                                controllerPessoa.atualizarFuncionario();
                                break;
                            case 4:
                                controllerEmprestimo.atualizarEmprestimo();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (opAtualiza != 0);
                    break;
                }
                case 0:
                    System.out.println("Saindo.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
