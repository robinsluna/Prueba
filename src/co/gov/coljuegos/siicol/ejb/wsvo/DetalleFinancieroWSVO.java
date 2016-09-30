package co.gov.coljuegos.siicol.ejb.wsvo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMoneda;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class DetalleFinancieroWSVO implements Serializable {

    public BigDecimal dfiActivosTot;
    public Integer dfiAdqComprav;
    public Integer dfiAdqDonac;
    public Integer dfiAdqNoPoseeBien;
    public BigDecimal dfiAdqOtro;
    public String dfiAdqOtroCual;
    public Integer dfiCambiosDiv;
    public Long dfiCodigo;
    public BigDecimal dfiEgreNoOpe;
    public BigDecimal dfiEgresosMens;
    public Integer dfiExportaciones;
    public Integer dfiGiros;
    public Integer dfiImportaciones;
    public BigDecimal dfiIngrNoOper;
    public BigDecimal dfiIngresosMens;
    public Integer dfiInversiones;
    public Integer dfiOperacInt;
    public Integer dfiOrdenesPago;
    public String dfiOriCual;
    public Integer dfiOriFonNegocio;
    public Integer dfiOriFonSocios;
    public Integer dfiOriOtro;
    public BigDecimal dfiOtrosIngr;
    public BigDecimal dfiPasivosTot;
    public BigDecimal dfiPatrimonioTot;
    public Integer dfiPrestamosMe;
    public Integer dfiRemesas;
    public Integer dfiTransferencias;
    public Date dfiFechaFinCorte;
    public Date dfiFechaIniCorte;
    public BigDecimal dfiCostosGastosAdm;
    public BigDecimal dfiCapitalSocial;
    public BigDecimal dfiNivelEndeud;
    public BigDecimal dfiCapTrabReq;
    public BigDecimal dfiIndiceActTot;
    public BigDecimal dfiPatrimonReq;
    public Integer dfiCambioDivisa;

    public BigDecimal dfiCostGastAdmOpe;
    public BigDecimal dfiGastIntereses;
    public BigDecimal dfiGastFinancieros;
    public BigDecimal dfiUtilidadNeta;
    public BigDecimal dfiUtilidadOper;
    public BigDecimal dfiCapitalTrabajo;
    public BigDecimal dfiEbit;
    public BigDecimal dfiEbitda;
    public BigDecimal dfiRetornoActivos;
    public BigDecimal dfiGastFinEbit;
    public BigDecimal dfiGastFinEbitda;
    public BigDecimal dfiRazonEndeuda;
    public BigDecimal dfiActivoCorriente;
    public BigDecimal dfiPasivoCorriente;


    public DetalleFinancieroWSVO() {
    }
}
