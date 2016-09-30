package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoProyeccionCar;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionCargaAct;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ProyeccionCargaActDAO extends GenericDAO<SiiProyeccionCargaAct>{
    public ProyeccionCargaActDAO(){
        super(SiiProyeccionCargaAct.class);
    }
    
    
   
    
    public List<SiiProyeccionCargaAct> buscarProyeccionCargaActXConceptoCuotaActAdmin(Long  caaCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT co FROM SiiProyeccionCargaAct co inner join  co.siiCargaActuacionesAdm c");
            sql.append(" where c.caaCodigo = :caaCodigo and co.pycEstado = 'A'");
           
            Query query = em.createQuery(sql.toString());
            query.setParameter("caaCodigo", caaCodigo);
            List<SiiProyeccionCargaAct> listaResultado = query.getResultList();
            return listaResultado;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
    
}
