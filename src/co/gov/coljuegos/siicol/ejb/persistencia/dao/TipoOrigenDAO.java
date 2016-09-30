package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoOrigen;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class TipoOrigenDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public TipoOrigenDAO() {
        recursos = new Recursos();
    }
    public SiiTipoOrigen buscarTipoOrigenPorId(long idTipoOrigen) throws ExcepcionDAO {
        SiiTipoOrigen tipoOrigen = null;
        try {
            tipoOrigen = (SiiTipoOrigen) manager.find(SiiTipoOrigen.class, idTipoOrigen);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoOrigenDAO");
        } 
        return tipoOrigen;
    }
}
