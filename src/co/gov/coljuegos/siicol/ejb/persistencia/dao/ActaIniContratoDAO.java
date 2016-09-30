package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaIniContrato;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.ActaIniContratoVO;

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

public class ActaIniContratoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ActaIniContratoDAO() {
        recursos = new Recursos();
    }

    public SiiActaIniContrato buscarActaIniContratoPorId(Long id) throws ExcepcionDAO {
        SiiActaIniContrato actaIniContrato = null;
        try {
            actaIniContrato = (SiiActaIniContrato) manager.find(SiiActaIniContrato.class, id);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ActaIniContratoDAO");
        }
        return actaIniContrato;
    }

    public SiiActaIniContrato insertarActaIniContrato(SiiActaIniContrato actaIniContrato) throws ExcepcionDAO {
        try {
            manager.persist(actaIniContrato);
            manager.flush();
            return actaIniContrato;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ActaIniContratoDAO");
        }
    }

    public SiiActaIniContrato actualizarActaIniContrato(SiiActaIniContrato actaIniContrato) throws ExcepcionDAO {
        try {
            manager.merge(actaIniContrato);
            manager.flush();
            return actaIniContrato;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ActaIniContratoDAO");
        }
    }

    public SiiActaIniContrato buscarActaIniContratoPorProceso(Long prcCodigo) throws ExcepcionDAO {
        List<SiiActaIniContrato> listaActaIniContrato = new ArrayList<SiiActaIniContrato>();
        SiiActaIniContrato actaIniContrato = new SiiActaIniContrato();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiActaIniContrato o WHERE o.siiProcesoContratacion.prcCodigo = :prcCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("prcCodigo", prcCodigo);
            listaActaIniContrato = query.getResultList();
            if (listaActaIniContrato.size() > 0)
                actaIniContrato = listaActaIniContrato.get(0);
            else
                actaIniContrato = null;
            return actaIniContrato;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ActaIniContratoDAO");
        }

    }

    public ActaIniContratoVO guardarActaIniContrato(ActaIniContratoVO actaIniContratoVo, boolean cambioEstado) {
        return null;
    }
}
