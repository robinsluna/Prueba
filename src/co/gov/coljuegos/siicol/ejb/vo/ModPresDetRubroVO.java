package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModPresDetRubro;


public class ModPresDetRubroVO {
    
    private Long mpdCodigo;
    private Long mpdValor;
    private DetalleRubroVO detalleRubroOriVo;
    private DetalleRubroVO detalleRubroDestVo;
    private ModificPresupVO modificPresupVo;

    public ModPresDetRubroVO() {
    }
    
    
    /**
     * Constructor.
     * @param siiModPresDetRubro
     */
    public ModPresDetRubroVO (SiiModPresDetRubro siiModPresDetRubro) {
        if (siiModPresDetRubro!=null) {
            this.mpdCodigo = siiModPresDetRubro.getMpdCodigo();
            this.mpdValor = siiModPresDetRubro.getMpdValor();
            
            if (siiModPresDetRubro.getSiiDetalleRubroOri() != null) {
                this.detalleRubroOriVo = new DetalleRubroVO(siiModPresDetRubro.getSiiDetalleRubroOri());
            }
            
            if (siiModPresDetRubro.getSiiDetalleRubroDest() != null) {
                this.detalleRubroDestVo = new DetalleRubroVO(siiModPresDetRubro.getSiiDetalleRubroDest());
            }
            
            if (siiModPresDetRubro.getSiiModificPresup() != null) {
                this.modificPresupVo = new ModificPresupVO(siiModPresDetRubro.getSiiModificPresup());
            }
        }
    }


    public void setMpdCodigo(Long mpdCodigo) {
        this.mpdCodigo = mpdCodigo;
    }

    public Long getMpdCodigo() {
        return mpdCodigo;
    }

    public void setMpdValor(Long mpdValor) {
        this.mpdValor = mpdValor;
    }

    public Long getMpdValor() {
        return mpdValor;
    }

    public void setDetalleRubroOriVo(DetalleRubroVO DetalleRubroOriVo) {
        this.detalleRubroOriVo = DetalleRubroOriVo;
    }

    public DetalleRubroVO getDetalleRubroOriVo() {
        return detalleRubroOriVo;
    }

    public void setDetalleRubroDestVo(DetalleRubroVO DetalleRubroDestVo) {
        this.detalleRubroDestVo = DetalleRubroDestVo;
    }

    public DetalleRubroVO getDetalleRubroDestVo() {
        return detalleRubroDestVo;
    }

    public void setModificPresupVo(ModificPresupVO ModificPresupVo) {
        this.modificPresupVo = ModificPresupVo;
    }

    public ModificPresupVO getModificPresupVo() {
        return modificPresupVo;
    }
}
