package controller;

import model.Cliente;
import model.Cupom;
import model.Produto;
import model.Venda;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class VendaController {
    public void registrarVenda(Map<String, Object> dados) {
        Cliente cliente = (Cliente) dados.get("cliente");
        List<Produto> produtos = (List<Produto>) dados.get("produtos");
        Date dataHora = (Date) dados.get("dataHora");
        Cupom cupom = (Cupom) dados.get("cupom");

        Venda venda = new Venda(cliente, produtos, dataHora, cupom);
        venda.registrarVenda();
    }

    public void emitirNota(Venda venda) {
        venda.emitirNota();
    }
}

