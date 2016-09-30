/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Seguridad
 * AUTOR	: Diego Alvarado
 * FECHA	: 12-09-2013
 */


package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogGeneral;
import co.gov.coljuegos.siicol.ejb.negocio.sistema.AdminParametrosSistema;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoUsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuncionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.DirectorioActivo;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.util.ServiciosCrypto;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;


@Stateless

public class AdminUsuarioBean implements AdminUsuario {
    @Resource
    SessionContext sessionContext;

    @EJB
    private UsuarioDAO usuarioDao;
    @EJB
    private EstadoUsuarioDAO estadoUsuarioDao;
    @EJB
    private FuncionDAO funcionDao;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private AdminLogGeneral adminLogGeneral;
    @EJB
    private AdminParametrosSistema adminParametrosSistema;

    private String url_directorio = null;
    private String dominio_directorio = null;
    private Recursos recursos = null;

    public AdminUsuarioBean() {
        recursos = new Recursos();
        url_directorio = recursos.obtenerRecurso("URL_DIRECTORIO", "recursos");
        dominio_directorio = recursos.obtenerRecurso("DOMINIO_DIRECTORIO", "recursos");
    }

    public UsuarioVO insertarUsuario(UsuarioVO usuarioVo) throws ExcepcionDAO {
        usuarioVo.setUsuNombreUsuario(usuarioVo.getUsuNombreUsuario().toUpperCase());
        SiiUsuario siiUsuario = conversionVoEntidad.convertir(usuarioVo);
        SiiUsuario siiUsuarioRetorno = usuarioDao.insertarUsuario(siiUsuario);
        return new UsuarioVO(siiUsuarioRetorno);
    }

    public UsuarioVO buscarUsuarioPorId(UsuarioVO usuarioVo) throws ExcepcionDAO {
        SiiUsuario unSiiUsuario = usuarioDao.buscarUsuarioPorId(usuarioVo.getUsuCodigo());
        return new UsuarioVO(unSiiUsuario);
    }

    /**
     * @author Modifica Giovanni
     * @param usuarioVo
     * @param usuarioLogueado
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public void actualizarUsuario(UsuarioVO usuarioVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        SiiUsuario siiUsuarioTemp = new SiiUsuario();
        siiUsuarioTemp = usuarioDao.buscarUsuarioXId(usuarioVo.getUsuCodigo());
        if (siiUsuarioTemp.getSiiEstadoUsuario().getEusCodigo() != usuarioVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del usuario fue cambiado durante la modificación. Seleccione nuevamente el usuario");
        }

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (usuarioVo.getEstadoUsuarioVo().getEusCodigo() != usuarioVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.USUARIO.getId(), usuarioVo.getEstadoUsuarioVo().getEusCodigo(), usuarioLogueado, usuarioVo.getUsuCodigo());
        }

        SiiUsuario siiUsuario = conversionVoEntidad.convertir(usuarioVo);
        usuarioDao.actualizarUsuario(siiUsuario);
    }

    /*public void eliminarUsuario(UsuarioVO usuarioVo) throws ExcepcionDAO {
        usuarioDao.eliminarUsuario(usuarioVo.getUsuCodigo());
    }*/

    public List<UsuarioVO> buscarTodosUsuario() throws ExcepcionDAO {
        List<SiiUsuario> listaSiiUsuario = usuarioDao.buscarTodosUsuario();
        List<UsuarioVO> listaUsuarioVo = new ArrayList();
        for (SiiUsuario unaEntidadUsuario : listaSiiUsuario) {
            UsuarioVO nuevoUsuarioVO = new UsuarioVO(unaEntidadUsuario);
            listaUsuarioVo.add(nuevoUsuarioVO);
        }
        return listaUsuarioVo;
    }

    public List<UsuarioVO> buscarTodoUsuarioConPersona() throws ExcepcionDAO {
        List<SiiUsuario> listaSiiUsuario = usuarioDao.buscarTodoUsuarioConPersona();
        List<UsuarioVO> listaUsuarioVo = new ArrayList();
        for (SiiUsuario unaEntidadUsuario : listaSiiUsuario) {
            UsuarioVO nuevoUsuarioVO = new UsuarioVO(unaEntidadUsuario);
            listaUsuarioVo.add(nuevoUsuarioVO);
        }
        return listaUsuarioVo;
    }

