package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcesoSancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcesoSanc;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcesoSancVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Estados de Procesos Sancionatorio.
 * @author Camilo Miranda
 */
@Stateless
public class AdminEstadoProcesoSancBean implements AdminEstadoProcesoSanc 
{
    @EJB
    private EstadoProcesoSancDAO estadoProcesoSancDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminEstadoProcesoSancBean() {
        super();
    }
    
    
    @Override
    public EstadoProcesoSancVO buscarEstadoProcesoSancPorCodigo(Long epsCodigo) throws ExcepcionDAO {
        EstadoProcesoSancVO resultado = null;
        SiiEstadoProcesoSanc siiEstadoProcesoSanc = estadoProcesoSancDao.buscarPorCodigo(epsCodigo);
        if (siiEstadoProcesoSanc!=null)
            resultado = new EstadoProcesoSancVO(siiEstadoProcesoSanc);
        
        return (resultado);
    }
    
    
    @Override
    public List<EstadoProcesoSancVO> buscarTodoEstadoProcesoSanc() throws ExcepcionDAO {
        List<EstadoProcesoSancVO> resultado = null;
        List<SiiEstadoProcesoSanc> lista = estadoProcesoSancDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<EstadoProcesoSancVO>();
            for (SiiEstadoProcesoSanc siiEstadoProcesoSanc: lista) {
                if (siiEstadoProcesoSanc!=null)
                    resultado.add(new EstadoProcesoSancVO(siiEstadoProcesoSanc));
            }
        }
        
        return (resultado);
    }
}
