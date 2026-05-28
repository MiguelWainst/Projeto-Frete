package model.servicies;

import model.entities.enums.CargaTipo;
import model.entities.enums.TransporteTipo;

/**
 * Classe que calcula o Advalorem (seguro) da carga.
 * O cálculo é a % do advalorem referente ao tipo da carga (frágil,
 * inflamável, visado, comum, etc.). Essa informação vem do {@link CargaTipo}.
 * Cada modal tem a sua porcentagem em cima de cada tipo de carga.
 * O {@link TransporteTipo} serve para saber o transporte. Cada porcentagem
 * de tipo de carga muda conforme o transporte.
 *
 * @author Miguel Wainstein
 * @version 1.0
 * @since 28/05/2026
 */
public class AdvaloremService {
    /**
     * Calcula o advalorem.
     * Preco * % advalorem.
     *
     * @param preco Preço da carga.
     * @param cargaTipo Enum que guarda o tipo da carga (comum, frágil, etc.)
     *                  e dentro dela tem um valor que depende do tipo de transporte.
     * @param transporteTipo Enum necessário para acessar a % correta do tipo
     *                       da carga.
     * @return Valor nu do advalorem.
     */
    public Double calcAdvalorem(Double preco, CargaTipo cargaTipo, TransporteTipo transporteTipo) {
        return preco * transporteTipo.extrairCargaTipo(cargaTipo);
    }
}
