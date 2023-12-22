package com.test;

import com.model.Categoria;
import com.connection.ConnectionFactory;

import javax.persistence.EntityManager;

public class CategoriaTest {
    public static void main(String[] args) {

        Categoria categoria=new Categoria();
        categoria.setDescricao("Java Pleno");

        EntityManager entityManager=new ConnectionFactory().getConnection();

        // INICIANDO TRANSAÇÃO
        entityManager.getTransaction().begin();

        // PERSISTINDO NO BANCO
        entityManager.persist(categoria);

        //COMITAR TRANSAÇÃO
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
