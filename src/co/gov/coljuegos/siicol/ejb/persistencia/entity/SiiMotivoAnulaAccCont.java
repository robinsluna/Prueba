package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MOTIVO_ANULA_ACC_CONT")
public class SiiMotivoAnulaAccCont implements Serializable{
    private static final long serialVersionUID = 3577545286103994599L;
    private Long macCodigo;
    private String macNombre;
    private List<SiiAccionControl> siiAccionControlList;

    public SiiMotivoAnulaAccCont(){
    }

    public SiiMotivoAnulaAccCont(Long macCodigo, String macNombre){
        this.macCodigo = macCodigo;
        this.macNombre = macNombre;
    }

    @Id
    @Column(name = "MAC_CODIGO", nullable = false)
    public Long getMacCodigo(){
        return macCodigo;
    }

    public void setMacCodigo(Long macCodigo){
        this.macCodigo = macCodigo;
    }

    @Column(name = "MAC_NOMBRE", nullable = false, length = 100)
    public String getMacNombre(){
        return macNombre;
    }

    public void setMacNombre(String macNombre){
        this.macNombre = macNombre;
    }

    @OneToMany(mappedBy = "siiMotivoAnulaAccCont")
    public List<SiiAccionControl> getSiiAccionControlList(){
        return siiAccionControlList;
    }

    public void setSiiAccionControlList(List<SiiAccionControl> siiAccionControlList){
        this.siiAccionControlList = siiAccionControlList;
    }

    public SiiAccionControl addSiiAccionControl(SiiAccionControl siiAccionControl){
        getSiiAccionControlList().add(siiAccionControl);
        siiAccionControl.setSiiMotivoAnulaAccCont(this);
        return siiAccionControl;
    }

    public SiiAccionControl removeSiiAccionControl(SiiAccionControl siiAccionControl){
        getSiiAccionControlList().remove(siiAccionControl);
        siiAccionControl.setSiiMotivoAnulaAccCont(null);
        return siiAccionControl;
    }
}
