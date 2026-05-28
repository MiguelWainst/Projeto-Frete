package model.entities.enums;

/**
 * Define as categorias de carga e suas respectivas taxas de seguro (Advalorem).
 * <p>
 * Cada tipo de carga possui uma porcentagem de taxa diferente que varia conforme
 * o modal de transporte (Aéreo, Marítimo ou Terrestre), refletindo o risco
 * de cada operação.
 *
 * @author Miguel Wainstein
 * @version 1.0
 * @since 28/05/2026
 */
public enum CargaTipo {
    /* * As constantes abaixo representam as taxas em formato decimal.
     * Exemplo: 0.012 significa 1.2% sobre o valor da mercadoria.
     */
    /** Cargas perigosas que exigem manuseio especial. */
    INFLAMAVEL(0.012, 0.009, 0.01),
    /** Objetos quebráveis que demandam cuidado extra. */
    FRAGIL(0.005, 0.009, 0.007),
    /** Mercadorias de alto valor com grande risco de roubo (eletrônicos, etc). */
    VISADO(0.004, 0.003, 0.01),
    /** Cargas padrão sem necessidades específicas de segurança. */
    COMUM(0.001, 0.002, 0.003);

    // Atributos que guardam as taxas para cada modal.
    private final Double aereo;
    private final Double maritimo;
    private final Double terrestre;

    // Construtor
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
