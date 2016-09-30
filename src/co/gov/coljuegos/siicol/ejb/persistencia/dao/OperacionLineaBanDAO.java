package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperacionLineaBan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaRequisitosPol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoLineaBan;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.ValidacionInteresVO;

import java.math.BigDecimal;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class OperacionLineaBanDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public OperacionLineaBanDAO() {
        super();
    }

    /**
     *Metodo encargado de hacer el registro en la base de datos de una operacion en linea del banco por medio del web services
     * @author David Tafur
     * @param siiOperacionLineaBan
     * @return
     * @throws ExcepcionDAO
     */
    public SiiOperacionLineaBan insertarSiiOperacionLineaBan(SiiOperacionLineaBan siiOperacionLineaBan) throws ExcepcionDAO {
        try {
            manager.persist(siiOperacionLineaBan);
            manager.flush();
            return siiOperacionLineaBan;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " " + pe.getMessage(), "OperacionLineaBanDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OperacionLineaBanDAO");
        }

    }

    /**
     *Metodo encargado de hacer la actualizacion de una operacion en linea del banco por medio del web services
     * @author David Tafur
     * @param siiOperacionLineaBan
     * @return
     * @throws ExcepcionDAO
     */
    public SiiOperacionLineaBan actualizarSiiOperacionLineaBan(SiiOperacionLineaBan siiOperacionLineaBan) throws ExcepcionDAO {
        try {
            manager.merge(siiOperacionLineaBan);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OperacionLineaBanDAO");
        }
        return siiOperacionLineaBan;
    }
    
    
   
    
    
    
}
