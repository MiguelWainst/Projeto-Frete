package model.entities;

/**
 * Representa o espelho do cálculo final de um frete.
 * <p>
 * Esta classe funciona como um contêiner de dados que armazena
 * detalhadamente os valores de frete, seguro e taxas, facilitando a
 * exibição e a geração do recibo para o cliente.
 *
 * @author Miguel Wainstein
 * @version 1.0
 * @since 28/05/2026
 */
public class ResultadoCalculo {
    /** Nome do modal de transporte (ex: Aéreo, Rodoviário). */
    private String transporte;
    /** Valor original da mercadoria informada pelo cliente. */
    private Double preco;
    /** Valor calculado apenas para o deslocamento (Frete Peso). */
    private Double taxaFrete;
    /** Valor final somando frete, adicionais e seguros. */
    private Double precoTotal;
    /** Nome descritivo da categoria da carga. */
    private String tipoDeCarga;
    /** Valor do seguro baseado no risco da carga (Advalorem). */
    private Double adicionalCarga;
    /** Local de destino da entrega. */
    private String endereco;


    public ResultadoCalculo(String transporte, Double preco, Double taxaFrete, Double precoTotal,
                            String tipoDeCarga, Double adicionalCarga, String endereco) {
        this.transporte = transporte;
        this.preco = preco;
        this.taxaFrete = taxaFrete;
        this.precoTotal = precoTotal;
        this.tipoDeCarga = tipoDeCarga;
        this.adicionalCarga = adicionalCarga;
        this.endereco = endereco;
    }

    // Getters e Setters.
    public Double getTaxaFrete() {
        return taxaFrete;
    }
    public void setTaxaFrete(Double taxaFrete) {
        this.taxaFrete = taxaFrete;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Double getAdicionalCarga() {
        return adicionalCarga;
    }
    public void setAdicionalCarga(Double adicionalCarga) {
        this.adicionalCarga = adicionalCarga;
    }
    public String getTipoDeCarga() {
        return tipoDeCarga;
    }
    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }
    public Double getPrecoTotal() {
        return precoTotal;
    }
    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public String getTransporte() {
        return transporte;
    }
    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }
}
