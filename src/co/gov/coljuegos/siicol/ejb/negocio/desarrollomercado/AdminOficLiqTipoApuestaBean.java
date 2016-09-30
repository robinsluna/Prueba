package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficLiqTipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficLiqTipoApuesta;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.OficLiqTipoApuestaVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminOficLiqTipoApuestaBean implements AdminOficLiqTipoApuesta{
    @EJB 
    ConversionVOEntidad conversionVoEntidad; 
    @EJB 
    OficLiqTipoApuestaDAO oficLiqTipoApuestaDao;
    


    public AdminOficLiqTipoApuestaBean() {
    }
    
    public OficLiqTipoApuestaVO insertarSiiOficLiqTipoApuesta(OficLiqTipoApuestaVO OficLiqTipoApuestaVo) throws ExcepcionDAO{
        SiiOficLiqTipoApuesta siiOficLiqTipoApuesta = conversionVoEntidad.convertir(OficLiqTipoApuestaVo);
        siiOficLiqTipoApuesta = oficLiqTipoApuestaDao.insertarSiiOficLiqTipoApuesta(siiOficLiqTipoApuesta);
        return new OficLiqTipoApuestaVO(siiOficLiqTipoApuesta);
    }
   
    public OficLiqTipoApuestaVO buscarOficLiqTipoApuestaPorCodigo(Long idCodigoOficLiqTipoApuesta)   throws ExcepcionDAO {
        SiiOficLiqTipoApuesta siiOficLiqTipoApuesta = oficLiqTipoApuestaDao.buscarOficLiqTipoApuestaPorCodigo(idCodigoOficLiqTipoApuesta);
        return new OficLiqTipoApuestaVO(siiOficLiqTipoApuesta);
    }
    
    public List<OficLiqTipoApuestaVO> buscarSiiOficLiqTipoApuestaPorOficioLiquidacion(Long oliCodigo) throws ExcepcionDAO {
        List<SiiOficLiqTipoApuesta> oficiosLiq  = oficLiqTipoApuestaDao.buscarSiiOficLiqTipoApuestaPorOficioLiquidacion(oliCodigo);
        List<OficLiqTipoApuestaVO> oficiosLiqVo = new ArrayList<OficLiqTipoApuestaVO>(); 
        for (SiiOficLiqTipoApuesta oficioLiq : oficiosLiq) {
            oficiosLiqVo.add(new OficLiqTipoApuestaVO(oficioLiq));
        }
        return oficiosLiqVo;
        
    }
    
    public BigDecimal valorAutorizacionMensual(Long oliCodigo,String otaIndicadorLiq)  throws ExcepcionDAO {
        return oficLiqTipoApuestaDao.valorAutorizacionMensual(oliCodigo,otaIndicadorLiq);
    }


    @Override
    public BigDecimal valorAutorizacionGasAdmNumero(Long oliCodigo, String otaIndicadorLiq) throws ExcepcionDAO {
        return oficLiqTipoApuestaDao.valorAutorizacionGasAdmNumero(oliCodigo,otaIndicadorLiq);
    }

    @Override
    public BigDecimal valorAutorizacionDerExpNumero(Long oliCodigo, String otaIndicadorLiq) throws ExcepcionDAO {
        return oficLiqTipoApuestaDao.valorAutorizacionDerExpNumero(oliCodigo,otaIndicadorLiq);
    }
}
