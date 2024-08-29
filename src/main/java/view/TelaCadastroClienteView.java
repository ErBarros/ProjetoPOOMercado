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
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Configuração dos componentes na tela
        int linha = 0;

        // Nome
        adicionarComponente(new JLabel("Nome:"), 0, linha, gbc);
        campoNome = adicionarCampoTexto(1, linha++, gbc);

        // CPF
        adicionarComponente(new JLabel("CPF:"), 0, linha, gbc);
        campoCpf = adicionarCampoTexto(1, linha++, gbc);

        // E-mail
        adicionarComponente(new JLabel("E-mail:"), 0, linha, gbc);
        campoEmail = adicionarCampoTexto(1, linha++, gbc);

        // Endereço
        adicionarComponente(new JLabel("Endereço (opcional):"), 0, linha, gbc);
        campoEndereco = adicionarCampoTexto(1, linha++, gbc);

        // Checkbox para receber promoções
        checkboxReceberPromocoes = new JCheckBox("Desejo receber promoções e cupons de desconto");
        gbc.gridx = 0;
        gbc.gridy = linha++;
        gbc.gridwidth = 2;
        add(checkboxReceberPromocoes, gbc);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 2;
        add(painelBotoes, gbc);
    }

    private JTextField adicionarCampoTexto(int gridx, int gridy, GridBagConstraints gbc) {
        JTextField campoTexto = new JTextField(20);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        add(campoTexto, gbc);
        return campoTexto;
    }

    private void adicionarComponente(Component componente, int gridx, int gridy, GridBagConstraints gbc) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        add(componente, gbc);
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
