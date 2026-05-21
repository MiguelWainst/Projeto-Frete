package model.entities;

import java.time.Duration;

public class RelatorioDoFrete {
    private Double preco;
    private Double peso;
    private Double impostoAplicado;
    private Double taxaFrete;
    private Duration tempoDeViagem;
    private Double adicionalCargaTipo;

    public RelatorioDoFrete(Double preco, Double peso, Double impostoAplicado, Double taxaFrete, Duration tempoDeViagem, Double adicionalCargaTipo) {
        this.preco = preco;
        this.peso = peso;
        this.impostoAplicado = impostoAplicado;
        this.taxaFrete = taxaFrete;
        this.tempoDeViagem = tempoDeViagem;
        this.adicionalCargaTipo = adicionalCargaTipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getImpostoAplicado() {
        return impostoAplicado;
    }

    public void setImpostoAplicado(Double impostoAplicado) {
        this.impostoAplicado = impostoAplicado;
    }

    public Double getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(Double taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public Duration getTempoDeViagem() {
        return tempoDeViagem;
    }

    public void setTempoDeViagem(Duration tempoDeViagem) {
        this.tempoDeViagem = tempoDeViagem;
    }

    public Double getAdicionalCargaTipo() {
        return adicionalCargaTipo;
    }

    public void setAdicionalCargaTipo(Double adicionalCargaTipo) {
        this.adicionalCargaTipo = adicionalCargaTipo;
    }
}
