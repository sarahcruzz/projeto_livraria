package br.com.livraria.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class ClientePF extends Cliente {
    // Atributos
    private String cpf;
    private String rg;
    private String login;
    private String senha;

    // Construtores
    public ClientePF() {
        // Chamada do construtor da superclasse
        super();
        // Inicialização dos atributos da subclasse
        this.cpf = "";
        this.rg = "";
        this.login = "";
        this.senha = "";
    }

    public ClientePF(String nome,
                     String email,
                     String telefone,
                     String logradouro,
                     String bairro,
                     String cidade,
                     String uf,
                     String cep,
                     BigDecimal limiteCredito,
                     String cpf,
                     String rg) {
        super(nome, email, telefone, logradouro, bairro, cidade, uf, cep, limiteCredito);
        this.cpf = cpf;
        this.rg = rg;
        this.login = "";
        this.senha = "";
    }

    // Métodos de acesso (getters e setters)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

        return String.format("Nome: %s \nCPF: %s \nRG: %s \nLimite de crédito: %s",
                this.getNome(), this.getCpf(), this.getRg(), formatoMoeda.format(this.getLimiteCredito()));
    }

}














