package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoFiscaliz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoSustan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class HistEstadoSustanDAO extends AbstractDAO<Long, SiiHistEstadoSustan>{
    public HistEstadoSustanDAO() {
        super(SiiHistEstadoSustan.class);
    }

    public List<SiiHistEstadoSustan> buscarHistEstadoSustanPorAuditor(Long suaCodigo,String tipo ) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiHistEstadoSustan o WHERE o.siiSustanciadorAuditor.suaCodigo =:suaCodigo " );
            if (tipo!= null)
                sql.append(" and o.hesGrupoAsignVisit =:tipo  " );
            sql.append(" ORDER BY o.hesCodigo DESC");
            Query query = em.createQuery(sql.toString());
            query.setParameter("suaCodigo", suaCodigo);
            if (tipo!= null)
                query.setParameter("tipo", tipo);
            List<SiiHistEstadoSustan> histEstados = query.getResultList();
            if (histEstados.size()==0) {
                histEstados = new ArrayList<SiiHistEstadoSustan>();
            }
            return histEstados;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiHistEstadoSustanDAO");
        }
    }
    
    public List<SiiHistEstadoSustan> buscarHistEstadoSustanciadorPorEstadoYTipo(Long suaCodigo,String grupo ) throws ExcepcionDAO {
        try {
            Date diaActual = null;
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            String date = formateador.format(new Date());
            diaActual = formateador.parse(date);
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiHistEstadoSustan o WHERE o.siiSustanciadorAuditor.suaCodigo=:suaCodigo ");
            sql.append(" and  o.hesGrupoAsignVisit =:grupo and :diaActual between o.hesFechaAct and o.hesFechaInact  ");
            sql.append(" ORDER BY o.hesCodigo DESC ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("suaCodigo", suaCodigo);
            query.setParameter("grupo", grupo);
                query.setParameter("diaActual", diaActual);
            List<SiiHistEstadoSustan> histEstados = query.getResultList();
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
