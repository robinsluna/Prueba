/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-10-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumRol;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;
import co.gov.coljuegos.siicol.ejb.vo.OfiLiquidacionSolAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionPrevioVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioRolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

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
public class OficioLiquidacionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public OficioLiquidacionDAO() {
        recursos = new Recursos();
    }

    public SiiOficioLiquidacion buscarPorCodigoOficioLiquidacion(Long idOficioLiquidacion) throws ExcepcionDAO {
        SiiOficioLiquidacion retorno = null;
        try {
            retorno = (SiiOficioLiquidacion) manager.find(SiiOficioLiquidacion.class, idOficioLiquidacion);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        }
        return retorno;

    }

    public SiiOficioLiquidacion insertarSiiOficioLiquidacion(SiiOficioLiquidacion oficioLiquidacion) throws ExcepcionDAO {
        try {
            manager.persist(oficioLiquidacion);
            manager.flush();
            return oficioLiquidacion;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        }
    }

    public SiiOficioLiquidacion actualizarSiiOficioLiquidacion(SiiOficioLiquidacion oficioLiquidacion) throws ExcepcionDAO {
        try {
            manager.merge(oficioLiquidacion);
            manager.flush();
            return oficioLiquidacion;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        }
    }

    public void borrarSiiOficioLiquidacion(Long idOficioLiquidacion) throws ExcepcionDAO {
        SiiOficioLiquidacion oficioBorrar = null;
        try {
            oficioBorrar = manager.find(SiiOficioLiquidacion.class, idOficioLiquidacion);
            manager.remove(oficioBorrar);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        }
    }

    public List<SiiOficioLiquidacion> buscarTodoSiiOficioLiquidacion() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOficioLiquidacion o");
            Query query = manager.createQuery(sql.toString());
            List<SiiOficioLiquidacion> listaOficio = query.getResultList();
            return listaOficio;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        }

    }

    public List<SiiOficioLiquidacion> buscarOficioLiquidacionPorSolicitudAutorizacion(Long sauCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOficioLiquidacion o WHERE o.siiSolicitudAutoriza.sauCodigo = :sauCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            List<SiiOficioLiquidacion> listaOficio = query.getResultList();
            return listaOficio;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        }

    }

    public List<OfiLiquidacionSolAutorizaVO> buscarTodosOficioLiquidacion(UsuarioVO usuarioLogueado) throws ExcepcionDAO {

        List<OfiLiquidacionSolAutorizaVO> miListaOficios = new ArrayList<OfiLiquidacionSolAutorizaVO>();
        boolean isEvaluador = false;
        Long codUsuario = usuarioLogueado.getUsuCodigo();
        try {
            if (usuarioLogueado.getUsuarioRolVoList().size() > 0) {
                for (UsuarioRolVO unRol : usuarioLogueado.getUsuarioRolVoList()) {
                    if (unRol.getRolVo().getRolNombre().equals("CN Evaluador financiero") ||
                        unRol.getRolVo().getRolNombre().equals("CN Administrador")) {
                        isEvaluador = true;
                        break;
                    }
                }
            }

            StringBuilder sql = new StringBuilder();
            sql.append(" select distinct ol.oli_consecutivo,ol.oli_fecha_oficio, sa.edo_codigo, per.per_jur_nombre_largo,Tid.Tid_Nombre_Corto||'-'||sa.sau_nit,eol.eol_nombre,ol.oli_codigo, sa.sau_codigo");
            sql.append(" ,Usu.Usu_Nombre_Usuario,nov.con_codigo");
            sql.append(" from sii_oficio_liquidacion ol Inner Join sii_solicitud_autoriza sa on (ol.sau_codigo = sa.sau_codigo)");
            sql.append(" Inner Join sii_persona per on (sa.sau_nit = per.per_num_identificacion)");
            sql.append(" Inner Join Sii_Tipo_Identificacion tid on (per.tid_codigo=tid.tid_codigo)");
            sql.append(" Inner Join sii_estado_oficio_liq eol on (ol.eol_codigo = eol.eol_codigo)");
            sql.append(" Inner Join Sii_Usuario usu on (sa.usu_codigo = usu.usu_codigo)");
            sql.append(" Inner Join sii_novedad nov on (sa.sau_codigo = nov.sau_codigo)");
            sql.append(" Inner Join Sii_Tipo_Solic_Autoriza tsa on (Sa.Tsa_Codigo = tsa.tsa_codigo) ");
            sql.append(" where tsa.tsa_codigo in (10,20)");
            sql.append(" and UPPER(per.per_tipo_persona)='J'");
            if (!isEvaluador) {
                sql.append(" and sa.usu_codigo =#codUsuario");
            }
            sql.append(" order by ol.oli_consecutivo desc");

            Query query = manager.createNativeQuery(sql.toString());
            if (!isEvaluador) {
                query.setParameter("codUsuario", codUsuario);
            }

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {

                for (Object[] object : results) {
                    OfiLiquidacionSolAutorizaVO ofiLiqVo = new OfiLiquidacionSolAutorizaVO();
                    ofiLiqVo.setConsecutivo(((BigDecimal) object[0]).intValue());
                    ofiLiqVo.setFechaExpedicion((Date) object[1]);
                    ofiLiqVo.setNumeroSiito((String) object[2]);
                    ofiLiqVo.setRazonSocial((String) object[3]);
                    ofiLiqVo.setNit((String) object[4]);
                    ofiLiqVo.setEstado((String) object[5]);
                    ofiLiqVo.setOliCodigo(((BigDecimal) object[6]).longValue());
                    ofiLiqVo.setSauCodigo(((BigDecimal) object[7]).longValue());
                    ofiLiqVo.setNombreUsuario((String) object[8]);
                    if (object[9] != null) {
                        ofiLiqVo.setCodigoContrato(((BigDecimal) object[9]).longValue());
                    }
                    miListaOficios.add(ofiLiqVo);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO");
        }
        return miListaOficios;
    }


    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionPorSolicitud(Long idSolicitud) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaOficiosTipoApuesta = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select p.tapCodigo,SUM(p.cantidad*p.totalInv) cantidad,p.tapNombre,p.valunidad,p.fechaExp,p.nit,");
            sql.append(" p.razonSocial,p.fechaInicio,p.fechaFin,p.meses,p.tipoApuesta,p.numSiito,p.sauCodigo from");
            sql.append(" (select s.tap_codigo tapCodigo,s.tapNombre tapNombre,s.valunidad valunidad,");
            sql.append(" s.codApuesta tipoApuesta, SUM(cantidad) cantidad,CASE WHEN s.invSillas=0 THEN 1 ELSE s.invSillas END totalInv,");
            sql.append(" SUM(cantidad)*s.invSillas totalCantidad,s.fechaExp fechaExp,s.nit nit,s.razonSocial razonSocial,s.fechaInicio fechaInicio,");
            sql.append(" s.fechaFin fechaFin,s.meses meses,s.numSiito numSiito,s.sauCodigo sauCodigo FROM");
            sql.append(" (select ta.tap_codigo tap_codigo,count(inv.tap_codigo) cantidad, ta.tap_nombre tapNombre,  ");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) valunidad,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
            sql.append(" ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");
            sql.append(" sysdate fechaExp,sau.edo_codigo numSiito, sau.sau_nit nit, Per.Per_Jur_Nombre_Largo razonSocial,");
            sql.append(" to_date(sysdate,'dd/mm/yyyy') fechaInicio, to_date(sysdate, 'dd/mm/yyyy') + to_number(Sau_Tiempo_Contr)*30 fechaFin,");
            sql.append(" Sau.Sau_Tiempo_Contr meses, Ta.Tap_codigo_Apuesta codApuesta, NVL(inv.inv_sillas,0) invSillas,sau.edo_codigo edoCodigo, sau.sau_codigo sauCodigo");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo) ");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join sii_solicitud_autoriza sau on (nov.sau_codigo= sau.sau_codigo)");
            sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)");
            sql.append(" where sau.sau_codigo = #idSolicitud and to_number(replace(Ta.Tap_codigo_Apuesta, 'NA', '0')) IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17) ");
            //se filta la persona juridica
            sql.append(" and UPPER(per.per_tipo_persona)='J' ");
            sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
            sql.append(" sysdate,sau.sau_numero_siito, sau.sau_nit, Per.Per_Jur_Nombre_Largo, sysdate,sysdate,Sau.Sau_Tiempo_Contr,");
            sql.append(" Ta.Tap_codigo_Apuesta,Ta.Tap_Min_Sillas, inv.inv_sillas,sau.edo_codigo, sau.sau_codigo)s");
            sql.append(" GROUP BY s.codApuesta,s.invSillas,s.tap_codigo,s.tapNombre,s.valunidad,s.fechaExp,s.nit,s.razonSocial,s.fechaInicio,s.fechaFin,");
            sql.append(" s.meses,s.numSiito,s.sauCodigo)p");
            sql.append(" GROUP BY p.tipoApuesta,p.tapCodigo,p.tapNombre,p.valunidad,p.fechaExp,p.nit,p.razonSocial,p.fechaInicio,p.fechaFin,p.meses,p.numSiito,p.sauCodigo");


            /*sql.append(" select s.tapCodigo,s.cantidad,s.nombre, s.valunidad,s.exmensual,s.gamensual,s.valortotalmensual,");
            sql.append(" s.fechaExp,s.nit,s.razonSocial,s.fechaInicio,s.fechaFin,s.meses,s.tipoApuesta,s.minsillas ,SUM(invSillas),");
            sql.append(" s.edoCodigo,s.sauCodigo, s.estable,  s.establecimiento  from ");
            sql.append(" ( select inv.est_codigo estable,ta.tap_codigo tapCodigo,count(inv.tap_codigo) cantidad, ta.tap_nombre nombre,");
            sql.append(" PR.fn_calcula_de(Tap_Der_Expl_Formula) valunidad,  PR.fn_calcula_de(Tap_Der_Expl_Formula) exmensual, ");
            sql.append(" ( 0.01*PR.fn_calcula_de(Tap_Der_Expl_Formula)) gamensual, ");
            sql.append(" (PR.fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*PR.fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual, ");
            sql.append(" sysdate fechaExp,sau.sau_numero_siito numSiito, sau.sau_nit nit, Per.Per_Jur_Nombre_Largo razonSocial, to_date(sysdate,'dd/mm/yyyy') fechaInicio, ");
            sql.append(" to_date(sysdate, 'dd/mm/yyyy') + to_number(Sau_Tiempo_Contr)*30 fechaFin, Sau.Sau_Tiempo_Contr meses, ");
            sql.append(" Ta.Tap_codigo_Apuesta tipoApuesta,NVL(Ta.Tap_Min_Sillas,0) minsillas, NVL(inv.inv_sillas,0) invSillas,sau.edo_codigo edoCodigo, sau.sau_codigo sauCodigo,");
            sql.append(" Est.Est_Nombre establecimiento");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo) ");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo) ");
            sql.append(" Inner Join sii_solicitud_autoriza sau on (nov.sau_codigo= sau.sau_codigo) ");
            sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)");
            sql.append(" Inner Join Sii_Establecimiento est on (inv.est_codigo=est.est_codigo)");
            sql.append(" where sau.sau_codigo =#idSolicitud ");
            sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA, ");
            sql.append(" sysdate,sau.sau_numero_siito, sau.sau_nit, Per.Per_Jur_Nombre_Largo, sysdate,sysdate,Sau.Sau_Tiempo_Contr , ");
            sql.append(" Ta.Tap_codigo_Apuesta,Ta.Tap_Min_Sillas, inv.inv_sillas,sau.edo_codigo, sau.sau_codigo , inv.est_codigo,Est.Est_Nombre");
            sql.append(" order by inv.est_codigo,Ta.Tap_codigo_Apuesta)s");
            sql.append(" GROUP BY s.estable,s.tipoApuesta,s.nombre,s.cantidad , s.minsillas,s.establecimiento,");
            sql.append(" s.valunidad,s.exmensual,s.gamensual,s.fechaExp, s.edoCodigo,s.fechaInicio,s.fechaFin,s.nit,s.razonSocial,s.meses,");
            sql.append(" s.tapCodigo,s.valortotalmensual,s.sauCodigo");
            sql.append(" ORDER BY s.tipoApuesta");*/

            /*sql.append(" select ta.tap_codigo,count(inv.tap_codigo), ta.tap_nombre, ");
            sql.append(" PR.fn_calcula_de(Tap_Der_Expl_Formula) valunidad, ");
            sql.append(" PR.fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
            sql.append(" ( 0.01*PR.fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
            sql.append(" (PR.fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*PR.fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");
            sql.append(" sysdate,sau.sau_numero_siito, sau.sau_nit, Per.Per_Jur_Nombre_Largo, to_date(sysdate,'dd/mm/yyyy'), to_date(sysdate, 'dd/mm/yyyy') + to_number(Sau_Tiempo_Contr)*30, Sau.Sau_Tiempo_Contr,");
            sql.append(" Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),sau.edo_codigo, sau.sau_codigo");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join sii_solicitud_autoriza sau on (nov.sau_codigo= sau.sau_codigo)");
            sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)");
            sql.append(" where sau.sau_codigo =#idSolicitud");
            sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
            sql.append(" sysdate,sau.sau_numero_siito, sau.sau_nit, Per.Per_Jur_Nombre_Largo, sysdate,sysdate,Sau.Sau_Tiempo_Contr,");
            sql.append(" Ta.Tap_codigo_Apuesta,Ta.Tap_Min_Sillas, inv.inv_sillas,sau.edo_codigo, sau.sau_codigo");*/

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idSolicitud", idSolicitud);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO oficioLiquidacionPrevioVo = new OficioLiquidacionPrevioVO();
                    oficioLiquidacionPrevioVo.setTapCodigo(((BigDecimal) object[0]).longValue());
                    oficioLiquidacionPrevioVo.setCantidad(((BigDecimal) object[1]).intValue());
                    oficioLiquidacionPrevioVo.setTap_nombre((String) object[2]);
                    oficioLiquidacionPrevioVo.setValorUnidad((BigDecimal) object[3]);
                    //oficioLiquidacionPrevioVo.setDerechosExplMensual((BigDecimal) object[4]);
                    //oficioLiquidacionPrevioVo.setGastosAdministracionMensual((BigDecimal) object[5]);
                    //oficioLiquidacionPrevioVo.setValorTotalMensual((BigDecimal) object[6]);
                    oficioLiquidacionPrevioVo.setFechaExpedicion((Date) object[4]);
                    //oficioLiquidacionPrevioVo.setNumeroSiito((String)object[8]);
                    oficioLiquidacionPrevioVo.setNit((String) object[5]);
                    oficioLiquidacionPrevioVo.setRazonSocial((String) object[6]);
                    oficioLiquidacionPrevioVo.setFechaInicioContrato((Date) object[7]);
                    oficioLiquidacionPrevioVo.setFechaFinContrato((Date) object[8]);
                    oficioLiquidacionPrevioVo.setMesesLiquidados(((BigDecimal) object[9]).intValue());
                    oficioLiquidacionPrevioVo.setCodigoApuesta((String) object[10]);
                    //oficioLiquidacionPrevioVo.setMinimoSillas(((BigDecimal) object[14]).intValue());
                    //ficioLiquidacionPrevioVo.setInventarioSillas(((BigDecimal) object[15]).longValue());
                    oficioLiquidacionPrevioVo.setNumeroSiito((String) object[11]);
                    oficioLiquidacionPrevioVo.setSauCodigo(((BigDecimal) object[12]).intValue());
                    //ficioLiquidacionPrevioVo.setEstablecimiento((String) object[19]);


                    miListaOficiosTipoApuesta.add(oficioLiquidacionPrevioVo);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO");
        }
        return miListaOficiosTipoApuesta;
    }

    public Long buscarConsecutivoOficio() throws ExcepcionDAO {
        Long consecutivo = 0L;
        ;
        BigDecimal resultado;
        try {
            StringBuilder sql = new StringBuilder();


            sql.append("SELECT NVL(MAX(SII_OFICIO_LIQUIDACION.OLI_CONSECUTIVO),0) FROM SII_OFICIO_LIQUIDACION");
            Query query = manager.createNativeQuery(sql.toString());

            resultado = (BigDecimal) query.getSingleResult();
            consecutivo = resultado.longValue();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RpDAO");
        }
        return consecutivo;
    }

    public List<OficioLiquidacionPrevioVO> buscarOficiosLiquidacionPorCodigo(Long idOficio) throws ExcepcionDAO {
        List<OficioLiquidacionPrevioVO> miListaOficios = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select ofta.tap_codigo,ta.tap_nombre,ofta.ota_num_elem, ");
            //sql.append(" PR.fn_calcula_de(Tap_Der_Expl_Formula) valunidad,");
            sql.append(" ofta.ota_valor_unidad valunidad,");
            sql.append(" Ofta.Ota_Der_Expl_Mes, Ofta.Ota_Gas_Admin,(Ofta.Ota_Der_Expl_Mes+Ofta.Ota_Gas_Admin) totalMes,");
            sql.append(" Ol.Oli_Fecha_Oficio,Sau.Sau_Numero_Siito,sau.sau_nit,Per.Per_Jur_Nombre_Largo, Sau.Sau_Tiempo_Contr,Ta.Tap_Codigo_Apuesta, Sau.Edo_Codigo, sau.sau_codigo");
            sql.append(" from sii_ofic_liq_tipo_apuesta  ofta");
            sql.append(" Inner Join sii_tipo_apuesta ta on (ofta.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_oficio_liquidacion ol on (ofta.oli_codigo =ol.oli_codigo)");
            sql.append(" Inner Join sii_solicitud_autoriza sau on (ol.sau_codigo = sau.sau_codigo)");
            sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)");
            sql.append("  Inner Join sii_novedad  nov on (sau.sau_codigo = Nov.Sau_Codigo)");
            //sql.append (" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" where Ofta.Oli_Codigo = #idOficio");
            sql.append(" group by ofta.tap_codigo,ta.tap_nombre,ofta.ota_num_elem,Ofta.Ota_Der_Expl_Mes, Ofta.Ota_Gas_Admin,");
            sql.append(" substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1),ofta.ota_valor_unidad,");
            sql.append(" Ol.Oli_Fecha_Oficio,Sau.Sau_Numero_Siito,sau.sau_nit,Per.Per_Jur_Nombre_Largo, Sau.Sau_Tiempo_Contr,Ta.Tap_Codigo_Apuesta, Sau.Edo_Codigo, sau.sau_codigo");


            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idOficio", idOficio);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO oficioLiquidacionPrevioVo = new OficioLiquidacionPrevioVO();
                    oficioLiquidacionPrevioVo.setTapCodigo(((BigDecimal) object[0]).longValue());
                    oficioLiquidacionPrevioVo.setCantidad(((BigDecimal) object[2]).intValue());
                    oficioLiquidacionPrevioVo.setTap_nombre((String) object[1]);
                    oficioLiquidacionPrevioVo.setValorUnidad((BigDecimal) object[3]);
                    oficioLiquidacionPrevioVo.setDerechosExplMensual((BigDecimal) object[4]);
                    oficioLiquidacionPrevioVo.setGastosAdministracionMensual((BigDecimal) object[5]);
                    oficioLiquidacionPrevioVo.setValorTotalMensual((BigDecimal) object[6]);
                    oficioLiquidacionPrevioVo.setFechaExpedicion((Date) object[7]);
                    oficioLiquidacionPrevioVo.setNit((String) object[9]);
                    oficioLiquidacionPrevioVo.setRazonSocial((String) object[10]);
                    if (object[11] != null) {
                        oficioLiquidacionPrevioVo.setMesesLiquidados(((BigDecimal) object[11]).intValue());
                    }
                    oficioLiquidacionPrevioVo.setCodigoApuesta((String) object[12]);
                    oficioLiquidacionPrevioVo.setNumeroSiito((String) object[13]);
                    oficioLiquidacionPrevioVo.setSauCodigo(((BigDecimal) object[14]).intValue());

                    miListaOficios.add(oficioLiquidacionPrevioVo);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO");
        }
        return miListaOficios;

    }

    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionModificaPorSolicitud(Long idContrato) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaOficiosTipoApuesta = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select p.tapCodigo,SUM(p.cantidad*p.totalInv) cantidad,p.tapNombre,p.valunidad,p.fechaExp,p.nit,");
            sql.append(" p.razonSocial,p.fechaInicio,p.fechaFin,p.tipoApuesta,p.cont, p.codcontra from");
            sql.append(" (select s.tap_codigo tapCodigo,s.tapNombre tapNombre,s.valunidad valunidad,");
            sql.append(" s.codApuesta tipoApuesta, SUM(cantidad) cantidad,CASE WHEN s.invSillas=0 THEN 1 ELSE s.invSillas END totalInv,");
            sql.append(" SUM(cantidad)*s.invSillas totalCantidad,s.fechaExp fechaExp,s.nit nit,s.razonSocial razonSocial,s.fechaInicio fechaInicio,");
            sql.append(" s.fechaFin fechaFin,s.contrato cont,s.codcontrato codcontra FROM");
            sql.append(" (select ta.tap_codigo tap_codigo,count(inv.tap_codigo) cantidad, ta.tap_nombre tapNombre,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) valunidad,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
            sql.append(" ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");
            sql.append(" sysdate fechaExp, Per.Per_Jur_Nombre_Largo razonSocial,Per.Per_Num_Identificacion nit,Ta.Tap_codigo_Apuesta codApuesta, NVL(inv.inv_sillas,0) invSillas,");
            sql.append(" con.con_numero contrato,con.con_codigo codcontrato,con.con_fecha_ini fechaInicio,con.con_fecha_fin fechaFin");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" Inner Join sii_operador op on (con.ope_codigo = op.ope_codigo)");
            sql.append(" Inner Join Sii_Persona per on (op.per_codigo = per.per_codigo)");
            sql.append(" where con.con_codigo=#idContrato");
            sql.append(" and to_number(replace(Ta.Tap_codigo_Apuesta, 'NA', '0')) IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17) ");
            sql.append(" and Inv.Inv_Estado ='A'");
            sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
            sql.append(" sysdate, Per.Per_Jur_Nombre_Largo, Ta.Tap_codigo_Apuesta, inv.inv_sillas, con.con_numero,con.con_codigo,con.con_fecha_ini,con.con_fecha_fin,Per.Per_Num_Identificacion)s");
            sql.append(" GROUP BY s.codApuesta,s.invSillas,s.tap_codigo,s.tapNombre,s.valunidad,s.fechaExp,s.nit,s.razonSocial,s.fechaInicio,s.fechaFin,");
            sql.append(" s.contrato,s.codcontrato)p");
            sql.append(" GROUP BY p.tipoApuesta,p.tapCodigo,p.tapNombre,p.valunidad,p.fechaExp,p.nit,p.razonSocial,p.fechaInicio,");
            sql.append(" p.fechaFin,p.cont, p.codcontra");

            /*sql.append(" select p.tapCodigo,SUM(p.cantidad*p.totalInv) cantidad,p.tapNombre,p.valunidad,p.fechaExp,p.nit,");
			sql.append(" p.razonSocial,p.fechaInicio,p.fechaFin,p.meses,p.tipoApuesta,p.numSiito,p.sauCodigo,p.cont, p.codcontra from");
			sql.append(" (select s.tap_codigo tapCodigo,s.tapNombre tapNombre,s.valunidad valunidad,");
			sql.append(" s.codApuesta tipoApuesta, SUM(cantidad) cantidad,CASE WHEN s.invSillas=0 THEN 1 ELSE s.invSillas END totalInv,");
			sql.append(" SUM(cantidad)*s.invSillas totalCantidad,s.fechaExp fechaExp,s.nit nit,s.razonSocial razonSocial,s.fechaInicio fechaInicio,");
			sql.append(" s.fechaFin fechaFin,s.meses meses,s.numSiito numSiito,s.sauCodigo sauCodigo, s.contrato cont,s.codcontrato codcontra FROM");
			sql.append(" (select ta.tap_codigo tap_codigo,count(inv.tap_codigo) cantidad, ta.tap_nombre tapNombre,");
			sql.append(" PR.fn_calcula_de(Tap_Der_Expl_Formula) valunidad,");
			sql.append(" PR.fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
			sql.append(" ( 0.01*PR.fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
			sql.append(" (PR.fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*PR.fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");
			sql.append(" sysdate fechaExp,sau.edo_codigo numSiito, sau.sau_nit nit, Per.Per_Jur_Nombre_Largo razonSocial,");
			sql.append(" to_date(sysdate,'dd/mm/yyyy') fechaInicio, to_date(sysdate, 'dd/mm/yyyy') + to_number(Sau_Tiempo_Contr)*30 fechaFin,");
			sql.append(" Sau.Sau_Tiempo_Contr meses, Ta.Tap_codigo_Apuesta codApuesta, NVL(inv.inv_sillas,0) invSillas,sau.edo_codigo edoCodigo, sau.sau_codigo sauCodigo, con.con_numero contrato,con.con_codigo codcontrato");
			sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo) ");
			sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
			sql.append(" Inner Join sii_solicitud_autoriza sau on (nov.sau_codigo= sau.sau_codigo)");
			sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)");
			sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
			sql.append(" where con.con_codigo=#idContrato");
			sql.append(" and to_number(replace(Ta.Tap_codigo_Apuesta, 'NA', '0'))between 1 and 15");
			sql.append("  and Inv.Inv_Estado='A'");
			sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
			sql.append(" sysdate,sau.edo_codigo, sau.sau_nit, Per.Per_Jur_Nombre_Largo, sysdate,sysdate,Sau.Sau_Tiempo_Contr,");
			sql.append(" Ta.Tap_codigo_Apuesta,Ta.Tap_Min_Sillas, inv.inv_sillas,sau.edo_codigo, sau.sau_codigo, con.con_numero,con.con_codigo)s");
			sql.append(" GROUP BY s.codApuesta,s.invSillas,s.tap_codigo,s.tapNombre,s.valunidad,s.fechaExp,s.nit,s.razonSocial,s.fechaInicio,s.fechaFin,");
			sql.append(" s.meses,s.numSiito,s.sauCodigo, s.contrato,s.codcontrato)p");
			sql.append(" GROUP BY p.tipoApuesta,p.tapCodigo,p.tapNombre,p.valunidad,p.fechaExp,p.nit,p.razonSocial,p.fechaInicio,");
			sql.append(" p.fechaFin,p.meses,p.numSiito,p.sauCodigo ,p.cont, p.codcontra");*/


            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idContrato", idContrato);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO oficioLiquidacionPrevioVo = new OficioLiquidacionPrevioVO();
                    oficioLiquidacionPrevioVo.setTapCodigo(((BigDecimal) object[0]).longValue());
                    oficioLiquidacionPrevioVo.setCantidad(((BigDecimal) object[1]).intValue());
                    oficioLiquidacionPrevioVo.setTap_nombre((String) object[2]);
                    oficioLiquidacionPrevioVo.setValorUnidad((BigDecimal) object[3]);
                    oficioLiquidacionPrevioVo.setFechaExpedicion((Date) object[4]);
                    oficioLiquidacionPrevioVo.setNit((String) object[5]);
                    oficioLiquidacionPrevioVo.setRazonSocial((String) object[6]);
                    oficioLiquidacionPrevioVo.setFechaInicioContrato((Date) object[7]);
                    oficioLiquidacionPrevioVo.setFechaFinContrato((Date) object[8]);
                    //oficioLiquidacionPrevioVo.setMesesLiquidados(((BigDecimal) object[9]).intValue());
                    oficioLiquidacionPrevioVo.setCodigoApuesta((String) object[9]);
                    //oficioLiquidacionPrevioVo.setNumeroSiito((String) object[11]);
                    //oficioLiquidacionPrevioVo.setSauCodigo(((BigDecimal) object[12]).intValue());
                    oficioLiquidacionPrevioVo.setNumeroContrato((String) object[10]);
                    oficioLiquidacionPrevioVo.setConCodigo(((BigDecimal) object[11]).longValue());

                    miListaOficiosTipoApuesta.add(oficioLiquidacionPrevioVo);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO");
        }
        return miListaOficiosTipoApuesta;
    }

    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionValorModificaPorSolicitud(Long idSolicitud) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaOficiosTipoApuesta = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select p.tapCodigo,SUM(p.cantidad*p.totalInv) cantidad,p.tapNombre,p.valunidad,p.fechaExp,");
            sql.append(" p.nit, p.razonSocial,p.fechaInicio,p.fechaFin,p.contrato,p.codContr,p.tipoApuesta, p.est from");
            sql.append(" (select s.tap_codigo tapCodigo,s.tapNombre tapNombre,s.valunidad valunidad,");
            sql.append(" s.codApuesta tipoApuesta, SUM(cantidad) cantidad,CASE WHEN s.invSillas=0 THEN 1 ELSE s.invSillas END totalInv,");
            sql.append(" SUM(cantidad)*s.invSillas totalCantidad,s.fechaExp fechaExp,s.nit nit,s.razonSocial razonSocial,s.con_Fecha_ini fechaInicio,");
            sql.append(" s.con_fecha_fin fechaFin,s.num_contrato contrato,s.cod_contrato codContr, s.estado est FROM");
            sql.append(" (select ta.tap_codigo tap_codigo,count(inv.tap_codigo) cantidad, ta.tap_nombre tapNombre,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) valunidad,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
            sql.append(" ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");
            sql.append(" sysdate fechaExp,sau.sau_numero_siito numSiito, sau.sau_nit nit, Per.Per_Jur_Nombre_Largo razonSocial,");
            sql.append(" Con.Con_Fecha_Ini con_Fecha_ini, Con.Con_Fecha_Fin con_fecha_fin, Con.Con_Numero num_contrato,");
            sql.append(" Ta.Tap_codigo_Apuesta codApuesta, NVL(inv.inv_sillas,0) invSillas, con.con_codigo cod_contrato, Inv.Inv_Estado estado, Inv.Inv_Codigo inv_codigo");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join sii_solicitud_autoriza sau on (nov.sau_codigo= sau.sau_codigo)");
            
            //se quita filtro ya que, no debe buscarse por nit sino por el operador asociado al contrato
            //sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)"); 
            
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            
            //linea que filtra el operador del contrato que se modifica
            sql.append(" Inner Join sii_Operador ope on (con.ope_codigo = ope.ope_codigo)"); 
            //linea que filtra la persona asociada al perador del contrato que se modifica
            sql.append(" Inner Join sii_persona per on (ope.per_codigo = per.per_codigo)");  
            
            sql.append(" where sau.sau_codigo = #idSolicitud ");
            sql.append(" and to_number(replace(Ta.Tap_codigo_Apuesta, 'NA', '0')) IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17) ");
            sql.append(" and Inv.Inv_Estado in ('PA','PR')");
            sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
            sql.append(" sysdate,sau.sau_numero_siito, sau.sau_nit, Per.Per_Jur_Nombre_Largo, Con.Con_Fecha_Ini, Con.Con_Fecha_Fin,");
            sql.append(" Con.Con_Numero, Ta.Tap_codigo_Apuesta,inv.inv_sillas,con.con_codigo,Inv.Inv_Estado, Inv.Inv_Codigo)s");
            sql.append(" GROUP BY s.codApuesta,s.invSillas,s.tap_codigo,s.tapNombre,s.valunidad,s.fechaExp,s.nit,s.razonSocial,s.con_Fecha_ini,s.con_fecha_fin,");
            sql.append(" s.num_contrato,s.cod_contrato, s.estado)p");
            sql.append(" GROUP BY p.tipoApuesta,p.tapCodigo,p.tapNombre,p.valunidad,p.fechaExp,p.nit,p.razonSocial,p.fechaInicio,p.fechaFin,p.contrato,p.codContr, p.est");


            /*sql.append(" select ta.tap_codigo,count(inv.tap_codigo), ta.tap_nombre, ");
            sql.append(" PR.fn_calcula_de(Tap_Der_Expl_Formula) valunidad, ");
            sql.append(" PR.fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
            sql.append(" ( 0.01*PR.fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
            sql.append(" (PR.fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*PR.fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");

            sql.append(" sysdate,sau.sau_numero_siito, sau.sau_nit, Per.Per_Jur_Nombre_Largo, Con.Con_Fecha_Ini, Con.Con_Fecha_Fin, Con.Con_Numero,Sau.Sau_Tiempo_Contr,");
            sql.append(" Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),inv.inv_estado, con.con_codigo ");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join sii_solicitud_autoriza sau on (nov.sau_codigo= sau.sau_codigo)");
            sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" where sau.sau_codigo =#idSolicitud and inv.inv_estado in( 'PA','PR')");
            sql.append(" and TO_NUMBER(DECODE(Ta.Tap_codigo_Apuesta,'NA',0,Ta.Tap_codigo_Apuesta)) between 1 and 15 ");
            sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
            sql.append(" sysdate,sau.sau_numero_siito, sau.sau_nit, Per.Per_Jur_Nombre_Largo, Con.Con_Fecha_Ini, Con.Con_Fecha_Fin,Con.Con_Numero,Sau.Sau_Tiempo_Contr,");
            sql.append(" Ta.Tap_codigo_Apuesta,Ta.Tap_Min_Sillas, inv.inv_sillas,inv.inv_estado, con.con_codigo");*/

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idSolicitud", idSolicitud);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO oficioLiquidacionPrevioVo = new OficioLiquidacionPrevioVO();
                    oficioLiquidacionPrevioVo.setTapCodigo(((BigDecimal) object[0]).longValue());
                    oficioLiquidacionPrevioVo.setCantidad(((BigDecimal) object[1]).intValue());
                    oficioLiquidacionPrevioVo.setTap_nombre((String) object[2]);
                    oficioLiquidacionPrevioVo.setValorUnidad((BigDecimal) object[3]);
                    /*oficioLiquidacionPrevioVo.setDerechosExplMensual((BigDecimal) object[4]);
                    oficioLiquidacionPrevioVo.setGastosAdministracionMensual((BigDecimal) object[5]);
                    oficioLiquidacionPrevioVo.setValorTotalMensual((BigDecimal) object[6]);*/
                    oficioLiquidacionPrevioVo.setFechaExpedicion((Date) object[4]);
                    //oficioLiquidacionPrevioVo.setNumeroSiito((String) object[8]);
                    oficioLiquidacionPrevioVo.setNit((String) object[5]);
                    oficioLiquidacionPrevioVo.setRazonSocial((String) object[6]);
                    oficioLiquidacionPrevioVo.setFechaInicioContrato((Date) object[7]);
                    oficioLiquidacionPrevioVo.setFechaFinContrato((Date) object[8]);
                    oficioLiquidacionPrevioVo.setNumeroContrato((String) object[9]);
                    oficioLiquidacionPrevioVo.setConCodigo(((BigDecimal) object[10]).longValue());
                    //oficioLiquidacionPrevioVo.setMesesLiquidados(((BigDecimal) object[14]).intValue());
                    oficioLiquidacionPrevioVo.setCodigoApuesta((String) object[11]);
                    /*oficioLiquidacionPrevioVo.setMinimoSillas(((BigDecimal) object[16]).intValue());
                    oficioLiquidacionPrevioVo.setInventarioSillas(((BigDecimal) object[17]).longValue());*/
                    oficioLiquidacionPrevioVo.setEstado((String) object[12]);


                    miListaOficiosTipoApuesta.add(oficioLiquidacionPrevioVo);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO");
        }
        return miListaOficiosTipoApuesta;
    }

    public List<OficioLiquidacionPrevioVO> obtenerLiquidacioncionOficioLiqPorContrato(Long idContrato) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaOficiosTipoApuesta = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select p.tapCodigo,SUM(p.cantidad*p.totalInv) cantidad,p.tapNombre,p.valunidad,p.fechaExp,");
            sql.append(" p.fechaInicio,p.fechaFin,p.contrato,p.codContr,p.tipoApuesta, p.est,p.inv_cod,");
            sql.append(" p.iniOper, p.finOper from");
            sql.append(" (select s.tap_codigo tapCodigo,s.tapNombre tapNombre,s.valunidad valunidad,");
            sql.append(" s.codApuesta tipoApuesta, SUM(cantidad) cantidad,CASE WHEN s.invSillas=0 THEN 1 ELSE s.invSillas END totalInv,");
            sql.append(" SUM(cantidad)*s.invSillas totalCantidad,s.fechaExp fechaExp,s.con_Fecha_ini fechaInicio,");
            sql.append(" s.con_fecha_fin fechaFin,s.num_contrato contrato,s.cod_contrato codContr, s.estado est, s.inv_codigo inv_cod,");
            sql.append(" s.iniLiq iniOper, s.finLiq finOper FROM");
            sql.append(" (select ta.tap_codigo tap_codigo,count(inv.tap_codigo) cantidad, ta.tap_nombre tapNombre,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) valunidad,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
            sql.append(" ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");
            sql.append(" sysdate fechaExp, Con.Con_Fecha_Ini con_Fecha_ini, Con.Con_Fecha_Fin con_fecha_fin, Con.Con_Numero num_contrato,");
            sql.append(" Ta.Tap_codigo_Apuesta codApuesta, NVL(inv.inv_sillas,0) invSillas, con.con_codigo cod_contrato, Inv.Inv_Estado estado, ");
            sql.append(" Inv.Inv_Codigo inv_codigo, Inv.Inv_Fecha_Ini_Liq iniLiq, Inv.Inv_Fecha_Fin_Liq finLiq");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" where con.con_codigo = #idContrato and to_number(replace(Ta.Tap_codigo_Apuesta, 'NA', '0')) IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17) ");
            sql.append(" and Inv.Inv_Estado in ('A','R')");
            sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
            sql.append(" sysdate, Con.Con_Fecha_Ini, Con.Con_Fecha_Fin,Con.Con_Numero, Ta.Tap_codigo_Apuesta,inv.inv_sillas,con.con_codigo,");
            sql.append(" Inv.Inv_Estado, Inv.Inv_Codigo,Inv.Inv_Fecha_Ini_Liq, Inv.Inv_Fecha_Fin_Liq )s");
            sql.append(" GROUP BY s.codApuesta,s.invSillas,s.tap_codigo,s.tapNombre,s.valunidad,s.fechaExp,s.con_Fecha_ini,s.con_fecha_fin,");
            sql.append(" s.num_contrato,s.cod_contrato, s.estado, s.inv_codigo,s.iniLiq, s.finLiq)p");
            sql.append(" GROUP BY p.tipoApuesta,p.tapCodigo,p.tapNombre,p.valunidad,p.fechaExp,p.fechaInicio,p.fechaFin,");
            sql.append(" p.contrato,p.codContr, p.est,p.inv_cod,p.iniOper, p.finOper");

            /*sql.append(" select ta.tap_codigo, ");
            sql.append(" substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1) valunidad,");
            sql.append(" substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1)/30 exmensualdiario,");
            sql.append(" substr(TAP_GAST_ADM_FORMULA,1,INSTR(TAP_GAST_ADM_FORMULA,'*')-1)*(substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1)/30) gamensual,");
            sql.append(" (substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1)/30)+");
            sql.append(" (substr(TAP_GAST_ADM_FORMULA,1,INSTR(TAP_GAST_ADM_FORMULA,'*')-1)*(substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1)/30)) valormensual,");
            sql.append(" sysdate,sau.sau_numero_siito, sau.sau_nit, Per.Per_Jur_Nombre_Largo, Con.Con_Fecha_Ini, Con.Con_Fecha_Fin, Con.Con_Numero,Sau.Sau_Tiempo_Contr,");
            sql.append(" Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),inv.inv_estado,");
            sql.append(" inv.inv_fecha_ini_ofi, inv.inv_fecha_fin_ofi");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join sii_solicitud_autoriza sau on (nov.sau_codigo= sau.sau_codigo)");
            sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" where sau.sau_codigo =#idSolicitud and inv.inv_estado in( #estado1,#estado2)");
            sql.append(" group by  ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
            sql.append(" sysdate,sau.sau_numero_siito, sau.sau_nit, Per.Per_Jur_Nombre_Largo, Con.Con_Fecha_Ini, Con.Con_Fecha_Fin,Con.Con_Numero,Sau.Sau_Tiempo_Contr,");
            sql.append(" Ta.Tap_codigo_Apuesta,Ta.Tap_Min_Sillas, inv.inv_sillas,inv.inv_estado, inv.inv_fecha_ini_ofi, inv.inv_fecha_fin_ofi");*/

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idContrato", idContrato);

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO oficioLiquidacionPrevioVo = new OficioLiquidacionPrevioVO();
                    oficioLiquidacionPrevioVo.setTapCodigo(((BigDecimal) object[0]).longValue());
                    oficioLiquidacionPrevioVo.setCantidad(((BigDecimal) object[1]).intValue());
                    oficioLiquidacionPrevioVo.setTap_nombre((String) object[2]);
                    oficioLiquidacionPrevioVo.setValorUnidad((BigDecimal) object[3]);
                    oficioLiquidacionPrevioVo.setFechaExpedicion((Date) object[4]);
                    oficioLiquidacionPrevioVo.setFechaInicioContrato((Date) object[5]);
                    oficioLiquidacionPrevioVo.setFechaFinContrato((Date) object[6]);
                    oficioLiquidacionPrevioVo.setNumeroContrato((String) object[7]);
                    oficioLiquidacionPrevioVo.setConCodigo(((BigDecimal) object[8]).longValue());
                    oficioLiquidacionPrevioVo.setCodigoApuesta((String) object[9]);
                    oficioLiquidacionPrevioVo.setEstado((String) object[10]);
                    oficioLiquidacionPrevioVo.setInvCodigo(((BigDecimal) object[11]).longValue());
                    oficioLiquidacionPrevioVo.setFechaInicioLiq((Date) object[12]);
                    oficioLiquidacionPrevioVo.setFechaFinLiq((Date) object[13]);

                    miListaOficiosTipoApuesta.add(oficioLiquidacionPrevioVo);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO");
        }
        return miListaOficiosTipoApuesta;
    }

    public List<DuplaVO> buscarPagosPorContrato(long codigoContrato) throws ExcepcionDAO {

        List<DuplaVO> miListaConceptos = new ArrayList<DuplaVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT SUM(dr.dre_Valor),Ccu_Abreviatura");
            sql.append(" FROM sii_detalle_recaudo dr");
            sql.append(" INNER JOIN sii_detalle_declaracion dd ON dr.dre_codigo = dd.dre_codigo");
            sql.append(" INNER JOIN sii_cuota_operador co ON co.cop_codigo = dd.cop_codigo");
            sql.append(" INNER JOIN sii_concepto_cuota cc ON cc.ccu_codigo = co.ccu_codigo");
            sql.append(" INNER JOIN sii_liquidacion_mes lm ON lm.lme_codigo = co.lme_codigo");
            sql.append(" WHERE lm.con_codigo =#codigoContrato ");
            sql.append(" GROUP BY Ccu_Abreviatura");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("codigoContrato", codigoContrato);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {

                for (Object[] object : results) {
                    DuplaVO dum = new DuplaVO();
                    dum.setValor((BigDecimal) object[0]);
                    dum.setConcepto((String) object[1]);
                    miListaConceptos.add(dum);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO" + "");
        }
        return miListaConceptos;
    }


    /**
     * @param sauCodigo id de sii_solicitud_autoriz
     * @return cantidad de elementos
     * @throws ExcepcionDAO
     */
    public Long cantidadElementosPorSolicitud(Long sauCodigo) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT SUM(ota.OTA_NUM_ELEM) cantidad\n" + "FROM sii_ofic_liq_tipo_apuesta ota\n" +
                       "INNER JOIN sii_oficio_liquidacion ofi\n" + "ON ofi.OLI_CODIGO    = ota.OLI_CODIGO\n" +
                       "WHERE ofi.SAU_CODIGO = #sauCodigo");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            return ((BigDecimal) query.getSingleResult()).longValue();

        } catch (PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        }
    }

    /**
     * @param idOficio consecutivo del oficio de liquidacion
     * @return cantidad de elementos
     * @throws ExcepcionDAO
     */

    public List<SiiContrato> buscarContratoPorOficioLiquidacion(Long idOficio) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT c FROM SiiContrato c INNER JOIN c.siiNovedadList nov ");
            sql.append(" Inner Join nov.siiSolicitudAutoriza sa");
            sql.append(" Inner Join sa.siiOficioLiquidacionList ol");
            sql.append(" where ol.oliCodigo = :idOficio ");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("idOficio", idOficio);
            List<SiiContrato> listaContrato = query.getResultList();

            return listaContrato;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        }
    }

    public List<OfiLiquidacionSolAutorizaVO> buscarTodosOficioLiquidacionModifContrato(UsuarioVO usuarioLogueado) throws ExcepcionDAO {

        List<OfiLiquidacionSolAutorizaVO> miListaOficios = new ArrayList<OfiLiquidacionSolAutorizaVO>();
        boolean isEvaluador = false;
        Long codUsuario = usuarioLogueado.getUsuCodigo();
        try {
            if (usuarioLogueado.getUsuarioRolVoList().size() > 0) {
                for (UsuarioRolVO unRol : usuarioLogueado.getUsuarioRolVoList()) {
                    if (unRol.getRolVo().getRolNombre().equals("CN Evaluador financiero") ||
                        unRol.getRolVo().getRolNombre().equals("CN Administrador")) {
                        isEvaluador = true;
                        break;
                    }
                }
            }

            StringBuilder sql = new StringBuilder();
            sql.append(" select distinct ol.oli_consecutivo,ol.oli_fecha_oficio, sa.edo_codigo, per.per_jur_nombre_largo,Tid.Tid_Nombre_Corto||'-'||sa.sau_nit,eol.eol_nombre,ol.oli_codigo, sa.sau_codigo");
            sql.append(" ,Usu.Usu_Nombre_Usuario, tsa.tsa_nombre, nov.con_codigo");
            sql.append(" from sii_oficio_liquidacion ol Inner Join sii_solicitud_autoriza sa on (ol.sau_codigo = sa.sau_codigo)");
            //sql.append(" Inner Join sii_persona per on (sa.sau_nit = per.per_num_identificacion)");
            //sql.append(" Inner Join Sii_Tipo_Identificacion tid on (per.tid_codigo=tid.tid_codigo)");
            sql.append(" Inner Join sii_estado_oficio_liq eol on (ol.eol_codigo = eol.eol_codigo)");
            sql.append(" Inner Join Sii_Usuario usu on (sa.usu_codigo = usu.usu_codigo)");
            sql.append(" Inner Join sii_novedad nov on (sa.sau_codigo = nov.sau_codigo)");
            //se busca operador relacionado al contrato
            sql.append(" Inner Join sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" Inner Join sii_Operador ope on (con.ope_codigo = ope.ope_codigo)");
            sql.append(" Inner Join sii_persona per on (ope.per_codigo = per.per_codigo)");
            sql.append(" Inner Join Sii_Tipo_Identificacion tid on (per.tid_codigo=tid.tid_codigo)");
            sql.append(" Inner Join Sii_Tipo_Solic_Autoriza tsa on (sa.Tsa_Codigo = tsa.tsa_codigo)");
            sql.append(" where tsa.tsa_codigo in (30,90)");
            if (!isEvaluador) {
                sql.append(" and sa.usu_codigo =#codUsuario");
            }
            sql.append(" order by ol.oli_consecutivo desc");

            Query query = manager.createNativeQuery(sql.toString());
            if (!isEvaluador) {
                query.setParameter("codUsuario", codUsuario);
            }

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {

                for (Object[] object : results) {
                    OfiLiquidacionSolAutorizaVO ofiLiqVo = new OfiLiquidacionSolAutorizaVO();
                    ofiLiqVo.setConsecutivo(((BigDecimal) object[0]).intValue());
                    ofiLiqVo.setFechaExpedicion((Date) object[1]);
                    ofiLiqVo.setNumeroSiito((String) object[2]);
                    ofiLiqVo.setRazonSocial((String) object[3]);
                    ofiLiqVo.setNit((String) object[4]);
                    ofiLiqVo.setEstado((String) object[5]);
                    ofiLiqVo.setOliCodigo(((BigDecimal) object[6]).longValue());
                    ofiLiqVo.setSauCodigo(((BigDecimal) object[7]).longValue());
                    ofiLiqVo.setNombreUsuario((String) object[8]);
                    ofiLiqVo.setTipoSolicitudAutoriza((String) object[9]);
                    if (object[10] != null) {
                        ofiLiqVo.setCodigoContrato(((BigDecimal) object[10]).longValue());
                    }
                    miListaOficios.add(ofiLiqVo);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO");
        }
        return miListaOficios;
    }

    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionModificaPorContrato(Long idContrato) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaOficiosTipoApuesta = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select p.tapCodigo,SUM(p.cantidad*p.totalInv) cantidad,p.tapNombre,p.valunidad,p.fechaExp,p.nit,");
            sql.append(" p.razonSocial,p.fechaInicio,p.fechaFin,p.tipoApuesta,p.cont, p.codcontra ,p.est from");
            sql.append(" (select s.tap_codigo tapCodigo,s.tapNombre tapNombre,s.valunidad valunidad,");
            sql.append(" s.codApuesta tipoApuesta, SUM(cantidad) cantidad,CASE WHEN s.invSillas=0 THEN 1 ELSE s.invSillas END totalInv,");
            sql.append(" SUM(cantidad)*s.invSillas totalCantidad,s.fechaExp fechaExp,s.nit nit,s.razonSocial razonSocial,s.fechaInicio fechaInicio,");
            sql.append(" s.fechaFin fechaFin,s.contrato cont,s.codcontrato codcontra,s.estado est FROM");
            sql.append(" (select ta.tap_codigo tap_codigo,count(inv.tap_codigo) cantidad, ta.tap_nombre tapNombre,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) valunidad,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
            sql.append(" ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");
            sql.append(" sysdate fechaExp, Per.Per_Jur_Nombre_Largo razonSocial,Per.Per_Num_Identificacion nit,Ta.Tap_codigo_Apuesta codApuesta, NVL(inv.inv_sillas,0) invSillas,");
            sql.append(" con.con_numero contrato,con.con_codigo codcontrato,con.con_fecha_ini fechaInicio,con.con_fecha_fin fechaFin,Inv.Inv_Estado estado");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" Inner Join sii_operador op on (con.ope_codigo = op.ope_codigo)");
            sql.append(" Inner Join Sii_Persona per on (op.per_codigo = per.per_codigo)");
            sql.append(" where con.con_codigo=#idContrato");
            sql.append(" and to_number(replace(Ta.Tap_codigo_Apuesta, 'NA', '0')) IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17) ");
            sql.append(" and Inv.Inv_Estado in ('PA','PR')");
            sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA");
            sql.append(" sysdate, Per.Per_Jur_Nombre_Largo, Ta.Tap_codigo_Apuesta, inv.inv_sillas, con.con_numero,con.con_codigo,con.con_fecha_ini,con.con_fecha_fin,Per.Per_Num_Identificacion,Inv.Inv_Estado)s");
            sql.append(" GROUP BY s.codApuesta,s.invSillas,s.tap_codigo,s.tapNombre,s.valunidad,s.fechaExp,s.nit,s.razonSocial,s.fechaInicio,s.fechaFin,s.estado,");
            sql.append(" s.contrato,s.codcontrato)p");
            sql.append(" GROUP BY p.tipoApuesta,p.tapCodigo,p.tapNombre,p.valunidad,p.fechaExp,p.nit,p.razonSocial,p.fechaInicio,");
            sql.append(" p.fechaFin,p.cont, p.codcontra,p.est");

            /*sql.append(" select p.tapCodigo,SUM(p.cantidad*p.totalInv) cantidad,p.tapNombre,p.valunidad,p.fechaExp,p.nit,");
                        sql.append(" p.razonSocial,p.fechaInicio,p.fechaFin,p.meses,p.tipoApuesta,p.numSiito,p.sauCodigo,p.cont, p.codcontra from");
                        sql.append(" (select s.tap_codigo tapCodigo,s.tapNombre tapNombre,s.valunidad valunidad,");
                        sql.append(" s.codApuesta tipoApuesta, SUM(cantidad) cantidad,CASE WHEN s.invSillas=0 THEN 1 ELSE s.invSillas END totalInv,");
                        sql.append(" SUM(cantidad)*s.invSillas totalCantidad,s.fechaExp fechaExp,s.nit nit,s.razonSocial razonSocial,s.fechaInicio fechaInicio,");
                        sql.append(" s.fechaFin fechaFin,s.meses meses,s.numSiito numSiito,s.sauCodigo sauCodigo, s.contrato cont,s.codcontrato codcontra FROM");
                        sql.append(" (select ta.tap_codigo tap_codigo,count(inv.tap_codigo) cantidad, ta.tap_nombre tapNombre,");
                        sql.append(" PR.fn_calcula_de(Tap_Der_Expl_Formula) valunidad,");
                        sql.append(" PR.fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
                        sql.append(" ( 0.01*PR.fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
                        sql.append(" (PR.fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*PR.fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");
                        sql.append(" sysdate fechaExp,sau.edo_codigo numSiito, sau.sau_nit nit, Per.Per_Jur_Nombre_Largo razonSocial,");
                        sql.append(" to_date(sysdate,'dd/mm/yyyy') fechaInicio, to_date(sysdate, 'dd/mm/yyyy') + to_number(Sau_Tiempo_Contr)*30 fechaFin,");
                        sql.append(" Sau.Sau_Tiempo_Contr meses, Ta.Tap_codigo_Apuesta codApuesta, NVL(inv.inv_sillas,0) invSillas,sau.edo_codigo edoCodigo, sau.sau_codigo sauCodigo, con.con_numero contrato,con.con_codigo codcontrato");
                        sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo) ");
                        sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
                        sql.append(" Inner Join sii_solicitud_autoriza sau on (nov.sau_codigo= sau.sau_codigo)");
                        sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)");
                        sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
                        sql.append(" where con.con_codigo=#idContrato");
                        sql.append(" and to_number(replace(Ta.Tap_codigo_Apuesta, 'NA', '0'))between 1 and 15");
                        sql.append("  and Inv.Inv_Estado='A'");
                        sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
                        sql.append(" sysdate,sau.edo_codigo, sau.sau_nit, Per.Per_Jur_Nombre_Largo, sysdate,sysdate,Sau.Sau_Tiempo_Contr,");
                        sql.append(" Ta.Tap_codigo_Apuesta,Ta.Tap_Min_Sillas, inv.inv_sillas,sau.edo_codigo, sau.sau_codigo, con.con_numero,con.con_codigo)s");
                        sql.append(" GROUP BY s.codApuesta,s.invSillas,s.tap_codigo,s.tapNombre,s.valunidad,s.fechaExp,s.nit,s.razonSocial,s.fechaInicio,s.fechaFin,");
                        sql.append(" s.meses,s.numSiito,s.sauCodigo, s.contrato,s.codcontrato)p");
                        sql.append(" GROUP BY p.tipoApuesta,p.tapCodigo,p.tapNombre,p.valunidad,p.fechaExp,p.nit,p.razonSocial,p.fechaInicio,");
                        sql.append(" p.fechaFin,p.meses,p.numSiito,p.sauCodigo ,p.cont, p.codcontra");*/


            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idContrato", idContrato);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO oficioLiquidacionPrevioVo = new OficioLiquidacionPrevioVO();
                    oficioLiquidacionPrevioVo.setTapCodigo(((BigDecimal) object[0]).longValue());
                    oficioLiquidacionPrevioVo.setCantidad(((BigDecimal) object[1]).intValue());
                    oficioLiquidacionPrevioVo.setTap_nombre((String) object[2]);
                    oficioLiquidacionPrevioVo.setValorUnidad((BigDecimal) object[3]);
                    oficioLiquidacionPrevioVo.setFechaExpedicion((Date) object[4]);
                    oficioLiquidacionPrevioVo.setNit((String) object[5]);
                    oficioLiquidacionPrevioVo.setRazonSocial((String) object[6]);
                    oficioLiquidacionPrevioVo.setFechaInicioContrato((Date) object[7]);
                    oficioLiquidacionPrevioVo.setFechaFinContrato((Date) object[8]);
                    //oficioLiquidacionPrevioVo.setMesesLiquidados(((BigDecimal) object[9]).intValue());
                    oficioLiquidacionPrevioVo.setCodigoApuesta((String) object[9]);
                    //oficioLiquidacionPrevioVo.setNumeroSiito((String) object[11]);
                    //oficioLiquidacionPrevioVo.setSauCodigo(((BigDecimal) object[12]).intValue());
                    oficioLiquidacionPrevioVo.setNumeroContrato((String) object[10]);
                    oficioLiquidacionPrevioVo.setConCodigo(((BigDecimal) object[11]).longValue());
                    oficioLiquidacionPrevioVo.setEstado((String) object[12]);

                    miListaOficiosTipoApuesta.add(oficioLiquidacionPrevioVo);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO");
        }
        return miListaOficiosTipoApuesta;
    }


    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionNuevoInventarioPorSolicitud(Long idSolicitud,
                                                                                                Long idContrato) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaOficiosTipoApuesta = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();

            sql.append(" select p.tapCodigo,SUM(p.cantidad*p.totalInv) cantidad,p.tapNombre,p.valunidad,p.fechaExp,p.nit,");
            sql.append(" p.razonSocial,p.fechaInicio,p.fechaFin,p.tipoApuesta,p.cont, p.codcontra, p.est  from");
            sql.append(" (select s.tap_codigo tapCodigo,s.tapNombre tapNombre,s.valunidad valunidad,");
            sql.append(" s.codApuesta tipoApuesta, SUM(cantidad) cantidad,CASE WHEN s.invSillas=0 THEN 1 ELSE s.invSillas END totalInv,");
            sql.append(" SUM(cantidad)*s.invSillas totalCantidad,s.fechaExp fechaExp,s.nit nit,s.razonSocial razonSocial,s.fechaInicio fechaInicio,");
            sql.append(" s.fechaFin fechaFin,s.contrato cont,s.codcontrato codcontra, s.estado est, s.inv_codigo inv_cod FROM");
            sql.append(" (select ta.tap_codigo tap_codigo,count(inv.tap_codigo) cantidad, ta.tap_nombre tapNombre,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) valunidad,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
            sql.append(" ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");
            sql.append(" sysdate fechaExp, Per.Per_Jur_Nombre_Largo razonSocial,Per.Per_Num_Identificacion nit,Ta.Tap_codigo_Apuesta codApuesta, NVL(inv.inv_sillas,0) invSillas,");
            sql.append(" con.con_numero contrato,con.con_codigo codcontrato,con.con_fecha_ini fechaInicio,con.con_fecha_fin fechaFin, Inv.Inv_Estado estado, Inv.Inv_Codigo inv_codigo");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" Inner Join sii_operador op on (con.ope_codigo = op.ope_codigo)");
            sql.append(" Inner Join Sii_Persona per on (op.per_codigo = per.per_codigo)");
            sql.append(" where con.con_codigo=#idContrato");
            sql.append(" and to_number(replace(Ta.Tap_codigo_Apuesta, 'NA', '0')) IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17) ");
            sql.append(" and Inv.Inv_Estado='A'");
            sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
            sql.append(" sysdate, Per.Per_Jur_Nombre_Largo, Ta.Tap_codigo_Apuesta, inv.inv_sillas, con.con_numero,con.con_codigo,con.con_fecha_ini,con.con_fecha_fin,Per.Per_Num_Identificacion");
            sql.append(" , Inv.Inv_Estado, Inv.Inv_Codigo )s");
            sql.append(" GROUP BY s.codApuesta,s.invSillas,s.tap_codigo,s.tapNombre,s.valunidad,s.fechaExp,s.nit,s.razonSocial,s.fechaInicio,s.fechaFin,");
            sql.append(" s.contrato,s.codcontrato, s.estado, s.inv_codigo)p");
            sql.append(" GROUP BY p.tipoApuesta,p.tapCodigo,p.tapNombre,p.valunidad,p.fechaExp,p.nit,p.razonSocial,p.fechaInicio,");
            sql.append(" p.fechaFin,p.cont, p.codcontra, p.est");
            sql.append(" UNION ALL");
            sql.append(" select p.tapCodigo,SUM(p.cantidad*p.totalInv) cantidad,p.tapNombre,p.valunidad,p.fechaExp,");
            sql.append(" p.nit, p.razonSocial,p.fechaInicio,p.fechaFin,p.tipoApuesta,p.contrato,p.codContr, p.est from");
            sql.append(" (select s.tap_codigo tapCodigo,s.tapNombre tapNombre,s.valunidad valunidad,");
            sql.append(" s.codApuesta tipoApuesta, SUM(cantidad) cantidad,CASE WHEN s.invSillas=0 THEN 1 ELSE s.invSillas END totalInv,");
            sql.append(" SUM(cantidad)*s.invSillas totalCantidad,s.fechaExp fechaExp,s.nit nit,s.razonSocial razonSocial,s.con_Fecha_ini fechaInicio,");
            sql.append(" s.con_fecha_fin fechaFin,s.num_contrato contrato,s.cod_contrato codContr, s.estado est, s.inv_codigo inv_cod FROM");
            sql.append(" (select ta.tap_codigo tap_codigo,count(inv.tap_codigo) cantidad, ta.tap_nombre tapNombre,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) valunidad,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) exmensual,");
            sql.append(" ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula)) gamensual,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula) + ( 0.01*fn_calcula_de(Tap_Der_Expl_Formula))) valortotalmensual,");
            sql.append(" sysdate fechaExp,sau.sau_numero_siito numSiito, sau.sau_nit nit, Per.Per_Jur_Nombre_Largo razonSocial,");
            sql.append(" Con.Con_Fecha_Ini con_Fecha_ini, Con.Con_Fecha_Fin con_fecha_fin, Con.Con_Numero num_contrato,");
            sql.append(" Ta.Tap_codigo_Apuesta codApuesta, NVL(inv.inv_sillas,0) invSillas, con.con_codigo cod_contrato, Inv.Inv_Estado estado, Inv.Inv_Codigo inv_codigo");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join sii_solicitud_autoriza sau on (nov.sau_codigo= sau.sau_codigo)");
            sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" where sau.sau_codigo = #idSolicitud ");
            sql.append(" and to_number(replace(Ta.Tap_codigo_Apuesta, 'NA', '0')) IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17) ");
            sql.append(" and Inv.Inv_Estado in ('PA','PR')");
            sql.append(" group by ta.tap_nombre , ta.tap_codigo,Ta.Tap_Der_Expl_Formula,INSTR(TAP_GAST_ADM_FORMULA,'*'),TAP_GAST_ADM_FORMULA,");
            sql.append(" sysdate,sau.sau_numero_siito, sau.sau_nit, Per.Per_Jur_Nombre_Largo, Con.Con_Fecha_Ini, Con.Con_Fecha_Fin,");
            sql.append(" Con.Con_Numero, Ta.Tap_codigo_Apuesta,inv.inv_sillas,con.con_codigo,Inv.Inv_Estado, Inv.Inv_Codigo)s");
            sql.append(" GROUP BY s.codApuesta,s.invSillas,s.tap_codigo,s.tapNombre,s.valunidad,s.fechaExp,s.nit,s.razonSocial,s.con_Fecha_ini,s.con_fecha_fin,");
            sql.append(" s.num_contrato,s.cod_contrato, s.estado, s.inv_codigo)p");
            sql.append(" GROUP BY p.tipoApuesta,p.tapCodigo,p.tapNombre,p.valunidad,p.fechaExp,p.nit,p.razonSocial,p.fechaInicio,p.fechaFin,p.contrato,p.codContr, p.est");


            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idSolicitud", idSolicitud);
            query.setParameter("idContrato", idContrato);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO oficioLiquidacionPrevioVo = new OficioLiquidacionPrevioVO();
                    oficioLiquidacionPrevioVo.setTapCodigo(((BigDecimal) object[0]).longValue());
                    oficioLiquidacionPrevioVo.setCantidad(((BigDecimal) object[1]).intValue());
                    oficioLiquidacionPrevioVo.setTap_nombre((String) object[2]);
                    oficioLiquidacionPrevioVo.setValorUnidad((BigDecimal) object[3]);
                    /*oficioLiquidacionPrevioVo.setDerechosExplMensual((BigDecimal) object[4]);
                    oficioLiquidacionPrevioVo.setGastosAdministracionMensual((BigDecimal) object[5]);
                    oficioLiquidacionPrevioVo.setValorTotalMensual((BigDecimal) object[6]);*/
                    oficioLiquidacionPrevioVo.setFechaExpedicion((Date) object[4]);
                    //oficioLiquidacionPrevioVo.setNumeroSiito((String) object[8]);
                    oficioLiquidacionPrevioVo.setNit((String) object[5]);
                    oficioLiquidacionPrevioVo.setRazonSocial((String) object[6]);
                    oficioLiquidacionPrevioVo.setFechaInicioContrato((Date) object[7]);
                    oficioLiquidacionPrevioVo.setFechaFinContrato((Date) object[8]);
                    oficioLiquidacionPrevioVo.setCodigoApuesta((String) object[9]);
                    oficioLiquidacionPrevioVo.setNumeroContrato((String) object[10]);
                    oficioLiquidacionPrevioVo.setConCodigo(((BigDecimal) object[11]).longValue());
                    //oficioLiquidacionPrevioVo.setMesesLiquidados(((BigDecimal) object[14]).intValue());

                    /*oficioLiquidacionPrevioVo.setMinimoSillas(((BigDecimal) object[16]).intValue());
                    oficioLiquidacionPrevioVo.setInventarioSillas(((BigDecimal) object[17]).longValue());*/
                    oficioLiquidacionPrevioVo.setEstado((String) object[12]);

                    miListaOficiosTipoApuesta.add(oficioLiquidacionPrevioVo);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO");
        }
        return miListaOficiosTipoApuesta;
    }

    public List<Long> consultarCodigoInventarioPorSolicitud(Long idSolicitud) throws ExcepcionDAO {

        List<Long> elementosActualizar = new ArrayList();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select Inv.Inv_Codigo inv_codigo, Inv.Inv_Estado");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo)");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join sii_solicitud_autoriza sau on (nov.sau_codigo= sau.sau_codigo)");
            sql.append(" Inner Join sii_persona per on (sau.sau_nit = per.per_num_identificacion)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" where sau.sau_codigo = #idSolicitud and to_number(replace(Ta.Tap_codigo_Apuesta, 'NA', '0')) IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17) ");
            sql.append(" and Inv.Inv_Estado in ('PA','PR')");


            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idSolicitud", idSolicitud);

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    elementosActualizar.add(((BigDecimal) object[0]).longValue());

                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO");
        }
        return elementosActualizar;
    }

    public List<DuplaVO> buscarPagosPorContratoYDestino(long codigoContrato) throws ExcepcionDAO {

        List<DuplaVO> miListaConceptos = new ArrayList<DuplaVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT SUM(dr.dre_Valor),Cc.Ccu_Destino");
            sql.append(" FROM sii_detalle_recaudo dr");
            sql.append(" INNER JOIN sii_detalle_declaracion dd ON dr.dre_codigo = dd.dre_codigo");
            sql.append(" INNER JOIN sii_cuota_operador co ON co.cop_codigo = dd.cop_codigo");
            sql.append(" INNER JOIN sii_concepto_cuota cc ON cc.ccu_codigo = co.ccu_codigo");
            sql.append(" INNER JOIN sii_liquidacion_mes lm ON lm.lme_codigo = co.lme_codigo");
            sql.append(" WHERE lm.con_codigo =#codigoContrato and Cc.Ccu_Destino in ('ET','CJ')");
            sql.append(" GROUP BY Cc.Ccu_Destino");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("codigoContrato", codigoContrato);

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {

                for (Object[] object : results) {
                    DuplaVO dum = new DuplaVO();
                    dum.setValor((BigDecimal) object[0]);
                    dum.setConcepto((String) object[1]);
                    miListaConceptos.add(dum);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioLiquidacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "OficioLiquidacionDAO" + "");
        }
        return miListaConceptos;
    }

}
