package model;

public class Almoxarife {
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String nisPis;

    public Almoxarife(String nome, String login, String senha, String email, String nisPis) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.nisPis = nisPis;
    }



    /* Exemplo de um configurador seguro para a senha, organizar para tornar seguro.
    public void setSenha(String senha) {
        this.senha = criptografarSenha(senha);
    }

    private String criptografarSenha(String senha) {
        // Implementação da criptografia aqui, por exemplo usando BCrypt
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }
    */

    @Override
    public String toString() {
        return "Almoxarife{" +
                "nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", nisPis='" + nisPis + '\'' +
                '}';
    }

    // Getters and setters omitted for brevity
}