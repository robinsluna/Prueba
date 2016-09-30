package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoCalleDireccionVO;

import co.gov.coljuegos.siicol.ejb.vo.TipoSectorDirecVO;

import co.gov.coljuegos.siicol.ejb.vo.TipoSufijo1CalleVO;

import co.gov.coljuegos.siicol.ejb.vo.TipoSufijo2CalleVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminDireccion {
    
    public List<TipoCalleDireccionVO> buscarTipoCalleDireccionTodos() throws ExcepcionDAO;
    
    /**
     * Buscar el tipo de callde de dirección por código del tipo
     * @param tcdCodigo
     * @return
     * @throws ExcepcionDAO
     */
    
    public TipoCalleDireccionVO buscarTipoCalleDireccionXId(Long tcdCodigo) throws ExcepcionDAO;
    /**
     * Buscar el tipo de sufijo 1 de la calle según id
     * @param tscCodigo
     * @return
     * @throws ExcepcionDAO
     */
    
    public TipoSufijo1CalleVO buscarTipoSufijo1CalleXId(Long tscCodigo) throws ExcepcionDAO;
    
    /**
     * Buscar por tipo de sector de la dirección según id
     * @param tsdCodigo
     * @return
     * @throws ExcepcionDAO
     */
    
    public TipoSectorDirecVO buscarTipoSectorDirecXId(Long tsdCodigo) throws ExcepcionDAO;
    
    /**
     * Buscar el tipo de sufijo 2 de la calle según su id (BIS)
     * @param tsuCodigo
     * @return
     * @throws ExcepcionDAO
     */
    
    public TipoSufijo2CalleVO buscarTipoSufijo2CalleXId(Long tsuCodigo) throws ExcepcionDAO;
    public List<TipoSectorDirecVO> buscarTipoSectorDirecTodos() throws ExcepcionDAO;
    public List<TipoSufijo1CalleVO> buscarTipoSufijo1CalleTodos() throws ExcepcionDAO;
    public List<TipoSufijo2CalleVO> buscarTipoSufijo2CalleTodos() throws ExcepcionDAO;
    
    /**
     * Buscar la dirección completa según el id de la dirección
     * @param denCodigo
     * @return String
     * @throws ExcepcionDAO
     */
    
    public String buscarDireccionCompletaXIdDenuncia(Long denCodigo) throws ExcepcionDAO;
    
    /**
     * Insertar la dirección en la base de datos
     * @param direccionVo
     * @return resultado - DireccionVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public DireccionVO insertarDireccion(DireccionVO direccionVo) throws ExcepcionDAO, ExcepcionAplicacion;
    
    /**
     * Actualizar la dirección
     * @param direccionVo
     * @return resultado - La dirección que fue agregada a la BD
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public DireccionVO actualizarDireccion(DireccionVO direccionVo) throws ExcepcionDAO, ExcepcionAplicacion;
    
}
