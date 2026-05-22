package model.entities;

import model.interfaces.IImposto;
import model.interfaces.ITransporte;

public class TTerrestre extends Transporte implements ITransporte {
    @Override
    public Double TaxaFrete(Double peso) {
        return 13.00;
    }

    @Override
    public String toString() {
        return "Frete Terrestre";
    }
}
