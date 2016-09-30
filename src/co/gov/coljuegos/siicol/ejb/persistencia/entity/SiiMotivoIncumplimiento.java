package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MOTIVO_INCUMPLIMIENTO")
public class SiiMotivoIncumplimiento implements Serializable {
    private static final long serialVersionUID = 4150784710501818313L;
    private Long minCodigo;
    private String minNombre;
    private String minTipo;
    private List<SiiMotivoIncuInfSuperv> siiMotivoIncuInfSupervList;
    private SiiTipoMulta siiTipoMulta;
    private List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmList;
    private String minConcepto;

    public SiiMotivoIncumplimiento() {
    }

    public SiiMotivoIncumplimiento(Long minCodigo, String minNombre) {
        this.minCodigo = minCodigo;
        this.minNombre = minNombre;
    }

    @Id
    @Column(name = "MIN_CODIGO", nullable = false)
    public Long getMinCodigo() {
        return minCodigo;
    }

    public void setMinCodigo(Long minCodigo) {
        this.minCodigo = minCodigo;
    }

    @Column(name = "MIN_NOMBRE", nullable = false, length = 30)
    public String getMinNombre() {
        return minNombre;
    }

    public void setMinNombre(String minNombre) {
        this.minNombre = minNombre;
    }

    @OneToMany(mappedBy = "siiMotivoIncumplimiento")
    public List<SiiMotivoIncuInfSuperv> getSiiMotivoIncuInfSupervList() {
        return siiMotivoIncuInfSupervList;
    }

    public void setSiiMotivoIncuInfSupervList(List<SiiMotivoIncuInfSuperv> siiMotivoIncuInfSupervList) {
        this.siiMotivoIncuInfSupervList = siiMotivoIncuInfSupervList;
    }

    public SiiMotivoIncuInfSuperv addSiiMotivoIncuInfSuperv(SiiMotivoIncuInfSuperv siiMotivoIncuInfSuperv) {
        getSiiMotivoIncuInfSupervList().add(siiMotivoIncuInfSuperv);
        siiMotivoIncuInfSuperv.setSiiMotivoIncumplimiento(this);
        return siiMotivoIncuInfSuperv;
    }

    public SiiMotivoIncuInfSuperv removeSiiMotivoIncuInfSuperv(SiiMotivoIncuInfSuperv siiMotivoIncuInfSuperv) {
        getSiiMotivoIncuInfSupervList().remove(siiMotivoIncuInfSuperv);
        siiMotivoIncuInfSuperv.setSiiMotivoIncumplimiento(null);
        return siiMotivoIncuInfSuperv;
    }

    @Column(name = "MIN_TIPO", length = 1)
    public String getMinTipo() {
        return minTipo;
    }
    
    public void setMinTipo(String minTipo) {
        this.minTipo = minTipo;
    }

    @ManyToOne
    @JoinColumn(name = "TMU_CODIGO")
    public SiiTipoMulta getSiiTipoMulta() {
        return siiTipoMulta;
    }

    public void setSiiTipoMulta(SiiTipoMulta siiTipoMulta) {
        this.siiTipoMulta = siiTipoMulta;
    }

    @OneToMany(mappedBy = "siiMotivoIncumplimiento")
    public List<SiiCargaActuacionesAdm> getSiiCargaActuacionesAdmList() {
        return siiCargaActuacionesAdmList;
    }

    public void setSiiCargaActuacionesAdmList(List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmList) {
        this.siiCargaActuacionesAdmList = siiCargaActuacionesAdmList;
    }

    public SiiCargaActuacionesAdm addSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmList().add(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiMotivoIncumplimiento(this);
        return siiCargaActuacionesAdm;
    }

    public SiiCargaActuacionesAdm removeSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmList().remove(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiMotivoIncumplimiento(null);
        return siiCargaActuacionesAdm;
    }

    @Column(name = "MIN_CONCEPTO", length = 5)
    public String getMinConcepto() {
        return minConcepto;
    }
    
    public void setMinConcepto(String minConcepto) {
        this.minConcepto = minConcepto;
    }

}
