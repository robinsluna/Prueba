package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumSoporModif;

import java.util.Date;

public class DocumSoporModifVO {
    private String dsmActivo;
    private Long dsmCodigo;
    private Date dsmFecha;
    private String dsmNumDoc;
    private ModificacionPlanContVO modificacionPlanContVo;
    private TipoDocSoporteModifVO tipoDocSoporteModifVo;
    
    public DocumSoporModifVO() {
        
    }
    
    public DocumSoporModifVO(SiiDocumSoporModif documSoporModif) {
        this.dsmActivo = documSoporModif.getDsmActivo();
        this.dsmCodigo = documSoporModif.getDsmCodigo();
        this.dsmFecha = documSoporModif.getDsmFecha();
        this.dsmNumDoc = documSoporModif.getDsmNumDoc();
        //Padres:
        if (documSoporModif.getSiiModificacionPlanCont() != null) {
            this.modificacionPlanContVo = new ModificacionPlanContVO(documSoporModif.getSiiModificacionPlanCont());
        }
        if (documSoporModif.getSiiTipoDocSoporteModif() != null) {
            this.tipoDocSoporteModifVo = new TipoDocSoporteModifVO(documSoporModif.getSiiTipoDocSoporteModif());
        }
    }

    public void setDsmActivo(String dsmActivo) {
        this.dsmActivo = dsmActivo;
    }

    public String getDsmActivo() {
        return dsmActivo;
    }

    public void setDsmCodigo(Long dsmCodigo) {
        this.dsmCodigo = dsmCodigo;
    }

    public Long getDsmCodigo() {
        return dsmCodigo;
    }

    public void setDsmFecha(Date dsmFecha) {
        this.dsmFecha = dsmFecha;
    }

    public Date getDsmFecha() {
        return dsmFecha;
    }

    public void setDsmNumDoc(String dsmNumDoc) {
        this.dsmNumDoc = dsmNumDoc;
    }

    public String getDsmNumDoc() {
        return dsmNumDoc;
    }

    public void setModificacionPlanContVo(ModificacionPlanContVO modificacionPlanContVo) {
        this.modificacionPlanContVo = modificacionPlanContVo;
    }

    public ModificacionPlanContVO getModificacionPlanContVo() {
        return modificacionPlanContVo;
    }

    public void setTipoDocSoporteModifVo(TipoDocSoporteModifVO tipoDocSoporteModifVo) {
        this.tipoDocSoporteModifVo = tipoDocSoporteModifVo;
    }

    public TipoDocSoporteModifVO getTipoDocSoporteModifVo() {
        return tipoDocSoporteModifVo;
    }
}
