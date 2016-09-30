
package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_ACUERDO_PAGO")
public class SiiAcuerdoPago implements Serializable {
    private static final long serialVersionUID = 2275686630460817L;
    private Long apaCodigo;
    private Date apaFecha;
    private Date apaFechaResol;
    private String apaNumResol;
    private Integer apaNumero;
    private List<SiiCuotaOperador> siiCuotaOperadorList;
    private SiiTipoOrigen siiTipoOrigen;
    private SiiPersona siiPersona;
    private SiiEstadoAcuerdoPago siiEstadoAcuerdoPago;
    private String apaDocOrigen;
    private Date apaFechaAprComite;
    private Date apaFechaFin;
    private Date apaFechaFirmaRes;
    private Date apaFechaInicio;
    private Date apaFechaRetiro;
    private Date apaIncFecha;
    private Date apaIncFechaRes;
    private String apaIncResolucion;
    private String apaIndicadorResult;
    private String apaMotivoRetiro;
    private String apaNumComiteApr;
    private String apaResolucModif;
    private List<SiiHlpCuotaAcuerdo> siiHlpCuotaAcuerdoList;
    private Date apaFechaIniPago;
    private Date apaFechaFinPago;
    private Date apaFechaMaxPagAbIni;
    private List<SiiDetalleRecaudo> siiDetalleRecaudoList;
    private BigDecimal apaPorcentAbIni;
    private List<SiiAbonoIniAcuerdoPago> siiAbonoIniAcuerdoPagoList;

    public SiiAcuerdoPago() {
    }

    public SiiAcuerdoPago(Long apaCodigo, Date apaFecha, Date apaFechaResol, String apaNumResol, Integer apaNumero) {
        this.apaCodigo = apaCodigo;
        this.apaFecha = apaFecha;
        this.apaFechaResol = apaFechaResol;
        this.apaNumResol = apaNumResol;
        this.apaNumero = apaNumero;
    }

    @Id
    @Column(name = "APA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACUERDO_PAGO_COD")
    @SequenceGenerator(name = "SEQ_ACUERDO_PAGO_COD", sequenceName = "SEQ_ACUERDO_PAGO_COD",allocationSize=1)
    public Long getApaCodigo() {
        return apaCodigo;
    }

    public void setApaCodigo(Long apaCodigo) {
        this.apaCodigo = apaCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_FECHA", nullable = false)
    public Date getApaFecha() {
        return apaFecha;
    }

    public void setApaFecha(Date apaFecha) {
        this.apaFecha = apaFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_FECHA_RESOL", nullable = false)
    public Date getApaFechaResol() {
        return apaFechaResol;
    }

    public void setApaFechaResol(Date apaFechaResol) {
        this.apaFechaResol = apaFechaResol;
    }

    @Column(name = "APA_NUM_RESOL", nullable = false, length = 8)
    public String getApaNumResol() {
        return apaNumResol;
    }

    public void setApaNumResol(String apaNumResol) {
        this.apaNumResol = apaNumResol;
    }

    @Column(name = "APA_NUMERO", nullable = false)
    public Integer getApaNumero() {
        return apaNumero;
    }

    public void setApaNumero(Integer apaNumero) {
        this.apaNumero = apaNumero;
    }

    @OneToMany(mappedBy = "siiAcuerdoPago")
    public List<SiiCuotaOperador> getSiiCuotaOperadorList() {
        return siiCuotaOperadorList;
    }

    public void setSiiCuotaOperadorList(List<SiiCuotaOperador> siiCuotaOperadorList) {
        this.siiCuotaOperadorList = siiCuotaOperadorList;
    }

    public SiiCuotaOperador addSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().add(siiCuotaOperador);
        siiCuotaOperador.setSiiAcuerdoPago(this);
        return siiCuotaOperador;
    }

    public SiiCuotaOperador removeSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().remove(siiCuotaOperador);
        siiCuotaOperador.setSiiAcuerdoPago(null);
        return siiCuotaOperador;
    }


    @ManyToOne
    @JoinColumn(name = "TOR_CODIGO")
    public SiiTipoOrigen getSiiTipoOrigen() {
        return siiTipoOrigen;
    }

