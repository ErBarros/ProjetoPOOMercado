package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaCadastroCliente extends JFrame {
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoEmail;
    private JTextField campoEndereco;
    private JButton botaoCadastrar;

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 2));

        painel.add(new JLabel("Nome:"));
        campoNome = new JTextField();
        painel.add(campoNome);

        painel.add(new JLabel("CPF:"));
        campoCpf = new JTextField();
        painel.add(campoCpf);

        painel.add(new JLabel("Email (opcional):"));
        campoEmail = new JTextField();
        painel.add(campoEmail);

        painel.add(new JLabel("Endereço (opcional):"));
        campoEndereco = new JTextField();
        painel.add(campoEndereco);

        botaoCadastrar = new JButton("Cadastrar");
        painel.add(botaoCadastrar);

        add(painel, BorderLayout.CENTER);
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

    public void adicionarListener(ActionListener listener) {
        botaoCadastrar.addActionListener(listener);
    }
}

