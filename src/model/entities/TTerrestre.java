package model.entities;

import model.interfaces.ITaxaTransporte;

public class TTerrestre extends Transporte implements ITaxaTransporte {
    @Override
    public Double TaxaFrete(Double peso) {
        return 13.00;
    }

    @Override
    public String toString() {
        return "Frete Terrestre";
    }
}
