package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoTdr;
import co.gov.coljuegos.siicol.ejb.vo.AdendaVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroCdpVO;

import co.gov.coljuegos.siicol.ejb.vo.DocumentoTdrVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminoReferenciaVO;

import java.util.List;

public interface AdminDocumentoTdr {
   
    public DocumentoTdrVO insertarSiiDocumentoTdr(DocumentoTdrVO documento) throws ExcepcionDAO;
    public DocumentoTdrVO buscarPorCodigoDocumento(Long idCodigoDoc) throws ExcepcionDAO;
    public List<DocumentoTdrVO> buscarDocumentosTdrPorCodigoTdr(long codigoTdr)  throws ExcepcionDAO;
}
