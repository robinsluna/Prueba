package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmasRequeridas;

import java.util.List;

public class FirmasRequeridasVO {
    private Long freCodigo;
    private String freEtiqueta;
    private FuncionVO funcionVo;
    private TipoDocumentoColjuegosVO tipoDocumentoColjuegosVo;
    private List<FirmaDocumentoVO> firmaDocumentoVoList;
    private String freActivo;
    
    public FirmasRequeridasVO(){
    }
    
    public FirmasRequeridasVO(SiiFirmasRequeridas firmasRequeridas){
        this.freCodigo = firmasRequeridas.getFreCodigo();
        this.freEtiqueta = firmasRequeridas.getFreEtiqueta();
        this.freActivo = firmasRequeridas.getFreActivo();
        //Padres:
        if (firmasRequeridas.getSiiFuncion()!=null)
            this.funcionVo = new FuncionVO(firmasRequeridas.getSiiFuncion());
        
        if (firmasRequeridas.getSiiTipoDocumentoColjuegos1()!=null)
            this.tipoDocumentoColjuegosVo = new TipoDocumentoColjuegosVO(firmasRequeridas.getSiiTipoDocumentoColjuegos1());
    }

    public void setFreCodigo(Long freCodigo) {
        this.freCodigo = freCodigo;
    }

    public Long getFreCodigo() {
        return freCodigo;
    }

    public void setFreActivo(String freActivo) {
        this.freActivo = freActivo;
    }

    public String getFreActivo() {
        return freActivo;
    }

    public void setFreEtiqueta(String freEtiqueta) {
        this.freEtiqueta = freEtiqueta;
    }

    public String getFreEtiqueta() {
        return freEtiqueta;
    }

    public void setFuncionVO(FuncionVO funcionVO) {
        this.funcionVo = funcionVO;
    }

    public FuncionVO getFuncionVO() {
        return funcionVo;
    }

    public void setFirmaDocumentoVoList(List<FirmaDocumentoVO> firmaDocumentoVoList) {
        this.firmaDocumentoVoList = firmaDocumentoVoList;
    }

    public List<FirmaDocumentoVO> getFirmaDocumentoVoList() {
        return firmaDocumentoVoList;
    }

    public void setTipoDocumentoColjuegosVo(TipoDocumentoColjuegosVO tipoDocumentoColjuegosVo) {
        this.tipoDocumentoColjuegosVo = tipoDocumentoColjuegosVo;
    }

    public TipoDocumentoColjuegosVO getTipoDocumentoColjuegosVo() {
        return tipoDocumentoColjuegosVo;
    }
    
    
    /**
     * Obtiene el nombre de la Funci&oacute;n asociada a la Firma.
     * @return firma.funcion.nombre
     */
    public String getNombreFuncion () {
        return (funcionVo!=null?funcionVo.getFunNombre():null);
    }
    
}
