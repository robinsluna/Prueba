package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoFiscaliz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class HistEstadoFiscalizDAO extends AbstractDAO<Long,SiiHistEstadoFiscaliz> {   

    public HistEstadoFiscalizDAO() {
        super(SiiHistEstadoFiscaliz.class);
    }

    public List<SiiHistEstadoFiscaliz> buscarHistEstadoFiscalizPorFiscaliz(Long fsuCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiHistEstadoFiscaliz o WHERE o.siiFiscalizadorSustanc.fsuCodigo=:fsuCodigo ORDER BY o.hefCodigo DESC");
            Query query = em.createQuery(sql.toString());
            query.setParameter("fsuCodigo", fsuCodigo);
            List<SiiHistEstadoFiscaliz> histEstados = query.getResultList();
            if (histEstados.size()==0) {
                histEstados = new ArrayList<SiiHistEstadoFiscaliz>();
            }
            return histEstados;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "HistEstadoFiscalizDAO");
        }
    }
    
    public List<SiiHistEstadoFiscaliz> buscarHistEstadoFiscalizPorEstadoYTipo(Long fsuCodigo,String grupo ) throws ExcepcionDAO {
        try {
            Date diaActual = new Date();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiHistEstadoFiscaliz o WHERE o.siiFiscalizadorSustanc.fsuCodigo=:fsuCodigo ");
            sql.append(" and  o.hefGrupoAsignVisit = :grupo and :diaActual between o.hefFechaAct and o.hefFechaInact  ");
            sql.append(" ORDER BY o.hefCodigo DESC ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("fsuCodigo", fsuCodigo);
            query.setParameter("grupo", grupo);
            query.setParameter("diaActual", diaActual);
            List<SiiHistEstadoFiscaliz> histEstados = query.getResultList();
            return histEstados;
            } catch(PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch(Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
        
        
    }
    
}
