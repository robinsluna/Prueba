package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RequisitoCritDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRequisitoCrit;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.RequisitoCritVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminRequisitoCritBean implements AdminRequisitoCrit{
    @Resource
    SessionContext sessionContext;
    @EJB
    RequisitoCritDAO requisitoCritDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminRequisitoCritBean() {
    }
    
    public RequisitoCritVO buscarRequisitoCritPorId(Long  idRequisito) throws ExcepcionDAO{
        //SiiRequisitoCrit requsitoCrit = conversionVoEntidad.convertir(requisitoCritVo);
        SiiRequisitoCrit unRequisitoCrit = requisitoCritDao.buscarRequisitoCritPorId(idRequisito);
        return new RequisitoCritVO(unRequisitoCrit);        
        }
        
    public RequisitoCritVO insertarRequisitoCrit(RequisitoCritVO requisitoCritVo) throws ExcepcionDAO{
        SiiRequisitoCrit requisitoCrit = conversionVoEntidad.convertir(requisitoCritVo);
        SiiRequisitoCrit unRequisitoCrit = requisitoCritDao.insertarRequisitoCrit(requisitoCrit);
        return new RequisitoCritVO(unRequisitoCrit);
        }
        
    public RequisitoCritVO actualizarRequisitoCrit(RequisitoCritVO requisitoCritVo) throws ExcepcionDAO{
        SiiRequisitoCrit requisitoCrit = conversionVoEntidad.convertir(requisitoCritVo);
        SiiRequisitoCrit unRequisitoCrit = requisitoCritDao.actualizarRequisitoCrit(requisitoCrit);
        return new RequisitoCritVO(unRequisitoCrit);
        }
        
    public List<RequisitoCritVO> buscarTodosRequisitoCrit() throws ExcepcionDAO{
        List<SiiRequisitoCrit> listaRequisitoCrit;
        listaRequisitoCrit = requisitoCritDao.buscarTodosRequisitoCrit();
        List <RequisitoCritVO> listaRequisitoCritVo = new ArrayList();
        for (SiiRequisitoCrit unRequisitoCrit : listaRequisitoCrit){
            listaRequisitoCritVo.add(new RequisitoCritVO(unRequisitoCrit));
        }
        return listaRequisitoCritVo;
        }
    
    public List<RequisitoCritVO> buscarRequisitoCritPorTipo(String tipoRequisito) throws ExcepcionDAO{
        List<SiiRequisitoCrit> listaRequisitoCrit;
        listaRequisitoCrit = requisitoCritDao.buscarRequisitoCritPorTipo(tipoRequisito);
        List<RequisitoCritVO> listaRequisitoCritVo = new ArrayList();
        for (SiiRequisitoCrit unRequisitoCrit : listaRequisitoCrit){
            listaRequisitoCritVo.add(new RequisitoCritVO(unRequisitoCrit));
        }
        return listaRequisitoCritVo;
    }
    
    public List<RequisitoCritVO> buscarRequisitoCriPorIdEstudioPrevio (Integer idEstudioPrevio) throws ExcepcionDAO{
        List<SiiRequisitoCrit> listaRequisitoCrit;
        listaRequisitoCrit = requisitoCritDao.buscarRequisitoCriPorIdEstudioPrevio(idEstudioPrevio);
        List<RequisitoCritVO> listaRequisitoCritVo =new ArrayList<RequisitoCritVO>();
        if(listaRequisitoCrit!= null){
            for(SiiRequisitoCrit unReqCrit:listaRequisitoCrit ){
                    listaRequisitoCritVo.add(new RequisitoCritVO(unReqCrit));
            }
        }
        return listaRequisitoCritVo;
    
    }
}


