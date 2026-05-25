package model.entities.enums;

public enum CargaTipo {
    /* Preços extra pago dependendo do tipo de carga
    transportada até o destinatário. */

    INFLAMAVEL(100.0),
    FRAGIL(50.0),
    COMUM(0.0);

    private final Double adicional;

    CargaTipo(Double adicional) {
        this.adicional = adicional;
    }

    public Double getAdicional() {
        return adicional;
    }
}
