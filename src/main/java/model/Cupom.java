package model;

public class Cupom {
    private String codigo;
    private double percentualDesconto;

    public Cupom(String codigo, double percentualDesconto) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
    }

    public void gerarCupom() {
        // Lógica para gerar cupom
    }

    public double aplicarDesconto(double valor) {

        return valor - (valor * (percentualDesconto / 100));
    }
}

