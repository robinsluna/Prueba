package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPruebaDescargoProIle;


/**
 * Value Object para el manejo de la relaci&oacute;n entre los tipos de Pruebas de Descargo y el Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
public class PruebaDescargoProIleVO 
{
    private Long pdpCodigo;
    
    private TipoPruebaIlegVO tipoPruebaIlegVo;
    private DescargoProcIlegVO descargoProcIlegVo;
    private UsuarioVO usuarioConecVo;
    
    
    /**
     * Constructor.
     */
    public PruebaDescargoProIleVO() { }
    
    
    
    /**
     * Constructor.
     * @param siiPruebaDescargoProIle - Entity.
     */
    public PruebaDescargoProIleVO (SiiPruebaDescargoProIle siiPruebaDescargoProIle) 
    {
        if (siiPruebaDescargoProIle!=null) {
            this.pdpCodigo = siiPruebaDescargoProIle.getPdpCodigo();
            
            if (siiPruebaDescargoProIle.getSiiDescargoProcIleg()!=null)
                this.descargoProcIlegVo = new DescargoProcIlegVO(siiPruebaDescargoProIle.getSiiDescargoProcIleg());
            
            if (siiPruebaDescargoProIle.getSiiTipoPruebaIleg()!=null)
                this.tipoPruebaIlegVo = new TipoPruebaIlegVO(siiPruebaDescargoProIle.getSiiTipoPruebaIleg());
            
            if (siiPruebaDescargoProIle.getSiiUsuarioConec()!=null)
                this.usuarioConecVo = new UsuarioVO(siiPruebaDescargoProIle.getSiiUsuarioConec());
        }
    }

    
    
    public void setPdpCodigo(Long pdpCodigo) {
        this.pdpCodigo = pdpCodigo;
    }

    public Long getPdpCodigo() {
        return pdpCodigo;
    }

    public void setTipoPruebaIlegVo(TipoPruebaIlegVO tipoPruebaIlegVo) {
        this.tipoPruebaIlegVo = tipoPruebaIlegVo;
    }

    public TipoPruebaIlegVO getTipoPruebaIlegVo() {
        return tipoPruebaIlegVo;
    }

    public void setDescargoProcIlegVo(DescargoProcIlegVO descargoProcIlegVo) {
        this.descargoProcIlegVo = descargoProcIlegVo;
    }

    public DescargoProcIlegVO getDescargoProcIlegVo() {
        return descargoProcIlegVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }
}
