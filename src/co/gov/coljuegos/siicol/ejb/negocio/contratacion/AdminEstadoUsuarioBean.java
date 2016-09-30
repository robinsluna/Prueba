package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolEstMercadoDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoUsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoUsuario;

import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoUsuarioVO;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;


@Stateless
public class AdminEstadoUsuarioBean implements AdminEstadoUsuario{
    
    @Resource
    SessionContext sessionContext;
    
    @EJB
    EstadoUsuarioDAO estadoUsuarioDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminEstadoUsuarioBean() {
    }
    public EstadoUsuarioVO buscarEstadoUsuarioPorId(EstadoUsuarioVO estadoUsuarioVo) throws ExcepcionDAO{
        SiiEstadoUsuario unEstadoUsuario = estadoUsuarioDao.buscarEstadoUsuarioPorId(estadoUsuarioVo.getEusCodigo());
        return new EstadoUsuarioVO(unEstadoUsuario);
    }
    public EstadoUsuarioVO insertarEstadoUsario(EstadoUsuarioVO estadoUsuarioVo) throws ExcepcionDAO{
        SiiEstadoUsuario estadoUsuario = conversionVoEntidad.convertir(estadoUsuarioVo);
        estadoUsuario = estadoUsuarioDao.insertarEstadoUsuario(estadoUsuario);
        return new EstadoUsuarioVO(estadoUsuario);
    }
    public EstadoUsuarioVO actualizarEstadoUsuario(EstadoUsuarioVO estadoUsuarioVo) throws ExcepcionDAO{
        SiiEstadoUsuario estadoUsuario = conversionVoEntidad.convertir(estadoUsuarioVo);
        SiiEstadoUsuario unEstadoUsuario = estadoUsuarioDao.actualizarEstadoUsuario(estadoUsuario);
        return new EstadoUsuarioVO(estadoUsuario);
    }
    public void eliminarEstadoUsuario(EstadoUsuarioVO estadoUsuarioVo) throws ExcepcionDAO{
        estadoUsuarioDao.eliminarEstadoUsuario(estadoUsuarioVo.getEusCodigo());
    }
 
}
