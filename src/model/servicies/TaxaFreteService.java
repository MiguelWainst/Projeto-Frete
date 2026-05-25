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

    public void calcularPrecoFrete(Double preco, Double peso, CargaTipo cargaTipo, IImposto imposto, String endereco,
                                   List<ResultadoCalculo> resultado, List<? extends ITaxaTransporte> list) {

        int i=0; // Índicie responsável por controlar a lista.
        for (ITaxaTransporte taxaTransporte:list) {

            /* Adiciona a taxa de frete conforme a regra de negócio
            da classe que implementa a interface ITaxaTransporte. */
            Double taxa = taxaTransporte.TaxaFrete(peso);
            Double precoComTaxa = taxa + preco;

            // Laço que adiciona imposto e adicional de tipo de carga ao preço final.
            Double precoTotal = 0.0; // Guarda o preço final a ser pago.
            Double impostoPreco = imposto.regraImposto(preco); // Guarda apenas o valor do imposto.
            Double adicionalCarga = 0.0; // Guarda o valor de adicional de carga.

            /* Lógica atualizada */
            /* Agora a lógica de acionar o valor adicional de carga
            está diretamente implementada no próprio enum. */
            adicionalCarga = cargaTipo.getAdicional();// Guarda o valor de adicional de carga. // O valor vem do enum.

            // Soma o preço com taxa, imposto e valor adicional de tipo de carga ao preço total.
            precoTotal += precoComTaxa + impostoPreco + adicionalCarga;

            // Adiciona à lista "resultado" uma nova instância de ResultadoCalculo.
            /* Esse ".add" é responsável por passar um objeto do tipo ResultadoCalculo
            para a lista ResultadoCalculo. */
            resultado.add(new ResultadoCalculo(taxaTransporte.toString(), preco, precoTotal, taxa,
                    impostoPreco, cargaTipo.toString(), "1 Dia", endereco, adicionalCarga));

            i++; // Incrementa para calcular o próximo item.
        }
    }
}
