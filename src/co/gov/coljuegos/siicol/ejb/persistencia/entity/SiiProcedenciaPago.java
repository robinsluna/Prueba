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
@Table(name = "SII_PROCEDENCIA_PAGO")
public class SiiProcedenciaPago implements Serializable {
    private static final long serialVersionUID = -4182552253351983924L;
    private String ppaCodigo;
    private String ppaNombre;
    private List<SiiDetalleRecaudo> siiDetalleRecaudoList;

    public SiiProcedenciaPago() {
    }

    public SiiProcedenciaPago(String ppaCodigo, String ppaNombre) {
        this.ppaCodigo = ppaCodigo;
        this.ppaNombre = ppaNombre;
    }

    @Id
    @Column(name = "PPA_CODIGO", nullable = false, length = 2)
    public String getPpaCodigo() {
        return ppaCodigo;
    }

    public void setPpaCodigo(String ppaCodigo) {
        this.ppaCodigo = ppaCodigo;
    }

    @Column(name = "PPA_NOMBRE", nullable = false, length = 30)
    public String getPpaNombre() {
        return ppaNombre;
    }

    public void setPpaNombre(String ppaNombre) {
        this.ppaNombre = ppaNombre;
    }

    @OneToMany(mappedBy = "siiProcedenciaPago")
    public List<SiiDetalleRecaudo> getSiiDetalleRecaudoList() {
        return siiDetalleRecaudoList;
    }

    public void setSiiDetalleRecaudoList(List<SiiDetalleRecaudo> siiDetalleRecaudoList) {
        this.siiDetalleRecaudoList = siiDetalleRecaudoList;
    }

    public SiiDetalleRecaudo addSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().add(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiProcedenciaPago(this);
        return siiDetalleRecaudo;
    }

    public SiiDetalleRecaudo removeSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().remove(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiProcedenciaPago(null);
        return siiDetalleRecaudo;
    }
}
