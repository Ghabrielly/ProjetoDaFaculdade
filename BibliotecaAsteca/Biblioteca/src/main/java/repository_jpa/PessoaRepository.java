package repository_jpa;

import factory.BibliotecaFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.pessoa.Pessoa;

import java.util.List;

public class PessoaRepository {
    private static EntityManager entityManager;

    public static void salvar(Pessoa pessoa) {
        EntityManager entityManager = BibliotecaFactory.getEntityManager();
        try {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
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

    public static Pessoa getById(long id) {
        entityManager = BibliotecaFactory.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.id = :id", Pessoa.class);
            query.setParameter("id", id);
            return (Pessoa) query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            entityManager.close();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Pessoa> listarTodos() {
        entityManager = BibliotecaFactory.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public static void salvarCliente(Cliente cliente) {
        entityManager = BibliotecaFactory.getEntityManager();
        try {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
            }

            entityManager.getTransaction().begin();

            entityManager.persist(cliente);

            entityManager.getTransaction().commit();
            System.out.println("Cliente salvo com sucesso!");
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


    public static void salvarFuncionario(Funcionario funcionario) {
        entityManager = BibliotecaFactory.getEntityManager();
        try {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
            }

            entityManager.getTransaction().begin();

            entityManager.persist(funcionario);

            entityManager.getTransaction().commit();
            System.out.println("Funcionário salvo com sucesso!");
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


    public static void atualizarCliente(Cliente clienteExistente) {
        entityManager = BibliotecaFactory.getEntityManager();
        try {

            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }

            Cliente cliente = entityManager.find(Cliente.class, clienteExistente.getId());
            if (cliente != null) {

                entityManager.merge(clienteExistente);

                entityManager.getTransaction().commit();
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Cliente com ID " + clienteExistente.getId() + " não encontrado.");
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

    public static void atualizarFuncionario(Funcionario funcionarioExistente) {
        entityManager = BibliotecaFactory.getEntityManager();
        try {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
            }

            entityManager.getTransaction().begin();

            entityManager.merge(funcionarioExistente);

            entityManager.getTransaction().commit();
            System.out.println("Funcionário atualizado com sucesso!");
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

    public static Cliente getClienteById(long id) {
        EntityManager entityManager = BibliotecaFactory.getEntityManager();
        Cliente cliente = null;
        try {
            cliente = entityManager.find(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return cliente;
    }

    public static Funcionario getFuncionarioById(long id) {
        entityManager = BibliotecaFactory.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT f FROM Funcionario f WHERE f.id = :id", Funcionario.class);
            query.setParameter("id", id);
            return (Funcionario) query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            entityManager.close();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Funcionario> listarTodosFuncionarios() {
        entityManager = BibliotecaFactory.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public static List<Cliente> listarClientes() {
        EntityManager entityManager = BibliotecaFactory.getEntityManager();
        try {

            Query query = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
            return query.getResultList();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public static List<Funcionario> listarFuncionarios() {
        EntityManager entityManager = BibliotecaFactory.getEntityManager();
        try {

            Query query = entityManager.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
            return query.getResultList();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public static void removerClientePorId(long id) {

        entityManager = BibliotecaFactory.getEntityManager();
        try {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
            }

            entityManager.getTransaction().begin();

            Cliente cliente = entityManager.find(Cliente.class, id);
            if (cliente != null) {

                entityManager.remove(cliente);

                entityManager.getTransaction().commit();
                System.out.println("Cliente com ID " + id + " removido com sucesso!");
            } else {
                System.out.println("Cliente com ID " + id + " não encontrado.");
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

    public static void removerFuncionarioPorId(long id) {

        entityManager = BibliotecaFactory.getEntityManager();
        try {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
            }


            entityManager.getTransaction().begin();


            Funcionario funcionario = entityManager.find(Funcionario.class, id);
            if (funcionario != null) {

                entityManager.remove(funcionario);

                entityManager.getTransaction().commit();
                System.out.println("Funcionário com ID " + id + " removido com sucesso!");
            } else {
                System.out.println("Funcionário com ID " + id + " não encontrado.");
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

}
