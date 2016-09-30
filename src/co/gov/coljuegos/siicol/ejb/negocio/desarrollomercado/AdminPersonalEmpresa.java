package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PersonalEmpresaVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminPersonalEmpresa {
    public PersonalEmpresaVO insertarSiiPersonalEmpresa(PersonalEmpresaVO personalEmpresaVO) throws ExcepcionDAO;
    public PersonalEmpresaVO buscarPersonalEmpresaPorCodigo(Long idCodigoPersonalEmpresa) throws ExcepcionDAO;
    public PersonalEmpresaVO actualizarSiiPersonalEmpresa(PersonalEmpresaVO personalEmpresaVO) throws ExcepcionDAO;
    public void borrarPersonalEmpresa(Long idCodigoPersonalEmpresa) throws ExcepcionDAO;
    public List<PersonalEmpresaVO> buscarTodoSiiPersonalEmpresa()throws ExcepcionDAO;   
    
    /**
     * Metodo que se encarga de coanultar los contactos  de un personal
     * @author Giovanni
     * @param codigoPersonal
     * @return
     */
    public List<PersonalEmpresaVO> buscarPersonalEmpresaXCodigoPersonal(long codigoPersonal) throws ExcepcionDAO;
    
    /**
     * Metodo para consultar un contacto para un operador ya sea autorizado, potencia o proveedor de tecnologia
     * @author Giovanni
     * @param idOperador
     * @param idPersonaContacto
     * @return
     * @throws ExcepcionDAO
     */
    public PersonalEmpresaVO buscarPersonalEmpresaXOperadorXPerosna(long idOperador,
                                                                    long idPersonaContacto) throws ExcepcionDAO;
    
    public PersonalEmpresaVO buscarPersonalEmpresaPorEmpresaPorRol(Long perCodigoEmpresa, String rol) throws ExcepcionDAO;
}
