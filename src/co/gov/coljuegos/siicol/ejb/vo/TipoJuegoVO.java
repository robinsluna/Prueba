/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Proceso recaudo y transferencia
 * AUTOR	: Monica Pabon
 * FECHA	: 28-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoJuego;

import java.util.List;


public class TipoJuegoVO implements Cloneable {
     
    private Long tjuCodigo;
    private String tjuNombre;
    private List<TipoApuestaVO> tipoApuestaVoList;
    
    public TipoJuegoVO(SiiTipoJuego siiTipoJuego){
        this.tjuCodigo = siiTipoJuego.getTjuCodigo();
        this.tjuNombre = siiTipoJuego.getTjuNombre();        
    }
    
    public TipoJuegoVO() {
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public TipoJuegoVO clone () 
    {
        TipoJuegoVO resultado = new TipoJuegoVO();
        
        resultado.tjuCodigo = this.tjuCodigo;
        resultado.tjuNombre = this.tjuNombre;
        
        return (resultado);
    }
    
    

    public void setTjuCodigo(Long tjuCodigo) {
        this.tjuCodigo = tjuCodigo;
    }

    public Long getTjuCodigo() {
        return tjuCodigo;
    }

    public void setTjuNombre(String tjuNombre) {
        this.tjuNombre = tjuNombre;
    }

    public String getTjuNombre() {
        return tjuNombre;
    }

    public void setTipoApuestaVoList(List<TipoApuestaVO> tipoApuestaVoList) {
        this.tipoApuestaVoList = tipoApuestaVoList;
    }

    public List<TipoApuestaVO> getTipoApuestaVoList() {
        return tipoApuestaVoList;
    }


}
