package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_GRAVAMEN_MOV_FINANC")
public class SiiGravamenMovFinanc implements Serializable {
    private static final long serialVersionUID = 3076771186113171176L;
    private String gmfActivo;
    private Long gmfCodigo;
    private Date gmfFechaReg;
    private BigDecimal gmfValor;
    private List<SiiDetalleRubroCdp> siiDetalleRubroCdpList;

    public SiiGravamenMovFinanc() {
    }

    public SiiGravamenMovFinanc(String gmfActivo, Long gmfCodigo, Date gmfFechaReg, BigDecimal gmfValor) {
        this.gmfActivo = gmfActivo;
        this.gmfCodigo = gmfCodigo;
        this.gmfFechaReg = gmfFechaReg;
        this.gmfValor = gmfValor;
    }

    @Column(name = "GMF_ACTIVO", nullable = false, length = 1)
    public String getGmfActivo() {
        return gmfActivo;
    }

    public void setGmfActivo(String gmfActivo) {
        this.gmfActivo = gmfActivo;
    }

    @Id
    @Column(name = "GMF_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GMF_COD")
    @SequenceGenerator(name = "SEQ_GMF_COD", sequenceName = "SEQ_GMF_COD",allocationSize=1)
    public Long getGmfCodigo() {
        return gmfCodigo;
    }

    public void setGmfCodigo(Long gmfCodigo) {
        this.gmfCodigo = gmfCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GMF_FECHA_REG", nullable = false)
    public Date getGmfFechaReg() {
        return gmfFechaReg;
    }

    public void setGmfFechaReg(Date gmfFechaReg) {
        this.gmfFechaReg = gmfFechaReg;
    }

    @Column(name = "GMF_VALOR", nullable = false)
    public BigDecimal getGmfValor() {
        return gmfValor;
    }

    public void setGmfValor(BigDecimal gmfValor) {
        this.gmfValor = gmfValor;
    }

    @OneToMany(mappedBy = "siiGravamenMovFinanc")
    public List<SiiDetalleRubroCdp> getSiiDetalleRubroCdpList() {
        return siiDetalleRubroCdpList;
    }

    public void setSiiDetalleRubroCdpList(List<SiiDetalleRubroCdp> siiDetalleRubroCdpList) {
        this.siiDetalleRubroCdpList = siiDetalleRubroCdpList;
    }

    public SiiDetalleRubroCdp addSiiDetalleRubroCdp(SiiDetalleRubroCdp siiDetalleRubroCdp) {
        getSiiDetalleRubroCdpList().add(siiDetalleRubroCdp);
        siiDetalleRubroCdp.setSiiGravamenMovFinanc(this);
        return siiDetalleRubroCdp;
    }

    public SiiDetalleRubroCdp removeSiiDetalleRubroCdp(SiiDetalleRubroCdp siiDetalleRubroCdp) {
        getSiiDetalleRubroCdpList().remove(siiDetalleRubroCdp);
        siiDetalleRubroCdp.setSiiGravamenMovFinanc(null);
        return siiDetalleRubroCdp;
    }
}
