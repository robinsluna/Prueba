package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepCuotCarActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPagoCargaActAdm;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class PagoCargaActAdmDAO extends GenericDAO<SiiPagoCargaActAdm>{
    public PagoCargaActAdmDAO(){
        super(SiiPagoCargaActAdm.class);
    }
    
    public List<SiiPagoCargaActAdm> buscarTodoSiiPagoCargaActAdmXLiqActAdmin(Long  caaCodigo,Long ccuCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT co FROM SiiPagoCargaActAdm co inner join  co.siiCargaActuacionesAdm c");
            sql.append(" inner join co.siiConceptoCuota cp  ");
            sql.append(" where c.caaCodigo = :caaCodigo and co.pcaActivo = 'S'");
            if(ccuCodigo!= null)
                sql.append(" and cp.ccuCodigo =:ccuCodigo  ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("caaCodigo", caaCodigo);
            if(ccuCodigo!= null)
                query.setParameter("ccuCodigo", ccuCodigo);
            List<SiiPagoCargaActAdm> listaResultado = query.getResultList();
            return listaResultado;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
}
