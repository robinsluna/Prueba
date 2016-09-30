package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoServicioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoServicio;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoServicioVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminTipoServicioBean implements AdminTipoServicio{
    @Resource
    SessionContext sessionContext;
    
    @EJB 
    TipoServicioDAO tipoServicioDao;
    @EJB 
    ConversionVOEntidad conversionVoEntidad;

    public AdminTipoServicioBean() {
    }


    /*public TipoServicioVO insertarTipoServicio(TipoServicioVO tipoServicioVO) throws ExcepcionDAO {
        return new TipoServicioVO(tipoServicioDao.insertarTipoServicio(conversionVoEntidad.convertir(tipoServicioVO)));
    }*/


    public TipoServicioVO buscarTipoServicioPorId(Long idTipoServicio) throws ExcepcionDAO {
        
        return new TipoServicioVO(tipoServicioDao.buscarTipoServicioPorId(idTipoServicio));
    }

    
    /*public TipoServicioVO actualizarTipoServicio(TipoServicioVO tipoServicioVO) throws ExcepcionDAO {
        
        return new TipoServicioVO(tipoServicioDao.actualizarTipoServicio(conversionVoEntidad.convertir(tipoServicioVO)));
    }*/


    public List<TipoServicioVO> buscarTodoTipoServicio() throws ExcepcionDAO {
        List<SiiTipoServicio> listaTipoServicio =  tipoServicioDao.buscarTodoTipoServicio();
        List<TipoServicioVO> listaTipoServicioVO = new ArrayList();
        for (SiiTipoServicio unTipoServicio : listaTipoServicio) {
            listaTipoServicioVO.add(new TipoServicioVO(unTipoServicio));
        }
        return listaTipoServicioVO;
    }
    
    public TipoServicioVO buscarTipoServicioPorNombre(String nombreServicio) throws ExcepcionDAO {
        return new TipoServicioVO(tipoServicioDao.buscarTipoServicioPorNombre(nombreServicio));
    }
}
