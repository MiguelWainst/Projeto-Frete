package model.entities.enums;

public enum TransporteTipo {
    AEREO(166.67, "Aéreo") {
        @Override
        public Double extrairPrecoKg(Rota rota) {return rota.getKmAereo();}
        @Override
        public Double extrairMinimo(Rota rota) {return rota.getMinAereo();}
        @Override
        public Double extrairCargaTipo(CargaTipo cargaTipo) {return cargaTipo.getAereo();}
    },
    TERRESTRE(300.0, "Rodoviário") {
        @Override
        public Double extrairPrecoKg(Rota rota) {return rota.getKmTerra();}
        @Override
        public Double extrairMinimo(Rota rota) {return rota.getMinTerra();}
        @Override
        public Double extrairCargaTipo(CargaTipo cargaTipo) {return cargaTipo.getTerrestre();}
    },
    MARITIMO(1000.0, "Marítimo") {
        @Override
        public Double extrairPrecoKg(Rota rota) {return rota.getKmMaritimo();}
        @Override
        public Double extrairMinimo(Rota rota) {return rota.getMinMaritimo();}
        @Override
        public Double extrairCargaTipo(CargaTipo cargaTipo) {return cargaTipo.getMaritimo();}
    };

    private final Double cubagem;
    private final String transporteNome;

    public abstract Double extrairPrecoKg(Rota rota);
    public abstract Double extrairMinimo(Rota rota);
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
