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
@Table(name = "SII_RP_DET_RUB_REINT_ING_PAG")
public class SiiRpDetRubReintIngPag implements Serializable {
    private static final long serialVersionUID = -7147846495563690869L;
    private Long rinCodigo;
    private SiiReintegroIngresoPag siiReintegroIngresoPag;
    private SiiUsuario siiUsuarioConec;
    private SiiRpDetRubroCdp siiRpDetRubroCdp;
    private BigDecimal rinValorReintegro;

    public SiiRpDetRubReintIngPag() {
    }

    public SiiRpDetRubReintIngPag(SiiRpDetRubroCdp siiRpDetRubroCdp, Long rinCodigo, SiiReintegroIngresoPag siiReintegroIngresoPag, SiiUsuario siiUsuarioConec) {
        this.siiRpDetRubroCdp = siiRpDetRubroCdp;
        this.rinCodigo = rinCodigo;
        this.siiReintegroIngresoPag = siiReintegroIngresoPag;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "RIN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RP_DRUB_REI_ING_PAG_COD_")
    @SequenceGenerator(name = "SEQ_RP_DRUB_REI_ING_PAG_COD_", sequenceName = "SEQ_RP_DRUB_REI_ING_PAG_COD_",allocationSize=1)
    public Long getRinCodigo() {
        return rinCodigo;
    }

    public void setRinCodigo(Long rinCodigo) {
        this.rinCodigo = rinCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "RIP_CODIGO")
    public SiiReintegroIngresoPag getSiiReintegroIngresoPag() {
        return siiReintegroIngresoPag;
    }

    public void setSiiReintegroIngresoPag(SiiReintegroIngresoPag siiReintegroIngresoPag) {
        this.siiReintegroIngresoPag = siiReintegroIngresoPag;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @ManyToOne
    @JoinColumn(name = "RDR_CODIGO")
    public SiiRpDetRubroCdp getSiiRpDetRubroCdp() {
        return siiRpDetRubroCdp;
    }

    public void setSiiRpDetRubroCdp(SiiRpDetRubroCdp siiRpDetRubroCdp) {
        this.siiRpDetRubroCdp = siiRpDetRubroCdp;
    }

    @Column(name = "RIN_VALOR_REINTEGRO")
    public BigDecimal getRinValorReintegro() {
        return rinValorReintegro;
    }
    
    public void setRinValorReintegro(BigDecimal rinValorReintegro) {
        this.rinValorReintegro = rinValorReintegro;
    }
}
