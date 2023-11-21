package br.com.livraria.model;

public class Funcionario implements Usuario {

    private String nome;
    private String funcao;
    private String login;
    private String senha;

    public Funcionario() {
        this.nome = "";
        this.funcao = "";
        this.login = "";
        this.senha = "";
    }
    public Funcionario(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
        this.login = "";
        this.senha = "";
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
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
}

