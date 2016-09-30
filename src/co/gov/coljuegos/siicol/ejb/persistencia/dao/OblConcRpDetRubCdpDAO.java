/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 12-03-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoObligacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOblConcRpDetRubCdp;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class OblConcRpDetRubCdpDAO extends GenericDAO<SiiOblConcRpDetRubCdp> 
{
    /**
     * Constructor.
     */
    public OblConcRpDetRubCdpDAO() 
    {
        // Establecer la clase correspondiente a la Entidad que administra el DAO
        super(SiiOblConcRpDetRubCdp.class);
    }
    
    
    /**
     * Obtiene el listado de SiiOblConcRpDetRubCdp a partir del c&oacute;digo del Concepto de la Obligaci&oacute;n.
     * @param ocoCodigo - C&oacute;digo del Concepto de la Obligaci&oacute;n.
     * @return List of SiiOblConcRpDetRubCdp.
     * @throws ExcepcionDAO
     */
    public List<SiiOblConcRpDetRubCdp> buscarPorCodigoObligacionConcepto (Long ocoCodigo) throws ExcepcionDAO 
    {
        List<SiiOblConcRpDetRubCdp> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOblConcRpDetRubCdp o ");
            sql.append("WHERE o.siiObligacionConcepto.ocoCodigo = :ocoCodigo");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("ocoCodigo", ocoCodigo);
            resultado = query.getResultList();
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Obtiene el listado de SiiOblConcRpDetRubCdp a partir del c&oacute;digo de la Obligaci&oacute;n.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @return List of SiiOblConcRpDetRubCdp.
     * @throws ExcepcionDAO
     */
    public List<SiiOblConcRpDetRubCdp> buscarPorCodigoObligacion (Long oblCodigo) throws ExcepcionDAO 
    {
        List<SiiOblConcRpDetRubCdp> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOblConcRpDetRubCdp o ");
            sql.append("WHERE o.siiObligacion.oblCodigo = :oblCodigo");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("oblCodigo", oblCodigo);
            resultado = query.getResultList();
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Obtiene la sumatoria de los valores dentro de los registros de Imputaci&oacute;n Presupuestal asociados al RP Detalle Rubro CDP especificado.
     * @param rdrCodigo - C&oacute;digo del RP Detalle Rubro CDP.
     * @return Sumatoria de RDR_VALOR.
     * @throws ExcepcionDAO
     */
    public BigDecimal obtenerTotalPorRpDetRubCdp (Long rdrCodigo) throws ExcepcionDAO {
        BigDecimal result = new BigDecimal(0);
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT NVL(SUM(OCR_VALOR), 0) AS TOTAL ");
            sql.append("FROM SII_OBL_CONC_RP_DET_RUB_CDP ordrc ");
            sql.append("WHERE ordrc.RDR_CODIGO = #rdrCodigo ");
            
            
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("rdrCodigo", rdrCodigo);
            
            
            result = (BigDecimal) query.getSingleResult();
            
            if (result==null) {
                result = new BigDecimal(0);
            }
            
        }
        catch (NoResultException e) {
            result = new BigDecimal(0);
        }
        catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        
        return (result);
    }

    /**
     * @param rdrCodigo
     * @return la suma de las obligaciones aprobadas por uno de los rubros de un rp (rdrCodigo) menos los reintegros y notas credito
     * 
     * @throws ExcepcionDAO
     */
    public BigDecimal valorRubroRpEjecutado(Long rdrCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(ocr.OCR_VALOR)\n" + 
            "FROM Sii_Obl_Conc_Rp_Det_Rub_Cdp ocr\n" + 
            "INNER JOIN sii_Rp_Det_Rubro_Cdp rdr\n" + 
            "ON ocr.RDR_CODIGO = rdr.RDR_CODIGO\n" + 
            "INNER JOIN sii_Obligacion olb\n" + 
            "ON ocr.OBL_CODIGO = olb.OBL_CODIGO\n" + 
            "INNER JOIN sii_Estado_Obligacion eob\n" + 
            "ON olb.EOB_CODIGO    = eob.EOB_CODIGO\n" + 
            "WHERE rdr.RDR_CODIGO = #rdrCodigo\n" + 
            "AND eob.EOB_NOMBRE   = 'APROBADO'\n" + 
            "GROUP BY rdr.RDR_CODIGO\n" + 
            "UNION\n" + 
            "SELECT ROUND(SUM(ocr.OCR_VALOR) * 4 / 1000, 0)\n" + 
            "FROM Sii_Obl_Conc_Rp_Det_Rub_Cdp ocr\n" + 
            "INNER JOIN sii_Rp_Det_Rubro_Cdp rdr\n" + 
            "ON ocr.RDR_CODIGO = rdr.RDR_CODIGO\n" + 
            "INNER JOIN sii_Obligacion olb\n" + 
            "ON ocr.OBL_CODIGO = olb.OBL_CODIGO\n" + 
            "INNER JOIN sii_Estado_Obligacion eob\n" + 
            "ON olb.EOB_CODIGO = eob.EOB_CODIGO\n" + 
            "INNER JOIN sii_detalle_rubro_cdp drc\n" + 
            "ON rdr.DRC_CODIGO = drc.DRC_CODIGO\n" + 
            "INNER JOIN sii_detalle_rubro_cdp drcGmf\n" + 
            "ON drc.CDP_CODIGO  = drcGmf.CDP_CODIGO\n" + 
            "AND drc.DRU_CODIGO = drcGmf.DRU_CODIGO\n" + 
            "INNER JOIN sii_Rp_Det_Rubro_Cdp rdrGmf\n" + 
            "ON drcGmf.DRC_CODIGO      = rdrGmf.DRC_CODIGO\n" + 
            "AND rdr.RP_CODIGO         = rdrGmf.RP_CODIGO\n" + 
            "WHERE rdrGmf.RDR_CODIGO   = #rdrCodigo\n" + 
            "AND eob.EOB_NOMBRE        = 'APROBADO'\n" + 
            "AND drc.DRC_APLICA_GMF    = 'N'\n" + 
            "AND drcGmf.DRC_APLICA_GMF = 'S'\n" + 
            "GROUP BY rdrGmf.RDR_CODIGO" );
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("rdrCodigo", rdrCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            if (valor==null) {
                valor = BigDecimal.ZERO;
            }
            valor = valor.subtract(valorRubroEnNotaCredito(rdrCodigo));
            valor = valor.subtract(valorRubroEnReintegro(rdrCodigo));
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (NoResultException e) {
            return  BigDecimal.ZERO;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }  
    }

    
    /**
     * @param rdrCodigo
     * @return Suma de reintegros asociados a las Notas crédito con el dato 
     * Indicador Reconocimiento Independiente = SI, asociadas a la
     * la Obligación para el rubro del cual se requiere el saldo
     * @throws ExcepcionDAO
     */
    private BigDecimal valorRubroEnReintegro(Long rdrCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sum(rip.RIP_VALOR)\n" + 
            "FROM sii_reintegro_ingreso_pag rip\n" + 
            "INNER JOIN sii_nota_credito ncr\n" + 
            "ON rip.NCR_CODIGO = ncr.NCR_CODIGO\n" + 
            "INNER JOIN sii_nota_cred_obl_conc_det_rub ndr\n" + 
            "ON ncr.NCR_CODIGO = ndr.NCR_CODIGO\n" + 
            "INNER JOIN sii_obl_conc_rp_det_rub_cdp ocr\n" + 
            "ON ocr.OCR_CODIGO = ndr.OCR_CODIGO\n" + 
            "INNER JOIN sii_Obligacion obl\n" + 
            "ON ocr.OBL_CODIGO = obl.OBL_CODIGO\n" + 
            "INNER JOIN sii_Estado_Obligacion eob\n" + 
            "ON obl.EOB_CODIGO       = eob.EOB_CODIGO\n" + 
            "WHERE eob.EOB_NOMBRE    = 'APROBADO'\n" + 
            "AND ncr.NCR_ESTADO      = 'A'\n" + 
            "AND ncr.NCR_RC_INDEPEND = 'S'\n" + 
            "AND rip.rip_estado = 'A'\n" + 
            "AND ocr.RDR_CODIGO      = #rdrCodigo" );
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("rdrCodigo", rdrCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
    }
    
    /**
     * @param rdrCodigo
     * @return Suma de Notas crédito con el dato Indicador Reconocimiento
               Independiente = NO asociadas a la Obligación para el rubro del cual se requiere el saldo
     * @throws ExcepcionDAO
     */
    public BigDecimal valorRubroEnNotaCredito(Long rdrCodigo) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(ndr.NDR_VALOR)\n" + 
            "FROM sii_nota_cred_obl_conc_det_rub ndr\n" + 
            "INNER JOIN sii_obl_conc_rp_det_rub_cdp ocr\n" + 
            "ON ndr.OCR_CODIGO = ocr.OCR_CODIGO\n" + 
            "INNER JOIN sii_nota_credito ncr\n" + 
            "ON ndr.NCR_CODIGO  = ncr.NCR_CODIGO\n" + 
            "AND ncr.OBL_CODIGO = ocr.OBL_CODIGO\n" + 
            "INNER JOIN sii_Obligacion obl\n" + 
            "ON ncr.OBL_CODIGO = obl.OBL_CODIGO\n" + 
            "INNER JOIN sii_Estado_Obligacion eob\n" + 
            "ON obl.EOB_CODIGO       = eob.EOB_CODIGO\n" + 
            "AND ocr.RDR_CODIGO       = #rdrCodigo\n" + 
            "AND ncr.NCR_ESTADO      = 'A'\n" + 
            "AND ncr.NCR_RC_INDEPEND = 'N'\n" + 
            "GROUP BY ocr.RDR_CODIGO\n" + 
            "UNION\n" + 
            "SELECT round(SUM(ndr.NDR_VALOR)*4/1000,0)\n" + 
            "FROM sii_nota_cred_obl_conc_det_rub ndr\n" + 
            "INNER JOIN sii_obl_conc_rp_det_rub_cdp ocr\n" + 
            "ON ndr.OCR_CODIGO = ocr.OCR_CODIGO\n" + 
            "INNER JOIN sii_nota_credito ncr\n" + 
            "ON ndr.NCR_CODIGO  = ncr.NCR_CODIGO\n" + 
            "AND ncr.OBL_CODIGO = ocr.OBL_CODIGO\n" + 
            "INNER JOIN sii_Obligacion obl\n" + 
            "ON ncr.OBL_CODIGO = obl.OBL_CODIGO\n" + 
            "INNER JOIN sii_Estado_Obligacion eob\n" + 
            "ON obl.EOB_CODIGO = eob.EOB_CODIGO\n" + 
            "INNER JOIN sii_Rp_Det_Rubro_Cdp rdr\n" + 
            "ON ocr.RDR_CODIGO = rdr.RDR_CODIGO\n" + 
            "INNER JOIN sii_detalle_rubro_cdp drc\n" + 
            "ON rdr.DRC_CODIGO = drc.DRC_CODIGO\n" + 
            "INNER JOIN sii_detalle_rubro_cdp drcGmf\n" + 
            "ON drc.CDP_CODIGO  = drcGmf.CDP_CODIGO\n" + 
            "AND drc.DRU_CODIGO = drcGmf.DRU_CODIGO\n" + 
            "INNER JOIN sii_Rp_Det_Rubro_Cdp rdrGmf\n" + 
            "ON drcGmf.DRC_CODIGO      = rdrGmf.DRC_CODIGO\n" + 
            "AND rdr.RP_CODIGO         = rdrGmf.RP_CODIGO\n" + 
            "WHERE rdrGmf.RDR_CODIGO   = #rdrCodigo\n" + 
            "AND eob.EOB_NOMBRE        = 'APROBADO'\n" + 
            "AND drc.DRC_APLICA_GMF    = 'N'\n" + 
            "AND drcGmf.DRC_APLICA_GMF = 'S'  \n" + 
            "AND ncr.NCR_ESTADO      = 'A'\n" + 
            "AND ncr.NCR_RC_INDEPEND = 'N'\n" + 
            "GROUP BY rdrGmf.RDR_CODIGO , ocr.RDR_CODIGO" );
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("rdrCodigo", rdrCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (NoResultException e) {
            return  BigDecimal.ZERO;            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
    }


    /**
     * @author Giovanni
     * @param rdrCodigo
     * @return la suma de las obligaciones aprobadas por uno de los rubros de un rp (rdrCodigo) suma
     * @throws ExcepcionDAO
     */
    public BigDecimal valorRubroRpEjecutadoPagos(Long rdrCodigo) throws ExcepcionDAO {
        BigDecimal valor = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(o.ocrValor)");
            sql.append(" FROM SiiOrdenPago orp");
            sql.append(" INNER JOIN orp.siiObligacion obl");
            sql.append(" INNER JOIN obl.siiOblConcRpDetRubCdpList o");
            sql.append(" WHERE o.siiRpDetRubroCdp.rdrCodigo = :rdrCodigo");
            sql.append(" AND o.siiObligacion.siiEstadoObligacion.eobNombre = 'APROBADO'");
            sql.append(" AND orp.siiEstadoOrdenPago.eopNombre = 'APROBADO'");

            Query query = em.createQuery(sql.toString());
            query.setParameter("rdrCodigo", rdrCodigo);

            valor = (BigDecimal) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
        return (valor == null ? BigDecimal.ZERO : valor);
    }    
    
    /**
     * Obtiene el listado de SiiOblConcRpDetRubCdp a partir del c&oacute;digo del RP.
     * @param rpCodigo - C&oacute;digo del RP.
     * @return List of SiiOblConcRpDetRubCdp.
     * @throws ExcepcionDAO
     */
    public List<SiiOblConcRpDetRubCdp> buscarPorCodigoRp (Long rpCodigo) throws ExcepcionDAO 
    {
        List<SiiOblConcRpDetRubCdp> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOblConcRpDetRubCdp o ");
            sql.append("INNER JOIN SiiRpDetRubroCdp rdr  ON  rdr.rdrCodigo = o.siiRpDetRubroCdp.rdrCodigo ");
            sql.append("WHERE rdr.siiRp.rpCodigo = :rpCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            resultado = query.getResultList();
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Obtiene el listado de SiiOblConcRpDetRubCdp a partir del c&oacute;digo del RP y la Fuente de Financiaci&oacute;n Contable, asociadas a Obligaciones que No se encuentren ANULADAS.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return List of SiiOblConcRpDetRubCdp.
     * @throws ExcepcionDAO
     */
    public List<SiiOblConcRpDetRubCdp> buscarPorCodigoRpFFC (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        return ( this.buscarPorCodigoRpFFC(rpCodigo, ffcCodigo, true) );
    }
    
    
    /**
     * Obtiene el listado de SiiOblConcRpDetRubCdp a partir del c&oacute;digo del RP y la Fuente de Financiaci&oacute;n Contable.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @param descartarOblAnuladas - Flag que determina si es necesario descartar los registros asociados a Obligaciones en estado <i>ANULADO</i>.
     * @return List of SiiOblConcRpDetRubCdp.
     * @throws ExcepcionDAO
     */
    public List<SiiOblConcRpDetRubCdp> buscarPorCodigoRpFFC (Long rpCodigo, String ffcCodigo, boolean descartarOblAnuladas) throws ExcepcionDAO 
    {
        List<SiiOblConcRpDetRubCdp> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOblConcRpDetRubCdp o ");
            
            if (descartarOblAnuladas) {
                sql.append("INNER JOIN SiiObligacion obl  ON  obl.oblCodigo = o.siiObligacion.oblCodigo ");
                sql.append("INNER JOIN SiiEstadoObligacion eob  ON  eob.eobCodigo = obl.siiEstadoObligacion.eobCodigo ");
            }
            
            sql.append("INNER JOIN SiiRpDetRubroCdp rdr  ON  rdr.rdrCodigo = o.siiRpDetRubroCdp.rdrCodigo ");
            sql.append("INNER JOIN SiiDetalleRubroCdp drc  ON  drc.drcCodigo = rdr.siiDetalleRubroCdp.drcCodigo ");
            sql.append("INNER JOIN SiiDetalleRubro dru  ON  dru.druCodigo = drc.siiDetalleRubro.druCodigo ");
            sql.append("WHERE rdr.siiRp.rpCodigo = :rpCodigo ");
            
            if (ffcCodigo!=null) {
                sql.append("AND dru.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
            }
            
            if (descartarOblAnuladas) {
                sql.append("AND eob.eobCodigo <> :eobCodigoAnulado ");
            }
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            
            if (ffcCodigo!=null)
                query.setParameter("ffcCodigo", ffcCodigo);
            
            if (descartarOblAnuladas)
                query.setParameter("eobCodigoAnulado", EnumEstadoObligacion.ANULADO.getId());
            
            
            resultado = query.getResultList();
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Obtiene el listado de SiiOblConcRpDetRubCdp a partir del c&oacute;digo de la Obligaci&oacute;n y la Fuente de Financiaci&oacute;n Contable.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return List of SiiOblConcRpDetRubCdp.
     * @throws ExcepcionDAO
     */
    public List<SiiOblConcRpDetRubCdp> buscarPorCodigoObligacionRpFFC (Long oblCodigo, Long rpCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        List<SiiOblConcRpDetRubCdp> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOblConcRpDetRubCdp o ");
            sql.append("INNER JOIN SiiRpDetRubroCdp rdr  ON  rdr.rdrCodigo = o.siiRpDetRubroCdp.rdrCodigo ");
            sql.append("INNER JOIN SiiDetalleRubroCdp drc  ON  drc.drcCodigo = rdr.siiDetalleRubroCdp.drcCodigo ");
            sql.append("INNER JOIN SiiDetalleRubro dru  ON  dru.druCodigo = drc.siiDetalleRubro.druCodigo ");
            sql.append("WHERE o.siiObligacion.oblCodigo = :oblCodigo ");
            
            if (rpCodigo!=null) 
                sql.append("AND rdr.siiRp.rpCodigo = :rpCodigo ");
            
            if (ffcCodigo!=null) 
                sql.append("AND dru.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
            
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("oblCodigo", oblCodigo);
            
            if (rpCodigo!=null)
                query.setParameter("rpCodigo", rpCodigo);
            
            if (ffcCodigo!=null)
                query.setParameter("ffcCodigo", ffcCodigo);
            
            resultado = query.getResultList();
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return (resultado);
    }

    
}
