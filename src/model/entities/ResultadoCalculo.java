package model.entities;

public class ResultadoCalculo {
    private String transporte;
    private Double preco;

    public ResultadoCalculo(String transporte, Double preco) {
        this.transporte = transporte;
        this.preco = preco;
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
}
