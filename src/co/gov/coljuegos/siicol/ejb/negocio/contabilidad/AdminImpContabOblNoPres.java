package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CuentaContTipoDocContVO;
import co.gov.coljuegos.siicol.ejb.vo.CuentasContablesVO;
import co.gov.coljuegos.siicol.ejb.vo.ImpContabOblNoPresVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminImpContabOblNoPres {
    public ImpContabOblNoPresVO insertarSiiImpContabOblNoPres(ImpContabOblNoPresVO impContabOblNoPresVo) throws ExcepcionDAO;
    public List<ImpContabOblNoPresVO> buscarImputaContableNoPresPorIdObligacion(Long idObligacionNoPres) throws ExcepcionDAO;
    //public void borrarImpContabOblNoPresPorCodigoObligacion(Long idCodigoObligacionNp) throws ExcepcionDAO;
    public CuentasContablesVO buscarCuentaContablePorDocumentoYConcepto(String tipoDoc,String concepto ) throws ExcepcionDAO ;
    public List<CuentaContTipoDocContVO> buscarCuentaContablePorDocumentoYFuente(String tipoDoc,String fuente ) throws ExcepcionDAO ;
    public List<ImpContabOblNoPresVO> buscarImputaContableNoPresPorIdObligacionYIdImputacionContable(Long idObligacionNoPres, Long idImputacion) throws ExcepcionDAO;
    public List<ImpContabOblNoPresVO> buscarImputaContableNoPresPorIdObligacionYIdImputacionContable(Long idObligacionNoPres, Long idImputacion, String ionEstado) throws ExcepcionDAO;
    public ImpContabOblNoPresVO actualizarSiiImpContabOblNoPres(ImpContabOblNoPresVO impContabOblNoPresVO) throws ExcepcionDAO;
    public ImpContabOblNoPresVO buscarImpContabOblNoPresPorCodigo(Long idImpContabOblNoPres) throws ExcepcionDAO;
    public List<ImpContabOblNoPresVO> buscarImpContabOblNoPresPorIdImputacionContable (Long imcCodigo) throws ExcepcionDAO;
}
