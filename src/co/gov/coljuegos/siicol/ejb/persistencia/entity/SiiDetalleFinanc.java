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
@Table(name = "SII_DETALLE_FINANC")
public class SiiDetalleFinanc implements Serializable {
    private static final long serialVersionUID = 1720596367280499996L;
    private BigDecimal dfiActivosTot;
    private Integer dfiAdqComprav;
    private Integer dfiAdqDonac;
    private Integer dfiAdqNoPoseeBien;
    private BigDecimal dfiAdqOtro;
    private String dfiAdqOtroCual;
    private Integer dfiCambiosDiv;
    private Long dfiCodigo;
    private BigDecimal dfiEgreNoOpe;
    private BigDecimal dfiEgresosMens;
    private Integer dfiExportaciones;
    private Integer dfiGiros;
    private Integer dfiImportaciones;
    private BigDecimal dfiIngrNoOper;
    private BigDecimal dfiIngresosMens;
    private Integer dfiInversiones;
    private Integer dfiOperacInt;
    private Integer dfiOrdenesPago;
    private String dfiOriCual;
    private Integer dfiOriFonNegocio;
    private Integer dfiOriFonSocios;
    private Integer dfiOriOtro;
    private BigDecimal dfiOtrosIngr;
    private BigDecimal dfiPasivosTot;
    private BigDecimal dfiPatrimonioTot;
    private Integer dfiPrestamosMe;
    private Integer dfiRemesas;
    private Integer dfiTransferencias;
    private SiiPersona siiPersona2;
    private SiiSolicitudAutoriza siiSolicitudAutoriza;
    private Date dfiFechaFinCorte;
    private Date dfiFechaIniCorte;
    private BigDecimal dfiCostosGastosAdm;
    private BigDecimal dfiCapitalSocial;
    private BigDecimal dfiNivelEndeud;
    private BigDecimal dfiCapTrabReq;
    private BigDecimal dfiIndiceActTot;
    private BigDecimal dfiPatrimonReq;
    private Integer dfiCambioDivisa;

    private BigDecimal dfiCostGastAdmOpe;
    private BigDecimal dfiGastIntereses;
    private BigDecimal dfiGastFinancieros;
    private BigDecimal dfiUtilidadNeta;
    private BigDecimal dfiUtilidadOper;
    private BigDecimal dfiCapitalTrabajo;
    private BigDecimal dfiEbit;
    private BigDecimal dfiEbitda;
    private BigDecimal dfiRetornoActivos;
    private BigDecimal dfiGastFinEbit;
    private BigDecimal dfiGastFinEbitda;
    private BigDecimal dfiRazonEndeuda;
    private BigDecimal dfiActivoCorriente;
    private BigDecimal dfiPasivoCorriente;
    private SiiMoneda siiMoneda;

    public SiiDetalleFinanc() {
    }

