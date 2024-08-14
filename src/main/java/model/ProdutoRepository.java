package model;

import java.util.HashMap;
import java.util.Map;

public class ProdutoRepository {
    private static int sequencial = 1; // Contador para gerar códigos sequenciais
    private Map<String, Produto> produtos = new HashMap<>();

    public String gerarCodigoProduto() {
        String codigo = String.format("%05d", sequencial++);
        return codigo;
    }

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getCodigo(), produto);
    }

    public Produto buscarProduto(String codigo) {
        return produtos.get(codigo);
    }
}

