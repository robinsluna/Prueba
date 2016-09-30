/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
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
 * Interface que gestiona las resoluciones de decomiso y destrucci�n
 * @author PAOLA ANDREA RUEDA LE�N
 */

@Local
public interface AdminResolucionDecomDest {

    /**
     * Insertar la resoluci�n de decomiso y destrucci�n
     * @param resolucionDecomDestVo
     * @return resultado - Resoluci�n de decomiso y destrucci�n
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public ResolucionDecomDestVO insertarResolucionDecomDest(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO, ExcepcionAplicacion;

    /**
     * Buscar resoluci�n de decomiso y destrucci�n por id
     * @param rddCodigo
     * @return resultado - ResolucionDecomDestVO
     * @throws ExcepcionDAO
     */

    public ResolucionDecomDestVO buscarResolucionDecomDestVOXId(Long rddCodigo) throws ExcepcionDAO;

    /**
     * Buscar el estado de la resoluci�n seg�n id de la denuncia
     * @param denCodigo
     * @return String
     * @throws ExcepcionDAO
     */

    public String buscarEstadoResolucionXIdDenuncia(Long denCodigo) throws ExcepcionDAO;

    /**
     * Buscar el estado de la resoluci�n que resuelve el recurso seg�n id de la denuncia
     * @param denCodigo
     * @return String
     * @throws ExcepcionDAO
     */

    public String buscarEstadoResolucionRecursoXIdDenuncia(Long denCodigo) throws ExcepcionDAO;

    /**
     * Buscar el estado de la resoluci�n seg�n id de denuncia
     * @param denCodigo
     * @return rrd_nombre - String
     * @throws ExcepcionDAO
     */

    public Long buscarEstadoTramiteResolucionXIdDenuncia(Long denCodigo) throws ExcepcionDAO;
    
    /**
     * Buscar el estado del tr�mite de la resoluci�n que resuelve el recurso seg�n id de denuncia
     * @param denCodigo
     * @return Long
     * @throws ExcepcionDAO
     */
    
    public Long buscarEstadoTramiteResolucionRecursoXIdDenuncia(Long denCodigo) throws ExcepcionDAO;

    /**
     * Buscar todas las resoluciones de decomiso y destrucci�n.
     * @return resultado - Lista de resoluciones de decomiso y destrucci�n.
     * @throws ExcepcionDAO
     */

    public List<ResolucionDecomDestVO> buscarTodaResolucionDecomDest() throws ExcepcionDAO;

    /**
     * Buscar todas las resoluciones de decomiso y destrucci�n que no tengan acta de destrucci�n asociada.
     * @return listaSiiResolucionDecomDest - Lista de resoluciones de decomiso y destrucci�n
     * @throws ExcepcionDAO
     */

    public List<ResolucionDecomDestVO> buscarTodoResolDecomDestSinActaDestruccion() throws ExcepcionDAO;

    /**
     * Buscar la resoluci�n de decomiso y destrucci�n seg�n Id de Acta de Destrucci�n
     * @param adeCodigo
     * @return resultado - Lista de ResolucionDecomDestVO
     * @throws ExcepcionDAO
     */

    public List<ResolucionDecomDestVO> buscarResolDecomDestXIdActaDestruccion(Long adeCodigo) throws ExcepcionDAO;

    /**
     * Actualizar la resoluci�n de decomiso y destrucci�n.
     * @param resolucionDecomDestVo
     * @return resultado - Resoluci�n de decomiso y destrucci�n.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public ResolucionDecomDestVO actualizarResolucionDecomDest(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO, ExcepcionAplicacion;

    public Integer buscarConsecutivoResolucion() throws ExcepcionDAO;

    /**
     * Buscar el Id de la �ltima resoluci�n agregada seg�n usuario logueado
     * @param usuarioVo
     * @return Long
     * @throws ExcepcionDAO
     */

    public Long buscarIdUltimaResolucion(UsuarioVO usuarioVo) throws ExcepcionDAO;

    public SiiAutoComisorioAccCon buscarUnAutoComisorioAccPorDenuncia(Long denCodigo) throws ExcepcionDAO;

}
