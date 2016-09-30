package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocSoporteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSoporte;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocSoporteVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoDocSoporteBean implements AdminTipoDocSoporte{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    TipoDocSoporteDAO tipoDocSoporteDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    public AdminTipoDocSoporteBean() {
    }  
    public TipoDocSoporteVO buscarTipoDocumentoSoportePorId(Long idTipoDocSoporte) throws ExcepcionDAO {
        SiiTipoDocSoporte tipoDocSoporte = tipoDocSoporteDao.buscarTipoDocumentoSoportePorId(idTipoDocSoporte);
        TipoDocSoporteVO tipoDocSoporteVoRetorno = new TipoDocSoporteVO(tipoDocSoporte);
        return tipoDocSoporteVoRetorno;
    }
        
    public List<TipoDocSoporteVO>  buscarTodoTipoDocumentoSoporte() throws ExcepcionDAO{
        List<SiiTipoDocSoporte> listaSiiTipoDocSoporte = tipoDocSoporteDao.buscarTodoTipoDocumentoSoporte();
        List<TipoDocSoporteVO> listaTipoDocSoporteVo = new ArrayList();
        for (SiiTipoDocSoporte unTipoDocSoporte : listaSiiTipoDocSoporte){
            TipoDocSoporteVO nuevoTipoDocSoporteVo = new TipoDocSoporteVO(unTipoDocSoporte);
            listaTipoDocSoporteVo.add(nuevoTipoDocSoporteVo);
        }
        return listaTipoDocSoporteVo;
    }
}
