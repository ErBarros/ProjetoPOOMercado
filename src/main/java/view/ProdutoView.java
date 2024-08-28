package view;

// ProdutoView.java
import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ProdutoView extends JFrame {
    private JTable table;
    private JButton detalhesButton;
    private DefaultTableModel tableModel;

    public ProdutoView() {
        setTitle("Lista de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new String[]{"Código", "Nome", "Unidade", "Quantidade em Estoque"}, 0);
        table = new JTable(tableModel);
        detalhesButton = new JButton("Ver Detalhes");

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(detalhesButton, BorderLayout.SOUTH);
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
}

