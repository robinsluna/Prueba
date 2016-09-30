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
@Table(name = "SII_RESPONSAB_REGLA")
public class SiiResponsabRegla implements Serializable {
    private static final long serialVersionUID = 8374891710736333915L;
    private Long rreCodigo;
    private SiiResponsabilidadDian siiResponsabilidadDian;
    private SiiReglaImpuestos siiReglaImpuestos;

    public SiiResponsabRegla() {
    }

    public SiiResponsabRegla(SiiResponsabilidadDian siiResponsabilidadDian, SiiReglaImpuestos siiReglaImpuestos,
                             Long rreCodigo) {
        this.siiResponsabilidadDian = siiResponsabilidadDian;
        this.siiReglaImpuestos = siiReglaImpuestos;
        this.rreCodigo = rreCodigo;
    }


    @Id
    @Column(name = "RRE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESPONSAB_REGLA_COD")
    @SequenceGenerator(name = "SEQ_RESPONSAB_REGLA_COD", sequenceName = "SEQ_RESPONSAB_REGLA_COD",allocationSize=1)
    public Long getRreCodigo() {
        return rreCodigo;
    }

    public void setRreCodigo(Long rreCodigo) {
        this.rreCodigo = rreCodigo;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "RDI_CODIGO")
    public SiiResponsabilidadDian getSiiResponsabilidadDian() {
        return siiResponsabilidadDian;
    }

    public void setSiiResponsabilidadDian(SiiResponsabilidadDian siiResponsabilidadDian) {
        this.siiResponsabilidadDian = siiResponsabilidadDian;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "RIM_CODIGO")
    public SiiReglaImpuestos getSiiReglaImpuestos() {
        return siiReglaImpuestos;
    }

    public void setSiiReglaImpuestos(SiiReglaImpuestos siiReglaImpuestos) {
        this.siiReglaImpuestos = siiReglaImpuestos;
    }
}
