package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumLogGeneral;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.sistema.AdminParametrosSistema;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LogGeneralDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogGeneral;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminLogGeneralBean implements AdminLogGeneral {
    
    @EJB
    LogGeneralDAO logGeneralDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    UsuarioDAO usuarioDao;
    @EJB
    AdminParametrosSistema adminParametrosSistema;
    
    public AdminLogGeneralBean() {
    }
    
    public void log(Integer tipoLog, int severidad, String modulo, String mensaje, UsuarioVO usuarioVo){
        try{
            if(mensaje.length() > 1000){
                mensaje = mensaje.substring(0,999);
            }
            if(modulo.length() > 200){
                modulo = modulo.substring(0,199);
            }
            SiiUsuario siiUsuario = null;
            if(usuarioVo != null && usuarioVo.getUsuCodigo() != null && usuarioVo.getUsuCodigo() > 0){
                siiUsuario = (conversionVoEntidad.convertir(usuarioVo));
            }
            else if(usuarioVo!=null && usuarioVo.getUsuNombreUsuario() != null){
                siiUsuario = usuarioDao.buscarUsuarioPorLogin(usuarioVo.getUsuNombreUsuario());
            }
            SiiLogGeneral siiLogGeneral = new SiiLogGeneral(null, mensaje, modulo, new Integer(severidad), tipoLog, siiUsuario, new Date(), null);
            logGeneralDao.insertarLog(siiLogGeneral);
            logConsola("Módulo: " + modulo + " - Usuario: " + (usuarioVo == null?"":usuarioVo.getUsuNombreUsuario()) + " - Mensaje: " + mensaje);
        }catch(Exception ex){
            System.out.println("Error al insertar Log General: ");
            ex.printStackTrace();
        }
    }
    
    public void log(String modulo, String mensaje, UsuarioVO usuarioVo){
        try{
            if(mensaje.length() > 1000){
                mensaje = mensaje.substring(0,999);
            }
            if(modulo.length() > 200){
                modulo = modulo.substring(0,199);
            }
            SiiUsuario siiUsuario = null;
            if(usuarioVo != null && usuarioVo.getUsuCodigo() != null && usuarioVo.getUsuCodigo() > 0){
                siiUsuario = (conversionVoEntidad.convertir(usuarioVo));
            }
            if(siiUsuario == null && usuarioVo!=null && usuarioVo.getUsuNombreUsuario() != null){
                siiUsuario = usuarioDao.buscarUsuarioPorLogin(usuarioVo.getUsuNombreUsuario());
            }
            SiiLogGeneral siiLogGeneral = new SiiLogGeneral(null, mensaje, modulo, new Integer(1), EnumLogGeneral.TIPO_INFO.getId(), siiUsuario, new Date(), null);
            logGeneralDao.insertarLog(siiLogGeneral);
            logConsola("Módulo: " + modulo + " - Usuario: " + (usuarioVo == null?"":usuarioVo.getUsuNombreUsuario()) + " - Mensaje: " + mensaje);
        }catch(Exception ex){
            System.out.println("Error al insertar Log General: ");
            ex.printStackTrace();
        }
    }
    
    public void logTiempo(Integer tipoLog, int severidad, String modulo, String mensaje, UsuarioVO usuarioVo, long tiempoEjec){
        try{
            SiiUsuario siiUsuario = null;
            if(mensaje.length() > 1000){
                mensaje = mensaje.substring(0,999);
            }
            if(modulo.length() > 200){
                modulo = modulo.substring(0,199);
            }
            if(usuarioVo != null && usuarioVo.getUsuCodigo() > 0){
                siiUsuario = usuarioDao.buscarUsuarioPorId(usuarioVo.getUsuCodigo());
            }
            SiiLogGeneral siiLogGeneral = new SiiLogGeneral(null, mensaje, modulo, new Integer(severidad), tipoLog, siiUsuario, new Date(), new Long(tiempoEjec));
            logGeneralDao.insertarLog(siiLogGeneral);
            logConsola("Log tiempo - Módulo " + modulo +" - Mensaje: " + mensaje +" - Tiempo de ejecución: " + tiempoEjec + " mSeg.");
        }catch(Exception ex){
            System.out.println("Error al insertar Log General: ");
            ex.printStackTrace();
        }
    }
    
    public void logTiempo(String modulo, long tiempoEjec, String usuarioWebservice){
        try{
            if(modulo.length() > 200){
                modulo = modulo.substring(0,199);
            }
            SiiLogGeneral siiLogGeneral = new SiiLogGeneral(null, usuarioWebservice, modulo, new Integer(1), EnumLogGeneral.TIPO_INFO.getId(), null, new Date(), new Long(tiempoEjec));
            logGeneralDao.insertarLog(siiLogGeneral);
            logConsola("Log tiempo - Módulo " + modulo + " - " + usuarioWebservice + " - Tiempo de ejecución: " + tiempoEjec + " mSeg.");
        }catch(Exception ex){
            System.out.println("Error al insertar Log General: ");
            ex.printStackTrace();
        }
    }
    
    public void logConsola(String textoLog){
        String strFecha = "";
        String baseDatos = "";
        try{
            baseDatos = adminParametrosSistema.buscarCadenaParametroPorId("BASE_DE_DATOS");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            strFecha = formatter.format(new Date());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(strFecha + " - Sistema: " + baseDatos + " - " + textoLog);
    }
    
    
    public List<String> buscarTodoModuloLogGeneral () throws ExcepcionDAO {
        return ( logGeneralDao.buscarTodoModuloLogGeneral() );
    }
}
