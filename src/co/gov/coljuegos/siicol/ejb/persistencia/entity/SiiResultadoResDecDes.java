package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_RESULTADO_RES_DEC_DES")
public class SiiResultadoResDecDes implements Serializable{
    private static final long serialVersionUID = -531143195217419765L;
    private Long rrdCodigo;
    private String rrdNombre;
    private List<SiiResolucionDecomDest> siiResolucionDecomDestList;

    public SiiResultadoResDecDes(){
    }

    public SiiResultadoResDecDes(Long rrdCodigo, String rrdNombre){
        this.rrdCodigo = rrdCodigo;
        this.rrdNombre = rrdNombre;
    }

    @Id
    @Column(name = "RRD_CODIGO", nullable = false)
    public Long getRrdCodigo(){
        return rrdCodigo;
    }

    public void setRrdCodigo(Long rrdCodigo){
        this.rrdCodigo = rrdCodigo;
    }

    @Column(name = "RRD_NOMBRE", nullable = false, length = 30)
    public String getRrdNombre(){
        return rrdNombre;
    }

    public void setRrdNombre(String rrdNombre){
        this.rrdNombre = rrdNombre;
    }

    @OneToMany(mappedBy = "siiResultadoResDecDes")
    public List<SiiResolucionDecomDest> getSiiResolucionDecomDestList(){
        return siiResolucionDecomDestList;
    }

    public void setSiiResolucionDecomDestList(List<SiiResolucionDecomDest> siiResolucionDecomDestList){
        this.siiResolucionDecomDestList = siiResolucionDecomDestList;
    }

    public SiiResolucionDecomDest addSiiResolucionDecomDest(SiiResolucionDecomDest siiResolucionDecomDest){
        getSiiResolucionDecomDestList().add(siiResolucionDecomDest);
        siiResolucionDecomDest.setSiiResultadoResDecDes(this);
        return siiResolucionDecomDest;
    }

    public SiiResolucionDecomDest removeSiiResolucionDecomDest(SiiResolucionDecomDest siiResolucionDecomDest){
        getSiiResolucionDecomDestList().remove(siiResolucionDecomDest);
        siiResolucionDecomDest.setSiiResultadoResDecDes(null);
        return siiResolucionDecomDest;
    }
}
