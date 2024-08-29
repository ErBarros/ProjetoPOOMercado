package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaCadastroCupomView extends JFrame {
    private JTextField campoCodigoCupom;
    private JTextField campoPercentualDesconto;
    private JButton botaoCadastrar;
    private JButton botaoCancelar;
    private JCheckBox checkboxEnviarEmail;

    public TelaCadastroCupomView() {
        setTitle("Cadastro de Cupom de Desconto");
        setSize(500, 350); // Tamanho ajustado para acomodar o checkbox
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Código do Cupom
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Código do Cupom:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        campoCodigoCupom = new JTextField(15);
        add(campoCodigoCupom, gbc);

        // Percentual de Desconto
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Percentual de Desconto (%):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        campoPercentualDesconto = new JTextField(5);
        add(campoPercentualDesconto, gbc);

        // Painel para botões
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Alinhamento centralizado
        botaoCadastrar = new JButton("Cadastrar");
        botaoCancelar = new JButton("Cancelar");
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoCancelar);

        add(painelBotoes, gbc);

        // Checkbox abaixo dos botões
        gbc.gridy = 3;
        checkboxEnviarEmail = new JCheckBox("Enviar e-mail para clientes");
        add(checkboxEnviarEmail, gbc);

    }

    public String getCodigoCupom() {
        return campoCodigoCupom.getText();
    }

    public String getPercentualDesconto() {
        return campoPercentualDesconto.getText();
    }

    public boolean isEnviarEmail() {
        return checkboxEnviarEmail.isSelected();
    }

    public void adicionarListenerCadastrar(ActionListener listener) {
        botaoCadastrar.addActionListener(listener);
    }

    public void adicionarListenerCancelar(ActionListener listener) {
        botaoCancelar.addActionListener(listener);
    }
}
