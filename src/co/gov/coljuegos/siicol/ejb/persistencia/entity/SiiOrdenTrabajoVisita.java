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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_ORDEN_TRABAJO_VISITA")
public class SiiOrdenTrabajoVisita implements Serializable {
    private static final long serialVersionUID = -1386361223108128939L;
    private Long otvCodigo;
    private String otvEstado;
    private Date otvFecha;
    private Date otvFechaFinal;
    private Date otvFechaInicio;
    private Integer otvNumero;
    private Integer otvNumeroFun;
    private List<SiiCuadranteOrdenTra> siiCuadranteOrdenTraList;
    private List<SiiDenunciaOrdenTrab> siiDenunciaOrdenTrabList;
    private List<SiiBarrioOrden> siiBarrioOrdenList;
    private List<SiiMunicipioOrdenTrab> siiMunicipioOrdenTrabList;
    private List<SiiAuditorOrdenTrab> siiAuditorOrdenTrabList;
    private Date otvFechaAnulac;
    private String otvMotivoAnulac;
    private List<SiiInformeVerificCampo> siiInformeVerificCampoList;

    public SiiOrdenTrabajoVisita() {
    }

    public SiiOrdenTrabajoVisita(Long otvCodigo, String otvEstado, Date otvFecha, Integer otvNumero, Integer otvNumeroFun) {
        this.otvCodigo = otvCodigo;
        this.otvEstado = otvEstado;
        this.otvFecha = otvFecha;
        this.otvNumero = otvNumero;
        this.otvNumeroFun = otvNumeroFun;
    }

    @Id
    @Column(name = "OTV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ORDEN_TRAB_VISITA_COD")
    @SequenceGenerator(name = "SEQ_ORDEN_TRAB_VISITA_COD", sequenceName = "SEQ_ORDEN_TRAB_VISITA_COD",allocationSize=1)
    public Long getOtvCodigo() {
        return otvCodigo;
    }

    public void setOtvCodigo(Long otvCodigo) {
        this.otvCodigo = otvCodigo;
    }

    @Column(name = "OTV_ESTADO", nullable = false, length = 1)
    public String getOtvEstado() {
        return otvEstado;
    }

