package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteDocum;

import java.util.Date;
import java.util.List;

public class ExpedienteDocumVO {
    private String edoCodigo;
    private Date edoFecha;    
    private List<SolicitudAutorizaVO> siiSolicitudAutorizaList;
   
    public ExpedienteDocumVO(SiiExpedienteDocum siiExpedienteDocum) {
        if( siiExpedienteDocum!= null){
            if(siiExpedienteDocum.getEdoCodigo()!= null ){
                this.edoCodigo = siiExpedienteDocum.getEdoCodigo();
            }
            this.edoFecha = siiExpedienteDocum.getEdoFecha();
        }
    }
    
    public ExpedienteDocumVO() {
    
    }

    public void setEdoCodigo(String edoCodigo) {
        this.edoCodigo = edoCodigo;
    }

    public String getEdoCodigo() {
        return edoCodigo;
    }

    public void setEdoFecha(Date edoFecha) {
        this.edoFecha = edoFecha;
    }

    public Date getEdoFecha() {
        return edoFecha;
    }

    public void setSiiSolicitudAutorizaList(List<SolicitudAutorizaVO> siiSolicitudAutorizaList) {
        this.siiSolicitudAutorizaList = siiSolicitudAutorizaList;
    }

    public List<SolicitudAutorizaVO> getSiiSolicitudAutorizaList() {
        return siiSolicitudAutorizaList;
    }
}
