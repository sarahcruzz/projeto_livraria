package br.com.livraria.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

abstract public class Produto {
    // Atributos
    private String descricao;
    private String genero;
    private BigDecimal precoCusto;
    private BigDecimal margemLucro;

    // Construtor
    public Produto() {
        this.descricao = "";
        this.genero = "";
        this.precoCusto = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_EVEN);
        this.margemLucro = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_EVEN);
    }

    public Produto(String descricao, String genero, BigDecimal precoCusto, BigDecimal margemLucro) {
        this.descricao = descricao;
        this.genero = genero;
        this.precoCusto = precoCusto.setScale(2, RoundingMode.HALF_EVEN);
        this.margemLucro = margemLucro.setScale(2, RoundingMode.HALF_EVEN);
    }


    // Métodos de acesso (getters e setters)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(BigDecimal margemLucro) {
        this.margemLucro = margemLucro;
    }


    // Métodos (funcionalidades da classe)

    // Método abstrato
    abstract public int verificarEstoque();


    protected BigDecimal calcularPrecoVenda(){

        /*  BigDecimal lucro = this.getPrecoCusto().multiply(BigDecimal.valueOf(0.2));
            BigDecimal precoVenda = this.getPrecoCusto().add(lucro);
            BigDecimal resultadoEscala = precoVenda.setScale(2, RoundingMode.HALF_EVEN);
            return resultadoEscala; */

        /*  BigDecimal lucro = this.getPrecoCusto().multiply(this.getMargemLucro());
            BigDecimal precoVenda = this.getPrecoCusto().add(lucro);
            BigDecimal resultadoEscala = precoVenda.setScale(2, RoundingMode.HALF_EVEN);
            return resultadoEscala; */


        return this.getPrecoCusto().add( this.getPrecoCusto().multiply(this.getMargemLucro()) ).setScale(2, RoundingMode.HALF_EVEN);
    }

    public String obterProduto(){

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        return String.format("Descrição: %s \nGênero: %s \nPreço de venda: %s",
                this.getDescricao(), this.getGenero(), formatoMoeda.format(this.calcularPrecoVenda()));
    }

}


















