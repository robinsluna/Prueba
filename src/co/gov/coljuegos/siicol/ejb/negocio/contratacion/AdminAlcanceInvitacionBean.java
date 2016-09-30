package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AlcanceInvitacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReqAlcanceInvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAlcanceInvitacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AlcanceInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ReqAlcanceInvVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminAlcanceInvitacionBean implements AdminAlcanceInvitacion {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AlcanceInvitacionDAO alcanceInvitacionDAO;
    @EJB
    private ReqAlcanceInvDAO reqAlcanceInvDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;

    public AdminAlcanceInvitacionBean() {
    }

    public AlcanceInvitacionVO buscarUltimoAlcanceInvitacionPorProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO {
        SiiAlcanceInvitacion localAlcanceInvitacion =
            alcanceInvitacionDAO.buscarUltimoAlcanceInvitacionPorProcesoContratacion(idProcesoContratacion);
        if (localAlcanceInvitacion != null) {
            return new AlcanceInvitacionVO(localAlcanceInvitacion);


        } else {
            return new AlcanceInvitacionVO();
        }

    }

    public AlcanceInvitacionVO insertarAlcanceInvitacion(AlcanceInvitacionVO alcanceInvitacionVo) throws ExcepcionDAO {
        return new AlcanceInvitacionVO(alcanceInvitacionDAO.insertarAlcanceInvitacion(conversionVoEntidad.convertir(alcanceInvitacionVo)));

    }

    /**
     * @author Modifica Giovanni
     * @param alcanceInvitacionVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public AlcanceInvitacionVO actualizarAlcanceInvitacion(AlcanceInvitacionVO alcanceInvitacionVo,
                                                           UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                             ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiAlcanceInvitacion siiAlcanceInvitacion = new SiiAlcanceInvitacion();
        siiAlcanceInvitacion = alcanceInvitacionDAO.buscarAlcanceInvitacionPorId(alcanceInvitacionVo.getAliCodigo());
        if (siiAlcanceInvitacion.getSiiEstadoAlcanceInv().getEaiCodigo() != alcanceInvitacionVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del alcance invitacion fue cambiado durante la modificación. Seleccione nuevamente el alcance de invitacion");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (alcanceInvitacionVo.getEstadoAlcanceInvVo().getEaiCodigo() != alcanceInvitacionVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ALCANCE_INVITACION_PROCESO_SELECCION_DIRECTA_CERRADA.getId(),
                                                         alcanceInvitacionVo.getEstadoAlcanceInvVo().getEaiCodigo(),
                                                         usuarioLogueado, alcanceInvitacionVo.getAliCodigo());
        }

        return new AlcanceInvitacionVO(alcanceInvitacionDAO.actualizarAlcanceInvitacion(conversionVoEntidad.convertir(alcanceInvitacionVo)));
    }

    public void eliminarAlcanceInvitacion(Long idAlcanceInvitacion) throws ExcepcionDAO {
        alcanceInvitacionDAO.eliminarAlcanceInvitacion(idAlcanceInvitacion);
    }

    /**
     * @author Modifica Giovanni
     * @param alcanceInvitacionVo
     * @param usuarioLogueado
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public void guardarAlcanceInvitacion(AlcanceInvitacionVO alcanceInvitacionVo,
                                         UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {
        AlcanceInvitacionVO localAlcanceInvitacionVo;
        if (alcanceInvitacionVo.getAliCodigo() == null) {
            localAlcanceInvitacionVo =
                new AlcanceInvitacionVO(alcanceInvitacionDAO.insertarAlcanceInvitacion(conversionVoEntidad.convertir(alcanceInvitacionVo)));
            alcanceInvitacionVo.setAliCodigo(localAlcanceInvitacionVo.getAliCodigo());

        } else {

            /*
             * Manejo de error de concurrencia
             */
            /*SiiAlcanceInvitacion siiAlcanceInvitacion = new SiiAlcanceInvitacion();
            siiAlcanceInvitacion =
                alcanceInvitacionDAO.buscarAlcanceInvitacionPorId(alcanceInvitacionVo.getAliCodigo());
            if (siiAlcanceInvitacion.getSiiEstadoAlcanceInv().getEaiCodigo() !=
                alcanceInvitacionVo.getIdEstadoAnterior()) {
                throw new ExcepcionAplicacion("Error de concurrencia: El estado del alcance invitacion fue cambiado durante la modificación. Seleccione nuevamente el alcance de invitacion");
            }*/

            /*
             * Registro del log de estados esto solo si el estado tuvo un cambio
             */
            if (alcanceInvitacionVo.getEstadoAlcanceInvVo().getEaiCodigo() !=
                alcanceInvitacionVo.getIdEstadoAnterior()) {
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ALCANCE_INVITACION_PROCESO_SELECCION_DIRECTA_CERRADA.getId(),
                                                             alcanceInvitacionVo.getEstadoAlcanceInvVo().getEaiCodigo(),
                                                             usuarioLogueado, alcanceInvitacionVo.getAliCodigo());
            }

            localAlcanceInvitacionVo =
                new AlcanceInvitacionVO(alcanceInvitacionDAO.actualizarAlcanceInvitacion(conversionVoEntidad.convertir(alcanceInvitacionVo)));

        }

        for (ReqAlcanceInvVO reqAlcanceInvVo : alcanceInvitacionVo.getReqAlcanceInvListVo()) {
            //            reqAlcanceInvVo.setAlcanceInvitacionVo(alcanceInvitacionVo);
            if (reqAlcanceInvVo.getRaiCodigo() == null) {
                reqAlcanceInvDao.insertarReqAlcanceInv(conversionVoEntidad.convertir(reqAlcanceInvVo));
            } else {
                reqAlcanceInvDao.actualizarReqAlcanceInv(conversionVoEntidad.convertir(reqAlcanceInvVo));
            }

        }
    }

}
