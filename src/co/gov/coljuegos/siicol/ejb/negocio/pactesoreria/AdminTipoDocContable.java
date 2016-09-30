/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocContableVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminTipoDocContable 
{
    public TipoDocContableVO buscarPorCodigoTipoDocContable(String tdcCodigo) throws ExcepcionDAO;
    public TipoDocContableVO insertarTipoDocContable (TipoDocContableVO tipoDocContableVO) throws ExcepcionDAO, ExcepcionAplicacion  ;
    public TipoDocContableVO actualizarTipoDocContable (TipoDocContableVO tipoDocContableVO,  UsuarioVO usuarioLogueado) throws ExcepcionDAO;
    public void borrarTipoDocContable (TipoDocContableVO tipoDocContableVO) throws ExcepcionDAO;
    public List<TipoDocContableVO> buscarTodoTipoDocContable () throws ExcepcionDAO;
    public List<TipoDocContableVO> buscarPermitidosRegistroManual () throws ExcepcionDAO;
    
}
