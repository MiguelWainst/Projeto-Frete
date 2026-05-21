package application;

import model.entities.enums.CargaTipo;
import model.interfaces.IImposto;
import model.servicies.BrazilImpostoService;
import model.servicies.TaxaFreteService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o preço da mercadoria: ");
        Double preco = sc.nextDouble();
        System.out.print("Informe o peso da mercadoria: ");
        Double peso = sc.nextDouble();
        System.out.print("Informe o tipo da mercadoria (inflamavel, fragil ou comum): ");
        CargaTipo cargaTipo = CargaTipo.valueOf(sc.next().toUpperCase());

        TaxaFreteService taxaFreteService = new TaxaFreteService();
        IImposto imposto = new BrazilImpostoService();
        taxaFreteService.calcularPrecoFrete(preco, peso, cargaTipo, imposto);
        taxaFreteService.readPrecosFinais();

        sc.close();
    }
}