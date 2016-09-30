package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.FirmaDocumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioDesigSupervVO;

import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminOficioDesigSuperv {
    //public OficioDesigSupervVO insertarOficioDesigSuperv (OficioDesigSupervVO oficioDesigSupervVo) throws ExcepcionDAO;
    public OficioDesigSupervVO insertarOficioDesigSuperv (OficioDesigSupervVO oficioDesigSupervVo, OficioDesigSupervVO actOficioDesigSupervVo, List<FirmaDocumentoVO> listaAgregarFirmaDocumentoVo, List<FirmaDocumentoVO> listaEliminarFirmaDocumentoVo) throws ExcepcionDAO;
    public List<OficioDesigSupervVO> buscarTodoOficioDesigSuperv () throws ExcepcionDAO;
    public OficioDesigSupervVO buscarOficioDesigSupervPorId (Long idOficioDesigSuperv) throws ExcepcionDAO;
    public OficioDesigSupervVO actualizarOficioDesigSuperv (OficioDesigSupervVO oficioDesigSupervVo, List<FirmaDocumentoVO> listaAgregarFirmaDocumentoVo, List<FirmaDocumentoVO> listaEliminarFirmaDocumentoVo) throws ExcepcionDAO;
    public List<OficioDesigSupervVO> buscarOficioDesigSupervPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO;
    public List<OficioDesigSupervVO> buscarUltimoOficioDesigSupervPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO;
    public List<OficioDesigSupervVO> buscarOficioDesigSupervPorIdProcesoContratacionEstado(Long idProcesoContratacion) throws ExcepcionDAO;
    public List<ProcesoContratacionVO> buscarProcesoContratacionOficioDesigSuperv() throws ExcepcionDAO;
}
