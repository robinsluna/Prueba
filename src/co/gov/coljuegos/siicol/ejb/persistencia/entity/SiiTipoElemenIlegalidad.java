package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_ELEMEN_ILEGALIDAD")
public class SiiTipoElemenIlegalidad implements Serializable {
    private static final long serialVersionUID = -2516387650083768523L;
    private Long teiCodigo;
    private String teiNombre;
    private List<SiiElementoIlegDenun> siiElementoIlegDenunList;
    private List<SiiElementoIlegInfVer> siiElementoIlegInfVerList;
    private List<SiiElementoRetiradoAcc> siiElementoRetiradoAccList;

    public SiiTipoElemenIlegalidad() {
    }

    public SiiTipoElemenIlegalidad(Long teiCodigo, String teiNombre) {
        this.teiCodigo = teiCodigo;
        this.teiNombre = teiNombre;
    }

    @Id
    @Column(name = "TEI_CODIGO", nullable = false)
    public Long getTeiCodigo() {
        return teiCodigo;
    }

    public void setTeiCodigo(Long teiCodigo) {
        this.teiCodigo = teiCodigo;
    }

    @Column(name = "TEI_NOMBRE", nullable = false, length = 30)
    public String getTeiNombre() {
        return teiNombre;
    }

    public void setTeiNombre(String teiNombre) {
        this.teiNombre = teiNombre;
    }

    @OneToMany(mappedBy = "siiTipoElemenIlegalidad")
    public List<SiiElementoIlegDenun> getSiiElementoIlegDenunList() {
        return siiElementoIlegDenunList;
    }

    public void setSiiElementoIlegDenunList(List<SiiElementoIlegDenun> siiElementoIlegDenunList) {
        this.siiElementoIlegDenunList = siiElementoIlegDenunList;
    }

    public SiiElementoIlegDenun addSiiElementoIlegDenun(SiiElementoIlegDenun siiElementoIlegDenun) {
        getSiiElementoIlegDenunList().add(siiElementoIlegDenun);
        siiElementoIlegDenun.setSiiTipoElemenIlegalidad(this);
        return siiElementoIlegDenun;
    }

    public SiiElementoIlegDenun removeSiiElementoIlegDenun(SiiElementoIlegDenun siiElementoIlegDenun) {
        getSiiElementoIlegDenunList().remove(siiElementoIlegDenun);
        siiElementoIlegDenun.setSiiTipoElemenIlegalidad(null);
        return siiElementoIlegDenun;
    }

    @OneToMany(mappedBy = "siiTipoElemenIlegalidad")
    public List<SiiElementoIlegInfVer> getSiiElementoIlegInfVerList() {
        return siiElementoIlegInfVerList;
    }

    public void setSiiElementoIlegInfVerList(List<SiiElementoIlegInfVer> siiElementoIlegInfVerList) {
        this.siiElementoIlegInfVerList = siiElementoIlegInfVerList;
    }

    public SiiElementoIlegInfVer addSiiElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) {
        getSiiElementoIlegInfVerList().add(siiElementoIlegInfVer);
        siiElementoIlegInfVer.setSiiTipoElemenIlegalidad(this);
        return siiElementoIlegInfVer;
    }

    public SiiElementoIlegInfVer removeSiiElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) {
        getSiiElementoIlegInfVerList().remove(siiElementoIlegInfVer);
        siiElementoIlegInfVer.setSiiTipoElemenIlegalidad(null);
        return siiElementoIlegInfVer;
    }

    @OneToMany(mappedBy = "siiTipoElemenIlegalidad")
    public List<SiiElementoRetiradoAcc> getSiiElementoRetiradoAccList(){
        return siiElementoRetiradoAccList;
    }

    public void setSiiElementoRetiradoAccList(List<SiiElementoRetiradoAcc> siiElementoRetiradoAccList){
        this.siiElementoRetiradoAccList = siiElementoRetiradoAccList;
    }

    public SiiElementoRetiradoAcc addSiiElementoRetiradoAcc(SiiElementoRetiradoAcc siiElementoRetiradoAcc){
        getSiiElementoRetiradoAccList().add(siiElementoRetiradoAcc);
        siiElementoRetiradoAcc.setSiiTipoElemenIlegalidad(this);
        return siiElementoRetiradoAcc;
    }

    public SiiElementoRetiradoAcc removeSiiElementoRetiradoAcc(SiiElementoRetiradoAcc siiElementoRetiradoAcc){
        getSiiElementoRetiradoAccList().remove(siiElementoRetiradoAcc);
        siiElementoRetiradoAcc.setSiiTipoElemenIlegalidad(null);
        return siiElementoRetiradoAcc;
    }
}
