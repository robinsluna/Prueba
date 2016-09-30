package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAjusteContCarAct;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPagoCargaActAdm;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class AjusteContCarActDAO extends GenericDAO<SiiAjusteContCarAct> {
    public AjusteContCarActDAO(){
        super(SiiAjusteContCarAct.class);
    }
    
    public List<SiiAjusteContCarAct> buscarTodoSiiAjusteContCarActXLiqActAdmin(Long  caaCodigo,Long camCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT co FROM SiiAjusteContCarAct co inner join  co.siiCargaActuacionesAdm c");
            sql.append(" inner join co.siiConcepCuotCarActAdm cp ");
            sql.append(" where c.caaCodigo = :caaCodigo and co.ajcActivo = 'S' and cp.camActivo='S' ");
            if ( camCodigo!= null)
                sql.append(" and cp.camCodigo =:camCodigo ");
           
            Query query = em.createQuery(sql.toString());
            query.setParameter("caaCodigo", caaCodigo);
            if ( camCodigo!= null)
                query.setParameter("camCodigo", camCodigo);
            
            List<SiiAjusteContCarAct> listaResultado = query.getResultList();
            return listaResultado;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
}
