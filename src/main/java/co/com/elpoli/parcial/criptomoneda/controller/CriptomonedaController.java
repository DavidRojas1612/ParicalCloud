package co.com.elpoli.parcial.criptomoneda.controller;


import co.com.elpoli.parcial.criptomoneda.model.Criptomoneda;
import co.com.elpoli.parcial.criptomoneda.services.ICriptomonedaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriptomonedaController {

    @Autowired
    private ICriptomonedaServices criptomonedaServices;

    @GetMapping("/criptomonedas")
    public List<Criptomoneda> getCriptomonedas(){
        return  criptomonedaServices.getCriptomonedas();
    }

    @GetMapping("/criptomonedas/{id}")
    public Criptomoneda getCriptomoneda (@PathVariable Long id){
        return criptomonedaServices.getCriptomoneda(id);
    }


    @GetMapping("/criptomonedas/higherDivisa")
    public Criptomoneda getHigherValue (){
        return criptomonedaServices.getHigherValue();
    }

    @PostMapping("/criptomonedas")
    public  Criptomoneda addCriptomoneda (@RequestBody Criptomoneda criptomoneda) {
        return criptomonedaServices.addCriptomoneda(criptomoneda);
    }

    @DeleteMapping("/criptomoneda/{id}/{simbolo}")
    public Boolean deleteCriptomoneda ( @PathVariable Long id, @PathVariable String simbolo ){
        return criptomonedaServices.deleteCriptomoneda(id, simbolo);
    }


}
