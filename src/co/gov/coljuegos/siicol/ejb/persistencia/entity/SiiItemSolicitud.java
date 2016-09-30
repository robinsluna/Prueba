package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ITEM_SOLICITUD")
public class SiiItemSolicitud implements Serializable {
    private static final long serialVersionUID = -7135461718638974204L;
    private Integer isoCantidad;
    private Long isoCodigo;
    private String isoDescripcion;
    private String isoNombre;
    private String isoUnidad;
    private Long isoValorUnitUltima;
    private SiiSolicitudEstMercado siiSolicitudEstMercado;
    private List<SiiItemCotizacion> siiItemCotizacionList;

    public SiiItemSolicitud() {
    }

    public SiiItemSolicitud(Integer isoCantidad, Long isoCodigo, String isoDescripcion, String isoNombre,
                            String isoUnidad, Long isoValorUnitUltima,
                            SiiSolicitudEstMercado siiSolicitudEstMercado) {
        this.isoCantidad = isoCantidad;
        this.isoCodigo = isoCodigo;
        this.isoDescripcion = isoDescripcion;
        this.isoNombre = isoNombre;
        this.isoUnidad = isoUnidad;
        this.isoValorUnitUltima = isoValorUnitUltima;
        this.siiSolicitudEstMercado = siiSolicitudEstMercado;
    }

    @Column(name = "ISO_CANTIDAD", nullable = false)
    public Integer getIsoCantidad() {
        return isoCantidad;
    }

    public void setIsoCantidad(Integer isoCantidad) {
        this.isoCantidad = isoCantidad;
    }

    @Id
    @Column(name = "ISO_CODIGO", nullable = false)
    public Long getIsoCodigo() {
        return isoCodigo;
    }

    public void setIsoCodigo(Long isoCodigo) {
        this.isoCodigo = isoCodigo;
    }

    @Column(name = "ISO_DESCRIPCION", nullable = false, length = 100)
    public String getIsoDescripcion() {
        return isoDescripcion;
    }

    public void setIsoDescripcion(String isoDescripcion) {
        this.isoDescripcion = isoDescripcion;
    }

    @Column(name = "ISO_NOMBRE", nullable = false, length = 100)
    public String getIsoNombre() {
        return isoNombre;
    }

    public void setIsoNombre(String isoNombre) {
        this.isoNombre = isoNombre;
    }

    @Column(name = "ISO_UNIDAD", nullable = false, length = 20)
    public String getIsoUnidad() {
        return isoUnidad;
    }

    public void setIsoUnidad(String isoUnidad) {
        this.isoUnidad = isoUnidad;
    }

    @Column(name = "ISO_VALOR_UNIT_ULTIMA", nullable = false)
    public Long getIsoValorUnitUltima() {
        return isoValorUnitUltima;
    }

    public void setIsoValorUnitUltima(Long isoValorUnitUltima) {
        this.isoValorUnitUltima = isoValorUnitUltima;
    }


    @ManyToOne
    @JoinColumn(name = "SEM_CODIGO")
    public SiiSolicitudEstMercado getSiiSolicitudEstMercado() {
        return siiSolicitudEstMercado;
    }

    public void setSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        this.siiSolicitudEstMercado = siiSolicitudEstMercado;
    }

    @OneToMany(mappedBy = "siiItemSolicitud")
    public List<SiiItemCotizacion> getSiiItemCotizacionList() {
        return siiItemCotizacionList;
    }

    public void setSiiItemCotizacionList(List<SiiItemCotizacion> siiItemCotizacionList) {
        this.siiItemCotizacionList = siiItemCotizacionList;
    }

    public SiiItemCotizacion addSiiItemCotizacion(SiiItemCotizacion siiItemCotizacion) {
        getSiiItemCotizacionList().add(siiItemCotizacion);
        siiItemCotizacion.setSiiItemSolicitud(this);
        return siiItemCotizacion;
    }

    public SiiItemCotizacion removeSiiItemCotizacion(SiiItemCotizacion siiItemCotizacion) {
        getSiiItemCotizacionList().remove(siiItemCotizacion);
        siiItemCotizacion.setSiiItemSolicitud(null);
        return siiItemCotizacion;
    }
}
