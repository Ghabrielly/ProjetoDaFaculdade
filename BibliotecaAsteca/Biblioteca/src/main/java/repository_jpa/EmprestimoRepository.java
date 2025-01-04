package repository_jpa;

import factory.BibliotecaFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.emprestimo.Emprestimo;

import java.util.List;
import java.util.UUID;

public class EmprestimoRepository {
    private static EntityManager entityManager;

    public static void salvar(Emprestimo emprestimo) {
        EntityManager entityManager = BibliotecaFactory.getEntityManager();
        try {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.getTransaction().begin();
            entityManager.persist(emprestimo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public static Emprestimo getById(long id) {
        entityManager = BibliotecaFactory.getEntityManager();
        try {
            return entityManager.find(Emprestimo.class, id);
        } finally {
            entityManager.close();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Emprestimo> listarTodos() {
        entityManager = BibliotecaFactory.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT e FROM Emprestimo e", Emprestimo.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public static void removerPorId(long id) {

        entityManager = BibliotecaFactory.getEntityManager();
        try {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
            }


            entityManager.getTransaction().begin();


            Emprestimo emprestimo = entityManager.find(Emprestimo.class, id);
            if (emprestimo != null) {

                entityManager.remove(emprestimo);

                entityManager.getTransaction().commit();
                System.out.println("Empréstimo removido com sucesso!");
            } else {
                System.out.println("Empréstimo não encontrado com o ID " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {

                entityManager.close();
            }
        }
    }

    public static void atualizarEmprestimo(Emprestimo emprestimoExistente) {
        entityManager = BibliotecaFactory.getEntityManager();
        try {

            if (entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().commit();
            }

            entityManager.getTransaction().begin();

            entityManager.merge(emprestimoExistente);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
