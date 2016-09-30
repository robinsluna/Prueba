package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_CUADRANTE_ORD_TRA_INF_VER")
public class SiiCuadranteOrdTraInfVer implements Serializable {
    private static final long serialVersionUID = -2106894997328501887L;
    private Long civCodigo;
    private String civDireccion;
    private String civTipoJuego;
    private List<SiiElementoIlegInfVer> siiElementoIlegInfVerList;
    private SiiInformeVerificCampo siiInformeVerificCampo1;
    private SiiCuadranteOrdenTra siiCuadranteOrdenTra;
    private String civActivo;

    public SiiCuadranteOrdTraInfVer() {
    }

    public SiiCuadranteOrdTraInfVer(Long civCodigo, String civDireccion, String civTipoJuego,
                                    SiiCuadranteOrdenTra siiCuadranteOrdenTra,
                                    SiiInformeVerificCampo siiInformeVerificCampo1) {
        this.civCodigo = civCodigo;
        this.civDireccion = civDireccion;
        this.civTipoJuego = civTipoJuego;
        this.siiCuadranteOrdenTra = siiCuadranteOrdenTra;
        this.siiInformeVerificCampo1 = siiInformeVerificCampo1;
    }

    @Id
    @Column(name = "CIV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CUADR_ORD_TRA_INF_VER_COD")
    @SequenceGenerator(name = "SEQ_CUADR_ORD_TRA_INF_VER_COD", sequenceName = "SEQ_CUADR_ORD_TRA_INF_VER_COD",allocationSize=1)
    public Long getCivCodigo() {
        return civCodigo;
    }

    public void setCivCodigo(Long civCodigo) {
        this.civCodigo = civCodigo;
    }

    @Column(name = "CIV_DIRECCION", nullable = false, length = 100)
    public String getCivDireccion() {
        return civDireccion;
    }

    public void setCivDireccion(String civDireccion) {
        this.civDireccion = civDireccion;
    }

    @Column(name = "CIV_TIPO_JUEGO", nullable = false, length = 15)
    public String getCivTipoJuego() {
        return civTipoJuego;
    }

    public void setCivTipoJuego(String civTipoJuego) {
        this.civTipoJuego = civTipoJuego;
    }


    @OneToMany(mappedBy = "siiCuadranteOrdTraInfVer")
    public List<SiiElementoIlegInfVer> getSiiElementoIlegInfVerList() {
        return siiElementoIlegInfVerList;
    }

    public void setSiiElementoIlegInfVerList(List<SiiElementoIlegInfVer> siiElementoIlegInfVerList) {
        this.siiElementoIlegInfVerList = siiElementoIlegInfVerList;
    }

    public SiiElementoIlegInfVer addSiiElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) {
        getSiiElementoIlegInfVerList().add(siiElementoIlegInfVer);
        siiElementoIlegInfVer.setSiiCuadranteOrdTraInfVer(this);
        return siiElementoIlegInfVer;
    }

    public SiiElementoIlegInfVer removeSiiElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) {
        getSiiElementoIlegInfVerList().remove(siiElementoIlegInfVer);
        siiElementoIlegInfVer.setSiiCuadranteOrdTraInfVer(null);
        return siiElementoIlegInfVer;
    }

    @ManyToOne
    @JoinColumn(name = "IVC_CODIGO")
    public SiiInformeVerificCampo getSiiInformeVerificCampo1() {
        return siiInformeVerificCampo1;
    }

    public void setSiiInformeVerificCampo1(SiiInformeVerificCampo siiInformeVerificCampo1) {
        this.siiInformeVerificCampo1 = siiInformeVerificCampo1;
    }

    @ManyToOne
    @JoinColumn(name = "COT_CODIGO")
    public SiiCuadranteOrdenTra getSiiCuadranteOrdenTra() {
        return siiCuadranteOrdenTra;
    }

    public void setSiiCuadranteOrdenTra(SiiCuadranteOrdenTra siiCuadranteOrdenTra) {
        this.siiCuadranteOrdenTra = siiCuadranteOrdenTra;
    }
    
    @Column(name = "CIV_ACTIVO", nullable = false, length = 1)
    public String getCivActivo() {
        return civActivo;
    }

    public void setCivActivo(String civActivo) {
        this.civActivo = civActivo;
    }
}
