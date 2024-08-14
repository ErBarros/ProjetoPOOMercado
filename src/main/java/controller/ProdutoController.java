

package controller;

import model.Produto;
import model.ProdutoRepository;

import java.util.Map;

public class ProdutoController {

    private ProdutoRepository repository = new ProdutoRepository();

    public void cadastrarProduto(Map<String, String> dados) {
        String codigo = repository.gerarCodigoProduto();
        Produto produto = new Produto(
                codigo,
                dados.get("nome"),
                dados.get("unidade"),
                Double.parseDouble(dados.get("valorCompra")),
                Double.parseDouble(dados.get("valorVenda")),
                Integer.parseInt(dados.get("quantidadeEstoque"))
        );
        repository.adicionarProduto(produto);
    }
    public void atualizarEstoque(Produto produto, int quantidade) {
        produto.atualizarEstoque(quantidade);
    }

    public void atualizarValorVenda(Produto produto, double valor) {
        produto.atualizarValorVenda(valor);
    }
}