    public void setOtvEstado(String otvEstado) {
        this.otvEstado = otvEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OTV_FECHA", nullable = false)
    public Date getOtvFecha() {
        return otvFecha;
    }

    public void setOtvFecha(Date otvFecha) {
        this.otvFecha = otvFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OTV_FECHA_FINAL", nullable = false)
    public Date getOtvFechaFinal() {
        return otvFechaFinal;
    }

    public void setOtvFechaFinal(Date otvFechaFinal) {
        this.otvFechaFinal = otvFechaFinal;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OTV_FECHA_INICIO", nullable = false)
    public Date getOtvFechaInicio() {
        return otvFechaInicio;
    }

    public void setOtvFechaInicio(Date otvFechaInicio) {
        this.otvFechaInicio = otvFechaInicio;
    }

    @Column(name = "OTV_NUMERO", nullable = false)
    public Integer getOtvNumero() {
        return otvNumero;
    }

    public void setOtvNumero(Integer otvNumero) {
        this.otvNumero = otvNumero;
    }

    @Column(name = "OTV_NUMERO_FUN", nullable = false)
    public Integer getOtvNumeroFun() {
        return otvNumeroFun;
    }

    public void setOtvNumeroFun(Integer otvNumeroFun) {
        this.otvNumeroFun = otvNumeroFun;
    }

    @OneToMany(mappedBy = "siiOrdenTrabajoVisita")
    public List<SiiCuadranteOrdenTra> getSiiCuadranteOrdenTraList() {
        return siiCuadranteOrdenTraList;
    }

    public void setSiiCuadranteOrdenTraList(List<SiiCuadranteOrdenTra> siiCuadranteOrdenTraList) {
        this.siiCuadranteOrdenTraList = siiCuadranteOrdenTraList;
    }

    public SiiCuadranteOrdenTra addSiiCuadranteOrdenTra(SiiCuadranteOrdenTra siiCuadranteOrdenTra) {
        getSiiCuadranteOrdenTraList().add(siiCuadranteOrdenTra);
        siiCuadranteOrdenTra.setSiiOrdenTrabajoVisita(this);
        return siiCuadranteOrdenTra;
    }

    public SiiCuadranteOrdenTra removeSiiCuadranteOrdenTra(SiiCuadranteOrdenTra siiCuadranteOrdenTra) {
        getSiiCuadranteOrdenTraList().remove(siiCuadranteOrdenTra);
        siiCuadranteOrdenTra.setSiiOrdenTrabajoVisita(null);
        return siiCuadranteOrdenTra;
    }

    @OneToMany(mappedBy = "siiOrdenTrabajoVisita")
    public List<SiiDenunciaOrdenTrab> getSiiDenunciaOrdenTrabList() {
        return siiDenunciaOrdenTrabList;
    }

    public void setSiiDenunciaOrdenTrabList(List<SiiDenunciaOrdenTrab> siiDenunciaOrdenTrabList) {
        this.siiDenunciaOrdenTrabList = siiDenunciaOrdenTrabList;
    }

    public SiiDenunciaOrdenTrab addSiiDenunciaOrdenTrab(SiiDenunciaOrdenTrab siiDenunciaOrdenTrab) {
        getSiiDenunciaOrdenTrabList().add(siiDenunciaOrdenTrab);
        siiDenunciaOrdenTrab.setSiiOrdenTrabajoVisita(this);
        return siiDenunciaOrdenTrab;
    }

    public SiiDenunciaOrdenTrab removeSiiDenunciaOrdenTrab(SiiDenunciaOrdenTrab siiDenunciaOrdenTrab) {
        getSiiDenunciaOrdenTrabList().remove(siiDenunciaOrdenTrab);
        siiDenunciaOrdenTrab.setSiiOrdenTrabajoVisita(null);
        return siiDenunciaOrdenTrab;
    }

    @OneToMany(mappedBy = "siiOrdenTrabajoVisita")
    public List<SiiBarrioOrden> getSiiBarrioOrdenList() {
        return siiBarrioOrdenList;
    }

    public void setSiiBarrioOrdenList(List<SiiBarrioOrden> siiBarrioOrdenList) {
        this.siiBarrioOrdenList = siiBarrioOrdenList;
    }

    public SiiBarrioOrden addSiiBarrioOrden(SiiBarrioOrden siiBarrioOrden) {
        getSiiBarrioOrdenList().add(siiBarrioOrden);
        siiBarrioOrden.setSiiOrdenTrabajoVisita(this);
        return siiBarrioOrden;
    }

    public SiiBarrioOrden removeSiiBarrioOrden(SiiBarrioOrden siiBarrioOrden) {
        getSiiBarrioOrdenList().remove(siiBarrioOrden);
        siiBarrioOrden.setSiiOrdenTrabajoVisita(null);
        return siiBarrioOrden;
    }

    @OneToMany(mappedBy = "siiOrdenTrabajoVisita")
    public List<SiiMunicipioOrdenTrab> getSiiMunicipioOrdenTrabList() {
        return siiMunicipioOrdenTrabList;
    }

    public void setSiiMunicipioOrdenTrabList(List<SiiMunicipioOrdenTrab> siiMunicipioOrdenTrabList) {
        this.siiMunicipioOrdenTrabList = siiMunicipioOrdenTrabList;
    }

    public SiiMunicipioOrdenTrab addSiiMunicipioOrdenTrab(SiiMunicipioOrdenTrab siiMunicipioOrdenTrab) {
        getSiiMunicipioOrdenTrabList().add(siiMunicipioOrdenTrab);
        siiMunicipioOrdenTrab.setSiiOrdenTrabajoVisita(this);
        return siiMunicipioOrdenTrab;
    }

    public SiiMunicipioOrdenTrab removeSiiMunicipioOrdenTrab(SiiMunicipioOrdenTrab siiMunicipioOrdenTrab) {
        getSiiMunicipioOrdenTrabList().remove(siiMunicipioOrdenTrab);
        siiMunicipioOrdenTrab.setSiiOrdenTrabajoVisita(null);
        return siiMunicipioOrdenTrab;
    }

    @OneToMany(mappedBy = "siiOrdenTrabajoVisita")
    public List<SiiAuditorOrdenTrab> getSiiAuditorOrdenTrabList() {
        return siiAuditorOrdenTrabList;
    }

    public void setSiiAuditorOrdenTrabList(List<SiiAuditorOrdenTrab> siiAuditorOrdenTrabList) {
        this.siiAuditorOrdenTrabList = siiAuditorOrdenTrabList;
    }

    public SiiAuditorOrdenTrab addSiiAuditorOrdenTrab(SiiAuditorOrdenTrab siiAuditorOrdenTrab) {
        getSiiAuditorOrdenTrabList().add(siiAuditorOrdenTrab);
        siiAuditorOrdenTrab.setSiiOrdenTrabajoVisita(this);
        return siiAuditorOrdenTrab;
    }

    public SiiAuditorOrdenTrab removeSiiAuditorOrdenTrab(SiiAuditorOrdenTrab siiAuditorOrdenTrab) {
        getSiiAuditorOrdenTrabList().remove(siiAuditorOrdenTrab);
        siiAuditorOrdenTrab.setSiiOrdenTrabajoVisita(null);
        return siiAuditorOrdenTrab;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OTV_FECHA_ANULAC")
    public Date getOtvFechaAnulac() {
        return otvFechaAnulac;
    }
    
    public void setOtvFechaAnulac(Date otvFechaAnulac) {
        this.otvFechaAnulac = otvFechaAnulac;
    }
    
    @Column(name = "OTV_MOTIVO_ANULAC", length = 400)
    public String getOtvMotivoAnulac() {
        return otvMotivoAnulac;
    }
    
    public void setOtvMotivoAnulac(String otvMotivoAnulac) {
        this.otvMotivoAnulac = otvMotivoAnulac;
    }
    
    @OneToMany(mappedBy = "siiOrdenTrabajoVisita")
    public List<SiiInformeVerificCampo> getSiiInformeVerificCampoList() {
        return siiInformeVerificCampoList;
    }

    public void setSiiInformeVerificCampoList(List<SiiInformeVerificCampo> siiInformeVerificCampoList) {
        this.siiInformeVerificCampoList = siiInformeVerificCampoList;
    }

    public SiiInformeVerificCampo addSiiInformeVerificCampo(SiiInformeVerificCampo siiInformeVerificCampo) {
        getSiiInformeVerificCampoList().add(siiInformeVerificCampo);
        siiInformeVerificCampo.setSiiOrdenTrabajoVisita(this);
        return siiInformeVerificCampo;
    }

    public SiiInformeVerificCampo removeSiiInformeVerificCampo(SiiInformeVerificCampo siiInformeVerificCampo) {
        getSiiInformeVerificCampoList().remove(siiInformeVerificCampo);
        siiInformeVerificCampo.setSiiOrdenTrabajoVisita(null);
        return siiInformeVerificCampo;
    }
}
