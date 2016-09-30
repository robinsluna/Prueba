/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 16-05-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoRetencion;
import co.gov.coljuegos.siicol.ejb.vo.TipoRetencionVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Administrador del Tipo de Retenci&oacute;n.
 * @author Camilo Miranda
 */
@Local
public interface AdminTipoRetencion {
    
    public TipoRetencionVO buscarPorCodigo (String treCodigo) throws ExcepcionDAO;
    public List<TipoRetencionVO> buscarTodoTipoRetencion () throws ExcepcionDAO;
    public TipoRetencionVO insertarTipoRetencion (TipoRetencionVO tipoRetencionVo) throws ExcepcionDAO;
    public TipoRetencionVO actualizarTipoRetencion (TipoRetencionVO tipoRetencionVo) throws ExcepcionDAO;
    public List<TipoRetencionVO> buscarPorIdGrupoRetencion (Long greCodigo) throws ExcepcionDAO;
}
