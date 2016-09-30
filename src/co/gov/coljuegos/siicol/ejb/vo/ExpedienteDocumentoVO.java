package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteDocum;

import java.util.Date;

public class ExpedienteDocumentoVO {
    
    private String edoCodigo;
    private Date edoFecha;
    //private 
    
    
    public ExpedienteDocumentoVO(SiiExpedienteDocum siiExpedienteDocum) {
       this.edoCodigo=siiExpedienteDocum.getEdoCodigo();
       this.edoFecha= siiExpedienteDocum.getEdoFecha();
    }
    public ExpedienteDocumentoVO() {
    
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

}
