/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoCuenta;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean

public class TipoCuentaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
   
   
    public TipoCuentaDAO() {
        recursos = new Recursos();  
    }
    
    public SiiTipoCuenta  buscarTipoCuentaXId(Long idTipoCuenta) throws ExcepcionDAO {
        SiiTipoCuenta retornoSiiTipoCuenta = null;
        try {
            retornoSiiTipoCuenta = (SiiTipoCuenta) manager.find(SiiTipoCuenta.class, idTipoCuenta);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecaudoBancoDAO");
        }
        return retornoSiiTipoCuenta;

    }
    
}
