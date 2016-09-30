package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_INFORME_VERIFIC_CAMPO")
public class SiiInformeVerificCampo implements Serializable {
    private static final long serialVersionUID = -4220860424008039477L;
    private Long ivcCodigo;
    private Date ivcFecha;
    private List<SiiMunicOrdTraInfVerif> siiMunicOrdTraInfVerifList;
    private List<SiiCuadranteOrdTraInfVer> siiCuadranteOrdTraInfVerList;
    private SiiOrdenTrabajoVisita siiOrdenTrabajoVisita;
    private List<SiiDenuncOrdTraInfVer> siiDenuncOrdTraInfVerList;
    private SiiAuditorOrdenTrab siiAuditorOrdenTrab;
    private List<SiiBarrioOrdenInfVer> siiBarrioOrdenInfVerList;

    public SiiInformeVerificCampo() {
    }

    public SiiInformeVerificCampo(SiiAuditorOrdenTrab siiAuditorOrdenTrab, Long ivcCodigo, Date ivcFecha,
                                  SiiOrdenTrabajoVisita siiOrdenTrabajoVisita) {
        this.siiAuditorOrdenTrab = siiAuditorOrdenTrab;
        this.ivcCodigo = ivcCodigo;
        this.ivcFecha = ivcFecha;
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
    }


    @Id
    @Column(name = "IVC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INFOR_VERIFIC_CAMPO_COD")
    @SequenceGenerator(name = "SEQ_INFOR_VERIFIC_CAMPO_COD", sequenceName = "SEQ_INFOR_VERIFIC_CAMPO_COD",allocationSize=1)
    public Long getIvcCodigo() {
        return ivcCodigo;
    }

    public void setIvcCodigo(Long ivcCodigo) {
        this.ivcCodigo = ivcCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IVC_FECHA", nullable = false)
    public Date getIvcFecha() {
        return ivcFecha;
    }

    public void setIvcFecha(Date ivcFecha) {
        this.ivcFecha = ivcFecha;
    }


    @OneToMany(mappedBy = "siiInformeVerificCampo")
    public List<SiiMunicOrdTraInfVerif> getSiiMunicOrdTraInfVerifList() {
        return siiMunicOrdTraInfVerifList;
    }

    public void setSiiMunicOrdTraInfVerifList(List<SiiMunicOrdTraInfVerif> siiMunicOrdTraInfVerifList) {
        this.siiMunicOrdTraInfVerifList = siiMunicOrdTraInfVerifList;
    }

    public SiiMunicOrdTraInfVerif addSiiMunicOrdTraInfVerif(SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif) {
        getSiiMunicOrdTraInfVerifList().add(siiMunicOrdTraInfVerif);
        siiMunicOrdTraInfVerif.setSiiInformeVerificCampo(this);
        return siiMunicOrdTraInfVerif;
    }

    public SiiMunicOrdTraInfVerif removeSiiMunicOrdTraInfVerif(SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif) {
        getSiiMunicOrdTraInfVerifList().remove(siiMunicOrdTraInfVerif);
        siiMunicOrdTraInfVerif.setSiiInformeVerificCampo(null);
        return siiMunicOrdTraInfVerif;
    }

    @OneToMany(mappedBy = "siiInformeVerificCampo1")
    public List<SiiCuadranteOrdTraInfVer> getSiiCuadranteOrdTraInfVerList() {
        return siiCuadranteOrdTraInfVerList;
    }

    public void setSiiCuadranteOrdTraInfVerList(List<SiiCuadranteOrdTraInfVer> siiCuadranteOrdTraInfVerList) {
        this.siiCuadranteOrdTraInfVerList = siiCuadranteOrdTraInfVerList;
    }

    public SiiCuadranteOrdTraInfVer addSiiCuadranteOrdTraInfVer(SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer) {
        getSiiCuadranteOrdTraInfVerList().add(siiCuadranteOrdTraInfVer);
        siiCuadranteOrdTraInfVer.setSiiInformeVerificCampo1(this);
        return siiCuadranteOrdTraInfVer;
    }

    public SiiCuadranteOrdTraInfVer removeSiiCuadranteOrdTraInfVer(SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer) {
        getSiiCuadranteOrdTraInfVerList().remove(siiCuadranteOrdTraInfVer);
        siiCuadranteOrdTraInfVer.setSiiInformeVerificCampo1(null);
        return siiCuadranteOrdTraInfVer;
    }

    @ManyToOne
    @JoinColumn(name = "OTV_CODIGO")
    public SiiOrdenTrabajoVisita getSiiOrdenTrabajoVisita() {
        return siiOrdenTrabajoVisita;
    }

    public void setSiiOrdenTrabajoVisita(SiiOrdenTrabajoVisita siiOrdenTrabajoVisita) {
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
    }

    @OneToMany(mappedBy = "siiInformeVerificCampo")
    public List<SiiDenuncOrdTraInfVer> getSiiDenuncOrdTraInfVerList() {
        return siiDenuncOrdTraInfVerList;
    }

    public void setSiiDenuncOrdTraInfVerList(List<SiiDenuncOrdTraInfVer> siiDenuncOrdTraInfVerList) {
        this.siiDenuncOrdTraInfVerList = siiDenuncOrdTraInfVerList;
    }

    public SiiDenuncOrdTraInfVer addSiiDenuncOrdTraInfVer(SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer) {
        getSiiDenuncOrdTraInfVerList().add(siiDenuncOrdTraInfVer);
        siiDenuncOrdTraInfVer.setSiiInformeVerificCampo(this);
        return siiDenuncOrdTraInfVer;
    }

    public SiiDenuncOrdTraInfVer removeSiiDenuncOrdTraInfVer(SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer) {
        getSiiDenuncOrdTraInfVerList().remove(siiDenuncOrdTraInfVer);
        siiDenuncOrdTraInfVer.setSiiInformeVerificCampo(null);
        return siiDenuncOrdTraInfVer;
    }

    @ManyToOne
    @JoinColumn(name = "AOT_CODIGO")
    public SiiAuditorOrdenTrab getSiiAuditorOrdenTrab() {
        return siiAuditorOrdenTrab;
    }

    public void setSiiAuditorOrdenTrab(SiiAuditorOrdenTrab siiAuditorOrdenTrab) {
        this.siiAuditorOrdenTrab = siiAuditorOrdenTrab;
    }

    @OneToMany(mappedBy = "siiInformeVerificCampo")
    public List<SiiBarrioOrdenInfVer> getSiiBarrioOrdenInfVerList() {
        return siiBarrioOrdenInfVerList;
    }

    public void setSiiBarrioOrdenInfVerList(List<SiiBarrioOrdenInfVer> siiBarrioOrdenInfVerList) {
        this.siiBarrioOrdenInfVerList = siiBarrioOrdenInfVerList;
    }

    public SiiBarrioOrdenInfVer addSiiBarrioOrdenInfVer(SiiBarrioOrdenInfVer siiBarrioOrdenInfVer) {
        getSiiBarrioOrdenInfVerList().add(siiBarrioOrdenInfVer);
        siiBarrioOrdenInfVer.setSiiInformeVerificCampo(this);
        return siiBarrioOrdenInfVer;
    }

    public SiiBarrioOrdenInfVer removeSiiBarrioOrdenInfVer(SiiBarrioOrdenInfVer siiBarrioOrdenInfVer) {
        getSiiBarrioOrdenInfVerList().remove(siiBarrioOrdenInfVer);
        siiBarrioOrdenInfVer.setSiiInformeVerificCampo(null);
        return siiBarrioOrdenInfVer;
    }
}
