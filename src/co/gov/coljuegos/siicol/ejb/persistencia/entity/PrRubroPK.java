package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

public class PrRubroPK implements Serializable {
    public Long interno;
    public Integer vigencia;

    public PrRubroPK() {
    }

    public PrRubroPK(Long interno, Integer vigencia) {
        this.interno = interno;
        this.vigencia = vigencia;
    }

    public boolean equals(Object other) {
        if (other instanceof PrRubroPK) {
            final PrRubroPK otherPrRubroPK = (PrRubroPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Long getInterno() {
        return interno;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }
}
