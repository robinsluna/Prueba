/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 21-10-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoAnulacionRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDetRubroCdpDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.CdpRubroDetalleFuenteVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoRpVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoAnulRpVO;
import co.gov.coljuegos.siicol.ejb.vo.RpDetRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.RpVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminMotivoAnulacionRpBean implements AdminMotivoAnulacionRp{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    MotivoAnulacionRpDAO motivoAnulacionRpDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    RpDAO rpDao;
    
    
    public AdminMotivoAnulacionRpBean() {
    }
    
    public MotivoAnulRpVO insertarMotivoAnulacionRp(MotivoAnulRpVO motivoAnulRpVo) throws ExcepcionDAO{
        SiiMotivoAnulRp siiMotivoAnulRp = conversionVoEntidad.convertir(motivoAnulRpVo);
        SiiMotivoAnulRp resultadoSiiMotivoAnulRp = motivoAnulacionRpDao.insertarSiiMotivoAnulRp(siiMotivoAnulRp);
       
        return new MotivoAnulRpVO(resultadoSiiMotivoAnulRp);
    }
    
    public MotivoAnulRpVO buscarPorCodigoMotivoAnulRp(MotivoAnulRpVO motivoAnulVo) throws ExcepcionDAO{
        SiiMotivoAnulRp resultadoSiiMotivoAnulRp = motivoAnulacionRpDao.buscarPorCodigoMotivoAnulacion(motivoAnulVo.getManCodigo());
        MotivoAnulRpVO miMotivoVO = new MotivoAnulRpVO(resultadoSiiMotivoAnulRp);
        List<SiiRp> miListaSiiRp = new ArrayList<SiiRp>(); 
        List<RpVO> miListaRpVo = new ArrayList<RpVO>();
        if(resultadoSiiMotivoAnulRp!= null){
            miListaSiiRp = resultadoSiiMotivoAnulRp.getSiiRpList();
            if(!miListaSiiRp.isEmpty()){
                for(SiiRp unSiiRp : miListaSiiRp){
                        RpVO miRpVO = new RpVO(unSiiRp);
                        miListaRpVo.add(miRpVO);                        
                    }
                }
        }
        miMotivoVO.setRpList(miListaRpVo);       
        return miMotivoVO;
    }
    
        
    public MotivoAnulRpVO actualizarSiiMotivoAnulRp(MotivoAnulRpVO motivoVo) throws ExcepcionDAO {
        
        // se actualiza el padre
        SiiMotivoAnulRp siiMotivo = conversionVoEntidad.convertir(motivoVo);        
        SiiMotivoAnulRp retornoSiiMotiv = motivoAnulacionRpDao.actualizarSiiMotivoAnulRp(siiMotivo);
        
        //Se actualizan los hijos         
        if(motivoVo.getRpList()!= null){
            for(RpVO unRpVO : motivoVo.getRpList()){
                    SiiRp miSiiRp = conversionVoEntidad.convertir(unRpVO);
                    miSiiRp.setSiiMotivoAnulRp(retornoSiiMotiv);                    
                    rpDao.actualizarRp(miSiiRp);
                }
        }        
        
        
        return new MotivoAnulRpVO(retornoSiiMotiv);
    }
    
    public List<MotivoAnulRpVO> buscarTodoMotivoAnulacion() throws ExcepcionDAO{
        List<SiiMotivoAnulRp> listaMotivos = motivoAnulacionRpDao.buscarTodoSiiMotivoAnulRp();
        
        List<MotivoAnulRpVO> listaMotivosAnulVo = new ArrayList();
        for(SiiMotivoAnulRp unaListaMotiv : listaMotivos){
            MotivoAnulRpVO nuevoMotivAnulVo = new MotivoAnulRpVO(unaListaMotiv);
            listaMotivosAnulVo.add(nuevoMotivAnulVo);
        }
        return listaMotivosAnulVo;
    }
    public void borrarMotivoAnulacionRp(MotivoAnulRpVO motivoAnulVo) throws ExcepcionDAO{
        motivoAnulacionRpDao.borrarSiiMotivoAnulRp(motivoAnulVo.getManCodigo());        
    }

}    