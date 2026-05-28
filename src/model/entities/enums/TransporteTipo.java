package model.entities.enums;

/**
 * Enum que define os modais de transporte disponíveis e suas respectivas
 * regras de cálculo.
 * <p>
 * Cada constante implementa métodos abstratos para extrair valores específicos
 * de preços e taxas, funcionando como um seletor dinâmico baseado na estratégia
 * de transporte escolhida.
 *
 * @author Miguel Wainstein
 * @version 1.0
 * @since 28/05/2026
 */
public enum TransporteTipo {
    /**
     * Modal aéreo. Utiliza o fator de cubagem padrão de 166.67.
     */
    AEREO(166.67, "Aéreo") {
        @Override
        public Double extrairPrecoKg(Rota rota) {return rota.getKmAereo();}
        @Override
        public Double extrairMinimo(Rota rota) {return rota.getMinAereo();}
        @Override
        public Double extrairCargaTipo(CargaTipo cargaTipo) {return cargaTipo.getAereo();}
    },
    /**
     * Modal terrestre (rodoviário). Utiliza o fator de cubagem padrão de 300.0.
     */
    TERRESTRE(300.0, "Rodoviário") {
        @Override
        public Double extrairPrecoKg(Rota rota) {return rota.getKmTerra();}
        @Override
        public Double extrairMinimo(Rota rota) {return rota.getMinTerra();}
        @Override
        public Double extrairCargaTipo(CargaTipo cargaTipo) {return cargaTipo.getTerrestre();}
    },
    /**
     * Modal marítimo (cabotagem ou longo curso). Utiliza o fator de cubagem de 1000.0.
     */
    MARITIMO(1000.0, "Marítimo") {
        @Override
        public Double extrairPrecoKg(Rota rota) {return rota.getKmMaritimo();}
        @Override
        public Double extrairMinimo(Rota rota) {return rota.getMinMaritimo();}
        @Override
        public Double extrairCargaTipo(CargaTipo cargaTipo) {return cargaTipo.getMaritimo();}
    };

    /** Fator de conversão de volume para peso volumétrico. */
    private final Double cubagem;
    /** Nome amigável do transporte para exibição em recibos. */
    private final String transporteNome;

    /**
     * Extrai o preço por KG específico da rota para o modal atual.
     * @param rota A rota contendo a tabela de preços.
     * @return O valor do KG correspondente ao transporte.
     */
    public abstract Double extrairPrecoKg(Rota rota);

    /**
     * Extrai o valor do frete mínimo da rota para o modal atual.
     * @param rota A rota contendo a tabela de mínimos.
     * @return O valor mínimo aceitável para o transporte.
     */
    public abstract Double extrairMinimo(Rota rota);

    /**
     * Extrai a porcentagem de Advalorem baseada no tipo de carga {@link CargaTipo}
     * e no modal.
     * @param cargaTipo O tipo da carga (frágil, comum, etc.).
     * @return A taxa percentual correspondente ao modal.
     */
    public abstract Double extrairCargaTipo(CargaTipo cargaTipo);

    TransporteTipo(Double cubagem, String transporteNome) {
        this.cubagem = cubagem;
        this.transporteNome = transporteNome;
    }

    public Double getCubagem() {
        return cubagem;
    }

    public String getTransporteNome() {
        return transporteNome;
    }
}
