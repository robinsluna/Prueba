package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocConpes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoElemenIlegalidad;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class TipoElemenIlegalidadDAO extends AbstractDAO<Long, SiiTipoElemenIlegalidad> {
    public TipoElemenIlegalidadDAO () {
        super(SiiTipoElemenIlegalidad.class);
    }
    
    
    public SiiTipoElemenIlegalidad buscarTipoElemenIlegalidadXNombre(String nombreEstado ) throws ExcepcionDAO {
        try {
            SiiTipoElemenIlegalidad siiTipoElemenIlegalidad= null;
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT t FROM SiiTipoElemenIlegalidad t");
            sql.append(" WHERE t.teiNombre = :nombreEstado");
            Query query = em.createQuery(sql.toString());
            query.setParameter("nombreEstado", nombreEstado);
            List<SiiTipoElemenIlegalidad> listaSiiTipoElemenIlegalidad= query.getResultList();
            
            if (listaSiiTipoElemenIlegalidad != null && !listaSiiTipoElemenIlegalidad.isEmpty()) {
                siiTipoElemenIlegalidad = listaSiiTipoElemenIlegalidad.get(0);
            }
            return siiTipoElemenIlegalidad;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }
    }
}
