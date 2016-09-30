/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;

import java.util.List;


public class TipoApuestaVO implements Cloneable, Comparable {
     
    private String tapApuesta;
    private Long tapCodigo;
    private String tapCodigoApuesta;
    private String tapDerechosExpl;
    private String tapDerExplFormula;
    private String tapGastosAdm;
    private String tapGastAdmFormula;
    private Integer tapMinSillas;
    private String tapNombre;
    private List<InventarioVO> inventarioVoList;
    private ClaseJuegoVO claseJuego;
    private TipoJuegoVO tipoJuego;
    
    
    
    public TipoApuestaVO(SiiTipoApuesta siiTipoApuesta){
        this.tapApuesta = siiTipoApuesta.getTapApuesta();
        this.tapCodigo = siiTipoApuesta.getTapCodigo();
        this.tapCodigoApuesta = siiTipoApuesta.getTapCodigoApuesta();
        this.tapDerExplFormula = siiTipoApuesta.getTapDerExplFormula();
        this.tapDerechosExpl = siiTipoApuesta.getTapDerechosExpl();
        this.tapGastAdmFormula = siiTipoApuesta.getTapGastAdmFormula();
        this.tapGastosAdm = siiTipoApuesta.getTapGastosAdm();
        this.tapMinSillas = siiTipoApuesta.getTapMinSillas();
        this.tapNombre = siiTipoApuesta.getTapNombre();
        if(siiTipoApuesta.getSiiTipoJuego()!= null){
           this.tipoJuego = new TipoJuegoVO(siiTipoApuesta.getSiiTipoJuego());
        }
        if(siiTipoApuesta.getSiiClaseJuego()!= null){
            this.claseJuego = new ClaseJuegoVO (siiTipoApuesta.getSiiClaseJuego());
        }
         
    }
    
    public TipoApuestaVO() {
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public TipoApuestaVO clone () 
    {
        TipoApuestaVO resultado = new TipoApuestaVO();
        
        resultado.tapApuesta = this.tapApuesta;
        resultado.tapCodigo = this.tapCodigo;
        resultado.tapCodigoApuesta = this.tapCodigoApuesta;
        resultado.tapDerechosExpl = this.tapDerechosExpl;
        resultado.tapDerExplFormula = this.tapDerExplFormula;
        resultado.tapGastosAdm = this.tapGastosAdm;
        resultado.tapGastAdmFormula = this.tapGastAdmFormula;
        resultado.tapMinSillas = this.tapMinSillas;
        resultado.tapNombre = this.tapNombre;
        
        if (this.claseJuego!=null)
            resultado.claseJuego = this.claseJuego.clone();
        
        if (this.tipoJuego!=null)
            resultado.tipoJuego = this.tipoJuego.clone();
        
        return (resultado);
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        
        if (o instanceof TipoApuestaVO) {
            TipoApuestaVO tapVo = (TipoApuestaVO) o;
            if (tapVo!=null && tapVo.getTapNombre()!=null && this.tapNombre!=null)
                resultado = this.tapNombre.compareTo(tapVo.getTapNombre());
        }
        
        return (resultado);
    }
    
    
    
    public void setTapApuesta(String tapApuesta) {
        this.tapApuesta = tapApuesta;
    }

    public String getTapApuesta() {
        return tapApuesta;
    }

    public void setTapCodigo(Long tapCodigo) {
        this.tapCodigo = tapCodigo;
    }

    public Long getTapCodigo() {
        return tapCodigo;
    }

    public void setTapCodigoApuesta(String tapCodigoApuesta) {
        this.tapCodigoApuesta = tapCodigoApuesta;
    }

    public String getTapCodigoApuesta() {
        return tapCodigoApuesta;
    }

    public void setTapDerechosExpl(String tapDerechosExpl) {
        this.tapDerechosExpl = tapDerechosExpl;
    }

    public String getTapDerechosExpl() {
        return tapDerechosExpl;
    }

    public void setTapDerExplFormula(String tapDerExplFormula) {
        this.tapDerExplFormula = tapDerExplFormula;
    }

    public String getTapDerExplFormula() {
        return tapDerExplFormula;
    }

    public void setTapGastosAdm(String tapGastosAdm) {
        this.tapGastosAdm = tapGastosAdm;
    }

    public String getTapGastosAdm() {
        return tapGastosAdm;
    }

    public void setTapGastAdmFormula(String tapGastAdmFormula) {
        this.tapGastAdmFormula = tapGastAdmFormula;
    }

    public String getTapGastAdmFormula() {
        return tapGastAdmFormula;
    }

    public void setTapMinSillas(Integer tapMinSillas) {
        this.tapMinSillas = tapMinSillas;
    }

    public Integer getTapMinSillas() {
        return tapMinSillas;
    }

    public void setTapNombre(String tapNombre) {
        this.tapNombre = tapNombre;
    }

    public String getTapNombre() {
        return tapNombre;
    }

    public void setInventarioVoList(List<InventarioVO> inventarioVoList) {
        this.inventarioVoList = inventarioVoList;
    }

    public List<InventarioVO> getInventarioVoList() {
        return inventarioVoList;
    }

    public void setClaseJuego(ClaseJuegoVO claseJuego) {
        this.claseJuego = claseJuego;
    }

    public ClaseJuegoVO getClaseJuego() {
        return claseJuego;
    }

    public void setTipoJuego(TipoJuegoVO tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public TipoJuegoVO getTipoJuego() {
        return tipoJuego;
    }
}
