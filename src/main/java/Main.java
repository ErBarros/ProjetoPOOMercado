import java.util.ArrayList;
import java.util.List;

import controller.AlmoxarifeController;
import controller.CaixaEletronicoController;
import controller.GerenteController;
import controller.ProdutoController;
import model.Almoxarife;
import model.Produto;
import model.ProdutoRepository;
import view.*;

public class Main {
    public static void main(String[] args) {

        //Lista de Produtos
        List<Produto> listaDeProdutosTeste = new ArrayList<>();

        // Cria e exibe a tela de cadastro de gerente
        GerenteController gerenteController = new GerenteController();
        TelaCadastroGerenteView telaCadastroGerente = new TelaCadastroGerenteView(gerenteController);
        telaCadastroGerente.setVisible(true);

        // Cria e exibe a tela de autenticação
        TelaAutenticacaoView telaAutenticacao = new TelaAutenticacaoView(gerenteController);
        telaAutenticacao.setVisible(true);

        // Cria e exibe a tela de cadastro de almoxarife
        AlmoxarifeController almoxarifeController = new AlmoxarifeController();
        TelaCadastroAlmoxarifeView telaCadastroAlmoxarife = new TelaCadastroAlmoxarifeView(almoxarifeController);
        telaCadastroAlmoxarife.setVisible(true);

        // Cria e exibe a tela de cadastro de caixa eletrônico
        CaixaEletronicoController caixaController = new CaixaEletronicoController();
        TelaCadastroCaixaEletronicoView telaCadastroCaixa = new TelaCadastroCaixaEletronicoView(caixaController);
        telaCadastroCaixa.setVisible(true);

        // Cria o repositório de produtos
        ProdutoRepository produtoRepository = new ProdutoRepository();

        // Adiciona alguns produtos ao repositório
        produtoRepository.adicionarProduto(new Produto("P001", "Produto A", "Unidade", 10.0, 15.0, 100, 15.0));
        produtoRepository.adicionarProduto(new Produto("P002", "Produto B", "Unidade", 20.0, 25.0, 50, 25.0));

        // Cria a visão para exibir a lista de produtos
        TelaProdutoView produtoView = new TelaProdutoView();

        // Cria o controlador de produtos, passando a visão e o repositório
        ProdutoController produtoController = new ProdutoController(produtoView, listaDeProdutosTeste, produtoRepository);

        // Cria e exibe a tela de cadastro de produtos, passando o controlador
        TelaCadastroProdutoView telaCadastroProduto = new TelaCadastroProdutoView(produtoController);
        telaCadastroProduto.setVisible(true);

        // Exibe a visão de produtos
        produtoView.setVisible(true);

        // Teste de tela criando um usuário Almoxarife.
        Almoxarife almoxarife = new Almoxarife("João", "joao123", "senhaSegura", "joao@example.com", "123456789");
        TelaEntradaEstoqueView view = new TelaEntradaEstoqueView(almoxarife);
        view.setVisible(true);

        // Inicializa a tela de gerente com o repositório de produtos
        TelaAtualizaValorView telaGerente = new TelaAtualizaValorView();
        GerenteController gerenteControllerComTela = new GerenteController(telaGerente, produtoRepository);
        telaGerente.setVisible(true);
    }
}
