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
@Table(name = "SII_USUARIO_ROL")
public class SiiUsuarioRol implements Serializable {
    private static final long serialVersionUID = -1130711600573943597L;
    private Long uroCodigo;
    private SiiUsuario siiUsuario;
    private SiiRol siiRol1;

    public SiiUsuarioRol() {
    }

    public SiiUsuarioRol(SiiRol siiRol1, Long uroCodigo, SiiUsuario siiUsuario) {
        this.siiRol1 = siiRol1;
        this.uroCodigo = uroCodigo;
        this.siiUsuario = siiUsuario;
    }


    @Id
    @Column(name = "URO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USUARIO_ROL_CODIGO")
    @SequenceGenerator(name = "SEQ_USUARIO_ROL_CODIGO", sequenceName = "SEQ_USUARIO_ROL_CODIGO",allocationSize=1)
    public Long getUroCodigo() {
        return uroCodigo;
    }

    public void setUroCodigo(Long uroCodigo) {
        this.uroCodigo = uroCodigo;
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
    @JoinColumn(name = "ROL_CODIGO")
    public SiiRol getSiiRol1() {
        return siiRol1;
    }

    public void setSiiRol1(SiiRol siiRol1) {
        this.siiRol1 = siiRol1;
    }
}
