package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoProyeccionCar;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPagoCargaActAdm;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ConceptoProyeccionCarDAO extends GenericDAO<SiiConceptoProyeccionCar>{
    public ConceptoProyeccionCarDAO(){
        super(SiiConceptoProyeccionCar.class);
    }
    
    public List<SiiConceptoProyeccionCar>  buscarConceptoProyeccionCarXConceptoCuotaActAdmin(Long  camCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT co FROM SiiConceptoProyeccionCar co inner join  co.siiConcepCuotCarActAdm c");
            sql.append(" where c.camCodigo = :camCodigo and co.cpcActivo = 'S'");
           
            Query query = em.createQuery(sql.toString());
            query.setParameter("camCodigo", camCodigo);
            List<SiiConceptoProyeccionCar> listaResultado = query.getResultList();
            return listaResultado;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
    
    public List<SiiConceptoProyeccionCar>  buscarConceptoProyeccionCarXProyeccionCargaAct(Long  pycCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT co FROM SiiConceptoProyeccionCar co inner join  co.siiProyeccionCargaAct c");
            sql.append(" where c.pycCodigo = :pycCodigo ");
           
            Query query = em.createQuery(sql.toString());
            query.setParameter("pycCodigo", pycCodigo);
            List<SiiConceptoProyeccionCar> listaResultado = query.getResultList();
            return listaResultado;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
    
    
}
