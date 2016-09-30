package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTramResPrSanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResPrSan;
import co.gov.coljuegos.siicol.ejb.vo.EstadoTramResPrSanVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Estados de Tr&aacute;mite de Resoluci&oacute;n de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
@Stateless
public class AdminEstadoTramResPrSanBean implements AdminEstadoTramResPrSan 
{
    @EJB
    private EstadoTramResPrSanDAO estadoTramResPrSanDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminEstadoTramResPrSanBean() {
        super();
    }
    
    
    
    @Override
    public EstadoTramResPrSanVO buscarEstadoTramResPrSanPorCodigo(Long etrCodigo) throws ExcepcionDAO {
        EstadoTramResPrSanVO resultado = null;
        SiiEstadoTramResPrSan siiEstadoTramResPrSan = estadoTramResPrSanDao.buscarPorCodigo(etrCodigo);
        if (siiEstadoTramResPrSan!=null)
            resultado = new EstadoTramResPrSanVO(siiEstadoTramResPrSan);
        
        return (resultado);
    }
    
    
    @Override
    public List<EstadoTramResPrSanVO> buscarTodoEstadoTramResPrSan() throws ExcepcionDAO {
        List<EstadoTramResPrSanVO> resultado = null;
        List<SiiEstadoTramResPrSan> lista = estadoTramResPrSanDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<EstadoTramResPrSanVO>();
            for (SiiEstadoTramResPrSan siiEstadoTramResPrSan: lista) {
                if (siiEstadoTramResPrSan!=null)
                    resultado.add(new EstadoTramResPrSanVO(siiEstadoTramResPrSan));
            }
        }
        
        return (resultado);
    }
}
