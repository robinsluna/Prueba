package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

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

@Entity
@Table(name = "SII_DETALLE_RECAUDO")
public class SiiDetalleRecaudo implements Serializable {
    private Long dreCodigo;
    private String dreEstado;
    private Integer dreNumAutoriza;
    private Integer dreNumOperac;
    private String dreRefPago;
    private Integer dreSecuencia;
    private String dreSucursal;
    private BigDecimal dreValor;
    private SiiRecaudoBanco siiRecaudoBanco;
    private SiiProcedenciaPago siiProcedenciaPago;
    private SiiMedioPago siiMedioPago;
    private SiiBanco siiBanco;
    private SiiRecaudoPse siiRecaudoPse;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private List<SiiDetRecaudoInteres> siiDetRecaudoInterList;
    private SiiAjuste siiAjuste;
    private SiiRecaudoLineaBan siiRecaudoLineaBan;
    private List<SiiAjusteDetRecaudo> siiAjusteDetRecaudoList;
    private SiiAcuerdoPago siiAcuerdoPago;
    private SiiRecaudoLineaBan siiRecaudoLineaBanAnula;
    private SiiPagoCargaActAdm siiPagoCargaActAdm;

    public SiiDetalleRecaudo() {
    }

    public SiiDetalleRecaudo(Long dreCodigo, Integer dreNumAutoriza, Integer dreNumOperac, SiiBanco siiBanco, String dreEstado,
                             String dreRefPago, Integer dreSecuencia, String dreSucursal, BigDecimal dreValor, SiiRecaudoPse siiRecaudoPse,
                             SiiRecaudoBanco siiRecaudoBanco, SiiMedioPago siiMedioPago, SiiProcedenciaPago siiProcedenciaPago) {
        this.dreCodigo = dreCodigo;
        this.dreNumAutoriza = dreNumAutoriza;
        this.dreNumOperac = dreNumOperac;
        this.dreRefPago = dreRefPago;
        this.dreSecuencia = dreSecuencia;
        this.dreSucursal = dreSucursal;
        this.dreValor = dreValor;
        this.siiRecaudoBanco = siiRecaudoBanco;
        this.siiMedioPago = siiMedioPago;
        this.siiProcedenciaPago = siiProcedenciaPago;
        this.siiBanco = siiBanco;
        this.siiRecaudoPse = siiRecaudoPse;

    }

    @Id
    @Column(name = "DRE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DETALLE_RECAUDO_COD")
    @SequenceGenerator(name = "SEQ_DETALLE_RECAUDO_COD", sequenceName = "SEQ_DETALLE_RECAUDO_COD",allocationSize=1)
    public Long getDreCodigo() {
        return dreCodigo;
    }

    public void setDreCodigo(Long dreCodigo) {
        this.dreCodigo = dreCodigo;
    }

    @Column(name = "DRE_ESTADO", nullable = false, length = 1)
    public String getDreEstado() {
        return dreEstado;
    }

    public void setDreEstado(String dreEstado) {
        this.dreEstado = dreEstado;
    }

    @Column(name = "DRE_NUM_AUTORIZA", nullable = false)
    public Integer getDreNumAutoriza() {
        return dreNumAutoriza;
    }

    public void setDreNumAutoriza(Integer dreNumAutoriza) {
        this.dreNumAutoriza = dreNumAutoriza;
    }

    @Column(name = "DRE_NUM_OPERAC", nullable = false)
    public Integer getDreNumOperac() {
        return dreNumOperac;
    }

    public void setDreNumOperac(Integer dreNumOperac) {
        this.dreNumOperac = dreNumOperac;
    }

    @Column(name = "DRE_REF_PAGO", nullable = false, length = 48)
    public String getDreRefPago() {
        return dreRefPago;
    }

    public void setDreRefPago(String dreRefPago) {
        this.dreRefPago = dreRefPago;
    }

    @Column(name = "DRE_SECUENCIA", nullable = false)
    public Integer getDreSecuencia() {
        return dreSecuencia;
    }

    public void setDreSecuencia(Integer dreSecuencia) {
        this.dreSecuencia = dreSecuencia;
    }

    @Column(name = "DRE_SUCURSAL", nullable = false, length = 4)
    public String getDreSucursal() {
        return dreSucursal;
    }

    public void setDreSucursal(String dreSucursal) {
        this.dreSucursal = dreSucursal;
    }

    @Column(name = "DRE_VALOR", nullable = false)
    public BigDecimal getDreValor() {
        return dreValor;
    }

    public void setDreValor(BigDecimal dreValor) {
        this.dreValor = dreValor;
    }


    @ManyToOne
    @JoinColumn(name = "RBA_CODIGO")
    public SiiRecaudoBanco getSiiRecaudoBanco() {
        return siiRecaudoBanco;
    }

    public void setSiiRecaudoBanco(SiiRecaudoBanco siiRecaudoBanco) {
        this.siiRecaudoBanco = siiRecaudoBanco;
    }

    @ManyToOne
    @JoinColumn(name = "PPA_CODIGO")
    public SiiProcedenciaPago getSiiProcedenciaPago() {
        return siiProcedenciaPago;
    }

    public void setSiiProcedenciaPago(SiiProcedenciaPago siiProcedenciaPago) {
        this.siiProcedenciaPago = siiProcedenciaPago;
    }

