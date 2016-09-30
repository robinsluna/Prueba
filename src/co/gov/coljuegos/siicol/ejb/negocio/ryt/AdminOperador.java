package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracionSug;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDeclaracionSugVO;
import co.gov.coljuegos.siicol.ejb.vo.OperadorVO;
import co.gov.coljuegos.siicol.ejb.wsvo.DeclaracionOperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.DetalleOperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ExpedienteRadicadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ImpedimentoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ImpedimentosWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.InventarioMarcarMetVO;
import co.gov.coljuegos.siicol.ejb.wsvo.LiquidacionOtrosConceptosWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.OperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.PersonaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminOperador {
    /**
     *Metodo encargado de hacer la insercion de un operador
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
    public String insertarSiiOperador(OperadorWSVO operadorWSVO, PersonaWSVO repLegalWSVO,
                                      PersonaWSVO revisorFiscalWSVO, PersonaWSVO repLegalSuplenteWSVO,
                                      PersonaWSVO revisorFiscalSuplenteWSVO, PersonaWSVO contactoWSVO,
                                      PersonaWSVO apoderadoWSVO, PersonaWSVO socio1WSVO, PersonaWSVO socio2WSVO,
                                      PersonaWSVO socio3WSVO, PersonaWSVO socio4WSVO, PersonaWSVO socio5WSVO,
                                      PersonaWSVO contadorWSVO, SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                      List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO,
                                                                                                      ExcepcionAplicacion;

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
                                                                                                        ExcepcionAplicacion,
                                                                                                        Exception;

    public DetalleOperadorWSVO validarOperadorPorNit(String pNit) throws ExcepcionDAO;

    public List<ImpedimentoWSVO> buscarImpedimentosOperador(String nit) throws ExcepcionDAO, ExcepcionAplicacion;
    
    public ImpedimentosWSVO buscarImpedimentosOpeContra(String nit) throws ExcepcionDAO, ExcepcionAplicacion;

    public List<OperadorVO> buscarOperadorPorNit(String pNit) throws ExcepcionDAO;
    
    /**
     *Metodo encargado de hacer el registro en la base de datos de la informacion de la declaracion del operador que
     * llega por medio del web services
     * @author CARLOS YESID ARCINIEGAS BARÓN - CYAB
     * @return
     */
    public String cargarDeclaracionOperadorModificada(DeclaracionOperadorWSVO declaracionOperadorWSVO) throws ExcepcionDAO;
    

    /**
     *Metodo encargado de hacer el registro en la base de datos de la informacion de la declaracion del operador que
     * llega por medio del web services
     * @author David Tafur
     * @return
     */
    public String cargarDeclaracionOperador(DeclaracionOperadorWSVO declaracionOperadorWSVO) throws ExcepcionDAO;

    /**
     *Metodo encargado de hacer el registro en la base de datos de la informacion de la declaracion del operador para otros conceptos
     * llega por medio del web services
     * @author David Tafur
     * @return
     */
    public String cargarLiquidacionOtrosConceptos(LiquidacionOtrosConceptosWSVO liquidacionOtrosConceptos) throws ExcepcionDAO, ExcepcionAplicacion;

    /**
     *Metodo encargado de hacer la busqueda del listado de detalle declaracion sugerida para una declaracion sugerida
     * @author David Tafur
     * @param codigoDeclaracionSugerida
     * @return
     * @throws ExcepcionDAO
     */
    public List<DetalleDeclaracionSugVO> consultarListaDetalleDeclaracionSugPorCodigoDecSug(long codigoDeclaracionSugerida) throws ExcepcionDAO;


    /**
     *Metodo encargado de hacer la actualizacion del detalle de la declaracion sugerida
     * @author David Tafur
     * @param siiDetalleDeclaracionSug
     * @throws ExcepcionDAO
     */
    public void actualizarSiiDetalleDeclaracionSug(DetalleDeclaracionSugVO detalleDeclaracionSugVo) throws ExcepcionDAO;


    /**
     *Metodo encargado de hacer la insercion del detalle de la declaracion sugerida
     * @author David Tafur
     * @param siiDetalleDeclaracionSug
     * @throws ExcepcionDAO
     */
    public void insertarDetalleDeclaracionSug(DetalleDeclaracionSugVO detalleDeclaracionSugVo) throws ExcepcionDAO;

    /**
     *Metodo encargado de devolver el 30 porcierto de maquinas que el operador debe marcar online
     * @author David Tafur
     * @return
     */
    public List<InventarioMarcarMetVO> mostrarTreintaPorcientoMaquinasPorOperadorSinMarcar(String opcionSeleccionada) throws ExcepcionDAO;
    
    public String cargarLiquidacionMultasSanciones(LiquidacionOtrosConceptosWSVO liquidacionMultasSancionesWsVo) throws ExcepcionDAO, ExcepcionAplicacion;

}
