package co.gov.coljuegos.siicol.ejb.persistencia.entity.siito;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SIITO_MOV_CARGUE_VENTAS")
public class SiitoMovCargueVentas implements Serializable {
    private static final long serialVersionUID = -389565286230942562L;
    private int movCarVentCantDiasReportados;
    private String movCarVentCodigoLocal;
    private String movCarVentContrato;
    private Timestamp movCarVentFechaSolicitud;
    private String movCarVentFechaVenta;
    private int movCarVentId;
    private int movCarVentModalidadJuego;
    private Long movCarVentMovSol;
    private String movCarVentNit;
    private Long movCarVentNuc;
    private String movCarVentNuid;
    private String movCarVentSerialMet;
    private int movCarVentTipoElementoVentas;
    private Long movCarVentValorTotalVentas;

    public SiitoMovCargueVentas() {
    }

    public SiitoMovCargueVentas(int movCarVentCantDiasReportados, String movCarVentCodigoLocal,
                                String movCarVentContrato, Timestamp movCarVentFechaSolicitud,
                                String movCarVentFechaVenta, int movCarVentId, int movCarVentModalidadJuego,
                                Long movCarVentMovSol, String movCarVentNit, Long movCarVentNuc, String movCarVentNuid,
                                String movCarVentSerialMet, int movCarVentTipoElementoVentas,
                                Long movCarVentValorTotalVentas) {
        this.movCarVentCantDiasReportados = movCarVentCantDiasReportados;
        this.movCarVentCodigoLocal = movCarVentCodigoLocal;
        this.movCarVentContrato = movCarVentContrato;
        this.movCarVentFechaSolicitud = movCarVentFechaSolicitud;
        this.movCarVentFechaVenta = movCarVentFechaVenta;
        this.movCarVentId = movCarVentId;
        this.movCarVentModalidadJuego = movCarVentModalidadJuego;
        this.movCarVentMovSol = movCarVentMovSol;
        this.movCarVentNit = movCarVentNit;
        this.movCarVentNuc = movCarVentNuc;
        this.movCarVentNuid = movCarVentNuid;
        this.movCarVentSerialMet = movCarVentSerialMet;
        this.movCarVentTipoElementoVentas = movCarVentTipoElementoVentas;
        this.movCarVentValorTotalVentas = movCarVentValorTotalVentas;
    }

    @Column(name = "MOV_CAR_VENT_CANT_DIAS_REPORTADOS", nullable = false)
    public int getMovCarVentCantDiasReportados() {
        return movCarVentCantDiasReportados;
    }

    public void setMovCarVentCantDiasReportados(int movCarVentCantDiasReportados) {
        this.movCarVentCantDiasReportados = movCarVentCantDiasReportados;
    }

    @Column(name = "MOV_CAR_VENT_CODIGO_LOCAL", nullable = false)
    public String getMovCarVentCodigoLocal() {
        return movCarVentCodigoLocal;
    }

    public void setMovCarVentCodigoLocal(String movCarVentCodigoLocal) {
        this.movCarVentCodigoLocal = movCarVentCodigoLocal;
    }

    @Column(name = "MOV_CAR_VENT_CONTRATO", nullable = false)
    public String getMovCarVentContrato() {
        return movCarVentContrato;
    }

    public void setMovCarVentContrato(String movCarVentContrato) {
        this.movCarVentContrato = movCarVentContrato;
    }

    @Column(name = "MOV_CAR_VENT_FECHA_SOLICITUD", nullable = false)
    public Timestamp getMovCarVentFechaSolicitud() {
        return movCarVentFechaSolicitud;
    }

    public void setMovCarVentFechaSolicitud(Timestamp movCarVentFechaSolicitud) {
        this.movCarVentFechaSolicitud = movCarVentFechaSolicitud;
    }

    @Column(name = "MOV_CAR_VENT_FECHA_VENTA", nullable = false)
    public String getMovCarVentFechaVenta() {
        return movCarVentFechaVenta;
    }

    public void setMovCarVentFechaVenta(String movCarVentFechaVenta) {
        this.movCarVentFechaVenta = movCarVentFechaVenta;
    }

    @Id
    @Column(name = "MOV_CAR_VENT_ID", nullable = false)
    public int getMovCarVentId() {
        return movCarVentId;
    }

    public void setMovCarVentId(int movCarVentId) {
        this.movCarVentId = movCarVentId;
    }

    @Column(name = "MOV_CAR_VENT_MODALIDAD_JUEGO", nullable = false)
    public int getMovCarVentModalidadJuego() {
        return movCarVentModalidadJuego;
    }

    public void setMovCarVentModalidadJuego(int movCarVentModalidadJuego) {
        this.movCarVentModalidadJuego = movCarVentModalidadJuego;
    }

    @Column(name = "MOV_CAR_VENT_MOV_SOL", nullable = false)
    public Long getMovCarVentMovSol() {
        return movCarVentMovSol;
    }

    public void setMovCarVentMovSol(Long movCarVentMovSol) {
        this.movCarVentMovSol = movCarVentMovSol;
    }

    @Column(name = "MOV_CAR_VENT_NIT", nullable = false)
    public String getMovCarVentNit() {
        return movCarVentNit;
    }

    public void setMovCarVentNit(String movCarVentNit) {
        this.movCarVentNit = movCarVentNit;
    }

    @Column(name = "MOV_CAR_VENT_NUC", nullable = false)
    public Long getMovCarVentNuc() {
        return movCarVentNuc;
    }

    public void setMovCarVentNuc(Long movCarVentNuc) {
        this.movCarVentNuc = movCarVentNuc;
    }

    @Column(name = "MOV_CAR_VENT_NUID", nullable = false)
    public String getMovCarVentNuid() {
        return movCarVentNuid;
    }

    public void setMovCarVentNuid(String movCarVentNuid) {
        this.movCarVentNuid = movCarVentNuid;
    }

    @Column(name = "MOV_CAR_VENT_SERIAL_MET", nullable = false)
    public String getMovCarVentSerialMet() {
        return movCarVentSerialMet;
    }

    public void setMovCarVentSerialMet(String movCarVentSerialMet) {
        this.movCarVentSerialMet = movCarVentSerialMet;
    }

    @Column(name = "MOV_CAR_VENT_TIPO_ELEMENTO_VENTAS", nullable = false)
    public int getMovCarVentTipoElementoVentas() {
        return movCarVentTipoElementoVentas;
    }

    public void setMovCarVentTipoElementoVentas(int movCarVentTipoElementoVentas) {
        this.movCarVentTipoElementoVentas = movCarVentTipoElementoVentas;
    }

    @Column(name = "MOV_CAR_VENT_VALOR_TOTAL_VENTAS", nullable = false)
    public Long getMovCarVentValorTotalVentas() {
        return movCarVentValorTotalVentas;
    }

    public void setMovCarVentValorTotalVentas(Long movCarVentValorTotalVentas) {
        this.movCarVentValorTotalVentas = movCarVentValorTotalVentas;
    }
}
