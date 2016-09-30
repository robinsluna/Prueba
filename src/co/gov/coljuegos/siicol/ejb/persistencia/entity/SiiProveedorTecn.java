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
@Table(name = "SII_PROVEEDOR_TECN")
public class SiiProveedorTecn implements Serializable {
    private static final long serialVersionUID = -7972587104452298414L;
    private Long pteCodigo;
    private SiiPersona siiPersona;

    public SiiProveedorTecn() {
    }

    public SiiProveedorTecn(SiiPersona siiPersona, Long pteCodigo) {
        this.siiPersona = siiPersona;
        this.pteCodigo = pteCodigo;
    }


    @Id
    @Column(name = "PTE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROVEEDOR_TECN_COD")
    @SequenceGenerator(name = "SEQ_PROVEEDOR_TECN_COD", sequenceName = "SEQ_PROVEEDOR_TECN_COD",allocationSize=1)
    public Long getPteCodigo() {
        return pteCodigo;
    }

    public void setPteCodigo(Long pteCodigo) {
        this.pteCodigo = pteCodigo;
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
