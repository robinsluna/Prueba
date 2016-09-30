package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.LogActividadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogActividad;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminLogActividadBean implements AdminLogActividad {

    @EJB
    LogActividadDAO logActividadDao;
    @EJB
    UsuarioDAO usuarioDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminLogActividadBean() {
    }

    public void log(Date fecha, String idSesion, String permisoAcceso, String url, UsuarioVO usuarioVo) {
        try{
            SiiLogActividad siiLogActividad = new SiiLogActividad();
            siiLogActividad.setLoaFecha(fecha);
            siiLogActividad.setLoaIdSesion(idSesion);
            siiLogActividad.setLoaPermisoAcc(permisoAcceso);
            siiLogActividad.setLoaUrl(url);
            if(usuarioVo != null && usuarioVo.getUsuCodigo() != null && usuarioVo.getUsuCodigo() > 0){
                siiLogActividad.setSiiUsuario(usuarioDao.buscarUsuarioPorId(usuarioVo.getUsuCodigo()));
            }
            logActividadDao.insertar(siiLogActividad);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
