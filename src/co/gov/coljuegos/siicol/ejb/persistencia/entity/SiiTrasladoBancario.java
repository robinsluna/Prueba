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
@Table(name = "SII_TRASLADO_BANCARIO")
public class SiiTrasladoBancario implements Serializable {
    private static final long serialVersionUID = 7329077237222771415L;
    private Long tbaCodigo;
    private Integer tbaConsecutivo;
    private String tbaDescripcion;
    private Date tbaFecha;
    private BigDecimal tbaValor;
    private SiiEstadoTraslBancario siiEstadoTraslBancario;
    private SiiCuentaBancaria siiCuentaBancariaOri;
    private SiiCuentaBancaria siiCuentaBancariaDest;
    private List<SiiDocumentoContable> siiDocumentoContableList;

    public SiiTrasladoBancario() {
    }

    public SiiTrasladoBancario(SiiCuentaBancaria siiCuentaBancariaDest, SiiCuentaBancaria siiCuentaBancariaOri,
                               SiiEstadoTraslBancario siiEstadoTraslBancario, Long tbaCodigo, Integer tbaConsecutivo,
                               String tbaDescripcion, Date tbaFecha, BigDecimal tbaValor) {
        this.siiCuentaBancariaDest = siiCuentaBancariaDest;
        this.siiCuentaBancariaOri = siiCuentaBancariaOri;
        this.siiEstadoTraslBancario = siiEstadoTraslBancario;
        this.tbaCodigo = tbaCodigo;
        this.tbaConsecutivo = tbaConsecutivo;
        this.tbaDescripcion = tbaDescripcion;
        this.tbaFecha = tbaFecha;
        this.tbaValor = tbaValor;
    }


    @Id
    @Column(name = "TBA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TRASLADO_BANCARIO_COD")
    @SequenceGenerator(name = "SEQ_TRASLADO_BANCARIO_COD", sequenceName = "SEQ_TRASLADO_BANCARIO_COD",allocationSize=1)
    public Long getTbaCodigo() {
        return tbaCodigo;
    }

    public void setTbaCodigo(Long tbaCodigo) {
        this.tbaCodigo = tbaCodigo;
    }

    @Column(name = "TBA_CONSECUTIVO")
    public Integer getTbaConsecutivo() {
        return tbaConsecutivo;
    }

    public void setTbaConsecutivo(Integer tbaConsecutivo) {
        this.tbaConsecutivo = tbaConsecutivo;
    }

    @Column(name = "TBA_DESCRIPCION", nullable = false, length = 300)
    public String getTbaDescripcion() {
        return tbaDescripcion;
    }

    public void setTbaDescripcion(String tbaDescripcion) {
        this.tbaDescripcion = tbaDescripcion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TBA_FECHA", nullable = false)
    public Date getTbaFecha() {
        return tbaFecha;
    }

    public void setTbaFecha(Date tbaFecha) {
        this.tbaFecha = tbaFecha;
    }

    @Column(name = "TBA_VALOR", nullable = false)
    public BigDecimal getTbaValor() {
        return tbaValor;
    }

    public void setTbaValor(BigDecimal tbaValor) {
        this.tbaValor = tbaValor;
    }

    @ManyToOne
    @JoinColumn(name = "ETB_CODIGO")
    public SiiEstadoTraslBancario getSiiEstadoTraslBancario() {
        return siiEstadoTraslBancario;
    }

    public void setSiiEstadoTraslBancario(SiiEstadoTraslBancario siiEstadoTraslBancario) {
        this.siiEstadoTraslBancario = siiEstadoTraslBancario;
    }

    @ManyToOne
    @JoinColumn(name = "CBA_CODIGO_ORIGEN")
    public SiiCuentaBancaria getSiiCuentaBancariaOri() {
        return siiCuentaBancariaOri;
    }

    public void setSiiCuentaBancariaOri(SiiCuentaBancaria siiCuentaBancariaOri) {
        this.siiCuentaBancariaOri = siiCuentaBancariaOri;
    }

    @ManyToOne
    @JoinColumn(name = "CBA_CODIGO_DESTINO")
    public SiiCuentaBancaria getSiiCuentaBancariaDest() {
        return siiCuentaBancariaDest;
    }

    public void setSiiCuentaBancariaDest(SiiCuentaBancaria siiCuentaBancariaDest) {
        this.siiCuentaBancariaDest = siiCuentaBancariaDest;
    }

    @OneToMany(mappedBy = "siiTrasladoBancario")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiTrasladoBancario(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiTrasladoBancario(null);
        return siiDocumentoContable;
    }
    
}
