package model.servicies;

import model.entities.*;
import model.entities.enums.CargaTipo;
import model.interfaces.IImposto;
import model.interfaces.ITaxaTransporte;

import javax.xml.datatype.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxaFreteService {
    /* Preço extra pago dependendo do tipo de carga
    transportada até o destinatário. */
    private static final Double ADICIONAL_INFLAMAVEL = 100.00;
    private static final Double ADICIONAL_FRAGIL     = 50.00;
    private static final Double ADICIONAL_COMUM      = 0.00;

    public void calcularPrecoFrete(Double preco, Double peso, CargaTipo cargaTipo, IImposto imposto, String endereco,
                                   List<ResultadoCalculo> resultado) {

        // Esta é uma lista de interfaces e tudo o que estende ela.
        List<? extends ITaxaTransporte> list = Arrays.asList(new TAereo(), new TMaritimo(), new TTerrestre());

        int i=0; // Índicie responsável por controlar a lista.
        for (ITaxaTransporte taxaTransporte:list) {

            /* Adiciona a taxa de frete conforme a regra de negócio
            da classe que implementa a interface ITaxaTransporte. */
            Double taxa = taxaTransporte.TaxaFrete(peso);
            Double precoComTaxa = taxa + preco; // Adiciona à lista o preço com a taxa.

            // Laço que adiciona imposto e adicional de tipo de carga ao preço final.
            Double precoTotal = 0.0; // Guarda o preço final a ser pago.
            Double impostoPreco = imposto.regraImposto(preco); // Guarda apenas o valor do imposto.
            Double adicionalCarga = 0.0; // Guarda o valor de adicional de carga.

            /* Cadeia de if e else feita para testar qual o tipo de carga
            vai ser transportada, dependendo do tipo da carga o valor
            vai aumentar conforme a regra: */
            if (cargaTipo == CargaTipo.COMUM) {
                precoTotal = ADICIONAL_COMUM;
                adicionalCarga = ADICIONAL_COMUM;
            } else if (cargaTipo == CargaTipo.FRAGIL) {
                precoTotal = ADICIONAL_FRAGIL;
                adicionalCarga = ADICIONAL_FRAGIL;
            } else if (cargaTipo == CargaTipo.INFLAMAVEL) {
                precoTotal =  ADICIONAL_INFLAMAVEL;
                adicionalCarga = ADICIONAL_INFLAMAVEL;
            }

            precoTotal += precoComTaxa + impostoPreco; // Soma o preço com taxa e o imposto ao preço total.

            // Adiciona à lista "resultado" uma nova instância de ResultadoCalculo.
            /* Essa ".add" é responsável por passar um objeto do tipo ResultadoCalculo
            para a lista ResultadoCalculo. */
            resultado.add(new ResultadoCalculo(list.get(i).toString(), preco, precoTotal, taxa,
                    impostoPreco, cargaTipo.toString(), "1 Dia", endereco, adicionalCarga));

            i++; // Incrementa para calcular o próximo item.
        }
    }
}
