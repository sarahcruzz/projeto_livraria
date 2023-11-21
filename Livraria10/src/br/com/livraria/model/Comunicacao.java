package br.com.livraria.model;

public class Comunicacao {

    // Atributos
    private String texto = "\nQueima de estoque relâmpago!\n";
    static private int quantidadeLimitada = 100;


    // Métodos de acesso (getters e setters)
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public int getQuantidadeLimitada() {
        return quantidadeLimitada;
    }
    public void setQuantidadeLimitada(int quantidadeLimitada) {
        this.quantidadeLimitada = quantidadeLimitada;
    }
    // Sobrecarga do método setQuantidadelimitada para decrementar o atributo
    public void setQuantidadeLimitada() {
        this.quantidadeLimitada--;
    }

    // Funcionalidades

    public void enviarPromocaoRelampago(ClientePF cliente){
        // Decrementa o atributo quantidadeLimitada
        this.setQuantidadeLimitada();

        String mensagem = String.format("\nOlá! %s", cliente.getNome());
        mensagem += this.getTexto();

        System.out.println(mensagem);
    }


    public void enviarPromocao(ClientePF cliente){

        String mensagem = "Olá! " + cliente.getNome();

        if(cliente.getEndereco().getCidade().equals("Campinas")){
            mensagem += "\nQueima de estoque! \nDescontos de até 50%\n";
        }else{
            mensagem += "\nFora da região da promoção\n";
        }

        System.out.println(mensagem);
    }

    public static String verificarPromocao(){
        return String.format("Faltam %d envios da promoção relâmpago.", quantidadeLimitada);
    }
}

