package model.entities;


import model.interfaces.ITransporte;

public class TAereo extends Transporte implements ITransporte{
    private static final Double VALOR_DESPACHO = 100.00;

    @Override
    public Double TaxaFrete(Double peso) {
        if (peso < 0 || peso > 2000) {
            throw new IllegalArgumentException("Peso inválido!");
        } else if (peso <= 20) {
            return 100.00 + VALOR_DESPACHO;
        } else if (peso >= 21 && peso <= 50) {
            return peso * 5.0 + VALOR_DESPACHO;
        } else {
            return peso * 12.0 + VALOR_DESPACHO;
        }
    }
    @Override
    public String toString() {
        return "Frete Aéreo";
    }
}
