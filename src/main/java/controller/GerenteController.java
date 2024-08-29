package controller;


import model.Gerente;
import model.Cupom;
import model.Produto;
import model.ProdutoRepository;
import view.TelaAtualizaValorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Controlador que gerencia a interação entre o Gerente, a tela e o repositório de produtos.
 */
public class GerenteController {
    private Gerente gerente;
    private TelaAtualizaValorView tela;
    private ProdutoRepository produtoRepository;

    /**
     * Construtor para inicializar o controlador com uma tela e um repositório de produtos.
     * @param tela Tela gráfica onde o gerente interage
     * @param produtoRepository Repositório onde os produtos são armazenados
     */
    public GerenteController(TelaAtualizaValorView tela, ProdutoRepository produtoRepository) {
        this.tela = tela;
        this.produtoRepository = produtoRepository;

        // Adiciona listener para atualizar o valor do produto
        this.tela.adicionarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarValorProduto();
            }
        });


    }


    public GerenteController() {

    }

    /**
     * Cadastra um novo gerente.
     * @param dados Dados do gerente
     */
    public void cadastrarGerente(Map<String, String> dados) {
        String nome = limitarCaracteres(dados.get("nome"), 64);
        String login = limitarCaracteres(dados.get("login"), 64);
        String senha = limitarCaracteres(dados.get("senha"), 128);
        String email = limitarCaracteres(dados.get("email"), 64);
        String nisPis = limitarCaracteres(dados.get("nisPis"), 11);

        gerente = new Gerente(nome, login, senha, email, nisPis);
        gerente.cadastrarGerente();
    }

    /**
     * Autentica um gerente.
     * @param login Login do gerente
     * @param senha Senha do gerente
     * @return Resultado da autenticação
     */
    public boolean autenticar(String login, String senha) {
        return gerente != null && gerente.autenticar(login, senha);
    }

    /**
     * Cadastra um novo produto.
     * @param dados Dados do produto
     */
    public void cadastrarProduto(Map<String, String> dados) {
        String codigo = dados.get("codigo");
        String nome = dados.get("nome");
        String unidade = dados.get("unidade");
        double valorCompra = Double.parseDouble(dados.get("valorCompra"));
        double valorVenda = Double.parseDouble(dados.get("valorVenda"));
        int quantidadeEstoque = Integer.parseInt(dados.get("quantidadeEstoque"));

        Produto produto = new Produto(codigo, nome, unidade, valorCompra, valorVenda, quantidadeEstoque, valorVenda);
        gerente.cadastrarProduto(produto);
    }

    /**
     * Gera um relatório de balanço.
     * @param mes Mês do balanço
     * @param ano Ano do balanço
     */
    public void gerarRelatorioBalanco(int mes, int ano) {
        if (gerente != null) {
            gerente.gerarRelatorioBalanco(mes, ano);
        } else {
            JOptionPane.showMessageDialog(tela, "Gerente não autenticado.");
        }
    }

    /**
     * Envia um cupom.
     * @param dados Dados do cupom
     */
    public void enviarCupom(Map<String, String> dados) {
        String codigo = dados.get("codigo");
        double percentualDesconto = Double.parseDouble(dados.get("percentualDesconto"));

        Cupom cupom = new Cupom(codigo, percentualDesconto);
        if (gerente != null) {
            gerente.enviarCupom(cupom);
        } else {
            JOptionPane.showMessageDialog(tela, "Gerente não autenticado.");
        }
    }

    /**
     * Atualiza o valor de um produto a partir da interface gráfica.
     */
    private void atualizarValorProduto() {
        String nomeProduto = tela.getNomeProduto();
        double novoValor = tela.getValorVenda();

        Produto produto = produtoRepository.buscarProduto(nomeProduto);
        if (produto != null) {
            produto.setValorUnitario(novoValor);
            JOptionPane.showMessageDialog(tela, "Valor atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(tela, "Produto não encontrado.");
        }
    }

    /**
     * Limita o número de caracteres de uma string.
     * @param texto Texto a ser limitado
     * @param limite Limite de caracteres
     * @return Texto limitado
     */
    private String limitarCaracteres(String texto, int limite) {
        if (texto.length() > limite) {
            int response = JOptionPane.showConfirmDialog(null, "Limite estourou", "Limite", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.DEFAULT_OPTION) {
                return texto.substring(0, limite);
            }
        }
        return texto;
    }
}