import controller.AlmoxarifeController;
import controller.CaixaEletronicoController;
import controller.GerenteController;
import controller.ProdutoController;
import view.*;

public class Main {

    public static void main(String[] args) {


        GerenteController controller = new GerenteController();
        TelaCadastroGerente tela = new TelaCadastroGerente(controller);
        tela.setVisible(true);


        TelaAutenticacao telaAutenticacao = new TelaAutenticacao(controller);
        telaAutenticacao.setVisible(true);


        AlmoxarifeController almoxarifeController = new AlmoxarifeController();
        CaixaEletronicoController caixaController = new CaixaEletronicoController();

        // Exemplo de como criar e exibir a tela de cadastro de almoxarife
        TelaCadastroAlmoxarife telaAlmoxarife = new TelaCadastroAlmoxarife(almoxarifeController);
        telaAlmoxarife.setVisible(true);

        // Exemplo de como criar e exibir a tela de cadastro de caixa eletrônico
        TelaCadastroCaixaEletronico telaCaixa = new TelaCadastroCaixaEletronico(caixaController);
        telaCaixa.setVisible(true);


        //Exemplo de como criar e exibir a tela de cadastro de produtos
        ProdutoController produtoController = new ProdutoController();
        TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(produtoController);
        telaCadastroProduto.setVisible(true);


    }
}
