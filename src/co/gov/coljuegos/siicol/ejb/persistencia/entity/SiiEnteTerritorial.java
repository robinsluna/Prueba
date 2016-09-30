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
@Table(name = "SII_ENTE_TERRITORIAL")
public class SiiEnteTerritorial implements Serializable {
    private static final long serialVersionUID = -308343953218758877L;
    private Long etiCodigo;
    private Integer etiPoblacion;
    private SiiUbicacion siiUbicacion;
    private List<SiiDistribucionUbica> siiDistribucionUbicaList;
    private SiiPersona siiPersona;
    private List<SiiDetalleDistrib> siiDetalleDistribList;
    private Integer etiPoblacP2014;
    private List<SiiBeneficiarioEnte> siiBeneficiarioEnteList;
    private SiiUsuario siiUsuarioConec;
    private List<SiiPoblacionEnte> siiPoblacionEnteList;

    public SiiEnteTerritorial() {
    }

    public SiiEnteTerritorial(Long etiCodigo, Integer etiPoblacion,
                              SiiPersona siiPersona, SiiUbicacion siiUbicacion) {
        this.etiCodigo = etiCodigo;
        this.etiPoblacion = etiPoblacion;
        this.siiPersona = siiPersona;
        this.siiUbicacion = siiUbicacion;
    }


    @Id
    @Column(name = "ETI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ENTE_TERRITORIAL_COD")
    @SequenceGenerator(name = "SEQ_ENTE_TERRITORIAL_COD", sequenceName = "SEQ_ENTE_TERRITORIAL_COD",allocationSize=1)
    public Long getEtiCodigo() {
        return etiCodigo;
    }

    public void setEtiCodigo(Long etiCodigo) {
        this.etiCodigo = etiCodigo;
    }

    @Column(name = "ETI_POBLACION", nullable = false)
    public Integer getEtiPoblacion() {
        return etiPoblacion;
    }

    public void setEtiPoblacion(Integer etiPoblacion) {
        this.etiPoblacion = etiPoblacion;
    }


    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO")
    public SiiUbicacion getSiiUbicacion() {
        return siiUbicacion;
    }

    public void setSiiUbicacion(SiiUbicacion siiUbicacion) {
        this.siiUbicacion = siiUbicacion;
    }


    @OneToMany(mappedBy = "siiEnteTerritorial")
    public List<SiiDistribucionUbica> getSiiDistribucionUbicaList() {
        return siiDistribucionUbicaList;
    }

    public void setSiiDistribucionUbicaList(List<SiiDistribucionUbica> siiDistribucionUbicaList) {
        this.siiDistribucionUbicaList = siiDistribucionUbicaList;
    }

    public SiiDistribucionUbica addSiiDistribucionUbica(SiiDistribucionUbica siiDistribucionUbica) {
        getSiiDistribucionUbicaList().add(siiDistribucionUbica);
        siiDistribucionUbica.setSiiEnteTerritorial(this);
        return siiDistribucionUbica;
    }

    public SiiDistribucionUbica removeSiiDistribucionUbica(SiiDistribucionUbica siiDistribucionUbica) {
        getSiiDistribucionUbicaList().remove(siiDistribucionUbica);
        siiDistribucionUbica.setSiiEnteTerritorial(null);
        return siiDistribucionUbica;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @OneToMany(mappedBy = "siiEnteTerritorial")
    public List<SiiDetalleDistrib> getSiiDetalleDistribList() {
        return siiDetalleDistribList;
    }

    public void setSiiDetalleDistribList(List<SiiDetalleDistrib> siiDetalleDistribList) {
        this.siiDetalleDistribList = siiDetalleDistribList;
    }

    public SiiDetalleDistrib addSiiDetalleDistrib(SiiDetalleDistrib siiDetalleDistrib) {
        getSiiDetalleDistribList().add(siiDetalleDistrib);
        siiDetalleDistrib.setSiiEnteTerritorial(this);
        return siiDetalleDistrib;
    }

    public SiiDetalleDistrib removeSiiDetalleDistrib(SiiDetalleDistrib siiDetalleDistrib) {
        getSiiDetalleDistribList().remove(siiDetalleDistrib);
        siiDetalleDistrib.setSiiEnteTerritorial(null);
        return siiDetalleDistrib;
    }


    @Column(name = "ETI_POBLAC_P_2014")
    public Integer getEtiPoblacP2014() {
        return etiPoblacP2014;
    }

    public void setEtiPoblacP2014(Integer etiPoblacP2014) {
        this.etiPoblacP2014 = etiPoblacP2014;
    }

    @OneToMany(mappedBy = "siiEnteTerritorial")
    public List<SiiBeneficiarioEnte> getSiiBeneficiarioEnteList() {
        return siiBeneficiarioEnteList;
    }

    public void setSiiBeneficiarioEnteList(List<SiiBeneficiarioEnte> siiBeneficiarioEnteList) {
        this.siiBeneficiarioEnteList = siiBeneficiarioEnteList;
    }

    public SiiBeneficiarioEnte addSiiBeneficiarioEnte(SiiBeneficiarioEnte siiBeneficiarioEnte) {
        getSiiBeneficiarioEnteList().add(siiBeneficiarioEnte);
        siiBeneficiarioEnte.setSiiEnteTerritorial(this);
        return siiBeneficiarioEnte;
    }

    public SiiBeneficiarioEnte removeSiiBeneficiarioEnte(SiiBeneficiarioEnte siiBeneficiarioEnte) {
        getSiiBeneficiarioEnteList().remove(siiBeneficiarioEnte);
        siiBeneficiarioEnte.setSiiEnteTerritorial(null);
        return siiBeneficiarioEnte;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CON")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @OneToMany(mappedBy = "siiEnteTerritorial")
    public List<SiiPoblacionEnte> getSiiPoblacionEnteList() {
        return siiPoblacionEnteList;
    }

    public void setSiiPoblacionEnteList(List<SiiPoblacionEnte> siiPoblacionEnteList) {
        this.siiPoblacionEnteList = siiPoblacionEnteList;
    }

    public SiiPoblacionEnte addSiiPoblacionEnte(SiiPoblacionEnte siiPoblacionEnte) {
        getSiiPoblacionEnteList().add(siiPoblacionEnte);
        siiPoblacionEnte.setSiiEnteTerritorial(this);
        return siiPoblacionEnte;
    }

    public SiiPoblacionEnte removeSiiPoblacionEnte(SiiPoblacionEnte siiPoblacionEnte) {
        getSiiPoblacionEnteList().remove(siiPoblacionEnte);
        siiPoblacionEnte.setSiiEnteTerritorial(null);
        return siiPoblacionEnte;
    }
}
