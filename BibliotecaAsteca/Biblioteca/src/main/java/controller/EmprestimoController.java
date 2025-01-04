package controller;

import model.emprestimo.Emprestimo;
import repository_jpa.EmprestimoRepository;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class EmprestimoController {
    private final Scanner scanner;
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoController() {
        this.scanner = new Scanner(System.in);
        this.emprestimoRepository = new EmprestimoRepository();
    }


    public void criarEmprestimo() {
        System.out.println("Digite os dados do novo empréstimo:");

        System.out.print("Status: ");
        String status = scanner.nextLine();

        System.out.print("Data do Empréstimo (yyyy-MM-dd): ");
        String dataEmprestimo = scanner.nextLine();

        System.out.print("Data de Devolução Prevista (yyyy-MM-dd): ");
        String dataDevolucaoPrevista = scanner.nextLine();

        System.out.print("Data de Devolução (yyyy-MM-dd): ");
        String dataDevolucao = scanner.nextLine();

        Emprestimo emprestimo = new Emprestimo(status, dataEmprestimo, dataDevolucao, dataDevolucaoPrevista);

        EmprestimoRepository.salvar(emprestimo);
        System.out.println("Empréstimo criado com sucesso! ID: " + emprestimo.getIdEmprestimo());
    }

    public void buscarEmprestimoPorId() {
        System.out.print("Digite o ID do empréstimo: ");
        long id = Long.parseLong(scanner.nextLine());

        Emprestimo emprestimo = EmprestimoRepository.getById(id);
        if (emprestimo != null) {
            System.out.println("Empréstimo encontrado:\n" + emprestimo);
        } else {
            System.out.println("Empréstimo com ID " + id + " não encontrado.");
        }
    }

    public void removerEmprestimo() {
        System.out.print("Digite o ID do empréstimo a ser removido: ");
        long id = Long.parseLong(scanner.nextLine());

        EmprestimoRepository.removerPorId(id);
        System.out.println("Empréstimo removido com sucesso!");
    }

    public void listarTodosEmprestimos() {
        List<Emprestimo> emprestimos = EmprestimoRepository.listarTodos();
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo cadastrado.");
        } else {
            System.out.println("Lista de Empréstimos:");
            emprestimos.forEach(System.out::println);
        }
    }

    public void atualizarEmprestimo() {
        System.out.print("Digite o ID do empréstimo a ser atualizado: ");
        long id = Long.parseLong(scanner.nextLine());

        Emprestimo emprestimoExistente = EmprestimoRepository.getById(id);
        if (emprestimoExistente != null) {
            System.out.println("Deixe os campos em branco para não alterar os valores.");

            System.out.print("Novo Status: ");
            String novoStatus = scanner.nextLine();
            if (!novoStatus.isBlank()) emprestimoExistente.setStatus(novoStatus);

            System.out.print("Nova Data do Empréstimo (yyyy-MM-dd): ");
            String novaDataEmprestimo = scanner.nextLine();
            if (!novaDataEmprestimo.isBlank()) emprestimoExistente.setDataEmprestimo(novaDataEmprestimo);

            System.out.print("Nova Data de Devolução Prevista (yyyy-MM-dd): ");
            String novaDataPrevista = scanner.nextLine();
            if (!novaDataPrevista.isBlank()) emprestimoExistente.setDataDevolucaoPrevista(novaDataPrevista);

            System.out.print("Nova Data de Devolução (yyyy-MM-dd): ");
            String novaDataDevolucao = scanner.nextLine();
            if (!novaDataDevolucao.isBlank()) emprestimoExistente.setDataDevolucao(novaDataDevolucao);

            EmprestimoRepository.atualizarEmprestimo(emprestimoExistente);
            System.out.println("Empréstimo atualizado com sucesso!");
        } else {
            System.out.println("Empréstimo com ID " + id + " não encontrado.");
        }
    }
}
