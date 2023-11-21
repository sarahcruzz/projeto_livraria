package br.com.livraria.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

abstract public class Cliente implements Usuario{

    // Atributos
    private String nome;
    private String email;
    private String telefone;
    private Endereco endereco;
    private BigDecimal limiteCredito;

    // Construtores
    public Cliente() {
        this.nome = "";
        this.email = "";
        this.telefone = "";
        this.endereco = new Endereco();
        this.limiteCredito = new BigDecimal(0).setScale(2, RoundingMode.HALF_EVEN);
    }

    public Cliente(String nome,
                   String email,
                   String telefone,
                   String logradouro,
                   String bairro,
                   String cidade,
                   String uf,
                   String cep,
                   BigDecimal limiteCredito) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = new Endereco(logradouro, bairro, cidade, uf, cep);
        this.limiteCredito = limiteCredito.setScale(2, RoundingMode.HALF_EVEN);
    }

    // Métodos de acesso (getters e setters)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }


    // Métodos (funcionalidades da classe)
    public String obterContatos(){
        return String.format("Nome: %s \nE-mail: %s \nTelefone: %s",
                             this.getNome(), this.getEmail(), this.getTelefone());
    }

    public String exibirEndereco(){
        return String.format("Nome: %s \nLogradouro: %s \nBairro: %s \nCidade: %s \nUF: %s \nCEP: %s",
               this.getNome(), this.getEndereco().getLogradouro(),
                               this.getEndereco().getBairro(),
                               this.getEndereco().getCidade(),
                               this.getEndereco().getUf(),
                               this.getEndereco().getCep());
    }
}

