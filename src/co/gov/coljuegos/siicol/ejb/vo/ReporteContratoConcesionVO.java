package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


public class ReporteContratoConcesionVO {

    private String nombre_operador;
    private String nit;
    private String direccion;
    private String telefonos;
    private String correo_electronico;
    private String ciudad;
    private String codigo_DANE;
    private String num_contrato;
    private Date fecha_Suscripcion;
    private Date fecha_Inicio_Ejecucion;
    private Date fecha_finalizacion;
    private int num_Establecimientos;
    private int num_Elementos;
    private BigDecimal valor_Contrato;
    private String numero_Poliza;
    private String aseguradora;
    private Date fecha_Aprobacion_Poliza;
    private BigDecimal valor_amparo_Cumplimiento;
    private BigDecimal valor_amparo_Premios;
    private BigDecimal valor_amparo_Sal_Pres_Soci;
    private Date amparo_Cumplimiento;
    private Date amparo_Premios;
    private Date amparo_Sal_Pres_Soci;
    private Date amparo_Cumplimiento_Fin;
    private Date amparo_Premios_Fin;
    private Date amparo_Sal_Pres_Soci_Fin;
    private String estado_Cuenta;
    private int METs;
    private int SILLAS;
    private int MESAS;
    private int TERMINALES;
    private String departamento;    

    List<ModReporteContratoConcesionVO> modReporteContratoConcesionVOs;

    public String getNombre_operador() {
        return nombre_operador;
    }

    public void setNombre_operador(String nombre_operador) {
        this.nombre_operador = nombre_operador;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_DANE() {
        return codigo_DANE;
    }

    public void setCodigo_DANE(String codigo_DANE) {
        this.codigo_DANE = codigo_DANE;
    }

    public String getNum_contrato() {
        return num_contrato;
    }

    public void setNum_contrato(String num_contrato) {
        this.num_contrato = num_contrato;
    }

    public String getNumero_Poliza() {
        return numero_Poliza;
    }

    public void setNumero_Poliza(String numero_Poliza) {
        this.numero_Poliza = numero_Poliza;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public String getEstado_Cuenta() {
        return estado_Cuenta;
    }

    public void setEstado_Cuenta(String estado_Cuenta) {
        this.estado_Cuenta = estado_Cuenta;
    }

    public List<ModReporteContratoConcesionVO> getModReporteContratoConcesionVOs() {
        return modReporteContratoConcesionVOs;
    }

    public void setModReporteContratoConcesionVOs(List<ModReporteContratoConcesionVO> modReporteContratoConcesionVOs) {
        this.modReporteContratoConcesionVOs = modReporteContratoConcesionVOs;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Date getFecha_Suscripcion() {
        return fecha_Suscripcion;
    }

    public void setFecha_Suscripcion(Date fecha_Suscripcion) {
        this.fecha_Suscripcion = fecha_Suscripcion;
    }

    public Date getFecha_Inicio_Ejecucion() {
        return fecha_Inicio_Ejecucion;
    }

    public void setFecha_Inicio_Ejecucion(Date fecha_Inicio_Ejecucion) {
        this.fecha_Inicio_Ejecucion = fecha_Inicio_Ejecucion;
    }

    public Date getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setFecha_finalizacion(Date fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public int getNum_Establecimientos() {
        return num_Establecimientos;
    }

    public void setNum_Establecimientos(int num_Establecimientos) {
        this.num_Establecimientos = num_Establecimientos;
    }

    public int getNum_Elementos() {
        return num_Elementos;
    }

    public void setNum_Elementos(int num_Elementos) {
        this.num_Elementos = num_Elementos;
    }

    public int getMETs() {
        return METs;
    }

    public void setMETs(int METs) {
        this.METs = METs;
    }

    public int getSILLAS() {
        return SILLAS;
    }

    public void setSILLAS(int SILLAS) {
        this.SILLAS = SILLAS;
    }

    public int getMESAS() {
        return MESAS;
    }

    public void setMESAS(int MESAS) {
        this.MESAS = MESAS;
    }

    public int getTERMINALES() {
        return TERMINALES;
    }

    public void setTERMINALES(int TERMINALES) {
        this.TERMINALES = TERMINALES;
    }

    public Date getFecha_Aprobacion_Poliza() {
        return fecha_Aprobacion_Poliza;
    }

    public void setFecha_Aprobacion_Poliza(Date fecha_Aprobacion_Poliza) {
        this.fecha_Aprobacion_Poliza = fecha_Aprobacion_Poliza;
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

    public BigDecimal getValor_amparo_Sal_Pres_Soci() {
        return valor_amparo_Sal_Pres_Soci;
    }

    public void setValor_amparo_Sal_Pres_Soci(BigDecimal valor_amparo_Sal_Pres_Soci) {
        this.valor_amparo_Sal_Pres_Soci = valor_amparo_Sal_Pres_Soci;
    }

    public Date getAmparo_Cumplimiento_Fin() {
        return amparo_Cumplimiento_Fin;
    }

    public void setAmparo_Cumplimiento_Fin(Date amparo_Cumplimiento_Fin) {
        this.amparo_Cumplimiento_Fin = amparo_Cumplimiento_Fin;
    }

    public Date getAmparo_Premios_Fin() {
        return amparo_Premios_Fin;
    }

    public void setAmparo_Premios_Fin(Date amparo_Premios_Fin) {
        this.amparo_Premios_Fin = amparo_Premios_Fin;
    }

    public Date getAmparo_Sal_Pres_Soci_Fin() {
        return amparo_Sal_Pres_Soci_Fin;
    }

    public void setAmparo_Sal_Pres_Soci_Fin(Date amparo_Sal_Pres_Soci_Fin) {
        this.amparo_Sal_Pres_Soci_Fin = amparo_Sal_Pres_Soci_Fin;
    }

    public Date getAmparo_Cumplimiento() {
        return amparo_Cumplimiento;
    }

    public void setAmparo_Cumplimiento(Date amparo_Cumplimiento) {
        this.amparo_Cumplimiento = amparo_Cumplimiento;
    }

    public Date getAmparo_Premios() {
        return amparo_Premios;
    }

    public void setAmparo_Premios(Date amparo_Premios) {
        this.amparo_Premios = amparo_Premios;
    }

    public Date getAmparo_Sal_Pres_Soci() {
        return amparo_Sal_Pres_Soci;
    }

    public void setAmparo_Sal_Pres_Soci(Date amparo_Sal_Pres_Soci) {
        this.amparo_Sal_Pres_Soci = amparo_Sal_Pres_Soci;
    }

    public BigDecimal getValor_Contrato() {
        return valor_Contrato;
    }

    public void setValor_Contrato(BigDecimal valor_Contrato) {
        this.valor_Contrato = valor_Contrato;
    }
}
