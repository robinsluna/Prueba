/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumConceptoLiquidacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;

import co.gov.coljuegos.siicol.ejb.vo.CambioEstDocContableVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoAccionControlVO;
import co.gov.coljuegos.siicol.ejb.vo.RecaudoEnteVO;
import co.gov.coljuegos.siicol.ejb.vo.SustanciadorAuditorVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class DocumentoContableDAO extends GenericDAO<SiiDocumentoContable>
{
    private Recursos recursos;
    
    @EJB
    private TipoDocContableDAO tipoDocContableDao;
    @EJB
    private EstadoDocContabDAO estadoDocContabDao;
    @EJB
    private LiquidacionMesDAO liquidacionMesDao;
    
    
    
    /**
     * Constructor.
     */
    public DocumentoContableDAO() {
        // Establecer la clase correspondiente a la Entidad que administra el DAO
        super(SiiDocumentoContable.class);
    }

    
    /**
     * Realiza la b&uacute;squeda del &uacute;ltimo Documento Contable del tipo suministrado.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return last of SiiDocumentoContable[tdcCodigo].
     * @throws ExcepcionDAO
     */
    public SiiDocumentoContable buscarUltimoDocumentoContable (String tdcCodigo) throws ExcepcionDAO {
        SiiDocumentoContable siiDocumentoContable= null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dco FROM SiiDocumentoContable dco ");
            sql.append("WHERE dco.dcoCodigo = (SELECT MAX(dc.dcoCodigo) FROM SiiDocumentoContable dc WHERE dc.siiTipoDocContable.tdcCodigo = :tdcCodigo)");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("tdcCodigo", tdcCodigo);
            
            siiDocumentoContable = (SiiDocumentoContable) query.getSingleResult();

        }
        catch (javax.persistence.NoResultException ne) {
            siiDocumentoContable = null;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }
        
        return siiDocumentoContable;
    }
    
    
    
    
    /**
     * Realiza la consulta de los Documentos Contables asociados a una Obligaci&oacute;n.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @return listado de SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorCodigoObligacion (Long oblCodigo) 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dc FROM SiiDocumentoContable dc, ");
            sql.append("               SiiObligacion o ");
            sql.append("WHERE o.oblCodigo = dc.siiObligacion.oblCodigo ");
            sql.append("AND o.oblCodigo = :oblCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("oblCodigo", oblCodigo);
            List<SiiDocumentoContable> listaDC = query.getResultList();
            return listaDC;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la consulta de los Documentos Contables asociados a una Orden de Pago.
     * @param orpCodigo - C&oacute;digo de la Orden de Pago.
     * @return listado de SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorCodigoOrdenPago (Long orpCodigo) 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dc FROM SiiDocumentoContable dc, ");
            sql.append("               SiiOrdenPago op ");
            sql.append("WHERE op.orpCodigo = dc.siiOrdenPago.orpCodigo ");
            sql.append("AND op.orpCodigo = :orpCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("orpCodigo", orpCodigo);
            List<SiiDocumentoContable> listaDC = query.getResultList();
            return listaDC;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    /**
     * Realiza la consulta de los Documentos Contables correspondientes al Tipo de Documento especificado.
     * @param tdcCodigo - C&oacute;digo del Tipo de Documento Contable.
     * @return List of SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorTipoDocumentoContable (String tdcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dc FROM SiiDocumentoContable dc ");
            sql.append("WHERE dc.siiTipoDocContable.tdcCodigo = :tdcCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("tdcCodigo", tdcCodigo);
            List<SiiDocumentoContable> listaDC = query.getResultList();
            return listaDC;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    /**
     * Realiza la consulta para obtener el Consecutivo del Documento Contable a trav&eacute;s del Tipo de Documento Contable.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return documentoContable.numero.nextval
     * @throws ExcepcionDAO
     */
    public Integer buscarConsecutivoDocumentoContable(String tdcCodigo) throws ExcepcionDAO 
    {
        Integer consecutivo = null;
        try{
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT NVL(MAX(dco.DCO_NUMERO_COMPR)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
            sql.append("FROM SII_DOCUMENTO_CONTABLE dco "); 
            sql.append("WHERE dco.DCO_NUMERO_COMPR LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%' ");
            sql.append("AND dco.TDC_CODIGO = #tdcCodigo");
            
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("tdcCodigo", tdcCodigo);
            
            if(query.getSingleResult() != null){
                consecutivo = new Integer(((BigDecimal)query.getSingleResult()).intValueExact());
            }
            
        }
        catch (javax.persistence.NoResultException ne) {
            consecutivo = null;
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
    
    
    /**
     * Realiza la consulta para obtener el Consecutivo del Documento Contable a trav&eacute;s del Tipo de Documento Contable y la Vigencia.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @param vigencia - Vigencia que se tomar&aacute; como referencia para el prefijo del Consecutivo.
     * @return documentoContable.numero.nextval
     * @throws ExcepcionDAO
     */
    public Integer buscarConsecutivoDocumentoContable(String tdcCodigo, Integer vigencia) throws ExcepcionDAO 
    {
        Integer consecutivo = null;
        
        if (tdcCodigo!=null) {
            
            try{
                StringBuilder sql = new StringBuilder();
                
                String prefix = null;
                if (vigencia!=null) {
                    int length = vigencia.toString().length();
                    prefix = vigencia.toString().substring(length-2);
                }
                
                if (prefix!=null)
                    sql.append("SELECT NVL(MAX(dco.DCO_NUMERO_COMPR)+1, "+prefix+"||'000001') ");
                else
                    sql.append("SELECT NVL(MAX(dco.DCO_NUMERO_COMPR)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
                
                
                sql.append("FROM SII_DOCUMENTO_CONTABLE dco ");
                
                
                if (prefix!=null)
                    sql.append("WHERE dco.DCO_NUMERO_COMPR LIKE ''||"+prefix+"||'%' ");
                else
                    sql.append("WHERE dco.DCO_NUMERO_COMPR LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%' ");
                
                
                sql.append("AND dco.TDC_CODIGO = #tdcCodigo");
                
                Query query = em.createNativeQuery(sql.toString());
                query.setParameter("tdcCodigo", tdcCodigo);
                
                
                BigDecimal resultado = (BigDecimal)query.getSingleResult();
                if(resultado != null){
                    consecutivo = new Integer(resultado.intValueExact());
                }
                
            }
            catch (javax.persistence.NoResultException ne) {
                consecutivo = null;
            }
            catch (PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return consecutivo;
    }
    
    
    
    public List<SiiDocumentoContable> buscarTodoNumerocomprobanteDocCon(String tdcCodigo ) throws ExcepcionDAO {
        List<SiiDocumentoContable> listaSiiDocumentoContable= new ArrayList<SiiDocumentoContable>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT distinct dco_numero_compr FROM sii_documento_contable  ");
            sql.append("WHERE  TDC_CODIGO=#tdcCodigo ");
            sql.append("order by dco_numero_compr desc");
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("tdcCodigo", tdcCodigo);
            List<BigDecimal> results = query.getResultList();
            
            for(BigDecimal object : results){
                SiiDocumentoContable siiDocumentoContable= new SiiDocumentoContable();
                siiDocumentoContable.setDcoNumeroCompr( (int) object.longValue());  
                listaSiiDocumentoContable.add(siiDocumentoContable);
            }

            return listaSiiDocumentoContable;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch(Exception ex){
                ex.printStackTrace();
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"DocumentoContableDAO");
            }
    }
    
    
    
    
    /**
     * Realiza la consulta de todos los Documentos Contables qe se encuentren dentro del rango especificado.
     * @param first - Valor inicial del rango.
     * @param last - Valor filan del rango.
     * @param sortField - Nombre de la columna por medio la cual se realizar&aacute; el ordenamiento.
     * @param sortOrder - Cadena del sentido de ordenamiento (ASC/DESC).
     * @return List of SiiDocumentoContable
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorRangoPaginacion (Integer first, Integer last, String sortField, String sortOrder) throws ExcepcionDAO {
        
        List<SiiDocumentoContable> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DCO_CODIGO, "); 
            sql.append("       DCO_NUMERO_COMPR, "); 
            sql.append("       OBL_CODIGO, ");
            sql.append("       TDC_CODIGO, "); 
            sql.append("       ORP_CODIGO, ");
            sql.append("       DCO_FECHA_OPER, "); 
            sql.append("       DRE_CODIGO, ");
            sql.append("       DCO_CONCEPTO, ");
            sql.append("       DCO_VALOR, ");
            sql.append("       DCO_MOTIVO_ANULA, ");
            sql.append("       EDO_CODIGO, ");
            sql.append("       ICU_CODIGO ");
            sql.append("FROM (");
            sql.append("    SELECT  /*+ FIRST_ROWS(10) */ ");
            sql.append("            ROWNUM AS CONSECUTIVO, dc.* ");
            sql.append("    FROM SII_DOCUMENTO_CONTABLE dc ");
            sql.append("    ORDER BY dc.dco_codigo ");
            sql.append(") Y ");
            sql.append("WHERE Y.CONSECUTIVO BETWEEN #first AND #last ");
            
            
            // ORDENAMIENTO
            if (sortField!=null && !sortField.isEmpty()) {
                
                String columnName = Utilidades.getColumnNameFromProperty(SiiDocumentoContable.class, sortField);
                
                if (columnName!=null) {
                    sql.append("ORDER BY "+columnName+" ");
                    
                    if (sortOrder!=null && !sortOrder.isEmpty()) {
                        sql.append(sortOrder+" ");
                    }
                }
            }
            else {
                // ordenamiento por defecto
                sql.append("ORDER BY DCO_FECHA_OPER DESC ");
            }
            
            
            
            Query query = em.createNativeQuery(sql.toString());
            
            query.setParameter("first", first);
            query.setParameter("last", last);
            
            
            List<Object[]> rows = query.getResultList();
            
            if (rows!=null) {
                
                resultado = new ArrayList<SiiDocumentoContable>();
                
                for (Object[] row: rows) {
                    SiiDocumentoContable siiDocumentoContable = new SiiDocumentoContable();
                    
                    if (row[0]!=null)
                        siiDocumentoContable.setDcoCodigo(((BigDecimal) row[0]).longValue());
                    if (row[1]!=null)
                        siiDocumentoContable.setDcoNumeroCompr(((BigDecimal) row[1]).intValue());
                    
                    if (row[2]!=null) {
                        /*
                        Long oblCodigo = ((BigDecimal) row[2]).longValue();
                        SiiObligacion siiObligacion = new SiiObligacion();
                        siiObligacion.setOblCodigo(oblCodigo);
                        siiDocumentoContable.setSiiObligacion(siiObligacion);
                        */
                    }
                    
                    if (row[3]!=null) {
                        String tdcCodigo = (String) row[3];
                        SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo(tdcCodigo);
                        siiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                        /*
                        SiiTipoDocContable siiTipoDocContable = new SiiTipoDocContable();
                        siiTipoDocContable.setTdcCodigo(tdcCodigo);
                        siiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                        */
                    }
                    
                    if (row[4]!=null) {
                        /*
                        Long orpCodigo = ((BigDecimal) row[4]).longValue();
                        SiiOrdenPago siiOrdenPago = new SiiOrdenPago();
                        siiOrdenPago.setOrpCodigo(orpCodigo);
                        siiDocumentoContable.setSiiOrdenPago(siiOrdenPago);
                        */
                    }
                    
                    if (row[5]!=null)
                        siiDocumentoContable.setDcoFechaOper((Date) row[5]);
                    
                    if (row[6]!=null) {
                        /*
                        Long dreCodigo = ((BigDecimal) row[6]).longValue();
                        SiiDetalleRecaudo siiDetalleRecaudo = new SiiDetalleRecaudo();
                        siiDetalleRecaudo.setDreCodigo(dreCodigo);
                        siiDocumentoContable.setSiiDetalleRecaudo(siiDetalleRecaudo);
                        */
                    }
                    
                    if (row[7]!=null)
                        siiDocumentoContable.setDcoConcepto((String) row[7]);
                    if (row[8]!=null)
                        siiDocumentoContable.setDcoValor((BigDecimal) row[8]);
                    if (row[9]!=null)
                        siiDocumentoContable.setDcoMotivoAnula((String) row[9]);
                    
                    if (row[10]!=null) {
                        Long edoCodigo = ((BigDecimal) row[10]).longValue();
                        SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarPorCodigo(edoCodigo);
                        siiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                        /*
                        SiiEstadoDocContab siiEstadoDocContab = new SiiEstadoDocContab();
                        siiEstadoDocContab.setEdoCodigo(edoCodigo);
                        siiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                        */
                    }
                    
                    if (row[11]!=null) {
                        /*
                        Long icuCodigo = ((BigDecimal) row[11]).longValue();
                        SiiInteresCuota siiInteresCuota = new SiiInteresCuota();
                        siiInteresCuota.setIcuCodigo(icuCodigo);
                        siiDocumentoContable.setSiiInteresCuota(siiInteresCuota);
                        */
                    }
                    
                    
                    
                    resultado.add(siiDocumentoContable);
                }
            }
            
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    
    /**
     * Realiza la consulta de todos los Documentos Contables qe se encuentren dentro del rango especificado.
     * @param filtros - Mapa que contiene el nombre y valor de los filtros que se desean aplicar a la b&uacute;squeda.
     * @param sortField - Nombre de la columna por medio la cual se realizar&aacute; el ordenamiento.
     * @param sortOrder - Cadena del sentido de ordenamiento (ASC/DESC).
     * @return List of SiiDocumentoContable
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorFiltros (Map<String,Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO {
        
        List<SiiDocumentoContable> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DCO_CODIGO, "); 
            sql.append("       DCO_NUMERO_COMPR, "); 
            sql.append("       OBL_CODIGO, ");
            sql.append("       TDC_CODIGO, "); 
            sql.append("       ORP_CODIGO, ");
            sql.append("       DCO_FECHA_OPER, "); 
            sql.append("       DRE_CODIGO, ");
            sql.append("       DCO_CONCEPTO, ");
            sql.append("       DCO_VALOR, ");
            sql.append("       DCO_MOTIVO_ANULA, ");
            sql.append("       EDO_CODIGO, ");
            sql.append("       ICU_CODIGO ");
            sql.append("FROM SII_DOCUMENTO_CONTABLE dc ");
            sql.append("WHERE 1=1 ");
            
            // FILTROS
            if (filtros!=null && !filtros.isEmpty()) {
                Set<String> columnas = filtros.keySet();
                if (columnas!=null) {
                    for (String columna: columnas) {
                        Object valor = filtros.get(columna);
                        
                        if (valor!=null) {
                            // PREVENCION DE SQL INJECTION
                            String strValor = Utilidades.filtrarInyeccionSQL(valor.toString());
                            
                            
                            String columnName = Utilidades.getColumnNameFromProperty(SiiDocumentoContable.class, columna);
                            if (columnName!=null && strValor!=null) {
                                sql.append("AND  UPPER("+columnName+")  LIKE UPPER('%"+strValor+"%') ");
                            }
                        }
                    }
                }
            }
            
            // ORDENAMIENTO
            if (sortField!=null && !sortField.isEmpty()) {
                
                String columnName = Utilidades.getColumnNameFromProperty(SiiDocumentoContable.class, sortField);
                
                if (columnName!=null) {
                    sql.append("ORDER BY "+columnName+" ");
                    
                    if (sortOrder!=null && !sortOrder.isEmpty()) {
                        sql.append(sortOrder+" ");
                    }
                }
            }
            else {
                // ordenamiento por defecto
                sql.append("ORDER BY DCO_FECHA_OPER DESC ");
            }
            
            
            Query query = em.createNativeQuery(sql.toString());
            
            
            List<Object[]> rows = query.getResultList();
            
            if (rows!=null) {
                
                resultado = new ArrayList<SiiDocumentoContable>();
                
                for (Object[] row: rows) {
                    SiiDocumentoContable siiDocumentoContable = new SiiDocumentoContable();
                    
                    if (row[0]!=null)
                        siiDocumentoContable.setDcoCodigo(((BigDecimal) row[0]).longValue());
                    if (row[1]!=null)
                        siiDocumentoContable.setDcoNumeroCompr(((BigDecimal) row[1]).intValue());
                    
                    if (row[2]!=null) {
                        /*
                        Long oblCodigo = ((BigDecimal) row[2]).longValue();
                        SiiObligacion siiObligacion = new SiiObligacion();
                        siiObligacion.setOblCodigo(oblCodigo);
                        siiDocumentoContable.setSiiObligacion(siiObligacion);
                        */
                    }
                    
                    if (row[3]!=null) {
                        String tdcCodigo = (String) row[3];
                        SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo(tdcCodigo);
                        siiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                        /*
                        SiiTipoDocContable siiTipoDocContable = new SiiTipoDocContable();
                        siiTipoDocContable.setTdcCodigo(tdcCodigo);
                        siiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                        */
                    }
                    
                    if (row[4]!=null) {
                        /*
                        Long orpCodigo = ((BigDecimal) row[4]).longValue();
                        SiiOrdenPago siiOrdenPago = new SiiOrdenPago();
                        siiOrdenPago.setOrpCodigo(orpCodigo);
                        siiDocumentoContable.setSiiOrdenPago(siiOrdenPago);
                        */
                    }
                    
                    if (row[5]!=null)
                        siiDocumentoContable.setDcoFechaOper((Date) row[5]);
                    
                    if (row[6]!=null) {
                        /*
                        Long dreCodigo = ((BigDecimal) row[6]).longValue();
                        SiiDetalleRecaudo siiDetalleRecaudo = new SiiDetalleRecaudo();
                        siiDetalleRecaudo.setDreCodigo(dreCodigo);
                        siiDocumentoContable.setSiiDetalleRecaudo(siiDetalleRecaudo);
                        */
                    }
                    
                    if (row[7]!=null)
                        siiDocumentoContable.setDcoConcepto((String) row[7]);
                    if (row[8]!=null)
                        siiDocumentoContable.setDcoValor((BigDecimal) row[8]);
                    if (row[9]!=null)
                        siiDocumentoContable.setDcoMotivoAnula((String) row[9]);
                    
                    if (row[10]!=null) {
                        Long edoCodigo = ((BigDecimal) row[10]).longValue();
                        SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarPorCodigo(edoCodigo);
                        siiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                        /*
                        SiiEstadoDocContab siiEstadoDocContab = new SiiEstadoDocContab();
                        siiEstadoDocContab.setEdoCodigo(edoCodigo);
                        siiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                        */
                    }
                    
                    if (row[11]!=null) {
                        /*
                        Long icuCodigo = ((BigDecimal) row[11]).longValue();
                        SiiInteresCuota siiInteresCuota = new SiiInteresCuota();
                        siiInteresCuota.setIcuCodigo(icuCodigo);
                        siiDocumentoContable.setSiiInteresCuota(siiInteresCuota);
                        */
                    }
                    
                    
                    
                    resultado.add(siiDocumentoContable);
                }
            }
            
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /** 
     * Obtiene la cantidad de registros de la tabla.
     * @throws ExcepcionDAO
     */
    public Integer obtenerRowCount () throws ExcepcionDAO {
        Integer resultado = null;
        
        try {
            
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT COUNT(1) FROM SII_DOCUMENTO_CONTABLE dc ");
            
            Query query = em.createNativeQuery(sql.toString());
            
            Object result = query.getSingleResult();
            
            if (result!=null) 
                resultado = ((BigDecimal) result).intValue();
            else
                resultado = new Integer(0);
            
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    public SiiDocumentoContable insertarDocumentoContable(SiiDocumentoContable siiDocumentoContable)throws ExcepcionDAO {
        try {
            em.persist(siiDocumentoContable);
            em.flush();
            return siiDocumentoContable;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la validaci&oacute;n para determinar si el mes registrado en la Fecha de la Operaci&oacute;n ha sido CERRADO.
     * @param siiDocumentoContable - Documento Contable.
     * @return ¿Mes Cerrado?
     * @throws ExcepcionDAO
     */
    public boolean isMesCerrado (SiiDocumentoContable siiDocumentoContable) throws ExcepcionDAO {
        boolean cerrado = false;
        
        if (siiDocumentoContable!=null && siiDocumentoContable.getDcoFechaOper()!=null) {
            try {
                Date fechaOperacion = siiDocumentoContable.getDcoFechaOper();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaOperacion);
                Integer mes = calendar.get(Calendar.MONTH) + 1;
                Integer vigencia = calendar.get(Calendar.YEAR);
                
                if (mes!=null && vigencia!=null) {
                    StringBuilder sql = new StringBuilder();
                    sql.append("SELECT COUNT(*) FROM SII_CIERRE_CONTABLE ");
                    sql.append("WHERE mes_codigo = #mes ");
                    sql.append("AND cic_vigencia = #vigencia ");
                    sql.append("AND CIC_FECHA_C_CONT IS NOT NULL ");
                    
                    Query query = em.createNativeQuery(sql.toString());
                    query.setParameter("mes", mes);
                    query.setParameter("vigencia", vigencia);
                    
                    BigDecimal result = (BigDecimal) query.getSingleResult();
                    cerrado = result!=null && result.compareTo(new BigDecimal(0)) > 0;
                }
            }
            catch (NoResultException e) {
                cerrado = false;
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (cerrado);
    }
    
    
    
    /**
     * Realiza la consulta del listado de N&uacute;meros de Comprobante Contable.
     * @return List of Integer
     * @throws ExcepcionDAO
     */
    public List<Integer> buscarTodoNumeroComprobante () throws ExcepcionDAO {
        List<Integer> resultado = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT distinct dco_numero_compr FROM sii_documento_contable ");
            sql.append("ORDER BY dco_numero_compr DESC ");
            Query query = em.createNativeQuery(sql.toString());
            
            List<BigDecimal> results = query.getResultList();
            
            if (results!=null) {
                resultado = new ArrayList<Integer>();
                
                for(BigDecimal numComprobante : results){
                    if (numComprobante!=null) {
                        resultado.add(numComprobante.intValue());  
                    }
                }
            }

            return (resultado);
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    /**
     * Realiza la consulta del listado de N&uacute;meros de Comprobante Contable asociados al Tipo de Documento Contable especificado.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return List of Integer
     * @throws ExcepcionDAO
     */
    public List<Integer> buscarNumerosComprobantePorTipoDocumento (String tdcCodigo) throws ExcepcionDAO {
        List<Integer> resultado = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT distinct dco_numero_compr FROM sii_documento_contable ");
            sql.append("WHERE  TDC_CODIGO = #tdcCodigo ");
            sql.append("ORDER BY dco_numero_compr DESC ");
            
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("tdcCodigo", tdcCodigo);
            
            List<BigDecimal> results = query.getResultList();
            
            if (results!=null) {
                resultado = new ArrayList<Integer>();
                
                for(BigDecimal numComprobante : results){
                    if (numComprobante!=null) {
                        resultado.add(numComprobante.intValue());  
                    }
                }
            }

            return (resultado);
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    /**
     * Obtiene el Documento Contable asociado al Tipo y N&uacute;mero de Comprobante Contable.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @param dcoNumeroCompr - N&uacute;mero de Comprobante.
     * @return instance of SiiDocumentoContable
     * @throws ExcepcionDAO
     */
    public SiiDocumentoContable buscarPorTipoYNumeroComprobante (String tdcCodigo, Integer dcoNumeroCompr) throws ExcepcionDAO
    {
        SiiDocumentoContable resultado = null;
        
        if (tdcCodigo!=null && dcoNumeroCompr!=null) {
            
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dco FROM SiiDocumentoContable dco ");
                sql.append("WHERE dco.siiTipoDocContable.tdcCodigo = :tdcCodigo ");
                sql.append("AND dco.dcoNumeroCompr = :dcoNumeroCompr ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("tdcCodigo", tdcCodigo);
                query.setParameter("dcoNumeroCompr", dcoNumeroCompr);
                
                resultado = (SiiDocumentoContable) query.getSingleResult();
                
            }
            catch (javax.persistence.NoResultException e) {
                resultado = null;
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la consulta de los Documentos Contables asociados a una Orden de Pago, que correspondan al Tipo de Comprobante especificado.
     * @param orpCodigo - C&oacute;digo de la Orden de Pago.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return listado de SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorOrdenPagoTipoDocContab (Long orpCodigo, String tdcCodigo) 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dc FROM SiiDocumentoContable dc, ");
            sql.append("               SiiOrdenPago op ");
            sql.append("WHERE op.orpCodigo = dc.siiOrdenPago.orpCodigo ");
            sql.append("AND op.orpCodigo = :orpCodigo ");
            sql.append("AND dc.siiTipoDocContable.tdcCodigo = :tdcCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("orpCodigo", orpCodigo);
            query.setParameter("tdcCodigo", tdcCodigo);
            
            List<SiiDocumentoContable> listaDC = query.getResultList();
            return listaDC;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la consulta de los Documentos Contables asociados a un Cierre Anual Contable.
     * @param cacCodigo - C&oacute;digo del Cierre Anual Contable.
     * @return listado de SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorCodigoCierreAnualContable (Long cacCodigo) 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dc FROM SiiDocumentoContable dc, ");
            sql.append("               SiiCierreAnualContable cac ");
            sql.append("WHERE cac.cacCodigo = dc.siiCierreAnualContable.cacCodigo ");
            sql.append("AND cac.cacCodigo = :cacCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("cacCodigo", cacCodigo);
            
            List<SiiDocumentoContable> listaDC = query.getResultList();
            return listaDC;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la consulta de los Documentos Contables asociados a un registro de Cargue de Documentos Contables.
     * @param cdcCodigo - C&oacute;digo del registro de Cargue de Documentos Contables.
     * @return listado de SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorCodigoCargaDocumentoCont (Long cdcCodigo) 
        throws ExcepcionDAO 
    {
        List<SiiDocumentoContable> resultado = null;
        
        try {
            
            if (cdcCodigo!=null) {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dc FROM SiiDocumentoContable dc ");
                sql.append("INNER JOIN SiiCargaDocumentoCont cdc  ON  cdc.cdcCodigo = dc.siiCargaDocumentoCont.cdcCodigo ");
                sql.append("WHERE cdc.cdcCodigo = :cdcCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("cdcCodigo", cdcCodigo);
                
                resultado = query.getResultList();
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    public SiiDocumentoContable buscarDocumentoContableXIDdetalleRecaudo (Long dreCodigo)  throws ExcepcionDAO  {
    
        SiiDocumentoContable siiDocumentoContable= new SiiDocumentoContable();
        List<SiiDocumentoContable> listaSiiDocumentoContable = null;
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dc FROM SiiDocumentoContable dc ");
            sql.append("INNER JOIN  SiiDetalleRecaudo dt on dt.dreCodigo = dc.siiDetalleRecaudo.dreCodigo ");
            sql.append("WHERE dt.dreCodigo = :dreCodigo ORDER BY dc.dcoCodigo DESC ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("dreCodigo", dreCodigo) ;   
          
            
            listaSiiDocumentoContable = query.getResultList();
            if (listaSiiDocumentoContable.size() > 0) {
                siiDocumentoContable = listaSiiDocumentoContable.get(0);
            }
            
            
            return siiDocumentoContable;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
  
    
    /**
     * Obtiene el listado de Documentos Contables asociados a la Nota de Cr&eacute;dito especificada.
     * @param ncrCodigo - C&oacute;digo de la Nota de Cr&eacute;dito.
     * @return List of SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorCodigoNotaCredito (Long ncrCodigo) throws ExcepcionDAO 
    {
        List<SiiDocumentoContable> resultado = null;
        
        if (ncrCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dc FROM SiiDocumentoContable dc ");
                sql.append("WHERE dc.siiNotaCredito.ncrCodigo = :ncrCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("ncrCodigo", ncrCodigo) ;   
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    public List<SiiDocumentoContable> buscarPorCodigoReintegroPag (Long ripCodigo) throws ExcepcionDAO 
    {
        List<SiiDocumentoContable> resultado = null;
        
        if (ripCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dc FROM SiiDocumentoContable dc ");
                sql.append("WHERE dc.siiReintegroIngresoPag.ripCodigo = :ripCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("ripCodigo", ripCodigo) ;   
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    
    
    /**
     * Realiza la b&uacute;squeda de los Documentos Contables asociados a la Liquidaci&oacute;n Mes especificada.
     * @param lmeCodigo - C&oacute;digo de la Liquidaci&oacute;n Mes.
     * @return Listado de SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorIdLiquidacionMes (Long lmeCodigo) throws ExcepcionDAO 
    {
        return ( this.buscarPorIdLiquidacionMes(lmeCodigo, null) );
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los Documentos Contables asociados a la Liquidaci&oacute;n Mes y Tipo de Documento Contable especificados.
     * @param lmeCodigo - C&oacute;digo de la Liquidaci&oacute;n Mes.
     * @param tdcCodigo - Tipo de Documento Contable <i>(OPCIONAL)</i>.
     * @return Listado de SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorIdLiquidacionMes (Long lmeCodigo, String tdcCodigo) throws ExcepcionDAO 
    {
        List<SiiDocumentoContable> resultado = null;
        
        if (lmeCodigo!=null) {
            try {
                // buscar el registro de liquidacion mes asociado al codigo suministrado
                SiiLiquidacionMes siiLiquidacionMes = liquidacionMesDao.buscarLiquidacionMesPorId(lmeCodigo);
                
                if (siiLiquidacionMes!=null && siiLiquidacionMes.getLiqConcepto()!=null) {
                    String conceptoLiquidacion = siiLiquidacionMes.getLiqConcepto();
                    
                    if (EnumConceptoLiquidacion.DERECHOS_DE_EXPLOTACION.getId().equals(conceptoLiquidacion) || 
                        EnumConceptoLiquidacion.GASTOS_DE_ADMINISTRACION.getId().equals(conceptoLiquidacion)) 
                    {
                        // buscar el listado de documentos contables, de acuerdo al concepto de la liquidacion mes especificada.
                        StringBuilder sql = new StringBuilder();
                        sql.append("SELECT dco FROM SiiDocumentoContable dco ");
                        
                        if (EnumConceptoLiquidacion.DERECHOS_DE_EXPLOTACION.getId().equals(conceptoLiquidacion))
                            sql.append("WHERE dco.siiLiquidacionMesDE.lmeCodigo = :lmeCodigo ");
                        else if (EnumConceptoLiquidacion.GASTOS_DE_ADMINISTRACION.getId().equals(conceptoLiquidacion))
                            sql.append("WHERE dco.siiLiquidacionMesGA.lmeCodigo = :lmeCodigo ");
                        
                        if (tdcCodigo!=null)
                            sql.append("AND dco.siiTipoDocContable.tdcCodigo = :tdcCodigo ");
                        
                        
                        Query query = em.createQuery(sql.toString());
                        query.setParameter("lmeCodigo", lmeCodigo);
                        
                        if (tdcCodigo!=null)
                            query.setParameter("tdcCodigo", tdcCodigo);
                        
                        
                        resultado = query.getResultList();
                    }
                }
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Obtiene el listado de Documentos Contables asociados al Proceso de Incumplimiento Contractual especificado.
     * @param icnCodigo - C&oacute;digo del Proceso de Incumplimiento Contractual.
     * @return List of SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorIdIncumplimientoContr (Long icnCodigo) throws ExcepcionDAO 
    {
        List<SiiDocumentoContable> resultado = null;
        
        if (icnCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dc FROM SiiDocumentoContable dc ");
                sql.append("WHERE dc.siiIncumplimientoContr.icnCodigo = :icnCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("icnCodigo", icnCodigo) ;   
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    /**
     * Obtiene el listado de Documentos Contables asociados al Proceso Sancionatorio de Fiscalizaci&oacute;n especificado.
     * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @return List of SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoContable> buscarPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO 
    {
        List<SiiDocumentoContable> resultado = null;
        
        if (psaCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dc FROM SiiDocumentoContable dc ");
                sql.append("WHERE dc.siiProcesoSancionatorio.psaCodigo = :psaCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("psaCodigo", psaCodigo) ;   
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    /**
     * Obtiene el listado de Documentos Contables por estado.
     * @param pEstado - estado del documento
     * @return List of SiiDocumentoContable.
     * @throws ExcepcionDAO
     */
    public List<CambioEstDocContableVO> buscarTodoDocConPorEstado(Long pEstado ) throws ExcepcionDAO {
        List<CambioEstDocContableVO> resultado = new ArrayList<CambioEstDocContableVO>();        
        CambioEstDocContableVO cambioEstDocContableVo = null;
        
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select dc.tdc_codigo, dc.dco_numero_compr, dc.dco_fecha_oper, es.edo_nombre, dc.dco_codigo ");
            sql.append("from sii_documento_contable dc ");
            sql.append("inner join sii_estado_doc_contab es on (es.edo_codigo = dc.edo_codigo) ");
            sql.append("where es.edo_codigo <> #pEstado "); 
            
            Query query = em.createNativeQuery(sql.toString());
            
            query.setParameter("pEstado", pEstado) ;   
            
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {            
                cambioEstDocContableVo = new CambioEstDocContableVO();
                cambioEstDocContableVo.setDcoCodigo(((BigDecimal) object[4]).longValue());   
                cambioEstDocContableVo.setDcoNumeroCompr(((BigDecimal) object[1]).intValue());
                cambioEstDocContableVo.setDcoFechaOper((Date) object[2]);
                cambioEstDocContableVo.setEstadoDocContabVo((String) object[3]);
                cambioEstDocContableVo.setTipoDocContableVo((String) object[0]);
                    
                resultado.add(cambioEstDocContableVo); 
                }       
            }
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
       
        
        return (resultado);
    }
    
    public List<SiiDocumentoContable> buscarTodoDocConPorEstadoTipo(Long pEstado,String  tdcCodigo ) throws ExcepcionDAO {
        List<SiiDocumentoContable> resultado = null;        
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dc FROM SiiDocumentoContable dc ");
            sql.append("INNER JOIN dc.siiEstadoDocContab es ");
            sql.append("WHERE es.edoCodigo = :pEstado and  dc.siiTipoDocContable.tdcCodigo =:tdcCodigo  ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("pEstado", pEstado) ;   
            query.setParameter("tdcCodigo", tdcCodigo) ;   
            resultado = query.getResultList();
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
       
        
        return (resultado);
    }
    
}
