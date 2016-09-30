package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolProcSan;

import java.util.Date;


/**
 * Value Object para el Tr&aacute;mite de Resoluci&oacute;n de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
public class TramiteResolProcSanVO implements Comparable 
{
    private Long trpCodigo;
    private Date trpFecha;
    private String trpNumeracRadicado;
    private Date trpNumeracFecRad;
    
    private ResolucionProcSancVO resolucionProcSancVo;
    private EstadoTramResPrSanVO estadoTramResPrSanVo;
    
    
    /**
     * Constructor.
     */
    public TramiteResolProcSanVO() { }
    
    
    /**
     * Constructor.
     * @param siiTramiteResolProcSan - Entity.
     */
    public TramiteResolProcSanVO(SiiTramiteResolProcSan siiTramiteResolProcSan) 
    {
        if (siiTramiteResolProcSan!=null) {
            this.trpCodigo = siiTramiteResolProcSan.getTrpCodigo();
            this.trpFecha = siiTramiteResolProcSan.getTrpFecha();
            this.trpNumeracRadicado = siiTramiteResolProcSan.getTrpNumeracRadicado();
            this.trpNumeracFecRad = siiTramiteResolProcSan.getTrpNumeracFecRad();
            
            if (siiTramiteResolProcSan.getSiiResolucionProcSanc()!=null)
                this.resolucionProcSancVo = new ResolucionProcSancVO(siiTramiteResolProcSan.getSiiResolucionProcSanc());
            
            if (siiTramiteResolProcSan.getSiiEstadoTramResPrSan()!=null)
                this.estadoTramResPrSanVo = new EstadoTramResPrSanVO(siiTramiteResolProcSan.getSiiEstadoTramResPrSan());
        }
    }

    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof TramiteResolProcSanVO) {
            TramiteResolProcSanVO trpVo = (TramiteResolProcSanVO) o;
            if (trpVo!=null && trpVo.getEstadoTramResPrSanVo()!=null && this.estadoTramResPrSanVo!=null) {
                // comparar los estados de los dos tramites de resolucion a comparar
                resultado = this.estadoTramResPrSanVo.compareTo(trpVo.getEstadoTramResPrSanVo());
            }
        }
        return (resultado);
    }
    
    
    
    public void setTrpCodigo(Long trpCodigo) {
        this.trpCodigo = trpCodigo;
    }

    public Long getTrpCodigo() {
        return trpCodigo;
    }

    public void setTrpFecha(Date trpFecha) {
        this.trpFecha = trpFecha;
    }

    public Date getTrpFecha() {
        return trpFecha;
    }

    public void setResolucionProcSancVo(ResolucionProcSancVO resolucionProcSancVo) {
        this.resolucionProcSancVo = resolucionProcSancVo;
    }

    public ResolucionProcSancVO getResolucionProcSancVo() {
        return resolucionProcSancVo;
    }

    public void setEstadoTramResPrSanVo(EstadoTramResPrSanVO estadoTramResPrSanVo) {
        this.estadoTramResPrSanVo = estadoTramResPrSanVo;
    }

    public EstadoTramResPrSanVO getEstadoTramResPrSanVo() {
        return estadoTramResPrSanVo;
    }

    public void setTrpNumeracRadicado(String trpNumeracRadicado) {
        this.trpNumeracRadicado = trpNumeracRadicado;
    }

    public String getTrpNumeracRadicado() {
        return trpNumeracRadicado;
    }

    public void setTrpNumeracFecRad(Date trpNumeracFecRad) {
        this.trpNumeracFecRad = trpNumeracFecRad;
    }

    public Date getTrpNumeracFecRad() {
        return trpNumeracFecRad;
    }
}
