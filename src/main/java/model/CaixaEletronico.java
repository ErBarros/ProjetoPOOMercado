package model;

public class CaixaEletronico {
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String nisPis;

    public CaixaEletronico(String nome, String login, String senha, String email, String nisPis) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.nisPis = nisPis;
    }

    // Getters and setters omitted for brevity
}

