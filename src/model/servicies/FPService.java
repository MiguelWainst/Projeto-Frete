package model.servicies;

import model.entities.enums.Rota;
import model.entities.enums.TransporteTipo;

public class FPService {
    public Double fPCalculo(Double PV, Rota rota, TransporteTipo transporteTipo) {
        Double FP;
        FP = PV * transporteTipo.extrairPrecoKg(rota);
        if (FP > transporteTipo.extrairMinimo(rota)) {return FP;}
        else {return transporteTipo.extrairMinimo(rota);}
    }
}
