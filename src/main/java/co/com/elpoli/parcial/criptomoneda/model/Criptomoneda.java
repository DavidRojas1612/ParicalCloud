package co.com.elpoli.parcial.criptomoneda.model;

import java.util.Objects;

public class Criptomoneda {
    private Long idMoneda;
    private Number valor;
    private String simbolo;

    public Criptomoneda() {
    }

    public Criptomoneda(Long idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Criptomoneda(Long idMoneda, String simbolo) {
        this.idMoneda = idMoneda;
        this.simbolo = simbolo;
    }

    public Criptomoneda(Long idMoneda, Number valor, String simbolo) {
        this.idMoneda = idMoneda;
        this.valor = valor;
        this.simbolo = simbolo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criptomoneda that = (Criptomoneda) o;
        return idMoneda.equals(that.idMoneda) &&
                simbolo.equals(that.simbolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMoneda, simbolo);
    }

    public Long getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Long idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Number getValor() {
        return valor;
    }

    public void setValor(Number valor) {
        this.valor = valor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
