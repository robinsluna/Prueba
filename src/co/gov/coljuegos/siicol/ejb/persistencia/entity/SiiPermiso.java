package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_PERMISO")
public class SiiPermiso implements Serializable {
    private static final long serialVersionUID = -11062099269740990L;
    private Long pmsCodigo;
    private String pmsNombre;
    private List<SiiPermisoRolModulo> siiPermisoRolModuloList;
    private List<SiiHistorialPermiso> siiHistorialPermisoList;

    public SiiPermiso() {
    }

    public SiiPermiso(Long pmsCodigo, String pmsNombre) {
        this.pmsCodigo = pmsCodigo;
        this.pmsNombre = pmsNombre;
    }

    @Id
    @Column(name = "PMS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PERMISO_CODIGO")
    @SequenceGenerator(name = "SEQ_PERMISO_CODIGO", sequenceName = "SEQ_PERMISO_CODIGO",allocationSize=1)
    public Long getPmsCodigo() {
        return pmsCodigo;
    }

    public void setPmsCodigo(Long pmsCodigo) {
        this.pmsCodigo = pmsCodigo;
    }

    @Column(name = "PMS_NOMBRE", nullable = false, length = 50)
    public String getPmsNombre() {
        return pmsNombre;
    }

    public void setPmsNombre(String pmsNombre) {
        this.pmsNombre = pmsNombre;
    }

    @OneToMany(mappedBy = "siiPermiso")
    public List<SiiPermisoRolModulo> getSiiPermisoRolModuloList() {
        return siiPermisoRolModuloList;
    }

    public void setSiiPermisoRolModuloList(List<SiiPermisoRolModulo> siiPermisoRolModuloList) {
        this.siiPermisoRolModuloList = siiPermisoRolModuloList;
    }

    public SiiPermisoRolModulo addSiiPermisoRolModulo(SiiPermisoRolModulo siiPermisoRolModulo) {
        getSiiPermisoRolModuloList().add(siiPermisoRolModulo);
        siiPermisoRolModulo.setSiiPermiso(this);
        return siiPermisoRolModulo;
    }

    public SiiPermisoRolModulo removeSiiPermisoRolModulo(SiiPermisoRolModulo siiPermisoRolModulo) {
        getSiiPermisoRolModuloList().remove(siiPermisoRolModulo);
        siiPermisoRolModulo.setSiiPermiso(null);
        return siiPermisoRolModulo;
    }

    @OneToMany(mappedBy = "siiPermiso")
    public List<SiiHistorialPermiso> getSiiHistorialPermisoList() {
        return siiHistorialPermisoList;
    }

    public void setSiiHistorialPermisoList(List<SiiHistorialPermiso> siiHistorialPermisoList) {
        this.siiHistorialPermisoList = siiHistorialPermisoList;
    }

    public SiiHistorialPermiso addSiiHistorialPermiso(SiiHistorialPermiso siiHistorialPermiso) {
        getSiiHistorialPermisoList().add(siiHistorialPermiso);
        siiHistorialPermiso.setSiiPermiso(this);
        return siiHistorialPermiso;
    }

    public SiiHistorialPermiso removeSiiHistorialPermiso(SiiHistorialPermiso siiHistorialPermiso) {
        getSiiHistorialPermisoList().remove(siiHistorialPermiso);
        siiHistorialPermiso.setSiiPermiso(null);
        return siiHistorialPermiso;
    }
}
