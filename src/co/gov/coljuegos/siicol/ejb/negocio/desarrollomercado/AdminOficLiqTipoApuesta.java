package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.OficLiqTipoApuestaVO;

import java.math.BigDecimal;

import java.util.List;

public interface AdminOficLiqTipoApuesta {
   
    public OficLiqTipoApuestaVO insertarSiiOficLiqTipoApuesta(OficLiqTipoApuestaVO OficLiqTipoApuestaVo) throws ExcepcionDAO;
    public OficLiqTipoApuestaVO buscarOficLiqTipoApuestaPorCodigo(Long idCodigoOficLiqTipoApuesta)   throws ExcepcionDAO;
    public List<OficLiqTipoApuestaVO> buscarSiiOficLiqTipoApuestaPorOficioLiquidacion(Long oliCodigo) throws ExcepcionDAO;
    public BigDecimal valorAutorizacionMensual(Long oliCodigo,String otaIndicadorLiq)  throws ExcepcionDAO;
    public BigDecimal valorAutorizacionGasAdmNumero(Long oliCodigo,String otaIndicadorLiq)  throws ExcepcionDAO;
    public BigDecimal valorAutorizacionDerExpNumero(Long oliCodigo,String otaIndicadorLiq) throws ExcepcionDAO;
    
}
