/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 11-06-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NotaCredOblConcDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcDetRub;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConcDetRubVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


 /**
  * Bean para la administraci&oacute;n de Notas de Cr&eacute;dito por Obligaci&oacute;n/Detalle Rubro CDP.
  * @author Camilo Miranda
  */
@Stateless
public class AdminNotaCredOblConcDetRubBean implements AdminNotaCredOblConcDetRub 
{
    @EJB
    private NotaCredOblConcDetRubDAO notaCredOblConcDetRubDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminNotaCredOblConcDetRubBean() { }

    @Override
    public NotaCredOblConcDetRubVO buscarNotaCredOblConcDetRubPorId(Long ndrCodigo) throws ExcepcionDAO {
        NotaCredOblConcDetRubVO resultado = null;
        SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub = notaCredOblConcDetRubDao.buscarPorCodigo(ndrCodigo);
        if (siiNotaCredOblConcDetRub!=null)
            resultado = new NotaCredOblConcDetRubVO(siiNotaCredOblConcDetRub);
        
        return (resultado);
    }
    
    
    @Override
    public NotaCredOblConcDetRubVO insertarNotaCredOblConcDetRub(NotaCredOblConcDetRubVO notaCredOblConcDetRubVo) throws ExcepcionDAO {
        NotaCredOblConcDetRubVO resultado = null;
        SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub = notaCredOblConcDetRubDao.insertar(conversionVoEntidad.convertir(notaCredOblConcDetRubVo));
        if (siiNotaCredOblConcDetRub!=null)
            resultado = new NotaCredOblConcDetRubVO(siiNotaCredOblConcDetRub);
        
        return (resultado);
    }
    
    
    @Override
    public NotaCredOblConcDetRubVO actualizarNotaCredOblConcDetRub(NotaCredOblConcDetRubVO notaCredOblConcDetRubVo) throws ExcepcionDAO {
        NotaCredOblConcDetRubVO resultado = null;
        SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub = notaCredOblConcDetRubDao.actualizar(conversionVoEntidad.convertir(notaCredOblConcDetRubVo));
        if (siiNotaCredOblConcDetRub!=null)
            resultado = new NotaCredOblConcDetRubVO(siiNotaCredOblConcDetRub);
        
        return (resultado);
    }
    
    
    @Override
    public void borrarNotaCredOblConcDetRub(Long ndrCodigo) throws ExcepcionDAO {
        notaCredOblConcDetRubDao.eliminar(ndrCodigo);
    }
    
    
    @Override
    public List<NotaCredOblConcDetRubVO> buscarTodaNotaCredOblConcDetRub() throws ExcepcionDAO {
        List<NotaCredOblConcDetRubVO> resultado = null;
        List<SiiNotaCredOblConcDetRub> lista = notaCredOblConcDetRubDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<NotaCredOblConcDetRubVO>();
            
            for (SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub: lista) {
                if (siiNotaCredOblConcDetRub!=null)
                    resultado.add(new NotaCredOblConcDetRubVO(siiNotaCredOblConcDetRub));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<NotaCredOblConcDetRubVO> buscarNotaCredOblConcDetRubPorIdNotaCredito (Long ncrCodigo) throws ExcepcionDAO {
        List<NotaCredOblConcDetRubVO> resultado = null;
        List<SiiNotaCredOblConcDetRub> lista = notaCredOblConcDetRubDao.buscarNotaCredOblConcDetRubPorIdNotaCredito(ncrCodigo);
        if (lista!=null) {
            resultado = new ArrayList<NotaCredOblConcDetRubVO>();
            
            for (SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub: lista) {
                if (siiNotaCredOblConcDetRub!=null)
                    resultado.add(new NotaCredOblConcDetRubVO(siiNotaCredOblConcDetRub));
            }
        }
        return (resultado);
    }
}
