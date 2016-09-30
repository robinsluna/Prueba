package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_TRAM_RES_DEC_DES")
public class SiiEstadoTramResDecDes implements Serializable{
    private static final long serialVersionUID = -3060322963531974639L;
    private Long etdCodigo;
    private String etdNombre;
    private List<SiiTramiteResolDecDes> siiTramiteResolDecDesList;
    private Integer etdOrden;

    public SiiEstadoTramResDecDes(){
    }

    public SiiEstadoTramResDecDes(Long etdCodigo, String etdNombre){
        this.etdCodigo = etdCodigo;
        this.etdNombre = etdNombre;
    }

    @Id
    @Column(name = "ETD_CODIGO", nullable = false)
    public Long getEtdCodigo(){
        return etdCodigo;
    }

    public void setEtdCodigo(Long etdCodigo){
        this.etdCodigo = etdCodigo;
    }

    @Column(name = "ETD_NOMBRE", nullable = false, length = 30)
    public String getEtdNombre(){
        return etdNombre;
    }

    public void setEtdNombre(String etdNombre){
        this.etdNombre = etdNombre;
    }

    @OneToMany(mappedBy = "siiEstadoTramResDecDes")
    public List<SiiTramiteResolDecDes> getSiiTramiteResolDecDesList(){
        return siiTramiteResolDecDesList;
    }

    public void setSiiTramiteResolDecDesList(List<SiiTramiteResolDecDes> siiTramiteResolDecDesList){
        this.siiTramiteResolDecDesList = siiTramiteResolDecDesList;
    }

    public SiiTramiteResolDecDes addSiiTramiteResolDecDes(SiiTramiteResolDecDes siiTramiteResolDecDes){
        getSiiTramiteResolDecDesList().add(siiTramiteResolDecDes);
        siiTramiteResolDecDes.setSiiEstadoTramResDecDes(this);
        return siiTramiteResolDecDes;
    }

    public SiiTramiteResolDecDes removeSiiTramiteResolDecDes(SiiTramiteResolDecDes siiTramiteResolDecDes){
        getSiiTramiteResolDecDesList().remove(siiTramiteResolDecDes);
        siiTramiteResolDecDes.setSiiEstadoTramResDecDes(null);
        return siiTramiteResolDecDes;
    }

    @Column(name = "ETD_ORDEN")
    public Integer getEtdOrden() {
        return etdOrden;
    }

    public void setEtdOrden(Integer etdOrden) {
        this.etdOrden = etdOrden;
    }
}
