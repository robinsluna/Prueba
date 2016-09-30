package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OblConcRpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionConceptoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOblConcRpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionConcepto;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.OblConcRpDetRubCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionConceptoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class AdminObligacionConceptoBean implements AdminObligacionConcepto {
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ObligacionConceptoDAO obligacionConceptoDAO;
    @EJB
    OblConcRpDetRubCdpDAO oblConcRpDetRubCdpDAO;
    
    
    
    /**
     * Constructor.
     */
    public AdminObligacionConceptoBean() {
        super();
    }
    
    
    
    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de los registros de conceptos RP Detalle Rubro, asociados al Concepto de la Obligación.
     * @param siiObligacionConcepto - Entidad Concepto Obligaci&oacute;n.
     * @param oblConcRpDetRubCdpList - Listado de OblConcRpDetRubCdpVO.
     * @throws ExcepcionDAO
     */
    private void persistirOblConcRpDetRubCdp (SiiObligacionConcepto siiObligacionConcepto, List<OblConcRpDetRubCdpVO> oblConcRpDetRubCdpList)
        throws ExcepcionDAO
    {
        if (oblConcRpDetRubCdpList!=null) {
             for (OblConcRpDetRubCdpVO oblConcRpDetRubCdpVO : oblConcRpDetRubCdpList) {
                SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp = conversionVoEntidad.convertir(oblConcRpDetRubCdpVO);
                if (siiOblConcRpDetRubCdp!=null) {
                    siiOblConcRpDetRubCdp.setSiiObligacionConcepto(siiObligacionConcepto);
                    if (siiOblConcRpDetRubCdp.getOcrCodigo()==null) {
                        // OPERACION INSERTAR
                        oblConcRpDetRubCdpDAO.insertar(siiOblConcRpDetRubCdp);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        oblConcRpDetRubCdpDAO.actualizar(siiOblConcRpDetRubCdp);
                    }
                }
                
             }
        }
    }
    
    
    /**
     * Realiza la b&uacute;squeda de un Concepto de Obligaci&oacute;n por medio del ID.
     * @param idObligacionConcepto
     * @return Value Object del Concepto
     * @throws ExcepcionDAO
     */
    public ObligacionConceptoVO buscarPorCodigoObligacionConcepto(Long idObligacionConcepto) throws ExcepcionDAO {
        SiiObligacionConcepto siiObligacionConcepto = obligacionConceptoDAO.buscarPorCodigo(idObligacionConcepto);
        return ( new ObligacionConceptoVO(siiObligacionConcepto) );
    }

    
    /**
     * Realiza la inserci&oacute;n de un registro de Concepto de Obligaci&oacute;n.
     * @param obligacionConceptoVO
     * @return Objeto modificado.
     * @throws ExcepcionDAO
     */
    public ObligacionConceptoVO insertarObligacionConcepto(ObligacionConceptoVO obligacionConceptoVO) throws ExcepcionDAO {
        SiiObligacionConcepto siiObligacionConcepto = obligacionConceptoDAO.insertar(conversionVoEntidad.convertir(obligacionConceptoVO));
        return ( new ObligacionConceptoVO(siiObligacionConcepto) );
    }

    
    /**
     * Realiza la actualizaci&oacute;n del registro de Concepto de Obligaci&oacute;n.
     * @param obligacionConceptoVO
     * @return Objeto modificado.
     * @throws ExcepcionDAO
     */
    public ObligacionConceptoVO actualizarObligacionConcepto(ObligacionConceptoVO obligacionConceptoVO) throws ExcepcionDAO {
        SiiObligacionConcepto siiObligacionConcepto = obligacionConceptoDAO.actualizar(conversionVoEntidad.convertir(obligacionConceptoVO));
        return ( new ObligacionConceptoVO(siiObligacionConcepto) );
    }

    
    /**
     * Realiza la eliminaci&oacute;n del registro de Concepto de Obligaci&oacute;n.
     * @param idObligacionConcepto
     * @throws ExcepcionDAO
     */
    public void borrarObligacionConcepto(Long idObligacionConcepto) throws ExcepcionDAO {
        obligacionConceptoDAO.eliminar(idObligacionConcepto);
    }
    
    
    /**
     * Realiza la consulta de todos los Conceptos de Obligaci&oacute;n.
     * @return List of ObligacionConceptoVO
     * @throws ExcepcionDAO
     */
    public List<ObligacionConceptoVO> buscarTodaObligacionConcepto() throws ExcepcionDAO {
        List<ObligacionConceptoVO>  listaObligacionConceptoVo = new ArrayList<ObligacionConceptoVO>();
        List<SiiObligacionConcepto> lista = obligacionConceptoDAO.buscarTodo();
        
        if (lista!=null) {
            for (SiiObligacionConcepto siiObligacionConcepto : lista){
                listaObligacionConceptoVo.add(new ObligacionConceptoVO(siiObligacionConcepto));
            }
        }
        
        return (listaObligacionConceptoVo);
    }

    
    /**
     * Realiza la consulta de los Conceptos de Obligaci&oacute;n asociados al c&oacute;digo de la Obligaci&oacute;n.
     * @param oblCodigo
     * @return List of ObligacionConceptoVO
     * @throws ExcepcionDAO
     */
    public List<ObligacionConceptoVO> buscarPorCodigoObligacion(Long oblCodigo) throws ExcepcionDAO {
        List<ObligacionConceptoVO>  listaObligacionConceptoVo = new ArrayList<ObligacionConceptoVO>();
        List<SiiObligacionConcepto> lista = obligacionConceptoDAO.buscarPorCodigoObligacion(oblCodigo);
        
        if (lista!=null) {
            for (SiiObligacionConcepto siiObligacionConcepto : lista){
                listaObligacionConceptoVo.add(new ObligacionConceptoVO(siiObligacionConcepto));
            }
        }
        
        return (listaObligacionConceptoVo);
    }
    
    
    /* (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminObligacionConcepto#buscarPorCodigoObligacionRP(java.lang.Long, java.lang.Long)
     */
    public List<ObligacionConceptoVO> buscarPorCodigoObligacionRP(Long oblCodigo, Long rpCodigo) throws ExcepcionDAO 
    {
        List<ObligacionConceptoVO>  listaObligacionConceptoVo = new ArrayList<ObligacionConceptoVO>();
        List<SiiObligacionConcepto> lista = obligacionConceptoDAO.buscarPorCodigoObligacionRP(oblCodigo, rpCodigo);
        
        if (lista!=null) {
            for (SiiObligacionConcepto siiObligacionConcepto : lista){
                listaObligacionConceptoVo.add(new ObligacionConceptoVO(siiObligacionConcepto));
            }
        }
        
        return (listaObligacionConceptoVo);
    }
    
    
    /* (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminObligacionConcepto#buscarPorObligacionRpFuenteFinancContab(java.lang.Long, java.lang.Long, java.lang.String)
     */
    public List<ObligacionConceptoVO> buscarPorObligacionRpFuenteFinancContab(Long oblCodigo, Long rpCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        List<ObligacionConceptoVO>  listaObligacionConceptoVo = new ArrayList<ObligacionConceptoVO>();
        List<SiiObligacionConcepto> lista = obligacionConceptoDAO.buscarPorObligacionRpFuenteFinancContab(oblCodigo, rpCodigo, ffcCodigo);
        
        if (lista!=null) {
            for (SiiObligacionConcepto siiObligacionConcepto : lista){
                listaObligacionConceptoVo.add(new ObligacionConceptoVO(siiObligacionConcepto));
            }
        }
        
        return (listaObligacionConceptoVo);
    }
    
    
    /* (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminObligacionConcepto#buscarPorObligacionRpFuenteFinancContab(java.lang.Long, java.lang.Long, java.lang.String)
     */
    public List<ObligacionConceptoVO> buscarPorRpFuenteFinancContab(Long rpCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        List<ObligacionConceptoVO>  listaObligacionConceptoVo = new ArrayList<ObligacionConceptoVO>();
        List<SiiObligacionConcepto> lista = obligacionConceptoDAO.buscarPorRpFuenteFinancContab(rpCodigo, ffcCodigo);
        
        if (lista!=null) {
            for (SiiObligacionConcepto siiObligacionConcepto : lista){
                listaObligacionConceptoVo.add(new ObligacionConceptoVO(siiObligacionConcepto));
            }
        }
        
        return (listaObligacionConceptoVo);
    }
}
