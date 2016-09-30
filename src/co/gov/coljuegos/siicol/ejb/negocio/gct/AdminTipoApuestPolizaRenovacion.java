package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestPolizaRenovacVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoApuestPolizaRenovacion {
    
    public List<TipoApuestPolizaRenovacVO> buscarTipoApuestaPolizaRenovacionPorPoliza(Long idPoliza) throws ExcepcionDAO;
}
