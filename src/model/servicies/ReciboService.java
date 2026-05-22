package model.servicies;

import model.entities.ResultadoCalculo;

import java.util.List;

public class ReciboService {
    public void mostrarOpcoes(List<ResultadoCalculo> resultado) {
        int i=1;
        for(ResultadoCalculo x : resultado) {
            System.out.println("Transporte [" + i + "]: "
                    + x.getTransporte()
                    + " | Preço: "
                    + x.getPrecoTotal());
            i++;
        }
    }

    public void imprimirNaTela(List<ResultadoCalculo> resultado, int escolha) {
        System.out.println("   ============== RECIBO ==============");
        ResultadoCalculo x = resultado.get(escolha - 1);

        System.out.printf("Preço da mercadoria da mercadoria R$          %.2f%n", x.getPreco());
        System.out.printf("     + Imposto R$                             %.2f%n", x.getImposto());
        System.out.println("Tipo do transporte:                           " + x.getTransporte());
        System.out.printf("     + Taxa taxa de frete R$                  %.2f%n", x.getTaxa());
        System.out.println("     + Tipo da carga:                         " + x.getTipoDeCarga());
        System.out.printf("           + Adicional de tipo de carga R$    %.2f%n", x.getAdicionalCarga());
        System.out.println("Endereço de entrega:                          " + x.getEndereco());
        System.out.println("Duração:                                      " + x.getDuracao());
        System.out.printf("PREÇO TOTAL A PAGAR: R$:%.2f%n", x.getPrecoTotal());
    }
}
