package co.gov.coljuegos.siicol.ejb.vo;

import java.util.ArrayList;


public class LineaCuadroComparativoVO {
    private int item;
    ItemSolicitudVO elemento;
    ArrayList<ItemCotizacionVO> elementosOferta;
    
    /* lineaVo.setDescripcion(elemento.getIsoDescripcion());
    lineaVo.setCantidadAnalizada(elemento.getIsoCantidad());
    lineaVo.setUnidad(elemento.getIsoUnidad());
    lineaVo.setValorUnitarioCompraAnterior(elemento.getIsoValorUnitUltima()); */    

    public void setElemento(ItemSolicitudVO elemento) {
        this.elemento = elemento;
    }

    public ItemSolicitudVO getElemento() {
        return elemento;
    }

    public void setElementosOferta(ArrayList<ItemCotizacionVO> elementosOferta) {
        this.elementosOferta = elementosOferta;
    }

    public ArrayList<ItemCotizacionVO> getElementosOferta() {
        return elementosOferta;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getItem() {
        return item;
    }
    
    public Integer getIsoCantidad() {
        return (elemento.getIsoCantidad());
    }
}
