
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoBanco;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean


public class RecaudoBancoDAO extends GenericDAO<SiiRecaudoBanco> {
    
    public RecaudoBancoDAO() {
        super(SiiRecaudoBanco.class); 
    }
    
    public SiiRecaudoBanco  buscarRecaudoBancoXId(Long idRec) throws ExcepcionDAO {
        SiiRecaudoBanco retornoRecaudoBanco = null;
        try {
            retornoRecaudoBanco = em.find(SiiRecaudoBanco.class, idRec);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return retornoRecaudoBanco;

    }
    public List<SiiRecaudoBanco> buscarTodosRecaudoBanco() throws ExcepcionDAO{
        try{
            List<SiiRecaudoBanco> listaSiiRecaudoBanco = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rec FROM SiiRecaudoBanco rec order by rec.rbaCodigo desc  ");
            Query query = em.createQuery(sql.toString());
            listaSiiRecaudoBanco = query.getResultList();
            return listaSiiRecaudoBanco;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
}
