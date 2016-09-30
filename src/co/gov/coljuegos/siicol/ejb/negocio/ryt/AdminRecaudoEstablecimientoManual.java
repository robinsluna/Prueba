package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AsignacionRecaudoVO;
import co.gov.coljuegos.siicol.ejb.vo.RecaudoEstablecimientoManualVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminRecaudoEstablecimientoManual {
    public List<RecaudoEstablecimientoManualVO> buscarPagoSinRecaudoEstabl(String numContrato) throws ExcepcionDAO;
    public AsignacionRecaudoVO insertarAsignacionRecaudo(AsignacionRecaudoVO asignacionRecaudoVo) throws ExcepcionDAO;
    public List<RecaudoEstablecimientoManualVO> todoAsignacionRecaudo() throws ExcepcionDAO ;
    public List<RecaudoEstablecimientoManualVO> buscarAsignacionRecaudoXid(Long areCodigo) throws ExcepcionDAO ;
    public AsignacionRecaudoVO actualizarAsignacionRecaudo (AsignacionRecaudoVO asignacionRecaudoVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO,ExcepcionAplicacion;
       
}
