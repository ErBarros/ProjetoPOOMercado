package model;

/**
 * Classe que representa um produto.
 */
public class Produto {

    private String codigo; // Codigo unico do produto
    private String nome; // Nome do produto
    private String unidade; // Unidade de medida do produto (ex.: unidade, litro)
    private double valorCompra; // Valor de compra do produto
    private double valorVenda; // Valor de venda do produto
    private int quantidadeEstoque; // Quantidade em estoque do produto

    /**
     * Construtor para inicializar o produto.
     * @param codigo Codigo do produto
     * @param nome Nome do produto
     * @param unidade Unidade de medida
     * @param valorCompra Valor de compra
     * @param valorVenda Valor de venda
     * @param quantidadeEstoque Quantidade em estoque
     */
    public Produto(String codigo, String nome, String unidade, double valorCompra, double valorVenda, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.unidade = unidade;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Getters e Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * Atualiza a quantidade em estoque do produto.
     * @param quantidade Quantidade a ser adicionada ou subtraida do estoque
     */
    public void atualizarEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    /**
     * Atualiza o valor de venda do produto.
     * @param valor Novo valor de venda
     */
    public void atualizarValorVenda(double valor) {
        this.valorVenda = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", unidade='" + unidade + '\'' +
                ", valorCompra=" + valorCompra +
                ", valorVenda=" + valorVenda +
                ", quantidadeEstoque=" + quantidadeEstoque +
                '}';
    }
}
