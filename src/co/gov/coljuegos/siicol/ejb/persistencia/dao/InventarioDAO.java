/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 29-11-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoInstrumento;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.InstrumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadInventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestaVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ElementoAsociadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.InventarioMarcarMetVO;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
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
public class InventarioDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public InventarioDAO() {
        recursos = new Recursos();
    }

    public List<InventarioContratoVO> buscarInventarioPorContrato(Integer codigoContrato) throws ExcepcionDAO {

        List<InventarioContratoVO> miListaInventario = new ArrayList<InventarioContratoVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select con.con_codigo, con.con_numero, con.ope_codigo,con.con_fecha_ini, con.con_fecha_fin,");
            sql.append(" inv.inv_codigo,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,ta.tap_codigo,");
            sql.append(" ta.tap_der_expl_formula,ta.tap_gast_adm_formula,");
            sql.append(" ta.tap_codigo_apuesta, ta.tap_apuesta, ta.tap_min_sillas,inv.inv_sillas,ti.tin_codigo ");
            sql.append(" from sii_contrato con INNER JOIN sii_operador op on con.ope_codigo = op.ope_codigo ");
            sql.append(" INNER JOIN sii_instrumento ins on op.ope_codigo = ins.ope_codigo ");
            sql.append(" INNER JOIN sii_tipo_instrumento ti on ins.tin_codigo = ti.tin_codigo ");
            sql.append(" INNER JOIN sii_inventario inv on ins.ins_codigo = inv.ins_codigo ");
            sql.append(" INNER JOIN sii_tipo_apuesta ta on inv.tap_codigo = ta.tap_codigo");
            sql.append(" where con.con_codigo =#codigoContrato and inv.inv_estado='A'");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("codigoContrato", codigoContrato);

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {

                for (Object[] object : results) {
                    InventarioContratoVO miInventario = new InventarioContratoVO();

                    miInventario.setCodigoContrato(new Long(((BigDecimal) object[0]).longValue()));
                    miInventario.setNumeroContrato((String) object[1]);
                    miInventario.setCodigoOperador(new Long(((BigDecimal) object[2]).longValue()));
                    miInventario.setFechaInicioContrato((Date) object[3]);
                    miInventario.setFechaFinContrato((Date) object[4]);
                    miInventario.setCodigoInventario(new Long(((BigDecimal) object[5]).longValue()));
                    miInventario.setFechaInicioLiquidacion((Date) object[6]);
                    miInventario.setFechaFinLiquidacion((Date) object[7]);
                    miInventario.setCodigoTipoApuesta(new Long(((BigDecimal) object[8]).longValue()));
                    miInventario.setDerechosExplotacion((String) object[9]);
                    miInventario.setGastosAdministracion((String) object[10]);
                    miInventario.setCodigoApuesta(new Long((String) object[11]));
                    miInventario.setApuesta((String) object[12]);
                    if (object[13] != null) {
                        miInventario.setMinimoSillas(((BigDecimal) object[13]).intValue());
                    }
                    if (object[14] != null) {
                        miInventario.setInventarioSillas(((BigDecimal) object[14]).intValue());
                    }
                    miInventario.setTipoInstrumento(((BigDecimal) object[15]).longValue());
                    miListaInventario.add(miInventario);
                }
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioDAO");
        }
        return miListaInventario;
    }

    public List<InventarioContratoVO> buscarInventarioPorContrato(String contrato) throws ExcepcionDAO {

        List<InventarioContratoVO> miListaInventario = new ArrayList<InventarioContratoVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select con.con_codigo, con.con_numero, con.ope_codigo,con.con_fecha_ini, con.con_fecha_fin,");
            sql.append(" inv.inv_codigo,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,ta.tap_codigo,");
            sql.append(" ta.tap_der_expl_formula,ta.tap_gast_adm_formula,");
            sql.append(" ta.tap_codigo_apuesta, ta.tap_apuesta, ta.tap_min_sillas,inv.inv_sillas,ti.tin_codigo ");
            sql.append(" from sii_contrato con INNER JOIN sii_operador op on con.ope_codigo = op.ope_codigo ");
            sql.append(" INNER JOIN sii_instrumento ins on op.ope_codigo = ins.ope_codigo ");
            sql.append(" INNER JOIN sii_tipo_instrumento ti on ins.tin_codigo = ti.tin_codigo ");
            sql.append(" INNER JOIN sii_inventario inv on ins.ins_codigo = inv.ins_codigo ");
            sql.append(" INNER JOIN sii_tipo_apuesta ta on inv.tap_codigo = ta.tap_codigo");
            sql.append(" where con.con_numero =#contrato and inv.inv_estado='A'");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("contrato", contrato);

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {

                for (Object[] object : results) {
                    InventarioContratoVO miInventario = new InventarioContratoVO();

                    miInventario.setCodigoContrato(new Long(((BigDecimal) object[0]).longValue()));
                    miInventario.setNumeroContrato((String) object[1]);
                    miInventario.setCodigoOperador(new Long(((BigDecimal) object[2]).longValue()));
                    miInventario.setFechaInicioContrato((Date) object[3]);
                    miInventario.setFechaFinContrato((Date) object[4]);
                    miInventario.setCodigoInventario(new Long(((BigDecimal) object[5]).longValue()));
                    miInventario.setFechaInicioLiquidacion((Date) object[6]);
                    miInventario.setFechaFinLiquidacion((Date) object[7]);
                    miInventario.setCodigoTipoApuesta(new Long(((BigDecimal) object[8]).longValue()));
                    miInventario.setDerechosExplotacion((String) object[9]);
                    miInventario.setGastosAdministracion((String) object[10]);
                    miInventario.setCodigoApuesta(new Long((String) object[11]));
                    miInventario.setApuesta((String) object[12]);
                    if (object[13] != null) {
                        miInventario.setMinimoSillas(((BigDecimal) object[13]).intValue());
                    }
                    if (object[14] != null) {
                        miInventario.setInventarioSillas(((BigDecimal) object[14]).intValue());
                    }
                    miInventario.setTipoInstrumento(((BigDecimal) object[15]).longValue());
                    miListaInventario.add(miInventario);
                }
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioDAO");
        }
        return miListaInventario;
    }

    public List<SiiInventario> buscarInventarioActivoPorContrato(String conNumero) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv \n" + "FROM SiiInventario inv\n" + " JOIN inv.siiEstablecimiento est\n" + " JOIN inv.siiNovedad nov\n" + " JOIN nov.siiContrato con\n" +
                       "WHERE con.conNumero = :conNumero\n" + "AND inv.invEstado='A'");


            Query query = manager.createQuery(sql.toString());
            query.setParameter("conNumero", conNumero);
            return query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioDAO");
        }

    }

    public List<SiiInventario> buscarInventarioActivoPorEstablecimientoContrato(Long estCodigo, String conNumero) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv \n" + "FROM SiiInventario inv\n" + " JOIN inv.siiEstablecimiento est\n" + " JOIN inv.siiNovedad nov\n" + " JOIN nov.siiContrato con\n" +
                       "WHERE con.conNumero = :conNumero\n" + "AND est.estCodigo = :estCodigo\n" + "AND inv.invEstado='A'");


            Query query = manager.createQuery(sql.toString());
            query.setParameter("conNumero", conNumero);
            query.setParameter("estCodigo", estCodigo);
            return query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioDAO");
        }

    }

    public List<SiiInventario> buscarInventarioActivoPorEstablecimiento(Long estCodigo) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv \n" + "FROM SiiInventario inv\n" + " JOIN inv.siiEstablecimiento est\n" + " JOIN inv.siiNovedad nov\n" + " JOIN nov.siiContrato con\n" +
                       "WHERE est.estCodigo = :estCodigo\n" + "AND inv.invEstado='A'");


            Query query = manager.createQuery(sql.toString());
            query.setParameter("estCodigo", estCodigo);
            return query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioDAO");
        }

    }


    public SiiInventario buscarUltimoInstrumentoPorTipoElementoMet(String uidMet, String nuidMet, String serial, Long tipoElemento) throws ExcepcionDAO {

        SiiInventario miInventario = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select inv.* from Sii_Met met");
            sql.append(" Inner Join Sii_Instrumento ins on (met.met_codigo =ins.met_codigo)");
            sql.append(" Inner Join Sii_Tipo_Instrumento tins on  (Ins.Tin_Codigo = tins.tin_codigo and Tins.Tin_Codigo=#tipoElemento)");
            sql.append(" Inner Join Sii_Inventario inv on (Ins.Ins_Codigo = inv.ins_codigo)");
            sql.append(" where Met.Met_Uid = #uidMet");
            sql.append(" and Met.Met_Nuid = #nuidMet");
            sql.append(" and Met.Met_Serial = #serial");
            sql.append(" order by inv.inv_codigo desc");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("uidMet", uidMet);
            query.setParameter("nuidMet", nuidMet);
            query.setParameter("serial", serial);
            query.setParameter("tipoElemento", tipoElemento);

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    miInventario = new SiiInventario();
                    miInventario = (SiiInventario) object[0];
                    break;
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return miInventario;
    }

    public SiiInventario buscarUltimoInstrumentoPorTipoElementoYLocal(Long tipoElemento, String codLocal) throws ExcepcionDAO {
        SiiInventario miInventario = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select inv.* from Sii_Inventario inv");
            sql.append(" Inner Join Sii_Instrumento ins on (inv.ins_codigo = ins.ins_codigo)");
            sql.append(" Inner Join Sii_Tipo_Instrumento tins on (Ins.Tin_Codigo = tins.tin_codigo and Tins.Tin_Codigo=#tipoElemento)");
            sql.append(" Inner Join Sii_establecimiento est on (inv.est_codigo =est.est_codigo)");
            sql.append(" where est.est_cod_interno = #codLocal");
            sql.append(" order by inv.inv_codigo desc");


            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("tipoElemento", tipoElemento);
            query.setParameter("codLocal", codLocal);


            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    miInventario = new SiiInventario();
                    miInventario = (SiiInventario) object[0];
                    break;
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return miInventario;
    }

    public SiiInventario buscarUltimoInstrumentoPorTipoElementoApuestaYLocalPorOperador(Long tipoElemento, Long Tapuesta, String codLocal, Long CodCont) throws ExcepcionDAO {

        SiiInventario miInventario = null;

        try {
            /*
            select inv.* from Sii_Inventario inv
                         Inner Join Sii_Instrumento ins on (inv.ins_codigo = ins.ins_codigo)
                         Inner Join Sii_Tipo_Instrumento tins on (Ins.Tin_Codigo = tins.tin_codigo and Tins.Tin_Codigo= 3)
                         Inner Join Sii_establecimiento est on (inv.est_codigo =est.est_codigo)
                         Inner Join Sii_tipo_apuesta apu on (inv.tap_codigo  = apu.tap_codigo)
                         Inner Join Sii_novedad nov on (inv.nov_codigo  = nov.nov_codigo)
                         where est.est_cod_interno ='010'
                         and inv.inv_estado = 'A'
                         and apu.tap_codigo_apuesta = '14'
                         and nov.con_codigo=
                         order by inv.inv_codigo desc
             * */
            StringBuilder sql = new StringBuilder();
            sql.append(" select inv.* from Sii_Inventario inv");
            sql.append(" Inner Join Sii_Instrumento ins on (inv.ins_codigo = ins.ins_codigo)");
            sql.append(" Inner Join Sii_Tipo_Instrumento tins on (Ins.Tin_Codigo = tins.tin_codigo and Tins.Tin_Codigo= #tipoElemento)");
            sql.append(" Inner Join Sii_establecimiento est on (inv.est_codigo =est.est_codigo)");
            sql.append(" Inner Join Sii_tipo_apuesta apu on (inv.tap_codigo  = apu.tap_codigo)");
            sql.append(" Inner Join Sii_novedad nov on (inv.nov_codigo  = nov.nov_codigo)");
            sql.append(" where est.est_cod_interno = #codLocal");
            sql.append(" and inv.inv_estado = 'A'");
            sql.append(" and apu.tap_codigo_apuesta  = #tapcodigo");
            sql.append(" and nov.con_codigo= #codCont");
            sql.append(" order by inv.inv_codigo desc");


            Query query = manager.createNativeQuery(sql.toString(), SiiInventario.class);
            query.setParameter("tipoElemento", tipoElemento);
            query.setParameter("tapcodigo", Tapuesta + "");
            query.setParameter("codLocal", codLocal);
            query.setParameter("codCont", CodCont);


            List<SiiInventario> results = query.getResultList();
            if (results != null && !results.isEmpty()) {

                //for (Object[] object : results) {
                miInventario = new SiiInventario();
                //miInventario = (SiiInventario) object[0];
                miInventario = (SiiInventario) results.get(0);
                //  break;
                //}
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return miInventario;
    }

    public SiiInventario actualizarSiiInventario(SiiInventario siiInventario) throws ExcepcionDAO {
        try {
            manager.merge(siiInventario);
            manager.flush();
            return siiInventario;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
    }

    public SiiInventario insertarSiiInventario(SiiInventario inventario) throws ExcepcionDAO {
        try {
            manager.persist(inventario);
            manager.flush();
            return inventario;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
    }

    public SiiInventario buscarUltimoInstrumentoPorCodigoInsyLocal(Long codigoInstrumento, String codigoLocal) throws ExcepcionDAO {

        SiiInventario miInventario = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiInventario o INNER JOIN o.siiInstrumento pc ");
            sql.append(" Inner Join o.siiEstablecimiento ");
            sql.append(" WHERE o.siiInstrumento.insCodigo = :codigoInstrumento");
            sql.append(" AND o.siiEstablecimiento.estCodInterno = :codigoLocal");
            sql.append(" Order By o.inv_codigo desc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoInstrumento", codigoInstrumento);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    miInventario = new SiiInventario();
                    miInventario = (SiiInventario) object[0];
                    break;
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return miInventario;
    }

    public List<InventarioContratoVO> buscarInventarioPorNumeroContrato(String numeroContrato) throws ExcepcionDAO {

        List<InventarioContratoVO> miListaInventario = new ArrayList<InventarioContratoVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select con.con_codigo, con.con_numero, con.ope_codigo,con.con_fecha_ini, con.con_fecha_fin,");
            sql.append(" inv.inv_codigo,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,ta.tap_codigo,");
            sql.append(" ta.tap_der_expl_formula,ta.tap_gast_adm_formula,");
            sql.append(" ta.tap_codigo_apuesta, ta.tap_apuesta, ta.tap_min_sillas,inv.inv_sillas,ti.tin_codigo ");
            sql.append(" inv.nov_codigo ");
            sql.append(" from sii_contrato con INNER JOIN sii_operador op on con.ope_codigo = op.ope_codigo ");
            sql.append(" INNER JOIN sii_instrumento ins on op.ope_codigo = ins.ope_codigo ");
            sql.append(" INNER JOIN sii_tipo_instrumento ti on ins.tin_codigo = ti.tin_codigo ");
            sql.append(" INNER JOIN sii_inventario inv on ins.ins_codigo = inv.ins_codigo ");
            sql.append(" INNER JOIN sii_tipo_apuesta ta on inv.tap_codigo = ta.tap_codigo");
            sql.append(" where con.con_con_numero =#numeroContrato");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("numeroContrato", numeroContrato);

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {

                for (Object[] object : results) {
                    InventarioContratoVO miInventario = new InventarioContratoVO();

                    miInventario.setCodigoContrato(new Long(((BigDecimal) object[0]).longValue()));
                    miInventario.setNumeroContrato((String) object[1]);
                    miInventario.setCodigoOperador(new Long(((BigDecimal) object[2]).longValue()));
                    miInventario.setFechaInicioContrato((Date) object[3]);
                    miInventario.setFechaFinContrato((Date) object[4]);
                    miInventario.setCodigoInventario(new Long(((BigDecimal) object[5]).longValue()));
                    miInventario.setFechaInicioLiquidacion((Date) object[6]);
                    miInventario.setFechaFinLiquidacion((Date) object[7]);
                    miInventario.setCodigoTipoApuesta(new Long(((BigDecimal) object[8]).longValue()));
                    miInventario.setDerechosExplotacion((String) object[9]);
                    miInventario.setGastosAdministracion((String) object[10]);
                    miInventario.setCodigoApuesta(new Long((String) object[11]));
                    miInventario.setApuesta((String) object[12]);
                    if (object[13] != null) {
                        miInventario.setMinimoSillas(((BigDecimal) object[13]).intValue());
                    }
                    if (object[14] != null) {
                        miInventario.setInventarioSillas(((BigDecimal) object[14]).intValue());
                    }
                    miInventario.setTipoInstrumento(((BigDecimal) object[15]).longValue());
                    miInventario.setCodigoNovedad((Long) object[16]);
                    miListaInventario.add(miInventario);
                }
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioDAO");
        }
        return miListaInventario;
    }


    public List<SiiInventario> consultaInventarioPorNitContrato(String nit, String numeroContrato) throws ExcepcionDAO {

        List<SiiInventario> miListaInventario = new ArrayList<SiiInventario>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiNovedad.siiContrato con");
            sql.append(" INNER JOIN con.siiOperador.siiPersona per");
            sql.append(" WHERE inv.invEstado in('A')");
            sql.append(" AND per.perNumIdentificacion = :nit");
            sql.append(" AND con.conNumero = :numeroContrato");
            Query query = manager.createQuery(sql.toString(), SiiInventario.class);
            query.setParameter("numeroContrato", numeroContrato);
            query.setParameter("nit", nit);
            miListaInventario = query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return miListaInventario;
    }

    public List<SiiInventario> buscarInventarioPorNumOtroSi(Long consecutivoOtroSi) throws ExcepcionDAO {
        List<SiiInventario> miListaInventario = new ArrayList<SiiInventario>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiInventario o INNER JOIN o.siiNovedad nov ");
            sql.append(" Inner Join nov.siiContrato ");
            sql.append(" WHERE nov.siiOtrosi.osiConsecutivo = :consecutivoOtroSi");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("consecutivoOtroSi", consecutivoOtroSi);
            miListaInventario = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return miListaInventario;
    }


    public void actualizarInventarioFechasLiqConEstadoActivo(Date invFechaIniLiq, Date invFechaFinLiq, Long novCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE SiiInventario o SET o.invFechaIniLiq = :invFechaIniLiq, o.invFechaFinLiq = :invFechaFinLiq, o.invEstado = 'A' WHERE o.siiNovedad.novCodigo = :novCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("invFechaIniLiq", invFechaIniLiq);
            query.setParameter("invFechaFinLiq", invFechaFinLiq);
            query.setParameter("novCodigo", novCodigo);
            query.executeUpdate();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");

        }
    }

    public InventarioVO buscarUltimoRegistroMetActivo(String idMet) throws ExcepcionDAO {
        SiiInventario miInventario = null;
        InventarioVO inventarioVo = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT inv from SiiInventario inv INNER JOIN inv.siiInstrumento ins ");
            sql.append(" Inner Join ins.siiTipoInstrumento tip ");
            sql.append(" WHERE ins.siiMet.metCodigo = :idMet ");
            sql.append(" AND inv.invEstado = 'A'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("idMet", Long.parseLong(idMet));
            miInventario = (SiiInventario) query.getSingleResult();

            inventarioVo = new InventarioVO(miInventario);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioVo;
    }

    /**
     * @author Giovanni
     * @param idTerminalACDV
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarUltimoRegistroACDVActivo(String idTerminalACDV) throws ExcepcionDAO {
        SiiInventario siiInventario = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" WHERE ins.siiTerminalAcdv.tacCodigo = :idTerminalACDV ");
            sql.append(" AND inv.invEstado = 'A'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("idTerminalACDV", Long.parseLong(idTerminalACDV));
            siiInventario = (SiiInventario) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return siiInventario;
    }

    public InventarioVO buscarUltimoRegistroBingoActivo(String idLocal) throws ExcepcionDAO {
        SiiInventario miInventario = null;
        InventarioVO inventarioVo = new InventarioVO();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select * from sii_inventario inv ");
            sql.append(" Inner Join sii_Instrumento ins on inv.ins_codigo=ins.ins_codigo  ");
            sql.append(" inner join sii_tipo_instrumento tip on ins.tin_codigo=tip.tin_codigo ");
            sql.append(" inner join sii_establecimiento est on inv.est_codigo=est.est_codigo");
            sql.append(" where est.est_codigo = #idLocal and  ins.met_codigo=2 and inv.inv_estado='A'");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idLocal", Long.parseLong(idLocal));
            //miInventario =(SiiInventario) query.getSingleResult();
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    miInventario = new SiiInventario();

                    inventarioVo.setInvCodigo(new Long(((BigDecimal) object[0]).longValue()));
                    inventarioVo.setInvFechaIniLiq((Date) object[1]);
                    inventarioVo.setInvFechaFinLiq((Date) object[2]);
                    inventarioVo.setInvFechaIniOfi((Date) object[3]);
                    inventarioVo.setInvFechaFinOfi((Date) object[4]);
                    inventarioVo.setInvEstado((String) object[5]);
                    NovedadVO unaNovedadVo = new NovedadVO();
                    unaNovedadVo.setNovCodigo(new Long(((BigDecimal) object[6]).longValue()));
                    inventarioVo.setNovedadVo(unaNovedadVo);
                    EstablecimientoVO unEstablecimientoVo = new EstablecimientoVO();
                    unEstablecimientoVo.setEstCodigo(new Long(((BigDecimal) object[7]).longValue()));
                    InstrumentoVO unIntrumentoVo = new InstrumentoVO();
                    unIntrumentoVo.setInsCodigo(new Long(((BigDecimal) object[8]).longValue()));
                    inventarioVo.setInstrumentoVo(unIntrumentoVo);
                    TipoApuestaVO tipoApuestaVo = new TipoApuestaVO();
                    tipoApuestaVo.setTapCodigo(new Long(((BigDecimal) object[9]).longValue()));
                    inventarioVo.setTipoApuestaVo(tipoApuestaVo);
                    inventarioVo.setInvSillas((new Long(((BigDecimal) object[10]).longValue())).intValue());

                    break;
                }
            }


            return inventarioVo;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }

    }

    public SiiInventario buscarInventarioPorId(Long idCodigo) throws ExcepcionDAO {
        SiiInventario resultadoSiiInventario = new SiiInventario();
        try {
            resultadoSiiInventario = (SiiInventario) manager.find(SiiInventario.class, idCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CdpDAO");
        }
        return resultadoSiiInventario;
    }

    /**
     *Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author David Tafur
     * @param codigoEstablecimiento
     * @param codSerialMet
     * @param codNuidMet
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioXEstablecimientoYDatosMet(long codigoEstablecimiento, String serialMet, String nuidMet) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" WHERE est.estCodigo = :codigoEstablecimiento");
            if (nuidMet != null && !nuidMet.equals("")) {
                sql.append(" AND met.metUid = :codNuidMet");
            }
            sql.append(" AND met.metSerial = :codSerialMet");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoEstablecimiento", codigoEstablecimiento);
            if (nuidMet != null && !nuidMet.equals(""))
                consulta.setParameter("codNuidMet", nuidMet);
            consulta.setParameter("codSerialMet", serialMet);

            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();

            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }

    /**
     *Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author David Tafur
     * @param codigoEstablecimiento
     * @param codSerialMet
     * @param coduidMet
     * @param contrato
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioXEstablecimientoYDatosMet(long codigoEstablecimiento, String serialMet, String uidMet, String contrato) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv.* FROM  sii_Contrato con, sii_Novedad nov,Sii_Inventario inv,sii_Instrumento ins,sii_Met met");
            sql.append(" WHERE con.con_numero='" + contrato + "'");
            sql.append(" AND con.con_codigo=nov.con_codigo");
            sql.append(" AND nov.nov_codigo=inv.nov_codigo");
            sql.append(" AND inv.inv_estado ='A'");
            sql.append(" AND inv.est_Codigo = " + codigoEstablecimiento);
            sql.append(" AND inv.ins_codigo=ins.ins_codigo");
            sql.append(" AND (ins.met_codigo=met.met_codigo");
            if (uidMet != null && !uidMet.equals("")) {
                sql.append(" AND met.met_uid = '" + uidMet + "'");
            }
            sql.append(" AND met.met_Serial = '" + serialMet + "')");

            Query consulta = manager.createNativeQuery(sql.toString(), SiiInventario.class);
            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();

            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }


    /**
     *Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author David Tafur
     * @param codigoEstablecimiento
     * @param codSerialMet
     * @param codNuc
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioXEstablecimientoYserialYuid(long codigoEstablecimiento, String serialMet, Long metUid) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = new SiiInventario();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" WHERE est.estCodigo = :codigoEstablecimiento");
            if (metUid != null && !metUid.equals(""))
                sql.append(" AND met.metUid = :metUid");
            sql.append(" AND met.metSerial = :codSerialMet");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoEstablecimiento", codigoEstablecimiento);
            if (metUid != null && !metUid.equals(""))
                consulta.setParameter("metUid", metUid);
            consulta.setParameter("codSerialMet", serialMet);

            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();

            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }


    /**
     *Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author David Tafur
     * @param codigoLocal
     * @param contrato
     * @param uid
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioXUIDYContrato(String uid, String contrato, String codigoLocal) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" WHERE met.metUid = :codUidMet");
            sql.append(" AND inv.invEstado = 'A'");
            sql.append(" AND con.conNumero = :conNumero");
            sql.append(" AND est.estCodInterno = :codLocal");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codUidMet", uid);
            consulta.setParameter("conNumero", contrato);
            consulta.setParameter("codLocal", codigoLocal);

            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();
            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }

    public SiiInventario buscarInventarioXUID(String uid) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" WHERE met.metUid = :codUidMet");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codUidMet", uid);


            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();
            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }


    /**
     *Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author David Tafur
     * @param codigoLocal
     * @param serialMet
     * @param codNuidMet
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioXOperadorXSerialXMarcaYContrato(long codOperador, String serialMet, long marcaMet, String contrato, String codigoLocal) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN con.siiOperador ope");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca mar");
            sql.append(" WHERE ope.opeCodigo = :codOperador");
            sql.append(" AND met.metSerial = :codSerial");
            sql.append(" AND mar.marCodigo = :codMarcaMet");
            if (contrato != null) {
                sql.append(" AND con.conNumero = :conNumero");
            }
            if (codigoLocal != null) {
                sql.append(" AND est.estCodInterno = :codLocal");
            }

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codOperador", codOperador);
            consulta.setParameter("codSerial", serialMet);
            consulta.setParameter("codMarcaMet", marcaMet);
            if (contrato != null) {
                consulta.setParameter("conNumero", contrato);
            }
            if (codigoLocal != null) {
                consulta.setParameter("codLocal", codigoLocal);
            }

            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();

            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }

    /**
     * @author Giovanni
     * @param codOperador
     * @param serial
     * @param marca
     * @param contrato
     * @param codigoLocal
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioACDVXOperadorXSerialXMarcaYContrato(long codOperador, String serial, long marca, String contrato, String codigoLocal) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN con.siiOperador ope");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiTerminalAcdv tac");
            sql.append(" INNER JOIN tac.siiMarca mar");
            sql.append(" WHERE ope.opeCodigo = :codOperador");
            sql.append(" AND tac.tacSerial = :codSerial");
            sql.append(" AND mar.marCodigo = :codMarca");
            sql.append(" AND con.conNumero = :conNumero");
            sql.append(" AND est.estCodInterno = :codLocal");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codOperador", codOperador);
            consulta.setParameter("codSerial", serial);
            consulta.setParameter("codMarca", marca);
            consulta.setParameter("conNumero", contrato);
            consulta.setParameter("codLocal", codigoLocal);

            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();

            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }

    /**
     *Metodo encargado de buscar todos los registros del inventario para un contrato, los cuales deben estar
     * entre unas fechas determinadas
     * @author David Tafur
     * @param numeroContrato
     * @return
     * @throws ExcepcionDAO
     */
    public List<ElementoAsociadoWSVO> buscarInventarioPorNumContratoFechaVigencia(String numeroContrato, Date fechaPrimerDia, Date fechaUltimoDia) throws ExcepcionDAO {

        List<ElementoAsociadoWSVO> listaElementosAsociadosWSVO = new ArrayList<ElementoAsociadoWSVO>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaPrimerDiaPeriodo = "TO_DATE('" + formatter.format(fechaPrimerDia) + "','YYYY/MM/DD HH24:MI:SS') ";
        String fechaUltimoDiaPeriodo = "TO_DATE('" + formatter.format(fechaUltimoDia) + "','YYYY/MM/DD HH24:MI:SS') ";

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tap_codigo,  tap_nombre,  cantidad,  valor,  valor/cantidad\n" + 
            "  FROM\n" + 
            "  (SELECT ta.tap_codigo,    ta.tap_nombre,    COUNT(inv.inv_codigo) cantidad , SUM((fn_calcula_de(Tap_Der_Expl_Formula))/31) valor\n" + 
            "  FROM sii_inventario inv\n" + 
            "  INNER JOIN sii_tipo_apuesta ta  ON (inv.tap_codigo = ta.tap_codigo )\n" + 
            "  LEFT OUTER JOIN sii_novedad nov  ON (inv.nov_codigo = nov.nov_codigo)\n" + 
            "  LEFT OUTER JOIN Sii_Establecimiento est  ON (Inv.Est_Codigo = est.Est_Codigo)\n" + 
            "  LEFT OUTER JOIN sii_instrumento ins  ON (inv.ins_codigo        = ins.ins_codigo)\n" + 
            "  LEFT OUTER JOIN Sii_Contrato con  ON (nov.con_codigo = con.con_codigo)\n" + 
            "  WHERE con.con_numero  = '" + numeroContrato + "' \n" + 
            "  AND inv.inv_estado       IN('A','PR','R')\n" + 
            "  AND ins.tin_codigo NOT   IN (1)\n" + 
            "  AND inv.inv_fecha_ini_liq < " + fechaUltimoDiaPeriodo + " \n" + 
            "  AND inv.inv_fecha_fin_liq > " + fechaPrimerDiaPeriodo + " \n" + 
            "  GROUP BY ta.tap_codigo,    ta.tap_nombre,  3\n" + 
            "  UNION\n" + 
            "  SELECT ta.tap_codigo,    ta.tap_nombre,    COUNT(inv.inv_codigo) cantidad ,    SUM((fn_calcula_de(Tap_Der_Expl_Formula))/31) valor\n" + 
            "  FROM sii_inventario inv  \n" + 
            "  INNER JOIN sii_tipo_apuesta ta  ON (inv.tap_codigo = ta.tap_codigo )\n" + 
            "  LEFT OUTER JOIN sii_novedad nov  ON (inv.nov_codigo = nov.nov_codigo)\n" + 
            "  LEFT OUTER JOIN Sii_Contrato con  ON (nov.con_codigo = con.con_codigo)\n" + 
            "  LEFT OUTER JOIN Sii_Establecimiento est  ON (Inv.Est_Codigo = est.Est_Codigo)\n" + 
            "  LEFT OUTER JOIN sii_instrumento ins  ON (inv.ins_codigo = ins.ins_codigo)\n" + 
            "  LEFT OUTER JOIN sii_met met  ON (ins.met_codigo        = met.met_codigo)\n" + 
            "  WHERE con.con_numero      = '" + numeroContrato + "' \n" + 
            "  AND inv.inv_estado       IN('A','PR','R')\n" + 
            "  AND met.met_online        ='N'\n" + 
            "  AND inv.inv_fecha_ini_liq < " + fechaUltimoDiaPeriodo + "\n" + 
            "  AND inv.inv_fecha_fin_liq > " + fechaPrimerDiaPeriodo + "\n" + 
            "  GROUP BY ta.tap_codigo,    ta.tap_nombre,    3\n" + 
            "  );\n  ") ;
            
            Query query = manager.createNativeQuery(sql.toString());

            List<Object[]> results = query.getResultList();

            for (Object[] object : results) {
                ElementoAsociadoWSVO elementoAsociadoWSVO = new ElementoAsociadoWSVO();
                elementoAsociadoWSVO.tipoApuesta = ((BigDecimal) object[0]).longValue();
                if (object[2] != null && ((BigDecimal) object[2]).longValue() > 0) {
                    elementoAsociadoWSVO.cantidadElemento = ((BigDecimal) object[2]).longValue();
                }
                if (object[3] != null) {
                    elementoAsociadoWSVO.ventasMet = ((BigDecimal) object[3]);
                }
                if (object[4] != null) {
                    elementoAsociadoWSVO.valorDerechosExp = ((BigDecimal) object[4]);
                }
                if (object[1] != null) {
                    elementoAsociadoWSVO.nombreApuesta = ((String) object[1]);
                }
                if (elementoAsociadoWSVO.cantidadElemento > 0) {
                    listaElementosAsociadosWSVO.add(elementoAsociadoWSVO);
                }
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return listaElementosAsociadosWSVO;
    }

    /**
     * @author Giovanni
     * @param numeroContrato
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiInventario> buscarInventarioPorNumContratoActivo(String numeroContrato) throws ExcepcionDAO {

        List<SiiInventario> miListaInventario = new ArrayList<SiiInventario>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiInventario o");
            sql.append(" INNER JOIN o.siiNovedad nov");
            sql.append(" WHERE nov.siiContrato.conNumero = :numeroContrato");
            sql.append(" AND o.invEstado = 'A'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("numeroContrato", numeroContrato);
            miListaInventario = query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return miListaInventario;
    }

    /**
     * @author Giovanni
     * @param codigoNovedad
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiInventario> buscarInventarioPorNovedadEstadoPA(Long codigoNovedad) throws ExcepcionDAO {
        List<SiiInventario> siiInventarios = new ArrayList<SiiInventario>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT inv FROM SiiInventario inv");
            sql.append(" WHERE inv.siiNovedad.novCodigo = :codigoNovedad");
            sql.append(" AND inv.invEstado = 'PA'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoNovedad", codigoNovedad);

            siiInventarios = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return siiInventarios;
    }

    /**
     * @author Giovanni
     * @param codigoNovedad
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiInventario> buscarInventarioPorNovedadEstadoPR(Long codigoNovedad) throws ExcepcionDAO {
        List<SiiInventario> siiInventarios = new ArrayList<SiiInventario>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT inv FROM SiiInventario inv");
            sql.append(" WHERE inv.siiNovedad.novCodigo = :codigoNovedad");
            sql.append(" AND inv.invEstado = 'PR'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoNovedad", codigoNovedad);

            siiInventarios = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return siiInventarios;
    }

    /**
     * @author
     * @param codNovedad
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiInventario> buscarInventarioPorNovedad(Long codNovedad) throws ExcepcionDAO {
        List<SiiInventario> siiInventarios = new ArrayList<SiiInventario>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" WHERE inv.siiNovedad.novCodigo = :codNovedad");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codNovedad", codNovedad);

            siiInventarios = query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return siiInventarios;
    }

    /**
     * @author Giovanni
     * @param nuc
     * @param estado
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioMETXCriterios(String nuc, String estado) throws ExcepcionDAO {
        SiiInventario siiInventario = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" WHERE met.metUid = :nuc");
            if (estado != null) {
                sql.append(" AND inv.invEstado = :estado");
            }

            Query query = manager.createQuery(sql.toString());
            query.setParameter("nuc", nuc);

            if (estado != null) {
                query.setParameter("estado", estado);
            }

            List<SiiInventario> siiInventarios = query.getResultList();
            if (siiInventarios != null && !siiInventarios.isEmpty()) {
                siiInventario = siiInventarios.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }

        return siiInventario;
    }

    /**
     *Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author David Tafur
     * @author Modifica Giovanni
     * @param marca
     * @param serial
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioMetPorSerialMarca(String serial, long marca) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca marca");
            sql.append(" WHERE met.metSerial = :serialMet");
            sql.append(" AND inv.invEstado = 'A'");
            sql.append(" AND marca.marCodigo = :marcaMet");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("serialMet", serial);
            consulta.setParameter("marcaMet", marca);

            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();
            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }


    /**
     *Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author alan
     * @param marcas
     * @param serial
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiInventario> buscarInventarioMetPorSerialMarca(String serial, List<Long> marcas, String estado) throws ExcepcionDAO {
        List<SiiInventario> inventarioCumpleCriterios = new ArrayList();
        ;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv.* FROM Sii_Inventario inv");
            sql.append(" INNER JOIN sii_Instrumento ins on inv.ins_codigo=ins.ins_codigo");
            sql.append(" INNER JOIN sii_Met met on met.met_codigo=ins.met_codigo");
            sql.append(" INNER JOIN sii_Marca marca on marca.mar_codigo=met.mar_codigo");
            /*sql.append(" WHERE met.met_Serial = '"+serial+"'");
            if (estado != null) {
                sql.append(" AND inv.inv_Estado = '"+estado+"'");
            }
            String inmarcas = marcas.toString().replace("[","").replace("]","");
            sql.append(" AND marca.mar_Codigo in("+inmarcas+")");            
            //sql.append(" AND marca.mar_Codigo in(#marcasMet)");*/

            sql.append(" WHERE met.met_Serial = #serialMet");
            if (estado == null) {
                sql.append(" AND inv.inv_Estado in ('I','R','F')");
            }
            if (estado != null) {
                sql.append(" AND inv.inv_Estado = #estado");
            }
            String inmarcas = marcas.toString().replace("[","").replace("]","");
            sql.append(" AND marca.mar_Codigo in("+inmarcas+")");
            Query consulta = manager.createNativeQuery(sql.toString(),SiiInventario.class);
            consulta.setParameter("serialMet",serial);
            if (estado != null) {
                consulta.setParameter("estado",estado);
            }         
            
            //consulta.setParameter("marcasMet", inmarcas);
            
            List<SiiInventario> listaInventario = consulta.getResultList();
            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario;
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }


    /**
     * Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @author Giovanni
     * @param marca
     * @param serial
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioACDVPorSerialMarca(String serial, long marca) throws ExcepcionDAO {
        SiiInventario siiInventario = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiTerminalAcdv tac");
            sql.append(" INNER JOIN tac.siiMarca mar");
            sql.append(" WHERE tac.tacSerial = :serial");
            sql.append(" AND inv.invEstado = 'A'");
            sql.append(" AND mar.marCodigo = :marca");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("serial", serial);
            consulta.setParameter("marca", marca);

            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();
            if (listaInventario != null && !listaInventario.isEmpty()) {
                siiInventario = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return siiInventario;
    }

    /**
     * Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author Giovanni
     * @param serialMet
     * @param marcaMet
     * @param contrato
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioXSerialXMarcaContratoActivos(String serialMet, long marcaMet, String contrato) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca mar");
            sql.append(" WHERE met.metSerial = :codSerial");
            sql.append(" AND mar.marCodigo = :codMarcaMet");
            sql.append(" AND con.conNumero = :conNumero");
            sql.append(" AND inv.invEstado = 'A'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codSerial", serialMet);
            query.setParameter("codMarcaMet", marcaMet);
            query.setParameter("conNumero", contrato);

            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = query.getResultList();

            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }

    /**
     *Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author David Tafur
     * @param codigoEstablecimiento
     * @param codSerialMet
     * @param codNuidMet
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario buscarInventarioXSerialXMarcaContratoYNUC(String serialMet, long marcaMet, String contrato, String nuc) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca mar");
            sql.append(" WHERE inv.invEstado = 'A'");
            sql.append(" AND met.metSerial = :codSerial");
            sql.append(" AND mar.marCodigo = :codMarcaMet");
            sql.append(" AND con.conNumero = :conNumero");
            if (nuc != null && !nuc.equals("")) {
                sql.append(" AND met.metUid = :nuc");
            }

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codSerial", serialMet);
            consulta.setParameter("codMarcaMet", marcaMet);
            consulta.setParameter("conNumero", contrato);

            if (nuc != null && !nuc.equals("")) {
                consulta.setParameter("nuc", nuc);
            }

            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();

            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }


    public SiiInventario buscarInventarioXSerialXMarcaXLocalContratoYNUC(String serialMet, long marcaMet, String contrato, String nuc, String codLocalIterno) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca mar");
            sql.append(" WHERE inv.invEstado = 'A'");
            sql.append(" AND est.estCodInterno = :codLocalIterno");
            sql.append(" AND met.metSerial = :codSerial");
            sql.append(" AND mar.marCodigo = :codMarcaMet");
            sql.append(" AND con.conNumero = :conNumero");

            if (nuc != null && !nuc.equals("")) {
                sql.append(" AND met.metUid = :nuc");
            }

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codLocalIterno", codLocalIterno);
            consulta.setParameter("codSerial", serialMet);
            consulta.setParameter("codMarcaMet", marcaMet);
            consulta.setParameter("conNumero", contrato);
            if (nuc != null && !nuc.equals("")) {
                consulta.setParameter("nuc", nuc);
            }
            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();

            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }

    /**
     *Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author David Tafur
     * @param codigoEstablecimiento
     * @param codSerialMet
     * @param codNuidMet
     * @return
     * @throws ExcepcionDAO
     */
    //public SiiInventario buscarInventarioBingoPorSillasYEstablecimientoTipoApuestaYContrato(int sillas, String codIntEstablecimiento,String codMun, Long tipoApuesta, Long contrato) throws ExcepcionDAO {
    public SiiInventario buscarInventarioBingoPorEstablecimientoTipoApuestaYContrato(String codIntEstablecimiento, String codMun, Long tipoApuesta, Long contrato) throws ExcepcionDAO {
        SiiInventario inventarioCumpleCriterios = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiTipoApuesta tap");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            //sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" WHERE inv.invEstado = 'A'");
            //sql.append(" AND inv.invSillas =:sillas");
            sql.append(" AND est.estCodInterno = :codIntEstablecimiento");
            sql.append(" AND est.siiUbicacion1.ubiCodigo= :codMun");
            sql.append(" AND tap.tapCodigoApuesta = :tipoApuesta");
            sql.append(" AND con.conCodigo = :contrato");

            Query consulta = manager.createQuery(sql.toString());
            //consulta.setParameter("sillas", sillas);
            consulta.setParameter("codIntEstablecimiento", codIntEstablecimiento);
            consulta.setParameter("codMun", codMun);
            consulta.setParameter("tipoApuesta", tipoApuesta.toString());
            consulta.setParameter("contrato", contrato);

            List<SiiInventario> listaInventario = new ArrayList<>();
            listaInventario = consulta.getResultList();

            if (listaInventario != null && !listaInventario.isEmpty()) {
                inventarioCumpleCriterios = listaInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return inventarioCumpleCriterios;
    }


    /**
     *Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author David Tafur
     * @param codigoEstablecimiento
     * @param codSerialMet
     * @param codNuidMet
     * @return
     * @throws ExcepcionDAO
     */

    public List<SiiInventario> buscarInventarioMesaPorEstablecimientoYContrato(String codIntEstablecimiento, String contrato) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiTipoApuesta tap");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMesaCasino mesa");
            sql.append(" WHERE est.estCodInterno = :codIntEstablecimiento");
            sql.append(" AND con.conNumero = :contrato");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codIntEstablecimiento", codIntEstablecimiento);
            consulta.setParameter("contrato", contrato);


            listaInventario = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return listaInventario;
    }

    public List<SiiInventario> buscarInventarioMesaPorContrato(Long contrato) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            //sql.append(" INNER JOIN inv.siiTipoApuesta tap");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            //sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            //sql.append(" INNER JOIN ins.siiMesaCasino mesa");

            sql.append(" WHERE con.conCodigo = :contrato");
            sql.append(" AND inv.invEstado = 'A'");
            sql.append(" AND ins.siiTipoInstrumento.tinCodigo = :tipoinst");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("contrato", contrato);
            consulta.setParameter("tipoinst", EnumTipoInstrumento.MESA_DE_CASINO.getId());


            listaInventario = consulta.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return listaInventario;
    }

    /**
     * Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author Giovanni
     * @param codIntEstablecimiento
     * @param contrato
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiInventario> buscarInventarioOtroPorEstablecimientoYContrato(String codIntEstablecimiento, String contrato) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiTipoApuesta tap");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMesaCasino mesa");
            sql.append(" WHERE est.estCodInterno = :codIntEstablecimiento");
            sql.append(" AND con.conNumero = :contrato");
            sql.append(" AND ins.siiTipoInstrumento.tinCodigo = 4");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codIntEstablecimiento", codIntEstablecimiento);
            consulta.setParameter("contrato", contrato);


            listaInventario = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return listaInventario;
    }

    /**
     *Metodo encargado de retornar todo el inventario de los operadores que no hicieron la marcacion del 30 porciento
     * de sus mets y se les debe decir cuales van a marcar
     * @return
     */
    public List<InventarioMarcarMetVO> consultarInventarioOperadoresNoMarcaOnline(long codOperador) throws ExcepcionDAO {
        List<InventarioMarcarMetVO> listaInventario = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT persel.per_num_identificacion,persel.per_jur_nombre_largo,opesel.ope_tipo_poblac,metsel.met_uid,metsel.met_serial,marca.mar_nombre,estsel.est_cod_interno,metsel.met_codigo FROM sii_establecimiento estsel");
            sql.append(" INNER JOIN sii_inventario invsel ON estsel.est_codigo = invsel.est_codigo");
            sql.append(" INNER JOIN sii_operador opesel ON estsel.ope_codigo = opesel.ope_codigo");
            sql.append(" INNER JOIN sii_persona persel ON opesel.per_codigo = persel.per_codigo");
            sql.append(" INNER JOIN sii_novedad novsel ON invsel.nov_codigo = novsel.nov_codigo");
            sql.append(" INNER JOIN sii_instrumento inssel ON invsel.ins_codigo = inssel.ins_codigo");
            sql.append(" INNER JOIN sii_met metsel ON metsel.met_codigo = inssel.met_codigo");
            sql.append(" INNER JOIN sii_marca marca ON metsel.mar_codigo = marca.mar_codigo");
            sql.append(" INNER JOIN sii_ente_territorial entsel ON estsel.ubi_codigo = entsel.ubi_codigo");
            sql.append(" WHERE invsel.inv_estado IN('A')");
            sql.append(" AND opesel.ope_codigo = #codOperador");
            sql.append(" AND invsel.inv_pg = 'S'");
            sql.append(" ORDER BY entsel.eti_poblac_p_2014 DESC");

            Query consulta = manager.createNativeQuery(sql.toString());
            consulta.setParameter("codOperador", codOperador);

            List<Object[]> results = consulta.getResultList();
            listaInventario = new ArrayList<InventarioMarcarMetVO>();
            for (Object[] object : results) {
                InventarioMarcarMetVO inventarioMarcarMetVO = new InventarioMarcarMetVO();

                inventarioMarcarMetVO.setPerNumeroIdentificacion((String) object[0]);
                inventarioMarcarMetVO.setPerJurNombreLargo((String) object[1]);
                inventarioMarcarMetVO.setTipoPoblacionOperador((String) object[2]);
                inventarioMarcarMetVO.setMetNuc((String) object[3]);
                inventarioMarcarMetVO.setMetSerial((String) object[4]);
                inventarioMarcarMetVO.setMetMarca((String) object[5]);
                inventarioMarcarMetVO.setCodInternoLocal((String) object[6]);
                inventarioMarcarMetVO.setMetCodigo(((BigDecimal) object[7]).longValue());

                listaInventario.add(inventarioMarcarMetVO);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return listaInventario;

    }

    /**
     * @author Giovanni
     * @param nuc
     * @param contrato
     * @param codigoLocal
     * @param codigoDane
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario validarNUCXContratoXCodigoLocalXCodigoDane(String nuc, String contrato, String codigoLocal, String codigoDane) throws ExcepcionDAO {
        SiiInventario siiInventario = null;
        List<SiiInventario> siiInventarios = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiTipoApuesta tap");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN est.siiUbicacion1 ubi");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" WHERE inv.invEstado = 'A'");
            sql.append(" AND met.metUid = :nuc");
            sql.append(" AND con.conNumero = :contrato");
            sql.append(" AND est.estCodInterno = :codLocal");
            sql.append(" AND ubi.ubiCodigo = :codDane");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("nuc", nuc);
            query.setParameter("contrato", contrato);
            query.setParameter("codLocal", codigoLocal);
            query.setParameter("codDane", codigoDane);

            siiInventarios = query.getResultList();
            if (siiInventarios != null && !siiInventarios.isEmpty()) {
                siiInventario = siiInventarios.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }

        return siiInventario;
    }

    /**
     * @author Giovanni
     * @param serial
     * @param marca
     * @param contrato
     * @param codigoLocal
     * @param codigoDane
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario validarMETSerialYMarcaXContratoXCodigoLocalXCodigoDane(String serial, Long marca, String contrato, String codigoLocal, String codigoDane) throws ExcepcionDAO {
        SiiInventario siiInventario = null;
        List<SiiInventario> siiInventarios = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            //sql.append(" INNER JOIN inv.siiTipoApuesta tap");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN est.siiUbicacion1 ubi");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca mar");
            sql.append(" WHERE inv.invEstado = 'A'");
            sql.append(" AND met.metSerial = :serial");
            sql.append(" AND mar.marCodigo = :marca");
            sql.append(" AND con.conNumero = :contrato");
            sql.append(" AND est.estCodInterno = :codLocal");
            sql.append(" AND ubi.ubiCodigo = :codDane");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("serial", serial);
            query.setParameter("marca", marca);
            query.setParameter("contrato", contrato);
            query.setParameter("codLocal", codigoLocal);
            query.setParameter("codDane", codigoDane);

            siiInventarios = query.getResultList();
            if (siiInventarios != null && !siiInventarios.isEmpty()) {
                siiInventario = siiInventarios.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }

        return siiInventario;
    }


    /**
     * @author Giovanni
     * @param serial
     * @param marca
     * @param contrato
     * @param codigoLocal
     * @param codigoDane
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInventario validarACDVSerialYMarcaXContratoXCodigoLocalXCodigoDane(String serial, Long marca, String contrato, String codigoLocal, String codigoDane) throws ExcepcionDAO {
        SiiInventario siiInventario = null;
        List<SiiInventario> siiInventarios = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiTipoApuesta tap");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN est.siiUbicacion1 ubi");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiTerminalAcdv tac");
            sql.append(" INNER JOIN tac.siiMarca mar");
            sql.append(" WHERE inv.invEstado = 'A'");
            sql.append(" AND tac.tacSerial = :serial");
            sql.append(" AND mar.marCodigo = :marca");
            sql.append(" AND con.conNumero = :contrato");
            sql.append(" AND est.estCodInterno = :codLocal");
            sql.append(" AND ubi.ubiCodigo = :codDane");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("serial", serial);
            query.setParameter("marca", marca);
            query.setParameter("contrato", contrato);
            query.setParameter("codLocal", codigoLocal);
            query.setParameter("codDane", codigoDane);

            siiInventarios = query.getResultList();
            if (siiInventarios != null && !siiInventarios.isEmpty()) {
                siiInventario = siiInventarios.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }

        return siiInventario;
    }

    /**
     * Metodo encargado de consultar el nuemro de sillas relacionados con un operador
     * @author Giovanni
     * @param codigoOperador
     * @return
     * @throws ExcepcionDAO
     */
    public int buscarNumeroSillasPorOperador(Long codigoOperador) throws ExcepcionDAO {
        int numeroSillas = 0;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiNovedad.siiContrato con");
            sql.append(" WHERE con.siiOperador.opeCodigo = :codigoOperador");
            sql.append(" AND inv.invSillas IS NOT NULL");
            sql.append(" AND inv.invEstado = 'A'");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoOperador", codigoOperador);

            List<SiiInventario> siiInventarios = consulta.getResultList();

            if (siiInventarios != null && !siiInventarios.isEmpty()) {
                for (SiiInventario siiInventario : siiInventarios) {
                    numeroSillas = siiInventario.getInvSillas();
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return numeroSillas;
    }

    /**
     * @author Giovanni
     * @param codigoInstrumento
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiInventario> consultarInventarioActivoXInstrumentoXNovedad(Long codigoInstrumento, Long codigoNovedad) throws ExcepcionDAO {
        List<SiiInventario> siiInventarios = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" WHERE inv.siiInstrumento.insCodigo = :codigoInstrumento");
            sql.append(" AND inv.siiNovedad.novCodigo = :codigoNovedad");
            sql.append(" AND inv.invEstado = 'A'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoInstrumento", codigoInstrumento);
            query.setParameter("codigoNovedad", codigoNovedad);

            siiInventarios = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return siiInventarios;
    }

    public List<SiiInventario> buscarInventarioPorNumContrato(String numeroContrato) throws ExcepcionDAO {

        List<SiiInventario> miListaInventario = new ArrayList<SiiInventario>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiInventario o");
            sql.append(" INNER JOIN o.siiNovedad nov");
            sql.append(" WHERE nov.siiContrato.conNumero = :numeroContrato");
            sql.append(" AND o.invEstado = 'A'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numeroContrato", numeroContrato);
            miListaInventario = query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return miListaInventario;
    }

    public List<SiiInventario> buscarInventarioPorNumContrato(Long codContrato) throws ExcepcionDAO {

        List<SiiInventario> miListaInventario = new ArrayList<SiiInventario>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" WHERE nov.siiContrato.conCodigo = :codContrato");
            sql.append(" AND inv.invEstado = 'A'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codContrato", codContrato);
            miListaInventario = query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return miListaInventario;
    }

    /**
     * Metodo encargado de buscar un registro de inventario que cumpla con los criterios de entrada
     * @Author Giovanni
     * @param serialMet
     * @param marcaMet
     * @param contrato
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiInventario> buscarTodoElInventarioXEstado(String estados) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = new ArrayList<>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT inv.* FROM Sii_Inventario inv");
            sql.append(" WHERE inv.inv_Estado IN (" + estados + ")");

            //Query query = manager.createQuery(sql.toString());
            Query query = manager.createNativeQuery(sql.toString(), SiiInventario.class);
            //query.setParameter("estados", estados);
            listaInventario = query.getResultList();
            return listaInventario;
        } finally {
            manager.clear();
        }

    }

    public List<SiiInventario> buscarTodoElInventarioXEstadoPorPeriodos(String estados, String fechaini, String fechafin) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = new ArrayList<>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT inv.* FROM Sii_Inventario inv");
            sql.append(" WHERE inv.inv_Estado IN (" + estados + ") ");
            sql.append("and inv_fecha_fin_liq between to_date('" + fechaini + "','YYYY/MM/dd') and to_date('" + fechafin + "','YYYY/MM/dd')");

            //Query query = manager.createQuery(sql.toString());
            Query query = manager.createNativeQuery(sql.toString(), SiiInventario.class);
            //query.setParameter("estados", estados);
            listaInventario = query.getResultList();
            return listaInventario;
        } finally {
            manager.clear();
        }

    }

    public List<NovedadInventarioVO> buscarInventarioContratoInicial(Long conCodigo) throws ExcepcionAplicacion, ExcepcionDAO {
        List<NovedadInventarioVO> inventarioInicial = new ArrayList<NovedadInventarioVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT con.CON_NUMERO contrato,\n" + "  osi.OSI_CONSECUTIVO otrosi,\n" + "  tsa.TSA_NOMBRE tipo_solicitud,\n" + "  tno.TNO_NOMBRE tipo_novedad,\n" +
                       "  tap.TAP_NOMBRE apuesta,\n" + "  COUNT(ins.INS_CODIGO) AS cantidad,\n" + "  est.EST_NOMBRE establecimiento,\n" + "  est.EST_DIRECCION direcccion,\n" +
                       "  mun.UBI_NOMBRE municipio,\n" + "  dto.UBI_NOMBRE AS depto\n" + "FROM sii_inventario inv\n" + "INNER JOIN sii_novedad nov\n" + "ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" +
                       "LEFT JOIN sii_contrato con\n" + "ON nov.CON_CODIGO = con.CON_CODIGO\n" + "LEFT JOIN sii_otrosi osi\n" + "ON nov.OSI_CODIGO = osi.OSI_CODIGO\n" +
                       "INNER JOIN sii_establecimiento est\n" + "ON inv.EST_CODIGO = est.EST_CODIGO\n" + "INNER JOIN sii_tipo_apuesta tap\n" + "ON inv.TAP_CODIGO = tap.TAP_CODIGO\n" +
                       "LEFT JOIN SII_UBICACION mun\n" + "ON est.UBI_CODIGO = mun.UBI_CODIGO\n" + "INNER JOIN SII_UBICACION dto\n" + "ON mun.UBI_CODIGO_PADRE = dto.UBI_CODIGO\n" +
                       "LEFT JOIN sii_solicitud_autoriz sau\n" + "ON nov.SAU_CODIGO = sau.SAU_CODIGO\n" + "LEFT JOIN sii_tipo_solic_autoriza tsa\n" + "ON sau.TSA_CODIGO = tsa.TSA_CODIGO\n" +
                       "INNER JOIN sii_instrumento ins\n" + "ON inv.INS_CODIGO = ins.INS_CODIGO\n" + "INNER JOIN sii_tipo_novedad tno\n" + "ON nov.TNO_CODIGO = tno.TNO_CODIGO\n" +
                       "  --WHERE tsa.tsa_nombre IN ()\n" + "WHERE con.con_codigo = #conCodigo and  tsa.tsa_nombre IN ('Contrato nuevo','Renovación contrato')\n" + "GROUP BY con.CON_NUMERO,\n" +
                       "  osi.OSI_CONSECUTIVO,\n" + "  tsa.TSA_NOMBRE,\n" + "  tap.TAP_NOMBRE,\n" + "  est.EST_NOMBRE,\n" + "  est.EST_DIRECCION,\n" + "  mun.UBI_NOMBRE,\n" + "  dto.UBI_NOMBRE,\n" +
                       "  tno.TNO_NOMBRE,\n" + "  nov.nov_codigo\n" + "ORDER BY con.CON_NUMERO ,\n" + "  osi.OSI_CONSECUTIVO ,\n" + "  tsa.TSA_NOMBRE ,\n" + "  nov.nov_codigo,\n" +
                       "  tno.TNO_NOMBRE ,\n" + "  tap.TAP_NOMBRE ,\n" + "  est.EST_NOMBRE,\n" + "  dto.UBI_NOMBRE,\n" + "  mun.UBI_NOMBRE ,\n" + "  est.EST_DIRECCION ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    inventarioInicial.add(construirNovedadInventario(object));
                }
            }

            return inventarioInicial;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioDAO");
        }
    }

    public List<NovedadInventarioVO> buscarHistorialInvContrato(Long conCodigo) throws ExcepcionDAO {
        List<NovedadInventarioVO> historial = new ArrayList<NovedadInventarioVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT con.CON_NUMERO contrato,\n" + "  osi.OSI_CONSECUTIVO otrosi,\n" + "  tsa.TSA_NOMBRE tipo_solicitud,\n" + "  tno.TNO_NOMBRE tipo_novedad,\n" +
                       "  tap.TAP_NOMBRE apuesta,\n" + "  COUNT(inv.INS_CODIGO) AS cantidad,\n" + "  est.EST_NOMBRE establecimiento,\n" + "  est.EST_DIRECCION direcccion,\n" +
                       "  mun.UBI_NOMBRE municipio,\n" + "  dto.UBI_NOMBRE AS depto\n" + "FROM sii_inventario inv\n" + "INNER JOIN sii_novedad nov\n" + "ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" +
                       "LEFT JOIN sii_contrato con\n" + "ON nov.CON_CODIGO = con.CON_CODIGO\n" + "LEFT JOIN sii_otrosi osi\n" + "ON nov.OSI_CODIGO = osi.OSI_CODIGO\n" +
                       "INNER JOIN sii_establecimiento est\n" + "ON inv.EST_CODIGO = est.EST_CODIGO\n" + "INNER JOIN sii_tipo_apuesta tap\n" + "ON inv.TAP_CODIGO = tap.TAP_CODIGO\n" +
                       "LEFT JOIN SII_UBICACION mun\n" + "ON est.UBI_CODIGO = mun.UBI_CODIGO\n" + "INNER JOIN SII_UBICACION dto\n" + "ON mun.UBI_CODIGO_PADRE = dto.UBI_CODIGO\n" +
                       "LEFT JOIN sii_solicitud_autoriz sau\n" + "ON nov.SAU_CODIGO = sau.SAU_CODIGO\n" + "LEFT JOIN sii_tipo_solic_autoriza tsa\n" + "ON sau.TSA_CODIGO = tsa.TSA_CODIGO\n" +
                       "INNER JOIN sii_tipo_novedad tno\n" + "ON nov.TNO_CODIGO    = tno.TNO_CODIGO\n" + "WHERE con.CON_CODIGO = #conCodigo\n" +
                       "AND (tsa.TSA_NOMBRE IN ('Actualización operador', 'Cesión Contrato', 'Desistir Solicitud', 'Nueva Rifa', 'Nuevo Operador', 'Nuevo Promocional', 'Otras Novedades', 'Prórroga contrato', 'Responder requerimiento', 'Solicitud cambio de estado MET en linea', 'Traslado Automático')\n" +
                       "OR tsa.TSA_NOMBRE   IS NULL)\n" + "GROUP BY con.CON_NUMERO,\n" + "  osi.OSI_CONSECUTIVO,\n" + "  tsa.TSA_NOMBRE,\n" + "  tno.TNO_NOMBRE,\n" + "  tap.TAP_NOMBRE,\n" +
                       "  est.EST_NOMBRE,\n" + "  est.EST_DIRECCION,\n" + "  mun.UBI_NOMBRE,\n" + "  dto.UBI_NOMBRE,\n" + "  nov.SAU_CODIGO\n" + "ORDER BY con.CON_NUMERO,\n" +
                       "  osi.OSI_CONSECUTIVO,\n" + "  tsa.TSA_NOMBRE,\n" + "  tno.TNO_NOMBRE,\n" + "  tap.TAP_NOMBRE,\n" + "  est.EST_NOMBRE,\n" + "  mun.UBI_NOMBRE,\n" + "  mun.UBI_NOMBRE,\n" +
                       "  est.EST_DIRECCION");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    historial.add(construirNovedadInventario(object));
                }
            }

            return historial;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioDAO");
        }
    }

    private NovedadInventarioVO construirNovedadInventario(Object[] object) {
        NovedadInventarioVO inv = new NovedadInventarioVO();
        if (object[0] != null) {
            inv.setConNumero(object[0].toString());
        }

        if (object[1] != null) {
            inv.setOsiConsecutivo(object[1].toString());
        }
        if (object[2] != null) {
            inv.setTsaNombre(object[2].toString());

        }
        if (object[3] != null) {
            inv.setTnoNombre(object[3].toString());

        }
        if (object[4] != null) {
            inv.setTapNombre(object[4].toString());

        }
        if (object[5] != null) {
            inv.setCantidad(new Long(((BigDecimal) object[5]).longValue()));

        }
        if (object[6] != null) {
            inv.setEstNombre(object[6].toString());

        }
        if (object[7] != null) {
            inv.setEstDireccion(object[7].toString());

        }
        if (object[8] != null) {
            inv.setMunicipio(object[8].toString());

        }
        if (object[9] != null) {
            inv.setDepartamento(object[9].toString());

        }
        return inv;
    }

    public int cantidadElementosPorContratoPorTipoInstrumento(Long conCodigo, String tinNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(\n" + "  CASE tin.TIN_NOMBRE\n" + "    WHEN 'BINGO'\n" + "    THEN inv.INV_SILLAS\n" + "    WHEN 'MET'\n" + "    THEN 1\n" + "    WHEN 'MESA DE CASINO'\n" +
                       "    THEN 1\n" + "    WHEN 'OTRO'\n" + "    THEN 1\n" + "    WHEN 'ACDV'\n" + "    THEN 1\n" + "    ELSE 1\n" + "  END) AS CANTIDAD\n" + "FROM sii_inventario inv\n" +
                       "INNER JOIN sii_novedad nov\n" + "ON nov.NOV_CODIGO = inv.NOV_CODIGO\n" + "INNER JOIN sii_contrato con\n" + "ON con.CON_CODIGO = nov.CON_CODIGO\n" +
                       "INNER JOIN sii_instrumento ins\n" + "ON inv.INS_CODIGO = ins.INS_CODIGO\n" + "INNER JOIN sii_tipo_instrumento tin\n" + "ON ins.TIN_CODIGO    = tin.TIN_CODIGO\n" +
                       "WHERE con.CON_CODIGO = #conCodigo\n" + "AND tin.TIN_NOMBRE   = #tinNombre\n" + "AND ins.INS_ACTIVO   = 'S'\n" + "GROUP BY tin.TIN_NOMBRE");

            Query consulta = manager.createNativeQuery(sql.toString());
            consulta.setParameter("conCodigo", conCodigo);
            consulta.setParameter("tinNombre", tinNombre);

            BigDecimal temp = (BigDecimal) consulta.getSingleResult();
            return temp.intValue();
        } catch (NoResultException pe) {
            return 0;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
    }

    public SiiInventario buscarInventarioXOperadorXSerialXMarcaYContrato(Long long1, String string, String string1, String string2, String string3) {
        return null;
    }

    public List<SiiInventario> buscarInventarioActivoOPenRetiroPorEstContrato(Long estCodigo, String conNumero) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT inv FROM SiiInventario inv");
            sql.append(" Inner Join inv.siiEstablecimiento est");
            sql.append(" left Join inv.siiNovedad nov");
            sql.append(" Inner Join nov.siiContrato con");
            sql.append(" WHERE con.conNumero =:conNumero   AND est.estCodigo =:estCodigo ");
            sql.append(" AND inv.invEstado='A' ");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("conNumero", conNumero);
            query.setParameter("estCodigo", estCodigo);
            return query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioDAO");
        }

    }

    public List<SiiInventario> buscarInventarioActivoPorEstContrato(Long estCodigo, String conNumero) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT inv FROM SiiInventario inv");
            sql.append(" Inner Join inv.siiEstablecimiento est");
            sql.append(" Inner Join inv.siiNovedad nov");
            sql.append(" Inner Join nov.siiContrato con");
            sql.append(" WHERE con.conNumero =:conNumero   AND est.estCodigo =:estCodigo ");
            sql.append(" AND inv.invEstado='A'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("conNumero", conNumero);
            query.setParameter("estCodigo", estCodigo);
            return query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioDAO");
        }

    }

    public SiiInventario buscarInventarioPorIdInstrumento(Long insCodigo) throws ExcepcionDAO {
        SiiInventario siiInventario = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT  i FROM SiiInventario i");
            sql.append(" where  i.invEstado='A' and  i.siiInstrumento.insCodigo =:insCodigo ");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("insCodigo", insCodigo);
            List<SiiInventario> listaSiiInventario = query.getResultList();
            if (listaSiiInventario.size() > 0) {
                siiInventario = listaSiiInventario.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return siiInventario;
    }


    public List<SiiInventario> buscarBingosPorCodigoDANE(String codigoDane, String contrato) {

        List<SiiInventario> siiInventarios = null;

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT inv FROM SiiInventario inv");
        sql.append(" INNER JOIN inv.siiTipoApuesta tap");
        sql.append(" INNER JOIN inv.siiNovedad nov");
        sql.append(" INNER JOIN nov.siiContrato con");
        sql.append(" INNER JOIN inv.siiEstablecimiento est");
        sql.append(" INNER JOIN est.siiUbicacion1 ubi");
        sql.append(" INNER JOIN inv.siiInstrumento ins");
        sql.append(" WHERE inv.invEstado = 'A'");
        sql.append(" AND ubi.ubiCodigo = :codDane");
        sql.append(" AND con.conNumero = :contrato");
        sql.append(" AND ins.siiTipoInstrumento.tinCodigo = :tipInst");

        Query query = manager.createQuery(sql.toString());
        query.setParameter("codDane", codigoDane);
        query.setParameter("contrato", contrato);
        query.setParameter("tipInst", EnumTipoInstrumento.BINGO.getId());

        siiInventarios = query.getResultList();

        return siiInventarios;
    }

    public String buscarJuegosAutorizadosPorNitOperador(String nit) throws ExcepcionDAO {
        String juegosAutorizados = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select ListAgg(REPLACE(REPLACE(numtoletras(count(inv.inv_codigo)), \' PESOS M/CTE.\'), \' PESO M/CTE.\')   || \' (\'  || count(inv.inv_codigo)   || \') \'" +
                       "      || REPLACE(tap.TAP_NOMBRE, \'(Ver Nota 2)\')   || \', \') Within GROUP ( ORDER BY tap.TAP_NOMBRE) " + " from sii_persona per" +
                       " inner join sii_operador ope on (per.per_codigo = ope.per_codigo)" + " inner join sii_establecimiento est on (ope.ope_codigo = est.ope_codigo)" +
                       " inner join sii_inventario inv on (est.est_codigo = inv.est_codigo)" + " inner join sii_ubicacion u on (est.ubi_codigo = u.ubi_codigo)" +
                       " inner join sii_ubicacion u2 on (u.ubi_codigo_padre = u2.ubi_codigo )" + " INNER JOIN SII_TIPO_APUESTA tap ON (inv.tap_codigo = tap.TAP_CODIGO )" +
                       " where est.est_estado=\'A\'" + " and inv.inv_estado =\'A\'" + " and per.per_num_identificacion =\' #nit" + "\'" + " GROUP BY tap.TAP_NOMBRE ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("nit", nit);
            if (query.getSingleResult() != null) {
                juegosAutorizados = query.getSingleResult().toString();
            } else {
                juegosAutorizados = "";
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return juegosAutorizados;
    }


    /**
     * Buscar inventario de proceso sancionatorio por tipo de apuesta
     * @param tapCodigo
     * @return resultado - Lista de inventario de proceso sancionatorio.
     * @throws ExcepcionDAO
     */

    public List<SiiInventario> buscarInventarioPorTipoApuesta(Long tapCodigo) throws ExcepcionDAO {
        return this.buscarInventarioPorContratoYTipoApuesta(null, tapCodigo, null);
    }


    /**
     * Buscar inventario de proceso sancionatorio por Contrato y Tipo de Apuesta.
     * @param conCodigo - C&oacute;digo del Contrato.
     * @param tapCodigo
     * @return resultado - Lista de inventario de proceso sancionatorio.
     * @throws ExcepcionDAO
     */

    public List<SiiInventario> buscarInventarioPorContratoYTipoApuesta(Long conCodigo, Long tapCodigo) throws ExcepcionDAO {
        return this.buscarInventarioPorContratoYTipoApuesta(conCodigo, tapCodigo, null);
    }


    /**
     * Buscar inventario de proceso sancionatorio por Tipo de apuesta y Estado.
     * @param conCodigo - C&oacute;digo del Contrato.
     * @param tapCodigo
     * @return resultado - Lista de inventario de proceso sancionatorio.
     * @throws ExcepcionDAO
     */

    public List<SiiInventario> buscarInventarioPorContratoYTipoApuesta(Long conCodigo, Long tapCodigo, String invEstado) throws ExcepcionDAO {
        List<SiiInventario> resultado = null;

        if (tapCodigo != null) {
            try {

                StringBuilder sql = new StringBuilder();
                sql.append("SELECT inv FROM SiiInventario inv ");

                if (conCodigo != null) {
                    sql.append("INNER JOIN SiiNovedad nov  ON  nov.novCodigo = inv.siiNovedad.novCodigo ");
                    sql.append("INNER JOIN SiiContrato con  ON  con.conCodigo = nov.siiContrato.conCodigo ");
                }

                sql.append("WHERE inv.siiTipoApuesta.tapCodigo = :tapCodigo ");

                if (invEstado != null)
                    sql.append("AND inv.invEstado = :invEstado ");

                if (conCodigo != null)
                    sql.append("AND con.conCodigo = :conCodigo ");


                Query query = manager.createQuery(sql.toString());
                query.setParameter("tapCodigo", tapCodigo);

                if (invEstado != null)
                    query.setParameter("invEstado", invEstado);

                if (conCodigo != null)
                    query.setParameter("conCodigo", conCodigo);


                resultado = query.getResultList();

            } catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }

        return (resultado);
    }

    /**
     * @param novCodigo Novedad especifica que se esta evaluando
     *        busca los instrumentos (ins_codigo) en las filas de inventario correspondientes a la novedad
     *        que tienen movimientos pendientes "inv_estado IN ('PR','PA')"
     *        y los busca en el inventario como instrumentos activos "inv_estado = 'A'"
     *        dejandolos inactivos "inv_estado = 'I'"
     * @throws ExcepcionDAO
     */
    public void inactivarInventarioPendiente(Long novCodigo) throws ExcepcionDAO {
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE sii_inventario \n" + "SET inv_estado    = 'I'\n" + "WHERE ins_codigo IN\n" + "  ( SELECT DISTINCT ins_codigo\n" + "  FROM sii_inventario\n" + "  WHERE\n" +
                       "    nov_codigo = #nov_codigo and\n" + "    inv_estado IN ('PR','PA')\n" + "  )\n" + "AND inv_estado = 'A'");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("nov_codigo", novCodigo);
            query.executeUpdate();

        } catch (Throwable pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }

    public Integer cantidadInventarioPendiente(Long novCodigo) throws ExcepcionDAO {
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT count(*)\n" + "    FROM sii_inventario   \n" + "    WHERE   \n" + "      nov_codigo = #nov_codigo and   \n" + "      inv_estado IN ('PR','PA')");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("nov_codigo", novCodigo);

            BigDecimal cantidad = (BigDecimal) query.getSingleResult();
            return cantidad.intValue();


        } catch (Throwable pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", pe.getMessage().substring(0, 400));
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }

    public List<ElementoAsociadoWSVO> buscarInventarioPorCodigoContratoVigencia(Integer vigencia, Long codigoContrato, String fechaPrimerDia, String fechaUltimoDia) throws ExcepcionDAO {

        List<ElementoAsociadoWSVO> listaElementosAsociadosWSVO = new ArrayList<ElementoAsociadoWSVO>();
        /*
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaPrimerDiaPeriodo = "TO_DATE('" + formatter.format(fechaPrimerDia) + "','YYYY/MM/DD HH24:MI:SS') ";
        String fechaUltimoDiaPeriodo = "TO_DATE('" + formatter.format(fechaUltimoDia) + "','YYYY/MM/DD HH24:MI:SS') ";
*/
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select codigo, tarifa, valor, count(cantidad), sum(valor_tarifa_fija)" + " from (" + " select   tap.tap_codigo codigo, tap.tap_nombre tarifa, ins.ins_codigo cantidad," +
                       " fn_liquida_DE(Tap_Der_Expl_Formula, " + vigencia + " )  valor," + " (case ins.tap_codigo" + " when 6 then inv_sillas*fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" +
                       " when 7 then inv_sillas*fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" + " when 8 then inv_sillas*fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" +
                       " when 9 then inv_sillas*fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" + " when 10 then inv_sillas*fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" +
                       " when 11 then inv_sillas*fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" + " when 12 then inv_sillas*fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" +
                       " when 13 then inv_sillas*fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" + " when 14 then inv_sillas*fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" +
                       " when 15 then inv_sillas*fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" + " when 1 then fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" +
                       " when 2 then fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" + " when 3 then fn_liquida_DE(Tap_Der_Expl_Formula," + vigencia + ")" + " end  )  valor_tarifa_fija" +
                       " from sii_inventario inv  " + " left join sii_instrumento ins on inv.ins_codigo = ins.ins_codigo " + " left join sii_met met on ins.met_codigo = met.met_codigo  " +
                       " left join sii_marca mar on met.mar_codigo = mar.mar_codigo  " + " left join sii_establecimiento est on inv.est_codigo = est.est_codigo  " +
                       " left JOIN sii_ubicacion ubi ON est.UBI_CODIGO = ubi.UBI_CODIGO " + " left JOIN sii_ubicacion ubi2 ON ubi.UBI_CODIGO_PADRE = ubi2.UBI_CODIGO " +
                       " left join sii_novedad n on inv.nov_codigo = n.nov_codigo  " + " left join sii_contrato con on con.con_codigo = n.con_codigo  " +
                       " left join sii_tipo_apuesta tap on inv.tap_codigo = tap.tap_codigo  " + " left join sii_tipo_instrumento ti on ins.tin_codigo = ti.tin_codigo  " +
                       " left join sii_tipo_novedad tn on n.tno_codigo = tn.tno_codigo " + " left join sii_operador ope on ope.ope_codigo = con.ope_codigo " +
                       " left join sii_persona p on p.per_codigo = ope.per_codigo " + " where " + " con.con_codigo = " + codigoContrato + " and inv.inv_estado IN('A', 'R')" +
                       " and con.con_vigente ='S'" + " and trunc(inv.inv_fecha_INI_liq)<=to_Date('" + fechaPrimerDia + "','dd/mm/yyyy') and trunc(inv.inv_fecha_fin_liq)>=to_date('" + fechaUltimoDia +
                       "','dd/mm/yyyy')" + " and est.est_estado='A')" + " group by codigo, tarifa, valor" + " order by 1 asc");

            Query query = manager.createNativeQuery(sql.toString());

            List<Object[]> results = query.getResultList();

            for (Object[] object : results) {
                ElementoAsociadoWSVO elementoAsociadoWSVO = new ElementoAsociadoWSVO();
                elementoAsociadoWSVO.tipoApuesta = ((BigDecimal) object[0]).longValue();
                if (object[3] != null && ((BigDecimal) object[3]).longValue() > 0) {
                    elementoAsociadoWSVO.cantidadElemento = ((BigDecimal) object[3]).longValue();
                }
                if (object[4] != null) {
                    elementoAsociadoWSVO.ventasMet = ((BigDecimal) object[4]);
                }
                if (object[2] != null) {
                    elementoAsociadoWSVO.valorDerechosExp = ((BigDecimal) object[2]);
                }
                if (object[1] != null) {
                    elementoAsociadoWSVO.nombreApuesta = ((String) object[1]);
                }
                if (elementoAsociadoWSVO.cantidadElemento > 0) {
                    listaElementosAsociadosWSVO.add(elementoAsociadoWSVO);
                }
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }
        return listaElementosAsociadosWSVO;
    }

}
