package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosProcesales;


/**
 * Value Object para el manejo de T&eacute;rminos Procesales.
 * @author Camilo Miranda
 */
public class TerminosProcesalesVO 
{
    private Long tprCodigo;
    private Integer tprDias;
    private String tprProceso;
    private String tprTipoDia;
    
    private EstadoProcesoSancVO estadoProcesoSancVo;
    private EstadoProcSanIlegVO estadoProcSanIlegVo;
    
    
    /**
     * Constructor.
     */
    public TerminosProcesalesVO() { }

    
    /**
     * Constructor.
     * @param siiTerminosProcesales - Entity.
     */
    public TerminosProcesalesVO (SiiTerminosProcesales siiTerminosProcesales) 
    {
        if (siiTerminosProcesales!=null) {
            this.tprCodigo = siiTerminosProcesales.getTprCodigo();
            this.tprDias = siiTerminosProcesales.getTprDias();
            this.tprProceso = siiTerminosProcesales.getTprProceso();
            this.tprTipoDia = siiTerminosProcesales.getTprTipoDia();
            
            if (siiTerminosProcesales.getSiiEstadoProcesoSanc()!=null)
                this.estadoProcesoSancVo = new EstadoProcesoSancVO(siiTerminosProcesales.getSiiEstadoProcesoSanc());
            
            if (siiTerminosProcesales.getSiiEstadoProcSanIleg()!=null)
                this.estadoProcSanIlegVo = new EstadoProcSanIlegVO(siiTerminosProcesales.getSiiEstadoProcSanIleg());
        }
    }
    
    
    
    public void setTprCodigo(Long tprCodigo) {
        this.tprCodigo = tprCodigo;
    }

    public Long getTprCodigo() {
        return tprCodigo;
    }

    public void setTprDias(Integer tprDias) {
        this.tprDias = tprDias;
    }

    public Integer getTprDias() {
        return tprDias;
    }

    public void setTprProceso(String tprProceso) {
        this.tprProceso = tprProceso;
    }

    public String getTprProceso() {
        return tprProceso;
    }

    public void setTprTipoDia(String tprTipoDia) {
        this.tprTipoDia = tprTipoDia;
    }

    public String getTprTipoDia() {
        return tprTipoDia;
    }

    public void setEstadoProcesoSancVo(EstadoProcesoSancVO estadoProcesoSancVo) {
        this.estadoProcesoSancVo = estadoProcesoSancVo;
    }

    public EstadoProcesoSancVO getEstadoProcesoSancVo() {
        return estadoProcesoSancVo;
    }

    public void setEstadoProcSanIlegVo(EstadoProcSanIlegVO estadoProcSanIlegVo) {
        this.estadoProcSanIlegVo = estadoProcSanIlegVo;
    }

    public EstadoProcSanIlegVO getEstadoProcSanIlegVo() {
        return estadoProcSanIlegVo;
    }
}
