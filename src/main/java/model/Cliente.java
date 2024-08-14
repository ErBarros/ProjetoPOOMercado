package model;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String endereco;

    public Cliente(String nome, String cpf, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    public void cadastrarCliente() {
        // Lógica para cadastrar cliente
    }

    public void enviarEmail(Cupom cupom) {
        // Lógica para enviar email com cupom
    }
}

