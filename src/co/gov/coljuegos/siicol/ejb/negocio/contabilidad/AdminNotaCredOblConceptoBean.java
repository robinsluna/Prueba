/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 11-06-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NotaCredOblConceptoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcepto;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConceptoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para la administraci&oacute;n de Notas de Cr&eacute;dito por Obligaci&oacute;n Concepto.
 * @author Camilo Miranda
 */
@Stateless
public class AdminNotaCredOblConceptoBean implements AdminNotaCredOblConcepto 
{
    @EJB
    private NotaCredOblConceptoDAO notaCredOblConceptoDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminNotaCredOblConceptoBean() { }
    
    
    
    @Override
    public NotaCredOblConceptoVO buscarNotaCredOblConceptoPorId(Long ncoCodigo) throws ExcepcionDAO {
        NotaCredOblConceptoVO resultado = null;
        SiiNotaCredOblConcepto siiNotaCredOblConcepto = notaCredOblConceptoDao.buscarPorCodigo(ncoCodigo);
        if (siiNotaCredOblConcepto!=null)
            resultado = new NotaCredOblConceptoVO(siiNotaCredOblConcepto);
        
        return (resultado);
    }
    
    
    @Override
    public NotaCredOblConceptoVO insertarNotaCredOblConcepto(NotaCredOblConceptoVO notaCredOblConceptoVo) throws ExcepcionDAO {
        NotaCredOblConceptoVO resultado = null;
        SiiNotaCredOblConcepto siiNotaCredOblConcepto = notaCredOblConceptoDao.insertar(conversionVoEntidad.convertir(notaCredOblConceptoVo));
        if (siiNotaCredOblConcepto!=null)
            resultado = new NotaCredOblConceptoVO(siiNotaCredOblConcepto);
        
        return (resultado);
    }
    
    
    @Override
    public NotaCredOblConceptoVO actualizarNotaCredOblConcepto(NotaCredOblConceptoVO notaCredOblConceptoVo) throws ExcepcionDAO {
        NotaCredOblConceptoVO resultado = null;
        SiiNotaCredOblConcepto siiNotaCredOblConcepto = notaCredOblConceptoDao.actualizar(conversionVoEntidad.convertir(notaCredOblConceptoVo));
        if (siiNotaCredOblConcepto!=null)
            resultado = new NotaCredOblConceptoVO(siiNotaCredOblConcepto);
        
        return (resultado);
    }
    
    
    @Override
    public void borrarNotaCredOblConcepto(Long ncoCodigo) throws ExcepcionDAO {
        notaCredOblConceptoDao.eliminar(ncoCodigo);
    }
    
    
    @Override
    public List<NotaCredOblConceptoVO> buscarTodaNotaCredOblConcepto() throws ExcepcionDAO {
        List<NotaCredOblConceptoVO> resultado = null;
        List<SiiNotaCredOblConcepto> lista = notaCredOblConceptoDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<NotaCredOblConceptoVO>();
            for (SiiNotaCredOblConcepto siiNotaCredOblConcepto: lista) {
                if (siiNotaCredOblConcepto!=null)
                    resultado.add(new NotaCredOblConceptoVO(siiNotaCredOblConcepto));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<NotaCredOblConceptoVO> buscarNotaCredOblConceptoPorIdNotaCredito (Long ncrCodigo) throws ExcepcionDAO {
        List<NotaCredOblConceptoVO> resultado = null;
        List<SiiNotaCredOblConcepto> lista = notaCredOblConceptoDao.buscarNotaCredOblConceptoPorIdNotaCredito(ncrCodigo);
        if (lista!=null) {
            resultado = new ArrayList<NotaCredOblConceptoVO>();
            for (SiiNotaCredOblConcepto siiNotaCredOblConcepto: lista) {
                if (siiNotaCredOblConcepto!=null)
                    resultado.add(new NotaCredOblConceptoVO(siiNotaCredOblConcepto));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<NotaCredOblConceptoVO> buscarNotaCredOblConceptoPorObligacionConcepto (Long ocoCodigo) throws ExcepcionDAO {
        List<NotaCredOblConceptoVO> resultado = null;
        List<SiiNotaCredOblConcepto> lista = notaCredOblConceptoDao.buscarNotaCredOblConceptoPorObligacionConcepto(ocoCodigo);
        if (lista!=null) {
            resultado = new ArrayList<NotaCredOblConceptoVO>();
            for (SiiNotaCredOblConcepto siiNotaCredOblConcepto: lista) {
                if (siiNotaCredOblConcepto!=null)
                    resultado.add(new NotaCredOblConceptoVO(siiNotaCredOblConcepto));
            }
        }
        
        return (resultado);
    }
}
