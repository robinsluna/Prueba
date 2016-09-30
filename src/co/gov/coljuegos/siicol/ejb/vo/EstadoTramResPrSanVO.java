package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResPrSan;

import java.util.List;


/**
 * Value Object para el Estado de Tr&aacute;mite de Resoluci&oacute;n de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
public class EstadoTramResPrSanVO implements Comparable 
{
    private Long etrCodigo;
    private String etrNombre;
    
    private List<TramiteResolProcSanVO> tramiteResolProcSanList;
    
    
    
    /**
     * Constructor.
     */
    public EstadoTramResPrSanVO() { }
    
    
    /**
     * Constructor.
     */
    public EstadoTramResPrSanVO(SiiEstadoTramResPrSan siiEstadoTramResPrSan) 
    {
        if (siiEstadoTramResPrSan!=null) {
            this.etrCodigo = siiEstadoTramResPrSan.getEtrCodigo();
            this.etrNombre = siiEstadoTramResPrSan.getEtrNombre();
        }
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof EstadoTramResPrSanVO) {
            EstadoTramResPrSanVO estado = (EstadoTramResPrSanVO) o;
            if (this.etrCodigo!=null && estado!=null && estado.etrCodigo!=null) {
                // comparar los estados por medio de la numeracion de los codigos de los mismos.
                resultado = this.etrCodigo.compareTo(estado.etrCodigo);
            }
        }
        
        return (resultado);
    }
    

    public void setEtrCodigo(Long etrCodigo) {
        this.etrCodigo = etrCodigo;
    }

    public Long getEtrCodigo() {
        return etrCodigo;
    }

    public void setEtrNombre(String etrNombre) {
        this.etrNombre = etrNombre;
    }

    public String getEtrNombre() {
        return etrNombre;
    }

    public void setTramiteResolProcSanList(List<TramiteResolProcSanVO> tramiteResolProcSanList) {
        this.tramiteResolProcSanList = tramiteResolProcSanList;
    }

    public List<TramiteResolProcSanVO> getTramiteResolProcSanList() {
        return tramiteResolProcSanList;
    }
}
