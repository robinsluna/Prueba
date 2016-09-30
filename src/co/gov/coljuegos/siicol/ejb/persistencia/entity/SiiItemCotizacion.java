package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ITEM_COTIZACION")
public class SiiItemCotizacion implements Serializable {
    private static final long serialVersionUID = -4425459057698945134L;
    private Long icoCodigo;
    private String icoEspecificac;
    private Long icoIva;
    private Long icoValorUnit;
    private SiiItemSolicitud siiItemSolicitud;
    private SiiCotizacionEstudio siiCotizacionEstudio;

    public SiiItemCotizacion() {
    }

    public SiiItemCotizacion(SiiCotizacionEstudio siiCotizacionEstudio, Long icoCodigo, Long icoValorUnit,
                             SiiItemSolicitud siiItemSolicitud, Long icoIva, String icoEspecificac) {
        this.siiCotizacionEstudio = siiCotizacionEstudio;
        this.icoCodigo = icoCodigo;
        this.icoEspecificac = icoEspecificac;
        this.icoIva = icoIva;
        this.icoValorUnit = icoValorUnit;
        this.siiItemSolicitud = siiItemSolicitud;
    }


    @Id
    @Column(name = "ICO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ITEM_COTIZADO_COD")
    @SequenceGenerator(name = "SEQ_ITEM_COTIZADO_COD", sequenceName = "SEQ_ITEM_COTIZADO_COD",allocationSize=1)
    public Long getIcoCodigo() {
        return icoCodigo;
    }

    public void setIcoCodigo(Long icoCodigo) {
        this.icoCodigo = icoCodigo;
    }

    @Column(name = "ICO_ESPECIFICAC", length = 1000)
    public String getIcoEspecificac() {
        return icoEspecificac;
    }

    public void setIcoEspecificac(String icoEspecificac) {
        this.icoEspecificac = icoEspecificac;
    }

    @Column(name = "ICO_IVA")
    public Long getIcoIva() {
        return icoIva;
    }

    public void setIcoIva(Long icoIva) {
        this.icoIva = icoIva;
    }

    @Column(name = "ICO_VALOR_UNIT", nullable = false)
    public Long getIcoValorUnit() {
        return icoValorUnit;
    }

    public void setIcoValorUnit(Long icoValorUnit) {
        this.icoValorUnit = icoValorUnit;
    }


    @ManyToOne
    @JoinColumn(name = "ISO_CODIGO")
    public SiiItemSolicitud getSiiItemSolicitud() {
        return siiItemSolicitud;
    }

    public void setSiiItemSolicitud(SiiItemSolicitud siiItemSolicitud) {
        this.siiItemSolicitud = siiItemSolicitud;
    }

    @ManyToOne
    @JoinColumn(name = "CES_CODIGO")
    public SiiCotizacionEstudio getSiiCotizacionEstudio() {
        return siiCotizacionEstudio;
    }

    public void setSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        this.siiCotizacionEstudio = siiCotizacionEstudio;
    }
}
