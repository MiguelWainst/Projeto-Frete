package model.entities;

import model.entities.enums.CargaTipo;
import model.entities.enums.Rota;

/**
 * Representa a mercadoria completa a ser transportada.
 * <p>
 * Esta classe atua como o principal objeto de valor do sistema, agrupando
 * informações de preço, peso, dimensões, categoria de risco e o trajeto (rota)
 * definido pelo cliente.
 *
 * @author Miguel Wainstein
 * @version 1.0
 * @since 28/05/2026
 */
public class Carga {
    private Double preco;
    private Double peso;
    private String endereco;
    private CargaTipo cargaTipo;
    private Dimensao dimensao;
    private Rota rota;

    /**
     * Construtor para inicializar uma carga com todos os atributos necessários.
     * @param preco     Valor comercial da mercadoria.
     * @param peso      Peso real aferido em balança (KG).
     * @param endereco  Local de destino da entrega.
     * @param cargaTipo Categoria da carga (Fragil, Inflamavel, etc.).
     * @param dimensao  Objeto contendo as medidas (C x L x A) da carga.
     * @param rota      O trajeto de origem e destino selecionado.
     */
    public Carga(Double preco, Double peso, String endereco, CargaTipo cargaTipo, Dimensao dimensao, Rota rota) {
        this.preco = preco;
        this.peso = peso;
        this.endereco = endereco;
        this.cargaTipo = cargaTipo;
        this.dimensao = dimensao;
        this.rota = rota;
    }

    // Getters e Setters
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