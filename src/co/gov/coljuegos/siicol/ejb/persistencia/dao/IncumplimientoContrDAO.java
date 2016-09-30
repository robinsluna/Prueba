/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GESTIÓN CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-08-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumCategoriaResolucionIncumContr;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoActuacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiIncumplimientoContr;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class IncumplimientoContrDAO extends AbstractDAO<Long, SiiIncumplimientoContr> {
    public IncumplimientoContrDAO() {
        super(SiiIncumplimientoContr.class);
    }

    public Integer calcularConsecutivo(Long tacCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT NVL(MAX(icn.ICN_CONSECUTIVO), MOD(Extract(YEAR FROM SysDate), 2000) * 1000000) + 1\n" + "FROM sii_incumplimiento_contr icn\n" +
                       "INNER JOIN Sii_Informe_Supervision isu\n" + "ON icn.ISU_CODIGO = isu.ISU_CODIGO\n" + "INNER JOIN Sii_Tipo_Actuacion tac\n" +
                       "ON isu.TAC_CODIGO                           = tac.TAC_CODIGO\n" + "WHERE MOD(Extract(YEAR FROM SysDate), 2000) = floor(icn.ICN_CONSECUTIVO / 1000000)\n" +
                       "AND tac.TAC_CODIGO                          = #tacCodigo");
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("tacCodigo", tacCodigo);
            BigDecimal consecutivo = (BigDecimal) query.getSingleResult();
            return consecutivo.intValue();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "IncumplimientoContrDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "IncumplimientoContrDAO");
        }
    }

    public List<SiiIncumplimientoContr> buscarIncumplimientosInforme(Long isuCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiIncumplimientoContr o WHERE o.siiInformeSupervision.isuCodigo = :isuCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("isuCodigo", isuCodigo);
            return query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "IncumplimientoContrDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "IncumplimientoContrDAO");
        }
    }

    /**
     * @param fsuCodigo el sustanciador/fiscalizador
     * @return si existen incumplimientos sin terminar asociados al sustanciador/fiscalizador
     * @throws ExcepcionDAO
     */
    public boolean sustanciadorConIncumplimientosVigentes(Long fsuCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRepartoFiscalizador o WHERE o.siiFiscalizadorSustanc.fsuCodigo = :fsuCodigo AND o.siiIncumplimientoContr.siiEstadoIncumplContract.eicNombre NOT IN ('ARCHIVADO','TERMINADO CON SANCIÓN','TERMINADO SIN SANCIÓN')");
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
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "IncumplimientoContrDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "IncumplimientoContrDAO");
        }
    }
    
    /**
         * Realiza la b&uacute;squeda de TODOS los registros correspondientes a la Entidad base.
         * @return List of SiiTipoDocContable
         * @throws ExcepcionDAO
         */
        public List<SiiIncumplimientoContr> buscarTodo() throws ExcepcionDAO 
        {
            List<SiiIncumplimientoContr> lista = null;
            
            try {                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT o FROM SiiIncumplimientoContr o");
                Query query = em.createQuery(sql.toString());
                lista = query.getResultList();
                
                return lista;

            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        public SiiIncumplimientoContr insertarSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) throws ExcepcionDAO {
            try {
                em.persist(siiIncumplimientoContr);
                em.flush();
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
            return siiIncumplimientoContr;
        }
        
        public SiiIncumplimientoContr actualizarSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) throws ExcepcionDAO {
            try {
                em.merge(siiIncumplimientoContr);
                em.flush();
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
            return siiIncumplimientoContr;
        }
        
        
        /**
         * Realiza la consulta de los registros de Incumplimiento Contractual que se encuentran asociados a la persona asociada al Sustanciador - Fiscalizador.
         * @param perCodigo - C&oacute;digo de la Persona (Sustanciador).
         * @return List of SiiIncumplimientoContr.
         * @throws ExcepcionDAO
         */
        public List<SiiIncumplimientoContr> buscarIncumplimientoPorPerCodigoSustanciador (Long perCodigo) throws ExcepcionDAO 
        {
            List<SiiIncumplimientoContr> resultado = null;
            
            if (perCodigo!=null) {
                try {
                    StringBuilder sql = new StringBuilder();
                    sql.append("SELECT icn FROM SiiIncumplimientoContr icn, ");
                    sql.append("  SiiRepartoFiscalizador rfs, ");
                    sql.append("  SiiFiscalizadorSustanc fsu, ");
                    sql.append("  SiiInformeSupervision isu, ");
                    sql.append("  SiiTipoActuacion tac ");
                    sql.append("WHERE rfs.siiIncumplimientoContr.icnCodigo = icn.icnCodigo ");
                    sql.append("AND rfs.siiFiscalizadorSustanc.fsuCodigo = fsu.fsuCodigo ");
                    sql.append("AND icn.siiInformeSupervision.isuCodigo = isu.isuCodigo ");
                    sql.append("AND isu.siiTipoActuacion.tacCodigo = tac.tacCodigo ");
                    sql.append("AND isu.siiTipoActuacion.tacCodigo = fsu.siiTipoActuacion.tacCodigo ");
                    sql.append("AND fsu.siiPersona.perCodigo = :perCodigo ");
                    sql.append("AND rfs.rfsActivo = :rfsActivo ");
                    sql.append("AND tac.tacCodigo = :tacCodigo ");
                    
                    Query query = em.createQuery(sql.toString());
                    query.setParameter("perCodigo", perCodigo);
                    query.setParameter("rfsActivo", EnumDecision.SI.getId());
                    query.setParameter("tacCodigo", EnumTipoActuacion.PROCESO_INCUMPLIMIENTO.getTacCodigo());
                    
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

    
    
    /**
     * Busca el Proceso de Incumplimiento Contractual asociado a la Resoluci&oacute;n y Categor&iacute;a de Resoluci&oacute;n especificadas.
     * @param rcoCodigo - C&oacute;digo de la Resoluci&oacute;n.
     * @param categoriaResolucion - Categor&iacute;a de la Resoluci&oacute;n (ORIGINA RECURSO / RESUELVE RECURSO).
     * @return Instance of SiiIncumplimientoContr.
     * @throws ExcepcionDAO
     */
    public SiiIncumplimientoContr buscarIncumplimientoPorIdResolucionYCategoria (Long rcoCodigo, Long categoriaResolucion) throws ExcepcionDAO 
    {
        SiiIncumplimientoContr resultado = null;
        
        if ( rcoCodigo!=null && categoriaResolucion!=null &&
            (EnumCategoriaResolucionIncumContr.ORIGINA_RECURSO.getId().equals(categoriaResolucion) || 
             EnumCategoriaResolucionIncumContr.RESUELVE_RECURSO.getId().equals(categoriaResolucion)) ) 
        {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT icn FROM SiiIncumplimientoContr icn, ");
                sql.append("                SiiResolucionIncumContr rco ");
                
                if (EnumCategoriaResolucionIncumContr.ORIGINA_RECURSO.getId().equals(categoriaResolucion)) 
                    sql.append("WHERE icn.siiResolucionIncumContrResol.rcoCodigo = rco.rcoCodigo ");
                else if (EnumCategoriaResolucionIncumContr.RESUELVE_RECURSO.getId().equals(categoriaResolucion))
                    sql.append("WHERE icn.siiResolucionIncumContrRecurso.rcoCodigo = rco.rcoCodigo ");
                
                sql.append("AND rco.rcoCodigo = :rcoCodigo ");
                
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("rcoCodigo", rcoCodigo);
                
                List<SiiIncumplimientoContr> lista = query.getResultList();
                if (lista!=null && !lista.isEmpty()) {
                    // obtener el primer registro, ya que solo debe existir un proceso por resolucion
                    resultado = lista.get(0);
                }
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
}
