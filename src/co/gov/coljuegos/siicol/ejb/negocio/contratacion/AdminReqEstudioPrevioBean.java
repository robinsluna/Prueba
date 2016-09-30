package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReqEstudioPrevioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReqEstudioPrevio;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ReqEstudioPrevioVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminReqEstudioPrevioBean implements  AdminReqEstudioPrevio{
    
    @Resource
    SessionContext sessionContext;
    @EJB
    ReqEstudioPrevioDAO reqEstudioPrevioDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminReqEstudioPrevioBean() {
    }
    
    public ReqEstudioPrevioVO buscarReqEstudioPrevioPorId(ReqEstudioPrevioVO reqEstudioPrevioVo) throws ExcepcionDAO{
        SiiReqEstudioPrevio reqEstudioPrevio = conversionVoEntidad.convertir(reqEstudioPrevioVo);
        SiiReqEstudioPrevio unEstudioPrevio = reqEstudioPrevioDao.buscarReqEstudioPrevioPorId(reqEstudioPrevioVo.getResCodigo());
        return new ReqEstudioPrevioVO(unEstudioPrevio);
    }
        
    public ReqEstudioPrevioVO insertarReqEstudioPrevio(ReqEstudioPrevioVO reqEstudioPrevioVo) throws ExcepcionDAO{
        SiiReqEstudioPrevio reqEstudioPrevio = conversionVoEntidad.convertir(reqEstudioPrevioVo);
        SiiReqEstudioPrevio unEstudioPrevio = reqEstudioPrevioDao.insertarReqEstudioPrevio(reqEstudioPrevio);
        return new ReqEstudioPrevioVO(unEstudioPrevio);
    }
        
    public ReqEstudioPrevioVO actualizarReqEstudioPrevio(ReqEstudioPrevioVO reqEstudioPrevioVo) throws ExcepcionDAO{
        SiiReqEstudioPrevio reqEstudioPrevio = conversionVoEntidad.convertir(reqEstudioPrevioVo);
        SiiReqEstudioPrevio unEstudioPrevio = reqEstudioPrevioDao.actualizarReqEstudioPrevio(reqEstudioPrevio);
        return new ReqEstudioPrevioVO(unEstudioPrevio);
    }
        
    public List<ReqEstudioPrevioVO> buscarTodosReqEstudioPrevio() throws ExcepcionDAO{
        List<SiiReqEstudioPrevio> listaReqEstudioPrevio;
        listaReqEstudioPrevio = reqEstudioPrevioDao.buscarTodosReqEstudioPrevio();
        List<ReqEstudioPrevioVO> listaReqEstudioPrevioVo = new ArrayList();
        for (SiiReqEstudioPrevio unReqEstudioPrevio : listaReqEstudioPrevio){
            listaReqEstudioPrevioVo.add(new ReqEstudioPrevioVO(unReqEstudioPrevio));
        }
        return listaReqEstudioPrevioVo;
    }
    
    public List<ReqEstudioPrevioVO> buscarReqEstudioPrevioPorEstudioPrevio(Long id) throws ExcepcionDAO {
        List<SiiReqEstudioPrevio> listaReqEstudioPrevio;
        listaReqEstudioPrevio = reqEstudioPrevioDao.buscarReqEstudioPrevioPorEstudioPrevio(id);
        List<ReqEstudioPrevioVO> listaReqEstudioPrevioVo = new ArrayList();
        for (SiiReqEstudioPrevio unReqEstudioPrevio : listaReqEstudioPrevio){
            listaReqEstudioPrevioVo.add(new ReqEstudioPrevioVO(unReqEstudioPrevio));
        }
        return listaReqEstudioPrevioVo;
        
    }
    
    public void eliminarReqEstudioPrevio(ReqEstudioPrevioVO reqEstudioPrevioVo) throws ExcepcionDAO{
        reqEstudioPrevioDao.eliminarReqEstudioPrevio(reqEstudioPrevioVo.getResCodigo());
    }
}

