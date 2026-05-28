package model.entities.enums;

public enum Rota {
    SC_SP(0.75, 50.0, 0.35, 130.0, 4.5, 110.0),
    SC_AM(3.50, 180.0, 3.50, 180.0, 12.0, 250.0),
    SC_RS(0.6, 45.0, 0.45, 110.0, 3.80, 95.0);

    private final Double kmTerra;
    private final Double minTerra;
    private final Double kmMaritimo;
    private final Double minMaritimo;
    private final Double kmAereo;
    private final Double minAereo;

    Rota(Double kmTerra, Double minTerra, Double kmMaritimo, Double minMaritimo, Double kmAereo, Double minAereo) {
        this.kmTerra = kmTerra;
        this.minTerra = minTerra;
        this.kmMaritimo = kmMaritimo;
        this.minMaritimo = minMaritimo;
        this.kmAereo = kmAereo;
        this.minAereo = minAereo;
    }

    public Double getKmTerra() {
        return kmTerra;
    }

    public Double getMinTerra() {
        return minTerra;
    }

    public Double getKmMaritimo() {
        return kmMaritimo;
    }

    public Double getMinMaritimo() {
        return minMaritimo;
    }

    public Double getKmAereo() {
        return kmAereo;
    }

    public Double getMinAereo() {
        return minAereo;
    }
}
