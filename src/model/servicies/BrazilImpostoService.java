package model.servicies;

import model.interfaces.IImposto;

public class BrazilImpostoService implements IImposto {
    /*
    Esse serviço é responsável por:
    Calcular o imposto do produto em cima das
    regras de importação do Brasil.

    Usado na classe TaxaFreteService

    Se o preço do produto é igual o menor que 50
    reais, então o imposto é de 20%. Se for acima
    desse mesmo valor, então o imposto sobe para 60%,
    porém com um abate de 20 reais do valor total.
     */
    @Override
    public Double regraImposto(Double preco) {
        if (preco <= 50.00) {
            return preco * 0.2;
        } else {
            return preco * 0.6 - 20;
        }
    }
}
