package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;


public class ModReporteContratoConcesionVO {

    private String num_Otro_Si;
    private String Fecha_Otro_Si;
    private String tipo_Novedad;
    private String numero_Poliza;
    private String aseguradora;
    private Date fecha_aprobacion_Poliza;
    private BigDecimal valor_amparo_Cumplimiento;
    private BigDecimal valor_amparo_Premios;
    private BigDecimal valor_amparo_Salarios_Prestaciones_Sociales;
    private String amparo_Cumplimiento;
    private String amparo_Premios;
    private String amparo_Salarios_Prestaciones_Sociales;
    private String modMETs;
    private String modSILLAS;
    private String modMESAS;
    private String modTERMINALES;

    public String getNum_Otro_Si() {
        return num_Otro_Si;
    }

    public void setNum_Otro_Si(String num_Otro_Si) {
        this.num_Otro_Si = num_Otro_Si;
    }

    public String getFecha_Otro_Si() {
        return Fecha_Otro_Si;
    }

    public void setFecha_Otro_Si(String Fecha_Otro_Si) {
        this.Fecha_Otro_Si = Fecha_Otro_Si;
    }

    public String getTipo_Novedad() {
        return tipo_Novedad;
    }

    public void setTipo_Novedad(String tipo_Novedad) {
        this.tipo_Novedad = tipo_Novedad;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public String getAmparo_Cumplimiento() {
        return amparo_Cumplimiento;
    }

    public void setAmparo_Cumplimiento(String amparo_Cumplimiento) {
        this.amparo_Cumplimiento = amparo_Cumplimiento;
    }

    public String getAmparo_Premios() {
        return amparo_Premios;
    }

    public void setAmparo_Premios(String amparo_Premios) {
        this.amparo_Premios = amparo_Premios;
    }

    public String getAmparo_Salarios_Prestaciones_Sociales() {
        return amparo_Salarios_Prestaciones_Sociales;
    }

    public void setAmparo_Salarios_Prestaciones_Sociales(String amparo_Salarios_Prestaciones_Sociales) {
        this.amparo_Salarios_Prestaciones_Sociales = amparo_Salarios_Prestaciones_Sociales;
    }

    public String getModMETs() {
        return modMETs;
    }

    public void setModMETs(String modMETs) {
        this.modMETs = modMETs;
    }

    public String getModSILLAS() {
        return modSILLAS;
    }

    public void setModSILLAS(String modSILLAS) {
        this.modSILLAS = modSILLAS;
    }

    public String getModMESAS() {
        return modMESAS;
    }

    public void setModMESAS(String modMESAS) {
        this.modMESAS = modMESAS;
    }

    public String getModTERMINALES() {
        return modTERMINALES;
    }

    public void setModTERMINALES(String modTERMINALES) {
        this.modTERMINALES = modTERMINALES;
    }

    public String getNumero_Poliza() {
        return numero_Poliza;
    }

    public void setNumero_Poliza(String numero_Poliza) {
        this.numero_Poliza = numero_Poliza;
    }

    public Date getFecha_aprobacion_Poliza() {
        return fecha_aprobacion_Poliza;
    }

    public void setFecha_aprobacion_Poliza(Date fecha_aprobacion_Poliza) {
        this.fecha_aprobacion_Poliza = fecha_aprobacion_Poliza;
    }

    public BigDecimal getValor_amparo_Cumplimiento() {
        return valor_amparo_Cumplimiento;
    }

    public void setValor_amparo_Cumplimiento(BigDecimal valor_amparo_Cumplimiento) {
        this.valor_amparo_Cumplimiento = valor_amparo_Cumplimiento;
    }

    public BigDecimal getValor_amparo_Premios() {
        return valor_amparo_Premios;
    }

    public void setValor_amparo_Premios(BigDecimal valor_amparo_Premios) {
        this.valor_amparo_Premios = valor_amparo_Premios;
    }

    public BigDecimal getValor_amparo_Salarios_Prestaciones_Sociales() {
        return valor_amparo_Salarios_Prestaciones_Sociales;
    }

    public void setValor_amparo_Salarios_Prestaciones_Sociales(BigDecimal valor_amparo_Salarios_Prestaciones_Sociales) {
        this.valor_amparo_Salarios_Prestaciones_Sociales = valor_amparo_Salarios_Prestaciones_Sociales;
    }
}
