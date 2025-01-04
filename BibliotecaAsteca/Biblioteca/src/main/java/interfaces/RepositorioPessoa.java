package interfaces;

import model.pessoa.Pessoa;

import java.util.List;

public interface RepositorioPessoa {
    void criar(Pessoa pessoa);

    Pessoa procurarPorId(long id);

    Pessoa remover(long id);

    void atualizar(Pessoa pessoa);

    List<Pessoa> listarTodas();
}