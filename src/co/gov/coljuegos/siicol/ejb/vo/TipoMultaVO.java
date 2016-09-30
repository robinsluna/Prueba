package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumClaseMulta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoMulta;

import java.math.BigDecimal;

import java.util.List;


/**
 * Value Object para los Tipos de Multa.
 * @author Camilo Miranda
 */
public class TipoMultaVO 
{
    private String tmuClase;
    private Long tmuCodigo;
    private String tmuDescripcion;
    private BigDecimal tmuFactor;
    private Integer tmuLimite;
    private Integer tmuMaximo;
    private String tmuNombre;
    
    private List<MotivoIncumplimientoVO> motivoIncumplimientoListVo;
    
    
    /**
     * Constructor.
     */
    public TipoMultaVO() { }
    
    
    /**
     * Constructor.
     * @param siiTipoMulta - Entity.
     */
    public TipoMultaVO (SiiTipoMulta siiTipoMulta) 
    {
        if (siiTipoMulta!=null) {
            this.tmuClase = siiTipoMulta.getTmuClase();
            this.tmuCodigo = siiTipoMulta.getTmuCodigo();
            this.tmuDescripcion = siiTipoMulta.getTmuDescripcion();
            this.tmuFactor = siiTipoMulta.getTmuFactor();
            this.tmuLimite = siiTipoMulta.getTmuLimite();
            this.tmuMaximo = siiTipoMulta.getTmuMaximo();
            this.tmuNombre = siiTipoMulta.getTmuNombre();
        }
    }


    public void setTmuClase(String tmuClase) {
        this.tmuClase = tmuClase;
    }

    public String getTmuClase() {
        return tmuClase;
    }

    public void setTmuCodigo(Long tmuCodigo) {
        this.tmuCodigo = tmuCodigo;
    }

    public Long getTmuCodigo() {
        return tmuCodigo;
    }

    public void setTmuDescripcion(String tmuDescripcion) {
        this.tmuDescripcion = tmuDescripcion;
    }

    public String getTmuDescripcion() {
        return tmuDescripcion;
    }

    public void setTmuFactor(BigDecimal tmuFactor) {
        this.tmuFactor = tmuFactor;
    }

    public BigDecimal getTmuFactor() {
        return tmuFactor;
    }

    public void setTmuLimite(Integer tmuLimite) {
        this.tmuLimite = tmuLimite;
    }

    public Integer getTmuLimite() {
        return tmuLimite;
    }

    public void setTmuMaximo(Integer tmuMaximo) {
        this.tmuMaximo = tmuMaximo;
    }

    public Integer getTmuMaximo() {
        return tmuMaximo;
    }

    public void setTmuNombre(String tmuNombre) {
        this.tmuNombre = tmuNombre;
    }

    public String getTmuNombre() {
        return tmuNombre;
    }

    public void setMotivoIncumplimientoListVo(List<MotivoIncumplimientoVO> motivoIncumplimientoListVo) {
        this.motivoIncumplimientoListVo = motivoIncumplimientoListVo;
    }

    public List<MotivoIncumplimientoVO> getMotivoIncumplimientoListVo() {
        return motivoIncumplimientoListVo;
    }
    
    
    
    /**
     * Obtiene el nombre de la Clase de Multa a partir del ID.
     * @return tmuClase=>nombre
     */
    public String getClaseMulta () 
    {
        String claseMulta = null;
        
        if (tmuClase!=null)
            claseMulta = EnumClaseMulta.getNombreById(tmuClase);
        
        return (claseMulta);
    }
}
