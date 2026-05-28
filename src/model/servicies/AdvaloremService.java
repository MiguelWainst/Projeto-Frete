package model.servicies;

import model.entities.enums.CargaTipo;

import java.util.List;

public class AdvaloremService {
    public Double calcAdvalorem(Double preco, CargaTipo cargaTipo) {
        Double advalorem;
        return advalorem = preco * cargaTipo.getMaritimo();
    }
}
