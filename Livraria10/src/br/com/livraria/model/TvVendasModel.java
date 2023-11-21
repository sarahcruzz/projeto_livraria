package br.com.livraria.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class TvVendasModel {

    // Atributos
    private final SimpleStringProperty produto;
    private final SimpleDoubleProperty mes01;
    private final SimpleDoubleProperty mes02;
    private final SimpleDoubleProperty mes03;

    // Construtor
    public TvVendasModel() {
        this.produto = new SimpleStringProperty();
        this.mes01 = new SimpleDoubleProperty();
        this.mes02 = new SimpleDoubleProperty();
        this.mes03 = new SimpleDoubleProperty();
    }

    public TvVendasModel(String produto, Double mes01, Double mes02, Double mes03) {
        this.produto = new SimpleStringProperty(produto);
        this.mes01 = new SimpleDoubleProperty(mes01);
        this.mes02 = new SimpleDoubleProperty(mes02);
        this.mes03 = new SimpleDoubleProperty(mes03);
    }

    // Métodos de acesso
    public String getProduto() {
        return produto.get();
    }
    public SimpleStringProperty getProdutoProperty() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto.set(produto);
    }

    public double getMes01() {
        return mes01.get();
    }
    public SimpleDoubleProperty getMes01Property() {
        return mes01;
    }
    public void setMes01(double mes01) {
        this.mes01.set(mes01);
    }

    public double getMes02() {
        return mes02.get();
    }
    public SimpleDoubleProperty getMes02Property() {
        return mes02;
    }
    public void setMes02(double mes02) {
        this.mes02.set(mes02);
    }

    public double getMes03() {
        return mes03.get();
    }
    public SimpleDoubleProperty getMes03Property() {
        return mes03;
    }
    public void setMes03(double mes03) {
        this.mes03.set(mes03);
    }
}
