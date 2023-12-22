package com.test;

import com.dao.CategoriaDAO;
import com.model.Categoria;
import com.connection.ConnectionFactory;

import javax.persistence.EntityManager;

public class CategoriaTest {
    public static void main(String[] args) {

        Categoria categoria=new Categoria();
        categoria.setId(1);
        categoria.setDescricao("Java Trainee");


        CategoriaDAO dao=new CategoriaDAO();
        categoria=dao.salvar(categoria);

        System.out.println("ID" + categoria.getId());
        System.out.println("DESCRICAO " +categoria.getDescricao());

        //=============================================================================

        CategoriaDAO dao1=new CategoriaDAO();

        Categoria categoria1= dao1.findById(1);

        System.out.println("BUSCANDO POR ID " + categoria1.getDescricao());

    }
}
