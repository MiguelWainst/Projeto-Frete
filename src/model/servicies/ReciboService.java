package model.servicies;

import model.entities.ResultadoCalculo;
import model.entities.Transporte;
import model.entities.enums.CargaTipo;
import model.interfaces.IImposto;

import java.util.ArrayList;
import java.util.List;

public class ReciboService {
    public void mostrarOpcoes(List<ResultadoCalculo> resultado) {
        int i=1;
        for(ResultadoCalculo x : resultado) {
            System.out.println("Transporte [" + i + "]: "
                    + x.getTransporte()
                    + " | Preço: "
                    + x.getPreco());
            i++;
        }
    }

    public void imprimirNaTela(TaxaFreteService taxaFreteService) {
        System.out.println("===== RECIBO ====");
        System.out.println("Preço da mercadoria: ");
    }
}
