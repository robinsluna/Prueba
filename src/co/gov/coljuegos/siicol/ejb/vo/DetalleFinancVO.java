package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMoneda;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;

import java.math.BigDecimal;

import java.util.Date;

public class DetalleFinancVO {

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
    private PersonaVO personaVo;
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
    private MonedaVO monedaVO;

    public DetalleFinancVO() {
        this.monedaVO = new MonedaVO();
    }

    public DetalleFinancVO(SiiDetalleFinanc siiDetalleFinanc) {
        this.dfiActivosTot = siiDetalleFinanc.getDfiActivosTot();
        this.dfiAdqComprav = siiDetalleFinanc.getDfiAdqComprav();
        this.dfiAdqDonac = siiDetalleFinanc.getDfiAdqDonac();
        this.dfiAdqNoPoseeBien = siiDetalleFinanc.getDfiAdqNoPoseeBien();
        this.dfiAdqOtro = siiDetalleFinanc.getDfiAdqOtro();
        this.dfiAdqOtroCual = siiDetalleFinanc.getDfiAdqOtroCual();
        this.dfiCambiosDiv = siiDetalleFinanc.getDfiCambiosDiv();
        this.dfiCodigo = siiDetalleFinanc.getDfiCodigo();
        this.dfiEgreNoOpe = siiDetalleFinanc.getDfiEgreNoOpe();
        this.dfiEgresosMens = siiDetalleFinanc.getDfiEgresosMens();
        this.dfiExportaciones = siiDetalleFinanc.getDfiExportaciones();
        this.dfiGiros = siiDetalleFinanc.getDfiGiros();
        this.dfiImportaciones = siiDetalleFinanc.getDfiImportaciones();
        this.dfiIngrNoOper = siiDetalleFinanc.getDfiIngrNoOper();
        this.dfiIngresosMens = siiDetalleFinanc.getDfiIngresosMens();
        this.dfiInversiones = siiDetalleFinanc.getDfiInversiones();
        this.dfiOperacInt = siiDetalleFinanc.getDfiOperacInt();
        this.dfiOrdenesPago = siiDetalleFinanc.getDfiOrdenesPago();
        this.dfiOriCual = siiDetalleFinanc.getDfiOriCual();
        this.dfiOriFonNegocio = siiDetalleFinanc.getDfiOriFonNegocio();
        this.dfiOriFonSocios = siiDetalleFinanc.getDfiOriFonSocios();
        this.dfiOriOtro = siiDetalleFinanc.getDfiOriOtro();
        this.dfiOtrosIngr = siiDetalleFinanc.getDfiOtrosIngr();
        this.dfiPasivosTot = siiDetalleFinanc.getDfiPasivosTot();
        this.dfiPatrimonioTot = siiDetalleFinanc.getDfiPatrimonioTot();
        this.dfiPrestamosMe = siiDetalleFinanc.getDfiPrestamosMe();
        this.dfiRemesas = siiDetalleFinanc.getDfiRemesas();
        this.dfiTransferencias = siiDetalleFinanc.getDfiTransferencias();

        //Persona
        if (siiDetalleFinanc.getSiiPersona2() != null) {
            this.personaVo = new PersonaVO(siiDetalleFinanc.getSiiPersona2());
        }

        this.dfiFechaFinCorte = siiDetalleFinanc.getDfiFechaFinCorte();
        this.dfiFechaIniCorte = siiDetalleFinanc.getDfiFechaIniCorte();
        this.dfiCostosGastosAdm = siiDetalleFinanc.getDfiCostosGastosAdm();
        this.dfiCapitalSocial = siiDetalleFinanc.getDfiCapitalSocial();
        this.dfiNivelEndeud = siiDetalleFinanc.getDfiNivelEndeud();
        this.dfiCapTrabReq = siiDetalleFinanc.getDfiCapTrabReq();
        this.dfiIndiceActTot = siiDetalleFinanc.getDfiIndiceActTot();
        this.dfiPatrimonReq = siiDetalleFinanc.getDfiPatrimonReq();
        this.dfiCambioDivisa = siiDetalleFinanc.getDfiCambioDivisa();

        this.dfiCostGastAdmOpe = siiDetalleFinanc.getDfiCostGastAdmOpe();
        this.dfiGastIntereses = siiDetalleFinanc.getDfiGastIntereses();
        this.dfiGastFinancieros = siiDetalleFinanc.getDfiGastFinancieros();
        this.dfiUtilidadNeta = siiDetalleFinanc.getDfiUtilidadNeta();
        this.dfiUtilidadOper = siiDetalleFinanc.getDfiUtilidadOper();
        this.dfiCapitalTrabajo = siiDetalleFinanc.getDfiCapitalTrabajo();
        this.dfiEbit = siiDetalleFinanc.getDfiEbit();
        this.dfiEbitda = siiDetalleFinanc.getDfiEbitda();
        this.dfiRetornoActivos = siiDetalleFinanc.getDfiRetornoActivos();
        this.dfiGastFinEbit = siiDetalleFinanc.getDfiGastFinEbit();
        this.dfiGastFinEbitda = siiDetalleFinanc.getDfiGastFinEbitda();
        this.dfiRazonEndeuda = siiDetalleFinanc.getDfiRazonEndeuda();
        this.dfiActivoCorriente = siiDetalleFinanc.getDfiActivoCorriente();
        this.dfiPasivoCorriente = siiDetalleFinanc.getDfiPasivoCorriente();

        //Moneda
        if (siiDetalleFinanc.getSiiMoneda() != null && siiDetalleFinanc.getSiiMoneda().getMonCodigo() != null &&
            siiDetalleFinanc.getSiiMoneda().getMonCodigo() > 0) {
            this.monedaVO = new MonedaVO();
            this.monedaVO.setMonCodigo(siiDetalleFinanc.getSiiMoneda().getMonCodigo());
        }
    }


