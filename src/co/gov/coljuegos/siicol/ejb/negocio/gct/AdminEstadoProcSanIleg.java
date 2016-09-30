/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 10-03-20156
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcSanIlegVO;

import javax.ejb.Local;

/**
 * Interface que administra los estados de los procesos sancionatorios de ilegalidad
 * @author PAOLA ANDREA RUEDA LE�N
 */

@Local
public interface AdminEstadoProcSanIleg {
    
    /**
     * Buscar el estado del proceso sancionatorio de ilegalidad por c�digo
     * @param epiCodigo
     * @return resultado - EstadoProcSanIlegVO
     * @throws ExcepcionDAO
     */

    EstadoProcSanIlegVO buscarEstadoProcSanIlegPorCodigo(Long epiCodigo) throws ExcepcionDAO;
}
