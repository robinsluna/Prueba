package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDenuncia;
import co.gov.coljuegos.siicol.ejb.vo.EstadoDenunciaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminEstadoDenunciaBean implements AdminEstadoDenuncia {

    @EJB
    EstadoDenunciaDAO estadoDenunciaDAO;

    public AdminEstadoDenunciaBean() {
        estadoDenunciaDAO = new EstadoDenunciaDAO();
    }

    @Override
    public List<EstadoDenunciaVO> buscarTodos() throws ExcepcionDAO {
        
        List<EstadoDenunciaVO> listEstados = new ArrayList<EstadoDenunciaVO>();
        List<SiiEstadoDenuncia> listSiiEstados = estadoDenunciaDAO.buscarTodo();
        
        for(SiiEstadoDenuncia unSiiEstadoDenuncia : listSiiEstados){
            
            EstadoDenunciaVO estadoVO = new EstadoDenunciaVO(unSiiEstadoDenuncia);
            listEstados.add(estadoVO);
            
        }
        return listEstados;
        
    }

    public EstadoDenunciaVO buscarEstadoPorNombre(String estado) throws ExcepcionDAO {
        
        return new EstadoDenunciaVO(estadoDenunciaDAO.buscarEstadoPorNombre(estado));
    }
}


