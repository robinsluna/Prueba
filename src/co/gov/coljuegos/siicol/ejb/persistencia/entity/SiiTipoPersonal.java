package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_PERSONAL")
public class SiiTipoPersonal implements Serializable {
    private static final long serialVersionUID = -3836703061923495286L;
    private Long tpeCodigo;
    private String tpeNombre;
    private List<SiiPersonalEmpresa> siiPersonalEmpresaList;
    private List<SiiHistPersonalEmp> siiHistPersonalEmpList;
private List<SiiDocumentoRadicado> siiDocumentoRadicadoList;

    public SiiTipoPersonal() {
    }

    public SiiTipoPersonal(Long tpeCodigo, String tpeNombre) {
        this.tpeCodigo = tpeCodigo;
        this.tpeNombre = tpeNombre;
    }

    @Id
    @Column(name = "TPE_CODIGO", nullable = false)
    public Long getTpeCodigo() {
        return tpeCodigo;
    }

    public void setTpeCodigo(Long tpeCodigo) {
        this.tpeCodigo = tpeCodigo;
    }

    @Column(name = "TPE_NOMBRE", nullable = false, length = 30)
    public String getTpeNombre() {
        return tpeNombre;
    }

    public void setTpeNombre(String tpeNombre) {
        this.tpeNombre = tpeNombre;
    }

    @OneToMany(mappedBy = "siiTipoPersonal")
    public List<SiiPersonalEmpresa> getSiiPersonalEmpresaList() {
        return siiPersonalEmpresaList;
    }

    public void setSiiPersonalEmpresaList(List<SiiPersonalEmpresa> siiPersonalEmpresaList) {
        this.siiPersonalEmpresaList = siiPersonalEmpresaList;
    }

    public SiiPersonalEmpresa addSiiPersonalEmpresa(SiiPersonalEmpresa siiPersonalEmpresa) {
        getSiiPersonalEmpresaList().add(siiPersonalEmpresa);
        siiPersonalEmpresa.setSiiTipoPersonal(this);
        return siiPersonalEmpresa;
    }

    public SiiPersonalEmpresa removeSiiPersonalEmpresa(SiiPersonalEmpresa siiPersonalEmpresa) {
        getSiiPersonalEmpresaList().remove(siiPersonalEmpresa);
        siiPersonalEmpresa.setSiiTipoPersonal(null);
        return siiPersonalEmpresa;
    }

    @OneToMany(mappedBy = "siiTipoPersonal")
    public List<SiiHistPersonalEmp> getSiiHistPersonalEmpList() {
        return siiHistPersonalEmpList;
    }

    public void setSiiHistPersonalEmpList(List<SiiHistPersonalEmp> siiHistPersonalEmpList) {
        this.siiHistPersonalEmpList = siiHistPersonalEmpList;
    }

    public SiiHistPersonalEmp addSiiHistPersonalEmp(SiiHistPersonalEmp siiHistPersonalEmp) {
        getSiiHistPersonalEmpList().add(siiHistPersonalEmp);
        siiHistPersonalEmp.setSiiTipoPersonal(this);
        return siiHistPersonalEmp;
    }

    public SiiHistPersonalEmp removeSiiHistPersonalEmp(SiiHistPersonalEmp siiHistPersonalEmp) {
        getSiiHistPersonalEmpList().remove(siiHistPersonalEmp);
        siiHistPersonalEmp.setSiiTipoPersonal(null);
        return siiHistPersonalEmp;
    }

    @OneToMany(mappedBy = "siiTipoPersonal")
    public List<SiiDocumentoRadicado> getSiiDocumentoRadicadoList() {
        return siiDocumentoRadicadoList;
    }

    public void setSiiDocumentoRadicadoList(List<SiiDocumentoRadicado> siiDocumentoRadicadoList) {
        this.siiDocumentoRadicadoList = siiDocumentoRadicadoList;
    }

    public SiiDocumentoRadicado addSiiDocumentoRadicado(SiiDocumentoRadicado siiDocumentoRadicado) {
        getSiiDocumentoRadicadoList().add(siiDocumentoRadicado);
        siiDocumentoRadicado.setSiiTipoPersonal(this);
        return siiDocumentoRadicado;
    }

    public SiiDocumentoRadicado removeSiiDocumentoRadicado(SiiDocumentoRadicado siiDocumentoRadicado) {
        getSiiDocumentoRadicadoList().remove(siiDocumentoRadicado);
        siiDocumentoRadicado.setSiiTipoPersonal(null);
        return siiDocumentoRadicado;
    }
}
