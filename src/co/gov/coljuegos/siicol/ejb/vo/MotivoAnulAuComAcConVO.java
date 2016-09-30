package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulAuComAcCon;

public class MotivoAnulAuComAcConVO {

    private Long maaCodigo;
    private String maaNombre;
    
    
    public MotivoAnulAuComAcConVO(){
        
    }
    public MotivoAnulAuComAcConVO(SiiMotivoAnulAuComAcCon siiMotivoAnulAuComAcCon){
        this.maaCodigo = siiMotivoAnulAuComAcCon.getMaaCodigo();
        this.maaNombre = siiMotivoAnulAuComAcCon.getMaaNombre();
    }
    

    public void setMaaCodigo(Long maaCodigo){
        this.maaCodigo = maaCodigo;
    }

    public Long getMaaCodigo(){
        return maaCodigo;
    }

    public void setMaaNombre(String maaNombre){
        this.maaNombre = maaNombre;
    }

    public String getMaaNombre(){
        return maaNombre;
    }
}
