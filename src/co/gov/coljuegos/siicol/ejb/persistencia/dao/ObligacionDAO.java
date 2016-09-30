package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoObligacion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoOrdenPago;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocContable;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacion;

import java.math.BigDecimal;

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
public class ObligacionDAO extends GenericDAO<SiiObligacion>{
    
    public ObligacionDAO() {
        super(SiiObligacion.class);
    }

    public List<SiiObligacion> buscarObligacionesRegistradasVigenciaActual() throws ExcepcionDAO {
        try{
            List<SiiObligacion> listaObligacion = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            //sql.append("SELECT oblObliga FROM SiiObligacion oblObliga");
            
            sql.append(" SELECT obl FROM SiiObligacion obl " +
                            " inner join SiiSolicitudPago spa on spa.spaCodigo = obl.siiSolicitudPago.spaCodigo" +
                            " inner join SiiRp rp on rp.rpCodigo = obl.siiSolicitudPago.siiRp.rpCodigo");
            //sql.append(" order by obl.oblCodigo desc ");
            sql.append(" ORDER BY obl.oblNumero DESC ");
            Query query = em.createQuery(sql.toString());
            listaObligacion= query.getResultList();
            return listaObligacion;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionDAO");
        }
    }
    
    
    
    
    public List<SiiObligacion> buscarObligacionesRegistradasVigencia() throws ExcepcionDAO {
        try{
            List<SiiObligacion> listaObligacion = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT obl FROM SiiObligacion obl where obl.oblNumero like '13%' " );
               /* "AND obl.oblCodigo not in (SELECT op.siiObligacion.oblCodigo FROM SiiOrdenPago op) " );*/
                //"AND obl.siiEstadoObligacion.eobCodigo = 2");
            sql.append(" order by obl.oblNumero desc ");
            Query query = em.createQuery(sql.toString());
            //query.setParameter("vigencia", vigencia);
            listaObligacion= query.getResultList();
            return listaObligacion;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionDAO");
        }
    }
    
    public List<SiiObligacion> buscarObligacionesSinOrdenDePago() throws ExcepcionDAO {
        try{
            List<SiiObligacion> listaObligacion = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ob FROM SiiObligacion ob  ");
            sql.append(" WHERE  ");
            sql.append(" ob.oblCodigo not in (SELECT op.siiObligacion.oblCodigo FROM SiiOrdenPago op)  ");
            sql.append(" AND ");
            sql.append(" ob.siiEstadoObligacion.eobCodigo = 2 ");
            Query query = em.createQuery(sql.toString());
            listaObligacion= query.getResultList();
            return listaObligacion;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionDAO");
        }
    }
    
    
    
    /**
     * Realiza la consulta para obtener el Consecutivo de la Obligaci&oacute;n.
     * @return obligacion.numero.nextval
     * @throws ExcepcionDAO
     */
    public Integer buscarConsecutivoObligacion() throws ExcepcionDAO 
    {
        return (this.buscarConsecutivoObligacion(null));
    }
    
    
    
