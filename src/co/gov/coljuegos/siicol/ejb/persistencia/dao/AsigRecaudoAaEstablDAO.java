/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Mónica Pabón
 * FECHA	: 01-10-2015
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsigRecaudoAaEstabl;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class AsigRecaudoAaEstablDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public AsigRecaudoAaEstablDAO() {
        recursos = new Recursos();
    }
    public SiiAsigRecaudoAaEstabl buscarPorCodigoAsigRecaudoAaEstabl(Long idAsigRecaudoAaEstabl) throws ExcepcionDAO {
        SiiAsigRecaudoAaEstabl retorno = null;
        try {
            retorno = (SiiAsigRecaudoAaEstabl) manager.find(SiiAsigRecaudoAaEstabl.class, idAsigRecaudoAaEstabl);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AsigRecaudoAaEstablDAO");
        }
        return retorno;

    }
    
}
