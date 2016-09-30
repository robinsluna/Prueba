package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AseguradoraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAseguradora;
import co.gov.coljuegos.siicol.ejb.vo.AseguradoraVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminAseguradoraBean implements AdminAseguradora{
    @EJB 
    AseguradoraDAO aseguradoraDao;
    public AdminAseguradoraBean() {
       
    }
    
    public List<AseguradoraVO> buscarTodaAseguradora() throws ExcepcionDAO {
        List<SiiAseguradora> aseguradoras = (List<SiiAseguradora>) aseguradoraDao.buscarTodaAseguradora();
        List<AseguradoraVO> aseguradorasVo = new ArrayList<AseguradoraVO>();
        for (SiiAseguradora aseguradora : aseguradoras) {
            aseguradorasVo.add(new AseguradoraVO(aseguradora));
        }
        return aseguradorasVo;
    }

    public AseguradoraVO buscarAseguradoraPorCodigo(Long aseCodigo) throws ExcepcionDAO {
        
        return new AseguradoraVO(aseguradoraDao.buscarAseguradoraPorCodigo(aseCodigo));
    }
}
