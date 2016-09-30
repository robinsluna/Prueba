package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoContrProv;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class EstadoContrProvDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoContrProvDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoContrProv buscarEstadoContrProvPorId(Long idEstadoContrProv) throws ExcepcionDAO {
        SiiEstadoContrProv siiEstadoContrProv = new SiiEstadoContrProv();
            try{
                siiEstadoContrProv = (SiiEstadoContrProv) manager.find(SiiEstadoContrProv.class, idEstadoContrProv);
            }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoContrProvDAO");
            }
            return siiEstadoContrProv;
        }
    
}