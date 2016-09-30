package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;

import java.util.Date;
import java.util.List;

public class DocumentoTdrVO {
    //private static final long serialVersionUID =
    private Long dtdCodigo;
    private String dtdTipoDocTdr;
    private TerminoReferenciaVO terminosReferenciavo;
    private ArchivoFisicoVO archivoFisicoVo;  
    
    
   
    
    public DocumentoTdrVO() {
    }
    
    public DocumentoTdrVO(SiiDocumentoTdr documento) {
        this.dtdCodigo = documento.getDtdCodigo();
        this.dtdTipoDocTdr = documento.getDtdTipoDocTdr();
        if(documento.getSiiTerminosReferencia() != null){
            this.terminosReferenciavo = new TerminoReferenciaVO (documento.getSiiTerminosReferencia());
        }
        if(documento.getSiiArchivoFisico()!= null){
            this.archivoFisicoVo = new ArchivoFisicoVO(documento.getSiiArchivoFisico());
        }
    }

    public void setDtdCodigo(Long dtdCodigo) {
        this.dtdCodigo = dtdCodigo;
    }

    public Long getDtdCodigo() {
        return dtdCodigo;
    }

    public void setDtdTipoDocTdr(String dtdTipoDocTdr) {
        this.dtdTipoDocTdr = dtdTipoDocTdr;
    }

    public String getDtdTipoDocTdr() {
        return dtdTipoDocTdr;
    }

    public void setTerminosReferenciavo(TerminoReferenciaVO terminosReferenciavo) {
        this.terminosReferenciavo = terminosReferenciavo;
    }

    public TerminoReferenciaVO getTerminosReferenciavo() {
        return terminosReferenciavo;
    }

    public void setArchivoFisicovo(ArchivoFisicoVO archivoFisicovo) {
        this.archivoFisicoVo = archivoFisicovo;
    }

    public ArchivoFisicoVO getArchivoFisicovo() {
        return archivoFisicoVo;
    }

}
