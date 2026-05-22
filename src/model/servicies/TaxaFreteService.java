package model.servicies;

import model.entities.*;
import model.entities.enums.CargaTipo;
import model.interfaces.IImposto;
import model.interfaces.ITaxaTransporte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxaFreteService {
    private static final Double ADICIONAL_INFLAMAVEL = 100.00;
    private static final Double ADICIONAL_FRAGIL = 50.00;
    private static final Double ADICIONAL_COMUM = 0.00;

    private final List<Double> precosFinais = new ArrayList<>();

    public List<ResultadoCalculo> calcularPrecoFrete(Double preco, Double peso, CargaTipo cargaTipo, IImposto imposto) {
        // Esta é uma lista de interfaces e tudo o que estende ela.
        List<? extends ITaxaTransporte> list = Arrays.asList(new TAereo(), new TMaritimo(), new TTerrestre());
        List<Double> precoComTaxa = new ArrayList<>();
        List<ResultadoCalculo> resultado = new ArrayList<>();

        int i=0; // Índicie responsável por controlar a lista.
        for (ITaxaTransporte taxaTransporte:list) {

            /* Adiciona a taxa de frete de acordo com a regra de negócio
            da classe que implementa a interface ITaxaTransporte. */
            Double taxa = taxaTransporte.TaxaFrete(peso);
            precoComTaxa.add(taxa + preco); // Adiciona à lista o preço com a taxa.

            // Laço que adiciona imposto e adicional de tipo de carga ao preço final.
            if (cargaTipo == CargaTipo.COMUM) {
                resultado.add(new ResultadoCalculo(list.get(i).toString(), precoComTaxa.get(i) + imposto.regraImposto(preco) + ADICIONAL_COMUM));
            } else if (cargaTipo == CargaTipo.FRAGIL) {
                resultado.add(new ResultadoCalculo(list.get(i).toString(), precoComTaxa.get(i) + imposto.regraImposto(preco) + ADICIONAL_FRAGIL));
            } else if (cargaTipo == CargaTipo.INFLAMAVEL) {
                resultado.add(new ResultadoCalculo(list.get(i).toString(), precoComTaxa.get(i) + imposto.regraImposto(preco) + ADICIONAL_INFLAMAVEL));
            }
            i++; // Incrementa para calcular o próximo item.
        }
        return resultado;
    }
}
