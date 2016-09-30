package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.FirmaDocumentoVO;

import java.util.List;

import javax.ejb.Local;

@Local


public interface AdminFirmaDocumento {
    public FirmaDocumentoVO insertarFirmaDocumento(FirmaDocumentoVO firmaDocumentoVO) throws ExcepcionDAO;
    public FirmaDocumentoVO buscarFirmaDocumentoPorId(FirmaDocumentoVO firmaDocumentoVO) throws ExcepcionDAO;
    public FirmaDocumentoVO actualizarFirmaDocumentos(FirmaDocumentoVO firmaDocumentoVO) throws ExcepcionDAO;
    public void eliminarFirmaDocumento(FirmaDocumentoVO firmaDocumentoVO) throws ExcepcionDAO;
    public List<FirmaDocumentoVO> buscarFirmaDocumentoPorIdTipoDocumento(Long idTipoDocumento) throws ExcepcionDAO;
    public List<FirmaDocumentoVO> buscarFirmaDocumentoPorIdDocumentoTipoDocumento(Long idDocumento, Long idTipoDocumento) throws ExcepcionDAO;
    public List<FirmaDocumentoVO> buscarJqlFirmaDocumentoPorIdDocumentoTipoDocumento(Long idDocumento, Long idTipoDocumento) throws ExcepcionDAO;
    public List<FirmaDocumentoVO> buscarFirmaDocumentoPorIdTipoDocumentoEntidad(Long idDocumento, Long idTipoDocumento) throws ExcepcionDAO;
}