    public BigDecimal getDfiActivosTot() {
        return dfiActivosTot;
    }

    public void setDfiActivosTot(BigDecimal dfiActivosTot) {
        this.dfiActivosTot = dfiActivosTot;
    }

    public Integer getDfiAdqComprav() {
        return dfiAdqComprav;
    }

    public void setDfiAdqComprav(Integer dfiAdqComprav) {
        this.dfiAdqComprav = dfiAdqComprav;
    }

    public Integer getDfiAdqDonac() {
        return dfiAdqDonac;
    }

    public void setDfiAdqDonac(Integer dfiAdqDonac) {
        this.dfiAdqDonac = dfiAdqDonac;
    }

    public Integer getDfiAdqNoPoseeBien() {
        return dfiAdqNoPoseeBien;
    }

    public void setDfiAdqNoPoseeBien(Integer dfiAdqNoPoseeBien) {
        this.dfiAdqNoPoseeBien = dfiAdqNoPoseeBien;
    }

    public BigDecimal getDfiAdqOtro() {
        return dfiAdqOtro;
    }

    public void setDfiAdqOtro(BigDecimal dfiAdqOtro) {
        this.dfiAdqOtro = dfiAdqOtro;
    }

    public String getDfiAdqOtroCual() {
        return dfiAdqOtroCual;
    }

    public void setDfiAdqOtroCual(String dfiAdqOtroCual) {
        this.dfiAdqOtroCual = dfiAdqOtroCual;
    }

    public Integer getDfiCambiosDiv() {
        return dfiCambiosDiv;
    }

    public void setDfiCambiosDiv(Integer dfiCambiosDiv) {
        this.dfiCambiosDiv = dfiCambiosDiv;
    }

    public Long getDfiCodigo() {
        return dfiCodigo;
    }

    public void setDfiCodigo(Long dfiCodigo) {
        this.dfiCodigo = dfiCodigo;
    }

    public BigDecimal getDfiEgreNoOpe() {
        return dfiEgreNoOpe;
    }

    public void setDfiEgreNoOpe(BigDecimal dfiEgreNoOpe) {
        this.dfiEgreNoOpe = dfiEgreNoOpe;
    }

    public BigDecimal getDfiEgresosMens() {
        return dfiEgresosMens;
    }

    public void setDfiEgresosMens(BigDecimal dfiEgresosMens) {
        this.dfiEgresosMens = dfiEgresosMens;
    }

    public Integer getDfiExportaciones() {
        return dfiExportaciones;
    }

    public void setDfiExportaciones(Integer dfiExportaciones) {
        this.dfiExportaciones = dfiExportaciones;
    }

    public Integer getDfiGiros() {
        return dfiGiros;
    }

    public void setDfiGiros(Integer dfiGiros) {
        this.dfiGiros = dfiGiros;
    }

    public Integer getDfiImportaciones() {
        return dfiImportaciones;
    }

    public void setDfiImportaciones(Integer dfiImportaciones) {
        this.dfiImportaciones = dfiImportaciones;
    }

    public BigDecimal getDfiIngrNoOper() {
        return dfiIngrNoOper;
    }

    public void setDfiIngrNoOper(BigDecimal dfiIngrNoOper) {
        this.dfiIngrNoOper = dfiIngrNoOper;
    }

    public BigDecimal getDfiIngresosMens() {
        return dfiIngresosMens;
    }

    public void setDfiIngresosMens(BigDecimal dfiIngresosMens) {
        this.dfiIngresosMens = dfiIngresosMens;
    }

