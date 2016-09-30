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
@Table(name = "SII_CDP_RP")
public class SiiCdpRp implements Serializable {
    private static final long serialVersionUID = -8263409205449134365L;
    private Long crpCodigo;
    private SiiRp siiRp;
    private SiiCdp siiCdp;

    public SiiCdpRp() {
    }

    public SiiCdpRp(SiiCdp siiCdp, Long crpCodigo, SiiRp siiRp) {
        this.siiCdp = siiCdp;
        this.crpCodigo = crpCodigo;
        this.siiRp = siiRp;
    }


    @Id
    @Column(name = "CRP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CDP_RP_COD")
    @SequenceGenerator(name = "SEQ_CDP_RP_COD", sequenceName = "SEQ_CDP_RP_COD",allocationSize=1)
    public Long getCrpCodigo() {
        return crpCodigo;
    }

    public void setCrpCodigo(Long crpCodigo) {
        this.crpCodigo = crpCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "RP_CODIGO")
    public SiiRp getSiiRp() {
        return siiRp;
    }

    public void setSiiRp(SiiRp siiRp) {
        this.siiRp = siiRp;
    }

    @ManyToOne
    @JoinColumn(name = "CDP_CODIGO")
    public SiiCdp getSiiCdp() {
        return siiCdp;
    }

    public void setSiiCdp(SiiCdp siiCdp) {
        this.siiCdp = siiCdp;
    }
}
