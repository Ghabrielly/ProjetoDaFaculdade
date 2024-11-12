package view;

import model.emprestimo.Multa;
import model.livro.Livro;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.pessoa.Pessoa;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente pessoa = new Cliente();
        Pessoa funcionario = new Funcionario();
        Multa emprestimo = new Multa();
        Livro livro = new Livro();

        int opcao;

        do {
            System.out.println("\n--Bibliotaca Asteca--\n");

            System.out.println("Menu Principal:");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Exibição");
            System.out.println("3 - Deleção");
            System.out.println("4 - Atualização");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: {
                    int opCadastro;
                    do {
                        System.out.println("\nMenu de Cadastro:");
                        System.out.println("1 - Cadastrar Livro");
                        System.out.println("2 - Cadastrar Cliente");
                        System.out.println("3 - Cadastrar Funcionário");
                        System.out.println("4 - Cadastrar Empréstimo");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        opCadastro = scanner.nextInt();
                        switch (opCadastro) {
                            case 1:
                                livro.cadastrarLivro();
                                break;
                            case 2:
                                pessoa.cadastrarPessoa();
                                break;
                            case 3:
                                funcionario.cadastrarPessoa();
                                break;
                            case 4:
                                emprestimo.realizarEmprestimo();
                                break;
                        }
                    } while (opCadastro != 0);
                    break;
                }
                case 2: {
                    int opExibicao;
                    do {
                        System.out.println("\nMenu de Exibição:");
                        System.out.println("1 - Exibir Livros");
                        System.out.println("2 - Exibir Clientes");
                        System.out.println("3 - Exibir Funcionários");
                        System.out.println("4 - Exibir Empréstimos");
                        System.out.println("5 - Exibir Valor da Multa");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        opExibicao = scanner.nextInt();

                        switch (opExibicao) {
                            case 1:
                                System.out.println(livro.toString());
                                break;
                            case 2:
                                System.out.println(pessoa.toString());
                                break;
                            case 3:
                                System.out.println(funcionario.toString());
                                break;
                            case 4:
                                System.out.println(emprestimo.toString());
                                break;
                            case 5:
                                System.out.println(emprestimo.verificarDevolucaoAtrasada());
                                break;
                        }
                    } while (opExibicao != 0);
                    break;
                }
                case 3: {
                    int opDelecao;
                    do {
                        System.out.println("\nMenu de Deleção:");
                        System.out.println("1 - Deletar Livro");
                        System.out.println("2 - Deletar Cliente");
                        System.out.println("3 - Deletar Funcionário");
                        System.out.println("4 - Deletar Empréstimo");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        opDelecao = scanner.nextInt();

                        switch (opDelecao){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                System.out.println("Em Desenvolvimento, volte mais tarde.");
                                break;
                        }
                    } while (opDelecao != 0);
                    break;
                }
                case 4: {
                    int opAtualiza;
                    do {
                        System.out.println("\nMenu de Atualização:");
                        System.out.println("1 - Atualizar Livro");
                        System.out.println("2 - Atualizar Cliente");
                        System.out.println("3 - Atualizar Funcionário");
                        System.out.println("4 - Atualizar Empréstimo");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        opAtualiza = scanner.nextInt();

                        switch (opAtualiza){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                System.out.println("Em Desenvolvimento, volte mais tarde.");
                                break;
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
