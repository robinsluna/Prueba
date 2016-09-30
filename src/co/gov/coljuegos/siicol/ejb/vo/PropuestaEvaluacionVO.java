/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaEvaluacion;


/**
 * Value Object para la Evaluaci&oacute;n de la Propuesta.
 * @author Camilo Miranda
 */
public class PropuestaEvaluacionVO implements Comparable<PropuestaEvaluacionVO>
{
    /** Calificaci&oacute;n de la Propuesta */
    private Integer pevCalificacion;
    /** C&oacute;digo de la Propuesta */
    private Long pevCodigo;
    private String pevCumpleEvFin;
    private String pevCumpleEvJur;
    private String pevCumpleEvTec;
    /** IVA */
    private Long pevIva;
    /** Valor */
    private Long pevValor;
    /** Evaluaci&oacute;n */
    private EvaluacionJurTecFinVO evaluacionJurTecFin;
    /** Propuesta Recibida */
    private PropuestaRecibVO propuestaRecib;
    
    
    /**
     * Constructor.
     */
    public PropuestaEvaluacionVO() { }
    
    
    /**
     * Constructor.
     * @param siiPropuestaEvaluacion - Entity
     */
    public PropuestaEvaluacionVO (SiiPropuestaEvaluacion siiPropuestaEvaluacion) 
    {
        this.pevCalificacion = siiPropuestaEvaluacion.getPevCalificacion();
        this.pevCodigo = siiPropuestaEvaluacion.getPevCodigo();
        this.pevCumpleEvFin = siiPropuestaEvaluacion.getPevCumpleEvFin();
        this.pevCumpleEvJur = siiPropuestaEvaluacion.getPevCumpleEvJur();
        this.pevCumpleEvTec = siiPropuestaEvaluacion.getPevCumpleEvTec();
        this.pevIva = siiPropuestaEvaluacion.getPevIva();
        this.pevValor = siiPropuestaEvaluacion.getPevValor();
        
        if (siiPropuestaEvaluacion.getSiiEvaluacionJurTecFin()!=null) {
            this.evaluacionJurTecFin = new EvaluacionJurTecFinVO(siiPropuestaEvaluacion.getSiiEvaluacionJurTecFin());
        }
        
        if (siiPropuestaEvaluacion.getSiiPropuestaRecib()!=null) {
            this.propuestaRecib = new PropuestaRecibVO(siiPropuestaEvaluacion.getSiiPropuestaRecib());
        }
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(PropuestaEvaluacionVO peVo) {
        if (peVo!=null) {
            Integer pevCalificacion2 = peVo.getPevCalificacion();
            
            if (this.pevCalificacion!=null && pevCalificacion2!=null) {
                return ( this.pevCalificacion.compareTo(pevCalificacion2) );
            }
        }
        return -2;
    }
    
    
    
    
    
    public void setPevCalificacion(Integer pevCalificacion) {
        this.pevCalificacion = pevCalificacion;
    }

    public Integer getPevCalificacion() {
        return pevCalificacion;
    }

    public void setPevCodigo(Long pevCodigo) {
        this.pevCodigo = pevCodigo;
    }

    public Long getPevCodigo() {
        return pevCodigo;
    }

    public void setPevCumpleEvFin(String pevCumpleEvFin) {
        this.pevCumpleEvFin = pevCumpleEvFin;
    }

    public String getPevCumpleEvFin() {
        return pevCumpleEvFin;
    }

    public void setPevCumpleEvJur(String pevCumpleEvJur) {
        this.pevCumpleEvJur = pevCumpleEvJur;
    }

    public String getPevCumpleEvJur() {
        return pevCumpleEvJur;
    }

    public void setPevCumpleEvTec(String pevCumpleEvTec) {
        this.pevCumpleEvTec = pevCumpleEvTec;
    }

    public String getPevCumpleEvTec() {
        return pevCumpleEvTec;
    }

    public void setPevIva(Long pevIva) {
        this.pevIva = pevIva;
    }

    public Long getPevIva() {
        return pevIva;
    }

    public void setPevValor(Long pevValor) {
        this.pevValor = pevValor;
    }

    public Long getPevValor() {
        return pevValor;
    }

    public void setEvaluacionJurTecFin(EvaluacionJurTecFinVO evaluacionJurTecFin) {
        this.evaluacionJurTecFin = evaluacionJurTecFin;
    }

    public EvaluacionJurTecFinVO getEvaluacionJurTecFin() {
        return evaluacionJurTecFin;
    }

    public void setPropuestaRecib(PropuestaRecibVO propuestaRecib) {
        this.propuestaRecib = propuestaRecib;
    }

    public PropuestaRecibVO getPropuestaRecib() {
        return propuestaRecib;
    }
    
    
    
    ///////////////////////
    // Metodos Delegados //
    ///////////////////////
    
    /**
     * Obtiene el Nombre del Proponente asociado a la Propuesta de Evaluaci&oacute;n.
     * @return propuestaRecib.nombreProponente
     */
    public String getNombreProponente () {
        return ( this.propuestaRecib!=null ? this.propuestaRecib.getNombreProponente() : null );
    }
    
    
    /**
     * Obtiene el E-mail del Proponente asociado a la Propuesta de Evaluaci&oacute;n.
     * @return propuestaRecib.emailProponente
     */
    public String getEmailProponente () {
        return ( this.propuestaRecib!=null ? this.propuestaRecib.getEmailProponente() : null );
    }
    
    
    
    /**
     * Obtiene la frase correspondiente al resultado de la Evaluaci&oacute;n especificada.
     * @param evaluacion
     * @return CUMPLE / NO CUMPLE.
     */
    private String getResultadoEvaluacion (String evaluacion) 
    {
        String resultado = null;
        
        if (EnumDecision.SI.getId().equals(evaluacion)) 
            resultado = "CUMPLE";
        else if (EnumDecision.NO.getId().equals(evaluacion))
            resultado = "NO CUMPLE";
        
        return (resultado);
    }
    
    
    
    /**
     * Obtiene la frase que representa el resultado de la Evaluaci&oacute;n Financiera.
     * @return resultado(pevCumpleEvFin)
     */
    public String getResultadoEvFinanciera () 
    {
        return ( this.getResultadoEvaluacion(this.pevCumpleEvFin) );
    }
    
    
    /**
     * Obtiene la frase que representa el resultado de la Evaluaci&oacute;n Jur&iacute;dica.
     * @return resultado(pevCumpleEvFin)
     */
    public String getResultadoEvJuridica () 
    {
        return ( this.getResultadoEvaluacion(this.pevCumpleEvJur) );
    }
    
    
    
    /**
     * Obtiene la frase que representa el resultado de la Evaluaci&oacute;n T&eacute;cnica.
     * @return resultado(pevCumpleEvFin)
     */
    public String getResultadoEvTecnica () 
    {
        return ( this.getResultadoEvaluacion(this.pevCumpleEvTec) );
    }
    
}
