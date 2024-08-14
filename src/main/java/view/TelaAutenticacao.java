package view;

import controller.GerenteController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TelaAutenticacao extends JFrame {
    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton autenticarButton;
    private JButton cancelarButton;

    private GerenteController controller;

    public TelaAutenticacao(GerenteController controller) {
        this.controller = controller;
        setTitle("Autenticação de Gerente");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initialize();
    }

    private void initialize() {
        loginField = new JTextField(20);
        senhaField = new JPasswordField(20);
        autenticarButton = new JButton("Entrar");
        cancelarButton = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Login:"));
        panel.add(loginField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(autenticarButton);
        panel.add(cancelarButton);

        add(panel);

        autenticarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(senhaField.getPassword());

                boolean autenticado = controller.autenticar(login, senha);
                if (autenticado) {
                    JOptionPane.showMessageDialog(null, "Autenticado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciais inválidas!");
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int response = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja cancelar?", "Cancelar Login", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                }

            }
        });
    }
}
