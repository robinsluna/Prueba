package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPruebaAutoDecrPru;

public class PruebaAutoDecrPruVO {
    private Long papCodigo;
    private UsuarioVO usuarioConecVo;
    private TipoPruebaIlegVO tipoPruebaIlegVo;
    private AutoDecretaPrueProIleVO autoDecretaPrueProIleVo;
    
    
    /**
     * Constructor.
     */
    public PruebaAutoDecrPruVO() { }
    
    
    /**
     * Constructor.
     * @param siiPruebaAutoDecrPru - Entity.
     */
    public PruebaAutoDecrPruVO(SiiPruebaAutoDecrPru siiPruebaAutoDecrPru) 
    {
        if (siiPruebaAutoDecrPru!=null) {
            this.papCodigo = siiPruebaAutoDecrPru.getPapCodigo();
            //Padres
            if (siiPruebaAutoDecrPru.getSiiAutoDecretaPrueProIle() != null) {
                this.autoDecretaPrueProIleVo = new AutoDecretaPrueProIleVO(siiPruebaAutoDecrPru.getSiiAutoDecretaPrueProIle());
            }
            if (siiPruebaAutoDecrPru.getSiiTipoPruebaIleg()!=null) {
                this.tipoPruebaIlegVo = new TipoPruebaIlegVO(siiPruebaAutoDecrPru.getSiiTipoPruebaIleg());
            }
            if (siiPruebaAutoDecrPru.getSiiUsuarioConec()!=null) {
                this.usuarioConecVo = new UsuarioVO(siiPruebaAutoDecrPru.getSiiUsuarioConec());
            }
        }
    }

    public void setPapCodigo(Long papCodigo) {
        this.papCodigo = papCodigo;
    }

    public Long getPapCodigo() {
        return papCodigo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setTipoPruebaIlegVo(TipoPruebaIlegVO tipoPruebaIlegVo) {
        this.tipoPruebaIlegVo = tipoPruebaIlegVo;
    }

    public TipoPruebaIlegVO getTipoPruebaIlegVo() {
        return tipoPruebaIlegVo;
    }

    public void setAutoDecretaPrueProIleVo(AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) {
        this.autoDecretaPrueProIleVo = autoDecretaPrueProIleVo;
    }

    public AutoDecretaPrueProIleVO getAutoDecretaPrueProIleVo() {
        return autoDecretaPrueProIleVo;
    }
}
