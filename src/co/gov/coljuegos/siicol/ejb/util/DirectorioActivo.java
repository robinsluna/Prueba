package co.gov.coljuegos.siicol.ejb.util;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class DirectorioActivo {
    
    private String url_directorio = null;
    private String dominio_directorio = null;
    private Recursos recursos = null;
    
    public DirectorioActivo() {
        recursos = new Recursos();
        url_directorio = recursos.obtenerRecurso("URL_DIRECTORIO", "recursos");
        dominio_directorio = recursos.obtenerRecurso("DOMINIO_DIRECTORIO", "recursos");
    }
    
    public static void autenticar(String usuario, String contrasena) throws ExcepcionAplicacion{
        Recursos unRecursos = new Recursos();
        String unUrl_directorio = unRecursos.obtenerRecurso("URL_DIRECTORIO", "recursos");
        String unDominio_directorio = unRecursos.obtenerRecurso("DOMINIO_DIRECTORIO", "recursos");
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, unUrl_directorio);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, usuario + "@" + unDominio_directorio);
        env.put(Context.SECURITY_CREDENTIALS, contrasena);
        
        try{
            DirContext ctx = new InitialDirContext(env);
            ctx.close();
        } catch (AuthenticationException ex) {
                try {
                    System.out.println("Sleep autenticacion");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String mensajeError = unRecursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
                throw new ExcepcionAplicacion(mensajeError, "AdminUsuarioBean");
        } catch (CommunicationException ex) {
            String mensajeError = unRecursos.obtenerRecurso("ERROR_COMUNICACION", "mensajes_sistema");
            throw new ExcepcionAplicacion(mensajeError, "AdminUsuarioBean");
        } catch (NamingException ex) {
            String mensajeError = unRecursos.obtenerRecurso("ERROR_AUTENTICACION", "mensajes_sistema");
            throw new ExcepcionAplicacion(mensajeError, "AdminUsuarioBean");
        } catch (Exception ex){
            ex.printStackTrace();
            throw new ExcepcionAplicacion(ex.getMessage(), "AdminUsuarioBean");
        }
    }
}
