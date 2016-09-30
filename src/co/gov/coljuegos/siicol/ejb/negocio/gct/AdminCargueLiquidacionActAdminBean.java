package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AjusteContCarActDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaActuacionesAdmDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConcepCuotCarActAdmDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoProyeccionCarDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DeclaracionOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DeclaracionSugeridaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecConCuoCarDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FestivoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InteresCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionEstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PagoCargaActAdmDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoOriCargaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProyeccionCargaActDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReferenciaPagoDeclDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TasaIntSuperbanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TasaInteresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAjusteContCarAct;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaActuacionesAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepCuotCarActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoProyeccionCar;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionSugerida;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecConCuoCar;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcesoSanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPagoCargaActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoOriCarga;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionCargaAct;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReferenciaPagoDecl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSmmlv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaIntSuperban;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminacionAnticip;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AjusteContCarActVO;
import co.gov.coljuegos.siicol.ejb.vo.CargaActuacionesAdmVO;
import co.gov.coljuegos.siicol.ejb.vo.ConcepCuotCarActAdmVO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecConCuoCarVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcesoSancVO;
import co.gov.coljuegos.siicol.ejb.vo.PagoCargaActAdmVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoOriCargaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProyeccionCargaActVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminacionAnticipContVO;

import co.gov.coljuegos.siicol.ejb.vo.UbicacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.lang.Math;

import java.math.MathContext;

