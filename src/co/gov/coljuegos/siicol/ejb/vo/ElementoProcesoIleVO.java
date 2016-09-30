package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoProcesoIle;

import java.math.BigDecimal;


/**
 * Value Object para el manejo de Elementos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
public class ElementoProcesoIleVO 
{
    private String eprActivo;
    private Long eprCodigo;
    private Integer eprNumElementos;
    private BigDecimal eprValorSancion;
    
    private UsuarioVO usuarioConecVo;
    private TipoInstrumentoVO tipoInstrumentoVo;
    private ClaseJuegoVO claseJuegoVo;
    private ProcesoSancIlegalidadVO procesoSancIlegalidadVo;
    
    
    
    /**
     * Constructor.
     */
    public ElementoProcesoIleVO() { }
    
    
    
    /**
     * Constructor.
     * @param siiElementoProcesoIle - Entity.
     */
    public ElementoProcesoIleVO (SiiElementoProcesoIle siiElementoProcesoIle) 
    {
        if (siiElementoProcesoIle!=null) {
            this.eprActivo = siiElementoProcesoIle.getEprActivo();
            this.eprCodigo = siiElementoProcesoIle.getEprCodigo();
            this.eprNumElementos = siiElementoProcesoIle.getEprNumElementos();
            this.eprValorSancion = siiElementoProcesoIle.getEprValorSancion();
            
            if (siiElementoProcesoIle.getSiiClaseJuego()!=null)
                this.claseJuegoVo = new ClaseJuegoVO(siiElementoProcesoIle.getSiiClaseJuego());
            
            if (siiElementoProcesoIle.getSiiProcesoSancIlegalidad()!=null)
                this.procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO(siiElementoProcesoIle.getSiiProcesoSancIlegalidad());
            
            if (siiElementoProcesoIle.getSiiTipoInstrumento()!=null)
                this.tipoInstrumentoVo = new TipoInstrumentoVO(siiElementoProcesoIle.getSiiTipoInstrumento());
            
            if (siiElementoProcesoIle.getSiiUsuarioConec()!=null)
                this.usuarioConecVo = new UsuarioVO(siiElementoProcesoIle.getSiiUsuarioConec());
        }
    }
    
    
    
    public void setEprActivo(String eprActivo) {
        this.eprActivo = eprActivo;
    }

    public String getEprActivo() {
        return eprActivo;
    }

    public void setEprCodigo(Long eprCodigo) {
        this.eprCodigo = eprCodigo;
    }

    public Long getEprCodigo() {
        return eprCodigo;
    }

    public void setEprNumElementos(Integer eprNumElementos) {
        this.eprNumElementos = eprNumElementos;
    }

    public Integer getEprNumElementos() {
        return eprNumElementos;
    }

    public void setEprValorSancion(BigDecimal eprValorSancion) {
        this.eprValorSancion = eprValorSancion;
    }

    public BigDecimal getEprValorSancion() {
        return eprValorSancion;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setTipoInstrumentoVo(TipoInstrumentoVO tipoInstrumentoVo) {
        this.tipoInstrumentoVo = tipoInstrumentoVo;
    }

    public TipoInstrumentoVO getTipoInstrumentoVo() {
        return tipoInstrumentoVo;
    }

    public void setClaseJuegoVo(ClaseJuegoVO claseJuegoVo) {
        this.claseJuegoVo = claseJuegoVo;
    }

    public ClaseJuegoVO getClaseJuegoVo() {
        return claseJuegoVo;
    }

    public void setProcesoSancIlegalidadVo(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) {
        this.procesoSancIlegalidadVo = procesoSancIlegalidadVo;
    }

    public ProcesoSancIlegalidadVO getProcesoSancIlegalidadVo() {
        return procesoSancIlegalidadVo;
    }
}
