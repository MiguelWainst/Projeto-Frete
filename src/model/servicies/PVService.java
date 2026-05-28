package model.servicies;

import model.entities.Dimensao;
import model.entities.enums.TransporteTipo;

/**
 * Essa classe é responsável por retornar o Peso Volumétrico. Esse é
 * o peso taxável.
 * Pela regra de negócio, o peso que retorna da classe é sempre o maior
 * peso, ou seja, se o maior peso continuar a ser o original, então a
 * classe retorna o original.
 * @author Miguel Wainstein
 * @version 1.0
 * @since 28/05/2026
 */
public class PVService {
    /**
     *
     * @param peso O peso é utilizado para ser comparado ao PV.
     * @param medidas Classe {@link Dimensao} fornece as dimensões já prontas
     *                (Comprimento * Largura * Altura).
     * @param transporteTipo Enum {@link TransporteTipo} vem para que o cálculo
     *                       seja feito com a cubagem do tipo de transporte correto
     *                       (Aéreo 166.67 kg, Terrestre 300.0 kg, Maritimo 1T).
     * @return O maior valor entre peso real e o peso calculado pela cubagem (PV).
     */
    public Double calcularPesoTaxavel(Double peso, Dimensao medidas, TransporteTipo transporteTipo) {
        Double PV = medidas.calcDimensao() * transporteTipo.getCubagem();
        return Math.max(peso, PV);
    }
}
