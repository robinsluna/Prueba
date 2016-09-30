package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocSoporteModifDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSoporteModif;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocSoporteModifVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoDocSoporteModifBean implements AdminTipoDocSoporteModif {
    @EJB
    TipoDocSoporteModifDAO tipoDocSoporteModifDao;

    public AdminTipoDocSoporteModifBean() {
    }

    public List<TipoDocSoporteModifVO> buscarTodosTipoDocSoporteModif() throws ExcepcionDAO {
        List<TipoDocSoporteModifVO> listaVo = new ArrayList<TipoDocSoporteModifVO>();
        for (SiiTipoDocSoporteModif tipo : tipoDocSoporteModifDao.buscarTodosTipoDocSoporteModif()) {
            listaVo.add(new TipoDocSoporteModifVO(tipo));
        }        
        return listaVo;
    }
    
    public TipoDocSoporteModifVO buscarTipoSoporteModifPorNombre(String tdmNombre) throws ExcepcionDAO {
        return new TipoDocSoporteModifVO(tipoDocSoporteModifDao.buscarTipoSoporteModifPorNombre(tdmNombre));
    }

    public TipoDocSoporteModifVO buscarTipoSoporteModifPorId(Long tdmCodigo) throws ExcepcionDAO {
        return new TipoDocSoporteModifVO(tipoDocSoporteModifDao.buscarTipoSoporteModifPorId(tdmCodigo));
    }
}
