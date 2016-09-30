package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModifRpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificacionRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionRp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ModifRpDetRubCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificacionRpVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminModificacionRpBean implements AdminModificacionRp {
    @EJB
    private ModificacionRpDAO modificacionRpDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ModifRpDetRubCdpDAO modifRpDetRubRpDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;


    public AdminModificacionRpBean() {

    }

    public ModificacionRpVO buscarUltimaModificacionRp(Long rpCodigo) throws ExcepcionDAO {
        SiiModificacionRp modificacionRp = modificacionRpDao.buscarUltimaModificacionRp(rpCodigo);
        if (modificacionRp != null) {
            return new ModificacionRpVO(modificacionRp);
        } else {
            return new ModificacionRpVO();
        }

    }

    /**
     * @author Modifica Giovanni
     * @param decrementoRpVo
     * @param usuarioLogueado
     * @param cambioEstado
     * @return
     * @throws ExcepcionDAO
     */
    public ModificacionRpVO guardarDecrementoRp(ModificacionRpVO decrementoRpVo, UsuarioVO usuarioLogueado,
                                                boolean cambioEstado) throws ExcepcionDAO, ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiModificacionRp siiModificacionRp = new SiiModificacionRp();
        siiModificacionRp = modificacionRpDao.buscarModificacionRpPorId(decrementoRpVo.getMrpCodigo());
        if (siiModificacionRp.getSiiEstadoModificRp().getEmrCodigo() != decrementoRpVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del del rp fue cambiado durante la modificación. Seleccione nuevamente la modificacion del rp");
        }*/

        List<ModifRpDetRubCdpVO> listaModifRpDetRubCdpVO = decrementoRpVo.getListaModifRpDetRubCdpVo();
        if (decrementoRpVo.getMrpCodigo() == null &&
            "BORRADOR".equals(decrementoRpVo.getEstadoModificRpVo().getEmrNombre())) {
            decrementoRpVo.setMrpConsecutivo(modificacionRpDao.siguienteNumeroModificacionRp(decrementoRpVo.getMrpTipoModif(),
                                                                                             Integer.valueOf(decrementoRpVo.getRpVo().getRpConsecutivo().toString().substring(0, 4))));
            decrementoRpVo =
                new ModificacionRpVO(modificacionRpDao.insertarModificacionRp(conversionVoEntidad.convertir(decrementoRpVo)));
        } else {
            decrementoRpVo =
                new ModificacionRpVO(modificacionRpDao.actualizarModifiacionRp(conversionVoEntidad.convertir(decrementoRpVo)));
        }

        if (listaModifRpDetRubCdpVO != null && listaModifRpDetRubCdpVO.size() > 0) {
            for (ModifRpDetRubCdpVO unModifVo : listaModifRpDetRubCdpVO) {
                unModifVo.setModificacionRpVo(decrementoRpVo);
                if (unModifVo.getMrdCodigo() == null) {

                    unModifVo =
                        new ModifRpDetRubCdpVO(modifRpDetRubRpDao.insertarModifRpDetRubCdp(conversionVoEntidad.convertir(unModifVo)));

                } else {
                    unModifVo =
                        new ModifRpDetRubCdpVO(modifRpDetRubRpDao.actualizarModifRpDetRubCdp(conversionVoEntidad.convertir(unModifVo)));
                }

            }

        }
        decrementoRpVo.setListaModifRpDetRubCdpVo(listaModifRpDetRubCdpVO);
        if (cambioEstado) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.DECREMENTO_RP.getId(),
                                                         decrementoRpVo.getEstadoModificRpVo().getEmrCodigo(),
                                                         usuarioLogueado, decrementoRpVo.getMrpCodigo());
        }
        return decrementoRpVo;

    }

    public ModificacionRpVO guardarIncrementoRp(ModificacionRpVO incrementoRpVo, UsuarioVO usuarioLogueado,
                                                boolean cambioEstado) throws ExcepcionDAO, ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiModificacionRp siiModificacionRp = new SiiModificacionRp();
        siiModificacionRp = modificacionRpDao.buscarModificacionRpPorId(decrementoRpVo.getMrpCodigo());
        if (siiModificacionRp.getSiiEstadoModificRp().getEmrCodigo() != decrementoRpVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del del rp fue cambiado durante la modificación. Seleccione nuevamente la modificacion del rp");
        }*/

        List<ModifRpDetRubCdpVO> listaModifRpDetRubCdpVO = incrementoRpVo.getListaModifRpDetRubCdpVo();
        if (incrementoRpVo.getMrpCodigo() == null &&
            "BORRADOR".equals(incrementoRpVo.getEstadoModificRpVo().getEmrNombre())) {
            incrementoRpVo.setMrpConsecutivo(modificacionRpDao.siguienteNumeroModificacionRp(incrementoRpVo.getMrpTipoModif(),
                                                                                             Integer.valueOf(incrementoRpVo.getRpVo().getRpConsecutivo().toString().substring(0, 4))));
            incrementoRpVo =
                new ModificacionRpVO(modificacionRpDao.insertarModificacionRp(conversionVoEntidad.convertir(incrementoRpVo)));
        } else {
            incrementoRpVo =
                new ModificacionRpVO(modificacionRpDao.actualizarModifiacionRp(conversionVoEntidad.convertir(incrementoRpVo)));
        }

        if (listaModifRpDetRubCdpVO != null && listaModifRpDetRubCdpVO.size() > 0) {
            for (ModifRpDetRubCdpVO unModifVo : listaModifRpDetRubCdpVO) {
                unModifVo.setModificacionRpVo(incrementoRpVo);
                if (unModifVo.getMrdCodigo() == null) {

                    unModifVo =
                        new ModifRpDetRubCdpVO(modifRpDetRubRpDao.insertarModifRpDetRubCdp(conversionVoEntidad.convertir(unModifVo)));

                } else {
                    unModifVo =
                        new ModifRpDetRubCdpVO(modifRpDetRubRpDao.actualizarModifRpDetRubCdp(conversionVoEntidad.convertir(unModifVo)));
                }

            }

        }
        incrementoRpVo.setListaModifRpDetRubCdpVo(listaModifRpDetRubCdpVO);
        if (cambioEstado) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.INCREMENTO_RP.getId(),
                                                         incrementoRpVo.getEstadoModificRpVo().getEmrCodigo(),
                                                         usuarioLogueado, incrementoRpVo.getMrpCodigo());
        }
        return incrementoRpVo;

    }

    public List<ModificacionRpVO> decrementosTramitados() throws ExcepcionDAO {
        List<SiiModificacionRp> decrementos = modificacionRpDao.decrementosTramitados();
        List<ModificacionRpVO> listaModificacionRpVo = new ArrayList();
        for (SiiModificacionRp unaModificacionRp : decrementos) {
            listaModificacionRpVo.add(new ModificacionRpVO(unaModificacionRp));
        }
        return listaModificacionRpVo;

    }

    public List<ModificacionRpVO> incrementosTramitados() throws ExcepcionDAO {
        List<ModificacionRpVO> listaModificacionRpVo = new ArrayList();
        for (SiiModificacionRp unaModificacionRp : modificacionRpDao.incrementosTramitados()) {
            listaModificacionRpVo.add(new ModificacionRpVO(unaModificacionRp));
        }
        return listaModificacionRpVo;

    }

}
