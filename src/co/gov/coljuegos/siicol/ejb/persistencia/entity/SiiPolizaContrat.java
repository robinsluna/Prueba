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
@Table(name = "SII_POLIZA_CONTRAT")
public class SiiPolizaContrat implements Serializable {
    private static final long serialVersionUID = 2607370132847737711L;
    private Long pccCodigo;
    private Date pccFechaExped;
    private Date pccFechaRecep;
    private String pccNumero;
    private String pccObservaciones;
    private SiiAseguradora siiAseguradora;
    private List<SiiPolizaRequisitosPol> siiPolizaRequisitosPolList;
    private SiiEstadoPolizaCont siiEstadoPolizaCont;
    private SiiArchivoFisico siiArchivoFisico;
    private List<SiiGarantiaPoliza> siiGarantiaPolizaList1;
    private List<SiiOficInfPoliza> siiOficInfPolizaList1;
    private SiiContrato siiContrato;
    private String pccContratoNue;
    private SiiTipoPolizaContr siiTipoPolizaContr;
    private SiiOtrosi siiOtrosi;
    private String pccRenovacion;
    private Date pccFechaAprobac;
    private Date pccFechaIniOpera;
    private String pccRadicado;
    private Date pccFechaRadicado;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private List<SiiTipoApuestPolizaRenovac> siiTipoApuestPolizaRenovacList;
    private BigDecimal pccTiempoEjecCon;

    public SiiPolizaContrat() {
    }

