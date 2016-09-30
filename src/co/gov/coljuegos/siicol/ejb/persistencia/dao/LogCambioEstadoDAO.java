package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.EstadoFechaVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class LogCambioEstadoDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public LogCambioEstadoDAO() {
        recursos = new Recursos();
    }

    public SiiLogCambioEstado insertarLogCambioEstado(SiiLogCambioEstado siiLogCambioEstado) throws ExcepcionDAO {
        try {
            manager.persist(siiLogCambioEstado);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiLogCambioEstado;
    }

    /**
     * @param tdoCodigo tipo documento coljuegos
     * @param lceEstadoNuevo estado a buscar
     * @param lceCodigoDoc interno del documento a buscar
     * @return la fecha del ultimo registro del log que cumplen con los 3 parametros anteriores.
     *         nulo si no existen registros.
     * @throws ExcepcionDAO
     */
    public Date buscarFechaLogCambioEstadoPorDocumentoEstado(Long tdoCodigo, Long lceEstadoNuevo,
                                                             Long lceCodigoDoc) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiLogCambioEstado o WHERE  o.siiTipoDocumentoColjuegos.tdoCodigo = :tdoCodigo " +
                       "AND o.lceEstadoNuevo = :lceEstadoNuevo AND o.lceCodigoDoc = :lceCodigoDoc order by o.lceCodigo desc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tdoCodigo", tdoCodigo);
            query.setParameter("lceEstadoNuevo", lceEstadoNuevo);
            query.setParameter("lceCodigoDoc", lceCodigoDoc);
            List<SiiLogCambioEstado> logCambioEstado = query.getResultList();
            if (logCambioEstado.size() > 0) {
                return logCambioEstado.get(0).getLceFecha();
            } else {
                return null;
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public List<EstadoFechaVO> listaFechasCambioEstadoPorDocumento(Long tdoCodigo, Long lceCodigoDoc) throws ExcepcionDAO {
        List<EstadoFechaVO>  listEstadoFechaVo= new ArrayList();
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT  o FROM SiiLogCambioEstado o WHERE   o.siiTipoDocumentoColjuegos.tdoCodigo = :tdoCodigo AND o.lceCodigoDoc = :lceCodigoDoc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tdoCodigo", tdoCodigo);
            query.setParameter("lceCodigoDoc", lceCodigoDoc);
            List<SiiLogCambioEstado> listaProveedor = query.getResultList();
            for( SiiLogCambioEstado siiLogCambioEstado :listaProveedor ){
                EstadoFechaVO stadoFechaVo = new EstadoFechaVO();
                stadoFechaVo.setEstado(siiLogCambioEstado.getLceEstadoNuevo().toString());
                stadoFechaVo.setFecha(siiLogCambioEstado.getLceFecha());
                listEstadoFechaVo.add(stadoFechaVo);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listEstadoFechaVo;

    }

    public String buscarNombreUsuario(Long tdoCodigo, Long lceEstado, Long lceCodigoDoc) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT per.PER_PRIMER_NOMBRE\n" + 
            "  ||DECODE( per.PER_SEGUNDO_NOMBRE,NULL,NULL,' '||per.PER_SEGUNDO_NOMBRE)\n" + 
            "  ||' '||PER_PRIMER_APELLIDO\n" + 
            "  ||DECODE( per.PER_SEGUNDO_APELLIDO,NULL,NULL,' '||per.PER_SEGUNDO_APELLIDO)\n" + 
            "FROM Sii_Log_Cambio_Estado lce\n" + 
            "INNER JOIN sii_usuario usu\n" + 
            "ON lce.USU_CODIGO = usu.USU_CODIGO\n" + 
            "INNER JOIN sii_Tipo_Documento_Coljuegos tdo\n" + 
            "ON lce.TDO_CODIGO = tdo.TDO_CODIGO\n" + 
            "INNER JOIN sii_persona per\n" + 
            "ON usu.PER_CODIGO        = per.PER_CODIGO\n" + 
            "WHERE tdo.TDO_CODIGO     = #tdoCodigo\n" + 
            "AND lce.LCE_ESTADO_NUEVO = #lceEstado\n" + 
            "AND lce.LCE_CODIGO_DOC   = #lceCodigoDoc\n" + 
            "AND lce.LCE_CODIGO = (SELECT MAX(lce.LCE_CODIGO)\n" + 
            "FROM Sii_Log_Cambio_Estado lce\n" + 
            "INNER JOIN sii_Tipo_Documento_Coljuegos tdo\n" + 
            "ON lce.TDO_CODIGO        = tdo.TDO_CODIGO\n" + 
            "WHERE tdo.TDO_CODIGO     = #tdoCodigo\n" + 
            "AND lce.LCE_CODIGO_DOC   = #lceCodigoDoc\n" + 
            "AND lce.LCE_ESTADO_NUEVO = #lceEstado\n" + 
            "GROUP BY tdo.TDO_CODIGO,\n" + 
            "  lce.LCE_ESTADO_NUEVO,\n" + 
            "  lce.LCE_CODIGO_DOC)\n" + 
            "ORDER BY lce.LCE_CODIGO DESC");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("tdoCodigo", tdoCodigo);
            query.setParameter("lceEstado", lceEstado);
            query.setParameter("lceCodigoDoc", lceCodigoDoc);
            return (String) query.getSingleResult();
        }catch (NoResultException pe) {
            return "_____________________";
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LogCambioEstadoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    public String buscarInicialesNombreUsuario(Long tdoCodigo, Long lceEstado, Long lceCodigoDoc) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("WITH lce1 AS\n" + 
            "  (SELECT MAX(Sii_Log_Cambio_Estado.LCE_CODIGO) lce_codigo,\n" + 
            "    Sii_Log_Cambio_Estado.TDO_CODIGO,\n" + 
            "    Sii_Log_Cambio_Estado.LCE_ESTADO_NUEVO,\n" + 
            "    Sii_Log_Cambio_Estado.LCE_CODIGO_DOC\n" + 
            "  FROM Sii_Log_Cambio_Estado\n" + 
            "  GROUP BY Sii_Log_Cambio_Estado.TDO_CODIGO,\n" + 
            "    Sii_Log_Cambio_Estado.LCE_ESTADO_NUEVO,\n" + 
            "    Sii_Log_Cambio_Estado.LCE_CODIGO_DOC\n" + 
            "  )\n" + 
            "SELECT NVL(SUBSTR(per.PER_PRIMER_NOMBRE,1,1)\n" + 
            "  ||SUBSTR(per.PER_SEGUNDO_NOMBRE,1,1)\n" + 
            "  ||SUBSTR(per.PER_PRIMER_APELLIDO,1,1)\n" + 
            "  ||SUBSTR(per.PER_SEGUNDO_APELLIDO,1,1),'__')\n" + 
            "FROM lce1\n" + 
            "INNER JOIN Sii_Log_Cambio_Estado lce\n" + 
            "ON lce1.lce_codigo        = lce.LCE_CODIGO\n" + 
            "AND lce1.TDO_CODIGO       = lce.TDO_CODIGO\n" + 
            "AND lce1.LCE_ESTADO_NUEVO = lce.LCE_ESTADO_NUEVO\n" + 
            "AND lce1.LCE_CODIGO_DOC   = lce.LCE_CODIGO_DOC\n" + 
            "INNER JOIN sii_usuario usu\n" + 
            "ON lce.USU_CODIGO = usu.USU_CODIGO\n" + 
            "INNER JOIN sii_Tipo_Documento_Coljuegos tdo\n" + 
            "ON tdo.TDO_CODIGO = lce1.TDO_CODIGO\n" + 
            "INNER JOIN sii_persona per\n" + 
            "ON usu.PER_CODIGO        = per.PER_CODIGO\n" + 
            "WHERE tdo.TDO_CODIGO     = #tdoCodigo\n" + 
            "AND lce.LCE_ESTADO_NUEVO = #lceEstado\n" + 
            "AND lce.LCE_CODIGO_DOC   = #lceCodigoDoc\n" + 
            "ORDER BY lce.LCE_CODIGO");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("tdoCodigo", tdoCodigo);
            query.setParameter("lceEstado", lceEstado);
            query.setParameter("lceCodigoDoc", lceCodigoDoc);
            String iniciales = (String) query.getSingleResult();
            return iniciales;
        } catch (NoResultException pe) {
            return "_____________________";
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LogCambioEstadoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    public SiiUsuario buscarUsuarioLogCambioEstado(Long tdoCodigo, Long lceEstado,
                                                   Long lceCodigoDoc) throws ExcepcionDAO {
        BigDecimal lceCodigo;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT MAX(lce.LCE_CODIGO)\n" + 
            "FROM Sii_Log_Cambio_Estado lce\n" + 
            "INNER JOIN sii_Tipo_Documento_Coljuegos tdo\n" + 
            "ON lce.TDO_CODIGO        = tdo.TDO_CODIGO\n" + 
            "WHERE tdo.TDO_CODIGO     = #tdoCodigo\n" + 
            "AND lce.LCE_CODIGO_DOC   = #lceCodigoDoc\n" + 
            "AND lce.LCE_ESTADO_NUEVO = #lceEstado\n" + 
            "GROUP BY tdo.TDO_CODIGO,\n" + 
            "  lce.LCE_ESTADO_NUEVO,\n" + 
            "  lce.LCE_CODIGO_DOC");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("tdoCodigo", tdoCodigo);
            query.setParameter("lceEstado", lceEstado);
            query.setParameter("lceCodigoDoc", lceCodigoDoc);
            lceCodigo = (BigDecimal) query.getSingleResult();
        } catch (NoResultException pe) {
            return new SiiUsuario();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LogCambioEstadoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o.siiUsuario FROM SiiLogCambioEstado o " +
                       "WHERE o.siiTipoDocumentoColjuegos.tdoCodigo = :tdoCodigo " +
                       "AND o.lceCodigoDoc = :lceCodigoDoc AND o.lceCodigo=:lceCodigo " +
                       "AND o.lceEstadoNuevo=:lceEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tdoCodigo", tdoCodigo);
            query.setParameter("lceCodigoDoc", lceCodigoDoc);
            query.setParameter("lceEstado", lceEstado);
             query.setParameter("lceCodigo", lceCodigo.longValue());
            return (SiiUsuario) query.getSingleResult();
            //     if (x==null)
        } catch (NoResultException pe) {
            return new SiiUsuario();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LogCambioEstadoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }
    
    public SiiLogCambioEstado fechaUltimoCambioEstadoPorDocumentoPorEstado(Long tdoCodigo, Long lceCodigoDoc, Long lceEstadoNuevo) throws ExcepcionDAO {
        SiiLogCambioEstado siiLogCambioEstado = null;
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT lce FROM SiiLogCambioEstado lce");
            sql.append(" WHERE lce.siiTipoDocumentoColjuegos.tdoCodigo = :tdoCodigo");
            sql.append(" AND lce.lceCodigoDoc = :lceCodigoDoc");
            sql.append(" AND lce.lceEstadoNuevo = :lceEstadoNuevo");
            sql.append(" ORDER BY lce.lceFecha DESC");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tdoCodigo", tdoCodigo);
            query.setParameter("lceCodigoDoc", lceCodigoDoc);
            query.setParameter("lceEstadoNuevo", lceEstadoNuevo);
            List<SiiLogCambioEstado> listaSiiLogCambioEstado = query.getResultList();
            
            if(listaSiiLogCambioEstado != null && listaSiiLogCambioEstado.size() > 0){
                siiLogCambioEstado = listaSiiLogCambioEstado.get(0);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiLogCambioEstado;
    }
    
    public String buscarNombreUsu(Long tdoCodigo, String nombreEstado, Long lceCodigoDoc) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT per.PER_PRIMER_NOMBRE\n" + 
            "  ||DECODE( per.PER_SEGUNDO_NOMBRE,NULL,NULL,' '||per.PER_SEGUNDO_NOMBRE)\n" + 
            "  ||' '||PER_PRIMER_APELLIDO\n" + 
            "  ||DECODE( per.PER_SEGUNDO_APELLIDO,NULL,NULL,' '||per.PER_SEGUNDO_APELLIDO)\n" + 
            "FROM Sii_Log_Cambio_Estado lce\n" + 
            "INNER JOIN sii_usuario usu\n" + 
            "ON lce.USU_CODIGO = usu.USU_CODIGO\n" + 
            "INNER JOIN sii_Tipo_Documento_Coljuegos tdo\n" + 
            "ON lce.TDO_CODIGO = tdo.TDO_CODIGO\n" + 
            "INNER JOIN sii_persona per\n" + 
            "ON usu.PER_CODIGO        = per.PER_CODIGO\n" + 
            "WHERE tdo.TDO_CODIGO     = #tdoCodigo\n" + 
            "AND lce.lce_nomb_est_nuevo = #nombreEstado\n" + 
            "AND lce.LCE_CODIGO_DOC   = #lceCodigoDoc\n" + 
            "AND lce.LCE_CODIGO = (SELECT MAX(lce.LCE_CODIGO)\n" + 
            "FROM Sii_Log_Cambio_Estado lce\n" + 
            "INNER JOIN sii_Tipo_Documento_Coljuegos tdo\n" + 
            "ON lce.TDO_CODIGO        = tdo.TDO_CODIGO\n" + 
            "WHERE tdo.TDO_CODIGO     = #tdoCodigo\n" + 
            "AND lce.LCE_CODIGO_DOC   = #lceCodigoDoc\n" + 
            "AND lce.lce_nomb_est_nuevo = #nombreEstado\n" + 
            "GROUP BY tdo.TDO_CODIGO,\n" + 
            "  lce.lce_nomb_est_nuevo,\n" + 
            "  lce.LCE_CODIGO_DOC)\n" + 
            "ORDER BY lce.LCE_CODIGO DESC");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("tdoCodigo", tdoCodigo);
            query.setParameter("nombreEstado", nombreEstado);
            query.setParameter("lceCodigoDoc", lceCodigoDoc);
            return (String) query.getSingleResult();
        }catch (NoResultException pe) {
            return "_____________________";
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LogCambioEstadoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }
    
}
