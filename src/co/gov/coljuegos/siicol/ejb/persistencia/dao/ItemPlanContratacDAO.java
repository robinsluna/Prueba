package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContratacionCdpVO;

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
public class ItemPlanContratacDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public ItemPlanContratacDAO() {
        recursos = new Recursos();
    }

    public SiiItemPlanContratac buscarItemPlanContratacPorId(Long idItemPlanContratac) throws ExcepcionDAO {
        SiiItemPlanContratac localItemPlanContratac = null;
        try {
            localItemPlanContratac =
                (SiiItemPlanContratac) manager.find(SiiItemPlanContratac.class, idItemPlanContratac);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        }
        return localItemPlanContratac;
    }

    public SiiItemPlanContratac insertarItemPlanContratac(SiiItemPlanContratac itemPlanContratac) throws ExcepcionDAO {
        try {
            manager.persist(itemPlanContratac);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        } catch (Exception ex) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(ex.getMessage(), "ItemPlanContratacDAO");
        }
        return itemPlanContratac;
    }

    public SiiItemPlanContratac actualizarItemPlanContractac(SiiItemPlanContratac itemPlanContratac) throws ExcepcionDAO {
        try {
            manager.merge(itemPlanContratac);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        }
        return itemPlanContratac;
    }

    public List<SiiItemPlanContratac> buscarTodoItemPlanContratac() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiItemPlanContratac o ORDER BY o.ipcDescripcion DESC");
            //sql.append("where o.itemPlanContratac.ipcCodigo=:codigo");
            Query query = manager.createQuery(sql.toString());
            //query.setParameter("codigo", itemPlanContratac.getIpcCodigo());
            List<SiiItemPlanContratac> listaItemPlanContratac = query.getResultList();
            return listaItemPlanContratac;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        }
    }

    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorSEMArea(Long idArea,
                                                                             Long anoVigencia) throws ExcepcionDAO {
        List<ItemPlanContratacionCdpVO> listaItemPlanContratacionCdpVo = new ArrayList<ItemPlanContratacionCdpVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT distinct ipc.ipc_codigo, ipc.ipc_descripcion, ipc.aco_codigo, ipc.ipc_valor_est, ");
            sql.append("ipc.ipc_fecha_ini_proc, ipc.ipc_fecha_ini_con, ipc.pcn_codigo ");
            sql.append("FROM sii_solicitud_est_mercado sem ");
            sql.append("INNER JOIN sii_item_plan_contratac ipc ON (sem.ipc_codigo = ipc.ipc_codigo) ");
            sql.append("INNER JOIN sii_plan_contratacion pc ON (ipc.pcn_codigo = pc.pcn_codigo) ");
            sql.append("WHERE ipc.aco_codigo = #unArea ");
            sql.append("AND  pc.pcn_vigencia = #unAnoVigencia ");
            sql.append("ORDER BY  ipc.ipc_descripcion ASC ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("unArea", idArea);
            query.setParameter("unAnoVigencia", anoVigencia);
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                ItemPlanContratacionCdpVO itemPlanContratacionCdpVo = new ItemPlanContratacionCdpVO();
                itemPlanContratacionCdpVo.setIpc_codigo(((BigDecimal) object[0]).longValue());
                itemPlanContratacionCdpVo.setIpc_descripcion((String) object[1]);
                itemPlanContratacionCdpVo.setAco_codigo(((BigDecimal) object[2]).longValue());
                itemPlanContratacionCdpVo.setIpc_valor_est(((BigDecimal) object[3]).longValue());
                itemPlanContratacionCdpVo.setIpc_fecha_ini_proc((Date) object[4]);
                itemPlanContratacionCdpVo.setIpc_fecha_ini_con((Date) object[5]);
                itemPlanContratacionCdpVo.setPcn_codigo(((BigDecimal) object[6]).longValue());
                listaItemPlanContratacionCdpVo.add(itemPlanContratacionCdpVo);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ItemPlanContratacDAO");
        }
        return listaItemPlanContratacionCdpVo;
    }

    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorArea(Long idArea,
                                                                          Long anoVigencia) throws ExcepcionDAO {
        List<ItemPlanContratacionCdpVO> listaItemPlanContratacionCdpVo = new ArrayList<ItemPlanContratacionCdpVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ipc.ipc_codigo, ipc.ipc_descripcion, ipc.aco_codigo, ipc.ipc_valor_est, ");
            sql.append("ipc.ipc_fecha_ini_proc, ipc.ipc_fecha_ini_con, ipc.pcn_codigo ");
            sql.append("FROM sii_item_plan_contratac ipc ");
            sql.append("INNER JOIN sii_plan_contratacion pc ON (ipc.pcn_codigo = pc.pcn_codigo) ");
            sql.append("WHERE ipc.aco_codigo = #unArea ");
            sql.append("AND pc.pcn_vigencia = #unAnoVigencia ");
            sql.append("ORDER BY  ipc.ipc_descripcion ASC ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("unArea", idArea);
            query.setParameter("unAnoVigencia", anoVigencia);
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                ItemPlanContratacionCdpVO itemPlanContratacionCdpVo = new ItemPlanContratacionCdpVO();
                itemPlanContratacionCdpVo.setIpc_codigo(((BigDecimal) object[0]).longValue());
                itemPlanContratacionCdpVo.setIpc_descripcion((String) object[1]);
                itemPlanContratacionCdpVo.setAco_codigo(((BigDecimal) object[2]).longValue());
                itemPlanContratacionCdpVo.setIpc_valor_est(((BigDecimal) object[3]).longValue());
                itemPlanContratacionCdpVo.setIpc_fecha_ini_proc((Date) object[4]);
                itemPlanContratacionCdpVo.setIpc_fecha_ini_con((Date) object[5]);
                itemPlanContratacionCdpVo.setPcn_codigo(((BigDecimal) object[6]).longValue());
                listaItemPlanContratacionCdpVo.add(itemPlanContratacionCdpVo);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ItemPlanContratacDAO");
        }
        return listaItemPlanContratacionCdpVo;
    }

    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorSEM(Long anoVigencia) throws ExcepcionDAO {
        List<ItemPlanContratacionCdpVO> listaItemPlanContratacionCdpVo = new ArrayList<ItemPlanContratacionCdpVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT distinct ipc.ipc_codigo, ipc.ipc_descripcion, ipc.aco_codigo, ipc.ipc_valor_est, ");
            sql.append("ipc.ipc_fecha_ini_proc, ipc.ipc_fecha_ini_con, ipc.pcn_codigo ");
            sql.append("FROM sii_item_plan_contratac ipc ");
            sql.append("INNER JOIN sii_plan_contratacion pc ON (ipc.pcn_codigo = pc.pcn_codigo) ");
            sql.append("WHERE pc.pcn_vigencia = #unAnoVigencia ");
            sql.append("ORDER BY  ipc.ipc_descripcion ASC ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("unAnoVigencia", anoVigencia);
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                ItemPlanContratacionCdpVO itemPlanContratacionCdpVo = new ItemPlanContratacionCdpVO();
                itemPlanContratacionCdpVo.setIpc_codigo(((BigDecimal) object[0]).longValue());
                itemPlanContratacionCdpVo.setIpc_descripcion((String) object[1]);
                itemPlanContratacionCdpVo.setAco_codigo(((BigDecimal) object[2]).longValue());
                itemPlanContratacionCdpVo.setIpc_valor_est(((BigDecimal) object[3]).longValue());
                itemPlanContratacionCdpVo.setIpc_fecha_ini_proc((Date) object[4]);
                itemPlanContratacionCdpVo.setIpc_fecha_ini_con((Date) object[5]);
                itemPlanContratacionCdpVo.setPcn_codigo(((BigDecimal) object[6]).longValue());
                listaItemPlanContratacionCdpVo.add(itemPlanContratacionCdpVo);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ItemPlanContratacDAO");
        }
        return listaItemPlanContratacionCdpVo;
    }

    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorVigencia(Long anoVigencia) throws ExcepcionDAO {
        List<ItemPlanContratacionCdpVO> listaItemPlanContratacionCdpVo = new ArrayList<ItemPlanContratacionCdpVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ipc.ipc_codigo, ipc.ipc_descripcion, ipc.aco_codigo, ipc.ipc_valor_est, ");
            sql.append("ipc.ipc_fecha_ini_proc, ipc.ipc_fecha_ini_con, ipc.pcn_codigo ");
            sql.append("FROM sii_item_plan_contratac ipc ");
            sql.append("INNER JOIN sii_plan_contratacion pc ON (ipc.pcn_codigo = pc.pcn_codigo) ");
            sql.append("WHERE pc.pcn_vigencia = #unAnoVigencia ");
            sql.append("ORDER BY  ipc.ipc_descripcion ASC ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("unAnoVigencia", anoVigencia);
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                ItemPlanContratacionCdpVO itemPlanContratacionCdpVo = new ItemPlanContratacionCdpVO();
                itemPlanContratacionCdpVo.setIpc_codigo(((BigDecimal) object[0]).longValue());
                itemPlanContratacionCdpVo.setIpc_descripcion((String) object[1]);
                itemPlanContratacionCdpVo.setAco_codigo(((BigDecimal) object[2]).longValue());
                itemPlanContratacionCdpVo.setIpc_valor_est(((BigDecimal) object[3]).longValue());
                itemPlanContratacionCdpVo.setIpc_fecha_ini_proc((Date) object[4]);
                itemPlanContratacionCdpVo.setIpc_fecha_ini_con((Date) object[5]);
                itemPlanContratacionCdpVo.setPcn_codigo(((BigDecimal) object[6]).longValue());
                listaItemPlanContratacionCdpVo.add(itemPlanContratacionCdpVo);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ItemPlanContratacDAO");
        }
        return listaItemPlanContratacionCdpVo;
    }

    public SiiItemPlanContratac buscarItemPlanContratacPorNombrePorIdPlan(String nombreItemPlan,
                                                                          Long idPlan) throws ExcepcionDAO {
        SiiItemPlanContratac siiItemPlanContratac = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select ipc from SiiItemPlanContratac ipc");
            sql.append(" where ipc.siiPlanContratacion.pcnCodigo = :pcnCodigo");
            sql.append(" and ipc.ipcNombre = :nombreItemPlan");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pcnCodigo", idPlan);
            query.setParameter("nombreItemPlan", nombreItemPlan);
            List<SiiItemPlanContratac> listaItemPlanContratac = query.getResultList();
            if (listaItemPlanContratac != null && listaItemPlanContratac.size() > 0) {
                siiItemPlanContratac = listaItemPlanContratac.get(0);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + ": " + pe.getMessage(), "ItemPlanContratacDAO");
        } catch (Exception ex) {
            throw new ExcepcionDAO("Error general DAO: " + ex.getMessage(), "ItemPlanContratacDAO");
        }
        return siiItemPlanContratac;
    }

    public List<SiiItemPlanContratac> buscarItemPlanContratacVigencia(Long anoVigencia) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            /*
            sql.append("select o from SiiItemPlanContratac o INNER JOIN SiiPlanContratacion pc " +
                "ON (o.pcnCodigo = pc.pcnCodigo) WHERE pc.pcnVigencia = #unAnoVigencia " +
                "ORDER BY o.ipcDescripcion DESC");
            */
            sql.append("select o from SiiItemPlanContratac o " +
                       "WHERE o.siiPlanContratacion.pcnVigencia = :unAnoVigencia " + "ORDER BY o.ipcCodigo ");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("unAnoVigencia", anoVigencia);
            List<SiiItemPlanContratac> listaItemPlanContratac = query.getResultList();
            return listaItemPlanContratac;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        }
    }

    public List<SiiItemPlanContratac> itemsPlanContratacionPorModificacion(Long mpcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o from SiiItemPlanContratac o WHERE o.siiModificacionPlanCont.mpcCodigo=:mpcCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mpcCodigo", mpcCodigo);
            return query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        }
    }

    public void borrarItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) throws ExcepcionDAO {
        try {
            manager.remove(siiItemPlanContratac); 
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ItemPlanContratacDAO");
        } catch (Exception ex) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(ex.getMessage(), "ItemPlanContratacDAO");
        }
    }
}


