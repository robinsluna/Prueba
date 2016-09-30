package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MedioDenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMedioDenuncia;
import co.gov.coljuegos.siicol.ejb.vo.MedioDenunciaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminMedioDenunciaBean implements AdminMedioDenuncia {
    
    @EJB
    MedioDenunciaDAO medioDenunciaDAO;
    
    public AdminMedioDenunciaBean() {
        medioDenunciaDAO = new MedioDenunciaDAO();
    }

    @Override
    public List<MedioDenunciaVO> buscarTodos() throws ExcepcionDAO {
        
        List<MedioDenunciaVO> listMedios = new ArrayList<MedioDenunciaVO>();
        List<SiiMedioDenuncia> listSiiMedios = medioDenunciaDAO.buscarTodo();
        
        for(SiiMedioDenuncia unSiiMedioDenuncia : listSiiMedios){
            
            MedioDenunciaVO medioVO = new MedioDenunciaVO(unSiiMedioDenuncia);
            listMedios.add(medioVO);
            
        }
        return listMedios;
    }
    
}
