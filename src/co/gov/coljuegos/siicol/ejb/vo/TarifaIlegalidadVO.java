package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTarifaIlegalidad;


/**
 * Value Object para el manejo de Tarifas de Ilegalidad.
 * @author Camilo Miranda
 */
public class TarifaIlegalidadVO 
{
    private Long tleCodigo;
    private Integer tleHabitDesde;
    private Long tleHabitHasta;
    private Integer tleMinSillas;
    private Integer tleSmmlvUni;
    private String tleUnidad;
    
    private ClaseJuegoVO claseJuegoVo;
    private TipoInstrumentoVO tipoInstrumentoVo;
    
    
    
    /**
     * Constructor.
     */
    public TarifaIlegalidadVO() { }
    
    
    /**
     * Constructor.
     * @param siiTarifaIlegalidad - Entity.
     */
    public TarifaIlegalidadVO (SiiTarifaIlegalidad siiTarifaIlegalidad) 
    {
        if (siiTarifaIlegalidad!=null) {
            this.tleCodigo = siiTarifaIlegalidad.getTleCodigo();
            this.tleHabitDesde = siiTarifaIlegalidad.getTleHabitDesde();
            this.tleHabitHasta = siiTarifaIlegalidad.getTleHabitHasta();
            this.tleMinSillas = siiTarifaIlegalidad.getTleMinSillas();
            this.tleSmmlvUni = siiTarifaIlegalidad.getTleSmmlvUni();
            this.tleUnidad = siiTarifaIlegalidad.getTleUnidad();
            
            if (siiTarifaIlegalidad.getSiiClaseJuego()!=null)
                this.claseJuegoVo = new ClaseJuegoVO(siiTarifaIlegalidad.getSiiClaseJuego());
            
            if (siiTarifaIlegalidad.getSiiTipoInstrumento()!=null)
                this.tipoInstrumentoVo = new TipoInstrumentoVO(siiTarifaIlegalidad.getSiiTipoInstrumento());
        }
    }

    
    
    public void setTleCodigo(Long tleCodigo) {
        this.tleCodigo = tleCodigo;
    }

    public Long getTleCodigo() {
        return tleCodigo;
    }

    public void setTleHabitDesde(Integer tleHabitDesde) {
        this.tleHabitDesde = tleHabitDesde;
    }

    public Integer getTleHabitDesde() {
        return tleHabitDesde;
    }

    public void setTleHabitHasta(Long tleHabitHasta) {
        this.tleHabitHasta = tleHabitHasta;
    }

    public Long getTleHabitHasta() {
        return tleHabitHasta;
    }

    public void setTleMinSillas(Integer tleMinSillas) {
        this.tleMinSillas = tleMinSillas;
    }

    public Integer getTleMinSillas() {
        return tleMinSillas;
    }

    public void setTleSmmlvUni(Integer tleSmmlvUni) {
        this.tleSmmlvUni = tleSmmlvUni;
    }

    public Integer getTleSmmlvUni() {
        return tleSmmlvUni;
    }

    public void setTleUnidad(String tleUnidad) {
        this.tleUnidad = tleUnidad;
    }

    public String getTleUnidad() {
        return tleUnidad;
    }

    public void setClaseJuegoVo(ClaseJuegoVO claseJuegoVo) {
        this.claseJuegoVo = claseJuegoVo;
    }

    public ClaseJuegoVO getClaseJuegoVo() {
        return claseJuegoVo;
    }

    public void setTipoInstrumentoVo(TipoInstrumentoVO tipoInstrumentoVo) {
        this.tipoInstrumentoVo = tipoInstrumentoVo;
    }

    public TipoInstrumentoVO getTipoInstrumentoVo() {
        return tipoInstrumentoVo;
    }
}
