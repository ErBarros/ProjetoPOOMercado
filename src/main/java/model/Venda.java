package model;

import java.util.Date;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<Produto> produtos;
    private Date dataHora;
    private Cupom cupom;

    public Venda(Cliente cliente, List<Produto> produtos, Date dataHora, Cupom cupom) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.dataHora = dataHora;
        this.cupom = cupom;
    }

    public void registrarVenda() {
        // Lógica para registrar venda
    }

    public void emitirNota() {
        // Lógica para emitir nota
    }
}

