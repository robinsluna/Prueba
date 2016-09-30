package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.FirmasMinutaVO;
import co.gov.coljuegos.siicol.ejb.vo.MinutaVO;

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
public class ProcesoContratacionDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ProcesoContratacionDAO() {
        recursos = new Recursos();
    }

    public SiiProcesoContratacion insertarProcesoContratacion(SiiProcesoContratacion procesoContratacion) throws ExcepcionDAO {
        try {
            manager.persist(procesoContratacion);
            manager.flush();
            return procesoContratacion;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        }
    }

    public List<SiiProcesoContratacion> buscarTodoProcesoContratacion() throws ExcepcionDAO {
        try {
            List<SiiProcesoContratacion> listaProcesoContratacion = new ArrayList();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT procesoContratacion FROM SiiProcesoContratacion procesoContratacion");
            Query query = manager.createQuery(sql.toString());
            listaProcesoContratacion = query.getResultList();
            return listaProcesoContratacion;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        }
    }

    public List<SiiProcesoContratacion> procesosContratacionConSolicitudAprobada() throws ExcepcionDAO {
        try {
            List<SiiProcesoContratacion> listaProcesoContratacion = new ArrayList();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o.siiProcesoContratacion FROM SiiSolicitudEstMercado o WHERE o.siiEstadoSolEstMercado.eseNombre='Aprobado'");
            Query query = manager.createQuery(sql.toString());
            listaProcesoContratacion = query.getResultList();
            return listaProcesoContratacion;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        }
    }

    public SiiProcesoContratacion buscarProcesoContratacionPorId(Long idProcesoContratacion) throws ExcepcionDAO {
        SiiProcesoContratacion procesoContratacionRetorno = new SiiProcesoContratacion();
        try {
            procesoContratacionRetorno =
                (SiiProcesoContratacion) manager.find(SiiProcesoContratacion.class, idProcesoContratacion);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContrtacionDAO");
        }
        return procesoContratacionRetorno;
    }

    public List<SiiProcesoContratacion> buscarProcesoContratacionPorEstado(String estado) throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT procesoContratacion FROM SiiProcesoContratacion procesoContratacion " +
                       "INNER JOIN procesoContratacion.siiEstadoProcContrat estadoProcContrat " +
                       "WHERE estadoProcContrat.epcNombre = :estado ORDER BY procesoContratacion asc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            listaProcesoContratacion = query.getResultList();
            return listaProcesoContratacion;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        }
    }

    public List<SiiProcesoContratacion> buscarProcesoContratacionDescPorEstado(String estado) throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT procesoContratacion FROM SiiProcesoContratacion procesoContratacion " +
                       "INNER JOIN procesoContratacion.siiEstadoProcContrat estadoProcContrat " +
                       "WHERE estadoProcContrat.epcNombre = :estado ORDER BY procesoContratacion desc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            listaProcesoContratacion = query.getResultList();
            return listaProcesoContratacion;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        }
    }

    public List<SiiProcesoContratacion> buscarProcesoContratacionSolicitudCdp() throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion = null;
        try {
            StringBuilder sql = new StringBuilder();
            //sql.append("SELECT spc FROM SiiProcesoContratacion spc WHERE spc.prcCodigo NOT IN " +
            //    "(SELECT srp.siiCdp.siiProcesoContratacion.prcCodigo FROM SiiRp srp WHERE srp.siiEstadoRp.erpCodigo IN (8))" );
            sql.append("SELECT spc FROM SiiProcesoContratacion spc");
            sql.append(" ORDER BY spc ASC");
            Query query = manager.createQuery(sql.toString());
            listaProcesoContratacion = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        }
        return listaProcesoContratacion;
    }

    public SiiProcesoContratacion actualizarProcesoContratacion(SiiProcesoContratacion procesoContratacion) throws ExcepcionDAO {
        try {
            manager.merge(procesoContratacion);
            manager.flush();
            return procesoContratacion;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        }
    }


    public List<SiiProcesoContratacion> buscarProcesoContratacionPorEstadoEstudioMercado(String estado) throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT procesoContratacion FROM SiiProcesoContratacion procesoContratacion JOIN procesoContratacion.estadoProcContrat WHERE estadoProcesoContrat.epcNombre = :estado");
            Query query = manager.createQuery(sql.toString());
            listaProcesoContratacion = query.getResultList();
            return listaProcesoContratacion;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContrtacionDAO");
        }
    }

    /*
    public SiiProcesoContratacion eliminarProcesoContratacion(SiiProcesoContratacion procesoContratacion) throws ExcepcionDAO{
        try{
            manager.remove(procesoContratacion);
            manager.flush();
            return procesoContratacion;

        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        }
    }    */
    public List<SiiProcesoContratacion> buscarProcesoContratacionConEstado() throws ExcepcionDAO {
        List<SiiProcesoContratacion> listaProcesoContratacion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT procesoContratacion FROM SiiProcesoContratacion procesoContratacion INNER JOIN procesoContratacion.siiEstadoProcContrat estadoProcContrat ");
            Query query = manager.createQuery(sql.toString());
            listaProcesoContratacion = query.getResultList();
            return listaProcesoContratacion;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        }
    }

    public List<MinutaVO> buscarProcesoContratacionPorIdMinuta(Long idProcesoContratacion) throws ExcepcionDAO {
        List<MinutaVO> listaMinutaVo = new ArrayList<MinutaVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ep.EPE_VALOR_CONTRAT CPR_VALOR,\n" +
                       "  TO_CHAR(cp.CPR_FECHA, 'YYYY-MM-DD') CPR_FECHA,\n" + "  oa.OAD_CONSEC_CONTR,\n" +
                       "  oa.OAD_VIGENCIA_CONTR,\n" + "  oa.OAD_TIPO_CONTR,\n" + "  oa.OAD_FECHA_REG,\n" +
                       "  ep.EPE_DESCR_JUSTIF,\n" + "  ep.EPE_FORMAS_ANALIZ,\n" + "  ep.EPE_VALOR_CONTRAT,\n" +
                       "  ep.EPE_FORMA_PAGO,\n" + "  ep.EPE_OBLIGAC_CONTRA_C,\n" + "  ep.EPE_ANALISI_ECON,\n" +
                       "  ep.EPE_VIGENCIA,\n" + "  tg.TGA_NOMBRE,\n" + "  ipc.IPC_CODIGO,\n" +
                       "  ipc.IPC_DESCRIPCION,\n" + "  c.CDP_CODIGO,\n" + "  c.CDP_CONSECUTIVO,\n" +
                       "  TO_CHAR(c.CDP_FECHA_EXPEDICION, 'YYYY-MM-DD') CDP_FECHA_EXPEDICION,\n" +
                       "  p.PRO_EJECUTIVO_CUENTA,\n" + "  per.PER_NUM_IDENTIFICACION,\n" +
                       "  per.PER_JUR_NOMBRE_LARGO,\n" +
                       "  per.PER_DIRECCION||', '||nvl(mun.UBI_NOMBRE,'________')||', '||nvl(dpt.UBI_NOMBRE,'________')  PER_DIRECCION,\n" +
                       "  NVL(sem.SEM_OBJETO_CONTRATO, NVL(pc.PRC_OBJETO_C, '___________________________________')),\n" +
                       "  ep.EPE_TIEMPO_DURAC SEM_TIEMPO_ESTIMADO,\n" +
                       "  ep.EPE_UNIDAD_DURAC SEM_UNID_TIEMPO_ESTIM,\n" + "  sem.SEM_TIPO_SUPERVISOR,\n" +
                       "  sem.USU_CODIGO_SUPERVISOR,\n" +
                       "  NVL(rep.PER_NUM_IDENTIFICACION, '_____') AS rep_NUM_IDENTIFICACION,\n" +
                       "  NVL(rep.PER_PRIMER_NOMBRE, '__________________')\n" + "  || ' '\n" +
                       "  || rep.PER_SEGUNDO_NOMBRE\n" + "  || ' '\n" + "  || rep.PER_PRIMER_APELLIDO\n" +
                       "  || ' '\n" + "  || rep.PER_SEGUNDO_APELLIDO rep_nombre,\n" +
                       "  NVL(rep_tid.TID_NOMBRE, '_______________'),\n" + "  (SELECT cta.CBP_NUMERO\n" + "  FROM\n" +
                       "    (SELECT cbp.CBP_NUMERO,\n" + "      pcb.PER_CODIGO\n" +
                       "    FROM sii_persona_cta_banco pcb\n" + "    LEFT JOIN sii_cuenta_banco_persona cbp\n" +
                       "    ON pcb.CBP_CODIGO              = cbp.CBP_CODIGO\n" +
                       "    WHERE NVL(cbp.CBP_ACTIVO, 'A') = 'A'\n" + "    ORDER BY cbp.cbp_codigo DESC\n" +
                       "    ) cta\n" + "  WHERE per.PER_CODIGO = cta.PER_CODIGO\n" + "  AND RowNum           = 1\n" +
                       "  ) cbp_numero,\n" + "  NVL(per_tid.TID_NOMBRE_CORTO,'___') tid_persona,\n" +
                       "  NVL(rep_tid.TID_NOMBRE_CORTO,'___') tid_representante\n" +
                       "FROM sii_contrato_proveedor cp\n" + "INNER JOIN sii_oficio_adjudica oa\n" +
                       "ON cp.OAD_CODIGO = oa.OAD_CODIGO\n" + "INNER JOIN sii_proceso_contratacion pc\n" +
                       "ON pc.PRC_CODIGO = oa.PRC_CODIGO\n" + "INNER JOIN sii_estudio_previo ep\n" +
                       "ON ep.PRC_CODIGO = pc.PRC_CODIGO\n" + "LEFT JOIN sii_tipo_garantia tg\n" +
                       "ON ep.TGA_CODIGO = tg.TGA_CODIGO\n" + "INNER JOIN sii_item_plan_contratac ipc\n" +
                       "ON ipc.IPC_CODIGO = ep.IPC_CODIGO\n" + "INNER JOIN sii_solicitud_est_mercado sem\n" +
                       "ON sem.PRC_CODIGO = pc.PRC_CODIGO\n" + "INNER JOIN sii_proveedor p\n" +
                       "ON oa.PRO_CODIGO = p.PRO_CODIGO\n" + "INNER JOIN sii_persona per\n" +
                       "ON p.PER_CODIGO = per.PER_CODIGO\n" + "INNER JOIN sii_cdp c\n" +
                       "ON c.PRC_CODIGO = pc.PRC_CODIGO\n" + "LEFT JOIN sii_persona rep\n" +
                       "ON per.PER_CODIGO_REPRESENTANTE = rep.PER_CODIGO\n" +
                       "LEFT JOIN sii_tipo_identificacion rep_tid\n" + "ON rep.TID_CODIGO = rep_tid.TID_CODIGO\n" +
                       "INNER JOIN sii_tipo_identificacion per_tid\n" + "ON per.TID_CODIGO   = per_tid.TID_CODIGO\n" +
                       "LEFT JOIN sii_ubicacion mun\n" + "ON per.UBI_CODIGO = mun.UBI_CODIGO\n" +
                       "LEFT JOIN sii_ubicacion dpt\n" + "ON mun.UBI_CODIGO_PADRE = dpt.UBI_CODIGO\n" +
                       "WHERE pc.PRC_CODIGO = #idProcesoContratacion");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idProcesoContratacion", idProcesoContratacion);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    MinutaVO minutaVo = new MinutaVO();
                    minutaVo.setCpr_valor(((BigDecimal) object[0]));
                    minutaVo.setCpr_fecha((String) object[1]);
                    minutaVo.setOad_consec_contr(((BigDecimal) object[2]).longValue());
                    minutaVo.setOad_vigencia_contr(((BigDecimal) object[3]).longValue());
                    minutaVo.setOad_tipo_contr((String) object[4]);
                    minutaVo.setOad_fecha_reg((Date) object[5]);
                    minutaVo.setEpe_descr_justif((String) object[6]);
                    minutaVo.setEpe_formas_analiz((String) object[7]);
                    minutaVo.setEpe_valor_contrat(((BigDecimal) object[8]));
                    minutaVo.setEpe_forma_pago((String) object[9]);
                    minutaVo.setEpe_obligac_contrat((String) object[10]);
                    minutaVo.setEpe_analisi_econ((String) object[11]);
                    minutaVo.setEpe_vigencia(((BigDecimal) object[12]).longValue());
                    minutaVo.setTga_nombre((String) object[13]);
                    minutaVo.setIpc_codigo(((BigDecimal) object[14]).longValue());
                    minutaVo.setIpc_descripcion((String) object[15]);
                    minutaVo.setCdp_codigo(((BigDecimal) object[16]).longValue());
                    minutaVo.setCdp_consecutivo(((BigDecimal) object[17]).longValue());
                    minutaVo.setCdp_fecha_expedicion((String) object[18]);
                    minutaVo.setPro_ejecutivo_cuenta((String) object[19]);
                    minutaVo.setPer_num_identificacion((String) object[20]);
                    minutaVo.setPer_jur_nombre_largo((String) object[21]);
                    minutaVo.setPer_direccion((String) object[22]);
                    minutaVo.setSem_objeto_contrato((String) object[23]);
                    minutaVo.setSem_tiempo_estimado(((BigDecimal) object[24]).longValue());
                    minutaVo.setSem_unid_tiempo_estim((String) object[25]);
                    minutaVo.setSem_tipo_supervisor((String) object[26]);
                    if (object[27] != null) {
                        minutaVo.setUsu_codigo_supervisor(((BigDecimal) object[27]).longValue());
                    }
                    minutaVo.setRep_num_identificacion((String) object[28]);
                    minutaVo.setRep_nombre((String) object[29]);
                    minutaVo.setRep_tid_nombre((String) object[30]);
                    minutaVo.setCbp_numero((String) object[31]);
                    minutaVo.setTid_persona((String) object[32]);
                    minutaVo.setTid_representante((String) object[33]);
                    listaMinutaVo.add(minutaVo);

                }
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ProcesoContratacionDAO");
        }
        return listaMinutaVo;
    }

    public List<FirmasMinutaVO> buscarFirmasDocumentosMinuta() throws ExcepcionDAO {
        List<FirmasMinutaVO> listaFirmasMinuta = new ArrayList<FirmasMinutaVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tdc.tdo_nombre, tdo_descripcion, upper(fr.fre_etiqueta), upper(p.per_primer_nombre) ||  ");
            sql.append("' ' || upper(p.per_segundo_nombre) || ' ' || upper(p.per_primer_apellido) || ' ' || upper(p.per_segundo_apellido), p.per_num_identificacion ");
            sql.append("FROM sii_tipo_documento_coljuegos tdc\n" + "INNER JOIN sii_firmas_requeridas fr\n" +
                       "ON tdc.TDO_CODIGO = fr.TDO_CODIGO\n" + "INNER JOIN sii_usuario u\n" +
                       "ON fr.FUN_CODIGO = u.FUN_CODIGO\n" + "INNER JOIN sii_persona p\n" +
                       "ON u.PER_CODIGO = p.PER_CODIGO\n" + "INNER JOIN sii_estado_usuario eus\n" +
                       "ON u.EUS_CODIGO      = eus.EUS_CODIGO\n" + "WHERE tdc.TDO_NOMBRE = 'OFICIO DE ADJUDICACIÓN'\n" +
                       "AND fr.FRE_ETIQUETA LIKE 'Vicepresidente de desarrollo organizacional'\n" +
                       "AND eus.eus_nombre ='ACTIVO'");
            Query query = manager.createNativeQuery(sql.toString());
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    FirmasMinutaVO fimasMinutaVo = new FirmasMinutaVO();
                    fimasMinutaVo.setFre_etiqueta((String) object[0]);
                    fimasMinutaVo.setPer_nombre_completo((String) object[1]);
                    fimasMinutaVo.setTdo_descripcion((String) object[2]);
                    fimasMinutaVo.setTdo_nombre((String) object[3]);
                    fimasMinutaVo.setPer_num_identificacion((String) object[4]);
                    listaFirmasMinuta.add(fimasMinutaVo);
                }
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ProcesoContratacionDAO");
        }
        return listaFirmasMinuta;
    }

    public String ConvertirNumeroALetra(BigDecimal numero) throws ExcepcionDAO {
        String letras = "";
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select numtoletras(" + numero + ") from dual");
            Query query = manager.createNativeQuery(sql.toString());
            letras = (String) query.getSingleResult();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoContratacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ProcesoContratacionDAO");
        }
        return letras;
    }


    public long consultarTipoOperacion(long numeroDocumento, String tipoOperacion) throws ExcepcionDAO {
        long numeroOperacion = 0;
        try {


            StringBuilder sql = new StringBuilder();


            sql.append("SELECT 'EXPEDICION DE RP' TIPO_OPERACION,");
            sql.append(" rp.RP_CONSECUTIVO numero_operacion");
            sql.append(" FROM sii_proceso_contratacion prc");
            sql.append(" RIGHT JOIN sii_oficio_adjudica oad");
            sql.append(" ON oad.PRC_CODIGO = prc.PRC_CODIGO");
            sql.append(" RIGHT JOIN sii_contrato_proveedor cpr");
            sql.append(" ON cpr.OAD_CODIGO = oad.OAD_CODIGO");
            sql.append(" LEFT JOIN sii_cdp cdp");
            sql.append(" ON prc.PRC_CODIGO = cdp.PRC_CODIGO");
            sql.append(" LEFT JOIN sii_rp rp");
            sql.append(" ON cdp.CDP_CODIGO    = rp.CDP_CODIGO");
            sql.append(" WHERE cpr.CPR_CODIGO = :numero_documento");
            //'CONTRATO'
            sql.append(" AND :tipo_operacion  = :tipo_operacion");
            sql.append(" UNION");
            sql.append(" SELECT 'EXPEDICION CDP' TIPO_OPERACION,");
            sql.append(" cdp.CDP_CONSECUTIVO");
            sql.append(" FROM sii_proceso_contratacion prc");
            sql.append(" RIGHT JOIN sii_oficio_adjudica oad");
            sql.append(" ON oad.PRC_CODIGO = prc.PRC_CODIGO");
            sql.append(" RIGHT JOIN sii_contrato_proveedor cpr");
            sql.append(" ON cpr.OAD_CODIGO = oad.OAD_CODIGO");
            sql.append(" LEFT JOIN sii_cdp cdp");
            sql.append(" ON prc.PRC_CODIGO    = cdp.PRC_CODIGO");
            sql.append(" WHERE cpr.CPR_CODIGO = :numero_documento");
            //'CONTRATO'
            sql.append(" AND :tipo_operacion  = :tipo_operacion");
            sql.append(" UNION");
            sql.append(" SELECT 'EXPEDICION DE CDP',");
            sql.append(" cdp.CDP_CONSECUTIVO");
            sql.append(" FROM sii_cdp cdp");
            sql.append(" WHERE cdp.CDP_CONSECUTIVO = :numero_documento");
            //'EXPEDICION DE CDP'
            sql.append(" AND :tipo_operacion  = :tipo_operacion");
            sql.append(" UNION");
            sql.append(" SELECT 'SOLICITUD CDP',");
            sql.append(" cdp.CDP_CODIGO");
            sql.append(" FROM sii_cdp cdp");
            sql.append(" WHERE cdp.CDP_CODIGO = :numero_documento");
            //'SOLICITUD CDP'
            sql.append(" AND :tipo_operacion  = :tipo_operacion");
            sql.append(" UNION");
            sql.append(" SELECT 'SOLICITUD DE RP',");
            sql.append(" rp.RP_CONSECUTIVO");
            sql.append(" FROM sii_cdp cdp");
            sql.append(" LEFT JOIN sii_rp rp");
            sql.append(" ON cdp.CDP_CODIGO       = rp.CDP_CODIGO");
            sql.append(" WHERE rp.RP_CONSECUTIVO = :numero_documento");
            //'SOLICITUD DE RP'
            sql.append(" AND :tipo_operacion  = :tipo_operacion");
            sql.append(" UNION");
            sql.append(" SELECT 'OBLIGACIONES',");
            sql.append("   obl.OBL_NUMERO");
            sql.append(" FROM sii_obligacion obl");
            sql.append("  WHERE obl.OBL_NUMERO = :numero_documento");
            //'OBLIGACIONES'
            sql.append(" AND :tipo_operacion  = :tipo_operacion ");
            sql.append(" UNION");
            sql.append(" SELECT 'PAGOS',");
            sql.append("   pago.ORP_CONSECUTIVO");
            sql.append(" FROM sii_orden_pago pago");
            sql.append(" WHERE pago.ORP_CONSECUTIVO = :numero_documento");
            //'PAGOS'
            sql.append(" AND :tipo_operacion = :tipo_operacion");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("numero_documento", numeroDocumento);
            query.setParameter("tipo_operacion", tipoOperacion);

            numeroOperacion = (Long) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }

        return numeroOperacion;
    }





    public List<Long> consultarNumeroOperacionPorTipo (String tipoOperacion, Integer vigencia, String tdcCodigo, String tdcCodigoOrp) throws ExcepcionDAO { 
        List<Long> resultado = null;
        
        try {


            StringBuilder sql = new StringBuilder();

            sql.append("SELECT DISTINCT NUMERO_OPERACION ");
            sql.append("FROM ( ");
            sql.append("SELECT 'EXPEDICION RP' TIPO_OPERACION, ");
            sql.append("rp.RP_CONSECUTIVO numero_operacion ");
            sql.append("FROM sii_rp rp ");
            sql.append("INNER JOIN SII_ESTADO_RP ERP ");
            sql.append("ON RP.ERP_CODIGO = ERP.ERP_CODIGO ");
            sql.append("WHERE erp.ERP_NOMBRE   = 'RP APROBADO' ");
            sql.append("AND EXTRACT(YEAR FROM  rp.RP_FECHA_RP) = #vigencia ");
            sql.append("UNION ");          
            sql.append("SELECT 'EXPEDICION CDP', ");
            sql.append("cdp.CDP_CONSECUTIVO ");
            sql.append("FROM sii_cdp cdp ");
            sql.append("INNER JOIN sii_estado_cdp ecd ");
            sql.append("ON cdp.ECD_CODIGO      = ecd.ECD_CODIGO ");
            sql.append("WHERE ecd.ECD_NOMBRE   = 'CDP APROBADO' ");
            sql.append("AND EXTRACT(YEAR FROM  cdp.cdp_fecha_expedicion) = #vigencia ");
            sql.append("UNION ");
            sql.append("SELECT 'SOLICITUD CDP', ");
            sql.append("cdp.CDP_CODIGO ");
            sql.append("FROM sii_cdp cdp ");
            sql.append("INNER JOIN sii_estado_cdp ecd ");
            sql.append("ON cdp.ECD_CODIGO      = ecd.ECD_CODIGO ");
            sql.append("WHERE ecd.ECD_NOMBRE   = 'CDP APROBADO' ");
            sql.append("AND EXTRACT(YEAR FROM  cdp.cdp_fecha_solic) = #vigencia ");
            sql.append("UNION ");
            sql.append("SELECT 'SOLICITUD RP', ");
            sql.append("rp.RP_CODIGO ");
            sql.append("FROM sii_rp rp ");
            sql.append("INNER JOIN SII_ESTADO_RP ERP ");
            sql.append("ON RP.ERP_CODIGO = ERP.ERP_CODIGO ");
            sql.append("WHERE erp.ERP_NOMBRE   = 'RP APROBADO' ");
            sql.append("AND EXTRACT(YEAR FROM  rp.rp_fecha_solic) = #vigencia ");
            sql.append("UNION ");
            sql.append("SELECT 'OBLIGACIONES', ");
            sql.append("obl.OBL_NUMERO ");
            sql.append("FROM sii_obligacion obl ");
            sql.append("INNER JOIN SII_ESTADO_OBLIGACION EOB ");
            sql.append("ON obl.EOB_CODIGO = EOB.EOB_CODIGO ");
            sql.append("WHERE EOB.EOB_NOMBRE       = 'APROBADO' "); 
            
            if (tdcCodigo!=null)
                sql.append("AND obl.tdc_codigo       = #tdcCodigo ");
            
            sql.append("AND EXTRACT(YEAR FROM obl.OBL_FECHA) = #vigencia ");
            sql.append("UNION ");
            sql.append("SELECT 'OBLIGACIONESNP', ");
            sql.append("onp.ONP_NUMERO ");
            sql.append("FROM sii_obligacion_no_presup onp ");
            sql.append("INNER JOIN SII_ESTADO_OBLIG_NO_PRES EON ");
            sql.append("ON onp.EON_CODIGO  = EON.EON_CODIGO ");
            sql.append("WHERE eon.EON_NOMBRE   = 'APROBADO' ");
            sql.append("AND Extract(YEAR FROM onp.ONP_FECHA) = #vigencia ");            
            sql.append("UNION ");
            sql.append("SELECT 'CONTRATO', ");
            sql.append("TO_NUMBER(oficio.oad_consec_contr) ");
            sql.append("FROM sii_oficio_adjudica oficio ");
            sql.append("WHERE EXTRACT(YEAR FROM  oficio.OAD_FECHA_REG) = #vigencia ");
            sql.append("UNION ");
            sql.append("SELECT 'PAGOS', ");
            sql.append("pago.ORP_CONSECUTIVO ");
            sql.append("FROM sii_orden_pago pago ");
            sql.append("INNER JOIN sii_estado_orden_pago eop ");
            sql.append("ON eop.EOP_CODIGO = eop.EOP_CODIGO ");
            sql.append("WHERE eop.EOP_NOMBRE   = 'PAGADA' "); 
            
            if (tdcCodigoOrp!=null)
                sql.append("AND pago.tdc_codigo       = #tdcCodigoOrp ");
            
            sql.append("AND EXTRACT(YEAR FROM  pago.ORP_FECHA) = #vigencia) ");
            sql.append("WHERE TIPO_OPERACION = #tipo_operacion ");
            sql.append("AND NUMERO_OPERACION IS NOT NULL ");
            sql.append("ORDER BY 1 DESC ");           
            
            
        Query query = manager.createNativeQuery(sql.toString());
        query.setParameter("tipo_operacion", tipoOperacion); 
        query.setParameter("vigencia", vigencia);
            
        if (tdcCodigo!=null)
            query.setParameter("tdcCodigo", tdcCodigo);
        
        if (tdcCodigoOrp!=null)
            query.setParameter("tdcCodigoOrp", tdcCodigoOrp);
            
        
        
        resultado =  query.getResultList();

        } catch (PersistenceException pe) {
    String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
    throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
}

    return resultado;
}

}