    public SiiPolizaContrat(SiiArchivoFisico siiArchivoFisico, SiiAseguradora siiAseguradora, SiiContrato siiContrato,
                            SiiEstadoPolizaCont siiEstadoPolizaCont, Long pccCodigo, Date pccFechaExped,
                            Date pccFechaRecep, String pccNumero, String pccObservaciones) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.siiAseguradora = siiAseguradora;
        this.siiContrato = siiContrato;
        this.siiEstadoPolizaCont = siiEstadoPolizaCont;
        this.pccCodigo = pccCodigo;
        this.pccFechaExped = pccFechaExped;
        this.pccFechaRecep = pccFechaRecep;
        this.pccNumero = pccNumero;
        this.pccObservaciones = pccObservaciones;
    }


    @Id
    @Column(name = "PCC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_POLIZA_CONTRAT_COD")
    @SequenceGenerator(name = "SEQ_POLIZA_CONTRAT_COD", sequenceName = "SEQ_POLIZA_CONTRAT_COD",allocationSize=1)
    public Long getPccCodigo() {
        return pccCodigo;
    }

    public void setPccCodigo(Long pccCodigo) {
        this.pccCodigo = pccCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PCC_FECHA_EXPED", nullable = false)
    public Date getPccFechaExped() {
        return pccFechaExped;
    }

    public void setPccFechaExped(Date pccFechaExped) {
        this.pccFechaExped = pccFechaExped;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PCC_FECHA_RECEP", nullable = false)
    public Date getPccFechaRecep() {
        return pccFechaRecep;
    }

    public void setPccFechaRecep(Date pccFechaRecep) {
        this.pccFechaRecep = pccFechaRecep;
    }

    @Column(name = "PCC_NUMERO", nullable = false, length = 30)
    public String getPccNumero() {
        return pccNumero;
    }

    public void setPccNumero(String pccNumero) {
        this.pccNumero = pccNumero;
    }

    @Column(name = "PCC_OBSERVACIONES", length = 200)
    public String getPccObservaciones() {
        return pccObservaciones;
    }

    public void setPccObservaciones(String pccObservaciones) {
        this.pccObservaciones = pccObservaciones;
    }

    @ManyToOne
    @JoinColumn(name = "ASE_CODIGO")
    public SiiAseguradora getSiiAseguradora() {
        return siiAseguradora;
    }

    public void setSiiAseguradora(SiiAseguradora siiAseguradora) {
        this.siiAseguradora = siiAseguradora;
    }

    @OneToMany(mappedBy = "siiPolizaContrat")
    public List<SiiPolizaRequisitosPol> getSiiPolizaRequisitosPolList() {
        return siiPolizaRequisitosPolList;
    }

    public void setSiiPolizaRequisitosPolList(List<SiiPolizaRequisitosPol> siiPolizaRequisitosPolList) {
        this.siiPolizaRequisitosPolList = siiPolizaRequisitosPolList;
    }

    public SiiPolizaRequisitosPol addSiiPolizaRequisitosPol(SiiPolizaRequisitosPol siiPolizaRequisitosPol) {
        getSiiPolizaRequisitosPolList().add(siiPolizaRequisitosPol);
        siiPolizaRequisitosPol.setSiiPolizaContrat(this);
        return siiPolizaRequisitosPol;
    }

    public SiiPolizaRequisitosPol removeSiiPolizaRequisitosPol(SiiPolizaRequisitosPol siiPolizaRequisitosPol) {
        getSiiPolizaRequisitosPolList().remove(siiPolizaRequisitosPol);
        siiPolizaRequisitosPol.setSiiPolizaContrat(null);
        return siiPolizaRequisitosPol;
    }

    @ManyToOne
    @JoinColumn(name = "EPO_CODIGO")
    public SiiEstadoPolizaCont getSiiEstadoPolizaCont() {
        return siiEstadoPolizaCont;
    }

    public void setSiiEstadoPolizaCont(SiiEstadoPolizaCont siiEstadoPolizaCont) {
        this.siiEstadoPolizaCont = siiEstadoPolizaCont;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @OneToMany(mappedBy = "siiPolizaContrat")
    public List<SiiGarantiaPoliza> getSiiGarantiaPolizaList1() {
        return siiGarantiaPolizaList1;
    }

    public void setSiiGarantiaPolizaList1(List<SiiGarantiaPoliza> siiGarantiaPolizaList1) {
        this.siiGarantiaPolizaList1 = siiGarantiaPolizaList1;
    }

    public SiiGarantiaPoliza addSiiGarantiaPoliza(SiiGarantiaPoliza siiGarantiaPoliza) {
        getSiiGarantiaPolizaList1().add(siiGarantiaPoliza);
        siiGarantiaPoliza.setSiiPolizaContrat(this);
        return siiGarantiaPoliza;
    }

    public SiiGarantiaPoliza removeSiiGarantiaPoliza(SiiGarantiaPoliza siiGarantiaPoliza) {
        getSiiGarantiaPolizaList1().remove(siiGarantiaPoliza);
        siiGarantiaPoliza.setSiiPolizaContrat(null);
        return siiGarantiaPoliza;
    }

    @OneToMany(mappedBy = "siiPolizaContrat")
    public List<SiiOficInfPoliza> getSiiOficInfPolizaList1() {
        return siiOficInfPolizaList1;
    }

    public void setSiiOficInfPolizaList1(List<SiiOficInfPoliza> siiOficInfPolizaList1) {
        this.siiOficInfPolizaList1 = siiOficInfPolizaList1;
    }

    public SiiOficInfPoliza addSiiOficInfPoliza(SiiOficInfPoliza siiOficInfPoliza) {
        getSiiOficInfPolizaList1().add(siiOficInfPoliza);
        siiOficInfPoliza.setSiiPolizaContrat(this);
        return siiOficInfPoliza;
    }

    public SiiOficInfPoliza removeSiiOficInfPoliza(SiiOficInfPoliza siiOficInfPoliza) {
        getSiiOficInfPolizaList1().remove(siiOficInfPoliza);
        siiOficInfPoliza.setSiiPolizaContrat(null);
        return siiOficInfPoliza;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }

    @Column(name = "PCC_CONTRATO_NUE", length = 1)
    public String getPccContratoNue() {
        return pccContratoNue;
    }

    public void setPccContratoNue(String pccContratoNue) {
        this.pccContratoNue = pccContratoNue;
    }

    @ManyToOne
    @JoinColumn(name = "TPC_CODIGO")
    public SiiTipoPolizaContr getSiiTipoPolizaContr() {
        return siiTipoPolizaContr;
    }

    public void setSiiTipoPolizaContr(SiiTipoPolizaContr siiTipoPolizaContr) {
        this.siiTipoPolizaContr = siiTipoPolizaContr;
    }

    @ManyToOne
    @JoinColumn(name = "OSI_CODIGO")
    public SiiOtrosi getSiiOtrosi() {
        return siiOtrosi;
    }

    public void setSiiOtrosi(SiiOtrosi siiOtrosi) {
        this.siiOtrosi = siiOtrosi;
    }

    @Column(name = "PCC_RENOVACION", length = 1)
    public String getPccRenovacion() {
        return pccRenovacion;
    }

    public void setPccRenovacion(String pccRenovacion) {
        this.pccRenovacion = pccRenovacion;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PCC_FECHA_APROBAC", nullable = true)
    public Date getPccFechaAprobac() {
        return pccFechaAprobac;
    }
    
    public void setPccFechaAprobac(Date pccFechaAprobac) {
        this.pccFechaAprobac = pccFechaAprobac;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PCC_FECHA_INI_OPERA", nullable = true)
    public Date getPccFechaIniOpera() {
        return pccFechaIniOpera;
    }
    
    public void setPccFechaIniOpera(Date pccFechaIniOpera) {
        this.pccFechaIniOpera = pccFechaIniOpera;
    }

    @Column(name = "PCC_RADICADO", length = 30)
    public String getPccRadicado() {
        return pccRadicado;
    }

    public void setPccRadicado(String pccRadicado) {
        this.pccRadicado = pccRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PCC_FECHA_RADICADO", nullable = true)
    public Date getPccFechaRadicado() {
        return pccFechaRadicado;
    }

    public void setPccFechaRadicado(Date pccFechaRadicado) {
        this.pccFechaRadicado = pccFechaRadicado;
    }
    
    @OneToMany(mappedBy = "siiPolizaContrat")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiPolizaContrat(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiPolizaContrat(null);
        return siiDocumentoContable;
    }

    @OneToMany(mappedBy = "siiPolizaContrat")
    public List<SiiTipoApuestPolizaRenovac> getSiiTipoApuestPolizaRenovacList() {
        return siiTipoApuestPolizaRenovacList;
    }

    public void setSiiTipoApuestPolizaRenovacList(List<SiiTipoApuestPolizaRenovac> siiTipoApuestPolizaRenovacList) {
        this.siiTipoApuestPolizaRenovacList = siiTipoApuestPolizaRenovacList;
    }

    public SiiTipoApuestPolizaRenovac addSiiTipoApuestPolizaRenovac(SiiTipoApuestPolizaRenovac siiTipoApuestPolizaRenovac) {
        getSiiTipoApuestPolizaRenovacList().add(siiTipoApuestPolizaRenovac);
        siiTipoApuestPolizaRenovac.setSiiPolizaContrat(this);
        return siiTipoApuestPolizaRenovac;
    }

    public SiiTipoApuestPolizaRenovac removeSiiTipoApuestPolizaRenovac(SiiTipoApuestPolizaRenovac siiTipoApuestPolizaRenovac) {
        getSiiTipoApuestPolizaRenovacList().remove(siiTipoApuestPolizaRenovac);
        siiTipoApuestPolizaRenovac.setSiiPolizaContrat(null);
        return siiTipoApuestPolizaRenovac;
    }

    @Column(name = "PCC_TIEMPO_EJEC_CON")
    public BigDecimal getPccTiempoEjecCon() {
        return pccTiempoEjecCon;
    }
    
    public void setPccTiempoEjecCon(BigDecimal pccTiempoEjecCon) {
        this.pccTiempoEjecCon = pccTiempoEjecCon;
    }
}
