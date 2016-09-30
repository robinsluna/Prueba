package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoGarantiaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoGarantia;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoGarantiaVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoGarantiaBean implements AdminTipoGarantia {
    @Resource
    SessionContext sessionContext;

    @EJB
    ConversionVOEntidad conversionVoEntidad;

    @EJB
    TipoGarantiaDAO tipoGarantiaDao;

    public AdminTipoGarantiaBean() {
    }

    public TipoGarantiaVO buscarTipoGarantiaPorId(Long idTipoGarantia) throws ExcepcionDAO {
        SiiTipoGarantia unTipoGarantia = tipoGarantiaDao.buscarTipoGarantiaPorId(idTipoGarantia);
        return new TipoGarantiaVO(unTipoGarantia);
    }

    public List<TipoGarantiaVO> buscarTodosTipoGarantia() throws ExcepcionDAO {
        List<SiiTipoGarantia> listaTipoGarantia = tipoGarantiaDao.buscarTodosTipoGarantia();
        List<TipoGarantiaVO> listaTipoGarantiaVo = new ArrayList();
        for(SiiTipoGarantia unTipoGarantia : listaTipoGarantia) {
            TipoGarantiaVO nuevoTipoGarantia = new TipoGarantiaVO(unTipoGarantia);
            listaTipoGarantiaVo.add(nuevoTipoGarantia);
        }

        return listaTipoGarantiaVo;
    }

    public List<TipoGarantiaVO> buscarTipoGarantiaPorNombre(String nombreGarantia) throws ExcepcionDAO {
        List<SiiTipoGarantia> listaTipoGarantia;
        listaTipoGarantia = tipoGarantiaDao.buscarTipoGarantiaPorNombre(nombreGarantia);
        List<TipoGarantiaVO> listaTipoGarantiaVo;
        listaTipoGarantiaVo = new ArrayList();
        for(SiiTipoGarantia unTipoGarantia : listaTipoGarantia) {
            listaTipoGarantiaVo.add(new TipoGarantiaVO(unTipoGarantia));
        }
        return listaTipoGarantiaVo;
    }
}


