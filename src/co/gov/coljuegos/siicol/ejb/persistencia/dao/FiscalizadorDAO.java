package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFiscalizadorSustanc;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class FiscalizadorDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public FiscalizadorDAO() {
        recursos = new Recursos();
    }
    
    
    public List<SiiFiscalizadorSustanc> buscarTodoFiscalizadorSustanc( ) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT a FROM SiiFiscalizadorSustanc a  ");
            sql.append(" SELECT a FROM siiPersona p  ");
            sql.append(" order by p.perPrimerApellido asc ");
            Query query = manager.createQuery(sql.toString());
           
            List<SiiFiscalizadorSustanc> listaFiscalizadorSustanc = query.getResultList();
            return listaFiscalizadorSustanc;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReintegroPagaduriaDAO");
        }
    }
}
