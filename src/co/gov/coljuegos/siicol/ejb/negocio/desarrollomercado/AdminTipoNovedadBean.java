package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoNovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoNovedad;
import co.gov.coljuegos.siicol.ejb.vo.TipoNovedadVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoNovedadBean implements AdminTipoNovedad {
    
    @EJB
    private TipoNovedadDAO tipoNovedadDao;
    
    public AdminTipoNovedadBean() {
        super();
    }
    
    

    @Override 
    public List<TipoNovedadVO> buscarTodaTipoNovedad() throws ExcepcionDAO {
        List<TipoNovedadVO> resultado = null;
        List<SiiTipoNovedad> lista = tipoNovedadDao.buscarTodo();
       
            if (lista!=null) {
            resultado = new ArrayList<TipoNovedadVO>();
            
            for (SiiTipoNovedad siiTipoNovedad: lista) {
                if (siiTipoNovedad!=null)
                    resultado.add(new TipoNovedadVO(siiTipoNovedad));
            }
        }       
        return resultado;
    }

    @Override
    public TipoNovedadVO insertarTipoNovedad(TipoNovedadVO TipoNovedadVo) throws ExcepcionDAO {
        // TODO Implement this method
        return null;
    }

    @Override
    public TipoNovedadVO actualizarTipoNovedad(TipoNovedadVO TipoNovedadVo) throws ExcepcionDAO {
        // TODO Implement this method
        return null;
    }

    @Override
    public void eliminarTipoNovedad(Long rdsCodigo) throws ExcepcionDAO {
        // TODO Implement this method
    }

    public TipoNovedadVO buscarTipoNovedadPorId(Long tnoCodigo) throws ExcepcionDAO {
        TipoNovedadVO resultado = null;
        SiiTipoNovedad siiTipoNovedad = tipoNovedadDao.buscarTipoNovedadPorId(tnoCodigo);
        
            if (siiTipoNovedad!=null) {
                        resultado = (new TipoNovedadVO(siiTipoNovedad));
            }
        
        return resultado;
    }
}

  