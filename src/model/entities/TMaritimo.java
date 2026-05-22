package model.entities;

import model.interfaces.IImposto;
import model.interfaces.ITransporte;

public class TMaritimo extends Transporte implements ITransporte {
    private static final Double VALOR_DESPACHO = 50.00;

    @Override
    public Double TaxaFrete(Double peso) {
        if (peso < 0 || peso > 10000) {
            throw new IllegalArgumentException("Peso inválido!");
        } else if (peso <= 100) {
            return 30.00 + VALOR_DESPACHO;
        } else if (peso >= 101 && peso <= 500) {
            return peso * 2.0 + VALOR_DESPACHO;
        } else {
            return peso * 6.0 + VALOR_DESPACHO;
        }
    }

    @Override
    public String toString() {
        return "Frete Marítimo";
    }
}
