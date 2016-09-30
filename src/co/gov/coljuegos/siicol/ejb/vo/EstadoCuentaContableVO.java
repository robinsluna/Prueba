package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCuentaContable;
public class EstadoCuentaContableVO  implements Cloneable 
{
    private Long eccCodigo; 
    private String eccNombre;
    
    
    public EstadoCuentaContableVO() { }
    
    
    public EstadoCuentaContableVO(SiiEstadoCuentaContable siiEstadoCuentaContable){
        this.eccCodigo = siiEstadoCuentaContable.getEccCodigo();
        this.eccNombre = siiEstadoCuentaContable.getEccNombre();
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public EstadoCuentaContableVO clone () 
    {
        EstadoCuentaContableVO estadoCuentaContableVo = new EstadoCuentaContableVO();
        estadoCuentaContableVo.setEccCodigo(eccCodigo);
        estadoCuentaContableVo.setEccNombre(eccNombre);
        
        return (estadoCuentaContableVo);
    }
    
    

    public void setEccCodigo(Long eccCodigo) {
        this.eccCodigo = eccCodigo;
    }

    public Long getEccCodigo() {
        return eccCodigo;
    }


    public void setEccNombre(String eccNombre) {
        this.eccNombre = eccNombre;
    }

    public String getEccNombre() {
        return eccNombre;
    }
}
