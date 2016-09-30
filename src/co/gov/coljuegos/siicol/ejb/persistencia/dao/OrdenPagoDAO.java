package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocContable;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenPago;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.util.Utilidades;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class OrdenPagoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public OrdenPagoDAO() {
        super();
        
        this.recursos = new Recursos();
    }
    
    
    
    
    /**
     * Obtiene el listado de Tipos de Documento Contable asociados a las &Oacute;rdenes de Pago que manejan consecutivo &uacute;nico (basados en el TDC_CODIGO).
     * @return List of String
     */
    private List<String> getListaTiposDocumentoConsecutivoUnico () 
    {
        List<String> resultado = new ArrayList<String>();
        resultado.add(EnumTipoDocContable.PAGO_ENTES_TERRITORIALES.getId());
        
        return (resultado);
    }
    
    
    public SiiOrdenPago buscarPorCodigoOrdenPago(Long idCodigoOrden) throws ExcepcionDAO {
        SiiOrdenPago retorno = null;
        try {
            retorno = manager.find(SiiOrdenPago.class, idCodigoOrden);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }
        return retorno;

    }
    
    public SiiOrdenPago insertarSiiOrdenPago(SiiOrdenPago orden) throws ExcepcionDAO {
        try {
            manager.persist(orden); 
            manager.flush(); 
            return orden; 

        } catch (PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }
    }
    
    public SiiOrdenPago actualizarSiiOrdenPago(SiiOrdenPago orden) throws ExcepcionDAO {
        try {
            manager.merge(orden); 
            manager.flush(); 
            return orden; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }
    }
    public void borrarOrden(Long idCodigoOrden) throws ExcepcionDAO {
        SiiOrdenPago ordenBorrar = null;
        try {
            ordenBorrar = manager.find(SiiOrdenPago.class, idCodigoOrden);
            manager.remove(ordenBorrar);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }
    }
    
    
    public List<SiiOrdenPago> buscarTodoSiiOrdenPago() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOrdenPago o");
            sql.append(" order by o.orpConsecutivo desc");
            Query query = manager.createQuery(sql.toString());
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }

    }
    
    public List<SiiOrdenPago> buscarTodasOrdenPagoCuentasXPagar() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOrdenPago o WHERE  o.siiObligacion.oblNumero like '13%' order by o.orpConsecutivo desc ");
            Query query = manager.createQuery(sql.toString());
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }

    }
    
    
    public List<SiiOrdenPago> buscarTodoSiiOrdenPagoCuentasXPagar() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOrdenPago o WHERE o.siiEstadoOrdenPago.eopCodigo=2 AND o.siiObligacion.oblNumero like '13%'");
            Query query = manager.createQuery(sql.toString());
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }

    }
    
    public List<SiiOrdenPago> buscarTodoSiiOrdenPagoAprobadas() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiOrdenPago o " +
                " inner join SiiObligacion obl on obl.oblCodigo = o.siiObligacion.oblCodigo" +
                " inner join SiiSolicitudPago spa on spa.spaCodigo = o.siiObligacion.siiSolicitudPago.spaCodigo" +
                " inner join SiiRp rp on rp.rpCodigo = o.siiObligacion.siiSolicitudPago.siiRp.rpCodigo");
            sql.append(" order by o.orpConsecutivo desc ");
            //sql.append(" WHERE o.siiEstadoOrdenPago.eopCodigo=2 ");
            Query query = manager.createQuery(sql.toString());
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }

    }
    
    public List<SiiOrdenPago> buscarTodoSiiOrdenPagoCuentarPagar() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
          
           sql.append(" SELECT o FROM SiiOrdenPago o ");
            sql.append(" inner join  o.siiObligacion ob ");
            
           // sql.append(" left join  ob.siiSolicitudPago s ");
            //sql.append(" left join  s.siiRp rp ");
            sql.append(" WHERE ob.oblNumero like '1300%' ");
            sql.append(" order by o.orpConsecutivo desc ");
            Query query = manager.createQuery(sql.toString());
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }

    }
    
    
    
    /**
     * Obtiene el Consecutivo de la Orden de Pago.
     * @return Siguiente n&uacute;mero de la Orden de Pago.
     * @throws ExcepcionDAO
     */
    public Integer getConsecutivo() throws ExcepcionDAO {
        return ( this.getConsecutivo(null) );
    }
    
    
    
    /**
     * Obtiene el Consecutivo de la Orden de Pago asociado al Tipo de Documento Contable especificado.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return Siguiente n&uacute;mero de la Orden de Pago.
     * @throws ExcepcionDAO
     */
    public Integer getConsecutivo (String tdcCodigo) throws ExcepcionDAO {
        
        Integer consecutivo = 0;
        try{
            StringBuilder sql = new StringBuilder();
            
            ////////////////////////////////////////////////////////
            // Listado de tipos de Documentos contables excluidos //
            ////////////////////////////////////////////////////////
            List<String> listaTDCExcluidos = this.getListaTiposDocumentoConsecutivoUnico();
            
            
            sql.append("SELECT NVL(MAX(O.ORP_CONSECUTIVO)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
            sql.append("FROM SII_ORDEN_PAGO O  ");
            sql.append("WHERE O.ORP_CONSECUTIVO LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%' ");
            
            if (tdcCodigo!=null)
                sql.append("AND O.TDC_CODIGO = #tdcCodigo  ");
            else {
                if (!listaTDCExcluidos.isEmpty()) {
                    sql.append("AND O.TDC_CODIGO NOT IN ");
                    
                    sql.append(" (");
                    Iterator<String> it = listaTDCExcluidos.iterator();
                    while (it.hasNext()) {
                        String tdcCodigoExcluido = it.next();
                        sql.append("'"+tdcCodigoExcluido+"'");
                        
                        if (it.hasNext())
                            sql.append(", ");
                    }
                    sql.append(") ");
                }
            }
            
            Query query = manager.createNativeQuery(sql.toString());
            
            
            if (tdcCodigo!=null) 
                query.setParameter("tdcCodigo", tdcCodigo);
            
            
            if(query.getSingleResult() != null){
                consecutivo = ((BigDecimal)query.getSingleResult()).intValueExact();
            }
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
    
    

    public SiiOrdenPago buscarOrdenPagoPorCodigo(long codOrdenPagoVO) throws ExcepcionDAO {
        SiiOrdenPago retornoOrden = null;
        try {
            retornoOrden = manager.find(SiiOrdenPago.class, codOrdenPagoVO);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OperadorDAO");
        }
        return retornoOrden;
    }

    public List<SiiOrdenPago> buscarRangoOrdenPagoPorCodigo(Integer inicio, Integer fin) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOrdenPago o WHERE o.orpConsecutivo BETWEEN :inicio AND :fin and (o.siiTipoDocContable.tdcCodigo='PPR' or o.siiTipoDocContable.tdcCodigo='TPE')  ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("inicio", inicio);
            query.setParameter("fin", fin);
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Ordenes de Pago que se encuentren asociadas a la Obligaci&oacute;n especificada.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenPago> buscarOrdenPagoPorObligacion (Long oblCodigo) throws ExcepcionDAO {
        return (this.buscarOrdenPagoPorObligacionFFC(oblCodigo, null));
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Ordenes de Pago que se encuentren asociadas a la Obligaci&oacute;n y Tipo de Gasto especificados.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @param orpTipoGasto - Tipo de Gasto de la Orden de Pago.
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenPago> buscarOrdenPagoPorObligacionTipoGasto (Long oblCodigo, String orpTipoGasto) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOrdenPago o ");
            sql.append("INNER JOIN SiiObligacion obl  ON  obl.oblCodigo = o.siiObligacion.oblCodigo ");
            sql.append("WHERE  o.siiObligacion.oblCodigo = :oblCodigo ");
            
            if (orpTipoGasto!=null)
                sql.append("AND    o.orpTipoGasto = :orpTipoGasto ");
            
            sql.append("ORDER BY o.orpConsecutivo desc ");
            
            Query query = manager.createQuery(sql.toString());
            
            query.setParameter("oblCodigo", oblCodigo);
            
            if (orpTipoGasto!=null)
                query.setParameter("orpTipoGasto", orpTipoGasto);
            
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Ordenes de Pago que se encuentren asociadas a la Obligaci&oacute;n y Fuente de Financiaci&oacute;n Contable especificadas.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @param ffcCodigo - Fuente de Financiaci&oacute;n Contable de la Orden de Pago.
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenPago> buscarOrdenPagoPorObligacionFFC (Long oblCodigo, String ffcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOrdenPago o ");
            sql.append("INNER JOIN SiiObligacion obl  ON  obl.oblCodigo = o.siiObligacion.oblCodigo ");
            sql.append("WHERE  o.siiObligacion.oblCodigo = :oblCodigo ");
            
            if (ffcCodigo!=null)
                sql.append("AND    o.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
            
            sql.append("ORDER BY o.orpConsecutivo desc ");
            
            Query query = manager.createQuery(sql.toString());
            
            query.setParameter("oblCodigo", oblCodigo);
            
            if (ffcCodigo!=null)
                query.setParameter("ffcCodigo", ffcCodigo);
            
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Ordenes de Pago NO presupuestales.    
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    
    public List<SiiOrdenPago> buscarTodoSiiOrdenPagoNoPresupuestal() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiOrdenPago o " );
            sql.append(" where o.siiObligacionNoPresup is not null order by o.orpConsecutivo desc");           
            Query query = manager.createQuery(sql.toString());
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenPagoDAO");
        }

    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de Ordenes de Pago por Estado.    
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    
    public List<SiiOrdenPago> buscarOrdenPagoPorEstado (Long eopCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOrdenPago o " );
            sql.append("where o.siiEstadoOrdenPago.eopCodigo = :eopCodigo ");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("eopCodigo", eopCodigo);
            
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de Ordenes de Pago por Tipo de Orden de Pago (Tipo de Documento Contable).
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenPago> buscarOrdenPagoPorTipoDocContable (String tdcCodigo) throws ExcepcionDAO {
        return ( this.buscarOrdenPagoPorTipoDocContableYEstado(tdcCodigo, null) );
    }
    
    
    /**
     * Realiza la b&uacute;squeda de Ordenes de Pago por Tipo de Orden de Pago (Tipo de Documento Contable) y Estado de la Orden de Pago.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @param eopCodigo - Estado de la Orden de Pago.
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenPago> buscarOrdenPagoPorTipoDocContableYEstado (String tdcCodigo, Long eopCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT op FROM SiiOrdenPago op " );
            sql.append("WHERE op.siiTipoDocContable.tdcCodigo = :tdcCodigo ");
            
            if (eopCodigo!=null) {
                sql.append("AND op.siiEstadoOrdenPago.eopCodigo = :eopCodigo ");
            }
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tdcCodigo", tdcCodigo);
            
            if (eopCodigo!=null)
                query.setParameter("eopCodigo", eopCodigo);
            
            
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de Ordenes de Pago por Tipo de Documento Contable de la Obligaci&oacute;n asociada.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenPago> buscarOrdenPagoPorTipoDocContableObligacion (String tdcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT op FROM SiiOrdenPago op " );
            sql.append("INNER JOIN SiiObligacion obl  ON  obl.oblCodigo = op.siiObligacion.oblCodigo ");
            sql.append("where obl.siiTipoDocContable.tdcCodigo = :tdcCodigo ");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tdcCodigo", tdcCodigo);
            
            List<SiiOrdenPago> listaOrdenes = query.getResultList();
            return listaOrdenes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de Ordenes de Pago por Consecutivo y Tipo de Documento Contable.    
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    
    public SiiOrdenPago buscarOrdenPagoPorConsecutivoYTipoDocContable (Integer orpConsecutivo, String tdcCodigo) throws ExcepcionDAO {
        SiiOrdenPago siiOrdenPago = null;
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT op FROM SiiOrdenPago op " );
            sql.append("WHERE op.orpConsecutivo = :orpConsecutivo ");
            sql.append("AND op.siiTipoDocContable.tdcCodigo = :tdcCodigo ");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("orpConsecutivo", orpConsecutivo);
            query.setParameter("tdcCodigo", tdcCodigo);
            
            siiOrdenPago = (SiiOrdenPago) query.getSingleResult();
           

        }
        catch (javax.persistence.NoResultException ne) {
            siiOrdenPago = null;
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return siiOrdenPago;
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////
    // INICIO METODOS USADOS PARA PAGINACION EN LAZY DATA MODELS. //
    ////////////////////////////////////////////////////////////////
    
    /**
     * Realiza la b&uacute;squeda de Ordenes de Pago por Rango de Paginaci&oacute;n (Para Lazy Data Models).
     * @param first - Valor inicial del rango.
     * @param last - Valor filan del rango.
     * @param sortField - Nombre de la columna por medio la cual se realizar&aacute; el ordenamiento.
     * @param sortOrder - Cadena del sentido de ordenamiento (ASC/DESC).
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenPago> buscarOrdenPagoPorRangoPaginacion (Integer first, Integer last, String sortField, String sortOrder) throws ExcepcionDAO 
    {
        return ( this.buscarOrdenPagoPorRangoPaginacion(null, first, last, sortField, sortOrder) );
    }
    
    
    /**
     * Realiza la b&uacute;squeda de Ordenes de Pago por Tipo de Orden de Pago (Tipo de Documento Contable) y Rango de Paginaci&oacute;n (Para Lazy Data Models).
     * @param tdcCodigo - Tipo de Documento Contable.
     * @param first - Valor inicial del rango.
     * @param last - Valor filan del rango.
     * @param sortField - Nombre de la columna por medio la cual se realizar&aacute; el ordenamiento.
     * @param sortOrder - Cadena del sentido de ordenamiento (ASC/DESC).
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenPago> buscarOrdenPagoPorRangoPaginacion (String tdcCodigo, Integer first, Integer last, String sortField, String sortOrder) throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ORP_CODIGO, ");
            sql.append("       EOP_CODIGO, ");
            sql.append("       OBL_CODIGO, ");
            sql.append("       ORP_FECHA, ");
            sql.append("       ORP_PAG_DEST_FINAL, "); 
            sql.append("       CBA_CODIGO, ");
            sql.append("       ORP_MOTIVO_ANULA, ");
            sql.append("       USU_CODIGO_REGISTRA, ");
            sql.append("       USU_CODIGO_APRUEBA, ");
            sql.append("       ORP_NUMERO_RP, ");
            sql.append("       PRO_CODIGO, ");
            sql.append("       ORP_TIPO_GASTO, ");
            sql.append("       ORP_VALOR_GASTO, ");
            sql.append("       TSP_CODIGO, ");
            sql.append("       ORP_NUM_DOC_SOP, "); 
            sql.append("       ONP_CODIGO, ");
            sql.append("       ORP_CONSECUTIVO, ");
            sql.append("       TDC_CODIGO, ");
            sql.append("       FFC_CODIGO, "); 
            sql.append("       PER_CODIGO_ENDOSO ");
            sql.append("FROM (");
            sql.append("    SELECT  /*+ FIRST_ROWS(20) */ ");
            sql.append("            ROWNUM AS CONSECUTIVO, orp.* ");
            sql.append("    FROM SII_ORDEN_PAGO orp ");
            
            if (tdcCodigo!=null)
                sql.append("    WHERE orp.TDC_CODIGO = #tdcCodigo ");
            
            sql.append("    ORDER BY orp.ORP_CODIGO DESC ");
            sql.append(") Y ");
            sql.append("WHERE Y.CONSECUTIVO BETWEEN #first AND #last ");
            
            
            // ORDENAMIENTO
            if (sortField!=null && !sortField.isEmpty()) {
                
                String columnName = Utilidades.getColumnNameFromProperty(SiiOrdenPago.class, sortField);
                
                if (columnName!=null) {
                    sql.append("ORDER BY "+columnName+" ");
                    
                    if (sortOrder!=null && !sortOrder.isEmpty()) {
                        sql.append(sortOrder+" ");
                    }
                }
            }
            else {
                // ordenamiento por defecto
                sql.append("ORDER BY ORP_CONSECUTIVO DESC ");
            }
            
            
            Query query = manager.createNativeQuery(sql.toString());
            
            if (tdcCodigo!=null)
                query.setParameter("tdcCodigo", tdcCodigo);
            
            query.setParameter("first", first);
            query.setParameter("last", last);
            
            
            
            List<SiiOrdenPago> listaOrdenes = null;
            List<Object[]> rows = query.getResultList();
            
            if (rows!=null) {
                
                listaOrdenes = new ArrayList<SiiOrdenPago>();
                
                for (Object[] row: rows) {
                    if (row[0]!=null) {
                        Long orpCodigo = ((BigDecimal) row[0]).longValue();
                        if (orpCodigo!=null) {
                            SiiOrdenPago siiOrdenPago = this.buscarOrdenPagoPorCodigo(orpCodigo);
                            if (siiOrdenPago!=null)
                                listaOrdenes.add(siiOrdenPago);
                        }
                    }
                }
                
            }
            
            
            return listaOrdenes;

        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la consulta de todos los Documentos Contables que se encuentren dentro del rango especificado.
     * @param filtros - Mapa que contiene el nombre y valor de los filtros que se desean aplicar a la b&uacute;squeda.
     * @param sortField - Nombre de la columna por medio la cual se realizar&aacute; el ordenamiento.
     * @param sortOrder - Cadena del sentido de ordenamiento (ASC/DESC).
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenPago> buscarPorFiltros (Map<String,Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO 
    {
        return ( this.buscarPorFiltros(null, filtros, sortField, sortOrder) );
    }
    
    
    
    /**
     * Realiza la consulta de los Documentos Contables del Tipo de Documento Contable y Rango especificados.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @param filtros - Mapa que contiene el nombre y valor de los filtros que se desean aplicar a la b&uacute;squeda.
     * @param sortField - Nombre de la columna por medio la cual se realizar&aacute; el ordenamiento.
     * @param sortOrder - Cadena del sentido de ordenamiento (ASC/DESC).
     * @return List of SiiOrdenPago
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenPago> buscarPorFiltros (String tdcCodigo, Map<String,Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO 
    {
        List<SiiOrdenPago> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ORP_CODIGO, ");
            sql.append("       EOP_CODIGO, ");
            sql.append("       OBL_CODIGO, ");
            sql.append("       ORP_FECHA, ");
            sql.append("       ORP_PAG_DEST_FINAL, "); 
            sql.append("       CBA_CODIGO, ");
            sql.append("       ORP_MOTIVO_ANULA, ");
            sql.append("       USU_CODIGO_REGISTRA, ");
            sql.append("       USU_CODIGO_APRUEBA, ");
            sql.append("       ORP_NUMERO_RP, ");
            sql.append("       PRO_CODIGO, ");
            sql.append("       ORP_TIPO_GASTO, ");
            sql.append("       ORP_VALOR_GASTO, ");
            sql.append("       TSP_CODIGO, ");
            sql.append("       ORP_NUM_DOC_SOP, "); 
            sql.append("       ONP_CODIGO, ");
            sql.append("       ORP_CONSECUTIVO, ");
            sql.append("       TDC_CODIGO, ");
            sql.append("       FFC_CODIGO, "); 
            sql.append("       PER_CODIGO_ENDOSO ");
            sql.append("FROM SII_ORDEN_PAGO orp ");
            sql.append("WHERE 1=1 ");
            
            if (tdcCodigo!=null)
                sql.append("AND orp.TDC_CODIGO = #tdcCodigo ");
            
            
            
            // FILTROS
            if (filtros!=null && !filtros.isEmpty()) {
                Set<String> columnas = filtros.keySet();
                if (columnas!=null) {
                    for (String columna: columnas) {
                        Object valor = filtros.get(columna);
                        
                        if (valor!=null) {
                            String strValor = valor.toString();
                            
                            // PREVENCION DE SQL INJECTION
                            strValor = Utilidades.filtrarInyeccionSQL(strValor);
                            
                            
                            String columnName = Utilidades.getColumnNameFromProperty(SiiOrdenPago.class, columna);
                            if (columnName!=null && strValor!=null) {
                                sql.append("AND  UPPER("+columnName+")  LIKE UPPER('%"+strValor+"%') ");
                            }
                        }
                    }
                }
            }
            
            
            // ORDENAMIENTO
            if (sortField!=null && !sortField.isEmpty()) {
                
                String columnName = Utilidades.getColumnNameFromProperty(SiiOrdenPago.class, sortField);
                
                if (columnName!=null) {
                    sql.append("ORDER BY "+columnName+" ");
                    
                    if (sortOrder!=null && !sortOrder.isEmpty()) {
                        sql.append(sortOrder+" ");
                    }
                }
            }
            else {
                // ordenamiento por defecto
                sql.append("ORDER BY ORP_CONSECUTIVO DESC ");
            }
            
            
            
            Query query = manager.createNativeQuery(sql.toString());
            
            if (tdcCodigo!=null)
                query.setParameter("tdcCodigo", tdcCodigo);
            
            
            List<Object[]> rows = query.getResultList();
            
            if (rows!=null) {
                
                resultado = new ArrayList<SiiOrdenPago>();
                
                for (Object[] row: rows) {
                    if (row[0]!=null) {
                        Long orpCodigo = ((BigDecimal) row[0]).longValue();
                        if (orpCodigo!=null) {
                            SiiOrdenPago siiOrdenPago = this.buscarOrdenPagoPorCodigo(orpCodigo);
                            if (siiOrdenPago!=null)
                                resultado.add(siiOrdenPago);
                        }
                    }
                }
            }
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        
        return (resultado);
    }
    
    
    
    /** 
     * Obtiene la cantidad de registros de la tabla.
     * @throws ExcepcionDAO
     */
    public Integer obtenerRowCount () throws ExcepcionDAO {
        return ( this.obtenerRowCount(null) );
    }
    
    
    /** 
     * Obtiene la cantidad de registros de la tabla, asociados al Tipo de Documento Contable especificado.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @throws ExcepcionDAO
     */
    public Integer obtenerRowCount (String tdcCodigo) throws ExcepcionDAO {
        Integer resultado = null;
        
        try {
            
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT COUNT(1) FROM SII_ORDEN_PAGO orp ");
            
            if (tdcCodigo!=null)
                sql.append("WHERE orp.TDC_CODIGO = #tdcCodigo ");
            
                
            Query query = manager.createNativeQuery(sql.toString());
            
            if (tdcCodigo!=null)
                query.setParameter("tdcCodigo", tdcCodigo);
            
            
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
    
    //
    // FIN METODOS USADOS PARA PAGINACION EN LAZY DATA MODELS.
    //
    
    
}
