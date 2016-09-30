package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ArchivoFisicoVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroCdpVO;

import co.gov.coljuegos.siicol.ejb.vo.DocumentoTdrVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminoReferenciaVO;

import java.io.File;

import java.util.List;

public interface AdminTerminoReferencia {
   
    public TerminoReferenciaVO insertarSiiTerminoReferencia(TerminoReferenciaVO terminoReferenciaVO,File archivoFinal,
                                                            ArchivoFisicoVO archivoFisico,DocumentoTdrVO documentoTdr) throws ExcepcionDAO;
    public TerminoReferenciaVO actualizarSiiTerminoReferencia(TerminoReferenciaVO terminoReferenciaVO) throws ExcepcionDAO;
    public void borrarTerminoReferencia(Long idCodigoTerminoReferencia) throws ExcepcionDAO;
    public List<TerminoReferenciaVO> buscarTodoSiiTerminoReferencia() throws ExcepcionDAO;
    TerminoReferenciaVO buscarTerminoReferencia (Integer idProcesoContratacion) throws ExcepcionDAO;
    public String buscarAreaColjuegosPorCodigoProcesoContratacion (Integer idProcesoContratacion) throws ExcepcionDAO;
}
