package co.gov.coljuegos.siicol.ejb.persistencia.entity.siito;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SIITO_ESTADO_CARGUE_INVENTARIO")
public class SiitoEstadoCargueInventario implements Serializable {
    private static final long serialVersionUID = -1411206848046051408L;
    
    @Id
    @Column(name = "EST_CARG_INV_CODIGO", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long estCargInvCodigo;

    @Column(name = "EST_CARG_INV_DESC")
    private String estCargInvDesc;
    
    @Column(name = "EST_CARG_INV_ESTADO")
    private boolean estCargInvEstado;
    private List<SiitoMovCargInvEstCargInv> siitoMovCargInvEstCargInvList;

    public SiitoEstadoCargueInventario() {
    }

    public SiitoEstadoCargueInventario(long estCargInvCodigo, String estCargInvDesc, boolean estCargInvEstado) {
        this.estCargInvCodigo = estCargInvCodigo;
        this.estCargInvDesc = estCargInvDesc;
        this.estCargInvEstado = estCargInvEstado;
    }


    public long getEstCargInvCodigo() {
        return estCargInvCodigo;
    }

    public void setEstCargInvCodigo(long estCargInvCodigo) {
        this.estCargInvCodigo = estCargInvCodigo;
    }

    
    public String getEstCargInvDesc() {
        return estCargInvDesc;
    }

    public void setEstCargInvDesc(String estCargInvDesc) {
        this.estCargInvDesc = estCargInvDesc;
    }
    
    public boolean getEstCargInvEstado() {
        return estCargInvEstado;
    }

    public void setEstCargInvEstado(boolean estCargInvEstado) {
        this.estCargInvEstado = estCargInvEstado;
    }
}
