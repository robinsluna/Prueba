package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComprobAsociado;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class ComprobAsociadoDAO extends GenericDAO<SiiComprobAsociado>{


    public ComprobAsociadoDAO() {
        super(SiiComprobAsociado.class);
    }
    
    public SiiComprobAsociado buscarComprobAsociadoPorId(String casCodigo) throws ExcepcionDAO {
        SiiComprobAsociado siiComprobAsociado = null;
        try {
            siiComprobAsociado = (SiiComprobAsociado) em.find(SiiComprobAsociado.class, casCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ComprobAsociadoDAO");
        }
        return siiComprobAsociado;
    }
}
