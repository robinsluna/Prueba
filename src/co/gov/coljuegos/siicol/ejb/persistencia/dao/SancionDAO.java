
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Mario Buc
 * FECHA	: 14-07-2015
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;

import co.gov.coljuegos.siicol.ejb.vo.SolicitudDetalleRubroCdpVO;

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
public class SancionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public SancionDAO() {
        recursos = new Recursos();
    }
    
    public boolean haySancionesXContrato(String contrato) throws ExcepcionDAO{
        
        List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT per_codigo,\n" + 
            "  COP_CODIGO,\n" + 
            "  CON_NUMERO,\n" + 
            "  cop_fecha_lim_pag,\n" + 
            "  resolucion,\n" + 
            "  cop_num_cuota ,\n" + 
            "  ccu_nombre,\n" + 
            "  saldo,\n" + 
            "  tasa,\n" + 
            "  tasa2\n" + 
            "FROM\n" + 
            "  (SELECT per_codigo,\n" + 
            "    COP_CODIGO,\n" + 
            "    CON_NUMERO,\n" + 
            "    cop_fecha_lim_pag,\n" + 
            "    resolucion,\n" + 
            "    cop_num_cuota ,\n" + 
            "    ccu_nombre,\n" + 
            "    CASE\n" + 
            "      WHEN RECAUDO IS NULL\n" + 
            "      THEN valorcuota\n" + 
            "      ELSE saldo\n" + 
            "    END AS saldo,\n" + 
            "    CASE\n" + 
            "      WHEN CCU_TIPO_TASA='SB'\n" + 
            "      THEN\n" + 
            "        (SELECT TIS_TASA\n" + 
            "        FROM SII_TASA_INT_SUPERBAN\n" + 
            "        WHERE CURRENT_DATE BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA\n" + 
            "        )\n" + 
            "      ELSE 0\n" + 
            "    END AS TASA ,\n" + 
            "    CASE\n" + 
            "      WHEN CCU_TIPO_TASA='ILC'\n" + 
            "      THEN\n" + 
            "        (SELECT TIS_TASA\n" + 
            "        FROM SII_TASA_INT_SUPERBAN\n" + 
            "        WHERE CURRENT_DATE BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA\n" + 
            "        )\n" + 
            "      ELSE 0\n" + 
            "    END AS TASA2\n" + 
            "  FROM\n" + 
            "    (\n" + 
            "      \n" + 
            "    SELECT \n" + 
            "          caa.caa_codigo,\n" + 
            "          per.per_codigo,\n" + 
            "          e.cop_codigo,\n" + 
            "          G.CON_NUMERO ,\n" + 
            "          e.cop_fecha_lim_pag,\n" + 
            "          con.CCU_TIPO_TASA,      \n" + 
            "          to_char(caa.CAA_NUM_RESOLUCION)                 AS resolucion,                      \n" + 
            "          e.cop_num_cuota,\n" + 
            "          con.ccu_nombre,      \n" + 
            "          e.cop_valor                            AS valorcuota,\n" + 
            "          SUM( dt.dde_valor_pagado)              AS recaudo,\n" + 
            "          (e.cop_valor-SUM(dt.dde_valor_pagado)) AS saldo\n" + 
            "        FROM SII_CUOTA_OPERADOR E\n" + 
            "        LEFT JOIN sii_detalle_declaracion dt\n" + 
            "        ON e.cop_codigo = dt.cop_codigo\n" + 
            "        INNER JOIN sii_concepto_cuota con\n" + 
            "        ON e.ccu_codigo=con.ccu_codigo\n" + 
            "        inner join SII_CARGA_ACTUACIONES_ADM caa on e.caa_codigo = caa.caa_codigo\n" + 
            "        INNER JOIN sii_operador op\n" + 
            "        ON e.ope_codigo=op.ope_codigo\n" + 
            "        LEFT JOIN SII_CONTRATO G\n" + 
            "        ON G.OPE_CODIGO = op.ope_codigo\n" + 
            "        INNER JOIN sii_persona per\n" + 
            "        ON per.per_codigo                                      = op.per_codigo    \n" + 
            "        WHERE \n" + 
            "        con.ccu_tipo_tasa                                 != 'N/A'\n" + 
            "        AND cop_fecha_lim_pag < sysdate\n" + 
            "        AND G.CON_NUMERO                                       = #contrato   \n" + 
            "        GROUP BY caa.caa_codigo,\n" + 
            "          per.per_codigo,\n" + 
            "          e.cop_codigo,\n" + 
            "          g.con_numero,\n" + 
            "          e.cop_fecha_lim_pag,\n" + 
            "          con.CCU_TIPO_TASA,          \n" + 
            "          caa.CAA_NUM_RESOLUCION, \n" + 
            "          e.cop_num_cuota,\n" + 
            "          con.ccu_nombre,      \n" + 
            "          e.cop_valor    \n" + 
            "    union\n" + 
            "\n" + 
            "    SELECT inc.icn_codigo,\n" + 
            "          per.per_codigo,\n" + 
            "          e.cop_codigo,\n" + 
            "          G.CON_NUMERO ,\n" + 
            "          e.cop_fecha_lim_pag,\n" + 
            "          con.CCU_TIPO_TASA,      \n" + 
            "          ric.RCO_NUMERO_RESOL                  AS resolucion,                 \n" + 
            "          e.cop_num_cuota,\n" + 
            "          con.ccu_nombre,          \n" + 
            "          e.cop_valor                            AS valorcuota,\n" + 
            "          SUM( dt.dde_valor_pagado)              AS recaudo,\n" + 
            "          (e.cop_valor-SUM(dt.dde_valor_pagado)) AS saldo\n" + 
            "        FROM SII_CUOTA_OPERADOR E\n" + 
            "        LEFT JOIN sii_detalle_declaracion dt\n" + 
            "        ON e.cop_codigo = dt.cop_codigo\n" + 
            "        INNER JOIN sii_concepto_cuota con\n" + 
            "        ON e.ccu_codigo=con.ccu_codigo\n" + 
            "        inner join sii_incumplimiento_contr inc on inc.icn_codigo = e.icn_codigo\n" + 
            "        inner join sii_resolucion_incum_contr ric on inc.rco_codigo_resol = ric.rco_codigo    \n" + 
            "        INNER JOIN sii_operador op\n" + 
            "        ON e.ope_codigo=op.ope_codigo\n" + 
            "        LEFT JOIN SII_CONTRATO G\n" + 
            "        ON G.OPE_CODIGO = op.ope_codigo\n" + 
            "        INNER JOIN sii_persona per\n" + 
            "        ON per.per_codigo                                      = op.per_codigo    \n" + 
            "        WHERE \n" + 
            "        con.ccu_tipo_tasa                                 != 'N/A'\n" + 
            "        AND cop_fecha_lim_pag < sysdate\n" + 
            "        AND G.CON_NUMERO                                       = #contrato    \n" + 
            "        GROUP BY inc.icn_codigo,      \n" + 
            "          per.per_codigo,\n" + 
            "          e.cop_codigo,\n" + 
            "          g.con_numero,\n" + 
            "          e.cop_fecha_lim_pag,\n" + 
            "          ric.RCO_NUMERO_RESOL,\n" + 
            "          e.cop_num_cuota,\n" + 
            "          con.ccu_nombre,      \n" + 
            "          con.CCU_TIPO_TASA,      \n" + 
            "          e.cop_valor    \n" + 
            "      union  \n" + 
            "      SELECT ps.psa_codigo,\n" + 
            "          per.per_codigo,\n" + 
            "          e.cop_codigo,\n" + 
            "          G.CON_NUMERO ,\n" + 
            "          e.cop_fecha_lim_pag,\n" + 
            "          con.CCU_TIPO_TASA,      \n" + 
            "          rps.rem_numero                          AS resolucion,      \n" + 
            "          e.cop_num_cuota,\n" + 
            "          con.ccu_nombre,\n" + 
            "          e.cop_valor                            AS valorcuota,\n" + 
            "          SUM( dt.dde_valor_pagado)              AS recaudo,\n" + 
            "          (e.cop_valor-SUM(dt.dde_valor_pagado)) AS saldo\n" + 
            "        FROM SII_CUOTA_OPERADOR E\n" + 
            "        LEFT JOIN sii_detalle_declaracion dt\n" + 
            "        ON e.cop_codigo = dt.cop_codigo\n" + 
            "        INNER JOIN sii_concepto_cuota con\n" + 
            "        ON e.ccu_codigo=con.ccu_codigo\n" + 
            "        left join sii_proceso_sancionatorio ps on ps.psa_codigo = e.psa_codigo\n" + 
            "        inner join sii_resolucion_proc_sanc rps on ps.rep_codigo_sancion = rps.rep_codigo\n" + 
            "        INNER JOIN sii_operador op\n" + 
            "        ON e.ope_codigo=op.ope_codigo\n" + 
            "        LEFT JOIN SII_CONTRATO G\n" + 
            "        ON G.OPE_CODIGO = op.ope_codigo\n" + 
            "        INNER JOIN sii_persona per\n" + 
            "        ON per.per_codigo                                      = op.per_codigo    \n" + 
            "        WHERE \n" + 
            "        con.ccu_tipo_tasa                                 != 'N/A'\n" + 
            "        AND cop_fecha_lim_pag < sysdate\n" + 
            "        AND G.CON_NUMERO                                       = #contrato     \n" + 
            "        GROUP BY ps.psa_codigo,          \n" + 
            "          per.per_codigo,\n" + 
            "          e.cop_codigo,\n" + 
            "          g.con_numero,\n" + 
            "          e.cop_fecha_lim_pag,\n" + 
            "          con.CCU_TIPO_TASA,          \n" + 
            "          rps.rem_numero,\n" + 
            "          e.cop_num_cuota,\n" + 
            "          con.ccu_nombre,\n" + 
            "          e.cop_valor\n" + 
            "          )\n" + 
            "      )\n" + 
            "WHERE saldo>0");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("contrato", contrato);            
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {                
                for (Object[] object : results) {
                    SiiCuotaOperador siiCuotaOperador= new SiiCuotaOperador();
                    siiCuotaOperador.setCopCodigo(Long.parseLong(((BigDecimal) (object[1])).toString()));
                    listaCuotaOperador.add(siiCuotaOperador);
                }
            }
        
        
        } catch (PersistenceException pe) {
        String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
        throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
        ex.printStackTrace();
        throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        if (listaCuotaOperador != null && listaCuotaOperador.size() > 0) {
        return true;
        } else {
        return false;
        }
        
    }

}