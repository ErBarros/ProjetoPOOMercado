import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import controller.AlmoxarifeController;
import controller.CaixaEletronicoController;
import controller.GerenteController;
import controller.ProdutoController;
import model.Produto;
import model.ProdutoRepository;
import view.*;

public class Main {
    public static void main(String[] args) {
        // Cria e exibe a tela de cadastro de gerente
        GerenteController gerenteController = new GerenteController();
        TelaCadastroGerente telaCadastroGerente = new TelaCadastroGerente(gerenteController);
        telaCadastroGerente.setVisible(true);

        // Cria e exibe a tela de autenticação
        TelaAutenticacao telaAutenticacao = new TelaAutenticacao(gerenteController);
        telaAutenticacao.setVisible(true);

        // Cria e exibe a tela de cadastro de almoxarife
        AlmoxarifeController almoxarifeController = new AlmoxarifeController();
        TelaCadastroAlmoxarife telaCadastroAlmoxarife = new TelaCadastroAlmoxarife(almoxarifeController);
        telaCadastroAlmoxarife.setVisible(true);

        // Cria e exibe a tela de cadastro de caixa eletrônico
        CaixaEletronicoController caixaController = new CaixaEletronicoController();
        TelaCadastroCaixaEletronico telaCadastroCaixa = new TelaCadastroCaixaEletronico(caixaController);
        telaCadastroCaixa.setVisible(true);

        // Cria alguns produtos de exemplo
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("P001", "Produto A", "Unidade", 10.0, 15.0, 100));
        produtos.add(new Produto("P002", "Produto B", "Unidade", 20.0, 25.0, 50));

        // Cria a visão para exibir a lista de produtos
        ProdutoView produtoView = new ProdutoView();

        // Cria o repositório de produtos
        ProdutoRepository produtoRepository = new ProdutoRepository();

        // Cria o controlador de produtos, passando a visão, a lista de produtos e o repositório
        ProdutoController produtoController = new ProdutoController(produtoView, produtos, produtoRepository);

        // Cria e exibe a tela de cadastro de produtos, passando o controlador
        TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(produtoController);
        telaCadastroProduto.setVisible(true);

        // Exibe a visão de produtos
        produtoView.setVisible(true);
    }
}
