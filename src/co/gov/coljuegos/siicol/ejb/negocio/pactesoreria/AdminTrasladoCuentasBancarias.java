/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 07-03-2014
 */


package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoTrasladoBancarioVO;
import co.gov.coljuegos.siicol.ejb.vo.TrasladoCuentasBancariasVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTrasladoCuentasBancarias {

    public TrasladoCuentasBancariasVO buscarTrasladoBancarioPorId(Long idTrasCuentaBan) throws ExcepcionDAO;

    public TrasladoCuentasBancariasVO insertarTrasladoBancario(TrasladoCuentasBancariasVO trasladoCuentasBancariasVo) throws ExcepcionDAO;

    public List<TrasladoCuentasBancariasVO> buscarTodoTrasladoBancario() throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param trasladoCuentasBancariasVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public TrasladoCuentasBancariasVO actualizarTrasladoBancario(TrasladoCuentasBancariasVO trasladoCuentasBancariasVo,
                                                                 UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                   ExcepcionAplicacion;
    
    /**
     * @author Modifica Giovanni 
     * @param trasladoCuentasBancariasVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public TrasladoCuentasBancariasVO actualizarTrasladoBancarioAprobar(TrasladoCuentasBancariasVO trasladoCuentasBancariasVo,
                                                                 UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                   ExcepcionAplicacion;

    public TrasladoCuentasBancariasVO buscarSaldoCuentaTrasladoBancario(Long idCuentaBancaria) throws ExcepcionDAO;

    public EstadoTrasladoBancarioVO buscarEstadoEstadoTraslBancarioPorNombre(String nombreEstado) throws ExcepcionDAO;
    
    public DocumentoContableVO buscarPorCodigoTrasBanco (Long trbCodigo) throws ExcepcionDAO ;

}
