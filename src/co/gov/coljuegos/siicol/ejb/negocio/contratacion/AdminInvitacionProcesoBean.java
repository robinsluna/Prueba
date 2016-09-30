package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InvitacionProcesoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProveedorInvitacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInvitacionProceso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedorInvitacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ImprimirInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.InvitacionProcesoVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminInvitacionProcesoBean implements AdminInvitacionProceso {

    @EJB
    private InvitacionProcesoDAO invitacionProcesoDAO;
    @EJB
    private ProveedorInvitacionDAO proveedorInvitacionDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private ProcesoContratacionDAO procesoContratacionDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;

    public AdminInvitacionProcesoBean() {
    }

    public InvitacionProcesoVO buscarInvitacionProcesoPorId(Long iprCodigo) throws ExcepcionDAO {
        SiiInvitacionProceso invitacion = invitacionProcesoDAO.buscarInvitacionProcesoPorId(iprCodigo);
        InvitacionProcesoVO invitacionProcesoVO;
        if (invitacion != null) {
            invitacionProcesoVO = new InvitacionProcesoVO(invitacion);
        } else {
            invitacionProcesoVO = new InvitacionProcesoVO();
        }

        return invitacionProcesoVO;
    }

    public InvitacionProcesoVO insertarInvitacionProceso(InvitacionProcesoVO invitacionProcesoVO) throws ExcepcionDAO {
        // se inserta la invitación
        SiiInvitacionProceso siiInvitacionProceso = conversionVoEntidad.convertir(invitacionProcesoVO);
        SiiInvitacionProceso resultadoSiiInvitaProceso =
            invitacionProcesoDAO.insertarInvitacionProceso(siiInvitacionProceso);

        List<ProveedorInvitacionVO> listaProveedorInvitacion = invitacionProcesoVO.getProveedorInvitacionListVO();
        for (ProveedorInvitacionVO unProvInvitaVo : listaProveedorInvitacion) {
            SiiProveedorInvitacion siiProvInvita = conversionVoEntidad.convertir(unProvInvitaVo);
            siiProvInvita.setSiiInvitacionProceso(resultadoSiiInvitaProceso);
            proveedorInvitacionDao.insertarProveedorInvitacion(siiProvInvita);
        }

        return new InvitacionProcesoVO(resultadoSiiInvitaProceso);

    }

    /**
     * @author Modifica Giovanni
     * @param invitacionProcesoVO
     * @param usuarioLogueado
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public void actualizarInvitacionProceso(InvitacionProcesoVO invitacionProcesoVO,
                                            UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        SiiInvitacionProceso siiInvitacionProcesoTemp = new SiiInvitacionProceso();
        siiInvitacionProcesoTemp =
            invitacionProcesoDAO.buscarInvitacionProcesoPorId(invitacionProcesoVO.getIprCodigo());
        if (siiInvitacionProcesoTemp.getSiiEstadoInvitacion().getEinCodigo() !=
            invitacionProcesoVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de la invitacion proceso fue cambiado durante la modificación. Seleccione nuevamente la invitacion proceso");
        }

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (invitacionProcesoVO.getEstadoInvitacionVO().getEinCodigo() != invitacionProcesoVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.INVITACION_PROCESO_SELECCION_DIRECTA_CERRADA.getId(),
                                                         invitacionProcesoVO.getEstadoInvitacionVO().getEinCodigo(),
                                                         usuarioLogueado, invitacionProcesoVO.getIprCodigo());
        }

        // se actualiza la invitación
        SiiInvitacionProceso siiInvitacionProceso = conversionVoEntidad.convertir(invitacionProcesoVO);
        SiiInvitacionProceso resultadoSiiInvitaProceso =
            invitacionProcesoDAO.actualizarInvitacionProceso(siiInvitacionProceso);

        // Se Busca si ya existen los hijos antes de insertarlos
        List<SiiProveedorInvitacion> miListaSiiProvInvitaReg = new ArrayList<SiiProveedorInvitacion>();
        if (invitacionProcesoVO.getIprCodigo() != null) {
            miListaSiiProvInvitaReg =
                proveedorInvitacionDao.buscarTodoProveedorInvitacionPorInvitacion(Integer.valueOf((invitacionProcesoVO.getIprCodigo()).toString()));
        }

        // Se insertan los hijos si no estan registrados
        if (invitacionProcesoVO.getProveedorInvitacionListVO() != null) {
            List<ProveedorInvitacionVO> listaProveedorInvitacion = invitacionProcesoVO.getProveedorInvitacionListVO();
            for (ProveedorInvitacionVO unProvInvitaVo : listaProveedorInvitacion) {
                SiiProveedorInvitacion siiProvInvita = conversionVoEntidad.convertir(unProvInvitaVo);
                for (SiiProveedorInvitacion unSiiProvInvitaReg : miListaSiiProvInvitaReg) {
                    if (!(unSiiProvInvitaReg.getSiiProveedor().getProCodigo()).equals(unSiiProvInvitaReg.getSiiProveedor().getProCodigo())) {
                        siiProvInvita.setSiiInvitacionProceso(resultadoSiiInvitaProceso);
                        proveedorInvitacionDao.insertarProveedorInvitacion(siiProvInvita);
                    }

                }
                // se actualiza los nombres de los proveedores (siiPersona)
                ProveedorVO unProvVo = unProvInvitaVo.getProveedorVO();
                if (unProvVo != null) {
                    SiiPersona siiPersona = conversionVoEntidad.convertir(unProvVo.getPersonaVo());
                    personaDao.actualizarPersona(siiPersona);
                }
            }
        }
        // Se actualiza el estado del proceso de contratacion
        if (invitacionProcesoVO.getProcesoContratacionVO() != null) {
            SiiProcesoContratacion unProceso =
                conversionVoEntidad.convertir(invitacionProcesoVO.getProcesoContratacionVO());
            procesoContratacionDao.actualizarProcesoContratacion(unProceso);
        }
    }

    public List<InvitacionProcesoVO> buscarInvitacionProcesoPorProceso(InvitacionProcesoVO invitacionProcesoVO) throws ExcepcionDAO {
        List<SiiInvitacionProceso> listaInvitacionProceso =
            invitacionProcesoDAO.buscarInvitacionProcesoPorProceso(conversionVoEntidad.convertir(invitacionProcesoVO));
        List<InvitacionProcesoVO> listaInvitacionProcesoVO = new ArrayList<InvitacionProcesoVO>();

        for (SiiInvitacionProceso unaInvitacionProceso : listaInvitacionProceso) {
            InvitacionProcesoVO invitaProcVo = new InvitacionProcesoVO(unaInvitacionProceso);
            if (unaInvitacionProceso.getSiiProcesoContratacion() != null) {
                ProcesoContratacionVO procesoVo =
                    new ProcesoContratacionVO(unaInvitacionProceso.getSiiProcesoContratacion());
                invitaProcVo.setProcesoContratacionVO(procesoVo);
                listaInvitacionProcesoVO.add(invitaProcVo);
            }

        }


        return listaInvitacionProcesoVO;
    }

    public List<InvitacionProcesoVO> buscarTodaInvitacionProceso(InvitacionProcesoVO invitacionProcesoVO) throws ExcepcionDAO {
        List<SiiInvitacionProceso> listaInvitacionProceso =
            invitacionProcesoDAO.buscarTodaInvitacionProceso(conversionVoEntidad.convertir(invitacionProcesoVO));
        List<InvitacionProcesoVO> listaInvitacionProcesoVO = new ArrayList();
        for (SiiInvitacionProceso unaInvitacionProceso : listaInvitacionProceso) {
            listaInvitacionProcesoVO.add(new InvitacionProcesoVO(unaInvitacionProceso));
        }
        return listaInvitacionProcesoVO;
    }

    public ImprimirInvitacionVO buscarDatosImpresionInvitacion(Integer idInvitacion) throws ExcepcionDAO {
        ImprimirInvitacionVO ImpresionInvitacion = invitacionProcesoDAO.buscarDatosImpresionInvitacion(idInvitacion);
        return ImpresionInvitacion;
    }

    public PersonaVO buscarDatosFuncionarioImpresion(Long codigoFuncionario) throws ExcepcionDAO {
        PersonaVO persona = invitacionProcesoDAO.buscarDatosFuncionarioImpresion(codigoFuncionario);
        return persona;
    }

    public List<InvitacionProcesoVO> buscarProcesoContratacionInvitacion() throws ExcepcionDAO {
        List<InvitacionProcesoVO> listaProcesoInvitacion = invitacionProcesoDAO.buscarProcesoContratacionInvitacion();
        return listaProcesoInvitacion;
    }
    
    
    @Override
    public List<InvitacionProcesoVO> buscarInvitacionProcesoPorProceso(Long prcCodigo) throws ExcepcionDAO 
    {
        List<InvitacionProcesoVO> resultado = null;
        List<SiiInvitacionProceso> lista = invitacionProcesoDAO.buscarInvitacionProcesoPorProceso(prcCodigo);
        if (lista!=null) {
            resultado = new ArrayList<InvitacionProcesoVO>();
            for (SiiInvitacionProceso siiInvitacionProceso: lista) {
                if (siiInvitacionProceso!=null)
                    resultado.add(new InvitacionProcesoVO(siiInvitacionProceso));
            }
        }
        
        return (resultado);
    }
}
