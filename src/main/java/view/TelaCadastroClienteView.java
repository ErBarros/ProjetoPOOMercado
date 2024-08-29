package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaCadastroClienteView extends JFrame {
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoEmail;
    private JTextField campoEndereco;
    private JCheckBox checkboxReceberPromocoes;
    private JButton botaoSalvar;
    private JButton botaoCancelar;

    public TelaCadastroClienteView() {
        setTitle("Cadastro de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento
        gbc.anchor = GridBagConstraints.WEST;

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        campoNome = new JTextField(20);
        add(campoNome, gbc);

        // CPF
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("CPF:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        campoCpf = new JTextField(20);
        add(campoCpf, gbc);

        // E-mail
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("E-mail:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        campoEmail = new JTextField(20);
        add(campoEmail, gbc);

        // Receber promoções
        gbc.gridx = 1;
        gbc.gridy = 3;
        checkboxReceberPromocoes = new JCheckBox("Desejo receber promoções e cupons de desconto");
        add(checkboxReceberPromocoes, gbc);

        // Endereço
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Endereço (opcional):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        campoEndereco = new JTextField(20);
        add(campoEndereco, gbc);

        // Botões
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panelButtons = new JPanel();
        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");
        panelButtons.add(botaoSalvar);
        panelButtons.add(botaoCancelar);

        add(panelButtons, gbc);

        setLocationRelativeTo(null); // Centraliza na tela
    }

    public String getNome() {
        return campoNome.getText();
    }

    public String getCpf() {
        return campoCpf.getText();
    }

    public String getEmail() {
        return campoEmail.getText();
    }

    public String getEndereco() {
        return campoEndereco.getText();
    }

    public boolean isReceberPromocoes() {
        return checkboxReceberPromocoes.isSelected();
    }

    public void adicionarListenerSalvar(ActionListener listener) {
        botaoSalvar.addActionListener(listener);
    }

    public void adicionarListenerCancelar(ActionListener listener) {
        botaoCancelar.addActionListener(listener);
    }
}

