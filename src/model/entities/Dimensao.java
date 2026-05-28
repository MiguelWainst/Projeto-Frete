package model.entities;

/**
 * Representa as medidas físicas da carga e fornece o cálculo de volume.
 * <p>
 * Utiliza o recurso de {@code record} do Java para garantir a imutabilidade dos dados,
 * servindo como uma estrutura matemática para o cálculo da cubagem.
 * </p>
 * @param comprimento A medida longitudinal da mercadoria em metros.
 * @param largura     A medida transversal da mercadoria em metros.
 * @param altura      A medida vertical da mercadoria em metros.
 *
 * @author Miguel Wainstein
 * @version 1.0
 * @since 28/05/2026
 */
public record Dimensao(Double comprimento, Double largura, Double altura) {
    public Double calcDimensao() {
        /**
         * Calcula o volume cúbico total da mercadoria.
         * <p>
         * O resultado deste method (C x L x A) é utilizado posteriormente
         * pelo serviço de peso volumétrico para determinar a taxa de ocupação de espaço.
         * @return O volume em metros cúbicos (m³).
         */
        return comprimento * largura * altura;
    }
}
