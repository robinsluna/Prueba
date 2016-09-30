/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 29-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;

import java.util.Date;


public class InventarioVO implements Cloneable {
     
    private Long invCodigo;
    private String invEstado;
    private Date invFechaFinLiq;
    private Date invFechaFinOfi;
    private Date invFechaIniLiq;
    private Date invFechaIniOfi;
    private Integer invSillas;
    private String invPg;
    
    private TipoApuestaVO tipoApuestaVo;
    private InstrumentoVO instrumentoVo;
    private NovedadVO novedadVo;
    private EstablecimientoVO establecimientoVo;
    
    
    public InventarioVO(SiiInventario siiInventario) {
        if (siiInventario!=null) {
            this.invCodigo = siiInventario.getInvCodigo();
            this.invEstado = siiInventario.getInvEstado();
            this.invFechaFinLiq = siiInventario.getInvFechaFinLiq();
            this.invFechaFinOfi = siiInventario.getInvFechaFinOfi();
            this.invFechaIniLiq = siiInventario.getInvFechaIniLiq();
            this.invFechaIniOfi = siiInventario.getInvFechaIniOfi();
            this.invSillas = siiInventario.getInvSillas();
            this.invPg = siiInventario.getInvPg();
            
            if(siiInventario.getSiiTipoApuesta()!= null){
                this.tipoApuestaVo = new TipoApuestaVO (siiInventario.getSiiTipoApuesta());
            }
            if(siiInventario.getSiiInstrumento()!= null){
                this.instrumentoVo = new InstrumentoVO(siiInventario.getSiiInstrumento());
            }
            if(siiInventario.getSiiNovedad() != null ){
                this.novedadVo = new NovedadVO (siiInventario.getSiiNovedad());
            }
            if(siiInventario.getSiiEstablecimiento() != null){
                this.establecimientoVo = new EstablecimientoVO (siiInventario.getSiiEstablecimiento());
            }
        }
    }
    
    
    public InventarioVO() {
    }
    
    
    
     /*
      * (non-Javadoc)
      * @see java.lang.Object#clone()
      */
    @Override
    public InventarioVO clone () 
    {
        InventarioVO resultado = new InventarioVO();
        
        resultado.invCodigo = this.invCodigo;
        resultado.invEstado = this.invEstado;
        resultado.invFechaFinLiq = this.invFechaFinLiq;
        resultado.invFechaFinOfi = this.invFechaFinOfi;
        resultado.invFechaIniLiq = this.invFechaIniLiq;
        resultado.invFechaIniOfi = this.invFechaIniOfi;
        resultado.invSillas = this.invSillas;
        resultado.invPg = this.invPg;
        
        if (this.tipoApuestaVo!=null)
            resultado.tipoApuestaVo = this.tipoApuestaVo.clone();
        
        if (this.instrumentoVo!=null)
            resultado.instrumentoVo = this.instrumentoVo;
        
        if (this.novedadVo!=null)
            resultado.novedadVo = this.novedadVo;
        
        if (this.establecimientoVo!=null)
            resultado.establecimientoVo = this.establecimientoVo;
        
        
        return (resultado);
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        boolean igual = false;
        if (o instanceof InventarioVO) {
            InventarioVO invVo = (InventarioVO) o;
            
            if (invVo != null) {
                igual =
                    ((invVo.invCodigo != null && invVo.invCodigo.equals(this.invCodigo)) || (invVo.invCodigo == null && this.invCodigo == null)) &&
                    ((invVo.invEstado != null && invVo.invEstado.equals(this.invEstado)) || (invVo.invEstado == null && this.invEstado == null)) &&
                    ((invVo.invFechaFinLiq != null && invVo.invFechaFinLiq.equals(this.invFechaFinLiq)) || (invVo.invFechaFinLiq == null && this.invFechaFinLiq == null)) &&
                    ((invVo.invFechaFinOfi != null && invVo.invFechaFinOfi.equals(this.invFechaFinOfi)) || (invVo.invFechaFinOfi == null && this.invFechaFinOfi == null)) &&
                    ((invVo.invFechaIniLiq != null && invVo.invFechaIniLiq.equals(this.invFechaIniLiq)) || (invVo.invFechaIniLiq == null && this.invFechaIniLiq == null)) &&
                    ((invVo.invFechaIniOfi != null && invVo.invFechaIniOfi.equals(this.invFechaIniOfi)) || (invVo.invFechaIniOfi == null && this.invFechaIniOfi == null)) &&
                    ((invVo.invSillas != null && invVo.invSillas.equals(this.invSillas)) || (invVo.invSillas == null && this.invSillas == null)) &&
                    ((invVo.invPg != null && invVo.invPg.equals(this.invPg)) || (invVo.invPg == null && this.invPg == null)) &&
                    
                    ((invVo.tipoApuestaVo!=null && invVo.tipoApuestaVo.getTapCodigo()!=null && this.tipoApuestaVo!=null && this.tipoApuestaVo.getTapCodigo()!=null && invVo.tipoApuestaVo.getTapCodigo().equals(this.tipoApuestaVo.getTapCodigo())) || (invVo.tipoApuestaVo == null && this.tipoApuestaVo == null)) &&
                    ((invVo.instrumentoVo!=null && invVo.instrumentoVo.getInsCodigo()!=null && this.instrumentoVo!=null && this.instrumentoVo.getInsCodigo()!=null && invVo.instrumentoVo.getInsCodigo().equals(this.instrumentoVo.getInsCodigo())) || (invVo.instrumentoVo == null && this.instrumentoVo == null)) &&
                    ((invVo.novedadVo!=null && invVo.novedadVo.getNovCodigo()!=null && this.novedadVo!=null && this.novedadVo.getNovCodigo()!=null && invVo.novedadVo.getNovCodigo().equals(this.novedadVo.getNovCodigo())) || (invVo.novedadVo == null && this.novedadVo == null)) &&
                    ((invVo.establecimientoVo!=null && invVo.establecimientoVo.getEstCodigo()!=null && this.establecimientoVo!=null && this.establecimientoVo.getEstCodigo()!=null && invVo.establecimientoVo.getEstCodigo().equals(this.establecimientoVo.getEstCodigo())) || (invVo.establecimientoVo == null && this.establecimientoVo == null));
            }
        }
        return (igual);
    }
    
    
    
    
    /**
     * Obtiene el nombre asociado al identificador del Estado del Inventario.
     * @return
     */
    public String getEstado() {
        return ( invEstado!=null ? EnumEstadoInventario.getNombreById(invEstado) : null );
    }
    

