/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Monica Pabon
 * FECHA	: 28-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiClaseJuego;

import java.util.List;


public class ClaseJuegoVO implements Cloneable {
     
    private Long cjuCodigo;
    private String cjuNombre;
    
    private List<TipoApuestaVO> tipoApuestaVoList;
    private List<TarifaIlegalidadVO> tarifaIlegalidadList;
    private List<ElementoProcesoIleVO> elementoProcesoIleList;
    
    
    /**
     * Constructor.
     * @param siiClaseJuego - Entity.
     */
    public ClaseJuegoVO(SiiClaseJuego siiClaseJuego){
        if (siiClaseJuego!=null) {
            this.cjuCodigo = siiClaseJuego.getCjuCodigo();
            this.cjuNombre = siiClaseJuego.getCjuNombre();
        }
    }
    
    
    /**
     * Constructor.
     */
    public ClaseJuegoVO() { }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public ClaseJuegoVO clone () 
    {
        ClaseJuegoVO resultado = new ClaseJuegoVO();
        
        resultado.cjuCodigo = this.cjuCodigo;
        resultado.cjuNombre = this.cjuNombre;
        
        return (resultado);
    }
    
    
    
    public void setCjuCodigo(Long cjuCodigo) {
        this.cjuCodigo = cjuCodigo;
    }

    public Long getCjuCodigo() {
        return cjuCodigo;
    }

    public void setCjuNombre(String cjuNombre) {
        this.cjuNombre = cjuNombre;
    }

    public String getCjuNombre() {
        return cjuNombre;
    }

    public void setTipoApuestaVoList(List<TipoApuestaVO> tipoApuestaVoList) {
        this.tipoApuestaVoList = tipoApuestaVoList;
    }

    public List<TipoApuestaVO> getTipoApuestaVoList() {
        return tipoApuestaVoList;
    }

    public void setTarifaIlegalidadList(List<TarifaIlegalidadVO> tarifaIlegalidadList) {
        this.tarifaIlegalidadList = tarifaIlegalidadList;
    }

    public List<TarifaIlegalidadVO> getTarifaIlegalidadList() {
        return tarifaIlegalidadList;
    }

    public void setElementoProcesoIleList(List<ElementoProcesoIleVO> elementoProcesoIleList) {
        this.elementoProcesoIleList = elementoProcesoIleList;
    }

    public List<ElementoProcesoIleVO> getElementoProcesoIleList() {
        return elementoProcesoIleList;
    }
}
