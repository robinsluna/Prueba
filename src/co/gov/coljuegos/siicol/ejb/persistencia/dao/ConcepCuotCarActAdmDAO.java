package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepCuotCarActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCierreAnualCont;

import co.gov.coljuegos.siicol.ejb.vo.ConcepCuotCarActAdmVO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ConcepCuotCarActAdmDAO extends GenericDAO<SiiConcepCuotCarActAdm> { 
    public ConcepCuotCarActAdmDAO(){
        super(SiiConcepCuotCarActAdm.class);
    }
    public List<SiiConcepCuotCarActAdm> buscarTodoSiiConcepCuotCarActAdmXLiqActAdmin(Long  caaCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT co FROM SiiConcepCuotCarActAdm co inner join  co.siiCargaActuacionesAdm c");
            sql.append(" where c.caaCodigo = :caaCodigo and co.camActivo = 'S' ");
           
            Query query = em.createQuery(sql.toString());
            query.setParameter("caaCodigo", caaCodigo);
            List<SiiConcepCuotCarActAdm> listaResultado = query.getResultList();
            return listaResultado;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
    
    public List<SiiConcepCuotCarActAdm> buscarTodoSiiConcepCuotCarActAdmXCcuCodigo(String   ccuNombre,Long caaCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT co FROM SiiConcepCuotCarActAdm co inner join co.siiConceptoCuota c ");
            sql.append(" inner join  co.siiCargaActuacionesAdm ca ");
            sql.append(" where c.ccuNombre = :ccuNombre and ca.caaCodigo =:caaCodigo and co.camActivo = 'S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("ccuNombre", ccuNombre);
            query.setParameter("caaCodigo", caaCodigo);
            List<SiiConcepCuotCarActAdm> listaResultado = query.getResultList();
            return listaResultado;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }

    

}