    /**
     * Realiza la consulta para obtener el Consecutivo de la Obligaci&oacute;n.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return obligacion.numero.nextval
     * @throws ExcepcionDAO
     */
    public Integer buscarConsecutivoObligacion(String tdcCodigo) throws ExcepcionDAO 
    {
        Integer consecutivo = null;
        try{
            StringBuilder sql = new StringBuilder();
            
            
            sql.append("SELECT NVL(MAX(OBL_NUMERO)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
            sql.append("FROM SII_OBLIGACION o "); 
            
            if (tdcCodigo!=null) {
                sql.append("INNER JOIN SII_TIPO_DOC_CONTABLE tdc  ON  tdc.tdc_codigo = o.tdc_codigo ");
            }
            
            sql.append("WHERE o.OBL_NUMERO LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%' ");
            
            if (tdcCodigo!=null) {
                sql.append("AND tdc.TDC_CODIGO = #tdcCodigo ");
            }
            
            Query query = em.createNativeQuery(sql.toString());
            
            if (tdcCodigo!=null)
                query.setParameter("tdcCodigo", tdcCodigo);
            
            Object result = query.getSingleResult();
            if(result != null){
                consecutivo = new Integer(((BigDecimal)result).intValueExact());
            }
            
        }
        catch (NoResultException e) {
            consecutivo = null;
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return consecutivo;
    }
    
    
    
    /**
     * Obtiene la &uacute;ltima Obligaci&oacute;n insertada.
     * @return obligaciones.last
     * @throws ExcepcionDAO
     */
    public SiiObligacion obtenerUltimaObligacion () throws ExcepcionDAO 
    {
        return (this.obtenerUltimaObligacion(null, null));
    }
    
    
    /**
     * Obtiene la &uacute;ltima Obligaci&oacute;n insertada.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return obligaciones.last
     * @throws ExcepcionDAO
     */
    public SiiObligacion obtenerUltimaObligacion (String tdcCodigo) throws ExcepcionDAO 
    {
        return (this.obtenerUltimaObligacion(tdcCodigo, null));
    }
    
    
    /**
     * Obtiene la &uacute;ltima Obligaci&oacute;n insertada.
     * @param oblCodigoOmision - C&oacute;digo de la Obligaci&oacute;n que debe ser omitida en el resultado (generalmente es la &uacute;ltima obligaci&oacute;n que a&acute;n se encuentra en estado BORRADOR).
     * @return obligaciones.last
     * @throws ExcepcionDAO
     */
    public SiiObligacion obtenerUltimaObligacion (Long oblCodigoOmision) throws ExcepcionDAO 
    {
        return (this.obtenerUltimaObligacion(null, oblCodigoOmision));
    }
    
    
    /**
     * Obtiene la &uacute;ltima Obligaci&oacute;n insertada.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @param oblCodigoOmision - C&oacute;digo de la Obligaci&oacute;n que debe ser omitida en el resultado (generalmente es la &uacute;ltima obligaci&oacute;n que a&acute;n se encuentra en estado BORRADOR).
     * @return obligaciones.last
     * @throws ExcepcionDAO
     */
    public SiiObligacion obtenerUltimaObligacion (String tdcCodigo, Long oblCodigoOmision) throws ExcepcionDAO 
    {
        SiiObligacion ultimaObligacion = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT o FROM SiiObligacion o ");
            sql.append("WHERE o.oblCodigo = (SELECT MAX(obl.oblCodigo) FROM SiiObligacion obl ");
            
            if (tdcCodigo!=null || oblCodigoOmision!=null) {
                sql.append("                     WHERE obl.oblCodigo = obl.oblCodigo ");
                
                if (tdcCodigo!=null)
                    sql.append("AND obl.siiTipoDocContable.tdcCodigo = :tdcCodigo ");
                
                if (oblCodigoOmision!=null)
                    sql.append("AND obl.oblCodigo <> :oblCodigoOmision ");
            }
            
            sql.append(") ");
            
            
            Query query = em.createQuery(sql.toString());
            
            if (tdcCodigo!=null)
                query.setParameter("tdcCodigo", tdcCodigo);
            
            if (oblCodigoOmision!=null)
                query.setParameter("oblCodigoOmision", oblCodigoOmision);
            
            ultimaObligacion = (SiiObligacion) query.getSingleResult();
        }
        catch (javax.persistence.NoResultException ne) {
            ultimaObligacion = null;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (ultimaObligacion);
    }
    
    
    
    /**
     * Realiza la consulta de Obligaciones que se encuentran asociadas al RP especificado.
     * @param rpCodigo - C&oacute;digo del RP.
     * @return List of SiiObligacion
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarObligacionPorRP (Long rpCodigo) throws ExcepcionDAO  {
        try{
            List<SiiObligacion> listaObligacion = new ArrayList<SiiObligacion>();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiObligacion o, ");
            sql.append("              SiiSolicitudPago sp, ");
            sql.append("              SiiRp rp ");
            sql.append("WHERE o.siiSolicitudPago.spaCodigo = sp.spaCodigo ");
            sql.append("AND sp.siiRp.rpCodigo = rp.rpCodigo ");
            sql.append("AND rp.rpCodigo = :rpCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            listaObligacion= query.getResultList();
            return listaObligacion;    
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la consulta de Obligaciones que se encuentran en el Estado especificado y est&aacute;n asociadas al RP suministrado.
     * @param rpCodigo - C&oacute;digo del RP
     * @param idEstadoObligacion - Estado de la Obligaci&oacute;n
     * @return List of SiiObligacion
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarObligacionPorRPYEstado (Long rpCodigo, Long idEstadoObligacion) throws ExcepcionDAO  {
        try{
            List<SiiObligacion> listaObligacion = new ArrayList<SiiObligacion>();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiObligacion o, ");
            sql.append("              SiiEstadoObligacion eo, ");
            sql.append("              SiiSolicitudPago sp, ");
            sql.append("              SiiRp rp ");
            sql.append("WHERE o.siiEstadoObligacion.eobCodigo = eo.eobCodigo ");
            sql.append("AND o.siiSolicitudPago.spaCodigo = sp.spaCodigo ");
            sql.append("AND sp.siiRp.rpCodigo = rp.rpCodigo ");
            sql.append("AND rp.rpCodigo = :rpCodigo ");
            sql.append("AND eo.eobCodigo = :eobCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            query.setParameter("eobCodigo", idEstadoObligacion);
            listaObligacion= query.getResultList();
            return listaObligacion;    
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la consulta de TODAS las Obligaciones que se encuentran asociadas al Beneficiario (Proveedor) especificado.
     * @param idBeneficiario - C&oacute;digo del Beneficiario/Proveedor
     * @return List of SiiObligacion
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarObligacionPorBeneficiario (Long idBeneficiario) throws ExcepcionDAO  {
        return ( this.buscarObligacionPorBeneficiarioMesYEstado(idBeneficiario, null, null) );
    }
    
    
    /**
     * Realiza la consulta de las Obligaciones que se encuentran en el Estado suministrado, asociadas al Beneficiario (Proveedor) especificado.
     * @param idBeneficiario - C&oacute;digo del Beneficiario/Proveedor
     * @param idEstadoObligacion - Estado de la Obligaci&oacute;n.
     * @return List of SiiObligacion
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarObligacionPorBeneficiarioYEstado (Long idBeneficiario, Long idEstadoObligacion) throws ExcepcionDAO  {
        return ( this.buscarObligacionPorBeneficiarioMesYEstado(idBeneficiario, idEstadoObligacion, null) );
    }
    
    
    
    /**
     * Realiza la consulta de las Obligaciones del Mes elegido, que se encuentran asociadas al Beneficiario (Proveedor) especificado, correspondientes al Estado de la Obligaci&oacute;n suministrado.
     * @param idBeneficiario - C&oacute;digo del Beneficiario/Proveedor
     * @param idEstadoObligacion - C&oacute;digo del Estado de la Obligaci&oacute;n.
     * @param fecha - Fecha que se utilizar&aacute; para filtrar el Mes de la Obligaci&oacute;n.
     * @return List of SiiObligacion
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarObligacionPorBeneficiarioMesYEstado (Long idBeneficiario, Long idEstadoObligacion, Date fecha) throws ExcepcionDAO  {
        try{
            List<SiiObligacion> listaObligacion = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiObligacion o, ");
            
            if (idEstadoObligacion!=null)
                sql.append("              SiiEstadoObligacion eo, ");
            
            sql.append("              SiiSolicitudPago sp, ");
            sql.append("              SiiRp rp, ");
            sql.append("              SiiProveedor p ");
            sql.append("WHERE o.siiSolicitudPago.spaCodigo = sp.spaCodigo ");
            sql.append("AND sp.siiRp.rpCodigo = rp.rpCodigo ");
            sql.append("AND rp.siiProveedor.proCodigo = p.proCodigo ");
            sql.append("AND p.proCodigo = :proCodigo ");
            
            if (idEstadoObligacion!=null) {
                sql.append("AND o.siiEstadoObligacion.eobCodigo = eo.eobCodigo ");
                sql.append("AND eo.eobCodigo = :eobCodigo ");
            }
            
            if (fecha!=null) {
                // obligaciones cuya fecha se encuentre entre el primero del mes y la fecha suministrada
                sql.append("AND o.oblFecha BETWEEN :fechaIni AND :fechaFin ");
            }
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("proCodigo", idBeneficiario);
            
            if (idEstadoObligacion!=null)
                query.setParameter("eobCodigo", idEstadoObligacion);
            
            if (fecha!=null) {
                Calendar calendarFin = Calendar.getInstance();
                calendarFin.setTime(fecha);
                
                Calendar calendarIni = Calendar.getInstance();
                calendarIni.set(Calendar.YEAR, calendarFin.get(Calendar.YEAR));
                calendarIni.set(Calendar.MONTH, calendarFin.get(Calendar.MONTH));
                calendarIni.set(Calendar.DAY_OF_MONTH, 1);
                
                query.setParameter("fechaIni", calendarIni.getTime());
                query.setParameter("fechaFin", calendarFin.getTime());
            }
            
            
            listaObligacion = query.getResultList();
            
            return listaObligacion;
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Calcula el TOTAL de la Obligaci&oacute;n (sumatoria de los totales de los Conceptos de la Obligaci&oacute;n).
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @return Sumatoria de los totales de los Conceptos que componenen la Obligaci&oacute;n.
     * @throws ExcepcionDAO
     */
    public BigDecimal obtenerValorTotalObligacion (Long oblCodigo) throws ExcepcionDAO {
        BigDecimal total = new BigDecimal(0);
        
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT SUM(oco.oco_subtotal + oco.oco_iva) ");
            sql.append("FROM sii_obligacion_concepto oco ");
            sql.append("WHERE oco.obl_codigo = #oblCodigo");
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("oblCodigo", oblCodigo);
            List<Object[]> results = query.getResultList();
            if (results!=null && !results.isEmpty()) {
                // primera fila
                Object[] row = results.get(0);
                // primera columna
                total = (BigDecimal) row[0];
            }
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return (total);
    }
    
    
    
    /**
     * Obtiene la suma de las Obligaciones registradas en el mes a nombre del Beneficiario.
     * @param proCodigo - C&oacute;digo del Proveedor correspondiente al Beneficiario.
     * @return Total de obligaciones.
     * @throws ExcepcionDAO
     */
    public BigDecimal obtenerValorObligacionesBeneficiarioMes (Long proCodigo) throws ExcepcionDAO {
        return (this.obtenerValorObligacionesBeneficiarioMes(proCodigo, null));
    }
    
    
    /**
     * Obtiene la suma de las Obligaciones (IVA incluido) registradas en el mes a nombre del Beneficiario.
     * @param proCodigo - C&oacute;digo del Proveedor correspondiente al Beneficiario.
     * @param fecha - Fecha que se utilizar&aacute; para filtrar el Mes de la Obligaci&oacute;n.
     * @return Total de obligaciones.
     * @throws ExcepcionDAO
     */
    public BigDecimal obtenerValorObligacionesBeneficiarioMes (Long proCodigo, Date fecha) throws ExcepcionDAO {
        return (this.obtenerValorObligacionesBeneficiarioMes(proCodigo, fecha, true));
    }
    
    
    /**
     * Obtiene la suma de las Obligaciones registradas en el mes a nombre del Beneficiario.
     * @param proCodigo - C&oacute;digo del Proveedor correspondiente al Beneficiario.
     * @param fecha - Fecha que se utilizar&aacute; para filtrar el Mes de la Obligaci&oacute;n.
     * @param ivaIncluido - Determina si se debe incluir el IVA en el resultado de la consulta.
     * @return Total de obligaciones.
     * @throws ExcepcionDAO
     */
    public BigDecimal obtenerValorObligacionesBeneficiarioMes (Long proCodigo, Date fecha, boolean ivaIncluido) throws ExcepcionDAO {
        BigDecimal total = new BigDecimal(0);
        
        if (proCodigo!=null) {
            
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT NVL(SUM(Y.TOTAL), 0) AS TOTAL ");
                sql.append("FROM ( ");
                
                if (ivaIncluido)
                    sql.append("    SELECT NVL(oco.OCO_SUBTOTAL,0) + NVL(oco.OCO_IVA,0) AS TOTAL ");
                else
                    sql.append("    SELECT NVL(oco.OCO_SUBTOTAL,0) AS TOTAL ");
                
                sql.append("    FROM SII_OBLIGACION_CONCEPTO oco "); 
                sql.append("    INNER JOIN SII_OBLIGACION obl  ON  obl.OBL_CODIGO = oco.OBL_CODIGO ");
                sql.append("    INNER JOIN SII_SOLICITUD_PAGO sp  ON  sp.SPA_CODIGO = obl.SPA_CODIGO ");
                sql.append("    INNER JOIN SII_RP rp  ON  rp.RP_CODIGO = sp.RP_CODIGO "); 
                sql.append("    INNER JOIN SII_PROVEEDOR pro  ON  pro.PRO_CODIGO = rp.PRO_CODIGO ");
                sql.append("    WHERE obl.EOB_CODIGO = #eobCodigo ");
                sql.append("    AND pro.PRO_CODIGO = #proCodigo ");
                
                if (fecha!=null)
                    sql.append("    AND obl.OBL_FECHA  BETWEEN  TRUNC(#fecha, 'MONTH')  AND  #fecha ");
                else
                    sql.append("    AND obl.OBL_FECHA  BETWEEN  TRUNC(CURRENT_DATE, 'MONTH')  AND  CURRENT_DATE ");
                
                sql.append(") Y ");
                
                Query query = em.createNativeQuery(sql.toString());
                query.setParameter("eobCodigo", EnumEstadoObligacion.APROBADO.getId());
                query.setParameter("proCodigo", proCodigo);
                
                if (fecha!=null)
                    query.setParameter("fecha", fecha);
                
                
                Object result = query.getSingleResult();
                if (result!=null)
                    total = (BigDecimal) result;
                
            }
            catch (javax.persistence.NoResultException ne) {
                total = new BigDecimal(0);
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }        
        
        return (total);
    }
    
    
    
    /**
     * Obtiene la suma de los valores de Retenci&oacute;n en la Fuente para aquellas Obligaciones registradas en el mes a nombre del Beneficiario.
     * @param proCodigo - C&oacute;digo del Proveedor correspondiente al Beneficiario.
     * @return Total de Pagos Anteriores de Retenci&oacute;n en la Fuente.
     * @throws ExcepcionDAO
     */
    public BigDecimal obtenerTotalPagoAntRfteObligacionesBeneficiarioMes (Long proCodigo) throws ExcepcionDAO {
        return (this.obtenerTotalPagoAntRfteObligacionesBeneficiarioMes(proCodigo, null));
    }
    
    
    
    /**
     * Obtiene la suma de los valores de Retenci&oacute;n en la Fuente para aquellas Obligaciones registradas en el mes a nombre del Beneficiario.
     * @param proCodigo - C&oacute;digo del Proveedor correspondiente al Beneficiario.
     * @param fecha - Fecha que se utilizar&aacute; para filtrar el Mes de la Obligaci&oacute;n.
     * @return Total de Pagos Anteriores de Retenci&oacute;n en la Fuente.
     * @throws ExcepcionDAO
     */
    public BigDecimal obtenerTotalPagoAntRfteObligacionesBeneficiarioMes (Long proCodigo, Date fecha) throws ExcepcionDAO {
        BigDecimal total = new BigDecimal(0);
        
        if (proCodigo!=null) {
            
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT NVL(SUM(Y.TOTAL), 0) AS TOTAL ");
                sql.append("FROM ( ");
                sql.append("    SELECT NVL(oco.OCO_VALOR_RENTA,0) AS TOTAL "); 
                sql.append("    FROM SII_OBLIGACION_CONCEPTO oco "); 
                sql.append("    INNER JOIN SII_OBLIGACION obl  ON  obl.OBL_CODIGO = oco.OBL_CODIGO ");
                sql.append("    INNER JOIN SII_SOLICITUD_PAGO sp  ON  sp.SPA_CODIGO = obl.SPA_CODIGO ");
                sql.append("    INNER JOIN SII_RP rp  ON  rp.RP_CODIGO = sp.RP_CODIGO "); 
                sql.append("    INNER JOIN SII_PROVEEDOR pro  ON  pro.PRO_CODIGO = rp.PRO_CODIGO ");
                sql.append("    WHERE obl.EOB_CODIGO = #eobCodigo ");
                sql.append("    AND pro.PRO_CODIGO = #proCodigo ");
                
                if (fecha!=null)
                    sql.append("    AND obl.OBL_FECHA  BETWEEN  TRUNC(#fecha, 'MONTH')  AND  #fecha ");
                else
                    sql.append("    AND obl.OBL_FECHA  BETWEEN  TRUNC(CURRENT_DATE, 'MONTH')  AND  CURRENT_DATE ");
                
                sql.append(") Y ");
                
                
                Query query = em.createNativeQuery(sql.toString());
                query.setParameter("eobCodigo", EnumEstadoObligacion.APROBADO.getId());
                query.setParameter("proCodigo", proCodigo);
                
                if (fecha!=null)
                    query.setParameter("fecha", fecha);
                
                
                Object result = query.getSingleResult();
                if (result!=null)
                    total = (BigDecimal) result;
                
            }
            catch (javax.persistence.NoResultException ne) {
                total = new BigDecimal(0);
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }        
        
        return (total);
    }
    
    
    
    /**
     * Realiza la consulta del listado de Obligaciones que no han sido cubiertas por Ordenes de Pago.
     * @return List of SiiObligacion
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarObligacionesNoCubiertasPorOrdenPago () throws ExcepcionDAO {
        return (this.buscarObligacionesNoCubiertasPorOrdenPago(false));
    }
    
    
    /**
     * Realiza la consulta del listado de Obligaciones que no han sido cubiertas por Ordenes de Pago.
     * @param mostrarObligacionesCuentasPorPagar - ¿Consultar las Obligaciones de Cuentas por Pagar (vigencia 2013)?
     * @return List of SiiObligacion
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarObligacionesNoCubiertasPorOrdenPago (boolean mostrarObligacionesCuentasPorPagar) throws ExcepcionDAO 
    {
        List<SiiObligacion> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append("WITH vg AS ( ");
            sql.append("  SELECT oco_vg.FFC_CODIGO, ");
            sql.append("         oco_vg.OBL_CODIGO, ");
            sql.append("         SUM( NVL(oco_vg.OCO_SUBTOTAL, 0) + NVL(oco_vg.OCO_IVA, 0) - NVL(oco_vg.OCO_VALOR_RENTA, 0) - NVL(oco_vg.OCO_VALOR_IVA, 0) - NVL(oco_vg.OCO_VALOR_ICA, 0) - NVL(oco_vg.OCO_VALOR_RET_ESTAMP, 0) - NVL(oco_vg.OCO_VALOR_VOL_AFP, 0) - NVL(oco_vg.OCO_VALOR_VOL_AFC, 0) ) AS VALOR_GIRAR ");
            sql.append("  FROM SII_OBLIGACION_CONCEPTO oco_vg "); 
            sql.append("  GROUP BY oco_vg.FFC_CODIGO, oco_vg.OBL_CODIGO "); 
            sql.append(") "); 
            sql.append(", ");
            sql.append("vd AS ( "); 
            sql.append("  SELECT ncr.FFC_CODIGO, ");
            sql.append("         ncr.OBL_CODIGO, ");
            sql.append("         SUM( NVL(nco.NCO_SUBTOTAL, 0) + NVL(nco.NCO_IVA, 0) - NVL(nco.NCO_VALOR_RETRENTA, 0) - NVL(nco.NCO_VALOR_RETIVA, 0) - NVL(nco.NCO_VALOR_RETICA, 0) - NVL(nco.NCO_VALOR_RETEST, 0) - NVL(nco.NCO_BENEF_DED_AFP, 0) - NVL(nco.NCO_BENEF_DED_AFC, 0) ) AS VALOR_DESCONTAR "); 
            sql.append("  FROM SII_NOTA_CREDITO ncr ");
            sql.append("  INNER JOIN SII_NOTA_CRED_OBL_CONCEPTO nco  ON  nco.NCR_CODIGO = ncr.NCR_CODIGO ");
            sql.append("  GROUP BY ncr.FFC_CODIGO, ncr.OBL_CODIGO ");
            sql.append(") ");
            sql.append(", ");
            sql.append("vo AS ( ");
            sql.append("    SELECT OBL_CODIGO, FFC_CODIGO, SUM(VALOR) AS TOTAL ");
            sql.append("    FROM ( ");
            sql.append("    (SELECT vg.OBL_CODIGO, vg.FFC_CODIGO, nvl(vg.VALOR_GIRAR, 0) AS VALOR "); 
            sql.append("    FROM vg ");
            sql.append("    INNER JOIN SII_OBLIGACION obl_vg  ON  obl_vg.OBL_CODIGO = vg.OBL_CODIGO ");
            sql.append("    INNER JOIN SII_FUENTE_FINANC_CONTAB ffc_vg  ON  ffc_vg.FFC_CODIGO = vg.FFC_CODIGO) ");
            sql.append("    UNION ");
            sql.append("    (SELECT vd.OBL_CODIGO, vd.FFC_CODIGO, nvl(vd.VALOR_DESCONTAR, 0)*-1 AS VALOR "); 
            sql.append("    FROM vd "); 
            sql.append("    INNER JOIN SII_OBLIGACION obl_vd  ON  obl_vd.OBL_CODIGO = vd.OBL_CODIGO ");
            sql.append("    INNER JOIN SII_FUENTE_FINANC_CONTAB ffc_vd  ON  ffc_vd.FFC_CODIGO = vd.FFC_CODIGO) ");
            sql.append("    ) "); 
            sql.append("    GROUP BY OBL_CODIGO, FFC_CODIGO ");
            sql.append(") ");
            sql.append("SELECT Y.OBL_CODIGO, "); 
            sql.append("       Y.OBL_NUMERO, "); 
            sql.append("       Y.OBL_FECHA, "); 
            sql.append("       Y.EOB_CODIGO, "); 
            sql.append("       Y.SPA_CODIGO, "); 
            sql.append("       Y.TDC_CODIGO, ");
            sql.append("       Y.GASTOS_PERSONAL, ");
            sql.append("       Y.GASTOS_GENERALES, "); 
            sql.append("       Y.RECURSOS_PROPIOS, ");
            sql.append("       Y.ORDENES_GP, ");
            sql.append("       Y.ORDENES_GG, "); 
            sql.append("       Y.ORDENES_RP ");
            sql.append("FROM ");
            sql.append("        (SELECT  obl.*,  ");
            sql.append("               NVL((SELECT ROUND(vo.TOTAL) FROM vo ");
            sql.append("                      WHERE vo.OBL_CODIGO = obl.OBL_CODIGO "); 
            sql.append("                      AND vo.FFC_CODIGO = 'RNP'), 0) AS GASTOS_PERSONAL,  ");
            
            sql.append("                 NVL((SELECT ROUND(vo.TOTAL) FROM vo ");
            sql.append("                      WHERE vo.OBL_CODIGO = obl.OBL_CODIGO "); 
            sql.append("                      AND vo.FFC_CODIGO = 'RNG'), 0) AS GASTOS_GENERALES, ");
            
            sql.append("                 NVL((SELECT ROUND(vo.TOTAL) FROM vo ");
            sql.append("                      WHERE vo.OBL_CODIGO = obl.OBL_CODIGO ");
            sql.append("                      AND vo.FFC_CODIGO = 'RPE'), 0) AS RECURSOS_PROPIOS, ");
            
            sql.append("                 NVL((SELECT ROUND(vo.TOTAL) FROM vo ");
            sql.append("                      WHERE vo.OBL_CODIGO = obl.OBL_CODIGO ");
            sql.append("                      AND vo.FFC_CODIGO = 'RNT'), 0) AS GASTOS_TRANSFERENCIA, ");
            
            sql.append("                 NVL((SELECT ROUND(vo.TOTAL) FROM vo ");
            sql.append("                      WHERE vo.OBL_CODIGO = obl.OBL_CODIGO ");
            sql.append("                      AND vo.FFC_CODIGO = 'RCI'), 0) AS RECURSOS_ILEGALIDAD, ");

            sql.append("               (SELECT ROUND(NVL(SUM(p.ORP_VALOR_GASTO), 0)) FROM Sii_Orden_Pago p ");
            sql.append("                INNER JOIN Sii_Obligacion o  ON  o.obl_Codigo = p.obl_Codigo "); 
            sql.append("                WHERE  p.obl_Codigo = obl.OBL_CODIGO  ");
            sql.append("                AND    p.EOP_CODIGO <> #eopCodigo ");
            sql.append("                AND    p.orp_Tipo_Gasto = 'GP') AS ORDENES_GP, "); 

            sql.append("                (SELECT ROUND(NVL(SUM(p.ORP_VALOR_GASTO), 0)) FROM Sii_Orden_Pago p ");
            sql.append("                INNER JOIN Sii_Obligacion o  ON  o.obl_Codigo = p.obl_Codigo ");
            sql.append("                WHERE  p.obl_Codigo = obl.OBL_CODIGO  ");
            sql.append("                AND    p.EOP_CODIGO <> #eopCodigo ");
            sql.append("                AND    p.orp_Tipo_Gasto = 'GG') AS ORDENES_GG, "); 

            sql.append("                (SELECT ROUND(NVL(SUM(p.ORP_VALOR_GASTO), 0)) FROM Sii_Orden_Pago p ");
            sql.append("                INNER JOIN Sii_Obligacion o  ON  o.obl_Codigo = p.obl_Codigo "); 
            sql.append("                WHERE  p.obl_Codigo = obl.OBL_CODIGO  ");
            sql.append("                AND    p.EOP_CODIGO <> #eopCodigo ");
            sql.append("                AND    p.orp_Tipo_Gasto = 'RP') AS ORDENES_RP ");
            sql.append("        FROM SII_OBLIGACION obl ");
            sql.append("        INNER JOIN SII_SOLICITUD_PAGO spa  ON  spa.SPA_CODIGO = obl.SPA_CODIGO ");
            
            sql.append("        WHERE obl.EOB_CODIGO = #eobCodigo  ");
            
            if (!mostrarObligacionesCuentasPorPagar)
                sql.append("        AND obl.OBL_NUMERO >= 13999999 ");
            
            sql.append("        ) Y ");
            sql.append("WHERE (Y.GASTOS_PERSONAL + Y.GASTOS_GENERALES + Y.RECURSOS_PROPIOS + Y.GASTOS_TRANSFERENCIA + Y.RECURSOS_ILEGALIDAD) <> (Y.ORDENES_GP + Y.ORDENES_GG + Y.ORDENES_RP) ");
            
            
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("eobCodigo", EnumEstadoObligacion.APROBADO.getId());
            query.setParameter("eopCodigo", EnumEstadoOrdenPago.ANULADO.getId());
            
            List<Object[]> rows = query.getResultList();
            
            if (rows!=null) {
                resultado = new ArrayList<SiiObligacion>();
                
                for (Object[] row: rows) {
                    if (row[0]!=null) {
                        // consultar y adicionar el objeto SiiObligacion
                        Long oblCodigo = ((BigDecimal) row[0]).longValue();
                        SiiObligacion siiObligacion = this.buscarPorCodigo(oblCodigo);
                        resultado.add(siiObligacion);
                    }
                }
            }
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    
    public List<SiiObligacion> buscarObligacionesNoCubiertasPorOrdenPagoCuentasPagar () throws ExcepcionDAO 
    {
        List<SiiObligacion> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT Y.OBL_CODIGO, "); 
            sql.append("       Y.OBL_NUMERO, "); 
            sql.append("       Y.OBL_FECHA, "); 
            sql.append("       Y.EOB_CODIGO, "); 
            sql.append("       Y.SPA_CODIGO, "); 
            sql.append("       Y.TDC_CODIGO, ");
            sql.append("       Y.GASTOS_PERSONAL, ");
            sql.append("       Y.GASTOS_GENERALES, "); 
            sql.append("       Y.RECURSOS_PROPIOS, ");
            sql.append("       Y.ORDENES_GP, ");
            sql.append("       Y.ORDENES_GG, "); 
            sql.append("       Y.ORDENES_RP ");
            sql.append("FROM ");
            sql.append("        (SELECT  obl.*,  ");
            sql.append("               (select NVL(SUM(P.OCO_SUBTOTAL), 0) from SII_OBLIGACION O "); 
            sql.append("                inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO "); 
            sql.append("                WHERE P.FFC_CODIGO = 'RNP' ");
            sql.append("                AND O.OBL_CODIGO = obl.OBL_CODIGO) AS GASTOS_PERSONAL, ");

            sql.append("               (select NVL(SUM(P.OCO_SUBTOTAL), 0) from SII_OBLIGACION O ");
            sql.append("                inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO "); 
            sql.append("                WHERE P.FFC_CODIGO = 'RNG' ");
            sql.append("                AND O.OBL_CODIGO = obl.OBL_CODIGO) AS GASTOS_GENERALES, ");

            sql.append("               (select NVL(SUM(P.OCO_SUBTOTAL), 0)  from SII_OBLIGACION O ");
            sql.append("                inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO ");
            sql.append("                WHERE P.FFC_CODIGO = 'RPE' ");
            sql.append("                AND O.OBL_CODIGO = obl.OBL_CODIGO) AS RECURSOS_PROPIOS, ");

            sql.append("               (SELECT NVL(SUM(p.ORP_VALOR_GASTO), 0) FROM Sii_Orden_Pago p ");
            sql.append("                INNER JOIN Sii_Obligacion o  ON  o.obl_Codigo = p.obl_Codigo "); 
            sql.append("                WHERE  p.obl_Codigo = obl.OBL_CODIGO  ");
            sql.append("                AND    p.orp_Tipo_Gasto = 'GP') AS ORDENES_GP, "); 

            sql.append("                (SELECT NVL(SUM(p.ORP_VALOR_GASTO), 0) FROM Sii_Orden_Pago p ");
            sql.append("                INNER JOIN Sii_Obligacion o  ON  o.obl_Codigo = p.obl_Codigo ");
            sql.append("                WHERE  p.obl_Codigo = obl.OBL_CODIGO  ");
            sql.append("                AND    p.orp_Tipo_Gasto = 'GG') AS ORDENES_GG, "); 

            sql.append("                (SELECT NVL(SUM(p.ORP_VALOR_GASTO), 0) FROM Sii_Orden_Pago p ");
            sql.append("                INNER JOIN Sii_Obligacion o  ON  o.obl_Codigo = p.obl_Codigo "); 
            sql.append("                WHERE  p.obl_Codigo = obl.OBL_CODIGO  ");
            sql.append("                AND    p.orp_Tipo_Gasto = 'RP') AS ORDENES_RP ");
            sql.append("        FROM SII_OBLIGACION obl ");
            
            sql.append("        WHERE obl.obl_numero like '13%'   ");
            sql.append("        ) Y ");
            sql.append("WHERE (Y.GASTOS_PERSONAL + Y.GASTOS_GENERALES + Y.RECURSOS_PROPIOS) <> (Y.ORDENES_GP + Y.ORDENES_GG + Y.ORDENES_RP) ");
            
            
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("eobCodigo", EnumEstadoObligacion.APROBADO.getId());
            
            List<Object[]> rows = query.getResultList();
            
            if (rows!=null) {
                resultado = new ArrayList<SiiObligacion>();
                
                for (Object[] row: rows) {
                    if (row[0]!=null) {
                        // consultar y adicionar el objeto SiiObligacion
                        Long oblCodigo = ((BigDecimal) row[0]).longValue();
                        SiiObligacion siiObligacion = this.buscarPorCodigo(oblCodigo);
                        resultado.add(siiObligacion);
                    }
                }
            }
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    
    /**
     * Realiza la consulta del listado de Obligaciones correspondientes al Cargue de N&oacute;mina asociado al c&oacute;digo especificado.
     * @param cnoCodigo - C&oacute;digo del Cargue de N&oacute;mina.
     * @return List of SiiObligacion
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarPorCodigoCargaNomina (Long cnoCodigo) throws ExcepcionDAO {
        List<SiiObligacion> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiObligacion o ");
            sql.append("WHERE o.siiCargaNomina.cnoCodigo = :cnoCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("cnoCodigo", cnoCodigo);
            
            resultado = query.getResultList();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    
    /**
     * Realiza la consulta del listado de Obligaciones correspondientes al Cargue de N&oacute;mina asociado al c&oacute;digo especificado.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return List of SiiObligacion
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarPorTipoDocContable (String tdcCodigo) throws ExcepcionDAO {
        List<SiiObligacion> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiObligacion o ");
            sql.append("WHERE o.siiTipoDocContable.tdcCodigo = :tdcCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("tdcCodigo", tdcCodigo);
            
            resultado = query.getResultList();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la consulta del listado de Obligaciones correspondientes a la Distribuci&oacute;n Mes especificada.
     * @param dmeCodigo - C&oacute;digo de la Distribuci&oacute;n Mes.
     * @return List of SiiObligacion.
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarPorIdDistribucionMes (Long dmeCodigo) throws ExcepcionDAO {
        List<SiiObligacion> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiObligacion o ");
            sql.append("WHERE o.siiDistribucionMes.dmeCodigo = :dmeCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("dmeCodigo", dmeCodigo);
            
            resultado = query.getResultList();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la consulta del listado de Obligaciones correspondientes al Cargue de N&oacute;mina, que contienen al menos un Concepto de N&oacute;mina de Reintegro.
     * @param eobCodigo - Estado de la Obligaci&oacute;n.
     * @return List of SiiObligacion
     * @throws ExcepcionDAO
     */
    public List<SiiObligacion> buscarObligacionConConceptoReintegro (Long eobCodigo) throws ExcepcionDAO {
        List<SiiObligacion> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT obl.OBL_CODIGO ");
            sql.append("FROM SII_OBLIGACION obl ");
            sql.append("WHERE obl.TDC_CODIGO = #tdcCodigo ");
            sql.append("AND obl.EOB_CODIGO = #eobCodigo ");
            sql.append("AND EXISTS (SELECT dcn.DCM_CODIGO FROM SII_DETALLE_CONT_NOMINA dcn ");
            sql.append("            INNER JOIN SII_CONCEPTO_NOMINA cno  ON  cno.CNO_CODIGO = dcn.CNO_CODIGO ");
            sql.append("            WHERE dcn.OBL_CODIGO = obl.OBL_CODIGO ");
            sql.append("            AND cno.CNO_REINTEGRO = #cnoReintegro ) ");
            
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("tdcCodigo", EnumTipoDocContable.OBLIGACION_FUNCIONARIOS_DE_PLANTA.getId());
            query.setParameter("cnoReintegro", EnumDecision.SI.getId());
            
            if (eobCodigo!=null)
                query.setParameter("eobCodigo", eobCodigo);
            else
                query.setParameter("eobCodigo", EnumEstadoObligacion.APROBADO.getId());
            
            
            List<BigDecimal> listaOblCodigos = query.getResultList();
            if (listaOblCodigos!=null && !listaOblCodigos.isEmpty()) {
                resultado = new ArrayList<SiiObligacion>();
                
                for (BigDecimal codigo: listaOblCodigos) {
                    if (codigo!=null) {
                        Long oblCodigo = codigo.longValueExact();
                        // buscar cada obligacion por codigo y adicionarla a la lista.
                        SiiObligacion siiObligacion = this.buscarPorCodigo(oblCodigo);
                        if (siiObligacion!=null)
                            resultado.add(siiObligacion);
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