    public SiiDetalleFinanc(BigDecimal dfiActivosTot, Integer dfiAdqComprav, Integer dfiAdqDonac, Integer dfiAdqNoPoseeBien,
                            BigDecimal dfiAdqOtro, String dfiAdqOtroCual, Integer dfiCambiosDiv, Long dfiCodigo,
                            BigDecimal dfiEgresosMens, Integer dfiExportaciones, Integer dfiGiros, Integer dfiImportaciones,
                            BigDecimal dfiIngrNoOper, BigDecimal dfiIngresosMens, Integer dfiInversiones, Integer dfiOperacInt,
                            Integer dfiOrdenesPago, String dfiOriCual, Integer dfiOriFonNegocio, SiiSolicitudAutoriza siiSolicitudAutoriza,
                            Integer dfiOriFonSocios, Integer dfiOriOtro, BigDecimal dfiOtrosIngr, BigDecimal dfiPasivosTot,
                            BigDecimal dfiPatrimonioTot, Integer dfiPrestamosMe, Integer dfiRemesas,Date dfiFechaFinCorte,
                            Date dfiFechaIniCorte, Integer dfiTransferencias, SiiPersona siiPersona2, BigDecimal dfiEgreNoOpe,
                            BigDecimal dfiCostosGastosAdm, BigDecimal dfiCapitalSocial, BigDecimal dfiNivelEndeud,
                            BigDecimal dfiCapTrabReq, BigDecimal dfiIndiceActTot, BigDecimal dfiPatrimonReq, Integer dfiCambioDivisa) {
        this.dfiActivosTot = dfiActivosTot;
        this.dfiAdqComprav = dfiAdqComprav;
        this.dfiAdqDonac = dfiAdqDonac;
        this.dfiAdqNoPoseeBien = dfiAdqNoPoseeBien;
        this.dfiAdqOtro = dfiAdqOtro;
        this.dfiAdqOtroCual = dfiAdqOtroCual;
        this.dfiCambiosDiv = dfiCambiosDiv;
        this.dfiCodigo = dfiCodigo;
        this.dfiEgreNoOpe = dfiEgreNoOpe;
        this.dfiEgresosMens = dfiEgresosMens;
        this.dfiExportaciones = dfiExportaciones;
        this.dfiFechaFinCorte = dfiFechaFinCorte;
        this.dfiFechaIniCorte = dfiFechaIniCorte;
        this.dfiGiros = dfiGiros;
        this.dfiImportaciones = dfiImportaciones;
        this.dfiIngrNoOper = dfiIngrNoOper;
        this.dfiIngresosMens = dfiIngresosMens;
        this.dfiInversiones = dfiInversiones;
        this.dfiOperacInt = dfiOperacInt;
        this.dfiOrdenesPago = dfiOrdenesPago;
        this.dfiOriCual = dfiOriCual;
        this.dfiOriFonNegocio = dfiOriFonNegocio;
        this.dfiOriFonSocios = dfiOriFonSocios;
        this.dfiOriOtro = dfiOriOtro;
        this.dfiOtrosIngr = dfiOtrosIngr;
        this.dfiPasivosTot = dfiPasivosTot;
        this.dfiPatrimonioTot = dfiPatrimonioTot;
        this.dfiPrestamosMe = dfiPrestamosMe;
        this.dfiRemesas = dfiRemesas;
        this.dfiTransferencias = dfiTransferencias;
        this.siiPersona2 = siiPersona2;
        this.siiSolicitudAutoriza = siiSolicitudAutoriza;
        this.dfiFechaFinCorte = dfiFechaFinCorte;
        this.dfiFechaIniCorte = dfiFechaIniCorte;
        this.dfiCostosGastosAdm = dfiCostosGastosAdm;
        this.dfiCapitalSocial = dfiCapitalSocial;
        this.dfiNivelEndeud = dfiNivelEndeud;
        this.dfiCapTrabReq = dfiCapTrabReq;
        this.dfiIndiceActTot = dfiIndiceActTot;
        this.dfiPatrimonReq = dfiPatrimonReq;
        this.dfiCambioDivisa = dfiCambioDivisa;

    }

    @Column(name = "DFI_ACTIVOS_TOT", nullable = false)
    public BigDecimal getDfiActivosTot() {
        return dfiActivosTot;
    }

    public void setDfiActivosTot(BigDecimal dfiActivosTot) {
        this.dfiActivosTot = dfiActivosTot;
    }

    @Column(name = "DFI_ADQ_COMPRAV")
    public Integer getDfiAdqComprav() {
        return dfiAdqComprav;
    }

    public void setDfiAdqComprav(Integer dfiAdqComprav) {
        this.dfiAdqComprav = dfiAdqComprav;
    }

    @Column(name = "DFI_ADQ_DONAC")
    public Integer getDfiAdqDonac() {
        return dfiAdqDonac;
    }

    public void setDfiAdqDonac(Integer dfiAdqDonac) {
        this.dfiAdqDonac = dfiAdqDonac;
    }

    @Column(name = "DFI_ADQ_NO_POSEE_BIEN")
    public Integer getDfiAdqNoPoseeBien() {
        return dfiAdqNoPoseeBien;
    }