    public void setSiiTipoOrigen(SiiTipoOrigen siiTipoOrigen) {
        this.siiTipoOrigen = siiTipoOrigen;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "EAP_CODIGO")
    public SiiEstadoAcuerdoPago getSiiEstadoAcuerdoPago() {
        return siiEstadoAcuerdoPago;
    }

    public void setSiiEstadoAcuerdoPago(SiiEstadoAcuerdoPago siiEstadoAcuerdoPago) {
        this.siiEstadoAcuerdoPago = siiEstadoAcuerdoPago;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_FECHA_APR_COMITE")
    public Date getApaFechaAprComite() {
        return apaFechaAprComite;
    }

    public void setApaFechaAprComite(Date apaFechaAprComite) {
        this.apaFechaAprComite = apaFechaAprComite;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_FECHA_FIN", nullable = false)
    public Date getApaFechaFin() {
        return apaFechaFin;
    }

    public void setApaFechaFin(Date apaFechaFin) {
        this.apaFechaFin = apaFechaFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_FECHA_FIRMA_RES")
    public Date getApaFechaFirmaRes() {
        return apaFechaFirmaRes;
    }

    public void setApaFechaFirmaRes(Date apaFechaFirmaRes) {
        this.apaFechaFirmaRes = apaFechaFirmaRes;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_FECHA_INICIO", nullable = false)
    public Date getApaFechaInicio() {
        return apaFechaInicio;
    }

    public void setApaFechaInicio(Date apaFechaInicio) {
        this.apaFechaInicio = apaFechaInicio;
    }

    @Column(name = "APA_DOC_ORIGEN", length = 20)
    public String getApaDocOrigen() {
        return apaDocOrigen;
    }

    public void setApaDocOrigen(String apaDocOrigen) {
        this.apaDocOrigen = apaDocOrigen;
    }

    @Column(name = "APA_NUM_COMITE_APR", length = 20)
    public String getApaNumComiteApr() {
        return apaNumComiteApr;
    }

    public void setApaNumComiteApr(String apaNumComiteApr) {
        this.apaNumComiteApr = apaNumComiteApr;
    }

    @Column(name = "APA_RESOLUC_MODIF", length = 8)
    public String getApaResolucModif() {
        return apaResolucModif;
    }

    public void setApaResolucModif(String apaResolucModif) {
        this.apaResolucModif = apaResolucModif;
    }

    @OneToMany(mappedBy = "siiAcuerdoPago")
    public List<SiiHlpCuotaAcuerdo> getSiiHlpCuotaAcuerdoList() {
        return siiHlpCuotaAcuerdoList;
    }

    public void setSiiHlpCuotaAcuerdoList(List<SiiHlpCuotaAcuerdo> siiHlpCuotaAcuerdoList) {
        this.siiHlpCuotaAcuerdoList = siiHlpCuotaAcuerdoList;
    }

    public SiiHlpCuotaAcuerdo addSiiHlpCuotaAcuerdo(SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo) {
        getSiiHlpCuotaAcuerdoList().add(siiHlpCuotaAcuerdo);
        siiHlpCuotaAcuerdo.setSiiAcuerdoPago(this);
        return siiHlpCuotaAcuerdo;
    }

    public SiiHlpCuotaAcuerdo removeSiiHlpCuotaAcuerdo(SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo) {
        getSiiHlpCuotaAcuerdoList().remove(siiHlpCuotaAcuerdo);
        siiHlpCuotaAcuerdo.setSiiAcuerdoPago(null);
        return siiHlpCuotaAcuerdo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_FECHA_INI_PAGO")
    public Date getApaFechaIniPago() {
        return apaFechaIniPago;
    }

    public void setApaFechaIniPago(Date apaFechaIniPago) {
        this.apaFechaIniPago = apaFechaIniPago;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_FECHA_FIN_PAGO")
    public Date getApaFechaFinPago() {
        return apaFechaFinPago;
    }

    public void setApaFechaFinPago(Date apaFechaFinPago) {
        this.apaFechaFinPago = apaFechaFinPago;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_FECHA_MAX_PAG_AB_INI")
    public Date getApaFechaMaxPagAbIni() {
        return apaFechaMaxPagAbIni;
    }

    public void setApaFechaMaxPagAbIni(Date apaFechaMaxPagAbIni) {
        this.apaFechaMaxPagAbIni = apaFechaMaxPagAbIni;
    }

    @OneToMany(mappedBy = "siiAcuerdoPago")
    public List<SiiDetalleRecaudo> getSiiDetalleRecaudoList() {
        return siiDetalleRecaudoList;
    }

    public void setSiiDetalleRecaudoList(List<SiiDetalleRecaudo> siiDetalleRecaudoList) {
        this.siiDetalleRecaudoList = siiDetalleRecaudoList;
    }

    public SiiDetalleRecaudo addSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().add(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiAcuerdoPago(this);
        return siiDetalleRecaudo;
    }

    public SiiDetalleRecaudo removeSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().remove(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiAcuerdoPago(null);
        return siiDetalleRecaudo;
    }

    @Column(name = "APA_PORCENT_AB_INI", nullable = false)
    public BigDecimal getApaPorcentAbIni() {
        return apaPorcentAbIni;
    }
    
    public void setApaPorcentAbIni(BigDecimal apaPorcentAbIni) {
        this.apaPorcentAbIni = apaPorcentAbIni;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_FECHA_RETIRO")
    public Date getApaFechaRetiro() {
        return apaFechaRetiro;
    }

    public void setApaFechaRetiro(Date apaFechaRetiro) {
        this.apaFechaRetiro = apaFechaRetiro;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_INC_FECHA")
    public Date getApaIncFecha() {
        return apaIncFecha;
    }

    public void setApaIncFecha(Date apaIncFecha) {
        this.apaIncFecha = apaIncFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APA_INC_FECHA_RES")
    public Date getApaIncFechaRes() {
        return apaIncFechaRes;
    }

    public void setApaIncFechaRes(Date apaIncFechaRes) {
        this.apaIncFechaRes = apaIncFechaRes;
    }

    @Column(name = "APA_INC_RESOLUCION", length = 30)
    public String getApaIncResolucion() {
        return apaIncResolucion;
    }

    public void setApaIncResolucion(String apaIncResolucion) {
        this.apaIncResolucion = apaIncResolucion;
    }

    @Column(name = "APA_INDICADOR_RESULT", length = 1)
    public String getApaIndicadorResult() {
        return apaIndicadorResult;
    }

    public void setApaIndicadorResult(String apaIndicadorResult) {
        this.apaIndicadorResult = apaIndicadorResult;
    }

    @Column(name = "APA_MOTIVO_RETIRO", length = 550)
    public String getApaMotivoRetiro() {
        return apaMotivoRetiro;
    }

    public void setApaMotivoRetiro(String apaMotivoRetiro) {
        this.apaMotivoRetiro = apaMotivoRetiro;
    }

    @OneToMany(mappedBy = "siiAcuerdoPago")
    public List<SiiAbonoIniAcuerdoPago> getSiiAbonoIniAcuerdoPagoList() {
        return siiAbonoIniAcuerdoPagoList;
    }

    public void setSiiAbonoIniAcuerdoPagoList(List<SiiAbonoIniAcuerdoPago> siiAbonoIniAcuerdoPagoList) {
        this.siiAbonoIniAcuerdoPagoList = siiAbonoIniAcuerdoPagoList;
    }

    public SiiAbonoIniAcuerdoPago addSiiAbonoIniAcuerdoPago(SiiAbonoIniAcuerdoPago siiAbonoIniAcuerdoPago) {
        getSiiAbonoIniAcuerdoPagoList().add(siiAbonoIniAcuerdoPago);
        siiAbonoIniAcuerdoPago.setSiiAcuerdoPago(this);
        return siiAbonoIniAcuerdoPago;
    }

    public SiiAbonoIniAcuerdoPago removeSiiAbonoIniAcuerdoPago(SiiAbonoIniAcuerdoPago siiAbonoIniAcuerdoPago) {
        getSiiAbonoIniAcuerdoPagoList().remove(siiAbonoIniAcuerdoPago);
        siiAbonoIniAcuerdoPago.setSiiAcuerdoPago(null);
        return siiAbonoIniAcuerdoPago;
    }
}
