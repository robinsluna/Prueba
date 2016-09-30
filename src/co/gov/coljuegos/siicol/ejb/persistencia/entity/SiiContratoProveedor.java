package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_CONTRATO_PROVEEDOR")
public class SiiContratoProveedor implements Serializable {
    private static final long serialVersionUID = -4645757602478357L;
    private Long cprCodigo;
    private Date cprFecha;
    private BigDecimal cprValor;
    private SiiEstadoContrProv siiEstadoContrProv;
    private SiiOficioAdjudica siiOficioAdjudica;
    private SiiArchivoFisico siiArchivoFisico;

    public SiiContratoProveedor() {
    }

    public SiiContratoProveedor(Long cprCodigo, Date cprFecha, BigDecimal cprValor, SiiEstadoContrProv siiEstadoContrProv,
                                SiiOficioAdjudica siiOficioAdjudica, SiiArchivoFisico siiArchivoFisico) {
        this.cprCodigo = cprCodigo;
        this.cprFecha = cprFecha;
        this.cprValor = cprValor;
        this.siiEstadoContrProv = siiEstadoContrProv;
        this.siiOficioAdjudica = siiOficioAdjudica;
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @Id
    @Column(name = "CPR_CODIGO", nullable = false, length = 16)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CONTR_PROVEEDOR_COD")
    @SequenceGenerator(name = "SEQ_CONTR_PROVEEDOR_COD", sequenceName = "SEQ_CONTR_PROVEEDOR_COD",allocationSize=1)
    public Long getCprCodigo() {
        return cprCodigo;
    }

    public void setCprCodigo(Long cprCodigo) {
        this.cprCodigo = cprCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CPR_FECHA", nullable = false)
    public Date getCprFecha() {
        return cprFecha;
    }

    public void setCprFecha(Date cprFecha) {
        this.cprFecha = cprFecha;
    }

    @Column(name = "CPR_VALOR", nullable = false)
    public BigDecimal getCprValor() {
        return cprValor;
    }

    public void setCprValor(BigDecimal cprValor) {
        this.cprValor = cprValor;
    }


    @ManyToOne
    @JoinColumn(name = "ECP_CODIGO")
    public SiiEstadoContrProv getSiiEstadoContrProv() {
        return siiEstadoContrProv;
    }

    public void setSiiEstadoContrProv(SiiEstadoContrProv siiEstadoContrProv) {
        this.siiEstadoContrProv = siiEstadoContrProv;
    }

    @ManyToOne
    @JoinColumn(name = "OAD_CODIGO")
    public SiiOficioAdjudica getSiiOficioAdjudica() {
        return siiOficioAdjudica;
    }

    public void setSiiOficioAdjudica(SiiOficioAdjudica siiOficioAdjudica) {
        this.siiOficioAdjudica = siiOficioAdjudica;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }
}
