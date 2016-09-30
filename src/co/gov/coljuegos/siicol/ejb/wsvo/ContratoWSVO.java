package co.gov.coljuegos.siicol.ejb.wsvo;

import java.util.Date;
import java.util.List;

public class ContratoWSVO {
    
    public Long conCodigo;
    public String conDescripcion;
    public Date conFechaFin;
    public Date conFechaIni;
    public String conNumero;
    public OperadorWSVO operadorVo;
    public List<NovedadWSVO> novedadVoList;
    public CuotaOperadorWSVO cuotaAcuerdosPagoActual;
    public CuotaOperadorWSVO cuotaIlegalidadActual;
    public List<CuotaOperadorWSVO> listaCuotasAcuerdosVencidas;
    public List<CuotaOperadorWSVO> listaCuotasAcuerdosNoVencidas;
    public CuotaOperadorWSVO cuotaMultasSancionesActual;
    public List<CuotaOperadorWSVO> listaCuotasMultasSancionesVencidas;
    public List<CuotaOperadorWSVO> listaCuotasMultasSancionesNoVencidas;
        public List<CuotaOperadorWSVO> listaCuotasIlegalidadVencidas;
    public List<CuotaOperadorWSVO> listaCuotasIlegalidadNoVencidas;
    
    public Date conFecha;
    public String conVigente;
    public Integer conConsecutivo;
    public Long valorContrato;
    
    /*
     * Por Gatopardo: campos creados para el WS de estado de cuenta:
     */
    public CuotaOperadorWSVO cuotaDEGAMesActual;
    public List<CuotaOperadorWSVO> listaCuotasDEGAVencidas;
    
    public ContratoWSVO() {
        
    }
}
