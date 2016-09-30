/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 11-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.BarrioOrdenInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.CuadranteOrdTraInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.DenuncOrdTraInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.InformeVerificCampoVO;
import co.gov.coljuegos.siicol.ejb.vo.MunicOrdTraInfVerifVO;
import co.gov.coljuegos.siicol.ejb.vo.OrdenTrabajoVisitaVO;
import co.gov.coljuegos.siicol.ejb.vo.ResultadoVerifCampoVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

/**
 * Interfaz local para el manejo del negocio de las órdenes de trabajo
 * @author PAOLA ANDREA RUEDA LEÓN
 */
@Local
public interface AdminOrdenTrabajoVisita {
    public OrdenTrabajoVisitaVO actualizarOrdenTrabajoVisita(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO,
                                                                                                               ExcepcionAplicacion;

    public List<OrdenTrabajoVisitaVO> buscarTodaOrdenTrabajoVisita() throws ExcepcionDAO;
    
    public List<OrdenTrabajoVisitaVO> buscarOrdenTrabajoVisitaAprobadas() throws ExcepcionDAO;

    public OrdenTrabajoVisitaVO insertarOrdenTrabajoVisita(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO,
                                                                                                             ExcepcionAplicacion;

    public Integer obtenerConsecutivoOrdenTrabajoVisita() throws ExcepcionDAO;
    
    public List<OrdenTrabajoVisitaVO> buscarOrdenTrabajoXEstadoAprobado(UsuarioVO usuarioLogueado) throws ExcepcionDAO ;
    
    public OrdenTrabajoVisitaVO buscarOrdenTrabajoXId(Long idOrden) throws ExcepcionDAO ;
    
    public InformeVerificCampoVO insertarInformeVerificCampo(InformeVerificCampoVO InformeVerificCampoVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO ;
    
    public List<BarrioOrdenInfVerVO> buscarBarrioOrdenInfVerPorBorCodigo(Long borCodigo) throws ExcepcionDAO ;
    
    public InformeVerificCampoVO actualizarInformeVerificacion (OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO;
    
    public List<ResultadoVerifCampoVO>  buscarTodoResulVerCampo() throws ExcepcionDAO; 
    
    public List<MunicOrdTraInfVerifVO> buscarMunicOrdTraInfVerifPorMotCodigo(Long motCodigo) throws ExcepcionDAO ;
    
    public List<CuadranteOrdTraInfVerVO> buscarCuadranteOrdTraInfVerPorCotCodigo(Long cotCodigo) throws ExcepcionDAO ;
    
    public List<DenuncOrdTraInfVerVO> buscarDenuncOrdTraInfVerPorDotCodigo(Long dotCodigo) throws ExcepcionDAO ;
    
}
