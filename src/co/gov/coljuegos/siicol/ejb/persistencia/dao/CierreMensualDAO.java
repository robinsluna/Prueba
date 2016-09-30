package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreContable;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class CierreMensualDAO {


    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public CierreMensualDAO() {
        recursos = new Recursos();
    }

    public SiiCierreContable insertarCierreContable(SiiCierreContable siiCierreContable) throws ExcepcionDAO {
        try {
            manager.persist(siiCierreContable);
            manager.flush();
            return siiCierreContable;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CierreMensualDAO");
        }
    }

    public SiiCierreContable actualizarCierreContable(SiiCierreContable siiCierreContable) throws ExcepcionDAO {
        try {
            manager.merge(siiCierreContable);
            manager.flush();
            return siiCierreContable;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CierreMensualDAO");
        }
    }

    public List<SiiCierreContable> buscarTodoCierreContable() throws ExcepcionDAO {
        try {
            List<SiiCierreContable> listaSiiCierreContable = new ArrayList();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT s FROM SiiCierreContable s order by s.cicCodigo desc ");
            Query query = manager.createQuery(sql.toString());
            listaSiiCierreContable = query.getResultList();
            return listaSiiCierreContable;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public SiiCierreContable buscarCierreContablePorId(Long idCierre) throws ExcepcionDAO {
        SiiCierreContable siiCierreContable = new SiiCierreContable();
        try {
            siiCierreContable = manager.find(SiiCierreContable.class, idCierre);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CierreMensualDAO");
        }
        return siiCierreContable;

    }


    /**
     * Realiza la validaci&oacute;n para determinar si el mes asociado a la Fecha especificada ha sido CERRADO.
     * @param fecha - Fecha que se desea validar.
     * @return ¿Mes Cerrado?
     * @throws ExcepcionDAO
     */
    public boolean isMesCerrado(Date fecha) throws ExcepcionDAO {
        boolean cerrado = false;

        if (fecha != null) {
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fecha);
                Integer mes = calendar.get(Calendar.MONTH) + 1;
                Integer vigencia = calendar.get(Calendar.YEAR);

                if (mes != null && vigencia != null) {
                    StringBuilder sql = new StringBuilder();
                    sql.append("SELECT COUNT(*) FROM SII_CIERRE_CONTABLE ");
                    sql.append("WHERE mes_codigo = #mes ");
                    sql.append("AND cic_vigencia = #vigencia ");
                    sql.append("AND CIC_FECHA_C_CONT IS NOT NULL ");

                    Query query = manager.createNativeQuery(sql.toString());
                    query.setParameter("mes", mes);
                    query.setParameter("vigencia", vigencia);

                    BigDecimal result = (BigDecimal) query.getSingleResult();
                    cerrado = result != null && result.compareTo(new BigDecimal(0)) > 0;
                }
            } catch (NoResultException e) {
                cerrado = false;
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }

        return (cerrado);
    }


    public void insertarDetalleCierre(Integer vigencia, Integer mes, Long cierre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO sii_detalle_cierre_cont\n" + 
            "SELECT nvl((select max(dec_codigo)  from sii_detalle_cierre_cont),0) +\n" + 
            "  rownum,\n" + 
            "  #cierre,\n" + 
            "  SUM(DEC_SALDO) saldo,\n" + 
            "  last_day(to_date(TO_CHAR(#vigencia)\n" + 
            "  ||lpad(#mes,2,'0')\n" + 
            "  ||TO_CHAR('01'),'yyyymmdd')) fecha_c_cont,\n" + 
            "  CCO_CODIGO,\n" + 
            "  PER_CODIGO\n" + 
            "FROM\n" + 
            "  (SELECT ALL cic.CIC_VIGENCIA,\n" + 
            "    cic.MES_CODIGO,\n" + 
            "    dc.CCO_CODIGO,\n" + 
            "    dc.PER_CODIGO,\n" + 
            "    dc.DEC_SALDO\n" + 
            "  FROM sii_cierre_contable cic\n" + 
            "  INNER JOIN sii_detalle_cierre_cont dc\n" + 
            "  ON cic.CIC_CODIGO      = dc.CIC_CODIGO\n" + 
            "  WHERE cic.CIC_VIGENCIA = extract (YEAR FROM add_months(to_date(TO_CHAR(#vigencia)\n" + 
            "    ||lpad(#mes,2,'0')\n" + 
            "    ||TO_CHAR('01'),'yyyymmdd'),-1))\n" + 
            "  AND cic.MES_CODIGO = extract (MONTH FROM add_months(to_date(TO_CHAR(#vigencia)\n" + 
            "    ||lpad(#mes,2,'0')\n" + 
            "    ||TO_CHAR('01'),'yyyymmdd'),-1))\n" + 
            "  UNION ALL\n" + 
            "  SELECT ALL Extract(YEAR FROM dco.DCO_FECHA_OPER) vigencia,\n" + 
            "    Extract(MONTH FROM dco.DCO_FECHA_OPER) mes ,\n" + 
            "    imc.CCO_CODIGO,\n" + 
            "    imc.PER_CODIGO,\n" + 
            "    imc.IMC_VALOR * DECODE(imc.IMC_TIPO_MOVIM,'D',1,'C',-1)\n" + 
            "  FROM SII_imputacion_contable imc\n" + 
            "  LEFT JOIN sii_documento_contable dco\n" + 
            "  ON imc.DCO_CODIGO                          = dco.DCO_CODIGO\n" + 
            "  WHERE imc.IMC_ESTADO                       = 'A'\n" + 
            "  AND Extract(YEAR FROM dco.DCO_FECHA_OPER)  = #vigencia\n" + 
            "  AND Extract(MONTH FROM dco.DCO_FECHA_OPER) = #mes\n" + 
            "  )\n" + 
            "GROUP BY #cierre,\n" + 
            "  rownum,\n" + 
            "  CIC_VIGENCIA,\n" + 
            "  MES_CODIGO,\n" + 
            "  CCO_CODIGO,\n" + 
            "  PER_CODIGO\n" + 
            "HAVING SUM(DEC_SALDO) <> 0\n" + 
            "ORDER BY #cierre,\n" + 
            "  rownum,\n" + 
            "  CIC_VIGENCIA,\n" + 
            "  MES_CODIGO,\n" + 
            "  CCO_CODIGO,\n" + 
            "  PER_CODIGO\n" + 
            "  \n");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("cierre", cierre);
            query.setParameter("vigencia", vigencia);
            query.setParameter("mes", mes);
            query.executeUpdate();
            
        //} catch (PersistenceException pe) {
        } catch (Throwable pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }

    public String proveedoresNulosEnCierreMensual(Integer vigencia, Integer mes) throws ExcepcionDAO {
        try { 
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT listagg( CCO_CODIGO ,',') within GROUP (\n" + 
            "ORDER BY cic_vigencia)\n" + 
            "FROM\n" + 
            "  (SELECT DISTINCT cic.CIC_VIGENCIA,\n" + 
            "    cic.MES_CODIGO,\n" + 
            "    dc.CCO_CODIGO,\n" + 
            "    dc.PER_CODIGO\n" + 
            "  FROM sii_cierre_contable cic\n" + 
            "  INNER JOIN sii_detalle_cierre_cont dc\n" + 
            "  ON cic.CIC_CODIGO      = dc.CIC_CODIGO\n" + 
            "  WHERE cic.CIC_VIGENCIA = extract (YEAR FROM add_months(to_date(TO_CHAR(#vigencia)\n" + 
            "    ||lpad(#mes,2,'0')\n" + 
            "    ||TO_CHAR('01'),'yyyymmdd'),-1))\n" + 
            "  AND cic.MES_CODIGO = extract (MONTH FROM add_months(to_date(TO_CHAR(#vigencia)\n" + 
            "    ||lpad(#mes,2,'0')\n" + 
            "    ||TO_CHAR('01'),'yyyymmdd'),-1))\n" + 
            "  UNION\n" + 
            "  SELECT DISTINCT Extract(YEAR FROM dco.DCO_FECHA_OPER) vigencia,\n" + 
            "    Extract(MONTH FROM dco.DCO_FECHA_OPER) mes ,\n" + 
            "    imc.CCO_CODIGO,\n" + 
            "    imc.PER_CODIGO\n" + 
            "  FROM SII_imputacion_contable imc\n" + 
            "  LEFT JOIN sii_documento_contable dco\n" + 
            "  ON imc.DCO_CODIGO                          = dco.DCO_CODIGO\n" + 
            "  WHERE imc.IMC_ESTADO                       = 'A'\n" + 
            "  AND Extract(YEAR FROM dco.DCO_FECHA_OPER)  = #vigencia\n" + 
            "  AND Extract(MONTH FROM dco.DCO_FECHA_OPER) = #mes\n" + 
            "  )\n" + 
            "WHERE per_codigo IS NULL\n" + 
            "ORDER BY \n" + 
            "  rownum,\n" + 
            "  CIC_VIGENCIA,\n" + 
            "  MES_CODIGO,\n" + 
            "  CCO_CODIGO,\n" + 
            "  PER_CODIGO ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("vigencia", vigencia);
            query.setParameter("mes", mes);
            return (String) query.getResultList().get(0);            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

}
