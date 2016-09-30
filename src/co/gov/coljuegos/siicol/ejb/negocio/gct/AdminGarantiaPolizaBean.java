package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoPolizaContrato;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantiaPolizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaPoliza;
import co.gov.coljuegos.siicol.ejb.vo.GarantiaPolizaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminGarantiaPolizaBean implements AdminGarantiaPoliza {
    @EJB 
    GarantiaPolizaDAO garantiaPolizaDao;
       
    public AdminGarantiaPolizaBean() {
       
    }
    
    public List<GarantiaPolizaVO> buscarGarantiaPolizaPorPolizaContrat(Long pccCodigo) throws ExcepcionDAO {
       List<GarantiaPolizaVO> garantiasVo  = new ArrayList<GarantiaPolizaVO>();
       List<SiiGarantiaPoliza> garantias = new ArrayList<SiiGarantiaPoliza>(); 
       garantias =  garantiaPolizaDao.buscarGarantiaPolizaPorPolizaContrat(pccCodigo);
       for (SiiGarantiaPoliza garantia : garantias) {
           garantiasVo.add(new GarantiaPolizaVO(garantia));
       }
       return garantiasVo;
    }
       
    public List<GarantiaPolizaVO> consultarGarantiasUltimaPolizaAprobadaXContrato(Long idContrato) throws ExcepcionDAO {
        List<GarantiaPolizaVO> listaGarantiaPolizaVo = null;
        List<SiiGarantiaPoliza> listaSiiGarantiaPoliza = garantiaPolizaDao.buscarGarantiasUltimaPolizaXContratoXEstado(idContrato, EnumEstadoPolizaContrato.APROBADO.getId());
        if(listaSiiGarantiaPoliza != null && listaSiiGarantiaPoliza.size() > 0){
            listaGarantiaPolizaVo = new ArrayList<>();
            for(SiiGarantiaPoliza siiGarantiaPoliza : listaSiiGarantiaPoliza){
                listaGarantiaPolizaVo.add(new GarantiaPolizaVO(siiGarantiaPoliza));
            }
        }
        return listaGarantiaPolizaVo;
    }
    
    public List<GarantiaPolizaVO> consultarGarantiasUltimaPolizaAprobadaXOtrosiContrato(Long idContrato) throws ExcepcionDAO {
        List<GarantiaPolizaVO> listaGarantiaPolizaVo = null;
        List<SiiGarantiaPoliza> listaSiiGarantiaPoliza = garantiaPolizaDao.buscarGarantiasUltimaPolizaXOtrosiContratoXEstado(idContrato, EnumEstadoPolizaContrato.APROBADO.getId());
        if(listaSiiGarantiaPoliza != null && listaSiiGarantiaPoliza.size() > 0){
            listaGarantiaPolizaVo = new ArrayList<>();
            for(SiiGarantiaPoliza siiGarantiaPoliza : listaSiiGarantiaPoliza){
                listaGarantiaPolizaVo.add(new GarantiaPolizaVO(siiGarantiaPoliza));
            }
        }
        return listaGarantiaPolizaVo;
    }
}
