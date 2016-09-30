package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaRequisitosPol;
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
public class RequisitosPolizaPolDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public RequisitosPolizaPolDAO() {
        recursos = new Recursos();
    }

    public List<SiiPolizaRequisitosPol> buscarRequisitosPorPolizaContrat(Long pccCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiPolizaRequisitosPol o JOIN o.siiPolizaContrat pc ");
            sql.append(" WHERE pc.pccCodigo = :pccCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pccCodigo", pccCodigo);
            return query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RequisitosPolizaPolDAO");
        }
    }
    

}