    public void setDfiAdqNoPoseeBien(Integer dfiAdqNoPoseeBien) {
        this.dfiAdqNoPoseeBien = dfiAdqNoPoseeBien;
    }

    @Column(name = "DFI_ADQ_OTRO")
    public BigDecimal getDfiAdqOtro() {
        return dfiAdqOtro;
    }

    public void setDfiAdqOtro(BigDecimal dfiAdqOtro) {
        this.dfiAdqOtro = dfiAdqOtro;
    }

    @Column(name = "DFI_ADQ_OTRO_CUAL", length = 1000)
    public String getDfiAdqOtroCual() {
        return dfiAdqOtroCual;
    }

    public void setDfiAdqOtroCual(String dfiAdqOtroCual) {
        this.dfiAdqOtroCual = dfiAdqOtroCual;
    }

    @Column(name = "DFI_CAMBIOS_DIV", nullable = false)
    public Integer getDfiCambiosDiv() {
        return dfiCambiosDiv;
    }

    public void setDfiCambiosDiv(Integer dfiCambiosDiv) {
        this.dfiCambiosDiv = dfiCambiosDiv;
    }

    @Column(name = "DFI_CAPITAL_TRABAJO")
    public BigDecimal getDfiCapitalTrabajo() {
        return dfiCapitalTrabajo;
    }

    public void setDfiCapitalTrabajo(BigDecimal dfiCapitalTrabajo) {
        this.dfiCapitalTrabajo = dfiCapitalTrabajo;
    }

    @Id
    @Column(name = "DFI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DETALLE_FINANC_COD")
    @SequenceGenerator(name = "SEQ_DETALLE_FINANC_COD", sequenceName = "SEQ_DETALLE_FINANC_COD",allocationSize=1)
    public Long getDfiCodigo() {
        return dfiCodigo;
    }

    public void setDfiCodigo(Long dfiCodigo) {
        this.dfiCodigo = dfiCodigo;
    }

    @Column(name = "DFI_COSTOS_GASTOS_ADM", nullable = false)
    public BigDecimal getDfiCostosGastosAdm() {
        return dfiCostosGastosAdm;
    }

    public void setDfiCostosGastosAdm(BigDecimal dfiCostosGastosAdm) {
        this.dfiCostosGastosAdm = dfiCostosGastosAdm;
    }

    @Column(name = "DFI_EBIT")
    public BigDecimal getDfiEbit() {
        return dfiEbit;
    }

    public void setDfiEbit(BigDecimal dfiEbit) {
        this.dfiEbit = dfiEbit;
    }

    @Column(name = "DFI_EBITDA")
    public BigDecimal getDfiEbitda() {
        return dfiEbitda;
    }

    public void setDfiEbitda(BigDecimal dfiEbitda) {
        this.dfiEbitda = dfiEbitda;
    }
    @Column(name = "DFI_EGRE_NO_OPE")
    public BigDecimal getDfiEgreNoOpe() {
        return dfiEgreNoOpe;
    }

    public void setDfiEgreNoOpe(BigDecimal dfiEgreNoOpe) {
        this.dfiEgreNoOpe = dfiEgreNoOpe;
    }

    @Column(name = "DFI_EGRESOS_MENS", nullable = false)
    public BigDecimal getDfiEgresosMens() {
        return dfiEgresosMens;
    }

    public void setDfiEgresosMens(BigDecimal dfiEgresosMens) {
        this.dfiEgresosMens = dfiEgresosMens;
    }

    @Column(name = "DFI_EXPORTACIONES", nullable = false)
    public Integer getDfiExportaciones() {
        return dfiExportaciones;
    }

