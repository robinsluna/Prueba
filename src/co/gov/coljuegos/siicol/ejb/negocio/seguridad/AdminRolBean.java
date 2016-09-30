package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RolDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;

import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.RolVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRolBean implements AdminRol {

    @EJB
    RolDAO rolDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminRolBean() {
    }

    public List<RolVO> buscarTodosRoles() throws ExcepcionDAO {
        List<RolVO> listaRolVo = null;
        List<SiiRol> listaSiiRol = rolDao.buscarTodosRoles();
        if (listaSiiRol != null && listaSiiRol.size() > 0) {
            listaRolVo = new ArrayList<RolVO>();
            for (SiiRol unSiiRol : listaSiiRol) {
                RolVO unRolVo = new RolVO(unSiiRol);
                listaRolVo.add(unRolVo);
            }
        }
        return listaRolVo;
    }

    public RolVO insertarRol(RolVO rolVo) throws ExcepcionDAO {
        SiiRol siiRol = conversionVoEntidad.convertir(rolVo);
        siiRol = rolDao.insertarRol(siiRol);
        return new RolVO(siiRol);
    }

    public List<RolVO> buscarTodosRolesConSinPermisoPorUsuario(Long idUsuario) throws ExcepcionDAO {
        return rolDao.buscarTodosRolesConSinPermisoPorUsuario(idUsuario);
    }
    
    public List<RolVO> buscarUsuariosIdPorRol(Long idusuario) throws ExcepcionDAO {
        List<RolVO> listaRolVo = new ArrayList();
         List<SiiRol> ListaSiiRol= null;
         ListaSiiRol=rolDao.buscarUsuariosIdPorRol(idusuario);        
         for(SiiRol unSiiRol: ListaSiiRol){
             RolVO unRolVo = new RolVO(unSiiRol);
             listaRolVo.add(unRolVo);
         }
         return listaRolVo;  
     }
    
    
    
}
