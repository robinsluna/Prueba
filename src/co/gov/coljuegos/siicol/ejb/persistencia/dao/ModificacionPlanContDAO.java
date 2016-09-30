package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionPlanCont;
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
public class ModificacionPlanContDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ModificacionPlanContDAO() {
        recursos = new Recursos();
    }

    public List<SiiModificacionPlanCont> buscarTrasladosPlanContEnTramite() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModificacionPlanCont o WHERE o.siiEstadoModifPlanCont.emoNombre <>'ANULADO' ORDER BY o.mpcConsecutivo DESC");
            Query query = manager.createQuery(sql.toString());
            return query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionPlanContDAO");
        }
    }   

    public SiiModificacionPlanCont insertarModifPlanCont(SiiModificacionPlanCont siiModificacionPlanCont) throws ExcepcionDAO {
        try {
            manager.persist(siiModificacionPlanCont); 
            manager.flush(); 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionCdpDAO");
            
        }
        return siiModificacionPlanCont;
    }
    
        public SiiModificacionPlanCont actualizarModificacionPlanCont(SiiModificacionPlanCont siiModificacionPlanCont) throws ExcepcionDAO {
            try {
                siiModificacionPlanCont = manager.merge(siiModificacionPlanCont);
                manager.flush();
                return siiModificacionPlanCont;
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionPlanContDAO");
            }
        }
    

    public SiiModificacionPlanCont buscarModificacionPlanContPorId(Long mpcCodigo) throws ExcepcionDAO {
        SiiModificacionPlanCont siiModificacionPlanCont = null;
        try {
            siiModificacionPlanCont = (SiiModificacionPlanCont) manager.find(SiiModificacionPlanCont.class, mpcCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionPlanContDAO");
        }
        return siiModificacionPlanCont;
        }


    public Integer calcularSiguienteConsecutivo(Integer mpcVigencia) throws ExcepcionDAO {
        Integer base = mpcVigencia * 1000000;
        Integer tope = (mpcVigencia + 1)* 1000000 - 1;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT max(o.mpcConsecutivo) " +
                "FROM SiiModificacionPlanCont o " +
                "WHERE o.mpcConsecutivo BETWEEN :base AND :tope");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("base", base);
            query.setParameter("tope", tope);
            Integer consecutivo = (Integer) query.getSingleResult();
            if (consecutivo == null || consecutivo < base) {
                consecutivo = base;
            }
            return consecutivo + 1;
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionPlanContDAO");
        }
    }
}

