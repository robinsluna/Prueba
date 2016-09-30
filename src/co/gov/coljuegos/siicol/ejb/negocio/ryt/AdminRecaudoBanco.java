/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.BancoVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRecaudoVO;
import co.gov.coljuegos.siicol.ejb.vo.MedioPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.PagoOperadoresVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcedenciaPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoCuentaVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminRecaudoBanco {
    public PagoOperadoresVO  buscarRecaudoBancoXId(Long idRec) throws ExcepcionDAO ;
    public List<DetalleRecaudoVO> buscarTodoDetalleRecaudoXRecaudo(PagoOperadoresVO  pagoOperadoresVo) throws ExcepcionDAO;   
    public List<PagoOperadoresVO> buscarTodosRecaudoBanco() throws ExcepcionDAO;
    public BancoVO  buscarBancoXId(BancoVO bancoVo) throws ExcepcionDAO ;
    public TipoCuentaVO  buscarTipoCuentaXId(TipoCuentaVO tipoCuentaVo) throws ExcepcionDAO;
    public MedioPagoVO  buscarMedioPagoXId(MedioPagoVO medioPagoVo) throws ExcepcionDAO ;
    public ProcedenciaPagoVO  buscarProcedenciaPagoXId(ProcedenciaPagoVO ProcedenciaPagoVo) throws ExcepcionDAO;
    public DetalleRecaudoVO  buscarDetalleRecaudoXId(DetalleRecaudoVO detalleRecaudoVo) throws ExcepcionDAO ;
    public PagoOperadoresVO insertarRecaudoBanco(PagoOperadoresVO pagoOperadoresVo) throws ExcepcionDAO,ExcepcionAplicacion ;
    public List<DetalleRecaudoVO> BuscarDetalleRecaudoXIdRefPago(DetalleRecaudoVO detalleRecaudoVo ) throws ExcepcionDAO;
        
   
}
