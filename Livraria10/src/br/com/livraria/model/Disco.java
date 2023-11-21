package br.com.livraria.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Disco extends Produto {

    private String artistaBanda;
    private String gravadora;
    private String origem;

    public Disco() {
        super();
        this.artistaBanda = "";
        this.gravadora = "";
        this.origem = "";
    }

    public Disco(String descricao, String genero, BigDecimal precoCusto, BigDecimal margemLucro,
                 String artistaBanda, String gravadora, String origem) {
        super(descricao, genero, precoCusto, margemLucro);
        this.artistaBanda = artistaBanda;
        this.gravadora = gravadora;
        this.origem = origem;
    }

    public String getArtistaBanda() {
        return artistaBanda;
    }

    public void setArtistaBanda(String artistaBanda) {
        this.artistaBanda = artistaBanda;
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }


    @Override
    public int verificarEstoque() {
        return 0;
    }

    public BigDecimal calcularPrecoVenda(BigDecimal cotacao){

        BigDecimal retorno = BigDecimal.valueOf(-1);

        if (!this.getOrigem().equals("Brasil")) {

            BigDecimal precoCustoDolar = this.getPrecoCusto().multiply(cotacao);

            retorno = precoCustoDolar.add( precoCustoDolar.multiply(this.getMargemLucro()) ).setScale(2, RoundingMode.HALF_EVEN);
        }

        return retorno;
    }
}


















