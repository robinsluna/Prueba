/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 30-12-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInvitacionProceso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

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
public class DocumentoTdrDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public DocumentoTdrDAO() {
        recursos = new Recursos();
    }
    
    public SiiDocumentoTdr buscarPorCodigoDocumento(Long idCodigoDoc) throws ExcepcionDAO {
        SiiDocumentoTdr documentoRetorno = null;
        try {
            documentoRetorno = (SiiDocumentoTdr) manager.find(SiiDocumentoTdr.class, idCodigoDoc);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DocumentoTdrDAO");
        }
        return documentoRetorno;

    }
    
    public SiiDocumentoTdr insertarSiiDocumentoTdr(SiiDocumentoTdr documento) throws ExcepcionDAO {
        try {
            manager.persist(documento); 
            manager.flush(); 
            return documento; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DocumentoTdrDAO");
        }
    }
    public List<SiiDocumentoTdr> buscarDocumentosTdrPorCodigoTdr(long codigoTdr) throws ExcepcionDAO {
        List<SiiDocumentoTdr> listaDocumentos = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiDocumentoTdr o INNER JOIN o.siiTerminosReferencia pc WHERE o.siiTerminosReferencia.tdrCodigo = :codigoTdr");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoTdr", codigoTdr);
            listaDocumentos = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "DocumentoTdrDAO");
        }
        return listaDocumentos;
    }
    
    
   
}
