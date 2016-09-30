/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Contratacion
 * AUTOR	: Orlando Rodriguez Bayona
 * FECHA	: 02-10-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ArchivoFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConsultaWebContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CotizacionEstudioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEstudioMercDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstudioMercadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemCotizacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemSolicitudDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProveedorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCotizacionEstudio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemSolicitud;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ConsultaWebContratVO;
import co.gov.coljuegos.siicol.ejb.vo.CotizacionEstudioVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcContratVO;
import co.gov.coljuegos.siicol.ejb.vo.EstudioMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemCotizacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemSolicitudVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminEstudioMercadoBean implements AdminEstudioMercado {
    @EJB
    private EstudioMercadoDAO estudioMercadoDAO;
    @EJB
    private EstadoEstudioMercDAO estadoEstudioMercDao;
    @EJB
    private CotizacionEstudioDAO cotizacionEstudioDao;
    @EJB
    private ProcesoContratacionDAO procesoContratacionDao;
    @EJB
    private EstadoProcContratDAO estadoProcContratDao;
    @EJB
    private ItemCotizacionDAO itemCotizacionDao;
    @EJB
    private ConsultaWebContratDAO consultaWebContratDao;
    @EJB
    private ProveedorDAO proveedorDao;
    @EJB
    private ArchivoFisicoDAO archivoFisicoDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private ItemSolicitudDAO itemSolicitudDao;

    public AdminEstudioMercadoBean() {
    }

    public EstudioMercadoVO insertarEstudioMercado(EstudioMercadoVO estudioMercadoVO) throws ExcepcionDAO {
        SiiEstudioMercado estudioMercado = conversionVoEntidad.convertir(estudioMercadoVO);

        estudioMercado = estudioMercadoDAO.insertarEstudioMercado(estudioMercado);

        return new EstudioMercadoVO(estudioMercado);
    }


    public EstudioMercadoVO buscarEstudioMercadoPorId(Long IdEstudioMercado) throws ExcepcionDAO {
        SiiEstudioMercado localEstudioMercado = estudioMercadoDAO.buscarEstudioMercadoPorId(IdEstudioMercado);
        return new EstudioMercadoVO(localEstudioMercado);
    }

    public EstudioMercadoVO buscarEstudioMercadoPorProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO {
        SiiEstudioMercado localEstudioMercado =
            estudioMercadoDAO.buscarEstudioMercadoPorProcesoContratacion(idProcesoContratacion);
        if (localEstudioMercado != null) {
            return new EstudioMercadoVO(localEstudioMercado);

        } else {
            return new EstudioMercadoVO();
        }
    }

    /**
     * @author Modifica Giovanni
     * @param estudioMercadoVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     */
    public EstudioMercadoVO actualizarEstudioMercado(EstudioMercadoVO estudioMercadoVO,
                                                     UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                       ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        SiiEstudioMercado siiEstudioMercado = new SiiEstudioMercado();
        siiEstudioMercado = estudioMercadoDAO.buscarEstudioMercadoPorId(estudioMercadoVO.getEmeCodigo());
        if (siiEstudioMercado.getSiiEstadoEstudioMerc().getEemCodigo() != estudioMercadoVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del estudio de mercado fue cambiado durante la modificación. Seleccione nuevamente el estudio de mercado");
        }

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (estudioMercadoVO.getEstadoEstudioMercVO().getEemCodigo() != estudioMercadoVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ESTUDIO_DE_MERCADO.getId(),
                                                         estudioMercadoVO.getEstadoEstudioMercVO().getEemCodigo(),
                                                         usuarioLogueado, estudioMercadoVO.getEmeCodigo());
        }

        SiiEstudioMercado estudioMercado = conversionVoEntidad.convertir(estudioMercadoVO);
        return new EstudioMercadoVO(estudioMercadoDAO.actualizarEstudioMercado(estudioMercado));
    }


    public void eliminarEstudioMercado(EstudioMercadoVO estudioMercadoVO) throws ExcepcionDAO {
        estudioMercadoDAO.eliminarEstudioMercado(estudioMercadoVO.getEmeCodigo());
    }


    public List<EstudioMercadoVO> buscarTodoEstudioMercado() throws ExcepcionDAO {
        List<SiiEstudioMercado> listaEstudioMercado = estudioMercadoDAO.buscarTodoEstudioMercado();
        List<EstudioMercadoVO> listaEstudioMercadoVO = new ArrayList();
        for (SiiEstudioMercado unEstudioMercado : listaEstudioMercado) {
            listaEstudioMercadoVO.add(new EstudioMercadoVO(unEstudioMercado));

        }
        return listaEstudioMercadoVO;

    }

    public List<EstudioMercadoVO> buscarEstudiosMercadoPorEstado(String estado) throws ExcepcionDAO {
        List<SiiEstudioMercado> listaEstudioMercado = estudioMercadoDAO.buscarEstudiosMercadoPorEstado(estado);
        List<EstudioMercadoVO> listaEstudioMercadoVO = new ArrayList();
        for (SiiEstudioMercado unEstudioMercado : listaEstudioMercado) {
            listaEstudioMercadoVO.add(new EstudioMercadoVO(unEstudioMercado));
        }
        return listaEstudioMercadoVO;
    }


    /**
     * @author Modifica Giovanni
     * @param estudioMercadoVO
     * @param usuarioLogueado
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public EstudioMercadoVO guardarEstudioMercado(EstudioMercadoVO estudioMercadoVO,
                                                  UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {
        List<CotizacionEstudioVO> listaCotizacionEstudioVo = estudioMercadoVO.getCotizacionEstudioListVO();

        if (estudioMercadoVO.getEmeCodigo() == null) {
            estudioMercadoVO = new EstudioMercadoVO(estudioMercadoDAO.insertarEstudioMercado(conversionVoEntidad.convertir(estudioMercadoVO)));
        } else {

            /*
             * Manejo de error de concurrencia
             */
            EstudioMercadoVO estudioMercadoAnteriorVO =
                new EstudioMercadoVO(estudioMercadoDAO.buscarEstudioMercadoPorId(estudioMercadoVO.getEmeCodigo()));
            if (estudioMercadoAnteriorVO.getEstadoEstudioMercVO().getEemCodigo() != estudioMercadoVO.getIdEstadoAnterior()) {
                throw new ExcepcionAplicacion("Error de concurrencia: El estado del estudio de mercado fue cambiado durante la modificación. Seleccione nuevamente el estudio de mercado");
            }

            /*
             * Registro del log de estados esto solo si el estado tuvo un cambio
             */
            if (estudioMercadoVO.getEstadoEstudioMercVO().getEemCodigo() != estudioMercadoVO.getIdEstadoAnterior()) {
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ESTUDIO_DE_MERCADO.getId(),
                                                             estudioMercadoVO.getEstadoEstudioMercVO().getEemCodigo(),
                                                             usuarioLogueado, estudioMercadoVO.getEmeCodigo());
            }

            estudioMercadoVO = new EstudioMercadoVO(estudioMercadoDAO.actualizarEstudioMercado(conversionVoEntidad.convertir(estudioMercadoVO)));
        }
        estudioMercadoVO.setCotizacionEstudioListVO(listaCotizacionEstudioVo);
        for (CotizacionEstudioVO loopCotizacionEstudioVO : estudioMercadoVO.getCotizacionEstudioListVO()) {
            loopCotizacionEstudioVO.setEstudioMercadoVO(estudioMercadoVO);
            loopCotizacionEstudioVO = guardarCotizacionEstudioMercado(loopCotizacionEstudioVO);
        }
                

        if (estudioMercadoVO.getEstadoEstudioMercVO().getEemNombre().equals("APROBADO")) {
            ProcesoContratacionVO procesoContratacionVO = new ProcesoContratacionVO();
            EstadoProcContratVO estadoProcContratVO = new EstadoProcContratVO();
            procesoContratacionVO =
                new ProcesoContratacionVO(procesoContratacionDao.buscarProcesoContratacionPorId(estudioMercadoVO.getProcesoContratacionVO().getPrcCodigo()));
            estadoProcContratVO =
                new EstadoProcContratVO(estadoProcContratDao.BuscarEstadoProcContratPorId(2L)); // ESTUDIO MERCADO
            procesoContratacionVO.setEstadoProcContrat(estadoProcContratVO);
            procesoContratacionVO =
                new ProcesoContratacionVO(procesoContratacionDao.actualizarProcesoContratacion(conversionVoEntidad.convertir(procesoContratacionVO)));

        }
        
        return estudioMercadoVO;

    }

    public CotizacionEstudioVO guardarCotizacionEstudioMercado(CotizacionEstudioVO cotizacionEstudioVo) throws ExcepcionDAO {
        List<ItemCotizacionVO> listaItemCotizacionVo = cotizacionEstudioVo.getItemCotizacionListVO1();

        if (cotizacionEstudioVo.getConsultaWebContratVO() != null) {

            //cotizacionEstudioVo.getConsultaWebContratVO().setArchivoFisicoVO(null);
            if (cotizacionEstudioVo.getConsultaWebContratVO().getCwcCodigo() == null) {
                cotizacionEstudioVo.setConsultaWebContratVO(new ConsultaWebContratVO(consultaWebContratDao.insertarConsultaWebContrat(conversionVoEntidad.convertir(cotizacionEstudioVo.getConsultaWebContratVO()))));
            } else {
                cotizacionEstudioVo.setConsultaWebContratVO(new ConsultaWebContratVO(consultaWebContratDao.actualizarConsultaWebContrat(conversionVoEntidad.convertir(cotizacionEstudioVo.getConsultaWebContratVO()))));
            }
        } else {

        }

        if (cotizacionEstudioVo.getProveedorVO() != null) {
            if (cotizacionEstudioVo.getProveedorVO().getProCodigo() == null) {
                // -          El proveedor de la cotización ya debe existir en la tabla de proveedores/Persona. La idea es que esta tabla va a estar bien poblada
                //-          Cuando el proveedor no exista no se debe agregar sino que se le debe solicitar al administrador que agregue al proveedor.
                //                    proveedor =
                //                      proveedorDao.insertarProveedor(conversionVoEntidad.convertir(loopCotizacionEstudioVO.getProveedorVO()));
                cotizacionEstudioVo.setProveedorVO(null);
                System.out.println(" insertarProveedor - debe solicitar al administrador que agregue al proveedor");
            } else {
                //                    proveedor =
                //                        proveedorDao.actualizarProveedor(conversionVoEntidad.convertir(cotizacionEstudioVo.getProveedorVO()));
                System.out.println("actualizarProveedor - debe solicitar al administrador que actualice al proveedor");
            }

        }

        if (cotizacionEstudioVo != null) {
            if (cotizacionEstudioVo.getCesCodigo() == null) {
                cotizacionEstudioVo = new CotizacionEstudioVO(cotizacionEstudioDao.insertarCotizacionEstudio(conversionVoEntidad.convertir(cotizacionEstudioVo)));

            } else {
                cotizacionEstudioVo = new CotizacionEstudioVO(cotizacionEstudioDao.actualizarCotizacionEstudio(conversionVoEntidad.convertir(cotizacionEstudioVo)));
            }
        }

        if (cotizacionEstudioVo != null && listaItemCotizacionVo != null) {
            for (ItemCotizacionVO loopItemCotizacionVO : listaItemCotizacionVo) {
                loopItemCotizacionVO.setCotizacionEstudioVo(cotizacionEstudioVo);
                if (loopItemCotizacionVO.getIcoCodigo() == null) {
                    loopItemCotizacionVO = new ItemCotizacionVO(itemCotizacionDao.insertarItemCotizacion(conversionVoEntidad.convertir(loopItemCotizacionVO)));
                } 
				else {
                    loopItemCotizacionVO = new ItemCotizacionVO(itemCotizacionDao.actualizarItemCotizacion(conversionVoEntidad.convertir(loopItemCotizacionVO)));
                }
            }
            cotizacionEstudioVo.setItemCotizacionListVO1(listaItemCotizacionVo);
        }

        return cotizacionEstudioVo;
    }


    public List<CotizacionEstudioVO> ofertas(Long prcCodigo) throws ExcepcionDAO, ExcepcionAplicacion {
        List<CotizacionEstudioVO> cotizacionesVo = new ArrayList<CotizacionEstudioVO>();
        for (SiiCotizacionEstudio cotizacion : cotizacionEstudioDao.ofertas(prcCodigo)) {
            cotizacionesVo.add(new CotizacionEstudioVO(cotizacion));
        }
        return cotizacionesVo;
    }

    public List<ItemSolicitudVO> elementos(Long prcCodigo) throws ExcepcionDAO, ExcepcionAplicacion {
        List<ItemSolicitudVO> elementosVo = new ArrayList<ItemSolicitudVO>();
        for (SiiItemSolicitud elemento : itemSolicitudDao.elementos(prcCodigo)) {
            elementosVo.add(new ItemSolicitudVO(elemento));
        }
        return elementosVo;
    }
    
    public ItemCotizacionVO elementoOferta(Long isoCodigo, Long cesCodigo)  throws ExcepcionDAO, ExcepcionAplicacion {
        return new ItemCotizacionVO(itemCotizacionDao.elementoOferta(isoCodigo, cesCodigo));
    }
    
    public BigDecimal preciosUnitariosMinimos(Long emeCodigo) throws ExcepcionDAO  {
        return itemCotizacionDao.preciosUnitariosMinimos(emeCodigo);
    }
    
    public BigDecimal preciosMinimosTotales(Long emeCodigo) throws ExcepcionDAO {
        return cotizacionEstudioDao.preciosMinimosTotales(emeCodigo);
    }
    
    public String nombreProveedorMinimosTotales(Long emeCodigo) throws ExcepcionDAO {
        return cotizacionEstudioDao.nombreProveedorMinimosTotales(emeCodigo);
    }
}
