package application;

import model.entities.ResultadoCalculo;
import model.entities.enums.CargaTipo;
import model.interfaces.IImposto;
import model.servicies.BrazilImpostoService;
import model.servicies.ReciboService;
import model.servicies.TaxaFreteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o preço da mercadoria R$: ");
        Double preco = sc.nextDouble();
        System.out.print("Informe o peso da mercadoria (KG): ");
        Double peso = sc.nextDouble();
        sc.nextLine();
        System.out.print("Informe o endereço de entrega (Rua, Número, Cep): ");
        String endereco = sc.nextLine();
        System.out.print("Informe o tipo da mercadoria (inflamavel, fragil ou comum): ");
        CargaTipo cargaTipo = CargaTipo.valueOf(sc.next().toUpperCase());

        List<ResultadoCalculo> resultCalc = new ArrayList<>(); // Criando lista para passar de arg.
        ReciboService reciboService = new ReciboService();

        // Chamando o serviço TaxaFrete para calcular tudo e colocar dentro da lista criada acima.
        new TaxaFreteService().calcularPrecoFrete(preco, peso, cargaTipo, new BrazilImpostoService(), endereco, resultCalc);
        reciboService.mostrarOpcoes(resultCalc); // Chamando o recibo service para printar as opções de compra.

        System.out.print("\nQual sua escolha: "); // Pede qual escolha será feita.
        int escolha = sc.nextInt();

        reciboService.imprimirNaTela(resultCalc, escolha); // Baseado na escolha, o ReciboService mostra o cupom fiscal.

        sc.close();
    }
}