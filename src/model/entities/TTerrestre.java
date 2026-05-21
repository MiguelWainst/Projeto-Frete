package model.entities;

import model.interfaces.IImposto;
import model.interfaces.ITransporte;

public class TTerrestre implements ITransporte {
    @Override
    public Double TaxaFrete(Double peso) {
        return 13.00;
    }
}