    @ManyToOne
    @JoinColumn(name = "MEP_CODIGO")
    public SiiMedioPago getSiiMedioPago() {
        return siiMedioPago;
    }

    public void setSiiMedioPago(SiiMedioPago siiMedioPago) {
        this.siiMedioPago = siiMedioPago;
    }

    @ManyToOne
    @JoinColumn(name = "BAN_CODIGO_ORIGEN")
    public SiiBanco getSiiBanco() {
        return siiBanco;
    }

    public void setSiiBanco(SiiBanco siiBanco) {
        this.siiBanco = siiBanco;
    }

    @ManyToOne
    @JoinColumn(name = "RPS_CODIGO")
    public SiiRecaudoPse getSiiRecaudoPse() {
        return siiRecaudoPse;
    }

    public void setSiiRecaudoPse(SiiRecaudoPse siiRecaudoPse) {
        this.siiRecaudoPse = siiRecaudoPse;
    }

    @OneToMany(mappedBy = "siiDetalleRecaudo")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiDetalleRecaudo(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiDetalleRecaudo(null);
        return siiDocumentoContable;
    }

    @OneToMany(mappedBy = "siiDetalleRecaudo")
    public List<SiiDetRecaudoInteres> getSiiDetRecaudoInterList() {
        return siiDetRecaudoInterList;
    }

    public void setSiiDetRecaudoInterList(List<SiiDetRecaudoInteres> siiDetRecaudoInterList) {
        this.siiDetRecaudoInterList = siiDetRecaudoInterList;
    }

    public SiiDetRecaudoInteres addSiiDetRecaudoInteres(SiiDetRecaudoInteres siiDetRecaudoInteres) {
        getSiiDetRecaudoInterList().add(siiDetRecaudoInteres);
        siiDetRecaudoInteres.setSiiDetalleRecaudo(this);
        return siiDetRecaudoInteres;
    }

    public SiiDetRecaudoInteres removeSiiDetRecaudoInteres(SiiDetRecaudoInteres siiDetRecaudoInteres) {
        getSiiDetRecaudoInterList().remove(siiDetRecaudoInteres);
        siiDetRecaudoInteres.setSiiDetalleRecaudo(null);
        return siiDetRecaudoInteres;
    }

    @ManyToOne
    @JoinColumn(name = "AJU_CODIGO")
    public SiiAjuste getSiiAjuste() {
        return siiAjuste;
    }

    public void setSiiAjuste(SiiAjuste siiAjuste) {
        this.siiAjuste = siiAjuste;
    }

    @ManyToOne
    @JoinColumn(name = "RLB_CODIGO")
    public SiiRecaudoLineaBan getSiiRecaudoLineaBan() {
        return siiRecaudoLineaBan;
    }

    public void setSiiRecaudoLineaBan(SiiRecaudoLineaBan siiRecaudoLineaBan) {
        this.siiRecaudoLineaBan = siiRecaudoLineaBan;
    }

    @OneToMany(mappedBy = "siiDetalleRecaudo")
    public List<SiiAjusteDetRecaudo> getSiiAjusteDetRecaudoList() {
        return siiAjusteDetRecaudoList;
    }

    public void setSiiAjusteDetRecaudoList(List<SiiAjusteDetRecaudo> siiAjusteDetRecaudoList) {
        this.siiAjusteDetRecaudoList = siiAjusteDetRecaudoList;
    }

    public SiiAjusteDetRecaudo addSiiAjusteDetRecaudo(SiiAjusteDetRecaudo siiAjusteDetRecaudo) {
        getSiiAjusteDetRecaudoList().add(siiAjusteDetRecaudo);
        siiAjusteDetRecaudo.setSiiDetalleRecaudo(this);
        return siiAjusteDetRecaudo;
    }

    public SiiAjusteDetRecaudo removeSiiAjusteDetRecaudo(SiiAjusteDetRecaudo siiAjusteDetRecaudo) {
        getSiiAjusteDetRecaudoList().remove(siiAjusteDetRecaudo);
        siiAjusteDetRecaudo.setSiiDetalleRecaudo(null);
        return siiAjusteDetRecaudo;
    }

    @ManyToOne
    @JoinColumn(name = "APA_CODIGO")
    public SiiAcuerdoPago getSiiAcuerdoPago() {
        return siiAcuerdoPago;
    }

    public void setSiiAcuerdoPago(SiiAcuerdoPago siiAcuerdoPago) {
        this.siiAcuerdoPago = siiAcuerdoPago;
    }

    @ManyToOne
    @JoinColumn(name = "RLB_CODIGO_ANULA")
    public SiiRecaudoLineaBan getSiiRecaudoLineaBanAnula() {
        return siiRecaudoLineaBanAnula;
    }

    public void setSiiRecaudoLineaBanAnula(SiiRecaudoLineaBan siiRecaudoLineaBanAnula) {
        this.siiRecaudoLineaBanAnula = siiRecaudoLineaBanAnula;
    }

    @ManyToOne
    @JoinColumn(name = "PCA_CODIGO")
    public SiiPagoCargaActAdm getSiiPagoCargaActAdm() {
        return siiPagoCargaActAdm;
    }

    public void setSiiPagoCargaActAdm(SiiPagoCargaActAdm siiPagoCargaActAdm) {
        this.siiPagoCargaActAdm = siiPagoCargaActAdm;
    }
}
