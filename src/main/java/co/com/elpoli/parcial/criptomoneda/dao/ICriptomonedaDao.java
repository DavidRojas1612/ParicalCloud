package co.com.elpoli.parcial.criptomoneda.dao;

import co.com.elpoli.parcial.criptomoneda.model.Criptomoneda;

import java.util.List;

public interface ICriptomonedaDao {
    List<Criptomoneda> getCriptomonedas();
    Criptomoneda getCriptomoneda(Long id);
    Criptomoneda addCriptomoneda(Criptomoneda criptomoneda);
    Boolean deleteCriptomoneda(Long id, String simbolo);
}
