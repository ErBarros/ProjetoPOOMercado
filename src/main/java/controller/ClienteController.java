package controller;

import model.Cliente;
import model.Cupom;

import java.util.Map;

public class ClienteController {
    public void cadastrarCliente(Map<String, String> dados) {
        String nome = dados.get("nome");
        String cpf = dados.get("cpf");
        String email = dados.get("email");
        String endereco = dados.get("endereco");

        Cliente cliente = new Cliente(nome, cpf, email, endereco);
        cliente.cadastrarCliente();
    }

    public void enviarEmail(Cliente cliente, Cupom cupom) {
        cliente.enviarEmail(cupom);
    }
}