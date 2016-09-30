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
@Table(name = "SII_HISTORIAL_PERMISO")
public class SiiHistorialPermiso implements Serializable {
    private static final long serialVersionUID = -4336369041176680265L;
    private String hipActivo;
    private Long hipCodigo;
    private SiiUsuario siiUsuarioConec;
    private SiiUsuario siiUsuario;
    private SiiPermiso siiPermiso;
    private SiiModulo siiModulo;
    private SiiHistorialRol siiHistorialRol;

    public SiiHistorialPermiso() {
    }

    public SiiHistorialPermiso(String hipActivo, Long hipCodigo, SiiHistorialRol siiHistorialRol, SiiModulo siiModulo, SiiPermiso siiPermiso, SiiUsuario siiUsuario, SiiUsuario siiUsuarioConec) {
        this.hipActivo = hipActivo;
        this.hipCodigo = hipCodigo;
        this.siiHistorialRol = siiHistorialRol;
        this.siiModulo = siiModulo;
        this.siiPermiso = siiPermiso;
        this.siiUsuario = siiUsuario;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Column(name = "HIP_ACTIVO", nullable = false, length = 1)
    public String getHipActivo() {
        return hipActivo;
    }

    public void setHipActivo(String hipActivo) {
        this.hipActivo = hipActivo;
    }

    @Id
    @Column(name = "HIP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HISTORIAL_PERMISO_COD")
    @SequenceGenerator(name = "SEQ_HISTORIAL_PERMISO_COD", sequenceName = "SEQ_HISTORIAL_PERMISO_COD",allocationSize=1)
    public Long getHipCodigo() {
        return hipCodigo;
    }

    public void setHipCodigo(Long hipCodigo) {
        this.hipCodigo = hipCodigo;
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
    @JoinColumn(name = "USU_CODIGO")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "PMS_CODIGO")
    public SiiPermiso getSiiPermiso() {
        return siiPermiso;
    }

    public void setSiiPermiso(SiiPermiso siiPermiso) {
        this.siiPermiso = siiPermiso;
    }

    @ManyToOne
    @JoinColumn(name = "MOD_CODIGO")
    public SiiModulo getSiiModulo() {
        return siiModulo;
    }

    public void setSiiModulo(SiiModulo siiModulo) {
        this.siiModulo = siiModulo;
    }

    @ManyToOne
    @JoinColumn(name = "HRO_CODIGO")
    public SiiHistorialRol getSiiHistorialRol() {
        return siiHistorialRol;
    }

    public void setSiiHistorialRol(SiiHistorialRol siiHistorialRol) {
        this.siiHistorialRol = siiHistorialRol;
    }
}
