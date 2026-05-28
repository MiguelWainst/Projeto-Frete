package model.entities.enums;

public enum CargaTipo {
    /* Preços extra pago dependendo do tipo de carga
    transportada até o destinatário. */

    INFLAMAVEL(0.012, 0.009, 0.01),
    FRAGIL(0.005, 0.009, 0.007),
    VISADO(0.004, 0.003, 0.01),
    COMUM(0.001, 0.002, 0.003);

    private final Double aereo;
    private final Double maritimo;
    private final Double terrestre;

    CargaTipo(Double aereo, Double maritimo, Double terrestre) {
        this.aereo = aereo;
        this.maritimo = maritimo;
        this.terrestre = terrestre;
    }

    public Double getAereo() {
        return aereo;
    }

    public Double getMaritimo() {
        return maritimo;
    }

    public Double getTerrestre() {
        return terrestre;
    }
}
