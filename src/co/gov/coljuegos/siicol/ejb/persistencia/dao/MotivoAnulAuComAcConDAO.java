package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoAlcanceInv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeVerificCampo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulAuComAcCon;
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
public class MotivoAnulAuComAcConDAO{
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public MotivoAnulAuComAcConDAO(){
        recursos = new Recursos();
    }
    
    public SiiMotivoAnulAuComAcCon insertarMotivoAnulAuComAcCon(SiiMotivoAnulAuComAcCon siiMotivoAnulAuComAcCon) throws ExcepcionDAO {
        try {
            manager.persist(siiMotivoAnulAuComAcCon);
            manager.flush();
            return siiMotivoAnulAuComAcCon;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InformeVerificCampoDAO");
        }   catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
    public SiiMotivoAnulAuComAcCon buscarMotivoAnulAuComAcConPorId(Long idInfVeriCampo) throws ExcepcionDAO {
        SiiMotivoAnulAuComAcCon siiMotivoAnulAuComAcCon = null;
        try {
            siiMotivoAnulAuComAcCon = manager.find(SiiMotivoAnulAuComAcCon.class, idInfVeriCampo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "InformeVerificCampoDAO");
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return siiMotivoAnulAuComAcCon;
    }
    
    public List<SiiMotivoAnulAuComAcCon> buscarTodoMotivoAnulAuComAcCon() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiMotivoAnulAuComAcCon o");
            Query query = manager.createQuery(sql.toString());
            List<SiiMotivoAnulAuComAcCon> listaSiiMotivoAnulAuComAcCon = query.getResultList();
            return listaSiiMotivoAnulAuComAcCon;
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "InformeVerificCampoDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
    
    
}
