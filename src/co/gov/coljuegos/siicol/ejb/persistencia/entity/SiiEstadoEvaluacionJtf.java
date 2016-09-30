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
@Table(name = "SII_ESTADO_EVALUACION_JTF")
public class SiiEstadoEvaluacionJtf implements Serializable {
    private static final long serialVersionUID = 1283356092811284542L;
    private Long eejCodigo;
    private String eejNombre;
    private List<SiiEvaluacionJurTecFin> siiEvaluacionJurTecFinList;

    public SiiEstadoEvaluacionJtf() {
    }

    public SiiEstadoEvaluacionJtf(Long eejCodigo, String eejNombre) {
        this.eejCodigo = eejCodigo;
        this.eejNombre = eejNombre;
    }

    @Id
    @Column(name = "EEJ_CODIGO", nullable = false)
    public Long getEejCodigo() {
        return eejCodigo;
    }

    public void setEejCodigo(Long eejCodigo) {
        this.eejCodigo = eejCodigo;
    }

    @Column(name = "EEJ_NOMBRE", nullable = false, length = 50, insertable=false, updatable = false)
    public String getEejNombre() {
        return eejNombre;
    }

    public void setEejNombre(String eejNombre) {
        this.eejNombre = eejNombre;
    }

    @OneToMany(mappedBy = "siiEstadoEvaluacionJtf")
    public List<SiiEvaluacionJurTecFin> getSiiEvaluacionJurTecFinList() {
        return siiEvaluacionJurTecFinList;
    }

    public void setSiiEvaluacionJurTecFinList(List<SiiEvaluacionJurTecFin> siiEvaluacionJurTecFinList) {
        this.siiEvaluacionJurTecFinList = siiEvaluacionJurTecFinList;
    }

    public SiiEvaluacionJurTecFin addSiiEvaluacionJurTecFin(SiiEvaluacionJurTecFin siiEvaluacionJurTecFin) {
        getSiiEvaluacionJurTecFinList().add(siiEvaluacionJurTecFin);
        siiEvaluacionJurTecFin.setSiiEstadoEvaluacionJtf(this);
        return siiEvaluacionJurTecFin;
    }

    public SiiEvaluacionJurTecFin removeSiiEvaluacionJurTecFin(SiiEvaluacionJurTecFin siiEvaluacionJurTecFin) {
        getSiiEvaluacionJurTecFinList().remove(siiEvaluacionJurTecFin);
        siiEvaluacionJurTecFin.setSiiEstadoEvaluacionJtf(null);
        return siiEvaluacionJurTecFin;
    }
}
