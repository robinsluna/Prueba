/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 17-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LibroAuxiliarDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.FiltrosLibroAuxiliarVO;
import co.gov.coljuegos.siicol.ejb.vo.LibroAuxiliarVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminLibroAuxiliarBean implements AdminLibroAuxiliar 
{
    @EJB
    private LibroAuxiliarDAO libroAuxiliarDao;
    
    @EJB
    private DocumentoContableDAO  documentoContableDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminLibroAuxiliarBean() {
        super();
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.LibroAuxiliarDAO#generarLibroAuxiliarPorComprobante(java.lang.Long)
     */
    public List<LibroAuxiliarVO> generarLibroAuxiliarPorComprobante(Long idDocumentoContable) throws ExcepcionDAO {
        return (libroAuxiliarDao.generarLibroAuxiliarPorComprobante(idDocumentoContable));
    }
    
    
    public List<DocumentoContableVO> buscarTodoNumerocomprobanteDocCon(String tdcCodigo  ) throws ExcepcionDAO {
        List<SiiDocumentoContable> listaSiiDocumentoContable = new ArrayList <SiiDocumentoContable>();
        List<DocumentoContableVO> listaDocumentoContableVo;
        listaSiiDocumentoContable= documentoContableDao.buscarTodoNumerocomprobanteDocCon(tdcCodigo );
        
        listaDocumentoContableVo= new ArrayList<DocumentoContableVO>();
        for (SiiDocumentoContable siiDocumentoContable: listaSiiDocumentoContable) {
            listaDocumentoContableVo.add(new DocumentoContableVO(siiDocumentoContable));
        }
        
        return listaDocumentoContableVo;
        
        
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.LibroAuxiliarDAO#generarLibroAuxiliarPorFiltros(co.gov.coljuegos.siicol.ejb.vo.FiltrosLibroAuxiliarVO)
     */
    public List<LibroAuxiliarVO> generarLibroAuxiliarPorFiltros(FiltrosLibroAuxiliarVO filtros) throws ExcepcionDAO {
        return (libroAuxiliarDao.generarLibroAuxiliarPorFiltros(filtros));
    }
}
