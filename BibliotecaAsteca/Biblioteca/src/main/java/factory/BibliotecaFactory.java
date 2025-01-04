package factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BibliotecaFactory {
    public static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("Biblioteca-Asteca");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    public static void saveAndClose(EntityManager em) {
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
