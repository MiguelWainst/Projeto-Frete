package model.servicies;

import model.entities.Carga;
import model.entities.TAereo;
import model.entities.TMaritimo;
import model.entities.TTerrestre;
import model.entities.enums.CargaTipo;
import model.interfaces.IImposto;
import model.interfaces.ITransporte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxaFreteService {
    private static final Double ADICIONAL_INFLAMAVEL = 100.00;
    private static final Double ADICIONAL_FRAGIL = 50.00;
    private static final Double ADICIONAL_COMUM = 0.00;

    private final List<Double> precosFinais = new ArrayList<>();

    public void calcularPrecoFrete(Double preco, Double peso, CargaTipo cargaTipo, IImposto imposto) {
        // Esta é uma lista de interfaces e tudo o que estende ela.
        List<? extends ITransporte> list = Arrays.asList(new TAereo(), new TMaritimo(), new TTerrestre());
        List<Double> precoComTaxa = new ArrayList<>();
        List<? extends Carga> cargas = new ArrayList<>();

        // Laço for que adiciona taxa no preço.
        for (ITransporte x:list) {
            Double taxa = x.TaxaFrete(peso);

            precoComTaxa.add(taxa + preco);
        }

        // Laço que adiciona imposto ao e adicional de tipo de carga ao preço final.
        for (Double x:precoComTaxa) {
            if (cargaTipo == CargaTipo.COMUM) {
                precosFinais.add(x + imposto.regraImposto(preco) + ADICIONAL_COMUM);
            } else if (cargaTipo == CargaTipo.FRAGIL) {
                precosFinais.add(x + imposto.regraImposto(preco) + ADICIONAL_FRAGIL);
            } else if (cargaTipo == CargaTipo.INFLAMAVEL) {
                precosFinais.add(x + imposto.regraImposto(preco) + ADICIONAL_INFLAMAVEL);
            }
        }
    }

    public void readPrecosFinais() {
        for (Double pf : precosFinais) {
            System.out.println(pf.getClass().toString() + " | " + pf.toString());
        }
    }
}
