/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMedioPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcedenciaPago;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class ProcedenciaPagoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    public ProcedenciaPagoDAO() {
        recursos = new Recursos();  
    }
    
    
    public SiiProcedenciaPago  buscarProcedenciaPagoXId(String idProPago) throws ExcepcionDAO {
        SiiProcedenciaPago retornoSiiProcedenciaPago = null;
        try {
            retornoSiiProcedenciaPago = (SiiProcedenciaPago) manager.find(SiiProcedenciaPago.class, idProPago);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecaudoBancoDAO");
        }
        return retornoSiiProcedenciaPago;

    }
}
