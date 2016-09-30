package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "SII_SOLICITUD_PFC_MENS")
public class SiiSolicitudPfcMens implements Serializable {
    private static final long serialVersionUID = 2300881564852705470L;
    private Long spfCodigo;
    private Date spfFecha;
    private Integer spfVigencia;
    private List<SiiSolicPfcmDetalle> siiSolicPfcmDetalleList;
    private SiiMes siiMes1;
    private SiiEstadoSolicPfcm siiEstadoSolicPfcm;
    private List<SiiSolPfcMensDetRub> siiSolPfcMensDetRubList;

    public SiiSolicitudPfcMens() {
    }

    public SiiSolicitudPfcMens(SiiEstadoSolicPfcm siiEstadoSolicPfcm, SiiMes siiMes1, Long spfCodigo, Date spfFecha,
                               Integer spfVigencia) {
        this.siiEstadoSolicPfcm = siiEstadoSolicPfcm;
        this.siiMes1 = siiMes1;
        this.spfCodigo = spfCodigo;
        this.spfFecha = spfFecha;
        this.spfVigencia = spfVigencia;
    }


    @Id
    @Column(name = "SPF_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SOLICITUD_PFC_MENS_COD")
    @SequenceGenerator(name = "SEQ_SOLICITUD_PFC_MENS_COD", sequenceName = "SEQ_SOLICITUD_PFC_MENS_COD",allocationSize=1)
    public Long getSpfCodigo() {
        return spfCodigo;
    }

    public void setSpfCodigo(Long spfCodigo) {
        this.spfCodigo = spfCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SPF_FECHA", nullable = false)
    public Date getSpfFecha() {
        return spfFecha;
    }

    public void setSpfFecha(Date spfFecha) {
        this.spfFecha = spfFecha;
    }

    @Column(name = "SPF_VIGENCIA", nullable = false)
    public Integer getSpfVigencia() {
        return spfVigencia;
    }

    public void setSpfVigencia(Integer spfVigencia) {
        this.spfVigencia = spfVigencia;
    }

    @OneToMany(mappedBy = "siiSolicitudPfcMens")
    public List<SiiSolicPfcmDetalle> getSiiSolicPfcmDetalleList() {
        return siiSolicPfcmDetalleList;
    }

    public void setSiiSolicPfcmDetalleList(List<SiiSolicPfcmDetalle> siiSolicPfcmDetalleList) {
        this.siiSolicPfcmDetalleList = siiSolicPfcmDetalleList;
    }

    public SiiSolicPfcmDetalle addSiiSolicPfcmDetalle(SiiSolicPfcmDetalle siiSolicPfcmDetalle) {
        getSiiSolicPfcmDetalleList().add(siiSolicPfcmDetalle);
        siiSolicPfcmDetalle.setSiiSolicitudPfcMens(this);
        return siiSolicPfcmDetalle;
    }

    public SiiSolicPfcmDetalle removeSiiSolicPfcmDetalle(SiiSolicPfcmDetalle siiSolicPfcmDetalle) {
        getSiiSolicPfcmDetalleList().remove(siiSolicPfcmDetalle);
        siiSolicPfcmDetalle.setSiiSolicitudPfcMens(null);
        return siiSolicPfcmDetalle;
    }


    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes1() {
        return siiMes1;
    }

    public void setSiiMes1(SiiMes siiMes1) {
        this.siiMes1 = siiMes1;
    }

    @ManyToOne
    @JoinColumn(name = "ESP_CODIGO")
    public SiiEstadoSolicPfcm getSiiEstadoSolicPfcm() {
        return siiEstadoSolicPfcm;
    }

    public void setSiiEstadoSolicPfcm(SiiEstadoSolicPfcm siiEstadoSolicPfcm) {
        this.siiEstadoSolicPfcm = siiEstadoSolicPfcm;
    }

    @OneToMany(mappedBy = "siiSolicitudPfcMens")
    public List<SiiSolPfcMensDetRub> getSiiSolPfcMensDetRubList() {
        return siiSolPfcMensDetRubList;
    }

    public void setSiiSolPfcMensDetRubList(List<SiiSolPfcMensDetRub> siiSolPfcMensDetRubList) {
        this.siiSolPfcMensDetRubList = siiSolPfcMensDetRubList;
    }

    public SiiSolPfcMensDetRub addSiiSolPfcMensDetRub(SiiSolPfcMensDetRub siiSolPfcMensDetRub) {
        getSiiSolPfcMensDetRubList().add(siiSolPfcMensDetRub);
        siiSolPfcMensDetRub.setSiiSolicitudPfcMens(this);
        return siiSolPfcMensDetRub;
    }

    public SiiSolPfcMensDetRub removeSiiSolPfcMensDetRub(SiiSolPfcMensDetRub siiSolPfcMensDetRub) {
        getSiiSolPfcMensDetRubList().remove(siiSolPfcMensDetRub);
        siiSolPfcMensDetRub.setSiiSolicitudPfcMens(null);
        return siiSolPfcMensDetRub;
    }
}
