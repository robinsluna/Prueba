package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoResolucAut;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoApuesta;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoNovedad;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado.AdminInventario;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionFinancResolAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionGctResolucAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionFinancResolAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionGctResolucAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminResolucionAutorizBean implements AdminResolucionAutoriz {
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ResolucionAutorizDAO resolucionAutorizDAO;
    @EJB
    EstadoContratoDAO estadoContratoDao;
    @EJB
    EstadoSolicAutorizDAO estadoSolicAutorizDao;
    @EJB
    ContratoDAO contratoDao;
    @EJB
    SolicitudAutorizaDAO solicitudAutorizaDao;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    MetDAO metDao;
    @EJB
    NovedadDAO novedadDao;
    @EJB
    RevisionFinancResolAutorizDAO adminRevisionFinancResolAutorizDao;
    @EJB
    RevisionGctResolucAutorizaDAO adminRevisionGctResolucAutorizaDao;
    @EJB
    AdminInventario adminInventario;


    public AdminResolucionAutorizBean() {

    }

    public List<ResolucionAutorizVO> buscarTodaResolucionAutoriz() throws ExcepcionDAO {
        List<ResolucionAutorizVO> resolucionesAutorizVo = new ArrayList();
        List<SiiResolucionAutoriz> resolucionesAutoriz = resolucionAutorizDAO.buscarTodaResolucionAutoriz();
        for (SiiResolucionAutoriz resolucionAutoriz : resolucionesAutoriz) {
            resolucionesAutorizVo.add(new ResolucionAutorizVO(resolucionAutoriz));
        }
        return resolucionesAutorizVo;
    }

    public List<ResolucionAutorizVO> buscarTodaResolucionAutorizLeftJoinSolicitudAutoriza() throws ExcepcionDAO {
        List<ResolucionAutorizVO> resolucionesAutorizVo = new ArrayList();
        List<SiiResolucionAutoriz> resolucionesAutoriz = resolucionAutorizDAO.buscarTodaResolucionAutorizLeftJoinSolicitudAutoriza();
        for (SiiResolucionAutoriz resolucionAutoriz : resolucionesAutoriz) {
            resolucionesAutorizVo.add(new ResolucionAutorizVO(resolucionAutoriz));
        }
        return resolucionesAutorizVo;
    }

    public List<SolicitudAutorizaVO> buscarTodaSolicitudAutorizLeftJoinResolucionAutoriz() throws ExcepcionDAO {
        List<SolicitudAutorizaVO> solicitudesAutorizaVo = new ArrayList();
        List<SiiSolicitudAutoriza> solicitudesAutoriza = resolucionAutorizDAO.buscarTodaSolicitudAutorizLeftJoinResolucionAutoriz();
        for (SiiSolicitudAutoriza solicitudAutoriza : solicitudesAutoriza) {
            solicitudesAutorizaVo.add(new SolicitudAutorizaVO(solicitudAutoriza));
        }
        return solicitudesAutorizaVo;
    }

    public List<ResolucionAutorizVO> buscarTodaResolucionAutorizOuterJoinSolicitudes() throws ExcepcionDAO {
        List<ResolucionAutorizVO> resolucionesAutorizVo = new ArrayList();
        List<SiiResolucionAutoriz> resolucionesAutoriz = resolucionAutorizDAO.buscarTodaResolucionAutorizOuterJoinSolicitudes();
        for (SiiResolucionAutoriz resolucionAutoriz : resolucionesAutoriz) {
            resolucionesAutorizVo.add(new ResolucionAutorizVO(resolucionAutoriz));
        }
        return resolucionesAutorizVo;

    }

    public ResolucionAutorizVO guardarResolucion(ResolucionAutorizVO resolucionAutorizVO, UsuarioVO usuarioLogueado, boolean cambioEstado, Connection conn) throws ExcepcionDAO, ExcepcionAplicacion,
                                                                                                                                                                   SQLException,
                                                                                                                                                                   ClassNotFoundException {
        SiiResolucionAutoriz resolucionAutoriz = new SiiResolucionAutoriz();

        if (resolucionAutorizVO.getRauCodigo() == null && EnumEstadoResolucAut.PROYECTADO.getId().equals(resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo())) {
            resolucionAutoriz = resolucionAutorizDAO.insetarResolucionAutoriz(conversionVoEntidad.convertir(resolucionAutorizVO));
            resolucionAutorizVO.setRauCodigo(resolucionAutoriz.getRauCodigo());

        }
        else {
            resolucionAutoriz = resolucionAutorizDAO.actualizarResolucionAutoriz(conversionVoEntidad.convertir(resolucionAutorizVO));
        }
        if (EnumEstadoResolucAut.PROYECTADO.getId().equals(resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo())) {
            if (resolucionAutorizVO.getSolicitudAutorizaVO().getNovedadListVo() != null) {
                for (NovedadVO novVo : resolucionAutorizVO.getSolicitudAutorizaVO().getNovedadListVo()) {
                    if (novVo.getTipoNovedad().getTnoCodigo().equals(EnumTipoNovedad.ADICION_ELEMENTOS.getId()) ||
                        novVo.getTipoNovedad().getTnoCodigo().equals(EnumTipoNovedad.REEMPLAZO_ELEMENTOS.getId())) {
                        if (novVo.getInventarioVoList() == null || novVo.getInventarioVoList().size() == 0) {
                            novVo.setInventarioVoList(adminInventario.buscarInventarioPorNovedad(novVo.getNovCodigo()));
                        }

                        for (InventarioVO inv : novVo.getInventarioVoList()) {
                            if ((inv.getTipoApuestaVo().getTapCodigo().equals(EnumTipoApuesta.MAQUINAS_ELECTRONICAS_TRAGAMONEDAS_CON_APUESTA_HASTA_500.getId()) ||
                                 inv.getTipoApuestaVo().getTapCodigo().equals(EnumTipoApuesta.MAQUINAS_ELECTRONICAS_TRAGAMONEDAS_CON_APUESTA_MAYOR_A_500.getId()) ||
                                 inv.getTipoApuestaVo().getTapCodigo().equals(EnumTipoApuesta.MAQUINAS_ELECTRONICAS_TRAGAMONEDAS_CON_APUESTA_PROGRESIVA.getId())) &&
                                (inv.getInstrumentoVo().getMetVo() != null && inv.getInstrumentoVo().getMetVo().getMetUid() == null)) {

                                inv.getInstrumentoVo().getMetVo().setMetUid(calcularNuid(conn));

                                metDao.actualizarSiiMet(conversionVoEntidad.convertir(inv.getInstrumentoVo().getMetVo()));

                            }

                        }

                    }

                }

                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }


            }

            actualizarSolicitudAutoriza(EnumEstadoSolicitudAutoriza.RESOLUCION_AUTORIZACION_EN_TRAMITE.getId(), resolucionAutorizVO, usuarioLogueado);
        }
        else if (EnumEstadoResolucAut.EN_FIRME.getId().equals(resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo())) {
            if (resolucionAutorizVO.getSolicitudAutorizaVO().getTipoSolicAutorizaVo().getTsaCodigo().equals(EnumTipoSolicitudAutoriza.TRASLADO_AUTOMATICO.getId()) ||
                (resolucionAutorizVO.getSolicitudAutorizaVO().getTipoSolicAutorizaVo().getTsaCodigo().equals(EnumTipoSolicitudAutoriza.OTRAS_NOVEDADES.getId()) &&
                 (resolucionAutorizVO.getSolicitudAutorizaVO().getSauAmpliacion() == null))) {
                actualizarSolicitudAutoriza(EnumEstadoSolicitudAutoriza.PROCESO_FINALIZADO_EN_RESOLUCION.getId(), resolucionAutorizVO, usuarioLogueado);
                adminInventario.actualizarInventarioXTipoSolicitudYTipoNovedad(null, resolucionAutorizVO.getSolicitudAutorizaVO(), resolucionAutorizVO.getRauFechaResFirme());
            }
            else {
                actualizarSolicitudAutoriza(EnumEstadoSolicitudAutoriza.RESOLUCION_AUTORIZACION.getId(), resolucionAutorizVO, usuarioLogueado);
            }

        }
        if (cambioEstado) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.RESOLUCION_AUTORIZACION_LOCALIZADOS.getId(), resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo(), usuarioLogueado,
                                                         resolucionAutorizVO.getRauCodigo());
        }
        List<RevisionFinancResolAutorizVO> revisionesFinanVo = resolucionAutorizVO.getRevisionFinancResolAutorizListVo();
        if (EnumEstadoResolucAut.VALIDADO_FINANCIERA.getId().equals(resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo()) ||
            EnumEstadoResolucAut.NO_VALIDADO_FINANCIERA.getId().equals(resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo())) {
            for (RevisionFinancResolAutorizVO rev : revisionesFinanVo) {
                rev.setResolucionAutorizVo(resolucionAutorizVO);
                if (rev.getRfrCodigo() == null) {
                    rev = new RevisionFinancResolAutorizVO(adminRevisionFinancResolAutorizDao.insertarRevisionFinancResolAutoriz(conversionVoEntidad.convertir(rev)));
                }
                else {
                    rev = new RevisionFinancResolAutorizVO(adminRevisionFinancResolAutorizDao.actualizarRevisionFinancResolAutoriz(conversionVoEntidad.convertir(rev)));
                }

            }

            resolucionAutorizVO.setRevisionFinancResolAutorizListVo(revisionesFinanVo);

        }

        List<RevisionGctResolucAutorizaVO> revisionesGctVo = resolucionAutorizVO.getRevisionGctResolucAutorizaListVo();

        if (EnumEstadoResolucAut.VALIDADO_GCT.getId().equals(resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo()) ||
            EnumEstadoResolucAut.NO_VALIDADO_GCT.getId().equals(resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo())) {
            for (RevisionGctResolucAutorizaVO rev : revisionesGctVo) {
                rev.setResolucionAutorizVo(resolucionAutorizVO);
                if (rev.getRgrCodigo() == null) {
                    rev = new RevisionGctResolucAutorizaVO(adminRevisionGctResolucAutorizaDao.insertarRevisionGctResolucAutoriza(conversionVoEntidad.convertir(rev)));
                }
                else {
                    rev = new RevisionGctResolucAutorizaVO(adminRevisionGctResolucAutorizaDao.actualizarRevisionGctResolucAutoriza(conversionVoEntidad.convertir(rev)));
                }
            }

            resolucionAutorizVO.setRevisionGctResolucAutorizaListVo(revisionesGctVo);
        }


        return new ResolucionAutorizVO(resolucionAutoriz);
    }

    private String calcularNuid(Connection conn) throws ExcepcionDAO, SQLException, ClassNotFoundException {

        return metDao.generarNuc(conn);


    }

    private int contarUidsPorGenerar(NovedadVO novVo) {
        int totalUids = 0;
        for (InventarioVO inv : novVo.getInventarioVoList()) {
            if ((inv.getTipoApuestaVo().getTapCodigo().equals(EnumTipoApuesta.MAQUINAS_ELECTRONICAS_TRAGAMONEDAS_CON_APUESTA_HASTA_500.getId()) ||
                 inv.getTipoApuestaVo().getTapCodigo().equals(EnumTipoApuesta.MAQUINAS_ELECTRONICAS_TRAGAMONEDAS_CON_APUESTA_MAYOR_A_500.getId()) ||
                 inv.getTipoApuestaVo().getTapCodigo().equals(EnumTipoApuesta.MAQUINAS_ELECTRONICAS_TRAGAMONEDAS_CON_APUESTA_PROGRESIVA.getId())) &&
                (inv.getInstrumentoVo().getMetVo() != null && inv.getInstrumentoVo().getMetVo().getMetUid() == null)) {
                totalUids = totalUids + 1;

            }

        }
        return totalUids;
    }


    /**
     * @author Modifica Giovanni
     * @param estado
     * @param resolucionAutorizVO
     * @param usuarioLogueado
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void actualizarSolicitudAutoriza(Long estado, ResolucionAutorizVO resolucionAutorizVO, UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiResolucionAutoriz siiResolucionAutoriz = new SiiResolucionAutoriz();
        siiResolucionAutoriz = resolucionAutorizDAO.buscarResolucionAutorizPorId(resolucionAutorizVO.getRauCodigo());
        if (siiResolucionAutoriz.getSiiEstadoResolucAut().getEraCodigo() != resolucionAutorizVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del resolucion autorizacion fue cambiado durante la modificación. Seleccione nuevamente la resolucion autorizacion");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo() != resolucionAutorizVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.RESOLUCION_AUTORIZACION_LOCALIZADOS.getId(), resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo(), usuarioLogueado,
                                                         resolucionAutorizVO.getRauCodigo());
        }

        EstadoSolicAutorizVO estadoSolicAutorizVo = new EstadoSolicAutorizVO();
        SolicitudAutorizaVO solicitudAutorizaVo;
        solicitudAutorizaVo = new SolicitudAutorizaVO();
        solicitudAutorizaVo = resolucionAutorizVO.getSolicitudAutorizaVO();
        SiiEstadoSolicAutoriz estadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(estado);
        estadoSolicAutorizVo = new EstadoSolicAutorizVO(estadoSolicAutoriz);
        solicitudAutorizaVo.setEstadoSolicAutoriz(estadoSolicAutorizVo);
        solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solicitudAutorizaVo));
    }

    public List<ResolucionAutorizVO> buscarResolucionAutorizPorSolicitudAutoriza(Long sauCodigo) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz = resolucionAutorizDAO.buscarResolucionAutorizPorSolicitudAutoriza(sauCodigo);
        List<ResolucionAutorizVO> resolucionesAutorizVo = new ArrayList<ResolucionAutorizVO>();
        for (SiiResolucionAutoriz resolucionAutoriz : resolucionesAutoriz) {
            resolucionesAutorizVo.add(new ResolucionAutorizVO(resolucionAutoriz));
        }
        return resolucionesAutorizVo;
    }

    public List<ResolucionAutorizVO> buscarResolucionAutorizPorEstadoSolicitudAutoriza(String estado, String condicionTipoSolicitud) throws ExcepcionDAO {

        List<ResolucionAutorizVO> resolucionesAutorizVo = new ArrayList<ResolucionAutorizVO>();
        for (SiiResolucionAutoriz resolucionAutoriz : resolucionAutorizDAO.buscarResolucionAutorizPorEstadoSolicitudAutoriza(estado, condicionTipoSolicitud)) {
            resolucionesAutorizVo.add(new ResolucionAutorizVO(resolucionAutoriz));
        }
        return resolucionesAutorizVo;

    }

    public List<ResolucionAutorizVO> buscarResolucionAutorizPorEstadoSolicitudAutoriza(Long estado, String condicionTipoSolicitud) throws ExcepcionDAO {

        List<ResolucionAutorizVO> resolucionesAutorizVo = new ArrayList<ResolucionAutorizVO>();
        for (SiiResolucionAutoriz resolucionAutoriz : resolucionAutorizDAO.buscarResolucionAutorizPorEstadoSolicitudAutoriza(estado, condicionTipoSolicitud)) {
            resolucionesAutorizVo.add(new ResolucionAutorizVO(resolucionAutoriz));
        }
        return resolucionesAutorizVo;

    }

    public List<ResolucionAutorizVO> resolucionesAutorizPorEstadoSolicitudPorUsuario(String estado, String condicionTipoSolicitud, Long usuCodigo) throws ExcepcionDAO {
        List<ResolucionAutorizVO> resolucionesAutorizVo = new ArrayList<ResolucionAutorizVO>();
        for (SiiResolucionAutoriz resolucionAutoriz : resolucionAutorizDAO.resolucionesAutorizPorEstadoSolicitudPorUsuario(estado, condicionTipoSolicitud, usuCodigo)) {
            resolucionesAutorizVo.add(new ResolucionAutorizVO(resolucionAutoriz));
        }
        return resolucionesAutorizVo;
    }

    public List<ResolucionAutorizVO> resolucionesAutorizPorEstadoSolicitudPorUsuario(Long estado, String condicionTipoSolicitud, Long usuCodigo) throws ExcepcionDAO {
        List<ResolucionAutorizVO> resolucionesAutorizVo = new ArrayList<ResolucionAutorizVO>();
        for (SiiResolucionAutoriz resolucionAutoriz : resolucionAutorizDAO.resolucionesAutorizPorEstadoSolicitudPorUsuario(estado, condicionTipoSolicitud, usuCodigo)) {
            resolucionesAutorizVo.add(new ResolucionAutorizVO(resolucionAutoriz));
        }
        return resolucionesAutorizVo;
    }

    public List<ResolucionAutorizVO> buscarResolucionAutorizPorTipoSolicitud(Long tipoSolicitud) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz = resolucionAutorizDAO.buscarResolucionAutorizPorTipoSolicitud(tipoSolicitud);
        List<ResolucionAutorizVO> resolucionesAutorizVo = new ArrayList<ResolucionAutorizVO>();
        for (SiiResolucionAutoriz resolucionAutoriz : resolucionesAutoriz) {
            resolucionesAutorizVo.add(new ResolucionAutorizVO(resolucionAutoriz));
        }
        return resolucionesAutorizVo;

    }

    public List<ResolucionAutorizVO> resolucionesAutorizPorTipoSolicitudPorUsuario(Long tipoSolicitud, Long usuCodigo) throws ExcepcionDAO {
        List<ResolucionAutorizVO> resolucionesVo = new ArrayList<ResolucionAutorizVO>();
        for (SiiResolucionAutoriz resolucion : resolucionAutorizDAO.resolucionesAutorizPorTipoSolicitudPorUsuario(tipoSolicitud, usuCodigo)) {
            resolucionesVo.add(new ResolucionAutorizVO(resolucion));
        }
        return resolucionesVo;
    }


}
