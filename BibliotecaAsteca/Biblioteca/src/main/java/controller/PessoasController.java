package controller;

import factory.BibliotecaFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.pessoa.Pessoa;
import repository_jpa.PessoaRepository;

import java.util.List;
import java.util.Scanner;

public class PessoasController {
    private Scanner scanner = new Scanner(System.in);

    public PessoasController() {
        PessoaRepository pessoas = new PessoaRepository();
    }

    public void criarPessoa() {
        System.out.println("Digite os dados da nova pessoa:");


        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("A pessoa é um Cliente [C] ou Funcionário [F]? ");
        String tipo = scanner.nextLine().trim().toUpperCase();
        if (tipo.equals("C")) {

            Cliente cliente = new Cliente(nome, cpf, email, endereco, telefone);

            PessoaRepository.salvar(cliente);
            System.out.println("Cliente criado com sucesso! ID: " + cliente.getId());
        } else if (tipo.equals("F")) {

            System.out.print("Digite o Cargo do Funcionário: ");
            String cargo = scanner.nextLine();
            Funcionario funcionario = new Funcionario(nome, cpf, email, endereco, telefone, cargo);

            PessoaRepository.salvar(funcionario);
            System.out.println("Funcionário criado com sucesso! ID: " + funcionario.getId());
        } else {
            System.out.println("Tipo inválido. A pessoa não foi criada.");
        }
    }

    public void criarCliente() {
        System.out.println("Digite os dados do novo cliente:");


        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();


        Cliente cliente = new Cliente(nome, cpf, email, endereco, telefone);


        PessoaRepository.salvarCliente(cliente);
        System.out.println("Cliente criado com sucesso! ID: " + cliente.getId());
    }

    public void criarFuncionario() {
        System.out.println("Digite os dados do novo funcionário:");


        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();


        System.out.print("Digite o Cargo do Funcionário: ");
        String cargo = scanner.nextLine();


        Funcionario funcionario = new Funcionario(nome, cpf, email, endereco, telefone, cargo);


        PessoaRepository.salvarFuncionario(funcionario);
        System.out.println("Funcionário criado com sucesso! ID: " + funcionario.getId());
    }

    public void removerClientePorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do cliente a ser removido: ");
        long id = scanner.nextLong();


        PessoaRepository.removerClientePorId(id);
    }

    public void removerFuncionarioPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do funcionário a ser removido: ");
        long id = scanner.nextLong();


        PessoaRepository.removerFuncionarioPorId(id);
    }

    public void listarFuncionarios() {
        List<Funcionario> funcionarios = PessoaRepository.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    public void listarClientes() {
        List<Cliente> clientes = PessoaRepository.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    public void atualizarCliente() {
        System.out.print("Digite o ID do cliente a ser atualizado: ");
        long id = Long.parseLong(scanner.nextLine());

        Cliente clienteExistente = (Cliente) PessoaRepository.getClienteById(id);

        if (clienteExistente != null) {
            System.out.println("Deixe os campos em branco para não alterar os valores.");

            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isBlank()) clienteExistente.setNome(novoNome);

            System.out.print("Novo CPF: ");
            String novoCpf = scanner.nextLine();
            if (!novoCpf.isBlank()) clienteExistente.setCpf(novoCpf);

            System.out.print("Novo Email: ");
            String novoEmail = scanner.nextLine();
            if (!novoEmail.isBlank()) clienteExistente.setEmail(novoEmail);

            System.out.print("Novo Endereço: ");
            String novoEndereco = scanner.nextLine();
            if (!novoEndereco.isBlank()) clienteExistente.setEndereco(novoEndereco);

            System.out.print("Novo Telefone: ");
            String novoTelefone = scanner.nextLine();
            if (!novoTelefone.isBlank()) clienteExistente.setTelefone(novoTelefone);

            PessoaRepository.atualizarCliente(clienteExistente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente com ID " + id + " não encontrado.");
        }
    }


    public void atualizarFuncionario() {
        System.out.print("Digite o ID do funcionário a ser atualizado: ");
        long id = Long.parseLong(scanner.nextLine());

        Funcionario funcionarioExistente = PessoaRepository.getFuncionarioById(id);

        if (funcionarioExistente != null) {
            System.out.println("Deixe os campos em branco para não alterar os valores.");
            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isBlank()) funcionarioExistente.setNome(novoNome);

            System.out.print("Novo CPF: ");
            String novoCpf = scanner.nextLine();
            if (!novoCpf.isBlank()) funcionarioExistente.setCpf(novoCpf);

            System.out.print("Novo Email: ");
            String novoEmail = scanner.nextLine();
            if (!novoEmail.isBlank()) funcionarioExistente.setEmail(novoEmail);

            System.out.print("Novo Endereço: ");
            String novoEndereco = scanner.nextLine();
            if (!novoEndereco.isBlank()) funcionarioExistente.setEndereco(novoEndereco);

            System.out.print("Novo Telefone: ");
            String novoTelefone = scanner.nextLine();
            if (!novoTelefone.isBlank()) funcionarioExistente.setTelefone(novoTelefone);

            System.out.print("Novo Cargo (deixe em branco para não alterar): ");
            String novoCargo = scanner.nextLine();
            if (!novoCargo.isBlank()) {
                funcionarioExistente.setCargo(novoCargo);
            }

            PessoaRepository.atualizarFuncionario(funcionarioExistente);
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário com ID " + id + " não encontrado.");
        }
    }
}
