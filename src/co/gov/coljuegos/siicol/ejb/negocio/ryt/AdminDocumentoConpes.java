
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 24-01-2014
 */
package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionUbicaVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoConpesVO;
import co.gov.coljuegos.siicol.ejb.vo.EnteTerritorialVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoDocConpesVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

public interface AdminDocumentoConpes {

    public List<DocumentoConpesVO> buscarTodosDocumentoConpes() throws ExcepcionDAO;

    public DocumentoConpesVO buscarDocumentoConpesPorId(DocumentoConpesVO documentoConpesVo) throws ExcepcionDAO;

    public DocumentoConpesVO insertarDocumentoConpes(DocumentoConpesVO documentoConpesVo) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param documentoConpesVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public DocumentoConpesVO actualizarDocumentoConpes(DocumentoConpesVO documentoConpesVo,
                                                       UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                         ExcepcionAplicacion;

    public List<DocumentoConpesVO> buscarTodosDocumentoConpesXNumeroYVigencia(DocumentoConpesVO documentoConpesVo) throws ExcepcionDAO;

    public EstadoDocConpesVO buscarEstadoDocConpesXNombre(EstadoDocConpesVO estadoDocConpesVo) throws ExcepcionDAO;

    public DocumentoConpesVO buscarDocumentoConpesActivo() throws ExcepcionDAO;

    public EnteTerritorialVO buscarEnteTerritorialXIdUbicacion(String idUbicacion) throws ExcepcionDAO;

    public List<DistribucionUbicaVO> buscarDistribucionUbicaXIdDocConpes(Long idDocCompes) throws ExcepcionDAO;
}
