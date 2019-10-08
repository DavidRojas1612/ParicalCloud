package co.com.elpoli.parcial.criptomoneda.services;

import co.com.elpoli.parcial.criptomoneda.model.Criptomoneda;

import java.util.List;

public interface ICriptomonedaServices {
    List<Criptomoneda> getCriptomonedas();
    Criptomoneda getCriptomoneda(Long id);
    Criptomoneda addCriptomoneda(Criptomoneda criptomoneda);
    Criptomoneda getHigherValue();
    Boolean deleteCriptomoneda(Long id, String simbolo);
}
