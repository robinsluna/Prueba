package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModPlanConItemPlanDetRub;

public class ModPlanConItemPlanDetRubVO {
    private String midActivo;
    private Long midCodigo;
    private String midTipo;
    private Long midValor;
    private ItemPlanContDetRubVO itemPlanContDetRubDesVo;
    private ModificacionPlanContVO modificacionPlanContVo;
    
    public ModPlanConItemPlanDetRubVO (){
        
    }

    public ModPlanConItemPlanDetRubVO(SiiModPlanConItemPlanDetRub siiModPlanConItemPlanDetRub) {
        this.midActivo = siiModPlanConItemPlanDetRub.getMidActivo();
        this.midCodigo = siiModPlanConItemPlanDetRub.getMidCodigo();
        this.midTipo = siiModPlanConItemPlanDetRub.getMidTipo();
        this.midValor = siiModPlanConItemPlanDetRub.getMidValor();
        //Padres
        if (siiModPlanConItemPlanDetRub.getSiiItemPlanContDetRubDes() != null) {
            this.itemPlanContDetRubDesVo = new ItemPlanContDetRubVO(siiModPlanConItemPlanDetRub.getSiiItemPlanContDetRubDes());
        }
        if (siiModPlanConItemPlanDetRub.getSiiModificacionPlanCont() != null) {
            this.modificacionPlanContVo = new ModificacionPlanContVO(siiModPlanConItemPlanDetRub.getSiiModificacionPlanCont());
        }
        
    }

    public void setMidActivo(String midActivo) {
        this.midActivo = midActivo;
    }

    public String getMidActivo() {
        return midActivo;
    }

    public void setMidCodigo(Long midCodigo) {
        this.midCodigo = midCodigo;
    }

    public Long getMidCodigo() {
        return midCodigo;
    }

    public void setMidTipo(String midTipo) {
        this.midTipo = midTipo;
    }

    public String getMidTipo() {
        return midTipo;
    }

    public void setMidValor(Long midValor) {
        this.midValor = midValor;
    }

    public Long getMidValor() {
        return midValor;
    }

    public void setItemPlanContDetRubDesVo(ItemPlanContDetRubVO itemPlanContDetRubDesVo) {
        this.itemPlanContDetRubDesVo = itemPlanContDetRubDesVo;
    }

    public ItemPlanContDetRubVO getItemPlanContDetRubDesVo() {
        return itemPlanContDetRubDesVo;
    }

    public void setModificacionPlanContVo(ModificacionPlanContVO modificacionPlanContVo) {
        this.modificacionPlanContVo = modificacionPlanContVo;
    }

    public ModificacionPlanContVO getModificacionPlanContVo() {
        return modificacionPlanContVo;
    }
}
