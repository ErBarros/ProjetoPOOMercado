package controller;

import model.Cliente;
import view.TelaCadastroClienteView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ClienteController {
    private TelaCadastroClienteView telaCadastroCliente;

    public ClienteController(TelaCadastroClienteView telaCadastroCliente) {

        this.telaCadastroCliente = telaCadastroCliente;

        this.telaCadastroCliente.adicionarListenerSalvar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        // Adiciona listener para o botão Cancelar
        this.telaCadastroCliente.adicionarListenerCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    telaCadastroCliente.dispose();
                }
        });
    }

    private void cadastrarCliente() {
        String nome = telaCadastroCliente.getNome();
        String cpf = telaCadastroCliente.getCpf();
        String email = telaCadastroCliente.getEmail();
        String endereco = telaCadastroCliente.getEndereco();

        // Validação dos campos obrigatórios
        if (nome.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(telaCadastroCliente, "Nome e CPF são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Map<String, String> dadosCliente = new HashMap<>();
        dadosCliente.put("nome", nome);
        dadosCliente.put("cpf", cpf);
        dadosCliente.put("email", email);
        dadosCliente.put("endereco", endereco);

        Cliente cliente = new Cliente(nome, cpf, email, endereco);
        cliente.cadastrarCliente();
        JOptionPane.showMessageDialog(telaCadastroCliente, "Cliente cadastrado com sucesso!");
    }
}
