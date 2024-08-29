package view;

// ProdutoView.java
import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaProdutoView extends JFrame {
    private JTable table;
    private JButton detalhesButton;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton refreshButton;

    public TelaProdutoView() {
        setTitle("Lista de Produtos");
        setSize(800, 600); // Tamanho aumentado para melhor visualização
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação do modelo da tabela
        tableModel = new DefaultTableModel(new String[]{"Código", "Nome", "Unidade", "Quantidade em Estoque"}, 0);
        table = new JTable(tableModel);

        // Adiciona a barra de rolagem
        JScrollPane scrollPane = new JScrollPane(table);

        // Criação dos botões e campos de pesquisa
        detalhesButton = new JButton("Ver Detalhes");
        searchField = new JTextField(20);
        searchButton = new JButton("Buscar");
        refreshButton = new JButton("Atualizar");

        // Painel para a barra de pesquisa e botões
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Buscar:"));
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(refreshButton);

        // Configura o layout
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(detalhesButton, BorderLayout.SOUTH);

        // Configura a barra de rolagem da tabela
        scrollPane.setPreferredSize(new Dimension(800, 400));
    }

    public void setProdutos(List<Produto> produtos) {
        tableModel.setRowCount(0); // Limpa a tabela
        for (Produto p : produtos) {
            tableModel.addRow(new Object[]{p.getCodigo(), p.getNome(), p.getUnidade(), p.getQuantidadeEstoque()});
        }
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public void addDetalhesButtonListener(ActionListener listener) {
        detalhesButton.addActionListener(listener);
    }

    public void addSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public void addRefreshButtonListener(ActionListener listener) {
        refreshButton.addActionListener(listener);
    }

    public String getSearchText() {
        return searchField.getText();
    }
}
