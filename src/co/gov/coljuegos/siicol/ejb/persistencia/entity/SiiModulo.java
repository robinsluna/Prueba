package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MODULO")
public class SiiModulo implements Serializable {
    private static final long serialVersionUID = -536298059229260565L;
    private String modActivo;
    private Long modCodigo;
    private Long modCodigoPadre;
    private String modMbClass;
    private String modNombre;
    private Integer modOrden;
    private String modPath;
    private String modTitulo;
    //private SiiModulo siiModulo;
    //private SiiModulo siiModuloList;
    private List<SiiPermisoRolModulo> siiPermisoRolModuloList;
    private String modParametros;
    private List<SiiHistorialPermiso> siiHistorialPermisoList;

    public SiiModulo() {
    }

    public SiiModulo(String modActivo, /*SiiModulo siiModulo,*/ Long modCodigoPadre, String modNombre, Integer modOrden,
                     String modPath, String modTitulo, String modMbClass) {
        this.modActivo = modActivo;
        //this.siiModulo = siiModulo;
        this.modCodigoPadre = modCodigoPadre;
        this.modMbClass = modMbClass;
        this.modNombre = modNombre;
        this.modOrden = modOrden;
        this.modPath = modPath;
        this.modTitulo = modTitulo;
    }

    @Column(name = "MOD_ACTIVO", nullable = false, length = 1)
    public String getModActivo() {
        return modActivo;
    }

    public void setModActivo(String modActivo) {
        this.modActivo = modActivo;
    }

    @Id
    @Column(name = "MOD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODULO_CODIGO")
    @SequenceGenerator(name = "SEQ_MODULO_CODIGO", sequenceName = "SEQ_MODULO_CODIGO",allocationSize=1)
    public Long getModCodigo() {
        return modCodigo;
    }

    public void setModCodigo(Long modCodigo) {
        this.modCodigo = modCodigo;
    }

    @Column(name = "MOD_CODIGO_PADRE")
    public Long getModCodigoPadre() {
        return modCodigoPadre;
    }

    public void setModCodigoPadre(Long modCodigoPadre) {
        this.modCodigoPadre = modCodigoPadre;
    }

    @Column(name = "MOD_MB_CLASS", length = 50)
    public String getModMbClass() {
        return modMbClass;
    }

    public void setModMbClass(String modMbClass) {
        this.modMbClass = modMbClass;
    }

    @Column(name = "MOD_NOMBRE", nullable = false, length = 50)
    public String getModNombre() {
        return modNombre;
    }

    public void setModNombre(String modNombre) {
        this.modNombre = modNombre;
    }

    @Column(name = "MOD_ORDEN", nullable = false)
    public Integer getModOrden() {
        return modOrden;
    }

    public void setModOrden(Integer modOrden) {
        this.modOrden = modOrden;
    }

    @Column(name = "MOD_PATH", length = 200)
    public String getModPath() {
        return modPath;
    }

    public void setModPath(String modPath) {
        this.modPath = modPath;
    }

    @Column(name = "MOD_TITULO", length = 50)
    public String getModTitulo() {
        return modTitulo;
    }

    public void setModTitulo(String modTitulo) {
        this.modTitulo = modTitulo;
    }
/*
    @OneToOne
    @JoinColumn(name = "MOD_CODIGO", insertable = false, updatable = false)
    public SiiModulo getSiiModulo() {
        return siiModulo;
    }

    public void setSiiModulo(SiiModulo siiModulo) {
        this.siiModulo = siiModulo;
        if (siiModulo != null) {
            this.modCodigo = siiModulo.getModCodigo();
        }
    }

    @OneToOne(mappedBy = "siiModulo")
    public SiiModulo getSiiModuloList() {
        return siiModuloList;
    }

    public void setSiiModuloList(SiiModulo siiModuloList) {
        this.siiModuloList = siiModuloList;
    }
*/
    @OneToMany(mappedBy = "siiModulo1")
    public List<SiiPermisoRolModulo> getSiiPermisoRolModuloList() {
        return siiPermisoRolModuloList;
    }

    public void setSiiPermisoRolModuloList(List<SiiPermisoRolModulo> siiPermisoRolModuloList) {
        this.siiPermisoRolModuloList = siiPermisoRolModuloList;
    }

    public SiiPermisoRolModulo addSiiPermisoRolModulo(SiiPermisoRolModulo siiPermisoRolModulo) {
        getSiiPermisoRolModuloList().add(siiPermisoRolModulo);
        siiPermisoRolModulo.setSiiModulo1(this);
        return siiPermisoRolModulo;
    }

    public SiiPermisoRolModulo removeSiiPermisoRolModulo(SiiPermisoRolModulo siiPermisoRolModulo) {
        getSiiPermisoRolModuloList().remove(siiPermisoRolModulo);
        siiPermisoRolModulo.setSiiModulo1(null);
        return siiPermisoRolModulo;
    }

    @Column(name = "MOD_PARAMETROS", length = 200)
    public String getModParametros() {
        return modParametros;
    }

    public void setModParametros(String modParametros) {
        this.modParametros = modParametros;
    }

    @OneToMany(mappedBy = "siiModulo")
    public List<SiiHistorialPermiso> getSiiHistorialPermisoList() {
        return siiHistorialPermisoList;
    }

    public void setSiiHistorialPermisoList(List<SiiHistorialPermiso> siiHistorialPermisoList) {
        this.siiHistorialPermisoList = siiHistorialPermisoList;
    }

    public SiiHistorialPermiso addSiiHistorialPermiso(SiiHistorialPermiso siiHistorialPermiso) {
        getSiiHistorialPermisoList().add(siiHistorialPermiso);
        siiHistorialPermiso.setSiiModulo(this);
        return siiHistorialPermiso;
    }

    public SiiHistorialPermiso removeSiiHistorialPermiso(SiiHistorialPermiso siiHistorialPermiso) {
        getSiiHistorialPermisoList().remove(siiHistorialPermiso);
        siiHistorialPermiso.setSiiModulo(null);
        return siiHistorialPermiso;
    }
}
