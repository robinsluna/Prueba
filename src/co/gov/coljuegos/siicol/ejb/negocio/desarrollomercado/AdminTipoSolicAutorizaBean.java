package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSolicAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSolicAutoriza;
import co.gov.coljuegos.siicol.ejb.vo.TipoSolicAutorizaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminTipoSolicAutorizaBean implements AdminTipoSolicAutoriza {
    
    @EJB
    private TipoSolicAutorizaDAO tipoSolicAutorizaDao;
    
    public AdminTipoSolicAutorizaBean() {
        super();
    }

    @Override
    public TipoSolicAutorizaVO buscarTipoSolicAutorizaPorId(Long rdsCodigo) throws ExcepcionDAO {
        TipoSolicAutorizaVO resultado = null;
        SiiTipoSolicAutoriza siiTipoSolicAutoriza = tipoSolicAutorizaDao.buscarTipoSolicAutorizaPorCodigo(rdsCodigo);
        if(siiTipoSolicAutoriza!=null){
            resultado= (new TipoSolicAutorizaVO(siiTipoSolicAutoriza));
        }
        
        return resultado;
    }
  
    @Override
    public TipoSolicAutorizaVO insertarTipoSolicAutoriza(TipoSolicAutorizaVO tipoSolicAutorizaVo) throws ExcepcionDAO {
        // TODO Implement this method
        return null;
    }   

    @Override
    public TipoSolicAutorizaVO actualizarTipoSolicAutoriza(TipoSolicAutorizaVO tipoSolicAutorizaVo) throws ExcepcionDAO {
        // TODO Implement this method
        return null;
    }

    @Override
    public void eliminarTipoSolicAutoriza(Long rdsCodigo) throws ExcepcionDAO {
        // TODO Implement this method
    }

    @Override
    public List<TipoSolicAutorizaVO> buscarTodaTipoSolicAutoriza() throws ExcepcionDAO {
        List<TipoSolicAutorizaVO> resultado = null;
        List<SiiTipoSolicAutoriza> lista = tipoSolicAutorizaDao.buscarTodaTipoSolicAutoriza();
       
            if (lista!=null) {
            resultado = new ArrayList<TipoSolicAutorizaVO>();
            
            for (SiiTipoSolicAutoriza siiTipoSolicAutoriza: lista) {
                if (siiTipoSolicAutoriza!=null)
                    resultado.add(new TipoSolicAutorizaVO(siiTipoSolicAutoriza));
            }
        }       
        return resultado;
    }
    
}