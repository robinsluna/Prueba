package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.gct.AdminDireccionPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActividadIcaPersDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaBancoPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFinancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HitosEmpresaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaCtaBancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonalEmpresaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProveedorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResponDianPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.siito.ProveedorTecnDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActividadIcaPers;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancoPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHitosEmpresa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaCtaBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonalEmpresa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedorTecn;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponDianPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ActividadIcaPersVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionPersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.HitosEmpresaVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaCtaBancoVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonalEmpresaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorVO;
import co.gov.coljuegos.siicol.ejb.vo.ResponDianPersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminPersonaBean implements AdminPersona {


    @EJB
    private PersonaDAO personaDAO;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ProveedorDAO proveedorDAo;
    @EJB
    private ResponDianPersonaDAO responDianPersonaDao;
    @EJB
    private ActividadIcaPersDAO actividadIcaPersDao;
    @EJB
    private PersonalEmpresaDAO personalEmpresaDAO;
    @EJB
    private DetalleFinancDAO detalleFinancDAO;
    @EJB
    private OperadorDAO operadorDAO;
    @EJB
    private ProveedorTecnDAO proveedorTecnDAO;
    @EJB
    private HitosEmpresaDAO hitosEmpresaDAO;
    @EJB
    private PersonaCtaBancoDAO personaCtaBancoDAO;
    @EJB
    private CuentaBancoPersonaDAO cuentaBancoPersonaDAO;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private AdminDireccionPersona adminDireccionPersona;

    public AdminPersonaBean() {
    }

    /**
     * Persistir la dirección de la persona
     * @param personaVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    private void persistirDireccionPersonaList(PersonaVO personaVo) throws ExcepcionDAO, ExcepcionAplicacion {    
        
        if(personaVo != null && personaVo.getDireccionPersonaListVo() != null) {
            for(DireccionPersonaVO dpVo : personaVo.getDireccionPersonaListVo()) {
                if(dpVo != null) {
                    dpVo.setPersonaVo(personaVo);

                    if(dpVo.getDpeCodigo() == null) {
                        // OPERACION INSERTAR
                        adminDireccionPersona.insertarDireccionPersona(dpVo);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        //TODO
                        //adminDireccionPersona.actualizarNotaCredOblConcepto(ncocoVo);
                    }
                }
            }
        }
    }

    /**
     * Persistir los hijos del value object
     * @param personaVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    private void persistirHijos(PersonaVO personaVo) throws ExcepcionDAO, ExcepcionAplicacion {
        this.persistirDireccionPersonaList(personaVo);

    }
    
    /**
     * Persistir una persona en cascada
     * @param doCascade
     * @param personaVo
     * @return resultado - PersonaVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
 //   public PersonaVO insertarPersona(boolean doCascade, PersonaVO personaVo) throws ExcepcionDAO, ExcepcionAplicacion {
//        PersonaVO resultado= this.insertarPersona(personaVo);
 //       if(doCascade)
 //           this.persistirHijos(resultado);
//        return resultado;
 //   }
    
    public PersonaVO insertarPersona(boolean doCascade, PersonaVO personaVo) throws ExcepcionDAO, ExcepcionAplicacion {
        PersonaVO resultado = null;
        
        try {
            SiiPersona unaPersona = personaDAO.insertarPersona(conversionVoEntidad.convertir(personaVo));
           
            if (unaPersona!=null) {
                resultado= new PersonaVO(unaPersona);
                // persistir las entidades hijas
                resultado.setDireccionPersonaListVo(personaVo.getDireccionPersonaListVo());
                this.persistirHijos(resultado);
            }
        }
        catch(ExcepcionAplicacion|ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Nota de Crédito: "+e.getMessage());
        }
        
        return (resultado);
    }
    
    public PersonaVO insertarPersona(PersonaVO personaVo) throws ExcepcionDAO {
        SiiPersona persona = conversionVoEntidad.convertir(personaVo);
        SiiPersona unaPersona = personaDAO.insertarPersona(persona);
        return new PersonaVO(unaPersona);
    }

    public PersonaVO buscarPersonaPorId(PersonaVO personaVo) throws ExcepcionDAO {
        SiiPersona persona = conversionVoEntidad.convertir(personaVo);
        SiiPersona unaPersona = personaDAO.buscarPersonaPorId(persona.getPerCodigo());
        return new PersonaVO(unaPersona);
    }

    public PersonaVO buscarPersonaPorId(Long perCodigo) throws ExcepcionDAO {
        PersonaVO personaVo = null;
        SiiPersona unaPersona = personaDAO.buscarPersonaPorId(perCodigo);
        if (unaPersona != null)
            personaVo = new PersonaVO(unaPersona);

        return (personaVo);
    }


    public PersonaVO actualizarPersona(PersonaVO personaVo) throws ExcepcionDAO {
        SiiPersona persona = conversionVoEntidad.convertir(personaVo);
        SiiPersona unaPersona = personaDAO.actualizarPersona(persona);
        return new PersonaVO(unaPersona);

    }

    /**
     * @author Giovanni
     * @param personaVO
     * @return
     * @throws ExcepcionDAO
     */
    public void actualizarPersonaParametrosContables(PersonaVO personaVO) throws ExcepcionDAO {
        SiiPersona siiPersona = conversionVoEntidad.convertir(personaVO);
        personaDAO.actualizarPersona(siiPersona);
    }

    public void eliminarPersona(PersonaVO personaVo) throws ExcepcionDAO {
        SiiPersona persona = conversionVoEntidad.convertir(personaVo);
        personaDAO.eliminarPersona(personaVo.getPerCodigo());
    }

    public List<PersonaVO> buscarTodoPersona() throws ExcepcionDAO {
        List<SiiPersona> listaPersona = personaDAO.buscarTodoPersona();
        List<PersonaVO> listaPersonaVo = new ArrayList();
        for (SiiPersona unaPersona : listaPersona) {
            listaPersonaVo.add(new PersonaVO(unaPersona));
        }
        return listaPersonaVo;
    }

    public List<PersonaVO> buscarPersonaPorIdentificacionPorTipoIdentificacion(PersonaVO unaPersonaVo) throws ExcepcionDAO {
        SiiPersona persona = conversionVoEntidad.convertir(unaPersonaVo);
        List<SiiPersona> listaPersona = personaDAO.buscarPersonaPorIdentificacionPorTipoIdentificacion(persona);
        List<PersonaVO> listaPersonaVo = new ArrayList();
        if (listaPersona.size() > 0) {
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }

    public List<PersonaVO> buscarPersonaPorIdUsuario(UsuarioVO unaUsuarioVo) throws ExcepcionDAO {
        //SiiUsuario usuario = conversionVoEntidad.convertir(unaUsuarioVo);
        List<SiiPersona> listaPersona = personaDAO.buscarPersonaPorIdUsuario(unaUsuarioVo.getUsuCodigo());
        List<PersonaVO> listaPersonaVo = new ArrayList();
        if (listaPersona.size() > 0) {
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }

    public List<PersonaVO> buscarPersonaPorIdUsuario(Long usuCodigo ) throws ExcepcionDAO {
        List<SiiPersona> listaPersona = personaDAO.buscarPersonaPorIdUsuario(usuCodigo);
        List<PersonaVO> listaPersonaVo = new ArrayList();
        if (listaPersona.size() > 0) {
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }

    public void actualizarListaPersona(List<PersonaVO> listaPersonaVO) throws ExcepcionDAO {
        if (listaPersonaVO != null) {
            for (PersonaVO miPersonaVo : listaPersonaVO) {
                personaDAO.actualizarPersona(conversionVoEntidad.convertir(miPersonaVo));
            }
        }
    }

    public PersonaVO buscarPersonaPorNumeroIdYTipoId(String numeroIdentificacion, String tipoId) throws ExcepcionDAO {
        PersonaVO personaVo = null;
        SiiPersona siiPersona = personaDAO.buscarPersonaPorNumeroIdYTipoId(numeroIdentificacion, tipoId);
        if (siiPersona != null)
            personaVo = new PersonaVO(siiPersona);

        return (personaVo);
    }

    public List<PersonaVO> buscarPersonaPorIdentificacionPorTipoIdentificacionUsuario(PersonaVO unaPersonaVo) throws ExcepcionDAO {
        SiiPersona persona = conversionVoEntidad.convertir(unaPersonaVo);
        List<SiiPersona> listaPersona = personaDAO.buscarPersonaPorIdentificacionPorTipoIdentificacionUsuario(persona);
        List<PersonaVO> listaPersonaVo = new ArrayList();
        if (listaPersona.size() > 0) {
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }

    public List<UsuarioVO> buscarPersonaUsuario() throws ExcepcionDAO {
        List<SiiUsuario> listaUsuario = personaDAO.buscarPersonaUsuario();
        List<UsuarioVO> listaUsuarioVo = new ArrayList();
        for (SiiUsuario unUsuario : listaUsuario) {
            listaUsuarioVo.add(new UsuarioVO(unUsuario));
        }
        return listaUsuarioVo;
    }

    public List<PersonaVO> buscarPersonaPorNombreId(PersonaVO personaVo) throws ExcepcionDAO {
        List<PersonaVO> listaPersonaVo = null;
        List<SiiPersona> listaPersona = personaDAO.buscarPersonaPorNombreId(conversionVoEntidad.convertir(personaVo));
        if (listaPersona != null && listaPersona.size() > 0) {
            listaPersonaVo = new ArrayList<PersonaVO>();
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }

    public List<PersonaVO> buscarPersonaPorNombre(String nombre) throws ExcepcionDAO {
        List<PersonaVO> listaPersonaVo = null;
        List<SiiPersona> listaPersona = personaDAO.buscarPersonaPorNombre(nombre);
        if (listaPersona != null && listaPersona.size() > 0) {
            listaPersonaVo = new ArrayList<PersonaVO>();
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }

    public List<PersonaVO> buscarPersonaPorNombreId(String nombre, Long numIdentificacion) throws ExcepcionDAO {
        List<PersonaVO> listaPersonaVo = null;
        List<SiiPersona> listaPersona = personaDAO.buscarPersonaPorNombreId(nombre, numIdentificacion);
        if (listaPersona != null && listaPersona.size() > 0) {
            listaPersonaVo = new ArrayList<PersonaVO>();
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }

    public List<PersonaVO> buscarPersonaProveedores() throws ExcepcionDAO {
        List<PersonaVO> listaPersonaVo = null;
        List<SiiPersona> listaPersona = personaDAO.buscarPersonaProveedores();
        if (listaPersona != null && listaPersona.size() > 0) {
            listaPersonaVo = new ArrayList<PersonaVO>();
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }


    public List<PersonaVO> buscarPorRangoPaginacion(Integer first, Integer last, String sortField,
                                                    String sortOrder) throws ExcepcionDAO {
        List<PersonaVO> listaPersonaVo = null;
        List<SiiPersona> listaPersona = personaDAO.buscarPorRangoPaginacion(first, last, sortField, sortOrder);
        if (listaPersona != null && listaPersona.size() > 0) {
            listaPersonaVo = new ArrayList<PersonaVO>();
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }

    /**
     * @author Giovanni
     * @param proveedorVO
     * @return
     * @throws ExcepcionDAO
     */
    public void registrarProveedor(ProveedorVO proveedorVO) throws ExcepcionDAO {

        SiiPersona siiPersona = new SiiPersona();
        SiiProveedor siiProveedor = new SiiProveedor();

        /*
         * Se persiste primero la persona
         */
        siiPersona = conversionVoEntidad.convertir(proveedorVO.getPersonaVo());
        if (siiPersona.getPerCodigo() != null && siiPersona.getPerCodigo().longValue() != 0) {

            /*
             * Informacion representante Legal
             */
            if (proveedorVO.getPersonaVo().getPerTipoPersona().equals("J")) {
                SiiPersona siiPersonaRepresentanteLegal = new SiiPersona();
                siiPersonaRepresentanteLegal =
                    conversionVoEntidad.convertir(proveedorVO.getPersonaVo().getPersonaRepresentanteVo());
                if (siiPersonaRepresentanteLegal.getPerCodigo() != null) {
                    personaDAO.actualizarPersona(siiPersonaRepresentanteLegal);
                } else {
                    siiPersonaRepresentanteLegal.setPerTipoPersona("N");
                    personaDAO.insertarPersona(siiPersonaRepresentanteLegal);
                    proveedorVO.getPersonaVo().getPersonaRepresentanteVo().setPerCodigo(siiPersonaRepresentanteLegal.getPerCodigo());
                    proveedorVO.getPersonaVo().getPersonaRepresentanteVo().setPerTipoPersona(siiPersonaRepresentanteLegal.getPerTipoPersona());
                }
            }

            /*
             * Actualizacion Persona
             */
            personaDAO.actualizarPersona(siiPersona);

            /*
             * Informacion Bancaria
             */
            if (proveedorVO.getPersonaVo().getPersonaCtaBancoList() != null &&
                !proveedorVO.getPersonaVo().getPersonaCtaBancoList().isEmpty()) {
                for (PersonaCtaBancoVO personaCtaBancoVO : proveedorVO.getPersonaVo().getPersonaCtaBancoList()) {
                    SiiPersonaCtaBanco siiPersonaCtaBanco = new SiiPersonaCtaBanco();

                    /*
                 * Agregamos la persona
                 */
                    personaCtaBancoVO.setPersonaVo(new PersonaVO(siiPersona));
                    siiPersonaCtaBanco = conversionVoEntidad.convertir(personaCtaBancoVO);

                    if (siiPersonaCtaBanco.getPcbCodigo() != null) {
                        personaCtaBancoDAO.actualizarPersonaCtaBanco(siiPersonaCtaBanco);
                    } else {

                        /*
                     * Creamos la cuenta banco persona
                     */
                        SiiCuentaBancoPersona siiCuentaBancoPersona = new SiiCuentaBancoPersona();
                        siiCuentaBancoPersona =
                            conversionVoEntidad.convertir(personaCtaBancoVO.getCuentaBancoPersonaVo());

                        //Ingresamos el estado de la cuenta Banco persona
                        siiCuentaBancoPersona.setCbpActivo("A");
                        cuentaBancoPersonaDAO.insertarPersona(siiCuentaBancoPersona);
                        siiPersonaCtaBanco.setSiiCuentaBancoPersona(siiCuentaBancoPersona);

                        personaCtaBancoDAO.insertarPersonaCtaBanco(siiPersonaCtaBanco);
                        personaCtaBancoVO.setPcbCodigo(siiPersonaCtaBanco.getPcbCodigo());
                    }
                }
            }

            /*
             * Luego se persiste la persona como proveedor
             */
            siiProveedor = conversionVoEntidad.convertir(proveedorVO);
            if (siiProveedor != null) {
                if (siiProveedor.getProCodigo() != null && siiProveedor.getProCodigo().longValue() != 0) {
                    proveedorDAo.actualizarProveedor(siiProveedor);
                } else {
                    proveedorDAo.insertarProveedor(siiProveedor);
                }
            }
        } else {

            /*
             * Informacion representante Legal
             */
            if (proveedorVO.getPersonaVo().getPerTipoPersona().equals("J")) {
                SiiPersona siiPersonaRepresentanteLegal = new SiiPersona();
                siiPersonaRepresentanteLegal =
                    conversionVoEntidad.convertir(proveedorVO.getPersonaVo().getPersonaRepresentanteVo());
                if (siiPersonaRepresentanteLegal.getPerCodigo() != null) {
                    personaDAO.actualizarPersona(siiPersonaRepresentanteLegal);
                } else {
                    siiPersonaRepresentanteLegal.setPerTipoPersona("N");
                    personaDAO.insertarPersona(siiPersonaRepresentanteLegal);
                    proveedorVO.getPersonaVo().getPersonaRepresentanteVo().setPerCodigo(siiPersonaRepresentanteLegal.getPerCodigo());
                    proveedorVO.getPersonaVo().getPersonaRepresentanteVo().setPerTipoPersona(siiPersonaRepresentanteLegal.getPerTipoPersona());
                }

                siiPersona.setSiiPersona(siiPersonaRepresentanteLegal);
            }

            /*
             * Registro Persona
             */
            personaDAO.insertarPersona(siiPersona);
            proveedorVO.getPersonaVo().setPerCodigo(siiPersona.getPerCodigo());

            /*
             * Informacion Bancaria
             */
            if (proveedorVO.getPersonaVo().getPersonaCtaBancoList() != null &&
                !proveedorVO.getPersonaVo().getPersonaCtaBancoList().isEmpty()) {
                for (PersonaCtaBancoVO personaCtaBancoVO : proveedorVO.getPersonaVo().getPersonaCtaBancoList()) {
                    SiiPersonaCtaBanco siiPersonaCtaBanco = new SiiPersonaCtaBanco();

                    /*
                 * Agregamos la persona
                 */
                    personaCtaBancoVO.setPersonaVo(new PersonaVO(siiPersona));
                    siiPersonaCtaBanco = conversionVoEntidad.convertir(personaCtaBancoVO);

                    if (siiPersonaCtaBanco.getPcbCodigo() != null) {
                        personaCtaBancoDAO.actualizarPersonaCtaBanco(siiPersonaCtaBanco);
                    } else {

                        /*
                     * Creamos la cuenta banco persona
                     */
                        SiiCuentaBancoPersona siiCuentaBancoPersona = new SiiCuentaBancoPersona();
                        siiCuentaBancoPersona =
                            conversionVoEntidad.convertir(personaCtaBancoVO.getCuentaBancoPersonaVo());

                        //Ingresamos el estado de la cuenta Banco persona
                        siiCuentaBancoPersona.setCbpActivo("A");
                        cuentaBancoPersonaDAO.insertarPersona(siiCuentaBancoPersona);
                        siiPersonaCtaBanco.setSiiCuentaBancoPersona(siiCuentaBancoPersona);

                        personaCtaBancoDAO.insertarPersonaCtaBanco(siiPersonaCtaBanco);
                        personaCtaBancoVO.setPcbCodigo(siiPersonaCtaBanco.getPcbCodigo());
                    }
                }
            }

            /*
             * Luego se persiste la persona como proveedor
             */
            siiProveedor = conversionVoEntidad.convertir(proveedorVO);
            proveedorDAo.insertarProveedor(siiProveedor);
        }
    }

    public List<PersonaVO> buscarPorFiltros(Map<String, Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO 
    {
        List<PersonaVO> listaPersonaVo = null;
        List<SiiPersona> listaPersona = personaDAO.buscarPorFiltros(filtros, sortField, sortOrder);
        if (listaPersona != null && listaPersona.size() > 0) {
            listaPersonaVo = new ArrayList<PersonaVO>();
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }

    public List<PersonaVO> buscarPorFiltrosYPaginacion(Map<String, Object> filtros, String sortField, String sortOrder, Integer first, Integer last) throws ExcepcionDAO 
    {
        List<PersonaVO> listaPersonaVo = null;
        List<SiiPersona> listaPersona =
            personaDAO.buscarPorFiltrosYPaginacion(filtros, sortField, sortOrder, first, last);
        if (listaPersona != null && listaPersona.size() > 0) {
            listaPersonaVo = new ArrayList<PersonaVO>();
            for (SiiPersona unaPersona : listaPersona) {
                listaPersonaVo.add(new PersonaVO(unaPersona));
            }
        }
        return listaPersonaVo;
    }

    public Integer obtenerRowCount() throws ExcepcionDAO {
        return (personaDAO.obtenerRowCount());
    }

    public PersonaVO actualizarProveedor(PersonaVO personaVo, PersonaVO personaRepLegalVo,
                                         List<ResponDianPersonaVO> listaAddResponDianPersonaVo,
                                         List<ResponDianPersonaVO> listaRemoveResponDianPersonaVo,
                                         List<ActividadIcaPersVO> listaAddActividadIcaPersVo,
                                         List<ActividadIcaPersVO> listaRemoveActividadIcaPersVo) throws ExcepcionDAO {

        SiiPersona unaPersonaRepLegal = new SiiPersona();
        if (personaRepLegalVo != null) {
            SiiPersona personaRepLegal = conversionVoEntidad.convertir(personaRepLegalVo);
            if (personaRepLegal.getPerCodigo() != null) {
                unaPersonaRepLegal = personaDAO.actualizarPersona(personaRepLegal);
            } else {
                unaPersonaRepLegal = personaDAO.insertarPersona(personaRepLegal);
            }
        }
        SiiPersona persona = conversionVoEntidad.convertir(personaVo);
        persona.setSiiPersona(unaPersonaRepLegal);
        SiiPersona unaPersona;
        if (persona.getPerCodigo() != null) {
            unaPersona = personaDAO.actualizarPersona(persona);
        } else {
            unaPersona = personaDAO.insertarPersona(persona);
        }
        SiiProveedor proveedor = new SiiProveedor();
        proveedor.setSiiPersona(unaPersona);
        proveedor = proveedorDAo.buscarProveedorPorPersona(personaVo);
        proveedor = proveedorDAo.actualizarProveedor(proveedor);

        if (listaAddResponDianPersonaVo != null) {
            for (ResponDianPersonaVO unaResponDianPersonaVo : listaAddResponDianPersonaVo) {
                SiiResponDianPersona nuevoResponDianPersona = conversionVoEntidad.convertir(unaResponDianPersonaVo);
                nuevoResponDianPersona.setSiiPersona(unaPersona);
                responDianPersonaDao.insertar(nuevoResponDianPersona);
            }
        }

        if (listaAddActividadIcaPersVo != null) {
            for (ActividadIcaPersVO actividadIcaPersVo : listaAddActividadIcaPersVo) {
                SiiActividadIcaPers nuevaActividadIcaPers = conversionVoEntidad.convertir(actividadIcaPersVo);
                nuevaActividadIcaPers.setSiiPersona(unaPersona);
                actividadIcaPersDao.insertar(nuevaActividadIcaPers);
            }
        }

        if (listaRemoveResponDianPersonaVo != null) {
            for (ResponDianPersonaVO responDianPersonaVo : listaRemoveResponDianPersonaVo) {
                SiiResponDianPersona nuevoResponDianPersona = conversionVoEntidad.convertir(responDianPersonaVo);
                if (nuevoResponDianPersona.getRdpCodigo() != null) {
                    responDianPersonaDao.eliminar(nuevoResponDianPersona.getRdpCodigo());
                }
            }
        }


        if (listaRemoveActividadIcaPersVo != null) {
            for (ActividadIcaPersVO actividadIcaPersVo : listaRemoveActividadIcaPersVo) {
                SiiActividadIcaPers nuevoActividadIcaPers = conversionVoEntidad.convertir(actividadIcaPersVo);
                if (nuevoActividadIcaPers.getAipCodigo() != null) {
                    responDianPersonaDao.eliminar(nuevoActividadIcaPers.getAipCodigo());
                }
            }
        }

        return new PersonaVO(unaPersona);
    }

    public Integer obtenerRowCount(Map<String, Object> filtros) throws ExcepcionDAO {
        return (personaDAO.obtenerRowCount(filtros));
    }


    public PersonaVO buscarPersonaPorTipoYNumeroIdentificacion(Long tidCodigo,
                                                               String perNumIdentificacion) throws ExcepcionDAO {
        PersonaVO personaVo = null;
        SiiPersona siiPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(tidCodigo, perNumIdentificacion);
        if (siiPersona != null) {
            personaVo = new PersonaVO(siiPersona);
        }
        return (personaVo);
    }

    /**
     * @author Giovanni
     * @param tidCodigo
     * @param perNumIdentificacion
     * @return
     * @throws ExcepcionDAO
     */
    public ProveedorVO buscarPersonaProveedorPorTipoYNumeroIdentificacion(Long tidCodigo,
                                                                          String perNumIdentificacion) throws ExcepcionDAO {
        ProveedorVO proveedorVO = new ProveedorVO();

        /*
         * Consultamos primero la persona
         */
        SiiPersona siiPersona = null;
        siiPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(tidCodigo, perNumIdentificacion);
        if (siiPersona != null) {
            if (siiPersona.getPerCodigo() != null && siiPersona.getPerCodigo().longValue() != 0) {
                PersonaVO personaVO = new PersonaVO(siiPersona);

                List<SiiPersonaCtaBanco> siiPersonaCtaBancos = null;
                siiPersonaCtaBancos = personaCtaBancoDAO.buscarPorCodigoPersona(personaVO.getPerCodigo());

                if (siiPersonaCtaBancos != null && !siiPersonaCtaBancos.isEmpty()) {
                    personaVO.setPersonaCtaBancoList(new ArrayList<PersonaCtaBancoVO>());
                    for (SiiPersonaCtaBanco siiPersonaCtaBanco : siiPersonaCtaBancos) {
                        PersonaCtaBancoVO personaCtaBancoVO = new PersonaCtaBancoVO(siiPersonaCtaBanco);
                        personaVO.getPersonaCtaBancoList().add(personaCtaBancoVO);
                    }
                }

                /*
                * consultamos el proveedor si esta relacionado con esa persona
                */
                SiiProveedor siiProveedor = null;
                siiProveedor = proveedorDAo.buscarProveedorPorPersona(personaVO);
                if (siiProveedor != null) {
                    if (siiProveedor.getProCodigo() != null && siiProveedor.getProCodigo().longValue() != 0) {
                        proveedorVO = new ProveedorVO(siiProveedor);
                    }
                }
                proveedorVO.setPersonaVo(personaVO);
            }
        }
        return proveedorVO;
    }

    /**
     * Se encarga de devolver todas la personas que sea operadores potenciales y provedores
     * @autor Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<PersonaVO> buscarPersonaOperadorPotencialYProveedor() throws ExcepcionDAO {
        List<PersonaVO> personaVOs = new ArrayList<PersonaVO>();

        //Operadores Autorizados
        List<SiiPersona> siiPersonasAutorizados = new ArrayList<SiiPersona>();
        siiPersonasAutorizados = personaDAO.buscarPersonaOperadorPotencialAutorizado();
        //Operadores Potenciales
        List<SiiPersona> siiPersonasPotenciales = new ArrayList<SiiPersona>();
        siiPersonasPotenciales = personaDAO.buscarPersonaOperadorPotencial();
        //Proveedores de Tecnologia
        List<SiiPersona> siiPersonasProveedoresTec = new ArrayList<SiiPersona>();
        siiPersonasProveedoresTec = personaDAO.buscarPersonaProveedorTecnologia();

        //Lllenamos las empresas Autorizadas con su tipo
        for (SiiPersona siiPersona : siiPersonasAutorizados) {
            PersonaVO personaVO = new PersonaVO(siiPersona);
            personaVO.setTipoEmpresa("Operador Autorizado");
            personaVOs.add(personaVO);
        }

        //Lllenamos las empresas Potenciales con su tipo
        for (SiiPersona siiPersona : siiPersonasPotenciales) {
            PersonaVO personaVO = new PersonaVO(siiPersona);
            personaVO.setTipoEmpresa("Operador Potencial");
            personaVOs.add(personaVO);
        }

        //Lllenamos las empresas Proveedores de tecnologia con su tipo
        for (SiiPersona siiPersona : siiPersonasProveedoresTec) {
            PersonaVO personaVO = new PersonaVO(siiPersona);
            personaVO.setTipoEmpresa("Proveedor de Tecnologia");
            personaVOs.add(personaVO);
        }
        return personaVOs;
    }

    /**
     * Se encarga de registrar una persona con sus contactos y su informacion financiera
     * @autor Giovanni
     * @throws ExcepcionDAO
     */
    public void registroPersonaCompleta(PersonaVO personaVO, List<PersonalEmpresaVO> personalEmpresaVOs,
                                        List<DetalleFinancVO> detalleFinancVOs, List<HitosEmpresaVO> hitosEmpresaVOs,
                                        boolean esOperadorPotencial, boolean esProveedorTec) throws ExcepcionDAO {

        /*
         * Creamos la persona
         */
        SiiPersona siiPersona = new SiiPersona();
        siiPersona = conversionVoEntidad.convertir(personaVO);
        personaDAO.insertarPersona(siiPersona);
        personaVO.setPerCodigo(siiPersona.getPerCodigo());

        /*
         * Verificamos que tipo de personal es operador potencial
         */
        if (esOperadorPotencial) {
            SiiOperador siiOperador = new SiiOperador();
            siiOperador.setOpePotencial("S");
            siiOperador.setSiiPersona(siiPersona);
            operadorDAO.insertarSiiOperador(siiOperador);
        }

        /*
         * Verificamos que tipo de personal es proveedor de tecnologia
         */
        if (esProveedorTec) {
            SiiProveedorTecn siiProveedorTecn = new SiiProveedorTecn();
            siiProveedorTecn.setSiiPersona(siiPersona);
            proveedorTecnDAO.insertarProveedorTecn(siiProveedorTecn);
        }

        /*
         *Creamos los contactos para esta persona
         */
        for (PersonalEmpresaVO personalEmpresaVO : personalEmpresaVOs) {
            SiiPersonalEmpresa siiPersonalEmpresa = new SiiPersonalEmpresa();

            /*
             * persistimos primero los datos del contacto verificando que no se encuentre ya en la base de datos
             */
            SiiPersona siiPersonaCont = new SiiPersona();
            siiPersonaCont = conversionVoEntidad.convertir(personalEmpresaVO.getPersonaVo());
            if (siiPersonaCont.getPerCodigo() != null) {
                personaDAO.actualizarPersona(siiPersonaCont);
            } else {
                personaDAO.insertarPersona(siiPersonaCont);
                personalEmpresaVO.getPersonaVo().setPerCodigo(siiPersonaCont.getPerCodigo());
            }

            /*
             * Persistimos la relacion con el contacto
             */
            siiPersonalEmpresa = conversionVoEntidad.convertir(personalEmpresaVO);
            personalEmpresaDAO.insertarSiiPersonalEmpresa(siiPersonalEmpresa);
            personalEmpresaVO.setPemCodigo(siiPersonalEmpresa.getPemCodigo());
        }

        /*
         * Creamos los hitos para esta persona
         */
        for (HitosEmpresaVO hitosEmpresaVO : hitosEmpresaVOs) {
            SiiHitosEmpresa siiHitosEmpresa = new SiiHitosEmpresa();

            //Agregamos la persona
            hitosEmpresaVO.setPersonaVO(personaVO);

            /*
             * Persistimos la relacion con los hitos
             */
            siiHitosEmpresa = conversionVoEntidad.convertir(hitosEmpresaVO);
            hitosEmpresaDAO.insertarHitosEmpresa(siiHitosEmpresa);
            hitosEmpresaVO.setHemCodigo(siiHitosEmpresa.getHemCodigo());
        }

        /*
        * Creamos la informacion financiera
        */
        for (DetalleFinancVO detalleFinancVO : detalleFinancVOs) {
            SiiDetalleFinanc siiDetalleFinanc = new SiiDetalleFinanc();

            //Agregamos la informacion finanaciera
            detalleFinancVO.setPersonaVo(personaVO);

            siiDetalleFinanc = conversionVoEntidad.convertir(detalleFinancVO);
            detalleFinancDAO.insertarSiiDetalleFinanc(siiDetalleFinanc);
            detalleFinancVO.setDfiCodigo(siiDetalleFinanc.getDfiCodigo());
        }
    }


    /**
     * Se encarga de actualizar una persona con sus contactos y su informacion financiera
     * @autor Giovanni
     * @throws ExcepcionDAO
     */
    public void actualizarPersonaCompleta(PersonaVO personaVO, List<PersonalEmpresaVO> personalEmpresaVOs,
                                          List<DetalleFinancVO> detalleFinancVOs, List<HitosEmpresaVO> hitosEmpresaVOs,
                                          boolean esOperadorPotencial, boolean esProveedorTec) throws ExcepcionDAO {

        /*
         * Actualizamos la persona
         */
        SiiPersona siiPersona = new SiiPersona();
        siiPersona = conversionVoEntidad.convertir(personaVO);
        personaDAO.actualizarPersona(siiPersona);

        /*
         * ****************** Inicio Actualizacion Contacto*************************************
         * *************************************************************************************
        */

        /*
         * Actualizamos  los contactos para esta persona
         */
        List<SiiPersonalEmpresa> siiPersonalEmpresas = new ArrayList<SiiPersonalEmpresa>();
        siiPersonalEmpresas = personalEmpresaDAO.buscarPersonalEmpresaPorIdPersona(personaVO.getPerCodigo());

        /*
         * Preguntamos si la lista en la base de datos esta vacia y la lista del Mb esta llena
         * para persistir nuevos contactos
         */
        if (siiPersonalEmpresas.isEmpty() && !personalEmpresaVOs.isEmpty()) {
            /*
             *Creamos los contactos para esta persona
             */
            for (PersonalEmpresaVO personalEmpresaVO : personalEmpresaVOs) {
                SiiPersonalEmpresa siiPersonalEmpresa = new SiiPersonalEmpresa();

                /*
                 * persistimos primero los datos del contacto
                 */
                personalEmpresaVO.getPersonaVo().setPerCodigo(personaVO.getPerCodigo());

                /*
                 * Persistimos la relacion con el contacto
                 */
                siiPersonalEmpresa = conversionVoEntidad.convertir(personalEmpresaVO);
                personalEmpresaDAO.insertarSiiPersonalEmpresa(siiPersonalEmpresa);
                personalEmpresaVO.setPemCodigo(siiPersonalEmpresa.getPemCodigo());
            }

        }

        /*
         * Preguntamos si la lista en la base de datos esta llena  y la lista del Mb esta vacia
         * para eliminar los contactos
         */
        if (!siiPersonalEmpresas.isEmpty() && personalEmpresaVOs.isEmpty()) {
            for (SiiPersonalEmpresa siiPersonalEmpresa : siiPersonalEmpresas) {
                personalEmpresaDAO.eliminarSiiPersonalEmpresa(siiPersonalEmpresa);
            }
        }

        /*
         * Preguntamos si hambas listas vienen llenas
         */

        /*
         * Atualizar el contacto
         */
        if (!siiPersonalEmpresas.isEmpty() && !personalEmpresaVOs.isEmpty()) {

            /*
             * verificamcos que todos los contactos esten en el MB de lo contrario se procedera a eliminarlos
             */
            for (SiiPersonalEmpresa siiPersonalEmpresa : siiPersonalEmpresas) {
                boolean estaPersonaEmpresaMB = false;
                for (PersonalEmpresaVO personalEmpresaVO : personalEmpresaVOs) {
                    if (siiPersonalEmpresa.getPemCodigo() == personalEmpresaVO.getPemCodigo()) {
                        estaPersonaEmpresaMB = true;
                        break;
                    }
                }

                if (!estaPersonaEmpresaMB) {
                    personalEmpresaDAO.eliminarSiiPersonalEmpresa(siiPersonalEmpresa);
                }
            }

            /*
             *Verificamos que la informacion que llege sea actulizada y que la que no tengoa codigo sea guardada
             */
            for (PersonalEmpresaVO personalEmpresaVO : personalEmpresaVOs) {
                if (personalEmpresaVO.getPemCodigo() != null) {
                    SiiPersona siiPersonaContacto = new SiiPersona();
                    siiPersonaContacto = conversionVoEntidad.convertir(personalEmpresaVO.getPersonaVo());
                    personaDAO.actualizarPersona(siiPersonaContacto);
                } else {
                    SiiPersonalEmpresa siiPersonalEmpresa = new SiiPersonalEmpresa();

                    /*
                     * persistimos primero los datos del contacto
                     */
                    personalEmpresaVO.getPersonaVo().setPerCodigo(personaVO.getPerCodigo());

                    /*
                     * Persistimos la relacion con el contacto
                     */
                    siiPersonalEmpresa = conversionVoEntidad.convertir(personalEmpresaVO);
                    personalEmpresaDAO.insertarSiiPersonalEmpresa(siiPersonalEmpresa);
                    personalEmpresaVO.setPemCodigo(siiPersonalEmpresa.getPemCodigo());
                }
            }
        }

        /*
        * ******************Fin Actualizacion Contacto*************************************
        * *************************************************************************************
        */

        /*
         * ****************** Inicio Actualizacion Hitos *************************************
         * *************************************************************************************
        */

        /*
         * Actualizamos los hitos para esta persona
         */
        List<SiiHitosEmpresa> siiHitosEmpresas = new ArrayList<SiiHitosEmpresa>();
        siiHitosEmpresas = hitosEmpresaDAO.buscarHitosEmpresaXCodigoPersonal(personaVO.getPerCodigo());

        /*
         * Preguntamos si la lista en la base de datos esta vacia y la lista del Mb esta llena
         * para persistir nuevos contactos
         */
        if (siiHitosEmpresas.isEmpty() && !hitosEmpresaVOs.isEmpty()) {
            /*
             * Creamos los hitos para esta persona
             */
            for (HitosEmpresaVO hitosEmpresaVO : hitosEmpresaVOs) {
                SiiHitosEmpresa siiHitosEmpresa = new SiiHitosEmpresa();

                //Agregamos la persona
                hitosEmpresaVO.setPersonaVO(personaVO);

                /*
                 * Persistimos la relacion con los hitos
                 */
                siiHitosEmpresa = conversionVoEntidad.convertir(hitosEmpresaVO);
                hitosEmpresaDAO.insertarHitosEmpresa(siiHitosEmpresa);
                hitosEmpresaVO.setHemCodigo(siiHitosEmpresa.getHemCodigo());
            }
        }

        /*
         * Preguntamos si la lista en la base de datos esta llena  y la lista del Mb esta vacia
         * para eliminar los hitos
         */
        if (!siiHitosEmpresas.isEmpty() && hitosEmpresaVOs.isEmpty()) {
            for (SiiHitosEmpresa siiHitosEmpresa : siiHitosEmpresas) {
                hitosEmpresaDAO.eliminarHitosEmpresa(siiHitosEmpresa);
            }
        }

        /*
         * Preguntamos si hambas listas vienen llenas
         */

        if (!siiHitosEmpresas.isEmpty() && !hitosEmpresaVOs.isEmpty()) {

            /*
             * verificamcos que todos los contactos esten en el MB de lo contrario se procedera a eliminarlos
             */
            for (SiiHitosEmpresa siiHitosEmpresa : siiHitosEmpresas) {
                boolean estaHitoEmpresaMB = false;
                for (HitosEmpresaVO hitosEmpresaVO : hitosEmpresaVOs) {
                    if (siiHitosEmpresa.getHemCodigo() == hitosEmpresaVO.getHemCodigo()) {
                        estaHitoEmpresaMB = true;
                        break;
                    }
                }

                if (!estaHitoEmpresaMB) {
                    hitosEmpresaDAO.eliminarHitosEmpresa(siiHitosEmpresa);
                }
            }

            /*
             *Verificamos que la informacion que llege sea actulizada y que la que no tengoa codigo sea guardada
             */
            for (HitosEmpresaVO hitosEmpresaVO : hitosEmpresaVOs) {
                if (hitosEmpresaVO.getHemCodigo() != null) {
                    SiiHitosEmpresa siiHitosEmpresa = new SiiHitosEmpresa();
                    siiHitosEmpresa = conversionVoEntidad.convertir(hitosEmpresaVO);
                    hitosEmpresaDAO.actualizarHitosEmpresa(siiHitosEmpresa);
                } else {
                    SiiHitosEmpresa siiHitosEmpresa = new SiiHitosEmpresa();

                    //Agregamos la persona
                    hitosEmpresaVO.setPersonaVO(personaVO);

                    /*
                     * Persistimos la relacion con los hitos
                     */
                    siiHitosEmpresa = conversionVoEntidad.convertir(hitosEmpresaVO);
                    hitosEmpresaDAO.insertarHitosEmpresa(siiHitosEmpresa);
                    hitosEmpresaVO.setHemCodigo(siiHitosEmpresa.getHemCodigo());
                }
            }
        }
        /*
         * ****************** Fin Actualizacion Hitos *************************************
         * *************************************************************************************
        */

        /*
         * ****************** Inicio Actualizacion Estados financieros *************************************
         * *************************************************************************************
        */

        /*
         * Actualizamos los estados financieros para esta persona
         */
        List<SiiDetalleFinanc> siiDetalleFinancs = new ArrayList<SiiDetalleFinanc>();
        siiDetalleFinancs = detalleFinancDAO.buscarDetallesFinancierosXPersona(personaVO.getPerCodigo());

        /*
         * Preguntamos si la lista en la base de datos esta vacia y la lista del Mb esta llena
         * para persistir nuevos estadod finacieros
         */
        if (siiDetalleFinancs.isEmpty() && !detalleFinancVOs.isEmpty()) {

            /*
             * Creamos los estados financieros para esta persona
             */
            for (DetalleFinancVO detalleFinancVO : detalleFinancVOs) {
                SiiDetalleFinanc siiDetalleFinanc = new SiiDetalleFinanc();

                //Agregamos el estado financiero
                detalleFinancVO.setPersonaVo(personaVO);

                /*
                 * Persistimos la relacion con los hitos
                 */
                siiDetalleFinanc = conversionVoEntidad.convertir(detalleFinancVO);
                detalleFinancDAO.insertarSiiDetalleFinanc(siiDetalleFinanc);
                detalleFinancVO.setDfiCodigo(siiDetalleFinanc.getDfiCodigo());
            }
        }

        /*
         * Preguntamos si la lista en la base de datos esta llena  y la lista del Mb esta vacia
         * para eliminar los estados financieros
         */
        if (!siiDetalleFinancs.isEmpty() && detalleFinancVOs.isEmpty()) {
            for (SiiHitosEmpresa siiHitosEmpresa : siiHitosEmpresas) {
                detalleFinancDAO.borrarSiiDetalleFinanc(siiHitosEmpresa.getHemCodigo());
            }
        }

        /*
         * Preguntamos si ambas listas vienen llenas
         */
        if (!siiDetalleFinancs.isEmpty() && !detalleFinancVOs.isEmpty()) {

            /*
             * verificamcos que todos los estados financierso esten en el MB de lo contrario se procedera a eliminarlos
             */
            for (SiiDetalleFinanc siiDetalleFinanc : siiDetalleFinancs) {
                boolean estaDetalleEmpresaMB = false;
                for (DetalleFinancVO detalleFinancVO : detalleFinancVOs) {
                    if (siiDetalleFinanc.getDfiCodigo() == detalleFinancVO.getDfiCodigo()) {
                        estaDetalleEmpresaMB = true;
                        break;
                    }
                }

                if (!estaDetalleEmpresaMB) {
                    detalleFinancDAO.borrarSiiDetalleFinanc(siiDetalleFinanc.getDfiCodigo());
                }
            }

            /*
             *Verificamos que la informacion que llege sea actulizada y que la que no tengoa codigo sea guardada
             */
            for (DetalleFinancVO detalleFinancVO : detalleFinancVOs) {
                if (detalleFinancVO.getDfiCodigo() != null) {
                    SiiDetalleFinanc siiDetalleFinanc = new SiiDetalleFinanc();
                    siiDetalleFinanc = conversionVoEntidad.convertir(detalleFinancVO);
                    detalleFinancDAO.actualizarSiiDetalleFinanc(siiDetalleFinanc);
                } else {
                    SiiDetalleFinanc siiDetalleFinanc = new SiiDetalleFinanc();

                    //Agregamos la persona
                    detalleFinancVO.setPersonaVo(personaVO);

                    /*
                     * Persistimos la relacion con los estados financieros
                     */
                    siiDetalleFinanc = conversionVoEntidad.convertir(detalleFinancVO);
                    detalleFinancDAO.insertarSiiDetalleFinanc(siiDetalleFinanc);
                    detalleFinancVO.setDfiCodigo(siiDetalleFinanc.getDfiCodigo());
                }
            }
        }
        /*
         * ****************** Fin Actualizacion Estados financieros *************************************
         * *************************************************************************************
        */

    }

    /**
     * Metodo para traer todos los hitos para para la persona
     * @author Giovanni
     * @param codigoPersonal
     * @return
     * @throws ExcepcionDAO
     */
    public List<HitosEmpresaVO> buscarHitosEmpresaXCodigoPersonal(long codigoPersonal) throws ExcepcionDAO {
        List<HitosEmpresaVO> hitosEmpresaVOs = new ArrayList<HitosEmpresaVO>();
        List<SiiHitosEmpresa> siiHitosEmpresas = new ArrayList<SiiHitosEmpresa>();
        siiHitosEmpresas = hitosEmpresaDAO.buscarHitosEmpresaXCodigoPersonal(codigoPersonal);
        for (SiiHitosEmpresa siiHitosEmpresa : siiHitosEmpresas) {
            HitosEmpresaVO hitosEmpresaVO = new HitosEmpresaVO(siiHitosEmpresa);
            hitosEmpresaVOs.add(hitosEmpresaVO);
        }
        return hitosEmpresaVOs;
    }

    public PersonaVO buscarPersonaPersonalEmpresaXOperadorXTipoPersonal(long codigoOperadorPersona,
                                                                        long codigoTipoPersonal) throws ExcepcionDAO {
        PersonaVO personaRetornoVo = null;
        SiiPersona siiPersonaEmpresa =
            personaDAO.buscarPersonaPersonalEmpresaXOperadorXTipoPersonal(codigoOperadorPersona, codigoTipoPersonal);
        if (siiPersonaEmpresa != null) {
            personaRetornoVo = new PersonaVO(siiPersonaEmpresa);
        }
        return personaRetornoVo;
    }

    /**
     * Guarda los parametros contables para una persona
     * @author Giovanni
     * @throws ExcepcionDAO
     */
    public void guardarParametroContables(PersonaVO personaVO) throws ExcepcionDAO {

        /*
         * Creamos la persona
         */
        
        
        PersonaVO nuevaPersonaVO = new PersonaVO(personaDAO.actualizarPersona(conversionVoEntidad.convertir(personaVO)));


        /*
         * ****************** Inicio Actualizacion Actividades Economicas **********************
         * *************************************************************************************
        */

        /*
         * Actualizamos los Actividades Economicas para esta persona
         */
        List<SiiActividadIcaPers> siiActividadIcaPerss = new ArrayList<SiiActividadIcaPers>();
        siiActividadIcaPerss = actividadIcaPersDao.buscarPorCodigoPersona(personaVO.getPerCodigo());

        /*
         * Preguntamos si la lista en la base de datos esta vacia y la lista del Mb esta llena
         * para persistir nuevas Actividades Economicas
         */
        if (siiActividadIcaPerss.isEmpty() && !personaVO.getActividadIcaPersList().isEmpty()) {

            /*
             * Creamos los Actividades Economicas para esta persona
             */
            for (ActividadIcaPersVO actividadIcaPersVO : personaVO.getActividadIcaPersList()) {
                SiiActividadIcaPers siiActividadIcaPers = new SiiActividadIcaPers();

                /*
                 * Persistimos la relacion con las Actividades Economicas
                 */
                siiActividadIcaPers = conversionVoEntidad.convertir(actividadIcaPersVO);
                actividadIcaPersDao.insertar(siiActividadIcaPers);
                actividadIcaPersVO.setAipCodigo(siiActividadIcaPers.getAipCodigo());
            }
        }

        /*
         * Preguntamos si la lista en la base de datos esta llena  y la lista del Mb esta vacia
         * para eliminar las Actividades Economicas
         */
        if (!siiActividadIcaPerss.isEmpty() && personaVO.getActividadIcaPersList().isEmpty()) {
            for (SiiActividadIcaPers siiActividadIcaPers : siiActividadIcaPerss) {
                actividadIcaPersDao.eliminar(siiActividadIcaPers.getAipCodigo());
            }
        }

        /*
         * Preguntamos si ambas listas vienen llenas
         */
        if (!siiActividadIcaPerss.isEmpty() && !personaVO.getActividadIcaPersList().isEmpty()) {

            /*
             * verificamcos que todos las Actividades Economicas esten en el MB de lo contrario se procedera a eliminarlos
             */
            for (SiiActividadIcaPers siiActividadIcaPers : siiActividadIcaPerss) {
                boolean estaActividadesEconomicaMB = false;
                for (ActividadIcaPersVO actividadIcaPersVO : personaVO.getActividadIcaPersList()) {
                    if (siiActividadIcaPers.getAipCodigo() == actividadIcaPersVO.getAipCodigo()) {
                        estaActividadesEconomicaMB = true;
                        break;
                    }
                }

                if (!estaActividadesEconomicaMB) {
                    actividadIcaPersDao.eliminar(siiActividadIcaPers.getAipCodigo());
                }
            }

            /*
             *Verificamos que la informacion que llege sea actulizada y que la que no tengoa codigo sea guardada
             */
            for (ActividadIcaPersVO actividadIcaPersVO : personaVO.getActividadIcaPersList()) {
                if (actividadIcaPersVO.getAipCodigo() != null) {
                    SiiActividadIcaPers siiActividadIcaPers = new SiiActividadIcaPers();
                    siiActividadIcaPers = conversionVoEntidad.convertir(actividadIcaPersVO);
                    actividadIcaPersDao.actualizar(siiActividadIcaPers);
                } else {
                    SiiActividadIcaPers siiActividadIcaPers = new SiiActividadIcaPers();

                    /*
                     * Persistimos la relacion con Actividades Economicas
                     */
                    siiActividadIcaPers = conversionVoEntidad.convertir(actividadIcaPersVO);
                    actividadIcaPersDao.insertar(siiActividadIcaPers);
                    actividadIcaPersVO.setAipCodigo(siiActividadIcaPers.getAipCodigo());
                }
            }
        }
        /*
         * ****************** Fin Actualizacion  Actividades Economicas ************************
         * *************************************************************************************
        */


        /*
         * ****************** Inicio Actualizacion Responsabilidades Dian **********************
         * *************************************************************************************
        */

        /*
         * Actualizamos las Responsabilidades Dian para esta persona
         */
        List<SiiResponDianPersona> siiResponDianPersonas = new ArrayList<SiiResponDianPersona>();
        siiResponDianPersonas = responDianPersonaDao.buscarPorCodigoPersona(personaVO.getPerCodigo());

        /*
         * Preguntamos si la lista en la base de datos esta vacia y la lista del Mb esta llena
         * para persistir nuevas Responsabilidades Dian
         */
        if (siiResponDianPersonas.isEmpty() && !personaVO.getResponDianPersonaList().isEmpty()) {

            /*
             * Creamos las Responsabilidades Dian para esta persona
             */
            for (ResponDianPersonaVO responDianPersonaVO : personaVO.getResponDianPersonaList()) {
                SiiResponDianPersona siiResponDianPersona = new SiiResponDianPersona();

                /*
                 * Persistimos la relacion con las Responsabilidades Dian
                 */
                siiResponDianPersona = conversionVoEntidad.convertir(responDianPersonaVO);
                responDianPersonaDao.insertar(siiResponDianPersona);
                responDianPersonaVO.setRdpCodigo(siiResponDianPersona.getRdpCodigo());
            }
        }

        /*
         * Preguntamos si la lista en la base de datos esta llena  y la lista del Mb esta vacia
         * para eliminar las Responsabilidades Dian
         */
        if (!siiResponDianPersonas.isEmpty() && personaVO.getResponDianPersonaList().isEmpty()) {
            for (SiiResponDianPersona siiResponDianPersona : siiResponDianPersonas) {
                responDianPersonaDao.eliminar(siiResponDianPersona.getRdpCodigo());
            }
        }

        /*
         * Preguntamos si ambas listas vienen llenas
         */
        if (!siiResponDianPersonas.isEmpty() && !personaVO.getResponDianPersonaList().isEmpty()) {

            /*
             * verificamcos que todos las Responsabilidades Dian esten en el MB de lo contrario se procedera a eliminarlos
             */
            for (SiiResponDianPersona siiResponDianPersona : siiResponDianPersonas) {
                boolean estaResponDianMB = false;
                for (ResponDianPersonaVO responDianPersonaVO : personaVO.getResponDianPersonaList()) {
                    if (siiResponDianPersona.getRdpCodigo() == responDianPersonaVO.getRdpCodigo()) {
                        estaResponDianMB = true;
                        break;
                    }
                }

                if (!estaResponDianMB) {
                    responDianPersonaDao.eliminar(siiResponDianPersona.getRdpCodigo());
                }
            }

            /*
             *Verificamos que la informacion que llege sea actulizada y que la que no tengoa codigo sea guardada
             */
            for (ResponDianPersonaVO responDianPersonaVO : personaVO.getResponDianPersonaList()) {
                if (responDianPersonaVO.getRdpCodigo() != null) {
                    SiiResponDianPersona siiResponDianPersona = new SiiResponDianPersona();
                    siiResponDianPersona = conversionVoEntidad.convertir(responDianPersonaVO);
                    responDianPersonaDao.actualizar(siiResponDianPersona);
                } else {
                    SiiResponDianPersona siiResponDianPersona = new SiiResponDianPersona();

                    /*
                     * Persistimos la relacion con Responsabilidades Dian
                     */
                    siiResponDianPersona = conversionVoEntidad.convertir(responDianPersonaVO);
                    responDianPersonaDao.insertar(siiResponDianPersona);
                    responDianPersonaVO.setRdpCodigo(siiResponDianPersona.getRdpCodigo());
                }
            }
        }
        /*
         * ****************** Fin Actualizacion Responsabilidades Dian *************************
         * *************************************************************************************
        */
    }
    //Por Gatopardo
    //Comentariado, solo se debe buscar personas por tipo de identificación y número
    /*
    public PersonaVO buscarPersonaXNumeroIdentificacion(String perNumIdentificacion) throws ExcepcionDAO
    {
        PersonaVO personaVo = null;
        SiiPersona siiPersona = personaDAO.buscarPersonaXNumeroIdentificacion(perNumIdentificacion);
        if (siiPersona != null)
            personaVo = new PersonaVO(siiPersona);

        return (personaVo);
    }
    */
    public String buscarNombreFuncionario(String cargo, String activo) throws ExcepcionDAO {
        return personaDAO.buscarNombreFuncionario(cargo, activo);
    }
    
    public PersonaVO buscarPersonaXNombreFuncionario(String cargo, String activo) throws ExcepcionDAO {
        PersonaVO personaRetornoVo = null;
        SiiPersona siiPersona =
            personaDAO.buscarPersonaXNombreFuncionario(cargo, activo);
        if (siiPersona != null) {
            personaRetornoVo = new PersonaVO(siiPersona);
        }
        return personaRetornoVo;
    }
    
    public List<PersonaVO> buscarPersonaXCodigoOperador(PersonaVO personaVo) throws ExcepcionDAO {
        List<PersonaVO> resultado = null;
        SiiPersona siiPersona = new SiiPersona();
        
        siiPersona  = conversionVoEntidad.convertir(personaVo);
        
        
        List<SiiPersona> lista = personaDao.buscarPersonaXCodigoOperador(siiPersona);
       
            if (lista!=null) {
            resultado = new ArrayList<PersonaVO>();
            
            for (SiiPersona sPersona: lista) {
                
                if (siiPersona!=null)
                    resultado.add(new PersonaVO(sPersona));
            }
        }       
        return resultado;
    }
    
}
