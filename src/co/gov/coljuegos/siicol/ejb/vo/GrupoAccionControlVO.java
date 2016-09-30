package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoAccionControl;

import java.util.Date;
import java.util.List;

public class GrupoAccionControlVO {
    private Long gacCodigo;
    private Date gacFecha;
    private Integer gacNumero;
    private SustanciadorAuditorVO sustanciadorAuditorPpalVo;
    private SustanciadorAuditorVO sustanciadorAuditorAcompVo;
    private List<AutoComisorioAccConVO> autoComisorioAccConListVo;

    public GrupoAccionControlVO() {
    }
    public GrupoAccionControlVO(SiiGrupoAccionControl siiGrupoAccionControl) {
        this.gacCodigo = siiGrupoAccionControl.getGacCodigo();
        this.gacFecha = siiGrupoAccionControl.getGacFecha();
        this.gacNumero = siiGrupoAccionControl.getGacNumero();
        
        if (siiGrupoAccionControl.getSiiSustanciadorAuditorAcomp() != null  )
            this.sustanciadorAuditorAcompVo = new SustanciadorAuditorVO(siiGrupoAccionControl.getSiiSustanciadorAuditorAcomp() );
       
        if (siiGrupoAccionControl.getSiiSustanciadorAuditorPpal() != null  )
            this.sustanciadorAuditorPpalVo = new SustanciadorAuditorVO(siiGrupoAccionControl.getSiiSustanciadorAuditorPpal() );
        
    }


    public void setGacCodigo(Long gacCodigo){
        this.gacCodigo = gacCodigo;
    }

    public Long getGacCodigo(){
        return gacCodigo;
    }

    public void setGacFecha(Date gacFecha){
        this.gacFecha = gacFecha;
    }

    public Date getGacFecha(){
        return gacFecha;
    }

    public void setGacNumero(Integer gacNumero){
        this.gacNumero = gacNumero;
    }

    public Integer getGacNumero(){
        return gacNumero;
    }

    public void setSustanciadorAuditorPpalVo(SustanciadorAuditorVO sustanciadorAuditorPpalVo){
        this.sustanciadorAuditorPpalVo = sustanciadorAuditorPpalVo;
    }

    public SustanciadorAuditorVO getSustanciadorAuditorPpalVo(){
        return sustanciadorAuditorPpalVo;
    }

    public void setSustanciadorAuditorAcompVo(SustanciadorAuditorVO sustanciadorAuditorAcompVo){
        this.sustanciadorAuditorAcompVo = sustanciadorAuditorAcompVo;
    }

    public SustanciadorAuditorVO getSustanciadorAuditorAcompVo(){
        return sustanciadorAuditorAcompVo;
    }

    public void setAutoComisorioAccConListVo(List<AutoComisorioAccConVO> autoComisorioAccConListVo){
        this.autoComisorioAccConListVo = autoComisorioAccConListVo;
    }

    public List<AutoComisorioAccConVO> getAutoComisorioAccConListVo(){
        return autoComisorioAccConListVo;
    }

}
