package controller;

import model.Produto;
import model.ProdutoRepository;
import view.ProdutoDetailView;
import view.ProdutoView;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class ProdutoController {

    private ProdutoView produtoView;
    private List<Produto> produtos;
    private ProdutoRepository repository;

    public ProdutoController(ProdutoView produtoView, List<Produto> produtos, ProdutoRepository repository) {
        this.produtoView = produtoView;
        this.produtos = produtos;
        this.repository = repository;
        this.produtoView.setProdutos(produtos);

        this.produtoView.addDetalhesButtonListener(e -> showProdutoDetails());
    }

    public ProdutoController() {
        this.repository = new ProdutoRepository();
    }

    private void showProdutoDetails() {
        int selectedRow = produtoView.getSelectedRow();
        if (selectedRow >= 0) {
            Produto selectedProduto = produtos.get(selectedRow);
            ProdutoDetailView detailView = new ProdutoDetailView(this); // Passa o controlador para a visão
            detailView.setProduto(selectedProduto);
            detailView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(produtoView, "Por favor, selecione um produto.");
        }
    }

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
        produtos.add(produto);
        produtoView.setProdutos(produtos);
    }

    public void atualizarProduto(Produto produto) {
        repository.atualizarProduto(produto);
        // Atualiza a visualização
        int index = produtos.indexOf(produto);
        if (index != -1) {
            produtos.set(index, produto);
            produtoView.setProdutos(produtos);
        }
    }

    public void excluirProduto(Produto produto) {
        repository.removerProduto(produto);
        produtos.remove(produto);
        produtoView.setProdutos(produtos);
    }
}
