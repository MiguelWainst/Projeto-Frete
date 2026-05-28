package model.servicies;

import model.entities.enums.TransporteTipo;

public class PVService {
    public Double pVCalculo(Double comp, Double larg, Double alt, TransporteTipo transporteTipo) {
        Double PV;
        PV = (comp * larg * alt) * transporteTipo.getCubagem();
        return PV;
    }
}
