package controller;

import model.Cupom;
import model.Gerente;
import model.Produto;

import javax.swing.*;
import java.util.Map;

public class GerenteController {
    private Gerente gerente;

    public void cadastrarGerente(Map<String, String> dados) {
        String nome = limitarCaracteres(dados.get("nome"), 64);
        String login = limitarCaracteres(dados.get("login"), 64);
        String senha = limitarCaracteres(dados.get("senha"), 128);
        String email = limitarCaracteres(dados.get("email"), 64);
        String nisPis = limitarCaracteres(dados.get("nisPis"), 11);

        gerente = new Gerente(nome, login, senha, email, nisPis);
        gerente.cadastrarGerente();
    }

    public boolean autenticar(String login, String senha) {
        return gerente != null && gerente.autenticar(login, senha);
    }

    public void cadastrarProduto(Map<String, String> dados) {
        String codigo = dados.get("codigo");
        String nome = dados.get("nome");
        String unidade = dados.get("unidade");
        double valorCompra = Double.parseDouble(dados.get("valorCompra"));
        double valorVenda = Double.parseDouble(dados.get("valorVenda"));
        int quantidadeEstoque = Integer.parseInt(dados.get("quantidadeEstoque"));

        Produto produto = new Produto(codigo, nome, unidade, valorCompra, valorVenda, quantidadeEstoque);
        gerente.cadastrarProduto(produto);
    }

    public void gerarRelatorioBalanco(int mes, int ano) {
        gerente.gerarRelatorioBalanco(mes, ano);
    }

    public void enviarCupom(Map<String, String> dados) {
        String codigo = dados.get("codigo");
        double percentualDesconto = Double.parseDouble(dados.get("percentualDesconto"));

        Cupom cupom = new Cupom(codigo, percentualDesconto);
        gerente.enviarCupom(cupom);
    }

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
