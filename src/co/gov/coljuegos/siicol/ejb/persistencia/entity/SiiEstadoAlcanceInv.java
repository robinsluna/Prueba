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
@Table(name = "SII_ESTADO_ALCANCE_INV")
public class SiiEstadoAlcanceInv implements Serializable {
    private static final long serialVersionUID = 4172315155917724196L;
    private Long eaiCodigo;
    private String eaiNombre;
    private List<SiiAlcanceInvitacion> siiAlcanceInvitacionList;

    public SiiEstadoAlcanceInv() {
    }

    public SiiEstadoAlcanceInv(Long eaiCodigo, String eaiNombre) {
        this.eaiCodigo = eaiCodigo;
        this.eaiNombre = eaiNombre;
    }

    @Id
    @Column(name = "EAI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTADO_ALCANCE_INV")
    @SequenceGenerator(name = "SEQ_ESTADO_ALCANCE_INV", sequenceName = "SEQ_ESTADO_ALCANCE_INV",allocationSize=1)
    public Long getEaiCodigo() {
        return eaiCodigo;
    }

    public void setEaiCodigo(Long eaiCodigo) {
        this.eaiCodigo = eaiCodigo;
    }

    @Column(name = "EAI_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEaiNombre() {
        return eaiNombre;
    }

    public void setEaiNombre(String eaiNombre) {
        this.eaiNombre = eaiNombre;
    }

    @OneToMany(mappedBy = "siiEstadoAlcanceInv")
    public List<SiiAlcanceInvitacion> getSiiAlcanceInvitacionList() {
        return siiAlcanceInvitacionList;
    }

    public void setSiiAlcanceInvitacionList(List<SiiAlcanceInvitacion> siiAlcanceInvitacionList) {
        this.siiAlcanceInvitacionList = siiAlcanceInvitacionList;
    }

    public SiiAlcanceInvitacion addSiiAlcanceInvitacion(SiiAlcanceInvitacion siiAlcanceInvitacion) {
        getSiiAlcanceInvitacionList().add(siiAlcanceInvitacion);
        siiAlcanceInvitacion.setSiiEstadoAlcanceInv(this);
        return siiAlcanceInvitacion;
    }

    public SiiAlcanceInvitacion removeSiiAlcanceInvitacion(SiiAlcanceInvitacion siiAlcanceInvitacion) {
        getSiiAlcanceInvitacionList().remove(siiAlcanceInvitacion);
        siiAlcanceInvitacion.setSiiEstadoAlcanceInv(null);
        return siiAlcanceInvitacion;
    }
}
