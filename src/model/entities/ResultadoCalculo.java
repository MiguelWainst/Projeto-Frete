package model.entities;

import java.time.Duration;

public class ResultadoCalculo {

    /*
    Esta classe é responsável por guardar um objeto carregando
    as informações necessárias para um print do recibo.
     */

    private String transporte;
    private Double preco;
    private Double precoTotal;
    private Double taxa;
    private Double imposto;
    private String tipoDeCarga;
    private Double adicionalCarga;
    private String duracao;
    private String endereco;

    public ResultadoCalculo(String transporte, Double preco, Double precoTotal, Double taxa,
                            Double imposto, String tipoDeCarga, String duracao, String endereco,
                            Double adicionalCarga) {
        this.transporte = transporte;
        this.preco = preco;
        this.precoTotal = precoTotal;
        this.taxa = taxa;
        this.imposto = imposto;
        this.tipoDeCarga = tipoDeCarga;
        this.adicionalCarga = adicionalCarga;
        this.duracao = duracao;
        this.endereco = endereco;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public String getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
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
}
