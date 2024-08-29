package model;

import java.time.LocalDateTime;

public class EntradaEstoque {
    private String produto;
    private int quantidade;
    private double valorUnitarioCompra;
    private LocalDateTime dataHoraEntrada;
    private Almoxarife almoxarife;

    public EntradaEstoque(String produto, int quantidade, double valorUnitarioCompra, Almoxarife almoxarife) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitarioCompra = valorUnitarioCompra;
        this.dataHoraEntrada = LocalDateTime.now();
        this.almoxarife = almoxarife;
    }

    // Getters e setters omitidos para brevidade
}

