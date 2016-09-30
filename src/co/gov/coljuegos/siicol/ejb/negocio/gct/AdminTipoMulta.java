package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoMultaVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Tipos de Multa.
 * @author Camilo Miranda
 */
@Local
public interface AdminTipoMulta 
{
    public TipoMultaVO buscarTipoMultaPorId (Long tmuCodigo) throws ExcepcionDAO;
    public TipoMultaVO insertarTipoMulta (TipoMultaVO tipoMultaVo) throws ExcepcionDAO;
    public TipoMultaVO actualizarTipoMulta (TipoMultaVO tipoMultaVo) throws ExcepcionDAO;
    public void eliminarTipoMulta (Long tmuCodigo) throws ExcepcionDAO;
    public List<TipoMultaVO> buscarTodoTipoMulta () throws ExcepcionDAO;
}
