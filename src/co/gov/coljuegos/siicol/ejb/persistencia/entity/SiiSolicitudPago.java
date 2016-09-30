package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

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
@Table(name = "SII_SOLICITUD_PAGO")
public class SiiSolicitudPago implements Serializable {
    private static final long serialVersionUID = -6853814323024395603L;
    private Long spaCodigo;
    private Long spaConsecutivo;
    private Date spaFechaSol;
    private String spaMotivoDevoluc;
    private String spaNumDocCobro;
    private String spaObservaciones;
    private String spaTipoCuenta;
    private BigDecimal spaValorCuenta;
    private Integer spaVigencia;
    
    private SiiRp siiRp;
    private SiiEstadoSolicPago siiEstadoSolicPago;
    private SiiMes siiMes;
    private List<SiiObligacion> siiObligacionList;
    private SiiTipoDocSopSolicPago siiTipoDocSopSolicPago;

    public SiiSolicitudPago() {
    }

    public SiiSolicitudPago(SiiEstadoSolicPago siiEstadoSolicPago, SiiMes siiMes, SiiRp siiRp, Long spaCodigo,
                            Long spaConsecutivo, Date spaFechaSol, String spaMotivoDevoluc, String spaNumDocCobro,
                            String spaObservaciones, String spaTipoCuenta, BigDecimal spaValorCuenta, Integer spaVigencia) {
        this.siiEstadoSolicPago = siiEstadoSolicPago;
        this.siiMes = siiMes;
        this.siiRp = siiRp;
        this.spaCodigo = spaCodigo;
        this.spaConsecutivo = spaConsecutivo;
        this.spaFechaSol = spaFechaSol;
        this.spaMotivoDevoluc = spaMotivoDevoluc;
        this.spaNumDocCobro = spaNumDocCobro;
        this.spaObservaciones = spaObservaciones;
        this.spaTipoCuenta = spaTipoCuenta;
        this.spaValorCuenta = spaValorCuenta;
        this.spaVigencia = spaVigencia;
    }


    @Id
    @Column(name = "SPA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SOLICITUD_PAGO_COD")
    @SequenceGenerator(name = "SEQ_SOLICITUD_PAGO_COD", sequenceName = "SEQ_SOLICITUD_PAGO_COD",allocationSize=1)
    public Long getSpaCodigo() {
        return spaCodigo;
    }

    public void setSpaCodigo(Long spaCodigo) {
        this.spaCodigo = spaCodigo;
    }

    @Column(name = "SPA_CONSECUTIVO", nullable = false)
    public Long getSpaConsecutivo() {
        return spaConsecutivo;
    }

    public void setSpaConsecutivo(Long spaConsecutivo) {
        this.spaConsecutivo = spaConsecutivo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SPA_FECHA_SOL", nullable = false)
    public Date getSpaFechaSol() {
        return spaFechaSol;
    }

    public void setSpaFechaSol(Date spaFechaSol) {
        this.spaFechaSol = spaFechaSol;
    }

    @Column(name = "SPA_MOTIVO_DEVOLUC", length = 1000)
    public String getSpaMotivoDevoluc() {
        return spaMotivoDevoluc;
    }

    public void setSpaMotivoDevoluc(String spaMotivoDevoluc) {
        this.spaMotivoDevoluc = spaMotivoDevoluc;
    }

    @Column(name = "SPA_NUM_DOC_COBRO", nullable = false, length = 20)
    public String getSpaNumDocCobro() {
        return spaNumDocCobro;
    }

    public void setSpaNumDocCobro(String spaNumDocCobro) {
        this.spaNumDocCobro = spaNumDocCobro;
    }

    @Column(name = "SPA_OBSERVACIONES", length = 1000)
    public String getSpaObservaciones() {
        return spaObservaciones;
    }

    public void setSpaObservaciones(String spaObservaciones) {
        this.spaObservaciones = spaObservaciones;
    }

    @Column(name = "SPA_TIPO_CUENTA", nullable = false, length = 1)
    public String getSpaTipoCuenta() {
        return spaTipoCuenta;
    }

    public void setSpaTipoCuenta(String spaTipoCuenta) {
        this.spaTipoCuenta = spaTipoCuenta;
    }

    @Column(name = "SPA_VALOR_CUENTA", nullable = false)
    public BigDecimal getSpaValorCuenta() {
        return spaValorCuenta;
    }

    public void setSpaValorCuenta(BigDecimal spaValorCuenta) {
        this.spaValorCuenta = spaValorCuenta;
    }

    @Column(name = "SPA_VIGENCIA", nullable = false)
    public Integer getSpaVigencia() {
        return spaVigencia;
    }

    public void setSpaVigencia(Integer spaVigencia) {
        this.spaVigencia = spaVigencia;
    }

    @ManyToOne
    @JoinColumn(name = "RP_CODIGO")
    public SiiRp getSiiRp() {
        return siiRp;
    }

    public void setSiiRp(SiiRp siiRp) {
        this.siiRp = siiRp;
    }

    @ManyToOne
    @JoinColumn(name = "ESO_CODIGO")
    public SiiEstadoSolicPago getSiiEstadoSolicPago() {
        return siiEstadoSolicPago;
    }

    public void setSiiEstadoSolicPago(SiiEstadoSolicPago siiEstadoSolicPago) {
        this.siiEstadoSolicPago = siiEstadoSolicPago;
    }

    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }

    @OneToMany(mappedBy = "siiSolicitudPago")
    public List<SiiObligacion> getSiiObligacionList() {
        return siiObligacionList;
    }

    public void setSiiObligacionList(List<SiiObligacion> siiObligacionList) {
        this.siiObligacionList = siiObligacionList;
    }

    public SiiObligacion addSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().add(siiObligacion);
        siiObligacion.setSiiSolicitudPago(this);
        return siiObligacion;
    }

    public SiiObligacion removeSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().remove(siiObligacion);
        siiObligacion.setSiiSolicitudPago(null);
        return siiObligacion;
    }

    @ManyToOne
    @JoinColumn(name = "TSP_CODIGO")
    public SiiTipoDocSopSolicPago getSiiTipoDocSopSolicPago() {
        return siiTipoDocSopSolicPago;
    }

    public void setSiiTipoDocSopSolicPago(SiiTipoDocSopSolicPago siiTipoDocSopSolicPago) {
        this.siiTipoDocSopSolicPago = siiTipoDocSopSolicPago;
    }
}
