import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cliente {
    // criação dos atributos
    private String nome;
    private String email;
    private String telefone;

    private String cpf;
    private String rg;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private BigDecimal limiteCredito;

    // construtor usando parâmetros


    public Cliente(String nome, String email, String telefone, String cpf, String rg, String logradouro, String bairro,
                   String cidade, String uf, String cep, BigDecimal limiteCredito) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.limiteCredito = limiteCredito.setScale(2, RoundingMode.HALF_EVEN);
    }

    public Cliente() {
        this.nome = "";
        this.email = "";
        this.telefone = "";
        this.cpf = "";
        this.rg = "";
        this.logradouro = "";
        this.bairro = "";
        this.cidade = "";
        this.uf = "";
        this.cep = "";
    }

    // métodos

    public String obterContatos(){
        return String.format("Contato: %s \nE-mail: %s \nTelefone: %s", this.getNome(),
                this.getEmail(), this.getTelefone());
    }

    public String obterEndereco(){
        return String.format("Nome: %s \nLogradouro: %s \nBairro: %s \nCidade: %s" +
                " \nUF: %s \nCEP: %s", this.getNome(), this.getLogradouro(), this.getBairro(),
                this.getCidade(), this.getUf(), this.getCep());
    }

    public String obterDocumentos(){
        return String.format("Nome: %s \nCPF: %s \nRG: %s \nLimite de Crédito: %s",
                this.getNome(), this.getCpf(), this.getRg(), this.getLimiteCredito());
    }

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

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}
