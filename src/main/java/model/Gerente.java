package model;

import java.util.Map;

public class Gerente {
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String nisPis;

    public Gerente(String nome, String login, String senha, String email, String nisPis) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.nisPis = nisPis;
    }

    public void cadastrarGerente() {
        // Lógica para cadastrar gerente
    }

    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    public void cadastroUsuario(String tipo, Map<String, String> dados) {
        // Lógica para cadastro de usuário
    }

    public void cadastrarProduto(Produto produto) {
        // Lógica para cadastrar produto
    }

    public void gerarRelatorioBalanco(int mes, int ano) {
        // Lógica para gerar relatório de balanço
    }

    public void enviarCupom(Cupom cupom) {
        // Lógica para enviar cupom
    }
}