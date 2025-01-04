package repository;

import interfaces.RepositorioEmprestimo;
import model.emprestimo.Emprestimo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RepositorioEmprestimoListas implements RepositorioEmprestimo {
    private List<Emprestimo> emprestimos;

    public RepositorioEmprestimoListas() {
        this.emprestimos = new ArrayList<>();
    }

    @Override
    public void criar(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    @Override
    public Emprestimo procurarPorId(long idEmprestimo) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getIdEmprestimo() == idEmprestimo) {
                return emprestimo;
            }
        }
        return null;
    }

    @Override
    public void remover(long idEmprestimo) {
        emprestimos.removeIf(e -> e.getIdEmprestimo() == idEmprestimo);
    }

    @Override
    public void atualizar(Emprestimo emprestimo) {
        for (int i = 0; i < emprestimos.size(); i++) {
            if (emprestimos.get(i).getIdEmprestimo() == emprestimo.getIdEmprestimo()) {
                emprestimos.set(i, emprestimo);
                break;
            }
        }
    }

    @Override
    public List<Emprestimo> listarTodos() {
        return new ArrayList<>(emprestimos);
    }
}
