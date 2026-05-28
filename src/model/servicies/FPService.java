package model.servicies;

import model.entities.enums.Rota;
import model.entities.enums.TransporteTipo;

/**
 * Essa classe é responsável por calcular o Frete Peso (FP). O cálculo
 * é feito multiplicando o Peso Volumétrico (PV) com o preço por KG.
 * O preço por KG depende da rota e do tipo de transporte. Essas
 * informações são fornecidas por {@link TransporteTipo} (tipo do
 * transporte) e {@link Rota} (rota percorrida).
 *
 * @author Miguel Wainstein
 * @version 1.0
 * @since 28/05/2026
 */
public class FPService {
    /**
     * Calcula o frete peso e devolve o maior valor entre os dois.
     *
     * @param PV Peso Volumétrico.
     * @param rota A rotaRota que a carga vai percorrer.
     * @param transporteTipo Tipo do transporte da vez.
     * @return O maior entre o FP (Frete Peso) calculado e o preço mínimo.
     */
    public Double calcularFretePeso(Double PV, Rota rota, TransporteTipo transporteTipo) {
        Double FP = PV * transporteTipo.extrairPrecoKg(rota);
        return Math.max(FP, transporteTipo.extrairMinimo(rota));
    }
}
