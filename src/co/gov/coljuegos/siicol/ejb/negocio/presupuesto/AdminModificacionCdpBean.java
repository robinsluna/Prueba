package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModifCdpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificacionCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionCdp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ModifCdpDetRubCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificacionCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminModificacionCdpBean implements AdminModificacionCdp {

    @EJB
    private ModificacionCdpDAO modificacionCdpDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ModifCdpDetRubCdpDAO modifCdpDetRubCdpDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;


    public AdminModificacionCdpBean() {
    }

    public ModificacionCdpVO buscarUltimaModificacionCdp(Long idCdp) throws ExcepcionDAO {
        SiiModificacionCdp modificacionCdp = modificacionCdpDao.buscarUltimaModificacionCdp(idCdp);
        if (modificacionCdp != null) {
            return new ModificacionCdpVO(modificacionCdp);
        } else {
            return new ModificacionCdpVO();
        }
    }

    public List<ModificacionCdpVO> decrementosTramitados() throws ExcepcionDAO {
        return convertirSiiListaModicacionCdpEnVo(modificacionCdpDao.decrementosTramitados());
    }

    public List<ModificacionCdpVO> incrementosTramitados() throws ExcepcionDAO {
        return convertirSiiListaModicacionCdpEnVo(modificacionCdpDao.incrementosTramitados());

    }
    
    public List<ModificacionCdpVO> incrementosExistentes() throws ExcepcionDAO {
        return convertirSiiListaModicacionCdpEnVo(modificacionCdpDao.incrementosExistentes());

    }
    
    public List<ModificacionCdpVO> decrementosExistentes() throws ExcepcionDAO {
        return convertirSiiListaModicacionCdpEnVo(modificacionCdpDao.decrementosExistentes());
    }

    private List<ModificacionCdpVO> convertirSiiListaModicacionCdpEnVo(List<SiiModificacionCdp> modificaciones) {
        List<ModificacionCdpVO> listaModificacionCdpVo = new ArrayList();
        for (SiiModificacionCdp unaModificacionCdp : modificaciones) {
            listaModificacionCdpVo.add(new ModificacionCdpVO(unaModificacionCdp));
        }
        return listaModificacionCdpVo;
    }
    
    public List<ModificacionCdpVO> buscarModificacionesCdpPorCdp(Long id) throws ExcepcionDAO {
        return convertirSiiListaModicacionCdpEnVo(modificacionCdpDao.buscarModificacionesCdpPorCdp(id));        

    }

    public List<ModificacionCdpVO> buscarDecrementosCdpEnTramite() throws ExcepcionDAO {
        // Excluye a los INCREMENTADO DECREMENTADO Y RECHAZADO
        return convertirSiiListaModicacionCdpEnVo(modificacionCdpDao.buscarDecrementosCdpEnTramite());        

    }


    /**
     * @author Modifica Giovanni
     * @param decrementoCdpVo
     * @param usuarioLogueado
     * @param cambioEstado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public ModificacionCdpVO guardarDecrementoCdp(ModificacionCdpVO decrementoCdpVo, UsuarioVO usuarioLogueado,
                                                  boolean cambioEstado) throws ExcepcionDAO, ExcepcionAplicacion {

        List<ModifCdpDetRubCdpVO> listaModifCdpDetRubCdpVo = decrementoCdpVo.getModifCdpDetRubCdpVoList();
        if (decrementoCdpVo.getMcdCodigo() == null &&
            "BORRADOR".equals(decrementoCdpVo.getEstadoModifCdpVo().getEmcNombre())) {
            decrementoCdpVo.setMcdNumero(modificacionCdpDao.siguienteNumeroModificacionCdp(decrementoCdpVo.getMcdTipoMod(),
                                                                                           decrementoCdpVo.getCdpVo().getCdpVigencia()));
            decrementoCdpVo =
                new ModificacionCdpVO(modificacionCdpDao.insertarModificacionCdp(conversionVoEntidad.convertir(decrementoCdpVo)));
        } else {
            decrementoCdpVo =
                new ModificacionCdpVO(modificacionCdpDao.actualizarModifiacionCdp(conversionVoEntidad.convertir(decrementoCdpVo)));
        }

        if (listaModifCdpDetRubCdpVo != null && listaModifCdpDetRubCdpVo.size() > 0) {
            for (ModifCdpDetRubCdpVO unModifVo : listaModifCdpDetRubCdpVo) {
                unModifVo.setModificacionCdpVo(decrementoCdpVo);
                if (unModifVo.getMcrCodigo() == null) {
                    unModifVo =
                        new ModifCdpDetRubCdpVO(modifCdpDetRubCdpDao.insertarModifCdpDetRubCdp(conversionVoEntidad.convertir(unModifVo)));

                } else {
                    unModifVo =
                        new ModifCdpDetRubCdpVO(modifCdpDetRubCdpDao.actualizarModifCdpDetRubCdp(conversionVoEntidad.convertir(unModifVo)));
                }

            }

        }
        decrementoCdpVo.setModifCdpDetRubCdpVoList(listaModifCdpDetRubCdpVo);
        if (cambioEstado) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.DECREMENTO_CDP.getId(),
                                                         decrementoCdpVo.getEstadoModifCdpVo().getEmcCodigo(),
                                                         usuarioLogueado, decrementoCdpVo.getMcdCodigo());
        }
        return decrementoCdpVo;
    }

    /**
     * @auhotr Modifica Giovanni
     * @param incrementoCdpVo
     * @param usuarioLogueado
     * @param cambioEstado
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public ModificacionCdpVO guardarIncrementoCdp(ModificacionCdpVO incrementoCdpVo, UsuarioVO usuarioLogueado,
                                     boolean cambioEstado) throws ExcepcionDAO, ExcepcionAplicacion {
        List<ModifCdpDetRubCdpVO> listaModifCdpDetRubCdpVo = incrementoCdpVo.getModifCdpDetRubCdpVoList();

        /*
         * Manejo de error de concurrencia
         */
        /*SiiModificacionCdp decrementoActual = new SiiModificacionCdp();
        decrementoActual = modificacionCdpDao.buscarModificacionCdpPorId(incrementoCdpVo.getMcdCodigo());
        if (decrementoActual.getSiiEstadoModifCdp().getEmcCodigo() != incrementoCdpVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de decremento fue cambiado durante la modificación. Seleccione nuevamente la solicitud");
        }*/

        if (incrementoCdpVo.getMcdCodigo() == null &&
            "BORRADOR".equals(incrementoCdpVo.getEstadoModifCdpVo().getEmcNombre())) {
            incrementoCdpVo.setMcdNumero(modificacionCdpDao.siguienteNumeroModificacionCdp(incrementoCdpVo.getMcdTipoMod(),
                                                                                           incrementoCdpVo.getCdpVo().getCdpVigencia()));
            incrementoCdpVo =
                new ModificacionCdpVO(modificacionCdpDao.insertarModificacionCdp(conversionVoEntidad.convertir(incrementoCdpVo)));
        } else {
            incrementoCdpVo =
                new ModificacionCdpVO(modificacionCdpDao.actualizarModifiacionCdp(conversionVoEntidad.convertir(incrementoCdpVo)));
        }

        if (listaModifCdpDetRubCdpVo != null && listaModifCdpDetRubCdpVo.size() > 0) {
            for (ModifCdpDetRubCdpVO unModifVo : listaModifCdpDetRubCdpVo) {
                unModifVo.setModificacionCdpVo(incrementoCdpVo);
                if (unModifVo.getMcrCodigo() == null) {
                    unModifVo = new ModifCdpDetRubCdpVO(modifCdpDetRubCdpDao.insertarModifCdpDetRubCdp(conversionVoEntidad.convertir(unModifVo)));

                } else {
                    unModifVo = new ModifCdpDetRubCdpVO(modifCdpDetRubCdpDao.actualizarModifCdpDetRubCdp(conversionVoEntidad.convertir(unModifVo)));
                }

            }

        }
        incrementoCdpVo.setModifCdpDetRubCdpVoList(listaModifCdpDetRubCdpVo);
        if (cambioEstado) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.INCREMENTO_CDP.getId(),
                                                         incrementoCdpVo.getEstadoModifCdpVo().getEmcCodigo(),
                                                         usuarioLogueado, incrementoCdpVo.getMcdCodigo());
        }
        
        return incrementoCdpVo;

    }


    public void setModificacionCdpDao(ModificacionCdpDAO modificacionCdpDao) {
        this.modificacionCdpDao = modificacionCdpDao;
    }

    public ModificacionCdpDAO getModificacionCdpDao() {
        return modificacionCdpDao;
    }

    public void setConversionVoEntidad(ConversionVOEntidad conversionVoEntidad) {
        this.conversionVoEntidad = conversionVoEntidad;
    }

    public ConversionVOEntidad getConversionVoEntidad() {
        return conversionVoEntidad;
    }

    public void setModifCdpDetRubCdpDao(ModifCdpDetRubCdpDAO modifCdpDetRubCdpDao) {
        this.modifCdpDetRubCdpDao = modifCdpDetRubCdpDao;
    }

    public ModifCdpDetRubCdpDAO getModifCdpDetRubCdpDao() {
        return modifCdpDetRubCdpDao;
    }

    //-----------------------------------INCREMENTO

    public List<ModificacionCdpVO> buscarIncrementosCdpEnTramite() throws ExcepcionDAO {
        // Excluye a los INCREMENTADO DECREMENTADO Y RECHAZADO
        return convertirSiiListaModicacionCdpEnVo(modificacionCdpDao.buscarIncrementosCdpEnTramite());
        
    }

    public ModificacionCdpVO actualizarModifiacionCdp(ModificacionCdpVO modificacionCdpVo) throws ExcepcionDAO {
        return new ModificacionCdpVO(modificacionCdpDao.actualizarModifiacionCdp(conversionVoEntidad.convertir(modificacionCdpVo)));
    }
    
}


