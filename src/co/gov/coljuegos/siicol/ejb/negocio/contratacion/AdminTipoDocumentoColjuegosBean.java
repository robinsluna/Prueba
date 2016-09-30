package co.gov.coljuegos.siicol.ejb.negocio.contratacion;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocumentoColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocumentoColjuegos;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocumentoColjuegosVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminTipoDocumentoColjuegosBean implements AdminTipoDocumentoColjuegos{
    
    @EJB
    TipoDocumentoColjuegosDAO tipoDocumentoColjuegosDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    
    public AdminTipoDocumentoColjuegosBean() {
    }
    
    public TipoDocumentoColjuegosVO insertarTipoDocumentoColjuegos(TipoDocumentoColjuegosVO tipoDocumentoColjuegosVO) throws ExcepcionDAO {
        SiiTipoDocumentoColjuegos tipoDocumentoColjuegos = conversionVoEntidad.convertir(tipoDocumentoColjuegosVO);
        tipoDocumentoColjuegos =  tipoDocumentoColjuegosDao.insertarTipoDocumentoColjuegos(tipoDocumentoColjuegos);
        return new TipoDocumentoColjuegosVO(tipoDocumentoColjuegos);
        }
    
    public TipoDocumentoColjuegosVO buscarTipoDocumentoColjuegosPorId(Long idTipoDocColjuegos) throws ExcepcionDAO {
        SiiTipoDocumentoColjuegos tipoDocumentoColjuegos = tipoDocumentoColjuegosDao.buscarTipoDocumentoColjuegosPorId(idTipoDocColjuegos);
        return new TipoDocumentoColjuegosVO(tipoDocumentoColjuegos);
    }

    public TipoDocumentoColjuegosVO actualizarTipoDocumentoColjuegos(TipoDocumentoColjuegosVO tipoDocumentoColjuegosVO) throws ExcepcionDAO {
        SiiTipoDocumentoColjuegos tipoDocumentoColjuegos = conversionVoEntidad.convertir(tipoDocumentoColjuegosVO);
        tipoDocumentoColjuegos = tipoDocumentoColjuegosDao.buscarTipoDocumentoColjuegosPorId(tipoDocumentoColjuegosVO.getTdoCodigo());
        return new TipoDocumentoColjuegosVO(tipoDocumentoColjuegos);
    }
/*
    public void eliminarTipoDocumentoColjuegos(TipoDocumentoColjuegosVO tipoDocumentoColjuegosVO) throws ExcepcionDAO {
        return tipoDocumentoColjuegosDao.eliminarTipoDocumentoColjuegos(tipoDocumentoColjuegosVO.getTdoCodigo());
    }
*/
    public List<TipoDocumentoColjuegosVO> buscarTodoTipoDocumentoColjuegos() throws ExcepcionDAO {
        List<SiiTipoDocumentoColjuegos> listaTiposDoc = tipoDocumentoColjuegosDao.buscarTodoTipoDocumentoColjuegos();
        List<TipoDocumentoColjuegosVO> listaRetornoVo = new ArrayList<TipoDocumentoColjuegosVO>();
        for(SiiTipoDocumentoColjuegos unTipoDocumento : listaTiposDoc){
            listaRetornoVo.add(new TipoDocumentoColjuegosVO(unTipoDocumento));
        }
        return listaRetornoVo;
    }
    
    public TipoDocumentoColjuegosVO buscarTipoDocumentoColjuegosPorNombre(String nombre) throws ExcepcionDAO {
        return tipoDocumentoColjuegosDao.buscarTipoDocumentoColjuegosPorNombre(nombre);
    }
    
}
