package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemCotizacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemSolicitud;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;

import java.util.List;

public class ItemSolicitudVO {

    private Integer isoCantidad;
    private Long isoCodigo;
    private String isoDescripcion;
    private String isoNombre;
    private String isoUnidad;
    private Long isoValorUnitUltima;
    private SolicitudEstMercadoVO solicitudEstMercadoVO;
    private List<ItemCotizacionVO> itemCotizacionListVO;
    
    public ItemSolicitudVO(SiiItemSolicitud itemSolicitud) {
        this.isoCantidad = itemSolicitud.getIsoCantidad();
        this.isoCodigo = itemSolicitud.getIsoCodigo();
        this.isoDescripcion = itemSolicitud.getIsoDescripcion();
        this.isoNombre = itemSolicitud.getIsoNombre();
        this.isoUnidad = itemSolicitud.getIsoUnidad();
        this.isoValorUnitUltima = itemSolicitud.getIsoValorUnitUltima();
        //Padres:
        if( itemSolicitud.getSiiSolicitudEstMercado() != null) {
            this.solicitudEstMercadoVO = new SolicitudEstMercadoVO(itemSolicitud.getSiiSolicitudEstMercado());
        }
        
    }
    public ItemSolicitudVO(){
        
    }

    public void setIsoCantidad(Integer isoCantidad) {
        this.isoCantidad = isoCantidad;
    }

    public Integer getIsoCantidad() {
        return isoCantidad;
    }

    public void setIsoCodigo(Long isoCodigo) {
        this.isoCodigo = isoCodigo;
    }

    public Long getIsoCodigo() {
        return isoCodigo;
    }

    public void setIsoDescripcion(String isoDescripcion) {
        this.isoDescripcion = isoDescripcion;
    }

    public String getIsoDescripcion() {
        return isoDescripcion;
    }

    public void setIsoNombre(String isoNombre) {
        this.isoNombre = isoNombre;
    }

    public String getIsoNombre() {
        return isoNombre;
    }

    public void setIsoUnidad(String isoUnidad) {
        this.isoUnidad = isoUnidad;
    }

    public String getIsoUnidad() {
        return isoUnidad;
    }

   

    public void setIsoValorUnitUltima(Long isoValorUnitUltima) {
        this.isoValorUnitUltima = isoValorUnitUltima;
    }

    public Long getIsoValorUnitUltima() {
        return isoValorUnitUltima;
    }

    public void setSolicitudEstMercadoVO(SolicitudEstMercadoVO solicitudEstMercadoVO) {
        this.solicitudEstMercadoVO = solicitudEstMercadoVO;
    }

    public SolicitudEstMercadoVO getSolicitudEstMercadoVO() {
        return solicitudEstMercadoVO;
    }

    public void setItemCotizacionListVO(List<ItemCotizacionVO> itemCotizacionListVO) {
        this.itemCotizacionListVO = itemCotizacionListVO;
    }

    public List<ItemCotizacionVO> getItemCotizacionListVO() {
        return itemCotizacionListVO;
    }
}
