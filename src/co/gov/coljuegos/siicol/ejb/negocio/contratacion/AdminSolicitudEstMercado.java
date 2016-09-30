package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.vo.AreaColjuegosVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoPfcVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemSolicitudVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoDevolucionVO;



import co.gov.coljuegos.siicol.ejb.vo.RequisitoCritVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local

public interface AdminSolicitudEstMercado {
    public SolicitudEstMercadoVO insertarSolicitudEstMercado(SolicitudEstMercadoVO solicitudEstMercadoVo) throws ExcepcionDAO;
    public SolicitudEstMercadoVO actualizarSolicitudEstMercado(SolicitudEstMercadoVO solicitudEstMercadoVo,ProcesoContratacionVO procesoContratacionVo, List<ItemSolicitudVO> listaAgregarItemPlanContratacVo,
            List<ItemSolicitudVO> listaEliminarItemPlanContratacVo, UsuarioVO usuarioLogueado)
            throws ExcepcionDAO, ExcepcionAplicacion;
    public SolicitudEstMercadoVO buscarSolicitudEstMercadoPorId(SolicitudEstMercadoVO solicitudEstMercadoVo) throws ExcepcionDAO;
    public List<SolicitudEstMercadoVO> buscarSolicitudesEstMercadoPorArea(AreaColjuegosVO unAreaColjuegosVo) throws ExcepcionDAO;
    public List<SolicitudEstMercadoVO> buscarSolicitudEMPorIdProcesoContratacion(ProcesoContratacionVO unProcesoContratacion) throws ExcepcionDAO;
    public List<SolicitudEstMercadoVO> buscarSolicitudesEstMercadoPorEstado(EstadoSolEstMercadoVO unEstadoSolicitudVo) throws ExcepcionDAO;
    public List<SolicitudEstMercadoVO> buscarTodoSolicitudEstMercado() throws ExcepcionDAO;
    public SolicitudEstMercadoVO insertarSolicitudEstMercadoConItemSolicitud (SolicitudEstMercadoVO solicitudEstMercadoVo,ProcesoContratacionVO unProContratacionVo,
                                                                              UsuarioVO usuarioLogueado) throws ExcepcionDAO;
    public List<SolicitudEstMercadoVO> buscarSolicitudesEstMercadoPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO;
    public List<MotivoDevolucionVO> buscarTodoMotivoDevolucionSEM() throws ExcepcionDAO;
    public MotivoDevolucionVO buscarMotivoDevolucionSEMPorId(Long idmotivoDevolucionVo) throws ExcepcionDAO;
    public MotivoDevolucionVO buscarEstadoMotivoDevPorNombre(MotivoDevolucionVO motivoDevolucionVo) throws ExcepcionDAO; 
  
    
}
