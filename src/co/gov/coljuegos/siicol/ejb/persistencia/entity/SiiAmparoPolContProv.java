package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_AMPARO_POL_CONT_PROV")
public class SiiAmparoPolContProv implements Serializable {
    private static final long serialVersionUID = -436694541937730176L;
    private Long apcCodigo;
    private BigDecimal apcValorAseg;
    private Date apcVigenciaDes;
    private Date apcVigenciaHas;
    private SiiPolizaContProv siiPolizaContProv;
    private SiiTipoAmparo siiTipoAmparo;

    public SiiAmparoPolContProv() {
    }

    public SiiAmparoPolContProv(Long apcCodigo, BigDecimal apcValorAseg, Date apcVigenciaDes, Date apcVigenciaHas,
                                SiiPolizaContProv siiPolizaContProv, SiiTipoAmparo siiTipoAmparo) {
        this.apcCodigo = apcCodigo;
        this.apcValorAseg = apcValorAseg;
        this.apcVigenciaDes = apcVigenciaDes;
        this.apcVigenciaHas = apcVigenciaHas;
        this.siiPolizaContProv = siiPolizaContProv;
        this.siiTipoAmparo = siiTipoAmparo;
    }

    @Id
    @Column(name = "APC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AMP_POL_CON_PROV_COD")
    @SequenceGenerator(name = "SEQ_AMP_POL_CON_PROV_COD", sequenceName = "SEQ_AMP_POL_CON_PROV_COD",allocationSize=1)
    public Long getApcCodigo() {
        return apcCodigo;
    }

    public void setApcCodigo(Long apcCodigo) {
        this.apcCodigo = apcCodigo;
    }

    @Column(name = "APC_VALOR_ASEG", nullable = false)
    public BigDecimal getApcValorAseg() {
        return apcValorAseg;
    }

    public void setApcValorAseg(BigDecimal apcValorAseg) {
        this.apcValorAseg = apcValorAseg;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APC_VIGENCIA_DES", nullable = false)
    public Date getApcVigenciaDes() {
        return apcVigenciaDes;
    }

    public void setApcVigenciaDes(Date apcVigenciaDes) {
        this.apcVigenciaDes = apcVigenciaDes;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APC_VIGENCIA_HAS", nullable = false)
    public Date getApcVigenciaHas() {
        return apcVigenciaHas;
    }

    public void setApcVigenciaHas(Date apcVigenciaHas) {
        this.apcVigenciaHas = apcVigenciaHas;
    }


    @ManyToOne
    @JoinColumn(name = "PCP_CODIGO")
    public SiiPolizaContProv getSiiPolizaContProv() {
        return siiPolizaContProv;
    }

    public void setSiiPolizaContProv(SiiPolizaContProv siiPolizaContProv) {
        this.siiPolizaContProv = siiPolizaContProv;
    }

    @ManyToOne
    @JoinColumn(name = "TAM_CODIGO")
    public SiiTipoAmparo getSiiTipoAmparo() {
        return siiTipoAmparo;
    }

    public void setSiiTipoAmparo(SiiTipoAmparo siiTipoAmparo) {
        this.siiTipoAmparo = siiTipoAmparo;
    }
}
