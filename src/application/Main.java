package application;

import model.entities.ResultadoCalculo;
import model.entities.TAereo;
import model.entities.TMaritimo;
import model.entities.TTerrestre;
import model.entities.enums.CargaTipo;
import model.interfaces.IImposto;
import model.interfaces.ITaxaTransporte;
import model.servicies.BrazilImpostoService;
import model.servicies.ReciboService;
import model.servicies.TaxaFreteService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Double preco = 0.0;
        while(true) {
            try {
                System.out.print("Informe o preço da mercadoria R$: ");
                preco = sc.nextDouble();
                if(preco < 0 || preco > 1000000000) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Formato inválido para preço.\n...");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: O preço deve estar entre 0 e 1.000.000.000.\n...");
            }
        }

        Double peso = 0.0;
        while (true) {
            try {
                System.out.print("Informe o peso da mercadoria (KG): ");
                peso = sc.nextDouble();
                if(peso < 0 || peso > 100000) {
                    throw new IllegalArgumentException();
                }
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Formato inválido para peso.\n...");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: O peso deve estar entre 0.01 Kg e 100.000 Kg.\n...");
            }
        }

        System.out.print("Informe o endereço de entrega (Rua, Número, Cep): ");
        String endereco = sc.nextLine();

        CargaTipo cargaTipo = null;
        while (true) {
            try {
                System.out.print("Informe o tipo da mercadoria (inflamavel, fragil ou comum): ");
                cargaTipo = CargaTipo.valueOf(sc.next().toUpperCase());
                //if (cargaTipo)
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: Tipo de mercadoria não existe.\n...");
            }
        }

        List<ResultadoCalculo> resultCalc = new ArrayList<>(); // Criando lista para passar de arg.
        ReciboService reciboService = new ReciboService();

        // Lista de interfaces e tudo o que estende ela.
        List<? extends ITaxaTransporte> listaTaxaTransporte = Arrays.asList(new TAereo(), new TMaritimo(), new TTerrestre());

        // Chamando o serviço TaxaFrete para calcular tudo e colocar dentro da lista criada acima.
        new TaxaFreteService().calcularPrecoFrete(preco, peso, cargaTipo, new BrazilImpostoService(),
                endereco, resultCalc, listaTaxaTransporte);
        reciboService.mostrarOpcoes(resultCalc); // Chamando o recibo service para printar as opções de compra.

        int escolha = 0;
        while (true) {
            try {
                System.out.print("\nQual sua escolha: "); // Pede qual escolha será feita.
                escolha = sc.nextInt();
                if (escolha <=0 || escolha > resultCalc.size()) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Formato inválido\n...");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: Escolha um número dentro do disponível.\n...");
                sc.nextLine();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        // Baseado na escolha, o ReciboService manda uma String com o cupom.
        String reciboFinal = reciboService.gerarRecibo(resultCalc, escolha);
        System.out.println(reciboFinal); // Imprimie o recibo/cupom fiscal final.

        /* Lógica para imprimir o cupom fiscal —criar um arquivo .txt na pasta
        temp—. Depende da resposta do usuário. */
        char resp = 'n';
        while (true) {
            try {
                System.out.println("Deseja gerar o cupom fiscal na pasta 'temp'? (s/n)");
                resp = sc.next().charAt(0);
                if (resp != 's' && resp != 'n')
                    throw new IllegalArgumentException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Input é inválido.\n...");
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: Reposta deve ser s/n (sim/não)\n...");
            }
        }
        if (resp == 's')
            // Chama a função responsável por criar o .txt com o cupom fiscal
            reciboService.gerarCupomFiscal(reciboFinal);

        sc.close();
    }
}