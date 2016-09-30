package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContDetRub;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.RubroPresupuestalConItemContratacionVigenciaVO;

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

public class ItemPlanContDetRubDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ItemPlanContDetRubDAO() {
        recursos = new Recursos();
    }

    public SiiItemPlanContDetRub buscarItemPlanContDetRubPorId(long idItemPlanContDetRub) throws ExcepcionDAO {
        SiiItemPlanContDetRub itemPlanContDetRub = null;
        try {
            itemPlanContDetRub = (SiiItemPlanContDetRub) manager.find(SiiItemPlanContDetRub.class, idItemPlanContDetRub);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return itemPlanContDetRub;
    }

    public SiiItemPlanContDetRub insertarItemPlanContDetRub(SiiItemPlanContDetRub itemPlanContDetRub) throws ExcepcionDAO {
        try {
            manager.persist(itemPlanContDetRub);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return itemPlanContDetRub;
    }

    public SiiItemPlanContDetRub actualizarItemPlanContDetRub(SiiItemPlanContDetRub itemPlanContDetRub) throws ExcepcionDAO {
        try {
            itemPlanContDetRub = manager.merge(itemPlanContDetRub);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return itemPlanContDetRub;
    }

    public void eliminarItemPlanContDetRub(long idItemPlanContDetRub) throws ExcepcionDAO {
        SiiItemPlanContDetRub itemPlanContDetRub;
        try {
            itemPlanContDetRub = (SiiItemPlanContDetRub) manager.find(SiiItemPlanContDetRub.class, idItemPlanContDetRub);
            manager.remove(itemPlanContDetRub);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public List<SiiItemPlanContratac> buscarTodoItemPlanContXVigencia(Integer vigencia) throws ExcepcionDAO {
        List<SiiItemPlanContratac> listaSiiItemPlanContratac = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiItemPlanContratac o");
            sql.append(" where o.siiPlanContratacion.pcnVigencia >= :vigencia");
            sql.append(" order by o.ipcDescripcion asc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", vigencia);

            listaSiiItemPlanContratac = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiItemPlanContratac;
    }

    public List<RubroPresupuestalConItemContratacionVigenciaVO> buscarRubrosPresupuestalesConItemPlanContratacionVigencia(Integer vigencia) throws ExcepcionDAO {
        List<RubroPresupuestalConItemContratacionVigenciaVO> listaRubroPresupuestalConItemContratacionVigenciaVo = new ArrayList<RubroPresupuestalConItemContratacionVigenciaVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sipcdr.idr_codigo, sipcdr.ipc_codigo, sdr.dru_codigo, sipcdr.idr_valor, ");
            sql.append(" sdr.interno, sdr.dff_codigo, pr.costos");
            sql.append(" FROM pr_rubro pr");
            sql.append(" INNER JOIN sii_detalle_rubro sdr on (pr.interno = sdr.interno) AND (pr.vigencia = sdr.vigencia)");
            sql.append(" INNER JOIN sii_item_plan_cont_det_rub sipcdr ON (sipcdr.dru_codigo = sdr.dru_codigo)");
            sql.append(" WHERE  pr.vigencia= #vigencia");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("vigencia", vigencia);
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                RubroPresupuestalConItemContratacionVigenciaVO rpicvVo = new RubroPresupuestalConItemContratacionVigenciaVO();
                rpicvVo.setIdr_codigo(((BigDecimal) object[0]).longValue());
                rpicvVo.setIpc_codigo(((BigDecimal) object[1]).longValue());
                rpicvVo.setDru_codigo(((BigDecimal) object[2]).longValue());
                rpicvVo.setIdr_valor(((BigDecimal) object[3]).longValue());
                rpicvVo.setInterno(((BigDecimal) object[4]).longValue());
                rpicvVo.setDff_codigo(((BigDecimal) object[5]).longValue());
                rpicvVo.setCostos(((BigDecimal) object[6]).longValue());
                listaRubroPresupuestalConItemContratacionVigenciaVo.add(rpicvVo);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaRubroPresupuestalConItemContratacionVigenciaVo;
    }


    public List<SiiItemPlanContDetRub> buscarItemsPlanContDetRub(Long ipcCodigo) throws ExcepcionDAO {
        List<SiiItemPlanContDetRub> listaSiiItemPlanContDetRub = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiItemPlanContDetRub o");
            sql.append(" where o.siiItemPlanContratac.ipcCodigo = :ipcCodigo");
            sql.append(" order by o.siiItemPlanContratac.ipcDescripcion asc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("ipcCodigo", ipcCodigo);
            listaSiiItemPlanContDetRub = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiItemPlanContDetRub;
    }

    public BigDecimal presupuestoItemPlan(Long ipcCodigo) throws ExcepcionDAO {
        BigDecimal presupuesto = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sum(o.idrValor) FROM SiiItemPlanContDetRub o");
            sql.append(" where o.siiItemPlanContratac.planContratacionVo.ipcCodigo = :ipcCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("ipcCodigo", ipcCodigo);
            presupuesto = (BigDecimal) query.getSingleResult();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return presupuesto;
    }

    public BigDecimal presupuestoItemPlanPorProcesoContratacion(Long prcCodigo) throws ExcepcionDAO {
        BigDecimal presupuesto = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(idr.IDR_VALOR)\n" + "FROM sii_Item_Plan_Cont_Det_Rub idr\n" + "INNER JOIN sii_item_plan_contratac ipc\n" + "ON idr.IPC_CODIGO = ipc.IPC_CODIGO\n" +
                       "INNER JOIN sii_solicitud_est_mercado sem\n" + "ON ipc.IPC_CODIGO = sem.IPC_CODIGO\n" + "INNER JOIN sii_proceso_contratacion prc\n" + "ON sem.PRC_CODIGO = prc.PRC_CODIGO\n" +
                       "where prc.prc_codigo = #prcCodigo");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("prcCodigo", prcCodigo);
            presupuesto = (BigDecimal) query.getSingleResult();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return presupuesto;
    }

}

