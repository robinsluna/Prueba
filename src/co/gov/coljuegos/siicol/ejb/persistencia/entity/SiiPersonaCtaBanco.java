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
@Table(name = "SII_PERSONA_CTA_BANCO")
public class SiiPersonaCtaBanco implements Serializable {
    private static final long serialVersionUID = -5196885024313996077L;
    private Long pcbCodigo;
    private SiiCuentaBancoPersona siiCuentaBancoPersona;
    private SiiPersona siiPersona;

    public SiiPersonaCtaBanco() {
    }

    public SiiPersonaCtaBanco(SiiCuentaBancoPersona siiCuentaBancoPersona, Long pcbCodigo, SiiPersona siiPersona) {
        this.siiCuentaBancoPersona = siiCuentaBancoPersona;
        this.pcbCodigo = pcbCodigo;
        this.siiPersona = siiPersona;
    }


    @Id
    @Column(name = "PCB_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PERSONA_CTA_BANCO_COD")
    @SequenceGenerator(name = "SEQ_PERSONA_CTA_BANCO_COD", sequenceName = "SEQ_PERSONA_CTA_BANCO_COD",allocationSize=1)
    public Long getPcbCodigo() {
        return pcbCodigo;
    }

    public void setPcbCodigo(Long pcbCodigo) {
        this.pcbCodigo = pcbCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "CBP_CODIGO")
    public SiiCuentaBancoPersona getSiiCuentaBancoPersona() {
        return siiCuentaBancoPersona;
    }

    public void setSiiCuentaBancoPersona(SiiCuentaBancoPersona siiCuentaBancoPersona) {
        this.siiCuentaBancoPersona = siiCuentaBancoPersona;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }
}
