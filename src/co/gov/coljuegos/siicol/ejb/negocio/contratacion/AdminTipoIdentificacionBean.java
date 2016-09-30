package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoIdentificacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoIdentificacionVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;


@Stateless
public class AdminTipoIdentificacionBean implements AdminTipoIdentificacion {
    @Resource
    SessionContext sessionContext;
    
    @EJB
    TipoIdentificacionDAO tipoIdentificacionDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminTipoIdentificacionBean() {
    }
    
    public TipoIdentificacionVO buscarTipoIdentificacionPorId(Long tidCodigo) throws ExcepcionDAO{
        SiiTipoIdentificacion unTipoIdentificacion = tipoIdentificacionDao.buscarTipoIdentificacionPorId(tidCodigo);
        return new TipoIdentificacionVO(unTipoIdentificacion);        
    }
    
    public TipoIdentificacionVO buscarTipoIdentificacionPorId(TipoIdentificacionVO tipoIdentificacionVo) throws ExcepcionDAO{
        SiiTipoIdentificacion unTipoIdentificacion = tipoIdentificacionDao.buscarTipoIdentificacionPorId(tipoIdentificacionVo.getTidCodigo());
        return new TipoIdentificacionVO(unTipoIdentificacion);        
    }
    
    public List<TipoIdentificacionVO> buscarTipoIdentificacionPorNombre(TipoIdentificacionVO unTipoIdentificacionVo) throws ExcepcionDAO{
        SiiTipoIdentificacion tipoIdentificacion;
        tipoIdentificacion = conversionVoEntidad.convertir(unTipoIdentificacionVo);
        List<SiiTipoIdentificacion> listaTipoIdentificacion;
        listaTipoIdentificacion = tipoIdentificacionDao.buscarTipoIdentificacionPorNombre(tipoIdentificacion);
        List<TipoIdentificacionVO> listaTipoIdentificacionVo;
        listaTipoIdentificacionVo = new ArrayList();
        for (SiiTipoIdentificacion unTipoIdentificacion : listaTipoIdentificacion){
            listaTipoIdentificacionVo.add(new TipoIdentificacionVO(unTipoIdentificacion));
        }
        return listaTipoIdentificacionVo;
    }        
    
    public List<TipoIdentificacionVO> buscarTodosTipoIdentificacion() throws ExcepcionDAO{
        List<SiiTipoIdentificacion> listaTipoIdentificacion = tipoIdentificacionDao.buscarTodosTipoIdentificacion();
        List<TipoIdentificacionVO> listaTipoIdentificacionVo = new ArrayList();
        for(SiiTipoIdentificacion unTipoIdentificacion : listaTipoIdentificacion){
            TipoIdentificacionVO nuevoTipoIdentificacion = new TipoIdentificacionVO(unTipoIdentificacion);
            listaTipoIdentificacionVo.add(nuevoTipoIdentificacion);
        }
        return listaTipoIdentificacionVo;
    }
    
    public TipoIdentificacionVO buscarTipoIdentificacionPorNombre(String tidNombre) throws ExcepcionDAO {
        return new TipoIdentificacionVO(tipoIdentificacionDao.buscarTipoIdentificacionPorNombre(tidNombre));
    }
}
