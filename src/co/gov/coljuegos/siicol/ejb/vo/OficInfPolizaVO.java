package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficInfPoliza;

import java.util.Date;

public class OficInfPolizaVO {
    private Long oipCodigo;
    private Date oipFechaRadic;
    private String oipNumRadica;
    private String oipTipoDocum;
    private ArchivoFisicoVO archivoFisicoVo;
    private PolizaContratVO polizaContratVo;
    
    public OficInfPolizaVO() {
        
    }
    
    public OficInfPolizaVO(SiiOficInfPoliza oficio) {
        this.oipCodigo = oficio.getOipCodigo();
        this.oipFechaRadic = oficio.getOipFechaRadic();
        this.oipNumRadica = oficio.getOipNumRadica();
        this.oipTipoDocum = oficio.getOipTipoDocum();
        //Padres:
        if (oficio.getSiiArchivoFisico() != null) {
            this.archivoFisicoVo = new ArchivoFisicoVO(oficio.getSiiArchivoFisico());           
        }
        if (oficio.getSiiPolizaContrat() != null ) {
            this.polizaContratVo = new PolizaContratVO(oficio.getSiiPolizaContrat());
        }
    }

    public void setOipCodigo(Long oipCodigo) {
        this.oipCodigo = oipCodigo;
    }

    public Long getOipCodigo() {
        return oipCodigo;
    }

    public void setOipFechaRadic(Date oipFechaRadic) {
        this.oipFechaRadic = oipFechaRadic;
    }

    public Date getOipFechaRadic() {
        return oipFechaRadic;
    }

    public void setOipNumRadica(String oipNumRadica) {
        this.oipNumRadica = oipNumRadica;
    }

    public String getOipNumRadica() {
        return oipNumRadica;
    }

    public void setOipTipoDocum(String oipTipoDocum) {
        this.oipTipoDocum = oipTipoDocum;
    }

    public String getOipTipoDocum() {
        return oipTipoDocum;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setPolizaContratVo(PolizaContratVO polizaContratVo) {
        this.polizaContratVo = polizaContratVo;
    }

    public PolizaContratVO getPolizaContratVo() {
        return polizaContratVo;
    }
}
