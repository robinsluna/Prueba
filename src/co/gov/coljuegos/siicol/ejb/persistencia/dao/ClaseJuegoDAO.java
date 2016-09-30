package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiClaseJuego;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class ClaseJuegoDAO extends GenericDAO<SiiClaseJuego>{


    public ClaseJuegoDAO() {
        super(SiiClaseJuego.class);
    }
    
    public SiiClaseJuego buscarClaseJuegoPorId(Long cjuCodigo) throws ExcepcionDAO {
        SiiClaseJuego siiClaseJuego = null;
        try {
            siiClaseJuego = (SiiClaseJuego) em.find(SiiClaseJuego.class, cjuCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ClaseJuegoDAO");
        }
        return siiClaseJuego;
    }
}
