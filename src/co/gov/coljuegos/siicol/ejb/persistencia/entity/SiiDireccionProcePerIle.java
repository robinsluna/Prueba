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
@Table(name = "SII_DIRECCION_PROCE_PER_ILE")
public class SiiDireccionProcePerIle implements Serializable {
    private static final long serialVersionUID = -6516424766794988613L;
    private Long dipCodigo;
    private SiiUbicacion siiUbicacion;
    private SiiPersonaInvestProIle siiPersonaInvestProIle;
    private SiiDireccion siiDireccion;
    private SiiUsuario siiUsuarioConec;

    public SiiDireccionProcePerIle() {
    }

    public SiiDireccionProcePerIle(Long dipCodigo, SiiDireccion siiDireccion, SiiPersonaInvestProIle siiPersonaInvestProIle, SiiUbicacion siiUbicacion, SiiUsuario siiUsuarioConec) {
        this.dipCodigo = dipCodigo;
        this.siiDireccion = siiDireccion;
        this.siiPersonaInvestProIle = siiPersonaInvestProIle;
        this.siiUbicacion = siiUbicacion;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Id
    @Column(name = "DIP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DIREC_PROCE_PER_ILE_COD")
    @SequenceGenerator(name = "SEQ_DIREC_PROCE_PER_ILE_COD", sequenceName = "SEQ_DIREC_PROCE_PER_ILE_COD",allocationSize=1)
    public Long getDipCodigo() {
        return dipCodigo;
    }

    public void setDipCodigo(Long dipCodigo) {
        this.dipCodigo = dipCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO")
    public SiiUbicacion getSiiUbicacion() {
        return siiUbicacion;
    }

    public void setSiiUbicacion(SiiUbicacion siiUbicacion) {
        this.siiUbicacion = siiUbicacion;
    }

    @ManyToOne
    @JoinColumn(name = "PIP_CODIGO")
    public SiiPersonaInvestProIle getSiiPersonaInvestProIle() {
        return siiPersonaInvestProIle;
    }

    public void setSiiPersonaInvestProIle(SiiPersonaInvestProIle siiPersonaInvestProIle) {
        this.siiPersonaInvestProIle = siiPersonaInvestProIle;
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
}
