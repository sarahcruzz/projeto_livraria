package br.com.livraria.controller;

import br.com.livraria.model.ControleUsuario;
import br.com.livraria.model.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class JFXLogin {

     // Atributos
    private Stage palcoLogin;
    // Referências FXML
    public TextField tfLogin;
    public Button bEntrar;
    public Button bFechar;
    public PasswordField pfSenha;

    // Métodos de acesso (getters e setters)
    public Stage getPalcoLogin() {
        return palcoLogin;
    }
    public void setPalcoLogin(Stage palcoLogin) {
        this.palcoLogin = palcoLogin;
    }

    // Funcionalidades
    public void logar(ActionEvent actionEvent) throws IOException {

        ControleUsuario controleUsuario = new ControleUsuario();
        Funcionario funcionario = new Funcionario();

        funcionario.setNome("Maria Silva");
        funcionario.setLogin(tfLogin.getText());
        funcionario.setSenha(pfSenha.getText());

        if (controleUsuario.autenticar(funcionario)){

            // Cria um novo palco para a tela JFXPrincipal
            Stage stagePrincipal = new Stage();

            // Objeto que carrega o arquivo fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/br/com/livraria/view/JFXLivraria.fxml"));
            // Objeto BorderPane (container utilizado no layout)
            // Controle (nó) raiz recebe a referência do arquivo fxml
            BorderPane nodeRoot = loader.load();
            // Criação da cena recebendo o controle raiz
            Scene scene = new Scene(nodeRoot);
            // Atribuição da cena no palco
            stagePrincipal.setScene(scene);

            // O objeto loader possui a referência do tela JFXLivraria
            JFXLivraria livrariaController = loader.getController();
            // Essa referência também dá acesso aos métodos de JFXLivraria
            // (setPalcoLivraria(), setUsuarioLogado() e setNomeUsuarioLogado())
            // Armazenar a sua própria referência (tela JFXLogin (stageLogin))
            // possibilitará fechá-la posteriormente
            livrariaController.setPalcoLivraria(stagePrincipal);
            // Armazena o objeto funcionario (dados do usuário logado)
            livrariaController.setUsuarioLogado(funcionario);
            // Armazena o nome do usuário no label que identifica o usuário logado
            livrariaController.setNomeUsuarioLogado(funcionario.getNome());

            // Retira a barra superior da janela (icone, título, minimizar, maximizar e fechar)
            stagePrincipal.initStyle(StageStyle.UNDECORATED);
            // Não permite redimensionamento
            stagePrincipal.setResizable(false);
            // Apresenta a janela centralizada na tela
            stagePrincipal.centerOnScreen();

            // Apresenta o palco
            stagePrincipal.show();

            // Fecha a tela JFXLogin
            this.getPalcoLogin().close();

        }else{

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login");
            alert.setHeaderText("Falha na validação de usuário.");
            alert.setContentText("Login e/ou senha não identificados.");
            alert.showAndWait();
        }
    }

    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
}

