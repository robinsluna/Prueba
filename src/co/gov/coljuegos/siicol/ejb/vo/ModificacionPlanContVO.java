package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionPlanCont;

import java.util.Date;
import java.util.List;

public class ModificacionPlanContVO {
    private Long mpcCodigo;
    private Integer mpcConsecutivo;
    private Integer mpcVigencia;
    private Date mpcFecha;
    private EstadoModifPlanContVO estadoModifPlanContVo;
    private List<DocumSoporModifVO> documSoporModifListVo;
    private List<ModPlanConItemPlanDetRubVO> modPlanConItemPlanDetRubListVo;
    private List<ItemPlanContratacVO> itemPlanContratacListVo;
    private DocumSoporModifVO documSoporModifVo; // campo que no pertenece a la entidad


    public ModificacionPlanContVO() {
    }

    public ModificacionPlanContVO(SiiModificacionPlanCont modificacionPlanCont) {
        this.mpcCodigo = modificacionPlanCont.getMpcCodigo();
        this.mpcConsecutivo = modificacionPlanCont.getMpcConsecutivo();
        this.mpcFecha = modificacionPlanCont.getMpcFecha();
        this.mpcVigencia = modificacionPlanCont.getMpcVigencia();
        //Padres:
        if (modificacionPlanCont.getSiiEstadoModifPlanCont() != null) {
            this.estadoModifPlanContVo = new EstadoModifPlanContVO(modificacionPlanCont.getSiiEstadoModifPlanCont());
        }
        //
        if (documSoporModifListVo != null && documSoporModifListVo.size() > 0) {
            this.documSoporModifVo = documSoporModifListVo.get(0);
        }

    }

    public void setMpcCodigo(Long mpcCodigo) {
        this.mpcCodigo = mpcCodigo;
    }

    public Long getMpcCodigo() {
        return mpcCodigo;
    }

    public void setMpcConsecutivo(Integer mpcConsecutivo) {
        this.mpcConsecutivo = mpcConsecutivo;
    }

    public Integer getMpcConsecutivo() {
        return mpcConsecutivo;
    }

    public void setMpcVigencia(Integer mpcVigencia) {
        this.mpcVigencia = mpcVigencia;
    }

    public Integer getMpcVigencia() {
        return mpcVigencia;
    }

    public void setMpcFecha(Date mpcFecha) {
        this.mpcFecha = mpcFecha;
    }

    public Date getMpcFecha() {
        return mpcFecha;
    }

    public void setEstadoModifPlanContVo(EstadoModifPlanContVO estadoModifPlanContVo) {
        this.estadoModifPlanContVo = estadoModifPlanContVo;
    }

    public EstadoModifPlanContVO getEstadoModifPlanContVo() {
        return estadoModifPlanContVo;
    }

    public void setDocumSoporModifListVo(List<DocumSoporModifVO> documSoporModifListVo) {
        this.documSoporModifListVo = documSoporModifListVo;
    }

    public List<DocumSoporModifVO> getDocumSoporModifListVo() {
        return documSoporModifListVo;
    }

    public void setModPlanConItemPlanDetRubListVo(List<ModPlanConItemPlanDetRubVO> modPlanConItemPlanDetRubListVo) {
        this.modPlanConItemPlanDetRubListVo = modPlanConItemPlanDetRubListVo;
    }

    public List<ModPlanConItemPlanDetRubVO> getModPlanConItemPlanDetRubListVo() {
        return modPlanConItemPlanDetRubListVo;
    }

    public void setDocumSoporModifVo(DocumSoporModifVO documSoporModifVo) {
        this.documSoporModifVo = documSoporModifVo;
    }

    public DocumSoporModifVO getDocumSoporModifVo() {
        return documSoporModifVo;
    }

    public void setItemPlanContratacListVo(List<ItemPlanContratacVO> itemPlanContratacListVo) {
        this.itemPlanContratacListVo = itemPlanContratacListVo;
    }

    public List<ItemPlanContratacVO> getItemPlanContratacListVo() {
        return itemPlanContratacListVo;
    }
}
