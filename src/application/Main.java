package application;

import model.entities.enums.CargaTipo;
import model.interfaces.IImposto;
import model.servicies.BrazilImpostoService;
import model.servicies.ReciboService;
import model.servicies.TaxaFreteService;

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

        TaxaFreteService taxaFreteService = new TaxaFreteService();
        IImposto imposto = new BrazilImpostoService();
        ReciboService reciboService = new ReciboService();

        reciboService.mostrarOpcoes(taxaFreteService.calcularPrecoFrete(preco, peso, cargaTipo, imposto, endereco));

        System.out.print("\nQual sua escolha: ");
        int escolha = sc.nextInt();

        reciboService.imprimirNaTela(taxaFreteService.calcularPrecoFrete(preco, peso, cargaTipo, imposto, endereco), escolha);

        sc.close();
    }
}