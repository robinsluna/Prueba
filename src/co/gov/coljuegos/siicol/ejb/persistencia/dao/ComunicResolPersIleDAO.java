package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComunicResolPersIle;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ComunicResolPersIleDAO extends AbstractDAO<Long, SiiComunicResolPersIle>  {
    
    public ComunicResolPersIleDAO() {
        super(SiiComunicResolPersIle.class);
    }

    public List<SiiComunicResolPersIle> buscarComunicResolPersIlePorResolucion(Long rpiCodigo) throws ExcepcionDAO {
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiComunicResolPersIle o ");
            sql.append("WHERE o.siiResolucionProcIleg.rpiCodigo = :rpiCodigo");

            Query query = em.createQuery(sql.toString());
            query.setParameter("rpiCodigo", rpiCodigo);

            return query.getResultList();

        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
        }
    }
}
