package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_RECAUDO_LINEA_BAN")
public class SiiRecaudoLineaBan implements Serializable {
    private static final long serialVersionUID = -3935343902944033484L;
    private Long rlbCodigo;
    private SiiOperacionLineaBan siiOperacionLineaBan;
    private List<SiiDetalleRecaudo> siiDetalleRecaudoList;
    private SiiOperacionLineaBan siiOperacionLineaBanAnula;
    private List<SiiDetalleRecaudo> siiDetalleRecaudoAnulaList;

    public SiiRecaudoLineaBan() {
    }

    public SiiRecaudoLineaBan(SiiOperacionLineaBan siiOperacionLineaBan, SiiOperacionLineaBan siiOperacionLineaBanAnula,
                              Long rlbCodigo) {
        this.siiOperacionLineaBan = siiOperacionLineaBan;
        this.siiOperacionLineaBanAnula = siiOperacionLineaBanAnula;
        this.rlbCodigo = rlbCodigo;
    }


    @Id
    @Column(name = "RLB_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RECAUDO_LINEA_BAN_COD")
    @SequenceGenerator(name = "SEQ_RECAUDO_LINEA_BAN_COD", sequenceName = "SEQ_RECAUDO_LINEA_BAN_COD",allocationSize=1)
    public Long getRlbCodigo() {
        return rlbCodigo;
    }

    public void setRlbCodigo(Long rlbCodigo) {
        this.rlbCodigo = rlbCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "OLB_CODIGO")
    public SiiOperacionLineaBan getSiiOperacionLineaBan() {
        return siiOperacionLineaBan;
    }

    public void setSiiOperacionLineaBan(SiiOperacionLineaBan siiOperacionLineaBan) {
        this.siiOperacionLineaBan = siiOperacionLineaBan;
    }

    @OneToMany(mappedBy = "siiRecaudoLineaBan")
    public List<SiiDetalleRecaudo> getSiiDetalleRecaudoList() {
        return siiDetalleRecaudoList;
    }

    public void setSiiDetalleRecaudoList(List<SiiDetalleRecaudo> siiDetalleRecaudoList) {
        this.siiDetalleRecaudoList = siiDetalleRecaudoList;
    }

    public SiiDetalleRecaudo addSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().add(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiRecaudoLineaBan(this);
        return siiDetalleRecaudo;
    }

    public SiiDetalleRecaudo removeSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().remove(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiRecaudoLineaBan(null);
        return siiDetalleRecaudo;
    }

    @OneToMany(mappedBy = "siiRecaudoLineaBanAnula")
    public List<SiiDetalleRecaudo> getSiiDetalleRecaudoAnulaList() {
        return siiDetalleRecaudoAnulaList;
    }

    public void setSiiDetalleRecaudoAnulaList(List<SiiDetalleRecaudo> siiDetalleRecaudoAnulaList) {
        this.siiDetalleRecaudoAnulaList = siiDetalleRecaudoAnulaList;
    }

    @ManyToOne
    @JoinColumn(name = "OLB_CODIGO_ANULA")
    public SiiOperacionLineaBan getSiiOperacionLineaBanAnula() {
        return siiOperacionLineaBanAnula;
    }

    public void setSiiOperacionLineaBanAnula(SiiOperacionLineaBan siiOperacionLineaBanAnula) {
        this.siiOperacionLineaBanAnula = siiOperacionLineaBanAnula;
    }
}
