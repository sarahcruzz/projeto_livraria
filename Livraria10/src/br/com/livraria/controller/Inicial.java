package br.com.livraria.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Inicial extends Application {

    @Override
    public void start(Stage stageLogin) throws Exception {
        // Objeto que carrega o arquivo fxml
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/br/com/livraria/view/JFXLogin.fxml"));
        // Objeto AnchorPane (container utilizado no layout)
        // Controle (nó) raiz recebe a referência do arquivo fxml
        AnchorPane nodeRoot = loader.load();
        // Criação da cena recebendo o controle raiz
        Scene scene = new Scene(nodeRoot);
        // Atribuição da cena no palco
        stageLogin.setScene(scene);

        // O objeto loader possui a referência do tela JFXLogin
        JFXLogin loginController = loader.getController();
        // Essa referência também dá acesso aos métodos de JFXLogin (no caso, setPalcoLogin())
        // Armazenar a sua própria referência (tela JFXLogin (stageLogin))
        // possibilitará fechá-la posteriormente
        loginController.setPalcoLogin(stageLogin);

        // Retira a barra superior da janela (icone, título, minimizar, maximizar e fechar)
        stageLogin.initStyle(StageStyle.UNDECORATED);
        // Não permite redimensionamento
        stageLogin.setResizable(false);
        // Apresenta a janela centralizada na tela
        stageLogin.centerOnScreen();

        // Apresenta o palco
        stageLogin.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

