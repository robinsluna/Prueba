package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

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

@Entity
@Table(name = "SII_DISTRIBUCION_UBICA")
public class SiiDistribucionUbica implements Serializable {
    private static final long serialVersionUID = -379111557996443465L;
    private Long dubCodigo;
    private BigDecimal dubValor;
    private SiiDocumentoConpes siiDocumentoConpes;
    private SiiEnteTerritorial siiEnteTerritorial;

    public SiiDistribucionUbica() {
    }

    public SiiDistribucionUbica(SiiDocumentoConpes siiDocumentoConpes, Long dubCodigo, BigDecimal dubValor,
                                SiiEnteTerritorial siiEnteTerritorial) {
        this.siiDocumentoConpes = siiDocumentoConpes;
        this.dubCodigo = dubCodigo;
        this.dubValor = dubValor;
        this.siiEnteTerritorial = siiEnteTerritorial;
    }


    @Id
    @Column(name = "DUB_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DISTRIBUCION_UBICA_COD")
    @SequenceGenerator(name = "SEQ_DISTRIBUCION_UBICA_COD", sequenceName = "SEQ_DISTRIBUCION_UBICA_COD",allocationSize=1)
    public Long getDubCodigo() {
        return dubCodigo;
    }

    public void setDubCodigo(Long dubCodigo) {
        this.dubCodigo = dubCodigo;
    }

    @Column(name = "DUB_VALOR", nullable = false)
    public BigDecimal getDubValor() {
        return dubValor;
    }

    public void setDubValor(BigDecimal dubValor) {
        this.dubValor = dubValor;
    }


    @ManyToOne
    @JoinColumn(name = "DCN_CODIGO")
    public SiiDocumentoConpes getSiiDocumentoConpes() {
        return siiDocumentoConpes;
    }

    public void setSiiDocumentoConpes(SiiDocumentoConpes siiDocumentoConpes) {
        this.siiDocumentoConpes = siiDocumentoConpes;
    }


    @ManyToOne
    @JoinColumn(name = "ETI_CODIGO")
    public SiiEnteTerritorial getSiiEnteTerritorial() {
        return siiEnteTerritorial;
    }

    public void setSiiEnteTerritorial(SiiEnteTerritorial siiEnteTerritorial) {
        this.siiEnteTerritorial = siiEnteTerritorial;
    }
}
