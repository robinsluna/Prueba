package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_INSTRUMENTO")
public class SiiTipoInstrumento implements Serializable {
    private static final long serialVersionUID = -1303816148978727924L;
    private Long tinCodigo;
    private String tinNombre;
    private List<SiiInstrumento> siiInstrumentoList;
    private List<SiiTarifaIlegalidad> siiTarifaIlegalidadList;
    private List<SiiElementoProcesoIle> siiElementoProcesoIleList;

    public SiiTipoInstrumento() {
    }

    public SiiTipoInstrumento(Long tinCodigo, String tinNombre) {
        this.tinCodigo = tinCodigo;
        this.tinNombre = tinNombre;
    }

    @Id
    @Column(name = "TIN_CODIGO", nullable = false)
    public Long getTinCodigo() {
        return tinCodigo;
    }

    public void setTinCodigo(Long tinCodigo) {
        this.tinCodigo = tinCodigo;
    }

    @Column(name = "TIN_NOMBRE", nullable = false, length = 100)
    public String getTinNombre() {
        return tinNombre;
    }

    public void setTinNombre(String tinNombre) {
        this.tinNombre = tinNombre;
    }

    @OneToMany(mappedBy = "siiTipoInstrumento")
    public List<SiiInstrumento> getSiiInstrumentoList() {
        return siiInstrumentoList;
    }

    public void setSiiInstrumentoList(List<SiiInstrumento> siiInstrumentoList) {
        this.siiInstrumentoList = siiInstrumentoList;
    }

    public SiiInstrumento addSiiInstrumento(SiiInstrumento siiInstrumento) {
        getSiiInstrumentoList().add(siiInstrumento);
        siiInstrumento.setSiiTipoInstrumento(this);
        return siiInstrumento;
    }

    public SiiInstrumento removeSiiInstrumento(SiiInstrumento siiInstrumento) {
        getSiiInstrumentoList().remove(siiInstrumento);
        siiInstrumento.setSiiTipoInstrumento(null);
        return siiInstrumento;
    }

    @OneToMany(mappedBy = "siiTipoInstrumento")
    public List<SiiTarifaIlegalidad> getSiiTarifaIlegalidadList() {
        return siiTarifaIlegalidadList;
    }

    public void setSiiTarifaIlegalidadList(List<SiiTarifaIlegalidad> siiTarifaIlegalidadList) {
        this.siiTarifaIlegalidadList = siiTarifaIlegalidadList;
    }

    public SiiTarifaIlegalidad addSiiTarifaIlegalidad(SiiTarifaIlegalidad siiTarifaIlegalidad) {
        getSiiTarifaIlegalidadList().add(siiTarifaIlegalidad);
        siiTarifaIlegalidad.setSiiTipoInstrumento(this);
        return siiTarifaIlegalidad;
    }

    public SiiTarifaIlegalidad removeSiiTarifaIlegalidad(SiiTarifaIlegalidad siiTarifaIlegalidad) {
        getSiiTarifaIlegalidadList().remove(siiTarifaIlegalidad);
        siiTarifaIlegalidad.setSiiTipoInstrumento(null);
        return siiTarifaIlegalidad;
    }

    @OneToMany(mappedBy = "siiTipoInstrumento")
    public List<SiiElementoProcesoIle> getSiiElementoProcesoIleList() {
        return siiElementoProcesoIleList;
    }

    public void setSiiElementoProcesoIleList(List<SiiElementoProcesoIle> siiElementoProcesoIleList) {
        this.siiElementoProcesoIleList = siiElementoProcesoIleList;
    }

    public SiiElementoProcesoIle addSiiElementoProcesoIle(SiiElementoProcesoIle siiElementoProcesoIle) {
        getSiiElementoProcesoIleList().add(siiElementoProcesoIle);
        siiElementoProcesoIle.setSiiTipoInstrumento(this);
        return siiElementoProcesoIle;
    }

    public SiiElementoProcesoIle removeSiiElementoProcesoIle(SiiElementoProcesoIle siiElementoProcesoIle) {
        getSiiElementoProcesoIleList().remove(siiElementoProcesoIle);
        siiElementoProcesoIle.setSiiTipoInstrumento(null);
        return siiElementoProcesoIle;
    }
}
