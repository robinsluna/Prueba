package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CacheDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminCacheBean implements AdminCache{
    
    @EJB
    CacheDAO cacheDao;
    
    public AdminCacheBean() {
    }
    
    public void limpiarCache() throws ExcepcionDAO{
        cacheDao.limpiarCache();
        System.out.println("Limpieza de cache exitosa");
    }
}
