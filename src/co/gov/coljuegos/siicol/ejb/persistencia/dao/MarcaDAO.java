/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 27-12-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMarca;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.AdendaVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminoReferenciaVO;

import java.math.BigDecimal;

import java.util.ArrayList;
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
public class MarcaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public MarcaDAO() {
        recursos = new Recursos();
    }
    
    public SiiMarca buscarMarcaPorCodigo(Long idCodigoMarca) throws ExcepcionDAO {
        SiiMarca retorno = null;
        try {
            retorno = (SiiMarca) manager.find(SiiMarca.class, idCodigoMarca);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MarcaDAO");
        }
        return retorno;

    }
    
    public SiiMarca insertarSiiMarca(SiiMarca marca) throws ExcepcionDAO {
        try {
            manager.persist(marca); 
            manager.flush(); 
            return marca; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MarcaDAO");
        }
    }
    
   
}
