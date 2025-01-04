package controller;

import model.livro.Livro;
import repository_jpa.LivroRepository;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class LivrosController {
    private Scanner scanner;
    private LivroRepository livroRepository;

    public LivrosController() {
        this.scanner = new Scanner(System.in);
        this.livroRepository = new LivroRepository();
    }

    public void criarLivro() {
        System.out.println("Digite as informações do livro:");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Editora: ");
        String editora = scanner.nextLine();

        System.out.print("Localização: ");
        String localizacao = scanner.nextLine();

        System.out.print("Número de Exemplares: ");
        int numeroExemplares = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Idioma: ");
        String idioma = scanner.nextLine();

        if (titulo.isBlank() || autor.isBlank() || numeroExemplares <= 0) {
            System.out.println("Erro: Preencha todos os campos obrigatórios.");
            return;
        }

        Livro livro = new Livro(titulo, categoria, autor, editora, localizacao, numeroExemplares, idioma);

        try {
            LivroRepository.salvar(livro);
            System.out.println("Livro criado com sucesso! ID: " + livro.getIdLivro());
        } catch (Exception e) {
            System.out.println("Erro ao salvar o livro: " + e.getMessage());
        }
    }

    public void buscarLivroPorId() {
        System.out.print("Digite o ID do livro: ");
        try {
            long id = Long.parseLong(scanner.nextLine());

            Livro livro = LivroRepository.getById(id);
            if (livro != null) {
                System.out.println("Livro encontrado:\n" + livro);
            } else {
                System.out.println("Livro com ID " + id + " não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: O ID deve ser um número válido.");
        }
    }

    public void removerLivro() {
        System.out.print("Digite o ID do livro a ser removido: ");
        long id = Long.parseLong(scanner.nextLine());  // Captura o ID fornecido pelo usuário

        // Passa o ID correto para o método removerPorId
        LivroRepository.removerPorId(id);  // Passa o ID fornecido pelo usuário
        System.out.println("Livro removido com sucesso!");
    }


    public void listarTodosLivros() {
        List<Livro> livros = LivroRepository.listarTodos();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("Lista de Livros:");
            livros.forEach(System.out::println);
        }
    }

    public void atualizarLivro() {
        System.out.print("Digite o ID do livro a ser atualizado: ");
        long id = Long.parseLong(scanner.nextLine());

        Livro livroExistente = LivroRepository.getById(id);
        if (livroExistente != null) {
            System.out.println("Deixe os campos em branco para não alterar os valores.");

            System.out.print("Novo Título: ");
            String novoTitulo = scanner.nextLine();
            if (!novoTitulo.isBlank()) livroExistente.setTitulo(novoTitulo);

            System.out.print("Novo Autor: ");
            String novoAutor = scanner.nextLine();
            if (!novoAutor.isBlank()) livroExistente.setAutor(novoAutor);

            System.out.print("Nova Categoria: ");
            String novaCategoria = scanner.nextLine();
            if (!novaCategoria.isBlank()) livroExistente.setCategoria(novaCategoria);

            System.out.print("Nova Editora: ");
            String novaEditora = scanner.nextLine();
            if (!novaEditora.isBlank()) livroExistente.setEditora(novaEditora);

            System.out.print("Nova Localização: ");
            String novaLocalizacao = scanner.nextLine();
            if (!novaLocalizacao.isBlank()) livroExistente.setLocalizacao(novaLocalizacao);

            System.out.print("Novo Número de Exemplares: ");
            String novoNumeroExemplares = scanner.nextLine();
            if (!novoNumeroExemplares.isBlank()) {
                livroExistente.setNumeroExemplares(Integer.parseInt(novoNumeroExemplares));
            }

            System.out.print("Novo Idioma: ");
            String novoIdioma = scanner.nextLine();
            if (!novoIdioma.isBlank()) livroExistente.setIdioma(novoIdioma);

            LivroRepository.atualizarLivro(livroExistente);
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Livro com ID " + id + " não encontrado.");
        }
    }
}
