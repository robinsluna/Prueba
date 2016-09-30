/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Walter Becerra
 * FECHA	: 13-03-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTraslBancario;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoTansladoBancarioDAO extends GenericDAO<SiiEstadoTraslBancario>{

    
    public EstadoTansladoBancarioDAO() {
        super(SiiEstadoTraslBancario.class);
       
    }
    
    
    public SiiEstadoTraslBancario buscarEstadoEstadoTraslBancarioPorNombre(String nombreEstado) throws ExcepcionDAO{
        SiiEstadoTraslBancario siiEstadoTraslBancario = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT est FROM SiiEstadoTraslBancario est");
            sql.append(" WHERE est.etbNombre = :nombreEstado");
            Query query = em.createQuery(sql.toString());
            query.setParameter("nombreEstado",nombreEstado);
            List<SiiEstadoTraslBancario> listaSiiEstadoTraslBancario = query.getResultList();
            
            if (listaSiiEstadoTraslBancario != null && !listaSiiEstadoTraslBancario.isEmpty()) {
                siiEstadoTraslBancario = listaSiiEstadoTraslBancario.get(0);
        }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FuenteFinanciacionDAO");
        }
        return siiEstadoTraslBancario;
    }
    
    
}
