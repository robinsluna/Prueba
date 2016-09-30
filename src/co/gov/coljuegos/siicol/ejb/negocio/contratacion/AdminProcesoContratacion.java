package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.FirmasMinutaVO;
import co.gov.coljuegos.siicol.ejb.vo.MinutaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminProcesoContratacion {
    public ProcesoContratacionVO insertarProcesoContratacion(ProcesoContratacionVO procesoContratacionVo) throws ExcepcionDAO;

    public ProcesoContratacionVO buscarProcesoContratacionPorId(ProcesoContratacionVO procesoContratacionVo) throws ExcepcionDAO;

    public List<ProcesoContratacionVO> buscarProcesoContratacionPorEstado(String estado) throws ExcepcionDAO;

    public List<ProcesoContratacionVO> buscarProcesoContratacionDescPorEstado(String estado) throws ExcepcionDAO;
    
    /**
     * @author Modifica Giovanni
     * @param procesoContratacionVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public ProcesoContratacionVO actualizarProcesoContratacion(ProcesoContratacionVO procesoContratacionVo,
                                                               UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                 ExcepcionAplicacion;

    public List<ProcesoContratacionVO> buscarTodoProcesoContratacion() throws ExcepcionDAO;

    public List<ProcesoContratacionVO> procesosContratacionConSolicitudAprobada() throws ExcepcionDAO;

    public List<ProcesoContratacionVO> buscarProcesoContratacionConEstado() throws ExcepcionDAO;

    public List<MinutaVO> buscarProcesoContratacionPorIdMinuta(Long idProcesoContratacion) throws ExcepcionDAO;

    public List<FirmasMinutaVO> buscarFirmasDocumentosMinuta() throws ExcepcionDAO;

    public String ConvertirNumeroALetra(BigDecimal numero) throws ExcepcionDAO;

    public List<ProcesoContratacionVO> buscarProcesoContratacionSolicitudCdp() throws ExcepcionDAO;
    
    public BigDecimal presupuestoItemPlanPorProcesoContratacion(Long prcCodigo) throws ExcepcionDAO;
}
