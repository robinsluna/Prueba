package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_MODIFIC_RP")
public class SiiEstadoModificRp implements Serializable {
    private static final long serialVersionUID = -3695995193045420446L;
    private Long emrCodigo;
    private String emrNombre;
    private List<SiiModificacionRp> siiModificacionRpList;

    public SiiEstadoModificRp() {
    }

    public SiiEstadoModificRp(Long emrCodigo, String emrNombre) {
        this.emrCodigo = emrCodigo;
        this.emrNombre = emrNombre;
    }

    @Id
    @Column(name = "EMR_CODIGO", nullable = false)
    public Long getEmrCodigo() {
        return emrCodigo;
    }

    public void setEmrCodigo(Long emrCodigo) {
        this.emrCodigo = emrCodigo;
    }

    @Column(name = "EMR_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEmrNombre() {
        return emrNombre;
    }

    public void setEmrNombre(String emrNombre) {
        this.emrNombre = emrNombre;
    }

    @OneToMany(mappedBy = "siiEstadoModificRp")
    public List<SiiModificacionRp> getSiiModificacionRpList() {
        return siiModificacionRpList;
    }

    public void setSiiModificacionRpList(List<SiiModificacionRp> siiModificacionRpList) {
        this.siiModificacionRpList = siiModificacionRpList;
    }

    public SiiModificacionRp addSiiModificacionRp(SiiModificacionRp siiModificacionRp) {
        getSiiModificacionRpList().add(siiModificacionRp);
        siiModificacionRp.setSiiEstadoModificRp(this);
        return siiModificacionRp;
    }

    public SiiModificacionRp removeSiiModificacionRp(SiiModificacionRp siiModificacionRp) {
        getSiiModificacionRpList().remove(siiModificacionRp);
        siiModificacionRp.setSiiEstadoModificRp(null);
        return siiModificacionRp;
    }
}
