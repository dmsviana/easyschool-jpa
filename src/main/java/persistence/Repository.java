package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class Repository {

    protected EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EasyPU");
        return factory.createEntityManager();
    }
}
