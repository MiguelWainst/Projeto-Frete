package model.servicies;

import model.entities.ResultadoCalculo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Serviço responsável pela interface de saída com o usuário e formalização da venda.
 * <p>
 * Esta classe gerencia a exibição das opções de frete disponíveis, a formatação do
 * recibo detalhado e a exportação do cupom fiscal para arquivo físico.
 *
 * @author Miguel Wainstein
 * @version 1.0
 * @since 28/05/2026
 */
public class ReciboService {
    /**
     * Lista no console as opções de transporte calculadas para que o usuário possa escolher.
     * @param resultado Lista contendo os cálculos de todos os modais disponíveis.
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

    /**
     * Constrói uma representação textual detalhada do fechamento do pedido.
     * @param resultado Lista com as opções calculadas.
     * @param escolha O índice da opção selecionada pelo usuário.
     * @return String formatada contendo o corpo do recibo.
     */
    public String gerarRecibo(List<ResultadoCalculo> resultado, int escolha) {
        ResultadoCalculo selecionado = resultado.get(escolha - 1);
        StringBuilder sb = new StringBuilder();

        sb.append("\n=======================================\n");
        sb.append("           RECIBO DE SERVIÇO           \n");
        sb.append("=======================================\n");
        sb.append(String.format("Valor do Produto:           R$ %10.2f%n", selecionado.getPreco()));
        sb.append(String.format("Modalidade:                 %s%n", selecionado.getTransporte()));
        sb.append(String.format("Tarifa de Frete (Peso):     R$ %10.2f%n", selecionado.getTaxaFrete()));
        sb.append(String.format("Categoria da Carga:         %s%n", selecionado.getTipoDeCarga()));
        sb.append(String.format("Adicional de Seguro (ADV):  R$ %10.2f%n", selecionado.getAdicionalCarga()));
        sb.append(String.format("Destino:                    %s%n", selecionado.getEndereco()));
        sb.append("---------------------------------------\n");
        sb.append(String.format("VALOR TOTAL DO SERVIÇO:     R$ %10.2f%n", selecionado.getPrecoTotal()));
        sb.append("=======================================\n");

        return sb.toString();
    }

    /**
     * Salva o conteúdo do recibo em um arquivo de texto no diretório local.
     * @param cupom Conteúdo textual do recibo finalizado.
     */
    public void gerarCupomFiscal(String cupom) {
        String path = "c:\\temp\\CupomFiscal.txt"; // Caminho que vai ser criado o arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("EXTRATO DE COTAÇÃO DE FRETE\n");
            bw.write("Emitido em: 28/05/2026\n");
            bw.write("---------------------------------------\n");
            bw.write(cupom);
            System.out.println("\n[Sucesso] Cupom fiscal exportado para: " + path);
        } catch (IOException e) {
            System.out.println("\nERRO: Falha ao gerar arquivo físico: " + e.getMessage());
        }
    }
}
