package repository;

import interfaces.RepositorioLivros;
import model.livro.Livro;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLivroLista implements RepositorioLivros {
    private List<Livro> livros;

    public RepositorioLivroLista() {
        this.livros = new ArrayList<>();
    }

    @Override
    public void criar(Livro livro) {
        livros.add(livro);
    }


    @Override
    public Livro procurarPorId(long idLivro) {
        for (Livro livro : livros) {
            if (livro.getIdLivro() == idLivro) {
                return livro;
            }
        }
        System.out.println("Livro com ID " + idLivro + " não encontrado.");
        return null;
    }


    @Override
    public void remover(long idLivro) {
        boolean removido = livros.removeIf(l -> l.getIdLivro() == idLivro);
        if (!removido) {
            System.out.println("Nenhum livro com ID " + idLivro + " foi encontrado para remoção.");
        } else {
            System.out.println("Livro com ID " + idLivro + " removido com sucesso da lista.");
        }
    }

    @Override
    public void atualizar(Livro livro) {
        boolean atualizado = false;
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getIdLivro() == livro.getIdLivro()) {
                livros.set(i, livro);
                atualizado = true;
                break;
            }
        }
        if (!atualizado) {
            System.out.println("Livro com ID " + livro.getIdLivro() + " não encontrado para atualização.");
        }
    }

    @Override
    public List<Livro> listarTodos() {
        return new ArrayList<>(livros);
    }
}
