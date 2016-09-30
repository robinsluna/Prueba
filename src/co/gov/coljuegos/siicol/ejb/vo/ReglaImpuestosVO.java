package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReglaImpuestos;


/**
 * Value Object para Regla de Impuestos.
 */
public class ReglaImpuestosVO 
{
    private Long rimCodigo;
    private String rimTipoContrib;
    private String rimTipoProveed;
    private String rimGrupoRespon;
    
    private TipoRetencionVO TipoRetencionVo;
    private GrupoRetencVO grupoRetencVo;
    private int NumGrupoRespon;    
    
    /**
     * Constructor.
     */
    public ReglaImpuestosVO() {        
    }

    
    /**
     * Constructor.
     * @param siiReglaImpuestos - Entity.
     */
    public ReglaImpuestosVO(SiiReglaImpuestos siiReglaImpuestos)
    {
        this.rimCodigo = siiReglaImpuestos.getRimCodigo();
        this.rimTipoContrib = siiReglaImpuestos.getRimTipoContrib();
        this.rimTipoProveed = siiReglaImpuestos.getRimTipoProveed();
        this.rimGrupoRespon = siiReglaImpuestos.getRimGrupoRespon();
        
        //Padres
        if (siiReglaImpuestos.getSiiTipoRetencion() != null){
            this.TipoRetencionVo = new TipoRetencionVO(siiReglaImpuestos.getSiiTipoRetencion());
        }
        if (siiReglaImpuestos.getSiiGrupoRetenc() != null){
            this.grupoRetencVo = new GrupoRetencVO (siiReglaImpuestos.getSiiGrupoRetenc());
        }
        
    }
    
    
    public void setRimCodigo(Long rimCodigo) {
        this.rimCodigo = rimCodigo;
    }

    public Long getRimCodigo() {
        return rimCodigo;
    }

    public void setRimTipoContrib(String rimTipoContrib) {
        this.rimTipoContrib = rimTipoContrib;
    }

    public String getRimTipoContrib() {
        return rimTipoContrib;
    }

    public void setRimTipoProveed(String rimTipoProveed) {
        this.rimTipoProveed = rimTipoProveed;
    }

    public String getRimTipoProveed() {
        return rimTipoProveed;
    }

    public void setRimGrupoRespon(String rimGrupoRespon) {
        this.rimGrupoRespon = rimGrupoRespon;
    }

    public String getRimGrupoRespon() {
        return rimGrupoRespon;
    }

    public void setTipoRetencionVo(TipoRetencionVO TipoRetencionVo) {
        this.TipoRetencionVo = TipoRetencionVo;
    }

    public TipoRetencionVO getTipoRetencionVo() {
        return TipoRetencionVo;
    }

    public void setGrupoRetencVo(GrupoRetencVO grupoRetencVo) {
        this.grupoRetencVo = grupoRetencVo;
    }

    public GrupoRetencVO getGrupoRetencVo() {
        return grupoRetencVo;
    }

    public int getNumGrupoRespon() {
        return NumGrupoRespon;
    }

    public void setNumGrupoRespon(int NumGrupoRespon) {
        this.NumGrupoRespon = NumGrupoRespon;
    }
}
