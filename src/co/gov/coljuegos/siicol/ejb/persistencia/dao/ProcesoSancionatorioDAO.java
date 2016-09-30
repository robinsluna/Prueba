package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoProcesoSanc;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoTramResPrSan;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoActuacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoSancionatorio;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Procesos Sancionatorios.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class ProcesoSancionatorioDAO extends AbstractDAO<Long, SiiProcesoSancionatorio> 
{
    /**
     * Constructor.
     */
    public ProcesoSancionatorioDAO() 
    {
        super(SiiProcesoSancionatorio.class);
    }
    
    
    /**
     * Realiza la consulta de los registros de Proceso Sancionatorio que se encuentran asociados a la persona asociada al Sustanciador - Fiscalizador.
     * @param perCodigo - C&oacute;digo de la Persona (Sustanciador).
     * @return List of SiiProcesoSancionatorio.
     * @throws ExcepcionDAO
     */
    public List<SiiProcesoSancionatorio> buscarProcesoSancionatorioPorPerCodigoSustanciador (Long perCodigo) throws ExcepcionDAO 
    {
        List<SiiProcesoSancionatorio> resultado = null;
        
        if (perCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT psa FROM SiiProcesoSancionatorio psa, ");
                sql.append("  SiiRepartoFiscalizador rfs, ");
                sql.append("  SiiFiscalizadorSustanc fsu, ");
                sql.append("  SiiInformeSupervision isu, ");
                sql.append("  SiiTipoActuacion tac ");
                sql.append("WHERE rfs.siiProcesoSancionatorio.psaCodigo = psa.psaCodigo ");
                sql.append("AND rfs.siiFiscalizadorSustanc.fsuCodigo = fsu.fsuCodigo ");
                sql.append("AND psa.siiInformeSupervision.isuCodigo = isu.isuCodigo ");
                sql.append("AND isu.siiTipoActuacion.tacCodigo = tac.tacCodigo ");
                sql.append("AND isu.siiTipoActuacion.tacCodigo = fsu.siiTipoActuacion.tacCodigo ");
                sql.append("AND fsu.siiPersona.perCodigo = :perCodigo ");
                sql.append("AND rfs.rfsActivo = :rfsActivo ");
                sql.append("AND tac.tacCodigo = :tacCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("perCodigo", perCodigo);
                query.setParameter("rfsActivo", EnumDecision.SI.getId());
                query.setParameter("tacCodigo", EnumTipoActuacion.PROCESO_FISCALIZACION.getTacCodigo());
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    public List<SiiProcesoSancionatorio> buscarProcesosInforme(Long isuCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiProcesoSancionatorio o WHERE o.siiInformeSupervision.isuCodigo = :isuCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("isuCodigo", isuCodigo);
            List<SiiProcesoSancionatorio> proceso = query.getResultList();
            return proceso;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ProcesoSancionatorioDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ProcesoSancionatorioDAO");
        }
    }

    public Integer calcularConsecutivo(Long tacCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT NVL(MAX(psa.PSA_CONSECUTIVO), MOD(Extract(YEAR FROM SysDate), 2000) * 1000000) + 1\n" + "FROM sii_proceso_sancionatorio psa\n" +
                       "INNER JOIN Sii_Informe_Supervision isu\n" + "ON psa.ISU_CODIGO = isu.ISU_CODIGO\n" + "INNER JOIN Sii_Tipo_Actuacion tac\n" +
                       "ON isu.TAC_CODIGO                           = tac.TAC_CODIGO\n" + "WHERE MOD(Extract(YEAR FROM SysDate), 2000) = floor(psa.PSA_CONSECUTIVO / 1000000)\n" +
                       "AND tac.TAC_CODIGO                          = #tacCodigo");
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("tacCodigo", tacCodigo);
            BigDecimal consecutivo = (BigDecimal) query.getSingleResult();
            return consecutivo.intValue();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ProcesoSancionatorioDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ProcesoSancionatorioDAO");
        }
    }

    /**
     * @param fsuCodigo el sustanciador/fiscalizador
     * @return si existen procesos sancionatorios sin terminar asociados al sustanciador/fiscalizador
     * @throws ExcepcionDAO
     */
    public boolean sustanciadorConProcesosVigentes(Long fsuCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRepartoFiscalizador o " +
                " WHERE o.siiProcesoSancionatorio.siiEstadoProcesoSanc.epsNombre NOT IN ('ARCHIVADO','TERMINADO CON SANCIÓN','TERMINADO SIN SANCIÓN') " +
                " AND o.siiFiscalizadorSustanc.fsuCodigo = :fsuCodigo ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("fsuCodigo", fsuCodigo);

            if(query.getResultList().size() > 0) {
                return true;
            }
            else {
                return false;
            }
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ProcesoSancionatorioDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ProcesoSancionatorioDAO");
        }
    }
    
    
    
    /**
     * Obtiene la sentencia SQL asociada a la consulta de los Tr&aacute;mites de Proceso Sancionatorio en estado NOTIFICADO.
     * @param columna - Columna con la cual se har&aacute; el JOIN.
     * @return Cadena con la Sentencia SQL.
     */
    private String obtenerQueryProcSancTramiteResolucionNotificado (String columna) 
    {
        String resultado = null;
        
        if (columna!=null) {
            // Construir el listado de estados de Proceso.
            StringBuilder estadosProceso = new StringBuilder();
            estadosProceso.append(EnumEstadoProcesoSanc.TRAMITE_RESOLUCION_SIN_SANCION.getId()+", ");
            estadosProceso.append(EnumEstadoProcesoSanc.TRAMITE_RESOLUCION_CON_SANCION.getId()+", ");
            estadosProceso.append(EnumEstadoProcesoSanc.TRAMITE_RECURSO_REPOSICION.getId()+", ");
            estadosProceso.append(EnumEstadoProcesoSanc.TRAMITE_RECURSO_APELACION.getId()+"");
            
            Long estadoNotificado = EnumEstadoTramResPrSan.NOTIFICADO.getId();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT psa.PSA_CODIGO FROM SII_PROCESO_SANCIONATORIO psa "); 
            sql.append("INNER JOIN SII_ESTADO_PROCESO_SANC eps  ON  eps.EPS_CODIGO = psa.EPS_CODIGO ");
            sql.append("WHERE eps.EPS_CODIGO IN ("+estadosProceso.toString()+") ");
            sql.append("AND psa."+columna+" IN (SELECT trp.REP_CODIGO FROM SII_TRAMITE_RESOL_PROC_SAN trp WHERE trp.ETR_CODIGO = "+estadoNotificado+") ");
            
            resultado = sql.toString();
        }
        
        return (resultado);
    }
    
    
    /**
     * Obtiene el listado de Procesos Sancionatorios de Fiscalizaci&oacute;n que contienen al menos una Resoluci&oacute;n con Tr&aacute;mite en estado <i>NOTIFICADO</i>.
     * (El estado del Proceso debe encontrarse en <i>TRAMITE_RESOLUCION/TRAMITE_RECURSO_REPOSICION/TRAMITE_RECURSO_APELACION</i>).
     * @return Listado de Procesos Sancionatorios.
     * @throws ExcepcionDAO
     */
    public List<SiiProcesoSancionatorio> buscarProcesoSancionatorioConTramiteResolucionNotificado () throws ExcepcionDAO 
    {
        List<SiiProcesoSancionatorio> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            
            // Listado de columnas que asocian el Proceso con una Resolucion.
            String[] columnas = {"REP_CODIGO_SIN_SANC", "REP_CODIGO_SANCION", "REP_CODIGO_REPOSIC", "REP_CODIGO_APELAC"};
            List<String> listaColumnas = Arrays.asList(columnas);
            Iterator<String> itColumnas = listaColumnas.iterator();
            
            // Construir el Query con la UNION de cada una de las sentencias SQL generadas por cada columna.
            while (itColumnas.hasNext()) {
                String columna = itColumnas.next();
                if (columna!=null) {
                    String query = this.obtenerQueryProcSancTramiteResolucionNotificado(columna);
                    if (query!=null) {
                        sql.append(query);
                        
                        if (itColumnas.hasNext())
                            sql.append(" UNION ");
                    }
                }
            }
            
            
            Query query = em.createNativeQuery(sql.toString());
            List<BigDecimal> rows = query.getResultList();
            
            if (rows!=null && !rows.isEmpty()) {
                resultado = new ArrayList<SiiProcesoSancionatorio>();
                
                for (BigDecimal row: rows) {
                    if (row!=null) {
                        Long psaCodigo = row.longValueExact();
                        
                        // Adicionar cada proceso al listado resultante.
                        SiiProcesoSancionatorio siiProcesoSancionatorio = this.buscarPorCodigo(psaCodigo);
                        if (siiProcesoSancionatorio!=null)
                            resultado.add(siiProcesoSancionatorio);
                    }
                }
            }
            
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName(), pe);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName(), ex);
        }
        
        return (resultado);
    }
}
