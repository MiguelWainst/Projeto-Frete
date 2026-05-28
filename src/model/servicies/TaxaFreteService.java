package model.servicies;

import model.Carga;
import model.entities.*;
import model.entities.enums.CargaTipo;
import model.entities.enums.Rota;
import model.entities.enums.TransporteTipo;

import java.util.List;

public class TaxaFreteService {

    /**
     *
     * Esta função é a responsável por dar o veredito final do preço. Ela junta todos os
     * serviços que tratam do valor do frete, usa e ordena eles de forma organizada e
     * depois adiciona todos os resultados numa lista "ResultadoCalculo" para salvar os
     * resultados e tratar eles do jeito que precisar.
     *
     * @param cargaInfo - Classe contendo todas os dados da carga.
     * @param FP - O Frete Peso é o valor dado em cima do Peso Volumétrico.
     * @param adv - Instanciação do Advalorem.
     * @param PV - Instanciação do Peso Volumétrico
     * @param transporteTipos - A Lista de tipo de transporte serve para poder calcular
     *                        todos os tipos de transportes antes de pedir para o cliente
     *                        que tipo de transporte ele quer utilizar. É mais fácil
     *                        escolher quando se sabe o preço de cada um.
     * @param resultadoCalculo - Essa lista serve exclusivamente para guardar o resultado
     *                         dos cálculos de cada tipo da lista "TransporteTipo".
     */
    public void calcularPrecoFrete(Carga cargaInfo,
                                   FPService FP, AdvaloremService adv, PVService PV,
                                   List<TransporteTipo> transporteTipos, List<ResultadoCalculo> resultadoCalculo) {

        for (TransporteTipo transporteTipo : transporteTipos) {
            Double pesoVolumetrico = PV.calcularPesoTaxavel(cargaInfo.getPeso(), cargaInfo.getDimensao(), transporteTipo);
            Double fretePeso = FP.fPCalculo(pesoVolumetrico, cargaInfo.getRota(), transporteTipo);
            Double advalorem = adv.calcAdvalorem(cargaInfo.getPreco(), cargaInfo.getCargaTipo());
            Double precoTotal = fretePeso + advalorem;
            resultadoCalculo.add(new ResultadoCalculo(transporteTipo.getTransporteNome(), cargaInfo.getPreco(), fretePeso, precoTotal, cargaInfo.getCargaTipo().name(), advalorem, cargaInfo.getEndereco()));
        }

    }
}
