package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifEstadoDocContab;

import java.util.Date;
import java.util.List;


public class ModifEstadoDocContabVO {
    
    private Long mecCodigo;
    private Date mecFecha;
    private UsuarioVO UsuarioConecVo;
    private List<DocumentoContableVO> DocumentoContableListVo;
    
    public ModifEstadoDocContabVO(SiiModifEstadoDocContab siiModifEstadoDocContab) {  
        this.mecCodigo = siiModifEstadoDocContab.getMecCodigo();
        this.mecFecha = siiModifEstadoDocContab.getMecFecha();
        
        if(siiModifEstadoDocContab.getSiiUsuarioConec()!= null){
            this.UsuarioConecVo = new UsuarioVO(siiModifEstadoDocContab.getSiiUsuarioConec());
        }
    }
    public ModifEstadoDocContabVO() {        
    }


    public void setMecCodigo(Long mecCodigo) {
        this.mecCodigo = mecCodigo;
    }

    public Long getMecCodigo() {
        return mecCodigo;
    }

    public void setMecFecha(Date mecFecha) {
        this.mecFecha = mecFecha;
    }

    public Date getMecFecha() {
        return mecFecha;
    }

    public void setUsuarioConecVo(UsuarioVO UsuarioConecVo) {
        this.UsuarioConecVo = UsuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return UsuarioConecVo;
    }

    public void setDocumentoContableListVo(List<DocumentoContableVO> DocumentoContableListVo) {
        this.DocumentoContableListVo = DocumentoContableListVo;
    }

    public List<DocumentoContableVO> getDocumentoContableListVo() {
        return DocumentoContableListVo;
    }
}
