/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 08-03-2016
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class ModifEstadoDocContabDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ModifEstadoDocContabDAO() { 
        recursos = new Recursos();
    }
    public SiiModifEstadoDocContab buscarPorCodigoModifEstadoDocContab(Long idCodigoModEstDoc) throws ExcepcionDAO {
        SiiModifEstadoDocContab retorno = null;
        try {
            retorno = (SiiModifEstadoDocContab) manager.find(SiiModifEstadoDocContab.class, idCodigoModEstDoc);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifEstadoDocContabDAO");
        }
        return retorno;

    }
    
    public SiiModifEstadoDocContab insertarSiiModifEstadoDocContab(SiiModifEstadoDocContab modifEstadoDocContab) throws ExcepcionDAO {
        try {
            manager.persist(modifEstadoDocContab); 
            manager.flush(); 
            return modifEstadoDocContab; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifEstadoDocContabDAO");
        }
    }
}
