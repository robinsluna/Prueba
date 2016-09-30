package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InformeActaIniDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeActaIni;
import co.gov.coljuegos.siicol.ejb.vo.InformeActaIniVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminInformeActaIniBean implements AdminInformeActaIni {
    @Resource
    SessionContext sessionContext;
    @EJB
    InformeActaIniDAO informeActaIniDao;

    public AdminInformeActaIniBean() {

    }

    public List<InformeActaIniVO> buscarInformeActaIniPorActaInicio(Long acnCodigo) throws ExcepcionDAO {
        List<InformeActaIniVO> listaInformeActaIniVo = new ArrayList<InformeActaIniVO>();
        List<SiiInformeActaIni> listaInformeActaIni = informeActaIniDao.buscarInformeActaIniPorActaInicio(acnCodigo);
        for (SiiInformeActaIni info :listaInformeActaIni) {
            listaInformeActaIniVo.add(new InformeActaIniVO(info));
        }
        return listaInformeActaIniVo;
    }
}
