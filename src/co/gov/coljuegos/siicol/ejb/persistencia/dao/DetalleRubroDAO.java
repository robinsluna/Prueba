/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 07-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoModifPresup;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoModificRP;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoNotaCredito;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoObligacion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoModificPresup;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoModificacionRP;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.InfoDetalladaRubroVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DetalleRubroDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public DetalleRubroDAO() {
        recursos = new Recursos();
    }

    public SiiDetalleRubro buscarPorCodigoDetalleRubro(Long idDetalleRubro) throws ExcepcionDAO {
        SiiDetalleRubro siiDetalleRubroRetorno = null;
        try {
            siiDetalleRubroRetorno = manager.find(SiiDetalleRubro.class, idDetalleRubro);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }
        return siiDetalleRubroRetorno;

    }

    public SiiDetalleRubro insertarSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) throws ExcepcionDAO {
        try {
            manager.persist(siiDetalleRubro); //La guarda en el almacen
            manager.flush(); //Pasa a la Bd
            return siiDetalleRubro; //Retorna el VO

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }
    }

    public SiiDetalleRubro actualizarSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) throws ExcepcionDAO {
        try {
            //SiiDetalleRubro siiDetalleRubro = DetalleRubroVO.convertirVoAEntidad(siiDetalleRubroVo);      //Crea la enttidad a ser grabada en la BD
            manager.merge(siiDetalleRubro); //La guarda en el almacen
            manager.flush(); //Pasa a la Bd
            return siiDetalleRubro; //Retorna el VO

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }
    }

    public void borrarPorCodigoDetalleRubro(Long idDetalleRubro) throws ExcepcionDAO {
        SiiDetalleRubro siiDetalleRubroBorrar = null;
        try {
            siiDetalleRubroBorrar = manager.find(SiiDetalleRubro.class, idDetalleRubro);
            manager.remove(siiDetalleRubroBorrar);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }
    }

    public List<SiiDetalleRubro> buscarTodoSiiDetalleRubro() throws ExcepcionDAO {
        try {
            //List<DetalleRubroVO> listaSiiDetalleRubroVo = new ArrayList();
            //List<SiiDetalleRubro> listaEntidadSiiDetalleRubro = new ArrayList();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT detalleRubro FROM SiiDetalleRubro detalleRubro");
            Query query = manager.createQuery(sql.toString());
            List<SiiDetalleRubro> listaEntidadDetalleRubro = query.getResultList();

            /*
            for (SiiDetalleRubro unaEntidadSiiDetalleRubro : listaEntidadDetalleRubro) {
                DetalleRubroVO nuevoSiiDetalleRubroVO = new DetalleRubroVO();
                nuevoSiiDetalleRubroVO = DetalleRubroVO.convertirEntidadAVO(unaEntidadSiiDetalleRubro);
                listaSiiDetalleRubroVo.add(nuevoSiiDetalleRubroVO);
            }
            */
            return listaEntidadDetalleRubro;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }

    }

    public String buscarCodigoPresupuestal(Long interno, Long vigencia) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select \n" + "(select codigo from pr_nivel1 n1 where n1.interno = r.interno_nivel1)||\n" +
                       "(select decode(codigo,null,null,'.'||codigo) from pr_nivel2 n1 where n1.interno = r.interno_nivel2)||\n" +
                       "(select decode(codigo,null,null,'.'||codigo) from pr_nivel3 n1 where n1.interno = r.interno_nivel3)||\n" +
                       "(select decode(codigo,null,null,'.'||codigo) from pr_nivel4 n1 where n1.interno = r.interno_nivel4)||\n" +
                       "(select decode(codigo,null,null,'.'||codigo) from pr_nivel5 n1 where n1.interno = r.interno_nivel5)||\n" +
                       "(select decode(codigo,null,null,'.'||codigo) from pr_nivel6 n1 where n1.interno = r.interno_nivel6)||\n" +
                       "(select decode(codigo,null,null,'.'||codigo) from pr_nivel7 n1 where n1.interno = r.interno_nivel7)||\n" +
                       "(select decode(codigo,null,null,'.'||codigo) from pr_nivel8 n1 where n1.interno = r.interno_nivel8)\n" +
                       "from pr_rubro r where  r.interno = ? and r.vigencia = ?");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter(1, interno);
            query.setParameter(2, vigencia);
            return (String) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }
    }

    public String buscarCodigoPresupuestal(Long rdrCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT TO_CHAR(Nivel1.CODIGO)\n" + "  ||\n" + "  CASE\n" + "    WHEN Nivel2.CODIGO IS NULL\n" +
                       "    THEN ''\n" + "    ELSE '.'\n" + "      || TO_CHAR(Nivel2.CODIGO)\n" + "  END\n" + "  ||\n" +
                       "  CASE\n" + "    WHEN Nivel3.CODIGO IS NULL\n" + "    THEN ''\n" + "    ELSE '.'\n" +
                       "      || TO_CHAR(Nivel3.CODIGO)\n" + "  END\n" + "  ||\n" + "  CASE\n" +
                       "    WHEN Nivel4.CODIGO IS NULL\n" + "    THEN ''\n" + "    ELSE '.'\n" +
                       "      || TO_CHAR(Nivel4.CODIGO)\n" + "  END\n" + "  ||\n" + "  CASE\n" +
                       "    WHEN Nivel5.CODIGO IS NULL\n" + "    THEN ''\n" + "    ELSE '.'\n" +
                       "      || TO_CHAR(Nivel5.CODIGO)\n" + "  END\n" + "  ||\n" + "  CASE\n" +
                       "    WHEN Nivel6.CODIGO IS NULL\n" + "    THEN ''\n" + "    ELSE '.'\n" +
                       "      || TO_CHAR(Nivel6.CODIGO)\n" + "  END\n" + "  ||\n" + "  CASE\n" +
                       "    WHEN Nivel7.CODIGO IS NULL\n" + "    THEN ''\n" + "    ELSE '.'\n" +
                       "      || TO_CHAR(Nivel7.CODIGO)\n" + "  END AS cadena\n" + "FROM SII_RP_DET_RUBRO_CDP\n" +
                       "INNER JOIN SII_DETALLE_RUBRO_CDP\n" +
                       "ON (SII_DETALLE_RUBRO_CDP.DRC_CODIGO = SII_RP_DET_RUBRO_CDP.DRC_CODIGO)\n" +
                       "INNER JOIN SII_DETALLE_RUBRO\n" +
                       "ON (SII_DETALLE_RUBRO.DRU_CODIGO = SII_DETALLE_RUBRO_CDP.DRU_CODIGO)\n" +
                       "INNER JOIN PR_RUBRO\n" + "ON PR_RUBRO.VIGENCIA = SII_DETALLE_RUBRO.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO = SII_DETALLE_RUBRO.INTERNO\n" + "INNER JOIN Pr_Nivel1 Nivel1\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel1.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL1 = Nivel1.INTERNO\n" + "LEFT JOIN Pr_Nivel2 Nivel2\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel2.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL2 = Nivel2.INTERNO\n" + "LEFT JOIN Pr_Nivel3 Nivel3\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel3.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL3 = Nivel3.INTERNO\n" + "LEFT JOIN Pr_Nivel4 Nivel4\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel4.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL4 = Nivel4.INTERNO\n" + "LEFT JOIN Pr_Nivel5 Nivel5\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel5.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL5 = Nivel5.INTERNO\n" + "LEFT JOIN Pr_Nivel6 Nivel6\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel6.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL6 = Nivel6.INTERNO\n" + "LEFT JOIN Pr_Nivel7 Nivel7\n" +
                       "ON PR_RUBRO.VIGENCIA                  = Nivel7.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL7           = Nivel7.INTERNO\n" +
                       "WHERE SII_RP_DET_RUBRO_CDP.rdr_codigo = ?");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter(1, rdrCodigo);
            return (String) query.getSingleResult();

        } catch (EntityNotFoundException enf) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + enf.getMessage(), "DetalleRubroDAO");
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }
    }

    public String buscarNombreRubro(Long interno, Long vigencia) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select descripcion from pr_rubro r where  r.interno = ? and  r.vigencia = ?");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter(1, interno);
            query.setParameter(2, vigencia);
            return (String) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }
    }

    public String buscarNombreRubro(Long rdrCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PR_RUBRO.DESCRIPCION\n" + "FROM SII_RP_DET_RUBRO_CDP\n" +
                       "INNER JOIN SII_DETALLE_RUBRO_CDP\n" +
                       "ON (SII_DETALLE_RUBRO_CDP.DRC_CODIGO = SII_RP_DET_RUBRO_CDP.DRC_CODIGO)\n" +
                       "INNER JOIN SII_DETALLE_RUBRO\n" +
                       "ON (SII_DETALLE_RUBRO.DRU_CODIGO = SII_DETALLE_RUBRO_CDP.DRU_CODIGO)\n" +
                       "INNER JOIN PR_RUBRO\n" + "ON PR_RUBRO.VIGENCIA = SII_DETALLE_RUBRO.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO = SII_DETALLE_RUBRO.INTERNO\n" + "INNER JOIN Pr_Nivel1 Nivel1\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel1.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL1 = Nivel1.INTERNO\n" + "LEFT JOIN Pr_Nivel2 Nivel2\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel2.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL2 = Nivel2.INTERNO\n" + "LEFT JOIN Pr_Nivel3 Nivel3\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel3.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL3 = Nivel3.INTERNO\n" + "LEFT JOIN Pr_Nivel4 Nivel4\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel4.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL4 = Nivel4.INTERNO\n" + "LEFT JOIN Pr_Nivel5 Nivel5\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel5.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL5 = Nivel5.INTERNO\n" + "LEFT JOIN Pr_Nivel6 Nivel6\n" +
                       "ON PR_RUBRO.VIGENCIA        = Nivel6.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL6 = Nivel6.INTERNO\n" + "LEFT JOIN Pr_Nivel7 Nivel7\n" +
                       "ON PR_RUBRO.VIGENCIA                  = Nivel7.VIGENCIA\n" +
                       "AND PR_RUBRO.INTERNO_NIVEL7           = Nivel7.INTERNO\n" +
                       "WHERE SII_RP_DET_RUBRO_CDP.rdr_codigo = ?");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter(1, rdrCodigo);
            return (String) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }
    }

    public SiiDetalleRubro buscarDetalleRubroPorDetFuentePorRubro(Long idDetFuente, Long interno,
                                                                  Integer vigencia) throws ExcepcionDAO {
        SiiDetalleRubro detRubroRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT detalleRubro FROM SiiDetalleRubro detalleRubro");
            sql.append(" WHERE detalleRubro.siiDtlleFuenteFinanciacion.dffCodigo = :idDetFuente");
            sql.append(" AND detalleRubro.interno = :interno");
            sql.append(" AND detalleRubro.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idDetFuente", idDetFuente);
            query.setParameter("interno", interno);
            query.setParameter("vigencia", vigencia);
            List<SiiDetalleRubro> listaEntidadDetalleRubro = query.getResultList();
            if (listaEntidadDetalleRubro != null && listaEntidadDetalleRubro.size() > 0) {
                detRubroRetorno = listaEntidadDetalleRubro.get(0);
            }
            return detRubroRetorno;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }

    }

    public SiiDetalleRubro buscarDetalleRubroPorDetFuenteYrubroInterno(Long dffCodigo, Long rubroInterno,
                                                                       Integer vigencia) throws ExcepcionDAO {
        SiiDetalleRubro detRubroRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT detalleRubro FROM SiiDetalleRubro detalleRubro");
            sql.append(" WHERE detalleRubro.siiDtlleFuenteFinanciacion.dffCodigo = :idDetFuente");
            sql.append(" AND detalleRubro.interno = :interno");
            sql.append(" AND detalleRubro.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idDetFuente", dffCodigo);
            query.setParameter("interno", rubroInterno);
            query.setParameter("vigencia", vigencia);
            List<SiiDetalleRubro> listaEntidadDetalleRubro = query.getResultList();
            if (listaEntidadDetalleRubro != null && listaEntidadDetalleRubro.size() > 0) {
                detRubroRetorno = listaEntidadDetalleRubro.get(0);
            }
            return detRubroRetorno;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }


    }


    /**
     * Obtiene el listado de Detalles Rubro asociados a la vigencia especificada.
     * @param vigencia
     * @return List of SiiDetalleRubro.
     * @throws ExcepcionDAO
     */
    public List<SiiDetalleRubro> buscarDetalleRubroPorVigencia(Integer vigencia) throws ExcepcionDAO {
        List<SiiDetalleRubro> resultado = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT detalleRubro FROM SiiDetalleRubro detalleRubro ");
            sql.append("WHERE detalleRubro.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", vigencia);
            resultado = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

        return resultado;
    }


    /**
     * Realiza la consulta detallada de la Informaci&oacute;n del Rubro, el Detalle Rubro y la Fuente de Financiaci&oacute;n, asociadas al Detalle Rubro y Vigencia dadas.
     * @param druCodigo - C&oacute;digo del Detalle Rubro.
     * @param vigencia - Vigencia.
     * @return List of InfoDetalladaRubroVO.
     * @throws ExcepcionDAO
     */
    public List<InfoDetalladaRubroVO> buscarInformacionDetalladaRubroPorCodigoYVigencia(Long druCodigo,
                                                                                        Integer vigencia) throws ExcepcionDAO {
        return (this.buscarInformacionDetalladaRubroPorCodigoVigenciaRP(druCodigo, vigencia, null));
    }


    /**
     * Realiza la consulta detallada de la Informaci&oacute;n del Rubro, el Detalle Rubro y la Fuente de Financiaci&oacute;n, asociadas al RP, Detalle Rubro y Vigencia dadas.
     * @param druCodigo - C&oacute;digo del Detalle Rubro.
     * @param vigencia - Vigencia.
     * @param rpCodigo - C&oacute;digo del RP.
     * @return List of InfoDetalladaRubroVO.
     * @throws ExcepcionDAO
     */
    public List<InfoDetalladaRubroVO> buscarInformacionDetalladaRubroPorCodigoVigenciaRP(Long druCodigo,
                                                                                         Integer vigencia,
                                                                                         Long rpCodigo) throws ExcepcionDAO {
        List<InfoDetalladaRubroVO> resultado = new ArrayList<InfoDetalladaRubroVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  TO_CHAR(Nivel1.CODIGO) || ");
            sql.append("        (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) || ");
            sql.append("        (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) || ");
            sql.append("        (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) || ");
            sql.append("        (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) || ");
            sql.append("        (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) || ");
            sql.append("        (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as RUBRO, ");
            sql.append("        rubro.DESCRIPCION AS DESC_RUBRO,  ");
            sql.append("        dru.VIGENCIA,  ");
            sql.append("        dru.DRU_CODIGO,  ");
            sql.append("        dru.DRU_VALOR,  ");
            sql.append("        dru.INTERNO,  ");
            sql.append("        dru.DFF_CODIGO,  ");
            sql.append("        ffi.FFI_CODIGO,  ");
            sql.append("        ffi.FFI_CODIGO_FUENTE, ");
            sql.append("        ffi.FFI_DESCRIPCION,  ");
            sql.append("        dru.FFC_CODIGO,  ");
            sql.append("        ffC.FCC_NOMBRE,  ");
            sql.append("        dff.DFF_CODIGO_RECURSO, ");
            sql.append("        dff.DFF_DESCRIPCION, ");
            sql.append("        (SELECT NVL(SUM(mpdr_destino.mpd_valor), 0) FROM SII_MOD_PRES_DET_RUBRO mpdr_destino, SII_MODIFIC_PRESUP mp WHERE mp.mpr_codigo=mpdr_destino.mpr_codigo AND mp.emp_codigo=#empCodigo AND mp.mpr_tipo=#mprTipoTraslado AND mpdr_destino.dru_codigo_destino=dru.DRU_CODIGO) AS CREDITOS,  ");
            sql.append("        (SELECT NVL(SUM(mpdr_origen.mpd_valor), 0) FROM SII_MOD_PRES_DET_RUBRO mpdr_origen, SII_MODIFIC_PRESUP mp WHERE mp.mpr_codigo=mpdr_origen.mpr_codigo AND mp.emp_codigo=#empCodigo AND mp.mpr_tipo=#mprTipoTraslado AND mpdr_origen.dru_codigo_origen=dru.DRU_CODIGO) AS CONTRACREDITOS,  ");
            sql.append("        (SELECT NVL(SUM(mpdr.mpd_valor), 0) FROM SII_MOD_PRES_DET_RUBRO mpdr, SII_MODIFIC_PRESUP mp WHERE mp.mpr_codigo=mpdr.mpr_codigo AND mp.emp_codigo=#empCodigo AND mp.mpr_tipo=#mprTipoAdicion AND mpdr.dru_codigo_destino=dru.DRU_CODIGO) AS ADICIONES,  ");
            sql.append("        (SELECT NVL(SUM(mpdr.mpd_valor), 0) FROM SII_MOD_PRES_DET_RUBRO mpdr, SII_MODIFIC_PRESUP mp WHERE mp.mpr_codigo=mpdr.mpr_codigo AND mp.emp_codigo=#empCodigo AND mp.mpr_tipo=#mprTipoReduccion AND mpdr.dru_codigo_destino=dru.DRU_CODIGO) AS REDUCCIONES  ");

            if (rpCodigo != null) {
                sql.append(",   (SELECT NVL(SUM(imrpdrc.mrd_Valor), 0) FROM Sii_Modif_Rp_Det_Rub_Cdp imrpdrc ");
                sql.append("        INNER JOIN Sii_Modificacion_Rp imrp  ON  imrp.mrp_Codigo = imrpdrc.mrp_Codigo ");
                sql.append("        INNER JOIN Sii_Estado_Modific_Rp iemrp  ON  iemrp.emr_Codigo = imrp.emr_Codigo ");
                sql.append("        INNER JOIN Sii_Rp_Det_Rubro_Cdp irdrc  ON   irdrc.rdr_Codigo = imrpdrc.rdr_Codigo  ");
                sql.append("        INNER JOIN Sii_Detalle_Rubro_Cdp idrc  ON  idrc.drc_Codigo = irdrc.drc_Codigo ");
                sql.append("        INNER JOIN Sii_Detalle_Rubro idru  ON  idru.dru_Codigo = idrc.dru_Codigo ");
                sql.append("      WHERE iemrp.emr_Codigo = #emrCodigo ");
                sql.append("      AND imrp.rp_Codigo = rp.rp_Codigo ");
                sql.append("      AND idru.ffc_Codigo = dru.ffc_Codigo ");
                sql.append("      AND imrp.mrp_tipo_modif = #mrpTipoDecremento ");
                sql.append("      AND idrc.DRC_APLICA_GMF = #aplicaGmf ");
                sql.append("     ) AS DECREMENTOS_RP, ");

                sql.append("   (SELECT NVL(SUM(imrpdrc.mrd_Valor), 0) FROM Sii_Modif_Rp_Det_Rub_Cdp imrpdrc ");
                sql.append("        INNER JOIN Sii_Modificacion_Rp imrp  ON  imrp.mrp_Codigo = imrpdrc.mrp_Codigo ");
                sql.append("        INNER JOIN Sii_Estado_Modific_Rp iemrp  ON  iemrp.emr_Codigo = imrp.emr_Codigo ");
                sql.append("        INNER JOIN Sii_Rp_Det_Rubro_Cdp irdrc  ON   irdrc.rdr_Codigo = imrpdrc.rdr_Codigo  ");
                sql.append("        INNER JOIN Sii_Detalle_Rubro_Cdp idrc  ON  idrc.drc_Codigo = irdrc.drc_Codigo ");
                sql.append("        INNER JOIN Sii_Detalle_Rubro idru  ON  idru.dru_Codigo = idrc.dru_Codigo ");
                sql.append("      WHERE iemrp.emr_Codigo = #emrCodigo ");
                sql.append("      AND imrp.rp_Codigo = rp.rp_Codigo ");
                sql.append("      AND idru.ffc_Codigo = dru.ffc_Codigo ");
                sql.append("      AND imrp.mrp_tipo_modif = #mrpTipoIncremento ");
                sql.append("      AND idrc.DRC_APLICA_GMF = #aplicaGmf ");
                sql.append("     ) AS INCREMENTOS_RP, ");

                sql.append("     (SELECT NVL(SUM(OCR_VALOR), 0) AS TOTAL ");
                sql.append("      FROM SII_OBL_CONC_RP_DET_RUB_CDP ordrc ");
                sql.append("      INNER JOIN SII_OBLIGACION obl  on  obl.OBL_CODIGO = ordrc.OBL_CODIGO ");
                sql.append("      WHERE ordrc.RDR_CODIGO = rdrc.RDR_CODIGO ");
                sql.append("      AND obl.EOB_CODIGO IN (#estadoObligBorrador, #estadoObligAprobado) ");
                sql.append("     ) AS VALOR_OBLIGACIONES, ");
                
                sql.append("     (SELECT NVL(SUM(ncocr.NDR_VALOR), 0) AS TOTAL_NC ");
                sql.append("      FROM SII_NOTA_CRED_OBL_CONC_DET_RUB ncocr "); 
                sql.append("      INNER JOIN SII_OBL_CONC_RP_DET_RUB_CDP ocr  ON  ocr.OCR_CODIGO = ncocr.OCR_CODIGO ");
                sql.append("      INNER JOIN SII_OBLIGACION obl  on  obl.OBL_CODIGO = ocr.OBL_CODIGO ");
                sql.append("      INNER JOIN SII_NOTA_CREDITO ncr  ON  ncr.NCR_CODIGO = ncocr.NCR_CODIGO ");
                sql.append("      WHERE ocr.RDR_CODIGO = rdrc.RDR_CODIGO ");
                sql.append("      AND ncr.NCR_ESTADO <> #estadoNCRAnulada ");
                sql.append("      AND obl.EOB_CODIGO IN (#estadoObligBorrador, #estadoObligAprobado)");
                sql.append("     ) AS VALOR_NOTAS_CREDITO, ");
                
                sql.append("     rp.RP_CODIGO, ");
                sql.append("     rp.RP_CONSECUTIVO, ");
                sql.append("     rdrc.RDR_CODIGO, ");
                sql.append("     rdrc.RDR_VALOR ");
            }

            sql.append("FROM SII_DETALLE_RUBRO dru ");

            if (rpCodigo != null) {
                sql.append("INNER JOIN SII_DETALLE_RUBRO_CDP drc  ON  drc.DRU_CODIGO = dru.DRU_CODIGO ");
                sql.append("INNER JOIN SII_RP_DET_RUBRO_CDP rdrc  ON  rdrc.DRC_CODIGO = drc.DRC_CODIGO ");
                sql.append("INNER JOIN SII_RP rp  ON  rp.RP_CODIGO = rdrc.RP_CODIGO ");
            }

            sql.append("LEFT  JOIN SII_FUENTE_FINANC_CONTAB ffc  ON  ffc.FFC_CODIGO = dru.FFC_CODIGO  ");
            sql.append("LEFT  JOIN Sii_Dtlle_Fuente_Financiacion dff ON dru.Dff_Codigo = dff.Dff_Codigo ");
            sql.append("LEFT  JOIN Sii_Fuente_Financiacion ffi ON ffi.Ffi_Codigo = dff.Ffi_Codigo ");
            sql.append("INNER JOIN PR_RUBRO rubro   ON  rubro.Vigencia = dru.Vigencia And rubro.Interno = dru.Interno  ");
            sql.append("INNER JOIN Pr_Nivel1 Nivel1 ON  rubro.Vigencia = Nivel1.Vigencia And rubro.Interno_Nivel1 = Nivel1.Interno  ");
            sql.append("LEFT  JOIN Pr_Nivel2 Nivel2 ON  rubro.Vigencia = Nivel2.Vigencia And rubro.Interno_Nivel2 = Nivel2.Interno  ");
            sql.append("LEFT  JOIN Pr_Nivel3 Nivel3 ON  rubro.Vigencia = Nivel3.Vigencia And rubro.Interno_Nivel3 = Nivel3.Interno  ");
            sql.append("LEFT  JOIN Pr_Nivel4 Nivel4 ON  rubro.Vigencia = Nivel4.Vigencia And rubro.Interno_Nivel4 = Nivel4.Interno  ");
            sql.append("LEFT  JOIN Pr_Nivel5 Nivel5 ON  rubro.Vigencia = Nivel5.Vigencia And rubro.Interno_Nivel5 = Nivel5.Interno  ");
            sql.append("LEFT  JOIN Pr_Nivel6 Nivel6 ON  rubro.Vigencia = Nivel6.Vigencia And rubro.Interno_Nivel6 = Nivel6.Interno  ");
            sql.append("LEFT  JOIN Pr_Nivel7 Nivel7 ON  rubro.Vigencia = Nivel7.Vigencia And rubro.Interno_Nivel7 = Nivel7.Interno  ");
            sql.append("WHERE 1=1  ");

            if (vigencia != null)
                sql.append("AND dru.VIGENCIA = #vigencia ");

            if (druCodigo != null)
                sql.append("AND dru.DRU_CODIGO = #druCodigo ");

            if (rpCodigo != null) {
                sql.append("AND rp.RP_CODIGO = #rpCodigo ");
                sql.append("AND drc.DRC_APLICA_GMF = #aplicaGmf ");
            }


            sql.append("ORDER BY RUBRO");


            Query query = manager.createNativeQuery(sql.toString());

            if (vigencia != null)
                query.setParameter("vigencia", vigencia);

            if (druCodigo != null)
                query.setParameter("druCodigo", druCodigo);

            if (rpCodigo != null) {
                query.setParameter("emrCodigo", EnumEstadoModificRP.APROBADO.getId());
                query.setParameter("rpCodigo", rpCodigo);
                query.setParameter("mrpTipoDecremento", EnumTipoModificacionRP.DECREMENTO.getId());
                query.setParameter("mrpTipoIncremento", EnumTipoModificacionRP.INCREMENTO.getId());
                query.setParameter("aplicaGmf", EnumDecision.NO.getId());
            }


            query.setParameter("empCodigo", EnumEstadoModifPresup.AUTORIZADO.getId());
            query.setParameter("mprTipoTraslado", EnumTipoModificPresup.TRASLADO.getId());
            query.setParameter("mprTipoAdicion", EnumTipoModificPresup.ADICION.getId());
            query.setParameter("mprTipoReduccion", EnumTipoModificPresup.REDUCCION.getId());
            
            
            // Estados de Notas de Credito
            query.setParameter("estadoNCRAnulada", EnumEstadoNotaCredito.ANULADO.getId());
            
            // Estados de Obligacion
            query.setParameter("estadoObligBorrador", EnumEstadoObligacion.BORRADOR.getId());
            query.setParameter("estadoObligAprobado", EnumEstadoObligacion.APROBADO.getId());
            
            
            List<Object[]> rows = query.getResultList();
            for (Object[] row : rows) {
                InfoDetalladaRubroVO info = new InfoDetalladaRubroVO();
                info.setRubro((String) row[0]);
                info.setDescRubro((String) row[1]);

                if (row[2] != null)
                    info.setVigencia(((BigDecimal) row[2]).intValue());

                if (row[3] != null)
                    info.setDruCodigo(((BigDecimal) row[3]).longValue());

                if (row[4] != null)
                    info.setDruValor(((BigDecimal) row[4]).longValue());

                if (row[5] != null)
                    info.setInterno(((BigDecimal) row[5]).longValue());

                if (row[6] != null)
                    info.setDffCodigo(((BigDecimal) row[6]).longValue());

                if (row[7] != null)
                    info.setFfiCodigo(((BigDecimal) row[7]).longValue());

                if (row[8] != null)
                    info.setFfiCodigoFuente(((BigDecimal) row[8]).intValue());

                info.setFfiDescripcion((String) row[9]);
                info.setFfcCodigo((String) row[10]);
                info.setFccNombre((String) row[11]);

                if (row[12] != null)
                    info.setDffCodigoRecurso(((BigDecimal) row[12]).intValue());

                info.setDffDescripcion((String) row[13]);


                if (row[14] != null)
                    info.setCreditos(((BigDecimal) row[14]).longValue());

                if (row[15] != null)
                    info.setContracreditos(((BigDecimal) row[15]).longValue());

                if (row[16] != null)
                    info.setAdiciones(((BigDecimal) row[16]).longValue());

                if (row[17] != null)
                    info.setReducciones(((BigDecimal) row[17]).longValue());


                if (rpCodigo != null) {
                    if (row[18] != null)
                        info.setDecrementosRP((BigDecimal) row[18]);

                    if (row[19] != null)
                        info.setIncrementosRP((BigDecimal) row[19]);

                    if (row[20] != null)
                        info.setValorObligaciones((BigDecimal) row[20]);
                    
                    if (row[21] != null)
                        info.setValorNotasCredito((BigDecimal) row[21]);
                    
                    if (row[22] != null)
                        info.setRpCodigo(((BigDecimal) row[22]).longValue());

                    if (row[23] != null)
                        info.setRpConsecutivo(((BigDecimal) row[23]).longValue());

                    if (row[24] != null)
                        info.setRdrCodigo(((BigDecimal) row[24]).longValue());

                    if (row[25] != null)
                        info.setValorRP((BigDecimal) row[25]);
                }


                // crear y asignar una instancia de DetalleRubroVO por cada registro
                if (info.getDruCodigo() != null) {
                    // asignar value object con los datos principales del Detalle Rubro
                    SiiDetalleRubro siiDetalleRubro = this.buscarPorCodigoDetalleRubro(info.getDruCodigo());
                    DetalleRubroVO detalleRubroVo = new DetalleRubroVO(siiDetalleRubro);

                    info.setDetalleRubroVo(detalleRubroVo);
                }

                resultado.add(info);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

        return (resultado);
    }


    /**
     * Realiza la consulta detallada de la Informaci&oacute;n del Rubro, el Detalle Rubro y la Fuente de Financiaci&oacute;n, asociadas a la vigencia dada.
     * @param vigencia
     * @return List of InfoDetalladaRubroVO.
     * @throws ExcepcionDAO
     */
    public List<InfoDetalladaRubroVO> buscarInformacionDetalladaRubroPorVigencia(Integer vigencia) throws ExcepcionDAO {
        return (this.buscarInformacionDetalladaRubroPorCodigoYVigencia(null, vigencia));
    }


    /**
     * Realiza la consulta detallada de la Informaci&oacute;n de TODOS los registros relacionados con el Rubro, el Detalle Rubro y la Fuente de Financiaci&oacute;n.
     * @return List of InfoDetalladaRubroVO.
     * @throws ExcepcionDAO
     */
    public List<InfoDetalladaRubroVO> buscarTodaInformacionDetalladaRubro() throws ExcepcionDAO {
        return (this.buscarInformacionDetalladaRubroPorCodigoYVigencia(null, null));
    }

    public BigDecimal valorActualApropiacionPorRubro(Long druCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT NVL(SUM(valor),0) FROM (SELECT dru.DRU_VALOR valor \n" + "FROM sii_detalle_rubro dru\n" +
                       "WHERE dru.DRU_CODIGO = #druCodigo\n" + "UNION all\n" + "SELECT mpd.MPD_VALOR valor\n" +
                       "FROM sii_mod_pres_det_rubro mpd,\n" + "  sii_modific_presup mpr,\n" +
                       "  sii_estado_modif_presup emp\n" + "WHERE mpd.MPR_CODIGO       = mpr.MPR_CODIGO\n" +
                       "AND mpr.EMP_CODIGO         = emp.EMP_CODIGO\n" + "AND (mpd.DRU_CODIGO_DESTINO = #druCodigo\n" +
                       "AND mpr.MPR_TIPO           = 'A'\n" + "AND emp.EMP_NOMBRE         = 'AUTORIZADO')\n" +
                       "UNION all\n" + "SELECT -mpd.MPD_VALOR valor\n" + "FROM sii_mod_pres_det_rubro mpd,\n" +
                       "  sii_modific_presup mpr,\n" + "  sii_estado_modif_presup emp\n" +
                       "WHERE mpd.MPR_CODIGO       = mpr.MPR_CODIGO\n" +
                       "AND mpr.EMP_CODIGO         = emp.EMP_CODIGO\n" + "AND (mpd.DRU_CODIGO_DESTINO = #druCodigo\n" +
                       "AND mpr.MPR_TIPO           = 'R'\n" + "AND emp.EMP_NOMBRE         = 'AUTORIZADO')\n" +
                       "UNION all\n" + "SELECT -mpd.MPD_VALOR valor\n" + "FROM sii_mod_pres_det_rubro mpd,\n" +
                       "  sii_modific_presup mpr,\n" + "  sii_estado_modif_presup emp\n" +
                       "WHERE mpd.MPR_CODIGO       = mpr.MPR_CODIGO\n" +
                       "AND mpr.EMP_CODIGO         = emp.EMP_CODIGO\n" + "AND (mpd.DRU_CODIGO_DESTINO = #druCodigo\n" +
                       "AND mpr.MPR_TIPO           = 'T'\n" + "AND emp.EMP_NOMBRE         = 'AUTORIZADO')\n" +
                       "UNION all\n" + "SELECT mpd.MPD_VALOR valor\n" + "FROM sii_mod_pres_det_rubro mpd,\n" +
                       "  sii_modific_presup mpr,\n" + "  sii_estado_modif_presup emp\n" +
                       "WHERE mpd.MPR_CODIGO        = mpr.MPR_CODIGO\n" +
                       "AND mpr.EMP_CODIGO          = emp.EMP_CODIGO\n" + "AND (mpd.DRU_CODIGO_ORIGEN = #druCodigo\n" +
                       "AND mpr.MPR_TIPO            = 'T'\n" + "AND emp.EMP_NOMBRE          = 'AUTORIZADO'))");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return valor;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }

    }

    public BigDecimal valorActualComprometidoPorRubro(Long druCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT NVL(SUM(valor),0) FROM (SELECT  drc.DRU_VALOR valor\n" +
                       "FROM sii_detalle_rubro_cdp drc\n" + "INNER JOIN sii_cdp cdp\n" +
                       "ON drc.CDP_CODIGO = cdp.CDP_CODIGO\n" + "INNER JOIN sii_estado_cdp ecd\n" +
                       "ON cdp.ECD_CODIGO    = ecd.ECD_CODIGO\n" + "WHERE ecd.ECD_NOMBRE = 'CDP APROBADO'\n" +
                       "AND drc.DRU_CODIGO   = #druCodigo\n" + "UNION ALL\n" + "SELECT mcr.MCR_VALOR\n" +
                       "FROM sii_modif_cdp_det_rub_cdp mcr\n" + "INNER JOIN sii_detalle_rubro_cdp dcr\n" +
                       "ON mcr.DRC_CODIGO = dcr.DRC_CODIGO\n" + "INNER JOIN sii_modificacion_cdp mcd\n" +
                       "ON mcd.MCD_CODIGO = mcr.MCD_CODIGO\n" + "INNER JOIN sii_estado_modif_cdp emc\n" +
                       "ON mcd.EMC_CODIGO      = emc.EMC_CODIGO\n" + "WHERE mcd.MCD_TIPO_MOD = 'I'\n" +
                       "AND emc.EMC_NOMBRE     = 'APROBADO'\n" + "AND dcr.DRU_CODIGO     = #druCodigo\n" +
                       "UNION ALL\n" + "SELECT -mcr.MCR_VALOR\n" + "FROM sii_modif_cdp_det_rub_cdp mcr\n" +
                       "INNER JOIN sii_detalle_rubro_cdp dcr\n" + "ON mcr.DRC_CODIGO = dcr.DRC_CODIGO\n" +
                       "INNER JOIN sii_modificacion_cdp mcd\n" + "ON mcr.MCD_CODIGO = mcd.MCD_CODIGO\n" +
                       "INNER JOIN sii_estado_modif_cdp emc\n" + "ON mcd.EMC_CODIGO      = emc.EMC_CODIGO\n" +
                       "WHERE mcd.MCD_TIPO_MOD = 'D'\n" + "AND emc.EMC_NOMBRE     = 'APROBADO'\n" +
                       "AND dcr.DRU_CODIGO     = #druCodigo)");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return valor;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }

    }

    public BigDecimal valorActualComprometidoPorRubroDelCdp(Long druCodigo, Long cdpCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT NVL(SUM(valor),0)\n" + "FROM\n" + "  (SELECT drc.DRU_VALOR valor\n" +
                       "  FROM sii_detalle_rubro_cdp drc\n" + "  INNER JOIN sii_cdp cdp\n" +
                       "  ON drc.CDP_CODIGO = cdp.CDP_CODIGO\n" + "  INNER JOIN sii_estado_cdp ecd\n" +
                       "  ON cdp.ECD_CODIGO    = ecd.ECD_CODIGO\n" + "  WHERE ecd.ECD_NOMBRE = 'CDP APROBADO'\n" +
                       "  AND drc.DRU_CODIGO   = #druCodigo\n" + "  AND cdp.cdp_codigo   = #cdpCodigo\n" +
                       "  UNION ALL\n" + "  SELECT mcr.MCR_VALOR\n" + "  FROM sii_modif_cdp_det_rub_cdp mcr\n" +
                       "  INNER JOIN sii_detalle_rubro_cdp dcr\n" + "  ON mcr.DRC_CODIGO = dcr.DRC_CODIGO\n" +
                       "  INNER JOIN sii_modificacion_cdp mcd\n" + "  ON mcd.MCD_CODIGO = mcr.MCD_CODIGO\n" +
                       "  INNER JOIN sii_estado_modif_cdp emc\n" + "  ON mcd.EMC_CODIGO      = emc.EMC_CODIGO\n" +
                       "  WHERE mcd.MCD_TIPO_MOD = 'I'\n" + "  AND emc.EMC_NOMBRE     = 'APROBADO'\n" +
                       "  AND dcr.DRU_CODIGO     = #druCodigo\n" + "  UNION ALL\n" + "  SELECT -mcr.MCR_VALOR\n" +
                       "  FROM sii_modif_cdp_det_rub_cdp mcr\n" + "  INNER JOIN sii_detalle_rubro_cdp dcr\n" +
                       "  ON mcr.DRC_CODIGO = dcr.DRC_CODIGO\n" + "  INNER JOIN sii_modificacion_cdp mcd\n" +
                       "  ON mcr.MCD_CODIGO = mcd.MCD_CODIGO\n" + "  INNER JOIN sii_estado_modif_cdp emc\n" +
                       "  ON mcd.EMC_CODIGO      = emc.EMC_CODIGO\n" + "  WHERE mcd.MCD_TIPO_MOD = 'D'\n" +
                       "  AND emc.EMC_NOMBRE     = 'APROBADO'\n" + "  AND dcr.DRU_CODIGO     = #druCodigo\n" + "  )\n");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("cdpCodigo", druCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return valor;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }

    }

    public List<SiiDetalleRubro> buscarDetalleRubroPorDetalleRubroCdp(Long numeroCdp, Long rubroInterno, Integer vigencia,
                                                                Integer fuenteFinanciacion) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select dru from SiiDetalleRubroCdp drc inner join drc.siiDetalleRubro dru " +
                       "where drc.siiCdp.cdpConsecutivo = :numeroCdp and dru.interno = :rubroInterno " +
                       "and dru.vigencia = :vigencia and dru.siiDtlleFuenteFinanciacion.siiFuenteFinanciacion.ffiCodigoFuente = :fuenteFinanciacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numeroCdp", numeroCdp);
            query.setParameter("rubroInterno", rubroInterno);
            query.setParameter("vigencia", vigencia);
            query.setParameter("fuenteFinanciacion", fuenteFinanciacion);
            return  query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroDAO");
        }
    }
}
