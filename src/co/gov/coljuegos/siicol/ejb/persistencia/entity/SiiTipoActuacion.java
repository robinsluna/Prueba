package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_ACTUACION")
public class SiiTipoActuacion implements Serializable {
    private static final long serialVersionUID = 5532282414086065873L;
    private Long tacCodigo;
    private String tacNombre;
    private List<SiiFiscalizadorSustanc> siiFiscalizadorSustancList;
    private List<SiiInformeSupervision> siiInformeSupervisionList;
    private List<SiiSustanciadorAuditor> siiSustanciadorAuditorList;

    public SiiTipoActuacion() {
    }

    public SiiTipoActuacion(Long tacCodigo, String tacNombre) {
        this.tacCodigo = tacCodigo;
        this.tacNombre = tacNombre;
    }

    @Id
    @Column(name = "TAC_CODIGO", nullable = false)
    public Long getTacCodigo() {
        return tacCodigo;
    }

    public void setTacCodigo(Long tacCodigo) {
        this.tacCodigo = tacCodigo;
    }

    @Column(name = "TAC_NOMBRE", nullable = false, length = 30)
    public String getTacNombre() {
        return tacNombre;
    }

    public void setTacNombre(String tacNombre) {
        this.tacNombre = tacNombre;
    }

    @OneToMany(mappedBy = "siiTipoActuacion")
    public List<SiiFiscalizadorSustanc> getSiiFiscalizadorSustancList() {
        return siiFiscalizadorSustancList;
    }

    public void setSiiFiscalizadorSustancList(List<SiiFiscalizadorSustanc> siiFiscalizadorSustancList) {
        this.siiFiscalizadorSustancList = siiFiscalizadorSustancList;
    }

    public SiiFiscalizadorSustanc addSiiFiscalizadorSustanc(SiiFiscalizadorSustanc siiFiscalizadorSustanc) {
        getSiiFiscalizadorSustancList().add(siiFiscalizadorSustanc);
        siiFiscalizadorSustanc.setSiiTipoActuacion(this);
        return siiFiscalizadorSustanc;
    }

    public SiiFiscalizadorSustanc removeSiiFiscalizadorSustanc(SiiFiscalizadorSustanc siiFiscalizadorSustanc) {
        getSiiFiscalizadorSustancList().remove(siiFiscalizadorSustanc);
        siiFiscalizadorSustanc.setSiiTipoActuacion(null);
        return siiFiscalizadorSustanc;
    }
    
    @OneToMany(mappedBy = "siiTipoActuacion")
    public List<SiiInformeSupervision> getSiiInformeSupervisionList() {
        return siiInformeSupervisionList;
    }

    public void setSiiInformeSupervisionList(List<SiiInformeSupervision> siiInformeSupervisionList) {
        this.siiInformeSupervisionList = siiInformeSupervisionList;
    }

    public SiiInformeSupervision addSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision) {
        getSiiInformeSupervisionList().add(siiInformeSupervision);
        siiInformeSupervision.setSiiTipoActuacion(this);
        return siiInformeSupervision;
    }

    public SiiInformeSupervision removeSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision) {
        getSiiInformeSupervisionList().remove(siiInformeSupervision);
        siiInformeSupervision.setSiiTipoActuacion(null);
        return siiInformeSupervision;
    }

    @OneToMany(mappedBy = "siiTipoActuacion")
    public List<SiiSustanciadorAuditor> getSiiSustanciadorAuditorList() {
        return siiSustanciadorAuditorList;
    }

    public void setSiiSustanciadorAuditorList(List<SiiSustanciadorAuditor> siiSustanciadorAuditorList) {
        this.siiSustanciadorAuditorList = siiSustanciadorAuditorList;
    }

    public SiiSustanciadorAuditor addSiiSustanciadorAuditor(SiiSustanciadorAuditor siiSustanciadorAuditor) {
        getSiiSustanciadorAuditorList().add(siiSustanciadorAuditor);
        siiSustanciadorAuditor.setSiiTipoActuacion(this);
        return siiSustanciadorAuditor;
    }

    public SiiSustanciadorAuditor removeSiiSustanciadorAuditor(SiiSustanciadorAuditor siiSustanciadorAuditor) {
        getSiiSustanciadorAuditorList().remove(siiSustanciadorAuditor);
        siiSustanciadorAuditor.setSiiTipoActuacion(null);
        return siiSustanciadorAuditor;
    }

}
