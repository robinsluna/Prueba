package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.PermisoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermiso;

import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.PermisoVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminPermisoBean implements AdminPermiso {
    
    @EJB
    PermisoDAO permisoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminPermisoBean() {
    }
    
    public PermisoVO insertarPermiso(PermisoVO permisoVo) throws ExcepcionDAO{
        SiiPermiso siiPermiso = permisoDao.insertarPermiso(conversionVoEntidad.convertir(permisoVo));
        return new PermisoVO(siiPermiso);
    }
}
