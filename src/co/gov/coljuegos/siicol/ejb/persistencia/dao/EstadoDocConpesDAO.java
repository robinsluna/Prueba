/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 24-01-2014
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoConpes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocConpes;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoDocConpesDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    
    public EstadoDocConpesDAO() {
        recursos = new Recursos();
    }
    
    
    public SiiEstadoDocConpes buscarEstadoDocConpesPorId(long idEstado) throws ExcepcionDAO {
        SiiEstadoDocConpes estadoDocConpes = null;
        try {
            estadoDocConpes = (SiiEstadoDocConpes) manager.find(SiiEstadoDocConpes.class, idEstado);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoCdpDAO");
        } 
        return estadoDocConpes;
    }
    public SiiEstadoDocConpes buscarEstadoDocConpesXNombre(String nombreEstado ) throws ExcepcionDAO {
        try {
            SiiEstadoDocConpes siiEstadoDocConpes= null;
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT est FROM SiiEstadoDocConpes est");
            sql.append(" WHERE est.edcNombre = :nombreEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreEstado", nombreEstado);
            List<SiiEstadoDocConpes> listaSiiEstadoDocConpes = query.getResultList();
            
            if (listaSiiEstadoDocConpes != null && !listaSiiEstadoDocConpes.isEmpty()) {
                siiEstadoDocConpes = listaSiiEstadoDocConpes.get(0);
            }
            return siiEstadoDocConpes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }
    }
    
}
