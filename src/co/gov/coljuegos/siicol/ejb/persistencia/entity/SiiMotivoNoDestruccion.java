package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MOTIVO_NO_DESTRUCCION")
public class SiiMotivoNoDestruccion implements Serializable{
    private static final long serialVersionUID = 2271687640645634714L;
    private Long mndCodigo;
    private String mndNombre;
    private List<SiiActaDestruccion> siiActaDestruccionList;

    public SiiMotivoNoDestruccion(){
    }

    public SiiMotivoNoDestruccion(Long mndCodigo, String mndNombre){
        this.mndCodigo = mndCodigo;
        this.mndNombre = mndNombre;
    }

    @Id
    @Column(name = "MND_CODIGO", nullable = false)
    public Long getMndCodigo(){
        return mndCodigo;
    }

    public void setMndCodigo(Long mndCodigo){
        this.mndCodigo = mndCodigo;
    }

    @Column(name = "MND_NOMBRE", nullable = false, length = 100)
    public String getMndNombre(){
        return mndNombre;
    }

    public void setMndNombre(String mndNombre){
        this.mndNombre = mndNombre;
    }

    @OneToMany(mappedBy = "siiMotivoNoDestruccion")
    public List<SiiActaDestruccion> getSiiActaDestruccionList(){
        return siiActaDestruccionList;
    }

    public void setSiiActaDestruccionList(List<SiiActaDestruccion> siiActaDestruccionList){
        this.siiActaDestruccionList = siiActaDestruccionList;
    }

    public SiiActaDestruccion addSiiActaDestruccion(SiiActaDestruccion siiActaDestruccion){
        getSiiActaDestruccionList().add(siiActaDestruccion);
        siiActaDestruccion.setSiiMotivoNoDestruccion(this);
        return siiActaDestruccion;
    }

    public SiiActaDestruccion removeSiiActaDestruccion(SiiActaDestruccion siiActaDestruccion){
        getSiiActaDestruccionList().remove(siiActaDestruccion);
        siiActaDestruccion.setSiiMotivoNoDestruccion(null);
        return siiActaDestruccion;
    }
}
