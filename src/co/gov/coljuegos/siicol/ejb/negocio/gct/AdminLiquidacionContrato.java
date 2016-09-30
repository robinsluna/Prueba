package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionContrato;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionLiquid;
import co.gov.coljuegos.siicol.ejb.vo.CausalTerminacionContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoLiquidacionContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoResolucionLiqVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionContratoVO;

import co.gov.coljuegos.siicol.ejb.vo.ResolucionLiquidacionVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;


public interface AdminLiquidacionContrato {
    public LiquidacionContratoVO insertarLiquidacionContrato(LiquidacionContratoVO liquidacionContratoVo) throws ExcepcionDAO;
    public List<LiquidacionContratoVO> buscarTodosLiquidacionContrato() throws ExcepcionDAO;
    public List<CausalTerminacionContratoVO> buscarTodosCausalTermContr() throws ExcepcionDAO;
    public CausalTerminacionContratoVO buscarSiiCausalTermContrXId(Long  idCausal) throws ExcepcionDAO;
    public EstadoLiquidacionContratoVO buscarEstadoLiquidContXNombre (String nombreEstado ) throws ExcepcionDAO ;
    public LiquidacionContratoVO buscarLiquidacionContratoXId(Long  idLiqContrato) throws ExcepcionDAO ;
    public ResolucionLiquidacionVO buscarResolucionLiquidPorId(Long codigo) throws ExcepcionDAO ;
    public LiquidacionContratoVO actualizarLiquidacionContrato(LiquidacionContratoVO liquidacionContratoVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO ;
    public LiquidacionContratoVO buscarLiquidacionContratoPorContrato(String conNumero) throws ExcepcionDAO;
    public EstadoResolucionLiqVO  buscarEstadoResolucLiqPorEstado(String nombreEstado) throws ExcepcionDAO ;
    public ResolucionLiquidacionVO actualizarSiiResolucionLiquid(ResolucionLiquidacionVO resolucionLiquidacionVo,ContratoVO contratoVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO ;
    public List<ResolucionLiquidacionVO> buscarSiiResolucionLiquidPorIdLiq(Long lcoCodigo) throws ExcepcionDAO ;
    public EstadoResolucionLiqVO buscarEstadoResolucionLiqXId(Long  idEstadoResLiq) throws ExcepcionDAO ;
    public void liquidacionConFirmeAutomatico()  ;
}
