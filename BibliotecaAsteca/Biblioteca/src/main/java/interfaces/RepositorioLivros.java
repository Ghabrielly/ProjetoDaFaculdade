package interfaces;

import model.livro.Livro;

import java.util.List;

public interface RepositorioLivros {
    void criar(Livro livro);

    Livro procurarPorId(long idLivro);

    void remover(long idLivro);

    void atualizar(Livro livro);

    List<Livro> listarTodos();
}