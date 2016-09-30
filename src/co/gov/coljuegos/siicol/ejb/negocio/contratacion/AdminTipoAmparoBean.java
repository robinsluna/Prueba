package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoAmparoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoAmparo;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoAmparoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoAmparoBean implements AdminTipoAmparo{
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    TipoAmparoDAO tipoAmparoDao;
    
    public AdminTipoAmparoBean() {
    }
    
    public TipoAmparoVO buscarTipoAmparoPorId(Long idAmparo) throws ExcepcionDAO{        
        SiiTipoAmparo unTipoAmparo = tipoAmparoDao.buscarTipoAmparoPorId(idAmparo);
        return new TipoAmparoVO(unTipoAmparo);
        }
        
    public TipoAmparoVO insertarTipoAmparo(TipoAmparoVO tipoAmparoVo) throws ExcepcionDAO{
        SiiTipoAmparo tipoAmparo = conversionVoEntidad.convertir(tipoAmparoVo);
        SiiTipoAmparo unTipoAmparo = tipoAmparoDao.insertarTipoAmparo(tipoAmparo);
        return new TipoAmparoVO(unTipoAmparo);
        }
        
    public List<TipoAmparoVO> buscarTodosTipoAmparo() throws ExcepcionDAO{
            List<SiiTipoAmparo> listaTipoAmparo;
            listaTipoAmparo = tipoAmparoDao.buscarTodosTipoAmparo();
            List<TipoAmparoVO> listaTipoAmparoVo = new ArrayList();
            for(SiiTipoAmparo unTipoAmparo : listaTipoAmparo){
                listaTipoAmparoVo.add(new TipoAmparoVO(unTipoAmparo));
            }
            return listaTipoAmparoVo;            
        }
        
    
    public List<TipoAmparoVO> buscarTipoAmparoPorNombre(TipoAmparoVO tipoAmparoVo) throws ExcepcionDAO{
            SiiTipoAmparo tipoAmparo = conversionVoEntidad.convertir(tipoAmparoVo);
            List<SiiTipoAmparo> listaTipoAmparo;
            listaTipoAmparo = tipoAmparoDao.buscarTipoAmparoPorNombre(tipoAmparo);
            List<TipoAmparoVO> listaTipoAmparoVo = new ArrayList();
            for (SiiTipoAmparo unTipoAmparo : listaTipoAmparo){
                listaTipoAmparoVo.add(new TipoAmparoVO(unTipoAmparo));
            }
            return listaTipoAmparoVo;
        }
}
