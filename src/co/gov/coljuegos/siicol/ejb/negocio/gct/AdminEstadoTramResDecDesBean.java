package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTramResDecDesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDenuncia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResDecDes;
import co.gov.coljuegos.siicol.ejb.vo.EstadoDenunciaVO;

import co.gov.coljuegos.siicol.ejb.vo.EstadoTramResDecDesVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoTramResDecDesBean implements AdminEstadoTramResDecDes {
    
    
    @EJB
    EstadoTramResDecDesDAO estadoTramResDecDesDAO;

    public AdminEstadoTramResDecDesBean() {
        estadoTramResDecDesDAO = new EstadoTramResDecDesDAO();
    }
    
    @Override
    public List<EstadoTramResDecDesVO> buscarTodos() throws ExcepcionDAO {
        
        List<EstadoTramResDecDesVO> listEstados = new ArrayList<EstadoTramResDecDesVO>();
        List<SiiEstadoTramResDecDes> listSiiEstados = estadoTramResDecDesDAO.buscarTodo();
        
        for(SiiEstadoTramResDecDes unSiiEstadoDenuncia : listSiiEstados){
            
            EstadoTramResDecDesVO estadoVO = new EstadoTramResDecDesVO(unSiiEstadoDenuncia);
            listEstados.add(estadoVO);
            
        }
        return listEstados;
        
    }
    
    /*@Override
    public EstadoTramResDecDesVO buscarEstadoPorNombre(String estado) throws ExcepcionDAO {
        
        return new EstadoTramResDecDesVO(estadoTramResDecDesDAO..buscarEstadoPorNombre(estado));
    }*/
}
