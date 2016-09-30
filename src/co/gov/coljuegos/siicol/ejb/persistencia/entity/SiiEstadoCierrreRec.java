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
@Table(name = "SII_ESTADO_CIERRRE_REC")
public class SiiEstadoCierrreRec implements Serializable {
    private static final long serialVersionUID = 6333022655084185124L;
    private Long ecrCodigo;
    private String ecrNombre;
    private List<SiiCierreRecaudo> siiCierreRecaudoList;

    public SiiEstadoCierrreRec() {
    }

    public SiiEstadoCierrreRec(Long ecrCodigo, String ecrNombre) {
        this.ecrCodigo = ecrCodigo;
        this.ecrNombre = ecrNombre;
    }

    @Id
    @Column(name = "ECR_CODIGO", nullable = false)
    public Long getEcrCodigo() {
        return ecrCodigo;
    }

    public void setEcrCodigo(Long ecrCodigo) {
        this.ecrCodigo = ecrCodigo;
    }

    @Column(name = "ECR_NOMBRE", nullable = false, length = 30)
    public String getEcrNombre() {
        return ecrNombre;
    }

    public void setEcrNombre(String ecrNombre) {
        this.ecrNombre = ecrNombre;
    }

    @OneToMany(mappedBy = "siiEstadoCierrreRec")
    public List<SiiCierreRecaudo> getSiiCierreRecaudoList() {
        return siiCierreRecaudoList;
    }

    public void setSiiCierreRecaudoList(List<SiiCierreRecaudo> siiCierreRecaudoList) {
        this.siiCierreRecaudoList = siiCierreRecaudoList;
    }

    public SiiCierreRecaudo addSiiCierreRecaudo(SiiCierreRecaudo siiCierreRecaudo) {
        getSiiCierreRecaudoList().add(siiCierreRecaudo);
        siiCierreRecaudo.setSiiEstadoCierrreRec(this);
        return siiCierreRecaudo;
    }

    public SiiCierreRecaudo removeSiiCierreRecaudo(SiiCierreRecaudo siiCierreRecaudo) {
        getSiiCierreRecaudoList().remove(siiCierreRecaudo);
        siiCierreRecaudo.setSiiEstadoCierrreRec(null);
        return siiCierreRecaudo;
    }
}
