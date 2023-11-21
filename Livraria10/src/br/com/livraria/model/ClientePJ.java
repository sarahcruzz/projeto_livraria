package br.com.livraria.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class ClientePJ extends Cliente{
    // Atributos
    private String cnpj;
    private String inscricaoMunicipal;
    private String inscricaoEstadual;
    private String login;
    private String senha;


    // Construtores
    public ClientePJ() {
        super();
        this.cnpj = "";
        this.inscricaoMunicipal = "";
        this.inscricaoEstadual = "";
        this.login = "";
        this.senha = "";
    }

    public ClientePJ(String nome,
                     String email,
                     String telefone,
                     String logradouro,
                     String bairro,
                     String cidade,
                     String uf,
                     String cep,
                     BigDecimal limiteCredito,
                     String cnpj,
                     String inscricaoMunicipal,
                     String inscricaoEstadual) {
        super(nome, email, telefone, logradouro, bairro, cidade, uf, cep, limiteCredito);
        this.cnpj = cnpj;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.inscricaoEstadual = inscricaoEstadual;
        this.login = "";
        this.senha = "";
    }

    // Métodos de acesso (getters e setters)
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }
    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public String getSenha() {
        return this.senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Métodos (funcionalidades da classe)
    public String obterDocumentos(){

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        return String.format("Nome: %s \ncnpj: %s \nInscrição municipal: %s \nInscrição estadual: %s \nLimite de crédito: %s",
                this.getNome(), this.getCnpj(), this.getInscricaoMunicipal(), this.getInscricaoEstadual(), formatoMoeda.format(this.getLimiteCredito()));
    }

    public String exibirEndereco(){
        return String.format("Nome: %s \nCidade: %s \nUF: %s",
                this.getNome(), this.getEndereco().getLogradouro(),
                this.getEndereco().getCidade(),
                this.getEndereco().getUf());
    }

}