    public void setDfiExportaciones(Integer dfiExportaciones) {
        this.dfiExportaciones = dfiExportaciones;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DFI_FECHA_FIN_CORTE", nullable = false)
    public Date getDfiFechaFinCorte() {
        return dfiFechaFinCorte;
    }

    public void setDfiFechaFinCorte(Date dfiFechaFinCorte) {
        this.dfiFechaFinCorte = dfiFechaFinCorte;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DFI_FECHA_INI_CORTE", nullable = false)
    public Date getDfiFechaIniCorte() {
        return dfiFechaIniCorte;
    }

    public void setDfiFechaIniCorte(Date dfiFechaIniCorte) {
        this.dfiFechaIniCorte = dfiFechaIniCorte;
    }

    @Column(name = "DFI_GIROS", nullable = false)
    public Integer getDfiGiros() {
        return dfiGiros;
    }

    @Column(name = "DFI_GAST_FINANCIEROS")
    public BigDecimal getDfiGastFinancieros() {
        return dfiGastFinancieros;
    }

    public void setDfiGastFinancieros(BigDecimal dfiGastFinancieros) {
        this.dfiGastFinancieros = dfiGastFinancieros;
    }

    @Column(name = "DFI_GAST_INTERESES")
    public BigDecimal getDfiGastIntereses() {
        return dfiGastIntereses;
    }

    public void setDfiGastIntereses(BigDecimal dfiGastIntereses) {
        this.dfiGastIntereses = dfiGastIntereses;
    }

    public void setDfiGiros(Integer dfiGiros) {
        this.dfiGiros = dfiGiros;
    }

    @Column(name = "DFI_IMPORTACIONES", nullable = false)
    public Integer getDfiImportaciones() {
        return dfiImportaciones;
    }

    public void setDfiImportaciones(Integer dfiImportaciones) {
        this.dfiImportaciones = dfiImportaciones;
    }

    @Column(name = "DFI_INGR_NO_OPER", nullable = false)
    public BigDecimal getDfiIngrNoOper() {
        return dfiIngrNoOper;
    }

    public void setDfiIngrNoOper(BigDecimal dfiIngrNoOper) {
        this.dfiIngrNoOper = dfiIngrNoOper;
    }

    @Column(name = "DFI_INGRESOS_MENS", nullable = false)
    public BigDecimal getDfiIngresosMens() {
        return dfiIngresosMens;
    }

    public void setDfiIngresosMens(BigDecimal dfiIngresosMens) {
        this.dfiIngresosMens = dfiIngresosMens;
    }

    @Column(name = "DFI_INVERSIONES", nullable = false)
    public Integer getDfiInversiones() {
        return dfiInversiones;
    }

    public void setDfiInversiones(Integer dfiInversiones) {
        this.dfiInversiones = dfiInversiones;
    }

    @Column(name = "DFI_NIVEL_ENDEUD", nullable = false)
    public BigDecimal getDfiNivelEndeud() {
        return dfiNivelEndeud;
    }

    public void setDfiNivelEndeud(BigDecimal dfiNivelEndeud) {
        this.dfiNivelEndeud = dfiNivelEndeud;
    }

    @Column(name = "DFI_OPERAC_INT", nullable = false)
    public Integer getDfiOperacInt() {
        return dfiOperacInt;
    }

    public void setDfiOperacInt(Integer dfiOperacInt) {
        this.dfiOperacInt = dfiOperacInt;
    }

    @Column(name = "DFI_ORDENES_PAGO", nullable = false)
    public Integer getDfiOrdenesPago() {
        return dfiOrdenesPago;
    }

    public void setDfiOrdenesPago(Integer dfiOrdenesPago) {
        this.dfiOrdenesPago = dfiOrdenesPago;
    }

    @Column(name = "DFI_ORI_CUAL", length = 1000)
    public String getDfiOriCual() {
        return dfiOriCual;
    }

    public void setDfiOriCual(String dfiOriCual) {
        this.dfiOriCual = dfiOriCual;
    }

    @Column(name = "DFI_ORI_FON_NEGOCIO")
    public Integer getDfiOriFonNegocio() {
        return dfiOriFonNegocio;
    }

    public void setDfiOriFonNegocio(Integer dfiOriFonNegocio) {
        this.dfiOriFonNegocio = dfiOriFonNegocio;
    }

    @Column(name = "DFI_ORI_FON_SOCIOS")
    public Integer getDfiOriFonSocios() {
        return dfiOriFonSocios;
    }

    public void setDfiOriFonSocios(Integer dfiOriFonSocios) {
        this.dfiOriFonSocios = dfiOriFonSocios;
    }

    @Column(name = "DFI_ORI_OTRO")
    public Integer getDfiOriOtro() {
        return dfiOriOtro;
    }

    public void setDfiOriOtro(Integer dfiOriOtro) {
        this.dfiOriOtro = dfiOriOtro;
    }

    @Column(name = "DFI_OTROS_INGR", nullable = false)
    public BigDecimal getDfiOtrosIngr() {
        return dfiOtrosIngr;
    }

    public void setDfiOtrosIngr(BigDecimal dfiOtrosIngr) {
        this.dfiOtrosIngr = dfiOtrosIngr;
    }

    @Column(name = "DFI_PASIVOS_TOT", nullable = false)
    public BigDecimal getDfiPasivosTot() {
        return dfiPasivosTot;
    }

    public void setDfiPasivosTot(BigDecimal dfiPasivosTot) {
        this.dfiPasivosTot = dfiPasivosTot;
    }

    @Column(name = "DFI_RAZON_ENDEUDA")
    public BigDecimal getDfiRazonEndeuda() {
        return dfiRazonEndeuda;
    }

    public void setDfiRazonEndeuda(BigDecimal dfiRazonEndeuda) {
        this.dfiRazonEndeuda = dfiRazonEndeuda;
    }

    @Column(name = "DFI_PATRIMONIO_TOT", nullable = false)
    public BigDecimal getDfiPatrimonioTot() {
        return dfiPatrimonioTot;
    }

    public void setDfiPatrimonioTot(BigDecimal dfiPatrimonioTot) {
        this.dfiPatrimonioTot = dfiPatrimonioTot;
    }

    @Column(name = "DFI_PRESTAMOS_ME", nullable = false)
    public Integer getDfiPrestamosMe() {
        return dfiPrestamosMe;
    }

    public void setDfiPrestamosMe(Integer dfiPrestamosMe) {
        this.dfiPrestamosMe = dfiPrestamosMe;
    }

    @Column(name = "DFI_REMESAS", nullable = false)
    public Integer getDfiRemesas() {
        return dfiRemesas;
    }

    public void setDfiRemesas(Integer dfiRemesas) {
        this.dfiRemesas = dfiRemesas;
    }

    @Column(name = "DFI_TRANSFERENCIAS", nullable = false)
    public Integer getDfiTransferencias() {
        return dfiTransferencias;
    }

    public void setDfiTransferencias(Integer dfiTransferencias) {
        this.dfiTransferencias = dfiTransferencias;
    }


    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona2() {
        return siiPersona2;
    }

    public void setSiiPersona2(SiiPersona siiPersona2) {
        this.siiPersona2 = siiPersona2;
    }

    @ManyToOne
    @JoinColumn(name = "SAU_CODIGO")
    public SiiSolicitudAutoriza getSiiSolicitudAutoriza() {
        return siiSolicitudAutoriza;
    }

    public void setSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        this.siiSolicitudAutoriza = siiSolicitudAutoriza;
    }

    @Column(name = "DFI_CAPITAL_SOCIAL", nullable = false)
    public BigDecimal getDfiCapitalSocial() {
        return dfiCapitalSocial;
    }

    public void setDfiCapitalSocial(BigDecimal dfiCapitalSocial) {
        this.dfiCapitalSocial = dfiCapitalSocial;
    }

    @Column(name = "DFI_CAP_TRAB_REQ", nullable = false)
    public BigDecimal getDfiCapTrabReq() {
        return dfiCapTrabReq;
    }

    public void setDfiCapTrabReq(BigDecimal dfiCapTrabReq) {
        this.dfiCapTrabReq = dfiCapTrabReq;
    }

    @Column(name = "DFI_INDICE_ACT_TOT", nullable = false)
    public BigDecimal getDfiIndiceActTot() {
        return dfiIndiceActTot;
    }

    public void setDfiIndiceActTot(BigDecimal dfiIndiceActTot) {
        this.dfiIndiceActTot = dfiIndiceActTot;
    }

    @Column(name = "DFI_PATRIMON_REQ", nullable = false)
    public BigDecimal getDfiPatrimonReq() {
        return dfiPatrimonReq;
    }

    public void setDfiPatrimonReq(BigDecimal dfiPatrimonReq) {
        this.dfiPatrimonReq = dfiPatrimonReq;
    }

    @Column(name = "DFI_RETORNO_ACTIVOS")
    public BigDecimal getDfiRetornoActivos() {
        return dfiRetornoActivos;
    }

    public void setDfiRetornoActivos(BigDecimal dfiRetornoActivos) {
        this.dfiRetornoActivos = dfiRetornoActivos;
    }


    @Column(name = "DFI_CAMBIO_DIVISA", nullable = false)
    public Integer getDfiCambioDivisa() {
        return dfiCambioDivisa;
    }

    public void setDfiCambioDivisa(Integer dfiCambioDivisa) {
        this.dfiCambioDivisa = dfiCambioDivisa;
    }

    @Column(name = "DFI_UTILIDAD_NETA")
    public BigDecimal getDfiUtilidadNeta() {
        return dfiUtilidadNeta;
    }

    public void setDfiUtilidadNeta(BigDecimal dfiUtilidadNeta) {
        this.dfiUtilidadNeta = dfiUtilidadNeta;
    }

    @Column(name = "DFI_UTILIDAD_OPER")
    public BigDecimal getDfiUtilidadOper() {
        return dfiUtilidadOper;
    }

    public void setDfiUtilidadOper(BigDecimal dfiUtilidadOper) {
        this.dfiUtilidadOper = dfiUtilidadOper;
    }

    @Column(name = "DFI_GAST_FIN_EBIT")
    public BigDecimal getDfiGastFinEbit() {
        return dfiGastFinEbit;
    }

    public void setDfiGastFinEbit(BigDecimal dfiGastFinEbit) {
        this.dfiGastFinEbit = dfiGastFinEbit;
    }

    @Column(name = "DFI_GAST_FIN_EBITDA")
    public BigDecimal getDfiGastFinEbitda() {
        return dfiGastFinEbitda;
    }

    public void setDfiGastFinEbitda(BigDecimal dfiGastFinEbitda) {
        this.dfiGastFinEbitda = dfiGastFinEbitda;
    }

    @Column(name = "DFI_COST_GAST_ADM_OPE")
    public BigDecimal getDfiCostGastAdmOpe() {
        return dfiCostGastAdmOpe;
    }

    public void setDfiCostGastAdmOpe(BigDecimal dfiCostGastAdmOpe) {
        this.dfiCostGastAdmOpe = dfiCostGastAdmOpe;
    }

    @Column(name = "DFI_ACTIVO_CORRIENTE")
    public BigDecimal getDfiActivoCorriente() {
        return dfiActivoCorriente;
    }

    public void setDfiActivoCorriente(BigDecimal dfiActivoCorriente) {
        this.dfiActivoCorriente = dfiActivoCorriente;
    }

    @Column(name = "DFI_PASIVO_CORRIENTE")
    public BigDecimal getDfiPasivoCorriente() {
        return dfiPasivoCorriente;
    }

    public void setDfiPasivoCorriente(BigDecimal dfiPasivoCorriente) {
        this.dfiPasivoCorriente = dfiPasivoCorriente;
    }

    @ManyToOne
    @JoinColumn(name = "MON_CODIGO")
    public SiiMoneda getSiiMoneda() {
        return siiMoneda;
    }

    public void setSiiMoneda(SiiMoneda siiMoneda) {
        this.siiMoneda = siiMoneda;
    }
}
