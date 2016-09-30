package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolSanCon;

import java.util.Date;


/**
 * Value Object para el manejo de Tr&aacute;mites de Resoluci&oacute;n Sancionatorios Contractuales.
 * @author Camilo Miranda
 */
public class TramiteResolSanConVO implements Comparable
{
    private Long trsCodigo;
    private Date trsFecha;
    
    private ResolucionIncumContrVO resolucionIncumContrVo;
    private EstadoResolucSanConVO estadoResolucSanConVo;
    
    
    
    /**
     * Constructor.
     */
    public TramiteResolSanConVO() { }
    
    
    /**
     * Constructor.
     */
    public TramiteResolSanConVO (SiiTramiteResolSanCon siiTramiteResolSanCon) 
    {
        if (siiTramiteResolSanCon!=null) {
            this.trsCodigo = siiTramiteResolSanCon.getTrsCodigo();
            this.trsFecha = siiTramiteResolSanCon.getTrsFecha();
            
            if (siiTramiteResolSanCon.getSiiResolucionIncumContr()!=null)
                this.resolucionIncumContrVo = new ResolucionIncumContrVO(siiTramiteResolSanCon.getSiiResolucionIncumContr());
            
            if (siiTramiteResolSanCon.getSiiEstadoResolucSanCon()!=null)
                this.estadoResolucSanConVo = new EstadoResolucSanConVO(siiTramiteResolSanCon.getSiiEstadoResolucSanCon());
        }
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof TramiteResolSanConVO) {
            TramiteResolSanConVO trsVo = (TramiteResolSanConVO) o;
            if (trsVo!=null && trsVo.getEstadoResolucSanConVo()!=null && this.estadoResolucSanConVo!=null) {
                // comparar los estados de los dos tramites de resolucion a comparar
                resultado = this.estadoResolucSanConVo.compareTo(trsVo.getEstadoResolucSanConVo());
            }
        }
        return (resultado);
    }
    
    
    
    public void setTrsCodigo(Long trsCodigo) {
        this.trsCodigo = trsCodigo;
    }

    public Long getTrsCodigo() {
        return trsCodigo;
    }

    public void setTrsFecha(Date trsFecha) {
        this.trsFecha = trsFecha;
    }

    public Date getTrsFecha() {
        return trsFecha;
    }

    public void setResolucionIncumContrVo(ResolucionIncumContrVO resolucionIncumContrVo) {
        this.resolucionIncumContrVo = resolucionIncumContrVo;
    }

    public ResolucionIncumContrVO getResolucionIncumContrVo() {
        return resolucionIncumContrVo;
    }

    public void setEstadoResolucSanConVo(EstadoResolucSanConVO estadoResolucSanConVo) {
        this.estadoResolucSanConVo = estadoResolucSanConVo;
    }

    public EstadoResolucSanConVO getEstadoResolucSanConVo() {
        return estadoResolucSanConVo;
    }
}
