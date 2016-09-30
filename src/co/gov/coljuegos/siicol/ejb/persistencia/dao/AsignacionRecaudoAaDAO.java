/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Mónica Pabón
 * FECHA	: 01-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsignacionRecaudoAa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenPago;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class AsignacionRecaudoAaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public AsignacionRecaudoAaDAO() {
        recursos = new Recursos();
    }
    public SiiAsignacionRecaudoAa buscarPorCodigoAsignacionRecaudoAa(Long idAsignacionRecaudoAa) throws ExcepcionDAO {
        SiiAsignacionRecaudoAa retorno = null;
        try {
            retorno = (SiiAsignacionRecaudoAa) manager.find(SiiAsignacionRecaudoAa.class, idAsignacionRecaudoAa);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AsignacionRecaudoAaDAO");
        }
        return retorno;

    }
    
    public SiiAsignacionRecaudoAa actualizarAsignacionRecaudoAa(SiiAsignacionRecaudoAa siiAsignacionRecaudoAa) throws ExcepcionDAO {
        try {
            siiAsignacionRecaudoAa = manager.merge(siiAsignacionRecaudoAa);
            manager.flush();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiAsignacionRecaudoAa;
    }
    
    public BigDecimal buscarTotalPagosActuacionesAdmPorMesYVigencia(int mes,Integer vigencia) throws ExcepcionDAO {
        BigDecimal total = new BigDecimal(0);
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT SUM(o.ara_Valor) FROM sii_asignacion_Recaudo_aa o");
            sql.append(" where to_char(o.ara_Fecha_Pago,'MM') = #mes and  to_char(o.ara_Fecha_Pago,'YYYY')=#vigencia");
                                   
            
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("vigencia",vigencia);
            query.setParameter("mes",mes);
            
            if (query.getSingleResult() != null) {
                total = (BigDecimal) query.getSingleResult();
            }
            return total;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AsignacionRecaudoAaDAO");
        }

    }
    
}
