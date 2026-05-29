package model.interfaces;

import model.entities.Carga;
import model.entities.ResultadoCalculo;
import model.entities.enums.TransporteTipo;

import java.util.List;

public interface ITaxaFreteService {
    List<ResultadoCalculo> calcularPrecoFrete(Carga cargaInfo, List<TransporteTipo> transporteTipos);
}
