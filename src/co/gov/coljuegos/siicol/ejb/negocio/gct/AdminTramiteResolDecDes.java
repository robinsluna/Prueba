/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 30-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolDecDesVO;

import java.util.List;

/**
 * Interaface que gestiona los trámites de resolución de decomiso y destrucción
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public interface AdminTramiteResolDecDes {
    /**
     * Buscar trámite de resolución de decomiso y destrucción por id de resolución y por id de estado
     * @param rddCodigo
     * @param etdCodigo
     * @return resultado - lista de trámites
     * @throws ExcepcionDAO
     */

    public List<TramiteResolDecDesVO> buscarTramiteResolDecDesXIdResolucionXIdEstado(Long rddCodigo,
                                                                              Long etdCodigo) throws ExcepcionDAO;
    
    /**
     * Insertar el trámite de resolución de decomiso y destrucción
     * @param tramiteResolDecDesVo
     * @return resultado - VO insertado en la BD
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public TramiteResolDecDesVO insertarTramiteResolDecDes(TramiteResolDecDesVO tramiteResolDecDesVo) throws ExcepcionDAO, ExcepcionAplicacion;
    
    /**
     * Actualizar el trámite de la resolución de decomiso y destrucción
     * @param tramiteResolDecDesVo
     * @return resultado - TramiteResolDecDesVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public TramiteResolDecDesVO actualizarTramiteResolDecDes(TramiteResolDecDesVO tramiteResolDecDesVo) throws ExcepcionDAO, ExcepcionAplicacion;
}
