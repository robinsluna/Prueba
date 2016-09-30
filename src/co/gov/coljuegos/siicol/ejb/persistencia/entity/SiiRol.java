package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ROL")
public class SiiRol implements Serializable {
    private static final long serialVersionUID = 174971009944161867L;
    private String rolActivo;
    private Long rolCodigo;
    private String rolDescripcion;
    private String rolNombre;
    private List<SiiPermisoRolModulo> siiPermisoRolModuloList;
    private List<SiiUsuarioRol> siiUsuarioRolList1;
    private List<SiiHistorialRol> siiHistorialRolList;

    public SiiRol() {
    }

    public SiiRol(String rolActivo, Long rolCodigo, String rolDescripcion, String rolNombre) {
        this.rolActivo = rolActivo;
        this.rolCodigo = rolCodigo;
        this.rolDescripcion = rolDescripcion;
        this.rolNombre = rolNombre;
    }

    @Column(name = "ROL_ACTIVO", nullable = false, length = 1)
    public String getRolActivo() {
        return rolActivo;
    }

    public void setRolActivo(String rolActivo) {
        this.rolActivo = rolActivo;
    }

    @Id
    @Column(name = "ROL_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ROL_CODIGO")
    @SequenceGenerator(name = "SEQ_ROL_CODIGO", sequenceName = "SEQ_ROL_CODIGO",allocationSize=1)
    public Long getRolCodigo() {
        return rolCodigo;
    }

    public void setRolCodigo(Long rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    @Column(name = "ROL_DESCRIPCION", nullable = false, length = 100)
    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    @Column(name = "ROL_NOMBRE", nullable = false, length = 50)
    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    @OneToMany(mappedBy = "siiRol")
    public List<SiiPermisoRolModulo> getSiiPermisoRolModuloList() {
        return siiPermisoRolModuloList;
    }

    public void setSiiPermisoRolModuloList(List<SiiPermisoRolModulo> siiPermisoRolModuloList) {
        this.siiPermisoRolModuloList = siiPermisoRolModuloList;
    }

    public SiiPermisoRolModulo addSiiPermisoRolModulo(SiiPermisoRolModulo siiPermisoRolModulo) {
        getSiiPermisoRolModuloList().add(siiPermisoRolModulo);
        siiPermisoRolModulo.setSiiRol(this);
        return siiPermisoRolModulo;
    }

    public SiiPermisoRolModulo removeSiiPermisoRolModulo(SiiPermisoRolModulo siiPermisoRolModulo) {
        getSiiPermisoRolModuloList().remove(siiPermisoRolModulo);
        siiPermisoRolModulo.setSiiRol(null);
        return siiPermisoRolModulo;
    }

    @OneToMany(mappedBy = "siiRol1")
    public List<SiiUsuarioRol> getSiiUsuarioRolList1() {
        return siiUsuarioRolList1;
    }

    public void setSiiUsuarioRolList1(List<SiiUsuarioRol> siiUsuarioRolList1) {
        this.siiUsuarioRolList1 = siiUsuarioRolList1;
    }

    public SiiUsuarioRol addSiiUsuarioRol(SiiUsuarioRol siiUsuarioRol) {
        getSiiUsuarioRolList1().add(siiUsuarioRol);
        siiUsuarioRol.setSiiRol1(this);
        return siiUsuarioRol;
    }

    public SiiUsuarioRol removeSiiUsuarioRol(SiiUsuarioRol siiUsuarioRol) {
        getSiiUsuarioRolList1().remove(siiUsuarioRol);
        siiUsuarioRol.setSiiRol1(null);
        return siiUsuarioRol;
    }

    @OneToMany(mappedBy = "siiRol")
    public List<SiiHistorialRol> getSiiHistorialRolList() {
        return siiHistorialRolList;
    }

    public void setSiiHistorialRolList(List<SiiHistorialRol> siiHistorialRolList) {
        this.siiHistorialRolList = siiHistorialRolList;
    }

    public SiiHistorialRol addSiiHistorialRol(SiiHistorialRol siiHistorialRol) {
        getSiiHistorialRolList().add(siiHistorialRol);
        siiHistorialRol.setSiiRol(this);
        return siiHistorialRol;
    }

    public SiiHistorialRol removeSiiHistorialRol(SiiHistorialRol siiHistorialRol) {
        getSiiHistorialRolList().remove(siiHistorialRol);
        siiHistorialRol.setSiiRol(null);
        return siiHistorialRol;
    }
}
