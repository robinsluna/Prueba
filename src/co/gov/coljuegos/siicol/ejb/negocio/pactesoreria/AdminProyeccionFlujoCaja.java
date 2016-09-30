/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Diana Caro
 * FECHA	: 23-09-2013
 */
package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionPfcVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoPfcVO;
import co.gov.coljuegos.siicol.ejb.vo.ProyeccionFlujoCajaVO;

import co.gov.coljuegos.siicol.ejb.vo.RubroDetalleFuenteVO;

import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;

import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemSolicitudVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminProyeccionFlujoCaja {

    public List<RubroDetalleFuenteVO> buscarTodoRubroDetallePorFteNacion(Integer vigencia) throws ExcepcionDAO;
    public List<RubroDetalleFuenteVO> buscarTodoRubroFuenteDetalle(Integer vigencia) throws ExcepcionDAO;

    public DistribucionPfcVO buscarPorCodigoPDF(DistribucionPfcVO distribucionPfcVo) throws ExcepcionDAO;
    public DistribucionPfcVO insertarSiiDistribucionPfc(DistribucionPfcVO distribucionPfcVo) throws ExcepcionDAO ;
    public DistribucionPfcVO actualizarSiiDistribucionPfc(DistribucionPfcVO distribucionPfcVo) throws ExcepcionDAO;
    public void borrarPorCodigoSiiDistribucionPfc(DistribucionPfcVO distribucionPfcVo) throws ExcepcionDAO;
    public List<DistribucionPfcVO> buscarTodoSiiDistribucionPfc() throws ExcepcionDAO;

    public EstadoPfcVO buscarPorEpfCodigo(EstadoPfcVO estadoPfcVo) throws ExcepcionDAO; 
    public EstadoPfcVO insertarSiiEstadoPfc(EstadoPfcVO estadoPfcVo) throws ExcepcionDAO;
    public EstadoPfcVO actualizarSiiEstadoPfc(EstadoPfcVO estadoPfcVo) throws ExcepcionDAO;
    public List<EstadoPfcVO> buscarTodoSiiEstadoPfcVO() throws ExcepcionDAO;
     public EstadoPfcVO buscarEstadoPfcPorNombre(EstadoPfcVO estadoPfcVo) throws ExcepcionDAO; 

    public ProyeccionFlujoCajaVO buscarPorCodigoPFC(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo) throws ExcepcionDAO;
    public ProyeccionFlujoCajaVO insertarProyeccionFC(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo,List<DistribucionPfcVO> listaDistribucion) throws ExcepcionDAO;
    public ProyeccionFlujoCajaVO actualizarSiiProyeccionFlujoCaja(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo) throws ExcepcionDAO;
    public void borrarPorCodigoSiiProyeccionFlujoCaja(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo) throws ExcepcionDAO;
    public List<ProyeccionFlujoCajaVO> buscarTodoSiiProyeccionFlujoCaja() throws ExcepcionDAO;
    public List<ProyeccionFlujoCajaVO> buscarTodoPFCNacion() throws ExcepcionDAO;
    public List<ProyeccionFlujoCajaVO> buscarPFCPorVigencia(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo) throws ExcepcionDAO;
    public List<ProyeccionFlujoCajaVO> buscarPFCPorVigenciayEstado(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo) throws ExcepcionDAO;
    public List<ProyeccionFlujoCajaVO> buscarPFCPorEstado(String estado) throws ExcepcionDAO;
    public List<DistribucionPfcVO> buscarTodoSiiDistribucionPfcXIdDetalleRubro(DetalleRubroVO siiDetalleRubroVo) throws ExcepcionDAO;
    public List<DistribucionPfcVO> buscarTodoSiiDistribucionPfcXVigencia(DetalleRubroVO siiDetalleRubroVo) throws ExcepcionDAO;
    public DistribucionPfcVO buscarDistribucionPfcXVigenciaDetalleR(DistribucionPfcVO distribucionPfcVo) throws ExcepcionDAO;
}

