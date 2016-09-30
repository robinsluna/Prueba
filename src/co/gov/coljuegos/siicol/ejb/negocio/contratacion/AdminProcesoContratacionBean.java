package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemPlanContDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.FirmasMinutaVO;
import co.gov.coljuegos.siicol.ejb.vo.MinutaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminProcesoContratacionBean implements AdminProcesoContratacion {
    @Resource
    SessionContext sessionContext;

    @EJB
    private ProcesoContratacionDAO procesoContratacionDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private ItemPlanContDetRubDAO itemPlanContDetRubDao;

    public AdminProcesoContratacionBean() {
    }

    public ProcesoContratacionVO insertarProcesoContratacion(ProcesoContratacionVO procesoContratacionVo) throws ExcepcionDAO {

        SiiProcesoContratacion procesoContratacion = conversionVoEntidad.convertir(procesoContratacionVo);
        SiiProcesoContratacion unProcesoContratacion =
            procesoContratacionDao.insertarProcesoContratacion(procesoContratacion);
        return new ProcesoContratacionVO(unProcesoContratacion);
    }

    public List<ProcesoContratacionVO> buscarTodoProcesoContratacion() throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion;
        listaProcesoContratacion = procesoContratacionDao.buscarTodoProcesoContratacion();
        List<ProcesoContratacionVO> listaProcesoContratacionVo = new ArrayList();
        for (SiiProcesoContratacion unProcesoContratacion : listaProcesoContratacion) {
            listaProcesoContratacionVo.add(new ProcesoContratacionVO(unProcesoContratacion));
        }
        return listaProcesoContratacionVo;
    }
    
    public List<ProcesoContratacionVO> procesosContratacionConSolicitudAprobada() throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion;
        listaProcesoContratacion = procesoContratacionDao.procesosContratacionConSolicitudAprobada();
        List<ProcesoContratacionVO> listaProcesoContratacionVo = new ArrayList();
        for(SiiProcesoContratacion unProcesoContratacion : listaProcesoContratacion){
            listaProcesoContratacionVo.add(new ProcesoContratacionVO(unProcesoContratacion));
        }
        return listaProcesoContratacionVo;        
        
    }
    
    public ProcesoContratacionVO buscarProcesoContratacionPorId(ProcesoContratacionVO procesoContratacionVo) throws ExcepcionDAO{
        SiiProcesoContratacion unProcesoContratacion = procesoContratacionDao.buscarProcesoContratacionPorId(procesoContratacionVo.getPrcCodigo());
        return new ProcesoContratacionVO(unProcesoContratacion);  
    }

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
                                                                                                 ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiProcesoContratacion siiProcesoContratacion = new SiiProcesoContratacion();
        siiProcesoContratacion =
            procesoContratacionDao.buscarProcesoContratacionPorId(procesoContratacionVo.getPrcCodigo());
        if (siiProcesoContratacion.getSiiEstadoProcContrat().getEpcCodigo() !=
            procesoContratacionVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del proceso de contratacion fue cambiado durante la modificación. Seleccione nuevamente el proceso de contratacion");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (procesoContratacionVo.getEstadoProcContrat().getEpcCodigo() !=
            procesoContratacionVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.PROC_CONTRAT.getId(),
                                                         procesoContratacionVo.getEstadoProcContrat().getEpcCodigo(),
                                                         usuarioLogueado, procesoContratacionVo.getPrcCodigo());
        }

        SiiProcesoContratacion procesoContratacion = conversionVoEntidad.convertir(procesoContratacionVo);
        SiiProcesoContratacion unProcesoContratacion =
            procesoContratacionDao.actualizarProcesoContratacion(procesoContratacion);
        return new ProcesoContratacionVO(unProcesoContratacion);
    }

    /*
    public ProcesoContratacionVO eliminarProcesoContratacion(ProcesoContratacionVO procesoContratacionVo) throws ExcepcionDAO{
        SiiProcesoContratacion procesoContratacion = conversionVoEntidad.convertir(procesoContratacionVo);
        SiiProcesoContratacion unProcesoContratacion = procesoContratacionDao.eliminarProcesoContratacion(procesoContratacion);
        ProcesoContratacionVO procesoContratacionVoRetorno = ProcesoContratacionVO.convertirEntiadAVO(unProcesoContratacion);
        return procesoContratacionVoRetorno;
    }*/

    public List<ProcesoContratacionVO> buscarProcesoContratacionPorEstado(String estado) throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion =
            procesoContratacionDao.buscarProcesoContratacionPorEstado(estado);
        List<ProcesoContratacionVO> listaProcesoContratacionVO = new ArrayList();
        for (SiiProcesoContratacion unProcesoContratacion : listaProcesoContratacion) {
            listaProcesoContratacionVO.add(new ProcesoContratacionVO(unProcesoContratacion));
        }
        return listaProcesoContratacionVO;
    }
    
    public List<ProcesoContratacionVO> buscarProcesoContratacionDescPorEstado(String estado) throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion =
            procesoContratacionDao.buscarProcesoContratacionDescPorEstado(estado);
        List<ProcesoContratacionVO> listaProcesoContratacionVO = new ArrayList();
        for (SiiProcesoContratacion unProcesoContratacion : listaProcesoContratacion) {
            listaProcesoContratacionVO.add(new ProcesoContratacionVO(unProcesoContratacion));
        }
        return listaProcesoContratacionVO;        
    }

    public List<ProcesoContratacionVO> buscarProcesoContratacionConEstado() throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion =
            procesoContratacionDao.buscarProcesoContratacionConEstado();
        List<ProcesoContratacionVO> listaProcesoContratacionVO = new ArrayList();
        for (SiiProcesoContratacion unProcesoContratacion : listaProcesoContratacion) {
            listaProcesoContratacionVO.add(new ProcesoContratacionVO(unProcesoContratacion));
        }
        return listaProcesoContratacionVO;

    }

    public List<ProcesoContratacionVO> buscarProcesoContratacionSolicitudCdp() throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion =
            procesoContratacionDao.buscarProcesoContratacionSolicitudCdp();
        List<ProcesoContratacionVO> listaProcesoContratacionVO = new ArrayList();
        for (SiiProcesoContratacion unProcesoContratacion : listaProcesoContratacion) {
            listaProcesoContratacionVO.add(new ProcesoContratacionVO(unProcesoContratacion));
        }
        return listaProcesoContratacionVO;
    }

    public List<MinutaVO> buscarProcesoContratacionPorIdMinuta(Long idProcesoContratacion) throws ExcepcionDAO {
        List<MinutaVO> listaMinutaVo =
            procesoContratacionDao.buscarProcesoContratacionPorIdMinuta(idProcesoContratacion);
        return listaMinutaVo;
    }

    public List<FirmasMinutaVO> buscarFirmasDocumentosMinuta() throws ExcepcionDAO {
        List<FirmasMinutaVO> listaFirmasMinutaVo = procesoContratacionDao.buscarFirmasDocumentosMinuta();
        return listaFirmasMinutaVo;
    }

    public String ConvertirNumeroALetra(BigDecimal numero) throws ExcepcionDAO {
        String letras = "";
        return letras = procesoContratacionDao.ConvertirNumeroALetra(numero);
    }
    
    public BigDecimal presupuestoItemPlanPorProcesoContratacion(Long prcCodigo) throws ExcepcionDAO {
        return itemPlanContDetRubDao.presupuestoItemPlanPorProcesoContratacion(prcCodigo);
    }
}
