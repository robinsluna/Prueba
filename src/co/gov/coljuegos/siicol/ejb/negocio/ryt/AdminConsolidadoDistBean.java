/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Camilo Miranda
 * FECHA	: 21-05-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConsolidadoDistDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConsolidadoDist;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ConsolidadoDistVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Consolidados de Distribuci&oacute;n.
 * @author Camilo Miranda
 */
@Stateless
public class AdminConsolidadoDistBean implements AdminConsolidadoDist {
    
    @EJB
    private ConsolidadoDistDAO consolidadoDistDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    /**
     * Constructor.
     */
    public AdminConsolidadoDistBean() {
        super();
    }
    
    
    @Override
    public ConsolidadoDistVO buscarPorCodigoConsolidadoDist(Long codCodigo) throws ExcepcionDAO {
        ConsolidadoDistVO resultado = null;
        
        if (codCodigo!=null) { 
            SiiConsolidadoDist siiConsolidoDist = consolidadoDistDao.buscarPorCodigoConsolidadoDist(codCodigo);
            if (siiConsolidoDist!=null) {
                resultado = new ConsolidadoDistVO(siiConsolidoDist);
            }
        }
        return (resultado);
    }
    
    
    @Override
    public ConsolidadoDistVO insertarConsolidadoDist(ConsolidadoDistVO consolidadoDistVo) throws ExcepcionDAO 
    {
        ConsolidadoDistVO resultado = null;
        if (consolidadoDistVo!=null) {
            SiiConsolidadoDist siiConsolidoDist = consolidadoDistDao.insertarSiiConsolidadoDist(conversionVoEntidad.convertir(consolidadoDistVo));
            if (siiConsolidoDist!=null)
                resultado = new ConsolidadoDistVO(siiConsolidoDist);
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<ConsolidadoDistVO> buscarPorCodigoDistribucionMes(Long dmeCodigo) throws ExcepcionDAO 
    {
        List<ConsolidadoDistVO> resultado = null;
        
        if (dmeCodigo!=null) {
            List<SiiConsolidadoDist> lista = consolidadoDistDao.buscarPorCodigoDistribucionMes(dmeCodigo);
            if (lista!=null) {
                resultado = new ArrayList<ConsolidadoDistVO>();
                
                for (SiiConsolidadoDist siiConsolidadoDist: lista) {
                    if (siiConsolidadoDist!=null)
                        resultado.add(new ConsolidadoDistVO(siiConsolidadoDist));
                }
            }
        }
        
        return (resultado);
    }
}
