package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_GARANTIA")
public class SiiTipoGarantia implements Serializable {
    private static final long serialVersionUID = -5681242195093965369L;
    private String tgaActivo;
    private Long tgaCodigo;
    private String tgaDescripciom;
    private String tgaNombre;
    private List<SiiEstudioPrevio> siiEstudioPrevioList2;
    private List<SiiAmparoEstPrev> siiAmparoEstPrevList;

    public SiiTipoGarantia() {
    }

    public SiiTipoGarantia(String tgaActivo, Long tgaCodigo, String tgaDescripciom, String tgaNombre) {
        this.tgaActivo = tgaActivo;
        this.tgaCodigo = tgaCodigo;
        this.tgaDescripciom = tgaDescripciom;
        this.tgaNombre = tgaNombre;
    }

    @Column(name = "TGA_ACTIVO", nullable = false, length = 1)
    public String getTgaActivo() {
        return tgaActivo;
    }

    public void setTgaActivo(String tgaActivo) {
        this.tgaActivo = tgaActivo;
    }

    @Id
    @Column(name = "TGA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TIPO_GARANTIA_COD")
    @SequenceGenerator(name = "SEQ_TIPO_GARANTIA_COD", sequenceName = "SEQ_TIPO_GARANTIA_COD",allocationSize=1)
    public Long getTgaCodigo() {
        return tgaCodigo;
    }

    public void setTgaCodigo(Long tgaCodigo) {
        this.tgaCodigo = tgaCodigo;
    }

    @Column(name = "TGA_DESCRIPCIOM", length = 200)
    public String getTgaDescripciom() {
        return tgaDescripciom;
    }

    public void setTgaDescripciom(String tgaDescripciom) {
        this.tgaDescripciom = tgaDescripciom;
    }

    @Column(name = "TGA_NOMBRE", nullable = false, length = 50)
    public String getTgaNombre() {
        return tgaNombre;
    }

    public void setTgaNombre(String tgaNombre) {
        this.tgaNombre = tgaNombre;
    }

    @OneToMany(mappedBy = "siiTipoGarantia")
    public List<SiiEstudioPrevio> getSiiEstudioPrevioList2() {
        return siiEstudioPrevioList2;
    }

    public void setSiiEstudioPrevioList2(List<SiiEstudioPrevio> siiEstudioPrevioList2) {
        this.siiEstudioPrevioList2 = siiEstudioPrevioList2;
    }

    public SiiEstudioPrevio addSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList2().add(siiEstudioPrevio);
        siiEstudioPrevio.setSiiTipoGarantia(this);
        return siiEstudioPrevio;
    }

    public SiiEstudioPrevio removeSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList2().remove(siiEstudioPrevio);
        siiEstudioPrevio.setSiiTipoGarantia(null);
        return siiEstudioPrevio;
    }

    @OneToMany(mappedBy = "siiTipoGarantia")
    public List<SiiAmparoEstPrev> getSiiAmparoEstPrevList() {
        return siiAmparoEstPrevList;
    }

    public void setSiiAmparoEstPrevList(List<SiiAmparoEstPrev> siiAmparoEstPrevList) {
        this.siiAmparoEstPrevList = siiAmparoEstPrevList;
    }

    public SiiAmparoEstPrev addSiiAmparoEstPrev(SiiAmparoEstPrev siiAmparoEstPrev) {
        getSiiAmparoEstPrevList().add(siiAmparoEstPrev);
        siiAmparoEstPrev.setSiiTipoGarantia(this);
        return siiAmparoEstPrev;
    }

    public SiiAmparoEstPrev removeSiiAmparoEstPrev(SiiAmparoEstPrev siiAmparoEstPrev) {
        getSiiAmparoEstPrevList().remove(siiAmparoEstPrev);
        siiAmparoEstPrev.setSiiTipoGarantia(null);
        return siiAmparoEstPrev;
    }
}
