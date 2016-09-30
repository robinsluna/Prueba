package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicPfcmVO;

import javax.ejb.Local;


@Local
public interface AdminEstadoSolicPfcm  {
    
    public EstadoSolicPfcmVO buscarEstadoSolicPfcmPorNombre(EstadoSolicPfcmVO estadoSolicPfcmVo) throws ExcepcionDAO;
}
