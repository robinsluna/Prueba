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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_OPERACION_LINEA_BAN")
public class SiiOperacionLineaBan implements Serializable {
    private static final long serialVersionUID = 3335755974909701384L;
    private Long olbCodigo;
    private Integer olbCodigoResp;
    private Long olbCodEan;
    private String olbCuartaRef;
    private String olbDatosAdicion;
    private Date olbFecha;
    private Date olbFechaReg;
    private String olbIdWebservice;
    private String olbRefPrincipal;
    private String olbRefSecund;
    private String olbTerceraRef;
    private String olbTipoOperacion;
    private BigDecimal olbValor;
    private List<SiiRecaudoLineaBan> siiRecaudoLineaBanList;
    private List<SiiRecaudoLineaBan> siiRecaudoLineaBanAnulaList;
    private String olbMedioPago;

    public SiiOperacionLineaBan() {
    }

    public SiiOperacionLineaBan(Long olbCodEan, Long olbCodigo, Integer olbCodigoResp, String olbCuartaRef,
                                String olbDatosAdicion, Date olbFecha, Date olbFechaReg, String olbIdWebservice,
                                String olbRefPrincipal, String olbRefSecund, String olbTerceraRef,
                                String olbTipoOperacion, BigDecimal olbValor) {
        this.olbCodEan = olbCodEan;
        this.olbCodigo = olbCodigo;
        this.olbCodigoResp = olbCodigoResp;
        this.olbCuartaRef = olbCuartaRef;
        this.olbDatosAdicion = olbDatosAdicion;
        this.olbFecha = olbFecha;
        this.olbFechaReg = olbFechaReg;
        this.olbIdWebservice = olbIdWebservice;
        this.olbRefPrincipal = olbRefPrincipal;
        this.olbRefSecund = olbRefSecund;
        this.olbTerceraRef = olbTerceraRef;
        this.olbTipoOperacion = olbTipoOperacion;
        this.olbValor = olbValor;
    }

    @Id
    @Column(name = "OLB_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OPE_LINEA_BAN_COD")
    @SequenceGenerator(name = "SEQ_OPE_LINEA_BAN_COD", sequenceName = "SEQ_OPE_LINEA_BAN_COD",allocationSize=1)
    public Long getOlbCodigo() {
        return olbCodigo;
    }

    public void setOlbCodigo(Long olbCodigo) {
        this.olbCodigo = olbCodigo;
    }

    @Column(name = "OLB_CODIGO_RESP")
    public Integer getOlbCodigoResp() {
        return olbCodigoResp;
    }

    public void setOlbCodigoResp(Integer olbCodigoResp) {
        this.olbCodigoResp = olbCodigoResp;
    }

    @Column(name = "OLB_COD_EAN", nullable = false)
    public Long getOlbCodEan() {
        return olbCodEan;
    }

    public void setOlbCodEan(Long olbCodEan) {
        this.olbCodEan = olbCodEan;
    }

    @Column(name = "OLB_CUARTA_REF", length = 50)
    public String getOlbCuartaRef() {
        return olbCuartaRef;
    }

    public void setOlbCuartaRef(String olbCuartaRef) {
        this.olbCuartaRef = olbCuartaRef;
    }

    @Column(name = "OLB_DATOS_ADICION", length = 200)
    public String getOlbDatosAdicion() {
        return olbDatosAdicion;
    }

    public void setOlbDatosAdicion(String olbDatosAdicion) {
        this.olbDatosAdicion = olbDatosAdicion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OLB_FECHA")
    public Date getOlbFecha() {
        return olbFecha;
    }

    public void setOlbFecha(Date olbFecha) {
        this.olbFecha = olbFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OLB_FECHA_REG", nullable = false)
    public Date getOlbFechaReg() {
        return olbFechaReg;
    }

    public void setOlbFechaReg(Date olbFechaReg) {
        this.olbFechaReg = olbFechaReg;
    }

    @Column(name = "OLB_ID_WEBSERVICE", length = 20)
    public String getOlbIdWebservice() {
        return olbIdWebservice;
    }

    public void setOlbIdWebservice(String olbIdWebservice) {
        this.olbIdWebservice = olbIdWebservice;
    }

    @Column(name = "OLB_REF_PRINCIPAL", nullable = false, length = 50)
    public String getOlbRefPrincipal() {
        return olbRefPrincipal;
    }

    public void setOlbRefPrincipal(String olbRefPrincipal) {
        this.olbRefPrincipal = olbRefPrincipal;
    }

    @Column(name = "OLB_REF_SECUND", length = 50)
    public String getOlbRefSecund() {
        return olbRefSecund;
    }

    public void setOlbRefSecund(String olbRefSecund) {
        this.olbRefSecund = olbRefSecund;
    }

    @Column(name = "OLB_TERCERA_REF", length = 50)
    public String getOlbTerceraRef() {
        return olbTerceraRef;
    }

    public void setOlbTerceraRef(String olbTerceraRef) {
        this.olbTerceraRef = olbTerceraRef;
    }

    @Column(name = "OLB_TIPO_OPERACION", nullable = false, length = 1)
    public String getOlbTipoOperacion() {
        return olbTipoOperacion;
    }

    public void setOlbTipoOperacion(String olbTipoOperacion) {
        this.olbTipoOperacion = olbTipoOperacion;
    }

    @Column(name = "OLB_VALOR")
    public BigDecimal getOlbValor() {
        return olbValor;
    }

    public void setOlbValor(BigDecimal olbValor) {
        this.olbValor = olbValor;
    }

    @OneToMany(mappedBy = "siiOperacionLineaBan")
    public List<SiiRecaudoLineaBan> getSiiRecaudoLineaBanList() {
        return siiRecaudoLineaBanList;
    }

    public void setSiiRecaudoLineaBanList(List<SiiRecaudoLineaBan> siiRecaudoLineaBanList) {
        this.siiRecaudoLineaBanList = siiRecaudoLineaBanList;
    }

    public SiiRecaudoLineaBan addSiiRecaudoLineaBan(SiiRecaudoLineaBan siiRecaudoLineaBan) {
        getSiiRecaudoLineaBanList().add(siiRecaudoLineaBan);
        siiRecaudoLineaBan.setSiiOperacionLineaBan(this);
        return siiRecaudoLineaBan;
    }

    public SiiRecaudoLineaBan removeSiiRecaudoLineaBan(SiiRecaudoLineaBan siiRecaudoLineaBan) {
        getSiiRecaudoLineaBanList().remove(siiRecaudoLineaBan);
        siiRecaudoLineaBan.setSiiOperacionLineaBan(null);
        return siiRecaudoLineaBan;
    }

    @OneToMany(mappedBy = "siiOperacionLineaBanAnula")
    public List<SiiRecaudoLineaBan> getSiiRecaudoLineaBanAnulaList() {
        return siiRecaudoLineaBanAnulaList;
    }

    public void setSiiRecaudoLineaBanAnulaList(List<SiiRecaudoLineaBan> siiRecaudoLineaBanAnulaList) {
        this.siiRecaudoLineaBanAnulaList = siiRecaudoLineaBanAnulaList;
    }

    @Column(name = "OLB_MEDIO_PAGO", nullable = false, length = 2)
    public String getOlbMedioPago() {
        return olbMedioPago;
    }

    public void setOlbMedioPago(String olbMedioPago) {
        this.olbMedioPago = olbMedioPago;
    }
}
