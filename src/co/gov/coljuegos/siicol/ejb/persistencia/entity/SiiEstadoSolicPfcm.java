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
@Table(name = "SII_ESTADO_SOLIC_PFCM")
public class SiiEstadoSolicPfcm implements Serializable {
    private static final long serialVersionUID = 3716000418940940102L;
    private Long espCodigo;
    private String espNombre;
    private List<SiiSolicitudPfcMens> siiSolicitudPfcMensList1;

    public SiiEstadoSolicPfcm() {
    }

    public SiiEstadoSolicPfcm(Long espCodigo, String espNombre) {
        this.espCodigo = espCodigo;
        this.espNombre = espNombre;
    }

    @Id
    @Column(name = "ESP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTADO_SOLIC_PFCM_COD")
    @SequenceGenerator(name = "SEQ_ESTADO_SOLIC_PFCM_COD", sequenceName = "SEQ_ESTADO_SOLIC_PFCM_COD",allocationSize=1)
    public Long getEspCodigo() {
        return espCodigo;
    }

    public void setEspCodigo(Long espCodigo) {
        this.espCodigo = espCodigo;
    }

    @Column(name = "ESP_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEspNombre() {
        return espNombre;
    }

    public void setEspNombre(String espNombre) {
        this.espNombre = espNombre;
    }

    @OneToMany(mappedBy = "siiEstadoSolicPfcm")
    public List<SiiSolicitudPfcMens> getSiiSolicitudPfcMensList1() {
        return siiSolicitudPfcMensList1;
    }

    public void setSiiSolicitudPfcMensList1(List<SiiSolicitudPfcMens> siiSolicitudPfcMensList1) {
        this.siiSolicitudPfcMensList1 = siiSolicitudPfcMensList1;
    }

    public SiiSolicitudPfcMens addSiiSolicitudPfcMens(SiiSolicitudPfcMens siiSolicitudPfcMens) {
        getSiiSolicitudPfcMensList1().add(siiSolicitudPfcMens);
        siiSolicitudPfcMens.setSiiEstadoSolicPfcm(this);
        return siiSolicitudPfcMens;
    }

    public SiiSolicitudPfcMens removeSiiSolicitudPfcMens(SiiSolicitudPfcMens siiSolicitudPfcMens) {
        getSiiSolicitudPfcMensList1().remove(siiSolicitudPfcMens);
        siiSolicitudPfcMens.setSiiEstadoSolicPfcm(null);
        return siiSolicitudPfcMens;
    }
}
