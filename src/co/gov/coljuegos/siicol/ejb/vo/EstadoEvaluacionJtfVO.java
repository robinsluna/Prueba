/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEvaluacionJtf;

import java.util.List;


/**
 * Value Object para el Estado de la Evaluaci&oacute;n.
 * @author Camilo Miranda
 */
public class EstadoEvaluacionJtfVO 
{
    /** C&oacute;digo */
    private Long eejCodigo;
    /** Nombre */
    private String eejNombre;
    /** Evaluaci&oacute;n */
    private List<EvaluacionJurTecFinVO> evaluacionJurTecFinList;
    
    
    
    /**
     * Constructor.
     */
    public EstadoEvaluacionJtfVO() { }
    
    
    /**
     * Constructor.
     * @param siiEstadoEvaluacionJtf - Entity
     */
    public EstadoEvaluacionJtfVO (SiiEstadoEvaluacionJtf siiEstadoEvaluacionJtf) 
    {
        this.eejCodigo = siiEstadoEvaluacionJtf.getEejCodigo();
        this.eejNombre = siiEstadoEvaluacionJtf.getEejNombre();
        
        /*
        if (siiEstadoEvaluacionJtf.getSiiEvaluacionJurTecFinList()!=null) {
            evaluacionJurTecFinList = new ArrayList<EvaluacionJurTecFinVO>();
            for (SiiEvaluacionJurTecFin evJutTecFin: siiEstadoEvaluacionJtf.getSiiEvaluacionJurTecFinList()) {
                this.addEvaluacionJurTecFin( new EvaluacionJurTecFinVO(evJutTecFin) );
            }
        }
        */
    }

    
    
    public void setEejCodigo(Long eejCodigo) {
        this.eejCodigo = eejCodigo;
    }

    public Long getEejCodigo() {
        return eejCodigo;
    }

    public void setEejNombre(String eejNombre) {
        this.eejNombre = eejNombre;
    }

    public String getEejNombre() {
        return eejNombre;
    }

    public void setEvaluacionJurTecFinList(List<EvaluacionJurTecFinVO> evaluacionJurTecFinList) {
        this.evaluacionJurTecFinList = evaluacionJurTecFinList;
    }

    public List<EvaluacionJurTecFinVO> getEvaluacionJurTecFinList() {
        return evaluacionJurTecFinList;
    }
    
    public boolean addEvaluacionJurTecFin (EvaluacionJurTecFinVO evaluacionJurTecFinVO) 
    {
        boolean exitoso = false;
        exitoso = getEvaluacionJurTecFinList().add(evaluacionJurTecFinVO);
        
        if (exitoso)
            evaluacionJurTecFinVO.setEstadoEvaluacionJtf(this);
        
        return (exitoso);
    }
    
    public boolean removeEvaluacionJurTecFin (EvaluacionJurTecFinVO evaluacionJurTecFinVO) 
    {
        boolean exitoso = false;
        exitoso = getEvaluacionJurTecFinList().remove(evaluacionJurTecFinVO);
        
        if (exitoso)
            evaluacionJurTecFinVO.setEstadoEvaluacionJtf(null);
        
        return (exitoso);
    }


    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) {
        if (o instanceof EstadoEvaluacionJtfVO) {
            EstadoEvaluacionJtfVO eejtf = (EstadoEvaluacionJtfVO)o;
            return (this.eejCodigo.equals(eejtf.eejCodigo) && this.eejNombre.equals(eejtf.eejNombre));
        }
        return false;
    }
}
