package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucSanCon;

import java.util.List;


/**
 * Value Object para el manejo de Estados de Resoluci&oacute;n Sanci&oacute;n Contractual.
 * @author Camilo Miranda
 */
public class EstadoResolucSanConVO implements Comparable
{
    private Long ersCodigo;
    private String ersNombre;
    
    private List<TramiteResolSanConVO> tramiteResolSanConList;
    
    
    /**
     * Constructor.
     */
    public EstadoResolucSanConVO() { }
    
    
    /**
     * Constructor.
     */
    public EstadoResolucSanConVO (SiiEstadoResolucSanCon siiEstadoResolucSanCon) 
    {
        if (siiEstadoResolucSanCon!=null) {
            this.ersCodigo = siiEstadoResolucSanCon.getErsCodigo();
            this.ersNombre = siiEstadoResolucSanCon.getErsNombre();
        }
    }


    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof EstadoResolucSanConVO) {
            EstadoResolucSanConVO estado = (EstadoResolucSanConVO) o;
            if (this.ersCodigo!=null && estado!=null && estado.ersCodigo!=null) {
                // comparar los estados por medio de la numeracion de los codigos de los mismos.
                resultado = this.ersCodigo.compareTo(estado.ersCodigo);
            }
        }
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode () {
        return ( this.ersCodigo!=null ? this.ersCodigo.hashCode() : 0 );
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) {
        boolean igual = false;
        
        if (o instanceof EstadoResolucSanConVO) {
            EstadoResolucSanConVO ersVo = (EstadoResolucSanConVO) o;
            if (ersVo!=null) {
                igual =
                    ((ersVo.ersCodigo != null && ersVo.ersCodigo.equals(this.ersCodigo)) || (ersVo.ersCodigo == null && this.ersCodigo == null)) &&
                    ((ersVo.ersNombre != null && ersVo.ersNombre.equals(this.ersNombre)) || (ersVo.ersNombre == null && this.ersNombre == null));
            }
        }
        
        return (igual);
    }
    
    
    
    
    public void setErsCodigo(Long ersCodigo) {
        this.ersCodigo = ersCodigo;
    }

    public Long getErsCodigo() {
        return ersCodigo;
    }

    public void setErsNombre(String ersNombre) {
        this.ersNombre = ersNombre;
    }

    public String getErsNombre() {
        return ersNombre;
    }
    
    public void setTramiteResolSanConList(List<TramiteResolSanConVO> tramiteResolSanConList) {
        this.tramiteResolSanConList = tramiteResolSanConList;
    }

    public List<TramiteResolSanConVO> getTramiteResolSanConList() {
        return tramiteResolSanConList;
    }
}
