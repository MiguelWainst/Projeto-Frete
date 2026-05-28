package model.entities;

import model.entities.enums.CargaTipo;
import model.entities.enums.Rota;

public class Carga {
    private Double preco;
    private Double peso;
    private String endereco;
    private CargaTipo cargaTipo;
    private Dimensao dimensao;
    private Rota rota;

    public Carga(Double preco, Double peso, String endereco, CargaTipo cargaTipo, Dimensao dimensao, Rota rota) {
        this.preco = preco;
        this.peso = peso;
        this.endereco = endereco;
        this.cargaTipo = cargaTipo;
        this.dimensao = dimensao;
        this.rota = rota;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public CargaTipo getCargaTipo() {
        return cargaTipo;
    }

    public void setCargaTipo(CargaTipo cargaTipo) {
        this.cargaTipo = cargaTipo;
    }

    public Dimensao getDimensao() {
        return dimensao;
    }

    public void setDimensao(Dimensao dimensao) {
        this.dimensao = dimensao;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
}
