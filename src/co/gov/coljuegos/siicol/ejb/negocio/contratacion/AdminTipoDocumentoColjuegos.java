/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Contratacion
 * AUTOR	: Orlando Rodriguez Bayona
 * FECHA	: 25-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocumentoColjuegosVO;

import java.util.List;

import javax.ejb.Local;

@Local

public interface AdminTipoDocumentoColjuegos {
    public TipoDocumentoColjuegosVO insertarTipoDocumentoColjuegos(TipoDocumentoColjuegosVO tipoDocumentoColjuegosVO) throws ExcepcionDAO;
    public TipoDocumentoColjuegosVO buscarTipoDocumentoColjuegosPorId(Long idTipoDocColjuegos) throws ExcepcionDAO;
    public TipoDocumentoColjuegosVO actualizarTipoDocumentoColjuegos(TipoDocumentoColjuegosVO tipoDocumentoColjuegosVO) throws ExcepcionDAO;
    //public TipoDocumentoColjuegosVO eliminarTipoDocumentoColjuegos(TipoDocumentoColjuegosVO tipoDocumentoColjuegosVO) throws ExcepcionDAO;
    public List<TipoDocumentoColjuegosVO> buscarTodoTipoDocumentoColjuegos() throws ExcepcionDAO;
    public TipoDocumentoColjuegosVO buscarTipoDocumentoColjuegosPorNombre(String nombre) throws ExcepcionDAO;
}

    