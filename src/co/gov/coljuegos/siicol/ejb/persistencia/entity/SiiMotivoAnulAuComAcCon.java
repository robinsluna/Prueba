package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MOTIVO_ANUL_AU_COM_AC_CON")
public class SiiMotivoAnulAuComAcCon implements Serializable{
    private static final long serialVersionUID = 8607861656051717491L;
    private Long maaCodigo;
    private String maaNombre;
    private List<SiiAutoComisorioAccCon> siiAutoComisorioAccConList;

    public SiiMotivoAnulAuComAcCon(){
    }

    public SiiMotivoAnulAuComAcCon(Long maaCodigo, String maaNombre){
        this.maaCodigo = maaCodigo;
        this.maaNombre = maaNombre;
    }

    @Id
    @Column(name = "MAA_CODIGO", nullable = false)
    public Long getMaaCodigo(){
        return maaCodigo;
    }

    public void setMaaCodigo(Long maaCodigo){
        this.maaCodigo = maaCodigo;
    }

    @Column(name = "MAA_NOMBRE", nullable = false, length = 30)
    public String getMaaNombre(){
        return maaNombre;
    }

    public void setMaaNombre(String maaNombre){
        this.maaNombre = maaNombre;
    }

    @OneToMany(mappedBy = "siiMotivoAnulAuComAcCon")
    public List<SiiAutoComisorioAccCon> getSiiAutoComisorioAccConList(){
        return siiAutoComisorioAccConList;
    }

    public void setSiiAutoComisorioAccConList(List<SiiAutoComisorioAccCon> siiAutoComisorioAccConList){
        this.siiAutoComisorioAccConList = siiAutoComisorioAccConList;
    }

    public SiiAutoComisorioAccCon addSiiAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon){
        getSiiAutoComisorioAccConList().add(siiAutoComisorioAccCon);
        siiAutoComisorioAccCon.setSiiMotivoAnulAuComAcCon(this);
        return siiAutoComisorioAccCon;
    }

    public SiiAutoComisorioAccCon removeSiiAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon){
        getSiiAutoComisorioAccConList().remove(siiAutoComisorioAccCon);
        siiAutoComisorioAccCon.setSiiMotivoAnulAuComAcCon(null);
        return siiAutoComisorioAccCon;
    }
}
