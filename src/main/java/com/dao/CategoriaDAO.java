package com.dao;

import com.connection.ConnectionFactory;
import com.model.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {

    private static EntityManager em;
    public Categoria salvar(Categoria categoria){
        em=new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();

            // PERSISTINDO NO BANCO
            if(categoria.getId() == null){
                em.persist(categoria);
            }else{
                em.merge(categoria);
            }

            //COMITAR TRANSAÇÃO
            em.getTransaction().commit();

        }catch (Exception e){
            System.out.println("Error " + e);
            //Desfaz tudo com rollback
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return categoria;
    }

    public Categoria findById(Integer id){
        em=new ConnectionFactory().getConnection();
        Categoria categoria=null;

        try {
            // Trabalhando com consulta não preciso realizar transações
            categoria=em.find(Categoria.class,id);

        }catch (Exception e){
            System.out.println("Error " + e);

            // Não insiro rollback pois não estou fazendo transações
            //em.getTransaction().rollback();

        }finally {
            em.close();
        }
        return categoria;
    }

    public List<Categoria> listarCategorias(){
        em=new ConnectionFactory().getConnection();
        List<Categoria> categorias=null;
        try {
            categorias=em.createQuery("from Categoria").getResultList(); // JPQL
        }catch (Exception  e){
            System.out.println("Error " + e.getMessage());
        }finally {
            em.close();
        }
        return categorias;
    }

    public Categoria removerPorId(Integer id){

        em=new ConnectionFactory().getConnection();
        Categoria categoria=null;

        try {
           categoria=em.find(Categoria.class,id);

            em.getTransaction().begin();

            em.remove(categoria);

            em.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return categoria;
    }
}
