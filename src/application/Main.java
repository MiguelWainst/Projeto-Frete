package application;

import model.entities.Carga;
import model.entities.Dimensao;
import model.entities.ResultadoCalculo;
import model.entities.enums.CargaTipo;
import model.entities.enums.Rota;
import model.entities.enums.TransporteTipo;
import model.servicies.*;
import util.ConsoleUI;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        /* ==Entrada de dados ==*/
        // Coleta informações básicas da carga usando métodos que já tratam erros de digitação.
        Double preco = ConsoleUI.lerDouble(sc, "Informe o preço da mercadoria R$: ",
                "ERRO: O preço deve estar entre %.2f e %.2f.\n...%n", 0, 1000000000);

        Double peso = ConsoleUI.lerDouble(sc, "Informe o peso da mercadoria (KG): ",
                "ERRO: O peso deve estar entre 0.01 Kg e 100.000 Kg.\n...", 0, 100000);

        System.out.print("Informe o endereço de entrega (Rua, Número, Cep): ");
        String endereco = sc.nextLine();

        // Seleciona categorias pré definidas (Enums) para evitar erros de texto.
        CargaTipo cargaTipo = ConsoleUI.lerEnum(sc, CargaTipo.class,
                "Informe o tipo da mercadoria (Inflamavel, Fragil, Visado ou Comum): ",
                "ERRO: Tipo de mercadoria não existe.\n...");

        System.out.println("---------------------------------------");
        System.out.println("Informe as dimensões da mercadoria (Metros): ");

        Double comp = ConsoleUI.lerDouble(sc, "Comprimento: ",
                "ERRO: Medida não pode ser menor que 0 ou maior que 5 metros.\n...", 0.01, 8),

                larg = ConsoleUI.lerDouble(sc, "Largura: ",
                        "ERRO: Medida não pode ser menor que 0 ou maior que 5 metros.\n...", 0.01, 8),

                alt = ConsoleUI.lerDouble(sc, "Altura : ",
                        "ERRO: Medida não pode ser menor que 0 ou maior que 5 metros.\n...", 0.01, 8);

        Rota rota = ConsoleUI.lerEnum(sc, Rota.class, "Informe a rota (SC_SP|SC_RS|SC_AM): ",
                "ERRO: Essa rota não existe.\n...");
        /* ==Fim da entrada de dados== */

        // Classe carga guardando todas as informações do que tange a carga.
        Carga carga = new Carga(preco, peso, endereco, cargaTipo, new Dimensao(comp, larg, alt), rota);

        // Criando uma lista de Enum que contenha os tipos de transporte.
        List<TransporteTipo> transporteTipos = Arrays.asList(TransporteTipo.AEREO, TransporteTipo.TERRESTRE, TransporteTipo.MARITIMO);

        // Passando para o TaxaFrete as informações necessárias para gerar o preço total do frete.
        List<ResultadoCalculo> resultCalc = new TaxaFreteService(new FPService(), new PVService(), new AdvaloremService()).calcularPrecoFrete(carga, transporteTipos);

        // Criando lista para passar de arg.
        ReciboService reciboService = new ReciboService();
        reciboService.mostrarOpcoes(resultCalc); // Chamando o recibo service para printar as opções de compra.

        int escolha = (int) ConsoleUI.lerLista(sc, resultCalc, "\nQual sua escolha: ",
                "ERRO: Escolha um número dentro do disponível.\n...");

        // Baseado na escolha, o ReciboService manda uma String com o cupom.
        String reciboFinal = reciboService.gerarRecibo(resultCalc, escolha);
        System.out.println(reciboFinal); // Imprimie o recibo/cupom fiscal final.

        /* Lógica para imprimir o cupom fiscal —criar um arquivo .txt na pasta
        temp—. Depende da resposta do usuário. */
        char resp = ConsoleUI.lerChar(sc, "Deseja gerar o cupom fiscal na pasta 'temp'? (s/n)",
                "ERRO: Reposta deve ser s/n (sim/não)\n...");

        if (resp == 's')
            // Chama a função responsável por criar o .txt com o cupom fiscal
            reciboService.gerarCupomFiscal(reciboFinal);

        sc.close();
    }
}