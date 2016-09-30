package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCierrreRec;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class EstadoCierreRecDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstadoCierreRecDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoCierrreRec buscarEstadoCierrreRecPorId(Long idCodigoEstadoCierre) throws ExcepcionDAO {
        SiiEstadoCierrreRec retorno = null;
        try {
            retorno = (SiiEstadoCierrreRec) manager.find(SiiEstadoCierrreRec.class, idCodigoEstadoCierre);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CierreRecaudoDAO");
        }
        return retorno;
    }
}
