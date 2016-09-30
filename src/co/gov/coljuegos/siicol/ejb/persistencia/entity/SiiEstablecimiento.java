package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTABLECIMIENTO")
public class SiiEstablecimiento implements Serializable {
    private Long estCodigo;
    private String estCodInterno;
    private String estDireccion;
    private SiiUbicacion siiUbicacion1;
    private SiiOperador siiOperador2;
    private List<SiiInventario> siiInventarioList3;
    private String estNombre;
    private List<SiiLiquidacionEstabl> siiLiquidacionEstablList;
    private BigDecimal estLatitud;
    private BigDecimal estLongitud;
    private SiiNovedad siiNovedad;
    private String estEstado;
    private List<SiiAutoComisorio> siiAutoComisorioList;
    private List<SiiEstablecSuspension> siiEstablecSuspensionList;




    public SiiEstablecimiento() {
    }

    public SiiEstablecimiento(String estCodInterno, Long estCodigo, String estDireccion, SiiOperador siiOperador2,
                              SiiUbicacion siiUbicacion1, String estNombre) {
        this.estCodInterno = estCodInterno;
        this.estCodigo = estCodigo;
        this.estDireccion = estDireccion;
        this.siiOperador2 = siiOperador2;
        this.siiUbicacion1 = siiUbicacion1;
        this.estNombre = estNombre;
    }

    @Id
    @Column(name = "EST_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTABLECIMIENTO_COD")
    @SequenceGenerator(name = "SEQ_ESTABLECIMIENTO_COD", sequenceName = "SEQ_ESTABLECIMIENTO_COD",allocationSize=1)
    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    @Column(name = "EST_COD_INTERNO", nullable = false, length = 3)
    public String getEstCodInterno() {
        return estCodInterno;
    }

    public void setEstCodInterno(String estCodInterno) {
        this.estCodInterno = estCodInterno;
    }

    @Column(name = "EST_DIRECCION", nullable = false, length = 100)
    public String getEstDireccion() {
        return estDireccion;
    }

    public void setEstDireccion(String estDireccion) {
        this.estDireccion = estDireccion;
    }


    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO")
    public SiiUbicacion getSiiUbicacion1() {
        return siiUbicacion1;
    }

    public void setSiiUbicacion1(SiiUbicacion siiUbicacion1) {
        this.siiUbicacion1 = siiUbicacion1;
    }

    @ManyToOne
    @JoinColumn(name = "OPE_CODIGO")
    public SiiOperador getSiiOperador2() {
        return siiOperador2;
    }

    public void setSiiOperador2(SiiOperador siiOperador2) {
        this.siiOperador2 = siiOperador2;
    }

    @OneToMany(mappedBy = "siiEstablecimiento")
    public List<SiiInventario> getSiiInventarioList3() {
        return siiInventarioList3;
    }

    public void setSiiInventarioList3(List<SiiInventario> siiInventarioList3) {
        this.siiInventarioList3 = siiInventarioList3;
    }

    public SiiInventario addSiiInventario(SiiInventario siiInventario) {
        getSiiInventarioList3().add(siiInventario);
        siiInventario.setSiiEstablecimiento(this);
        return siiInventario;
    }

    public SiiInventario removeSiiInventario(SiiInventario siiInventario) {
        getSiiInventarioList3().remove(siiInventario);
        siiInventario.setSiiEstablecimiento(null);
        return siiInventario;
    }

    @Column(name = "EST_NOMBRE", length = 100)
    public String getEstNombre() {
        return estNombre;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    @OneToMany(mappedBy = "siiEstablecimiento")
    public List<SiiLiquidacionEstabl> getSiiLiquidacionEstablList() {
        return siiLiquidacionEstablList;
    }

    public void setSiiLiquidacionEstablList(List<SiiLiquidacionEstabl> siiLiquidacionEstablList) {
        this.siiLiquidacionEstablList = siiLiquidacionEstablList;
    }

    public SiiLiquidacionEstabl addSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        getSiiLiquidacionEstablList().add(siiLiquidacionEstabl);
        siiLiquidacionEstabl.setSiiEstablecimiento(this);
        return siiLiquidacionEstabl;
    }

    public SiiLiquidacionEstabl removeSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        getSiiLiquidacionEstablList().remove(siiLiquidacionEstabl);
        siiLiquidacionEstabl.setSiiEstablecimiento(null);
        return siiLiquidacionEstabl;
    }

    @Column(name = "EST_LATITUD")
    public BigDecimal getEstLatitud() {
        return estLatitud;
    }

    public void setEstLatitud(BigDecimal estLatitud) {
        this.estLatitud = estLatitud;
    }

    @Column(name = "EST_LONGITUD")
    public BigDecimal getEstLongitud() {
        return estLongitud;
    }

    public void setEstLongitud(BigDecimal estLongitud) {
        this.estLongitud = estLongitud;
    }

    @ManyToOne
    @JoinColumn(name = "NOV_CODIGO")
    public SiiNovedad getSiiNovedad() {
        return siiNovedad;
    }

    public void setSiiNovedad(SiiNovedad siiNovedad) {
        this.siiNovedad = siiNovedad;
    }
    
    @Column(name = "EST_ESTADO", nullable = false, length = 2)
    public String getEstEstado() {
        return estEstado;
    }

    public void setEstEstado(String estEstado) {
        this.estEstado = estEstado;
    }
    
    @OneToMany(mappedBy = "siiEstablecimiento")
    public List<SiiAutoComisorio> getSiiAutoComisorioList() {
        return siiAutoComisorioList;
    }

    public void setSiiAutoComisorioList(List<SiiAutoComisorio> siiAutoComisorioList) {
        this.siiAutoComisorioList = siiAutoComisorioList;
    }

    public SiiAutoComisorio addSiiAutoComisorio(SiiAutoComisorio siiAutoComisorio) {
        getSiiAutoComisorioList().add(siiAutoComisorio);
        siiAutoComisorio.setSiiEstablecimiento(this);
        return siiAutoComisorio;
    }

    public SiiAutoComisorio removeSiiAutoComisorio(SiiAutoComisorio siiAutoComisorio) {
        getSiiAutoComisorioList().remove(siiAutoComisorio);
        siiAutoComisorio.setSiiEstablecimiento(null);
        return siiAutoComisorio;
    }
    
    @OneToMany(mappedBy = "siiEstablecimiento")
    public List<SiiEstablecSuspension> getSiiEstablecSuspensionList() {
        return siiEstablecSuspensionList;
    }

    public void setSiiEstablecSuspensionList(List<SiiEstablecSuspension> siiEstablecSuspensionList) {
        this.siiEstablecSuspensionList = siiEstablecSuspensionList;
    }

    public SiiEstablecSuspension addSiiEstablecSuspension(SiiEstablecSuspension siiEstablecSuspension) {
        getSiiEstablecSuspensionList().add(siiEstablecSuspension);
        siiEstablecSuspension.setSiiEstablecimiento(this);
        return siiEstablecSuspension;
    }

    public SiiEstablecSuspension removeSiiEstablecSuspension(SiiEstablecSuspension siiEstablecSuspension) {
        getSiiEstablecSuspensionList().remove(siiEstablecSuspension);
        siiEstablecSuspension.setSiiEstablecimiento(null);
        return siiEstablecSuspension;
    }


}
