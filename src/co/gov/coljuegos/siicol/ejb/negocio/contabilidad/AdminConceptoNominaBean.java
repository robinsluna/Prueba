/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 26-03-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoNominaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoNomina;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoNominaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Conceptos de N&oacute;mina.
 * @author Camilo Miranda
 */
@Stateless
public class AdminConceptoNominaBean implements AdminConceptoNomina 
{
    @EJB
    private ConceptoNominaDAO conceptoNominaDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminConceptoNominaBean() {
        super();
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.contabilidad.AdminConceptoNomina#buscarConceptoNominaPorCodigo(java.lang.String)
     */
    @Override
    public ConceptoNominaVO buscarConceptoNominaPorCodigo(String cnoCodigo) throws ExcepcionDAO 
    {
        ConceptoNominaVO resultado = null;
        SiiConceptoNomina siiConceptoNomina =  conceptoNominaDao.buscarPorCodigo(cnoCodigo);
        if (siiConceptoNomina!=null)
            resultado = new ConceptoNominaVO(siiConceptoNomina);
        
        return ( resultado );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.contabilidad.AdminConceptoNomina#insertarConceptoNomina(co.gov.coljuegos.siicol.ejb.vo.ConceptoNominaVO)
     */
    @Override
    public ConceptoNominaVO insertarConceptoNomina(ConceptoNominaVO conceptoNominaVo) throws ExcepcionDAO 
    {
        ConceptoNominaVO resultado = null;
        SiiConceptoNomina siiConceptoNomina =  conceptoNominaDao.insertar(conversionVoEntidad.convertir(conceptoNominaVo));
        if (siiConceptoNomina!=null)
            resultado = new ConceptoNominaVO(siiConceptoNomina);
        
        return ( resultado );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.contabilidad.AdminConceptoNomina#actualizarConceptoNomina(co.gov.coljuegos.siicol.ejb.vo.ConceptoNominaVO)
     */
    @Override
    public ConceptoNominaVO actualizarConceptoNomina(ConceptoNominaVO conceptoNominaVo) throws ExcepcionDAO 
    {
        ConceptoNominaVO resultado = null;
        SiiConceptoNomina siiConceptoNomina =  conceptoNominaDao.actualizar(conversionVoEntidad.convertir(conceptoNominaVo));
        if (siiConceptoNomina!=null)
            resultado = new ConceptoNominaVO(siiConceptoNomina);
        
        return ( resultado );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.contabilidad.AdminConceptoNomina#eliminarConceptoNomina()
     */
    @Override
    public void eliminarConceptoNomina(String cnoCodigo) throws ExcepcionDAO 
    {
        conceptoNominaDao.eliminar(cnoCodigo);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.contabilidad.AdminConceptoNomina#buscarTodoConceptoNomina()
     */
    @Override
    public List<ConceptoNominaVO> buscarTodoConceptoNomina() throws ExcepcionDAO 
    {
        List<ConceptoNominaVO> resultado = null;
        List<SiiConceptoNomina> lista = conceptoNominaDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<ConceptoNominaVO>();
            
            for (SiiConceptoNomina siiConceptoNomina: lista) {
                if (siiConceptoNomina!=null)
                    resultado.add(new ConceptoNominaVO(siiConceptoNomina));
            }
        }
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.contabilidad.AdminConceptoNomina#buscarConceptoNominaActivos()
     */
    @Override
    public List<ConceptoNominaVO> buscarConceptoNominaActivos() throws ExcepcionDAO 
    {
        List<ConceptoNominaVO> resultado = null;
        List<SiiConceptoNomina> lista = conceptoNominaDao.buscarConceptoNominaActivos();
        if (lista!=null) {
            resultado = new ArrayList<ConceptoNominaVO>();
            
            for (SiiConceptoNomina siiConceptoNomina: lista) {
                if (siiConceptoNomina!=null)
                    resultado.add(new ConceptoNominaVO(siiConceptoNomina));
            }
        }
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.contabilidad.AdminConceptoNomina#isConceptoNominaAsociadoDocumentoContable(java.lang.String)
     */
    public boolean isConceptoNominaAsociadoDocumentoContable(String cnoCodigo) throws ExcepcionDAO {
        return ( conceptoNominaDao.isConceptoNominaAsociadoDocumentoContable(cnoCodigo) );
    }
}
