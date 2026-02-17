package org.example.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerPersistence {
    private static final String unitName = "archiveLogConstraint";
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory(unitName);


    public static EntityManager getEntityManager(){
        return EMF.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em){
        em.close();
    }


}