    public void setInvCodigo(Long invCodigo) {
        this.invCodigo = invCodigo;
    }

    public Long getInvCodigo() {
        return invCodigo;
    }

    public void setInvEstado(String invEstado) {
        this.invEstado = invEstado;
    }

    public String getInvEstado() {
        return invEstado;
    }

    public void setInvFechaFinLiq(Date invFechaFinLiq) {
        this.invFechaFinLiq = invFechaFinLiq;
    }

    public Date getInvFechaFinLiq() {
        return invFechaFinLiq;
    }
    
    
    public void setInvFechaFinOfi(Date invFechaFinOfi) {
        this.invFechaFinOfi = invFechaFinOfi;
    }

    public Date getInvFechaFinOfi() {
        return invFechaFinOfi;
    }

    public void setInvFechaIniLiq(Date invFechaIniLiq) {
        this.invFechaIniLiq = invFechaIniLiq;
    }

    public Date getInvFechaIniLiq() {
        return invFechaIniLiq;
    }

    public void setInvFechaIniOfi(Date invFechaIniOfi) {
        this.invFechaIniOfi = invFechaIniOfi;
    }

    public Date getInvFechaIniOfi() {
        return invFechaIniOfi;
    }

    public void setInvSillas(Integer invSillas) {
        this.invSillas = invSillas;
    }

    public Integer getInvSillas() {
        return invSillas;
    }

    public void setTipoApuestaVo(TipoApuestaVO tipoApuestaVo) {
        this.tipoApuestaVo = tipoApuestaVo;
    }

    public TipoApuestaVO getTipoApuestaVo() {
        return tipoApuestaVo;
    }

    public void setInstrumentoVo(InstrumentoVO instrumentoVo) {
        this.instrumentoVo = instrumentoVo;
    }

    public InstrumentoVO getInstrumentoVo() {
        return instrumentoVo;
    }

    public void setNovedadVo(NovedadVO novedadVo) {
        this.novedadVo = novedadVo;
    }

    public NovedadVO getNovedadVo() {
        return novedadVo;
    }

    public void setEstablecimientoVo(EstablecimientoVO establecimientoVo) {
        this.establecimientoVo = establecimientoVo;
    }

    public EstablecimientoVO getEstablecimientoVo() {
        return establecimientoVo;
    }

    public void setInvPg(String invPg) {
        this.invPg = invPg;
    }

    public String getInvPg() {
        return invPg;
    }
}
