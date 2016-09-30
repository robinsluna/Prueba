package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorVO;

import java.util.List;

import javax.ejb.Local;

@Local

public interface AdminProveedor {
    public ProveedorVO insertarProveedor(ProveedorVO proveedorVO) throws ExcepcionDAO;

    public ProveedorVO buscarProveedorPorId(ProveedorVO proveedorVO) throws ExcepcionDAO;

    public ProveedorVO actualizarProveedor(ProveedorVO proveedorVO) throws ExcepcionDAO;

    public void eliminarProveedor(ProveedorVO proveedorVO) throws ExcepcionDAO;

    public List<ProveedorVO> buscarTodoProveedor() throws ExcepcionDAO;

    public List<ProveedorVO> buscarProveedorPorNombre(String nombre) throws ExcepcionDAO;

    public List<ProveedorVO> buscarProveedorPorIdentificacion(String numeroId) throws ExcepcionDAO;
    
    public ProveedorVO buscarProveedorPorPersona(PersonaVO personaVo) throws ExcepcionDAO;
    
    public void actualizarListaProveedor(List<ProveedorVO> listaProveedorVO) throws ExcepcionDAO;
    
    public List<ProveedorVO> buscarProveedoresCotizacion(long idproceso) throws ExcepcionDAO;
    
}
