package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImpContabOblNoPresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImpContabOblNoPres;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CuentaContTipoDocContVO;
import co.gov.coljuegos.siicol.ejb.vo.CuentasContablesVO;
import co.gov.coljuegos.siicol.ejb.vo.ImpContabOblNoPresVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminImpContabOblNoPresBean implements AdminImpContabOblNoPres{
    @EJB 
    ConversionVOEntidad conversionVoEntidad; 
    @EJB 
    ImpContabOblNoPresDAO impContabOblNoPresDao;
    
   
    public AdminImpContabOblNoPresBean() {
        
    }
    
    public ImpContabOblNoPresVO insertarSiiImpContabOblNoPres(ImpContabOblNoPresVO impContabOblNoPresVo) throws ExcepcionDAO {
        SiiImpContabOblNoPres siiImpContabOblNoPres = impContabOblNoPresDao.insertarSiiImpContabOblNoPres(conversionVoEntidad.convertir(impContabOblNoPresVo));                 
        return new ImpContabOblNoPresVO(siiImpContabOblNoPres);
    }
    public List<ImpContabOblNoPresVO> buscarImputaContableNoPresPorIdObligacion(Long idObligacionNoPres) throws ExcepcionDAO {
        List<ImpContabOblNoPresVO> resultado = null;
        List<SiiImpContabOblNoPres> lista = impContabOblNoPresDao.buscarImputaContableNoPresPorIdObligacion(idObligacionNoPres);
        if (lista!=null) {
            resultado = new ArrayList<ImpContabOblNoPresVO>();
            for (SiiImpContabOblNoPres siiListImpNp: lista) {
                if (siiListImpNp!=null) {
                    resultado.add(new ImpContabOblNoPresVO(siiListImpNp));
                }
            }
        }
        return (resultado);
    }
    /*
    public void borrarImpContabOblNoPresPorCodigoObligacion(Long idCodigoObligacionNp) throws ExcepcionDAO {        
        impContabOblNoPresDao.borrarImpContabOblNoPresPorCodigoObligacion(idCodigoObligacionNp);
    }
    */
    public CuentasContablesVO buscarCuentaContablePorDocumentoYConcepto(String tipoDoc,String concepto ) throws ExcepcionDAO {
        return new CuentasContablesVO(impContabOblNoPresDao.buscarCuentaContablePorDocumentoYConcepto(tipoDoc, concepto));
    }
    
    public List<CuentaContTipoDocContVO> buscarCuentaContablePorDocumentoYFuente(String tipoDoc,String fuente ) throws ExcepcionDAO {
        List<CuentaContTipoDocContVO> listaCuentasContablesVo = new ArrayList<CuentaContTipoDocContVO>();
        List<SiiCuentaContTipoDocCont> listaSiiCuentasCon = impContabOblNoPresDao.buscarCuentaContablePorDocumentoYFuente(tipoDoc, fuente);
        if(listaSiiCuentasCon!= null && listaSiiCuentasCon.size()> 0){
            for(SiiCuentaContTipoDocCont unSiiCuentaC : listaSiiCuentasCon){
                listaCuentasContablesVo.add(new CuentaContTipoDocContVO(unSiiCuentaC));
            }
        }
        return listaCuentasContablesVo;
    }
    public List<ImpContabOblNoPresVO> buscarImputaContableNoPresPorIdObligacionYIdImputacionContable(Long idObligacionNoPres, Long idImputacion) throws ExcepcionDAO {
        List<ImpContabOblNoPresVO> resultado = new ArrayList<ImpContabOblNoPresVO>();
        List<SiiImpContabOblNoPres> listaSiiImpuNoPres = impContabOblNoPresDao.buscarImputaContableNoPresPorIdObligacionYIdImputacionContable(idObligacionNoPres, idImputacion);
        if(listaSiiImpuNoPres!= null && listaSiiImpuNoPres.size()> 0){
            for(SiiImpContabOblNoPres unVo : listaSiiImpuNoPres){
                resultado.add(new ImpContabOblNoPresVO(unVo) );
            }
        }
        return resultado;
    }
    
    public List<ImpContabOblNoPresVO> buscarImputaContableNoPresPorIdObligacionYIdImputacionContable(Long idObligacionNoPres, Long idImputacion, String ionEstado) throws ExcepcionDAO 
    {
        List<ImpContabOblNoPresVO> resultado = new ArrayList<ImpContabOblNoPresVO>();
        List<SiiImpContabOblNoPres> listaSiiImpuNoPres = impContabOblNoPresDao.buscarImputaContableNoPresPorIdObligacionYIdImputacionContable(idObligacionNoPres, idImputacion, ionEstado);
        if(listaSiiImpuNoPres!= null && listaSiiImpuNoPres.size()> 0){
            for(SiiImpContabOblNoPres siiImpContabOblNoPres : listaSiiImpuNoPres){
                if (siiImpContabOblNoPres!=null)
                    resultado.add(new ImpContabOblNoPresVO(siiImpContabOblNoPres) );
            }
        }
        
        return (resultado);
    }
    
    public ImpContabOblNoPresVO actualizarSiiImpContabOblNoPres(ImpContabOblNoPresVO impContabOblNoPresVO) throws ExcepcionDAO {
        SiiImpContabOblNoPres imputa =  impContabOblNoPresDao.actualizarSiiImpContabOblNoPres(conversionVoEntidad.convertir(impContabOblNoPresVO));
        return new ImpContabOblNoPresVO(imputa);
    }
    public ImpContabOblNoPresVO buscarImpContabOblNoPresPorCodigo(Long idImpContabOblNoPres) throws ExcepcionDAO{
        return new ImpContabOblNoPresVO(impContabOblNoPresDao.buscarImpContabOblNoPresPorCodigo(idImpContabOblNoPres));
        
    }
    
    
    public List<ImpContabOblNoPresVO> buscarImpContabOblNoPresPorIdImputacionContable (Long imcCodigo) throws ExcepcionDAO 
    {
        List<ImpContabOblNoPresVO> resultado = new ArrayList<ImpContabOblNoPresVO>();
        List<SiiImpContabOblNoPres> listaSiiImpuNoPres = impContabOblNoPresDao.buscarImpContabOblNoPresPorIdImputacionContable(imcCodigo);
        if(listaSiiImpuNoPres!= null && listaSiiImpuNoPres.size()> 0){
            for(SiiImpContabOblNoPres siiImpContabOblNoPres : listaSiiImpuNoPres){
                if (siiImpContabOblNoPres!=null)
                    resultado.add(new ImpContabOblNoPresVO(siiImpContabOblNoPres) );
            }
        }
        return resultado;
    }
}
