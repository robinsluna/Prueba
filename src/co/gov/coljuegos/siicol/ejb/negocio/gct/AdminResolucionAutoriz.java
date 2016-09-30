package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminResolucionAutoriz {
    public List<ResolucionAutorizVO> buscarTodaResolucionAutoriz() throws ExcepcionDAO;
    
    public List<ResolucionAutorizVO> buscarTodaResolucionAutorizLeftJoinSolicitudAutoriza() throws ExcepcionDAO;
    
    public List<SolicitudAutorizaVO> buscarTodaSolicitudAutorizLeftJoinResolucionAutoriz() throws ExcepcionDAO;

    public List<ResolucionAutorizVO> buscarTodaResolucionAutorizOuterJoinSolicitudes() throws ExcepcionDAO;
    
    public ResolucionAutorizVO guardarResolucion(ResolucionAutorizVO resolucionAutorizVO, UsuarioVO usuarioLogueado, boolean cambioEstado, Connection conn) throws ExcepcionDAO, ExcepcionAplicacion,
                                                                                                                                                                   SQLException,
                                                                                                                                                                   ClassNotFoundException ;
    
    public List<ResolucionAutorizVO> buscarResolucionAutorizPorSolicitudAutoriza(Long sauCodigo) throws ExcepcionDAO;
    
    public List<ResolucionAutorizVO> buscarResolucionAutorizPorEstadoSolicitudAutoriza(String estado, String condicionTipoSolicitud) throws ExcepcionDAO;
    
    public List<ResolucionAutorizVO> buscarResolucionAutorizPorEstadoSolicitudAutoriza(Long estado, String condicionTipoSolicitud) throws ExcepcionDAO;
    
    public List<ResolucionAutorizVO> resolucionesAutorizPorEstadoSolicitudPorUsuario(String estado,
                                                                                     String condicionTipoSolicitud, Long usuCodigo) throws ExcepcionDAO;    
    
    public List<ResolucionAutorizVO> resolucionesAutorizPorEstadoSolicitudPorUsuario(Long estado,
                                                                                     String condicionTipoSolicitud, Long usuCodigo) throws ExcepcionDAO;    

    public List<ResolucionAutorizVO> buscarResolucionAutorizPorTipoSolicitud(Long tipoSolicitud) throws ExcepcionDAO;
    
    public List<ResolucionAutorizVO> resolucionesAutorizPorTipoSolicitudPorUsuario(Long tipoSolicitud, Long usuCodigo) throws ExcepcionDAO;

}
