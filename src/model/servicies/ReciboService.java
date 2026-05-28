package model.servicies;

import model.entities.ResultadoCalculo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReciboService {
    /*
    Esta classe serviço é responsável pelo trabalho de impressão
    de informação para o cliente e também de salvar um arquivo
    de cupom fiscal no computador.
     */
    public void mostrarOpcoes(List<ResultadoCalculo> resultado) {
        int i=1;
        for(ResultadoCalculo x : resultado) {
            System.out.println("Transporte [" + i + "]: "
                    + x.getTransporte()
                    + " | Preço: "
                    + String.format("%.2f", x.getPrecoTotal()));
            i++;
        }
    }

    public String gerarRecibo(List<ResultadoCalculo> resultado, int escolha) {
        ResultadoCalculo x = resultado.get(escolha - 1);
        StringBuilder sb = new StringBuilder();

        sb.append("   ============== RECIBO ==============\n");
        sb.append(String.format("Preço da mercadoria R$               %.2f%n", x.getPreco()));
        sb.append("Tipo do transporte:                  ").append(x.getTransporte()).append("\n");
        sb.append(String.format("Taxa de rete R$                      %.2f%n", x.getTaxaFrete()));
        sb.append("     + Tipo da carga:                ").append(x.getTipoDeCarga()).append("\n");
        sb.append(String.format("           + Adicional de carga R$   %.2f%n", x.getAdicionalCarga()));
        sb.append("Endereço de entrega:                 ").append(x.getEndereco()).append("\n");
        sb.append("---------------------------------------\n");
        sb.append(String.format("PREÇO TOTAL A PAGAR: R$              %.2f%n", x.getPrecoTotal()));

        return sb.toString();
    }

    public void gerarCupomFiscal(String cupom) {
        String path = "c:\\temp\\CupomFiscal.txt"; // Caminho que vai ser criado o arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("CupomFiscal:\n\n");
            bw.write(cupom); // Escreve a String fornecida.
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERRO: Não foi possível abrir o arquivo.");
        }
    }
}
