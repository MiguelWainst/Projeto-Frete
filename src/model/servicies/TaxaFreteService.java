package model.servicies;

import model.Carga;
import model.entities.*;
import model.entities.enums.TransporteTipo;

import java.util.List;

/**
 * Esta classe é o organizador do sistema de fretes.
 * Ela coordena a execução dos serviços de Peso Volumétrico, Frete Peso
 * e Advalorem para consolidar o custo logístico de cada modal de transporte.
 *
 * @author Miguel Wainstein
 * @version 1.1
 * @since 28/05/2026
 */
public class TaxaFreteService {
    private final FPService fretePesoService;
    private final PVService pesoVolumetricoService;
    private final AdvaloremService advaloremService;

    /**
     * Construtor que inicializa as dependências necessárias para o cálculo.
     * @param fretePesoService Serviço para cálculo do frete baseado no peso/rota.
     * @param pesoVolumetricoService Serviço para definição do peso taxável (real e cubado).
     * @param advaloremService Serviço para cálculo do seguro da carga.
     */
    public TaxaFreteService(FPService fretePesoService, PVService pesoVolumetricoService, AdvaloremService advaloremService) {
        this.fretePesoService = fretePesoService;
        this.pesoVolumetricoService = pesoVolumetricoService;
        this.advaloremService = advaloremService;
    }

    /**
     * Realiza o processamento em lote de todos os modais de transporte informados.
     * <p>
     * O metodh percorre a lista de modais, executa a cadeia de cálculos e popula
     * a lista de resultados com objetos {@link ResultadoCalculo} formatados.
     *
     * @param cargaInfo Objeto contendo os dados brutos da mercadoria e rota.
     * @param transporteTipos Lista de modais (Aéreo, Marítimo, etc.) a serem avaliados.
     * @param resultadoCalculo Lista de destino onde os resultados finais serão armazenados.
     */
    public void calcularPrecoFrete(Carga cargaInfo, List<TransporteTipo> transporteTipos, List<ResultadoCalculo> resultadoCalculo) {

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
    }
}
