package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActaIniContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FirmaDocumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FirmasRequeridasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InformeActaIniDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaIniContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmaDocumento;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ActaIniContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcContratVO;
import co.gov.coljuegos.siicol.ejb.vo.FirmaDocumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.FirmasRequeridasDocumentosVO;
import co.gov.coljuegos.siicol.ejb.vo.FirmasRequeridasVO;
import co.gov.coljuegos.siicol.ejb.vo.InformeActaIniVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminActaIniContratoBean implements AdminActaIniContrato {
    @Resource
    SessionContext sessionContext;
    @EJB
    ActaIniContratoDAO actaIniContratoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    InformeActaIniDAO informeActaIniDao;
    @EJB
    AdminInformeActaIni adminInformeActaIni;
    @EJB
    AdminInformeContrProv adminInformeContrProv;
    @EJB
    FirmaDocumentoDAO firmaDocumentoDao;
    @EJB
    FirmasRequeridasDAO firmasRequeridasDao;
    @EJB
    UsuarioDAO usuarioDao;
    @EJB
    ProcesoContratacionDAO procesoContratacionDao;
    @EJB
    EstadoProcContratDAO estadoProcContratDao;


    public AdminActaIniContratoBean() {

    }

    public ActaIniContratoVO actualizarActaIniContrato(ActaIniContratoVO actaIniContratoVo) throws ExcepcionDAO {
        return new ActaIniContratoVO(actaIniContratoDao.actualizarActaIniContrato(conversionVoEntidad.convertir(actaIniContratoVo)));
    }

    public ActaIniContratoVO buscarActaIniContratoPorProceso(Long prcCodigo) throws ExcepcionDAO {
        ActaIniContratoVO actaIniContratoVo = null;
        SiiActaIniContrato actaIniContrato = actaIniContratoDao.buscarActaIniContratoPorProceso(prcCodigo);
        if (actaIniContrato != null) {
            actaIniContratoVo = new ActaIniContratoVO(actaIniContrato);
            actaIniContratoVo.setInformeActaIniListVo(adminInformeActaIni.buscarInformeActaIniPorActaInicio(actaIniContratoVo.getAcnCodigo()));
            actaIniContratoVo.setInformeContrProvListVo(adminInformeContrProv.buscarInformeContrProvPorActaInicio(actaIniContratoVo.getAcnCodigo()));
        } else {
            actaIniContratoVo = null;
        }

        return actaIniContratoVo;
    }

    /**
     * @param actaIniContratoVo
     * @param usuarioLogueado
     * @param cambioEstado
     * @param listaFirmaRequeridasDocumentoVo lista de firmas asociadas al acta de inicio que de agregaran.
     * @param listaFirmaDocumentoVo lista de firmas asociadas al acta de inicio que serán borradas.
     * @param listaInformeActaIniInicial lisra de fechas de informes/pagos que seran borrados
     * @return actaIniContratoVo
     * @throws ExcepcionDAO
     */
    public ActaIniContratoVO guardarActaIniContrato(ActaIniContratoVO actaIniContratoVo, UsuarioVO usuarioLogueado,
                                                    boolean cambioEstado,
                                                    List<FirmasRequeridasDocumentosVO> listaFirmaRequeridasDocumentoVo,
                                                    List<FirmaDocumentoVO> listaFirmaDocumentoVo,
                                                    List<InformeActaIniVO> listaInformeActaIniInicial) throws ExcepcionDAO {
        List<FirmaDocumentoVO> listaFinalFirmaDocumentoVo = new ArrayList<FirmaDocumentoVO>();
        int BORRADOR = 1;
        int APROBADO = 2;

        List<InformeActaIniVO> listaInformeActaIniVo = actaIniContratoVo.getInformeActaIniListVo();

        if (listaFirmaDocumentoVo != null) {
            for (FirmaDocumentoVO fdVo : listaFirmaDocumentoVo) {
                if (!listaFinalFirmaDocumentoVo.contains(fdVo)) {
                    firmaDocumentoDao.eliminarFirmaDocumento(fdVo.getFdoCodigo());
                }
            }
        }

        if (listaInformeActaIniInicial != null) {
            for (InformeActaIniVO informeVo : listaInformeActaIniInicial) {
                if (!actaIniContratoVo.getInformeActaIniListVo().contains(informeVo)) {
                    informeActaIniDao.eliminaInformeActaIni(informeVo.getIaiCodigo());
                }

            }
            
        }

        if (actaIniContratoVo.getAcnCodigo() == null && actaIniContratoVo.getAcnEstado() == BORRADOR) {
            actaIniContratoVo =
                new ActaIniContratoVO(actaIniContratoDao.insertarActaIniContrato(conversionVoEntidad.convertir(actaIniContratoVo)));
        } else {
            actaIniContratoVo =
                new ActaIniContratoVO(actaIniContratoDao.actualizarActaIniContrato(conversionVoEntidad.convertir(actaIniContratoVo)));
            if (actaIniContratoVo.getAcnEstado() == APROBADO) {
                ProcesoContratacionVO procesoContratacionVo =
                    new ProcesoContratacionVO(procesoContratacionDao.buscarProcesoContratacionPorId(actaIniContratoVo.getProcesoContratacionVo().getPrcCodigo()));
                procesoContratacionVo.setEstadoProcContrat(new EstadoProcContratVO(estadoProcContratDao.buscarEstadoProcContratPorEstado("ACTA INICIO")));
                procesoContratacionDao.actualizarProcesoContratacion(conversionVoEntidad.convertir(procesoContratacionVo));
            }
        }

        if (cambioEstado) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ACTA_INI_CONTRATO.getId(),
                                                         actaIniContratoVo.getAcnEstado().longValue(), usuarioLogueado,
                                                         actaIniContratoVo.getAcnCodigo());

        }

        for (InformeActaIniVO informe : listaInformeActaIniVo) {
            if (informe.getIaiCodigo() == null) {
                informe.setActaIniContratoVo(actaIniContratoVo);
                informeActaIniDao.insertarInformeActaIni(conversionVoEntidad.convertir(informe));
            }

        }

        SiiFirmaDocumento firmaDocumento;
        FirmaDocumentoVO firmaDocumentoVo = new FirmaDocumentoVO();
        if (listaFirmaRequeridasDocumentoVo != null) {
            for (FirmasRequeridasDocumentosVO firmaVo : listaFirmaRequeridasDocumentoVo) {
                firmaDocumentoVo.setFdoCodigo(firmaVo.getFdo_codigo());
                firmaDocumentoVo.setFdoFechaFirma(firmaVo.getFdo_fecha_firma());
                if (firmaVo.getFdo_id_documento().compareTo(actaIniContratoVo.getAcnCodigo()) != 0) {
                    firmaDocumentoVo.setFdoIdDocumento(actaIniContratoVo.getAcnCodigo());
                }
                if (firmaVo.getFre_codigo() != null) {
                    firmaDocumentoVo.setFirmasRequeridasVo(new FirmasRequeridasVO(firmasRequeridasDao.buscarFirmasRequeridasPorId(firmaVo.getFre_codigo())));
                }
                if (firmaVo.getUsu_codigo() != null) {
                    firmaDocumentoVo.setUsuarioVo(new UsuarioVO(usuarioDao.buscarUsuarioPorId(firmaVo.getUsu_codigo())));
                }
                firmaDocumento = conversionVoEntidad.convertirVoAEntidad(firmaDocumentoVo);
                if (firmaDocumento.getFdoCodigo() != null) {
                    listaFinalFirmaDocumentoVo.add(new FirmaDocumentoVO(firmaDocumentoDao.actualizarFirmaDocumento(firmaDocumento)));
                } else {
                    listaFinalFirmaDocumentoVo.add(new FirmaDocumentoVO(firmaDocumentoDao.insertarFirmaDocumento(firmaDocumento)));
                }
            }
        }
        return actaIniContratoVo;
    }
}