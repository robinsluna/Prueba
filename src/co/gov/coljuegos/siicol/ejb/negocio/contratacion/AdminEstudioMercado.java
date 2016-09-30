/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Contratacion
 * AUTOR	: Orlando Rodriguez Bayona
 * FECHA	: 02-10-2013
 */
package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CotizacionEstudioVO;
import co.gov.coljuegos.siicol.ejb.vo.EstudioMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemCotizacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemSolicitudVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstudioMercado {
    public EstudioMercadoVO insertarEstudioMercado(EstudioMercadoVO estudioMercadoVO) throws ExcepcionDAO;

    public EstudioMercadoVO buscarEstudioMercadoPorId(Long IdEstudioMercado) throws ExcepcionDAO;

    public EstudioMercadoVO buscarEstudioMercadoPorProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param estudioMercadoVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     */
    public EstudioMercadoVO actualizarEstudioMercado(EstudioMercadoVO estudioMercadoVO,
                                                     UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                       ExcepcionAplicacion;

    public void eliminarEstudioMercado(EstudioMercadoVO estudioMercadoVO) throws ExcepcionDAO;

    public List<EstudioMercadoVO> buscarTodoEstudioMercado() throws ExcepcionDAO;

    public List<EstudioMercadoVO> buscarEstudiosMercadoPorEstado(String estado) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param estudioMercadoVO
     * @param usuarioLogueado
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public EstudioMercadoVO guardarEstudioMercado(EstudioMercadoVO estudioMercadoVO, UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                           ExcepcionAplicacion;
    public List<CotizacionEstudioVO> ofertas(Long prcCodigo) throws ExcepcionDAO, ExcepcionAplicacion;
    
    public List<ItemSolicitudVO> elementos(Long prcCodigo) throws ExcepcionDAO, ExcepcionAplicacion;
    
    public ItemCotizacionVO elementoOferta(Long isoCodigo, Long cesCodigo)  throws ExcepcionDAO, ExcepcionAplicacion;
    
    public BigDecimal preciosUnitariosMinimos(Long emeCodigo) throws ExcepcionDAO;
    
    public BigDecimal preciosMinimosTotales(Long emeCodigo) throws ExcepcionDAO;
    
    public String nombreProveedorMinimosTotales(Long emeCodigo) throws ExcepcionDAO;
}
