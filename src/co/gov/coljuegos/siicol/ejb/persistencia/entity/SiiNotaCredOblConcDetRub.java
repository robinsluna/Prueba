package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

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
@Table(name = "SII_NOTA_CRED_OBL_CONC_DET_RUB")
public class SiiNotaCredOblConcDetRub implements Serializable {
    private static final long serialVersionUID = 5587095820886518525L;
    private Long ndrCodigo;
    private BigDecimal ndrValor;
    private SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp;
    private SiiNotaCredito siiNotaCredito;

    public SiiNotaCredOblConcDetRub() {
    }

    public SiiNotaCredOblConcDetRub(Long ndrCodigo, BigDecimal ndrValor,
                                    SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp) {
        this.ndrCodigo = ndrCodigo;
        this.ndrValor = ndrValor;
        this.siiOblConcRpDetRubCdp = siiOblConcRpDetRubCdp;
    }


    @Id
    @Column(name = "NDR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_NOT_CRED_OBL_CON_DET_COD")
    @SequenceGenerator(name = "SEQ_NOT_CRED_OBL_CON_DET_COD", sequenceName = "SEQ_NOT_CRED_OBL_CON_DET_COD",allocationSize=1)
    public Long getNdrCodigo() {
        return ndrCodigo;
    }

    public void setNdrCodigo(Long ndrCodigo) {
        this.ndrCodigo = ndrCodigo;
    }

    @Column(name = "NDR_VALOR", nullable = false)
    public BigDecimal getNdrValor() {
        return ndrValor;
    }

    public void setNdrValor(BigDecimal ndrValor) {
        this.ndrValor = ndrValor;
    }


    @ManyToOne
    @JoinColumn(name = "OCR_CODIGO")
    public SiiOblConcRpDetRubCdp getSiiOblConcRpDetRubCdp() {
        return siiOblConcRpDetRubCdp;
    }

    public void setSiiOblConcRpDetRubCdp(SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp) {
        this.siiOblConcRpDetRubCdp = siiOblConcRpDetRubCdp;
    }

    @ManyToOne
    @JoinColumn(name = "NCR_CODIGO")
    public SiiNotaCredito getSiiNotaCredito() {
        return siiNotaCredito;
    }

    public void setSiiNotaCredito(SiiNotaCredito siiNotaCredito) {
        this.siiNotaCredito = siiNotaCredito;
    }
}
