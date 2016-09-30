/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 26-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorioAccCon;
import co.gov.coljuegos.siicol.ejb.vo.AccionControlVO;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionDecomDestVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

/**
 * Interface que gestiona las resoluciones de decomiso y destrucción
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Local
public interface AdminResolucionDecomDest {

    /**
     * Insertar la resolución de decomiso y destrucción
     * @param resolucionDecomDestVo
     * @return resultado - Resolución de decomiso y destrucción
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public ResolucionDecomDestVO insertarResolucionDecomDest(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO, ExcepcionAplicacion;

    /**
     * Buscar resolución de decomiso y destrucción por id
     * @param rddCodigo
     * @return resultado - ResolucionDecomDestVO
     * @throws ExcepcionDAO
     */

    public ResolucionDecomDestVO buscarResolucionDecomDestVOXId(Long rddCodigo) throws ExcepcionDAO;

    /**
     * Buscar el estado de la resolución según id de la denuncia
     * @param denCodigo
     * @return String
     * @throws ExcepcionDAO
     */

    public String buscarEstadoResolucionXIdDenuncia(Long denCodigo) throws ExcepcionDAO;

    /**
     * Buscar el estado de la resolución que resuelve el recurso según id de la denuncia
     * @param denCodigo
     * @return String
     * @throws ExcepcionDAO
     */

    public String buscarEstadoResolucionRecursoXIdDenuncia(Long denCodigo) throws ExcepcionDAO;

    /**
     * Buscar el estado de la resolución según id de denuncia
     * @param denCodigo
     * @return rrd_nombre - String
     * @throws ExcepcionDAO
     */

    public Long buscarEstadoTramiteResolucionXIdDenuncia(Long denCodigo) throws ExcepcionDAO;
    
    /**
     * Buscar el estado del trámite de la resolución que resuelve el recurso según id de denuncia
     * @param denCodigo
     * @return Long
     * @throws ExcepcionDAO
     */
    
    public Long buscarEstadoTramiteResolucionRecursoXIdDenuncia(Long denCodigo) throws ExcepcionDAO;

    /**
     * Buscar todas las resoluciones de decomiso y destrucción.
     * @return resultado - Lista de resoluciones de decomiso y destrucción.
     * @throws ExcepcionDAO
     */

    public List<ResolucionDecomDestVO> buscarTodaResolucionDecomDest() throws ExcepcionDAO;

    /**
     * Buscar todas las resoluciones de decomiso y destrucción que no tengan acta de destrucción asociada.
     * @return listaSiiResolucionDecomDest - Lista de resoluciones de decomiso y destrucción
     * @throws ExcepcionDAO
     */

    public List<ResolucionDecomDestVO> buscarTodoResolDecomDestSinActaDestruccion() throws ExcepcionDAO;

    /**
     * Buscar la resolución de decomiso y destrucción según Id de Acta de Destrucción
     * @param adeCodigo
     * @return resultado - Lista de ResolucionDecomDestVO
     * @throws ExcepcionDAO
     */

    public List<ResolucionDecomDestVO> buscarResolDecomDestXIdActaDestruccion(Long adeCodigo) throws ExcepcionDAO;

    /**
     * Actualizar la resolución de decomiso y destrucción.
     * @param resolucionDecomDestVo
     * @return resultado - Resolución de decomiso y destrucción.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public ResolucionDecomDestVO actualizarResolucionDecomDest(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO, ExcepcionAplicacion;

    public Integer buscarConsecutivoResolucion() throws ExcepcionDAO;

    /**
     * Buscar el Id de la última resolución agregada según usuario logueado
     * @param usuarioVo
     * @return Long
     * @throws ExcepcionDAO
     */

    public Long buscarIdUltimaResolucion(UsuarioVO usuarioVo) throws ExcepcionDAO;

    public SiiAutoComisorioAccCon buscarUnAutoComisorioAccPorDenuncia(Long denCodigo) throws ExcepcionDAO;

}
