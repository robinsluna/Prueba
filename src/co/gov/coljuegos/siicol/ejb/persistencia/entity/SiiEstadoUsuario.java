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
@Table(name = "SII_ESTADO_USUARIO")
public class SiiEstadoUsuario implements Serializable {
    private static final long serialVersionUID = 1924130631105902265L;
    private Long eusCodigo;
    private String eusDescripcion;
    private String eusNombre;
    private List<SiiUsuario> siiUsuarioList1;

    public SiiEstadoUsuario() {
    }

    public SiiEstadoUsuario(Long eusCodigo, String eusDescripcion, String eusNombre) {
        this.eusCodigo = eusCodigo;
        this.eusDescripcion = eusDescripcion;
        this.eusNombre = eusNombre;
    }

    @Id
    @Column(name = "EUS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTADO_USUARIO_CODIGO")
    @SequenceGenerator(name = "SEQ_ESTADO_USUARIO_CODIGO", sequenceName = "SEQ_ESTADO_USUARIO_CODIGO",allocationSize=1)
    public Long getEusCodigo() {
        return eusCodigo;
    }

    public void setEusCodigo(Long eusCodigo) {
        this.eusCodigo = eusCodigo;
    }

    @Column(name = "EUS_DESCRIPCION", nullable = false, length = 100, insertable=false, updatable = false)
    public String getEusDescripcion() {
        return eusDescripcion;
    }

    public void setEusDescripcion(String eusDescripcion) {
        this.eusDescripcion = eusDescripcion;
    }

    @Column(name = "EUS_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEusNombre() {
        return eusNombre;
    }

    public void setEusNombre(String eusNombre) {
        this.eusNombre = eusNombre;
    }

    @OneToMany(mappedBy = "siiEstadoUsuario")
    public List<SiiUsuario> getSiiUsuarioList1() {
        return siiUsuarioList1;
    }

    public void setSiiUsuarioList1(List<SiiUsuario> siiUsuarioList1) {
        this.siiUsuarioList1 = siiUsuarioList1;
    }

    public SiiUsuario addSiiUsuario(SiiUsuario siiUsuario) {
        getSiiUsuarioList1().add(siiUsuario);
        siiUsuario.setSiiEstadoUsuario(this);
        return siiUsuario;
    }

    public SiiUsuario removeSiiUsuario(SiiUsuario siiUsuario) {
        getSiiUsuarioList1().remove(siiUsuario);
        siiUsuario.setSiiEstadoUsuario(null);
        return siiUsuario;
    }
}
