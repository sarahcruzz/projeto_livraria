package br.com.livraria.controller;

import br.com.livraria.model.Usuario;
import br.com.livraria.model.TvVendasModel;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class JFXLivraria implements Initializable {

    // Atributos
    private Usuario usuarioLogado;
    private Stage palcoLivraria;
    private ArrayList<TvVendasModel> listaVendas = new ArrayList<TvVendasModel>();

    // Referências FXML
    public Label lUsuario;
    public Button bCarregar;
    public TableView<TvVendasModel> tvVendas;
    public TableColumn<TvVendasModel,String> colProduto;
    public TableColumn<TvVendasModel,Double> colMes01;
    public TableColumn<TvVendasModel,Double> colMes02;
    public TableColumn<TvVendasModel,Double> colMes03;
    public BarChart graficoBarra;
    public LineChart graficoLinha;
    public PieChart graficoPizza;
    public ImageView iSair;


    // Inicialização/montagem do TableView
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colProduto.setCellValueFactory(new PropertyValueFactory<>("getProduto"));
        colMes01.setCellValueFactory(new PropertyValueFactory<>("getMes01"));
        colMes02.setCellValueFactory(new PropertyValueFactory<>("getMes02"));
        colMes03.setCellValueFactory(new PropertyValueFactory<>("getMes03"));
    }


    // Métodos de acesso (getters e setters)
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    public Stage getPalcoLivraria() {
        return palcoLivraria;
    }
    public void setPalcoLivraria(Stage palcoLivraria) {
        this.palcoLivraria = palcoLivraria;
    }

    // Métodos de acesso para a identificação do usuário logado (label)
    public String getNomeUsuarioLogado() {
        return this.lUsuario.getText();
    }
    public void setNomeUsuarioLogado(String nomeUsuarioLogado) {
        this.lUsuario.setText(nomeUsuarioLogado);
    }

    public ArrayList<TvVendasModel> getListaVendas() {
        return listaVendas;
    }
    // Recebe um ArrayList de Vendas (sobrepondo valores anteriores)
    public void setListaVendas(ArrayList<TvVendasModel> listaVendas) {
        this.listaVendas.addAll(listaVendas);
    }
    // Recebe uma Venda (adicionando ao ArrayList)
    public void setListaVendas(TvVendasModel venda) {
        this.listaVendas.add(venda);
    }


    // Funcionalidades

    public void atualizarTableView(){
        // Define a relação entre o TableView e a fonte de dados
        tvVendas.setItems(FXCollections.observableArrayList(this.getListaVendas()));
    }

    // Método vinculado ao botão Carregar da tela
    public void carregarArquivo(ActionEvent actionEvent) {

        try {
            // Objeto FileChooser para explorar pastas e arquivos
            FileChooser fileChooser = new FileChooser();
            // Define a tela onde o explorador de arquivos será aberto
            // Armazena o arquivo selecionado
            File arquivoSelecionado = fileChooser.showOpenDialog(palcoLivraria);

            // Objeto CSVReader para leitura do arquivo
            CSVReader leitorCSV = new CSVReaderBuilder(new FileReader(arquivoSelecionado)).build();

            // Lê a primeira linha do arquivo que equivale aos títulos das colunas
            String[] titulo = leitorCSV.readNext();

            // Atribui os titulos das colunas do arquivo nos titulos das colunas do TableView
            colProduto.setText(titulo[0]);
            colMes01.setText(titulo[1]);
            colMes02.setText(titulo[2]);
            colMes03.setText(titulo[3]);

            // Vetor para ler cada linha do arquivo
            String[] nextLine;

            // Enquanto não for a última linha
            while( (nextLine = leitorCSV.readNext()) != null ) {

                // Objeto TvVendasModel que equivale a uma linha do arquivo
                TvVendasModel venda = new TvVendasModel();
                // Atribui os valores de cada coluna
                venda.setProduto(nextLine[0]);
                venda.setMes01(Double.parseDouble(nextLine[1]));
                venda.setMes02(Double.parseDouble(nextLine[2]));
                venda.setMes03(Double.parseDouble(nextLine[3]));
                // Armazena o objeto no vetor fonte de dados da TableView
                this.setListaVendas(venda);
            }

            // Atualiza visualização da TableView
            atualizarTableView();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção!");
            alert.setHeaderText("Gráficos");
            alert.setContentText("Clique sobre um item da tabela para apresentar os gráficos!");
            alert.showAndWait();

            // Tratamento simplificado das exceptions relacionadas
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void obterVenda() {

        if(this.tvVendas.getSelectionModel().getSelectedIndex() < 0){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vendas");
            alert.setContentText("Nenhuma venda encontrada!");
            alert.showAndWait();

        }else{

            // Objeto TvVendasModel que receberá os daos de uma linha (item) do TableView
            TvVendasModel vendaSelecionada = new TvVendasModel();
            vendaSelecionada = tvVendas.getSelectionModel().getSelectedItem();

            // Apresenta os gráficos
            montaGraficoBarra();
            montaGraficoLinha();
            montaGraficoPizza(vendaSelecionada);
        }
    }


    public void montaGraficoBarra(){

        graficoBarra.getData().clear();

        this.tvVendas.getItems().forEach(umaVenda -> {
            // Cria as series para o gráfico
            XYChart.Series<String, Number> produto = new XYChart.Series<>();
            produto.setName(umaVenda.getProduto());

            //Adiciona os dados as séries
            produto.getData().add(new XYChart.Data<String, Number>(this.colMes01.getText(), umaVenda.getMes01()));
            produto.getData().add(new XYChart.Data<String, Number>(this.colMes02.getText(), umaVenda.getMes02()));
            produto.getData().add(new XYChart.Data<String, Number>(this.colMes03.getText(), umaVenda.getMes03()));

            //Adiciona as séries ao gráfico
            graficoBarra.getData().add(produto);

            graficoBarra.setTitle("Vendas Trimestre");
        });
    }

    public void montaGraficoLinha(){

        graficoLinha.getData().clear();

        this.tvVendas.getItems().forEach(umaVenda -> {
            // Cria as series para o gráfico
            XYChart.Series<String, Number> produto = new XYChart.Series<>();
            produto.setName(umaVenda.getProduto());

            //Adiciona os dados as séries
            produto.getData().add(new XYChart.Data<String, Number>(this.colMes01.getText(), umaVenda.getMes01()));
            produto.getData().add(new XYChart.Data<String, Number>(this.colMes02.getText(), umaVenda.getMes02()));
            produto.getData().add(new XYChart.Data<String, Number>(this.colMes03.getText(), umaVenda.getMes03()));

            //Adiciona as séries ao gráfico
            graficoLinha.getData().add(produto);

            graficoLinha.setTitle("Vendas Trimestre");
        });
    }

    public void montaGraficoPizza(TvVendasModel venda){

        graficoPizza.getData().clear();

        ObservableList<PieChart.Data> dados =
                FXCollections.observableArrayList(
                        new PieChart.Data(this.colMes01.getText(), venda.getMes01()),
                        new PieChart.Data(this.colMes02.getText(), venda.getMes02()),
                        new PieChart.Data(this.colMes03.getText(), venda.getMes03()));

        graficoPizza.setData(dados);

        graficoPizza.setTitle("Vendas Trimestre - " + venda.getProduto());
    }

    public void sair(MouseEvent mouseEvent) {
        System.exit(0);
    }

}