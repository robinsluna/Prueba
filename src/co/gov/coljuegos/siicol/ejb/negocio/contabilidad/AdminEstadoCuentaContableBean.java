package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoCuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCuentaContable;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.EstadoCuentaContableVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoCuentaContableBean implements AdminEstadoCuentaContable{
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private  EstadoCuentasContablesDAO estadoCuentasContablesDao;
    
    public AdminEstadoCuentaContableBean() {
        //super();
    }
    
    
    public EstadoCuentaContableVO buscarEstadoCuentaContablePorCodigo(Long idEstado) throws ExcepcionDAO {
        return (new EstadoCuentaContableVO(estadoCuentasContablesDao.buscarPorCodigo(idEstado)));    
    }


      public List<EstadoCuentaContableVO> buscarTodoEstadoCuentaContable() throws ExcepcionDAO {
        

        List<EstadoCuentaContableVO> listaEstadoCuentaContableVo = null;
        List<SiiEstadoCuentaContable> listaEstadoCuentaContable = estadoCuentasContablesDao.buscarTodo();
        if (listaEstadoCuentaContable!=null) {
            listaEstadoCuentaContableVo = new ArrayList<EstadoCuentaContableVO>();
            
            for (SiiEstadoCuentaContable siiEstadoCuentaContable: listaEstadoCuentaContable) {
                if (siiEstadoCuentaContable!=null)
                    listaEstadoCuentaContableVo.add(new EstadoCuentaContableVO(siiEstadoCuentaContable));
            }
        }
        return (listaEstadoCuentaContableVo);
    }
 
}
