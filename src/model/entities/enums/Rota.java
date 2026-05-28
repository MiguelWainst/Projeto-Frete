package model.entities.enums;

/**
 * Tabela de preços e fretes mínimos organizada por trajetos regionais.
 * <p>
 * Este Enum funciona como um repositório de tarifas, onde cada constante
 * armazena os custos por quilograma e os valores mínimos de faturamento
 * para os modais Terrestre, Marítimo e Aéreo.
 * @author Miguel Wainstein
 * @version 1.0
 * @since 28/05/2026
 */
public enum Rota {
    /** Rota Santa Catarina para São Paulo. */
    SC_SP(0.75, 50.0, 0.35, 130.0, 4.5, 110.0),
    /** Rota Santa Catarina para Amazonas (Longo percurso). */
    SC_AM(3.50, 180.0, 3.50, 180.0, 12.0, 250.0),
    /** Rota Santa Catarina para Rio Grande do Sul. */
    SC_RS(0.6, 45.0, 0.45, 110.0, 3.80, 95.0);

    private final Double kmTerra;
    private final Double minTerra;
    private final Double kmMaritimo;
    private final Double minMaritimo;
    private final Double kmAereo;
    private final Double minAereo;

    /**
     * Construtor da Rota com sua respectiva tabela de preços.
     * @param kmTerra Preço por KG no modal rodoviário.
     * @param minTerra Valor mínimo do frete rodoviário.
     * @param kmMaritimo Preço por KG no modal marítimo.
     * @param minMaritimo Valor mínimo do frete marítimo.
     * @param kmAereo Preço por KG no modal aéreo.
     * @param minAereo Valor mínimo do frete aéreo.
     */
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
