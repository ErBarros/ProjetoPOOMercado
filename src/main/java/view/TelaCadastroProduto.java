package view;

import controller.ProdutoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TelaCadastroProduto extends JFrame {

    private JTextField nomeField;
    private JTextField unidadeField;
    private JTextField valorCompraField;
    private JTextField valorVendaField;
    private JTextField quantidadeEstoqueField;
    private JButton cadastrarButton;
    private JButton cancelarButton;

    private ProdutoController controller;

    public TelaCadastroProduto(ProdutoController controller) {
        this.controller = controller;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Cadastro de Produto");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Setup layout
        setLayout(new BorderLayout());

        // Create and add components
        JPanel formPanel = createFormPanel();
        JPanel buttonPanel = createButtonPanel();

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5)); // 6 rows, 2 columns

        nomeField = new JTextField(20);
        unidadeField = new JTextField(20);
        valorCompraField = new JTextField(20);
        valorVendaField = new JTextField(20);
        quantidadeEstoqueField = new JTextField(20);

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Unidade:"));
        panel.add(unidadeField);
        panel.add(new JLabel("Valor Compra:"));
        panel.add(valorCompraField);
        panel.add(new JLabel("Valor Venda:"));
        panel.add(valorVendaField);
        panel.add(new JLabel("Quantidade Estoque:"));
        panel.add(quantidadeEstoqueField);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        cadastrarButton = new JButton("Cadastrar");
        cancelarButton = new JButton("Cancelar");

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCadastrar();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCancelar();
            }
        });

        panel.add(cadastrarButton);
        panel.add(cancelarButton);

        return panel;
    }

    private void handleCadastrar() {
        Map<String, String> dados = new HashMap<>();
        dados.put("nome", nomeField.getText());
        dados.put("unidade", unidadeField.getText());
        dados.put("valorCompra", valorCompraField.getText());
        dados.put("valorVenda", valorVendaField.getText());
        dados.put("quantidadeEstoque", quantidadeEstoqueField.getText());

        controller.cadastrarProduto(dados);
        JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
        clearFields();
    }

    private void handleCancelar() {
        int response = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja cancelar o cadastro?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            dispose(); // Fecha a janela atual
        }
    }

    private void clearFields() {
        nomeField.setText("");
        unidadeField.setText("");
        valorCompraField.setText("");
        valorVendaField.setText("");
        quantidadeEstoqueField.setText("");
    }
}
