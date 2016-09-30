package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

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
@Table(name = "SII_SOLIC_PFCM_DETALLE")
public class SiiSolicPfcmDetalle implements Serializable {
    private static final long serialVersionUID = -9026388825321090510L;
    private Long spdCodigo;
    private BigDecimal spdValorAntic;
    private BigDecimal spdValorAplaz;
    private BigDecimal spdValorProgram;
    private SiiSolicitudPfcMens siiSolicitudPfcMens;
    private List<SiiModificPfcAnual> siiModificPfcAnualList;

    public SiiSolicPfcmDetalle() {
    }

    public SiiSolicPfcmDetalle(Long spdCodigo, BigDecimal spdValorAntic, BigDecimal spdValorAplaz, BigDecimal spdValorProgram,
                               SiiSolicitudPfcMens siiSolicitudPfcMens) {
        this.spdCodigo = spdCodigo;
        this.spdValorAntic = spdValorAntic;
        this.spdValorAplaz = spdValorAplaz;
        this.spdValorProgram = spdValorProgram;
        this.siiSolicitudPfcMens = siiSolicitudPfcMens;
    }

    @Id
    @Column(name = "SPD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SOLIC_PFCM_DETALLE")
    @SequenceGenerator(name = "SEQ_SOLIC_PFCM_DETALLE", sequenceName = "SEQ_SOLIC_PFCM_DETALLE",allocationSize=1)
    public Long getSpdCodigo() {
        return spdCodigo;
    }

    public void setSpdCodigo(Long spdCodigo) {
        this.spdCodigo = spdCodigo;
    }

    @Column(name = "SPD_VALOR_ANTIC")
    public BigDecimal getSpdValorAntic() {
        return spdValorAntic;
    }

    public void setSpdValorAntic(BigDecimal spdValorAntic) {
        this.spdValorAntic = spdValorAntic;
    }

    @Column(name = "SPD_VALOR_APLAZ")
    public BigDecimal getSpdValorAplaz() {
        return spdValorAplaz;
    }

    public void setSpdValorAplaz(BigDecimal spdValorAplaz) {
        this.spdValorAplaz = spdValorAplaz;
    }

    @Column(name = "SPD_VALOR_PROGRAM", nullable = false)
    public BigDecimal getSpdValorProgram() {
        return spdValorProgram;
    }

    public void setSpdValorProgram(BigDecimal spdValorProgram) {
        this.spdValorProgram = spdValorProgram;
    }


    @ManyToOne
    @JoinColumn(name = "SPF_CODIGO")
    public SiiSolicitudPfcMens getSiiSolicitudPfcMens() {
        return siiSolicitudPfcMens;
    }

    public void setSiiSolicitudPfcMens(SiiSolicitudPfcMens siiSolicitudPfcMens) {
        this.siiSolicitudPfcMens = siiSolicitudPfcMens;
    }

    @OneToMany(mappedBy = "siiSolicPfcmDetalle")
    public List<SiiModificPfcAnual> getSiiModificPfcAnualList() {
        return siiModificPfcAnualList;
    }

    public void setSiiModificPfcAnualList(List<SiiModificPfcAnual> siiModificPfcAnualList) {
        this.siiModificPfcAnualList = siiModificPfcAnualList;
    }

    public SiiModificPfcAnual addSiiModificPfcAnual(SiiModificPfcAnual siiModificPfcAnual) {
        getSiiModificPfcAnualList().add(siiModificPfcAnual);
        siiModificPfcAnual.setSiiSolicPfcmDetalle(this);
        return siiModificPfcAnual;
    }

    public SiiModificPfcAnual removeSiiModificPfcAnual(SiiModificPfcAnual siiModificPfcAnual) {
        getSiiModificPfcAnualList().remove(siiModificPfcAnual);
        siiModificPfcAnual.setSiiSolicPfcmDetalle(null);
        return siiModificPfcAnual;
    }
}
