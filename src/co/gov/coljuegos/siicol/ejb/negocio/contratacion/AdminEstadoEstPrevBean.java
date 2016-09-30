package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEstPrevDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEstPrev;

import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoEstPrevVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoEstPrevBean implements AdminEstadoEstPrev {
    @EJB
    EstadoEstPrevDAO EstadoEstPrevDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    
    public AdminEstadoEstPrevBean() {
    }
   
    public EstadoEstPrevVO buscarEstadoEstPrevPorId(Long idEstadoEstPrev) throws ExcepcionDAO{
        SiiEstadoEstPrev unEstadoEstPrev = EstadoEstPrevDao.buscarEstadoEstPrevPorId(idEstadoEstPrev);
        return new EstadoEstPrevVO(unEstadoEstPrev);
    }

    public EstadoEstPrevVO insertarEstadoEstPrevPorId(EstadoEstPrevVO estadoEstPrevVo) throws ExcepcionDAO{
        SiiEstadoEstPrev estadoEstPrev = conversionVoEntidad.convertir(estadoEstPrevVo);
        SiiEstadoEstPrev unEstadoEstPrev = EstadoEstPrevDao.insertarEstadoEstPrev(estadoEstPrev);
        return new EstadoEstPrevVO(unEstadoEstPrev);
    }
    
    public EstadoEstPrevVO actualizarEstadoEstPrevPorId(EstadoEstPrevVO estadoEstPrevVo) throws ExcepcionDAO{
        SiiEstadoEstPrev estadoEstPrev = conversionVoEntidad.convertir(estadoEstPrevVo);
        SiiEstadoEstPrev unEstadoEstPrev = EstadoEstPrevDao.actualizarEstadoEstPrevPorId(estadoEstPrev);
        return new EstadoEstPrevVO(unEstadoEstPrev);
    }
    public List<EstadoEstPrevVO> buscarTodoEstadoEstPrev() throws ExcepcionDAO{
        List<SiiEstadoEstPrev> listaEstadoEstPrev;
        listaEstadoEstPrev = EstadoEstPrevDao.buscarTodoEstadoEstPrev();
        List<EstadoEstPrevVO> listaEstadoEstPrevVo = new ArrayList();
        for (SiiEstadoEstPrev unEstadoEstPrev : listaEstadoEstPrev){
            listaEstadoEstPrevVo.add(new EstadoEstPrevVO(unEstadoEstPrev));
        }
        return listaEstadoEstPrevVo;
    }
}