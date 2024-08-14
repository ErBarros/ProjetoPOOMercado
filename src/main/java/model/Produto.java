package model;

public class Produto {

    private String codigo;
    private String nome;
    private String unidade;
    private double valorCompra;
    private double valorVenda;
    private int quantidadeEstoque;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    public double getValorVenda() {
        return valorVenda;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Produto(String codigo, String nome, String unidade, double valorCompra, double valorVenda, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.unidade = unidade;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void atualizarEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    public void atualizarValorVenda(double valor) {
        this.valorVenda = valor;
    }
}
