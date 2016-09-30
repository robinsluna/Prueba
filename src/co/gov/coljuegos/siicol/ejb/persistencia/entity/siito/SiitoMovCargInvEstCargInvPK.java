package co.gov.coljuegos.siicol.ejb.persistencia.entity.siito;

import java.io.Serializable;

public class SiitoMovCargInvEstCargInvPK implements Serializable {
    public Long estCargInvCodigo;
    public Long movCargueInvCodigo;

    public SiitoMovCargInvEstCargInvPK() {
    }

    public SiitoMovCargInvEstCargInvPK(Long estCargInvCodigo, Long movCargueInvCodigo) {
        this.estCargInvCodigo = estCargInvCodigo;
        this.movCargueInvCodigo = movCargueInvCodigo;
    }

    public boolean equals(Object other) {
        if (other instanceof SiitoMovCargInvEstCargInvPK) {
            final SiitoMovCargInvEstCargInvPK otherSiitoMovCargInvEstCargInvPK = (SiitoMovCargInvEstCargInvPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
    
    
    public Long getEstCargInvCodigo() {
        return estCargInvCodigo;
    }

    public void setEstCargInvCodigo(Long estCargInvCodigo) {
        this.estCargInvCodigo = estCargInvCodigo;
    }
    
   
    public Long getMovCargueInvCodigo() {
        return movCargueInvCodigo;
    }

    public void setMovCargueInvCodigo(Long movCargueInvCodigo) {
        this.movCargueInvCodigo = movCargueInvCodigo;
    }
}
