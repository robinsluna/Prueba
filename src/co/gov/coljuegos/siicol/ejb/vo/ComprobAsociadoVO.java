/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC & TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 13-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComprobAsociado;

import java.util.ArrayList;
import java.util.List;


/**
 * Value Object para los Comprobantes Asociados.
 * @author Camilo Miranda
 */
public class ComprobAsociadoVO {
    
    private String casCodigo;
    private String casNombre;
    private List<ConceptoGastoVO> conceptoGastoList;
    
    
    /**
     * Constructor.
     * @param siiComprobAsociado
     */
    public ComprobAsociadoVO(SiiComprobAsociado siiComprobAsociado) {
        this.casCodigo =  siiComprobAsociado.getCasCodigo();
        this.casNombre = siiComprobAsociado.getCasNombre();
    }
    
    public ComprobAsociadoVO() {
    }


    public void setCasCodigo(String casCodigo) {
        this.casCodigo = casCodigo;
    }

    public String getCasCodigo() {
        return casCodigo;
    }

    public void setCasNombre(String casNombre) {
        this.casNombre = casNombre;
    }

    public String getCasNombre() {
        return casNombre;
    }

    public void setConceptoGastoList(List<ConceptoGastoVO> conceptoGastoList) {
        this.conceptoGastoList = conceptoGastoList;
    }

    public List<ConceptoGastoVO> getConceptoGastoList() {
        return conceptoGastoList;
    }
    
    public boolean addConceptoGastoVO (ConceptoGastoVO conceptoGastoVO) 
    {
        boolean exitoso = false;
        
        if (conceptoGastoList==null)
            conceptoGastoList = new ArrayList<ConceptoGastoVO>();
        
        exitoso = conceptoGastoList.add(conceptoGastoVO);
        
        if (exitoso)
            conceptoGastoVO.setComprobAsociado(this);
        
        return (exitoso);
    }
    
    public boolean removePropuestaEvaluacionVO (ConceptoGastoVO conceptoGastoVO) 
    {
        boolean exitoso = false;
        exitoso = this.conceptoGastoList.remove(conceptoGastoVO);
        
        if (exitoso)
            conceptoGastoVO.setComprobAsociado(null);
        
        return (exitoso);
    }
    
}
