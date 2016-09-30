package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_MODIF_CDP")
public class SiiEstadoModifCdp implements Serializable {
    private String emcActivo;
    private Long emcCodigo;
    private String emcDescripcion;
    private String emcNombre;
    private List<SiiModificacionCdp> siiModificacionCdpList;

    public SiiEstadoModifCdp() {
    }

    public SiiEstadoModifCdp(String emcActivo, Long emcCodigo, String emcDescripcion, String emcNombre) {
        this.emcActivo = emcActivo;
        this.emcCodigo = emcCodigo;
        this.emcDescripcion = emcDescripcion;
        this.emcNombre = emcNombre;
    }

    @Column(name = "EMC_ACTIVO", nullable = false, length = 1, insertable=false, updatable = false)
    public String getEmcActivo() {
        return emcActivo;
    }

    public void setEmcActivo(String emcActivo) {
        this.emcActivo = emcActivo;
    }

    @Id
    @Column(name = "EMC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTADO_MODIF_CDP")
    @SequenceGenerator(name = "SEQ_ESTADO_MODIF_CDP", sequenceName = "SEQ_ESTADO_MODIF_CDP",allocationSize=1)
    public Long getEmcCodigo() {
        return emcCodigo;
    }

    public void setEmcCodigo(Long emcCodigo) {
        this.emcCodigo = emcCodigo;
    }

    @Column(name = "EMC_DESCRIPCION", length = 100, insertable=false, updatable = false)
    public String getEmcDescripcion() {
        return emcDescripcion;
    }

    public void setEmcDescripcion(String emcDescripcion) {
        this.emcDescripcion = emcDescripcion;
    }

    @Column(name = "EMC_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEmcNombre() {
        return emcNombre;
    }

    public void setEmcNombre(String emcNombre) {
        this.emcNombre = emcNombre;
    }

    @OneToMany(mappedBy = "siiEstadoModifCdp")
    public List<SiiModificacionCdp> getSiiModificacionCdpList() {
        return siiModificacionCdpList;
    }

    public void setSiiModificacionCdpList(List<SiiModificacionCdp> siiModificacionCdpList) {
        this.siiModificacionCdpList = siiModificacionCdpList;
    }

    public SiiModificacionCdp addSiiModificacionCdp(SiiModificacionCdp siiModificacionCdp) {
        getSiiModificacionCdpList().add(siiModificacionCdp);
        siiModificacionCdp.setSiiEstadoModifCdp(this);
        return siiModificacionCdp;
    }

    public SiiModificacionCdp removeSiiModificacionCdp(SiiModificacionCdp siiModificacionCdp) {
        getSiiModificacionCdpList().remove(siiModificacionCdp);
        siiModificacionCdp.setSiiEstadoModifCdp(null);
        return siiModificacionCdp;
    }
}
