package model.servicies;

import model.entities.Carga;
import model.entities.*;
import model.entities.enums.TransporteTipo;
import model.interfaces.ITaxaFreteService;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe é o organizador do sistema de fretes.
 * Ela Implementa a interface ITaxaFreteService.
 * Ela coordena a execução dos serviços de Peso Volumétrico, Frete Peso
 * e Advalorem para consolidar o custo logístico de cada modal de transporte.
 *
 * @author Miguel Wainstein
 * @version 1.2
 * @since 28/05/2026
 */
public class TaxaFreteServiceBrazil implements ITaxaFreteService {
    private final FPService fretePesoService;
    private final PVService pesoVolumetricoService;
    private final AdvaloremService advaloremService;

    /**
     * O construtor recebe as ferramentas (serviços) necessárias.
     * Isso garante que a classe sempre tenha o que precisa para calcular.
     * @param fretePesoService Serviço para o cálculo do frete baseado em peso e rota.
     * @param pesoVolumetricoService Serviço que define se usamos o peso real ou o tamanho da caixa (cubagem).
     * @param advaloremService Serviço que calcula o valor do seguro da mercadoria.
     */
    public TaxaFreteServiceBrazil(FPService fretePesoService, PVService pesoVolumetricoService, AdvaloremService advaloremService) {
        this.fretePesoService = fretePesoService;
        this.pesoVolumetricoService = pesoVolumetricoService;
        this.advaloremService = advaloremService;
    }

    /**
     * Realiza o cálculo de todos os tipos de transporte e devolve uma lista com os resultados.
     * @param cargaInfo Objeto com os dados da mercadoria (peso, preço, dimensões, etc.).
     * @param transporteTipos Lista de transportes que queremos calcular (Aéreo, Terrestre, etc.).
     * @return Uma lista de objetos {@link ResultadoCalculo} contendo os orçamentos prontos.
     */
    public List<ResultadoCalculo> calcularPrecoFrete(Carga cargaInfo, List<TransporteTipo> transporteTipos) {
        // Cria uma lista interna para guardar os cálculos que vamos fazer agora.
        List<ResultadoCalculo> resultadoCalculo = new ArrayList<>();

        // Para cada tipo de transporte na lista, fazemos a sequência de cálculos.
        for (TransporteTipo transporteTipo : transporteTipos) {
            // Calcula o peso que será efetivamente cobrado (Peso Volumétrico).
            Double pesoTaxavel = pesoVolumetricoService.calcularPesoTaxavel(cargaInfo.getPeso(), cargaInfo.getDimensao(), transporteTipo);

            // Calcula o frete peso com base no peso taxável.
            Double fretePeso = fretePesoService.calcularFretePeso(pesoTaxavel, cargaInfo.getRota(), transporteTipo);

            // Calcula o seguro (Advalorem) sobre o valor da mercadoria.
            Double advalorem = advaloremService.calcAdvalorem(cargaInfo.getPreco(), cargaInfo.getCargaTipo(), transporteTipo);

            Double precoTotal = fretePeso + advalorem;

            // Consolida os dados no objeto de transferência de resultado.
            resultadoCalculo.add(new ResultadoCalculo(transporteTipo.getTransporteNome(),
                    cargaInfo.getPreco(),
                    fretePeso,
                    precoTotal,
                    cargaInfo.getCargaTipo().name(),
                    advalorem,
                    cargaInfo.getEndereco()));
        }
        // Devolvemos a lista completa para quem chamou o metodh.
        return resultadoCalculo;
    }
}
