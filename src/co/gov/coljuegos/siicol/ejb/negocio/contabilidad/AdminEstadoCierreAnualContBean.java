package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoCierreAnualContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCierreAnualCont;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCierreAnualContVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoCierreAnualContBean implements AdminEstadoCierreAnualCont 
{
    @EJB
    private EstadoCierreAnualContDAO estadoCierreAnualContDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminEstadoCierreAnualContBean() { }
    
    

    @Override
    public EstadoCierreAnualContVO buscarEstadoCierreAnualContPorId(Long ecaCodigo) throws ExcepcionDAO {
        EstadoCierreAnualContVO resultado = null;
        SiiEstadoCierreAnualCont siiEstadoCierreAnualCont = estadoCierreAnualContDao.buscarPorCodigo(ecaCodigo);
        if (siiEstadoCierreAnualCont!=null)
            resultado = new EstadoCierreAnualContVO(siiEstadoCierreAnualCont);
        
        return (resultado);
    }

    @Override
    public List<EstadoCierreAnualContVO> buscarTodoEstadoCierreAnualCont() throws ExcepcionDAO {
        List<EstadoCierreAnualContVO> resultado = null;
        List<SiiEstadoCierreAnualCont> lista = estadoCierreAnualContDao.buscarTodo();
        
        if (lista!=null) {
            resultado = new ArrayList<EstadoCierreAnualContVO>();
            
            for (SiiEstadoCierreAnualCont siiEstadoCierreAnualCont: lista) {
                if (siiEstadoCierreAnualCont!=null)
                    resultado.add(new EstadoCierreAnualContVO(siiEstadoCierreAnualCont));
            }
        }
        
        return (resultado);
    }
}
