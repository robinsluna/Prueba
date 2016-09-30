/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Utilidades EJB
 * AUTOR	: Diego Alvarado
 * FECHA	: 26-12-2013
 */
package co.gov.coljuegos.siicol.ejb.util;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSociedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.InstrumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.MarcaVO;
import co.gov.coljuegos.siicol.ejb.vo.MetVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.OperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoIdentificacionVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoInstrumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoNovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoSociedadVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoSolicAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoUbicacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.InstrumentoWSVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.InventarioWSVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.MetWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ContratoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.DetalleFinancieroWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.EstablecimientoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.MarcaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.NovedadWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.OperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.PersonaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.TipoApuestaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.TipoInstrumentoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.TipoNovedadWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.TipoUbicacionWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.TransladoAutomaticoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.UbicacionWSVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ConversionVOWS {
    
    @EJB
    private UbicacionDAO ubicacionDao;
    @EJB
    private TipoSociedadDAO tipoSociedadDao;
    @EJB
    private UsuarioDAO usuarioDao;

    public ConversionVOWS() {
    }

    public PersonaVO convertir(PersonaWSVO personaWsVo) {
        PersonaVO personaVoRetorno = null;
        if (personaWsVo != null) {
            personaVoRetorno = new PersonaVO();
            personaVoRetorno.setPerPrimerNombre(personaWsVo.primerNombre);
            personaVoRetorno.setPerSegundoNombre(personaWsVo.segundoNombre);
            personaVoRetorno.setPerPrimerApellido(personaWsVo.primerApellido);
            personaVoRetorno.setPerSegundoApellido(personaWsVo.segundoApellido);
            TipoIdentificacionVO tipoIdentificaRe = new TipoIdentificacionVO();
            tipoIdentificaRe.setTidCodigo(new Long(personaWsVo.tipoIdentificacion));
            personaVoRetorno.setTipoIdentificacionVo(tipoIdentificaRe);
            personaVoRetorno.setPerNumIdentificacion(personaWsVo.numIdentificacion);
            personaVoRetorno.setPerDireccion(personaWsVo.direccion);
            personaVoRetorno.setPerTelefono(personaWsVo.telefono);
            personaVoRetorno.setPerTelefono2(personaWsVo.telefono2);
            personaVoRetorno.setPerEmail(personaWsVo.correoElectronico);
            UbicacionVO ubicacionRl = new UbicacionVO();
            ubicacionRl.setUbiCodigo(personaWsVo.codMunicipioDane);
            personaVoRetorno.setUbicacionVo(ubicacionRl);
            personaVoRetorno.setPerTipoPersona(personaWsVo.perTipoPersona);
            personaVoRetorno.setPerDigitoVerif(personaWsVo.perDigitoVerif);
            personaVoRetorno.setPerCelular(personaWsVo.perCelular);
            personaVoRetorno.setPerNumTarjetaProfesional(personaWsVo.numTarjetaProfesional);
        }
        return personaVoRetorno;
    }

    public PersonaWSVO convertir(PersonaVO personaVo) {
        PersonaWSVO personaWsVoRetorno = null;
        if (personaVo != null) {
            personaWsVoRetorno = new PersonaWSVO();
            personaWsVoRetorno.primerNombre = personaVo.getPerPrimerNombre();
            if(personaVo.getTipoIdentificacionVo().getTidCodigo() == EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId()){
                personaWsVoRetorno.primerNombre = personaVo.getPerJurNombreLargo();
            }
            personaWsVoRetorno.segundoNombre = personaVo.getPerSegundoNombre();
            personaWsVoRetorno.primerApellido = personaVo.getPerPrimerApellido();
            personaWsVoRetorno.segundoApellido = personaVo.getPerSegundoApellido();
            int codigoTipoIdentificacion = personaVo.getTipoIdentificacionVo().getTidCodigo().intValue();
            personaWsVoRetorno.tipoIdentificacion = codigoTipoIdentificacion;
            personaWsVoRetorno.numIdentificacion = personaVo.getPerNumIdentificacion();
            personaWsVoRetorno.direccion = personaVo.getPerDireccion();
            personaWsVoRetorno.telefono = personaVo.getPerTelefono();
            personaWsVoRetorno.telefono2 = personaVo.getPerTelefono2();
            personaWsVoRetorno.correoElectronico = personaVo.getPerEmail();
            personaWsVoRetorno.numTarjetaProfesional = personaVo.getPerNumTarjetaProfesional();
            if (personaVo.getUbicacionVo() != null) {
                String ubicacion = personaVo.getUbicacionVo().getUbiCodigo();
                personaWsVoRetorno.codMunicipioDane = ubicacion;
            }
        }
        return personaWsVoRetorno;
    }

    public PersonaVO convertir(OperadorWSVO operadorWsVo) {
        PersonaVO personaVoRetorno = null;
        if (operadorWsVo != null) {
            personaVoRetorno = new PersonaVO();
            personaVoRetorno.setPerJurNombreLargo(operadorWsVo.razonSocial);
            personaVoRetorno.setPerNumIdentificacion(operadorWsVo.numIdentificacion);
            TipoIdentificacionVO tipoIdentificaOp = new TipoIdentificacionVO();
            tipoIdentificaOp.setTidCodigo(new Long(31));
            personaVoRetorno.setTipoIdentificacionVo(tipoIdentificaOp);
            personaVoRetorno.setPerDireccion(operadorWsVo.direccion);
            personaVoRetorno.setPerTelefono(operadorWsVo.telefono);
            personaVoRetorno.setPerTelefono2(operadorWsVo.telefono2);
            personaVoRetorno.setPerEmail(operadorWsVo.correoElectronico);
            UbicacionVO ubicacionRl = new UbicacionVO();
            ubicacionRl.setUbiCodigo(operadorWsVo.codMunicipioDane);
            personaVoRetorno.setUbicacionVo(ubicacionRl);
            personaVoRetorno.setPerTipoPersona("J");
            personaVoRetorno.setPerDigitoVerif(operadorWsVo.digitoVerificacion);
            TipoSociedadVO tipoSociedadVo = new TipoSociedadVO();
            tipoSociedadVo.setTsoCodigo(operadorWsVo.tipoSociedad);
            personaVoRetorno.setTipoSociedadVO(tipoSociedadVo);

        }
        return personaVoRetorno;
    }
    

    public OperadorVO convertiraOperadorVo(OperadorWSVO operadorWsVo) {
        OperadorVO operadorVoRetorno = null;
        if (operadorWsVo != null) {
            operadorVoRetorno = new OperadorVO();
            /* operadorVoRetorno.setContratoVoList(operadorWsVo.contratoVoList);
            operadorVoRetorno.setEstablecimientoVoList(operadorWsVo.establecimientoVoList);
            operadorVoRetorno.setInstrumentoVoList(operadorWsVo.instrumentoVoList); */
            //   operadorVoRetorno.setOpeCodigo(operadorWsVo.codigo);
            //operadorVoRetorno.setPersonaVo(this.convertir(operadorWsVo.personaVo));
        }
        return operadorVoRetorno;
    }

    public ContratoVO convertir(ContratoWSVO contratoWsVo) {
        ContratoVO contratoVoRetorno = null;
        if (contratoWsVo != null) {
            contratoVoRetorno = new ContratoVO();
            contratoVoRetorno.setConCodigo(contratoWsVo.conCodigo);
            contratoVoRetorno.setConConsecutivo(contratoWsVo.conConsecutivo);
            contratoVoRetorno.setConDescripcion(contratoWsVo.conDescripcion);
            contratoVoRetorno.setConFecha(contratoWsVo.conFecha);
            contratoVoRetorno.setConFechaFin(contratoWsVo.conFechaFin);
            contratoVoRetorno.setConNumero(contratoWsVo.conNumero);
            contratoVoRetorno.setConVigente(contratoWsVo.conVigente);
            //contratoVoRetorno.setEstadoContratoVo(contratoWsVo.estadoContratoVo);
            contratoVoRetorno.setOperadorVo(this.convertiraOperadorVo(contratoWsVo.operadorVo));
            //contratoVoRetorno.setPolizaContratLisVo(contratoWsVo.polizaContratLisVo);
            contratoVoRetorno.setValorCOntrato(contratoWsVo.valorContrato);
        }
        return contratoVoRetorno;
    }

    public ContratoWSVO convertir(ContratoVO contratoVo) {
        ContratoWSVO contratoWsVoRetorno = null;
        if (contratoVo != null) {
            contratoWsVoRetorno = new ContratoWSVO();
            contratoWsVoRetorno.conCodigo = contratoVo.getConCodigo();
            contratoWsVoRetorno.conConsecutivo = contratoVo.getConConsecutivo();
            contratoWsVoRetorno.conDescripcion = contratoVo.getConDescripcion();
            contratoWsVoRetorno.conFechaIni = contratoVo.getConFechaIni();
            contratoWsVoRetorno.conFechaFin = contratoVo.getConFechaFin();
            contratoWsVoRetorno.conNumero = contratoVo.getConNumero();
            contratoWsVoRetorno.conVigente = contratoVo.getConVigente();
            contratoWsVoRetorno.valorContrato = contratoVo.getValorCOntrato();
        }
        return contratoWsVoRetorno;
    }

    public OperadorWSVO convertirAOperadorWs(PersonaVO personaVo) {
        OperadorWSVO operadorWsVoRetorno = null;
        if (personaVo != null) {
            operadorWsVoRetorno = new OperadorWSVO();
            operadorWsVoRetorno.razonSocial = personaVo.getPerJurNombreLargo();
            operadorWsVoRetorno.numIdentificacion = personaVo.getPerNumIdentificacion();
            operadorWsVoRetorno.direccion = personaVo.getPerDireccion();
            operadorWsVoRetorno.telefono = personaVo.getPerTelefono();
            operadorWsVoRetorno.telefono2 = personaVo.getPerTelefono2();
            operadorWsVoRetorno.correoElectronico = personaVo.getPerEmail();
            operadorWsVoRetorno.digitoVerificacion = personaVo.getPerDigitoVerif();
            if (personaVo.getUbicacionVo() != null) {
                String ubicacion = personaVo.getUbicacionVo().getUbiCodigo();
                operadorWsVoRetorno.codMunicipioDane = ubicacion;
            }
            if (personaVo.getTipoSociedadVO() != null) {
                operadorWsVoRetorno.tipoSociedad = personaVo.getTipoSociedadVO().getTsoCodigo();
            }
            //     operadorWsVoRetorno.codigo = personaVo.getPerCodigo();
        }
        return operadorWsVoRetorno;
    }

    public DetalleFinancVO convertir(DetalleFinancieroWSVO detalleFinancieroWSVO) {
        DetalleFinancVO detalleFinVO = new DetalleFinancVO();

        detalleFinVO.setDfiActivosTot(detalleFinancieroWSVO.dfiActivosTot);
        detalleFinVO.setDfiAdqComprav(detalleFinancieroWSVO.dfiAdqComprav);
        detalleFinVO.setDfiAdqDonac(detalleFinancieroWSVO.dfiAdqDonac);
        detalleFinVO.setDfiAdqNoPoseeBien(detalleFinancieroWSVO.dfiAdqNoPoseeBien);
        detalleFinVO.setDfiAdqOtro(detalleFinancieroWSVO.dfiAdqOtro);
        detalleFinVO.setDfiAdqOtroCual(detalleFinancieroWSVO.dfiAdqOtroCual);
        detalleFinVO.setDfiCambiosDiv(detalleFinancieroWSVO.dfiCambiosDiv);
        detalleFinVO.setDfiCodigo(detalleFinancieroWSVO.dfiCodigo);
        detalleFinVO.setDfiEgreNoOpe(detalleFinancieroWSVO.dfiEgreNoOpe);
        detalleFinVO.setDfiEgresosMens(detalleFinancieroWSVO.dfiEgresosMens);
        detalleFinVO.setDfiExportaciones(detalleFinancieroWSVO.dfiExportaciones);
        detalleFinVO.setDfiGiros(detalleFinancieroWSVO.dfiGiros);
        detalleFinVO.setDfiImportaciones(detalleFinancieroWSVO.dfiImportaciones);
        detalleFinVO.setDfiIngrNoOper(detalleFinancieroWSVO.dfiIngrNoOper);
        detalleFinVO.setDfiIngresosMens(detalleFinancieroWSVO.dfiIngresosMens);
        detalleFinVO.setDfiInversiones(detalleFinancieroWSVO.dfiInversiones);
        detalleFinVO.setDfiOperacInt(detalleFinancieroWSVO.dfiOperacInt);
        detalleFinVO.setDfiOrdenesPago(detalleFinancieroWSVO.dfiOrdenesPago);
        detalleFinVO.setDfiOriCual(detalleFinancieroWSVO.dfiOriCual);
        detalleFinVO.setDfiOriFonNegocio(detalleFinancieroWSVO.dfiOriFonNegocio);
        detalleFinVO.setDfiOriFonSocios(detalleFinancieroWSVO.dfiOriFonSocios);
        detalleFinVO.setDfiOriOtro(detalleFinancieroWSVO.dfiOriOtro);
        detalleFinVO.setDfiOtrosIngr(detalleFinancieroWSVO.dfiOtrosIngr);
        detalleFinVO.setDfiPasivosTot(detalleFinancieroWSVO.dfiPasivosTot);
        detalleFinVO.setDfiPatrimonioTot(detalleFinancieroWSVO.dfiPatrimonioTot);
        detalleFinVO.setDfiPrestamosMe(detalleFinancieroWSVO.dfiPrestamosMe);
        detalleFinVO.setDfiRemesas(detalleFinancieroWSVO.dfiRemesas);
        detalleFinVO.setDfiTransferencias(detalleFinancieroWSVO.dfiTransferencias);
        detalleFinVO.setDfiFechaFinCorte(detalleFinancieroWSVO.dfiFechaFinCorte);
        detalleFinVO.setDfiFechaIniCorte(detalleFinancieroWSVO.dfiFechaIniCorte);
        detalleFinVO.setDfiCostosGastosAdm(detalleFinancieroWSVO.dfiCostosGastosAdm);
        detalleFinVO.setDfiCapitalSocial(detalleFinancieroWSVO.dfiCapitalSocial);
        detalleFinVO.setDfiNivelEndeud(detalleFinancieroWSVO.dfiNivelEndeud);
        detalleFinVO.setDfiCapTrabReq(detalleFinancieroWSVO.dfiCapTrabReq);
        detalleFinVO.setDfiIndiceActTot(detalleFinancieroWSVO.dfiIndiceActTot);
        detalleFinVO.setDfiPatrimonReq(detalleFinancieroWSVO.dfiPatrimonReq);
        detalleFinVO.setDfiCambioDivisa(detalleFinancieroWSVO.dfiCambioDivisa);

        detalleFinVO.setDfiCostGastAdmOpe(detalleFinancieroWSVO.dfiCostGastAdmOpe);
        detalleFinVO.setDfiGastIntereses(detalleFinancieroWSVO.dfiGastIntereses);
        detalleFinVO.setDfiGastFinancieros(detalleFinancieroWSVO.dfiGastFinancieros);
        detalleFinVO.setDfiUtilidadNeta(detalleFinancieroWSVO.dfiUtilidadNeta);
        detalleFinVO.setDfiUtilidadOper(detalleFinancieroWSVO.dfiUtilidadOper);
        detalleFinVO.setDfiCapitalTrabajo(detalleFinancieroWSVO.dfiCapitalTrabajo);
        detalleFinVO.setDfiEbit(detalleFinancieroWSVO.dfiEbit);
        detalleFinVO.setDfiEbitda(detalleFinancieroWSVO.dfiEbitda);
        detalleFinVO.setDfiRetornoActivos(detalleFinancieroWSVO.dfiRetornoActivos);
        detalleFinVO.setDfiGastFinEbit(detalleFinancieroWSVO.dfiGastFinEbit);
        detalleFinVO.setDfiGastFinEbitda(detalleFinancieroWSVO.dfiGastFinEbitda);
        detalleFinVO.setDfiRazonEndeuda(detalleFinancieroWSVO.dfiRazonEndeuda);
        detalleFinVO.setDfiActivoCorriente(detalleFinancieroWSVO.dfiActivoCorriente);
        detalleFinVO.setDfiPasivoCorriente(detalleFinancieroWSVO.dfiPasivoCorriente);

        return detalleFinVO;
    }

    public DetalleFinancieroWSVO convertir(DetalleFinancVO detalleFinancieroVo) {
        DetalleFinancieroWSVO detalleFinancieroWsVo = new DetalleFinancieroWSVO();
        detalleFinancieroWsVo.dfiOperacInt = detalleFinancieroVo.getDfiOperacInt();
        detalleFinancieroWsVo.dfiImportaciones = detalleFinancieroVo.getDfiImportaciones();
        detalleFinancieroWsVo.dfiTransferencias = detalleFinancieroVo.getDfiTransferencias();
        detalleFinancieroWsVo.dfiPrestamosMe = detalleFinancieroVo.getDfiPrestamosMe();
        detalleFinancieroWsVo.dfiOrdenesPago = detalleFinancieroVo.getDfiOrdenesPago();
        detalleFinancieroWsVo.dfiExportaciones = detalleFinancieroVo.getDfiExportaciones();
        detalleFinancieroWsVo.dfiRemesas = detalleFinancieroVo.getDfiRemesas();
        detalleFinancieroWsVo.dfiGiros = detalleFinancieroVo.getDfiGiros();
        detalleFinancieroWsVo.dfiCambiosDiv = detalleFinancieroVo.getDfiCambiosDiv();
        detalleFinancieroWsVo.dfiInversiones = detalleFinancieroVo.getDfiInversiones();
        detalleFinancieroWsVo.dfiIngresosMens = detalleFinancieroVo.getDfiIngresosMens();
        detalleFinancieroWsVo.dfiIngrNoOper = detalleFinancieroVo.getDfiIngrNoOper();
        detalleFinancieroWsVo.dfiActivosTot = detalleFinancieroVo.getDfiActivosTot();
        detalleFinancieroWsVo.dfiPatrimonioTot = detalleFinancieroVo.getDfiPatrimonioTot();
        detalleFinancieroWsVo.dfiEgresosMens = detalleFinancieroVo.getDfiEgresosMens();
        detalleFinancieroWsVo.dfiEgreNoOpe = detalleFinancieroVo.getDfiEgreNoOpe();
        detalleFinancieroWsVo.dfiPasivosTot = detalleFinancieroVo.getDfiPasivosTot();
        detalleFinancieroWsVo.dfiOtrosIngr = detalleFinancieroVo.getDfiOtrosIngr();
        detalleFinancieroWsVo.dfiAdqComprav = detalleFinancieroVo.getDfiAdqComprav();
        detalleFinancieroWsVo.dfiAdqDonac = detalleFinancieroVo.getDfiAdqDonac();
        detalleFinancieroWsVo.dfiAdqNoPoseeBien = detalleFinancieroVo.getDfiAdqNoPoseeBien();
        detalleFinancieroWsVo.dfiAdqOtro = detalleFinancieroVo.getDfiAdqOtro();
        detalleFinancieroWsVo.dfiAdqOtroCual = detalleFinancieroVo.getDfiAdqOtroCual();
        detalleFinancieroWsVo.dfiOriFonNegocio = detalleFinancieroVo.getDfiOriFonNegocio();
        detalleFinancieroWsVo.dfiOriFonSocios = detalleFinancieroVo.getDfiOriFonSocios();
        detalleFinancieroWsVo.dfiOriOtro = detalleFinancieroVo.getDfiOriOtro();
        detalleFinancieroWsVo.dfiOriCual = detalleFinancieroVo.getDfiOriCual();
        return detalleFinancieroWsVo;
    }

    public SolicitudAutorizaVO convertir(SolicitudAutorizaWSVO solicitudAutorizacionWsVo) throws ExcepcionDAO {
        SolicitudAutorizaVO solicitudVo = new SolicitudAutorizaVO();
        if (solicitudAutorizacionWsVo != null) {
            solicitudVo = new SolicitudAutorizaVO();
            solicitudVo.setSauFecha(solicitudAutorizacionWsVo.fecha);
            solicitudVo.setSauNit(solicitudAutorizacionWsVo.nit);
            solicitudVo.setSauNumeroSiito(solicitudAutorizacionWsVo.numeroSiito);
            solicitudVo.setSauRadicado(solicitudAutorizacionWsVo.radicado);
            if (solicitudAutorizacionWsVo.codigoMovimiento != null) {
                solicitudVo.setSauMovimientoSiito(solicitudAutorizacionWsVo.codigoMovimiento.intValue());
            }


            TipoSolicAutorizaVO tipoSolVo = new TipoSolicAutorizaVO();
            tipoSolVo.setTsaCodigo(new Long(solicitudAutorizacionWsVo.tipoSolicitud));
            solicitudVo.setTipoSolicAutorizaVo(tipoSolVo);
            solicitudVo.setSauValorEstimado(solicitudAutorizacionWsVo.valorContrato);
            solicitudVo.setSauTiempoContr(solicitudAutorizacionWsVo.tiempoContratoMeses);

            if (solicitudAutorizacionWsVo.estadoSolicAutoriz != null) {
                EstadoSolicAutorizVO estado = new EstadoSolicAutorizVO();
                estado.setEsaCodigo(solicitudAutorizacionWsVo.estadoSolicAutoriz.esaCodigo);
                solicitudVo.setEstadoSolicAutoriz(estado);
            }


            NovedadVO novedad = new NovedadVO();
            novedad = convertir(solicitudAutorizacionWsVo.ultimaNovedadVo);
            List<NovedadVO> novedadListVo = new ArrayList();
            novedadListVo.add(novedad);


            solicitudVo.setNovedadListVo(novedadListVo);

            if (solicitudAutorizacionWsVo.valorProrroga != null) {
                solicitudVo.setSauValorProrroga(solicitudAutorizacionWsVo.valorProrroga);
            }
            solicitudVo.setSauAmpliacion(solicitudAutorizacionWsVo.ampliacion);
            //Usuario analista que realiza la solicitud
            if(solicitudAutorizacionWsVo.UsuarioColjuegos != null && !"".equals(solicitudAutorizacionWsVo.UsuarioColjuegos)){
                SiiUsuario siiUsuarioAnalista = usuarioDao.buscarUsuarioPorLogin(solicitudAutorizacionWsVo.UsuarioColjuegos);
                if(siiUsuarioAnalista != null){
                    solicitudVo.setUsuarioVo(new UsuarioVO(siiUsuarioAnalista));
                }
            }

        }
        return solicitudVo;
    }

    public InventarioVO convertir(InventarioWSVO inventario) {
        InventarioVO inventarioVo = new InventarioVO();
        if (inventario != null) {
            inventarioVo.setEstablecimientoVo(this.convertir(inventario.establecimientoVo));
            inventarioVo.setInstrumentoVo(this.convertir(inventario.instrumentoVo));
            inventarioVo.setInvCodigo(inventario.invCodigo);
            inventarioVo.setInvEstado(inventario.invEstado);
            inventarioVo.setInvFechaFinLiq(inventario.invFechaFinLiq);
            inventarioVo.setInvFechaFinOfi(inventario.invFechaFinOfi);
            inventarioVo.setInvFechaIniLiq(inventario.invFechaIniLiq);
            inventarioVo.setInvFechaIniOfi(inventario.invFechaIniOfi);
            inventarioVo.setInvSillas(inventario.invSillas);
            //inventarioVo.setNovedadVo(this.convertir(inventario.novedadVo));
            inventarioVo.setTipoApuestaVo(this.convertir(inventario.tipoApuestaVo));
        }
        return inventarioVo;
    }

    public List<InventarioVO> convertir(List<InventarioWSVO> listInventarioWs) {

        List<InventarioVO> inventarioListVo = new ArrayList();
        if (listInventarioWs != null && !listInventarioWs.isEmpty()) {
            for (InventarioWSVO inventarioWs : listInventarioWs) {
                InventarioVO instrumentoVo = convertir(inventarioWs);
                inventarioListVo.add(instrumentoVo);
            }
        }
        return inventarioListVo;
    }

    public TipoApuestaVO convertir(TipoApuestaWSVO apuestaWs) {
        TipoApuestaVO objetoVo = new TipoApuestaVO();
        if (apuestaWs != null) {
            //objetoVo.setClaseJuego(apuestaWs.claseJuego);
            //objetoVo.setInventarioVoList(apuestaWs.inventarioVoList);
            objetoVo.setTapApuesta(apuestaWs.tapApuesta);
            objetoVo.setTapCodigo(apuestaWs.tapCodigo);
            objetoVo.setTapCodigoApuesta(apuestaWs.tapCodigoApuesta);
            objetoVo.setTapDerExplFormula(apuestaWs.tapDerExplFormula);
            objetoVo.setTapDerechosExpl(apuestaWs.tapDerechosExpl);
            objetoVo.setTapGastAdmFormula(apuestaWs.tapGastAdmFormula);
            objetoVo.setTapGastosAdm(apuestaWs.tapGastosAdm);
            objetoVo.setTapMinSillas(apuestaWs.tapMinSillas);
            objetoVo.setTapNombre(apuestaWs.tapNombre);
            //objetoVo.setTipoJuego(apuestaWs.tipoJuego);
        }
        return objetoVo;
    }

    public TipoApuestaWSVO convertir(TipoApuestaVO apuestaVo) {
        TipoApuestaWSVO objetoWs = new TipoApuestaWSVO();
        if (apuestaVo != null) {
            objetoWs.tapApuesta = apuestaVo.getTapApuesta();
            objetoWs.tapCodigo = apuestaVo.getTapCodigo();
            objetoWs.tapCodigoApuesta = apuestaVo.getTapCodigoApuesta();
            objetoWs.tapDerExplFormula = apuestaVo.getTapDerExplFormula();
            objetoWs.tapDerechosExpl = apuestaVo.getTapDerechosExpl();
            objetoWs.tapGastAdmFormula = apuestaVo.getTapGastAdmFormula();
            objetoWs.tapGastosAdm = apuestaVo.getTapGastosAdm();
            objetoWs.tapMinSillas = apuestaVo.getTapMinSillas();
        }
        return objetoWs;
    }

    public NovedadVO convertir(NovedadWSVO novedadWs) {
        NovedadVO novedadVo = new NovedadVO();
        if (novedadWs != null) {
            if (novedadWs.contratoVO != null) {
                novedadVo.setContratoVO(this.convertir(novedadWs.contratoVO));
            }
            novedadVo.setInventarioVoList(this.convertir(novedadWs.inventarioVoList));
            novedadVo.setNovCodigo(novedadWs.novCodigo);
            novedadVo.setNovFecha(novedadWs.novFecha);
            //novedadVo.setSolicitudAutorizaVO(this.convertir(novedadWs.solicitudAutorizaVO));
            novedadVo.setTipoNovedad(this.convertir(novedadWs.tipoNovedad));
        }
        return novedadVo;
    }

    public TipoNovedadVO convertir(TipoNovedadWSVO entradaWs) {
        TipoNovedadVO tipoVo = new TipoNovedadVO();
        if (entradaWs != null) {
            tipoVo.setTnoCodigo(entradaWs.tnoCodigo);
            tipoVo.setTnoNombre(entradaWs.tnoNombre);
        }
        return tipoVo;
    }

    public EstablecimientoVO convertir(EstablecimientoWSVO establecimientoWs) {
        EstablecimientoVO establecimietnoVo = new EstablecimientoVO();
        if (establecimientoWs != null) {
            establecimietnoVo.setEstCodInterno(establecimientoWs.estCodInterno);
            establecimietnoVo.setEstCodigo(Long.parseLong (establecimientoWs.estCodigo));
            establecimietnoVo.setEstDireccion(establecimientoWs.estDireccion);
            establecimietnoVo.setEstNombre(establecimientoWs.estNombre);
            //establecimietnoVo.setInventarioVoList(this.convertir(establecimientoWs.inventarioVoList));
            establecimietnoVo.setOperador(this.convertiraOperadorVo(establecimientoWs.operador));
            establecimietnoVo.setUbicacionVo(this.convertir(establecimientoWs.ubicacionVo));
        }
        return establecimietnoVo;
    }

    public UbicacionVO convertir(UbicacionWSVO entradaWs) {
        UbicacionVO objetoVo = new UbicacionVO();
        if (entradaWs != null) {
            objetoVo.setTipoUbicacionVo(this.convertir(entradaWs.tipoUbicacionVo));
            objetoVo.setUbiCodigo(entradaWs.ubiCodigo);
            objetoVo.setUbiCodigoPadre(entradaWs.ubiCodigoPadre);
            objetoVo.setUbiDescripcion(entradaWs.ubiDescripcion);
            objetoVo.setUbiNombre(entradaWs.ubiNombre);
        }
        return objetoVo;
    }

    public TipoUbicacionVO convertir(TipoUbicacionWSVO tipoUbucacionWs) {
        TipoUbicacionVO objetoVo = new TipoUbicacionVO();
        if (tipoUbucacionWs != null) {
            objetoVo.setTiuCodigo(tipoUbucacionWs.tiuCodigo);
            objetoVo.setTiuNombre(tipoUbucacionWs.tiuNombre);

        }
        return objetoVo;
    }

    public InstrumentoVO convertir(InstrumentoWSVO instrumentoWs) {
        InstrumentoVO instrumentoVo = new InstrumentoVO();
        if (instrumentoWs != null) {
            instrumentoVo.setInsActivo(instrumentoWs.insActivo);
            instrumentoVo.setInsCodigo(instrumentoWs.insCodigo);
            instrumentoVo.setInsFechaModific(instrumentoWs.insFechaModific);
            instrumentoVo.setInsFechaRegistro(instrumentoWs.insFechaRegistro);
            instrumentoVo.setInventarioVoList(this.convertir(instrumentoWs.inventarioVoList));
            //instrumentoVo.setMesaCasino(instrumentoWs.mesaCasino);
            instrumentoVo.setMetVo(this.convertir(instrumentoWs.metVo));
            instrumentoVo.setOperadorVo(this.convertir(instrumentoWs.operadorVo));
            instrumentoVo.setTapCodigo(instrumentoWs.tapCodigo);
            instrumentoVo.setTipoInstrumentoVo(this.convertir(instrumentoWs.tipoInstrumentoVo));
        }
        return instrumentoVo;
    }

    public List<InstrumentoVO> convertirLista(List<InstrumentoWSVO> listInstrumentoWs) {

        List<InstrumentoVO> instrumentoListVo = new ArrayList();
        if (listInstrumentoWs != null && !listInstrumentoWs.isEmpty()) {
            for (InstrumentoWSVO instrumentoWs : listInstrumentoWs) {
                InstrumentoVO instrumentoVo = convertir(instrumentoWs);
                instrumentoListVo.add(instrumentoVo);
            }
        }
        return instrumentoListVo;
    }

    public MetVO convertir(MetWSVO metWs) {
        MetVO metVo = new MetVO();
        if (metWs != null) {
            metVo.setInstrumentoList1(this.convertirLista(metWs.instrumentoList1));
            metVo.setMarcaVo(this.convertir(metWs.marcaVo));
            metVo.setMetCodigo(metWs.metCodigo);
            metVo.setMetFechaFab(metWs.metFechaFab);
            metVo.setMetHomologado(metWs.metHomologado);
            metVo.setMetMarcaAnterior(metWs.metMarcaAnterior);
            metVo.setMetModelo(metWs.metModelo);
            metVo.setMetNuid(metWs.metNuid);
            metVo.setMetOnline(metWs.metOnline);
            metVo.setMetOnline(metWs.metOnline);
            metVo.setMetSerial(metWs.metSerial);
            metVo.setMetUid(metWs.metUid);
        }
        return metVo;
    }

    public MarcaVO convertir(MarcaWSVO marcaWs) {
        MarcaVO marcaVo = new MarcaVO();
        if (marcaWs != null) {
            marcaVo.setMarCodigo(marcaWs.marCodigo);
            marcaVo.setMarNombre(marcaWs.marNombre);
        }
        return marcaVo;
    }

    public TipoInstrumentoVO convertir(TipoInstrumentoWSVO instrumentoWs) {
        TipoInstrumentoVO tipoInstrumentoVo = new TipoInstrumentoVO();
        if (instrumentoWs != null) {
            tipoInstrumentoVo.setTinCodigo(instrumentoWs.tinCodigo);
            tipoInstrumentoVo.setTinNombre(instrumentoWs.tinNombre);
        }
        return tipoInstrumentoVo;
    }


    public SolicitudAutorizaVO convertir(TransladoAutomaticoWSVO transladoAutomaticoWSVo) {
        SolicitudAutorizaVO solicitudVo = new SolicitudAutorizaVO();
        if (transladoAutomaticoWSVo != null) {
            solicitudVo = new SolicitudAutorizaVO();
            solicitudVo.setSauNumeroSiito(transladoAutomaticoWSVo.numeroSiito);
            solicitudVo.setSauMovimientoSiito(transladoAutomaticoWSVo.codigoMovimiento.intValue());
            TipoSolicAutorizaVO tipoSolVo = new TipoSolicAutorizaVO();
            tipoSolVo.setTsaCodigo(new Long(transladoAutomaticoWSVo.tipoSolicitud));
            solicitudVo.setTipoSolicAutorizaVo(tipoSolVo);
            solicitudVo.setSauFecha(transladoAutomaticoWSVo.fechaSolicitud);
            solicitudVo.setSauRadicado(transladoAutomaticoWSVo.numeroRadicado);
            solicitudVo.setSauNit(transladoAutomaticoWSVo.nit);

        }
        return solicitudVo;
    }


    /**
     *Convierte de un vo a un objeto plano creado para usarse en los web services
     * Autor: David Tafur
     * @param operadorWsVo
     * @return
     */
    public EstablecimientoWSVO convertir(EstablecimientoVO establecimientoVO) {
        EstablecimientoWSVO establecimientoWSVO = null;
        if (establecimientoVO != null) {
            establecimientoWSVO = new EstablecimientoWSVO();
            establecimientoWSVO.estCodigo = establecimientoVO.getEstCodigo().toString();
            establecimientoWSVO.estCodInterno = establecimientoVO.getEstCodInterno();
            establecimientoWSVO.estDireccion = establecimientoVO.getEstDireccion();

            if (establecimientoVO.getUbicacionVo() != null) {
                UbicacionWSVO ubicacionWSVO = new UbicacionWSVO();
                ubicacionWSVO.ubiCodigo = establecimientoVO.getUbicacionVo().getUbiCodigo();
            }

            /*      if (establecimientoVO.getOperador() != null) {
                OperadorWSVO operadorWSVO = new OperadorWSVO();
                operadorWSVO.codigo = establecimientoVO.getOperador().getOpeCodigo();
            } */

            establecimientoWSVO.estNombre = establecimientoVO.getEstNombre();

        }
        return establecimientoWSVO;
    }
    
    public OperadorWSVO convertirAPersonaWs(PersonaVO personaVo) {
           OperadorWSVO operadorWsVoRetorno = null;
           if (personaVo != null) {
               operadorWsVoRetorno = new OperadorWSVO();
               operadorWsVoRetorno.razonSocial = personaVo.getNombreCompletoPrimeroNombres(); 
               operadorWsVoRetorno.numIdentificacion = personaVo.getPerNumIdentificacion();
               operadorWsVoRetorno.direccion = personaVo.getPerDireccion();
               operadorWsVoRetorno.telefono = personaVo.getPerTelefono();
               operadorWsVoRetorno.telefono2 = personaVo.getPerTelefono2();
               operadorWsVoRetorno.correoElectronico = personaVo.getPerEmail();
               operadorWsVoRetorno.digitoVerificacion = personaVo.getPerDigitoVerif();
               if (personaVo.getUbicacionVo() != null) {
                   String ubicacion = personaVo.getUbicacionVo().getUbiCodigo();
                   operadorWsVoRetorno.codMunicipioDane = ubicacion;
               }
               if (personaVo.getTipoSociedadVO() != null) {
                   operadorWsVoRetorno.tipoSociedad = personaVo.getTipoSociedadVO().getTsoCodigo();
               }
               //     operadorWsVoRetorno.codigo = personaVo.getPerCodigo();
           }
           return operadorWsVoRetorno;
       }   

}
