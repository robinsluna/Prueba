package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_DETALLE_TRASL_BANC")
public class SiiDetalleTraslBanc implements Serializable {
    private static final long serialVersionUID = -6437402135073689265L;
    private Long dtbCodigo;
    private String dtbConcepto;
    private SiiTrasladoBancario siiTrasladoBancario;
    private SiiRifaPromocional siiRifaPromocional;

    public SiiDetalleTraslBanc() {
    }

    public SiiDetalleTraslBanc(Long dtbCodigo, String dtbConcepto, SiiRifaPromocional siiRifaPromocional,
                               SiiTrasladoBancario siiTrasladoBancario) {
        this.dtbCodigo = dtbCodigo;
        this.dtbConcepto = dtbConcepto;
        this.siiRifaPromocional = siiRifaPromocional;
        this.siiTrasladoBancario = siiTrasladoBancario;
    }

    @Id
    @Column(name = "DTB_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DETALLE_TRASL_BANC_COD")
    @SequenceGenerator(name = "SEQ_DETALLE_TRASL_BANC_COD", sequenceName = "SEQ_DETALLE_TRASL_BANC_COD",allocationSize=1)
    public Long getDtbCodigo() {
        return dtbCodigo;
    }

    public void setDtbCodigo(Long dtbCodigo) {
        this.dtbCodigo = dtbCodigo;
    }

    @Column(name = "DTB_CONCEPTO", nullable = false, length = 3)
    public String getDtbConcepto() {
        return dtbConcepto;
    }

    public void setDtbConcepto(String dtbConcepto) {
        this.dtbConcepto = dtbConcepto;
    }


    @ManyToOne
    @JoinColumn(name = "TBA_CODIGO")
    public SiiTrasladoBancario getSiiTrasladoBancario() {
        return siiTrasladoBancario;
    }

    public void setSiiTrasladoBancario(SiiTrasladoBancario siiTrasladoBancario) {
        this.siiTrasladoBancario = siiTrasladoBancario;
    }

    @ManyToOne
    @JoinColumn(name = "RFP_CODIGO")
    public SiiRifaPromocional getSiiRifaPromocional() {
        return siiRifaPromocional;
    }

    public void setSiiRifaPromocional(SiiRifaPromocional siiRifaPromocional) {
        this.siiRifaPromocional = siiRifaPromocional;
    }
}
