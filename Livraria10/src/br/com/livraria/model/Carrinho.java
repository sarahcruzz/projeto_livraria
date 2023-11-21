package br.com.livraria.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    // Atributos
    private String identificador;
    private Cliente cliente;
    private List<Produto> itens;

    // Construtor
    public Carrinho(Cliente cliente) {
        this.identificador = ""; // Geração interna de id
        this.cliente = cliente;
        this.itens = new ArrayList<Produto>();
    }

    // Métodos de acesso
    public String getIdentificador() {
        return identificador;
    }

    // Geração interna de id
    //public void setIdentificador(String identificador) this.identificador = identificador;

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Produto> getItens() {
        return itens;
    }

    // Inserção de uma lista de itens
    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    // Inserção de um item
    public void setItem(Produto item) {
        this.itens.add(item);
    }


    // Funcionalidades
    public boolean finalizarVenda(){
        return true;
    }


    public String verCarrinho(){

        String retorno = String.format("br.com.livraria.model.Cliente: %s \n", this.getCliente().getNome());

        for (int i = 0; i < this.itens.size(); i++) {
            retorno += String.format("Item %d: %s \n", (i +1), this.getItens().get(i).getDescricao());
        }

        return retorno;
    }
}

