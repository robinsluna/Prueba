package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_POLIZA_REQUISITOS_POL")
public class SiiPolizaRequisitosPol implements Serializable {
    private static final long serialVersionUID = -4533421006272519784L;
    private Long prpCodigo;
    private String prpCumple;
    private SiiPolizaContrat siiPolizaContrat;
    private SiiRequisitosPolizaCon siiRequisitosPolizaCon;

    public SiiPolizaRequisitosPol() {
    }

    public SiiPolizaRequisitosPol(SiiPolizaContrat siiPolizaContrat, Long prpCodigo, String prpCumple,
                                  SiiRequisitosPolizaCon siiRequisitosPolizaCon) {
        this.siiPolizaContrat = siiPolizaContrat;
        this.prpCodigo = prpCodigo;
        this.prpCumple = prpCumple;
        this.siiRequisitosPolizaCon = siiRequisitosPolizaCon;
    }


    @Id
    @Column(name = "PRP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_POLIZA_REQUISITOS_POL_COD")
    @SequenceGenerator(name = "SEQ_POLIZA_REQUISITOS_POL_COD", sequenceName = "SEQ_POLIZA_REQUISITOS_POL_COD",allocationSize=1)
    public Long getPrpCodigo() {
        return prpCodigo;
    }

    public void setPrpCodigo(Long prpCodigo) {
        this.prpCodigo = prpCodigo;
    }

    @Column(name = "PRP_CUMPLE", nullable = false, length = 1)
    public String getPrpCumple() {
        return prpCumple;
    }

    public void setPrpCumple(String prpCumple) {
        this.prpCumple = prpCumple;
    }


    @ManyToOne
    @JoinColumn(name = "PCC_CODIGO")
    public SiiPolizaContrat getSiiPolizaContrat() {
        return siiPolizaContrat;
    }

    public void setSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        this.siiPolizaContrat = siiPolizaContrat;
    }

    @ManyToOne
    @JoinColumn(name = "RPC_CODIGO")
    public SiiRequisitosPolizaCon getSiiRequisitosPolizaCon() {
        return siiRequisitosPolizaCon;
    }

    public void setSiiRequisitosPolizaCon(SiiRequisitosPolizaCon siiRequisitosPolizaCon) {
        this.siiRequisitosPolizaCon = siiRequisitosPolizaCon;
    }
}
