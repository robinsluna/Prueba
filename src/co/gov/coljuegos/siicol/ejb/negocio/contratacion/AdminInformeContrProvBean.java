package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InformeContrProvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeContrProv;
import co.gov.coljuegos.siicol.ejb.vo.InformeContrProvVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminInformeContrProvBean implements AdminInformeContrProv {
    @EJB
    InformeContrProvDAO informeContrProvDao;

    public List<InformeContrProvVO> buscarInformeContrProvPorActaInicio(Long acnCodigo) throws ExcepcionDAO {
        List<InformeContrProvVO> listaInformeContrProvVo = new ArrayList<InformeContrProvVO>();
        List<SiiInformeContrProv> listaInformeContrProv = informeContrProvDao.buscarInformeContrProvPorActaInicio(acnCodigo);
        if (listaInformeContrProv != null) {
            for (SiiInformeContrProv informeContrProv : listaInformeContrProv) {
                listaInformeContrProvVo.add(new InformeContrProvVO(informeContrProv));
            } 
        }
        
        return listaInformeContrProvVo;
    }
}
