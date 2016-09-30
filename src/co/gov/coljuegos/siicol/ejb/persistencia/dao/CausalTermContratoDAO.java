package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCausalTermContr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionContrato;
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
public class CausalTermContratoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public CausalTermContratoDAO() {
        recursos = new Recursos();
    }
    
    public SiiCausalTermContr buscarSiiCausalTermContrXId(Long  idCausal) throws ExcepcionDAO {
        SiiCausalTermContr retornoSiiCausalTermContr= null;
        try {
            retornoSiiCausalTermContr = (SiiCausalTermContr) manager.find(SiiCausalTermContr.class, idCausal);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LiquidacionContratoDAO");
        }
        return retornoSiiCausalTermContr;

    }
    
    public List<SiiCausalTermContr> buscarTodosCausalTermContr() throws ExcepcionDAO{
            try{
                List<SiiCausalTermContr> listaCausalTermContr = null;
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT cau FROM SiiCausalTermContr cau order by cau.ctcNombre asc  ");
                Query query = manager.createQuery(sql.toString());
                listaCausalTermContr = query.getResultList();
                return listaCausalTermContr;
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"UsuarioDAO");
            }
        }
}
