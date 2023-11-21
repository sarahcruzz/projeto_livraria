package br.com.livraria.model;

public class Endereco {
    // Atributos
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    // Construtor
    public Endereco() {
        this.logradouro = "";
        this.bairro = "";
        this.cidade = "";
        this.uf = "";
        this.cep = "";
    }

    public Endereco(String logradouro, String bairro, String cidade, String uf, String cep) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    // Métodos de acesso (getters e setters)
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


    // Métodos (funcionalidades da classe)
    public String obterEndereco(){
        return String.format("Logradouro: %s \nBairro: %s \nCidade: %s \nUF: %s \nCEP: %s",
                             this.getLogradouro(), this.getBairro(), this.getCidade(), this.getUf(), this.getCep());
    }

}
