package co.com.elpoli.parcial.criptomoneda.dao.impl;

import co.com.elpoli.parcial.criptomoneda.dao.ICriptomonedaDao;
import co.com.elpoli.parcial.criptomoneda.data.CriptomonedaData;
import co.com.elpoli.parcial.criptomoneda.model.Criptomoneda;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class CriptomonedaDaoImplList implements ICriptomonedaDao {


    @Override
    public List<Criptomoneda> getCriptomonedas() {
        return CriptomonedaData.getListado();
    }

    @Override
    public Criptomoneda getCriptomoneda(Long id) {
        List<Criptomoneda> listado = CriptomonedaData.getListado();
        return listado.get(listado.indexOf(new Criptomoneda(id)));
    }

    @Override
    public Criptomoneda addCriptomoneda(Criptomoneda criptomoneda) {
        List<Criptomoneda> listado = CriptomonedaData.getListado();
        listado.add(criptomoneda);
        CriptomonedaData.setListado(listado);
        return criptomoneda;
    }

    @Override
    public Boolean deleteCriptomoneda(Long id, String simbolo) {
        List<Criptomoneda> listado = CriptomonedaData.getListado();
        listado.remove(new Criptomoneda(id, simbolo));
        CriptomonedaData.setListado(listado);
        return true;
    }
}
