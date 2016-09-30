package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ActividadIcaPersVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;
import co.gov.coljuegos.siicol.ejb.vo.HitosEmpresaVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonalEmpresaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorVO;
import co.gov.coljuegos.siicol.ejb.vo.ResponDianPersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface AdminPersona {
    public PersonaVO insertarPersona(PersonaVO personaVo) throws ExcepcionDAO;
    
    /**
     * Persistir una persona en cascada
     * @param doCascade
     * @param personaVo
     * @return resultado - PersonaVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public PersonaVO insertarPersona(boolean doCascade, PersonaVO personaVo) throws ExcepcionDAO, ExcepcionAplicacion;

    public PersonaVO buscarPersonaPorId(PersonaVO personaVo) throws ExcepcionDAO;

    public PersonaVO buscarPersonaPorId(Long perCodigo) throws ExcepcionDAO;

    public List<PersonaVO> buscarPersonaPorIdUsuario(UsuarioVO usuarioVo) throws ExcepcionDAO;

    public PersonaVO actualizarPersona(PersonaVO personaVo) throws ExcepcionDAO;

    public void eliminarPersona(PersonaVO personaVo) throws ExcepcionDAO;

    public List<PersonaVO> buscarTodoPersona() throws ExcepcionDAO;

    public List<PersonaVO> buscarPersonaPorIdentificacionPorTipoIdentificacion(PersonaVO unaPersonaVo) throws ExcepcionDAO;

    public List<PersonaVO> buscarPersonaPorIdentificacionPorTipoIdentificacionUsuario(PersonaVO unaPersonaVo) throws ExcepcionDAO;

    public void actualizarListaPersona(List<PersonaVO> listaPersonaVO) throws ExcepcionDAO;

    public PersonaVO buscarPersonaPorNumeroIdYTipoId(String numeroIdentificacion, String tipoId) throws ExcepcionDAO;

    public List<UsuarioVO> buscarPersonaUsuario() throws ExcepcionDAO;

    public List<PersonaVO> buscarPersonaPorNombreId(PersonaVO personaVo) throws ExcepcionDAO;

    public List<PersonaVO> buscarPersonaPorNombre(String nombre) throws ExcepcionDAO;

    public List<PersonaVO> buscarPersonaPorNombreId(String nombre, Long numIdentificacion) throws ExcepcionDAO;

    /**
     * @author Giovannni
     * @param proveedorVO
     * @return
     * @throws ExcepcionDAO
     */
    public void registrarProveedor(ProveedorVO proveedorVO) throws ExcepcionDAO;

    public List<PersonaVO> buscarPersonaProveedores() throws ExcepcionDAO;

    public List<PersonaVO> buscarPorRangoPaginacion(Integer first, Integer last, String sortField,
                                                    String sortOrder) throws ExcepcionDAO;

    public List<PersonaVO> buscarPorFiltros(Map<String, Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO;

    public List<PersonaVO> buscarPorFiltrosYPaginacion(Map<String, Object> filtros, String sortField, String sortOrder, Integer first, Integer last) throws ExcepcionDAO;

    public Integer obtenerRowCount() throws ExcepcionDAO;

    public Integer obtenerRowCount(Map<String, Object> filtros) throws ExcepcionDAO;

    public PersonaVO actualizarProveedor(PersonaVO personaVo, PersonaVO personaRepLegalVo,
                                         List<ResponDianPersonaVO> listaAddResponDianPersonaVo,
                                         List<ResponDianPersonaVO> listaRemoveResponDianPersonaVo,
                                         List<ActividadIcaPersVO> listaAddActividadIcaPersVo,
                                         List<ActividadIcaPersVO> listaRemoveActividadIcaPersVo) throws ExcepcionDAO;

    public PersonaVO buscarPersonaPorTipoYNumeroIdentificacion(Long tidCodigo,
                                                               String perNumIdentificacion) throws ExcepcionDAO;

    /**
     * Se encarga de devolver todas la personas que sea operadores potenciales y provedores
     * @autor Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<PersonaVO> buscarPersonaOperadorPotencialYProveedor() throws ExcepcionDAO;

    /**
     * Se encarga de registrar una persona con sus contactos y su informacion financiera
     * @autor Giovanni
     * @throws ExcepcionDAO
     */
    public void registroPersonaCompleta(PersonaVO personaVO, List<PersonalEmpresaVO> personalEmpresaVOs,
                                        List<DetalleFinancVO> detalleFinancVOs, List<HitosEmpresaVO> hitosEmpresaVOs,
                                        boolean esOperadorPotencial, boolean esProveedorTec) throws ExcepcionDAO;

    /**
     * Se encarga de actualizar una persona con sus contactos y su informacion financiera
     * @autor Giovanni
     * @throws ExcepcionDAO
     */
    public void actualizarPersonaCompleta(PersonaVO personaVO, List<PersonalEmpresaVO> personalEmpresaVOs,
                                          List<DetalleFinancVO> detalleFinancVOs, List<HitosEmpresaVO> hitosEmpresaVOs,
                                          boolean esOperadorPotencial, boolean esProveedorTec) throws ExcepcionDAO;

    /**
     * Metodo para traer todos los hitos para para la persona
     * @author Giovanni
     * @param codigoPersonal
     * @return
     * @throws ExcepcionDAO
     */
    public List<HitosEmpresaVO> buscarHitosEmpresaXCodigoPersonal(long codigoPersonal) throws ExcepcionDAO;


    public PersonaVO buscarPersonaPersonalEmpresaXOperadorXTipoPersonal(long codigoOperadorPersona,
                                                                        long codigoTipoPersonal) throws ExcepcionDAO;

    /**
     * @author Giovanni
     * @param tidCodigo
     * @param perNumIdentificacion
     * @return
     * @throws ExcepcionDAO
     */
    public ProveedorVO buscarPersonaProveedorPorTipoYNumeroIdentificacion(Long tidCodigo,
                                                                          String perNumIdentificacion) throws ExcepcionDAO;

    /**
     * @author Giovanni
     * @param personaVO
     * @return
     * @throws ExcepcionDAO
     */
    public void actualizarPersonaParametrosContables(PersonaVO personaVO) throws ExcepcionDAO;

    /**
     * Guarda los parametros contables para una persona
     * @author Giovanni
     * @throws ExcepcionDAO
     */
    public void guardarParametroContables(PersonaVO personaVO) throws ExcepcionDAO;
    
    
    //public PersonaVO buscarPersonaXNumeroIdentificacion(String perNumIdentificacion) throws ExcepcionDAO;
    
    public String buscarNombreFuncionario(String cargo, String activo) throws ExcepcionDAO;
    
    public PersonaVO buscarPersonaXNombreFuncionario(String cargo, String activo) throws ExcepcionDAO ;
    
    public List<PersonaVO> buscarPersonaXCodigoOperador(PersonaVO personaVo) throws ExcepcionDAO ;

}
