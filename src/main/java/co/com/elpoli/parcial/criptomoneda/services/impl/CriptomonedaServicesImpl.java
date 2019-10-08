package co.com.elpoli.parcial.criptomoneda.services.impl;

import co.com.elpoli.parcial.criptomoneda.dao.ICriptomonedaDao;
import co.com.elpoli.parcial.criptomoneda.model.Criptomoneda;
import co.com.elpoli.parcial.criptomoneda.services.ICriptomonedaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CriptomonedaServicesImpl implements ICriptomonedaServices {


    @Autowired
    private ICriptomonedaDao criptomonedaDao;

    @Override
    public List<Criptomoneda> getCriptomonedas() {
        return criptomonedaDao.getCriptomonedas();
    }

    @Override
    public Criptomoneda getCriptomoneda(Long id) {
        if(!getCriptomonedas().contains(new Criptomoneda(id))){
            return criptomonedaDao.getCriptomoneda(id);
        }
        return null;
    }

    @Override
    public Criptomoneda addCriptomoneda(Criptomoneda criptomoneda) {
        Long idMoneda = criptomoneda.getIdMoneda();
        String simbolo = criptomoneda.getSimbolo();
        Number valor = criptomoneda.getValor();

        List<String> divisas = new ArrayList<String>() {
            {
                add("USD");
                add("EUR");
                add("LIB");
            }
        };

        Boolean isRanged = valor.intValue() > 1 && valor.intValue() < 10000;

        Boolean noexiste = !getCriptomonedas().contains(new Criptomoneda(idMoneda,simbolo));

        Boolean isDivisa = divisas.contains(simbolo);

        if(noexiste && isRanged && isDivisa){
            return criptomonedaDao.addCriptomoneda(criptomoneda);
        }
        return null;
    }

    @Override
    public Boolean deleteCriptomoneda(Long id, String simbolo) {
        if(getCriptomonedas().contains((new Criptomoneda(id, simbolo)))){
            return criptomonedaDao.deleteCriptomoneda(id, simbolo);
        }
        return false;
    }

    @Override
    public Criptomoneda getHigherValue() {
        int inicialValue=1;
        Iterator iterator= criptomonedaDao.getCriptomonedas().iterator();
        while(iterator.hasNext()){
            Criptomoneda cript = (Criptomoneda) iterator.next();
            if(cript.getValor().intValue() > inicialValue){
                inicialValue = cript.getValor().intValue();
            }
        }

        Criptomoneda higherCriptomoneda = null;
        Iterator iterator2= criptomonedaDao.getCriptomonedas().iterator();
        while(iterator2.hasNext()){
            Criptomoneda cript= (Criptomoneda) iterator2.next();
            if(cript.getValor().intValue() == inicialValue){
                higherCriptomoneda=cript;
            }
        }
        return higherCriptomoneda;
    }

}
