package com.test;

import com.dao.ProdutoDAO;
import com.model.Categoria;
import com.model.Produto;

public class ProdutoTest {

    public static void main(String[] args) {
        ProdutoDAO dao=new ProdutoDAO();

        Categoria categoria=new Categoria();
        categoria.setId(3);

        Produto produto=new Produto();
        produto.setDescricao("Curso Java Intermediario");
        produto.setQtd(2);
        produto.setValor(49.90);
        produto.setCategoria(categoria);

        //dao.salvar(produto);

        System.out.println("=========================BUSCA POR ID==============================");
        produto=dao.buscarPorId(3);
        System.out.println("PRODUTO =  " + produto.getDescricao());

        System.out.println("==========================LISTAR TODOS===================================");

        for (Produto prod: dao.listarProduto()){
            System.out.println("Produtos " + prod.getDescricao());

        }
    // FORMA 2 DE LISTAGEM
        dao.listarProduto().stream().map((produto1)->{
            System.out.println("DESCRIÇÃO " + produto1.getDescricao());
            return produto1;
        }).map((produto1)->{
            System.out.println("QTD " + produto1.getQtd());
            return produto1;
        }).map((produto1)->{
            System.out.println("VALOR " + produto1.getValor());
            return produto1;
        }).forEachOrdered((produto1) ->{
            System.out.println("CATEGORIA " + produto1.getCategoria().getDescricao());
        } );

        System.out.println("=========================== REMOVER======================================");
        produto=dao.removerPorId(3);
        System.out.println("Produto removido " + produto.getId());
    }

}
