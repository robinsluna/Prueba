package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModPlanConItemPlanDetRub;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ModPlanConItemPlanDetRubDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ModPlanConItemPlanDetRubDAO() {
        recursos = new Recursos();
    }

    public SiiModPlanConItemPlanDetRub insertarModPlanConItemPlanDetRub(SiiModPlanConItemPlanDetRub modPlanConItemPlanDetRub) throws ExcepcionDAO {
        SiiModPlanConItemPlanDetRub modDetRubPrevio =
            existeRegistro(modPlanConItemPlanDetRub.getSiiModificacionPlanCont().getMpcCodigo(),
                           modPlanConItemPlanDetRub.getSiiItemPlanContDetRubDes().getIdrCodigo(), modPlanConItemPlanDetRub.getMidTipo());
        if(modDetRubPrevio == null) {
            try {
                manager.persist(modPlanConItemPlanDetRub);
                manager.flush();
                return modPlanConItemPlanDetRub;

            } catch(PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModPlanConItemPlanDetRubDAO");
            }
        }
        else {
            modDetRubPrevio.setMidActivo("S");
            modDetRubPrevio.setMidTipo(modPlanConItemPlanDetRub.getMidTipo());
            modDetRubPrevio.setMidValor(modPlanConItemPlanDetRub.getMidValor());
            return actualizarModPlanConItemPlanDetRub(modDetRubPrevio);
        }

    }

    public SiiModPlanConItemPlanDetRub actualizarModPlanConItemPlanDetRub(SiiModPlanConItemPlanDetRub modPlanConItemPlanDetRub) throws ExcepcionDAO {
        try {
            manager.merge(modPlanConItemPlanDetRub);
            manager.flush();
            return modPlanConItemPlanDetRub;

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModPlanConItemPlanDetRubDAO");
        }
    }

    public SiiModPlanConItemPlanDetRub buscarModPlanConItemPlanDetRubPorId(Long midCodigo) throws ExcepcionDAO {
        SiiModPlanConItemPlanDetRub siiModPlanConItemPlanDetRub = null;
        try {
            siiModPlanConItemPlanDetRub = (SiiModPlanConItemPlanDetRub) manager.find(SiiModPlanConItemPlanDetRub.class, midCodigo);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModPlanConItemPlanDetRubDAO");
        }
        return siiModPlanConItemPlanDetRub;

    }


    public List<SiiModPlanConItemPlanDetRub> detRubrosPorModPlan(Long mpcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModPlanConItemPlanDetRub o WHERE o.siiModificacionPlanCont.mpcCodigo = :mpcCodigo AND o.midActivo='S'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mpcCodigo", mpcCodigo);
            List<SiiModPlanConItemPlanDetRub> modPlanConItemPlanDetRubList = query.getResultList();
            return modPlanConItemPlanDetRubList;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionRpDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ModificacionRpDAO");

        }
    }

    public List<SiiModPlanConItemPlanDetRub> detRubrosModPorItemDetRubPorItemPlan(Long idrCodigo, Long ipcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiItemPlanContDetRub o " + "WHERE o.idrCodigo = :idrCodigo AND o.siiItemPlanContratac.siiModificacionPlanCont.siiEstadoModifPlanCont.emoNombre='AUTORIZADO' " +
                       "AND o.siiItemPlanContratac.siiModificacionPlanCont.mpcCodigo = :mpcCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idrCodigo", idrCodigo);
            query.setParameter("mpcCodigo", ipcCodigo);
            List<SiiModPlanConItemPlanDetRub> modPlanConItemPlanDetRubList = query.getResultList();
            return modPlanConItemPlanDetRubList;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionRpDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ModificacionRpDAO");

        }
    }

    public void eliminarModPlanConItemPlanDetRub(Long midCodigo) throws ExcepcionDAO {
        try {
            SiiModPlanConItemPlanDetRub modDetRub = buscarModPlanConItemPlanDetRubPorId(midCodigo);
            modDetRub.setMidActivo("N");
            actualizarModPlanConItemPlanDetRub(modDetRub);

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModPlanConItemPlanDetRubDAO");
        }
    }

    public void eliminarModPlanConItemPlanDetRub(SiiModPlanConItemPlanDetRub modPlanConItemPlanDetRub) throws ExcepcionDAO {
        try {
            manager.remove(modPlanConItemPlanDetRub);
            manager.flush();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModPlanConItemPlanDetRubDAO");
        }
    }

    private SiiModPlanConItemPlanDetRub existeRegistro(Long mpcCodigo, Long idrCodigo, String midTipo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModPlanConItemPlanDetRub o WHERE o.siiModificacionPlanCont.mpcCodigo = :mpcCodigo AND o.siiItemPlanContDetRubDes.idrCodigo=:idrCodigo AND o.midTipo=:midTipo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mpcCodigo", mpcCodigo);
            query.setParameter("idrCodigo", idrCodigo);
            query.setParameter("midTipo", midTipo);
            return (SiiModPlanConItemPlanDetRub) query.getSingleResult();
        } catch(NoResultException nre) {
            return null;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionRpDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ModificacionRpDAO");

        }
    }
}
