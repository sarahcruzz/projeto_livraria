package br.com.livraria.model;

public class ControleUsuario {
    public boolean autenticar(Usuario usuario){

        String loginVerificado = "usuario";
        String senhaVerificada = "123456";

        boolean retorno = false;

        if(usuario.getLogin().equals(loginVerificado) && usuario.getSenha().equals(senhaVerificada)){
            retorno = true;
        }

        return retorno;
    }
}

