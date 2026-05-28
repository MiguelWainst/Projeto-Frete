package model.servicies;

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
     * @param preco - O preço é usado para calcular o advalorem. O valor deve estar
     *              entre 0 e 1 Bilhão.
     * @param peso - O peso nessa classe é usada apenas para comparar com o Peso Volumétrico
     *             que a classe PV retorna. O cálculo exige que seja usado o maior entre
     *             os dois.
     * @param endereco - Por agora, esta variável é apenas usada para fazer parte do cupom
     *                 fiscal.
     * @param cargaTipo - O tipo de carga é necessário para o cálculo do advalorem.
     * @param comprimento - Parâmetro de medição para o cálculo do PV (Peso Volumétrico).
     * @param largura - //
     * @param altura - //
     * @param FP - O Frete Peso é o valor dado em cima do Peso Volumétrico.
     * @param adv - Instanciação do Advalorem.
     * @param PV - Instanciação do Peso Volumétrico
     * @param transporteTipos - A Lista de tipo de transporte serve para poder calcular
     *                        todos os tipos de transportes antes de pedir para o cliente
     *                        que tipo de transporte ele quer utilizar. É mais fácil
     *                        escolher quando se sabe o preço de cada um.
     * @param resultadoCalculo - Essa lista serve exclusivamente para guardar o resultado
     *                         dos cálculos de cada tipo da lista "TransporteTipo".
     * @param rota - É necessário saber a rota, porque sem ela não é possível calcular
     *             o Frete Peso (FP).
     */
    public void calcularPrecoFrete(Double preco, Double peso, String endereco, CargaTipo cargaTipo, Double comprimento, Double largura, Double altura,
                                   FPService FP, AdvaloremService adv, PVService PV,
                                   List<TransporteTipo> transporteTipos, List<ResultadoCalculo> resultadoCalculo, Rota rota) {

        for (TransporteTipo transporteTipo : transporteTipos) {
            Double pesoVolumetrico = Math.max(peso, PV.pVCalculo(comprimento,largura, altura, transporteTipo));
            Double fretePeso = FP.fPCalculo(pesoVolumetrico, rota, transporteTipo);
            Double advalorem = adv.calcAdvalorem(preco, cargaTipo);
            Double precoTotal = fretePeso + advalorem;
            resultadoCalculo.add(new ResultadoCalculo(transporteTipo.getTransporteNome(), preco, fretePeso, precoTotal, cargaTipo.name(), advalorem, endereco));
        }

    }
}
