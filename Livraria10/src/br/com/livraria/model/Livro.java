package br.com.livraria.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Livro extends Produto{

    private String autor;
    private String editora;
    private int anoPublicacao;

    public Livro() {
        super();
        this.autor = "";
        this.editora = "";
        this.anoPublicacao = 0;
    }

    public Livro(String descricao, String genero, BigDecimal precoCusto, BigDecimal margemLucro,
                 String autor, String editora, int anoPublicacao) {
        super(descricao, genero, precoCusto, margemLucro);
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }


    // Métodos (funcionalidades da classe)

    // Obtém a data corrente
    LocalDate dataAtual = LocalDate.now();
    int anoAtual = dataAtual.getYear();


    @Override
    public int verificarEstoque() {
        return 0;
    }

    protected BigDecimal calcularPrecoVenda(){

        BigDecimal precoVenda = this.getPrecoCusto().add( this.getPrecoCusto().multiply(this.getMargemLucro()) ).setScale(2, RoundingMode.HALF_EVEN);

        if (this.getAnoPublicacao() == anoAtual) precoVenda.add(precoVenda.multiply(BigDecimal.valueOf(0.05)));

        return precoVenda;
    }

    public String obterProduto(){

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        String retorno;

        if (this.getAnoPublicacao() == anoAtual){

            retorno = String.format("Lançamento!!! \nDescrição: %s \nGênero: %s \nPreço de venda: %s",
                                    this.getDescricao(), this.getGenero(), formatoMoeda.format(this.calcularPrecoVenda()));
        }else{

            retorno = String.format("Descrição: %s \nGênero: %s \nPreço de venda: %s",
                                    this.getDescricao(), this.getGenero(), formatoMoeda.format(this.calcularPrecoVenda()));
        }

        return retorno;
    }
}
