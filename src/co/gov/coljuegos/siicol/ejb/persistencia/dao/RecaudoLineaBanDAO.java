package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaRequisitosPol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoLineaBan;
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
public class RecaudoLineaBanDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public RecaudoLineaBanDAO() {
        super();
    }

    /**
     *Metodo encargado de hacer el registro de un recaudo en linea del banco por medio del web services
     * @author David Tafur
     * @param siiRecaudoLineaBan
     * @return
     * @throws ExcepcionDAO
     */
    public SiiRecaudoLineaBan insertarSiiRecaudoLineaBan(SiiRecaudoLineaBan siiRecaudoLineaBan) throws ExcepcionDAO {
        try {
            manager.persist(siiRecaudoLineaBan);
            manager.flush();
            return siiRecaudoLineaBan;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " " + pe.getMessage(), "RecaudoLineaBanDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RecaudoLineaBanDAO");
        }

    }

    /**
     *Metodo encargado de hacer la actualizacion de un recaudo en linea del banco por medio del web services
     * @author David Tafur
     * @param siiRecaudoLineaBan
     * @return
     * @throws ExcepcionDAO
     */
    public SiiRecaudoLineaBan actualizarSiiRecaudoLineaBan(SiiRecaudoLineaBan siiRecaudoLineaBan) throws ExcepcionDAO {
        try {
            manager.merge(siiRecaudoLineaBan);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RecaudoLineaBanDAO");
        }
        return siiRecaudoLineaBan;
    }
    
    public SiiRecaudoLineaBan buscarRecaudoLineaBanXId(Long idRecuadoLin) throws ExcepcionDAO {
        SiiRecaudoLineaBan retornoSiiRecaudoLineaBan = null;
        try {
            retornoSiiRecaudoLineaBan = (SiiRecaudoLineaBan) manager.find(SiiRecaudoLineaBan.class, idRecuadoLin);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecaudoBancoDAO");
        }
        return retornoSiiRecaudoLineaBan;

    }
    
    public SiiRecaudoLineaBan  buscarRecaudoLineaBanXRef(String refrincipal ) throws ExcepcionDAO{ 
       // ValidacionInteresVO unValidacionInteresVo= new ValidacionInteresVO();
       
        List<SiiRecaudoLineaBan> listaSiiRecaudoLineaBan = null;
        SiiRecaudoLineaBan retornoSiiRecaudoLineaBan= null;
        
        try{        
          
            
            StringBuilder sql = new StringBuilder();
            sql.append(" select  re from SiiRecaudoLineaBan re ");
            sql.append(" where re.siiOperacionLineaBan.olbRefPrincipal = :refrincipal  ");
            sql.append(" order by re.rlbCodigo desc ");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("refrincipal",refrincipal );          
            listaSiiRecaudoLineaBan = query.getResultList();
            
            if (listaSiiRecaudoLineaBan.size() > 0) {
                retornoSiiRecaudoLineaBan = listaSiiRecaudoLineaBan.get(0);
            }
    
    
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return retornoSiiRecaudoLineaBan;
    }  
    
    
}
