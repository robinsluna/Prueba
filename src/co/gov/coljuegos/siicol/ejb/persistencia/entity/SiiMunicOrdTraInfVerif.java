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
@Table(name = "SII_MUNIC_ORD_TRA_INF_VERIF")
public class SiiMunicOrdTraInfVerif implements Serializable {
    private static final long serialVersionUID = 2961479157915154722L;
    private Long mivCodigo;
    private String mivDireccion;
    private String mivTipoJuego;
    private SiiMunicipioOrdenTrab siiMunicipioOrdenTrab;
    private SiiInformeVerificCampo siiInformeVerificCampo;
    private List<SiiElementoIlegInfVer> siiElementoIlegInfVerList3;
    private String mivActivo;

    public SiiMunicOrdTraInfVerif() {
    }

    public SiiMunicOrdTraInfVerif(SiiInformeVerificCampo siiInformeVerificCampo, Long mivCodigo, String mivDireccion,
                                  String mivTipoJuego, SiiMunicipioOrdenTrab siiMunicipioOrdenTrab) {
        this.siiInformeVerificCampo = siiInformeVerificCampo;
        this.mivCodigo = mivCodigo;
        this.mivDireccion = mivDireccion;
        this.mivTipoJuego = mivTipoJuego;
        this.siiMunicipioOrdenTrab = siiMunicipioOrdenTrab;
    }


    @Id
    @Column(name = "MIV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MUN_ORD_TRA_INF_VER_COD")
    @SequenceGenerator(name = "SEQ_MUN_ORD_TRA_INF_VER_COD", sequenceName = "SEQ_MUN_ORD_TRA_INF_VER_COD",allocationSize=1)
    public Long getMivCodigo() {
        return mivCodigo;
    }

    public void setMivCodigo(Long mivCodigo) {
        this.mivCodigo = mivCodigo;
    }

    @Column(name = "MIV_DIRECCION", nullable = false, length = 100)
    public String getMivDireccion() {
        return mivDireccion;
    }

    public void setMivDireccion(String mivDireccion) {
        this.mivDireccion = mivDireccion;
    }

    @Column(name = "MIV_TIPO_JUEGO", nullable = false, length = 15)
    public String getMivTipoJuego() {
        return mivTipoJuego;
    }

    public void setMivTipoJuego(String mivTipoJuego) {
        this.mivTipoJuego = mivTipoJuego;
    }


    @ManyToOne
    @JoinColumn(name = "MOT_CODIGO")
    public SiiMunicipioOrdenTrab getSiiMunicipioOrdenTrab() {
        return siiMunicipioOrdenTrab;
    }

    public void setSiiMunicipioOrdenTrab(SiiMunicipioOrdenTrab siiMunicipioOrdenTrab) {
        this.siiMunicipioOrdenTrab = siiMunicipioOrdenTrab;
    }

    @ManyToOne
    @JoinColumn(name = "IVC_CODIGO")
    public SiiInformeVerificCampo getSiiInformeVerificCampo() {
        return siiInformeVerificCampo;
    }

    public void setSiiInformeVerificCampo(SiiInformeVerificCampo siiInformeVerificCampo) {
        this.siiInformeVerificCampo = siiInformeVerificCampo;
    }

    @OneToMany(mappedBy = "siiMunicOrdTraInfVerif")
    public List<SiiElementoIlegInfVer> getSiiElementoIlegInfVerList3() {
        return siiElementoIlegInfVerList3;
    }

    public void setSiiElementoIlegInfVerList3(List<SiiElementoIlegInfVer> siiElementoIlegInfVerList3) {
        this.siiElementoIlegInfVerList3 = siiElementoIlegInfVerList3;
    }

    public SiiElementoIlegInfVer addSiiElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) {
        getSiiElementoIlegInfVerList3().add(siiElementoIlegInfVer);
        siiElementoIlegInfVer.setSiiMunicOrdTraInfVerif(this);
        return siiElementoIlegInfVer;
    }

    public SiiElementoIlegInfVer removeSiiElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) {
        getSiiElementoIlegInfVerList3().remove(siiElementoIlegInfVer);
        siiElementoIlegInfVer.setSiiMunicOrdTraInfVerif(null);
        return siiElementoIlegInfVer;
    }
    
    @Column(name = "MIV_ACTIVO", nullable = false, length = 1)
    public String getMivActivo() {
        return mivActivo;
    }

    public void setMivActivo(String mivActivo) {
        this.mivActivo = mivActivo;
    }
}
