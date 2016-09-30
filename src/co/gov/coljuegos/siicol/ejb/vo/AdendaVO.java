package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;

import java.util.Date;
import java.util.List;

public class AdendaVO {
    //private static final long serialVersionUID =
    private Long atdCodigo;
    private Date atdFechaAprob;
    private Date atdFechaEnvPub;
    private Date atdFechaPub;
    private String atdRadicado;
    private TerminoReferenciaVO terminosReferencia;
    
    
    
   
    
    public AdendaVO() {
    }
    
    public AdendaVO(SiiAdendaTdr adenda) {
        this.atdCodigo          = adenda.getAtdCodigo();
        this.atdFechaAprob      = adenda.getAtdFechaAprob();
        this.atdFechaEnvPub     = adenda.getAtdFechaEnvPub();
        this.atdFechaPub        = adenda.getAtdFechaPub();
        this.atdRadicado        = adenda.getAtdRadicado();
                      
    }

    public void setAtdCodigo(Long atdCodigo) {
        this.atdCodigo = atdCodigo;
    }

    public Long getAtdCodigo() {
        return atdCodigo;
    }

    public void setAtdFechaAprob(Date atdFechaAprob) {
        this.atdFechaAprob = atdFechaAprob;
    }

    public Date getAtdFechaAprob() {
        return atdFechaAprob;
    }

    public void setAtdFechaEnvPub(Date atdFechaEnvPub) {
        this.atdFechaEnvPub = atdFechaEnvPub;
    }

    public Date getAtdFechaEnvPub() {
        return atdFechaEnvPub;
    }

    public void setAtdFechaPub(Date atdFechaPub) {
        this.atdFechaPub = atdFechaPub;
    }

    public Date getAtdFechaPub() {
        return atdFechaPub;
    }

    public void setAtdRadicado(String atdRadicado) {
        this.atdRadicado = atdRadicado;
    }

    public String getAtdRadicado() {
        return atdRadicado;
    }

    public void setTerminosReferencia(TerminoReferenciaVO terminosReferencia) {
        this.terminosReferencia = terminosReferencia;
    }

    public TerminoReferenciaVO getTerminosReferencia() {
        return terminosReferencia;
    }


}
