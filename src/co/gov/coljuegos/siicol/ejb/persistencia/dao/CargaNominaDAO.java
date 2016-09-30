/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 15-05-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoObligacion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoOrdenPago;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocContable;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaNomina;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class CargaNominaDAO extends GenericDAO<SiiCargaNomina> {
    
    /**
     * Constructor.
     */
    public CargaNominaDAO() {
        super(SiiCargaNomina.class);
    }
    
    
    /**
     * Realiza la b&uacute;squeda de un registro de Carga N&oacute;mina por medio del nombre de archivo.
     * @param cnoNombreArch - Nombre del Archivo.
     * @return instance of SiiCargaNomina
     * @throws ExcepcionDAO
     */
    public SiiCargaNomina buscarPorNombreArchivo (String cnoNombreArch) throws ExcepcionDAO {
        SiiCargaNomina siiCargaNomina = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cn FROM SiiCargaNomina cn ");
            sql.append("WHERE cn.cnoNombreArch = :cnoNombreArch ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("cnoNombreArch", cnoNombreArch);
            
            siiCargaNomina = (SiiCargaNomina) query.getSingleResult();
        }
        catch (NoResultException e) {
            siiCargaNomina = null;
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (siiCargaNomina);
    }
    
    
    
    /**
     * Realiza la consulta del &uacute;ltimo consecutivo de archivo cargado en el sistema, correspondiente a la fecha suministrada.
     * @param calendar - Calendario asociado a la fecha correspondiente al consecutivo que se desea buscar.
     * @return Consecutivo del archivo en formato yyyyMMdd-#
     * @throws ExcepcionDAO
     */
    public Long buscarUltimoConsecutivo (Calendar calendar) throws ExcepcionDAO {
        return (this.buscarUltimoConsecutivo(calendar.getTime()));
    }
    
    
    /**
     * Realiza la consulta del &uacute;ltimo consecutivo de archivo cargado en el sistema, correspondiente a la fecha suministrada.
     * @param fecha - Fecha correspondiente al consecutivo que se desea buscar.
     * @return Consecutivo del archivo en formato yyyyMMdd-#
     * @throws ExcepcionDAO
     */
    public Long buscarUltimoConsecutivo (Date fecha) throws ExcepcionDAO {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String formatoFecha = df.format(fecha);
        return (this.buscarUltimoConsecutivo(formatoFecha));
    }
    
    
    /**
     * Realiza la consulta del &uacute;ltimo consecutivo de archivo cargado en el sistema, correspondiente al formato de fecha suministrado.
     * @param formatoFecha - Fecha en formato yyyyMMdd.
     * @return Consecutivo del archivo en formato yyyyMMdd-#
     * @throws ExcepcionDAO
     */
    public Long buscarUltimoConsecutivo (String formatoFecha) throws ExcepcionDAO {
        Long consecutivo = 0L;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUBSTR(NOMBRE_ARCH, INSTR(NOMBRE_ARCH, '-')+1, LENGTH(NOMBRE_ARCH)-INSTR(NOMBRE_ARCH, '-')) AS CONSECUTIVO ");
            sql.append("FROM ( ");
            sql.append("        SELECT MAX(cno.CNO_NOMBRE_ARCH) AS NOMBRE_ARCH ");
            sql.append("        FROM SII_CARGA_NOMINA cno ");
            sql.append("        WHERE cno.CNO_NOMBRE_ARCH LIKE #formatoFecha "); 
            sql.append(") ");
            
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("formatoFecha", formatoFecha+"%");
            
            String result = (String) query.getSingleResult();
            if (result!=null)
                consecutivo = Long.parseLong(result);
        }
        catch (NoResultException e) {
            consecutivo = 0L;
        }
        catch (NumberFormatException e) {
            consecutivo = 0L;
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (consecutivo);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de registros de Carga N&oacute;mina que no poseen relaci&oacute;n con Ordenes de Pago.
     * @return List of SiiCargaNomina
     * @throws ExcepcionDAO
     */
    public List<SiiCargaNomina> buscarCargaNominaSinOrdenPago () throws ExcepcionDAO 
    {
        List<SiiCargaNomina> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  cno.cno_codigo, ");
            sql.append("        cno.cno_nombre_arch, ");
            sql.append("        cno.cno_descripcion, ");
            sql.append("        cno.afi_codigo, ");
            sql.append("        afi.afi_fecha ");
            sql.append("from sii_carga_nomina cno ");
            sql.append("INNER JOIN sii_archivo_fisico afi  ON  afi.afi_codigo = cno.afi_codigo ");
            sql.append("WHERE NOT EXISTS (SELECT orp.orp_codigo FROM SII_ORDEN_PAGO orp, SII_OBLIGACION obl WHERE orp.obl_codigo = obl.obl_codigo AND obl.cno_codigo = cno.cno_codigo) ");
            
            Query query = em.createNativeQuery(sql.toString());
            List<Object[]> lista = query.getResultList();
            
            if (lista!=null) {
                resultado = new ArrayList<SiiCargaNomina>();
                
                for (Object[] row: lista) {
                    if (row!=null && row[0]!=null) {
                        Long cnoCodigo = ((BigDecimal) row[0]).longValue();
                        SiiCargaNomina siiCargaNomina = this.buscarPorCodigo(cnoCodigo);
                        if (siiCargaNomina!=null) 
                            resultado.add(siiCargaNomina);
                    }
                }
            }
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de registros de Carga N&oacute;mina que poseen Ordenes de Pago pendientes por generar (alguna Obligaci&oacute;n no ha sido cubierta).
     * @return List of SiiCargaNomina
     * @throws ExcepcionDAO
     */
    public List<SiiCargaNomina> buscarCargaNominaConOrdenPagoPendientes () throws ExcepcionDAO 
    {
        List<SiiCargaNomina> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  cno.cno_codigo, ");
            sql.append("        cno.cno_nombre_arch, ");
            sql.append("        cno.cno_descripcion, ");
            sql.append("        cno.afi_codigo, ");
            sql.append("        afi.afi_fecha ");
            sql.append("from sii_carga_nomina cno ");
            sql.append("INNER JOIN sii_archivo_fisico afi  ON  afi.afi_codigo = cno.afi_codigo ");
            sql.append("WHERE EXISTS (SELECT obl.obl_codigo FROM SII_OBLIGACION obl ");
            sql.append("              INNER JOIN SII_ESTADO_OBLIGACION eob  ON  eob.eob_codigo = obl.eob_codigo ");
            sql.append("              WHERE obl.cno_codigo = cno.cno_codigo ");
            sql.append("              AND obl.eob_codigo = #eobCodigo ");
            sql.append("              AND obl.obl_codigo NOT IN (SELECT orp.obl_codigo FROM SII_ORDEN_PAGO orp WHERE orp.tdc_codigo = #tdcCodigo  AND  orp.eop_codigo <> #eopCodigo   AND  orp.obl_codigo IS NOT NULL)) ");
            
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("eobCodigo", EnumEstadoObligacion.APROBADO.getId());
            query.setParameter("tdcCodigo", EnumTipoDocContable.PAGO_FUNCIONARIOS_PLANTA.getId());
            // El registro de carga puede estar vinculado a una Obligacion asociada a una Orden de Pago en estado ANULADA, 
            // de manera que se genere una nueva Orden de Pago para la misma Obligacion.
            query.setParameter("eopCodigo", EnumEstadoOrdenPago.ANULADO.getId());
            
            List<Object[]> lista = query.getResultList();
            
            if (lista!=null) {
                resultado = new ArrayList<SiiCargaNomina>();
                
                for (Object[] row: lista) {
                    if (row!=null && row[0]!=null) {
                        Long cnoCodigo = ((BigDecimal) row[0]).longValue();
                        SiiCargaNomina siiCargaNomina = this.buscarPorCodigo(cnoCodigo);
                        if (siiCargaNomina!=null) 
                            resultado.add(siiCargaNomina);
                    }
                }
            }
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
}
