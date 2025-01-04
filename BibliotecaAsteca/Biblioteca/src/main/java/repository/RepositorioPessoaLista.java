package repository;

import interfaces.RepositorioPessoa;
import model.pessoa.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPessoaLista implements RepositorioPessoa {
    private List<Pessoa> pessoas;

    public RepositorioPessoaLista() {
        this.pessoas = new ArrayList<>();
    }

    @Override
    public void criar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    @Override
    public Pessoa procurarPorId(long id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        System.out.println("Pessoa com ID " + id + " não encontrada.");
        return null;
    }

    @Override
    public Pessoa remover(long id) {
        boolean removido = pessoas.removeIf(p -> p.getId() == id);
        if (!removido) {
            System.out.println("Nenhuma pessoa com ID " + id + " foi encontrada para remoção.");
        }
        return null;
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        boolean atualizado = false;
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == pessoa.getId()) {
                pessoas.set(i, pessoa);
                atualizado = true;
                break;
            }
        }
        if (!atualizado) {
            System.out.println("Pessoa com ID " + pessoa.getId() + " não encontrada para atualização.");
        }
    }

    @Override
    public List<Pessoa> listarTodas() {
        return new ArrayList<>(pessoas);
    }
}
