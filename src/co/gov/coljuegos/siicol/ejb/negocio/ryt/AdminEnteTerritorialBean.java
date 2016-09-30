/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Camilo Miranda
 * FECHA	: 21-05-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.ryt;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EnteTerritorialDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEnteTerritorial;
import co.gov.coljuegos.siicol.ejb.vo.EnteTerritorialVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminEnteTerritorialBean implements AdminEnteTerritorial 
{
    @EJB
    private EnteTerritorialDAO enteTerritorialDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminEnteTerritorialBean() {
        super();
    }
    
    
    
    @Override
    public EnteTerritorialVO buscarEnteTerritorialPorId(Long etiCodigo) throws ExcepcionDAO 
    {
        EnteTerritorialVO resultado = null;
        
        if (etiCodigo!=null) {
            SiiEnteTerritorial siiEnteTerritorial = enteTerritorialDao.buscarEnteTerritorialPorId(etiCodigo);
            if (siiEnteTerritorial!=null)
                resultado = new EnteTerritorialVO(siiEnteTerritorial);
        }
        
        return (resultado);
    }
    
    
    @Override
    public EnteTerritorialVO buscarEnteTerritorialXIdUbicacion(String ubiCodigo) throws ExcepcionDAO 
    {
        EnteTerritorialVO resultado = null;
        
        if (ubiCodigo!=null) {
            SiiEnteTerritorial siiEnteTerritorial = enteTerritorialDao.buscarEnteTerritorialXIdUbicacion(ubiCodigo);
            if (siiEnteTerritorial!=null)
                resultado = new EnteTerritorialVO(siiEnteTerritorial);
        }
        
        return (resultado);
    }
    
    
    @Override
    public EnteTerritorialVO buscarEnteTerritorialPorUbicacion (String ubiCodigo) throws ExcepcionDAO 
    {
        EnteTerritorialVO resultado = null;
        
        if (ubiCodigo!=null) {
            SiiEnteTerritorial siiEnteTerritorial = enteTerritorialDao.buscarEnteTerritorialPorUbicacion(ubiCodigo);
            if (siiEnteTerritorial!=null)
                resultado = new EnteTerritorialVO(siiEnteTerritorial);
        }
        
        return (resultado);
    }
}
