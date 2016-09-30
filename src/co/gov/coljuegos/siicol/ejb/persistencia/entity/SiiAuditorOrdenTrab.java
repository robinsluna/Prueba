package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_AUDITOR_ORDEN_TRAB")
public class SiiAuditorOrdenTrab implements Serializable {
    private static final long serialVersionUID = 4436358845532323732L;
    private String aotActivo;
    private Long aotCodigo;
    private SiiSustanciadorAuditor siiSustanciadorAuditor;
    private SiiOrdenTrabajoVisita siiOrdenTrabajoVisita;
    private List<SiiInformeVerificCampo> siiInformeVerificCampoList;

    public SiiAuditorOrdenTrab() {
    }

    public SiiAuditorOrdenTrab(String aotActivo, Long aotCodigo, SiiOrdenTrabajoVisita siiOrdenTrabajoVisita, SiiSustanciadorAuditor siiSustanciadorAuditor) {
        this.aotActivo = aotActivo;
        this.aotCodigo = aotCodigo;
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
        this.siiSustanciadorAuditor = siiSustanciadorAuditor;
    }

    @Column(name = "AOT_ACTIVO", nullable = false, length = 1)
    public String getAotActivo() {
        return aotActivo;
    }

    public void setAotActivo(String aotActivo) {
        this.aotActivo = aotActivo;
    }

    @Id
    @Column(name = "AOT_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AUDITOR_ORD_TRAB_COD")
    @SequenceGenerator(name = "SEQ_AUDITOR_ORD_TRAB_COD", sequenceName = "SEQ_AUDITOR_ORD_TRAB_COD",allocationSize=1)
    public Long getAotCodigo() {
        return aotCodigo;
    }

    public void setAotCodigo(Long aotCodigo) {
        this.aotCodigo = aotCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "SUA_CODIGO")
    public SiiSustanciadorAuditor getSiiSustanciadorAuditor() {
        return siiSustanciadorAuditor;
    }

    public void setSiiSustanciadorAuditor(SiiSustanciadorAuditor siiSustanciadorAuditor) {
        this.siiSustanciadorAuditor = siiSustanciadorAuditor;
    }

    @ManyToOne
    @JoinColumn(name = "OTV_CODIGO")
    public SiiOrdenTrabajoVisita getSiiOrdenTrabajoVisita() {
        return siiOrdenTrabajoVisita;
    }

    public void setSiiOrdenTrabajoVisita(SiiOrdenTrabajoVisita siiOrdenTrabajoVisita) {
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
    }

    @OneToMany(mappedBy = "siiAuditorOrdenTrab")
    public List<SiiInformeVerificCampo> getSiiInformeVerificCampoList() {
        return siiInformeVerificCampoList;
    }

    public void setSiiInformeVerificCampoList(List<SiiInformeVerificCampo> siiInformeVerificCampoList) {
        this.siiInformeVerificCampoList = siiInformeVerificCampoList;
    }

    public SiiInformeVerificCampo addSiiInformeVerificCampo(SiiInformeVerificCampo siiInformeVerificCampo) {
        getSiiInformeVerificCampoList().add(siiInformeVerificCampo);
        siiInformeVerificCampo.setSiiAuditorOrdenTrab(this);
        return siiInformeVerificCampo;
    }

    public SiiInformeVerificCampo removeSiiInformeVerificCampo(SiiInformeVerificCampo siiInformeVerificCampo) {
        getSiiInformeVerificCampoList().remove(siiInformeVerificCampo);
        siiInformeVerificCampo.setSiiAuditorOrdenTrab(null);
        return siiInformeVerificCampo;
    }
}
