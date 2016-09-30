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
@Table(name = "SII_DIRECCION_PERSONA")
public class SiiDireccionPersona implements Serializable {
    private static final long serialVersionUID = 2767528339507841489L;
    private Long dpeCodigo;
    private SiiPersona siiPersona;
    private SiiDireccion siiDireccion;
    private SiiUsuario siiUsuarioConec;
    private SiiUbicacion siiUbicacionMunicipio;

    public SiiDireccionPersona() {
    }

    public SiiDireccionPersona(SiiDireccion siiDireccion, Long dpeCodigo, SiiPersona siiPersona, SiiUbicacion siiUbicacionMunicipio, SiiUsuario siiUsuarioConec) {
        this.siiDireccion = siiDireccion;
        this.dpeCodigo = dpeCodigo;
        this.siiPersona = siiPersona;
        this.siiUbicacionMunicipio = siiUbicacionMunicipio;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "DPE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DIRECCION_PERSONA_COD")
    @SequenceGenerator(name = "SEQ_DIRECCION_PERSONA_COD", sequenceName = "SEQ_DIRECCION_PERSONA_COD",allocationSize=1)
    public Long getDpeCodigo() {
        return dpeCodigo;
    }

    public void setDpeCodigo(Long dpeCodigo) {
        this.dpeCodigo = dpeCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "DIR_CODIGO")
    public SiiDireccion getSiiDireccion() {
        return siiDireccion;
    }

    public void setSiiDireccion(SiiDireccion siiDireccion) {
        this.siiDireccion = siiDireccion;
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
    @JoinColumn(name = "UBI_CODIGO")
    public SiiUbicacion getSiiUbicacionMunicipio() {
        return siiUbicacionMunicipio;
    }

    public void setSiiUbicacionMunicipio(SiiUbicacion siiUbicacionMunicipio) {
        this.siiUbicacionMunicipio = siiUbicacionMunicipio;
    }
}
