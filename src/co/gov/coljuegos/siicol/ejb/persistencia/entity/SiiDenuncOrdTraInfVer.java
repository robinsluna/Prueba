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
@Table(name = "SII_DENUNC_ORD_TRA_INF_VER")
public class SiiDenuncOrdTraInfVer implements Serializable {
    private static final long serialVersionUID = 2480775004745183462L;
    private Long  divCodigo;
    private String divDireccion;
    private String divTipoJuego;
    private List<SiiElementoIlegInfVer> siiElementoIlegInfVerList;
    private SiiResultadoVerifCampo siiResultadoVerifCampo;
    private SiiInformeVerificCampo siiInformeVerificCampo;
    private SiiDenunciaOrdenTrab siiDenunciaOrdenTrab;
    private String divActivo;

    public SiiDenuncOrdTraInfVer() {
    }

    public SiiDenuncOrdTraInfVer(Long divCodigo, String divDireccion, String divTipoJuego,
                                 SiiDenunciaOrdenTrab siiDenunciaOrdenTrab,
                                 SiiInformeVerificCampo siiInformeVerificCampo,
                                 SiiResultadoVerifCampo siiResultadoVerifCampo) {
        this.divCodigo = divCodigo;
        this.divDireccion = divDireccion;
        this.divTipoJuego = divTipoJuego;
        this.siiDenunciaOrdenTrab = siiDenunciaOrdenTrab;
        this.siiInformeVerificCampo = siiInformeVerificCampo;
        this.siiResultadoVerifCampo = siiResultadoVerifCampo;
    }

    @Id
    @Column(name = "DIV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DEN_ORD_TRA_INF_VER_COD")
    @SequenceGenerator(name = "SEQ_DEN_ORD_TRA_INF_VER_COD", sequenceName = "SEQ_DEN_ORD_TRA_INF_VER_COD",allocationSize=1)
    public Long getDivCodigo() {
        return divCodigo;
    }

    public void setDivCodigo(Long divCodigo) {
        this.divCodigo = divCodigo;
    }

    @Column(name = "DIV_DIRECCION", nullable = false, length = 100)
    public String getDivDireccion() {
        return divDireccion;
    }

    public void setDivDireccion(String divDireccion) {
        this.divDireccion = divDireccion;
    }

    @Column(name = "DIV_TIPO_JUEGO", nullable = false, length = 15)
    public String getDivTipoJuego() {
        return divTipoJuego;
    }

    public void setDivTipoJuego(String divTipoJuego) {
        this.divTipoJuego = divTipoJuego;
    }


    @OneToMany(mappedBy = "siiDenuncOrdTraInfVer")
    public List<SiiElementoIlegInfVer> getSiiElementoIlegInfVerList() {
        return siiElementoIlegInfVerList;
    }

    public void setSiiElementoIlegInfVerList(List<SiiElementoIlegInfVer> siiElementoIlegInfVerList) {
        this.siiElementoIlegInfVerList = siiElementoIlegInfVerList;
    }

    public SiiElementoIlegInfVer addSiiElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) {
        getSiiElementoIlegInfVerList().add(siiElementoIlegInfVer);
        siiElementoIlegInfVer.setSiiDenuncOrdTraInfVer(this);
        return siiElementoIlegInfVer;
    }

    public SiiElementoIlegInfVer removeSiiElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) {
        getSiiElementoIlegInfVerList().remove(siiElementoIlegInfVer);
        siiElementoIlegInfVer.setSiiDenuncOrdTraInfVer(null);
        return siiElementoIlegInfVer;
    }

    @ManyToOne
    @JoinColumn(name = "RVC_CODIGO")
    public SiiResultadoVerifCampo getSiiResultadoVerifCampo() {
        return siiResultadoVerifCampo;
    }

    public void setSiiResultadoVerifCampo(SiiResultadoVerifCampo siiResultadoVerifCampo) {
        this.siiResultadoVerifCampo = siiResultadoVerifCampo;
    }

    @ManyToOne
    @JoinColumn(name = "IVC_CODIGO")
    public SiiInformeVerificCampo getSiiInformeVerificCampo() {
        return siiInformeVerificCampo;
    }

    public void setSiiInformeVerificCampo(SiiInformeVerificCampo siiInformeVerificCampo) {
        this.siiInformeVerificCampo = siiInformeVerificCampo;
    }

    @ManyToOne
    @JoinColumn(name = "DOT_CODIGO")
    public SiiDenunciaOrdenTrab getSiiDenunciaOrdenTrab() {
        return siiDenunciaOrdenTrab;
    }

    public void setSiiDenunciaOrdenTrab(SiiDenunciaOrdenTrab siiDenunciaOrdenTrab) {
        this.siiDenunciaOrdenTrab = siiDenunciaOrdenTrab;
    }
    
    @Column(name = "DIV_ACTIVO", nullable = false, length = 1)
    public String getDivActivo() {
        return divActivo;
    }

    public void setDivActivo(String divActivo) {
        this.divActivo = divActivo;
    }
}
