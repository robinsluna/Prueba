/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 30-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolDecDesVO;

import java.util.List;

/**
 * Interaface que gestiona los tr�mites de resoluci�n de decomiso y destrucci�n
 * @author PAOLA ANDREA RUEDA LE�N
 */

public interface AdminTramiteResolDecDes {
    /**
     * Buscar tr�mite de resoluci�n de decomiso y destrucci�n por id de resoluci�n y por id de estado
     * @param rddCodigo
     * @param etdCodigo
     * @return resultado - lista de tr�mites
     * @throws ExcepcionDAO
     */

    public List<TramiteResolDecDesVO> buscarTramiteResolDecDesXIdResolucionXIdEstado(Long rddCodigo,
                                                                              Long etdCodigo) throws ExcepcionDAO;
    
    /**
     * Insertar el tr�mite de resoluci�n de decomiso y destrucci�n
     * @param tramiteResolDecDesVo
     * @return resultado - VO insertado en la BD
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public TramiteResolDecDesVO insertarTramiteResolDecDes(TramiteResolDecDesVO tramiteResolDecDesVo) throws ExcepcionDAO, ExcepcionAplicacion;
    
    /**
     * Actualizar el tr�mite de la resoluci�n de decomiso y destrucci�n
     * @param tramiteResolDecDesVo
     * @return resultado - TramiteResolDecDesVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public TramiteResolDecDesVO actualizarTramiteResolDecDes(TramiteResolDecDesVO tramiteResolDecDesVo) throws ExcepcionDAO, ExcepcionAplicacion;
}