    public Integer getDfiInversiones() {
        return dfiInversiones;
    }

    public void setDfiInversiones(Integer dfiInversiones) {
        this.dfiInversiones = dfiInversiones;
    }

    public Integer getDfiOperacInt() {
        return dfiOperacInt;
    }

    public void setDfiOperacInt(Integer dfiOperacInt) {
        this.dfiOperacInt = dfiOperacInt;
    }

    public Integer getDfiOrdenesPago() {
        return dfiOrdenesPago;
    }

    public void setDfiOrdenesPago(Integer dfiOrdenesPago) {
        this.dfiOrdenesPago = dfiOrdenesPago;
    }

    public String getDfiOriCual() {
        return dfiOriCual;
    }

    public void setDfiOriCual(String dfiOriCual) {
        this.dfiOriCual = dfiOriCual;
    }

    public Integer getDfiOriFonNegocio() {
        return dfiOriFonNegocio;
    }

    public void setDfiOriFonNegocio(Integer dfiOriFonNegocio) {
        this.dfiOriFonNegocio = dfiOriFonNegocio;
    }

    public Integer getDfiOriFonSocios() {
        return dfiOriFonSocios;
    }

    public void setDfiOriFonSocios(Integer dfiOriFonSocios) {
        this.dfiOriFonSocios = dfiOriFonSocios;
    }

    public Integer getDfiOriOtro() {
        return dfiOriOtro;
    }

    public void setDfiOriOtro(Integer dfiOriOtro) {
        this.dfiOriOtro = dfiOriOtro;
    }

    public BigDecimal getDfiOtrosIngr() {
        return dfiOtrosIngr;
    }

    public void setDfiOtrosIngr(BigDecimal dfiOtrosIngr) {
        this.dfiOtrosIngr = dfiOtrosIngr;
    }

    public BigDecimal getDfiPasivosTot() {
        return dfiPasivosTot;
    }

    public void setDfiPasivosTot(BigDecimal dfiPasivosTot) {
        this.dfiPasivosTot = dfiPasivosTot;
    }

    public BigDecimal getDfiPatrimonioTot() {
        return dfiPatrimonioTot;
    }

    public void setDfiPatrimonioTot(BigDecimal dfiPatrimonioTot) {
        this.dfiPatrimonioTot = dfiPatrimonioTot;
    }

    public Integer getDfiPrestamosMe() {
        return dfiPrestamosMe;
    }

    public void setDfiPrestamosMe(Integer dfiPrestamosMe) {
        this.dfiPrestamosMe = dfiPrestamosMe;
    }

    public Integer getDfiRemesas() {
        return dfiRemesas;
    }

    public void setDfiRemesas(Integer dfiRemesas) {
        this.dfiRemesas = dfiRemesas;
    }

    public Integer getDfiTransferencias() {
        return dfiTransferencias;
    }

    public void setDfiTransferencias(Integer dfiTransferencias) {
        this.dfiTransferencias = dfiTransferencias;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public SiiSolicitudAutoriza getSiiSolicitudAutoriza() {
        return siiSolicitudAutoriza;
    }

    public void setSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        this.siiSolicitudAutoriza = siiSolicitudAutoriza;
    }

    public Date getDfiFechaFinCorte() {
        return dfiFechaFinCorte;
    }

    public void setDfiFechaFinCorte(Date dfiFechaFinCorte) {
        this.dfiFechaFinCorte = dfiFechaFinCorte;
    }

    public Date getDfiFechaIniCorte() {
        return dfiFechaIniCorte;
    }

    public void setDfiFechaIniCorte(Date dfiFechaIniCorte) {
        this.dfiFechaIniCorte = dfiFechaIniCorte;
    }

    public BigDecimal getDfiCostosGastosAdm() {
        return dfiCostosGastosAdm;
    }

    public void setDfiCostosGastosAdm(BigDecimal dfiCostosGastosAdm) {
        this.dfiCostosGastosAdm = dfiCostosGastosAdm;
    }

    public BigDecimal getDfiCapitalSocial() {
        return dfiCapitalSocial;
    }

    public void setDfiCapitalSocial(BigDecimal dfiCapitalSocial) {
        this.dfiCapitalSocial = dfiCapitalSocial;
    }

    public BigDecimal getDfiNivelEndeud() {
        return dfiNivelEndeud;
    }

    public void setDfiNivelEndeud(BigDecimal dfiNivelEndeud) {
        this.dfiNivelEndeud = dfiNivelEndeud;
    }

    public BigDecimal getDfiCapTrabReq() {
        return dfiCapTrabReq;
    }

