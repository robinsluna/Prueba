/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 30-04-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CargaDocumentoContVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface local para el Cargue de archivos de Documentos Contables.
 * @author Camilo Miranda
 */
@Local
public interface AdminCargaDocumentoCont 
{
    public CargaDocumentoContVO buscarCargaDocumentoContPorId (Long cdcCodigo) throws ExcepcionDAO;
    public CargaDocumentoContVO insertarCargaDocumentoCont (CargaDocumentoContVO cargaDocumentoContVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public CargaDocumentoContVO actualizarCargaDocumentoCont (CargaDocumentoContVO cargaDocumentoContVo) throws ExcepcionDAO;
    public void borrarCargaDocumentoCont (Long cdcCodigo) throws ExcepcionDAO;
    public List<CargaDocumentoContVO> buscarTodoCargaDocumentoCont () throws ExcepcionDAO;
}
