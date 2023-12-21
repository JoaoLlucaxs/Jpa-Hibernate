package com.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    private static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Categorize-PU");;

    public EntityManager getConnection(){
        return entityManagerFactory.createEntityManager();
    }
}
