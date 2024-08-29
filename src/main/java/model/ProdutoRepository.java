package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que gerencia o armazenamento e manipulação de produtos.
 */
public class ProdutoRepository {

    private static int sequencial = 1; // Contador para gerar códigos sequenciais
    private Map<String, Produto> produtos = new HashMap<>(); // Mapa para armazenar produtos com código como chave

    /**
     * Gera um código único para um novo produto.
     * @return O código gerado
     */
    public String gerarCodigoProduto() {
        String codigo = String.format("%05d", sequencial++); // Gera um código sequencial formatado
        return codigo;
    }

    /**
     * Adiciona um produto ao repositório.
     * @param produto O produto a ser adicionado
     */
    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getCodigo(), produto); // Adiciona o produto ao mapa
    }

    /**
     * Atualiza as informações de um produto existente no repositório.
     * @param produto O produto a ser atualizado
     */
    public void atualizarProduto(Produto produto) {
        produtos.put(produto.getCodigo(), produto); // Atualiza o produto no mapa
    }

    /**
     * Remove um produto do repositório.
     * @param produto O produto a ser removido
     */
    public void removerProduto(Produto produto) {
        produtos.remove(produto.getCodigo()); // Remove o produto do mapa
    }

    /**
     * Busca um produto no repositório pelo código.
     * @param codigo O código do produto
     * @return O produto correspondente ao código
     */
    public Produto buscarProduto(String codigo) {
        return produtos.get(codigo); // Retorna o produto do mapa
    }


}
