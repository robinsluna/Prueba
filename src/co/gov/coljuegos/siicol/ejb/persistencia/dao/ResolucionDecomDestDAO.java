/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 26-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumResultadoResDecDes;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAccionControl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionDecomDest;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionDecomDestVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access Object que gestiona las resoluciones con decomiso y destrucción.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class ResolucionDecomDestDAO extends AbstractDAO<Long, SiiResolucionDecomDest> {

    List<SiiResolucionDecomDest> listaSiiResolucionDecomDest;

    /**
     * Constructor.
     */

    public ResolucionDecomDestDAO() {
        super(SiiResolucionDecomDest.class);

        listaSiiResolucionDecomDest = new ArrayList<SiiResolucionDecomDest>();
    }

    /**
     * Realiza la consulta para obtener el Consecutivo del Documento Contable a trav&eacute;s del Tipo de Documento Contable.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return documentoContable.numero.nextval
     * @throws ExcepcionDAO
     */
    public Integer buscarConsecutivoResolucion() throws ExcepcionDAO {
        Integer consecutivo = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT NVL(MAX(RES.RDD_RESOLUCION)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
            sql.append("FROM SII_RESOLUCION_DECOM_DEST RES ");
            sql.append("WHERE RES.RDD_RESOLUCION LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%' ");

            Query query = em.createNativeQuery(sql.toString());

            if(query.getSingleResult() != null) {
                consecutivo = new Integer(((BigDecimal) query.getSingleResult()).intValueExact());
            }

        } catch(javax.persistence.NoResultException ne) {
            consecutivo = null;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }

    /**
     * Buscar el estado de la resolución según id de denuncia
     * @param denCodigo
     * @return rrd_nombre - String
     * @throws ExcepcionDAO
     */

    public String buscarEstadoResolucionXIdDenuncia(Long denCodigo) throws ExcepcionDAO {
        String rrd_nombre = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT rrdd.rrd_nombre");
            sql.append(" FROM sii_resultado_res_dec_des rrdd");
            sql.append(" INNER JOIN sii_resolucion_decom_dest rdd");
            sql.append(" ON rrdd.rrd_codigo = rdd.rrd_codigo");
            sql.append(" INNER JOIN sii_accion_control ac");
            sql.append(" ON rdd.rdd_codigo = ac.rdd_codigo");
            sql.append(" INNER JOIN sii_auto_comisorio_acc_con acac");
            sql.append(" ON acac.aca_codigo   = ac.aca_codigo");
            sql.append(" WHERE acac.den_codigo= ");
            sql.append(denCodigo);
            Query query = em.createNativeQuery(sql.toString());

            if(query.getSingleResult() != null) {
                rrd_nombre = (String) query.getSingleResult();
            }

        } catch(javax.persistence.NoResultException ne) {
            rrd_nombre = null;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return rrd_nombre;
    }


    /**
     * Buscar el estado del trámite de la resolución según id de la denuncia
     * @param denCodigo
     * @return etd_codigo - Long
     * @throws ExcepcionDAO
     */

    public Long buscarEstadoTramiteResolucionXIdDenuncia(Long denCodigo) throws ExcepcionDAO {
        Long etd_codigo = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT *");
            sql.append(" FROM");
            sql.append(" (SELECT trdd.etd_codigo");
            sql.append(" FROM sii_tramite_resol_dec_des trdd");
            sql.append(" INNER JOIN sii_resolucion_decom_dest rdd");
            sql.append(" ON trdd.rdd_codigo = rdd.rdd_codigo");
            sql.append(" INNER JOIN sii_accion_control ac");
            sql.append(" ON rdd.rdd_codigo = ac.rdd_codigo");
            sql.append(" INNER JOIN sii_auto_comisorio_acc_con acac");
            sql.append(" ON acac.aca_codigo = ac.aca_codigo");
            sql.append(" INNER JOIN sii_estado_tram_res_dec_des etrdd");
            sql.append(" ON trdd.etd_codigo   = etrdd.etd_codigo");
            sql.append(" WHERE acac.den_codigo= ");
            sql.append(denCodigo);
            sql.append(" ORDER BY etrdd.etd_orden DESC");
            sql.append(" )");
            sql.append(" WHERE rownum=1");

            Query query = em.createNativeQuery(sql.toString());

            if(query.getSingleResult() != null) {
                etd_codigo = new Long(((BigDecimal) query.getSingleResult()).intValueExact());
            }

        } catch(javax.persistence.NoResultException ne) {
            etd_codigo = null;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return etd_codigo;
    }

    /**
     * Buscar el estado del trámite de la resolución que resuelve el recurso
     * @param denCodigo
     * @return etd_codigo - Long
     * @throws ExcepcionDAO
     */

    public Long buscarEstadoTramiteResolucionRecursoXIdDenuncia(Long denCodigo) throws ExcepcionDAO {
        Long etd_codigo = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT *");
            sql.append(" FROM");
            sql.append(" (SELECT trdd.etd_codigo");
            sql.append(" FROM sii_tramite_resol_dec_des trdd");
            sql.append(" INNER JOIN sii_resolucion_decom_dest rdd");
            sql.append(" ON trdd.rdd_codigo = rdd.rdd_codigo");
            sql.append(" INNER JOIN sii_accion_control ac");
            sql.append(" ON rdd.rdd_codigo = ac.rdd_codigo_resuelve");
            sql.append(" INNER JOIN sii_auto_comisorio_acc_con acac");
            sql.append(" ON acac.aca_codigo = ac.aca_codigo");
            sql.append(" INNER JOIN sii_estado_tram_res_dec_des etrdd");
            sql.append(" ON trdd.etd_codigo   = etrdd.etd_codigo");
            sql.append(" WHERE acac.den_codigo= ");
            sql.append(denCodigo);
            sql.append(" ORDER BY etrdd.etd_orden DESC");
            sql.append(" )");
            sql.append(" WHERE rownum=1");

            Query query = em.createNativeQuery(sql.toString());

            if(query.getSingleResult() != null) {
                etd_codigo = new Long(((BigDecimal) query.getSingleResult()).intValueExact());
            }

        } catch(javax.persistence.NoResultException ne) {
            etd_codigo = null;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return etd_codigo;
    }

    /**
     * Buscar el estado de la resolución que resuelve el recurso según id de denuncia
     * @param denCodigo
     * @return rrd_nombre - String
     * @throws ExcepcionDAO
     */

    public String buscarEstadoResolucionRecursoXIdDenuncia(Long denCodigo) throws ExcepcionDAO {
        String rrd_nombre = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT rrdd.rrd_nombre");
            sql.append(" FROM sii_resultado_res_dec_des rrdd");
            sql.append(" INNER JOIN sii_resolucion_decom_dest rdd");
            sql.append(" ON rrdd.rrd_codigo = rdd.rrd_codigo");
            sql.append(" INNER JOIN sii_accion_control ac");
            sql.append(" ON rdd.rdd_codigo = ac.rdd_codigo_resuelve");
            sql.append(" INNER JOIN sii_auto_comisorio_acc_con acac");
            sql.append(" ON acac.aca_codigo   = ac.aca_codigo");
            sql.append(" WHERE acac.den_codigo= ");
            sql.append(denCodigo);
            Query query = em.createNativeQuery(sql.toString());

            if(query.getSingleResult() != null) {
                rrd_nombre = (String) query.getSingleResult();
            }

        } catch(javax.persistence.NoResultException ne) {
            rrd_nombre = null;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return rrd_nombre;
    }

    /**
     * Buscar el Id de la última resolución agregada a la BD según id del usuario logueado
     * @param usuarioVo
     * @return consecutivo - Long
     * @throws ExcepcionDAO
     */

    public Long buscarIdUltimaResolucion(UsuarioVO usuarioVo) throws ExcepcionDAO {
        Long consecutivo = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT MAX(RES.RDD_CODIGO) FROM SII_RESOLUCION_DECOM_DEST RES where res.usu_codigo_conect= ");
            sql.append(usuarioVo.getUsuCodigo());

            Query query = em.createNativeQuery(sql.toString());

            if(query.getSingleResult() != null) {
                consecutivo = new Long(((BigDecimal) query.getSingleResult()).intValueExact());
            }

        } catch(javax.persistence.NoResultException ne) {
            consecutivo = null;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }

    /**
     * Buscar todas las resoluciones de decomiso y destrucción que no tengan acta de destrucción asociada.
     * Además que estén en decomiso y destrucción o en devolución de decomiso y destrucción
     * @return listaSiiResolucionDecomDest - Lista de resoluciones de decomiso y destrucción
     * @throws ExcepcionDAO
     */

    public List<SiiAccionControl> buscarResolDecomDestSinActaDestruccionDecoDestrDev() throws ExcepcionDAO {
        List<SiiAccionControl> listaSiiAccionControl = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT ac");
            sql.append(" FROM SiiAccionControl ac");
            sql.append(" inner join  ac.siiAutoComisorioAccCon au");
            sql.append(" inner join  ac.siiResolucionDecomDest rdd");
            sql.append(" WHERE  ");
            sql.append(" rdd.siiActaDestruccion  IS NULL");
            sql.append(" and (rdd.siiResultadoResDecDes.rrdCodigo = ");
            sql.append(EnumResultadoResDecDes.DECOMISO_Y_DESTRUCCION.getId());
            sql.append(" or rdd.siiResultadoResDecDes.rrdCodigo =");
            sql.append(EnumResultadoResDecDes.DEVOLUCION_DECOMISO_Y_DESTRUCCION.getId());
            sql.append(" )");

            Query query = em.createQuery(sql.toString());
            listaSiiAccionControl = query.getResultList();
            return listaSiiAccionControl;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ResolucionDecomDestDAO");
        }

    }

    /**
     * Buscar las resoluciones de decomiso y destrucción según id de Acta de Destrucción
     * @param adeCodigo
     * @return listaSiiResolucionDecomDest - Lista de SiiResolucionDecomDest
     * @throws ExcepcionDAO
     */

    public List<SiiAccionControl> buscarResolDecomDestXIdActaDestruccion(Long adeCodigo) throws ExcepcionDAO {
        List<SiiAccionControl> listaSiiAccionControl = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT ac");
            sql.append(" FROM SiiAccionControl ac");
            sql.append(" inner join  ac.siiAutoComisorioAccCon au");
            sql.append(" inner join  ac.siiResolucionDecomDest rdd");
            sql.append(" WHERE  ");
            sql.append(" rdd.siiActaDestruccion.adeCodigo =:adeCodigo");

            Query query = em.createQuery(sql.toString());
            query.setParameter("adeCodigo", adeCodigo);
            listaSiiAccionControl = query.getResultList();
            return listaSiiAccionControl;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ResolucionDecomDestDAO");
        }

    }

    /**
     * Buscar todas la resoluciones que resuelven el recurso de decomiso y destrucción según el estado del trámite
     * @param etdCodigo
     * @return listaSiiResolucionDecomDest - Lista de las resoluciones que resuelven el recurso
     * @throws ExcepcionDAO
     */
    public List<SiiResolucionDecomDest> buscarResolDecomDestResuelveXEstadoTramite(Long etdCodigo) throws ExcepcionDAO {
        List<SiiResolucionDecomDest> listaSiiResolucionDecomDest = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rdd");
            sql.append("FROM SiiResolucionDecomDest rdd");
            sql.append("INNER JOIN SiiAccionControl ac");
            sql.append("ON rdd.rddCodigo = ac.siiResolucionDecomDestResuelve.rddCodigo");
            sql.append("INNER JOIN SiiTramiteResolDecDes trdd");
            sql.append("ON trdd.siiResolucionDecomDest.rddCodigo   = ac.siiResolucionDecomDestResuelve.rddCodigo");
            sql.append("WHERE trdd.siiEstadoTramResDecDes.etdCodigo=:etdCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("etdCodigo", etdCodigo);
            listaSiiResolucionDecomDest = query.getResultList();
            this.listaSiiResolucionDecomDest = listaSiiResolucionDecomDest;
            return listaSiiResolucionDecomDest;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ResolucionDecomDestDAO");
        }

    }

    /**
     * Buscar el estado del trámite de la resolución según su id
     * @param rdd_codigo
     * @return
     * @throws ExcepcionDAO
     */
    
    public Long buscarEstadoTramiteResolucionResuelveXIdResol(Long rdd_codigo) throws ExcepcionDAO {
        Long etd_codigo = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT *");
            sql.append(" FROM");
            sql.append(" (SELECT etrdd.etd_codigo");
            sql.append(" FROM sii_tramite_resol_dec_des trdd");
            sql.append(" INNER JOIN sii_resolucion_decom_dest rdd");
            sql.append(" ON trdd.rdd_codigo = rdd.rdd_codigo");
            sql.append(" INNER JOIN sii_accion_control ac");
            sql.append(" ON rdd.rdd_codigo = ac.rdd_codigo_resuelve");
            sql.append(" INNER JOIN sii_auto_comisorio_acc_con acac");
            sql.append(" ON acac.aca_codigo = ac.aca_codigo");
            sql.append(" INNER JOIN sii_estado_tram_res_dec_des etrdd");
            sql.append(" ON trdd.etd_codigo  = etrdd.etd_codigo");
            sql.append(" WHERE rdd.rdd_codigo= ");
            sql.append(rdd_codigo);
            sql.append(" ORDER BY etrdd.etd_orden DESC");
            sql.append(" )");
            sql.append(" WHERE rownum=1");

            Query query = em.createNativeQuery(sql.toString());

            if(query.getSingleResult() != null) {
                etd_codigo = new Long(((BigDecimal) query.getSingleResult()).intValueExact());
            }

        } catch(javax.persistence.NoResultException ne) {
            etd_codigo = null;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return etd_codigo;
    }
    
    /**
     * Buscar el estado del trámite de las resoluciones de decomiso y destrución según su id de resolución
     * @param rdd_codigo
     * @return etd_codigo - Long
     * @throws ExcepcionDAO
     */
    
    public List<ResolucionDecomDestVO> buscarEstadoNumeracionTramiteResolucion() throws ExcepcionDAO {
           List<ResolucionDecomDestVO> listResolucionDecomDestVo= new ArrayList(); 
           try {
               StringBuilder sql = new StringBuilder();
              
               sql.append("  select rdd.rdd_codigo, ac.aca_codigo fROM sii_tramite_resol_dec_des trdd ");
               sql.append("  INNER JOIN sii_resolucion_decom_dest rdd ON trdd.rdd_codigo = rdd.rdd_codigo ");
               sql.append("  INNER JOIN sii_accion_control ac ON rdd.rdd_codigo = ac.rdd_codigo");
               sql.append("  inner join sii_auto_comisorio_acc_con acac on acac.aca_codigo = ac.aca_codigo ");
               sql.append("  INNER JOIN sii_estado_tram_res_dec_des etrdd ON trdd.etd_codigo  = etrdd.etd_codigo");
               sql.append("  where    ac.rdd_codigo_resuelve is not null and  etrdd.etd_orden = 5 and rdd.rdd_codigo not in (");
               sql.append("  select rdd.rdd_codigo fROM sii_tramite_resol_dec_des trdd");
               sql.append("  INNER JOIN sii_resolucion_decom_dest rdd ON trdd.rdd_codigo = rdd.rdd_codigo");
               sql.append("  left  JOIN sii_accion_control ac ON rdd.rdd_codigo = ac.rdd_codigo_resuelve");
               sql.append("  left join sii_auto_comisorio_acc_con acac on acac.aca_codigo = ac.aca_codigo");
               sql.append("  INNER JOIN sii_estado_tram_res_dec_des etrdd ON trdd.etd_codigo  = etrdd.etd_codigo");
               sql.append("  WHERE etrdd.etd_orden > 5 )and   rdd.rdd_codigo not in  ");
               sql.append("               (select rdd.rdd_codigo fROM sii_tramite_resol_dec_des trdd ");
               sql.append("  INNER JOIN sii_resolucion_decom_dest rdd ON trdd.rdd_codigo = rdd.rdd_codigo ");
               sql.append("  INNER JOIN sii_accion_control ac ON rdd.rdd_codigo = ac.rdd_codigo");
               sql.append("  inner join sii_auto_comisorio_acc_con acac on acac.aca_codigo = ac.aca_codigo ");
               sql.append("  INNER JOIN sii_estado_tram_res_dec_des etrdd ON trdd.etd_codigo  = etrdd.etd_codigo");
               sql.append("  where etrdd.etd_orden > 5) and ");
               sql.append("  ac.rdd_codigo_resuelve in ( select tr.rdd_codigo from  sii_tramite_resol_dec_des tr   INNER JOIN sii_estado_tram_res_dec_des etrdd ON tr.etd_codigo");
               sql.append("   = etrdd.etd_codigo    where etrdd.etd_orden=5  and   tr.trd_fecha < SYSDATE )                            ");
               
                

               Query query = em.createNativeQuery(sql.toString());

                   List<Object[]> results = query.getResultList();
                   if (results != null && !results.isEmpty()) {
                         for (Object[] object : results) {
                             ResolucionDecomDestVO unaResolucionDecomDestVo = new ResolucionDecomDestVO();
                             unaResolucionDecomDestVo.setRddCodigo(((BigDecimal) object[0]).longValue());
                             listResolucionDecomDestVo.add(unaResolucionDecomDestVo);
                         }
                     }
           } catch(PersistenceException pe) {
               String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
               throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
           }
           return listResolucionDecomDestVo;
       }
}
