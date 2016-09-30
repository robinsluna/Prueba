package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCotizacionEstudio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemCotizacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemSolicitud;

public class ItemCotizacionVO {
    private Long icoCodigo;
    private Long icoIva;
    private Long icoValorUnit;
    private ItemSolicitudVO itemSolicitudVo;
    private CotizacionEstudioVO cotizacionEstudioVo;
    private String icoEspecificac;
    
    public ItemCotizacionVO() {
        
    }

    public ItemCotizacionVO(SiiItemCotizacion itemCotizacion) {
        this.icoCodigo = itemCotizacion.getIcoCodigo();
        this.icoValorUnit = itemCotizacion.getIcoValorUnit();
        this.icoIva = itemCotizacion.getIcoIva();
        this.icoEspecificac = itemCotizacion.getIcoEspecificac();
        //Padres:
        this.itemSolicitudVo = new ItemSolicitudVO(itemCotizacion.getSiiItemSolicitud());
        this.cotizacionEstudioVo = new CotizacionEstudioVO(itemCotizacion.getSiiCotizacionEstudio());
    }
    
    public void setIcoCodigo(Long icoCodigo) {
        this.icoCodigo = icoCodigo;
    }

    public void setIcoEspecificac(String icoEspecificac) {
        this.icoEspecificac = icoEspecificac;
    }

    public String getIcoEspecificac() {
        return icoEspecificac;
    }

    public Long getIcoCodigo() {
        return icoCodigo;
    }

    public void setIcoValorUnit(Long icoValorUnit) {
        this.icoValorUnit = icoValorUnit;
    }

    public Long getIcoValorUnit() {
        return icoValorUnit;
    }

    public void setItemSolicitudVo(ItemSolicitudVO itemSolicitudVo) {
        this.itemSolicitudVo = itemSolicitudVo;
    }

    public ItemSolicitudVO getItemSolicitudVo() {
        return itemSolicitudVo;
    }

    public void setCotizacionEstudioVo(CotizacionEstudioVO cotizacionEstudioVo) {
        this.cotizacionEstudioVo = cotizacionEstudioVo;
    }

    public CotizacionEstudioVO getCotizacionEstudioVo() {
        return cotizacionEstudioVo;
    }

    public void setIcoIva(Long icoIva) {
        this.icoIva = icoIva;
    }

    public Long getIcoIva() {
        return icoIva;
    }
}

