/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 22-01-2015
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaAcuerdo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaOpCuoAcu;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class HlpCuotaOpCuoAcuDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public HlpCuotaOpCuoAcuDAO() {
        recursos = new Recursos();
    }
    public SiiHlpCuotaOpCuoAcu buscarHlpCuotaOpCuoAcuPorCodigo(Long idCodigoHlpCuotaOpCuoAcu) throws ExcepcionDAO {
        SiiHlpCuotaOpCuoAcu retorno = null;
        try {
            retorno = (SiiHlpCuotaOpCuoAcu) manager.find(SiiHlpCuotaOpCuoAcu.class, idCodigoHlpCuotaOpCuoAcu);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "HlpCuotaOpCuoAcuDAO");
        }
        return retorno;

    }
    
    public SiiHlpCuotaOpCuoAcu insertarSiiHlpCuotaOpCuoAcu(SiiHlpCuotaOpCuoAcu siiHlpCuotaOpCuoAcu) throws ExcepcionDAO {
        try {
            manager.persist(siiHlpCuotaOpCuoAcu); 
            manager.flush(); 
            return siiHlpCuotaOpCuoAcu; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "HlpCuotaOpCuoAcuDAO");
        }
    }
}
