package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocConpes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResDecDes;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoTramResDecDesDAO extends AbstractDAO<Long, SiiEstadoTramResDecDes> {
    
    
    public EstadoTramResDecDesDAO() {
        super(SiiEstadoTramResDecDes.class);
    }
    
    public SiiEstadoTramResDecDes buscarEstadoTramResDecDes(String nombreEstado ) throws ExcepcionDAO {
        try {
            SiiEstadoTramResDecDes siiEstadoTramResDecDes= null;
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT est FROM SiiEstadoTramResDecDes est");
            sql.append(" WHERE est.etdNombre = :nombreEstado");
            Query query = em.createQuery(sql.toString());
            query.setParameter("nombreEstado", nombreEstado);
            List<SiiEstadoTramResDecDes> listaSiiEstadoTramResDecDes = query.getResultList();
            
            if (listaSiiEstadoTramResDecDes != null && !listaSiiEstadoTramResDecDes.isEmpty()) {
                siiEstadoTramResDecDes = listaSiiEstadoTramResDecDes.get(0);
            }
            return siiEstadoTramResDecDes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }
    }


}
