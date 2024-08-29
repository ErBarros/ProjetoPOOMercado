import java.util.ArrayList;
import java.util.List;

import controller.*;
import model.Almoxarife;
import model.Produto;
import model.ProdutoRepository;
import view.*;

public class Main {
    public static void main(String[] args) {

        // Inicializa a lista de produtos de teste
        List<Produto> listaDeProdutosTeste = new ArrayList<>();


        // Inicializa os controladores
        GerenteController gerenteController = new GerenteController();
        AlmoxarifeController almoxarifeController = new AlmoxarifeController();
        CaixaEletronicoController caixaController = new CaixaEletronicoController();

        // Cria o repositório de produtos e adiciona produtos de teste
        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.adicionarProduto(new Produto("P001", "Produto A", "Unidade", 10.0, 15.0, 100, 15.0));
        produtoRepository.adicionarProduto(new Produto("P002", "Produto B", "Unidade", 20.0, 25.0, 50, 25.0));
        produtoRepository.adicionarProduto(new Produto("P003","Produto C", "Unidade", 30.0, 35.0, 50, 25.0));
        produtoRepository.adicionarProduto(new Produto("P004","Produto D", "Unidade", 40.0, 35.0, 50, 25.0));

        // Inicializa as telas e associa os controladores necessários
        inicializarTelaCadastroGerente(gerenteController);
        inicializarTelaAutenticacao(gerenteController);
        inicializarTelaCadastroAlmoxarife(almoxarifeController);
        inicializarTelaCadastroCaixaEletronico(caixaController);
        inicializarTelaCadastroProduto(produtoRepository, listaDeProdutosTeste);
        inicializarTelaEntradaEstoque();
        inicializarTelaAtualizaValor(gerenteController, produtoRepository);
        inicializarTelaCadastroCliente();
        inicializarTelaCadastroCupom();
    }

    // Métodos de inicialização para cada tela
    private static void inicializarTelaCadastroGerente(GerenteController gerenteController) {
        TelaCadastroGerenteView telaCadastroGerente = new TelaCadastroGerenteView(gerenteController);
        telaCadastroGerente.setVisible(true);
    }

    private static void inicializarTelaAutenticacao(GerenteController gerenteController) {
        TelaAutenticacaoView telaAutenticacao = new TelaAutenticacaoView(gerenteController);
        telaAutenticacao.setVisible(true);
    }

    private static void inicializarTelaCadastroAlmoxarife(AlmoxarifeController almoxarifeController) {
        TelaCadastroAlmoxarifeView telaCadastroAlmoxarife = new TelaCadastroAlmoxarifeView(almoxarifeController);
        telaCadastroAlmoxarife.setVisible(true);
    }

    private static void inicializarTelaCadastroCaixaEletronico(CaixaEletronicoController caixaController) {
        TelaCadastroCaixaEletronicoView telaCadastroCaixa = new TelaCadastroCaixaEletronicoView(caixaController);
        telaCadastroCaixa.setVisible(true);
    }

    private static void inicializarTelaCadastroProduto(ProdutoRepository produtoRepository, List<Produto> listaDeProdutosTeste) {
        TelaProdutoView produtoView = new TelaProdutoView();
        ProdutoController produtoController = new ProdutoController(produtoView, listaDeProdutosTeste, produtoRepository);

        TelaCadastroProdutoView telaCadastroProduto = new TelaCadastroProdutoView(produtoController);
        telaCadastroProduto.setVisible(true);

        produtoView.setVisible(true);
    }

    private static void inicializarTelaEntradaEstoque() {
        Almoxarife almoxarife = new Almoxarife("João", "joao123", "senhaSegura", "joao@example.com", "123456789");
        TelaEntradaEstoqueView view = new TelaEntradaEstoqueView(almoxarife);
        view.setVisible(true);
    }

    private static void inicializarTelaAtualizaValor(GerenteController gerenteController, ProdutoRepository produtoRepository) {
        TelaAtualizaValorView telaGerente = new TelaAtualizaValorView();
        GerenteController gerenteControllerComTela = new GerenteController(telaGerente, produtoRepository);
        telaGerente.setVisible(true);
    }

    private static void inicializarTelaCadastroCliente() {
        TelaCadastroClienteView telaCadastroCliente = new TelaCadastroClienteView();
        telaCadastroCliente.setVisible(true);
    }

    private static void inicializarTelaCadastroCupom() {
        TelaCadastroCupomView telaCadastroCupomView = new TelaCadastroCupomView();
        telaCadastroCupomView.setVisible(true);
    }
}
