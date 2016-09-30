/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 10-03-20156
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcSanIlegVO;

import javax.ejb.Local;

/**
 * Interface que administra los estados de los procesos sancionatorios de ilegalidad
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Local
public interface AdminEstadoProcSanIleg {
    
    /**
     * Buscar el estado del proceso sancionatorio de ilegalidad por código
     * @param epiCodigo
     * @return resultado - EstadoProcSanIlegVO
     * @throws ExcepcionDAO
     */

    EstadoProcSanIlegVO buscarEstadoProcSanIlegPorCodigo(Long epiCodigo) throws ExcepcionDAO;
}
