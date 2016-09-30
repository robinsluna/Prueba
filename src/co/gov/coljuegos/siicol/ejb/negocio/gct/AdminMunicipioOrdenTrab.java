/* 
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 15-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.MunicipioOrdenTrabVO;

import java.util.List;

/**
 * Interfaz para AdminMunicipioOrdenTrab
 * @author PAOLA ANDREA RUEDA LE�N
 */

public interface AdminMunicipioOrdenTrab {
    
    public MunicipioOrdenTrabVO insertarMunicipioOrdenTrab (MunicipioOrdenTrabVO municipioOrdenTrabVo) throws ExcepcionDAO;
    public MunicipioOrdenTrabVO actualizarMunicipioOrdenTrab (MunicipioOrdenTrabVO municipioOrdenTrabVo) throws ExcepcionDAO;
    public List<MunicipioOrdenTrabVO> buscarMunicipioOrdenTrabXCodOrdenTrabajo(Long codOrdenTrabajo) throws ExcepcionDAO;
}
