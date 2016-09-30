package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumConceptoCuota;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoPolizaContrato;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocRadicado;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoPersonal;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.gct.AdminContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CorteCarteraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DeclaracionOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DeclaracionSugeridaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleCorteCarteraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionSugDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoRadicadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedienteDocumDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedienteRadicadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantiaPolizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistPersonalEmpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonalEmpresaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PolizaContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReferenciaPagoDeclDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SancionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocRadicadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoIdentificacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoPersonalDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoRetencionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSociedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCorteCartera;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionSugerida;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracionSug;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoRadicado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteDocum;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteRadicado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistPersonalEmp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonalEmpresa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReferenciaPagoDecl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocRadicado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPersonal;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoRetencion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSociedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOWS;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDeclaracionSugVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCuentaVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.OperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ConceptoCuotaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ContratoInformacionWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.CuotaOperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.DeclaracionOperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.DetalleOperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.DocumentoRadicadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.EstadoSolicAutorizWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ExpedienteRadicadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ImpedimContratoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ImpedimentoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ImpedimentosWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.InventarioMarcarMetVO;
import co.gov.coljuegos.siicol.ejb.wsvo.LiquidacionOtrosConceptosWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.OperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.PersonaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;




import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminOperadorBean implements AdminOperador {


    @EJB
    private OperadorDAO operadorDao;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private PersonalEmpresaDAO personalEmpresaDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private SolicitudAutorizaDAO solicitudAutorizaDao;
    @EJB
    private ConversionVOWS conversionVoWs;
    @EJB
    private CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    private PolizaContratDAO polizaContratoDao;
    @EJB
    private GarantiaPolizaDAO garantiaPolizaDao;
    @EJB
    private HistPersonaDAO histPersonaDao;
    @EJB
    private HistPersonalEmpDAO histPersonalEmpDao;
    @EJB
    private DeclaracionSugeridaDAO declaracionSugeridaDao;
    @EJB
    private DeclaracionOperadorDAO declaracionOperadorDao;
    @EJB
    private ReferenciaPagoDeclDAO referenciaPagoDeclDao;
    @EJB
    private DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB
    private ContratoDAO contratoDao;
    @EJB
    private ExpedienteDocumDAO expedienteDocumDao;
    @EJB
    private DocumentoRadicadoDAO documentoRadicadoDao;
    @EJB
    private ExpedienteRadicadoDAO expedienteRadicadoDao;
    @EJB
    private DetalleDeclaracionSugDAO detalleDeclaracionSugDao;
    @EJB
    private InventarioDAO inventarioDao;
    @EJB
    private MetDAO metDao;
    @EJB
    private TipoSociedadDAO tipoSociedadDao;
    @EJB
    private TipoPersonalDAO tipoPersonalDao;
    @EJB
    private TipoDocRadicadoDAO tipoDocRadicadoDao;
    @EJB
    private UbicacionDAO ubicacionDao;
    @EJB
    private TipoRetencionDAO tipoRetencionDao;
    @EJB
    private TipoIdentificacionDAO tipoIdentificacionDao;
    @EJB
    private AdminContrato adminContrato;
    @EJB
    private SancionDAO sancionDao;
    @EJB
    private CorteCarteraDAO corteCarteraDao;
    @EJB
    private DetalleCorteCarteraDAO detalleCorteCarteraDao;
    @EJB
    private ContratoDAO contratoDAO;
    @EJB
    private NovedadDAO novedadDAO;



    public AdminOperadorBean() {
    }

    public List<OperadorVO> buscarOperadorPorNit(String pNit) throws ExcepcionDAO {
        List<SiiOperador> listaOperadores = operadorDao.buscarOperadorPorNit(pNit);
        List<OperadorVO> listaOperadorVo = new ArrayList<OperadorVO>();
        for (SiiOperador unOperador : listaOperadores) {
            listaOperadorVo.add(new OperadorVO(unOperador));
        }
        return listaOperadorVo;
    }

    /**
     *Metodo encargado de hacer la insercion de un operador
     * @author David Tafur
     * @param operadorWSVO
     * @param repLegalWSVO
     * @param revisorFiscalWSVO
     * @param repLegalSuplenteWSVO
     * @param revisorFiscalSuplenteWSVO
     * @param contactoWSVO
     * @param apoderadoWSVO
     * @param socio1WSVO
     * @param socio2WSVO
     * @param socio3WSVO
     * @param socio4WSVO
     * @param socio5WSVO
     * @param contadorWSVO
     * @param solicitudAutorizacionWSVO
     * @param listaExpedienteRadicadoWsVo
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     * @throws Exception
     */
    public String insertarSiiOperador(OperadorWSVO operadorWSVO, PersonaWSVO repLegalWSVO,
                                      PersonaWSVO revisorFiscalWSVO, PersonaWSVO repLegalSuplenteWSVO,
                                      PersonaWSVO revisorFiscalSuplenteWSVO, PersonaWSVO contactoWSVO,
                                      PersonaWSVO apoderadoWSVO, PersonaWSVO socio1WSVO, PersonaWSVO socio2WSVO,
                                      PersonaWSVO socio3WSVO, PersonaWSVO socio4WSVO, PersonaWSVO socio5WSVO,
                                      PersonaWSVO contadorWSVO, SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                      List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO,
                                                                                                      ExcepcionAplicacion{
        String resultado = "";
        try {

            PersonaVO operadorVO = null;
            SolicitudAutorizaVO solicitudVO = null;
            Calendar calendar = Calendar.getInstance();

            //Validamos que la solicitud de registro de operador traiga el tipo de sociedad
            if (operadorWSVO.tipoSociedad == null || operadorWSVO.tipoSociedad == 0) {
                throw new ExcepcionAplicacion("El tipo de sociedad no puede ser nulo por favor verifique.");
            }
            //Validamos que el digito de verificacion del operador venga
            if (operadorWSVO.digitoVerificacion == null) {
                throw new ExcepcionAplicacion("El digito de verificacion no puede ser nulo por favor verifique.");
            }
            
            if(listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1){
                throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");
                
            }
            
            //Validamos que almenos traiga un documento
            boolean hayDocumento = false;
            for(ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo){
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null || expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0){
                    hayDocumento = true;
                    break;
                }
            }
            
            if(!hayDocumento){
                throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
            }
            

            // Transformaciones de los parámetros

            if (operadorWSVO == null) {
                throw new ExcepcionAplicacion("El operador no puede ser nulo");
            } else {
                operadorVO = conversionVoWs.convertir(operadorWSVO);
            }

            if (solicitudAutorizacionWSVO == null) {
                throw new ExcepcionAplicacion("La solicitud no puede ser nula");
            } else {
                solicitudVO = conversionVoWs.convertir(solicitudAutorizacionWSVO);
            }

            if (repLegalWSVO == null) {
                throw new ExcepcionAplicacion("El representante legal no puede ser nulo");
            }
            
            if (contadorWSVO == null){
                throw new ExcepcionAplicacion("El contador no puede ser nulo");
            }
            
            if(repLegalWSVO.perTipoPersona.equals("J")){
                throw new ExcepcionAplicacion("El representante legal no puede ser persona Jurídica");
            }
            
            if(repLegalWSVO.perTipoPersona == null){
                throw new ExcepcionAplicacion("El tipo de documento del representante legal no puede ser nulo");
            }

            Date fechaActual = new Date();

            //Se valida la existencia de la persona
            SiiPersona siiPersonaOperador = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(),operadorWSVO.numIdentificacion);
            if (siiPersonaOperador != null) {
                throw new ExcepcionAplicacion("No se cargó la información del operador porque ya existe en la base de datos de Siicol");
            }

            //Buscar el representante Legal
            SiiPersona siiPersonaRepLegal = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(repLegalWSVO.tipoIdentificacion), repLegalWSVO.numIdentificacion);
            
            if (siiPersonaRepLegal == null) {
                siiPersonaRepLegal = copiarPersonaWsVoASiiPersona(repLegalWSVO, new SiiPersona());
                personaDao.insertarPersona(siiPersonaRepLegal);
            } else {
                siiPersonaRepLegal = copiarPersonaWsVoASiiPersona(repLegalWSVO, siiPersonaRepLegal);
                personaDao.actualizarPersona(siiPersonaRepLegal);
            }

            //se inserta el operador
            siiPersonaOperador = conversionVoEntidad.convertir(operadorVO);
            siiPersonaOperador.setSiiPersona(siiPersonaRepLegal);
            //Tipo sociedad del operador
            SiiTipoSociedad siiTipoSociedad = tipoSociedadDao.buscarPorCodigo(operadorWSVO.tipoSociedad);
            siiPersonaOperador.setSiiTipoSociedad(siiTipoSociedad);
            siiPersonaOperador = personaDao.insertarPersona(siiPersonaOperador);
            SiiOperador siiOperador = new SiiOperador();
            siiOperador.setSiiPersona(siiPersonaOperador);
            
            siiOperador = operadorDao.insertarSiiOperador(siiOperador);

            // se inserta el personal

            // Revisor fiscal
            if (revisorFiscalWSVO != null) {
                SiiPersona siiRevisorFiscal = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(revisorFiscalWSVO.tipoIdentificacion), revisorFiscalWSVO.numIdentificacion);
                
                if (siiRevisorFiscal == null) {
                    siiRevisorFiscal = copiarPersonaWsVoASiiPersona(revisorFiscalWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiRevisorFiscal);
                } else {
                    siiRevisorFiscal = copiarPersonaWsVoASiiPersona(revisorFiscalWSVO, siiRevisorFiscal);
                    personaDao.actualizarPersona(siiRevisorFiscal);
                }

                // se inserta en personal - empresa
                SiiPersonalEmpresa siiPersonalEmpresaNew = new SiiPersonalEmpresa();
                siiPersonalEmpresaNew.setSiiPersona(siiPersonaOperador);
                siiPersonalEmpresaNew.setPemFechaRegistro(fechaActual);
                siiPersonalEmpresaNew.setSiiPersona3(siiRevisorFiscal);
                SiiTipoPersonal siiTipoPersonalRev = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.REVISOR_FISCAL.getId());
                siiPersonalEmpresaNew.setSiiTipoPersonal(siiTipoPersonalRev);
                siiPersonalEmpresaNew.setPemActivo("S");
                personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNew);

            }

            // Representante legal suplente
            if (repLegalSuplenteWSVO != null) {
                SiiPersona siiRepresentanteLegalSuplente = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(repLegalSuplenteWSVO.tipoIdentificacion), repLegalSuplenteWSVO.numIdentificacion);
                
                if (siiRepresentanteLegalSuplente == null) {
                    siiRepresentanteLegalSuplente = copiarPersonaWsVoASiiPersona(repLegalSuplenteWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiRepresentanteLegalSuplente);
                } else {
                    siiRepresentanteLegalSuplente = copiarPersonaWsVoASiiPersona(repLegalSuplenteWSVO, siiRepresentanteLegalSuplente);
                    personaDao.actualizarPersona(siiRepresentanteLegalSuplente);
                }

                // se inserta en personal - empresa
                SiiPersonalEmpresa siiPersonalEmpresaNew = new SiiPersonalEmpresa();
                siiPersonalEmpresaNew.setSiiPersona(siiPersonaOperador);
                siiPersonalEmpresaNew.setPemFechaRegistro(fechaActual);
                siiPersonalEmpresaNew.setSiiPersona3(siiRepresentanteLegalSuplente);
                SiiTipoPersonal siiTipoPersonalRev = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.REPRESENTANTE_LEGAL_SUPLENTE.getId());
                siiPersonalEmpresaNew.setSiiTipoPersonal(siiTipoPersonalRev);
                siiPersonalEmpresaNew.setPemActivo("S");
                personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNew);

            }

            // Revisor fiscal suplente
            if (revisorFiscalSuplenteWSVO != null) {
                SiiPersona siiRevisorFiscalSuplente = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(revisorFiscalSuplenteWSVO.tipoIdentificacion), revisorFiscalSuplenteWSVO.numIdentificacion);
                
                if (siiRevisorFiscalSuplente == null) {
                    siiRevisorFiscalSuplente = copiarPersonaWsVoASiiPersona(revisorFiscalSuplenteWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiRevisorFiscalSuplente);
                } else {
                    siiRevisorFiscalSuplente = copiarPersonaWsVoASiiPersona(revisorFiscalSuplenteWSVO, siiRevisorFiscalSuplente);
                    personaDao.actualizarPersona(siiRevisorFiscalSuplente);
                }

                // se inserta en personal - empresa
                SiiPersonalEmpresa siiPersonalEmpresaNew = new SiiPersonalEmpresa();
                siiPersonalEmpresaNew.setSiiPersona(siiPersonaOperador);
                siiPersonalEmpresaNew.setPemFechaRegistro(fechaActual);
                siiPersonalEmpresaNew.setSiiPersona3(siiRevisorFiscalSuplente);
                SiiTipoPersonal siiTipoPersonalRev = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.REVISOR_FISCAL_SUPLENTE.getId());
                siiPersonalEmpresaNew.setSiiTipoPersonal(siiTipoPersonalRev);
                siiPersonalEmpresaNew.setPemActivo("S");
                personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNew);

            }

            // Persona de contacto
            if (contactoWSVO != null) {
                SiiPersona siiPersonaContactoEmp = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(contactoWSVO.tipoIdentificacion), contactoWSVO.numIdentificacion);
                
                if (siiPersonaContactoEmp == null) {
                    siiPersonaContactoEmp = copiarPersonaWsVoASiiPersona(contactoWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiPersonaContactoEmp);
                } else {
                    siiPersonaContactoEmp = copiarPersonaWsVoASiiPersona(contactoWSVO, siiPersonaContactoEmp);
                    personaDao.actualizarPersona(siiPersonaContactoEmp);
                }

                // se inserta en personal - empresa
                SiiPersonalEmpresa siiPersonalEmpresaCon = new SiiPersonalEmpresa();
                siiPersonalEmpresaCon.setSiiPersona(siiPersonaOperador);
                siiPersonalEmpresaCon.setPemFechaRegistro(fechaActual);
                siiPersonalEmpresaCon.setSiiPersona3(siiPersonaContactoEmp);
                SiiTipoPersonal siiTipoPersonalCon = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.CONTACTO_EMPRESA.getId());
                siiPersonalEmpresaCon.setSiiTipoPersonal(siiTipoPersonalCon);
                siiPersonalEmpresaCon.setPemActivo("S");
                personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaCon);

            }

            // Apoderado
            if (apoderadoWSVO != null) {
                SiiPersona siiPersonaApoderadoEmp = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(apoderadoWSVO.tipoIdentificacion), apoderadoWSVO.numIdentificacion);
                
                if (siiPersonaApoderadoEmp == null) {
                    siiPersonaApoderadoEmp = copiarPersonaWsVoASiiPersona(apoderadoWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiPersonaApoderadoEmp);
                } else {
                    siiPersonaApoderadoEmp = copiarPersonaWsVoASiiPersona(apoderadoWSVO, siiPersonaApoderadoEmp);
                    personaDao.actualizarPersona(siiPersonaApoderadoEmp);
                }
                
                // se inserta en personal - empresa
                SiiPersonalEmpresa siiPersonalEmpresaApo = new SiiPersonalEmpresa();
                siiPersonalEmpresaApo.setSiiPersona(siiPersonaOperador);
                siiPersonalEmpresaApo.setPemFechaRegistro(fechaActual);
                siiPersonalEmpresaApo.setSiiPersona3(siiPersonaApoderadoEmp);
                SiiTipoPersonal siiTipoPersonalCon = new SiiTipoPersonal();
                siiTipoPersonalCon.setTpeCodigo(EnumTipoPersonal.APODERADO.getId());
                siiPersonalEmpresaApo.setSiiTipoPersonal(siiTipoPersonalCon);
                siiPersonalEmpresaApo.setPemActivo("S");
                personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaApo);

            }

            // Socio Mayoritario uno
            if (socio1WSVO != null) {
                if (socio1WSVO.numIdentificacion != null && !socio1WSVO.numIdentificacion.equals("") &&
                    socio1WSVO.tipoIdentificacion > 0) {

                    SiiPersona resultadoSocio1 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(socio1WSVO.tipoIdentificacion), socio1WSVO.numIdentificacion);
                    
                    if (resultadoSocio1 == null) {
                        resultadoSocio1 = copiarPersonaWsVoASiiPersona(socio1WSVO, new SiiPersona());
                        personaDao.insertarPersona(resultadoSocio1);
                    } else {
                        resultadoSocio1.setPerPrimerNombre(socio1WSVO.primerNombre);
                        resultadoSocio1.setPerPrimerApellido(socio1WSVO.primerApellido);
                        resultadoSocio1.setPerSegundoNombre(socio1WSVO.segundoNombre);
                        resultadoSocio1.setPerSegundoApellido(socio1WSVO.segundoApellido);
                        personaDao.actualizarPersona(resultadoSocio1);
                    }

                    // se inserta en personal - empresa
                    SiiPersonalEmpresa siiPersonalEmpresaSoc1 = new SiiPersonalEmpresa();
                    siiPersonalEmpresaSoc1.setSiiPersona(siiPersonaOperador);
                    siiPersonalEmpresaSoc1.setPemFechaRegistro(fechaActual);
                    siiPersonalEmpresaSoc1.setSiiPersona3(resultadoSocio1);
                    SiiTipoPersonal siiTipoPersonalSoc1 = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_1.getId());
                    siiPersonalEmpresaSoc1.setSiiTipoPersonal(siiTipoPersonalSoc1);
                    siiPersonalEmpresaSoc1.setPemActivo("S");
                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaSoc1);
                }
            }

            if (socio2WSVO != null) {
                if (socio2WSVO.numIdentificacion != null && !socio2WSVO.numIdentificacion.equals("") &&
                    socio2WSVO.tipoIdentificacion > 0) {
                    SiiPersona resultadoSocio2 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(socio2WSVO.tipoIdentificacion), socio2WSVO.numIdentificacion);
                    
                    if (resultadoSocio2 == null) {
                        resultadoSocio2 = copiarPersonaWsVoASiiPersona(socio2WSVO, new SiiPersona());
                        personaDao.insertarPersona(resultadoSocio2);
                    } else {
                        resultadoSocio2.setPerPrimerNombre(socio1WSVO.primerNombre);
                        resultadoSocio2.setPerPrimerApellido(socio1WSVO.primerApellido);
                        resultadoSocio2.setPerSegundoNombre(socio1WSVO.segundoNombre);
                        resultadoSocio2.setPerSegundoApellido(socio1WSVO.segundoApellido);
                        personaDao.actualizarPersona(resultadoSocio2);
                    }

                    // se inserta en personal - empresa
                    SiiPersonalEmpresa siiPersonalEmpresaSoc1 = new SiiPersonalEmpresa();
                    siiPersonalEmpresaSoc1.setSiiPersona(siiPersonaOperador);
                    siiPersonalEmpresaSoc1.setPemFechaRegistro(fechaActual);
                    siiPersonalEmpresaSoc1.setSiiPersona3(resultadoSocio2);
                    SiiTipoPersonal siiTipoPersonalSoc1 = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_2.getId());
                    siiPersonalEmpresaSoc1.setSiiTipoPersonal(siiTipoPersonalSoc1);
                    siiPersonalEmpresaSoc1.setPemActivo("S");
                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaSoc1);
                }
            }

            if (socio3WSVO != null) {
                if (socio3WSVO.numIdentificacion != null && !socio3WSVO.numIdentificacion.equals("") &&
                    socio3WSVO.tipoIdentificacion > 0) {
                    SiiPersona resultadoSocio3 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(socio3WSVO.tipoIdentificacion), socio3WSVO.numIdentificacion);
                    
                    if (resultadoSocio3 == null) {
                        resultadoSocio3 = copiarPersonaWsVoASiiPersona(socio3WSVO, new SiiPersona());
                        personaDao.insertarPersona(resultadoSocio3);
                    } else {
                        resultadoSocio3.setPerPrimerNombre(socio1WSVO.primerNombre);
                        resultadoSocio3.setPerPrimerApellido(socio1WSVO.primerApellido);
                        resultadoSocio3.setPerSegundoNombre(socio1WSVO.segundoNombre);
                        resultadoSocio3.setPerSegundoApellido(socio1WSVO.segundoApellido);
                        personaDao.actualizarPersona(resultadoSocio3);
                    }

                    // se inserta en personal - empresa
                    SiiPersonalEmpresa siiPersonalEmpresaSoc1 = new SiiPersonalEmpresa();
                    siiPersonalEmpresaSoc1.setSiiPersona(siiPersonaOperador);
                    siiPersonalEmpresaSoc1.setPemFechaRegistro(fechaActual);
                    siiPersonalEmpresaSoc1.setSiiPersona3(resultadoSocio3);
                    SiiTipoPersonal siiTipoPersonalSoc1 = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_3.getId());
                    siiPersonalEmpresaSoc1.setSiiTipoPersonal(siiTipoPersonalSoc1);
                    siiPersonalEmpresaSoc1.setPemActivo("S");
                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaSoc1);
                }
            }

            if (socio4WSVO != null) {
                if (socio4WSVO.numIdentificacion != null && !socio4WSVO.numIdentificacion.equals("") &&
                    socio4WSVO.tipoIdentificacion > 0) {
                    SiiPersona resultadoSocio4 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(socio4WSVO.tipoIdentificacion), socio4WSVO.numIdentificacion);
                    
                    if (resultadoSocio4 == null) {
                        resultadoSocio4 = copiarPersonaWsVoASiiPersona(socio4WSVO, new SiiPersona());
                        personaDao.insertarPersona(resultadoSocio4);
                    } else {
                        resultadoSocio4.setPerPrimerNombre(socio1WSVO.primerNombre);
                        resultadoSocio4.setPerPrimerApellido(socio1WSVO.primerApellido);
                        resultadoSocio4.setPerSegundoNombre(socio1WSVO.segundoNombre);
                        resultadoSocio4.setPerSegundoApellido(socio1WSVO.segundoApellido);
                        personaDao.actualizarPersona(resultadoSocio4);
                    }

                    // se inserta en personal - empresa
                    SiiPersonalEmpresa siiPersonalEmpresaSoc1 = new SiiPersonalEmpresa();
                    siiPersonalEmpresaSoc1.setSiiPersona(siiPersonaOperador);
                    siiPersonalEmpresaSoc1.setPemFechaRegistro(fechaActual);
                    siiPersonalEmpresaSoc1.setSiiPersona3(resultadoSocio4);
                    SiiTipoPersonal siiTipoPersonalSoc1 = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_4.getId());
                    siiPersonalEmpresaSoc1.setSiiTipoPersonal(siiTipoPersonalSoc1);
                    siiPersonalEmpresaSoc1.setPemActivo("S");
                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaSoc1);
                }
            }

            if (socio5WSVO != null) {
                if (socio5WSVO.numIdentificacion != null && !socio5WSVO.numIdentificacion.equals("") &&
                    socio5WSVO.tipoIdentificacion > 0) {
                    SiiPersona resultadoSocio5 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(socio5WSVO.tipoIdentificacion), socio5WSVO.numIdentificacion);
                    
                    if (resultadoSocio5 == null) {
                        resultadoSocio5 = copiarPersonaWsVoASiiPersona(socio5WSVO, new SiiPersona());
                        personaDao.insertarPersona(resultadoSocio5);
                    } else {
                        resultadoSocio5.setPerPrimerNombre(socio1WSVO.primerNombre);
                        resultadoSocio5.setPerPrimerApellido(socio1WSVO.primerApellido);
                        resultadoSocio5.setPerSegundoNombre(socio1WSVO.segundoNombre);
                        resultadoSocio5.setPerSegundoApellido(socio1WSVO.segundoApellido);
                        personaDao.actualizarPersona(resultadoSocio5);
                    }

                    // se inserta en personal - empresa
                    SiiPersonalEmpresa siiPersonalEmpresaSoc1 = new SiiPersonalEmpresa();
                    siiPersonalEmpresaSoc1.setSiiPersona(siiPersonaOperador);
                    siiPersonalEmpresaSoc1.setPemFechaRegistro(fechaActual);
                    siiPersonalEmpresaSoc1.setSiiPersona3(resultadoSocio5);
                    SiiTipoPersonal siiTipoPersonalSoc1 = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_5.getId());
                    siiPersonalEmpresaSoc1.setSiiTipoPersonal(siiTipoPersonalSoc1);
                    siiPersonalEmpresaSoc1.setPemActivo("S");
                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaSoc1);
                }
            }

            // CONTADOR
            SiiPersona siiContador = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(contadorWSVO.tipoIdentificacion), contadorWSVO.numIdentificacion);
            
            if (siiContador == null) {
                siiContador = copiarPersonaWsVoASiiPersona(contadorWSVO, new SiiPersona());
                personaDao.insertarPersona(siiContador);
            } else {
                siiContador = copiarPersonaWsVoASiiPersona(contadorWSVO, siiContador);
                personaDao.actualizarPersona(siiContador);
            }

            // se inserta en personal - empresa
            SiiPersonalEmpresa siiPersonalEmpresaNew = new SiiPersonalEmpresa();
            siiPersonalEmpresaNew.setSiiPersona(siiPersonaOperador);
            siiPersonalEmpresaNew.setPemFechaRegistro(fechaActual);
            siiPersonalEmpresaNew.setSiiPersona3(siiContador);
            SiiTipoPersonal siiTipoPersonalRev = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.CONTADOR.getId());
            siiPersonalEmpresaNew.setSiiTipoPersonal(siiTipoPersonalRev);
            siiPersonalEmpresaNew.setPemActivo("S");
            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNew);


            //Gestion Documental
            SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
            siiExpedienteDocumento.setEdoFecha(calendar.getTime());
            siiExpedienteDocumento.setEdoCodigo(solicitudAutorizacionWSVO.numeroSiito);
            siiExpedienteDocumento = expedienteDocumDao.insertarExpedienteDocum(siiExpedienteDocumento);
            boolean existeTarjProContador = false;
            //boolean existeContador = false;
            for(ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo){
                //Creamos el expediente radicado y lo asociamos con el expediente
                SiiExpedienteRadicado siiExpedienteRadicado = new SiiExpedienteRadicado();
                siiExpedienteRadicado.setExrCodigo(expedienteRadicadoWsVo.codigoExpedienteRadicado);
                siiExpedienteRadicado.setSiiExpedienteDocum(siiExpedienteDocumento);
                siiExpedienteRadicado.setExrFecha(new Date());
                siiExpedienteRadicado = expedienteRadicadoDao.insertarExpedienteRadicado(siiExpedienteRadicado);
                
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null && expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                //Documentos Radicados
                    for (DocumentoRadicadoWSVO radicadoWSVO : expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo) {
                        SiiDocumentoRadicado siiDocumentoRadicado = new SiiDocumentoRadicado();
                        siiDocumentoRadicado.setDraFecha(radicadoWSVO.draFecha);
                        siiDocumentoRadicado.setDraCodigo(radicadoWSVO.draCodigo);
                        siiDocumentoRadicado.setSiiExpedienteRadicado(siiExpedienteRadicado);
                        
                        boolean esContador = false;
                        if(radicadoWSVO.cargo != null){
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(radicadoWSVO.cargo);
                            if(siiTipoPersonal == null){
                                throw new ExcepcionAplicacion("No se encontró el cargo con identificador " + radicadoWSVO.cargo);
                            }
                            siiDocumentoRadicado.setSiiTipoPersonal(siiTipoPersonal);
                            //Verificamos si el tipo de personal es Contador
                            esContador = siiTipoPersonal.getTpeCodigo() == EnumTipoPersonal.CONTADOR.getId();
                        }
                        
                        //Tipo radicado
                        if(radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0){
                            throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                        }
                        SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                        if (siiTipoDocRadicado == null) {
                            throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " + siiDocumentoRadicado.getDraCodigo());
                        }
                        siiDocumentoRadicado.setSiiTipoDocRadicado(siiTipoDocRadicado);
                        //Verificamos si el tipo de documento es tarjeta profesional
                        if(esContador && siiTipoDocRadicado.getTdrCodigo() == EnumTipoDocRadicado.TARJETA_PROFESIONAL.getId()){
                            existeTarjProContador = true;
                            //existeContador = true;
                        }
        
                        /*
                         * Si el documento radicado tiene un numero de identificacion asociado entonces vamos a buscar esa persona
                         * en la base de datos de siicol para poder hacer la asociacion con el documento radicado al momento de registrarlo.
                         */
                        if(radicadoWSVO.perNumIdentificacion == null || radicadoWSVO.perNumIdentificacion.equals("")){
                            throw new ExcepcionAplicacion("Falta el número de identificación de la persona del documento " + siiDocumentoRadicado.getDraCodigo());
                        }
                        
                        if(radicadoWSVO.perTipoIdentificacion == null || radicadoWSVO.perTipoIdentificacion <= 0){
                            throw new ExcepcionAplicacion("Falta el tipo de identificación de la persona del documento " + siiDocumentoRadicado.getDraCodigo());
                        }
                        
                        SiiPersona siiPersonaRadicado = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(radicadoWSVO.perTipoIdentificacion, radicadoWSVO.perNumIdentificacion);
                        if (siiPersonaRadicado == null) {
                            throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " + radicadoWSVO.perNumIdentificacion);
                        }
                        siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);
                        
                        documentoRadicadoDao.insertarSiiDocumentoRadicado(siiDocumentoRadicado);
                    }
                }
            }
            
            //Debe existir la tarjeta profesional del contador
            if(!existeTarjProContador){
                throw new ExcepcionAplicacion("La tarjeta profesional del contador es requerida");
            }

            // Se inserta la solicitud de autorizacion
            EstadoSolicAutorizVO estadoSolicAutorizVo = new EstadoSolicAutorizVO();
            estadoSolicAutorizVo.setEsaCodigo(EnumEstadoSolicitudAutoriza.SOLIC_ESTADO_REVISADO.getId());
            solicitudVO.setEstadoSolicAutoriz(estadoSolicAutorizVo);
            SiiSolicitudAutoriza siiSolicitud = conversionVoEntidad.convertir(solicitudVO);
            siiSolicitud.setSiiExpedienteDocum(siiExpedienteDocumento);
            siiSolicitud = solicitudAutorizaDao.insertarSiiSolicitudAutoriza(siiSolicitud);

            resultado = siiSolicitud.getSauCodigo() + " " + solicitudAutorizacionWSVO.codigoMovimiento + " Proceso Exitoso";
            
        } catch (ExcepcionDAO eda) {
            eda.printStackTrace();
            throw eda;
        } catch (ExcepcionAplicacion ea) {
            throw ea;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion(e.getMessage());
        }
        return resultado;
    }

    /**
     * @author Modifica Giovanni
     * Por Gatopardo:
     * Método usado por webservice para consultar la información del operador y sus detalles
     */
    public DetalleOperadorWSVO validarOperadorPorNit(String pNit) throws ExcepcionDAO {

        DetalleOperadorWSVO operadorRetornoWs = null;
        List<SiiOperador> listaOperadores = operadorDao.buscarOperadorPorNit(pNit);

        if (listaOperadores != null && listaOperadores.size() > 0) {

            SiiPersona empresa = listaOperadores.get(0).getSiiPersona();
            PersonaVO personaVoEmpresa = new PersonaVO(empresa);
            operadorRetornoWs = new DetalleOperadorWSVO();
            ConversionVOWS conversionVoWs = new ConversionVOWS();
            List<DocumentoRadicadoWSVO> listaDocumentoRadicadoWSVO = new ArrayList<DocumentoRadicadoWSVO>();

            operadorRetornoWs.operador = conversionVoWs.convertirAOperadorWs(personaVoEmpresa);

            /*
            * Documentos radicados para la empresa
            */
            List<SiiDocumentoRadicado> listaDocumentosRadicadosOpe = null;
            listaDocumentosRadicadosOpe = documentoRadicadoDao.buscarUltimosDocumentoRadicadosPorNumIdentificacion(empresa.getPerNumIdentificacion());

            /*
             * Si trae algun documento radicado para esa persona entonces lo adjuntamos a la lista de radicados que vamos a devolver
             * para la validacion del operador.
             */
            if (listaDocumentosRadicadosOpe != null && listaDocumentosRadicadosOpe.size() > 0) {

                /*
                * Ya tenemos la lista de los documentos radicados para este numero de identificacion, en esta lista puede venir el mismo tipo
                * de documento varias veces, por lo tanto debemos sacar solo una vez este documento radicado, el cual debe ser el que tenga la
                * fecha mas reciente a la actual, como la lista viene del DAO ordenada de forma ascendente entonces el primer registro que nos
                * trae es el ultimo registrado, lo agregamos a la lista y verificamos antes de agregar el siguiente que no exista, por lo tanto
                * cumpliremos con la condicion de traer el ultimo documento radicado de ese tipo de documento.
                */
                for (SiiDocumentoRadicado siiDocumentoRadicadoBD : listaDocumentosRadicadosOpe) {

                    boolean yaExiste = false;
                    for (DocumentoRadicadoWSVO documentoRadicadoGuardadoWSVO : listaDocumentoRadicadoWSVO) {

                        if (documentoRadicadoGuardadoWSVO.codigoTipoDocRadicado == siiDocumentoRadicadoBD.getSiiTipoDocRadicado().getTdrCodigo() &&
                            documentoRadicadoGuardadoWSVO.perNumIdentificacion.equals(siiDocumentoRadicadoBD.getSiiPersona().getPerNumIdentificacion()) &&
                            documentoRadicadoGuardadoWSVO.perTipoIdentificacion.equals(siiDocumentoRadicadoBD.getSiiPersona().getSiiTipoIdentificacion1().getTidCodigo())) {
                            yaExiste = true;
                            break;
                        }

                    }

                    if (!yaExiste) {
                        DocumentoRadicadoWSVO documentoRadicadoWSVO = new DocumentoRadicadoWSVO();
                        documentoRadicadoWSVO.draCodigo = siiDocumentoRadicadoBD.getDraCodigo();
                        documentoRadicadoWSVO.draFecha = siiDocumentoRadicadoBD.getDraFecha();
                        documentoRadicadoWSVO.codigoTipoDocRadicado = siiDocumentoRadicadoBD.getSiiTipoDocRadicado().getTdrCodigo();
                        documentoRadicadoWSVO.perNumIdentificacion = siiDocumentoRadicadoBD.getSiiPersona().getPerNumIdentificacion();
                        documentoRadicadoWSVO.perTipoIdentificacion = siiDocumentoRadicadoBD.getSiiPersona().getSiiTipoIdentificacion1().getTidCodigo();
                        if(siiDocumentoRadicadoBD.getSiiTipoPersonal() != null){
                            documentoRadicadoWSVO.cargo = siiDocumentoRadicadoBD.getSiiTipoPersonal().getTpeCodigo();
                        }

                        listaDocumentoRadicadoWSVO.add(documentoRadicadoWSVO);
                    }

                }
            }

            if (empresa.getSiiPersona() != null) {
                PersonaVO personaVoRepLegal = new PersonaVO(empresa.getSiiPersona());
                operadorRetornoWs.representanteLegal = conversionVoWs.convertir(personaVoRepLegal);

                /*
                 * Documentos radicados para el representante legal
                 */
                List<SiiDocumentoRadicado> listaDocumentosRadicados = null;
                listaDocumentosRadicados = documentoRadicadoDao.buscarUltimosDocumentoRadicadosPorNumIdentificacionPorIdTipoPersonal(empresa.getSiiPersona().getPerNumIdentificacion(),EnumTipoPersonal.REPRESENTANTE_LEGAL.getId());

                /*
                 * Si trae algun documento radicado para esa persona entonces lo adjuntamos a la lista de radicados que vamos a devolver
                 * para la validacion del operador.
                 */
                if (listaDocumentosRadicados != null && listaDocumentosRadicados.size() > 0) {

                    /*
                    * Ya tenemos la lista de los documentos radicados para este numero de identificacion, en esta lista puede venir el mismo tipo
                    * de documento varias veces, por lo tanto debemos sacar solo una vez este documento radicado, el cual debe ser el que tenga la
                    * fecha mas reciente a la actual, como la lista viene del DAO ordenada de forma ascendente entonces el primer registro que nos
                    * trae es el ultimo registrado, lo agregamos a la lista y verificamos antes de agregar el siguiente que no exista, por lo tanto
                    * cumpliremos con la condicion de traer el ultimo documento radicado de ese tipo de documento.
                    */
                    for (SiiDocumentoRadicado siiDocumentoRadicadoBD : listaDocumentosRadicados) {

                        boolean yaExiste = false;
                        for (DocumentoRadicadoWSVO documentoRadicadoGuardadoWSVO : listaDocumentoRadicadoWSVO) {

                            if(siiDocumentoRadicadoBD.getSiiTipoPersonal() == null) {
                                yaExiste = true;
                                break;
                            }
                            if (documentoRadicadoGuardadoWSVO.codigoTipoDocRadicado == siiDocumentoRadicadoBD.getSiiTipoDocRadicado().getTdrCodigo() &&
                                documentoRadicadoGuardadoWSVO.perNumIdentificacion.equals(siiDocumentoRadicadoBD.getSiiPersona().getPerNumIdentificacion()) &&
                                documentoRadicadoGuardadoWSVO.perTipoIdentificacion.equals(siiDocumentoRadicadoBD.getSiiPersona().getSiiTipoIdentificacion1().getTidCodigo()) &&
                                documentoRadicadoGuardadoWSVO.cargo == siiDocumentoRadicadoBD.getSiiTipoPersonal().getTpeCodigo()) {

                                yaExiste = true;
                                break;
                            }

                        }

                        if (!yaExiste) {
                            DocumentoRadicadoWSVO documentoRadicadoWSVO = new DocumentoRadicadoWSVO();
                            documentoRadicadoWSVO.draCodigo = siiDocumentoRadicadoBD.getDraCodigo();
                            documentoRadicadoWSVO.draFecha = siiDocumentoRadicadoBD.getDraFecha();
                            documentoRadicadoWSVO.codigoTipoDocRadicado = siiDocumentoRadicadoBD.getSiiTipoDocRadicado().getTdrCodigo();
                            documentoRadicadoWSVO.perNumIdentificacion = siiDocumentoRadicadoBD.getSiiPersona().getPerNumIdentificacion();
                            documentoRadicadoWSVO.perTipoIdentificacion = siiDocumentoRadicadoBD.getSiiPersona().getSiiTipoIdentificacion1().getTidCodigo();
                            if(siiDocumentoRadicadoBD.getSiiTipoPersonal() != null){
                                documentoRadicadoWSVO.cargo = siiDocumentoRadicadoBD.getSiiTipoPersonal().getTpeCodigo();
                            }
                            
                            listaDocumentoRadicadoWSVO.add(documentoRadicadoWSVO);
                        }
                    }
                }
            }
            if (empresa.getSiiDetalleFinancList() != null && empresa.getSiiDetalleFinancList().size() > 0) {
                DetalleFinancVO detalleFinancieroVo = new DetalleFinancVO(empresa.getSiiDetalleFinancList().get(0));
                operadorRetornoWs.detalleFinanciero = conversionVoWs.convertir(detalleFinancieroVo);
            }

            List<SiiPersonalEmpresa> listaPersonalEmpresa = personalEmpresaDao.buscarPersonalEmpresaPorIdPersona(empresa.getPerCodigo());

            for (SiiPersonalEmpresa unPersonalEmpresa : listaPersonalEmpresa) {
                PersonaVO personaVoPersonal = new PersonaVO(unPersonalEmpresa.getSiiPersona3());

                /*
                 * Por cada personal de la empresa haces la busqueda de sus documentos radicados
                 *
                 */
                List<SiiDocumentoRadicado> listaDocumentosRadicados = null;
                listaDocumentosRadicados = documentoRadicadoDao.buscarUltimosDocumentoRadicadosPorNumIdentificacionPorIdTipoPersonal(unPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion(), unPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo());

                /*
                 * Si trae algun documento radicado para esa persona entonces lo adjuntamos a la lista de radicados que vamos a devolver
                 * para la validacion del operador.
                 */
                if (listaDocumentosRadicados != null && listaDocumentosRadicados.size() > 0) {

                    /*
                    * Ya tenemos la lista de los documentos radicados para este numero de identificacion, en esta lista puede venir el mismo tipo
                    * de documento varias veces, por lo tanto debemos sacar solo una vez este documento radicado, el cual debe ser el que tenga la
                    * fecha mas reciente a la actual, como la lista viene del DAO ordenada de forma ascendente entonces el primer registro que nos
                    * trae es el ultimo registrado, lo agregamos a la lista y verificamos antes de agregar el siguiente que no exista, por lo tanto
                    * cumpliremos con la condicion de traer el ultimo documento radicado de ese tipo de documento.
                    */
                    for (SiiDocumentoRadicado siiDocumentoRadicadoBD : listaDocumentosRadicados) {

                        boolean yaExiste = false;
                        for (DocumentoRadicadoWSVO documentoRadicadoGuardadoWSVO : listaDocumentoRadicadoWSVO) {

                            if(siiDocumentoRadicadoBD.getSiiTipoPersonal() == null) {
                                yaExiste = true;
                                break;
                            }
                            if (documentoRadicadoGuardadoWSVO.codigoTipoDocRadicado == siiDocumentoRadicadoBD.getSiiTipoDocRadicado().getTdrCodigo() &&
                                documentoRadicadoGuardadoWSVO.perNumIdentificacion.equals(siiDocumentoRadicadoBD.getSiiPersona().getPerNumIdentificacion()) &&
                                documentoRadicadoGuardadoWSVO.perTipoIdentificacion.equals(siiDocumentoRadicadoBD.getSiiPersona().getSiiTipoIdentificacion1().getTidCodigo()) &&
                                documentoRadicadoGuardadoWSVO.cargo == siiDocumentoRadicadoBD.getSiiTipoPersonal().getTpeCodigo()) {

                                yaExiste = true;
                                break;
                            }
                        }

                        if (!yaExiste) {
                            DocumentoRadicadoWSVO documentoRadicadoWSVO = new DocumentoRadicadoWSVO();
                            documentoRadicadoWSVO.draCodigo = siiDocumentoRadicadoBD.getDraCodigo();
                            documentoRadicadoWSVO.draFecha = siiDocumentoRadicadoBD.getDraFecha();
                            documentoRadicadoWSVO.codigoTipoDocRadicado = siiDocumentoRadicadoBD.getSiiTipoDocRadicado().getTdrCodigo();
                            documentoRadicadoWSVO.perNumIdentificacion = siiDocumentoRadicadoBD.getSiiPersona().getPerNumIdentificacion();
                            documentoRadicadoWSVO.perTipoIdentificacion = siiDocumentoRadicadoBD.getSiiPersona().getSiiTipoIdentificacion1().getTidCodigo();
                            if(siiDocumentoRadicadoBD.getSiiTipoPersonal() != null){
                                documentoRadicadoWSVO.cargo = siiDocumentoRadicadoBD.getSiiTipoPersonal().getTpeCodigo();
                            }
                            
                            listaDocumentoRadicadoWSVO.add(documentoRadicadoWSVO);
                        }
                    }
                }

                switch (unPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().intValue()) {

                    /* 1       REVISOR FISCAL
                    2       CONTACTO EMPRESA
                    3       APODERADO
                    4       SOCIO MAYORITARIO
                    5       CONTADOR
                    6       REPRESENTANTE LEGAL SUPLENTE
                    7       REVISOR FISCAL SUPLENTE
*/
                case 1:
                    operadorRetornoWs.revisorFiscal = conversionVoWs.convertir(personaVoPersonal);
                    break;
                case 2:
                    operadorRetornoWs.contactoEmpresa = conversionVoWs.convertir(personaVoPersonal);
                    break;
                case 3:
                    operadorRetornoWs.apoderado = conversionVoWs.convertir(personaVoPersonal);
                    break;
                case 4:
                    break;
                case 5:
                    operadorRetornoWs.contador = conversionVoWs.convertir(personaVoPersonal);
                    break;
                case 6:

                    operadorRetornoWs.socio1 = conversionVoWs.convertir(personaVoPersonal);
                    break;

                case 7:
                    operadorRetornoWs.socio2 = conversionVoWs.convertir(personaVoPersonal);
                    break;

                case 8:
                    operadorRetornoWs.socio3 = conversionVoWs.convertir(personaVoPersonal);
                    break;

                case 9:
                    operadorRetornoWs.socio4 = conversionVoWs.convertir(personaVoPersonal);
                    break;

                case 10:
                    operadorRetornoWs.socio5 = conversionVoWs.convertir(personaVoPersonal);
                    break;


                case 11:
                    operadorRetornoWs.representanteLegalSuplente = conversionVoWs.convertir(personaVoPersonal);
                    break;
                case 12:
                    operadorRetornoWs.revisorFiscalSuplente = conversionVoWs.convertir(personaVoPersonal);
                    break;
                }
            }
            
            /*
              * Una vez tenemos toda la lista de documentos radicados para esa empresa y su personal procedemos a setearla
              * al objeto que da respuesta al web services
              */
            operadorRetornoWs.listaDocumentosRadicadosWSVO = listaDocumentoRadicadoWSVO;

            /*
             * Consultamos los contratos del operador
             */
            List<SiiContrato> listaContratos = new ArrayList<SiiContrato>();
            listaContratos =
                contratoDao.buscarContratosVigentesPorNit(listaOperadores.get(0).getSiiPersona().getPerNumIdentificacion());
            
            List<ContratoInformacionWSVO> listaContratosWSVO = null;
            if (listaContratos != null && listaContratos.size() > 0) {
                listaContratosWSVO = new ArrayList<ContratoInformacionWSVO>();

                for (SiiContrato siiContrato : listaContratos) {
                    BigDecimal calculovalorContrato ;
                    calculovalorContrato = adminContrato.calculoValorXEjecutarContratoConc(siiContrato.getConCodigo());
                    ContratoInformacionWSVO contratoWSVO = new ContratoInformacionWSVO();
                    contratoWSVO.conCodigo = siiContrato.getConCodigo();
                    contratoWSVO.conDescripcion = siiContrato.getConDescripcion();
                    contratoWSVO.conExpedienteUrl = siiContrato.getConExpedienteUrl();
                    contratoWSVO.conFecha = siiContrato.getConFecha();
                    contratoWSVO.conFechaCitFirOpe = siiContrato.getConFechaCitFirOpe();
                    contratoWSVO.conFechaFin = siiContrato.getConFechaFinDefin(); //Modificado para incidencia 13808
                    contratoWSVO.conFechaFirColj = siiContrato.getConFechaFirColj();
                    contratoWSVO.conFechaFirOpe = siiContrato.getConFechaFirOpe();
                    contratoWSVO.conFechaIni = siiContrato.getConFechaIni();
                    contratoWSVO.conFechaPrgFirOpe = siiContrato.getConFechaPrgFirOpe();
                    contratoWSVO.conFechaRegistro = siiContrato.getConFechaRegistro();
                    contratoWSVO.conFechaRevAbog = siiContrato.getConFechaRevAbog();
                    contratoWSVO.conNumero = siiContrato.getConNumero();
                    contratoWSVO.conVigente = siiContrato.getConVigente();
                    contratoWSVO.conConsecutivo = siiContrato.getConConsecutivo();
                    contratoWSVO.conTextoValFinan = siiContrato.getConTextoValFinan();
                    contratoWSVO.conTextoValGct = siiContrato.getConTextoValGct();
                    contratoWSVO.conPermiso = siiContrato.getConPermiso();      
                    if (calculovalorContrato != null){
                        contratoWSVO.valorContrato = calculovalorContrato;
                    }else {
                        siiContrato.setConValorEstimado(new BigDecimal("0.00"));                        
                    }
                    listaContratosWSVO.add(contratoWSVO);
                }
                operadorRetornoWs.listaContratosWSVO = listaContratosWSVO;
            }
        }

        return operadorRetornoWs;
    }

    /**
     *Metodo encargado de buscar los impedimentos que tiene un operador buscandolo por su numero de nit y por contratos
     * @Author Mario Bucheli
     * @param nit
     * @return ImpedimentosWSVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public ImpedimentosWSVO buscarImpedimentosOpeContra(String nit) throws ExcepcionDAO, ExcepcionAplicacion {
        
        ImpedimentosWSVO impedimentos = new ImpedimentosWSVO();
        impedimentos.impedimentosNIT = new ArrayList<ImpedimentoWSVO>();
        impedimentos.impedimentosContrato = new ArrayList<ImpedimContratoWSVO>();
        
        /*
        * Solicitudes de autorizacion en proceso las cuales esten en los siguientes estados:
        * APROBADO - OFICIO LIQUIDACION - RESOLUCION AUTORIZACION - CONTRATO PERFECCIONADO
        * OTROSI PERFECCIONADO
        */
        boolean operadorConSolicitudEnProceso = false;
        List<SiiSolicitudAutoriza> listaSolicitudes = solicitudAutorizaDao.buscarSolicitudAutorizacionPorNit(nit);
        
        ImpedimentoWSVO impedimentoWsVo = new ImpedimentoWSVO();
        impedimentoWsVo.listaEstadoSolicitudes = new ArrayList<EstadoSolicAutorizWSVO>();        
        
        /*
         * Consultamos los contratos del operador
         */
        List<SiiContrato> listaContratos = new ArrayList<SiiContrato>();
        listaContratos = contratoDao.buscarContratosVigentesPorNit(nit);
        
        if (listaSolicitudes != null && listaSolicitudes.size() > 0) {
            impedimentoWsVo.codigo = 4;
            impedimentoWsVo.descripcion = "Operador con Solicitud en Proceso";
            impedimentoWsVo.tieneImpedimento = "S";            
            // Agregar estado solicitudes
            for (SiiSolicitudAutoriza unaSolicitudAutoriza : listaSolicitudes) {                
                EstadoSolicAutorizWSVO estadoSol = new EstadoSolicAutorizWSVO();
                estadoSol.esaCodigo = unaSolicitudAutoriza.getSiiEstadoSolicAutoriz().getEsaCodigo();
                //estadoSol.esaNombre = unaSolicitudAutoriza.getSiiEstadoSolicAutoriz().getEsaNombre();
                estadoSol.esaNombre = " EN TRAMITE ";
                estadoSol.tipoSolic = unaSolicitudAutoriza.getSiiTipoSolicAutoriza().getTsaNombre();
                List<SiiNovedad> listaNovedad = novedadDAO.buscarNovedadPorSolicitudAutotiza(unaSolicitudAutoriza.getSauCodigo());
                for (SiiNovedad siiNovedad:listaNovedad){
                    if (siiNovedad.getSiiContrato() != null){
                        estadoSol.contrato = siiNovedad.getSiiContrato().getConNumero();
                    }
                     
                }
                    impedimentoWsVo.listaEstadoSolicitudes.add(estadoSol);
                }
            /*
                if( !unaSolicitudAutoriza.getSiiNovedadList().isEmpty() )
                        if( unaSolicitudAutoriza.getSiiNovedadList().get(0).getSiiContrato() != null )
                            estadoSol.contrato = unaSolicitudAutoriza.getSiiNovedadList().get(0).getSiiContrato().getConNumero();                
                            
                            impedimentoWsVo.listaEstadoSolicitudes.add(estadoSol);                             
                }
            */
            
            impedimentos.impedimentosNIT.add(impedimentoWsVo);
        }else {
                impedimentoWsVo.codigo = 4;
                impedimentoWsVo.descripcion = "Operador con Solicitud en Proceso";
                impedimentoWsVo.tieneImpedimento = "N";
                impedimentos.impedimentosNIT.add(impedimentoWsVo);
        }
        
        // Agregar impedimentos por contrato
        
        
        Date fecha = Utilidades.truncDate(new Date()) ;
        
  
        for(SiiContrato contrato: listaContratos){
            
            boolean contratoMoraCartera = false;
            
            List<EstadoCuentaVO> estados = this.estadoDeCuentaPorContrato(contrato.getConNumero(), fecha);
            if (estados!=null) {
                Iterator<EstadoCuentaVO> it = estados.iterator();
                while (it.hasNext() && !contratoMoraCartera) {
                    EstadoCuentaVO estado = it.next();
                    if (!estado.getFecha_vencimiento().after(fecha)) {
                        BigDecimal saldo = estado.getSaldo().setScale(0,BigDecimal.ROUND_DOWN);
                        BigDecimal intereses = estado.getSaldo_interes().setScale(0,BigDecimal.ROUND_DOWN);
                        if ( saldo.add(intereses).compareTo(BigDecimal.ZERO) > 0) {
                            System.out.println("Fecha Vencimiento: "+estado.getFecha_vencimiento()+" saldo:  "+saldo+" intereses: "+intereses);
                            contratoMoraCartera = true;
                        }
                    }
                }
            }
            
            if (contratoMoraCartera) {
                ImpedimContratoWSVO impedContrWsVo = new ImpedimContratoWSVO();
                impedContrWsVo.codigo = 1;
                impedContrWsVo.descripcion = "Estado de Cartera";
                impedContrWsVo.tieneImpedimento = "S";
                impedContrWsVo.contrato = contrato.getConNumero();
                impedimentos.impedimentosContrato.add(impedContrWsVo);
            } else {
                ImpedimContratoWSVO impedContrWsVo = new ImpedimContratoWSVO();
                impedContrWsVo.codigo = 1;
                impedContrWsVo.descripcion = "Estado de Cartera";
                impedContrWsVo.tieneImpedimento = "N";
                impedContrWsVo.contrato = contrato.getConNumero();
                impedimentos.impedimentosContrato.add(impedContrWsVo);
            }
        
            /*
            * Consultamos al contrato por las polizas vigentes
            */
            boolean contratoPolizaVencida = false;
            SiiPolizaContrat siiPolizaContrat = new SiiPolizaContrat();
            siiPolizaContrat = polizaContratoDao.consultarPolizaXContrato(contrato.getConNumero(), EnumEstadoPolizaContrato.APROBADO.getId());

            contratoPolizaVencida = garantiaPolizaDao.verificarGarantiaPolizaVencida(siiPolizaContrat.getPccCodigo());
            if (contratoPolizaVencida) {
                ImpedimContratoWSVO impedContrWsVo = new ImpedimContratoWSVO();
                impedContrWsVo.codigo = 2;
                impedContrWsVo.descripcion = "Pólizas Vigentes";
                impedContrWsVo.tieneImpedimento = "S";
                impedContrWsVo.contrato = contrato.getConNumero();
                impedimentos.impedimentosContrato.add(impedContrWsVo);
            } else {
                ImpedimContratoWSVO impedContrWsVo = new ImpedimContratoWSVO();
                impedContrWsVo.codigo = 2;
                impedContrWsVo.descripcion = "Pólizas Vigentes";
                impedContrWsVo.tieneImpedimento = "N";
                impedContrWsVo.contrato = contrato.getConNumero();
                impedimentos.impedimentosContrato.add(impedContrWsVo);
            }
            
            /*
            * Consultamos sanciones por contrato
            */
            
            boolean contratoSancion = sancionDao.haySancionesXContrato(contrato.getConNumero());
            if (contratoSancion) {
                ImpedimContratoWSVO impedContrWsVo = new ImpedimContratoWSVO();
                impedContrWsVo.codigo = 3;
                impedContrWsVo.descripcion = "Sanciones";
                impedContrWsVo.tieneImpedimento = "S";
                impedContrWsVo.contrato = contrato.getConNumero();
                impedimentos.impedimentosContrato.add(impedContrWsVo);
            } else {
                ImpedimContratoWSVO impedContrWsVo = new ImpedimContratoWSVO();
                impedContrWsVo.codigo = 3;
                impedContrWsVo.descripcion = "Sanciones";
                impedContrWsVo.tieneImpedimento = "N";
                impedContrWsVo.contrato = contrato.getConNumero();
                impedimentos.impedimentosContrato.add(impedContrWsVo);
            }
            
        }

        return impedimentos;
    }
    
    public List<EstadoCuentaVO> estadoDeCuentaPorContrato(String contrato, Date unaFechaCorte) {
        List<EstadoCuentaVO> estadoCuentaVOs = new ArrayList<EstadoCuentaVO>();

        if (unaFechaCorte != null) {
            estadoCuentaVOs = consultarEstadoCuenta(contrato, -1, unaFechaCorte, false);
        } else {
            estadoCuentaVOs = consultarEstadoCuenta(contrato, -1, new Date(), false);
        }
        return estadoCuentaVOs;
    }
    
    
    public List<EstadoCuentaVO> consultarEstadoCuenta(String contrato, Integer concepto, Date unaFechaCorte,
                                                             boolean isOrderTipo) {
        List<EstadoCuentaVO> listaFiltradaRetorno = new ArrayList();
        try {
            System.out.println("Consultando estado de cuenta " + (contrato.equals("") ? "" : ("contrato " + contrato)));
            List<EstadoCuentaVO> unaListaEstadoCuentaVo = adminContrato.estadoCuenta(contrato, concepto, unaFechaCorte, isOrderTipo);
            listaFiltradaRetorno = procesarLista(unaListaEstadoCuentaVo, unaFechaCorte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFiltradaRetorno;
    }
    
    
    public static List<EstadoCuentaVO> procesarLista(List<EstadoCuentaVO> listaEntrada, Date unaFechaCorte) {
        List<EstadoCuentaVO> listaFiltradaRetorno = new ArrayList<EstadoCuentaVO>();
        List<EstadoCuentaVO> copiaListaParaSuma = new ArrayList();
        for(EstadoCuentaVO unEstadoCopia : listaEntrada){
            //Si no hay contrato, es multa o sanción y debe tener resolución
            if(unEstadoCopia.getContrato() == null){
                unEstadoCopia.setContrato(unEstadoCopia.getResolucion());
            }
            copiaListaParaSuma.add(unEstadoCopia);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String strUnaFechaCorte = formatter.format(unaFechaCorte);
        long elapsedTimeMark = 0;
        Long lUnaFechaCorte = new Long(strUnaFechaCorte);
        try {
            List<EstadoCuentaVO> unaListaEstadoCuentaVo = listaEntrada;
            EstadoCuentaVO estadoOld = new EstadoCuentaVO();
            System.out.println("Empezando analisis");
            long startTimeSetMark = System.currentTimeMillis();
            for (int i = 0; i < unaListaEstadoCuentaVo.size(); i++) {
                EstadoCuentaVO estadoActual = unaListaEstadoCuentaVo.get(i);
                if (i != 0) {
                    estadoOld = unaListaEstadoCuentaVo.get(i - 1);
                }
                //Pone ceros a las cuotas operador repetidas
                if (estadoOld != null) {
                    if (estadoActual.getContrato().equals(estadoOld.getContrato()) &&
                        estadoActual.getCuota().equals(estadoOld.getCuota()) &&
                        estadoActual.getDescripcionConcepto().equals(estadoOld.getDescripcionConcepto()) &&
                        estadoActual.getRazonSocial().equals(estadoOld.getRazonSocial()) )  {
                        estadoActual.setMonto_obligacion(new BigDecimal(-9999999999999999D));
                    }
                }

                String conNumero = estadoActual.getContrato();
                BigDecimal numCuota = estadoActual.getCuota();
                String razonSocial = estadoActual.getRazonSocial();
                BigDecimal numConcepto = null;

                numConcepto = estadoActual.getCodigoConcepto();

                //Hace la suma del total pagado
                BigDecimal totalPagado = BigDecimal.ZERO;

                boolean barriendoIguales = false;
                List<EstadoCuentaVO> listaEstadosParaRetirar = new ArrayList<EstadoCuentaVO>();

                
                for (EstadoCuentaVO unEstado : copiaListaParaSuma) {
                    if (unEstado.getContrato().equals(conNumero) && 
                            unEstado.getCuota().equals(numCuota) &&
                            unEstado.getCodigoConcepto().equals(numConcepto) &&
                            unEstado.getRazonSocial().equals(razonSocial)) {
                        totalPagado = totalPagado.add(unEstado.getMonto_pago());
                        listaEstadosParaRetirar.add(unEstado);
                        barriendoIguales = true;
                    } else if (barriendoIguales) { //Ya terminó el barrido y pasó por acá
                        break;
                    }
                }
                //Retiramos de la copia de la lista los elementos ya procesados
                for(EstadoCuentaVO unEstadoRetirar : listaEstadosParaRetirar){
                    copiaListaParaSuma.remove(unEstadoRetirar);
                }

                estadoActual.setTotal_pagado(totalPagado);

                if (estadoActual.getTotalTodosInteres() == null) {
                    estadoActual.setTotalTodosInteres(BigDecimal.ZERO);
                }
                if (estadoActual.getPagado_interes() == null) {
                    estadoActual.setPagado_interes(BigDecimal.ZERO);
                }

                estadoActual.setTotalTodosSaldoInteres(estadoActual.getTotalTodosInteres().subtract(estadoActual.getPagado_interes()));
                if (estadoActual.getTotalTodosSaldoInteres().doubleValue() < 0D && lUnaFechaCorte > 20131231235959L) {
                    estadoActual.setRecaudoInteresPorClasificar(BigDecimal.ZERO);
                    estadoActual.setRecaudoInteresPorClasificar(estadoActual.getRecaudoInteresPorClasificar().subtract(estadoActual.getTotalTodosSaldoInteres()));
                    estadoActual.setTotalTodosSaldoInteres(BigDecimal.ZERO);
                }

                estadoActual.setSaldo(estadoActual.getMonto_obligacion().subtract(totalPagado));
                if (estadoActual.getSaldo().doubleValue() < 0D && lUnaFechaCorte > 20131231235959L) {
                    estadoActual.setRecaudoPorCalsificar(BigDecimal.ZERO);
                    estadoActual.setRecaudoPorCalsificar(estadoActual.getRecaudoPorCalsificar().subtract(estadoActual.getSaldo()));
                    estadoActual.setSaldo(BigDecimal.ZERO);
                }
                listaFiltradaRetorno.add(estadoActual);

            }

            //Quita los saldos repetidos
            for (int i = 0; i < listaFiltradaRetorno.size(); i++) {
                EstadoCuentaVO estadoActual = unaListaEstadoCuentaVo.get(i);
                if (estadoActual.getMonto_obligacion().equals(new BigDecimal(-9999999999999999D))) {
                    estadoActual.setMonto_obligacion(BigDecimal.ZERO);
                    estadoActual.setSaldo(BigDecimal.ZERO);
                    estadoActual.setTotalTodosInteres(BigDecimal.ZERO);
                    estadoActual.setPagado_interes(BigDecimal.ZERO);
                    estadoActual.setTotalTodosSaldoInteres(BigDecimal.ZERO);
                    estadoActual.setRecaudoInteresPorClasificar(BigDecimal.ZERO);
                    estadoActual.setRecaudoPorCalsificar(BigDecimal.ZERO);
                }
            }
            long stopTimeSetMark = System.currentTimeMillis();
            elapsedTimeMark += (stopTimeSetMark - startTimeSetMark);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Tiempo marcacion: " + elapsedTimeMark + " mseg.");
        return listaFiltradaRetorno;
    }
    
    public List<EstadoCuentaVO> estadoCuenta(String contrato, Integer concepto, Date fechaCorte,
                                             boolean isOrderDesc) throws ExcepcionDAO {
        if (fechaCorte == null) {
            fechaCorte = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCorte);
        int vigencia = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1;
        SiiCorteCartera corteCartera = corteCarteraDao.buscarCorteCarteraPorVigenciaPorMes(vigencia, mes);
        List<EstadoCuentaVO> listaEstadoCuentaVo = null;
        if (corteCartera != null) {
            listaEstadoCuentaVo = detalleCorteCarteraDao.estadoCuentaCorte(contrato, concepto, fechaCorte, isOrderDesc);
        } else {
            listaEstadoCuentaVo = contratoDAO.estadoCuenta(contrato, concepto, fechaCorte, isOrderDesc, null);
        }
        return listaEstadoCuentaVo;
    }
    /**
     *Metodo encargado de buscar los impedimentos que tiene un operador buscandolo por su numero de nit
     * @Author David Tafur
     * @param nit
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public List<ImpedimentoWSVO> buscarImpedimentosOperador(String nit) throws ExcepcionDAO, ExcepcionAplicacion {

        List<SiiOperador> listaOperadores = operadorDao.buscarOperadorPorNit(nit);
        /*
        * Lista que almacena todos los impedimentos del operador
        */
        List<ImpedimentoWSVO> listaImpedimentosWsVo = new ArrayList<ImpedimentoWSVO>();
        
        /*
         * Consultamos los contratos del operador
         */
        List<SiiContrato> listaContratos = new ArrayList<SiiContrato>();
        listaContratos =
            contratoDao.buscarContratosVigentesPorNit(nit);


        if (listaContratos != null && listaContratos.size() > 0) {

            for (SiiContrato siiContrato : listaContratos) {}
        }
        
        
        /*
        * En caso de que no se encuentre un operador en la base de datos por ese nit entonces vamos a retornar la lista
        * con los impedimentos en 'N'
        */

        if (listaOperadores == null || listaOperadores.size() == 0) {
            /*    throw new ExcepcionAplicacion("El operador con NIT " + nit + " no se encuentra registrado en el sistema"); */

            ImpedimentoWSVO impedimentoCWsVo = new ImpedimentoWSVO();
            impedimentoCWsVo.codigo = 1;
            impedimentoCWsVo.descripcion = "Estado de Cartera";
            impedimentoCWsVo.tieneImpedimento = "N";
            listaImpedimentosWsVo.add(impedimentoCWsVo);

            ImpedimentoWSVO impedimentoPWsVo = new ImpedimentoWSVO();
            impedimentoPWsVo = new ImpedimentoWSVO();
            impedimentoPWsVo.codigo = 2;
            impedimentoPWsVo.descripcion = "Pólizas Vigentes";
            impedimentoPWsVo.tieneImpedimento = "N";
            listaImpedimentosWsVo.add(impedimentoPWsVo);

            ImpedimentoWSVO impedimentoCcWsVo = new ImpedimentoWSVO();
            impedimentoCcWsVo = new ImpedimentoWSVO();
            impedimentoCcWsVo.codigo = 3;
            impedimentoCcWsVo.descripcion = "Operador en Cobro Coactivo";
            impedimentoCcWsVo.tieneImpedimento = "N";
            listaImpedimentosWsVo.add(impedimentoCcWsVo);

            ImpedimentoWSVO impedimentoSWsVo = new ImpedimentoWSVO();
            impedimentoSWsVo = new ImpedimentoWSVO();
            impedimentoSWsVo.codigo = 4;
            impedimentoSWsVo.descripcion = "Operador con Solicitud en Proceso";
            impedimentoSWsVo.tieneImpedimento = "N";
            listaImpedimentosWsVo.add(impedimentoSWsVo);

            return listaImpedimentosWsVo;
        }

        //Tenemos el operador a la mano
        SiiOperador siiOperador = listaOperadores.get(0);
        /*
        * Consultamos si tiene impedimientos para el estado de cartera por lo tanto consultamos el operador
         * en la tabla cuota operador
        */

        boolean operadorMoraCartera = false;
        operadorMoraCartera = cuotaOperadorDao.operadorEnMora(siiOperador.getOpeCodigo());

        /*
        * Si el operador se encuentra en mora de cartera entonces se agrega el registro con estado impedimento si
        * de lo contrario con no
        */

        if (operadorMoraCartera) {

            ImpedimentoWSVO impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo.codigo = 1;
            impedimentoWsVo.descripcion = "Estado de Cartera";
            impedimentoWsVo.tieneImpedimento = "S";
            listaImpedimentosWsVo.add(impedimentoWsVo);
        } else {

            ImpedimentoWSVO impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo.codigo = 1;
            impedimentoWsVo.descripcion = "Estado de Cartera";
            impedimentoWsVo.tieneImpedimento = "N";
            listaImpedimentosWsVo.add(impedimentoWsVo);
        }

        /*
        * Consultamos al operador por las polizas vigentes
        */
        boolean operadorPolizaVencida = false;
        SiiPolizaContrat siiPolizaContrat = new SiiPolizaContrat();
        siiPolizaContrat = polizaContratoDao.consultarPolizaXOperadorYEstado(nit, EnumEstadoPolizaContrato.APROBADO.getId());

        operadorPolizaVencida = garantiaPolizaDao.verificarGarantiaPolizaVencida(siiPolizaContrat.getPccCodigo());


        if (operadorPolizaVencida) {
            ImpedimentoWSVO impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo.codigo = 2;
            impedimentoWsVo.descripcion = "Pólizas Vigentes";
            impedimentoWsVo.tieneImpedimento = "S";
            listaImpedimentosWsVo.add(impedimentoWsVo);
        } else {
            ImpedimentoWSVO impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo.codigo = 2;
            impedimentoWsVo.descripcion = "Pólizas Vigentes";
            impedimentoWsVo.tieneImpedimento = "N";
            listaImpedimentosWsVo.add(impedimentoWsVo);
        }

        /*
         * Consultamos los cobros coactivos del operador
        */
        boolean operadorEnCobroCoactivo = false;
        /*    operadorEnCobroCoactivo = cuotaOperadorDAO.operadorCobroCoactivo(siiOperador.getOpeCodigo());*/

        if (operadorEnCobroCoactivo) {
            ImpedimentoWSVO impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo.codigo = 3;
            impedimentoWsVo.descripcion = "Operador en Cobro Coactivo";
            impedimentoWsVo.tieneImpedimento = "S";
            listaImpedimentosWsVo.add(impedimentoWsVo);
        } else {
            ImpedimentoWSVO impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo.codigo = 3;
            impedimentoWsVo.descripcion = "Operador en Cobro Coactivo";
            impedimentoWsVo.tieneImpedimento = "N";
            listaImpedimentosWsVo.add(impedimentoWsVo);
        }

        /*
        * Solicitudes de autorizacion en proceso las cuales esten en los siguientes estados:
        * APROBADO - OFICIO LIQUIDACION - RESOLUCION AUTORIZACION - CONTRATO PERFECCIONADO
        * OTROSI PERFECCIONADO
        */

        boolean operadorConSolicitudEnProceso = false;
        List<SiiSolicitudAutoriza> listaSolicitudes = solicitudAutorizaDao.buscarSolicitudAutorizacionPorNit(nit);
        if (listaSolicitudes != null && listaSolicitudes.size() > 0) {
            for (SiiSolicitudAutoriza unaSolicitudAutoriza : listaSolicitudes) {
                if (unaSolicitudAutoriza.getSiiEstadoSolicAutoriz().getEsaCodigo() ==
                    EnumEstadoSolicitudAutoriza.APROBADO.getId() ||
                    unaSolicitudAutoriza.getSiiEstadoSolicAutoriz().getEsaCodigo() ==
                    EnumEstadoSolicitudAutoriza.OFICIO_LIQUIDACION.getId() ||
                    unaSolicitudAutoriza.getSiiEstadoSolicAutoriz().getEsaCodigo() ==
                    EnumEstadoSolicitudAutoriza.RESOLUCION_AUTORIZACION.getId() ||
                    unaSolicitudAutoriza.getSiiEstadoSolicAutoriz().getEsaCodigo() ==
                    EnumEstadoSolicitudAutoriza.CONTRATO_PERFECCIONADO.getId() ||
                    unaSolicitudAutoriza.getSiiEstadoSolicAutoriz().getEsaCodigo() ==
                    EnumEstadoSolicitudAutoriza.OTROSI_PERFECCIONADO.getId()) {
                    operadorConSolicitudEnProceso = true;
                    break;
                }
            }
        }


        if (operadorConSolicitudEnProceso) {
            ImpedimentoWSVO impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo.codigo = 4;
            impedimentoWsVo.descripcion = "Operador con Solicitud en Proceso";
            impedimentoWsVo.tieneImpedimento = "S";
            listaImpedimentosWsVo.add(impedimentoWsVo);
        } else {
            ImpedimentoWSVO impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo = new ImpedimentoWSVO();
            impedimentoWsVo.codigo = 4;
            impedimentoWsVo.descripcion = "Operador con Solicitud en Proceso";
            impedimentoWsVo.tieneImpedimento = "N";
            listaImpedimentosWsVo.add(impedimentoWsVo);
        }


        return listaImpedimentosWsVo;
    }

    /**
     * Metodo encargado de actualizar un operador con la informacion proveniente del cliente del Web Services
     * @author David Tafur
     * @param operadorWSVO
     * @param repLegalWSVO
     * @param revisorFiscalWSVO
     * @param repLegalSuplenteWSVO
     * @param revisorFiscalSuplenteWSVO
     * @param contactoWSVO
     * @param apoderadoWSVO
     * @param socio1WSVO
     * @param socio2WSVO
     * @param socio3WSVO
     * @param socio4WSVO
     * @param socio5WSVO
     * @param contadorWSVO
     * @param solicitudAutorizacionWSVO
     * @param listaRadicadosWSVO
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     * @throws Exception
     */
    public String actualizarSiiOperador(OperadorWSVO operadorWSVO, PersonaWSVO repLegalWSVO,
                                        PersonaWSVO revisorFiscalWSVO, PersonaWSVO repLegalSuplenteWSVO,
                                        PersonaWSVO revisorFiscalSuplenteWSVO, PersonaWSVO contactoWSVO,
                                        PersonaWSVO apoderadoWSVO, PersonaWSVO socio1WSVO, PersonaWSVO socio2WSVO,
                                        PersonaWSVO socio3WSVO, PersonaWSVO socio4WSVO, PersonaWSVO socio5WSVO,
                                        PersonaWSVO contadorWSVO, SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                        List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO,
                                                                                                        ExcepcionAplicacion{
        //Variable usada para guardar el mensaje que se enviara como resultado del proceso de actualizacion del operador



        //y de la solicitud
        String resultado = "";
        try {
            SolicitudAutorizaVO solicitudVO = null;
            Calendar calendar = Calendar.getInstance();
            SiiPersona siiOperadorPersona = null;
            SiiHistPersona siiHistOperadorPersona = null;

            
            if (operadorWSVO != null) {
                if(operadorWSVO.razonSocial == null){
                    throw new ExcepcionAplicacion("La razon social no puede ser nula");
                }
                if(operadorWSVO.codMunicipioDane == null){
                    throw new ExcepcionAplicacion("El codigo DANE del municipio no puede ser nulo");
                }
                if(operadorWSVO.numIdentificacion == null){
                    throw new ExcepcionAplicacion("El numero de identificacion no puede ser nulo");
                }
            }
            
            if (solicitudAutorizacionWSVO == null) {
                throw new ExcepcionAplicacion("La solicitud no puede ser nula");
            } 
            solicitudVO = conversionVoWs.convertir(solicitudAutorizacionWSVO);

            //Si viene la informacion del operador desde el ws
            if (operadorWSVO != null) {
                
                //Esta es la informacion que nos llega por el ws
                System.out.println("Informacion de entrada del operador: " + operadorWSVO.toString());

                siiOperadorPersona = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), operadorWSVO.numIdentificacion);
                if (siiOperadorPersona == null) {
                    throw new ExcepcionAplicacion("No se cargó la información del operador porque no existe en la base de datos de Siicol");
                }
                
                //Esta es la informacion que estaba registrada en la base de datos
                System.out.println("Informacion que estaba registrada en la bd de siicol");
                System.out.println("razonSocial: " + siiOperadorPersona.getPerJurNombreLargo());
                System.out.println("numIdentificacion: " + siiOperadorPersona.getPerNumIdentificacion());
                System.out.println("direccion: " + siiOperadorPersona.getPerDireccion());
                System.out.println("telefono: " + siiOperadorPersona.getPerTelefono());
                System.out.println("telefono2: " + siiOperadorPersona.getPerTelefono2());
                System.out.println("correoElectronico: " + siiOperadorPersona.getPerEmail());
                System.out.println("digitoVerificacion: " + siiOperadorPersona.getPerDigitoVerif());
                System.out.println("tipoSociedad: " + (siiOperadorPersona.getSiiTipoSociedad() == null?"null":siiOperadorPersona.getSiiTipoSociedad().getTsoCodigo()));
                
                //Para el historico consultamos el anterior registro de representante legal para ese operador
                boolean tieneRepresentante = false;
                SiiHistPersona siiHistRepresentanteLegal = null;
                if (siiOperadorPersona.getSiiPersona() != null) {
                    tieneRepresentante = true;
                    SiiPersona siiRepresentanteLegalAnterior = siiOperadorPersona.getSiiPersona();
                    /*
                    * Copiamos el registro antiguo en el historico del representante legal
                    */
                    siiHistRepresentanteLegal = copiarPersonaHistoricoPersona(siiRepresentanteLegalAnterior);
                    siiHistRepresentanteLegal.setSiiPersonaOrigen(siiRepresentanteLegalAnterior);
                    histPersonaDao.insertar(siiHistRepresentanteLegal);
                }

                /*
                * Copiamos el registro antiguo del operador en el historico operador
                */
                siiHistOperadorPersona = copiarPersonaHistoricoPersona(siiOperadorPersona);
                siiHistOperadorPersona.setSiiPersonaOrigen(siiOperadorPersona);
                if (tieneRepresentante) {
                    siiHistOperadorPersona.setSiiHistPersonaRepLegal(siiHistRepresentanteLegal);
                }
                histPersonaDao.insertar(siiHistOperadorPersona);

                //actualizamos los datos actuales con los provenientes del WS
                siiOperadorPersona.setPerJurNombreLargo(operadorWSVO.razonSocial);
                siiOperadorPersona.setPerNumIdentificacion(operadorWSVO.numIdentificacion);
                siiOperadorPersona.setPerDireccion(operadorWSVO.direccion);
                siiOperadorPersona.setPerTelefono(operadorWSVO.telefono);
                siiOperadorPersona.setPerTelefono2(operadorWSVO.telefono2);
                siiOperadorPersona.setPerEmail(operadorWSVO.correoElectronico);
                SiiUbicacion siiUbicacion = ubicacionDao.buscarUbicacionPorId(operadorWSVO.codMunicipioDane);
                siiOperadorPersona.setSiiUbicacion1(siiUbicacion);
                siiOperadorPersona.setPerDigitoVerif(operadorWSVO.digitoVerificacion);
                if(operadorWSVO.tipoSociedad != null){
                    SiiTipoSociedad siiTipoSociedad = tipoSociedadDao.buscarPorCodigo(operadorWSVO.tipoSociedad);
                    siiOperadorPersona.setSiiTipoSociedad(siiTipoSociedad);
                }
                personaDao.actualizarPersona(siiOperadorPersona);

                //Informacion final que quedo registrada en la base de datos
                System.out.println("Informacion final registrada en siicol");
                System.out.println("razonSocial: " + siiOperadorPersona.getPerJurNombreLargo());
                System.out.println("numIdentificacion: " + siiOperadorPersona.getPerNumIdentificacion());
                System.out.println("direccion: " + siiOperadorPersona.getPerDireccion());
                System.out.println("telefono: " + siiOperadorPersona.getPerTelefono());
                System.out.println("telefono2: " + siiOperadorPersona.getPerTelefono2());
                System.out.println("correoElectronico: " + siiOperadorPersona.getPerEmail());
                System.out.println("digitoVerificacion: " + siiOperadorPersona.getPerDigitoVerif());
                System.out.println("tipoSociedad: " + (siiOperadorPersona.getSiiTipoSociedad() == null?"null":siiOperadorPersona.getSiiTipoSociedad().getTsoCodigo()));
            
            }

            /*
            * Si no trae la informacion del operador por el ws entonces vamos a buscar el operador en la base de datos
            * por el nit que viene en la solicitud de autorizacion
            */

            else {
                //operadorWSVO es nulo
                siiOperadorPersona = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizacionWSVO.nit);
                if(siiOperadorPersona == null){
                    throw new ExcepcionAplicacion("Error, no se encuentra al operador con NIT " + solicitudAutorizacionWSVO.nit);
                }
                
                //Para el historico consultamos el anterior registro de representante legal para ese operador
                boolean tieneRepresentante = false;
                SiiHistPersona siiHistRepresentanteLegal = null;
                if (siiOperadorPersona.getSiiPersona() != null) {
                    tieneRepresentante = true;
                    SiiPersona siiRepresentanteLegalAnterior = siiOperadorPersona.getSiiPersona();
                    /*
                    * Copiamos el registro antiguo en el historico del representante legal
                    */
                    siiHistRepresentanteLegal = copiarPersonaHistoricoPersona(siiRepresentanteLegalAnterior);
                    siiHistRepresentanteLegal.setSiiPersonaOrigen(siiRepresentanteLegalAnterior);
                    histPersonaDao.insertar(siiHistRepresentanteLegal);
                }

                /*
                 * Copiamos el registro antiguo en el historico operador
                 */
                siiHistOperadorPersona = copiarPersonaHistoricoPersona(siiOperadorPersona);
                siiHistOperadorPersona.setSiiPersonaOrigen(siiOperadorPersona);
                if (tieneRepresentante) {
                    siiHistOperadorPersona.setSiiHistPersonaRepLegal(siiHistRepresentanteLegal);
                }
                histPersonaDao.insertar(siiHistOperadorPersona);
            }

            /*
             * Para efectos del historico en la actualizacion del operador entonces traemos toda la informacion del
             * operador y sus asociados (SiiPersonalEmpresa)
             */

            List<SiiPersonalEmpresa> listaPersonalEmpresa = new ArrayList<>();
            listaPersonalEmpresa = personalEmpresaDao.buscarPersonalEmpresaPorIdPersona(siiOperadorPersona.getPerCodigo());


            if (repLegalWSVO != null) {
                if(!repLegalWSVO.perTipoPersona.equals("N")){
                    throw new ExcepcionAplicacion("El representante legal solo puede ser persona natural");
                }
                System.out.println("Informacion de entrada del representante legal: " + repLegalWSVO.toString());
                //Buscar el representante Legal
                SiiPersona siiPersonaRepLegal = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(repLegalWSVO.tipoIdentificacion), repLegalWSVO.numIdentificacion);
                
                if (siiPersonaRepLegal == null) {
                    siiPersonaRepLegal = copiarPersonaWsVoASiiPersona(repLegalWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiPersonaRepLegal);

                } else {
                    siiPersonaRepLegal = copiarPersonaWsVoASiiPersona(repLegalWSVO, siiPersonaRepLegal);
                    personaDao.actualizarPersona(siiPersonaRepLegal);
                }
                
                //Hacemos la asociacion con el operador
                siiOperadorPersona.setSiiPersona(siiPersonaRepLegal);
                personaDao.actualizarPersona(siiOperadorPersona);
            }


            //REPRESENTANTE LEGAL SUPLENTE
            if (repLegalSuplenteWSVO != null) {
                if(!repLegalSuplenteWSVO.perTipoPersona.equals("N")){
                    throw new ExcepcionAplicacion("El representante legal suplente solo puede ser persona natural");
                }
                System.out.println("Informacion de entrada del representante legal suplente: " + repLegalSuplenteWSVO.toString());
                SiiPersona siiPersonaRepLegalSuplente = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(repLegalSuplenteWSVO.tipoIdentificacion), repLegalSuplenteWSVO.numIdentificacion);
                
                if (siiPersonaRepLegalSuplente == null) {
                    siiPersonaRepLegalSuplente = copiarPersonaWsVoASiiPersona(repLegalSuplenteWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiPersonaRepLegalSuplente);
                } else {
                    siiPersonaRepLegalSuplente = copiarPersonaWsVoASiiPersona(repLegalSuplenteWSVO, siiPersonaRepLegalSuplente);
                    personaDao.actualizarPersona(siiPersonaRepLegalSuplente);
                }


                SiiPersona siiRepresentanteLegalSuplenteAnterior = new SiiPersona();
                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.REPRESENTANTE_LEGAL_SUPLENTE.getId())) {
                        siiRepresentanteLegalSuplenteAnterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;

                        /*
                         * Copiamos el registro antiguo de la SiiPersona revisor fiscal en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(siiRepresentanteLegalSuplenteAnterior);
                        siiHistPersona.setSiiPersonaOrigen(siiRepresentanteLegalSuplenteAnterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                        * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                        * anterior representante legal y el actual
                        */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);

                        /*
                        * Si es diferente
                        */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiPersonaRepLegalSuplente.getPerNumIdentificacion()) {


                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior representante legal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());

                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.REPRESENTANTE_LEGAL_SUPLENTE.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiPersonaRepLegalSuplente);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }

                }
                if (!existePersonalEmpresa) {
                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.REPRESENTANTE_LEGAL_SUPLENTE.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiPersonaRepLegalSuplente);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }
            }


            // Persona de contacto
            if (contactoWSVO != null) {
                if(!contactoWSVO.perTipoPersona.equals("N")){
                    throw new ExcepcionAplicacion("La persona de contacto solo puede ser persona natural");
                }
                System.out.println("Informacion de entrada de la persona de contacto: " + contactoWSVO.toString());
                SiiPersona siiPersonaContactoEmp = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(contactoWSVO.tipoIdentificacion), contactoWSVO.numIdentificacion);
                
                if (siiPersonaContactoEmp == null) {
                    siiPersonaContactoEmp = copiarPersonaWsVoASiiPersona(contactoWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiPersonaContactoEmp);
                } else {
                    siiPersonaContactoEmp = copiarPersonaWsVoASiiPersona(contactoWSVO, siiPersonaContactoEmp);
                    personaDao.actualizarPersona(siiPersonaContactoEmp);
                }


                SiiPersona personaContactoAnterior = new SiiPersona();
                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.CONTACTO_EMPRESA.getId())) {
                        personaContactoAnterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;
                        /*
                         * Copiamos el registro antiguo en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(personaContactoAnterior);
                        siiHistPersona.setSiiPersonaOrigen(personaContactoAnterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                        * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                        * anterior representante legal y el actual
                        */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);
                        /*
                          * Si es diferente
                         */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiPersonaContactoEmp.getPerNumIdentificacion()) {
                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior representante legal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());

                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.CONTACTO_EMPRESA.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiPersonaContactoEmp);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }
                }
                if (!existePersonalEmpresa) {
                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.CONTACTO_EMPRESA.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiPersonaContactoEmp);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }
            }

            // Apoderado
            if (apoderadoWSVO != null) {
                if(!apoderadoWSVO.perTipoPersona.equals("N")){
                    throw new ExcepcionAplicacion("El apoderado solo puede ser persona natural");
                }
                System.out.println("Informacion de entrada del apoderado: " + apoderadoWSVO.toString());
                SiiPersona siiPersonaApoderado = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(apoderadoWSVO.tipoIdentificacion), apoderadoWSVO.numIdentificacion);
                
                if (siiPersonaApoderado == null) {
                    siiPersonaApoderado = copiarPersonaWsVoASiiPersona(apoderadoWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiPersonaApoderado);
                } else {
                    String emailApoderado = apoderadoWSVO.correoElectronico;
                    siiPersonaApoderado = copiarPersonaWsVoASiiPersona(apoderadoWSVO, siiPersonaApoderado);
                    //Para el apoderado el email es obligatorio. Si llega null o vacío se actualiza con dicho valor
                    siiPersonaApoderado.setPerEmail(emailApoderado);
                    personaDao.actualizarPersona(siiPersonaApoderado);
                }


                SiiPersona personaApoderadoAnterior = new SiiPersona();
                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.APODERADO.getId())) {
                        personaApoderadoAnterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;
                        /*
                         * Copiamos el registro antiguo en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(personaApoderadoAnterior);
                        siiHistPersona.setSiiPersonaOrigen(personaApoderadoAnterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                        * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                        * anterior representante legal y el actual
                        */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);
                        /*
                        * Si es diferente
                        */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiPersonaApoderado.getPerNumIdentificacion()) {

                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior representante legal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());
                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.APODERADO.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiPersonaApoderado);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }
                }
                if (!existePersonalEmpresa) {
                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.APODERADO.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiPersonaApoderado);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }
            }
            
            //Revisor fiscal
            if (revisorFiscalWSVO != null) {
                System.out.println("Informacion de entrada del revisor fiscal: " + revisorFiscalWSVO.toString());
                SiiPersona siiRevisorFiscal = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(revisorFiscalWSVO.tipoIdentificacion), revisorFiscalWSVO.numIdentificacion);
                
                if (siiRevisorFiscal == null) {
                    siiRevisorFiscal = copiarPersonaWsVoASiiPersona(revisorFiscalWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiRevisorFiscal);
                } else {
                    siiRevisorFiscal = copiarPersonaWsVoASiiPersona(revisorFiscalWSVO, siiRevisorFiscal);
                    personaDao.actualizarPersona(siiRevisorFiscal);
                }

                SiiPersona siiRevisorFiscalAnterior = new SiiPersona();

                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.REVISOR_FISCAL.getId())) {
                        siiRevisorFiscalAnterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;

                        /*
                         * Copiamos el registro antiguo de la SiiPersona revisor fiscal en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(siiRevisorFiscalAnterior);
                        siiHistPersona.setSiiPersonaOrigen(siiRevisorFiscalAnterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                        * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                        * anterior representante legal y el actual
                        */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);

                        /*
                        * Si es diferente
                        */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiRevisorFiscal.getPerNumIdentificacion()) {


                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior revisor fiscal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());

                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.REVISOR_FISCAL.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiRevisorFiscal);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }
                }

                if (!existePersonalEmpresa) {
                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.REVISOR_FISCAL.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiRevisorFiscal);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }

            }
            
            //REVISOR FISCAL SUPLENTE
            if (revisorFiscalSuplenteWSVO != null) {
                System.out.println("Informacion de entrada del revisor fiscal suplente: " + revisorFiscalSuplenteWSVO.toString());
                SiiPersona siiRevisorFiscalSuplente = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(revisorFiscalSuplenteWSVO.tipoIdentificacion), revisorFiscalSuplenteWSVO.numIdentificacion);
                
                if (siiRevisorFiscalSuplente == null) {
                    siiRevisorFiscalSuplente = copiarPersonaWsVoASiiPersona(revisorFiscalSuplenteWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiRevisorFiscalSuplente);
                } else {
                    siiRevisorFiscalSuplente = copiarPersonaWsVoASiiPersona(revisorFiscalSuplenteWSVO, siiRevisorFiscalSuplente);
                    personaDao.actualizarPersona(siiRevisorFiscalSuplente);
                }

                SiiPersona siiRevisorFiscalSuplenteAnterior = new SiiPersona();
                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.REVISOR_FISCAL_SUPLENTE.getId())) {
                        siiRevisorFiscalSuplenteAnterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;
                        /*
                         * Copiamos el registro antiguo de la SiiPersona revisor fiscal en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(siiRevisorFiscalSuplenteAnterior);
                        siiHistPersona.setSiiPersonaOrigen(siiRevisorFiscalSuplenteAnterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                        * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                        * anterior representante legal y el actual
                        */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);

                        /*
                        * Si es diferente
                        */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiRevisorFiscalSuplente.getPerNumIdentificacion()) {


                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior representante legal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());

                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.REVISOR_FISCAL_SUPLENTE.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiRevisorFiscalSuplente);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }

                }
                if (!existePersonalEmpresa) {
                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = new SiiTipoPersonal();
                    siiTipoPersonal.setTpeCodigo(EnumTipoPersonal.REVISOR_FISCAL_SUPLENTE.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiRevisorFiscalSuplente);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }
            }

            //CONTADOR

            if (contadorWSVO != null) {
                if(!contadorWSVO.perTipoPersona.equals("N")){
                    throw new ExcepcionAplicacion("El contador solo puede ser persona natural");
                }
                System.out.println("Informacion de entrada del contador: " + contadorWSVO.toString());
                SiiPersona siiContador = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(contadorWSVO.tipoIdentificacion), contadorWSVO.numIdentificacion);
                
                if (siiContador == null) {
                    siiContador = copiarPersonaWsVoASiiPersona(contadorWSVO, new SiiPersona());
                    personaDao.insertarPersona(siiContador);
                } else {
                    siiContador = copiarPersonaWsVoASiiPersona(contadorWSVO, siiContador);
                    personaDao.actualizarPersona(siiContador);
                }

                SiiPersona siiContadorAnterior = new SiiPersona();
                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.CONTADOR.getId())) {
                        siiContadorAnterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;
                        /*
                         * Copiamos el registro antiguo de la SiiPersona revisor fiscal en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(siiContadorAnterior);
                        siiHistPersona.setSiiPersonaOrigen(siiContadorAnterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                        * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                        * anterior representante legal y el actual
                        */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);

                        /*
                        * Si es diferente
                        */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiContador.getPerNumIdentificacion()) {


                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior representante legal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());

                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.CONTADOR.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiContador);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }
                }
                if (!existePersonalEmpresa) {
                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.CONTADOR.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiContador);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }
            }

            //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/SOCIOS/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/


            // Socio Mayoritario uno
            if (socio1WSVO != null) {
                System.out.println("Informacion de entrada del socio1:\r\n" + socio1WSVO.toString());
                SiiPersona siiSocio1 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(socio1WSVO.tipoIdentificacion), socio1WSVO.numIdentificacion);
                /*
                * Comprobamos si la busqueda de la persona que esta ingresando es exitosa y devuelve algun resultado, en caso de que
                * no lo devuelva debemos hacer el registro en la base de datos para posterirormente hacer la asociacion
                */
                if (siiSocio1 == null) {
                    siiSocio1 = copiarPersonaWsVoASiiPersona(socio1WSVO, new SiiPersona());
                    personaDao.insertarPersona(siiSocio1);
                } else {
                    /*
                    * Actualizamos la anterior socio con la informacion nueva que entra desde el web services
                    */
                    siiSocio1.setPerPrimerNombre(socio1WSVO.primerNombre);
                    siiSocio1.setPerPrimerApellido(socio1WSVO.primerApellido);
                    siiSocio1.setPerSegundoNombre(socio1WSVO.segundoNombre);
                    siiSocio1.setPerSegundoApellido(socio1WSVO.segundoApellido);
                    if(socio1WSVO.tipoIdentificacion == EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId()
                            || socio1WSVO.perTipoPersona.equals("J")){
                        siiSocio1.setPerJurNombreLargo(socio1WSVO.primerNombre);
                        siiSocio1.setPerPrimerNombre(null);
                        siiSocio1.setPerSegundoNombre(null);
                        siiSocio1.setPerPrimerApellido(null);
                        siiSocio1.setPerSegundoApellido(null);
                    }
                    personaDao.actualizarPersona(siiSocio1);
                }

                SiiPersona siiSocio1Anterior = new SiiPersona();
                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.SOCIO_MAYORITARIO_1.getId())) {
                        siiSocio1Anterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;
                        /*
                         * Copiamos el registro antiguo de la SiiPersona revisor fiscal en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(siiSocio1Anterior);
                        siiHistPersona.setSiiPersonaOrigen(siiSocio1Anterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                        * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                        * anterior representante legal y el actual
                        */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);

                        /*
                        * Si es diferente
                        */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiSocio1.getPerNumIdentificacion()) {


                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior representante legal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());

                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_1.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiSocio1);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }
                }
                if (!existePersonalEmpresa) {

                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = new SiiTipoPersonal();
                    siiTipoPersonal.setTpeCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_1.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiSocio1);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }

            }

            // Socio Mayoritario dos
            if (socio2WSVO != null) {
                System.out.println("Informacion de entrada del socio2:\r\n" + socio2WSVO.toString());
                SiiPersona siiSocio2 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(socio2WSVO.tipoIdentificacion), socio2WSVO.numIdentificacion);
                /*
                * Comprobamos si la busqueda de la persona que esta ingresando es exitosa y devuelve algun resultado, en caso de que
                * no lo devuelva debemos hacer el registro en la base de datos para posterirormente hacer la asociacion
                */
                if (siiSocio2 == null) {
                    siiSocio2 = copiarPersonaWsVoASiiPersona(socio2WSVO, new SiiPersona());
                    personaDao.insertarPersona(siiSocio2);
                } else {
                    /*
                    * Actualizamos la anterior socio con la informacion nueva que entra desde el web services
                    */
                    siiSocio2.setPerPrimerNombre(socio2WSVO.primerNombre);
                    siiSocio2.setPerPrimerApellido(socio2WSVO.primerApellido);
                    siiSocio2.setPerSegundoNombre(socio2WSVO.segundoNombre);
                    siiSocio2.setPerSegundoApellido(socio2WSVO.segundoApellido);
                    if(socio2WSVO.tipoIdentificacion == EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId()
                            || socio2WSVO.perTipoPersona.equals("J")){
                        siiSocio2.setPerJurNombreLargo(socio1WSVO.primerNombre);
                        siiSocio2.setPerPrimerNombre(null);
                        siiSocio2.setPerSegundoNombre(null);
                        siiSocio2.setPerPrimerApellido(null);
                        siiSocio2.setPerSegundoApellido(null);
                    }
                    personaDao.actualizarPersona(siiSocio2);
                }

                SiiPersona siiSocio2Anterior = new SiiPersona();
                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.SOCIO_MAYORITARIO_2.getId())) {
                        siiSocio2Anterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;
                        /*
                         * Copiamos el registro antiguo de la SiiPersona revisor fiscal en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(siiSocio2Anterior);
                        siiHistPersona.setSiiPersonaOrigen(siiSocio2Anterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                        * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                        * anterior representante legal y el actual
                        */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);

                        /*
                        * Si es diferente
                        */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiSocio2.getPerNumIdentificacion()) {


                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior representante legal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());

                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_2.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiSocio2);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }

                }
                if (!existePersonalEmpresa) {
                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_2.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiSocio2);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }
            }

            // Socio Mayoritario tres
            if (socio3WSVO != null) {
                System.out.println("Informacion de entrada del socio3:\r\n" + socio3WSVO.toString());
                SiiPersona siiSocio3 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(socio3WSVO.tipoIdentificacion), socio3WSVO.numIdentificacion);
                /*
                * Comprobamos si la busqueda de la persona que esta ingresando es exitosa y devuelve algun resultado, en caso de que
                * no lo devuelva debemos hacer el registro en la base de datos para posterirormente hacer la asociacion
                */
                if (siiSocio3 == null) {
                    siiSocio3 = copiarPersonaWsVoASiiPersona(socio3WSVO, new SiiPersona());
                    personaDao.insertarPersona(siiSocio3);
                } else {
                    /*
                    * Actualizamos la anterior socio con la informacion nueva que entra desde el web services
                    */
                    siiSocio3.setPerPrimerNombre(socio3WSVO.primerNombre);
                    siiSocio3.setPerPrimerApellido(socio3WSVO.primerApellido);
                    siiSocio3.setPerSegundoNombre(socio3WSVO.segundoNombre);
                    siiSocio3.setPerSegundoApellido(socio3WSVO.segundoApellido);
                    if(socio3WSVO.tipoIdentificacion == EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId()
                            || socio3WSVO.perTipoPersona.equals("J")){
                        siiSocio3.setPerJurNombreLargo(socio1WSVO.primerNombre);
                        siiSocio3.setPerPrimerNombre(null);
                        siiSocio3.setPerSegundoNombre(null);
                        siiSocio3.setPerPrimerApellido(null);
                        siiSocio3.setPerSegundoApellido(null);
                    }
                    personaDao.actualizarPersona(siiSocio3);
                }

                SiiPersona siiSocio3Anterior = new SiiPersona();
                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.SOCIO_MAYORITARIO_3.getId())) {
                        siiSocio3Anterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;
                        /*
                         * Copiamos el registro antiguo de la SiiPersona revisor fiscal en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(siiSocio3Anterior);
                        siiHistPersona.setSiiPersonaOrigen(siiSocio3Anterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                        * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                        * anterior representante legal y el actual
                        */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);

                        /*
                        * Si es diferente
                        */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiSocio3.getPerNumIdentificacion()) {


                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior representante legal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());

                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_3.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiSocio3);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }
                }
                if (!existePersonalEmpresa) {
                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_3.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiSocio3);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }
            }

            // Socio Mayoritario cuatro
            if (socio4WSVO != null) {
                System.out.println("Informacion de entrada del socio4:\r\n" + socio4WSVO.toString());
                SiiPersona siiSocio4 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(socio4WSVO.tipoIdentificacion), socio4WSVO.numIdentificacion);
                /*
                * Comprobamos si la busqueda de la persona que esta ingresando es exitosa y devuelve algun resultado, en caso de que
                * no lo devuelva debemos hacer el registro en la base de datos para posterirormente hacer la asociacion
                */
                if (siiSocio4 == null) {
                    siiSocio4 = copiarPersonaWsVoASiiPersona(socio4WSVO, new SiiPersona());
                    personaDao.insertarPersona(siiSocio4);
                } else {
                    /*
                    * Actualizamos la anterior socio con la informacion nueva que entra desde el web services
                    */
                    siiSocio4.setPerPrimerNombre(socio4WSVO.primerNombre);
                    siiSocio4.setPerPrimerApellido(socio4WSVO.primerApellido);
                    siiSocio4.setPerSegundoNombre(socio4WSVO.segundoNombre);
                    siiSocio4.setPerSegundoApellido(socio4WSVO.segundoApellido);
                    if(socio4WSVO.tipoIdentificacion == EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId()
                            || socio4WSVO.perTipoPersona.equals("J")){
                        siiSocio4.setPerJurNombreLargo(socio1WSVO.primerNombre);
                        siiSocio4.setPerPrimerNombre(null);
                        siiSocio4.setPerSegundoNombre(null);
                        siiSocio4.setPerPrimerApellido(null);
                        siiSocio4.setPerSegundoApellido(null);
                    }
                    personaDao.actualizarPersona(siiSocio4);
                }

                SiiPersona siiSocio4Anterior = new SiiPersona();
                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.SOCIO_MAYORITARIO_4.getId())) {
                        siiSocio4Anterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;
                        /*
                         * Copiamos el registro antiguo de la SiiPersona revisor fiscal en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(siiSocio4Anterior);
                        siiHistPersona.setSiiPersonaOrigen(siiSocio4Anterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                    * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                    * anterior representante legal y el actual
                    */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);

                        /*
                        * Si es diferente
                        */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiSocio4.getPerNumIdentificacion()) {


                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior representante legal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());

                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_4.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiSocio4);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }
                }
                if (!existePersonalEmpresa) {
                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = new SiiTipoPersonal();
                    siiTipoPersonal.setTpeCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_4.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiSocio4);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }
            }

            // Socio Mayoritario cinco
            if (socio5WSVO != null) {
                System.out.println("Informacion de entrada del socio5:\r\n" + socio5WSVO.toString());
                SiiPersona siiSocio5 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(new Long(socio5WSVO.tipoIdentificacion), socio5WSVO.numIdentificacion);
                /*
                * Comprobamos si la busqueda de la persona que esta ingresando es exitosa y devuelve algun resultado, en caso de que
                * no lo devuelva debemos hacer el registro en la base de datos para posterirormente hacer la asociacion
                */
                if (siiSocio5 == null) {
                    siiSocio5 = copiarPersonaWsVoASiiPersona(socio5WSVO, new SiiPersona());
                    personaDao.insertarPersona(siiSocio5);
                } else {
                    /*
                    * Actualizamos la anterior socio con la informacion nueva que entra desde el web services
                    */
                    siiSocio5.setPerPrimerNombre(socio5WSVO.primerNombre);
                    siiSocio5.setPerPrimerApellido(socio5WSVO.primerApellido);
                    siiSocio5.setPerSegundoNombre(socio5WSVO.segundoNombre);
                    siiSocio5.setPerSegundoApellido(socio5WSVO.segundoApellido);
                    if(socio5WSVO.tipoIdentificacion == EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId()
                            || socio5WSVO.perTipoPersona.equals("J")){
                        siiSocio5.setPerJurNombreLargo(socio1WSVO.primerNombre);
                        siiSocio5.setPerPrimerNombre(null);
                        siiSocio5.setPerSegundoNombre(null);
                        siiSocio5.setPerPrimerApellido(null);
                        siiSocio5.setPerSegundoApellido(null);
                    }
                    personaDao.actualizarPersona(siiSocio5);
                }

                SiiPersona siiSocio5Anterior = new SiiPersona();
                /*
                * Verificamos si el representante legal es el mismo de la ultima vez de lo contrario debemos buscar
                * la persona por ese numero de identificacion para hacer la asociacion
                */
                boolean existePersonalEmpresa = false;
                for (SiiPersonalEmpresa siiPersonalEmpresa : listaPersonalEmpresa) {

                    if (siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo().equals(EnumTipoPersonal.SOCIO_MAYORITARIO_5.getId())) {
                        siiSocio5Anterior = siiPersonalEmpresa.getSiiPersona3();
                        existePersonalEmpresa = true;
                        /*
                         * Copiamos el registro antiguo de la SiiPersona revisor fiscal en el historico
                         */
                        SiiHistPersona siiHistPersona = copiarPersonaHistoricoPersona(siiSocio5Anterior);
                        siiHistPersona.setSiiPersonaOrigen(siiSocio5Anterior);
                        histPersonaDao.insertar(siiHistPersona);

                        /*
                        * Creamos el registro del historico de personal empresa, para cambiar la sociacion entre el
                        * anterior representante legal y el actual
                        */
                        SiiHistPersonalEmp siiHistPersonalEmpresa = new SiiHistPersonalEmp();
                        siiHistPersonalEmpresa = copiarPersonalEmpresaHistoricoPersonalEmpresa(siiPersonalEmpresa);
                        siiHistPersonalEmpresa.setSiiHistPersonaEmpresa(siiHistOperadorPersona);
                        siiHistPersonalEmpresa.setSiiHistPersonaPersona(siiHistPersona);
                        histPersonalEmpDao.insertarSiiHistPersonalEmp(siiHistPersonalEmpresa);

                        /*
                        * Si es diferente
                        */

                        if (siiPersonalEmpresa.getSiiPersona3().getPerNumIdentificacion() !=
                            siiSocio5.getPerNumIdentificacion()) {


                            /*
                            * Eliminamos el anterior registro que tenia la asociacion con el anterior representante legal
                            * para poder hacer la nueva asociacion sin afectar la integridad de los datos
                            */
                            personalEmpresaDao.borrarPersonalEmpresa(siiPersonalEmpresa.getPemCodigo());

                            //Hacemos la nueva asociacion
                            SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                            siiPersonalEmpresaNuevo.setPemActivo("S");
                            siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                            //Tipo Personal
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_5.getId());
                            siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                            siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                            siiPersonalEmpresaNuevo.setSiiPersona3(siiSocio5);

                            personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);

                        }

                        break;
                    }

                }
                if (!existePersonalEmpresa) {
                    //Hacemos la nueva asociacion
                    SiiPersonalEmpresa siiPersonalEmpresaNuevo = new SiiPersonalEmpresa();
                    siiPersonalEmpresaNuevo.setPemActivo("S");
                    siiPersonalEmpresaNuevo.setPemFechaRegistro(calendar.getTime());
                    //Tipo Personal
                    SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(EnumTipoPersonal.SOCIO_MAYORITARIO_5.getId());
                    siiPersonalEmpresaNuevo.setSiiTipoPersonal(siiTipoPersonal);
                    siiPersonalEmpresaNuevo.setSiiPersona(siiOperadorPersona);
                    siiPersonalEmpresaNuevo.setSiiPersona3(siiSocio5);

                    personalEmpresaDao.insertarSiiPersonalEmpresa(siiPersonalEmpresaNuevo);
                }
            }
            
            SiiExpedienteDocum siiExpedienteDocumento = null;
            boolean existeTarjProContador = false;
            boolean existeContador = false;
            if(listaExpedienteRadicadoWsVo != null && listaExpedienteRadicadoWsVo.size() > 0){
                //Gestion Documental
                //Buscamos el expediente principal
                SiiExpedienteDocum siiExpedienteDocumPrincipal = null;
                if(solicitudAutorizacionWSVO.numeroContrato != null){
                    siiExpedienteDocumPrincipal = expedienteDocumDao.buscarExpedientePrincipalPorContratoPorNit(solicitudAutorizacionWSVO.numeroContrato, solicitudAutorizacionWSVO.nit);
                }
                //Creamos el nuevo expediente
                siiExpedienteDocumento = new SiiExpedienteDocum();
                siiExpedienteDocumento.setEdoCodigo(solicitudAutorizacionWSVO.numeroSiito);
                siiExpedienteDocumento.setEdoFecha(calendar.getTime());
                siiExpedienteDocumento.setSiiExpedienteDocumPadre(siiExpedienteDocumPrincipal);
                expedienteDocumDao.insertarExpedienteDocum(siiExpedienteDocumento);
                
                for(ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo){
                    //Creamos el expediente radicado y lo asociamos con el expediente
                    SiiExpedienteRadicado siiExpedienteRadicado = new SiiExpedienteRadicado();
                    siiExpedienteRadicado.setExrCodigo(expedienteRadicadoWsVo.codigoExpedienteRadicado);
                    siiExpedienteRadicado.setSiiExpedienteDocum(siiExpedienteDocumento);
                    siiExpedienteRadicado.setExrFecha(new Date());
                    siiExpedienteRadicado = expedienteRadicadoDao.insertarExpedienteRadicado(siiExpedienteRadicado);
                    
                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null && expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                        
                        //Documentos Radicados
                        for (DocumentoRadicadoWSVO radicadoWSVO : expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo) {
                            SiiDocumentoRadicado siiDocumentoRadicado = new SiiDocumentoRadicado();
                            siiDocumentoRadicado.setDraFecha(radicadoWSVO.draFecha);
                            siiDocumentoRadicado.setDraCodigo(radicadoWSVO.draCodigo);
                            siiDocumentoRadicado.setSiiExpedienteRadicado(siiExpedienteRadicado);
                            
                            boolean esContador = false;
                            if(radicadoWSVO.cargo != null){
                                SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(radicadoWSVO.cargo);
                                if(siiTipoPersonal == null){
                                    throw new ExcepcionAplicacion("No se encontró el cargo con identificador " + radicadoWSVO.cargo);
                                }
                                siiDocumentoRadicado.setSiiTipoPersonal(siiTipoPersonal);
                                //Verificamos si el tipo de personal es Contador
                                esContador = siiTipoPersonal.getTpeCodigo() == EnumTipoPersonal.CONTADOR.getId();
                                if(esContador){
                                    existeContador = true;
                                }
                            }
        
                            //Tipo radicado
                            if(radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0){
                                throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                            }
                            SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                            if (siiTipoDocRadicado == null) {
                                throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " + siiDocumentoRadicado.getDraCodigo());
                            }
                            siiDocumentoRadicado.setSiiTipoDocRadicado(siiTipoDocRadicado);
                            //Verificamos si el tipo de documento es tarjeta profesional
                            if(esContador && siiTipoDocRadicado.getTdrCodigo() == EnumTipoDocRadicado.TARJETA_PROFESIONAL.getId()){
                                existeTarjProContador = true;
                            }
        
                            /*
                             * Si el documento radicado tiene un numero de identificacion asociado entonces vamos a buscar esa persona
                             * en la base de datos de siicol para poder hacer la asociacion con el documento radicado al momento de registrarlo.
                             */
                            if(radicadoWSVO.perNumIdentificacion == null || radicadoWSVO.perNumIdentificacion.equals("")){
                                throw new ExcepcionAplicacion("Falta el número de identificación de la persona del documento " + siiDocumentoRadicado.getDraCodigo());
                            }
                            
                            if(radicadoWSVO.perTipoIdentificacion == null || radicadoWSVO.perTipoIdentificacion <= 0){
                                throw new ExcepcionAplicacion("Falta el tipo de identificación de la persona del documento " + siiDocumentoRadicado.getDraCodigo());
                            }
                            
                            SiiPersona siiPersonaRadicado = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(radicadoWSVO.perTipoIdentificacion, radicadoWSVO.perNumIdentificacion);
                            if (siiPersonaRadicado == null) {
                                throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " + radicadoWSVO.perNumIdentificacion);
                            }
                            siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);
                            //}
        
                            SiiDocumentoRadicado siiDocumentoRadicadoTemp = documentoRadicadoDao.buscarDocumentoRadicadoPorId(radicadoWSVO.draCodigo);
        
                            //TODO: verificar si realmente se puede hacer actualización
                            if (siiDocumentoRadicadoTemp == null) {
                                documentoRadicadoDao.insertarSiiDocumentoRadicado(siiDocumentoRadicado);
                            }
                            else {
                                documentoRadicadoDao.actualizarDocumentoRadicado(siiDocumentoRadicado);
                            }
                        }
                    }
                }
            }
            
            //Debe existir la tarjeta profesional del contador solo si existe el contador
            if(existeContador && !existeTarjProContador){
                throw new ExcepcionAplicacion("La tarjeta profesional del contador es requerida");
            }

            // Se inserta la solicitud de autorizacion
            EstadoSolicAutorizVO estadoSolicAutorizVo = new EstadoSolicAutorizVO();
            estadoSolicAutorizVo.setEsaCodigo(EnumEstadoSolicitudAutoriza.SOLIC_ESTADO_REVISADO.getId());
            solicitudVO.setEstadoSolicAutoriz(estadoSolicAutorizVo);
            SiiSolicitudAutoriza siiSolicitud = conversionVoEntidad.convertir(solicitudVO);
            
            if (siiExpedienteDocumento != null){
                siiSolicitud.setSiiExpedienteDocum(siiExpedienteDocumento);
            }
            siiSolicitud = solicitudAutorizaDao.insertarSiiSolicitudAutoriza(siiSolicitud);

            resultado = siiSolicitud.getSauCodigo() + " " + solicitudAutorizacionWSVO.codigoMovimiento + " Proceso Exitoso";
            
        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();
            throw ex;
        } catch (ExcepcionAplicacion ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionAplicacion(ex.getMessage());
        }
        return resultado;
    }

    /**
     *Metodo encargado de copiar una entidad de tipo persona a una entidad historico de person
     * @Author David Tafur
     * @param siiPersona
     * @return
     */
    public SiiHistPersona copiarPersonaHistoricoPersona(SiiPersona siiPersona) throws ExcepcionDAO {
        SiiHistPersona siiHistPersona = new SiiHistPersona();

        siiHistPersona.setHpeCelular(siiPersona.getPerCelular());
        siiHistPersona.setHpeDigitoVerif(siiPersona.getPerDigitoVerif());
        siiHistPersona.setHpeDireccion(siiPersona.getPerDireccion());
        siiHistPersona.setHpeEmail(siiPersona.getPerEmail());
        siiHistPersona.setHpeFax(siiPersona.getPerFax());
        siiHistPersona.setHpeJurNombreCorto(siiPersona.getPerJurNombreCorto());
        siiHistPersona.setHpeJurNombreLargo(siiPersona.getPerJurNombreLargo());
        siiHistPersona.setHpeNumIdentificacion(siiPersona.getPerNumIdentificacion());
        siiHistPersona.setHpeOrigen(siiPersona.getPerOrigen());
        siiHistPersona.setHpePrimerApellido(siiPersona.getPerPrimerApellido());
        siiHistPersona.setHpePrimerNombre(siiPersona.getPerPrimerNombre());
        siiHistPersona.setHpeSegundoApellido(siiPersona.getPerSegundoApellido());
        siiHistPersona.setHpeSegundoNombre(siiPersona.getPerSegundoNombre());
        siiHistPersona.setHpeTelefono(siiPersona.getPerTelefono());
        siiHistPersona.setHpeTelefono2(siiPersona.getPerTelefono2());
        siiHistPersona.setHpeTipoPersona(siiPersona.getPerTipoPersona());
        siiHistPersona.setHpeTipoProveedor(siiPersona.getPerTipoProveedor());
        //  siiHistPersona.setRdiCodigoRenta(siiPersona.getRdiCodigoRenta());
        // siiHistPersona.setRdiCodigoVentas(siiPersona.getRdiCodigoVentas());
        // siiHistPersona.setTreCodigo(siiPersona.);

        if (siiPersona.getSiiUbicacion1() != null && !siiPersona.getSiiUbicacion1().getUbiCodigo().equals("")) {
            SiiUbicacion siiUbicacion = ubicacionDao.buscarUbicacionPorId(siiPersona.getSiiUbicacion1().getUbiCodigo());
            siiHistPersona.setSiiUbicacion(siiUbicacion);
        }

        if (siiPersona.getSiiTipoRetencionVentas() != null && !siiPersona.getSiiTipoRetencionVentas().getTreCodigo().equals("")) {
            SiiTipoRetencion siiTipoRetencionVent = tipoRetencionDao.buscarPorCodigo(siiPersona.getSiiTipoRetencionVentas().getTreCodigo());
            siiHistPersona.setSiiTipoRetencionVent(siiTipoRetencionVent);
        }

        if (siiPersona.getSiiTipoRetencionRentas() != null && !siiPersona.getSiiTipoRetencionRentas().getTreCodigo().equals("")) {
            SiiTipoRetencion siiTipoRetencionRent = tipoRetencionDao.buscarPorCodigo(siiPersona.getSiiTipoRetencionRentas().getTreCodigo());
            siiHistPersona.setSiiTipoRetencionRent(siiTipoRetencionRent);
        }

        if (siiPersona.getSiiPersona() != null && siiPersona.getSiiPersona().getPerCodigo() > 0) {
            SiiHistPersona siiHistPersonaRepLegal = histPersonaDao.buscarPorCodigo(siiPersona.getSiiPersona().getPerCodigo());
            siiHistPersona.setSiiHistPersonaRepLegal(siiHistPersonaRepLegal);
        }

        if (siiPersona.getSiiTipoIdentificacion1() != null && siiPersona.getSiiTipoIdentificacion1().getTidCodigo() > 0) {
            SiiTipoIdentificacion siiTipoIdentificacion = tipoIdentificacionDao.buscarTipoIdentificacionPorId(siiPersona.getSiiTipoIdentificacion1().getTidCodigo());
            siiHistPersona.setSiiTipoIdentificacion(siiTipoIdentificacion);
        }
        /*
        if(siiPersona.getSiiTipoSociedad() != null && siiPersona.getSiiTipoSociedad().getTsoCodigo() != null){
            SiiTipoSociedad siiTipoSociedad = tipoSociedadDao.buscarPorCodigo(siiPersona.getSiiTipoSociedad().getTsoCodigo());
            siiHistPersona.setSiiTipoSociedad(siiTipoSociedad);
        }
        */
        return siiHistPersona;
    }

    /**
     *Metodo encargado de copiar una entidad de tipo persona empresa en una entidad historica de persona empresa
     * @Author David Tafur
     * @param siiPersonalEmpresa
     * @return
     */
    public SiiHistPersonalEmp copiarPersonalEmpresaHistoricoPersonalEmpresa(SiiPersonalEmpresa siiPersonalEmpresa) throws ExcepcionDAO{
        Calendar calendar = Calendar.getInstance();

        SiiHistPersonalEmp siiHistPersonalEmp = new SiiHistPersonalEmp();
        siiHistPersonalEmp.setHpmActivo(siiPersonalEmpresa.getPemActivo());
        siiHistPersonalEmp.setHpmFechaRegistro(calendar.getTime());
        siiHistPersonalEmp.setHpmFechaInactivac(siiPersonalEmpresa.getPemFechaInactivac());
        siiHistPersonalEmp.setHpmPorcentajePart(siiPersonalEmpresa.getPemPorcentajePart());


        if (siiPersonalEmpresa.getSiiTipoPersonal() != null &&
            siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo() > 0) {
            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(siiPersonalEmpresa.getSiiTipoPersonal().getTpeCodigo());
            siiHistPersonalEmp.setSiiTipoPersonal(siiTipoPersonal);
        }

        return siiHistPersonalEmp;
    }

    /**
     *Metodo encargado de hacer el registro en la base de datos de la informacion de la declaracion del operador que
     * llega por medio del web services
     * @author CARLOS YESID ARCINIEGAS BARÓN - cyab
     * @return
     */
    public String cargarDeclaracionOperadorModificada(DeclaracionOperadorWSVO declaracionOperadorWSVO) throws ExcepcionDAO {

        String resultado = "";
        Calendar calendar = Calendar.getInstance();
        
        /*
        * Consultamos el registro de la declaracion sugerida por el numero de declaracion para hacer la
        * respectiva asociacion con la declaracion del operador
        */
        SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();
        siiDeclaracionSugerida = declaracionSugeridaDao.consultarDeclaracionSugeridaPorConsecutivo(declaracionOperadorWSVO.numeroDeclaracion);

        /*
         * Una vez tenemos la declaracion sugerida entonces vamos a hacer el registro de la declaracion del operador
        */

        SiiDeclaracionOperador siiDeclaracionOperador = new SiiDeclaracionOperador();
        siiDeclaracionOperador.setDopFecha(calendar.getTime());
        siiDeclaracionOperador.setDopTipo("D");
        siiDeclaracionOperador.setSiiDeclaracionSugerida(siiDeclaracionSugerida);

        //Registramos la declaracion del operador
        declaracionOperadorDao.insertar(siiDeclaracionOperador);

        /*
        * Almacenamos los numeros de referencia que recibimmos
         */

        SiiReferenciaPagoDecl siiReferenciaPagoDeclDE = new SiiReferenciaPagoDecl();
        SiiReferenciaPagoDecl siiReferenciaPagoDeclGA = new SiiReferenciaPagoDecl();
        siiReferenciaPagoDeclDE.setRpdNumero(declaracionOperadorWSVO.referenciaPagoDE);
        siiReferenciaPagoDeclGA.setRpdNumero(declaracionOperadorWSVO.referenciaPagoGA);

        //Registramos los numeros de referencia
        referenciaPagoDeclDao.insertarReferenciaPagoDecl(siiReferenciaPagoDeclDE);
        referenciaPagoDeclDao.insertarReferenciaPagoDecl(siiReferenciaPagoDeclGA);

        //Se buscan todas las cuotas para la vigencia y el mes por contraro
        List<SiiCuotaOperador> listaCuotaOperador = cuotaOperadorDao.buscarCuotaOperadorXOperadorXContratoXVigenciaXMes(declaracionOperadorWSVO.opeCodigo, declaracionOperadorWSVO.conCodigo, declaracionOperadorWSVO.anoOperacion , declaracionOperadorWSVO.mesCodigo);
        // Se Inactivan todas las cuotas que están en estado A sugerida y en estado T modificada
        for (SiiCuotaOperador miCuotaOperador:listaCuotaOperador){
            if (!miCuotaOperador.getCopCancelada().equals("I")){
                miCuotaOperador.setCopCancelada("I");
                cuotaOperadorDao.actualizarCuotaOperador(miCuotaOperador);
            }
        }
        /*
 * Se realiza la busqueda de los detalle declaracion sug (SiiDetalleDeclaracionSug) para esa
 * declaracion sugerida para saber cual es la cuota DE y GA que declaro el operador, de esta forma la tenemos
 * para poderla relacionar con el detalle
 */
        List<SiiDetalleDeclaracionSug> listaDetallesDeclaracionSug = new ArrayList<SiiDetalleDeclaracionSug>();
        listaDetallesDeclaracionSug =
            detalleDeclaracionSugDao.consultarListaDetalleDeclaracionSugPorCodigoDecSug(siiDeclaracionSugerida.getDsuCodigo());

        /*
 * Recorremos la lista para saber cual es la cuota DE y GA
 */
        SiiCuotaOperador siiCuotaOperadorDE = new SiiCuotaOperador();
        SiiCuotaOperador siiCuotaOperadorGA = new SiiCuotaOperador();
        for (SiiDetalleDeclaracionSug siiDetalleDeclaracionSug : listaDetallesDeclaracionSug) {

            if (siiDetalleDeclaracionSug.getSiiCuotaOperador().getSiiConceptoCuota().getCcuCodigo() ==
                EnumConceptoCuota.GASTOS_DE_ADMINISTRACION.getId()) {
                siiCuotaOperadorGA = cuotaOperadorDao.buscarCuotaOperadorPorId(siiDetalleDeclaracionSug.getSiiCuotaOperador().getCopCodigo());
                //Se pone en estado Activo ls cuota que el operador seleccionó para pago
                siiCuotaOperadorGA.setCopCancelada("A");
                cuotaOperadorDao.actualizarCuotaOperador(siiCuotaOperadorGA);
            }

            if (siiDetalleDeclaracionSug.getSiiCuotaOperador().getSiiConceptoCuota().getCcuCodigo() ==
                EnumConceptoCuota.DERECHOS_DE_EXPLOTACION.getId()) {

                siiCuotaOperadorDE = cuotaOperadorDao.buscarCuotaOperadorPorId(siiDetalleDeclaracionSug.getSiiCuotaOperador().getCopCodigo());
                //Se pone en estado Activo ls cuota que el operador seleccionó para pago
                siiCuotaOperadorDE.setCopCancelada("A");
                cuotaOperadorDao.actualizarCuotaOperador(siiCuotaOperadorDE);
            }

        }


        /*
        * Por cada referencia de pago almacena el detalle declaracion asociado a la declaracion y al
        * numero de referencia de pago con la siguiente informacion
         */
        SiiDetalleDeclaracion siiDetalleDeclaracionDE = new SiiDetalleDeclaracion();
        SiiDetalleDeclaracion siiDetalleDeclaracionGA = new SiiDetalleDeclaracion();

        siiDetalleDeclaracionDE.setSiiReferenciaPagoDecl(siiReferenciaPagoDeclDE);
        siiDetalleDeclaracionDE.setSiiDeclaracionOperador(siiDeclaracionOperador);
        siiDetalleDeclaracionDE.setDdeValorDeclarado(declaracionOperadorWSVO.derechosDeExplotacion);
        siiDetalleDeclaracionDE.setDdeValorInter(declaracionOperadorWSVO.interesesMoraDE);
        siiDetalleDeclaracionDE.setSiiCuotaOperador(siiCuotaOperadorDE);

        siiDetalleDeclaracionGA.setSiiReferenciaPagoDecl(siiReferenciaPagoDeclGA);
        siiDetalleDeclaracionGA.setSiiDeclaracionOperador(siiDeclaracionOperador);
        siiDetalleDeclaracionGA.setDdeValorDeclarado(declaracionOperadorWSVO.gastosAdministracion);
        siiDetalleDeclaracionGA.setDdeValorInter(declaracionOperadorWSVO.interesesMoraGA);
        siiDetalleDeclaracionGA.setSiiCuotaOperador(siiCuotaOperadorGA);

        //Por Gatopardo:
        //Traza del contenido de las entidades
        try {
            if (siiDetalleDeclaracionDE.getSiiReferenciaPagoDecl() != null) {
                System.out.println("Ref pago DE: " + siiDetalleDeclaracionDE.getSiiReferenciaPagoDecl().getRpdCodigo());
            }
            if (siiDetalleDeclaracionDE.getSiiDeclaracionOperador() != null) {
                System.out.println("Declarac operador DE: " +
                                   siiDetalleDeclaracionDE.getSiiDeclaracionOperador().getDopCodigo());
            }
            if (siiDetalleDeclaracionDE.getSiiCuotaOperador() != null) {
                System.out.println("Cuota Operador DE: " +
                                   siiDetalleDeclaracionDE.getSiiCuotaOperador().getCopCodigo());
            }

            if (siiDetalleDeclaracionGA.getSiiReferenciaPagoDecl() != null) {
                System.out.println("Ref pago GA: " + siiDetalleDeclaracionDE.getSiiReferenciaPagoDecl().getRpdCodigo());
            }
            if (siiDetalleDeclaracionGA.getSiiDeclaracionOperador() != null) {
                System.out.println("Declarac operador GA: " +
                                   siiDetalleDeclaracionDE.getSiiDeclaracionOperador().getDopCodigo());
            }
            if (siiDetalleDeclaracionGA.getSiiCuotaOperador() != null) {
                System.out.println("Cuota Operador GA: " +
                                   siiDetalleDeclaracionDE.getSiiCuotaOperador().getCopCodigo());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        detalleDeclaracionDao.insertarDetalleDeclaracion(siiDetalleDeclaracionDE);
        detalleDeclaracionDao.insertarDetalleDeclaracion(siiDetalleDeclaracionGA);


        resultado = siiDeclaracionOperador.getDopCodigo() + " Proceso Exitoso";
        
        return resultado;
    }

    /**        
     *Metodo encargado de hacer el registro en la base de datos de la informacion de la declaracion del operador que
     * llega por medio del web services
     * @author David Tafur
     * @return
     */
    public String cargarDeclaracionOperador(DeclaracionOperadorWSVO declaracionOperadorWSVO) throws ExcepcionDAO {

        String resultado = "";
        Calendar calendar = Calendar.getInstance();
        /*
        * Consultamos el registro de la declaracion sugerida por el numero de declaracion para hacer la
        * respectiva asociacion con la declaracion del operador
        */
        SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();
        siiDeclaracionSugerida = declaracionSugeridaDao.consultarDeclaracionSugeridaPorConsecutivo(declaracionOperadorWSVO.numeroDeclaracion);

        /*
         * Una vez tenemos la declaracion sugerida entonces vamos a hacer el registro de la declaracion del operador
        */

        SiiDeclaracionOperador siiDeclaracionOperador = new SiiDeclaracionOperador();
        siiDeclaracionOperador.setDopFecha(calendar.getTime());
        siiDeclaracionOperador.setDopTipo("D");
        siiDeclaracionOperador.setSiiDeclaracionSugerida(siiDeclaracionSugerida);

        //Registramos la declaracion del operador
        declaracionOperadorDao.insertar(siiDeclaracionOperador);

        /*
        * Almacenamos los numeros de referencia que recibimmos
         */

        SiiReferenciaPagoDecl siiReferenciaPagoDeclDE = new SiiReferenciaPagoDecl();
        SiiReferenciaPagoDecl siiReferenciaPagoDeclGA = new SiiReferenciaPagoDecl();
        siiReferenciaPagoDeclDE.setRpdNumero(declaracionOperadorWSVO.referenciaPagoDE);
        siiReferenciaPagoDeclGA.setRpdNumero(declaracionOperadorWSVO.referenciaPagoGA);

        //Registramos los numeros de referencia
        referenciaPagoDeclDao.insertarReferenciaPagoDecl(siiReferenciaPagoDeclDE);
        referenciaPagoDeclDao.insertarReferenciaPagoDecl(siiReferenciaPagoDeclGA);

        /*
    * Se realiza la busqueda de los detalle declaracion sug (SiiDetalleDeclaracionSug) para esa
    * declaracion sugerida para saber cual es la cuota DE y GA que declaro el operador, de esta forma la tenemos
    * para poderla relacionar con el detalle
    */
        List<SiiDetalleDeclaracionSug> listaDetallesDeclaracionSug = new ArrayList<SiiDetalleDeclaracionSug>();
        listaDetallesDeclaracionSug =
            detalleDeclaracionSugDao.consultarListaDetalleDeclaracionSugPorCodigoDecSug(siiDeclaracionSugerida.getDsuCodigo());

        /*
    * Recorremos la lista para saber cual es la cuota DE y GA
    */
        SiiCuotaOperador siiCuotaOperadorDE = new SiiCuotaOperador();
        SiiCuotaOperador siiCuotaOperadorGA = new SiiCuotaOperador();
        for (SiiDetalleDeclaracionSug siiDetalleDeclaracionSug : listaDetallesDeclaracionSug) {

            if (siiDetalleDeclaracionSug.getSiiCuotaOperador().getSiiConceptoCuota().getCcuCodigo() ==
                EnumConceptoCuota.GASTOS_DE_ADMINISTRACION.getId()) {
                siiCuotaOperadorGA = cuotaOperadorDao.buscarCuotaOperadorPorId(siiDetalleDeclaracionSug.getSiiCuotaOperador().getCopCodigo());
            }

            if (siiDetalleDeclaracionSug.getSiiCuotaOperador().getSiiConceptoCuota().getCcuCodigo() ==
                EnumConceptoCuota.DERECHOS_DE_EXPLOTACION.getId()) {

                siiCuotaOperadorDE = cuotaOperadorDao.buscarCuotaOperadorPorId(siiDetalleDeclaracionSug.getSiiCuotaOperador().getCopCodigo());
            }

        }


        /*
        * Por cada referencia de pago almacena el detalle declaracion asociado a la declaracion y al
        * numero de referencia de pago con la siguiente informacion
         */
        SiiDetalleDeclaracion siiDetalleDeclaracionDE = new SiiDetalleDeclaracion();
        SiiDetalleDeclaracion siiDetalleDeclaracionGA = new SiiDetalleDeclaracion();

        siiDetalleDeclaracionDE.setSiiReferenciaPagoDecl(siiReferenciaPagoDeclDE);
        siiDetalleDeclaracionDE.setSiiDeclaracionOperador(siiDeclaracionOperador);
        siiDetalleDeclaracionDE.setDdeValorDeclarado(declaracionOperadorWSVO.derechosDeExplotacion);
        siiDetalleDeclaracionDE.setDdeValorInter(declaracionOperadorWSVO.interesesMoraDE);
        siiDetalleDeclaracionDE.setSiiCuotaOperador(siiCuotaOperadorDE);

        siiDetalleDeclaracionGA.setSiiReferenciaPagoDecl(siiReferenciaPagoDeclGA);
        siiDetalleDeclaracionGA.setSiiDeclaracionOperador(siiDeclaracionOperador);
        siiDetalleDeclaracionGA.setDdeValorDeclarado(declaracionOperadorWSVO.gastosAdministracion);
        siiDetalleDeclaracionGA.setDdeValorInter(declaracionOperadorWSVO.interesesMoraGA);
        siiDetalleDeclaracionGA.setSiiCuotaOperador(siiCuotaOperadorGA);

        //Por Gatopardo:
        //Traza del contenido de las entidades
        try {
            if (siiDetalleDeclaracionDE.getSiiReferenciaPagoDecl() != null) {
                System.out.println("Ref pago DE: " + siiDetalleDeclaracionDE.getSiiReferenciaPagoDecl().getRpdCodigo());
            }
            if (siiDetalleDeclaracionDE.getSiiDeclaracionOperador() != null) {
                System.out.println("Declarac operador DE: " +
                                   siiDetalleDeclaracionDE.getSiiDeclaracionOperador().getDopCodigo());
            }
            if (siiDetalleDeclaracionDE.getSiiCuotaOperador() != null) {
                System.out.println("Cuota Operador DE: " +
                                   siiDetalleDeclaracionDE.getSiiCuotaOperador().getCopCodigo());
            }

            if (siiDetalleDeclaracionGA.getSiiReferenciaPagoDecl() != null) {
                System.out.println("Ref pago GA: " + siiDetalleDeclaracionDE.getSiiReferenciaPagoDecl().getRpdCodigo());
            }
            if (siiDetalleDeclaracionGA.getSiiDeclaracionOperador() != null) {
                System.out.println("Declarac operador GA: " +
                                   siiDetalleDeclaracionDE.getSiiDeclaracionOperador().getDopCodigo());
            }
            if (siiDetalleDeclaracionGA.getSiiCuotaOperador() != null) {
                System.out.println("Cuota Operador GA: " +
                                   siiDetalleDeclaracionDE.getSiiCuotaOperador().getCopCodigo());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        detalleDeclaracionDao.insertarDetalleDeclaracion(siiDetalleDeclaracionDE);
        detalleDeclaracionDao.insertarDetalleDeclaracion(siiDetalleDeclaracionGA);


        resultado = siiDeclaracionOperador.getDopCodigo() + " Proceso Exitoso";
        return resultado;
    }

    /**
     *Metodo encargado de hacer el registro en la base de datos de la informacion de la declaracion del operador para otros conceptos
     * llega por medio del web services
     * @author David Tafur
     * @return
     */
    public String cargarLiquidacionOtrosConceptos(LiquidacionOtrosConceptosWSVO liquidacionOtrosConceptosWSVO) throws ExcepcionDAO, ExcepcionAplicacion {

        String resultado = "";
        Calendar calendar = Calendar.getInstance();
        /*
        * Consultamos el registro de la declaracion sugerida por el numero de declaracion para hacer la
        * respectiva asociacion con la declaracion del operador
        */
        SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();
        siiDeclaracionSugerida = declaracionSugeridaDao.consultarDeclaracionSugeridaPorConsecutivo(liquidacionOtrosConceptosWSVO.numeroLiquidacion.intValue());

        /*
         * Una vez tenemos la declaracion sugerida entonces vamos a hacer el registro de la declaracion del operador
        */

        SiiDeclaracionOperador siiDeclaracionOperador = new SiiDeclaracionOperador();
        siiDeclaracionOperador.setDopFecha(calendar.getTime());
        siiDeclaracionOperador.setDopTipo("L");
        siiDeclaracionOperador.setSiiDeclaracionSugerida(siiDeclaracionSugerida);

        //Registramos la declaracion del operador
        declaracionOperadorDao.insertar(siiDeclaracionOperador);

        /*
        * Almacenamos los numeros de referencia que recibimmos
         */

        SiiReferenciaPagoDecl siiReferenciaPagoDeclDE = new SiiReferenciaPagoDecl();
        SiiReferenciaPagoDecl siiReferenciaPagoDeclGA = new SiiReferenciaPagoDecl();
        siiReferenciaPagoDeclDE.setRpdNumero(liquidacionOtrosConceptosWSVO.referenciaPagoDE);
        siiReferenciaPagoDeclGA.setRpdNumero(liquidacionOtrosConceptosWSVO.referenciaPagoGA);

        //Registramos los numeros de referencia
        referenciaPagoDeclDao.insertarReferenciaPagoDecl(siiReferenciaPagoDeclDE);
        referenciaPagoDeclDao.insertarReferenciaPagoDecl(siiReferenciaPagoDeclGA);

        /*
        * Creamos esta lista para almacenar los codigos de las cuotas que ya han sido registradas, dado que en
        * estado de cuenta los intereses se separan en un nuevo concepto para la presentacion de la informacion
        * no es necesario registrar dos veces (una para el valor y otra para el interes) si no que solo se guarda
        * un registro con el id de la sii_cuota_operador la cual tendra ambos valores.
        */

        List<Long> listaCodigoCuotasGuardados = new ArrayList<Long>();
        List<SiiDetalleDeclaracion> siiDetalleDeclaracions = new ArrayList<SiiDetalleDeclaracion>();

        System.out.println("Se empieza a revisar las cuotas y sus conceptos");
        for (CuotaOperadorWSVO cuotaOperadorWSVO : liquidacionOtrosConceptosWSVO.listaCuotaOperadorWSVO) {

            for (ConceptoCuotaWSVO conceptoCuotaWSVO : cuotaOperadorWSVO.listaConceptosCuota) {

                //Comprobamos si ese numero de sii_cuota_operador ya se encuentra registrado para este llamado
                //al web services
                boolean yaEstaRegistrada = false;
                for (Long codigoCuota : listaCodigoCuotasGuardados) {
                    if (codigoCuota.equals(conceptoCuotaWSVO.codigoCuota)) {
                        yaEstaRegistrada = true;
                        break;
                    }
                }

                if (!yaEstaRegistrada) {
                    System.out.println("Busqueda cuota numero" + conceptoCuotaWSVO.codigoCuota);
                    System.out.println("Trae valores por ws de" + conceptoCuotaWSVO.valor +
                                       conceptoCuotaWSVO.valorInteres);
                    /*
                        * Buscamos la cuota del operador para el detalle de la declaracion
                        */
                    SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
                    CuotaOperadorVO cuotVO = new CuotaOperadorVO();
                    cuotVO.setCopCodigo(conceptoCuotaWSVO.codigoCuota);
                    siiCuotaOperador = cuotaOperadorDao.buscarCuotaOperadorPorId(cuotVO);

                    /*
                        * Por cada referencia de pago almacena el detalle declaracion asociado a la declaracion y al
                        * numero de referencia de pago con la siguiente informacion
                        */
                    SiiDetalleDeclaracion siiDetalleDeclaracion = new SiiDetalleDeclaracion();                    
                    //if (conceptoCuotaWSVO.nombreConcepto.equals("INTERESES DE MORA ACUERDOS DE PAGO GASTOS DE ADMINISTRACIÓN")) {
                    if (conceptoCuotaWSVO.destinoCuota != null){
                        if (conceptoCuotaWSVO.destinoCuota.equals("CJ")){
                            siiDetalleDeclaracion.setSiiReferenciaPagoDecl(siiReferenciaPagoDeclGA);
                        } else {
                            siiDetalleDeclaracion.setSiiReferenciaPagoDecl(siiReferenciaPagoDeclDE);
                        }
                    }

                    siiDetalleDeclaracion.setSiiDeclaracionOperador(siiDeclaracionOperador);                    
                    if (conceptoCuotaWSVO.valor != null && conceptoCuotaWSVO.valor.doubleValue() > 0D) {
                            siiDetalleDeclaracion.setDdeValorDeclarado(conceptoCuotaWSVO.valor);
                    } else {
                            siiDetalleDeclaracion.setDdeValorDeclarado(new BigDecimal("0"));
                    }
                                        
                    if (conceptoCuotaWSVO.valorInteres != null && conceptoCuotaWSVO.valorInteres.doubleValue() > 0D) {
                            siiDetalleDeclaracion.setDdeValorInter(conceptoCuotaWSVO.valorInteres);
                    } else {
                            siiDetalleDeclaracion.setDdeValorInter(new BigDecimal("0"));
                    }
                    
                    siiDetalleDeclaracion.setSiiCuotaOperador(siiCuotaOperador);

                    detalleDeclaracionDao.insertarDetalleDeclaracion(siiDetalleDeclaracion);
                    siiDetalleDeclaracions.add(siiDetalleDeclaracion);

                    listaCodigoCuotasGuardados.add(conceptoCuotaWSVO.codigoCuota);
                }

            }

            /*
             * Verificamos los conceptos con condicion de interes de mora y actualizacmos los detalles declaraciones
             */
            for (ConceptoCuotaWSVO conceptoCuotaWSVO : cuotaOperadorWSVO.listaConceptosCuota) {
                if (conceptoCuotaWSVO.nombreConcepto.contains("INTERESES DE MORA")) {

                    Long codigoDetDeclaracion = null;
                    for (SiiDetalleDeclaracion siiDetalleDeclaracion : siiDetalleDeclaracions) {
                        if (siiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo().equals(conceptoCuotaWSVO.codigoCuota)) {
                            codigoDetDeclaracion = siiDetalleDeclaracion.getDdeCodigo();
                            break;
                        }
                    }

                    SiiDetalleDeclaracion siiDetalleDeclaracion = null;
                    siiDetalleDeclaracion =
                        detalleDeclaracionDao.buscarPorCodigoDetalleDeclaracion(codigoDetDeclaracion);

                    siiDetalleDeclaracion.setDdeValorInter(conceptoCuotaWSVO.valorInteres);
                    detalleDeclaracionDao.actualizarDetalleDeclaracion(siiDetalleDeclaracion);
                }
            }
        }

        resultado = siiDeclaracionOperador.getDopCodigo() + " Proceso Exitoso";
        return resultado;
    }

    /**
     *Metodo encargado de hacer la insercion del detalle de la declaracion sugerida
     * @author David Tafur
     * @param siiDetalleDeclaracionSug
     * @throws ExcepcionDAO
     */
    public void insertarDetalleDeclaracionSug(DetalleDeclaracionSugVO detalleDeclaracionSugVo) throws ExcepcionDAO {
        SiiDetalleDeclaracionSug siiDetalleDeclaracionSug = conversionVoEntidad.convertir(detalleDeclaracionSugVo);
        detalleDeclaracionSugDao.insertar(siiDetalleDeclaracionSug);
    }

    /**
     *Metodo encargado de hacer la busqueda del listado de detalle declaracion sugerida para una declaracion sugerida
     * @author David Tafur
     * @param codigoDeclaracionSugerida
     * @return
     * @throws ExcepcionDAO
     */
    public List<DetalleDeclaracionSugVO> consultarListaDetalleDeclaracionSugPorCodigoDecSug(long codigoDeclaracionSugerida) throws ExcepcionDAO {
        List<DetalleDeclaracionSugVO> listaDetalleDeclaracionSugVo = null;
        List<SiiDetalleDeclaracionSug> listaDetalleDeclaracionSug = detalleDeclaracionSugDao.consultarListaDetalleDeclaracionSugPorCodigoDecSug(codigoDeclaracionSugerida);
        if(listaDetalleDeclaracionSug != null && listaDetalleDeclaracionSug.size() > 0){
            listaDetalleDeclaracionSugVo = new ArrayList<>();
            for(SiiDetalleDeclaracionSug siiDetalleDeclaracionSug : listaDetalleDeclaracionSug){
                listaDetalleDeclaracionSugVo.add(new DetalleDeclaracionSugVO(siiDetalleDeclaracionSug));
            }
        }
        return listaDetalleDeclaracionSugVo;
    }

    /**
     *Metodo encargado de hacer la actualizacion del detalle de la declaracion sugerida
     * @author David Tafur
     * @param siiDetalleDeclaracionSug
     * @throws ExcepcionDAO
     */
    public void actualizarSiiDetalleDeclaracionSug(DetalleDeclaracionSugVO detalleDeclaracionSugVo) throws ExcepcionDAO {
        SiiDetalleDeclaracionSug siiDetalleDeclaracionSug = conversionVoEntidad.convertir(detalleDeclaracionSugVo);
        detalleDeclaracionSugDao.actualizar(siiDetalleDeclaracionSug);
    }

    /**
     *Metodo encargado de devolver el 30 porcierto de maquinas que el operador debe marcar online
     * @author David Tafur
     * @return
     */
    public List<InventarioMarcarMetVO> mostrarTreintaPorcientoMaquinasPorOperadorSinMarcar(String opcionSeleccionada) throws ExcepcionDAO {
        List<InventarioMarcarMetVO> listaInventarioMarcarTotal = new ArrayList<InventarioMarcarMetVO>();


        if (opcionSeleccionada.equals("1")) {

            /*
             * Se consulta el listado de todos los oepradores
             */
            List<SiiOperador> listaOperadores = new ArrayList<SiiOperador>();
            listaOperadores = operadorDao.buscarOperadoresNoMarcaMetLinea("A");

            /*
             * Por cada uno de los operadores buscamos su inventario y cogemos el 30%
             */
            for (SiiOperador siiOperador : listaOperadores) {
                List<InventarioMarcarMetVO> listaInventarioParaOpe = new ArrayList<InventarioMarcarMetVO>();
                listaInventarioParaOpe =
                    inventarioDao.consultarInventarioOperadoresNoMarcaOnline(siiOperador.getOpeCodigo());

                /*
            * Se calcula el 30%
            */
                int totalRegistros = listaInventarioParaOpe.size();
                int treintaPorcientoRegistros = (totalRegistros * 30) / 100;
                int treintaPorcientoRegistrosRedondeado =
                    (new BigDecimal(treintaPorcientoRegistros).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();

                /*
                 * Agregamos a la lista a devolver el 30% para ese operador
                 */
                int cont = 1;
                for (InventarioMarcarMetVO inventarioMarcarMetVO : listaInventarioParaOpe) {
                    if (cont <= treintaPorcientoRegistrosRedondeado) {
                        /*
                         * Actualizamos la met*/



                        SiiMet siiMet = new SiiMet();
                        siiMet = metDao.buscarPorCodigoMet(inventarioMarcarMetVO.getMetCodigo());
                        siiMet.setMetCodigo(inventarioMarcarMetVO.getMetCodigo());
                        siiMet.setMetOnline("S");
                        siiMet.setMetFase(Integer.parseInt(opcionSeleccionada));
                        siiMet.setMetReporteOpe("N");
                        metDao.actualizarSiiMet(siiMet);

                        listaInventarioMarcarTotal.add(inventarioMarcarMetVO);
                        cont++;
                    } else {
                        break;
                    }

                }
            }

        } else if (opcionSeleccionada.equals("2")) {

            /*
             * Se consulta el listado de todos los oepradores
             */
            List<SiiOperador> listaOperadores = new ArrayList<SiiOperador>();
            listaOperadores = operadorDao.buscarOperadoresNoMarcaMetLinea("B");

            /*
             * Por cada uno de los operadores buscamos su inventario y cogemos el 30%
             */
            for (SiiOperador siiOperador : listaOperadores) {
                List<InventarioMarcarMetVO> listaInventarioParaOpe = new ArrayList<InventarioMarcarMetVO>();
                listaInventarioParaOpe =
                    inventarioDao.consultarInventarioOperadoresNoMarcaOnline(siiOperador.getOpeCodigo());

                /*
            * Se calcula el 30%
            */
                int totalRegistros = listaInventarioParaOpe.size();
                int treintaPorcientoRegistros = (totalRegistros * 30) / 100;
                int treintaPorcientoRegistrosRedondeado =
                    (new BigDecimal(treintaPorcientoRegistros).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();

                /*
                 * Agregamos a la lista a devolver el 30% para ese operador
                 */
                int cont = 1;
                for (InventarioMarcarMetVO inventarioMarcarMetVO : listaInventarioParaOpe) {
                    if (cont <= treintaPorcientoRegistrosRedondeado) {
                        /*
                         * Actualizamos la met*/



                        SiiMet siiMet = new SiiMet();
                        siiMet = metDao.buscarPorCodigoMet(inventarioMarcarMetVO.getMetCodigo());
                        siiMet.setMetCodigo(inventarioMarcarMetVO.getMetCodigo());
                        siiMet.setMetOnline("S");
                        siiMet.setMetFase(Integer.parseInt(opcionSeleccionada) - 1);
                        siiMet.setMetReporteOpe("N");
                        metDao.actualizarSiiMet(siiMet);
                        listaInventarioMarcarTotal.add(inventarioMarcarMetVO);
                        cont++;
                    } else {
                        break;
                    }

                }
            }

        } else if (opcionSeleccionada.equals("3")) {
            /*
             * Se consulta el listado de todos los oepradores
             */
            List<SiiOperador> listaOperadores = new ArrayList<SiiOperador>();
            listaOperadores = operadorDao.buscarOperadoresNoMarcaMetLinea("A");

            /*
             * Por cada uno de los operadores buscamos su inventario y cogemos el 60%
             */
            for (SiiOperador siiOperador : listaOperadores) {
                List<InventarioMarcarMetVO> listaInventarioParaOpe = new ArrayList<InventarioMarcarMetVO>();
                listaInventarioParaOpe =
                    inventarioDao.consultarInventarioOperadoresNoMarcaOnline(siiOperador.getOpeCodigo());

                /*
            * Se calcula el 60%
            */
                int totalRegistros = listaInventarioParaOpe.size();
                int treintaPorcientoRegistros = (totalRegistros * 60) / 100;
                int treintaPorcientoRegistrosRedondeado =
                    (new BigDecimal(treintaPorcientoRegistros).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();

                /*
                 * Agregamos a la lista a devolver el 60% para ese operador
                 */
                int cont = 1;
                for (InventarioMarcarMetVO inventarioMarcarMetVO : listaInventarioParaOpe) {
                    if (cont <= treintaPorcientoRegistrosRedondeado) {
                        /*
                         * Actualizamos la met
                        */
                        SiiMet siiMet = new SiiMet();
                        siiMet = metDao.buscarPorCodigoMet(inventarioMarcarMetVO.getMetCodigo());
                        siiMet.setMetCodigo(inventarioMarcarMetVO.getMetCodigo());
                        siiMet.setMetOnline("S");
                        siiMet.setMetFase(Integer.parseInt(opcionSeleccionada) - 1);
                        siiMet.setMetReporteOpe("N");
                        metDao.actualizarSiiMet(siiMet);

                        listaInventarioMarcarTotal.add(inventarioMarcarMetVO);
                        cont++;
                    } else {
                        break;
                    }

                }
            }
        } else if (opcionSeleccionada.equals("4")) {
            /*
             * Se consulta el listado de todos los oepradores
             */
            List<SiiOperador> listaOperadores = new ArrayList<SiiOperador>();
            listaOperadores = operadorDao.buscarOperadoresNoMarcaMetLinea("B");

            /*
             * Por cada uno de los operadores buscamos su inventario y cogemos el 60%
             */
            for (SiiOperador siiOperador : listaOperadores) {
                List<InventarioMarcarMetVO> listaInventarioParaOpe = new ArrayList<InventarioMarcarMetVO>();
                listaInventarioParaOpe =
                    inventarioDao.consultarInventarioOperadoresNoMarcaOnline(siiOperador.getOpeCodigo());

                /*
            * Se calcula el 60%
            */
                int totalRegistros = listaInventarioParaOpe.size();
                int treintaPorcientoRegistros = (totalRegistros * 60) / 100;
                int treintaPorcientoRegistrosRedondeado =
                    (new BigDecimal(treintaPorcientoRegistros).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();

                /*
                 * Agregamos a la lista a devolver el 60% para ese operador
                 */
                int cont = 1;
                for (InventarioMarcarMetVO inventarioMarcarMetVO : listaInventarioParaOpe) {
                    if (cont <= treintaPorcientoRegistrosRedondeado) {
                        /*
                         * Actualizamos la met*/



                        SiiMet siiMet = new SiiMet();
                        siiMet = metDao.buscarPorCodigoMet(inventarioMarcarMetVO.getMetCodigo());
                        siiMet.setMetCodigo(inventarioMarcarMetVO.getMetCodigo());
                        siiMet.setMetOnline("S");
                        siiMet.setMetFase(Integer.parseInt(opcionSeleccionada) - 2);
                        siiMet.setMetReporteOpe("N");
                        metDao.actualizarSiiMet(siiMet);

                        listaInventarioMarcarTotal.add(inventarioMarcarMetVO);
                        cont++;
                    } else {
                        break;
                    }

                }
            }
        }


        return listaInventarioMarcarTotal;
    }
    
    //Cuando se usa PersonaWSVO para enviar datos de persona jurídica
    //la razón social va en el campo personaWsVo.primerNombre
    public SiiPersona copiarPersonaWsVoASiiPersona(PersonaWSVO personaWsVo, SiiPersona siiPersonaDestino) throws ExcepcionDAO{
        siiPersonaDestino.setPerPrimerNombre(personaWsVo.primerNombre);
        siiPersonaDestino.setPerSegundoNombre(personaWsVo.segundoNombre);
        siiPersonaDestino.setPerPrimerApellido(personaWsVo.primerApellido);
        siiPersonaDestino.setPerSegundoApellido(personaWsVo.segundoApellido);
        SiiTipoIdentificacion siiTipoIdentificacion = tipoIdentificacionDao.buscarTipoIdentificacionPorId(new Long(personaWsVo.tipoIdentificacion));
        siiPersonaDestino.setSiiTipoIdentificacion1(siiTipoIdentificacion);
        siiPersonaDestino.setPerNumIdentificacion(personaWsVo.numIdentificacion);
        
        if(personaWsVo.direccion != null && !personaWsVo.direccion.equals("")){
            siiPersonaDestino.setPerDireccion(personaWsVo.direccion);
        }
        if(personaWsVo.telefono != null && !personaWsVo.telefono.equals("")){
            siiPersonaDestino.setPerTelefono(personaWsVo.telefono);
        }
        if(personaWsVo.telefono2 != null && !personaWsVo.telefono2.equals("")){
            siiPersonaDestino.setPerTelefono2(personaWsVo.telefono2);
        }
        if(personaWsVo.correoElectronico != null && !personaWsVo.correoElectronico.equals("")){
            siiPersonaDestino.setPerEmail(personaWsVo.correoElectronico);
        }
        if(personaWsVo.codMunicipioDane != null && !personaWsVo.codMunicipioDane.equals("")){
            SiiUbicacion siiUbicacion = ubicacionDao.buscarUbicacionPorId(personaWsVo.codMunicipioDane);
            siiPersonaDestino.setSiiUbicacion1(siiUbicacion);
        }
        
        if(siiPersonaDestino.getPerTipoPersona() == null){ //Si es un registro nuevo se modifica, sino no se toca
            siiPersonaDestino.setPerTipoPersona(personaWsVo.perTipoPersona);
        }
        if(personaWsVo.tipoIdentificacion == EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId()
                || personaWsVo.perTipoPersona.equals("J")){
            siiPersonaDestino.setPerJurNombreLargo(personaWsVo.primerNombre);
            siiPersonaDestino.setPerPrimerNombre(null);
            siiPersonaDestino.setPerSegundoNombre(null);
            siiPersonaDestino.setPerPrimerApellido(null);
            siiPersonaDestino.setPerSegundoApellido(null);
        }
        siiPersonaDestino.setPerDigitoVerif(personaWsVo.perDigitoVerif);
        siiPersonaDestino.setPerCelular(personaWsVo.perCelular);
        siiPersonaDestino.setPerTarjetaPro(personaWsVo.numTarjetaProfesional);
        
        return siiPersonaDestino;
    }
    
    /**
     *Metodo encargado de hacer el registro en la base de datos de la informacion de la declaracion del operador para otros conceptos
     * llega por medio del web services
     * @author David Tafur
     * @return
     */
    public String cargarLiquidacionMultasSanciones(LiquidacionOtrosConceptosWSVO liquidacionMultasSancionesWsVo) throws ExcepcionAplicacion, ExcepcionDAO {

        String resultado = "";
        
        try{
            
            Calendar calendar = Calendar.getInstance();
            /*
            * Consultamos el registro de la declaracion sugerida por el numero de declaracion para hacer la
            * respectiva asociacion con la declaracion del operador
            */
            SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();
            siiDeclaracionSugerida = declaracionSugeridaDao.consultarDeclaracionSugeridaPorConsecutivo(liquidacionMultasSancionesWsVo.numeroLiquidacion.intValue());
    
            /*
             * Una vez tenemos la declaracion sugerida entonces vamos a hacer el registro de la declaracion del operador
            */
    
            SiiDeclaracionOperador siiDeclaracionOperador = new SiiDeclaracionOperador();
            siiDeclaracionOperador.setDopFecha(calendar.getTime());
            siiDeclaracionOperador.setDopTipo("L");
            siiDeclaracionOperador.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
    
            //Registramos la declaracion del operador
            declaracionOperadorDao.insertar(siiDeclaracionOperador);
    
            /*
            * Almacenamos los numeros de referencia que recibimmos
             */
    
            SiiReferenciaPagoDecl siiReferenciaPagoDeclDE = null;
            SiiReferenciaPagoDecl siiReferenciaPagoDeclGA = null;
            
            if(liquidacionMultasSancionesWsVo.referenciaPagoDE == null && liquidacionMultasSancionesWsVo.referenciaPagoGA == null){
                throw new ExcepcionAplicacion("Referencia de Pago DE y GA no pueden ser nulos simultaneamente");
            }
            
            if(liquidacionMultasSancionesWsVo.referenciaPagoDE != null){
                siiReferenciaPagoDeclDE = new SiiReferenciaPagoDecl();
                siiReferenciaPagoDeclDE.setRpdNumero(liquidacionMultasSancionesWsVo.referenciaPagoDE);
                referenciaPagoDeclDao.insertarReferenciaPagoDecl(siiReferenciaPagoDeclDE);
            }
            
            if(liquidacionMultasSancionesWsVo.referenciaPagoGA != null){
                siiReferenciaPagoDeclGA = new SiiReferenciaPagoDecl();
                siiReferenciaPagoDeclGA.setRpdNumero(liquidacionMultasSancionesWsVo.referenciaPagoGA);
                referenciaPagoDeclDao.insertarReferenciaPagoDecl(siiReferenciaPagoDeclGA);
            }
    
            /*
            * Creamos esta lista para almacenar los codigos de las cuotas que ya han sido registradas, dado que en
            * estado de cuenta los intereses se separan en un nuevo concepto para la presentacion de la informacion
            * no es necesario registrar dos veces (una para el valor y otra para el interes) si no que solo se guarda
            * un registro con el id de la sii_cuota_operador la cual tendra ambos valores.
            */
    
            //List<Long> listaCodigoCuotasGuardados = new ArrayList<Long>();
            List<SiiDetalleDeclaracion> siiListaDetalleDeclaracion = new ArrayList<SiiDetalleDeclaracion>();
    
            System.out.println("Se empieza a revisar las cuotas y sus conceptos");
            for (CuotaOperadorWSVO cuotaOperadorWSVO : liquidacionMultasSancionesWsVo.listaCuotaOperadorWSVO) {
    
                for (ConceptoCuotaWSVO conceptoCuotaWSVO : cuotaOperadorWSVO.listaConceptosCuota) {

                    System.out.println("Busqueda cuota numero" + conceptoCuotaWSVO.codigoCuota);
                    System.out.println("Trae valores por ws de" + conceptoCuotaWSVO.valor +
                                       conceptoCuotaWSVO.valorInteres);
                    /*
                    * Buscamos la cuota del operador para el detalle de la declaracion
                    */
                    SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
                    CuotaOperadorVO cuotVO = new CuotaOperadorVO();
                    cuotVO.setCopCodigo(conceptoCuotaWSVO.codigoCuota);
                    siiCuotaOperador = cuotaOperadorDao.buscarCuotaOperadorPorId(cuotVO);
    
                    /*
                    * Por cada referencia de pago almacena el detalle declaracion asociado a la declaracion y al
                    * numero de referencia de pago con la siguiente informacion
                    */
                    SiiDetalleDeclaracion siiDetalleDeclaracion = new SiiDetalleDeclaracion();
    
                    siiDetalleDeclaracion.setSiiReferenciaPagoDecl(siiReferenciaPagoDeclDE == null? siiReferenciaPagoDeclDE : siiReferenciaPagoDeclGA);
    
                    siiDetalleDeclaracion.setSiiDeclaracionOperador(siiDeclaracionOperador);                    
                    if (conceptoCuotaWSVO.valor != null && conceptoCuotaWSVO.valor.doubleValue() > 0D) {
                        siiDetalleDeclaracion.setDdeValorDeclarado(conceptoCuotaWSVO.valor);
                    } else {
                        siiDetalleDeclaracion.setDdeValorDeclarado(BigDecimal.ZERO);
                    }
                                        
                    if (conceptoCuotaWSVO.valor != null && conceptoCuotaWSVO.valor.doubleValue() > 0D) {
                        siiDetalleDeclaracion.setDdeValorInter(conceptoCuotaWSVO.valorInteres);
                    } else {
                        siiDetalleDeclaracion.setDdeValorInter(BigDecimal.ZERO);
                    }
                    
                    siiDetalleDeclaracion.setSiiCuotaOperador(siiCuotaOperador);
    
                    detalleDeclaracionDao.insertarDetalleDeclaracion(siiDetalleDeclaracion);
                    siiListaDetalleDeclaracion.add(siiDetalleDeclaracion);
    
                }
            }
            resultado = siiDeclaracionOperador.getDopCodigo() + " Proceso Exitoso";
        } catch(ExcepcionAplicacion | ExcepcionDAO ex){
            throw ex;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new ExcepcionAplicacion("Excepcion general: " + ex.getMessage());
        }
        return resultado;
    }

    /*
    public static  List<EstadoCuentaVO> generarDeclaracionMultasSanciones(LiquidacionOtrosConceptosWSVO liquidacionOtrosConceptosWSVO, Double ValorAPagar) {
        liquidacionOtrosConceptosWSVO.
            for(CuotaOperadorWSVO cuotaOperadorWSVO :liquidacionOtrosConceptosWSVO.listaCuotaOperadorWSVO){
                cuotaOperadorWSVO.
            }
    }
    */
}
