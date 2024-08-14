package view;

import controller.GerenteController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

//Define uma nova classe pública chamada TelaCadastroGerente
public class TelaCadastroGerente extends JFrame {

    private JTextField nomeField;
    private JTextField loginField;
    private JPasswordField senhaField;
    private JTextField emailField;
    private JTextField nisPisField;
    private JButton cadastrarButton;
    private JButton cancelarButton;

    //gerencia as ações realizadas na tela de cadastro e manipula a lógica necessária para o cadastro de um gerente.
    private GerenteController controller;

    //Construtor recebe um parâmetro controller do tipo GerenteController. Esse parâmetro é usado para passar um objeto controlador para a classe TelaCadastroGerente.
    public TelaCadastroGerente(GerenteController controller) {
        this.controller = controller;
        setTitle("Cadastro de Gerente");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initialize();
    }

    private void initialize() {

        //JTextField com uma largura de 20 colunas.
        nomeField = new JTextField(20);
        loginField = new JTextField(20);
        senhaField = new JPasswordField(20);
        emailField = new JTextField(20);
        nisPisField = new JTextField(20);

        //JButton padrão, função de cadastarr e cancelar .
        cadastrarButton = new JButton("Cadastrar");
        cancelarButton = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Login:"));
        panel.add(loginField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(new JLabel("Email (opcional):"));
        panel.add(emailField);
        panel.add(new JLabel("NIS/PIS (opcional):"));
        panel.add(nisPisField);
        panel.add(cadastrarButton);
        panel.add(cancelarButton);

        add(panel);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, String> dados = new HashMap<>();
                dados.put("nome", nomeField.getText());
                dados.put("login", loginField.getText());
                dados.put("senha", new String(senhaField.getPassword()));
                dados.put("email", emailField.getText());
                dados.put("nisPis", nisPisField.getText());

                controller.cadastrarGerente(dados);
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja cancelar o cadastro?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }

            }
        });
    }
}
