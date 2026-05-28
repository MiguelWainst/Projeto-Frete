package model.entities;

import java.time.Duration;

public class ResultadoCalculo {

    /*
    Esta classe é responsável por guardar um objeto carregando
    as informações necessárias para um print do recibo.
     */

    private String transporte;
    private Double preco;
    private Double taxaFrete;
    private Double precoTotal;
    private String tipoDeCarga;
    private Double adicionalCarga;
    private String endereco;

    public ResultadoCalculo(String transporte, Double preco, Double taxaFrete, Double precoTotal,
                            String tipoDeCarga, Double adicionalCarga, String endereco) {
        this.transporte = transporte;
        this.preco = preco;
        this.taxaFrete = taxaFrete;
        this.precoTotal = precoTotal;
        this.tipoDeCarga = tipoDeCarga;
        this.adicionalCarga = adicionalCarga;
        this.endereco = endereco;
    }

    public Double getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(Double taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getAdicionalCarga() {
        return adicionalCarga;
    }

    public void setAdicionalCarga(Double adicionalCarga) {
        this.adicionalCarga = adicionalCarga;
    }

    public String getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }
}
