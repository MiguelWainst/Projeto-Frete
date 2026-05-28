package model.servicies;

import model.entities.*;
import model.entities.enums.CargaTipo;
import model.entities.enums.Rota;
import model.entities.enums.TransporteTipo;

import java.util.List;

public class TaxaFreteService {

    public void calcularPrecoFrete(Double preco, Double peso, String endereco, CargaTipo cargaTipo, Double comp, Double larg, Double alt,
                                   FPService FP, AdvaloremService adv, PVService PV,
                                   List<TransporteTipo> transporteTipos, List<ResultadoCalculo> resultadoCalculo, Rota rota) {

        for (TransporteTipo transporteTipo : transporteTipos) {
            Double pesoVolumetrico = Math.max(peso, PV.pVCalculo(comp,larg, alt, transporteTipo));
            Double fretePeso = FP.fPCalculo(pesoVolumetrico, rota, transporteTipo);
            Double advalorem = adv.calcAdvalorem(preco, cargaTipo);
            Double precoTotal = fretePeso + advalorem;
            resultadoCalculo.add(new ResultadoCalculo(transporteTipo.getTransporteNome(), preco, fretePeso, precoTotal, cargaTipo.name(), advalorem, endereco));
        }

    }
}
