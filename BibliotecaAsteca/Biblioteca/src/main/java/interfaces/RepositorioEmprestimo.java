package interfaces;

import model.emprestimo.Emprestimo;

import java.util.List;
import java.util.UUID;

public interface RepositorioEmprestimo {
    void criar(Emprestimo emprestimo);

    Emprestimo procurarPorId(long idEmprestimo);

    void remover(long idEmprestimo);

    void atualizar(Emprestimo emprestimo);

    List<Emprestimo> listarTodos();
}