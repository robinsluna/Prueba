package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class SolicitudAutorizaWSVO implements Serializable {

    public String nit;
    public String numeroSiito;
    public Long tipoSolicitud;
    public Date fecha;
    public String radicado;
    public Long codigoMovimiento;
    public String UsuarioColjuegos; //Login del usuario
    public Integer tiempoContratoMeses;
    public String numeroContrato;
    public EstadoSolicAutorizWSVO estadoSolicAutoriz;
    public BigDecimal valorContrato;
    public NovedadWSVO ultimaNovedadVo;
    public BigDecimal valorProrroga;
    public Integer indicadorRenovacion;
    public String numeroSiitoSolicitudDesitir;
    public Integer ampliacion;

    public SolicitudAutorizaWSVO() {
    }

}
