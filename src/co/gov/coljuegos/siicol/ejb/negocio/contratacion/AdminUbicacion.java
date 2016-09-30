package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminUbicacion {
    public UbicacionVO buscarUbicacionPorId(UbicacionVO ubicacionVo) throws ExcepcionDAO;   
    public UbicacionVO buscarUbicacionPorId(String idUbicacion) throws ExcepcionDAO;
    public List<UbicacionVO>  buscarUbicacionTipoUbicacion(Long idTipoUbicacion)throws ExcepcionDAO;        
    public List<UbicacionVO>  buscarUbicacionPorPadre(String idPadre)throws ExcepcionDAO;
    public List<UbicacionVO> buscarTodaUbicacion( ) throws ExcepcionDAO ;
    
    /**
     * Metodo que se encarga de consultat todos los paises
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<UbicacionVO> buscarUbicacionPaises() throws ExcepcionDAO;    
    
    /**
     * Metodo que se encarga de consultar todos los departamentos 
     * @author Giovanni 
     * @return
     * @throws ExcepcionDAO
     */
    public List<UbicacionVO> buscarUbicacionDepartamento() throws ExcepcionDAO;  
        
    /**
     * Metodo que se encarga de consultar todas ciudades del departamento 
     * @author Giovanni 
     * @return
     * @throws ExcepcionDAO
     */
    public List<UbicacionVO> buscarUbicacionCiudadesXDepartamento(String codigoDepartamenteo) throws ExcepcionDAO;
}

