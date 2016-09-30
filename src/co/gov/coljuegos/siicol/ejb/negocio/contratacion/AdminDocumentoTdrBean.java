package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AdendaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoTdrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminoReferenciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AdendaVO;
import co.gov.coljuegos.siicol.ejb.vo.AreaColjuegosVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroCdpVO;

import co.gov.coljuegos.siicol.ejb.vo.DocumentoTdrVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.RpDetRubroCdpVO;

import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminoReferenciaVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminDocumentoTdrBean implements AdminDocumentoTdr{
    @EJB 
    ConversionVOEntidad conversionVoEntidad; 
    @EJB 
    DocumentoTdrDAO documentoTdrDao;
    

    public AdminDocumentoTdrBean() {
    }
    
    public DocumentoTdrVO insertarSiiDocumentoTdr(DocumentoTdrVO documento)  throws ExcepcionDAO {
        SiiDocumentoTdr siiDocumento = documentoTdrDao.insertarSiiDocumentoTdr(conversionVoEntidad.convertir(documento));
               
        return new DocumentoTdrVO(siiDocumento);
    }
   
    public DocumentoTdrVO buscarPorCodigoDocumento(Long idCodigoDoc)  throws ExcepcionDAO {
        SiiDocumentoTdr miSiiDocumentoTdr = documentoTdrDao.buscarPorCodigoDocumento(idCodigoDoc);            
        return new DocumentoTdrVO(miSiiDocumentoTdr);
        
    }
    
    public List<DocumentoTdrVO> buscarDocumentosTdrPorCodigoTdr(long codigoTdr)  throws ExcepcionDAO {
        List<SiiDocumentoTdr> miLista = documentoTdrDao.buscarDocumentosTdrPorCodigoTdr(codigoTdr);
        List<DocumentoTdrVO> miListaVo = new ArrayList<DocumentoTdrVO>();
        for(SiiDocumentoTdr unSiiDoc :miLista ){
            DocumentoTdrVO midocVo = new DocumentoTdrVO(unSiiDoc);
            miListaVo.add(midocVo);
        }
        return miListaVo;        
    }
}
