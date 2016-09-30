package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTermAnticip;

import java.util.List;

public class EstadoTermAnticipVO {
    private Long etaCodigo;
    private String etaNombre;
    private List<TerminacionAnticipContVO> terminacionAnticipVoList;
    
    public EstadoTermAnticipVO() {                
    }
    
    public EstadoTermAnticipVO(SiiEstadoTermAnticip siiEstadoTermAnticip) {      
        this.etaCodigo = siiEstadoTermAnticip.getEtaCodigo();
        this.etaNombre = siiEstadoTermAnticip.getEtaNombre();
    }


    public void setEtaCodigo(Long etaCodigo) {
        this.etaCodigo = etaCodigo;
    }

    public Long getEtaCodigo() {
        return etaCodigo;
    }

    public void setEtaNombre(String etaNombre) {
        this.etaNombre = etaNombre;
    }

    public String getEtaNombre() {
        return etaNombre;
    }

    public void setTerminacionAnticipVoList(List<TerminacionAnticipContVO> terminacionAnticipVoList) {
        this.terminacionAnticipVoList = terminacionAnticipVoList;
    }

    public List<TerminacionAnticipContVO> getTerminacionAnticipVoList() {
        return terminacionAnticipVoList;
    }
}
