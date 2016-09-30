/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-10-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoInstrumento;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;


@Stateless
@LocalBean
public class TipoInstrumentoDAO extends AbstractDAO<Long, SiiTipoInstrumento> {
    
    /**
     * Constructor.
     */
    public TipoInstrumentoDAO() {
        super(SiiTipoInstrumento.class);
    }
    
    
    public SiiTipoInstrumento buscarTipoInstrumentoPorCodigo(Long idCodigo) throws ExcepcionDAO {
        SiiTipoInstrumento instrumentoRetorno = null;
        try {
            instrumentoRetorno = em.find(SiiTipoInstrumento.class, idCodigo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoInstrumentoDAO");
        }
        return instrumentoRetorno;

    }
    
    public SiiTipoInstrumento insertarSiiTipoInstrumento(SiiTipoInstrumento instrumento) throws ExcepcionDAO {
        try {
            em.persist(instrumento); 
            em.flush(); 
            return instrumento; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoInstrumentoDAO");
        }
    }
   
}
