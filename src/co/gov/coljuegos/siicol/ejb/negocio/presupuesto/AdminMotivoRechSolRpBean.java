/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Mónica Pabón
 * FECHA	: 26-11-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoRechSolRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDetRubroCdpDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoRechSolRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.CdpRubroDetalleFuenteVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoRpVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoAnulRpVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoRechSolRpVO;
import co.gov.coljuegos.siicol.ejb.vo.RpDetRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.RpVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminMotivoRechSolRpBean implements AdminMotivoRechSolRp{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    MotivoRechSolRpDAO motivoRechSolRpDao;
    @EJB
    RpDAO rpDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminMotivoRechSolRpBean() {
    }
    
    public MotivoRechSolRpVO insertarSiiMotivoRechSolRp(MotivoRechSolRpVO MotivoRechSolRpVO) throws ExcepcionDAO{
        SiiMotivoRechSolRp siiMotiRechSolRp = conversionVoEntidad.convertir(MotivoRechSolRpVO);
        SiiMotivoRechSolRp resultadoMotRechSolRp = motivoRechSolRpDao.insertarSiiMotivoRechSolRp(siiMotiRechSolRp);
        return new MotivoRechSolRpVO(resultadoMotRechSolRp);
    }
            
    public MotivoRechSolRpVO buscarPorCodigoMotivoRechSolRp(Long idCodigoMotivo) throws ExcepcionDAO{
        SiiMotivoRechSolRp resultadoSiiMotivoRechSolRp = motivoRechSolRpDao.buscarPorCodigoMotivoRechSolRp(idCodigoMotivo);
        MotivoRechSolRpVO miMotivoRechSolRpVO = new MotivoRechSolRpVO(resultadoSiiMotivoRechSolRp);
        List<SiiRp> miListaSiiRp = new ArrayList<SiiRp>(); 
        List<RpVO> miListaRpVo = new ArrayList<RpVO>();
        if(resultadoSiiMotivoRechSolRp!= null){
            miListaSiiRp = resultadoSiiMotivoRechSolRp.getSiiRpList1();
            if(!miListaSiiRp.isEmpty()){
                for(SiiRp unSiiRp : miListaSiiRp){
                        RpVO miRpVO = new RpVO(unSiiRp);
                        miListaRpVo.add(miRpVO);                        
                    }
                }
        }
        miMotivoRechSolRpVO.setRpList1(miListaRpVo);
        return miMotivoRechSolRpVO;
    }
    
       
    public MotivoRechSolRpVO actualizarSiiMotivoRechSolRp(MotivoRechSolRpVO MotivoRechSolRpVO) throws ExcepcionDAO {
        // se actualiza el padre
        
        SiiMotivoRechSolRp siiMotivo = conversionVoEntidad.convertir(MotivoRechSolRpVO);        
        SiiMotivoRechSolRp retornoSiiMotiv = motivoRechSolRpDao.actualizarSiiMotivoRechSolRp(siiMotivo);
        
        //Se actualizan los hijos         
        if(MotivoRechSolRpVO.getRpList1()!= null){
            for(RpVO unRpVO : MotivoRechSolRpVO.getRpList1()){
                    SiiRp miSiiRp = conversionVoEntidad.convertir(unRpVO);
                    miSiiRp.setSiiMotivoRechSolRp(retornoSiiMotiv);                    
                    rpDao.actualizarRp(miSiiRp);
                }
        }          
        return new MotivoRechSolRpVO(retornoSiiMotiv);
    }
    
    public List<MotivoRechSolRpVO> buscarTodoSiiMotivoRechSolRp() throws ExcepcionDAO{
        List<SiiMotivoRechSolRp> listaMotivos = motivoRechSolRpDao.buscarTodoSiiMotivoRechSolRp();        
        List<MotivoRechSolRpVO> listaMotivosRechVo = new ArrayList();
        for(SiiMotivoRechSolRp unaListaMotiv : listaMotivos){
            MotivoRechSolRpVO nuevoMotivRechVo = new MotivoRechSolRpVO(unaListaMotiv);
            listaMotivosRechVo.add(nuevoMotivRechVo);
        }
        return listaMotivosRechVo;
    }
    public void borrarSiiMotivoRechSolRp(MotivoRechSolRpVO MotivoRechSolRpVO) throws ExcepcionDAO{
       motivoRechSolRpDao.borrarSiiMotivoRechSolRp(MotivoRechSolRpVO.getMrsCodigo());        
    }

}    