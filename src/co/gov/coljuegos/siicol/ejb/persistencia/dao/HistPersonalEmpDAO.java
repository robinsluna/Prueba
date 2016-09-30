package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistPersonalEmp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class HistPersonalEmpDAO extends GenericDAO<SiiHistPersonalEmp>{

    
    public HistPersonalEmpDAO() {
        super(SiiHistPersonalEmp.class);
    }

    /**
     *Metodo encargado de registrar un historial del personal de una empresa
     * @Author David Tafur
     * @param siiHistPersonalEmp
     * @throws ExcepcionDAO
     */
    public void insertarSiiHistPersonalEmp(SiiHistPersonalEmp siiHistPersonalEmp) throws ExcepcionDAO {
        try {
            em.persist(siiHistPersonalEmp);
            em.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "HistPersonalEmpDAO");
        }
    }
}
