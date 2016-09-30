/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: RECAUDO Y TRANSFERENCIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 29-08-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDistribDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDistrib;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDistribVO;

import co.gov.coljuegos.siicol.ejb.vo.DetalleDistribucionVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminDetalleDistribBean implements AdminDetalleDistrib {
    
    @EJB
    private DetalleDistribDAO detalleDistribDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminDetalleDistribBean() { }

    @Override
    public DetalleDistribVO buscarPorCodigoDetalleDistrib(Long dmeCodigo) throws ExcepcionDAO {
        DetalleDistribVO resultado = null;
        SiiDetalleDistrib siiDetalleDistrib = detalleDistribDao.buscarPorCodigoDetalleDistrib(dmeCodigo);
        if (siiDetalleDistrib!=null)
            resultado = new DetalleDistribVO(siiDetalleDistrib);
        
        return (resultado);
    }
    
    
    @Override
    public DetalleDistribVO insertarDetalleDistrib(DetalleDistribVO detalleDistribVo) throws ExcepcionDAO {
        DetalleDistribVO resultado = null;
        SiiDetalleDistrib siiDetalleDistrib = detalleDistribDao.insertarSiiDetalleDistrib(conversionVoEntidad.convertir(detalleDistribVo));
        if (siiDetalleDistrib!=null)
            resultado = new DetalleDistribVO(siiDetalleDistrib);
        
        return (resultado);
    }
    
    
    @Override
    public List<DetalleDistribVO> buscarDetalleDistribPorIdDistribucion(Long dmeCodigo) throws ExcepcionDAO {
        List<DetalleDistribVO> resultado = null;
        List<SiiDetalleDistrib> lista = detalleDistribDao.buscarDetalleDistribPorIdDistribucion(dmeCodigo);
        if (lista!=null) {
            resultado = new ArrayList<DetalleDistribVO>();
            
            for (SiiDetalleDistrib siiDetalleDistrib: lista) {
                if (siiDetalleDistrib!=null) {
                    resultado.add(new DetalleDistribVO(siiDetalleDistrib));
                }
            }
        }
        
        return (resultado);
    }
    public List<DetalleDistribucionVO> buscarDetalleDistribucionPorId(Long idDistriMes) throws ExcepcionDAO {        
        return(detalleDistribDao.buscarDetalleDistribucionPorId(idDistriMes));
    }
}
