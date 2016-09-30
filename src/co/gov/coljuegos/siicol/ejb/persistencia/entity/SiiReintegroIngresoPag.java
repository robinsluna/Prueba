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
@Table(name = "SII_REINTEGRO_INGRESO_PAG")
public class SiiReintegroIngresoPag implements Serializable {
    private static final long serialVersionUID = -1514965910803790163L;
    private Long ripCodigo;
    private String ripConcepto;
    private String ripEstado;
    private BigDecimal ripValor;
    private SiiCuentaBancaria siiCuentaBancaria;
    private SiiNotaCredito siiNotaCredito;
    private Date ripFecha;
    private Integer ripNumero;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private String RipMotivoAnula;
    private List<SiiRpDetRubReintIngPag> siiRpDetRubReintIngPagList;
    private SiiUsuario siiUsuarioConec;

    public SiiReintegroIngresoPag() {
    }

    public SiiReintegroIngresoPag(SiiCuentaBancaria siiCuentaBancaria, SiiNotaCredito siiNotaCredito, Long ripCodigo,
                                  String ripConcepto, String ripEstado, BigDecimal ripValor) {
        this.siiCuentaBancaria = siiCuentaBancaria;
        this.siiNotaCredito = siiNotaCredito;
        this.ripCodigo = ripCodigo;
        this.ripConcepto = ripConcepto;
        this.ripEstado = ripEstado;
        this.ripValor = ripValor;
    }


    @Id
    @Column(name = "RIP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REINTEGRO_ING_PAG_COD")
    @SequenceGenerator(name = "SEQ_REINTEGRO_ING_PAG_COD", sequenceName = "SEQ_REINTEGRO_ING_PAG_COD",allocationSize=1)
    public Long getRipCodigo() {
        return ripCodigo;
    }

    public void setRipCodigo(Long ripCodigo) {
        this.ripCodigo = ripCodigo;
    }

    @Column(name = "RIP_CONCEPTO", nullable = false, length = 330)
    public String getRipConcepto() {
        return ripConcepto;
    }

    public void setRipConcepto(String ripConcepto) {
        this.ripConcepto = ripConcepto;
    }

    @Column(name = "RIP_ESTADO", nullable = false, length = 1)
    public String getRipEstado() {
        return ripEstado;
    }

    public void setRipEstado(String ripEstado) {
        this.ripEstado = ripEstado;
    }

    @Column(name = "RIP_VALOR", nullable = false)
    public BigDecimal getRipValor() {
        return ripValor;
    }

    public void setRipValor(BigDecimal ripValor) {
        this.ripValor = ripValor;
    }

    @ManyToOne
    @JoinColumn(name = "CBA_CODIGO")
    public SiiCuentaBancaria getSiiCuentaBancaria() {
        return siiCuentaBancaria;
    }

    public void setSiiCuentaBancaria(SiiCuentaBancaria siiCuentaBancaria) {
        this.siiCuentaBancaria = siiCuentaBancaria;
    }

    @ManyToOne
    @JoinColumn(name = "NCR_CODIGO")
    public SiiNotaCredito getSiiNotaCredito() {
        return siiNotaCredito;
    }

    public void setSiiNotaCredito(SiiNotaCredito siiNotaCredito) {
        this.siiNotaCredito = siiNotaCredito;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RIP_FECHA", nullable = false)
    public Date getRipFecha() {
        return ripFecha;
    }

    public void setRipFecha(Date ripFecha) {
        this.ripFecha = ripFecha;
    }

    @Column(name = "RIP_NUMERO", nullable = false)
    public Integer getRipNumero() {
        return ripNumero;
    }

    public void setRipNumero(Integer ripNumero) {
        this.ripNumero = ripNumero;
    }

    @OneToMany(mappedBy = "siiReintegroIngresoPag")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiReintegroIngresoPag(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiReintegroIngresoPag(null);
        return siiDocumentoContable;
    }

    @Column(name = "RIP_MOTIVO_ANULA", nullable = false, length = 440)
    public String getRipMotivoAnula() {
        return RipMotivoAnula;
    }
    
    public void setRipMotivoAnula(String RipMotivoAnula) {
        this.RipMotivoAnula = RipMotivoAnula;
    }

    @OneToMany(mappedBy = "siiReintegroIngresoPag")
    public List<SiiRpDetRubReintIngPag> getSiiRpDetRubReintIngPagList() {
        return siiRpDetRubReintIngPagList;
    }

    public void setSiiRpDetRubReintIngPagList(List<SiiRpDetRubReintIngPag> siiRpDetRubReintIngPagList) {
        this.siiRpDetRubReintIngPagList = siiRpDetRubReintIngPagList;
    }

    public SiiRpDetRubReintIngPag addSiiRpDetRubReintIngPag(SiiRpDetRubReintIngPag siiRpDetRubReintIngPag) {
        getSiiRpDetRubReintIngPagList().add(siiRpDetRubReintIngPag);
        siiRpDetRubReintIngPag.setSiiReintegroIngresoPag(this);
        return siiRpDetRubReintIngPag;
    }

    public SiiRpDetRubReintIngPag removeSiiRpDetRubReintIngPag(SiiRpDetRubReintIngPag siiRpDetRubReintIngPag) {
        getSiiRpDetRubReintIngPagList().remove(siiRpDetRubReintIngPag);
        siiRpDetRubReintIngPag.setSiiReintegroIngresoPag(null);
        return siiRpDetRubReintIngPag;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }
}
