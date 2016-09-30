package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepCuotCarActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecConCuoCar;

import co.gov.coljuegos.siicol.ejb.vo.ConcepCuotCarActAdmVO;

import co.gov.coljuegos.siicol.ejb.vo.EstablecConCuoCarVO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstablecConCuoCarDAO extends GenericDAO<SiiEstablecConCuoCar>{
    public EstablecConCuoCarDAO(){
        super(SiiEstablecConCuoCar.class);
    }
    
    public List<SiiEstablecConCuoCar> buscarTodoEstablecConCuoCarXConcepCuotaAct(Long  camCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT co FROM SiiEstablecConCuoCar co inner join  co.siiConcepCuotCarActAdm c");
            sql.append(" where c.camCodigo = :camCodigo and co.ecuActivo = 'S' ");
           
            Query query = em.createQuery(sql.toString());
            query.setParameter("camCodigo", camCodigo);
            List<SiiEstablecConCuoCar> listaResultado = query.getResultList();
            return listaResultado;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
}
