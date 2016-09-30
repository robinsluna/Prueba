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
@Table(name = "SII_FUNCION")
public class SiiFuncion implements Serializable {
    private static final long serialVersionUID = -6146580424187752041L;
    private String funActivo;
    private Long funCodigo;
    private String funDescripcion;
    private String funNombre;
    private List<SiiFirmasRequeridas> siiFirmasRequeridasList;
    private List<SiiUsuario> siiUsuarioList2;

    public SiiFuncion() {
    }

    public SiiFuncion(String funActivo, Long funCodigo, String funDescripcion, String funNombre) {
        this.funActivo = funActivo;
        this.funCodigo = funCodigo;
        this.funDescripcion = funDescripcion;
        this.funNombre = funNombre;
    }

    @Column(name = "FUN_ACTIVO", nullable = false, length = 1)
    public String getFunActivo() {
        return funActivo;
    }

    public void setFunActivo(String funActivo) {
        this.funActivo = funActivo;
    }

    @Id
    @Column(name = "FUN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_FUNCION_COD")
    @SequenceGenerator(name = "SEQ_FUNCION_COD", sequenceName = "SEQ_FUNCION_COD",allocationSize=1)
    public Long getFunCodigo() {
        return funCodigo;
    }

    public void setFunCodigo(Long funCodigo) {
        this.funCodigo = funCodigo;
    }

    @Column(name = "FUN_DESCRIPCION", nullable = false, length = 100)
    public String getFunDescripcion() {
        return funDescripcion;
    }

    public void setFunDescripcion(String funDescripcion) {
        this.funDescripcion = funDescripcion;
    }

    @Column(name = "FUN_NOMBRE", nullable = false, length = 50)
    public String getFunNombre() {
        return funNombre;
    }

    public void setFunNombre(String funNombre) {
        this.funNombre = funNombre;
    }

    @OneToMany(mappedBy = "siiFuncion")
    public List<SiiFirmasRequeridas> getSiiFirmasRequeridasList() {
        return siiFirmasRequeridasList;
    }

    public void setSiiFirmasRequeridasList(List<SiiFirmasRequeridas> siiFirmasRequeridasList) {
        this.siiFirmasRequeridasList = siiFirmasRequeridasList;
    }

    public SiiFirmasRequeridas addSiiFirmasRequeridas(SiiFirmasRequeridas siiFirmasRequeridas) {
        getSiiFirmasRequeridasList().add(siiFirmasRequeridas);
        siiFirmasRequeridas.setSiiFuncion(this);
        return siiFirmasRequeridas;
    }

    public SiiFirmasRequeridas removeSiiFirmasRequeridas(SiiFirmasRequeridas siiFirmasRequeridas) {
        getSiiFirmasRequeridasList().remove(siiFirmasRequeridas);
        siiFirmasRequeridas.setSiiFuncion(null);
        return siiFirmasRequeridas;
    }

    @OneToMany(mappedBy = "siiFuncion1")
    public List<SiiUsuario> getSiiUsuarioList2() {
        return siiUsuarioList2;
    }

    public void setSiiUsuarioList2(List<SiiUsuario> siiUsuarioList2) {
        this.siiUsuarioList2 = siiUsuarioList2;
    }

    public SiiUsuario addSiiUsuario(SiiUsuario siiUsuario) {
        getSiiUsuarioList2().add(siiUsuario);
        siiUsuario.setSiiFuncion1(this);
        return siiUsuario;
    }

    public SiiUsuario removeSiiUsuario(SiiUsuario siiUsuario) {
        getSiiUsuarioList2().remove(siiUsuario);
        siiUsuario.setSiiFuncion1(null);
        return siiUsuario;
    }
}
