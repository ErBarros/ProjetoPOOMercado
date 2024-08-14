package controller;

import model.Cupom;

import java.util.Map;

public class CupomController {
    public void gerarCupom(Map<String, String> dados) {
        String codigo = dados.get("codigo");
        double percentualDesconto = Double.parseDouble(dados.get("percentualDesconto"));

        Cupom cupom = new Cupom(codigo, percentualDesconto);
        cupom.gerarCupom();
    }

    public double aplicarDesconto(Cupom cupom, double valor) {
        return cupom.aplicarDesconto(valor);
    }
}

