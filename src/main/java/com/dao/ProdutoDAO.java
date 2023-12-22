package com.dao;

import com.connection.ConnectionFactory;
import com.model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {
    private static EntityManager em;

    public Produto salvar(Produto produto){
        em=new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            if(produto.getId() == null){
                em.persist(produto);
            }else{
                em.merge(produto);
            }
            em.getTransaction().commit();

        }catch (Exception e){
            //Desfaz tudo com rollback caso caia no catch
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
       return produto;
    }

    public Produto buscarPorId(Integer id){
        em=new ConnectionFactory().getConnection();
        Produto produto=null;

        try {
            produto=em.find(Produto.class,id);
        }catch (Exception e){
            System.out.println("Ocorreu um erro " + e.getMessage());
        }finally {
            em.close();
        }
        return produto;
    }

    public List<Produto> listarProduto(){
        em=new ConnectionFactory().getConnection();
        List<Produto> produtos=null;
        try {
            produtos=em.createQuery("from Produto").getResultList(); // JPQL
        }catch (Exception e){

        }finally {
            em.close();
        }
        return produtos;
    }

    public Produto removerPorId(Integer id){
        em=new ConnectionFactory().getConnection();
        Produto produto=null;

        try {
            produto=em.find(Produto.class,id);

            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();

        }catch (Exception e){
            System.out.println("Error " + e);
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return produto;
    }
}
