package br.com.livraria.controller;

import br.com.livraria.model.ClientePF;
import br.com.livraria.model.ClientePJ;
import br.com.livraria.model.ControleUsuario;
import br.com.livraria.model.Funcionario;

import java.math.BigDecimal;

public class Teste {
    public static void main(String[] args) {

        ClientePF clientePF = new ClientePF("João da Silva",
                "","","","","","","",BigDecimal.valueOf(0),
                "","");

        ClientePJ clientePJ = new ClientePJ("Escola Técnica",
                "","","","","","","",BigDecimal.valueOf(0),
                "","", "");

        Funcionario funcionario = new Funcionario("Maria dos Santos","Vendas");

        ControleUsuario controleUsuario = new ControleUsuario();


        clientePF.setLogin("joao");
        clientePF.setSenha("123456");

        clientePJ.setLogin("usuario");
        clientePJ.setSenha("123456");

        funcionario.setLogin("usuario");
        funcionario.setSenha("654321");


        if (controleUsuario.autenticar(clientePF)){
            System.out.println("Acesso autorizado!");
        }else{
            System.out.println("Acesso negado!");
        }

        if (controleUsuario.autenticar(clientePJ)){
            System.out.println("Acesso autorizado!");
        }else{
            System.out.println("Acesso negado!");
        }

        if (controleUsuario.autenticar(funcionario)){
            System.out.println("Acesso autorizado!");
        }else{
            System.out.println("Acesso negado!");
        }

    }
}












