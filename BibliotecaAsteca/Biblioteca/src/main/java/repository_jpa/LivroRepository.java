package repository_jpa;

import factory.BibliotecaFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.livro.Livro;

import java.util.List;

public class LivroRepository {
    private static EntityManager entityManager;


    public static void salvar(Livro livro) {
        EntityManager entityManager = BibliotecaFactory.getEntityManager();
        try {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            entityManager.getTransaction().begin();


            entityManager.persist(livro);


            entityManager.getTransaction().commit();
        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {

            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }


    public static Livro getById(long id) {
        entityManager = BibliotecaFactory.getEntityManager();
        try {
            return entityManager.find(Livro.class, id);
        } finally {
            entityManager.close();
        }
    }


    @SuppressWarnings("unchecked")
    public static List<Livro> listarTodos() {
        entityManager = BibliotecaFactory.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT l FROM Livro l", Livro.class);
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


            Livro livro = entityManager.find(Livro.class, id);
            if (livro != null) {

                entityManager.remove(livro);


                entityManager.getTransaction().commit();
                System.out.println("Livro removido com sucesso!");
            } else {
                System.out.println("Livro não encontrado com o ID " + id);
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


    public static void atualizarLivro(Livro livroExistente) {
        entityManager = BibliotecaFactory.getEntityManager();
        try {

            if (entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().commit();
            }

            entityManager.getTransaction().begin();

            entityManager.merge(livroExistente);

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