    public void setDfiCapTrabReq(BigDecimal dfiCapTrabReq) {
        this.dfiCapTrabReq = dfiCapTrabReq;
    }

    public BigDecimal getDfiIndiceActTot() {
        return dfiIndiceActTot;
    }

    public void setDfiIndiceActTot(BigDecimal dfiIndiceActTot) {
        this.dfiIndiceActTot = dfiIndiceActTot;
    }

    public BigDecimal getDfiPatrimonReq() {
        return dfiPatrimonReq;
    }

    public void setDfiPatrimonReq(BigDecimal dfiPatrimonReq) {
        this.dfiPatrimonReq = dfiPatrimonReq;
    }

    public Integer getDfiCambioDivisa() {
        return dfiCambioDivisa;
    }

    public void setDfiCambioDivisa(Integer dfiCambioDivisa) {
        this.dfiCambioDivisa = dfiCambioDivisa;
    }

    public BigDecimal getDfiCostGastAdmOpe() {
        return dfiCostGastAdmOpe;
    }

    public void setDfiCostGastAdmOpe(BigDecimal dfiCostGastAdmOpe) {
        this.dfiCostGastAdmOpe = dfiCostGastAdmOpe;
    }

    public BigDecimal getDfiGastIntereses() {
        return dfiGastIntereses;
    }

    public void setDfiGastIntereses(BigDecimal dfiGastIntereses) {
        this.dfiGastIntereses = dfiGastIntereses;
    }

    public BigDecimal getDfiGastFinancieros() {
        return dfiGastFinancieros;
    }

    public void setDfiGastFinancieros(BigDecimal dfiGastFinancieros) {
        this.dfiGastFinancieros = dfiGastFinancieros;
    }

    public BigDecimal getDfiUtilidadNeta() {
        return dfiUtilidadNeta;
    }

    public void setDfiUtilidadNeta(BigDecimal dfiUtilidadNeta) {
        this.dfiUtilidadNeta = dfiUtilidadNeta;
    }

    public BigDecimal getDfiUtilidadOper() {
        return dfiUtilidadOper;
    }

    public void setDfiUtilidadOper(BigDecimal dfiUtilidadOper) {
        this.dfiUtilidadOper = dfiUtilidadOper;
    }

    public BigDecimal getDfiCapitalTrabajo() {
        return dfiCapitalTrabajo;
    }

    public void setDfiCapitalTrabajo(BigDecimal dfiCapitalTrabajo) {
        this.dfiCapitalTrabajo = dfiCapitalTrabajo;
    }

    public BigDecimal getDfiEbit() {
        return dfiEbit;
    }

    public void setDfiEbit(BigDecimal dfiEbit) {
        this.dfiEbit = dfiEbit;
    }

    public BigDecimal getDfiEbitda() {
        return dfiEbitda;
    }

    public void setDfiEbitda(BigDecimal dfiEbitda) {
        this.dfiEbitda = dfiEbitda;
    }

    public BigDecimal getDfiRetornoActivos() {
        return dfiRetornoActivos;
    }

    public void setDfiRetornoActivos(BigDecimal dfiRetornoActivos) {
        this.dfiRetornoActivos = dfiRetornoActivos;
    }

    public BigDecimal getDfiGastFinEbit() {
        return dfiGastFinEbit;
    }

    public void setDfiGastFinEbit(BigDecimal dfiGastFinEbit) {
        this.dfiGastFinEbit = dfiGastFinEbit;
    }

    public BigDecimal getDfiGastFinEbitda() {
        return dfiGastFinEbitda;
    }

    public void setDfiGastFinEbitda(BigDecimal dfiGastFinEbitda) {
        this.dfiGastFinEbitda = dfiGastFinEbitda;
    }

    public BigDecimal getDfiRazonEndeuda() {
        return dfiRazonEndeuda;
    }

    public void setDfiRazonEndeuda(BigDecimal dfiRazonEndeuda) {
        this.dfiRazonEndeuda = dfiRazonEndeuda;
    }

    public BigDecimal getDfiActivoCorriente() {
        return dfiActivoCorriente;
    }

    public void setDfiActivoCorriente(BigDecimal dfiActivoCorriente) {
        this.dfiActivoCorriente = dfiActivoCorriente;
    }

    public BigDecimal getDfiPasivoCorriente() {
        return dfiPasivoCorriente;
    }

    public void setDfiPasivoCorriente(BigDecimal dfiPasivoCorriente) {
        this.dfiPasivoCorriente = dfiPasivoCorriente;
    }

    public MonedaVO getMonedaVO() {
        return monedaVO;
    }

    public void setMonedaVO(MonedaVO monedaVO) {
        this.monedaVO = monedaVO;
    }
}
