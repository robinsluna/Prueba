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
@Table(name = "SII_RESPON_DIAN_PERSONA")
public class SiiResponDianPersona implements Serializable {
    private static final long serialVersionUID = 1445687952171422726L;
    private Long rdpCodigo;
    private SiiResponsabilidadDian siiResponsabilidadDian;
    private SiiPersona siiPersona;

    public SiiResponDianPersona() {
    }

    public SiiResponDianPersona(SiiPersona siiPersona, SiiResponsabilidadDian siiResponsabilidadDian, Long rdpCodigo) {
        this.siiPersona = siiPersona;
        this.siiResponsabilidadDian = siiResponsabilidadDian;
        this.rdpCodigo = rdpCodigo;
    }


    @Id
    @Column(name = "RDP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESPON_DIAN_PERS_COD")
    @SequenceGenerator(name = "SEQ_RESPON_DIAN_PERS_COD", sequenceName = "SEQ_RESPON_DIAN_PERS_COD",allocationSize=1)
    public Long getRdpCodigo() {
        return rdpCodigo;
    }

    public void setRdpCodigo(Long rdpCodigo) {
        this.rdpCodigo = rdpCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "RDI_CODIGO")
    public SiiResponsabilidadDian getSiiResponsabilidadDian() {
        return siiResponsabilidadDian;
    }

    public void setSiiResponsabilidadDian(SiiResponsabilidadDian siiResponsabilidadDian) {
        this.siiResponsabilidadDian = siiResponsabilidadDian;
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
