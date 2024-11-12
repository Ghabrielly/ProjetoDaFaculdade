package model.livro;

import java.util.Scanner;

public class Livro {
    private int idLivro;
    private String titulo;
    private String Autor;
    private String categoria;
    private String editora;
    private String localizacao;
    private int numeroExemplares;
    private String idioma;

    public Livro(int idLivro, String titulo, String categoria, String autor, String editora, String localizacao, int numeroExemplares, String idioma) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.categoria = categoria;
        Autor = autor;
        this.editora = editora;
        this.localizacao = localizacao;
        this.numeroExemplares = numeroExemplares;
        this.idioma = idioma;
    }

    public Livro() {
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void cadastrarLivro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID do livro: ");
        int idLivro = sc.nextInt();
        setIdLivro(idLivro);
        sc.nextLine();

        System.out.println("Digite o título do livro: ");
        String titulo = sc.nextLine();
        setTitulo(titulo);

        System.out.println("Digite o autor do livro: ");
        String autor = sc.nextLine();
        setAutor(autor);

        System.out.println("Digite a categoria do livro: ");
        String categoria = sc.nextLine();
        setCategoria(categoria);

        System.out.println("Digite a editora do livro: ");
        String editora = sc.nextLine();
        setEditora(editora);

        System.out.println("Digite a localização do livro: ");
        String localizacao = sc.nextLine();
        setLocalizacao(localizacao);

        System.out.println("Digite o número de exemplares do livro: ");
        int numeroExemplares = sc.nextInt();
        setNumeroExemplares(numeroExemplares);
        sc.nextLine();

        System.out.println("Digite o idioma do livro: ");
        String idioma = sc.nextLine();
        setIdioma(idioma);
    }

    public String toString() {
        return "ID do Livro: " + this.idLivro + " - " +
                "Título: " + this.titulo + " - " +
                "Autor: " + this.Autor + " - " +
                "Categoria: " + this.categoria + " - " +
                "Editora: " + this.editora + " - " +
                "Localização: " + this.localizacao + " - " +
                "Número de Exemplares: " + this.numeroExemplares + " - " +
                "Idioma: " + this.idioma;
    }

}