import java.math.RoundingMode;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminCargueLiquidacionActAdminBean implements AdminCargueLiquidacionActAdmin {

    @Resource
    SessionContext sessionContext;
    @EJB
    private CargaActuacionesAdmDAO cargaActuacionesAdmDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ConcepCuotCarActAdmDAO concepCuotCarActAdmDao;
    @EJB
    private PagoCargaActAdmDAO pagoCargaActAdmDao;
    @EJB
    private EstablecConCuoCarDAO establecConCuoCarDao;
    @EJB
    private ProyeccionCargaActDAO proyeccionCargaActDao;
    @EJB
    private FestivoDAO festivoDao;
    @EJB
    private TasaIntSuperbanDAO tasaIntSuperbanDao;
    @EJB
    private ProcesoOriCargaDAO procesoOriCargaDao;
    @EJB
    private ConceptoCuotaDAO conceptoCuotaDao;
    @EJB
    private ConceptoProyeccionCarDAO conceptoProyeccionCarDao;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    DocumentoContableDAO documentoContableDao;
    @EJB
    CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    LiquidacionEstablecimientoDAO liquidacionEstablecimientoDao;
    @EJB
    DeclaracionSugeridaDAO declaracionSugeridaDao;
    @EJB
    DeclaracionOperadorDAO declaracionOperadorDao;
    @EJB
    DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB
    ReferenciaPagoDeclDAO referenciaPagoDao;
    @EJB
    DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    TasaInteresDAO tasaInteresDao;
    @EJB
    AjusteContCarActDAO ajusteContCarActDao;
    @EJB
    InteresCuotaDAO interesCuotaDao;
    @EJB
    PersonaDAO personaDao;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public AdminCargueLiquidacionActAdminBean() {

    }

    public CargaActuacionesAdmVO insertarCargaActuacionesAdm(CargaActuacionesAdmVO cargaActuacionesAdmVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {
        cargaActuacionesAdmVo.setUsuarioConectadoVo(usuarioLogueado);
        SiiCargaActuacionesAdm siiCargaActuacionesAdm = conversionVoEntidad.convertir(cargaActuacionesAdmVo);

        // registra nueva persona
        if (cargaActuacionesAdmVo.getPersonaVo().getPerCodigo() == null) {
            SiiPersona siipersona = conversionVoEntidad.convertir(cargaActuacionesAdmVo.getPersonaVo());
            siipersona.setPerCargaLiqActAdm("S");
            personaDao.insertarPersona(siipersona);
            siiCargaActuacionesAdm.setSiiPersona(siipersona);

        }

        //busca documento contable asosciado para insertar
        if (cargaActuacionesAdmVo.getDocumentoContableVo() != null) {
            SiiDocumentoContable siiDocumentoContable = documentoContableDao.buscarPorCodigo(cargaActuacionesAdmVo.getDocumentoContableVo().getDcoCodigo());
            siiCargaActuacionesAdm.setSiiDocumentoContable(siiDocumentoContable);
        }

        Integer consecutivo = cargaActuacionesAdmDao.buscarConsecutivoCargaActuacionesAdm();
        siiCargaActuacionesAdm.setCaaConsecutivo(consecutivo);
        siiCargaActuacionesAdm = cargaActuacionesAdmDao.insertar(siiCargaActuacionesAdm);
        List<SiiConcepCuotCarActAdm> listSiiConcepCuotCarActAdm = new ArrayList();
        List<SiiEstablecConCuoCar> listSiiEstablecConCuoCar = new ArrayList();
        List<SiiPagoCargaActAdm> listSiiPagoCargaActAdm = new ArrayList();
        List<SiiAjusteContCarAct> listSiiAjusteContCarAct = new ArrayList();

        for (ConcepCuotCarActAdmVO concepCuotCarActAdmVo : cargaActuacionesAdmVo.getListConcepCuotCarActAdmVO()) {
            List<SiiConceptoCuota> listSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXNombre(concepCuotCarActAdmVo.getCcuNombre());
            concepCuotCarActAdmVo.setUsuarioConectadoVo(usuarioLogueado);
            concepCuotCarActAdmVo.setCamActivo("S");
            SiiConcepCuotCarActAdm siiConcepCuotCarActAdm = conversionVoEntidad.convertir(concepCuotCarActAdmVo);
            siiConcepCuotCarActAdm.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
            siiConcepCuotCarActAdm.setSiiConceptoCuota(listSiiConceptoCuota.get(0));
            siiConcepCuotCarActAdm = concepCuotCarActAdmDao.insertar(siiConcepCuotCarActAdm);

            BigDecimal tempValor = BigDecimal.ZERO;
            if (concepCuotCarActAdmVo.getListEstablecConCuoCarVo() != null) {
                for (EstablecConCuoCarVO establecConCuoCarVo : concepCuotCarActAdmVo.getListEstablecConCuoCarVo()) {
                    establecConCuoCarVo.setUsuarioConectadoVo(usuarioLogueado);
                    UbicacionVO ubicacionVo = new UbicacionVO();
                    ubicacionVo.setUbiCodigo(establecConCuoCarVo.getUbiCodigo());
                    establecConCuoCarVo.setUbicacionMunicipioVo(ubicacionVo);
                    SiiEstablecConCuoCar siiEstablecConCuoCar = conversionVoEntidad.convertir(establecConCuoCarVo);
                    siiEstablecConCuoCar.setSiiConcepCuotCarActAdm(siiConcepCuotCarActAdm);
                    siiEstablecConCuoCar.setEcuActivo("S");
                    siiEstablecConCuoCar = establecConCuoCarDao.insertar(siiEstablecConCuoCar);
                    listSiiEstablecConCuoCar.add(siiEstablecConCuoCar);
                    tempValor = tempValor.add(siiEstablecConCuoCar.getEcuValor());
                }
            }
            siiConcepCuotCarActAdm.setCamValor(concepCuotCarActAdmVo.getCamValor());
            siiConcepCuotCarActAdm = concepCuotCarActAdmDao.actualizar(siiConcepCuotCarActAdm);
            siiConcepCuotCarActAdm.setSiiEstablecConCuoCarList(listSiiEstablecConCuoCar);
            listSiiConcepCuotCarActAdm.add(siiConcepCuotCarActAdm);

            if (cargaActuacionesAdmVo.getListAjusteContCarActVo() != null) {
                for (AjusteContCarActVO AjusteContCarActVo : cargaActuacionesAdmVo.getListAjusteContCarActVo()) {
                    AjusteContCarActVo.setAjcActivo("S");
                    AjusteContCarActVo.setUsuarioConectadoVo(usuarioLogueado);
                    SiiAjusteContCarAct siiAjusteContCarAct = conversionVoEntidad.convertir(AjusteContCarActVo);
                    siiAjusteContCarAct.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
                    siiAjusteContCarAct.setSiiConcepCuotCarActAdm(siiConcepCuotCarActAdm);
                    ajusteContCarActDao.insertar(siiAjusteContCarAct);
                    listSiiAjusteContCarAct.add(siiAjusteContCarAct);
                }
            }
        }
        if (cargaActuacionesAdmVo.getListPgoCargaActAdmVo() != null) {
            for (PagoCargaActAdmVO unPgoCargaActAdmVo : cargaActuacionesAdmVo.getListPgoCargaActAdmVo()) {
                List<SiiConceptoCuota> listSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXNombre(unPgoCargaActAdmVo.getCcuNombre());
                unPgoCargaActAdmVo.setUsuarioConectadoVo(usuarioLogueado);
                SiiPagoCargaActAdm siipagoCargaActAdm = conversionVoEntidad.convertir(unPgoCargaActAdmVo);
                siipagoCargaActAdm.setSiiConceptoCuota(listSiiConceptoCuota.get(0));
                siipagoCargaActAdm.setPcaActivo("S");
                siipagoCargaActAdm.setSiiConceptoCuota(listSiiConceptoCuota.get(0));
                siipagoCargaActAdm.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
                siipagoCargaActAdm = pagoCargaActAdmDao.insertar(siipagoCargaActAdm);
                listSiiPagoCargaActAdm.add(siipagoCargaActAdm);
            }
        }

        siiCargaActuacionesAdm.setSiiAjusteContCarActList(listSiiAjusteContCarAct);
        siiCargaActuacionesAdm.setSiiPagoCargaActAdmList(listSiiPagoCargaActAdm);
        siiCargaActuacionesAdm.setSiiConcepCuotCarActAdmList(listSiiConcepCuotCarActAdm);
        liquidarActuacionAdm(cargaActuacionesAdmVo, siiCargaActuacionesAdm);

        return new CargaActuacionesAdmVO(siiCargaActuacionesAdm);
    }

    public CargaActuacionesAdmVO actualizarActuacionAdm(CargaActuacionesAdmVO cargaActuacionesAdmVo, Boolean migrar, UsuarioVO usuarioLogueado) throws ExcepcionDAO, Throwable {

        List<SiiEstablecConCuoCar> listSiiEstablecConCuoCar = new ArrayList();
        List<SiiPagoCargaActAdm> listSiiPagoCargaActAdm = new ArrayList();
        List<SiiConcepCuotCarActAdm> listSiiConcepCuotCarActAdm = new ArrayList();
        CargaActuacionesAdmVO unaCargaActuacionesAdmVo = new CargaActuacionesAdmVO();
        SiiCargaActuacionesAdm siiCargaActuacionesAdm = conversionVoEntidad.convertir(cargaActuacionesAdmVo);
        Boolean tempProyec = false;

        // ANULA PROYECCION ANTERIOR
        anularRgistrosAct(siiCargaActuacionesAdm, cargaActuacionesAdmVo);


        // registra nueva persona
        if (cargaActuacionesAdmVo.getPersonaVo().getPerCodigo() == null) {
            SiiPersona siipersona = conversionVoEntidad.convertir(cargaActuacionesAdmVo.getPersonaVo());
            siipersona.setPerCargaLiqActAdm("S");
            personaDao.insertarPersona(siipersona);
            siiCargaActuacionesAdm.setSiiPersona(siipersona);

        }
        else {
            SiiPersona siipersona = conversionVoEntidad.convertir(cargaActuacionesAdmVo.getPersonaVo());
            personaDao.actualizarPersona(siipersona);
        }

        //busca  documento contable
        if (cargaActuacionesAdmVo.getDocumentoContableVo() != null) {

            SiiDocumentoContable siiDocumentoContable = documentoContableDao.buscarPorCodigo(cargaActuacionesAdmVo.getDocumentoContableVo().getDcoCodigo());
            siiCargaActuacionesAdm.setSiiDocumentoContable(siiDocumentoContable);
        }

        //nuevos conceptos
        for (ConcepCuotCarActAdmVO concepCuotCarActAdmVo : cargaActuacionesAdmVo.getListConcepCuotCarActAdmVO()) {
            BigDecimal tempValor = BigDecimal.ZERO;
            SiiConcepCuotCarActAdm siiConcepCuotCarActAdm = new SiiConcepCuotCarActAdm();
            if (concepCuotCarActAdmVo.getCamCodigo() == null) {
                tempProyec = true;
                List<SiiConceptoCuota> listSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXNombre(concepCuotCarActAdmVo.getCcuNombre());
                concepCuotCarActAdmVo.setUsuarioConectadoVo(usuarioLogueado);
                concepCuotCarActAdmVo.setCamActivo("S");
                siiConcepCuotCarActAdm = conversionVoEntidad.convertir(concepCuotCarActAdmVo);
                siiConcepCuotCarActAdm.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
                siiConcepCuotCarActAdm.setSiiConceptoCuota(listSiiConceptoCuota.get(0));
                siiConcepCuotCarActAdm = concepCuotCarActAdmDao.insertar(siiConcepCuotCarActAdm);

                if (concepCuotCarActAdmVo.getListEstablecConCuoCarVo() != null) {
                    for (EstablecConCuoCarVO establecConCuoCarVo : concepCuotCarActAdmVo.getListEstablecConCuoCarVo()) {
                        establecConCuoCarVo.setUsuarioConectadoVo(usuarioLogueado);
                        UbicacionVO ubicacionVo = new UbicacionVO();
                        ubicacionVo.setUbiCodigo(establecConCuoCarVo.getUbiCodigo());
                        establecConCuoCarVo.setUbicacionMunicipioVo(ubicacionVo);
                        SiiEstablecConCuoCar siiEstablecConCuoCar = conversionVoEntidad.convertir(establecConCuoCarVo);
                        siiEstablecConCuoCar.setSiiConcepCuotCarActAdm(siiConcepCuotCarActAdm);
                        siiEstablecConCuoCar.setEcuActivo("S");
                        siiEstablecConCuoCar = establecConCuoCarDao.insertar(siiEstablecConCuoCar);
                        listSiiEstablecConCuoCar.add(siiEstablecConCuoCar);
                        tempValor = tempValor.add(siiEstablecConCuoCar.getEcuValor());
                    }
                }
                siiConcepCuotCarActAdm = concepCuotCarActAdmDao.actualizar(siiConcepCuotCarActAdm);
                siiConcepCuotCarActAdm.setSiiEstablecConCuoCarList(listSiiEstablecConCuoCar);
                listSiiConcepCuotCarActAdm.add(siiConcepCuotCarActAdm);
            }
            else {
                for (EstablecConCuoCarVO establecConCuoCarVo : concepCuotCarActAdmVo.getListEstablecConCuoCarVo()) {
                    if (establecConCuoCarVo.getEcuCodigo() == null) {
                        establecConCuoCarVo.setUsuarioConectadoVo(usuarioLogueado);
                        UbicacionVO ubicacionVo = new UbicacionVO();
                        ubicacionVo.setUbiCodigo(establecConCuoCarVo.getUbiCodigo());
                        establecConCuoCarVo.setUbicacionMunicipioVo(ubicacionVo);
                        SiiEstablecConCuoCar siiEstablecConCuoCar = conversionVoEntidad.convertir(establecConCuoCarVo);
                        siiEstablecConCuoCar.setSiiConcepCuotCarActAdm(siiConcepCuotCarActAdm);
                        siiEstablecConCuoCar.setEcuActivo("S");
                        siiEstablecConCuoCar = establecConCuoCarDao.insertar(siiEstablecConCuoCar);
                        listSiiEstablecConCuoCar.add(siiEstablecConCuoCar);
                        tempValor = tempValor.add(siiEstablecConCuoCar.getEcuValor());
                    }
                }
                if (siiConcepCuotCarActAdm.getCamCodigo() != null) {
                    siiConcepCuotCarActAdm.setCamValor(tempValor);
                    siiConcepCuotCarActAdm = concepCuotCarActAdmDao.actualizar(siiConcepCuotCarActAdm);
                }
            }

            // nuevos ajustes
            if (cargaActuacionesAdmVo.getListAjusteContCarActVo() != null) {
                for (AjusteContCarActVO ajusteContCarActVo : cargaActuacionesAdmVo.getListAjusteContCarActVo()) {
                    if (ajusteContCarActVo.getAjcCodigo() == null && concepCuotCarActAdmVo.getCcuNombre().equals(ajusteContCarActVo.getCcuNombre())) {
                        SiiAjusteContCarAct siiAjusteContCarAct = new SiiAjusteContCarAct();
                        tempProyec = true;
                        List<SiiConceptoCuota> listSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXNombre(ajusteContCarActVo.getCcuNombre());
                        ajusteContCarActVo.setUsuarioConectadoVo(usuarioLogueado);
                        ajusteContCarActVo.setAjcActivo("S");
                        siiAjusteContCarAct = conversionVoEntidad.convertir(ajusteContCarActVo);
                        siiAjusteContCarAct.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
                        if (siiConcepCuotCarActAdm.getCamCodigo() != null)
                            siiAjusteContCarAct.setSiiConcepCuotCarActAdm(siiConcepCuotCarActAdm);
                        else {
                            List<SiiConcepCuotCarActAdm> siiConcepCuotCarActAdmList =
                                concepCuotCarActAdmDao.buscarTodoSiiConcepCuotCarActAdmXCcuCodigo(ajusteContCarActVo.getCcuNombre(), siiCargaActuacionesAdm.getCaaCodigo());
                            siiAjusteContCarAct.setSiiConcepCuotCarActAdm(siiConcepCuotCarActAdmList.get(0));
                        }

                        siiAjusteContCarAct = ajusteContCarActDao.insertar(siiAjusteContCarAct);
                    }
                }
            }
        }
        // nuevos pagos
        for (PagoCargaActAdmVO unPgoCargaActAdmVo : cargaActuacionesAdmVo.getListPgoCargaActAdmVo()) {
            if (unPgoCargaActAdmVo.getPcaCodigo() == null) {
                tempProyec = true;
                List<SiiConceptoCuota> listSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXNombre(unPgoCargaActAdmVo.getCcuNombre());
                unPgoCargaActAdmVo.setUsuarioConectadoVo(usuarioLogueado);
                SiiPagoCargaActAdm siipagoCargaActAdm = conversionVoEntidad.convertir(unPgoCargaActAdmVo);
                siipagoCargaActAdm.setSiiConceptoCuota(listSiiConceptoCuota.get(0));
                siipagoCargaActAdm.setPcaActivo("S");
                siipagoCargaActAdm.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
                siipagoCargaActAdm.setSiiConceptoCuota(listSiiConceptoCuota.get(0));
                siipagoCargaActAdm = pagoCargaActAdmDao.insertar(siipagoCargaActAdm);
            }
        }

        listSiiConcepCuotCarActAdm = concepCuotCarActAdmDao.buscarTodoSiiConcepCuotCarActAdmXLiqActAdmin(siiCargaActuacionesAdm.getCaaCodigo());
        for (SiiConcepCuotCarActAdm siiConcepCuotCarActAdm : listSiiConcepCuotCarActAdm) {
            List<SiiAjusteContCarAct> listSiiAjusteContCarAct =
                ajusteContCarActDao.buscarTodoSiiAjusteContCarActXLiqActAdmin(siiCargaActuacionesAdm.getCaaCodigo(), siiConcepCuotCarActAdm.getCamCodigo());
            siiConcepCuotCarActAdm.setSiiAjusteContCarActList(listSiiAjusteContCarAct);
        }
        siiCargaActuacionesAdm.setSiiConcepCuotCarActAdmList(listSiiConcepCuotCarActAdm);

        //genera nueva liquidaciòn por cambios
        liquidarActuacionAdm(cargaActuacionesAdmVo, siiCargaActuacionesAdm);

        siiCargaActuacionesAdm = cargaActuacionesAdmDao.actualizar(siiCargaActuacionesAdm);
        cargaActuacionesAdmVo = new CargaActuacionesAdmVO(siiCargaActuacionesAdm);
        if (migrar == true) {
            migrar(siiCargaActuacionesAdm);
            adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.CARGUE_LIQ_ACT_ADM.getId(), "M", usuarioLogueado, siiCargaActuacionesAdm.getCaaCodigo());
        }


        return cargaActuacionesAdmVo;
    }

    public void anularRgistrosAct(SiiCargaActuacionesAdm siiCargaActuacionesAdm, CargaActuacionesAdmVO cargaActuacionesAdmVo) throws ExcepcionDAO {
        List<SiiEstablecConCuoCar> listSiiEstablecConCuoCar = new ArrayList();
        List<SiiPagoCargaActAdm> listSiiPagoCargaActAdm = new ArrayList();
        List<SiiConcepCuotCarActAdm> listSiiConcepCuotCarActAdm = new ArrayList();

        listSiiConcepCuotCarActAdm = concepCuotCarActAdmDao.buscarTodoSiiConcepCuotCarActAdmXLiqActAdmin(siiCargaActuacionesAdm.getCaaCodigo());

        List<SiiProyeccionCargaAct> listSiiProyeccionCargaAct = proyeccionCargaActDao.buscarProyeccionCargaActXConceptoCuotaActAdmin(siiCargaActuacionesAdm.getCaaCodigo());

        // cambia a estado inanctivo los conceptos
        if (cargaActuacionesAdmVo.getListeliminarConcepCuotCarActAdmVO() != null) {

            for (ConcepCuotCarActAdmVO concepCuotCarActAdmVo : cargaActuacionesAdmVo.getListeliminarConcepCuotCarActAdmVO()) {
                listSiiPagoCargaActAdm = pagoCargaActAdmDao.buscarTodoSiiPagoCargaActAdmXLiqActAdmin(siiCargaActuacionesAdm.getCaaCodigo(), concepCuotCarActAdmVo.getConceptoCuotaVo().getCcuCodigo());
                List<SiiAjusteContCarAct> listSiiAjusteContCarAct =
                    ajusteContCarActDao.buscarTodoSiiAjusteContCarActXLiqActAdmin(siiCargaActuacionesAdm.getCaaCodigo(), concepCuotCarActAdmVo.getCamCodigo());
                //cambia a estado inanctivo establecimientos
                List<SiiEstablecConCuoCar> lisSiiEstablecConCuoCar = establecConCuoCarDao.buscarTodoEstablecConCuoCarXConcepCuotaAct(concepCuotCarActAdmVo.getCamCodigo());
                if (lisSiiEstablecConCuoCar != null) {
                    for (SiiEstablecConCuoCar unsiiEstablecConCuoCar : lisSiiEstablecConCuoCar) {
                        unsiiEstablecConCuoCar.setEcuActivo("N");
                        establecConCuoCarDao.actualizar(unsiiEstablecConCuoCar);
                    }
                }
                concepCuotCarActAdmVo.setCamActivo("N");
                SiiConcepCuotCarActAdm siiConcepCuotCarActAdm = conversionVoEntidad.convertir(concepCuotCarActAdmVo);
                concepCuotCarActAdmDao.actualizar(siiConcepCuotCarActAdm);

                // cambia a estado inanctivo los  pagos
                if (listSiiPagoCargaActAdm.size() > 0) {
                    for (SiiPagoCargaActAdm siiPagoCargaActAdm : listSiiPagoCargaActAdm) {
                        siiPagoCargaActAdm.setPcaActivo("N");
                        pagoCargaActAdmDao.actualizar(siiPagoCargaActAdm);
                    }
                }
                //cambia a estado incativo los ajustes
                if (listSiiAjusteContCarAct.size() > 0) {
                    for (SiiAjusteContCarAct siiAjusteContCarAct : listSiiAjusteContCarAct) {
                        if (siiAjusteContCarAct.getSiiConcepCuotCarActAdm().getCamCodigo() == concepCuotCarActAdmVo.getCamCodigo())
                            siiAjusteContCarAct.setAjcActivo("N");
                        ajusteContCarActDao.actualizar(siiAjusteContCarAct);
                    }
                }

            }
        }
        else {
            if (cargaActuacionesAdmVo.getListeliminarPgoCargaActAdmVo() != null) {
                for (PagoCargaActAdmVO pagoCargaActAdmVo : cargaActuacionesAdmVo.getListeliminarPgoCargaActAdmVo()) {
                    pagoCargaActAdmVo.setPcaActivo("N");
                    SiiPagoCargaActAdm siipagoCargaActAdm = conversionVoEntidad.convertir(pagoCargaActAdmVo);
                    pagoCargaActAdmDao.actualizar(siipagoCargaActAdm);
                }
            }

            if (cargaActuacionesAdmVo.getListEliminarAjusteContCarActVo() != null) {
                for (AjusteContCarActVO ajusteContCarActVo : cargaActuacionesAdmVo.getListEliminarAjusteContCarActVo()) {
                    ajusteContCarActVo.setAjcActivo("N");
                    SiiAjusteContCarAct siiAjusteContCarAct = conversionVoEntidad.convertir(ajusteContCarActVo);
                    ajusteContCarActDao.actualizar(siiAjusteContCarAct);
                }
            }
        }

        // cambia a estado inactivo la proyeccion
        for (SiiProyeccionCargaAct siiProyeccionCargaAct : listSiiProyeccionCargaAct) {
            //cambia a estadoinactivo la proyecciòn
            List<SiiConceptoProyeccionCar> listSiiConceptoProyeccionCar = conceptoProyeccionCarDao.buscarConceptoProyeccionCarXProyeccionCargaAct(siiProyeccionCargaAct.getPycCodigo());
            for (SiiConceptoProyeccionCar unaSiiConceptoProyeccionCar : listSiiConceptoProyeccionCar) {
                unaSiiConceptoProyeccionCar.setCpcActivo("N");
                conceptoProyeccionCarDao.actualizar(unaSiiConceptoProyeccionCar);
            }

            siiProyeccionCargaAct.setPycEstado("I");
            proyeccionCargaActDao.actualizar(siiProyeccionCargaAct);
        }
    }


    public CargaActuacionesAdmVO migrar(SiiCargaActuacionesAdm siiCargaActuacionesAdm) throws ExcepcionDAO {
        CargaActuacionesAdmVO cargaActuacionesAdmVo = new CargaActuacionesAdmVO();
        SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();
        Date fechaActual = new Date();
        Calendar fechaRe = Calendar.getInstance();

        Calendar fLp = Calendar.getInstance();
        fLp.setTime(siiCargaActuacionesAdm.getCaaFechaEjecut());
        Calendar fechaIni = Calendar.getInstance();

        //calcular fechas
        fLp.add(Calendar.DAY_OF_YEAR, siiCargaActuacionesAdm.getCaaDiasPlazo());
        fechaIni.setTime(siiCargaActuacionesAdm.getCaaFechaEjecut());
        // System.out.println(fechaIni.getTime());
        //System.out.println(fLp.getTime());
        if (siiCargaActuacionesAdm.getCaaTipoDias().equals("H")) {
            Date fechaHabil = null;
            fechaHabil = obtenerDiasHabiles(fechaIni, fLp);
            fLp.setTime(fechaHabil);
        }
        List<SiiProyeccionCargaAct> listSiiProyeccionCargaAct = proyeccionCargaActDao.buscarProyeccionCargaActXConceptoCuotaActAdmin(siiCargaActuacionesAdm.getCaaCodigo());

        for (SiiProyeccionCargaAct siiProyeccionCargaAct : listSiiProyeccionCargaAct) {
            List<SiiConceptoProyeccionCar> listSiiConceptoProyeccionCar = conceptoProyeccionCarDao.buscarConceptoProyeccionCarXProyeccionCargaAct(siiProyeccionCargaAct.getPycCodigo());
            for (SiiConceptoProyeccionCar unaSiiConceptoProyeccionCar : listSiiConceptoProyeccionCar) {
                SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
                if (unaSiiConceptoProyeccionCar.getCpcSaldoCapital().compareTo(BigDecimal.ZERO) > 0) {
                   
                    SiiConceptoCuota siiConceptoCuota = new SiiConceptoCuota();
                    List<SiiConceptoCuota> listasiiConceptoCuota = new ArrayList();
                    //Se crea la cuota operador
                    siiCuotaOperador.setCopNumCuota(1);
                    
                    listasiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXAbreviatura(unaSiiConceptoProyeccionCar.getSiiConcepCuotCarActAdm().getSiiConceptoCuota().getCcuAbreviatura());
                    siiCuotaOperador.setSiiConceptoCuota(listasiiConceptoCuota.get(0));
                    siiCuotaOperador.setCopTipoCartera("C");
                    siiCuotaOperador.setCopCancelada("A");
                    siiCuotaOperador.setCopTipoDocSopor("RE");
                    Date tempVigencia = siiCargaActuacionesAdm.getCaaFechaResoluc();
                    siiCuotaOperador.setCopVigencia(fLp.get(Calendar.YEAR));
                    siiCuotaOperador.setCopFechaLimPag(fLp.getTime());
                    siiCuotaOperador.setMesCodigo(fLp.get(Calendar.MONTH) + 1);
                    siiCuotaOperador.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
                    siiCuotaOperador.setCopValor(unaSiiConceptoProyeccionCar.getCpcSaldoCapital());
                    siiCuotaOperador = cuotaOperadorDao.insertarSiiCuotaOperador(siiCuotaOperador);
                }
                
                // registra saldo de interesç
                if (unaSiiConceptoProyeccionCar.getCpcSaldoInt().compareTo(BigDecimal.ZERO)>0){
                    SiiInteresCuota unSiiInteresCuota= new SiiInteresCuota();
                    unSiiInteresCuota.setIcuFecha(fechaActual);
                    unSiiInteresCuota.setIcuTasaAplic(BigDecimal.ZERO);
                    unSiiInteresCuota.setIcuValor(unaSiiConceptoProyeccionCar.getCpcSaldoInt());
                    unSiiInteresCuota.setIcuValorPagado(BigDecimal.ZERO);
                    unSiiInteresCuota.setSiiCuotaOperador(siiCuotaOperador);
                    unSiiInteresCuota.setIcuBaseCalc(BigDecimal.ZERO);
                    unSiiInteresCuota.setIcuCancelado("C");
                    interesCuotaDao.insertarSiiInteresCuota(unSiiInteresCuota);
                }
                
            }
        }
        
     

        // registra liquidacion establecimiento
        for (SiiConcepCuotCarActAdm siiConcepCuotCarActAdm : siiCargaActuacionesAdm.getSiiConcepCuotCarActAdmList()) {
            for (SiiEstablecConCuoCar siiEstablecConCuoCar : siiConcepCuotCarActAdm.getSiiEstablecConCuoCarList()) {
                SiiLiquidacionEstabl siiLiquidacionEstabl = new SiiLiquidacionEstabl();
                siiLiquidacionEstabl.setLesPonderado(siiEstablecConCuoCar.getEcuPorcentaje().divide(BigDecimal.valueOf(100L)));
                siiLiquidacionEstabl.setLesValor(siiEstablecConCuoCar.getEcuValor().setScale(2, RoundingMode.HALF_UP));
                siiLiquidacionEstabl.setLesNumEstablec(siiEstablecConCuoCar.getEcuCodEstablec());
                siiLiquidacionEstabl.setSiiUbicacionMunEstab(siiEstablecConCuoCar.getSiiUbicacionMunicipio());
                siiLiquidacionEstabl.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
                liquidacionEstablecimientoDao.insertarSiiLiquidacionEstabl(siiLiquidacionEstabl);
            }
        }
        
        return cargaActuacionesAdmVo;
    }


    public CargaActuacionesAdmVO liquidarActuacionAdm(CargaActuacionesAdmVO cargaActuacionesAdmVo, SiiCargaActuacionesAdm siiCargaActuacionesAdm) throws ExcepcionDAO {

        SiiProyeccionCargaAct siiProyeccionCargaAct = new SiiProyeccionCargaAct();
        SiiConceptoProyeccionCar siiConceptoProyeccionCar = new SiiConceptoProyeccionCar();
        Date fechaActual = new Date();
        Calendar fechaLP = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatters = new SimpleDateFormat("yyyyMMdd");
        Calendar fechaIni = Calendar.getInstance();
        Calendar fechaFin = Calendar.getInstance();
        Calendar tempfechaEje = Calendar.getInstance();

        for (SiiConcepCuotCarActAdm siiConcepCuotCarActAdm : siiCargaActuacionesAdm.getSiiConcepCuotCarActAdmList()) {

            fechaLP.setTime(siiCargaActuacionesAdm.getCaaFechaEjecut());
          
            BigDecimal cien = BigDecimal.valueOf(100L);
            BigDecimal diasAno = BigDecimal.valueOf(365L);
            final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
            Date fFin = fechaLP.getTime();
            fechaFin.set(2006, 11, 31); //UN MES MENOS PARA PRUEBAS

            //calcular fechas
            fechaLP.add(Calendar.DAY_OF_YEAR, siiCargaActuacionesAdm.getCaaDiasPlazo());
            fechaIni.setTime(siiCargaActuacionesAdm.getCaaFechaEjecut());
            
            if (siiCargaActuacionesAdm.getCaaTipoDias().equals("H")) {
                Date fechaHabil = null;
                fechaHabil = obtenerDiasHabiles(fechaIni, fechaLP);
                fechaLP.setTime(fechaHabil);
            }

            BigDecimal ims = BigDecimal.ZERO;
            BigDecimal tempPeriodo = BigDecimal.ZERO;
            tempPeriodo = tempPeriodo.add(siiConcepCuotCarActAdm.getCamValor());
            BigDecimal tempSaldoS = BigDecimal.ZERO;
            BigDecimal tempSaldoC = BigDecimal.ZERO;
            BigDecimal tempSaldoD = BigDecimal.ZERO;
            Boolean tempVal = true;
            tempSaldoS = tempSaldoS.add(siiConcepCuotCarActAdm.getCamValor());
            tempSaldoC = tempSaldoC.add(siiConcepCuotCarActAdm.getCamValor());
            tempSaldoD =  tempSaldoD.add(siiConcepCuotCarActAdm.getCamValor());
            BigDecimal tempTasa = BigDecimal.ZERO;
            BigDecimal tempTotalAjuste = BigDecimal.ZERO;
            Date fIni = fechaLP.getTime();
            fFin = fechaFin.getTime();
           
            siiProyeccionCargaAct = new SiiProyeccionCargaAct();
            siiProyeccionCargaAct.setPycEstado("A");
            siiProyeccionCargaAct.setPycFechaLiq(fechaActual);
            siiProyeccionCargaAct.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
            siiProyeccionCargaAct.setSiiUsuarioConectado(siiCargaActuacionesAdm.getSiiUsuarioConectado());
            siiProyeccionCargaAct = proyeccionCargaActDao.insertar(siiProyeccionCargaAct);

            //busca tasas bancarias
            List<SiiTasaIntSuperban> listSiiTasaIntSuperban = tasaIntSuperbanDao.consultarListaTasasIntSuperbanDesdeFecha(fIni);
            Integer tempUltTasa =  listSiiTasaIntSuperban.size();
            listSiiTasaIntSuperban.get(tempUltTasa-1).setTisVigenHasta(fechaActual);

            // calcula el total de ajuste
            if (siiConcepCuotCarActAdm.getSiiAjusteContCarActList() != null) {
                for (SiiAjusteContCarAct siiAjusteContCarAct : siiConcepCuotCarActAdm.getSiiAjusteContCarActList()) {
                    tempTotalAjuste = tempTotalAjuste.add(siiAjusteContCarAct.getAjcValor());
                }
            }
            //se busca pagospor conceptos
            List<SiiPagoCargaActAdm> listSiiPagoCargaActAdm =
                pagoCargaActAdmDao.buscarTodoSiiPagoCargaActAdmXLiqActAdmin(siiCargaActuacionesAdm.getCaaCodigo(), siiConcepCuotCarActAdm.getSiiConceptoCuota().getCcuCodigo());

            // si no existen pagos
            if (listSiiPagoCargaActAdm == null || listSiiPagoCargaActAdm.size() == 0) {

                if (siiConcepCuotCarActAdm.getSiiConceptoCuota().getCcuTipoTasa().equals("SB")) {

                    for (SiiTasaIntSuperban unaSiiTasaIntSuperban : listSiiTasaIntSuperban) {
                        // System.out.println(unaSiiTasaIntSuperban.getTisVigenHasta());
                        Long dias = (unaSiiTasaIntSuperban.getTisVigenHasta().getTime() - fIni.getTime()) / MILLSECS_PER_DAY;
                        dias = dias + 1;
                        System.out.println(dias);
                        //calculo de interes simple
                        if (unaSiiTasaIntSuperban.getTisTipoInteres() != null && unaSiiTasaIntSuperban.getTisTipoInteres().equals("S")) {
                            ims =
                                ims.add(((tempSaldoS.multiply(unaSiiTasaIntSuperban.getTisTasa().multiply(BigDecimal.valueOf(dias.longValue())).divide(cien, 5, BigDecimal.ROUND_UP)))).divide(diasAno,
                                                                                                                                                                                               5,
                                                                                                                                                                                               BigDecimal.ROUND_UP));
                            //System.out.println(ims);
                        }
                        // calculo de interes compuesto
                        if (unaSiiTasaIntSuperban.getTisTipoInteres() != null && unaSiiTasaIntSuperban.getTisTipoInteres().equals("C")) {
                            ims =
                                ims.add(tempSaldoC.multiply(new BigDecimal(Math.pow((BigDecimal.ONE.add(unaSiiTasaIntSuperban.getTisTasa().divide(cien, 5, BigDecimal.ROUND_UP))).doubleValue(),
                                                                                    (BigDecimal.valueOf(dias.longValue()).divide(diasAno, 5, BigDecimal.ROUND_UP).doubleValue())) - 1)));
                            //System.out.println(ims);
                        }

                        fechaIni.setTime(unaSiiTasaIntSuperban.getTisVigenHasta());
                        fechaIni.add(Calendar.DAY_OF_YEAR, dias.intValue());
                        fIni = fechaIni.getTime();
                    }
                }
                //si  tipo de tasa es diferente a SB
                else {
                    Long dias = (fFin.getTime() - fIni.getTime()) / MILLSECS_PER_DAY;
                    dias = dias + 1;
                    SiiTasaInteres siiTasaInteres = tasaInteresDao.consultarTasaIntXFecha(fechaLP.getTime(), siiConcepCuotCarActAdm.getSiiConceptoCuota().getCcuTipoTasa());
                    if (siiTasaInteres.getTaiCodigo() != null) {
                        ims =
                            ims.add(((siiConcepCuotCarActAdm.getCamValor().multiply(siiTasaInteres.getTaiPorcentaje()).multiply(BigDecimal.valueOf(dias.longValue())).divide(cien, 5,
                                                                                                                                     BigDecimal.ROUND_UP)).divide(diasAno,5,BigDecimal.ROUND_DOWN)));
                    }
                }

                siiConceptoProyeccionCar = new SiiConceptoProyeccionCar();
                siiConceptoProyeccionCar.setCpcActivo("S");
                siiConceptoProyeccionCar.setCpcTotalInteres(ims.setScale(0, BigDecimal.ROUND_UP));
                siiConceptoProyeccionCar.setCpcSaldoInt(ims.setScale(0, BigDecimal.ROUND_UP));
                siiConceptoProyeccionCar.setCpcValorResoluc(siiConcepCuotCarActAdm.getCamValor());
                siiConceptoProyeccionCar.setCpcTotalAjustes(tempTotalAjuste);
                siiConceptoProyeccionCar.setSiiProyeccionCargaAct(siiProyeccionCargaAct);
                siiConceptoProyeccionCar.setSiiConcepCuotCarActAdm(siiConcepCuotCarActAdm);
                siiConceptoProyeccionCar.setCpcTotalPagado(BigDecimal.ZERO);
                siiConceptoProyeccionCar.setCpcTotalPagInt(BigDecimal.ZERO);
                siiConceptoProyeccionCar.setCpcSaldoCapital(siiConcepCuotCarActAdm.getCamValor().add(tempTotalAjuste));
                siiConceptoProyeccionCar.setSiiUsuarioConectado(siiCargaActuacionesAdm.getSiiUsuarioConectado());
                conceptoProyeccionCarDao.insertar(siiConceptoProyeccionCar);
            }
            else { // si  existen pagos
                Long dias = 0L;
                Long diasPago = 0L;
                Integer tempPagos = listSiiPagoCargaActAdm.size();
                BigDecimal tempValorpagado = BigDecimal.ZERO;
                BigDecimal tempValorpagadoCap = BigDecimal.ZERO;
                BigDecimal tempValorpagadoInt = BigDecimal.ZERO;
                BigDecimal tempSaldoCC   = siiConcepCuotCarActAdm.getCamValor();
                SiiTasaInteres siiTasaInteres = tasaInteresDao.consultarTasaIntXFecha(fechaLP.getTime(), siiConcepCuotCarActAdm.getSiiConceptoCuota().getCcuTipoTasa());
                
                //totaliza pagos 
                for (SiiPagoCargaActAdm unSiiPagoCargaActAdm : listSiiPagoCargaActAdm) {
                    
                    tempValorpagadoInt = tempValorpagadoInt.add(unSiiPagoCargaActAdm.getPcaValorInteres());
                    tempValorpagadoCap = tempValorpagadoCap.add(unSiiPagoCargaActAdm.getPcaValorCapital());
                }
                
                if (siiConcepCuotCarActAdm.getSiiConceptoCuota().getCcuTipoTasa().equals("SB")) {
                    for (SiiTasaIntSuperban unaSiiTasaIntSuperban : listSiiTasaIntSuperban) {
                        List<PagoCargaActAdmVO> listPagoCargaActAdmVo = new ArrayList();
                        dias = (unaSiiTasaIntSuperban.getTisVigenHasta().getTime() - fIni.getTime()) / MILLSECS_PER_DAY;
                        System.out.println(fIni);
                        System.out.println(unaSiiTasaIntSuperban.getTisVigenDesde());
                        System.out.println(unaSiiTasaIntSuperban.getTisVigenHasta());
                        System.out.println(dias);
    
                        for (SiiPagoCargaActAdm unSiiPagoCargaActAdm : listSiiPagoCargaActAdm) {
                            
                            if (unSiiPagoCargaActAdm.getPcaFechaPago().compareTo(unaSiiTasaIntSuperban.getTisVigenDesde()) >= 0 &&
                                unSiiPagoCargaActAdm.getPcaFechaPago().compareTo(unaSiiTasaIntSuperban.getTisVigenHasta()) <= 0) {
    
                                PagoCargaActAdmVO pagoCargaActAdmVo = new PagoCargaActAdmVO();
                                diasPago = (unSiiPagoCargaActAdm.getPcaFechaPago().getTime() - fIni.getTime()) / MILLSECS_PER_DAY;
                                System.out.println(unSiiPagoCargaActAdm.getPcaFechaPago());
                                System.out.println(fIni);
                                tempValorpagado = unSiiPagoCargaActAdm.getPcaValorCapital();
                                fIni = unSiiPagoCargaActAdm.getPcaFechaPago();
    
                                //agrega pagos dentro de la vigencia de la tasa
                                pagoCargaActAdmVo.setPcaValorCapital(tempValorpagado);
                                pagoCargaActAdmVo.setDiasPago(diasPago);
                                pagoCargaActAdmVo.setPcaFechaPago(unSiiPagoCargaActAdm.getPcaFechaPago());
                                listPagoCargaActAdmVo.add(pagoCargaActAdmVo);
                            }
                        }
    
                        //calcula interes si en la vigencia de la tasa no existen pagos
                        if (listPagoCargaActAdmVo.size() <= 0) {
                                //calculo de interes simple
                                if (unaSiiTasaIntSuperban.getTisTipoInteres() != null && unaSiiTasaIntSuperban.getTisTipoInteres().equals("S")) {
                                    ims =
                                        ims.add(((tempSaldoS.multiply(unaSiiTasaIntSuperban.getTisTasa().multiply(BigDecimal.valueOf(dias)).divide(cien, 5, BigDecimal.ROUND_UP)))).divide(diasAno, 5,
                                                                                                                                                                                           BigDecimal.ROUND_UP));
                                    System.out.println(ims);
                                    System.out.println(tempSaldoS);
                                    System.out.println(((tempSaldoS.multiply(unaSiiTasaIntSuperban.getTisTasa().multiply(BigDecimal.valueOf(dias)).divide(cien, 5, BigDecimal.ROUND_UP)))).divide(diasAno, 5,
                                                                                                                                                                                                  BigDecimal.ROUND_UP));
                                }
                                //calculo de interes compuesto
                                if (unaSiiTasaIntSuperban.getTisTipoInteres() != null && unaSiiTasaIntSuperban.getTisTipoInteres().equals("C")) {
        
                                    System.out.println(tempSaldoC);
                                    ims =
                                        ims.add(tempSaldoC.multiply(new BigDecimal(Math.pow((BigDecimal.ONE.add(unaSiiTasaIntSuperban.getTisTasa().divide(cien, 5, BigDecimal.ROUND_UP))).doubleValue(),
                                                                                            (BigDecimal.valueOf(dias).divide(diasAno, 5, BigDecimal.ROUND_UP).doubleValue())) - 1)));
                                    tempSaldoC =
                                        tempSaldoC.add(tempSaldoC.multiply(new BigDecimal(Math.pow((BigDecimal.ONE.add(unaSiiTasaIntSuperban.getTisTasa().divide(cien, 5, BigDecimal.ROUND_UP))).doubleValue(),
                                                                                                   (BigDecimal.valueOf(dias).divide(diasAno, 5, BigDecimal.ROUND_UP).doubleValue())) - 1)));
        
                                    System.out.println(tempSaldoC);
                                    System.out.println(ims);
                                }
                        }
                        else {
    
                            //recorre lista de pagos en la tasa vigente
                            for (int i = 0; i < listPagoCargaActAdmVo.size(); i++) {
                              
                            if (i == listPagoCargaActAdmVo.size() - 1) {
                                  if (unaSiiTasaIntSuperban.getTisTipoInteres() != null && unaSiiTasaIntSuperban.getTisTipoInteres().equals("C")) {
                                           System.out.println(tempSaldoCC);
                                           System.out.println(ims);
                                           ims =
                                             ims.add(tempSaldoCC.multiply(new BigDecimal(Math.pow((BigDecimal.ONE.add(unaSiiTasaIntSuperban.getTisTasa().divide(cien, 5, BigDecimal.ROUND_UP))).doubleValue(),
                                                                                                                     (BigDecimal.valueOf(listPagoCargaActAdmVo.get(i).getDiasPago()).divide(diasAno, 5,
                                                                                                                                                                                            BigDecimal.ROUND_UP).doubleValue())) -1)));
                                        
                                          System.out.println(ims);  
                                           tempSaldoCC = tempSaldoCC.subtract(listPagoCargaActAdmVo.get(i).getPcaValorCapital());
                                           ims =
                                             ims.add(tempSaldoCC.multiply(new BigDecimal(Math.pow((BigDecimal.ONE.add(unaSiiTasaIntSuperban.getTisTasa().divide(cien, 5, BigDecimal.ROUND_UP))).doubleValue(),
                                                                                                                     (BigDecimal.valueOf(dias-listPagoCargaActAdmVo.get(i).getDiasPago()).divide(diasAno, 5,
                                                                                                                                                                                            BigDecimal.ROUND_UP).doubleValue())) -1)));
                                        
                                           System.out.println(ims);
                                           fIni = unaSiiTasaIntSuperban.getTisVigenHasta();
                                    }
                                    else {
                                           ims =
                                           ims.add(((tempSaldoS.multiply(unaSiiTasaIntSuperban.getTisTasa().multiply(BigDecimal.valueOf(listPagoCargaActAdmVo.get(i).getDiasPago())).divide(cien, 5,
                                                                                                                                                                      BigDecimal.ROUND_UP)))).divide(diasAno,
                                                                                                                                                                      5, BigDecimal.ROUND_UP));
                                           tempSaldoS = tempSaldoS.subtract(listPagoCargaActAdmVo.get(i).getPcaValorCapital());
                                           System.out.println(ims);
                                           ims =
                                           ims.add(((tempSaldoS.multiply(unaSiiTasaIntSuperban.getTisTasa().multiply(BigDecimal.valueOf(dias - listPagoCargaActAdmVo.get(i).getDiasPago())).divide(cien, 5,
                                                                                                                                                                                                                            BigDecimal.ROUND_UP)))).divide(diasAno,
                                                                                                                                                                                                                            5,BigDecimal.ROUND_UP));
                                           System.out.println(ims);
                                           System.out.println(tempSaldoS);
                                           fIni = unaSiiTasaIntSuperban.getTisVigenHasta();
                                        }
                                }
                                else {
                                //calculo de interes simple
                                     if (unaSiiTasaIntSuperban.getTisTipoInteres() != null && unaSiiTasaIntSuperban.getTisTipoInteres().equals("S")) {
                                              System.out.println(tempSaldoS);
                                              System.out.println(ims);
                                              System.out.println(((tempSaldoS.multiply(unaSiiTasaIntSuperban.getTisTasa().multiply(BigDecimal.valueOf(listPagoCargaActAdmVo.get(i).getDiasPago())).divide(cien, 5,
                                                                                                                                                                                                  BigDecimal.ROUND_UP)))).divide(diasAno,
                                                                                                                                                                                                                           5,BigDecimal.ROUND_UP));
                                              ims =
                                                   ims.add(((tempSaldoS.multiply(unaSiiTasaIntSuperban.getTisTasa().multiply(BigDecimal.valueOf(listPagoCargaActAdmVo.get(i).getDiasPago())).divide(cien, 5,
                                                                                                                                                                                                                         BigDecimal.ROUND_UP)))).divide(diasAno,
                                                                                                                                                                                                                         5,BigDecimal.ROUND_UP));
                                              tempSaldoS = tempSaldoS.subtract(listPagoCargaActAdmVo.get(i).getPcaValorCapital());
                                              System.out.println(ims);

                                     }
                               //calculo de interes compuesto
                                     if (unaSiiTasaIntSuperban.getTisTipoInteres() != null && unaSiiTasaIntSuperban.getTisTipoInteres().equals("C")) {
                                              System.out.println(tempSaldoC);
                                              ims =
                                              ims.add(tempSaldoC.multiply(new BigDecimal(Math.pow((BigDecimal.ONE.add(unaSiiTasaIntSuperban.getTisTasa().divide(cien, 5, BigDecimal.ROUND_UP))).doubleValue(),
                                                                                                                            (BigDecimal.valueOf(listPagoCargaActAdmVo.get(i).getDiasPago()).divide(diasAno, 5,
                                                                                                          BigDecimal.ROUND_UP).doubleValue())) -  1)));
                                              tempSaldoC = tempSaldoC.subtract(listPagoCargaActAdmVo.get(i).getPcaValorCapital());
                                              System.out.println(tempSaldoC.multiply(new BigDecimal(Math.pow((BigDecimal.ONE.add(unaSiiTasaIntSuperban.getTisTasa().divide(cien, 5,
                                                                                                                                BigDecimal.ROUND_UP))).doubleValue(), (BigDecimal.valueOf(listPagoCargaActAdmVo.get(i).getDiasPago()).divide(diasAno, 5,
                                                                                                                               BigDecimal.ROUND_UP).doubleValue())) - 1)));
                                              tempSaldoCC = tempSaldoCC.subtract(listPagoCargaActAdmVo.get(i).getPcaValorCapital());
                                              System.out.println(ims);
                                   }

                                fIni = listPagoCargaActAdmVo.get(i).getPcaFechaPago();
                                dias = dias - listPagoCargaActAdmVo.get(i).getDiasPago();
                              }
                            }
                        }
                      
                        if (listPagoCargaActAdmVo.size() <= 0)
                            fIni = unaSiiTasaIntSuperban.getTisVigenHasta();
                    }
                }
                //  para tasas dirferentes de SB
                else{
                        if (siiTasaInteres.getTaiCodigo() != null) {
                            fIni = fechaLP.getTime();
                            //ims = BigDecimal.ZERO;
                            List<PagoCargaActAdmVO> listPagoCargaActAdmVo = new ArrayList();
        
                            for (SiiPagoCargaActAdm unSiiPagoCargaActAdm : listSiiPagoCargaActAdm) {
                              
                                dias = (fechaActual.getTime() - fIni.getTime()) / MILLSECS_PER_DAY;
                                System.out.println(fIni);
                                System.out.println(fechaActual);
                                System.out.println(dias);
                                System.out.println(ims);
                                System.out.println(unSiiPagoCargaActAdm.getPcaFechaPago());
                             
                                diasPago = (unSiiPagoCargaActAdm.getPcaFechaPago().getTime() - fIni.getTime()) / MILLSECS_PER_DAY;
                                ims =
                                    ims.add(((tempSaldoD.multiply(siiTasaInteres.getTaiPorcentaje()).multiply(BigDecimal.valueOf(diasPago)).divide(cien, 5,
                                                                                                          BigDecimal.ROUND_UP)).divide(diasAno,5,BigDecimal.ROUND_DOWN)));
                                fIni  = unSiiPagoCargaActAdm.getPcaFechaPago();
                                tempSaldoD = tempSaldoD.subtract(unSiiPagoCargaActAdm.getPcaValorCapital()); 
                                System.out.println(ims);
                                System.out.println(tempSaldoD);                         
                            }      
                            
                            // valida ultimo pago 
                            diasPago = (fechaActual.getTime() - fIni.getTime()) / MILLSECS_PER_DAY;
                            ims =
                                ims.add(((tempSaldoD.multiply(siiTasaInteres.getTaiPorcentaje()).multiply(BigDecimal.valueOf(diasPago)).divide(cien, 5,
                                                                                                      BigDecimal.ROUND_UP)).divide(diasAno,5,BigDecimal.ROUND_DOWN)));
                            System.out.println(ims);
                            System.out.println(tempSaldoD);     
                        }
                    }
                
                siiConceptoProyeccionCar = new SiiConceptoProyeccionCar();
                siiConceptoProyeccionCar.setCpcActivo("S");
                siiConceptoProyeccionCar.setCpcTotalInteres(ims.setScale(0, BigDecimal.ROUND_HALF_UP));
                siiConceptoProyeccionCar.setCpcValorResoluc(siiConcepCuotCarActAdm.getCamValor());
                siiConceptoProyeccionCar.setCpcTotalPagado(tempValorpagadoCap);
                siiConceptoProyeccionCar.setCpcSaldoInt(ims.subtract(tempValorpagadoInt).setScale(0, BigDecimal.ROUND_HALF_UP));
                siiConceptoProyeccionCar.setCpcSaldoCapital(siiConcepCuotCarActAdm.getCamValor().add(tempTotalAjuste).subtract(tempValorpagadoCap));
                siiConceptoProyeccionCar.setCpcTotalAjustes(tempTotalAjuste);
                siiConceptoProyeccionCar.setCpcTotalPagInt(tempValorpagadoInt);
                siiConceptoProyeccionCar.setSiiProyeccionCargaAct(siiProyeccionCargaAct);
                siiConceptoProyeccionCar.setSiiConcepCuotCarActAdm(siiConcepCuotCarActAdm);
                siiConceptoProyeccionCar.setSiiUsuarioConectado(siiCargaActuacionesAdm.getSiiUsuarioConectado());
                conceptoProyeccionCarDao.insertar(siiConceptoProyeccionCar);
            }
        }

        return cargaActuacionesAdmVo;
    }

    public List<CargaActuacionesAdmVO> buscarTodasCargaActuacionesAdm() throws ExcepcionDAO {
        List<SiiCargaActuacionesAdm> listaCargaActuacionesAdm = cargaActuacionesAdmDao.buscarTodo();
        List<CargaActuacionesAdmVO> listaCargaActuacionesAdmVo = new ArrayList();
        ProyeccionCargaActVO proyeccionCargaActVo = new ProyeccionCargaActVO();

        for (SiiCargaActuacionesAdm unaSiiCargaActuacionesAdm : listaCargaActuacionesAdm) {
            List<SiiProyeccionCargaAct> listSiiroyeccionCargaAct = proyeccionCargaActDao.buscarProyeccionCargaActXConceptoCuotaActAdmin(unaSiiCargaActuacionesAdm.getCaaCodigo());

            if (listSiiroyeccionCargaAct.size() > 0)
                proyeccionCargaActVo = new ProyeccionCargaActVO(listSiiroyeccionCargaAct.get(0));

            //totaliza valorde conceptos activos
            BigDecimal tempTotalValor = BigDecimal.ZERO;
            for (SiiConcepCuotCarActAdm concepCuotCarActAdm : unaSiiCargaActuacionesAdm.getSiiConcepCuotCarActAdmList()) {
                if (concepCuotCarActAdm.getCamActivo().equals("S"))
                    tempTotalValor = tempTotalValor.add(concepCuotCarActAdm.getCamValor());
            }
            CargaActuacionesAdmVO cargaActuacionesAdmVo = new CargaActuacionesAdmVO(unaSiiCargaActuacionesAdm);
            cargaActuacionesAdmVo.setValorInicial(tempTotalValor);
            if (cargaActuacionesAdmVo.getCaaEstado().equals("B"))
                cargaActuacionesAdmVo.setCaaEstado("BORRADOR");
            if (cargaActuacionesAdmVo.getCaaEstado().equals("M"))
                cargaActuacionesAdmVo.setCaaEstado("MIGRADO");

            cargaActuacionesAdmVo.setProyeccionCargaActVo(proyeccionCargaActVo);
            listaCargaActuacionesAdmVo.add(cargaActuacionesAdmVo);


        }
        return listaCargaActuacionesAdmVo;
    }

    public CargaActuacionesAdmVO buscarCargaActuacionesAdmXId(Long caaCodigo) throws ExcepcionDAO {
        List<ConcepCuotCarActAdmVO> listConcepCuotCarActAdmVo = new ArrayList();
        List<PagoCargaActAdmVO> listPagoCargaActAdmVo = new ArrayList();
        List<AjusteContCarActVO> listAjusteContCarActVo = new ArrayList();
        List<EstablecConCuoCarVO> listEstablecConCuoCarVo;
        SiiCargaActuacionesAdm unaCargaActuacionesAdm = cargaActuacionesAdmDao.buscarPorCodigo(caaCodigo);
        CargaActuacionesAdmVO cargaActuacionesAdmVo = new CargaActuacionesAdmVO(unaCargaActuacionesAdm);
        // busca conceptos cuota carga asociados
        List<SiiConcepCuotCarActAdm> listSiiConcepCuotCarActAdm = concepCuotCarActAdmDao.buscarTodoSiiConcepCuotCarActAdmXLiqActAdmin(cargaActuacionesAdmVo.getCaaCodigo());
        for (SiiConcepCuotCarActAdm siiConcepCuotCarActAdm : listSiiConcepCuotCarActAdm) {
            listEstablecConCuoCarVo = new ArrayList();
            ConcepCuotCarActAdmVO concepCuotCarActAdmVo = new ConcepCuotCarActAdmVO(siiConcepCuotCarActAdm);
            concepCuotCarActAdmVo.setCcuNombre(concepCuotCarActAdmVo.getConceptoCuotaVo().getCcuNombre());
            List<SiiEstablecConCuoCar> listSiiEstablecConCuoCar = establecConCuoCarDao.buscarTodoEstablecConCuoCarXConcepCuotaAct(siiConcepCuotCarActAdm.getCamCodigo());
            for (SiiEstablecConCuoCar siiEstablecConCuoCar : listSiiEstablecConCuoCar) {
                EstablecConCuoCarVO establecConCuoCarVo = new EstablecConCuoCarVO(siiEstablecConCuoCar);
                establecConCuoCarVo.setUbiCodigo(establecConCuoCarVo.getUbicacionMunicipioVo().getUbiCodigo());
                listEstablecConCuoCarVo.add(establecConCuoCarVo);
            }
            concepCuotCarActAdmVo.setListEstablecConCuoCarVo(listEstablecConCuoCarVo);
            listConcepCuotCarActAdmVo.add(concepCuotCarActAdmVo);
        }
        //busca pagos asociados
        List<SiiPagoCargaActAdm> listSiiPagoCargaActAdm = pagoCargaActAdmDao.buscarTodoSiiPagoCargaActAdmXLiqActAdmin(cargaActuacionesAdmVo.getCaaCodigo(), null);
        for (SiiPagoCargaActAdm siiPagoCargaActAdm : listSiiPagoCargaActAdm) {
            PagoCargaActAdmVO pagoCargaActAdmVo = new PagoCargaActAdmVO(siiPagoCargaActAdm);
            pagoCargaActAdmVo.setCcuNombre(pagoCargaActAdmVo.getConceptoCuotaVo().getCcuNombre());
            listPagoCargaActAdmVo.add(pagoCargaActAdmVo);
        }
        // busca ajustes asociados
        List<SiiAjusteContCarAct> listSiiAjusteContCarAct = ajusteContCarActDao.buscarTodoSiiAjusteContCarActXLiqActAdmin(cargaActuacionesAdmVo.getCaaCodigo(), null);
        for (SiiAjusteContCarAct siiAjusteContCarAct : listSiiAjusteContCarAct) {
            AjusteContCarActVO ajusteContCarActVo = new AjusteContCarActVO(siiAjusteContCarAct);
            ajusteContCarActVo.setCcuNombre(ajusteContCarActVo.getConcepCuotCarActAdmVo().getConceptoCuotaVo().getCcuNombre());
            listAjusteContCarActVo.add(ajusteContCarActVo);
        }

        cargaActuacionesAdmVo.setListAjusteContCarActVo(listAjusteContCarActVo);
        cargaActuacionesAdmVo.setListPgoCargaActAdmVo(listPagoCargaActAdmVo);
        cargaActuacionesAdmVo.setListConcepCuotCarActAdmVO(listConcepCuotCarActAdmVo);


        return cargaActuacionesAdmVo;
    }

    public List<CargaActuacionesAdmVO> buscarNumReSolucionFechaActAdm(Long numResolucion, Date fechaActAdm) throws ExcepcionDAO {
        List<CargaActuacionesAdmVO> listCargaActuacionesAdmVo = new ArrayList();
        List<SiiCargaActuacionesAdm> listSiiCargaActuacionesAdm = cargaActuacionesAdmDao.buscarNumReSolucionFechaActAdm(numResolucion, fechaActAdm);
        for (SiiCargaActuacionesAdm siiCargaActuacionesAdm : listSiiCargaActuacionesAdm) {
            listCargaActuacionesAdmVo.add(new CargaActuacionesAdmVO(siiCargaActuacionesAdm));
        }

        return listCargaActuacionesAdmVo;
    }

    public Date obtenerDiasHabiles(Calendar fechaInicial, Calendar fechaFinal) {
        String fechaIni = sdf.format(fechaInicial.getTime());
        String fechaFin = sdf.format(fechaFinal.getTime());
        Date festivo;
        int conta = 0;
        try {
            while (!fechaInicial.equals(fechaFinal)) {
                fechaIni = sdf.format(fechaInicial.getTime());
                festivo = festivoDao.buscarSiiFestivo(fechaInicial.getTime());
                //System.out.println(fechaInicial.getTime());
                if (fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && festivo == null) {
                    fechaInicial.add(Calendar.DATE, 1);
                    conta++;
                }
                else {
                    fechaFinal.add(Calendar.DATE, 1);
                    fechaInicial.add(Calendar.DATE, 1);
                    //  System.out.println(fechaInicial.getTime());
                    //  System.out.println(fechaFinal.getTime());
                }
                if (conta == 9) {
                    break;
                }
                fechaIni = sdf.format(fechaInicial.getTime());
                //System.out.println(fechaIni);
            }
            fechaIni = sdf.format(fechaInicial.getTime());
            if (fechaInicial.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                fechaInicial.add(Calendar.DATE, 2);

            }
            else if (fechaInicial.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                fechaInicial.add(Calendar.DATE, 1);
            }
            if (festivoDao.buscarSiiFestivo(fechaInicial.getTime()) != null) {
                fechaInicial.add(Calendar.DATE, 1);
            }
        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();

        }
        fechaIni = sdf.format(fechaInicial.getTime());
        return fechaInicial.getTime();

    }

    public int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    public List<ProcesoOriCargaVO> buscarTodoProcesoOriCarga() throws ExcepcionDAO {
        List<ProcesoOriCargaVO> resultado = null;
        List<SiiProcesoOriCarga> lista = procesoOriCargaDao.buscarTodo();
        if (lista != null) {
            resultado = new ArrayList<ProcesoOriCargaVO>();
            for (SiiProcesoOriCarga siiProcesoOriCarga : lista) {
                if (siiProcesoOriCarga != null)
                    resultado.add(new ProcesoOriCargaVO(siiProcesoOriCarga));
            }
        }

        return (resultado);
    }


    public List<ProcesoOriCargaVO> buscarTodosProcesoOriCarga() throws ExcepcionDAO {
        List<ProcesoOriCargaVO> listProcesoOriCargaVo = new ArrayList();
        List<SiiProcesoOriCarga> listSiiProcesoOriCarga = procesoOriCargaDao.buscarTodo();
        for (SiiProcesoOriCarga siiProcesoOriCarga : listSiiProcesoOriCarga) {
            ProcesoOriCargaVO unProcesoOriCargaVo = new ProcesoOriCargaVO(siiProcesoOriCarga);
            listProcesoOriCargaVo.add(unProcesoOriCargaVo);
        }

        return listProcesoOriCargaVo;
    }

    public List<ProyeccionCargaActVO> buscarProyeccionCargaActXConceptoCuotaActAdmin(Long caaCodigo) throws ExcepcionDAO {
        List<ProyeccionCargaActVO> listProyeccionCargaActVo = new ArrayList();
        List<SiiProyeccionCargaAct> listSiiroyeccionCargaAct = proyeccionCargaActDao.buscarProyeccionCargaActXConceptoCuotaActAdmin(caaCodigo);
        for (SiiProyeccionCargaAct siiProyeccionCargaAct : listSiiroyeccionCargaAct) {
            listProyeccionCargaActVo.add(new ProyeccionCargaActVO(siiProyeccionCargaAct));
        }

        return listProyeccionCargaActVo;
    }
    
    public List<CargaActuacionesAdmVO> buscarPersonasCargaActAdminPorNumeroId(String identificacion) throws ExcepcionDAO{
          List<CargaActuacionesAdmVO> listaCargaActuacionesAdmVo = new ArrayList();
          List<SiiCargaActuacionesAdm> listaSiiCargaActuacionesAdm =  cargaActuacionesAdmDao.buscarPersonasCargaActAdminPorNumeroId(identificacion);
          for (SiiCargaActuacionesAdm siiCargaActuacionesAdm :listaSiiCargaActuacionesAdm){
              listaCargaActuacionesAdmVo.add(new CargaActuacionesAdmVO(siiCargaActuacionesAdm));
          }
          return listaCargaActuacionesAdmVo;
      }
 

}