    public void autenticarWS(UsuarioVO usuarioVo) throws ExcepcionAplicacion {
        UsuarioVO usuarioVoComprobar = null;
        try {
            usuarioVoComprobar = buscarUsuarioPorLogin(usuarioVo);
            if (usuarioVoComprobar == null) {
                String mensajeError = recursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
                throw new ExcepcionAplicacion(mensajeError);
            }
            if (usuarioVoComprobar.getUsuContrasena() != null && usuarioVoComprobar.getUsuContrasena().startsWith("{MD5}")) {
                //Comprobar contraseña localmente
                String passEnviado = ServiciosCrypto.convertPassword(usuarioVo.getUsuContrasena(), usuarioVoComprobar.getUsuSalt());
                if (!usuarioVoComprobar.getUsuContrasena().equals(passEnviado)) {
                    try {
                        System.out.println("Sleep autenticacion");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String mensajeError = recursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
                    throw new ExcepcionAplicacion(mensajeError);
                }
            }
        } catch (ExcepcionDAO ex) {
            String mensajeError = recursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
            throw new ExcepcionAplicacion(mensajeError + ex.getMessage(), "AdminUsuarioBean.autenticarWS");
        } catch (Exception ex) {
            String mensajeError = recursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
            throw new ExcepcionAplicacion(mensajeError + ex.getMessage(), "AdminUsuarioBean.autenticarWS");
        }
    }

    public UsuarioVO autenticarDirectorio(UsuarioVO usuarioVo) throws ExcepcionAplicacion {
        UsuarioVO usuarioVoComprobar = null;
        try {
            usuarioVoComprobar = buscarUsuarioPorLogin(usuarioVo);
            if (usuarioVoComprobar == null) {
                try {
                    System.out.println("Sleep autenticacion");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String mensajeError = recursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
                throw new ExcepcionAplicacion(mensajeError);
            }
            if (usuarioVoComprobar.getUsuContrasena() != null && usuarioVoComprobar.getUsuContrasena().startsWith("{MD5}")) {
                //Solo ROOT_SIICOL puede autenticarse en el aplicativo sin estar en el directorio
                /*if (!usuarioVo.getUsuNombreUsuario().toUpperCase().equals("ROOT_SIICOL")) {
                    String mensajeError = recursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
                    throw new ExcepcionAplicacion(mensajeError);
                }*/

                //Comprobar contraseña localmente
                String passEnviado = ServiciosCrypto.convertPassword(usuarioVo.getUsuContrasena(), usuarioVoComprobar.getUsuSalt());
                if (!usuarioVoComprobar.getUsuContrasena().equals(passEnviado)) {
                    try {
                        System.out.println("Sleep autenticacion");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String mensajeError = recursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
                    throw new ExcepcionAplicacion(mensajeError);
                }
            }
            else {
                //Se autentica contra el directorio
                DirectorioActivo.autenticar(usuarioVo.getUsuNombreUsuario(), usuarioVo.getUsuContrasena());
                /*try {
                    Hashtable env = new Hashtable();
                    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
                    env.put(Context.PROVIDER_URL, url_directorio);
                    env.put(Context.SECURITY_AUTHENTICATION, "simple");
                    env.put(Context.SECURITY_PRINCIPAL, usuarioVo.getUsuNombreUsuario() + "@" + dominio_directorio);
                    env.put(Context.SECURITY_CREDENTIALS, usuarioVo.getUsuContrasena());
                    DirContext ctx = new InitialDirContext(env);
                    ctx.close();
                } catch (AuthenticationException ex) {
                    try {
                        System.out.println("Sleep autenticacion");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String mensajeError = recursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
                    throw new ExcepcionAplicacion(mensajeError, "AdminUsuarioBean");
                }*/

            }

        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
            throw new ExcepcionAplicacion(mensajeError, "AdminUsuarioBean");
        }
        return usuarioVoComprobar;
    }

    public UsuarioVO buscarUsuarioPorLogin(UsuarioVO unUsuarioVo) throws ExcepcionDAO {
        UsuarioVO usuarioRetorno = null;
        SiiUsuario unSiiUsuario = usuarioDao.buscarUsuarioPorLogin(unUsuarioVo.getUsuNombreUsuario());
        if (unSiiUsuario != null) {
            usuarioRetorno = new UsuarioVO(unSiiUsuario);
        }
        return usuarioRetorno;
    }

    public UsuarioVO buscarUsuarioPorIdPersona(UsuarioVO unUsuarioVo) throws ExcepcionDAO {
        UsuarioVO usuarioRetorno = null;
        SiiUsuario unSiiUsuario = usuarioDao.buscarUsuarioPorIdPersona(unUsuarioVo.getPersonaVo().getPerCodigo());
        if (unSiiUsuario != null) {
            usuarioRetorno = new UsuarioVO(unSiiUsuario);
        }
        return usuarioRetorno;
    }

    public UsuarioVO buscarUsuarioPorIdPersona(Long perCodigo) throws ExcepcionDAO {
        UsuarioVO resultado = null;
        SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorIdPersona(perCodigo);
        if (siiUsuario!=null)
            resultado = new UsuarioVO(siiUsuario);
        
        return (resultado);
    }

    public String convertPassword(String password, String salt) throws ExcepcionAplicacion {
        return ServiciosCrypto.convertPassword(password, salt);
    }


    public UsuarioVO buscarUsuarioRolPorId(Long idUsuario) throws ExcepcionDAO {
        UsuarioVO usuarioRetorno = null;
        SiiUsuario siiUsuario = usuarioDao.buscarUsuarioXId(idUsuario);
        if (siiUsuario != null) {
            usuarioRetorno = new UsuarioVO(siiUsuario);
        }
        return usuarioRetorno;
    }


    public List<UsuarioVO> buscarUsuariosPorIdFuncion(Long idFuncion) throws ExcepcionDAO {
        List<UsuarioVO> resultado = null;

        List<SiiUsuario> lista = usuarioDao.buscarUsuariosPorIdFuncion(idFuncion);

        if (lista != null) {
            resultado = new ArrayList<UsuarioVO>();
            for (SiiUsuario siiUsuario : lista) {
                resultado.add(new UsuarioVO(siiUsuario));
            }
        }

        return (resultado);
    }

}
