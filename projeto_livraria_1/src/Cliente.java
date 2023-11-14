public class Cliente {
    // criação dos atributos
    private String nome;
    private String email;
    private String telefone;

    // construtor usando parâmetros
    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente() {
        this.nome = "";
        this.email = "";
        this.telefone = "";
    }

    // métodos

    public String obterContatos(){
        return String.format("Contato: %s \nE-mail: %s \nTelefone: %s", this.getNome(),
                this.getEmail(), this.getTelefone());
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
}
