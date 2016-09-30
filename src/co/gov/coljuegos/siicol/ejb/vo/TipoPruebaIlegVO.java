package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPruebaIleg;

import java.util.List;


public class TipoPruebaIlegVO implements Comparable<TipoPruebaIlegVO>, Cloneable
{
    private Long tpiCodigo;
    private String tpiNombre;
    private List<PruebaAutoDecrPruVO> pruebaAutoDecrPruListVo;
    
    
    /**
     * Constructor.
     */
    public TipoPruebaIlegVO() { }
    
    
    /**
     * Constructor.
     * @param siiTipoPruebaIleg - Entity.
     */
    public TipoPruebaIlegVO(SiiTipoPruebaIleg siiTipoPruebaIleg) {
        if (siiTipoPruebaIleg!=null) {
            this.tpiCodigo = siiTipoPruebaIleg.getTpiCodigo();
            this.tpiNombre = siiTipoPruebaIleg.getTpiNombre();
        }
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(TipoPruebaIlegVO t) 
    {
        int resultado = -1;
        if (t!=null && this.tpiNombre!=null && t.tpiNombre!=null)
            resultado = this.tpiNombre.compareTo(t.tpiNombre);
        
        return ( resultado );
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) 
    {
        boolean igual = false;
        
        if (o instanceof TipoPruebaIlegVO) {
            TipoPruebaIlegVO tpiVo = (TipoPruebaIlegVO) o;
            
            if (tpiVo != null) {
                igual =
                    ((tpiVo.tpiCodigo != null && tpiVo.tpiCodigo.equals(this.tpiCodigo)) || (tpiVo.tpiCodigo == null && this.tpiCodigo == null)) &&
                    ((tpiVo.tpiNombre != null && tpiVo.tpiNombre.equals(this.tpiNombre)) || (tpiVo.tpiNombre == null && this.tpiNombre == null));
            }
        }
        
        return (igual);
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone () 
    {
        TipoPruebaIlegVO tipoPruebaIlegVo = new TipoPruebaIlegVO();
        tipoPruebaIlegVo.tpiCodigo = this.tpiCodigo;
        tipoPruebaIlegVo.tpiNombre = this.tpiNombre;
        
        return (tipoPruebaIlegVo);
    }
    
    

    public void setTpiCodigo(Long tpiCodigo) {
        this.tpiCodigo = tpiCodigo;
    }

    public Long getTpiCodigo() {
        return tpiCodigo;
    }

    public void setTpiNombre(String tpiNombre) {
        this.tpiNombre = tpiNombre;
    }

    public String getTpiNombre() {
        return tpiNombre;
    }

    public void setPruebaAutoDecrPruListVo(List<PruebaAutoDecrPruVO> pruebaAutoDecrPruListVo) {
        this.pruebaAutoDecrPruListVo = pruebaAutoDecrPruListVo;
    }

    public List<PruebaAutoDecrPruVO> getPruebaAutoDecrPruListVo() {
        return pruebaAutoDecrPruListVo;
    }
}
