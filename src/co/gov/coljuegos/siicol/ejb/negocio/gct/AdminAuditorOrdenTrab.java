/* 
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 14-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AuditorOrdenTrabVO;

import java.util.List;

/**
 * Interface de AdminAuditorOrdenTrab
 * @author PAOLA ANDREA RUEDA LE�N
 */
public interface AdminAuditorOrdenTrab {

    public AuditorOrdenTrabVO insertarAuditorOrdenTrab(AuditorOrdenTrabVO auditorOrdenTrabVo) throws ExcepcionDAO;
    public AuditorOrdenTrabVO actualizarAuditorOrdenTrab(AuditorOrdenTrabVO auditorOrdenTrabVo) throws ExcepcionDAO;
    public List<AuditorOrdenTrabVO> buscarAuditorOrdenTraXCodOrdenTrabajo(Long codOrdenTrabajo) throws ExcepcionDAO ;
    
    /**
     * 
     * @param suaCodigo
     * @return boolean
     * @throws ExcepcionDAO
     */
    
    public boolean isAsignado(Long suaCodigo) throws ExcepcionDAO;
}
