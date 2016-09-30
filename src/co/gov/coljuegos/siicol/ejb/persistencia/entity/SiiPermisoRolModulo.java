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
@Table(name = "SII_PERMISO_ROL_MODULO")
public class SiiPermisoRolModulo implements Serializable {
    private static final long serialVersionUID = -8318424452715671175L;
    private Long prmCodigo;
    private SiiRol siiRol;
    private SiiModulo siiModulo1;
    private SiiPermiso siiPermiso;

    public SiiPermisoRolModulo() {
    }

    public SiiPermisoRolModulo(SiiModulo siiModulo1, SiiPermiso siiPermiso, Long prmCodigo, SiiRol siiRol) {
        this.siiModulo1 = siiModulo1;
        this.siiPermiso = siiPermiso;
        this.prmCodigo = prmCodigo;
        this.siiRol = siiRol;
    }


    @Id
    @Column(name = "PRM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PERMISO_ROL_MODULO")
    @SequenceGenerator(name = "SEQ_PERMISO_ROL_MODULO", sequenceName = "SEQ_PERMISO_ROL_MODULO",allocationSize=1)
    public Long getPrmCodigo() {
        return prmCodigo;
    }

    public void setPrmCodigo(Long prmCodigo) {
        this.prmCodigo = prmCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "ROL_CODIGO")
    public SiiRol getSiiRol() {
        return siiRol;
    }

    public void setSiiRol(SiiRol siiRol) {
        this.siiRol = siiRol;
    }

    @ManyToOne
    @JoinColumn(name = "MOD_CODIGO")
    public SiiModulo getSiiModulo1() {
        return siiModulo1;
    }

    public void setSiiModulo1(SiiModulo siiModulo1) {
        this.siiModulo1 = siiModulo1;
    }

    @ManyToOne
    @JoinColumn(name = "PMS_CODIGO")
    public SiiPermiso getSiiPermiso() {
        return siiPermiso;
    }

    public void setSiiPermiso(SiiPermiso siiPermiso) {
        this.siiPermiso = siiPermiso;
    }
}
