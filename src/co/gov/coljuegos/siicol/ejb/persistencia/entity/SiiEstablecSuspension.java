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
@Table(name = "SII_ESTABLEC_SUSPENSION")
public class SiiEstablecSuspension implements Serializable {
    private static final long serialVersionUID = -5124090347122628575L;
    private Long esuCodigo;
    private SiiSuspensionContr siiSuspensionContr;
    private SiiEstablecimiento siiEstablecimiento;

    public SiiEstablecSuspension() {
    }

    public SiiEstablecSuspension(SiiEstablecimiento siiEstablecimiento, Long esuCodigo, SiiSuspensionContr siiSuspensionContr) {
        this.siiEstablecimiento = siiEstablecimiento;
        this.esuCodigo = esuCodigo;
        this.siiSuspensionContr = siiSuspensionContr;
    }


    @Id
    @Column(name = "ESU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTABLEC_SUSPENSION_COD")
    @SequenceGenerator(name = "SEQ_ESTABLEC_SUSPENSION_COD", sequenceName = "SEQ_ESTABLEC_SUSPENSION_COD",allocationSize=1)
    public Long getEsuCodigo() {
        return esuCodigo;
    }

    public void setEsuCodigo(Long esuCodigo) {
        this.esuCodigo = esuCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "SCO_CODIGO")
    public SiiSuspensionContr getSiiSuspensionContr() {
        return siiSuspensionContr;
    }

    public void setSiiSuspensionContr(SiiSuspensionContr siiSuspensionContr) {
        this.siiSuspensionContr = siiSuspensionContr;
    }

    @ManyToOne
    @JoinColumn(name = "EST_CODIGO")
    public SiiEstablecimiento getSiiEstablecimiento() {
        return siiEstablecimiento;
    }

    public void setSiiEstablecimiento(SiiEstablecimiento siiEstablecimiento) {
        this.siiEstablecimiento = siiEstablecimiento;
    }
}
