/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Mónica Pabón
 * FECHA	: 21-05-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConsolidadoDist;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ConsolidadoDistDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
	@EJB
    private PersonaDAO PersonaDao;
    @EJB
    private DistribucionMesDAO distribucionMesDao;
    @EJB
    private UbicacionDAO ubicacionDao;
    
    public ConsolidadoDistDAO() {
        recursos = new Recursos();
    }
    public SiiConsolidadoDist buscarPorCodigoConsolidadoDist(Long idCodigoConsolidadoDist) throws ExcepcionDAO {
        SiiConsolidadoDist retorno = null;
        try {
            retorno = manager.find(SiiConsolidadoDist.class, idCodigoConsolidadoDist);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConsolidadoDistDAO");
        }
        return retorno;

    }
    
    public SiiConsolidadoDist insertarSiiConsolidadoDist(SiiConsolidadoDist siiConsolidadoDist) throws ExcepcionDAO {
        try {
            manager.persist(siiConsolidadoDist); 
            manager.flush(); 
            return siiConsolidadoDist; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConsolidadoDistDAO");
        }
    }
    
    
    
    /**
     * Realiza la consulta de Consolidado de Distribuci&oacute;n a partir del c&oacute;digo de la Distribuci&oacute;n Mes.
     * @param dmeCodigo - C&oacute;digo de la Distribuci&oacute;n Mes.
     * @return List of SiiConsolidadoDist.
     * @throws ExcepcionDAO
     */
    public List<SiiConsolidadoDist> buscarPorCodigoDistribucionMes (Long dmeCodigo) throws ExcepcionDAO 
    {
        List<SiiConsolidadoDist> resultado = null;
        
        if (dmeCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT cd FROM SiiConsolidadoDist cd ");
                sql.append("WHERE cd.siiDistribucionMes.dmeCodigo = :dmeCodigo ORDER BY cd.codCodigo");
                
                
                Query query = manager.createQuery(sql.toString());
                query.setParameter("dmeCodigo", dmeCodigo);
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
	    public List<SiiConsolidadoDist> buscarConsolidadoDistribPorIdDistribucion(Long dmeCodigo) throws ExcepcionDAO {         
            List<SiiConsolidadoDist> lista = new ArrayList<SiiConsolidadoDist>();
            try{             
                StringBuilder sql = new StringBuilder();
                
                /*sql.append(" select sum(cdis.codValorRecaudo),sum(cdis.codLocalizMenCien),sum(cdis.codLocalizMayCien),sum(cdis.codLocMayCienDnp),");
                                sql.append(" sum(cdis.codPromocionales),sum(NVL(cdis.codRifas,0)),sum(NVL(cdis.codHipicosGallist,0)),sum(NVL(cdis.codActuacAdmin,0)),");
                                sql.append(" sum(NVL(cdis.codInteresMora,0)), sum(NVL(cdis.codInteresFinanc,0)),sum(NVL(cdis.codLegalizacAnticip,0)),sum(NVL(cdis.codTotalControl,0)),");
                                sql.append(" sum(NVL(cdis.codColciencias,0)), sum(NVL(cdis.codSubtotalTrans,0)), sum(NVL(cdis.codPorcentajePart,0)), sum (NVL(cdis.codRendimientosFin,0)),");
                                sql.append(" sum(NVL(cdis.codTotalTransf,0)),sum(NVL(cdis.codDistribFosyga,0)),sum(NVL(cdis.codDistribMunicip,0)),");
                                sql.append(" cdis.siiPersona, cdis.siiDistribucionMes,cdis.siiUbicacion,sum(NVL(cdis.codDerechosExpl,0)), sum(NVL(cdis.codDeMunicipio,0)),");
                                sql.append(" sum(NVL(cdis.codDeColciencias,0)), sum(NVL(cdis.codDeFosyga,0)),sum(NVL(cdis.codImMunicipio,0)), sum(NVL(cdis.codImColciencias,0)),");
                                sql.append(" sum(NVL(cdis.codImFosyga,0)),sum(NVL(cdis.codIfMunicipio,0)), sum(NVL(cdis.codIfColciencias,0)), sum(NVL(cdis.codIfFosyga,0)),");
                                sql.append(" sum(NVL(cdis.codAaMunicipio,0)),sum(NVL(cdis.codAaColciencias,0)), sum(NVL(cdis.codAaFosyga,0)),sum(NVL(cdis.codRfMunicipio,0)),");
                                sql.append(" sum(NVL(cdis.codRfColciencias,0)), sum(NVL(cdis.codRfFosyga,0)), sum(NVL(cdis.codDistrColciencias,0))");
                                sql.append(" from SiiConsolidadoDist cdis");
                                sql.append(" where cdis.siiDistribucionMes.dmeCodigo =:dmeCodigo");
                                sql.append(" group by cdis.per_codigo, cdis.dme_codigo,cdis.ubi_codigo");*/
                                
                sql.append(" select sum(cdis.cod_valor_recaudo),sum(cdis.cod_localiz_men_cien),sum(cdis.cod_localiz_may_cien),sum(cdis.cod_loc_may_cien_dnp),");
                sql.append(" sum(cdis.cod_promocionales),sum(NVL(cdis.cod_rifas,0)),sum(NVL(cdis.cod_hipicos_gallist,0)),sum(NVL(cdis.cod_actuac_admin,0)),");
                sql.append(" sum(NVL(cdis.cod_interes_mora,0)), sum(NVL(cdis.cod_interes_financ,0)),sum(NVL(cdis.cod_legalizac_anticip,0)),sum(NVL(cdis.cod_total_control,0)),");
                sql.append(" sum(NVL(cdis.cod_colciencias,0)), sum(NVL(cdis.cod_subtotal_trans,0)), sum(NVL(cdis.cod_porcentaje_part,0)), sum (NVL(cdis.cod_rendimientos_fin,0)),");
                sql.append(" sum(NVL(cdis.cod_total_transf,0)),sum(NVL(cdis.cod_distrib_fosyga,0)),sum(NVL(cdis.cod_distrib_municip,0)),");
                sql.append(" cdis.per_codigo, cdis.dme_codigo,cdis.ubi_codigo,sum(NVL(cdis.cod_derechos_expl,0)), sum(NVL(cdis.cod_de_municipio,0)),");
                sql.append(" sum(NVL(cdis.cod_de_colciencias,0)), sum(NVL(cdis.cod_de_fosyga,0)),sum(NVL(cdis.cod_im_municipio,0)), sum(NVL(cdis.cod_im_colciencias,0)),");
                sql.append(" sum(NVL(cdis.cod_im_fosyga,0)),sum(NVL(cdis.cod_if_municipio,0)), sum(NVL(cdis.cod_if_colciencias,0)), sum(NVL(cdis.cod_if_fosyga,0)),");
                sql.append(" sum(NVL(cdis.cod_aa_municipio,0)),sum(NVL(cdis.cod_aa_colciencias,0)), sum(NVL(cdis.cod_aa_fosyga,0)),sum(NVL(cdis.cod_rf_municipio,0)),");
                sql.append(" sum(NVL(cdis.cod_rf_colciencias,0)), sum(NVL(cdis.cod_rf_fosyga,0)), sum(NVL(cdis.cod_distr_colciencias,0))");
                sql.append(" from Sii_Consolidado_Dist cdis");
                sql.append(" where dme_codigo =#dmeCodigo");
                sql.append(" group by cdis.per_codigo, cdis.dme_codigo,cdis.ubi_codigo");
                
               
                                                       
                Query query = manager.createNativeQuery(sql.toString());
                
                query.setParameter("dmeCodigo",dmeCodigo);
                
                             
                List<Object[]> results = query.getResultList();
                for(Object[] object : results){
                    SiiConsolidadoDist miSiiConsolidadoDis = new SiiConsolidadoDist(); 
                    miSiiConsolidadoDis.setCodValorRecaudo((BigDecimal) object[0]);
                    miSiiConsolidadoDis.setCodLocalizMenCien((BigDecimal) object[1]);
                    miSiiConsolidadoDis.setCodLocalizMayCien((BigDecimal) object[2]);
                    miSiiConsolidadoDis.setCodLocMayCienDnp((BigDecimal) object[3]);
                    miSiiConsolidadoDis.setCodPromocionales((BigDecimal) object[4]);
                    miSiiConsolidadoDis.setCodRifas((BigDecimal) object[5]);
                    miSiiConsolidadoDis.setCodHipicosGallist((BigDecimal) object[6]);
                    miSiiConsolidadoDis.setCodActuacAdmin((BigDecimal) object[7]);
                    miSiiConsolidadoDis.setCodInteresMora((BigDecimal) object[8]);
                    miSiiConsolidadoDis.setCodInteresFinanc((BigDecimal) object[9]);
                    miSiiConsolidadoDis.setCodLegalizacAnticip((BigDecimal) object[10]);
                    miSiiConsolidadoDis.setCodTotalControl((BigDecimal) object[11]);
                    miSiiConsolidadoDis.setCodColciencias((BigDecimal) object[12]);
                    miSiiConsolidadoDis.setCodSubtotalTrans((BigDecimal) object[13]);
                    miSiiConsolidadoDis.setCodPorcentajePart((BigDecimal) object[14]);
                    miSiiConsolidadoDis.setCodRendimientosFin((BigDecimal) object[15]);
                    miSiiConsolidadoDis.setCodTotalTransf((BigDecimal) object[16]);
                    miSiiConsolidadoDis.setCodDistribFosyga((BigDecimal) object[17]);
                    miSiiConsolidadoDis.setCodDistribMunicip((BigDecimal) object[18]);
                    if((BigDecimal) object[19]!= null){
                        SiiPersona siiPersona = PersonaDao.buscarPersonaPorId(((BigDecimal) object[19]).longValue());  
                        miSiiConsolidadoDis.setSiiPersona(siiPersona);
                    }
                    if((BigDecimal) object[20]!= null){
                    SiiDistribucionMes siiDistribucionMes = distribucionMesDao.buscarPorCodigoDistribucionMes(((BigDecimal) object[20]).longValue());
                    miSiiConsolidadoDis.setSiiDistribucionMes(siiDistribucionMes);
                    }
                    if((String) object[21]!= null){
                    SiiUbicacion siiUbicacion = ubicacionDao.buscarUbicacionPorId((String) object[21]);                   
                    miSiiConsolidadoDis.setSiiUbicacion(siiUbicacion);
                    }
                    miSiiConsolidadoDis.setCodDerechosExpl((BigDecimal) object[22]);
                    miSiiConsolidadoDis.setCodDeMunicipio((BigDecimal) object[23]);
                    miSiiConsolidadoDis.setCodDeColciencias((BigDecimal) object[24]);
                    miSiiConsolidadoDis.setCodDeFosyga((BigDecimal) object[25]);
                    miSiiConsolidadoDis.setCodImMunicipio((BigDecimal) object[26]);
                    miSiiConsolidadoDis.setCodImColciencias((BigDecimal) object[27]);
                    miSiiConsolidadoDis.setCodImFosyga((BigDecimal) object[28]);
                    miSiiConsolidadoDis.setCodIfMunicipio((BigDecimal) object[29]);
                    miSiiConsolidadoDis.setCodIfColciencias((BigDecimal) object[30]);
                    miSiiConsolidadoDis.setCodIfFosyga((BigDecimal) object[31]);
                    miSiiConsolidadoDis.setCodAaMunicipio((BigDecimal) object[32]);
                    miSiiConsolidadoDis.setCodAaColciencias((BigDecimal) object[33]);
                    miSiiConsolidadoDis.setCodAaFosyga((BigDecimal) object[34]);
                    miSiiConsolidadoDis.setCodRfMunicipio((BigDecimal) object[35]);
                    miSiiConsolidadoDis.setCodRfColciencias((BigDecimal) object[36]);
                    miSiiConsolidadoDis.setCodRfFosyga((BigDecimal) object[37]);
                    miSiiConsolidadoDis.setCodDistrColciencias((BigDecimal) object[38]);                    
                               
                    lista.add(miSiiConsolidadoDis);               
                }             
                
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            return lista;
        }
}
