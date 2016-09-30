package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionPersona;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DireccionPersonaDAO extends AbstractDAO<Long,SiiDireccionPersona>{
    public DireccionPersonaDAO() {
        super(SiiDireccionPersona.class);
    }
    
    /**
     * Buscar una dirección según el id de la persona
     * @param perCodigo
     * @return resultado - List de SiiDireccionPersona
     * @throws ExcepcionDAO
     */

    public List<SiiDireccionPersona> buscarDireccionPersonaXIdPersona(Long perCodigo) throws ExcepcionDAO {
        List<SiiDireccionPersona> resultado = null;

        if(perCodigo != null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dp FROM SiiDireccionPersona dp ");
                sql.append("WHERE dp.siiPersona.perCodigo = :perCodigo ");

                Query query = em.createQuery(sql.toString());
                query.setParameter("perCodigo", perCodigo);

                resultado = query.getResultList();

            } catch(PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }

        return (resultado);
    }
}
