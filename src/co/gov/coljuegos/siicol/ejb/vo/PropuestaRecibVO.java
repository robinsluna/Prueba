/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 04-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaRecib;

import java.util.List;


/**
 * Value Object para Propuestas Recibidas.
 * @author Camilo Miranda
 */
public class PropuestaRecibVO 
{
    /** C&oacute;digo de la Propuesta Recibida*/
    private Long preCodigo;
    /** Proveedor */
    private ProveedorVO proveedor;
    /** Recepci&oacute;n de Propuestas */
    private RecepcionPropuestasVO recepcionPropuestas;
    /** Listado de Propuestas de Evaluaci&oacute;n */
    private List<PropuestaEvaluacionVO> propuestaEvaluacionList;
    
    
    /**
     * Constructor.
     */
    public PropuestaRecibVO () { }
    
    
    /**
     * Constructor.
     * @param siiPropuestaRecib - Entity
     */
    public PropuestaRecibVO (SiiPropuestaRecib siiPropuestaRecib) 
    {
        this.preCodigo = siiPropuestaRecib.getPreCodigo();
        
        if (siiPropuestaRecib.getSiiProveedor()!=null)
            this.proveedor = new ProveedorVO(siiPropuestaRecib.getSiiProveedor());
        
        if (siiPropuestaRecib.getSiiRecepcionPropuestas()!=null)
            this.recepcionPropuestas = new RecepcionPropuestasVO(siiPropuestaRecib.getSiiRecepcionPropuestas());
        
        
        /*
        // adicionar las propuestas de evaluacion
        if (siiPropuestaRecib.getSiiPropuestaEvaluacionList1()!=null) {
            this.propuestaEvaluacionList = new ArrayList<PropuestaEvaluacionVO>();
            
            for (SiiPropuestaEvaluacion pev: siiPropuestaRecib.getSiiPropuestaEvaluacionList1()) {
                addPropuestaEvaluacionVO(new PropuestaEvaluacionVO(pev));
            }
        }
        */
    }

    
    
    public void setPreCodigo(Long preCodigo) {
        this.preCodigo = preCodigo;
    }

    public Long getPreCodigo() {
        return preCodigo;
    }

    public void setProveedor(ProveedorVO proveedor) {
        this.proveedor = proveedor;
    }

    public ProveedorVO getProveedor() {
        return proveedor;
    }

    public void setRecepcionPropuestas(RecepcionPropuestasVO recepcionPropuestas) {
        this.recepcionPropuestas = recepcionPropuestas;
    }

    public RecepcionPropuestasVO getRecepcionPropuestas() {
        return recepcionPropuestas;
    }


    public void setPropuestaEvaluacionList(List<PropuestaEvaluacionVO> propuestaEvaluacionList) {
        this.propuestaEvaluacionList = propuestaEvaluacionList;
    }

    public List<PropuestaEvaluacionVO> getPropuestaEvaluacionList() {
        return propuestaEvaluacionList;
    }
    


    ///////////////////////
    // Metodos Delegados //
    ///////////////////////
    private PersonaVO getPersonaProveedorVo () {
        return ( proveedor!=null?proveedor.getPersonaVo():null );
    }
    
    public String getTipoDocProponente () 
    {
        String tipoDoc = null;
        
        if (getPersonaProveedorVo()!=null && getPersonaProveedorVo().getTipoIdentificacionVo()!=null) {
            tipoDoc = getPersonaProveedorVo().getTipoIdentificacionVo().getTidNombreCorto();
        }
        
        return (tipoDoc);
    }
    
    public String getNumeroDocProponente () {
        return ( getPersonaProveedorVo()!=null?getPersonaProveedorVo().getPerNumIdentificacion():null );
    }
    
    public String getNombreProponente () {
        String nombre = null;
        PersonaVO persona = getPersonaProveedorVo();
        if (persona!=null) {
            nombre = persona.getNombreCompleto();
        }
        return (nombre);
    }
    
    public String getDireccionComercialProponente () {
        return ( getPersonaProveedorVo()!=null?getPersonaProveedorVo().getPerDireccion():null );
    }
    
    public String getTelefonoFijoProponente () {
        return ( getPersonaProveedorVo()!=null?getPersonaProveedorVo().getPerTelefono():null );
    }
    
    public String getCelularProponente () {
        return ( getPersonaProveedorVo()!=null?getPersonaProveedorVo().getPerCelular():null );
    }
    
    public String getEmailProponente () {
        return ( getPersonaProveedorVo()!=null?getPersonaProveedorVo().getPerEmail():null );
    }
    
    public String getFaxProponente () {
        return ( getPersonaProveedorVo()!=null?getPersonaProveedorVo().getPerFax():null );
    }
    
    
    public boolean addPropuestaEvaluacionVO (PropuestaEvaluacionVO propuestaEvaluacionVO) 
    {
        boolean exitoso = false;
        
        exitoso = getPropuestaEvaluacionList().add(propuestaEvaluacionVO);
        if (exitoso)
            propuestaEvaluacionVO.setPropuestaRecib(this);
        return (exitoso);
    }
    
    public boolean removePropuestaEvaluacionVO (PropuestaEvaluacionVO propuestaEvaluacionVO) 
    {
        boolean exitoso = false;
        
        exitoso = getPropuestaEvaluacionList().remove(propuestaEvaluacionVO);
        if (exitoso)
            propuestaEvaluacionVO.setPropuestaRecib(null);
        return (exitoso);
    }
    
}
