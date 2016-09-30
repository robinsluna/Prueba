package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoLiquidCont;
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
public class EstadoLiqContratoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstadoLiqContratoDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoLiquidCont buscarEstadoLiqContratoXId(Long  idEstado) throws ExcepcionDAO {
        SiiEstadoLiquidCont retornoSiiEstadoLiquidCont= null;
        try {
            retornoSiiEstadoLiquidCont = (SiiEstadoLiquidCont) manager.find(SiiEstadoLiquidCont.class, idEstado);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LiquidacionContratoDAO");
        }
        return retornoSiiEstadoLiquidCont;

    }
    
    public SiiEstadoLiquidCont buscarEstadoLiquidContXNombre (String nombreEstado ) throws ExcepcionDAO {
           try {
               SiiEstadoLiquidCont siiEstadoLiquidCont= null;
               StringBuilder sql = new StringBuilder();
               sql.append(" SELECT est FROM SiiEstadoLiquidCont est");
               sql.append(" WHERE est.elcNombre = :nombreEstado");
               Query query = manager.createQuery(sql.toString());
               query.setParameter("nombreEstado", nombreEstado);
               List<SiiEstadoLiquidCont> listaSiiEstadoLiquidCont = query.getResultList();
               
               if (listaSiiEstadoLiquidCont!= null && !listaSiiEstadoLiquidCont.isEmpty()) {
                   siiEstadoLiquidCont = listaSiiEstadoLiquidCont.get(0);
               }
               return siiEstadoLiquidCont;

           } catch (PersistenceException pe) {
               String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
               throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
           }
       }
    
    
}
