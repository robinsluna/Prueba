/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Mónica Pabón
 * FECHA	: 22-04-2015
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCategoriaDistrib;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class CategoriaDistribDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public CategoriaDistribDAO() {
        recursos = new Recursos();
    }
    
    public SiiCategoriaDistrib buscarPorCodigoCategoriaDistrib(Long idCodigoCategoria) throws ExcepcionDAO {
        SiiCategoriaDistrib retorno = null;
        try {
            retorno = (SiiCategoriaDistrib) manager.find(SiiCategoriaDistrib.class, idCodigoCategoria);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CategoriaDistribDAO");
        }
        return retorno;

    }
}
