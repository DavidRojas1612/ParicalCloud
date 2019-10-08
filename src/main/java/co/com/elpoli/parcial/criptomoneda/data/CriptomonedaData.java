package co.com.elpoli.parcial.criptomoneda.data;

import co.com.elpoli.parcial.criptomoneda.model.Criptomoneda;

import java.util.ArrayList;
import java.util.List;

public class CriptomonedaData {
    private static List<Criptomoneda> listado;

    static {
        listado = new ArrayList<Criptomoneda>() {
            {
                add(new Criptomoneda(10L, 25, "USD"));
                add(new Criptomoneda(10L, 30, "EUR"));
                add(new Criptomoneda(10L, 40, "LIB"));
            }
        };
    }


    public static List<Criptomoneda> getListado() {
        return listado;
    }

    public static void setListado(List<Criptomoneda> listado) {
        CriptomonedaData.listado = listado;
    }

}
