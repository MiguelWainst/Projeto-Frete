package model.entities;

public record Dimensao(Double comprimento, Double largura, Double altura) {
    public Double calcDimensao() {
        return comprimento * largura * altura;
    }
}
