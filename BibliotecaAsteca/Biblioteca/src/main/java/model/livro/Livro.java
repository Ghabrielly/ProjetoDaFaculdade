package model.livro;

import jakarta.persistence.*;

@Entity
@Table(name = "Livro")
@MappedSuperclass
public class Livro {
    @Id
    @Column(name = "idLivro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLivro;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String Autor;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "editora")
    private String editora;
    @Column(name = "localizacao")
    private String localizacao;
    @Column(name = "numeroExemplares")
    private int numeroExemplares;
    @Column(name = "idioma")
    private String idioma;

    public Livro(String titulo, String categoria, String autor, String editora, String localizacao, int numeroExemplares, String idioma) {
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

    public long getIdLivro() {
        return idLivro;
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
